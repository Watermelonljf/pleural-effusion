package org.bysj.pleural.utils;

import java.util.List;

/**
 * className: CollectionsUtil
 * describe: TODO
 * author: Watermelon_R
 * date:   2017/12/24
 */
public class CollectionsUtil {


    public static boolean isEmpty(List<? extends Object> source){
        return source==null || source.size()==0 ? true : false;
    }

    public static boolean isNotEmpty(List<? extends Object> source){
        return !(isEmpty(source));
    }

}
