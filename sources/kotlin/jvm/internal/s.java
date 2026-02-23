package kotlin.jvm.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class s implements d {
    public final Class a;
    public final String c;

    public s(Class jClass, String moduleName) {
        l.e(jClass, "jClass");
        l.e(moduleName, "moduleName");
        this.a = jClass;
        this.c = moduleName;
    }

    public Class a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && l.a(a(), ((s) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
