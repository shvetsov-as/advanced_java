package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target({ElementType.METHOD, ElementType.TYPE}) for more than one rule
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Retention(RetentionPolicy.RUNTIME) - yderjanie.politica yderjaniya.Annotaciya
// vidna v hode vbIplneniya programmbI
public @interface MethodInfo {

	String author() default "Alex";
	int dateOfCreation() default 2021;
	String purpose();
}
