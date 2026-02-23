package com.google.android.exoplayer2.ui;

import P3.b;
import a4.Y;
import a4.b0;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends View implements SubtitleView.a {
    public final List a;
    public List c;
    public int d;
    public float e;
    public a4.c f;
    public float g;

    public a(Context context) {
        this(context, null);
    }

    public static P3.b b(P3.b bVar) {
        b.b p = bVar.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (bVar.g == 0) {
            p.h(1.0f - bVar.f, 0);
        } else {
            p.h((-bVar.f) - 1.0f, 1);
        }
        int i = bVar.h;
        if (i == 0) {
            p.i(2);
        } else if (i == 2) {
            p.i(0);
        }
        return p.a();
    }

    public void a(List list, a4.c cVar, float f, int i, float f2) {
        this.c = list;
        this.f = cVar;
        this.e = f;
        this.d = i;
        this.g = f2;
        while (this.a.size() < list.size()) {
            this.a.add(new Y(getContext()));
        }
        invalidate();
    }

    public void dispatchDraw(Canvas canvas) {
        List list = this.c;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float h = b0.h(this.d, this.e, height, i);
        if (h <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            P3.b bVar = (P3.b) list.get(i2);
            if (bVar.q != Integer.MIN_VALUE) {
                bVar = b(bVar);
            }
            P3.b bVar2 = bVar;
            int i3 = paddingBottom;
            ((Y) this.a.get(i2)).b(bVar2, this.f, h, b0.h(bVar2.o, bVar2.p, height, i), this.g, canvas, paddingLeft, paddingTop, width, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = width;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.c = Collections.emptyList();
        this.d = 0;
        this.e = 0.0533f;
        this.f = a4.c.g;
        this.g = 0.08f;
    }
}
