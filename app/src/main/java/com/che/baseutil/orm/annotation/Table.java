package com.che.baseutil.orm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：余天然 on 16/9/15 下午4:37
 */
/*用来映射表名称的注解*/
@Target({ElementType.TYPE})  //应用于类或接口
@Retention(RetentionPolicy.RUNTIME)  //方便运行时通过反射获取到
@Inherited  //类注解可被类继承
@Documented
public @interface Table {
}
