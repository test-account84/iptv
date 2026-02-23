package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface EventNode extends Iterable {
    int getLine();

    String getName();

    String getPrefix();

    String getReference();

    Object getSource();

    String getValue();

    boolean isEnd();

    boolean isStart();

    boolean isText();
}
