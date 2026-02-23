package org.simpleframework.xml.stream;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface NodeMap extends Iterable {
    Node get(String str);

    String getName();

    Node getNode();

    Iterator iterator();

    Node put(String str, String str2);

    Node remove(String str);
}
