package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajd implements CompanionAdSlot {
    private int a;
    private int b;
    private ViewGroup c;
    private String d;
    private final List e = new ArrayList(1);

    public final List a() {
        return this.e;
    }

    public final void addClickListener(CompanionAdSlot.ClickListener clickListener) {
        this.e.add(clickListener);
    }

    public final void b(String str) {
        this.d = str;
    }

    public final ViewGroup getContainer() {
        return this.c;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.a;
    }

    public final boolean isFilled() {
        return this.c.findViewWithTag(this.d) != null;
    }

    public final void removeClickListener(CompanionAdSlot.ClickListener clickListener) {
        this.e.remove(clickListener);
    }

    public final void setContainer(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public final void setSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
