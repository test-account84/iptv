package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aeq {
    public final Object a;
    public final Object b;

    public aeq(Handler handler, no noVar) {
        this.b = handler;
        this.a = noVar;
    }

    public final void a(long j, cj cjVar) {
        if (cjVar.a() < 9) {
            return;
        }
        int e = cjVar.e();
        int e2 = cjVar.e();
        int i = cjVar.i();
        if (e == 434 && e2 == 1195456820 && i == 3) {
            fz.m(j, cjVar, (aae[]) this.b);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.List] */
    public final void b(zk zkVar, aet aetVar) {
        for (int i = 0; i < ((aae[]) this.b).length; i++) {
            aetVar.c();
            aae i2 = zkVar.i(aetVar.a(), 3);
            s sVar = (s) this.a.get(i);
            String str = sVar.l;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            af.v(z, "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            r rVar = new r();
            rVar.S(aetVar.b());
            rVar.ae(str);
            rVar.ag(sVar.d);
            rVar.V(sVar.c);
            rVar.F(sVar.D);
            rVar.T(sVar.n);
            i2.b(rVar.v());
            ((aae[]) this.b)[i] = i2;
        }
    }

    public final void c() {
        ((WebView) this.a).setVisibility(4);
    }

    public final void d() {
        if (((WebView) this.a).getParent() == null) {
            Object obj = this.b;
            ViewGroup viewGroup = (ViewGroup) obj;
            viewGroup.addView((View) this.a, new ViewGroup.LayoutParams(-1, -1));
        }
        ((WebView) this.a).setVisibility(0);
        ((ViewGroup) this.b).bringChildToFront((View) this.a);
    }

    public final ArrayList e() {
        return (ArrayList) this.a;
    }

    public final void f(String str) {
        ((ArrayList) this.a).add(str);
    }

    public final ly g() {
        return (ly) this.b;
    }

    public final String h() {
        return (String) this.b;
    }

    public final byte[] i() {
        return (byte[]) this.a;
    }

    public final int j(int i) {
        return ((q) this.b).a(i);
    }

    public final int k() {
        return ((q) this.b).b();
    }

    public final hv l(int i) {
        hv hvVar = (hv) ((SparseArray) this.a).get(i);
        af.s(hvVar);
        return hvVar;
    }

    public final boolean m(int i) {
        return ((q) this.b).c(i);
    }

    public final ku n(xd xdVar, lu luVar, ly lyVar, int i, int[] iArr, we weVar, int i2, long j, boolean z, List list, lq lqVar, dw dwVar, iw iwVar) {
        de a = ((df) this.a).a();
        if (dwVar != null) {
            a.f(dwVar);
        }
        return new lm(xdVar, luVar, lyVar, i, iArr, weVar, i2, a, j, z, list, lqVar, null);
    }

    public aeq(WebView webView, ViewGroup viewGroup) {
        this.a = webView;
        this.b = viewGroup;
    }

    public aeq(cx cxVar) {
        this.b = ut.a;
        this.a = cxVar;
    }

    public aeq(ly lyVar, String str, byte[] bArr) {
        this.a = new ArrayList();
        this.b = lyVar;
        f(str);
    }

    public aeq(q qVar, SparseArray sparseArray) {
        this.b = qVar;
        SparseArray sparseArray2 = new SparseArray(qVar.b());
        for (int i = 0; i < qVar.b(); i++) {
            int a = qVar.a(i);
            hv hvVar = (hv) sparseArray.get(a);
            af.s(hvVar);
            sparseArray2.append(a, hvVar);
        }
        this.a = sparseArray2;
    }

    public aeq(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    public aeq(List list) {
        this.a = list;
        this.b = new aae[list.size()];
    }

    public aeq(byte[] bArr, String str) {
        this.a = bArr;
        this.b = str;
    }
}
