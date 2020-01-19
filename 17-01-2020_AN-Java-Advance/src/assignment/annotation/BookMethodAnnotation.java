package assignment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface BookMethodAnnotation {
	String owner() default "Not Owned";
	double version() default 1.0;
	String publisher() default "Not Specified";
}


class Book{
	String name;
	String author;
	
	@BookMethodAnnotation(owner="Yash",version=2.0,publisher="Penguin")
	public String getBooks(){
		return this.name+"::"+this.author;
	}
}

class BookDefault{
	String name;
	String author;
	
	@BookMethodAnnotation()
	public String getBooks(){
		return this.name+"::"+this.author;
	}
}
