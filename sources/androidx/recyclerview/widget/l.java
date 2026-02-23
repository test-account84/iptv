package androidx.recyclerview.widget;

import P.L;
import Q.C;
import Q.D;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l extends P.a {
    public final RecyclerView d;
    public final a e;

    public static class a extends P.a {
        public final l d;
        public Map e = new WeakHashMap();

        public a(l lVar) {
            this.d = lVar;
        }

        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            P.a aVar = (P.a) this.e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        public D b(View view) {
            P.a aVar = (P.a) this.e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            P.a aVar = (P.a) this.e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        public void g(View view, C c) {
            if (!this.d.o() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().k1(view, c);
                P.a aVar = (P.a) this.e.get(view);
                if (aVar != null) {
                    aVar.g(view, c);
                    return;
                }
            }
            super.g(view, c);
        }

        public void h(View view, AccessibilityEvent accessibilityEvent) {
            P.a aVar = (P.a) this.e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            P.a aVar = (P.a) this.e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean j(View view, int i, Bundle bundle) {
            if (this.d.o() || this.d.d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            P.a aVar = (P.a) this.e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.d.d.getLayoutManager().E1(view, i, bundle);
        }

        public void l(View view, int i) {
            P.a aVar = (P.a) this.e.get(view);
            if (aVar != null) {
                aVar.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        public void m(View view, AccessibilityEvent accessibilityEvent) {
            P.a aVar = (P.a) this.e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        public P.a n(View view) {
            return (P.a) this.e.remove(view);
        }

        public void o(View view) {
            P.a n = L.n(view);
            if (n == null || n == this) {
                return;
            }
            this.e.put(view, n);
        }
    }

    public l(RecyclerView recyclerView) {
        this.d = recyclerView;
        P.a n = n();
        this.e = (n == null || !(n instanceof a)) ? new a(this) : (a) n;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().g1(accessibilityEvent);
        }
    }

    public void g(View view, C c) {
        super.g(view, c);
        if (o() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().i1(c);
    }

    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().C1(i, bundle);
    }

    public P.a n() {
        return this.e;
    }

    public boolean o() {
        return this.d.q0();
    }
}
