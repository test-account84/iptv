package org.simpleframework.xml.stream;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface NamespaceMap extends Iterable {
    String getPrefix();

    String getPrefix(String str);

    String getReference(String str);

    Iterator iterator();

    String setReference(String str);

    String setReference(String str, String str2);
}
