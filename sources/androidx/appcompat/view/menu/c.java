package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c implements i, AdapterView.OnItemClickListener {
    public Context a;
    public LayoutInflater c;
    public e d;
    public ExpandedMenuView e;
    public int f;
    public int g;
    public int h;
    public i.a i;
    public a j;

    public class a extends BaseAdapter {
        public int a = -1;

        public a() {
            a();
        }

        public void a() {
            g v = c.this.d.v();
            if (v != null) {
                ArrayList z = c.this.d.z();
                int size = z.size();
                for (int i = 0; i < size; i++) {
                    if (((g) z.get(i)) == v) {
                        this.a = i;
                        return;
                    }
                }
            }
            this.a = -1;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i) {
            ArrayList z = c.this.d.z();
            int i2 = i + c.this.f;
            int i3 = this.a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return (g) z.get(i2);
        }

        public int getCount() {
            int size = c.this.d.z().size() - c.this.f;
            return this.a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.c.inflate(cVar.h, viewGroup, false);
            }
            ((j.a) view).c(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i, int i2) {
        this.h = i;
        this.g = i2;
    }

    public ListAdapter a() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    public void b(e eVar, boolean z) {
        i.a aVar = this.i;
        if (aVar != null) {
            aVar.b(eVar, z);
        }
    }

    public boolean c(e eVar, g gVar) {
        return false;
    }

    public void d(i.a aVar) {
        this.i = aVar;
    }

    public boolean e(l lVar) {
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        new f(lVar).d(null);
        i.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.c(lVar);
        return true;
    }

    public void f(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean g() {
        return false;
    }

    public boolean h(e eVar, g gVar) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(android.content.Context r3, androidx.appcompat.view.menu.e r4) {
        /*
            r2 = this;
            int r0 = r2.g
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.g
            r0.<init>(r3, r1)
            r2.a = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.c = r3
            goto L23
        L14:
            android.content.Context r0 = r2.a
            if (r0 == 0) goto L23
            r2.a = r3
            android.view.LayoutInflater r0 = r2.c
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.d = r4
            androidx.appcompat.view.menu.c$a r3 = r2.j
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.c.i(android.content.Context, androidx.appcompat.view.menu.e):void");
    }

    public j j(ViewGroup viewGroup) {
        if (this.e == null) {
            this.e = this.c.inflate(c.g.g, viewGroup, false);
            if (this.j == null) {
                this.j = new a();
            }
            this.e.setAdapter(this.j);
            this.e.setOnItemClickListener(this);
        }
        return this.e;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.d.M(this.j.getItem(i), this, 0);
    }

    public c(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.c = LayoutInflater.from(context);
    }
}
