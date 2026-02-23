package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lu implements ry {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final mo i;
    public final ml j;
    public final Uri k;
    public final ma l;
    private final List m;

    public lu(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ma maVar, mo moVar, ml mlVar, Uri uri, List list) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.l = maVar;
        this.i = moVar;
        this.k = uri;
        this.j = mlVar;
        this.m = list;
    }

    public final int a() {
        return this.m.size();
    }

    public final long b(int i) {
        if (i != this.m.size() - 1) {
            return ((lz) this.m.get(i + 1)).b - ((lz) this.m.get(i)).b;
        }
        long j = this.b;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - ((lz) this.m.get(i)).b;
    }

    public final long c(int i) {
        return cq.t(b(i));
    }

    public final lz d(int i) {
        return (lz) this.m.get(i);
    }

    public final /* bridge */ /* synthetic */ Object e(List list) {
        lu luVar = this;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new ba());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (i < a()) {
            if (((ba) linkedList.peek()).a != i) {
                long b = luVar.b(i);
                if (b != -9223372036854775807L) {
                    j += b;
                }
            } else {
                lz d = luVar.d(i);
                List list2 = d.c;
                ba baVar = (ba) linkedList.poll();
                int i2 = baVar.a;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i3 = baVar.b;
                    ls lsVar = (ls) list2.get(i3);
                    List list3 = lsVar.c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add((me) list3.get(baVar.c));
                        baVar = (ba) linkedList.poll();
                        if (baVar.a != i2) {
                            break;
                        }
                    } while (baVar.b == i3);
                    List list4 = list2;
                    arrayList2.add(new ls(lsVar.a, lsVar.b, arrayList3, lsVar.d, lsVar.e, lsVar.f));
                    if (baVar.a != i2) {
                        break;
                    }
                    list2 = list4;
                }
                linkedList.addFirst(baVar);
                arrayList.add(new lz(d.a, d.b - j, arrayList2, d.d));
            }
            i++;
            luVar = this;
        }
        long j2 = luVar.b;
        return new lu(luVar.a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, luVar.c, luVar.d, luVar.e, luVar.f, luVar.g, luVar.h, luVar.l, luVar.i, luVar.j, luVar.k, arrayList);
    }
}
