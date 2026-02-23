package N3;

import O2.z0;
import android.net.Uri;
import d4.b0;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import l3.p;
import z3.C;
import z3.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a implements C {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final a e;
    public final b[] f;
    public final long g;
    public final long h;

    public static class a {
        public final UUID a;
        public final byte[] b;
        public final p[] c;

        public a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.a = uuid;
            this.b = bArr;
            this.c = pVarArr;
        }
    }

    public static class b {
        public final int a;
        public final String b;
        public final long c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final String i;
        public final z0[] j;
        public final int k;
        public final String l;
        public final String m;
        public final List n;
        public final long[] o;
        public final long p;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, z0[] z0VarArr, List list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, z0VarArr, list, k0.d1(list, 1000000L, j), k0.c1(j2, 1000000L, j));
        }

        public Uri a(int i, int i2) {
            d4.a.g(this.j != null);
            d4.a.g(this.n != null);
            d4.a.g(i2 < this.n.size());
            String num = Integer.toString(this.j[i].i);
            String l = ((Long) this.n.get(i2)).toString();
            return b0.e(this.l, this.m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }

        public b b(z0[] z0VarArr) {
            return new b(this.l, this.m, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, z0VarArr, this.n, this.o, this.p);
        }

        public long c(int i) {
            if (i == this.k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i + 1] - jArr[i];
        }

        public int d(long j) {
            return k0.i(this.o, j, true, true);
        }

        public long e(int i) {
            return this.o[i];
        }

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, z0[] z0VarArr, List list, long[] jArr, long j2) {
            this.l = str;
            this.m = str2;
            this.a = i;
            this.b = str3;
            this.c = j;
            this.d = str4;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = str5;
            this.j = z0VarArr;
            this.n = list;
            this.o = jArr;
            this.p = j2;
            this.k = list.size();
        }
    }

    public a(int i, int i2, long j, long j2, int i3, boolean z, a aVar, b[] bVarArr) {
        this.a = i;
        this.b = i2;
        this.g = j;
        this.h = j2;
        this.c = i3;
        this.d = z;
        this.e = aVar;
        this.f = bVarArr;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i = 0;
        while (i < arrayList.size()) {
            H h = (H) arrayList.get(i);
            b bVar2 = this.f[h.c];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((z0[]) arrayList3.toArray(new z0[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.j[h.d]);
            i++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((z0[]) arrayList3.toArray(new z0[0])));
        }
        return new a(this.a, this.b, this.g, this.h, this.c, this.d, this.e, (b[]) arrayList2.toArray(new b[0]));
    }

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, a aVar, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : k0.c1(j2, 1000000L, j), j3 != 0 ? k0.c1(j3, 1000000L, j) : -9223372036854775807L, i3, z, aVar, bVarArr);
    }
}
