package kr.co.ezenac.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before");
		System.out.println("beanName = " + beanName);
		
		switch(beanName) {
		case "t1" : 
			System.out.println("id : t1");
			break;
		case "t2" : 
			System.out.println("id : t2");
		}

		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after");
		System.out.println("beanName = " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	

}
