package org.simpleframework.xml.util;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Cache {
    void cache(Object obj, Object obj2);

    boolean contains(Object obj);

    Object fetch(Object obj);

    boolean isEmpty();

    Object take(Object obj);
}
