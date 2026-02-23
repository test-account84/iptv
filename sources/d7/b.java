package D7;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b {
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final a e;
    public final String f;
    public b g;
    public b h;
    public boolean i;

    public b(a aVar, long j, long j2, String str, String str2, String str3) {
        this.e = aVar;
        this.a = j;
        this.b = j2;
        this.c = str;
        this.f = str2;
        this.d = str3;
    }

    public a a() {
        return this.e;
    }

    public String b() {
        return this.d;
    }

    public long c() {
        return this.b;
    }

    public b d() {
        return this.h;
    }

    public b e() {
        return this.g;
    }

    public long f() {
        return this.a;
    }

    public String g() {
        return this.c;
    }

    public boolean h(int i) {
        long currentTimeMillis = System.currentTimeMillis() + i;
        return currentTimeMillis >= this.a && currentTimeMillis <= this.b;
    }

    public boolean i() {
        return this.i;
    }

    public void j(b bVar) {
        this.h = bVar;
    }

    public void k(b bVar) {
        this.g = bVar;
    }
}
