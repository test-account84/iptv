package O5;

import u6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class j implements u6.b {
    public final u a;
    public String b = null;

    public j(u uVar) {
        this.a = uVar;
    }

    public void a(b.b bVar) {
        L5.f.f().b("App Quality Sessions session changed: " + bVar);
        this.b = bVar.a();
    }

    public boolean b() {
        return this.a.d();
    }

    public b.a c() {
        return b.a.CRASHLYTICS;
    }

    public String d() {
        return this.b;
    }
}
