package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzals extends AbstractSet {
    private final /* synthetic */ zzalg zza;

    private zzals(zzalg zzalgVar) {
        this.zza = zzalgVar;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zza.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator iterator() {
        return new zzalq(this.zza, null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zza.size();
    }

    public /* synthetic */ zzals(zzalg zzalgVar, zzalv zzalvVar) {
        this(zzalgVar);
    }
}
