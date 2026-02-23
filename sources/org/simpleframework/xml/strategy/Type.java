package org.simpleframework.xml.strategy;

import java.lang.annotation.Annotation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Type {
    Annotation getAnnotation(Class cls);

    Class getType();

    String toString();
}
