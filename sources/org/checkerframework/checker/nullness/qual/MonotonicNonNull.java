package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.MonotonicQualifier;
import org.checkerframework.framework.qual.SubtypeOf;

@Target({ElementType.TYPE_USE})
@MonotonicQualifier(NonNull.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({Nullable.class})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public @interface MonotonicNonNull {
}
