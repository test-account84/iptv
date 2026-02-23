package com.google.android.gms.internal.firebase-auth-api;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzajm implements Map.Entry {
    private Map.Entry zza;

    private zzajm(Map.Entry entry) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzajn) this.zza.getValue()) == null) {
            return null;
        }
        return zzajn.zza();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzakn) {
            return ((zzajn) this.zza.getValue()).zza((zzakn) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzajn zza() {
        return (zzajn) this.zza.getValue();
    }

    public /* synthetic */ zzajm(Map.Entry entry, zzajp zzajpVar) {
        this(entry);
    }
}
