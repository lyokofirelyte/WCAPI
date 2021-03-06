package com.github.lyokofirelyte.WCAPI.Command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface WCCommand {
	public String[] aliases();
	public String name() default "none";
	public String desc() default "A WC Command";
	public String help() default "/wc ?";
	public String perm() default "wa.member";
	public boolean player() default false;
	public int max() default 9999;
	public int min() default 0;
}