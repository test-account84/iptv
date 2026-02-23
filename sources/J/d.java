package j;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d implements f, i, AdapterView.OnItemClickListener {
    public Rect a;

    public static int m(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean w(androidx.appcompat.view.menu.e eVar) {
        int size = eVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = eVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static androidx.appcompat.view.menu.d x(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) listAdapter;
    }

    public boolean c(androidx.appcompat.view.menu.e eVar, g gVar) {
        return false;
    }

    public boolean h(androidx.appcompat.view.menu.e eVar, g gVar) {
        return false;
    }

    public abstract void j(androidx.appcompat.view.menu.e eVar);

    public boolean k() {
        return true;
    }

    public Rect l() {
        return this.a;
    }

    public abstract void n(View view);

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter adapter = adapterView.getAdapter();
        x(adapter).a.M((MenuItem) adapter.getItem(i), this, k() ? 0 : 4);
    }

    public void p(Rect rect) {
        this.a = rect;
    }

    public abstract void q(boolean z);

    public abstract void r(int i);

    public abstract void s(int i);

    public abstract void t(PopupWindow.OnDismissListener onDismissListener);

    public abstract void u(boolean z);

    public abstract void v(int i);

    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
    }
}
