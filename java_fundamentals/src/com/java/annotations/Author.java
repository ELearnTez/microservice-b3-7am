package com.java.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 
 * dfsdfdsfdsfds sfsdfds 
 * 
 * 
 */

//@Repeatable(value = Author.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE, ElementType.FIELD , ElementType.CONSTRUCTOR})
public @interface Author {

	
	String name() ;
	
	String version() default "1.0.0";
	
}
