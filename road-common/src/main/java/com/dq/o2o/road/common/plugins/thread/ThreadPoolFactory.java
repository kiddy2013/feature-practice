package com.dq.o2o.road.common.plugins.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;

/**
 * 线程池工厂
 *
 * @author jack
 */
public class ThreadPoolFactory implements DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolFactory.class);
    private static final Map<String, ThreadPoolTaskExecutor> threadPoolMap = new ConcurrentHashMap();
    private static final Map<String, ThreadPoolTaskScheduler> threadPoolSchedulerMap = new ConcurrentHashMap();
    private static final ThreadPoolFactory threadPoolFactory = new ThreadPoolFactory();

    private ThreadPoolFactory() {
    }

    public static ThreadPoolFactory getInstance() {
        return threadPoolFactory;
    }

    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(String groupName) {
        Map<String, ThreadPoolTaskExecutor> threadPoolMap = threadPoolFactory.getThreadPoolMap();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = threadPoolMap.get(groupName);
        if (threadPoolTaskExecutor != null) {
            return threadPoolTaskExecutor;
        } else {
            synchronized (ThreadPoolFactory.class) {
                if (threadPoolTaskExecutor == null) {
                    int availableProcessors = Runtime.getRuntime().availableProcessors();
                    threadPoolTaskExecutor = this.buildThreadPoolTaskExecutor(groupName, availableProcessors * 2,
                        availableProcessors * 4, false, 30, 999999, false, 0, new CallerRunsPolicy());
                    threadPoolMap.put(groupName, threadPoolTaskExecutor);
                }
                return threadPoolTaskExecutor;
            }
        }
    }

    public ThreadPoolTaskScheduler getThreadPoolTaskScheduler(String groupName) {
        Map<String, ThreadPoolTaskScheduler> threadPoolSchedulerMap = threadPoolFactory.getThreadPoolSchedulerMap();
        ThreadPoolTaskScheduler threadPoolTaskScheduler = threadPoolSchedulerMap.get(groupName);
        if (threadPoolTaskScheduler != null) {
            return threadPoolTaskScheduler;
        } else {
            synchronized (ThreadPoolFactory.class) {
                if (threadPoolTaskScheduler == null) {
                    int availableProcessors = Runtime.getRuntime().availableProcessors();
                    threadPoolTaskScheduler = this.buildThreadPoolTaskScheduler(groupName, availableProcessors * 2, 5,
                        false, 0, null, new CallerRunsPolicy());
                    threadPoolSchedulerMap.put(groupName, threadPoolTaskScheduler);
                }

                return threadPoolTaskScheduler;
            }
        }
    }

    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(String groupName, int corePoolSize, int maxPoolSize,
                                                            boolean allowCoreThreadTimeOut, int keepAliveSeconds,
                                                            int queueCapacity, boolean waitForJobsToCompleteOnShutdown,
                                                            int awaitTerminationSeconds,
                                                            RejectedExecutionHandler rejectedExecutionHandler) {
        Map<String, ThreadPoolTaskExecutor> threadPoolMap = threadPoolFactory.getThreadPoolMap();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = threadPoolMap.get(groupName);
        if (threadPoolTaskExecutor != null) {
            return threadPoolTaskExecutor;
        } else {
            synchronized (ThreadPoolFactory.class) {
                if (threadPoolTaskExecutor == null) {
                    threadPoolTaskExecutor = this.buildThreadPoolTaskExecutor(groupName, corePoolSize, maxPoolSize,
                        allowCoreThreadTimeOut, keepAliveSeconds, queueCapacity, waitForJobsToCompleteOnShutdown,
                        awaitTerminationSeconds, rejectedExecutionHandler);
                    threadPoolMap.put(groupName, threadPoolTaskExecutor);
                }

                return threadPoolTaskExecutor;
            }
        }
    }

    private ThreadPoolTaskExecutor buildThreadPoolTaskExecutor(String groupName, int corePoolSize, int maxPoolSize,
                                                               boolean allowCoreThreadTimeOut, int keepAliveSeconds,
                                                               int queueCapacity,
                                                               boolean waitForJobsToCompleteOnShutdown,
                                                               int awaitTerminationSeconds,
                                                               RejectedExecutionHandler rejectedExecutionHandler) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        if (rejectedExecutionHandler == null) {
            rejectedExecutionHandler = new CallerRunsPolicy();
        }

        threadPoolTaskExecutor.setRejectedExecutionHandler(rejectedExecutionHandler);
        threadPoolTaskExecutor.setThreadGroupName(groupName);
        threadPoolTaskExecutor.setBeanName(groupName);
        threadPoolTaskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
        threadPoolTaskExecutor.afterPropertiesSet();
        return threadPoolTaskExecutor;
    }

    private ThreadPoolTaskScheduler buildThreadPoolTaskScheduler(String groupName, int poolSize, int threadPriority,
                                                                 boolean waitForJobsToCompleteOnShutdown,
                                                                 int awaitTerminationSeconds, ErrorHandler errorHandler,
                                                                 RejectedExecutionHandler rejectedExecutionHandler) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(awaitTerminationSeconds);
        threadPoolTaskScheduler.setBeanName(groupName);
        if (rejectedExecutionHandler == null) {
            rejectedExecutionHandler = new CallerRunsPolicy();
        }

        threadPoolTaskScheduler.setRejectedExecutionHandler(rejectedExecutionHandler);
        if (errorHandler == null) {
            errorHandler = new ErrorHandler() {
                @Override
                public void handleError(Throwable t) {
                    if (ThreadPoolFactory.LOGGER.isErrorEnabled()) {
                        ThreadPoolFactory.LOGGER.error("Unexpected error occurred in scheduled task.", t);
                    }

                }
            };
        }

        threadPoolTaskScheduler.setErrorHandler(errorHandler);
        threadPoolTaskScheduler.setPoolSize(poolSize);
        threadPoolTaskScheduler.setThreadGroupName(groupName);
        threadPoolTaskScheduler.setThreadPriority(threadPriority);
        threadPoolTaskScheduler.afterPropertiesSet();
        return threadPoolTaskScheduler;
    }

    public Map<String, ThreadPoolTaskExecutor> getThreadPoolMap() {
        return threadPoolMap;
    }

    public Map<String, ThreadPoolTaskScheduler> getThreadPoolSchedulerMap() {
        return threadPoolSchedulerMap;
    }

    @Override
    public void destroy() throws Exception {
        Map<String, ThreadPoolTaskExecutor> threadPoolMap = threadPoolFactory.getThreadPoolMap();
        Map<String, ThreadPoolTaskScheduler> threadPoolSchedulerMap = threadPoolFactory.getThreadPoolSchedulerMap();
        Iterator iterator;
        Entry entry;
        if (threadPoolMap != null && !threadPoolMap.isEmpty()) {
            iterator = threadPoolMap.entrySet().iterator();

            while (iterator.hasNext()) {
                entry = (Entry)iterator.next();
                ((ThreadPoolTaskExecutor)entry.getValue()).destroy();
            }
        }

        if (threadPoolSchedulerMap != null && !threadPoolSchedulerMap.isEmpty()) {
            iterator = threadPoolSchedulerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = (Entry)iterator.next();
                ((ThreadPoolTaskScheduler)entry.getValue()).destroy();
            }
        }

    }
}
