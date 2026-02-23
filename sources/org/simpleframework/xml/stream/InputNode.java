package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface InputNode extends Node {
    InputNode getAttribute(String str);

    NodeMap getAttributes();

    InputNode getNext() throws Exception;

    InputNode getNext(String str) throws Exception;

    InputNode getParent();

    Position getPosition();

    String getPrefix();

    String getReference();

    Object getSource();

    boolean isElement();

    boolean isEmpty() throws Exception;

    boolean isRoot();

    void skip() throws Exception;
}
