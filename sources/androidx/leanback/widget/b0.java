package androidx.leanback.widget;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b0 {
    public int a = 0;
    public int b = 100;
    public s.g c;

    public static String e(int i) {
        return Integer.toString(i);
    }

    public void a() {
        s.g gVar;
        int i = this.a;
        if (i == 2) {
            if (this.b <= 0) {
                throw new IllegalArgumentException();
            }
            s.g gVar2 = this.c;
            if (gVar2 != null && gVar2.maxSize() == this.b) {
                return;
            } else {
                gVar = new s.g(this.b);
            }
        } else if (i == 3 || i == 1) {
            s.g gVar3 = this.c;
            if (gVar3 != null && gVar3.maxSize() == Integer.MAX_VALUE) {
                return;
            } else {
                gVar = new s.g(Integer.MAX_VALUE);
            }
        } else {
            gVar = null;
        }
        this.c = gVar;
    }

    public void b() {
        s.g gVar = this.c;
        if (gVar != null) {
            gVar.evictAll();
        }
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final void f(Bundle bundle) {
        s.g gVar = this.c;
        if (gVar == null || bundle == null) {
            return;
        }
        gVar.evictAll();
        for (String str : bundle.keySet()) {
            this.c.put(str, bundle.getSparseParcelableArray(str));
        }
    }

    public final void g(View view, int i) {
        if (this.c != null) {
            SparseArray sparseArray = (SparseArray) this.c.remove(e(i));
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
            }
        }
    }

    public void h(int i) {
        s.g gVar = this.c;
        if (gVar == null || gVar.size() == 0) {
            return;
        }
        this.c.remove(e(i));
    }

    public final Bundle i() {
        s.g gVar = this.c;
        if (gVar == null || gVar.size() == 0) {
            return null;
        }
        Map snapshot = this.c.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry entry : snapshot.entrySet()) {
            bundle.putSparseParcelableArray((String) entry.getKey(), (SparseArray) entry.getValue());
        }
        return bundle;
    }

    public final void j(View view, int i) {
        int i2 = this.a;
        if (i2 == 1) {
            h(i);
        } else if (i2 == 2 || i2 == 3) {
            l(view, i);
        }
    }

    public final Bundle k(Bundle bundle, View view, int i) {
        if (this.a != 0) {
            String e = e(i);
            SparseArray sparseArray = new SparseArray();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(e, sparseArray);
        }
        return bundle;
    }

    public final void l(View view, int i) {
        if (this.c != null) {
            String e = e(i);
            SparseArray sparseArray = new SparseArray();
            view.saveHierarchyState(sparseArray);
            this.c.put(e, sparseArray);
        }
    }

    public final void m(int i) {
        this.b = i;
        a();
    }

    public final void n(int i) {
        this.a = i;
        a();
    }
}
