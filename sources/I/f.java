package i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import i.b;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends ActionMode {
    public final Context a;
    public final b b;

    public static class a implements b.a {
        public final ActionMode.Callback a;
        public final Context b;
        public final ArrayList c = new ArrayList();
        public final s.i d = new s.i();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(bVar), new j.c(this.b, (I.b) menuItem));
        }

        public void b(b bVar) {
            this.a.onDestroyActionMode(e(bVar));
        }

        public boolean c(b bVar, Menu menu) {
            return this.a.onPrepareActionMode(e(bVar), f(menu));
        }

        public boolean d(b bVar, Menu menu) {
            return this.a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.c.get(i);
                if (fVar != null && fVar.b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            j.e eVar = new j.e(this.b, (I.a) menu);
            this.d.put(menu, eVar);
            return eVar;
        }
    }

    public f(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.d();
    }

    public Menu getMenu() {
        return new j.e(this.a, (I.a) this.b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.h();
    }

    public CharSequence getTitle() {
        return this.b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    public void invalidate() {
        this.b.k();
    }

    public boolean isTitleOptional() {
        return this.b.l();
    }

    public void setCustomView(View view) {
        this.b.m(view);
    }

    public void setSubtitle(int i) {
        this.b.n(i);
    }

    public void setTag(Object obj) {
        this.b.p(obj);
    }

    public void setTitle(int i) {
        this.b.q(i);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.s(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.r(charSequence);
    }
}
