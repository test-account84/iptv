package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public static final int[] d = {0, 4, 8};
    public static SparseIntArray e;
    public HashMap a = new HashMap();
    public boolean b = true;
    public HashMap c = new HashMap();

    public static class a {
        public int a;
        public final d b = new d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap f = new HashMap();

        public static /* synthetic */ void a(a aVar, int i, ConstraintLayout.b bVar) {
            aVar.d(i, bVar);
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.d;
            bVar.d = bVar2.h;
            bVar.e = bVar2.i;
            bVar.f = bVar2.j;
            bVar.g = bVar2.k;
            bVar.h = bVar2.l;
            bVar.i = bVar2.m;
            bVar.j = bVar2.n;
            bVar.k = bVar2.o;
            bVar.l = bVar2.p;
            bVar.p = bVar2.q;
            bVar.q = bVar2.r;
            bVar.r = bVar2.s;
            bVar.s = bVar2.t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.G;
            bVar.x = bVar2.O;
            bVar.y = bVar2.N;
            bVar.u = bVar2.K;
            bVar.w = bVar2.M;
            bVar.z = bVar2.u;
            bVar.A = bVar2.v;
            bVar.m = bVar2.x;
            bVar.n = bVar2.y;
            bVar.o = bVar2.z;
            bVar.B = bVar2.w;
            bVar.Q = bVar2.A;
            bVar.R = bVar2.B;
            bVar.F = bVar2.P;
            bVar.E = bVar2.Q;
            bVar.H = bVar2.S;
            bVar.G = bVar2.R;
            bVar.T = bVar2.h0;
            bVar.U = bVar2.i0;
            bVar.I = bVar2.T;
            bVar.J = bVar2.U;
            bVar.M = bVar2.V;
            bVar.N = bVar2.W;
            bVar.K = bVar2.X;
            bVar.L = bVar2.Y;
            bVar.O = bVar2.Z;
            bVar.P = bVar2.a0;
            bVar.S = bVar2.C;
            bVar.c = bVar2.g;
            bVar.a = bVar2.e;
            bVar.b = bVar2.f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.d;
            String str = bVar2.g0;
            if (str != null) {
                bVar.V = str;
            }
            bVar.setMarginStart(bVar2.I);
            bVar.setMarginEnd(this.d.H);
            bVar.a();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.d.a(this.d);
            aVar.c.a(this.c);
            aVar.b.a(this.b);
            aVar.e.a(this.e);
            aVar.a = this.a;
            return aVar;
        }

        public final void d(int i, ConstraintLayout.b bVar) {
            this.a = i;
            b bVar2 = this.d;
            bVar2.h = bVar.d;
            bVar2.i = bVar.e;
            bVar2.j = bVar.f;
            bVar2.k = bVar.g;
            bVar2.l = bVar.h;
            bVar2.m = bVar.i;
            bVar2.n = bVar.j;
            bVar2.o = bVar.k;
            bVar2.p = bVar.l;
            bVar2.q = bVar.p;
            bVar2.r = bVar.q;
            bVar2.s = bVar.r;
            bVar2.t = bVar.s;
            bVar2.u = bVar.z;
            bVar2.v = bVar.A;
            bVar2.w = bVar.B;
            bVar2.x = bVar.m;
            bVar2.y = bVar.n;
            bVar2.z = bVar.o;
            bVar2.A = bVar.Q;
            bVar2.B = bVar.R;
            bVar2.C = bVar.S;
            bVar2.g = bVar.c;
            bVar2.e = bVar.a;
            bVar2.f = bVar.b;
            bVar2.c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.P = bVar.F;
            bVar2.Q = bVar.E;
            bVar2.S = bVar.H;
            bVar2.R = bVar.G;
            bVar2.h0 = bVar.T;
            bVar2.i0 = bVar.U;
            bVar2.T = bVar.I;
            bVar2.U = bVar.J;
            bVar2.V = bVar.M;
            bVar2.W = bVar.N;
            bVar2.X = bVar.K;
            bVar2.Y = bVar.L;
            bVar2.Z = bVar.O;
            bVar2.a0 = bVar.P;
            bVar2.g0 = bVar.V;
            bVar2.K = bVar.u;
            bVar2.M = bVar.w;
            bVar2.J = bVar.t;
            bVar2.L = bVar.v;
            bVar2.O = bVar.x;
            bVar2.N = bVar.y;
            bVar2.H = bVar.getMarginEnd();
            this.d.I = bVar.getMarginStart();
        }
    }

    public static class b {
        public static SparseIntArray k0;
        public int c;
        public int d;
        public int[] e0;
        public String f0;
        public String g0;
        public boolean a = false;
        public boolean b = false;
        public int e = -1;
        public int f = -1;
        public float g = -1.0f;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;
        public float a0 = 1.0f;
        public int b0 = -1;
        public int c0 = 0;
        public int d0 = -1;
        public boolean h0 = false;
        public boolean i0 = false;
        public boolean j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k0 = sparseIntArray;
            sparseIntArray.append(z.d.q3, 24);
            k0.append(z.d.r3, 25);
            k0.append(z.d.t3, 28);
            k0.append(z.d.u3, 29);
            k0.append(z.d.z3, 35);
            k0.append(z.d.y3, 34);
            k0.append(z.d.b3, 4);
            k0.append(z.d.a3, 3);
            k0.append(z.d.Y2, 1);
            k0.append(z.d.E3, 6);
            k0.append(z.d.F3, 7);
            k0.append(z.d.i3, 17);
            k0.append(z.d.j3, 18);
            k0.append(z.d.k3, 19);
            k0.append(z.d.J2, 26);
            k0.append(z.d.v3, 31);
            k0.append(z.d.w3, 32);
            k0.append(z.d.h3, 10);
            k0.append(z.d.g3, 9);
            k0.append(z.d.I3, 13);
            k0.append(z.d.L3, 16);
            k0.append(z.d.J3, 14);
            k0.append(z.d.G3, 11);
            k0.append(z.d.K3, 15);
            k0.append(z.d.H3, 12);
            k0.append(z.d.C3, 38);
            k0.append(z.d.o3, 37);
            k0.append(z.d.n3, 39);
            k0.append(z.d.B3, 40);
            k0.append(z.d.m3, 20);
            k0.append(z.d.A3, 36);
            k0.append(z.d.f3, 5);
            k0.append(z.d.p3, 76);
            k0.append(z.d.x3, 76);
            k0.append(z.d.s3, 76);
            k0.append(z.d.Z2, 76);
            k0.append(z.d.X2, 76);
            k0.append(z.d.M2, 23);
            k0.append(z.d.O2, 27);
            k0.append(z.d.Q2, 30);
            k0.append(z.d.R2, 8);
            k0.append(z.d.N2, 33);
            k0.append(z.d.P2, 2);
            k0.append(z.d.K2, 22);
            k0.append(z.d.L2, 21);
            k0.append(z.d.c3, 61);
            k0.append(z.d.e3, 62);
            k0.append(z.d.d3, 63);
            k0.append(z.d.D3, 69);
            k0.append(z.d.l3, 70);
            k0.append(z.d.V2, 71);
            k0.append(z.d.T2, 72);
            k0.append(z.d.U2, 73);
            k0.append(z.d.W2, 74);
            k0.append(z.d.S2, 75);
        }

        public void a(b bVar) {
            this.a = bVar.a;
            this.c = bVar.c;
            this.b = bVar.b;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.a0 = bVar.a0;
            this.b0 = bVar.b0;
            this.c0 = bVar.c0;
            this.d0 = bVar.d0;
            this.g0 = bVar.g0;
            int[] iArr = bVar.e0;
            if (iArr != null) {
                this.e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.e0 = null;
            }
            this.f0 = bVar.f0;
            this.h0 = bVar.h0;
            this.i0 = bVar.i0;
            this.j0 = bVar.j0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.d.I2);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = k0.get(index);
                if (i2 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.p = c.a(obtainStyledAttributes, index, this.p);
                            break;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 3:
                            this.o = c.a(obtainStyledAttributes, index, this.o);
                            break;
                        case 4:
                            this.n = c.a(obtainStyledAttributes, index, this.n);
                            break;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            break;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 8:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            break;
                        case 9:
                            this.t = c.a(obtainStyledAttributes, index, this.t);
                            break;
                        case 10:
                            this.s = c.a(obtainStyledAttributes, index, this.s);
                            break;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 17:
                            this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                            break;
                        case 18:
                            this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                            break;
                        case 19:
                            this.g = obtainStyledAttributes.getFloat(index, this.g);
                            break;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            break;
                        case 21:
                            this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                            break;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            break;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 24:
                            this.h = c.a(obtainStyledAttributes, index, this.h);
                            break;
                        case 25:
                            this.i = c.a(obtainStyledAttributes, index, this.i);
                            break;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            break;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 28:
                            this.j = c.a(obtainStyledAttributes, index, this.j);
                            break;
                        case 29:
                            this.k = c.a(obtainStyledAttributes, index, this.k);
                            break;
                        case 30:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            break;
                        case 31:
                            this.q = c.a(obtainStyledAttributes, index, this.q);
                            break;
                        case 32:
                            this.r = c.a(obtainStyledAttributes, index, this.r);
                            break;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 34:
                            this.m = c.a(obtainStyledAttributes, index, this.m);
                            break;
                        case 35:
                            this.l = c.a(obtainStyledAttributes, index, this.l);
                            break;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            break;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            break;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            break;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            break;
                        default:
                            switch (i2) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    break;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    break;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    break;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    break;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    break;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    break;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.x = c.a(obtainStyledAttributes, index, this.x);
                                            break;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            break;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            break;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    continue;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    continue;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    continue;
                                                case 76:
                                                    sb = new StringBuilder();
                                                    str = "unused attribute 0x";
                                                    break;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    sb = new StringBuilder();
                                                    str = "Unknown attribute 0x";
                                                    break;
                                            }
                                            sb.append(str);
                                            sb.append(Integer.toHexString(index));
                                            sb.append("   ");
                                            sb.append(k0.get(index));
                                            Log.w("ConstraintSet", sb.toString());
                                            break;
                                    }
                            }
                    }
                } else {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class c {
        public static SparseIntArray h;
        public boolean a = false;
        public int b = -1;
        public String c = null;
        public int d = -1;
        public int e = 0;
        public float f = Float.NaN;
        public float g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            h = sparseIntArray;
            sparseIntArray.append(z.d.W3, 1);
            h.append(z.d.Y3, 2);
            h.append(z.d.Z3, 3);
            h.append(z.d.V3, 4);
            h.append(z.d.U3, 5);
            h.append(z.d.X3, 6);
        }

        public void a(c cVar) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.g = cVar.g;
            this.f = cVar.f;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.d.T3);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (h.get(index)) {
                    case 1:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 2:
                        this.d = obtainStyledAttributes.getInt(index, this.d);
                        break;
                    case 3:
                        this.c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : u.a.c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.b = c.a(obtainStyledAttributes, index, this.b);
                        break;
                    case 6:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(d dVar) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.c = dVar.c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.d.i4);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == z.d.k4) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                } else if (index == z.d.j4) {
                    this.b = obtainStyledAttributes.getInt(index, this.b);
                    this.b = c.b()[this.b];
                } else if (index == z.d.m4) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == z.d.l4) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {
        public static SparseIntArray n;
        public boolean a = false;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(z.d.G4, 1);
            n.append(z.d.H4, 2);
            n.append(z.d.I4, 3);
            n.append(z.d.E4, 4);
            n.append(z.d.F4, 5);
            n.append(z.d.A4, 6);
            n.append(z.d.B4, 7);
            n.append(z.d.C4, 8);
            n.append(z.d.D4, 9);
            n.append(z.d.J4, 10);
            n.append(z.d.K4, 11);
        }

        public void a(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.d.z4);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (n.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.i = obtainStyledAttributes.getDimension(index, this.i);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 10:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 11:
                        this.l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(z.d.u0, 25);
        e.append(z.d.v0, 26);
        e.append(z.d.x0, 29);
        e.append(z.d.y0, 30);
        e.append(z.d.E0, 36);
        e.append(z.d.D0, 35);
        e.append(z.d.c0, 4);
        e.append(z.d.b0, 3);
        e.append(z.d.Z, 1);
        e.append(z.d.M0, 6);
        e.append(z.d.N0, 7);
        e.append(z.d.j0, 17);
        e.append(z.d.k0, 18);
        e.append(z.d.l0, 19);
        e.append(z.d.s, 27);
        e.append(z.d.z0, 32);
        e.append(z.d.A0, 33);
        e.append(z.d.i0, 10);
        e.append(z.d.h0, 9);
        e.append(z.d.Q0, 13);
        e.append(z.d.T0, 16);
        e.append(z.d.R0, 14);
        e.append(z.d.O0, 11);
        e.append(z.d.S0, 15);
        e.append(z.d.P0, 12);
        e.append(z.d.H0, 40);
        e.append(z.d.s0, 39);
        e.append(z.d.r0, 41);
        e.append(z.d.G0, 42);
        e.append(z.d.q0, 20);
        e.append(z.d.F0, 37);
        e.append(z.d.g0, 5);
        e.append(z.d.t0, 82);
        e.append(z.d.C0, 82);
        e.append(z.d.w0, 82);
        e.append(z.d.a0, 82);
        e.append(z.d.Y, 82);
        e.append(z.d.x, 24);
        e.append(z.d.z, 28);
        e.append(z.d.L, 31);
        e.append(z.d.M, 8);
        e.append(z.d.y, 34);
        e.append(z.d.A, 2);
        e.append(z.d.v, 23);
        e.append(z.d.w, 21);
        e.append(z.d.u, 22);
        e.append(z.d.B, 43);
        e.append(z.d.O, 44);
        e.append(z.d.J, 45);
        e.append(z.d.K, 46);
        e.append(z.d.I, 60);
        e.append(z.d.G, 47);
        e.append(z.d.H, 48);
        e.append(z.d.C, 49);
        e.append(z.d.D, 50);
        e.append(z.d.E, 51);
        e.append(z.d.F, 52);
        e.append(z.d.N, 53);
        e.append(z.d.I0, 54);
        e.append(z.d.m0, 55);
        e.append(z.d.J0, 56);
        e.append(z.d.n0, 57);
        e.append(z.d.K0, 58);
        e.append(z.d.o0, 59);
        e.append(z.d.d0, 61);
        e.append(z.d.f0, 62);
        e.append(z.d.e0, 63);
        e.append(z.d.P, 64);
        e.append(z.d.X0, 65);
        e.append(z.d.V, 66);
        e.append(z.d.Y0, 67);
        e.append(z.d.V0, 79);
        e.append(z.d.t, 38);
        e.append(z.d.U0, 68);
        e.append(z.d.L0, 69);
        e.append(z.d.p0, 70);
        e.append(z.d.T, 71);
        e.append(z.d.R, 72);
        e.append(z.d.S, 73);
        e.append(z.d.U, 74);
        e.append(z.d.Q, 75);
        e.append(z.d.W0, 76);
        e.append(z.d.B0, 77);
        e.append(z.d.Z0, 78);
        e.append(z.d.X, 80);
        e.append(z.d.W, 81);
    }

    public static /* synthetic */ int a(TypedArray typedArray, int i, int i2) {
        return n(typedArray, i, i2);
    }

    public static /* synthetic */ int[] b() {
        return d;
    }

    public static int n(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void d(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + v.a.a(childAt));
            } else {
                if (this.b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.d.d0 = 1;
                        }
                        int i2 = aVar.d.d0;
                        if (i2 != -1 && i2 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.d.b0);
                            barrier.setMargin(aVar.d.c0);
                            barrier.setAllowsGoneWidget(aVar.d.j0);
                            b bVar = aVar.d;
                            int[] iArr = bVar.e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f0;
                                if (str != null) {
                                    bVar.e0 = i(barrier, str);
                                    barrier.setReferencedIds(aVar.d.e0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.b(bVar2);
                        if (z) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f);
                        }
                        childAt.setLayoutParams(bVar2);
                        d dVar = aVar.b;
                        if (dVar.c == 0) {
                            childAt.setVisibility(dVar.b);
                        }
                        childAt.setAlpha(aVar.b.d);
                        childAt.setRotation(aVar.e.b);
                        childAt.setRotationX(aVar.e.c);
                        childAt.setRotationY(aVar.e.d);
                        childAt.setScaleX(aVar.e.e);
                        childAt.setScaleY(aVar.e.f);
                        if (!Float.isNaN(aVar.e.g)) {
                            childAt.setPivotX(aVar.e.g);
                        }
                        if (!Float.isNaN(aVar.e.h)) {
                            childAt.setPivotY(aVar.e.h);
                        }
                        childAt.setTranslationX(aVar.e.i);
                        childAt.setTranslationY(aVar.e.j);
                        childAt.setTranslationZ(aVar.e.k);
                        e eVar = aVar.e;
                        if (eVar.l) {
                            childAt.setElevation(eVar.m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.c.get(num);
            int i3 = aVar2.d.d0;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.d;
                int[] iArr2 = bVar3.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f0;
                    if (str2 != null) {
                        bVar3.e0 = i(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.d.e0);
                    }
                }
                barrier2.setType(aVar2.d.b0);
                barrier2.setMargin(aVar2.d.c0);
                ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar2.b(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar2.d.a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.b(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void e(int i, int i2) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            a aVar = (a) this.c.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    b bVar = aVar.d;
                    bVar.i = -1;
                    bVar.h = -1;
                    bVar.D = -1;
                    bVar.J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.d;
                    bVar2.k = -1;
                    bVar2.j = -1;
                    bVar2.E = -1;
                    bVar2.L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.d;
                    bVar3.m = -1;
                    bVar3.l = -1;
                    bVar3.F = -1;
                    bVar3.K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.d;
                    bVar4.n = -1;
                    bVar4.o = -1;
                    bVar4.G = -1;
                    bVar4.M = -1;
                    return;
                case 5:
                    aVar.d.p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.d;
                    bVar5.q = -1;
                    bVar5.r = -1;
                    bVar5.I = -1;
                    bVar5.O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.d;
                    bVar6.s = -1;
                    bVar6.t = -1;
                    bVar6.H = -1;
                    bVar6.N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.b layoutParams = childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.c.containsKey(Integer.valueOf(id))) {
                this.c.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.c.get(Integer.valueOf(id));
            aVar.f = androidx.constraintlayout.widget.a.a(this.a, childAt);
            a.a(aVar, id, layoutParams);
            aVar.b.b = childAt.getVisibility();
            aVar.b.d = childAt.getAlpha();
            aVar.e.b = childAt.getRotation();
            aVar.e.c = childAt.getRotationX();
            aVar.e.d = childAt.getRotationY();
            aVar.e.e = childAt.getScaleX();
            aVar.e.f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                e eVar = aVar.e;
                eVar.g = pivotX;
                eVar.h = pivotY;
            }
            aVar.e.i = childAt.getTranslationX();
            aVar.e.j = childAt.getTranslationY();
            aVar.e.k = childAt.getTranslationZ();
            e eVar2 = aVar.e;
            if (eVar2.l) {
                eVar2.m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.d.j0 = barrier.l();
                aVar.d.e0 = barrier.getReferencedIds();
                aVar.d.b0 = barrier.getType();
                aVar.d.c0 = barrier.getMargin();
            }
        }
    }

    public void h(int i, int i2, int i3, float f) {
        b bVar = k(i).d;
        bVar.x = i2;
        bVar.y = i3;
        bVar.z = f;
    }

    public final int[] i(View view, String str) {
        int i;
        Object f;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = z.c.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (f = view.getParent().f(0, trim)) != null && (f instanceof Integer)) {
                i = ((Integer) f).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final a j(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.d.r);
        o(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public final a k(int i) {
        if (!this.c.containsKey(Integer.valueOf(i))) {
            this.c.put(Integer.valueOf(i), new a());
        }
        return (a) this.c.get(Integer.valueOf(i));
    }

    public void l(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a j = j(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        j.d.a = true;
                    }
                    this.c.put(Integer.valueOf(j.a), j);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x017d, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.m(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void o(Context context, a aVar, TypedArray typedArray) {
        c cVar;
        String str;
        StringBuilder sb;
        String str2;
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != z.d.t && z.d.L != index && z.d.M != index) {
                aVar.c.a = true;
                aVar.d.b = true;
                aVar.b.a = true;
                aVar.e.a = true;
            }
            switch (e.get(index)) {
                case 1:
                    b bVar = aVar.d;
                    bVar.p = n(typedArray, index, bVar.p);
                    continue;
                case 2:
                    b bVar2 = aVar.d;
                    bVar2.G = typedArray.getDimensionPixelSize(index, bVar2.G);
                    continue;
                case 3:
                    b bVar3 = aVar.d;
                    bVar3.o = n(typedArray, index, bVar3.o);
                    continue;
                case 4:
                    b bVar4 = aVar.d;
                    bVar4.n = n(typedArray, index, bVar4.n);
                    continue;
                case 5:
                    aVar.d.w = typedArray.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.d;
                    bVar5.A = typedArray.getDimensionPixelOffset(index, bVar5.A);
                    continue;
                case 7:
                    b bVar6 = aVar.d;
                    bVar6.B = typedArray.getDimensionPixelOffset(index, bVar6.B);
                    continue;
                case 8:
                    b bVar7 = aVar.d;
                    bVar7.H = typedArray.getDimensionPixelSize(index, bVar7.H);
                    continue;
                case 9:
                    b bVar8 = aVar.d;
                    bVar8.t = n(typedArray, index, bVar8.t);
                    continue;
                case 10:
                    b bVar9 = aVar.d;
                    bVar9.s = n(typedArray, index, bVar9.s);
                    continue;
                case 11:
                    b bVar10 = aVar.d;
                    bVar10.M = typedArray.getDimensionPixelSize(index, bVar10.M);
                    continue;
                case 12:
                    b bVar11 = aVar.d;
                    bVar11.N = typedArray.getDimensionPixelSize(index, bVar11.N);
                    continue;
                case 13:
                    b bVar12 = aVar.d;
                    bVar12.J = typedArray.getDimensionPixelSize(index, bVar12.J);
                    continue;
                case 14:
                    b bVar13 = aVar.d;
                    bVar13.L = typedArray.getDimensionPixelSize(index, bVar13.L);
                    continue;
                case 15:
                    b bVar14 = aVar.d;
                    bVar14.O = typedArray.getDimensionPixelSize(index, bVar14.O);
                    continue;
                case 16:
                    b bVar15 = aVar.d;
                    bVar15.K = typedArray.getDimensionPixelSize(index, bVar15.K);
                    continue;
                case 17:
                    b bVar16 = aVar.d;
                    bVar16.e = typedArray.getDimensionPixelOffset(index, bVar16.e);
                    continue;
                case 18:
                    b bVar17 = aVar.d;
                    bVar17.f = typedArray.getDimensionPixelOffset(index, bVar17.f);
                    continue;
                case 19:
                    b bVar18 = aVar.d;
                    bVar18.g = typedArray.getFloat(index, bVar18.g);
                    continue;
                case 20:
                    b bVar19 = aVar.d;
                    bVar19.u = typedArray.getFloat(index, bVar19.u);
                    continue;
                case 21:
                    b bVar20 = aVar.d;
                    bVar20.d = typedArray.getLayoutDimension(index, bVar20.d);
                    continue;
                case 22:
                    d dVar = aVar.b;
                    dVar.b = typedArray.getInt(index, dVar.b);
                    d dVar2 = aVar.b;
                    dVar2.b = d[dVar2.b];
                    continue;
                case 23:
                    b bVar21 = aVar.d;
                    bVar21.c = typedArray.getLayoutDimension(index, bVar21.c);
                    continue;
                case 24:
                    b bVar22 = aVar.d;
                    bVar22.D = typedArray.getDimensionPixelSize(index, bVar22.D);
                    continue;
                case 25:
                    b bVar23 = aVar.d;
                    bVar23.h = n(typedArray, index, bVar23.h);
                    continue;
                case 26:
                    b bVar24 = aVar.d;
                    bVar24.i = n(typedArray, index, bVar24.i);
                    continue;
                case 27:
                    b bVar25 = aVar.d;
                    bVar25.C = typedArray.getInt(index, bVar25.C);
                    continue;
                case 28:
                    b bVar26 = aVar.d;
                    bVar26.E = typedArray.getDimensionPixelSize(index, bVar26.E);
                    continue;
                case 29:
                    b bVar27 = aVar.d;
                    bVar27.j = n(typedArray, index, bVar27.j);
                    continue;
                case 30:
                    b bVar28 = aVar.d;
                    bVar28.k = n(typedArray, index, bVar28.k);
                    continue;
                case 31:
                    b bVar29 = aVar.d;
                    bVar29.I = typedArray.getDimensionPixelSize(index, bVar29.I);
                    continue;
                case 32:
                    b bVar30 = aVar.d;
                    bVar30.q = n(typedArray, index, bVar30.q);
                    continue;
                case 33:
                    b bVar31 = aVar.d;
                    bVar31.r = n(typedArray, index, bVar31.r);
                    continue;
                case 34:
                    b bVar32 = aVar.d;
                    bVar32.F = typedArray.getDimensionPixelSize(index, bVar32.F);
                    continue;
                case 35:
                    b bVar33 = aVar.d;
                    bVar33.m = n(typedArray, index, bVar33.m);
                    continue;
                case 36:
                    b bVar34 = aVar.d;
                    bVar34.l = n(typedArray, index, bVar34.l);
                    continue;
                case 37:
                    b bVar35 = aVar.d;
                    bVar35.v = typedArray.getFloat(index, bVar35.v);
                    continue;
                case 38:
                    aVar.a = typedArray.getResourceId(index, aVar.a);
                    continue;
                case 39:
                    b bVar36 = aVar.d;
                    bVar36.Q = typedArray.getFloat(index, bVar36.Q);
                    continue;
                case 40:
                    b bVar37 = aVar.d;
                    bVar37.P = typedArray.getFloat(index, bVar37.P);
                    continue;
                case 41:
                    b bVar38 = aVar.d;
                    bVar38.R = typedArray.getInt(index, bVar38.R);
                    continue;
                case 42:
                    b bVar39 = aVar.d;
                    bVar39.S = typedArray.getInt(index, bVar39.S);
                    continue;
                case 43:
                    d dVar3 = aVar.b;
                    dVar3.d = typedArray.getFloat(index, dVar3.d);
                    continue;
                case 44:
                    e eVar = aVar.e;
                    eVar.l = true;
                    eVar.m = typedArray.getDimension(index, eVar.m);
                    continue;
                case 45:
                    e eVar2 = aVar.e;
                    eVar2.c = typedArray.getFloat(index, eVar2.c);
                    continue;
                case 46:
                    e eVar3 = aVar.e;
                    eVar3.d = typedArray.getFloat(index, eVar3.d);
                    continue;
                case 47:
                    e eVar4 = aVar.e;
                    eVar4.e = typedArray.getFloat(index, eVar4.e);
                    continue;
                case 48:
                    e eVar5 = aVar.e;
                    eVar5.f = typedArray.getFloat(index, eVar5.f);
                    continue;
                case 49:
                    e eVar6 = aVar.e;
                    eVar6.g = typedArray.getDimension(index, eVar6.g);
                    continue;
                case 50:
                    e eVar7 = aVar.e;
                    eVar7.h = typedArray.getDimension(index, eVar7.h);
                    continue;
                case 51:
                    e eVar8 = aVar.e;
                    eVar8.i = typedArray.getDimension(index, eVar8.i);
                    continue;
                case 52:
                    e eVar9 = aVar.e;
                    eVar9.j = typedArray.getDimension(index, eVar9.j);
                    continue;
                case 53:
                    e eVar10 = aVar.e;
                    eVar10.k = typedArray.getDimension(index, eVar10.k);
                    continue;
                case 54:
                    b bVar40 = aVar.d;
                    bVar40.T = typedArray.getInt(index, bVar40.T);
                    continue;
                case 55:
                    b bVar41 = aVar.d;
                    bVar41.U = typedArray.getInt(index, bVar41.U);
                    continue;
                case 56:
                    b bVar42 = aVar.d;
                    bVar42.V = typedArray.getDimensionPixelSize(index, bVar42.V);
                    continue;
                case 57:
                    b bVar43 = aVar.d;
                    bVar43.W = typedArray.getDimensionPixelSize(index, bVar43.W);
                    continue;
                case 58:
                    b bVar44 = aVar.d;
                    bVar44.X = typedArray.getDimensionPixelSize(index, bVar44.X);
                    continue;
                case 59:
                    b bVar45 = aVar.d;
                    bVar45.Y = typedArray.getDimensionPixelSize(index, bVar45.Y);
                    continue;
                case 60:
                    e eVar11 = aVar.e;
                    eVar11.b = typedArray.getFloat(index, eVar11.b);
                    continue;
                case 61:
                    b bVar46 = aVar.d;
                    bVar46.x = n(typedArray, index, bVar46.x);
                    continue;
                case 62:
                    b bVar47 = aVar.d;
                    bVar47.y = typedArray.getDimensionPixelSize(index, bVar47.y);
                    continue;
                case 63:
                    b bVar48 = aVar.d;
                    bVar48.z = typedArray.getFloat(index, bVar48.z);
                    continue;
                case 64:
                    c cVar2 = aVar.c;
                    cVar2.b = n(typedArray, index, cVar2.b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.c;
                        str = typedArray.getString(index);
                    } else {
                        cVar = aVar.c;
                        str = u.a.c[typedArray.getInteger(index, 0)];
                    }
                    cVar.c = str;
                    continue;
                case 66:
                    aVar.c.e = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    c cVar3 = aVar.c;
                    cVar3.g = typedArray.getFloat(index, cVar3.g);
                    continue;
                case 68:
                    d dVar4 = aVar.b;
                    dVar4.e = typedArray.getFloat(index, dVar4.e);
                    continue;
                case 69:
                    aVar.d.Z = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.d.a0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    b bVar49 = aVar.d;
                    bVar49.b0 = typedArray.getInt(index, bVar49.b0);
                    continue;
                case 73:
                    b bVar50 = aVar.d;
                    bVar50.c0 = typedArray.getDimensionPixelSize(index, bVar50.c0);
                    continue;
                case 74:
                    aVar.d.f0 = typedArray.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.d;
                    bVar51.j0 = typedArray.getBoolean(index, bVar51.j0);
                    continue;
                case 76:
                    c cVar4 = aVar.c;
                    cVar4.d = typedArray.getInt(index, cVar4.d);
                    continue;
                case 77:
                    aVar.d.g0 = typedArray.getString(index);
                    continue;
                case 78:
                    d dVar5 = aVar.b;
                    dVar5.c = typedArray.getInt(index, dVar5.c);
                    continue;
                case 79:
                    c cVar5 = aVar.c;
                    cVar5.f = typedArray.getFloat(index, cVar5.f);
                    continue;
                case 80:
                    b bVar52 = aVar.d;
                    bVar52.h0 = typedArray.getBoolean(index, bVar52.h0);
                    continue;
                case 81:
                    b bVar53 = aVar.d;
                    bVar53.i0 = typedArray.getBoolean(index, bVar53.i0);
                    continue;
                case 82:
                    sb = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                default:
                    sb = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb.append(str2);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(e.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
    }
}
