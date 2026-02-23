package com.google.android.exoplayer2.ui;

import a4.b0;
import a4.j;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends FrameLayout implements SubtitleView.a {
    public final com.google.android.exoplayer2.ui.a a;
    public final WebView c;
    public List d;
    public a4.c e;
    public float f;
    public int g;
    public float h;

    public class a extends WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(Context context) {
        this(context, null);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = b.a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    public static String d(a4.c cVar) {
        int i = cVar.d;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unset" : k0.D("-0.05em -0.05em 0.15em %s", j.b(cVar.e)) : k0.D("0.06em 0.08em 0.15em %s", j.b(cVar.e)) : k0.D("0.1em 0.12em 0.15em %s", j.b(cVar.e)) : k0.D("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", j.b(cVar.e));
    }

    public static String f(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public static String h(P3.b bVar) {
        float f = bVar.r;
        if (f == 0.0f) {
            return "";
        }
        int i = bVar.q;
        return k0.D("%s(%.2fdeg)", (i == 2 || i == 1) ? "skewY" : "skewX", Float.valueOf(f));
    }

    public void a(List list, a4.c cVar, float f, int i, float f2) {
        this.e = cVar;
        this.f = f;
        this.g = i;
        this.h = f2;
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            P3.b bVar = (P3.b) list.get(i2);
            if (bVar.e != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.d.isEmpty() || !arrayList2.isEmpty()) {
            this.d = arrayList2;
            i();
        }
        this.a.a(arrayList, cVar, f, i, f2);
        invalidate();
    }

    public final String e(int i, float f) {
        float h = b0.h(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return h == -3.4028235E38f ? "unset" : k0.D("%.2fpx", Float.valueOf(h / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.c.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.g.i():void");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.d.isEmpty()) {
            return;
        }
        i();
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = Collections.emptyList();
        this.e = a4.c.g;
        this.f = 0.0533f;
        this.g = 0;
        this.h = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.c = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }
}
