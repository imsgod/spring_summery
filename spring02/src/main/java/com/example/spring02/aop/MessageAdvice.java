package com.example.spring02.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessageAdvice {
	private static final Logger LOGGERS = LoggerFactory.getLogger(MessageAdvice.class);
	
	@Before(
			"execution(* com.example.spring02.service.message"
				+ ".MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		LOGGERS.info("@Before proceeding~~");
		LOGGERS.info("핵심 업무 코드의 정보 : " + jp.getSignature());
		LOGGERS.info("method : " + jp.getSignature().getName());
		LOGGERS.info("매개변수 : " + Arrays.toString(jp.getArgs()));
	}
	
	@Around(
			"execution(* com.example.spring02.service.message"
				+ ".MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		//호출전
		long start = System.currentTimeMillis();
		LOGGERS.info("@Around-Before proceeding~~");
		// 비즈니스 로직 실행
		Object result = pjp.proceed();
		//호출 후
		long end = System.currentTimeMillis();
		LOGGERS.info("@Around-After proceeding~~");
		LOGGERS.info(pjp.getSignature().getName() + " : " + (end - start));
		LOGGERS.info("==================================");
		return result;
	}
}
