package com.quartz.system.web.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zj
 * @date 2018/11/30
 */
public abstract class JobBase {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void run(){
        System.out.println(dateFormat.format(new Date()) + " -- " + this.getClass().getSimpleName()  + " >> 定时任务正在执行");
    }
}
