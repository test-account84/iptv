package x6;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o {
    public final String a;
    public final byte[] b;
    public final int c;
    public q[] d;
    public final a e;
    public Map f;
    public final long g;

    public o(String str, byte[] bArr, int i, q[] qVarArr, a aVar, long j) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = qVarArr;
        this.e = aVar;
        this.f = null;
        this.g = j;
    }

    public void a(q[] qVarArr) {
        q[] qVarArr2 = this.d;
        if (qVarArr2 == null) {
            this.d = qVarArr;
            return;
        }
        if (qVarArr == null || qVarArr.length <= 0) {
            return;
        }
        q[] qVarArr3 = new q[qVarArr2.length + qVarArr.length];
        System.arraycopy(qVarArr2, 0, qVarArr3, 0, qVarArr2.length);
        System.arraycopy(qVarArr, 0, qVarArr3, qVarArr2.length, qVarArr.length);
        this.d = qVarArr3;
    }

    public a b() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    public Map d() {
        return this.f;
    }

    public q[] e() {
        return this.d;
    }

    public String f() {
        return this.a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f;
            if (map2 == null) {
                this.f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(p pVar, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(p.class);
        }
        this.f.put(pVar, obj);
    }

    public String toString() {
        return this.a;
    }

    public o(String str, byte[] bArr, q[] qVarArr, a aVar) {
        this(str, bArr, qVarArr, aVar, System.currentTimeMillis());
    }

    public o(String str, byte[] bArr, q[] qVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, qVarArr, aVar, j);
    }
}
