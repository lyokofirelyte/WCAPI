package com.github.lyokofirelyte.WCAPI.Command;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface WCArg {
	
	public String[] refs();
	public String perm() default "wa.member";
	public boolean player() default false;
	
}
