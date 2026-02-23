package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import g4.b;
import g4.c;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public final g4.a a;
    public boolean[] b;
    public int[] c;
    public long[] d;
    public long[] e;

    public static class a {
        public List a;
        public int b;

        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    public a(g4.a aVar) {
        this.a = aVar;
    }

    public final int A(boolean z) {
        return z ? this.a.b() : this.a.c();
    }

    public final int B(boolean z) {
        return z ? this.a.c() : this.a.b();
    }

    public final int C(boolean z) {
        return z ? this.a.n() : this.a.w();
    }

    public final int D(boolean z) {
        return z ? this.a.w() : this.a.n();
    }

    public final int E(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int F(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean G(int i, int i2, c cVar) {
        return i == i2 - 1 && cVar.c() != 0;
    }

    public final boolean H(View view, int i, int i2, int i3, int i4, b bVar, int i5, int i6, int i7) {
        if (this.a.r() == 0) {
            return false;
        }
        if (bVar.s()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int g = this.a.g();
        if (g != -1 && g <= i7 + 1) {
            return false;
        }
        int v = this.a.v(view, i5, i6);
        if (v > 0) {
            i4 += v;
        }
        return i2 < i3 + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(android.view.View r6, g4.c r7, int r8, int r9, int r10, int r11) {
        /*
            r5 = this;
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            g4.b r0 = (g4.b) r0
            g4.a r1 = r5.a
            int r1 = r1.t()
            int r2 = r0.i()
            r3 = -1
            if (r2 == r3) goto L17
            int r1 = r0.i()
        L17:
            int r2 = r7.g
            r3 = 2
            if (r1 == 0) goto Lb3
            r4 = 1
            if (r1 == r4) goto L80
            if (r1 == r3) goto L5c
            r2 = 3
            if (r1 == r2) goto L29
            r7 = 4
            if (r1 == r7) goto Lb3
            goto Lcb
        L29:
            g4.a r1 = r5.a
            int r1 = r1.r()
            int r7 = r7.l
            if (r1 == r3) goto L47
            int r1 = r6.getBaseline()
            int r7 = r7 - r1
            int r0 = r0.n()
            int r7 = java.lang.Math.max(r7, r0)
            int r9 = r9 + r7
        L41:
            int r11 = r11 + r7
        L42:
            r6.layout(r8, r9, r10, r11)
            goto Lcb
        L47:
            int r1 = r6.getMeasuredHeight()
            int r7 = r7 - r1
            int r1 = r6.getBaseline()
            int r7 = r7 + r1
            int r0 = r0.y()
            int r7 = java.lang.Math.max(r7, r0)
            int r9 = r9 - r7
        L5a:
            int r11 = r11 - r7
            goto L42
        L5c:
            int r7 = r6.getMeasuredHeight()
            int r2 = r2 - r7
            int r7 = r0.n()
            int r2 = r2 + r7
            int r7 = r0.y()
            int r2 = r2 - r7
            int r2 = r2 / r3
            g4.a r7 = r5.a
            int r7 = r7.r()
            if (r7 == r3) goto L7e
            int r9 = r9 + r2
        L75:
            int r7 = r6.getMeasuredHeight()
            int r7 = r7 + r9
            r6.layout(r8, r9, r10, r7)
            goto Lcb
        L7e:
            int r9 = r9 - r2
            goto L75
        L80:
            g4.a r7 = r5.a
            int r7 = r7.r()
            if (r7 == r3) goto L9d
            int r9 = r9 + r2
            int r7 = r6.getMeasuredHeight()
            int r7 = r9 - r7
            int r11 = r0.y()
            int r7 = r7 - r11
            int r11 = r0.y()
            int r9 = r9 - r11
            r6.layout(r8, r7, r10, r9)
            goto Lcb
        L9d:
            int r9 = r9 - r2
            int r7 = r6.getMeasuredHeight()
            int r9 = r9 + r7
            int r7 = r0.n()
            int r9 = r9 + r7
            int r11 = r11 - r2
            int r7 = r6.getMeasuredHeight()
            int r11 = r11 + r7
        Lae:
            int r7 = r0.n()
            goto L41
        Lb3:
            g4.a r7 = r5.a
            int r7 = r7.r()
            if (r7 == r3) goto Lc1
            int r7 = r0.n()
            int r9 = r9 + r7
            goto Lae
        Lc1:
            int r7 = r0.y()
            int r9 = r9 - r7
            int r7 = r0.y()
            goto L5a
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.a.I(android.view.View, g4.c, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J(android.view.View r5, g4.c r6, boolean r7, int r8, int r9, int r10, int r11) {
        /*
            r4 = this;
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            g4.b r0 = (g4.b) r0
            g4.a r1 = r4.a
            int r1 = r1.t()
            int r2 = r0.i()
            r3 = -1
            if (r2 == r3) goto L17
            int r1 = r0.i()
        L17:
            int r6 = r6.g
            if (r1 == 0) goto L77
            r2 = 1
            if (r1 == r2) goto L49
            r2 = 2
            if (r1 == r2) goto L28
            r6 = 3
            if (r1 == r6) goto L77
            r6 = 4
            if (r1 == r6) goto L77
            goto L85
        L28:
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r1 = r5.getMeasuredWidth()
            int r6 = r6 - r1
            int r1 = P.s.b(r0)
            int r6 = r6 + r1
            int r0 = P.s.a(r0)
            int r6 = r6 - r0
            int r6 = r6 / r2
            if (r7 != 0) goto L46
            int r8 = r8 + r6
        L41:
            int r10 = r10 + r6
        L42:
            r5.layout(r8, r9, r10, r11)
            goto L85
        L46:
            int r8 = r8 - r6
        L47:
            int r10 = r10 - r6
            goto L42
        L49:
            if (r7 != 0) goto L61
            int r8 = r8 + r6
            int r7 = r5.getMeasuredWidth()
            int r8 = r8 - r7
            int r7 = r0.D()
            int r8 = r8 - r7
            int r10 = r10 + r6
            int r6 = r5.getMeasuredWidth()
            int r10 = r10 - r6
        L5c:
            int r6 = r0.D()
            goto L47
        L61:
            int r8 = r8 - r6
            int r7 = r5.getMeasuredWidth()
            int r8 = r8 + r7
            int r7 = r0.z()
            int r8 = r8 + r7
            int r10 = r10 - r6
            int r6 = r5.getMeasuredWidth()
            int r10 = r10 + r6
        L72:
            int r6 = r0.z()
            goto L41
        L77:
            if (r7 != 0) goto L7f
            int r6 = r0.z()
            int r8 = r8 + r6
            goto L72
        L7f:
            int r6 = r0.D()
            int r8 = r8 - r6
            goto L5c
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.a.J(android.view.View, g4.c, boolean, int, int, int, int):void");
    }

    public long K(int i, int i2) {
        return (i & 4294967295L) | (i2 << 32);
    }

    public final void L(int i, int i2, c cVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8 = cVar.e;
        float f = cVar.k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i8) {
            return;
        }
        float f3 = (i8 - i3) / f;
        cVar.e = i4 + cVar.f;
        if (!z) {
            cVar.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < cVar.h) {
            int i11 = cVar.o + i9;
            View s = this.a.s(i11);
            if (s == null || s.getVisibility() == 8) {
                i5 = i8;
                i6 = i9;
            } else {
                b bVar = (b) s.getLayoutParams();
                int f5 = this.a.f();
                if (f5 == 0 || f5 == 1) {
                    i5 = i8;
                    int i12 = i9;
                    int measuredWidth = s.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i11]);
                    }
                    int measuredHeight = s.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i11]);
                    }
                    if (this.b[i11] || bVar.j() <= 0.0f) {
                        i6 = i12;
                    } else {
                        float j = measuredWidth - (bVar.j() * f3);
                        i6 = i12;
                        if (i6 == cVar.h - 1) {
                            j += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(j);
                        if (round < bVar.l()) {
                            round = bVar.l();
                            this.b[i11] = true;
                            cVar.k -= bVar.j();
                            z2 = true;
                        } else {
                            f4 += j - round;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int s2 = s(i2, bVar, cVar.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        s.measure(makeMeasureSpec, s2);
                        int measuredWidth2 = s.getMeasuredWidth();
                        int measuredHeight2 = s.getMeasuredHeight();
                        Q(i11, makeMeasureSpec, s2, s);
                        this.a.u(i11, s);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i10, measuredHeight + bVar.n() + bVar.y() + this.a.p(s));
                    cVar.e += measuredWidth + bVar.z() + bVar.D();
                    i7 = max;
                } else {
                    int measuredHeight3 = s.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i11]);
                    }
                    int measuredWidth3 = s.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i11]);
                    }
                    if (this.b[i11] || bVar.j() <= f2) {
                        i5 = i8;
                        i6 = i9;
                    } else {
                        float j2 = measuredHeight3 - (bVar.j() * f3);
                        if (i9 == cVar.h - 1) {
                            j2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(j2);
                        if (round2 < bVar.E()) {
                            round2 = bVar.E();
                            this.b[i11] = true;
                            cVar.k -= bVar.j();
                            i5 = i8;
                            i6 = i9;
                            z2 = true;
                        } else {
                            f4 += j2 - round2;
                            i5 = i8;
                            i6 = i9;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int t = t(i, bVar, cVar.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        s.measure(t, makeMeasureSpec2);
                        measuredWidth3 = s.getMeasuredWidth();
                        int measuredHeight4 = s.getMeasuredHeight();
                        Q(i11, t, makeMeasureSpec2, s);
                        this.a.u(i11, s);
                        measuredHeight3 = measuredHeight4;
                    }
                    i7 = Math.max(i10, measuredWidth3 + bVar.z() + bVar.D() + this.a.p(s));
                    cVar.e += measuredHeight3 + bVar.n() + bVar.y();
                }
                cVar.g = Math.max(cVar.g, i7);
                i10 = i7;
            }
            i9 = i6 + 1;
            i8 = i5;
            f2 = 0.0f;
        }
        int i13 = i8;
        if (!z2 || i13 == cVar.e) {
            return;
        }
        L(i, i2, cVar, i3, i4, true);
    }

    public final void M(View view, int i, int i2) {
        b layoutParams = view.getLayoutParams();
        int min = Math.min(Math.max(((i - layoutParams.z()) - layoutParams.D()) - this.a.p(view), layoutParams.l()), layoutParams.u());
        long[] jArr = this.e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? q(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Q(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.u(i2, view);
    }

    public final void N(View view, int i, int i2) {
        b layoutParams = view.getLayoutParams();
        int min = Math.min(Math.max(((i - layoutParams.n()) - layoutParams.y()) - this.a.p(view), layoutParams.E()), layoutParams.F());
        long[] jArr = this.e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? r(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Q(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.u(i2, view);
    }

    public void O() {
        P(0);
    }

    public void P(int i) {
        View s;
        if (i >= this.a.d()) {
            return;
        }
        int f = this.a.f();
        if (this.a.t() != 4) {
            for (c cVar : this.a.l()) {
                for (Integer num : cVar.n) {
                    View s2 = this.a.s(num.intValue());
                    if (f == 0 || f == 1) {
                        N(s2, cVar.g, num.intValue());
                    } else {
                        if (f != 2 && f != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + f);
                        }
                        M(s2, cVar.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.c;
        List l = this.a.l();
        int size = l.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            c cVar2 = (c) l.get(i2);
            int i3 = cVar2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = cVar2.o + i4;
                if (i4 < this.a.d() && (s = this.a.s(i5)) != null && s.getVisibility() != 8) {
                    b layoutParams = s.getLayoutParams();
                    if (layoutParams.i() == -1 || layoutParams.i() == 4) {
                        if (f == 0 || f == 1) {
                            N(s, cVar2.g, i5);
                        } else {
                            if (f != 2 && f != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + f);
                            }
                            M(s, cVar2.g, i5);
                        }
                    }
                }
            }
        }
    }

    public final void Q(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = K(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = K(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List list, c cVar, int i, int i2) {
        cVar.m = i2;
        this.a.a(cVar);
        cVar.p = i;
        list.add(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.google.android.flexbox.a.a r32, int r33, int r34, int r35, int r36, int r37, java.util.List r38) {
        /*
            Method dump skipped, instructions count: 850
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.a.b(com.google.android.flexbox.a$a, int, int, int, int, int, java.util.List):void");
    }

    public void c(a aVar, int i, int i2, int i3, int i4, List list) {
        b(aVar, i, i2, i3, i4, -1, list);
    }

    public void d(a aVar, int i, int i2, int i3, int i4, List list) {
        b(aVar, i, i2, i3, 0, i4, list);
    }

    public void e(a aVar, int i, int i2, int i3, int i4, List list) {
        b(aVar, i2, i, i3, i4, -1, list);
    }

    public void f(a aVar, int i, int i2, int i3, int i4, List list) {
        b(aVar, i2, i, i3, 0, i4, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            g4.b r0 = (g4.b) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.l()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.l()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.u()
            if (r1 <= r3) goto L26
            int r1 = r0.u()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.E()
            if (r2 >= r5) goto L32
            int r2 = r0.E()
            goto L3e
        L32:
            int r5 = r0.F()
            if (r2 <= r5) goto L3d
            int r2 = r0.F()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Q(r8, r1, r0, r7)
            g4.a r0 = r6.a
            r0.u(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.a.g(android.view.View, int):void");
    }

    public void h(List list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        if (list.size() > i2) {
            list.subList(i2, list.size()).clear();
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public void i(int i, int i2) {
        j(i, i2, 0);
    }

    public void j(int i, int i2, int i3) {
        int size;
        int o;
        int k;
        k(this.a.d());
        if (i3 >= this.a.d()) {
            return;
        }
        int f = this.a.f();
        int f2 = this.a.f();
        if (f2 == 0 || f2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int h = this.a.h();
            if (mode != 1073741824) {
                size = Math.min(h, size);
            }
            o = this.a.o();
            k = this.a.k();
        } else {
            if (f2 != 2 && f2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + f);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.a.h();
            }
            o = this.a.n();
            k = this.a.b();
        }
        int i4 = o + k;
        int[] iArr = this.c;
        List l = this.a.l();
        int size2 = l.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            c cVar = (c) l.get(i5);
            int i6 = cVar.e;
            if (i6 < size && cVar.q) {
                p(i, i2, cVar, size, i4, false);
            } else if (i6 > size && cVar.r) {
                L(i, i2, cVar, size, i4, false);
            }
        }
    }

    public final void k(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            this.b = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.b = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void l(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            this.c = new int[Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.c = Arrays.copyOf(this.c, Math.max(iArr.length * 2, i));
        }
    }

    public void m(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            this.d = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.d = Arrays.copyOf(this.d, Math.max(jArr.length * 2, i));
        }
    }

    public void n(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            this.e = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.e = Arrays.copyOf(this.e, Math.max(jArr.length * 2, i));
        }
    }

    public final void o(CompoundButton compoundButton) {
        b layoutParams = compoundButton.getLayoutParams();
        int l = layoutParams.l();
        int E = layoutParams.E();
        Drawable a2 = T.c.a(compoundButton);
        int minimumWidth = a2 == null ? 0 : a2.getMinimumWidth();
        int minimumHeight = a2 != null ? a2.getMinimumHeight() : 0;
        if (l == -1) {
            l = minimumWidth;
        }
        layoutParams.setMinWidth(l);
        if (E == -1) {
            E = minimumHeight;
        }
        layoutParams.o(E);
    }

    public final void p(int i, int i2, c cVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        double d;
        int i8;
        double d2;
        float f = cVar.j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = cVar.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        cVar.e = i4 + cVar.f;
        if (!z) {
            cVar.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < cVar.h) {
            int i11 = cVar.o + i9;
            View s = this.a.s(i11);
            if (s == null || s.getVisibility() == 8) {
                i6 = i5;
            } else {
                b bVar = (b) s.getLayoutParams();
                int f5 = this.a.f();
                if (f5 == 0 || f5 == 1) {
                    int i12 = i5;
                    int measuredWidth = s.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i11]);
                    }
                    int measuredHeight = s.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    i6 = i12;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i11]);
                    }
                    if (!this.b[i11] && bVar.p() > 0.0f) {
                        float p = measuredWidth + (bVar.p() * f3);
                        if (i9 == cVar.h - 1) {
                            p += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(p);
                        if (round > bVar.u()) {
                            round = bVar.u();
                            this.b[i11] = true;
                            cVar.j -= bVar.p();
                            z2 = true;
                        } else {
                            f4 += p - round;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                round++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                round--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int s2 = s(i2, bVar, cVar.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        s.measure(makeMeasureSpec, s2);
                        int measuredWidth2 = s.getMeasuredWidth();
                        int measuredHeight2 = s.getMeasuredHeight();
                        Q(i11, makeMeasureSpec, s2, s);
                        this.a.u(i11, s);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i10, measuredHeight + bVar.n() + bVar.y() + this.a.p(s));
                    cVar.e += measuredWidth + bVar.z() + bVar.D();
                    i7 = max;
                } else {
                    int measuredHeight3 = s.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i11]);
                    }
                    int measuredWidth3 = s.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i11]);
                    }
                    if (this.b[i11] || bVar.p() <= f2) {
                        i8 = i5;
                    } else {
                        float p2 = measuredHeight3 + (bVar.p() * f3);
                        if (i9 == cVar.h - 1) {
                            p2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(p2);
                        if (round2 > bVar.F()) {
                            round2 = bVar.F();
                            this.b[i11] = true;
                            cVar.j -= bVar.p();
                            i8 = i5;
                            z2 = true;
                        } else {
                            f4 += p2 - round2;
                            i8 = i5;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                round2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int t = t(i, bVar, cVar.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        s.measure(t, makeMeasureSpec2);
                        measuredWidth3 = s.getMeasuredWidth();
                        int measuredHeight4 = s.getMeasuredHeight();
                        Q(i11, t, makeMeasureSpec2, s);
                        this.a.u(i11, s);
                        measuredHeight3 = measuredHeight4;
                    }
                    i7 = Math.max(i10, measuredWidth3 + bVar.z() + bVar.D() + this.a.p(s));
                    cVar.e += measuredHeight3 + bVar.n() + bVar.y();
                    i6 = i8;
                }
                cVar.g = Math.max(cVar.g, i7);
                i10 = i7;
            }
            i9++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i13 = i5;
        if (!z2 || i13 == cVar.e) {
            return;
        }
        p(i, i2, cVar, i3, i4, true);
    }

    public int q(long j) {
        return (int) (j >> 32);
    }

    public int r(long j) {
        return (int) j;
    }

    public final int s(int i, b bVar, int i2) {
        int E;
        g4.a aVar = this.a;
        int m = aVar.m(i, aVar.n() + this.a.b() + bVar.n() + bVar.y() + i2, bVar.getHeight());
        int size = View.MeasureSpec.getSize(m);
        if (size > bVar.F()) {
            E = bVar.F();
        } else {
            if (size >= bVar.E()) {
                return m;
            }
            E = bVar.E();
        }
        return View.MeasureSpec.makeMeasureSpec(E, View.MeasureSpec.getMode(m));
    }

    public final int t(int i, b bVar, int i2) {
        int l;
        g4.a aVar = this.a;
        int i3 = aVar.i(i, aVar.o() + this.a.k() + bVar.z() + bVar.D() + i2, bVar.getWidth());
        int size = View.MeasureSpec.getSize(i3);
        if (size > bVar.u()) {
            l = bVar.u();
        } else {
            if (size >= bVar.l()) {
                return i3;
            }
            l = bVar.l();
        }
        return View.MeasureSpec.makeMeasureSpec(l, View.MeasureSpec.getMode(i3));
    }

    public final int u(b bVar, boolean z) {
        return z ? bVar.y() : bVar.D();
    }

    public final int v(b bVar, boolean z) {
        return z ? bVar.D() : bVar.y();
    }

    public final int w(b bVar, boolean z) {
        return z ? bVar.n() : bVar.z();
    }

    public final int x(b bVar, boolean z) {
        return z ? bVar.z() : bVar.n();
    }

    public final int y(b bVar, boolean z) {
        return z ? bVar.getHeight() : bVar.getWidth();
    }

    public final int z(b bVar, boolean z) {
        return z ? bVar.getWidth() : bVar.getHeight();
    }
}
