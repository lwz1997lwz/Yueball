package org.yueball.service.impl;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{
    private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		// TODO Auto-generated method stub
		logger.log(Level.INFO,"method starts"+method);
	}

}
