package org.simpleframework.xml.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Section extends Iterable {
    String getAttribute(String str) throws Exception;

    LabelMap getAttributes() throws Exception;

    Label getElement(String str) throws Exception;

    LabelMap getElements() throws Exception;

    String getName();

    String getPath(String str) throws Exception;

    String getPrefix();

    Section getSection(String str) throws Exception;

    Label getText() throws Exception;

    boolean isSection(String str) throws Exception;
}
