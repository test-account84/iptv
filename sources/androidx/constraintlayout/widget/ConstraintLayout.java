package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import x.e;
import x.f;
import x.g;
import y.b;
import z.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConstraintLayout extends ViewGroup {
    public SparseArray a;
    public ArrayList c;
    public f d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public androidx.constraintlayout.widget.c k;
    public z.a l;
    public int m;
    public HashMap n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public SparseArray u;
    public c v;
    public int w;
    public int x;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.b.values().length];
            a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        public float C;
        public int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public String V;
        public boolean W;
        public boolean X;
        public boolean Y;
        public boolean Z;
        public int a;
        public boolean a0;
        public int b;
        public boolean b0;
        public float c;
        public boolean c0;
        public int d;
        public int d0;
        public int e;
        public int e0;
        public int f;
        public int f0;
        public int g;
        public int g0;
        public int h;
        public int h0;
        public int i;
        public int i0;
        public int j;
        public float j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public float m0;
        public int n;
        public e n0;
        public float o;
        public boolean o0;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        public static class a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(d.K1, 8);
                sparseIntArray.append(d.L1, 9);
                sparseIntArray.append(d.N1, 10);
                sparseIntArray.append(d.O1, 11);
                sparseIntArray.append(d.U1, 12);
                sparseIntArray.append(d.T1, 13);
                sparseIntArray.append(d.s1, 14);
                sparseIntArray.append(d.r1, 15);
                sparseIntArray.append(d.p1, 16);
                sparseIntArray.append(d.t1, 2);
                sparseIntArray.append(d.v1, 3);
                sparseIntArray.append(d.u1, 4);
                sparseIntArray.append(d.c2, 49);
                sparseIntArray.append(d.d2, 50);
                sparseIntArray.append(d.z1, 5);
                sparseIntArray.append(d.A1, 6);
                sparseIntArray.append(d.B1, 7);
                sparseIntArray.append(d.b1, 1);
                sparseIntArray.append(d.P1, 17);
                sparseIntArray.append(d.Q1, 18);
                sparseIntArray.append(d.y1, 19);
                sparseIntArray.append(d.x1, 20);
                sparseIntArray.append(d.g2, 21);
                sparseIntArray.append(d.j2, 22);
                sparseIntArray.append(d.h2, 23);
                sparseIntArray.append(d.e2, 24);
                sparseIntArray.append(d.i2, 25);
                sparseIntArray.append(d.f2, 26);
                sparseIntArray.append(d.G1, 29);
                sparseIntArray.append(d.V1, 30);
                sparseIntArray.append(d.w1, 44);
                sparseIntArray.append(d.I1, 45);
                sparseIntArray.append(d.X1, 46);
                sparseIntArray.append(d.H1, 47);
                sparseIntArray.append(d.W1, 48);
                sparseIntArray.append(d.n1, 27);
                sparseIntArray.append(d.m1, 28);
                sparseIntArray.append(d.Y1, 31);
                sparseIntArray.append(d.C1, 32);
                sparseIntArray.append(d.a2, 33);
                sparseIntArray.append(d.Z1, 34);
                sparseIntArray.append(d.b2, 35);
                sparseIntArray.append(d.E1, 36);
                sparseIntArray.append(d.D1, 37);
                sparseIntArray.append(d.F1, 38);
                sparseIntArray.append(d.J1, 39);
                sparseIntArray.append(d.S1, 40);
                sparseIntArray.append(d.M1, 41);
                sparseIntArray.append(d.q1, 42);
                sparseIntArray.append(d.o1, 43);
                sparseIntArray.append(d.R1, 51);
            }
        }

        public b(int i, int i2) {
            super(i, i2);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new e();
            this.o0 = false;
        }

        public void a() {
            this.Z = false;
            this.W = true;
            this.X = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.W = false;
                if (i == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.X = false;
                if (i2 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.c == -1.0f && this.a == -1 && this.b == -1) {
                return;
            }
            this.Z = true;
            this.W = true;
            this.X = true;
            if (!(this.n0 instanceof g)) {
                this.n0 = new g();
            }
            ((g) this.n0).N0(this.S);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 249
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(Context context, AttributeSet attributeSet) {
            String str;
            int i;
            float parseFloat;
            super(context, attributeSet);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new e();
            this.o0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = a.a.get(index);
                switch (i3) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        continue;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        continue;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f;
                        if (f < 0.0f) {
                            this.o = (360.0f - f) % 360.0f;
                        } else {
                            continue;
                        }
                    case 5:
                        this.a = obtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        continue;
                    case 6:
                        this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        continue;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        continue;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        continue;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        continue;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        continue;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        continue;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        continue;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        continue;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        continue;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        continue;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        continue;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        continue;
                    case 31:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i4;
                        if (i4 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                            break;
                        }
                    case 32:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i5;
                        if (i5 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        continue;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        continue;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i);
                                        if (substring2.length() > 0) {
                                            parseFloat = Float.parseFloat(substring2);
                                            this.C = parseFloat;
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                float parseFloat3 = Float.parseFloat(substring4);
                                                if (parseFloat2 > 0.0f && parseFloat3 > 0.0f) {
                                                    parseFloat = this.D == 1 ? Math.abs(parseFloat3 / parseFloat2) : Math.abs(parseFloat2 / parseFloat3);
                                                    this.C = parseFloat;
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                            case 51:
                                this.V = obtainStyledAttributes.getString(index);
                                continue;
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new e();
            this.o0 = false;
        }
    }

    public class c implements b.b {
        public ConstraintLayout a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public c(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        public final void a() {
            int childCount = this.a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.a.getChildAt(i);
            }
            int size = ConstraintLayout.b(this.a).size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((androidx.constraintlayout.widget.b) ConstraintLayout.b(this.a).get(i2)).h(this.a);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x020d  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x01ee  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x019c  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x016b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0223  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0231  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0225  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(x.e r20, y.b.a r21) {
            /*
                Method dump skipped, instructions count: 594
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c.b(x.e, y.b$a):void");
        }

        public void c(int i, int i2, int i3, int i4, int i5, int i6) {
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i;
            this.g = i2;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new f();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 263;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
        this.u = new SparseArray();
        this.v = new c(this);
        this.w = 0;
        this.x = 0;
        j(attributeSet, 0, 0);
    }

    public static /* synthetic */ ArrayList b(ConstraintLayout constraintLayout) {
        return constraintLayout.c;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return max2 > 0 ? max2 : max;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(boolean r19, android.view.View r20, x.e r21, androidx.constraintlayout.widget.ConstraintLayout.b r22, android.util.SparseArray r23) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c(boolean, android.view.View, x.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((androidx.constraintlayout.widget.b) this.c.get(i)).i(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object f(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap hashMap = this.n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public final e g(int i) {
        if (i == 0) {
            return this.d;
        }
        View view = (View) this.a.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        return view.getLayoutParams().n0;
    }

    public int getMaxHeight() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.g;
    }

    public int getMinHeight() {
        return this.f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.d.R0();
    }

    public View h(int i) {
        return (View) this.a.get(i);
    }

    public final e i(View view) {
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        return view.getLayoutParams().n0;
    }

    public final void j(AttributeSet attributeSet, int i, int i2) {
        this.d.Z(this);
        this.d.a1(this.v);
        this.a.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a1, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == d.e1) {
                    this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == d.f1) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == d.c1) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == d.d1) {
                    this.h = obtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == d.k2) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == d.l1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == d.j1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.k = cVar;
                        cVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.d.b1(this.j);
    }

    public boolean k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public final void l() {
        this.i = true;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
    }

    public void m(int i) {
        this.l = new z.a(getContext(), this, i);
    }

    public void n(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        c cVar = this.v;
        int i5 = cVar.e;
        int resolveSizeAndState = View.resolveSizeAndState(i3 + cVar.d, i, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i4 + i5, i2, 0) & 16777215;
        int min = Math.min(this.g, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.h, resolveSizeAndState2);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.o = min;
        this.p = min2;
    }

    public void o(f fVar, int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i4 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.v.c(i2, i3, max, max2, paddingWidth, i4);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        int max5 = (max3 > 0 || max4 > 0) ? k() ? max4 : max3 : Math.max(0, getPaddingLeft());
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        r(fVar, mode, i5, mode2, i6);
        fVar.X0(i, mode, i5, mode2, i6, this.o, this.p, max5, max);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            b layoutParams = childAt.getLayoutParams();
            e eVar = layoutParams.n0;
            if ((childAt.getVisibility() != 8 || layoutParams.Z || layoutParams.a0 || layoutParams.c0 || isInEditMode) && !layoutParams.b0) {
                int O = eVar.O();
                int P = eVar.P();
                childAt.layout(O, P, eVar.N() + O, eVar.t() + P);
            }
        }
        int size = this.c.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((androidx.constraintlayout.widget.b) this.c.get(i6)).g(this);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        this.w = i;
        this.x = i2;
        this.d.c1(k());
        if (this.i) {
            this.i = false;
            if (s()) {
                this.d.e1();
            }
        }
        o(this.d, this.j, i, i2);
        n(i, i2, this.d.N(), this.d.t(), this.d.W0(), this.d.U0());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e i = i(view);
        if ((view instanceof Guideline) && !(i instanceof g)) {
            b layoutParams = view.getLayoutParams();
            g gVar = new g();
            layoutParams.n0 = gVar;
            layoutParams.Z = true;
            gVar.N0(layoutParams.S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) view;
            bVar.k();
            view.getLayoutParams().a0 = true;
            if (!this.c.contains(bVar)) {
                this.c.add(bVar);
            }
        }
        this.a.put(view.getId(), view);
        this.i = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.a.remove(view.getId());
        this.d.H0(i(view));
        this.c.remove(view);
        this.i = true;
    }

    public final void p() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e i2 = i(getChildAt(i));
            if (i2 != null) {
                i2.W();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    g(childAt.getId()).a0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.m != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                getChildAt(i4).getId();
            }
        }
        androidx.constraintlayout.widget.c cVar = this.k;
        if (cVar != null) {
            cVar.d(this, true);
        }
        this.d.I0();
        int size = this.c.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                ((androidx.constraintlayout.widget.b) this.c.get(i5)).j(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6);
        }
        this.u.clear();
        this.u.put(0, this.d);
        this.u.put(getId(), this.d);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            this.u.put(childAt2.getId(), i(childAt2));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt3 = getChildAt(i8);
            e i9 = i(childAt3);
            if (i9 != null) {
                b layoutParams = childAt3.getLayoutParams();
                this.d.b(i9);
                c(isInEditMode, childAt3, i9, layoutParams, this.u);
            }
        }
    }

    public void q(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.n.put(str, num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[PHI: r2
      0x0047: PHI (r2v2 x.e$b) = (r2v1 x.e$b), (r2v4 x.e$b) binds: [B:24:0x0050, B:21:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0027 A[PHI: r9
      0x0027: PHI (r9v2 x.e$b) = (r9v1 x.e$b), (r9v8 x.e$b) binds: [B:30:0x0030, B:27:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r(x.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.v
            int r1 = r0.e
            int r0 = r0.d
            x.e$b r2 = x.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = 0
            goto L33
        L1a:
            int r9 = r7.g
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L33
        L23:
            x.e$b r9 = x.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
        L27:
            int r10 = r7.e
            int r10 = java.lang.Math.max(r6, r10)
            goto L33
        L2e:
            x.e$b r9 = x.e.b.WRAP_CONTENT
            if (r3 != 0) goto L33
            goto L27
        L33:
            if (r11 == r5) goto L4e
            if (r11 == 0) goto L43
            if (r11 == r4) goto L3b
        L39:
            r12 = 0
            goto L53
        L3b:
            int r11 = r7.h
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L53
        L43:
            x.e$b r2 = x.e.b.WRAP_CONTENT
            if (r3 != 0) goto L39
        L47:
            int r11 = r7.f
            int r12 = java.lang.Math.max(r6, r11)
            goto L53
        L4e:
            x.e$b r2 = x.e.b.WRAP_CONTENT
            if (r3 != 0) goto L53
            goto L47
        L53:
            int r11 = r8.N()
            if (r10 != r11) goto L5f
            int r11 = r8.t()
            if (r12 == r11) goto L62
        L5f:
            r8.T0()
        L62:
            r8.B0(r6)
            r8.C0(r6)
            int r11 = r7.g
            int r11 = r11 - r0
            r8.o0(r11)
            int r11 = r7.h
            int r11 = r11 - r1
            r8.n0(r11)
            r8.q0(r6)
            r8.p0(r6)
            r8.i0(r9)
            r8.A0(r10)
            r8.w0(r2)
            r8.e0(r12)
            int r9 = r7.e
            int r9 = r9 - r0
            r8.q0(r9)
            int r9 = r7.f
            int r9 = r9 - r1
            r8.p0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.r(x.f, int, int, int, int):void");
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public final boolean s() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            p();
        }
        return z;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.k = cVar;
    }

    public void setId(int i) {
        this.a.remove(getId());
        super.setId(i);
        this.a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.e) {
            return;
        }
        this.e = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(z.b bVar) {
        z.a aVar = this.l;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void setOptimizationLevel(int i) {
        this.j = i;
        this.d.b1(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new f();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 263;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
        this.u = new SparseArray();
        this.v = new c(this);
        this.w = 0;
        this.x = 0;
        j(attributeSet, i, 0);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }
}
