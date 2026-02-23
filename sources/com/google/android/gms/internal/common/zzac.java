package com.google.android.gms.internal.common;

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
import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzac extends AbstractCollection implements Serializable, Collection {
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

    public int zza(Object[] objArr, int i) {
        throw null;
    }

    public int zzb() {
        throw null;
    }

    public int zzc() {
        throw null;
    }

    public zzag zzd() {
        throw null;
    }

    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public abstract zzaj iterator();

    public abstract boolean zzf();

    public Object[] zzg() {
        throw null;
    }

    public /* synthetic */ j$.util.stream.Stream parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    public final j$.util.Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    public /* synthetic */ j$.util.stream.Stream stream() {
        return Collection.-CC.$default$stream(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }

    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] zzg = zzg();
            if (zzg != null) {
                return Arrays.copyOfRange(zzg, zzc(), zzb(), objArr.getClass());
            }
            if (length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (length > size) {
            objArr[size] = null;
        }
        zza(objArr, 0);
        return objArr;
    }
}
