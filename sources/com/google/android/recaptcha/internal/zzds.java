package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Queue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzds extends zzdq implements Queue {
    public final Object element() {
        return zzd().element();
    }

    public boolean offer(Object obj) {
        return zzd().offer(obj);
    }

    public final Object peek() {
        return zzd().peek();
    }

    public final Object poll() {
        return zzd().poll();
    }

    public final Object remove() {
        return zzd().remove();
    }

    public /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }

    public abstract Queue zzd();
}
