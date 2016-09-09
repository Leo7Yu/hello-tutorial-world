package cn.leo.annotation;

import java.lang.reflect.Method;

public class AnnotationExample {

    @MethodInfo(comments = "deprecated method", date = "2016-08-24")
    public static void oldMethod() {
        System.out.println("old...");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getClassLoader()
                    .loadClass("cn.leo.annotation.AnnotationExample")
                    .getMethods()) {
                if(method.isAnnotationPresent(MethodInfo.class)){
                    MethodInfo methodAnno=method.getAnnotation(MethodInfo.class);
                    System.out.println(methodAnno.comments()+":"+methodAnno.author());
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
