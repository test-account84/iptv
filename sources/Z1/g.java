package z1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {
    public x1.d a = x1.d.a();

    public class a implements x1.c {
        public final /* synthetic */ j a;

        public a(j jVar) {
            this.a = jVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f apply(g gVar) {
            return gVar.b(this.a);
        }
    }

    public abstract f a(j jVar);

    public final f b(j jVar) {
        return this.a.f() ? a(jVar).a((f) this.a.g(new a(jVar)).e()) : a(jVar);
    }
}
