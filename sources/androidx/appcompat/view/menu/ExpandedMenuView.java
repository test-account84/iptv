package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import k.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, j, AdapterView.OnItemClickListener {
    public static final int[] d = {16842964, 16843049};
    public e a;
    public int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void a(e eVar) {
        this.a = eVar;
    }

    public boolean d(g gVar) {
        return this.a.L(gVar, 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        d((g) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        d0 v = d0.v(context, attributeSet, d, i, 0);
        if (v.s(0)) {
            setBackgroundDrawable(v.g(0));
        }
        if (v.s(1)) {
            setDivider(v.g(1));
        }
        v.w();
    }
}
