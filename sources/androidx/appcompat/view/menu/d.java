package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends BaseAdapter {
    public e a;
    public int c = -1;
    public boolean d;
    public final boolean e;
    public final LayoutInflater f;
    public final int g;

    public d(e eVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.e = z;
        this.f = layoutInflater;
        this.a = eVar;
        this.g = i;
        a();
    }

    public void a() {
        g v = this.a.v();
        if (v != null) {
            ArrayList z = this.a.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (((g) z.get(i)) == v) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public e b() {
        return this.a;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i) {
        ArrayList z = this.e ? this.a.z() : this.a.E();
        int i2 = this.c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (g) z.get(i);
    }

    public void d(boolean z) {
        this.d = z;
    }

    public int getCount() {
        ArrayList z = this.e ? this.a.z() : this.a.E();
        int i = this.c;
        int size = z.size();
        return i < 0 ? size : size - 1;
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.inflate(this.g, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.a.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.c(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
