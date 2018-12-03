package com.quartz.system.web.job;

/**
 * @author zj
 * @date 2018/11/30
 */
public abstract class JobBase {

    public void run(){
        System.out.println("定时任务" + this + "正在执行");
    }
}
