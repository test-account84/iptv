package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class amw implements amv {
    protected static volatile anw a;
    protected MotionEvent b;
    protected double k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected DisplayMetrics q;
    private double r;
    private double s;
    protected final LinkedList c = new LinkedList();
    protected long d = 0;
    protected long e = 0;
    protected long f = 0;
    protected long g = 0;
    protected long h = 0;
    protected long i = 0;
    protected long j = 0;
    private boolean t = false;
    protected boolean p = false;

    public amw(Context context) {
        try {
            if (((Boolean) aqo.u.f()).booleanValue()) {
                amc.c();
            } else {
                any.a(a);
            }
            this.q = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void j() {
        this.h = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = 0L;
        this.j = 0L;
        if (this.c.size() > 0) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.c.clear();
        } else {
            MotionEvent motionEvent = this.b;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.b = null;
    }

    private final String m(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        afm afmVar;
        amu amuVar;
        String str2;
        int i2;
        int i3;
        String a2;
        int i4;
        int i5 = i;
        agl aglVar = null;
        if (bArr == null || bArr.length <= 0) {
            afmVar = null;
        } else {
            try {
                afmVar = afm.b(bArr, bqb.a());
            } catch (NullPointerException unused) {
                return Integer.toString(3);
            } catch (bqw unused2) {
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) aqo.j.f()).booleanValue();
        if (booleanValue) {
            amuVar = a != null ? a.d() : null;
            str2 = true != ((Boolean) aqo.u.f()).booleanValue() ? "te" : "be";
        } else {
            amuVar = null;
            str2 = null;
        }
        try {
            if (i5 == 3) {
                aglVar = c(context, view, activity);
                this.t = true;
                i4 = 1002;
            } else if (i5 == 2) {
                aglVar = i(context, view, activity);
                i4 = 1008;
            } else {
                aglVar = d(context, afmVar);
                i4 = 1000;
            }
            if (booleanValue && amuVar != null) {
                amuVar.e(i4, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            if (booleanValue && amuVar != null) {
                if (i5 == 3) {
                    i2 = 1003;
                } else if (i5 == 2) {
                    i2 = 1009;
                } else {
                    i2 = 1001;
                    i5 = 1;
                }
                i3 = 2;
                amuVar.c(i2, -1, System.currentTimeMillis() - currentTimeMillis, str2, e);
            }
        }
        i3 = 2;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (aglVar != null) {
            try {
                if (((agc) aglVar.aY()).ax() == 0) {
                    a2 = Integer.toString(5);
                } else {
                    a2 = amc.a((agc) aglVar.aY(), str);
                    if (booleanValue && amuVar != null) {
                        amuVar.e(i5 == 3 ? 1006 : i5 == i3 ? 1010 : 1004, System.currentTimeMillis() - currentTimeMillis2, str2);
                    }
                }
            } catch (Exception e2) {
                a2 = Integer.toString(7);
                if (booleanValue && amuVar != null) {
                    amuVar.c(i5 == 3 ? 1007 : i5 == i3 ? 1011 : 1005, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e2);
                }
            }
        } else {
            a2 = Integer.toString(5);
        }
        return a2;
    }

    public abstract long a(StackTraceElement[] stackTraceElementArr) throws anp;

    public abstract anz b(MotionEvent motionEvent) throws anp;

    public abstract agl c(Context context, View view, Activity activity);

    public abstract agl d(Context context, afm afmVar);

    public final String e(Context context, String str, View view, Activity activity) {
        return m(context, str, 3, view, activity, null);
    }

    public final String f(Context context) {
        if (aoa.f()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return m(context, null, 1, null, null, null);
    }

    public final String g(Context context, byte[] bArr) {
        if (aoa.f()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return m(context, null, 1, null, null, bArr);
    }

    public final String h(Context context, View view, Activity activity) {
        return m(context, null, 2, view, activity, null);
    }

    public abstract agl i(Context context, View view, Activity activity);

    public final synchronized void k(MotionEvent motionEvent) {
        Long l;
        try {
            if (this.t) {
                j();
                this.t = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.k = 0.0d;
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = rawX - this.r;
                double d2 = rawY - this.s;
                this.k += Math.sqrt((d * d) + (d2 * d2));
                this.r = rawX;
                this.s = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        this.b = obtain;
                        this.c.add(obtain);
                        if (this.c.size() > 6) {
                            ((MotionEvent) this.c.remove()).recycle();
                        }
                        this.f++;
                        this.h = a(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.e += motionEvent.getHistorySize() + 1;
                        anz b = b(motionEvent);
                        Long l2 = b.d;
                        if (l2 != null && b.g != null) {
                            this.i += l2.longValue() + b.g.longValue();
                        }
                        if (this.q != null && (l = b.e) != null && b.h != null) {
                            this.j += l.longValue() + b.h.longValue();
                        }
                    } else if (action2 == 3) {
                        this.g++;
                    }
                } catch (anp unused) {
                }
            } else {
                this.l = motionEvent.getX();
                this.m = motionEvent.getY();
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                this.d++;
            }
            this.p = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void l(int i, int i2, int i3) {
        try {
            if (this.b != null) {
                if (((Boolean) aqo.h.f()).booleanValue()) {
                    j();
                } else {
                    this.b.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.q;
            if (displayMetrics != null) {
                float f = displayMetrics.density;
                this.b = MotionEvent.obtain(0L, i3, 1, i * f, i2 * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.b = null;
            }
            this.p = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void n(View view) {
    }

    public final boolean q() {
        return true;
    }

    public final boolean s() {
        return true;
    }
}
