package org.bysj.pleural.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * <pre>类名: TaskExecutorConfig</pre>
 * <pre>描述: 线程池配置</pre>
 * <pre>日期: 2018/3/28  13:57</pre>
 * <pre>作者: ljianf</pre>
 */
@Configuration
public class TaskExecutorConfig implements AsyncConfigurer {

    //配置类实现AsyncConfigurer接口并重写AsyncConfigurer方法，并返回一个ThreadPoolTaskExecutor
    //这样我们就得到了一个基于线程池的TaskExecutor
    @Override
    public Executor getAsyncExecutor() {
        // TODO Auto-generated method stub
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
        taskExecutor.setCorePoolSize(5);
        //连接池中保留的最大连接数。Default: 15 maxPoolSize
        taskExecutor.setMaxPoolSize(10);
        //queueCapacity 线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
