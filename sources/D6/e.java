package D6;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e {
    public final byte[] a;
    public int b;
    public final String c;
    public final List d;
    public final String e;
    public Integer f;
    public Integer g;
    public Object h;
    public final int i;
    public final int j;

    public e(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public Object d() {
        return this.h;
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public String h() {
        return this.c;
    }

    public boolean i() {
        return this.i >= 0 && this.j >= 0;
    }

    public void j(Integer num) {
        this.g = num;
    }

    public void k(Integer num) {
        this.f = num;
    }

    public void l(int i) {
        this.b = i;
    }

    public void m(Object obj) {
        this.h = obj;
    }

    public e(byte[] bArr, String str, List list, String str2, int i, int i2) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i2;
        this.j = i;
    }
}
