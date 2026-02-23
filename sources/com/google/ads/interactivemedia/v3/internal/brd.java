package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class brd extends bop implements RandomAccess, bre {
    private static final brd a;
    private final List b;

    static {
        brd brdVar = new brd(10);
        a = brdVar;
        brdVar.b();
    }

    public brd() {
        this(10);
    }

    private static String j(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof bpb ? ((bpb) obj).y() : bqu.f((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        a();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        a();
        if (collection instanceof bre) {
            collection = ((bre) collection).h();
        }
        boolean addAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public final void clear() {
        a();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ bqt d(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new brd(arrayList);
    }

    public final bre e() {
        return c() ? new bta(this) : this;
    }

    public final Object f(int i) {
        return this.b.get(i);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof bpb) {
            bpb bpbVar = (bpb) obj;
            String y = bpbVar.y();
            if (bpbVar.o()) {
                this.b.set(i, y);
            }
            return y;
        }
        byte[] bArr = (byte[]) obj;
        String f = bqu.f(bArr);
        if (bqu.h(bArr)) {
            this.b.set(i, f);
        }
        return f;
    }

    public final List h() {
        return Collections.unmodifiableList(this.b);
    }

    public final void i(bpb bpbVar) {
        a();
        this.b.add(bpbVar);
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return j(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        a();
        return j(this.b.set(i, (String) obj));
    }

    public final int size() {
        return this.b.size();
    }

    public brd(int i) {
        this(new ArrayList(i));
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    private brd(ArrayList arrayList) {
        this.b = arrayList;
    }
}
