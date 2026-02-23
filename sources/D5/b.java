package d5;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final View a;
    public boolean b = false;
    public int c = 0;

    public b(a aVar) {
        this.a = (View) aVar;
    }

    public final void a() {
        CoordinatorLayout parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            parent.f(this.a);
        }
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void f(int i) {
        this.c = i;
    }
}
