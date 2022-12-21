package com.shahidfoy.springbootquartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class SchedulerJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        capableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle triggerFiredBundle) throws Exception {
        final Object job = super.createJobInstance(triggerFiredBundle);
        capableBeanFactory.autowireBean(job);
        return job;
    }
}
