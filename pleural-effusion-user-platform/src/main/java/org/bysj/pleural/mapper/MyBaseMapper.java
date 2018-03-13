package org.bysj.pleural.mapper;

import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <pre>类名: MyBaseMapper</pre>
 * <pre>描述: 基础Mapper</pre>
 * <pre>日期: 2018/3/13  17:22</pre>
 * <pre>作者: ljianf</pre>
 */
@NoRepositoryBean
public interface MyBaseMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
