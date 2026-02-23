package f5;

import android.view.View;
import android.view.ViewGroup;
import f5.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public final Map a = new HashMap();
    public final Set b = new HashSet();
    public b c;
    public boolean d;
    public boolean e;

    public class a implements h.a {
        public a() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h hVar, boolean z) {
            if (!z) {
                a aVar = a.this;
                if (!a.c(aVar, hVar, a.b(aVar))) {
                    return;
                }
            } else if (!a.a(a.this, hVar)) {
                return;
            }
            a.d(a.this);
        }
    }

    public interface b {
        void a(Set set);
    }

    public static /* synthetic */ boolean a(a aVar, h hVar) {
        return aVar.g(hVar);
    }

    public static /* synthetic */ boolean b(a aVar) {
        return aVar.e;
    }

    public static /* synthetic */ boolean c(a aVar, h hVar, boolean z) {
        return aVar.r(hVar, z);
    }

    public static /* synthetic */ void d(a aVar) {
        aVar.m();
    }

    public void e(h hVar) {
        this.a.put(Integer.valueOf(hVar.getId()), hVar);
        if (hVar.isChecked()) {
            g(hVar);
        }
        hVar.setInternalOnCheckedChangeListener(new a());
    }

    public void f(int i) {
        h hVar = (h) this.a.get(Integer.valueOf(i));
        if (hVar != null && g(hVar)) {
            m();
        }
    }

    public final boolean g(h hVar) {
        int id = hVar.getId();
        if (this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        h hVar2 = (h) this.a.get(Integer.valueOf(k()));
        if (hVar2 != null) {
            r(hVar2, false);
        }
        boolean add = this.b.add(Integer.valueOf(id));
        if (!hVar.isChecked()) {
            hVar.setChecked(true);
        }
        return add;
    }

    public void h() {
        boolean z = !this.b.isEmpty();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            r((h) it.next(), false);
        }
        if (z) {
            m();
        }
    }

    public Set i() {
        return new HashSet(this.b);
    }

    public List j(ViewGroup viewGroup) {
        Set i = i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof h) && i.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.d || this.b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.b.iterator().next()).intValue();
    }

    public boolean l() {
        return this.d;
    }

    public final void m() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    public void n(h hVar) {
        hVar.setInternalOnCheckedChangeListener(null);
        this.a.remove(Integer.valueOf(hVar.getId()));
        this.b.remove(Integer.valueOf(hVar.getId()));
    }

    public void o(b bVar) {
        this.c = bVar;
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(boolean z) {
        if (this.d != z) {
            this.d = z;
            h();
        }
    }

    public final boolean r(h hVar, boolean z) {
        int id = hVar.getId();
        if (!this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && this.b.size() == 1 && this.b.contains(Integer.valueOf(id))) {
            hVar.setChecked(true);
            return false;
        }
        boolean remove = this.b.remove(Integer.valueOf(id));
        if (hVar.isChecked()) {
            hVar.setChecked(false);
        }
        return remove;
    }
}
