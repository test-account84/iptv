package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class auk implements Map.Entry {
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (com.google.ads.interactivemedia.v3.impl.data.k.c(getKey(), entry.getKey()) && com.google.ads.interactivemedia.v3.impl.data.k.c(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public abstract Object getKey();

    public abstract Object getValue();

    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
