package t06_t07;

import java.lang.annotation.*;

/**
 * Custom annotation without certain purpose. Created to fulfill Java school task 07.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String version() default "1.0.0";

    String lastModified() default "12.07.2017";

    String createdBy() default "John Smith";
}
