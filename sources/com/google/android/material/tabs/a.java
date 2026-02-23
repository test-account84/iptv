package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import f5.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public static RectF a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.y() || !(view instanceof TabLayout.i)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.i) view, 24);
    }

    public static RectF b(TabLayout.i iVar, int i) {
        int contentWidth = iVar.getContentWidth();
        int contentHeight = iVar.getContentHeight();
        int b = (int) w.b(iVar.getContext(), i);
        if (contentWidth < b) {
            contentWidth = b;
        }
        int left = (iVar.getLeft() + iVar.getRight()) / 2;
        int top = (iVar.getTop() + iVar.getBottom()) / 2;
        int i2 = contentWidth / 2;
        return new RectF(left - i2, top - (contentHeight / 2), i2 + left, top + (left / 2));
    }

    public void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF a = a(tabLayout, view);
        drawable.setBounds((int) a.left, drawable.getBounds().top, (int) a.right, drawable.getBounds().bottom);
    }

    public void d(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF a = a(tabLayout, view);
        RectF a2 = a(tabLayout, view2);
        drawable.setBounds(S4.a.c((int) a.left, (int) a2.left, f), drawable.getBounds().top, S4.a.c((int) a.right, (int) a2.right, f), drawable.getBounds().bottom);
    }
}
