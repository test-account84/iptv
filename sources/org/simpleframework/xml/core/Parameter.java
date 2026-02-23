package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Parameter {
    Annotation getAnnotation();

    Expression getExpression();

    int getIndex();

    Object getKey();

    String getName();

    String getPath();

    Class getType();

    boolean isAttribute();

    boolean isPrimitive();

    boolean isRequired();

    boolean isText();

    String toString();
}
