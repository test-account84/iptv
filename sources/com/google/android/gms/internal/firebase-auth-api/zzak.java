package com.google.android.gms.internal.firebase-auth-api;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzak extends AbstractCollection implements Serializable, Collection {
    private static final Object[] zza = new Object[0];

    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.-CC.$default$forEach(this, consumer);
    }

    public /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.-CC.$default$removeIf(this, predicate);
    }

    @Deprecated
    public final boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    public int zza() {
        throw new UnsupportedOperationException();
    }

    public int zzb() {
        throw new UnsupportedOperationException();
    }

    public zzap zzc() {
        return isEmpty() ? zzap.zzh() : zzap.zza(toArray());
    }

    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public abstract zzbc iterator();

    public abstract boolean zze();

    public Object[] zzf() {
        return null;
    }

    public /* synthetic */ j$.util.stream.Stream parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    public j$.util.Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    public /* synthetic */ j$.util.stream.Stream stream() {
        return Collection.-CC.$default$stream(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }

    public int zza(Object[] objArr, int i) {
        zzbc zzbcVar = (zzbc) iterator();
        while (zzbcVar.hasNext()) {
            objArr[i] = zzbcVar.next();
            i++;
        }
        return i;
    }

    public final Object[] toArray(Object[] objArr) {
        zzy.zza(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] zzf = zzf();
            if (zzf != null) {
                return Arrays.copyOfRange(zzf, zzb(), zza(), objArr.getClass());
            }
            if (objArr.length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        zza(objArr, 0);
        return objArr;
    }
}
