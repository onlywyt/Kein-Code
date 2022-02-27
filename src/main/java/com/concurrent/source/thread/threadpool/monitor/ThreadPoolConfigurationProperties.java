package com.concurrent.source.thread.threadpool.monitor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ThreadPoolConfigurationProperties
 * @author: Mr.Wang
 * @create: 2022-01-24 22:38
 **/

@Data
@ConfigurationProperties(prefix = "monitor.threads")
public class ThreadPoolConfigurationProperties {
    private List<ThreadPoolProperties> executors = new ArrayList<>();
}
