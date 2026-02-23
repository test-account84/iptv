package Y3;

import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k implements P3.i {
    public final List a;
    public final long[] c;
    public final long[] d;

    public k(List list) {
        this.a = Collections.unmodifiableList(new ArrayList(list));
        this.c = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            int i2 = i * 2;
            long[] jArr = this.c;
            jArr[i2] = eVar.b;
            jArr[i2 + 1] = eVar.c;
        }
        long[] jArr2 = this.c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.d = copyOf;
        Arrays.sort(copyOf);
    }

    public static /* synthetic */ int d(e eVar, e eVar2) {
        return e(eVar, eVar2);
    }

    public static /* synthetic */ int e(e eVar, e eVar2) {
        return Long.compare(eVar.b, eVar2.b);
    }

    public int a(long j) {
        int e = k0.e(this.d, j, false, false);
        if (e < this.d.length) {
            return e;
        }
        return -1;
    }

    public List b(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            long[] jArr = this.c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                e eVar = (e) this.a.get(i);
                P3.b bVar = eVar.a;
                if (bVar.f == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new j());
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((e) arrayList2.get(i3)).a.b().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    public long c(int i) {
        d4.a.a(i >= 0);
        d4.a.a(i < this.d.length);
        return this.d[i];
    }

    public int h() {
        return this.d.length;
    }
}
