package com.example.spring02.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 	// 스프링에서 관리하는 bean
@Aspect		// 공통적인 업무를 지원하는 bean
public class LogAdvice {

		private static final Logger LOGGERS = LoggerFactory.getLogger(LogAdvice.class);      
		
		@Around(
		"execution(* com.example.spring02.controller..*Controller.*(..))"
			+ "or execution(* com.example.spring02.service..*Impl.*(..))"
			+ "or execution(* com.example.spring02.model..dao.*Impl.*(..))")
		public Object logPrint(ProceedingJoinPoint joinPoint) 
													throws Throwable {
			
			long start = System.currentTimeMillis();
			
			Object result = joinPoint.proceed(); // 핵심업무 
			//호출한 클래스 이름 == reflection과 비슷한 개념인듯
			String type = joinPoint.getSignature().getDeclaringTypeName();
			String name = "";
			if (type.indexOf("Controller") > -1) {
				name = "Controller \t:";
			} else if(type.indexOf("Service") > -1) {
				name = "ServiceImpl \t:";
			} else if(type.indexOf("DAO") > -1) {
				name = "DAOImpl \t:";
			}
			//호춣한 클래스, method 정보 == reflection과 비슷한 개념인듯
			LOGGERS.info(name + type + " . " + joinPoint.getSignature().getName() + "()");
			LOGGERS.info(Arrays.toString(joinPoint.getArgs()));
			long end = System.currentTimeMillis();
			long time = end - start;
			LOGGERS.info("실행시간 : " + time);
			return result;
		}
}
