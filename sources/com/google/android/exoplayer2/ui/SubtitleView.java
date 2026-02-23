package com.google.android.exoplayer2.ui;

import P3.b;
import a4.b0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class SubtitleView extends FrameLayout {
    public List a;
    public a4.c c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public int i;
    public a j;
    public View k;

    public interface a {
        void a(List list, a4.c cVar, float f, int i, float f2);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Collections.emptyList();
        this.c = a4.c.g;
        this.d = 0;
        this.e = 0.0533f;
        this.f = 0.08f;
        this.g = true;
        this.h = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context);
        this.j = aVar;
        this.k = aVar;
        addView(aVar);
        this.i = 1;
    }

    private List getCuesWithStylingPreferencesApplied() {
        if (this.g && this.h) {
            return this.a;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            arrayList.add(a((P3.b) this.a.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (k0.a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private a4.c getUserCaptionStyle() {
        if (k0.a < 19 || isInEditMode()) {
            return a4.c.g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? a4.c.g : a4.c.a(captioningManager.getUserStyle());
    }

    private void setView(View view) {
        removeView(this.k);
        g gVar = this.k;
        if (gVar instanceof g) {
            gVar.g();
        }
        this.k = view;
        this.j = (a) view;
        addView(view);
    }

    public final P3.b a(P3.b bVar) {
        b.b b = bVar.b();
        if (!this.g) {
            b0.e(b);
        } else if (!this.h) {
            b0.f(b);
        }
        return b.a();
    }

    public void b(float f, boolean z) {
        c(z ? 1 : 0, f);
    }

    public final void c(int i, float f) {
        this.d = i;
        this.e = f;
        f();
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void f() {
        this.j.a(getCuesWithStylingPreferencesApplied(), this.c, this.e, this.d, this.f);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.h = z;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.g = z;
        f();
    }

    public void setBottomPaddingFraction(float f) {
        this.f = f;
        f();
    }

    public void setCues(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.a = list;
        f();
    }

    public void setFractionalTextSize(float f) {
        b(f, false);
    }

    public void setStyle(a4.c cVar) {
        this.c = cVar;
        f();
    }

    public void setViewType(int i) {
        View aVar;
        if (this.i == i) {
            return;
        }
        if (i == 1) {
            aVar = new com.google.android.exoplayer2.ui.a(getContext());
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            aVar = new g(getContext());
        }
        setView(aVar);
        this.i = i;
    }
}
