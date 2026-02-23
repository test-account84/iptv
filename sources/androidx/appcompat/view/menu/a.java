package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a implements i {
    public Context a;
    public Context c;
    public e d;
    public LayoutInflater e;
    public LayoutInflater f;
    public i.a g;
    public int h;
    public int i;
    public j j;
    public int k;

    public a(Context context, int i, int i2) {
        this.a = context;
        this.e = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public void a(View view, int i) {
        ViewGroup parent = view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        this.j.addView(view, i);
    }

    public void b(e eVar, boolean z) {
        i.a aVar = this.g;
        if (aVar != null) {
            aVar.b(eVar, z);
        }
    }

    public boolean c(e eVar, g gVar) {
        return false;
    }

    public void d(i.a aVar) {
        this.g = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    public boolean e(l lVar) {
        i.a aVar = this.g;
        l lVar2 = lVar;
        if (aVar == null) {
            return false;
        }
        if (lVar == null) {
            lVar2 = this.d;
        }
        return aVar.c(lVar2);
    }

    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.j;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.d;
        int i = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList E = this.d.E();
            int size = E.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) E.get(i3);
                if (q(i2, gVar)) {
                    j.a childAt = viewGroup.getChildAt(i2);
                    g itemData = childAt instanceof j.a ? childAt.getItemData() : null;
                    j.a n = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        n.setPressed(false);
                        n.jumpDrawablesToCurrentState();
                    }
                    if (n != childAt) {
                        a(n, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!l(viewGroup, i)) {
                i++;
            }
        }
    }

    public boolean h(e eVar, g gVar) {
        return false;
    }

    public void i(Context context, e eVar) {
        this.c = context;
        this.f = LayoutInflater.from(context);
        this.d = eVar;
    }

    public abstract void j(g gVar, j.a aVar);

    public j.a k(ViewGroup viewGroup) {
        return this.e.inflate(this.i, viewGroup, false);
    }

    public boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public i.a m() {
        return this.g;
    }

    public View n(g gVar, View view, ViewGroup viewGroup) {
        j.a k = view instanceof j.a ? (j.a) view : k(viewGroup);
        j(gVar, k);
        return (View) k;
    }

    public j o(ViewGroup viewGroup) {
        if (this.j == null) {
            j inflate = this.e.inflate(this.h, viewGroup, false);
            this.j = inflate;
            inflate.a(this.d);
            f(true);
        }
        return this.j;
    }

    public void p(int i) {
        this.k = i;
    }

    public abstract boolean q(int i, g gVar);
}
