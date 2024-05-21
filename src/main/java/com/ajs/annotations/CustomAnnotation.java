package com.ajs.annotations;


import com.ajs.enums.TestCategories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface CustomAnnotation {


    String[] authors();
    TestCategories[] categories();

}
