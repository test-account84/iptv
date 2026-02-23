package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r {
    public final j a;
    public final u b;
    public final b c;

    public r(j jVar, u uVar, b bVar) {
        kotlin.jvm.internal.l.e(jVar, "eventType");
        kotlin.jvm.internal.l.e(uVar, "sessionData");
        kotlin.jvm.internal.l.e(bVar, "applicationInfo");
        this.a = jVar;
        this.b = uVar;
        this.c = bVar;
    }

    public final b a() {
        return this.c;
    }

    public final j b() {
        return this.a;
    }

    public final u c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a == rVar.a && kotlin.jvm.internal.l.a(this.b, rVar.b) && kotlin.jvm.internal.l.a(this.c, rVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.a + ", sessionData=" + this.b + ", applicationInfo=" + this.c + ')';
    }
}
