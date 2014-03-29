package com.github.lyokofirelyte.WCAPI.Loops;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface WCLoop {

	long time() default 0;
	long delay() default 0L;
	int repeats() default 0;
}
