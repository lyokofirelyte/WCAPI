package com.github.lyokofirelyte.WCAPI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface WCCommand {
	public String[] aliases();
	public String name() default "";
	public String desc() default "A WC Command";
	public String help() default "/wc ?";
	public String perm() default "wa.member";
	int max() default -1;
	int min() default 0;
}