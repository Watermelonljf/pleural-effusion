package org.bysj.pleural.svm;

/**
 * className: Cache
 * describe: TODO
 * author: Watermelon_R
 * date:   2018/1/4
 */
public class Cache {
    private final int l;
    private long size;
    private final class head_t
    {
        head_t prev, next;	// a cicular list
        float[] data;
        int len;		// data[0,len) is cached in this entry
    }
    private final head_t[] head;
    private head_t lru_head;

    Cache(int l_, long size_)
    {
        l = l_;
        size = size_;
        head = new head_t[l];
        for(int i=0;i<l;i++) head[i] = new head_t();
        size /= 4;
        size -= l * (16/4);	// sizeof(head_t) == 16
        size = Math.max(size, 2* (long) l);  // cache must be large enough for two columns
        lru_head = new head_t();
        lru_head.next = lru_head.prev = lru_head;
    }

    private void lru_delete(head_t h)
    {
        // delete from current location
        h.prev.next = h.next;
        h.next.prev = h.prev;
    }

    private void lru_insert(head_t h)
    {
        // insert to last position
        h.next = lru_head;
        h.prev = lru_head.prev;
        h.prev.next = h;
        h.next.prev = h;
    }

    // request data [0,len)
    // return some position p where [p,len) need to be filled
    // (p >= len if nothing needs to be filled)
    // java: simulate pointer using single-element array
    int get_data(int index, float[][] data, int len)
    {
        head_t h = head[index];
        if(h.len > 0) lru_delete(h);
        int more = len - h.len;

        if(more > 0)
        {
            // free old space
            while(size < more)
            {
                head_t old = lru_head.next;
                lru_delete(old);
                size += old.len;
                old.data = null;
                old.len = 0;
            }

            // allocate new space
            float[] new_data = new float[len];
            if(h.data != null) System.arraycopy(h.data,0,new_data,0,h.len);
            h.data = new_data;
            size -= more;
            do {int tmp=h.len; h.len=len; len=tmp;} while(false);
        }

        lru_insert(h);
        data[0] = h.data;
        return len;
    }

    void swap_index(int i, int j)
    {
        if(i==j) return;

        if(head[i].len > 0) lru_delete(head[i]);
        if(head[j].len > 0) lru_delete(head[j]);
        do {float[] tmp=head[i].data; head[i].data=head[j].data; head[j].data=tmp;} while(false);
        do {int tmp=head[i].len; head[i].len=head[j].len; head[j].len=tmp;} while(false);
        if(head[i].len > 0) lru_insert(head[i]);
        if(head[j].len > 0) lru_insert(head[j]);

        if(i>j) do {int tmp=i; i=j; j=tmp;} while(false);
        for(head_t h = lru_head.next; h!=lru_head; h=h.next)
        {
            if(h.len > i)
            {
                if(h.len > j)
                    do {float tmp=h.data[i]; h.data[i]=h.data[j]; h.data[j]=tmp;} while(false);
                else
                {
                    // give up
                    lru_delete(h);
                    size += h.len;
                    h.data = null;
                    h.len = 0;
                }
            }
        }
    }
}
