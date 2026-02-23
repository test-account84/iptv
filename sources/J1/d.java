package J1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements v1.d {
    public final h a;
    public final K1.d b;

    public d(h hVar, K1.d dVar) {
        this.a = hVar;
        this.b = dVar;
    }

    public void a(String str, v1.c cVar) {
        x1.g.c(str, "fieldName == null");
        if (cVar == null) {
            this.a.g(str).h();
            return;
        }
        this.a.g(str).c();
        cVar.marshal(this);
        this.a.e();
    }

    public void b(String str, Integer num) {
        x1.g.c(str, "fieldName == null");
        if (num != null) {
            this.a.g(str).o(num);
        } else {
            this.a.g(str).h();
        }
    }

    public void c(String str, String str2) {
        x1.g.c(str, "fieldName == null");
        if (str2 != null) {
            this.a.g(str).p(str2);
        } else {
            this.a.g(str).h();
        }
    }
}
