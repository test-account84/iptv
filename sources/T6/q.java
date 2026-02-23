package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q {
    public final String a;
    public final String b;
    public final int c;
    public final long d;

    public q(String str, String str2, int i, long j) {
        kotlin.jvm.internal.l.e(str, "sessionId");
        kotlin.jvm.internal.l.e(str2, "firstSessionId");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.l.a(this.a, qVar.a) && kotlin.jvm.internal.l.a(this.b, qVar.b) && this.c == qVar.c && this.d == qVar.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + p.a(this.d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.a + ", firstSessionId=" + this.b + ", sessionIndex=" + this.c + ", sessionStartTimestampUs=" + this.d + ')';
    }
}
