package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bqz implements Map.Entry {
    private final Map.Entry a;

    public /* synthetic */ bqz(Map.Entry entry) {
        this.a = entry;
    }

    public final brb a() {
        return (brb) this.a.getValue();
    }

    public final Object getKey() {
        return this.a.getKey();
    }

    public final Object getValue() {
        if (((brb) this.a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof brs) {
            return ((brb) this.a.getValue()).d((brs) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
