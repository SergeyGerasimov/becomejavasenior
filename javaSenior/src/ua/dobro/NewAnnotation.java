package ua.dobro;

import java.lang.annotation.*;

@Documented @Inherited @Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME)
public @interface NewAnnotation {
    String name();
    boolean field1() default true;
    boolean field2() default true;
}
