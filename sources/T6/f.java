package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f {
    public final d a;
    public final d b;
    public final double c;

    public f(d dVar, d dVar2, double d) {
        kotlin.jvm.internal.l.e(dVar, "performance");
        kotlin.jvm.internal.l.e(dVar2, "crashlytics");
        this.a = dVar;
        this.b = dVar2;
        this.c = d;
    }

    public final d a() {
        return this.b;
    }

    public final d b() {
        return this.a;
    }

    public final double c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b && kotlin.jvm.internal.l.a(Double.valueOf(this.c), Double.valueOf(fVar.c));
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + e.a(this.c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.a + ", crashlytics=" + this.b + ", sessionSamplingRate=" + this.c + ')';
    }

    public /* synthetic */ f(d dVar, d dVar2, double d, int i, kotlin.jvm.internal.g gVar) {
        this((i & 1) != 0 ? d.COLLECTION_SDK_NOT_INSTALLED : dVar, (i & 2) != 0 ? d.COLLECTION_SDK_NOT_INSTALLED : dVar2, (i & 4) != 0 ? 1.0d : d);
    }
}
