package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzhf extends zzek implements RandomAccess, zzhg {

    @Deprecated
    public static final zzhg zza;
    private static final zzhf zzb;
    private final List zzc;

    static {
        zzhf zzhfVar = new zzhf(false);
        zzb = zzhfVar;
        zza = zzhfVar;
    }

    public zzhf() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzez ? ((zzez) obj).zzn(zzgw.zzb) : zzgw.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzhg) {
            collection = ((zzhg) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzgv zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzhf(arrayList);
    }

    public final zzhg zze() {
        return zzc() ? new zzjk(this) : this;
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
        if (obj instanceof zzez) {
            zzez zzezVar = (zzez) obj;
            String zzn = zzezVar.zzn(zzgw.zzb);
            if (zzezVar.zzj()) {
                this.zzc.set(i, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgw.zzd(bArr);
        if (zzju.zze(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzez zzezVar) {
        zza();
        this.zzc.add(zzezVar);
        ((AbstractList) this).modCount++;
    }

    public zzhf(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    private zzhf(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzhf(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }
}
