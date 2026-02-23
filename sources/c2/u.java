package C2;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class u implements t {
    public static volatile v e;
    public final M2.a a;
    public final M2.a b;
    public final I2.e c;
    public final J2.r d;

    public u(M2.a aVar, M2.a aVar2, I2.e eVar, J2.r rVar, J2.v vVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = eVar;
        this.d = rVar;
        vVar.c();
    }

    public static u c() {
        v vVar = e;
        if (vVar != null) {
            return vVar.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(z2.b.b("proto"));
    }

    public static void f(Context context) {
        if (e == null) {
            synchronized (u.class) {
                try {
                    if (e == null) {
                        e = e.d().a(context).build();
                    }
                } finally {
                }
            }
        }
    }

    public void a(o oVar, z2.h hVar) {
        this.c.a(oVar.f().f(oVar.c().c()), b(oVar), hVar);
    }

    public final i b(o oVar) {
        return i.a().i(this.a.a()).k(this.b.a()).j(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a()).d();
    }

    public J2.r e() {
        return this.d;
    }

    public z2.g g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
