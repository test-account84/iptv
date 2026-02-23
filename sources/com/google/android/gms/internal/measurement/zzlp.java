package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlp extends zzjl implements RandomAccess, zzlq {

    @Deprecated
    public static final zzlq zza;
    private static final zzlp zzb;
    private final List zzc;

    static {
        zzlp zzlpVar = new zzlp(false);
        zzb = zzlpVar;
        zza = zzlpVar;
    }

    public zzlp() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzka ? ((zzka) obj).zzm(zzlj.zzb) : zzlj.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzbW();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zzbW();
        if (collection instanceof zzlq) {
            collection = ((zzlq) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public final void clear() {
        zzbW();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzbW();
        Object remove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzbW();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzli zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzlp(arrayList);
    }

    public final zzlq zze() {
        return zzc() ? new zznp(this) : this;
    }

    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzka) {
            zzka zzkaVar = (zzka) obj;
            String zzm = zzkaVar.zzm(zzlj.zzb);
            if (zzkaVar.zzi()) {
                this.zzc.set(i, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzlj.zzd(bArr);
        if (zznz.zzd(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzka zzkaVar) {
        zzbW();
        this.zzc.add(zzkaVar);
        ((AbstractList) this).modCount++;
    }

    public zzlp(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    private zzlp(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzlp(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }
}
