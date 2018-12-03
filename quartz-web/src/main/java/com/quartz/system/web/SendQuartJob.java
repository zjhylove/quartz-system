/**  
 * SendQuartJob.java 
 * 版本 core-0.4.0_Beta
 * Copyright 2013 北京壹平台科技有限公司 
 */
package com.quartz.system.web;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

/**
 * 类 名: SendQuartJob<br/>
 * 描 述: 定时任务<br/>
 * 作 者: ShiLina<br/>
 * 创 建：2013-08-09<br/>
 * 版 本：<br/>
 * 
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class SendQuartJob extends QuartzJobBean {

	private String targetObject;
	private String targetMethod;

	/*
	 * 推送资金明细信息 (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org
	 * .quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext jc) throws JobExecutionException {
		try {
			ApplicationContext ctx = (ApplicationContext) jc.getScheduler().getContext().get("springContext");
			Object targetObj = ctx.getBean(targetObject);
			Method targetMtd = targetObj.getClass().getMethod(targetMethod, new Class[] {});
			targetMtd.invoke(targetObj, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

}
