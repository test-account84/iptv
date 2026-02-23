package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u {
    public final String a;
    public final String b;
    public final int c;
    public long d;
    public f e;
    public String f;

    public u(String str, String str2, int i, long j, f fVar, String str3) {
        kotlin.jvm.internal.l.e(str, "sessionId");
        kotlin.jvm.internal.l.e(str2, "firstSessionId");
        kotlin.jvm.internal.l.e(fVar, "dataCollectionStatus");
        kotlin.jvm.internal.l.e(str3, "firebaseInstallationId");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.e = fVar;
        this.f = str3;
    }

    public final f a() {
        return this.e;
    }

    public final long b() {
        return this.d;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.l.a(this.a, uVar.a) && kotlin.jvm.internal.l.a(this.b, uVar.b) && this.c == uVar.c && this.d == uVar.d && kotlin.jvm.internal.l.a(this.e, uVar.e) && kotlin.jvm.internal.l.a(this.f, uVar.f);
    }

    public final int f() {
        return this.c;
    }

    public final void g(String str) {
        kotlin.jvm.internal.l.e(str, "<set-?>");
        this.f = str;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + p.a(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.a + ", firstSessionId=" + this.b + ", sessionIndex=" + this.c + ", eventTimestampUs=" + this.d + ", dataCollectionStatus=" + this.e + ", firebaseInstallationId=" + this.f + ')';
    }

    public /* synthetic */ u(String str, String str2, int i, long j, f fVar, String str3, int i2, kotlin.jvm.internal.g gVar) {
        this(str, str2, i, j, (i2 & 16) != 0 ? new f(null, null, 0.0d, 7, null) : fVar, (i2 & 32) != 0 ? "" : str3);
    }
}
