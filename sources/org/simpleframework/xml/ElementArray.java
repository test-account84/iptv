package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public @interface ElementArray {
    boolean data() default false;

    boolean empty() default true;

    String entry() default "";

    String name() default "";

    boolean required() default true;
}
