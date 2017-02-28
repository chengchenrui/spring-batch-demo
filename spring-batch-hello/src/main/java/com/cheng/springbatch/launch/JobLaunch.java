/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.springbatch.launch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author chengchenrui
 * @version Id: JobLaunch.java, v 0.1 2017.2.27 14:28 chengchenrui Exp $$
 */
public class JobLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("E:\\code\\spring-batch-demo\\spring-batch-web\\src\\main\\resources\\spring-batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("helloWorldJob");

        try {
            //运行Job
            JobExecution result = launcher.run(job, new JobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}