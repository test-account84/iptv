package com.facebook.ads.internal.bench;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public @interface Benchmark {
    int failAtMillis() default Integer.MAX_VALUE;

    int warnAtMillis() default Integer.MAX_VALUE;
}
