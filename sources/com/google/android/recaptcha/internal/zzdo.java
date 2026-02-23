package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdo extends zzds implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzdo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(zzdl.zza("maxSize (%s) must >= 0", Integer.valueOf(i)));
        }
        this.zzb = new ArrayDeque(i);
        this.zza = i;
    }

    public static zzdo zza(int i) {
        return new zzdo(i);
    }

    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    public final boolean addAll(Collection collection) {
        Iterator it;
        int size = collection.size();
        if (size >= this.zza) {
            clear();
            int i = size - this.zza;
            zzdi.zzb(i >= 0, "number to skip cannot be negative");
            it = new zzdu(collection, i).iterator();
        } else {
            it = collection.iterator();
        }
        return zzdv.zza(this, it);
    }

    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    public final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    public final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    public final Queue zzd() {
        return this.zzb;
    }
}
