package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public a(String str, String str2, String str3, String str4) {
        kotlin.jvm.internal.l.e(str, "packageName");
        kotlin.jvm.internal.l.e(str2, "versionName");
        kotlin.jvm.internal.l.e(str3, "appBuildVersion");
        kotlin.jvm.internal.l.e(str4, "deviceManufacturer");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.l.a(this.a, aVar.a) && kotlin.jvm.internal.l.a(this.b, aVar.b) && kotlin.jvm.internal.l.a(this.c, aVar.c) && kotlin.jvm.internal.l.a(this.d, aVar.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.a + ", versionName=" + this.b + ", appBuildVersion=" + this.c + ", deviceManufacturer=" + this.d + ')';
    }
}
