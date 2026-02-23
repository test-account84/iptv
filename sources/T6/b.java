package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final n e;
    public final a f;

    public b(String str, String str2, String str3, String str4, n nVar, a aVar) {
        kotlin.jvm.internal.l.e(str, "appId");
        kotlin.jvm.internal.l.e(str2, "deviceModel");
        kotlin.jvm.internal.l.e(str3, "sessionSdkVersion");
        kotlin.jvm.internal.l.e(str4, "osVersion");
        kotlin.jvm.internal.l.e(nVar, "logEnvironment");
        kotlin.jvm.internal.l.e(aVar, "androidAppInfo");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = nVar;
        this.f = aVar;
    }

    public final a a() {
        return this.f;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final n d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.a, bVar.a) && kotlin.jvm.internal.l.a(this.b, bVar.b) && kotlin.jvm.internal.l.a(this.c, bVar.c) && kotlin.jvm.internal.l.a(this.d, bVar.d) && this.e == bVar.e && kotlin.jvm.internal.l.a(this.f, bVar.f);
    }

    public final String f() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.a + ", deviceModel=" + this.b + ", sessionSdkVersion=" + this.c + ", osVersion=" + this.d + ", logEnvironment=" + this.e + ", androidAppInfo=" + this.f + ')';
    }
}
