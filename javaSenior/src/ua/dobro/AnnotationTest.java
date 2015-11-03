package ua.dobro;

import java.lang.reflect.Method;
import java.lang.annotation.*;
import java.util.Arrays;

public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationTest ann = new AnnotationTest();
        ann.checkForAnnotations(ann);
    }

    @Override
    @NewAnnotation(name = "first")
    public String toString() {
        return "override annotation";
    }

    @Deprecated
    @NewAnnotation(name = "second")
    public void printDepr() {
        System.out.println("Deprecated Annotation");
    }

    @SuppressWarnings("unused")
    @NewAnnotation(name = "third")
    public void suppresWarning() {
        String[] s = { "a", "b", "c" };
    }

    public void checkForAnnotations(AnnotationTest test) {
        Method[] methods = test.getClass().getMethods();
        for (Method method : methods) {
            if (method.getAnnotations().length == 0) {
                continue;
            }
            StringBuilder s = new StringBuilder();
            s.append("Method's name=" + method.getName() + ";");
            s.append("Annotations=" + Arrays.toString(method.getAnnotations()));
            System.out.println(s);
        }
    }
}

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface NewAnnotation {
    String name();

    boolean field1() default true;

    boolean field2() default true;
}
