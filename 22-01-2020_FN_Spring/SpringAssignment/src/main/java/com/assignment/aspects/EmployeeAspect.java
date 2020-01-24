package com.assignment.aspects;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	LocalTime startTime;
	
	@Before("execution(* com.assignment.models.EmployeeService.getAllEmployees())")
	public void beforeGetAll(JoinPoint joinPoint) {
		this.startTime=LocalTime.now();
	}
	
	@After("execution(* com.assignment.models.EmployeeService.getAllEmployees())")
	public void afterGetAll(JoinPoint joinPoint) {
		long total_time=ChronoUnit.MILLIS.between(this.startTime, LocalTime.now());
		System.out.println("Total Time for execution of getAllEmployees is :"+total_time+" milliseconds");
	}
}
