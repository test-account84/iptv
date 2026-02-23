package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface MethodPart {
    Annotation getAnnotation();

    Annotation getAnnotation(Class cls);

    Class getDeclaringClass();

    Class getDependent();

    Class[] getDependents();

    Method getMethod();

    MethodType getMethodType();

    String getName();

    Class getType();

    String toString();
}
