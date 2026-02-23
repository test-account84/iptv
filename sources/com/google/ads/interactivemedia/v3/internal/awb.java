package com.google.ads.interactivemedia.v3.internal;

import j$.util.Map;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class awb extends awc implements NavigableMap, Map {
    private static final awb a = new awb(awf.w(awx.a), avo.o());
    private static final long serialVersionUID = 0;
    private final transient axg b;
    private final transient avo c;
    private transient awb d;

    public awb(axg axgVar, avo avoVar) {
        this(axgVar, avoVar, null);
    }

    public static /* synthetic */ avo k(awb awbVar) {
        return awbVar.c;
    }

    public static awb l(Comparator comparator) {
        return awx.a.equals(comparator) ? a : new awb(awf.w(comparator), avo.o());
    }

    public static awb n() {
        return a;
    }

    public static /* synthetic */ axg q(awb awbVar) {
        return awbVar.b;
    }

    private final awb r(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        return i == i2 ? l(comparator()) : new awb(this.b.A(i, i2), this.c.subList(i, i2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public final avi a() {
        throw new AssertionError("should never be called");
    }

    public final avi b() {
        return this.c;
    }

    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    public final Object ceilingKey(Object obj) {
        return axo.n(ceilingEntry(obj));
    }

    public final Comparator comparator() {
        return ((awf) this.b).a;
    }

    public final /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return this.b.p();
    }

    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        awb awbVar = this.d;
        return awbVar == null ? isEmpty() ? l(awy.b(comparator()).a()) : new awb((axg) this.b.p(), this.c.h(), this) : awbVar;
    }

    public final avx e() {
        return isEmpty() ? axf.a : new avu(this);
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    public final avx f() {
        throw new AssertionError("should never be called");
    }

    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().d().get(0);
    }

    public final Object firstKey() {
        return this.b.first();
    }

    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    public final Object floorKey(Object obj) {
        return axo.n(floorEntry(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0005  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.axg r0 = r3.b
            r1 = -1
            if (r4 != 0) goto L7
        L5:
            r4 = -1
            goto L14
        L7:
            com.google.ads.interactivemedia.v3.internal.avo r2 = r0.d     // Catch: java.lang.ClassCastException -> L12
            java.util.Comparator r0 = r0.a     // Catch: java.lang.ClassCastException -> L12
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L12
            if (r4 >= 0) goto L14
            goto L5
        L12:
            goto L5
        L14:
            if (r4 != r1) goto L18
            r4 = 0
            return r4
        L18:
            com.google.ads.interactivemedia.v3.internal.avo r0 = r3.c
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.awb.get(java.lang.Object):java.lang.Object");
    }

    public final /* synthetic */ avx h() {
        return this.b;
    }

    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    public final Object higherKey(Object obj) {
        return axo.n(higherEntry(obj));
    }

    public final boolean i() {
        return this.b.f() || this.c.f();
    }

    public final /* synthetic */ Set keySet() {
        return this.b;
    }

    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().d().get(size() - 1);
    }

    public final Object lastKey() {
        return this.b.last();
    }

    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    public final Object lowerKey(Object obj) {
        return axo.n(lowerEntry(obj));
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final awb headMap(Object obj, boolean z) {
        axg axgVar = this.b;
        atp.k(obj);
        return r(0, axgVar.y(obj, z));
    }

    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.b;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final awb subMap(Object obj, boolean z, Object obj2, boolean z2) {
        atp.k(obj);
        atp.k(obj2);
        if (comparator().compare(obj, obj2) <= 0) {
            return headMap(obj2, z2).tailMap(obj, z);
        }
        throw new IllegalArgumentException(atp.b("expected fromKey <= toKey but %s > %s", obj, obj2));
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final awb tailMap(Object obj, boolean z) {
        axg axgVar = this.b;
        atp.k(obj);
        return r(axgVar.z(obj, z), size());
    }

    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.c.size();
    }

    public final /* synthetic */ Collection values() {
        return this.c;
    }

    public Object writeReplace() {
        return new awa(this);
    }

    public awb(axg axgVar, avo avoVar, awb awbVar) {
        this.b = axgVar;
        this.c = avoVar;
        this.d = awbVar;
    }

    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
