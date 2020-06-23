package com.java.annotations;

import static java.util.Objects.nonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class AnnotationProcess {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		
		Class<AnnotationUseageDemo> annotationUseageDemoClass = AnnotationUseageDemo.class;
		
		Annotation[] annotations = annotationUseageDemoClass.getAnnotations();
		
		if(nonNull(annotations)) {
			
			for(Annotation annotation:annotations) {
				
				if(annotation instanceof Author) {
				
				Author author = (Author)annotation;
				
				System.out.println(" AnnotationUseageDemo written by :" + author.name());
				
				System.out.println(" AnnotationUseageDemo Version is :" + author.version());
				
				///
				 // DB Logging
				///
				
				
				}
				
				
				
			}
			
		}
		
		//Class End
		
		
		//Method Start
		Method method = annotationUseageDemoClass.getMethod("sayHello", new Class[] {});

		Author annotation = method.getAnnotation(Author.class);

		System.out.println("Author :" + annotation.name());
		System.out.println("Version :" + annotation.version());
		
		//Field
		Field textField = annotationUseageDemoClass.getDeclaredField("text");
		textField.setAccessible(true);
		Author ann = textField.getAnnotation(Author.class);

		System.out.println(ann.name());
		System.out.println(ann.version());
		
		Constructor<AnnotationUseageDemo> constructor = annotationUseageDemoClass.getConstructor( new Class[] {	});

		Author author = constructor.getAnnotation(Author.class);
		
		System.out.println(
				author.name() +" = "+ author.version()
				
				);
		
		
		
		
			System.out.println("Done");
		
	}

}
