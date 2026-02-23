package org.simpleframework.xml.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Expression extends Iterable {
    String getAttribute(String str);

    String getElement(String str);

    String getFirst();

    int getIndex();

    String getLast();

    String getPath();

    Expression getPath(int i);

    Expression getPath(int i, int i2);

    String getPrefix();

    boolean isAttribute();

    boolean isEmpty();

    boolean isPath();

    String toString();
}
