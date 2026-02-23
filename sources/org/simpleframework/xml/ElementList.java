package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public @interface ElementList {
    boolean data() default false;

    boolean empty() default true;

    String entry() default "";

    boolean inline() default false;

    String name() default "";

    boolean required() default true;

    Class type() default void.class;
}
