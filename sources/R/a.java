package r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a implements c {
    public void a(b bVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        bVar.b(new d(colorStateList, f));
        View f4 = bVar.f();
        f4.setClipToOutline(true);
        f4.setElevation(f2);
        m(bVar, f3);
    }

    public float b(b bVar) {
        return k(bVar) * 2.0f;
    }

    public void c(b bVar, float f) {
        bVar.f().setElevation(f);
    }

    public void d(b bVar) {
        m(bVar, i(bVar));
    }

    public void e(b bVar) {
        m(bVar, i(bVar));
    }

    public void f(b bVar, float f) {
        o(bVar).h(f);
    }

    public ColorStateList g(b bVar) {
        return o(bVar).b();
    }

    public float h(b bVar) {
        return bVar.f().getElevation();
    }

    public float i(b bVar) {
        return o(bVar).c();
    }

    public float j(b bVar) {
        return k(bVar) * 2.0f;
    }

    public float k(b bVar) {
        return o(bVar).d();
    }

    public void m(b bVar, float f) {
        o(bVar).g(f, bVar.c(), bVar.e());
        p(bVar);
    }

    public void n(b bVar, ColorStateList colorStateList) {
        o(bVar).f(colorStateList);
    }

    public final d o(b bVar) {
        return (d) bVar.d();
    }

    public void p(b bVar) {
        if (!bVar.c()) {
            bVar.a(0, 0, 0, 0);
            return;
        }
        float i = i(bVar);
        float k = k(bVar);
        int ceil = (int) Math.ceil(e.a(i, k, bVar.e()));
        int ceil2 = (int) Math.ceil(e.b(i, k, bVar.e()));
        bVar.a(ceil, ceil2, ceil, ceil2);
    }

    public void l() {
    }
}
