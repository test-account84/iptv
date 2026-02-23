package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzajq extends zzahj implements zzajt, RandomAccess {
    private static final zzajq zza;

    @Deprecated
    private static final zzajt zzb;
    private final List zzc;

    static {
        zzajq zzajqVar = new zzajq(false);
        zza = zzajqVar;
        zzb = zzajqVar;
    }

    public zzajq() {
        this(10);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzajt) {
            collection = ((zzajt) collection).zze();
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

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzahp) {
            zzahp zzahpVar = (zzahp) obj;
            String zzd = zzahpVar.zzd();
            if (zzahpVar.zzf()) {
                this.zzc.set(i, zzd);
            }
            return zzd;
        }
        byte[] bArr = (byte[]) obj;
        String zzb2 = zzajf.zzb(bArr);
        if (zzajf.zzc(bArr)) {
            this.zzc.set(i, zzb2);
        }
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zza(remove);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zza(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzajj zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzajq(arrayList);
    }

    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    public final /* bridge */ /* synthetic */ boolean zzc() {
        return super.zzc();
    }

    public final zzajt zzd() {
        return zzc() ? new zzamf(this) : this;
    }

    public final List zze() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzajq(int i) {
        this(new ArrayList(i));
    }

    private static String zza(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzahp ? ((zzahp) obj).zzd() : zzajf.zzb((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private zzajq(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    public final void zza(zzahp zzahpVar) {
        zza();
        this.zzc.add(zzahpVar);
        ((AbstractList) this).modCount++;
    }

    private zzajq(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }
}
