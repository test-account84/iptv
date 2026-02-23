package org.simpleframework.xml.strategy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Value {
    int getLength();

    Class getType();

    Object getValue();

    boolean isReference();

    void setValue(Object obj);
}
