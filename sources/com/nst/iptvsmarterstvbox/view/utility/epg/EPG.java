package com.nst.iptvsmarterstvbox.view.utility.epg;

import a7.j;
import a7.k;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSmallEPG;
import com.squareup.picasso.C;
import com.squareup.picasso.t;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m7.w;
import org.joda.time.LocalDateTime;
import s5.I;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class EPG extends ViewGroup {
    public static int f1 = 3600000;
    public static int g1 = 14400000;
    public static int h1 = 7200000;
    public static int i1;
    public static int j1;
    public static final CookieManager k1;
    public static String l1;
    public static String m1;
    public final int A;
    public boolean A0;
    public final int B;
    public LinearLayout B0;
    public final int C;
    public TextView C0;
    public int D;
    public long D0;
    public final int E;
    public String E0;
    public final int F;
    public int F0;
    public final Bitmap G;
    public int G0;
    public final int H;
    public SharedPreferences H0;
    public final Map I;
    public boolean I0;
    public final Map J;
    public Handler J0;
    public C7.a K;
    public Handler K0;
    public int L;
    public SurfaceView L0;
    public int M;
    public int M0;
    public long N;
    public NSTIJKPlayerSmallEPG N0;
    public long O;
    public Activity O0;
    public long P;
    public Boolean P0;
    public long Q;
    public int Q0;
    public boolean R;
    public boolean R0;
    public SharedPreferences S;
    public int S0;
    public long T;
    public ProgressDialog T0;
    public C7.b U;
    public u7.a U0;
    public D7.a V;
    public Uri V0;
    public D7.a W;
    public boolean W0;
    public boolean X0;
    public Boolean Y0;
    public Date Z0;
    public DatabaseHandler a;
    public DateFormat a1;
    public SimpleDateFormat b1;
    public LiveStreamDBHandler c;
    public String c1;
    public final String d;
    public String d1;
    public SimpleDateFormat e;
    public D7.b e0;
    public LinearLayout e1;
    public SimpleDateFormat f;
    public TextView f0;
    public SharedPreferences g;
    public TextView g0;
    public final Rect h;
    public TextView h0;
    public final Rect i;
    public int i0;
    public final Rect j;
    public SharedPreferences j0;
    public final Paint k;
    public SharedPreferences k0;
    public final Scroller l;
    public PopupWindow l0;
    public final GestureDetector m;
    public Context m0;
    public int n;
    public ProgressBar n0;
    public final int o;
    public int o0;
    public final int p;
    public String p0;
    public final int q;
    public String q0;
    public int r;
    public String r0;
    public int s;
    public int s0;
    public final int t;
    public int t0;
    public final int u;
    public int u0;
    public final int v;
    public int v0;
    public final int w;
    public int w0;
    public final int x;
    public int x0;
    public final int y;
    public int y0;
    public final int z;
    public int z0;

    public class a implements C {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        public void a(Drawable drawable) {
            EPG.b(EPG.this).put(this.a, BitmapFactory.decodeResource(EPG.this.getResources(), a7.e.i1));
            EPG.this.l0();
            EPG.m(EPG.this).remove(this.a);
        }

        public void b(Bitmap bitmap, t.e eVar) {
            EPG.b(EPG.this).put(this.a, bitmap);
            EPG.this.l0();
            EPG.m(EPG.this).remove(this.a);
        }

        public void c(Drawable drawable) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public View a;

        public b(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                this.a.getTag().equals("iv_cross");
                return;
            }
            View view3 = this.a;
            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                return;
            }
            view.setBackground(EPG.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public c(Context context, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = context;
            this.c = str;
            this.d = i;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
        }

        public void onClick(View view) {
            EPG.s(EPG.this).dismiss();
            if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
                if (EPG.u(EPG.this).booleanValue()) {
                    w.y0(EPG.this.getContext(), this.c, this.d, "live", this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                }
            } else {
                if (SharepreferenceDBHandler.getEventAdsView(this.a) >= m7.a.f1) {
                    SharepreferenceDBHandler.setEventAdsView(0, this.a);
                    EPG epg = EPG.this;
                    EPG.t(epg, epg.getContext(), this.c, this.d, "live", this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                    return;
                }
                if (SharepreferenceDBHandler.getEventAdsView(this.a) == 0 && SharepreferenceDBHandler.getFirstTimeAdsShow(this.a)) {
                    SharepreferenceDBHandler.setFirstTimeAdsShow(false, this.a);
                    EPG epg2 = EPG.this;
                    EPG.t(epg2, epg2.getContext(), this.c, this.d, "live", this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                } else if (EPG.u(EPG.this).booleanValue()) {
                    w.y0(EPG.this.getContext(), this.c, this.d, "live", this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                }
                SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this.a) + 1, this.a);
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public d(Context context, String str, String str2, String str3, int i, String str4, String str5) {
            this.a = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i;
            this.g = str4;
            this.h = str5;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
                EPG.v(EPG.this, this.a, this.c, this.d, this.e);
            } else {
                EPG.this.x(this.a, this.c, this.f, this.e, this.g, this.h);
            }
            EPG.s(EPG.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;

        public e(Context context, String str, String str2, String str3, int i, String str4) {
            this.a = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i;
            this.g = str4;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
                EPG.w(EPG.this, this.a, this.c, this.d);
            } else {
                EPG.c(EPG.this, this.a, this.e, this.f, this.d, this.g);
            }
            EPG.s(EPG.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            EPG.s(EPG.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ Dialog k;

        public g(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Dialog dialog) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = str8;
            this.k = dialog;
        }

        public void onClick(View view) {
            if (EPG.u(EPG.this).booleanValue()) {
                w.y0(EPG.this.getContext(), this.a, this.c, "live", this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            this.k.dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ Dialog k;

        public h(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Dialog dialog) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = str8;
            this.k = dialog;
        }

        public void onClick(View view) {
            if (EPG.u(EPG.this).booleanValue()) {
                w.y0(EPG.this.getContext(), this.a, this.c, "live", this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            this.k.dismiss();
        }
    }

    public class i extends GestureDetector.SimpleOnGestureListener {
        public i() {
        }

        public static /* synthetic */ void a(i iVar) {
            iVar.c();
        }

        public static /* synthetic */ void b(i iVar) {
            iVar.d();
        }

        public final void c() {
            if (EPG.p(EPG.this) == null || EPG.q(EPG.this) == null) {
                return;
            }
            EPG.q(EPG.this).dismiss();
        }

        public final void d() {
            if (EPG.p(EPG.this) != null) {
                if (EPG.q(EPG.this) == null || !EPG.q(EPG.this).isShowing()) {
                    EPG.r(EPG.this, new ProgressDialog(EPG.p(EPG.this)));
                    EPG.q(EPG.this).setMessage(EPG.p(EPG.this).getResources().getString(j.t5));
                    EPG.q(EPG.this).setCanceledOnTouchOutside(false);
                    EPG.q(EPG.this).setCancelable(false);
                    EPG.q(EPG.this).setProgressStyle(0);
                    EPG.q(EPG.this).show();
                }
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (!EPG.o(EPG.this).isFinished()) {
                EPG.o(EPG.this).forceFinished(true);
            }
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            EPG.o(EPG.this).fling(EPG.this.getScrollX(), EPG.this.getScrollY(), -((int) f), -((int) f2), 0, EPG.l(EPG.this), 0, EPG.n(EPG.this));
            EPG.this.l0();
            if (EPG.o(EPG.this).getFinalY() == EPG.n(EPG.this) && EPG.this.S0 == 1) {
                d();
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int i = (int) f;
            int i2 = (int) f2;
            int scrollX = EPG.this.getScrollX();
            int scrollY = EPG.this.getScrollY();
            if (scrollX + i < 0) {
                i = 0 - scrollX;
            }
            if (scrollY + i2 < 0) {
                i2 = 0 - scrollY;
            }
            if (scrollX + i > EPG.l(EPG.this)) {
                i = EPG.l(EPG.this) - scrollX;
            }
            if (scrollY + i2 > EPG.n(EPG.this)) {
                i2 = EPG.n(EPG.this) - scrollY;
            }
            EPG.this.scrollBy(i, i2);
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int k;
            C7.a e;
            D7.b a;
            try {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int scrollX = EPG.this.getScrollX() + x;
                int scrollY = EPG.this.getScrollY() + y;
                int d = EPG.d(EPG.this, scrollY);
                if (d != -1 && EPG.e(EPG.this) != null) {
                    if (EPG.f(EPG.this).contains(scrollX, scrollY)) {
                        EPG.e(EPG.this).c();
                    } else if (EPG.g(EPG.this).contains(x, y)) {
                        EPG.e(EPG.this).c();
                        Iterator it = EPG.h(EPG.this).c(d).e().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                a = null;
                                break;
                            }
                            a = (D7.b) it.next();
                            if (a.h(EPG.this.getTimeShiftMilliSeconds())) {
                                break;
                            }
                        }
                        if (a != null) {
                            EPG epg = EPG.this;
                            k = EPG.k(epg, d, EPG.j(epg, (epg.getScrollX() + x) - EPG.i(EPG.this).left));
                            if (k != -1) {
                                e = EPG.e(EPG.this);
                                e.a(d, k, a);
                            }
                        } else {
                            EPG.e(EPG.this).b(d, EPG.h(EPG.this).c(d));
                        }
                    } else if (EPG.i(EPG.this).contains(x, y)) {
                        EPG epg2 = EPG.this;
                        k = EPG.k(epg2, d, EPG.j(epg2, (epg2.getScrollX() + x) - EPG.i(EPG.this).left));
                        if (k != -1) {
                            e = EPG.e(EPG.this);
                            a = EPG.h(EPG.this).a(d, k);
                            e.a(d, k, a);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return true;
        }

        public /* synthetic */ i(EPG epg, a aVar) {
            this();
        }
    }

    static {
        CookieManager cookieManager = new CookieManager();
        k1 = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public EPG(Context context, AttributeSet attributeSet) {
        String str;
        String str2;
        this(context, attributeSet, 0);
        this.m0 = context;
        this.J0 = new Handler();
        this.K0 = new Handler();
        this.U0 = new u7.a(context);
        this.H0 = context.getSharedPreferences("loginPrefs", 0);
        this.c1 = w.S0(w7.a.a());
        l1 = context.getApplicationContext().getPackageName();
        m1 = T(context);
        this.d1 = w.S0(w7.d.d());
        Locale locale = Locale.US;
        this.b1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.a1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.Z0 = new Date();
        SimpleDateFormat simpleDateFormat = this.b1;
        if (J(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(context))), this.a1.format(this.Z0)) < w7.c.p() || (str = this.c1) == null || this.d1 == null) {
            return;
        }
        if (m1.equals(str) && (this.c1 == null || (str2 = this.d1) == null || l1.equals(str2))) {
            return;
        }
        this.Y0 = Boolean.FALSE;
    }

    public static long J(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String T(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ Map b(EPG epg) {
        return epg.I;
    }

    public static /* synthetic */ void c(EPG epg, Context context, String str, int i2, String str2, String str3) {
        epg.m0(context, str, i2, str2, str3);
    }

    public static /* synthetic */ int d(EPG epg, int i2) {
        return epg.U(i2);
    }

    public static /* synthetic */ C7.a e(EPG epg) {
        return epg.K;
    }

    public static /* synthetic */ Rect f(EPG epg) {
        return epg.E();
    }

    public static /* synthetic */ Rect g(EPG epg) {
        return epg.z();
    }

    private int getChannelAreaWidth() {
        return this.s + this.o + this.n;
    }

    private D7.a getFirstChannelData() {
        return this.V;
    }

    private D7.a getFirstLastChannelData() {
        return this.W;
    }

    private int getFirstVisibleChannelPosition() {
        int scrollY = getScrollY();
        int i2 = this.n;
        int i3 = ((scrollY - i2) - this.C) / (this.p + i2);
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private int getLastVisibleChannelPosition() {
        int scrollY = getScrollY();
        int f2 = this.U.f();
        int height = scrollY + getHeight();
        int i2 = this.C + height;
        int i3 = this.n;
        int i4 = this.p;
        int i5 = (i2 - i3) / (i3 + i4);
        int i6 = f2 - 1;
        if (i5 > i6) {
            i5 = i6;
        }
        return (height <= i4 * i5 || i5 >= i6) ? i5 : i5 + 1;
    }

    private int getProgramAreaWidth() {
        return getWidth() - getChannelAreaWidth();
    }

    private int getXPositionStart() {
        return a0((System.currentTimeMillis() + getTimeShiftMilliSeconds()) - (h1 / 2));
    }

    public static /* synthetic */ C7.b h(EPG epg) {
        return epg.U;
    }

    public static /* synthetic */ Rect i(EPG epg) {
        return epg.D();
    }

    public static /* synthetic */ long j(EPG epg, int i2) {
        return epg.Y(i2);
    }

    public static /* synthetic */ int k(EPG epg, int i2, long j) {
        return epg.X(i2, j);
    }

    public static /* synthetic */ int l(EPG epg) {
        return epg.L;
    }

    public static /* synthetic */ Map m(EPG epg) {
        return epg.J;
    }

    public static /* synthetic */ int n(EPG epg) {
        return epg.M;
    }

    public static /* synthetic */ Scroller o(EPG epg) {
        return epg.l;
    }

    public static /* synthetic */ Activity p(EPG epg) {
        return epg.O0;
    }

    public static /* synthetic */ ProgressDialog q(EPG epg) {
        return epg.T0;
    }

    public static /* synthetic */ ProgressDialog r(EPG epg, ProgressDialog progressDialog) {
        epg.T0 = progressDialog;
        return progressDialog;
    }

    public static /* synthetic */ PopupWindow s(EPG epg) {
        return epg.l0;
    }

    public static /* synthetic */ void t(EPG epg, Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        epg.f0(context, str, i2, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public static /* synthetic */ Boolean u(EPG epg) {
        return epg.Y0;
    }

    public static /* synthetic */ void v(EPG epg, Context context, String str, String str2, String str3) {
        epg.y(context, str, str2, str3);
    }

    public static /* synthetic */ void w(EPG epg, Context context, String str, String str2) {
        epg.n0(context, str, str2);
    }

    public final void A() {
        int i2;
        SharedPreferences sharedPreferences = this.m0.getSharedPreferences("auto_start", 0);
        this.S = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("full_epg", false);
        this.R = z;
        if (z) {
            i2 = 86400000;
            g1 = 86400000;
        } else {
            g1 = 14400000;
            i2 = 3600000;
        }
        f1 = i2;
        this.L = (int) (((f1 + g1) - h1) / this.N);
    }

    public final void B() {
        int Z = Z(this.U.f() - 1) + this.p;
        this.M = Z < getHeight() ? 0 : Z - getHeight();
    }

    public final long C() {
        return h1 / ((getResources().getDisplayMetrics().widthPixels - this.s) - this.n);
    }

    public final Rect D() {
        this.j.top = this.C;
        int f2 = this.U.f() * (this.p + this.n);
        Rect rect = this.j;
        if (f2 >= getHeight()) {
            f2 = getHeight();
        }
        rect.bottom = f2;
        Rect rect2 = this.j;
        rect2.left = this.s;
        rect2.right = getWidth();
        return this.j;
    }

    public final Rect E() {
        this.j.left = ((getScrollX() + getWidth()) - this.E) - this.F;
        Rect rect = this.j;
        int scrollY = getScrollY() + getHeight();
        int i2 = this.E;
        rect.top = (scrollY - i2) - this.F;
        Rect rect2 = this.j;
        rect2.right = rect2.left + i2;
        rect2.bottom = rect2.top + i2;
        return rect2;
    }

    public final long F() {
        SharedPreferences sharedPreferences = this.m0.getSharedPreferences("auto_start", 0);
        this.S = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("full_epg", false);
        this.R = z;
        f1 = z ? 86400000 : 3600000;
        return LocalDateTime.now().toDateTime().minusMillis(f1).getMillis();
    }

    public final void G(int i2, long j) {
        int i3 = i2 - 1;
        if (i3 < 0) {
            super.requestFocus();
            return;
        }
        D7.b W = W(i3, j);
        if (W == null) {
            G(i3, j);
            return;
        }
        this.e0.i = false;
        this.e0 = W;
        W.i = true;
    }

    public void H() {
        this.I.clear();
    }

    public void I() {
        if (this.U0.x() == 3) {
            return;
        }
        try {
            NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG = this.N0;
            if (nSTIJKPlayerSmallEPG != null) {
                if (nSTIJKPlayerSmallEPG.T()) {
                    this.N0.M();
                } else {
                    this.N0.h0();
                    this.N0.W(true);
                    this.N0.g0();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused) {
        }
    }

    public final void K(Canvas canvas, int i2, Rect rect) {
        Rect rect2;
        Paint paint;
        int i3;
        try {
            rect.left = getScrollX();
            int Z = Z(i2);
            rect.top = Z;
            rect.right = rect.left + this.q;
            rect.bottom = Z + this.p;
            String f2 = this.U.c(i2).f();
            String g2 = this.U.c(i2).g();
            if (i2 == this.Q0) {
                this.k.setColor(this.y);
                int scrollX = getScrollX();
                int i4 = rect.top;
                rect2 = new Rect(scrollX, i4, rect.left + this.s, this.p + i4);
                paint = new Paint();
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                i3 = this.w;
            } else {
                this.k.setColor(this.y);
                int i5 = rect.left;
                int i6 = rect.top;
                rect2 = new Rect(i5, i6, this.s + i5, this.p + i6);
                paint = new Paint();
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                i3 = this.t;
            }
            paint.setColor(i3);
            canvas.drawRect(rect2, paint);
            if (this.I.containsKey(f2)) {
                Bitmap bitmap = (Bitmap) this.I.get(f2);
                rect = V(rect, bitmap);
                canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
            } else {
                int min = Math.min(this.p, this.s);
                if (!this.J.containsKey(f2)) {
                    this.J.put(f2, new a(f2));
                    E7.b.d(getContext(), f2, min, min, (C) this.J.get(f2));
                }
            }
            this.k.setColor(this.y);
            int length = g2.length();
            String substring = g2.substring(0, this.k.breakText(g2, true, this.r, (float[]) null));
            canvas.drawText(substring + (substring.length() < length ? ".." : ""), rect.right + 10, rect.centerY() + 10, this.k);
        } catch (Exception unused) {
        }
    }

    public final void L(Canvas canvas, Rect rect) {
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            K(canvas, firstVisibleChannelPosition, rect);
        }
    }

    public final void M(Canvas canvas, int i2, D7.b bVar, Rect rect) {
        Paint paint;
        int i3;
        Paint paint2;
        int i4;
        s0(i2, bVar.f(), bVar.c(), rect);
        String g2 = bVar.g();
        if (bVar.i()) {
            this.k.setColor(this.w);
            this.Q0 = i2;
        } else {
            if (bVar.h(getTimeShiftMilliSeconds())) {
                paint = this.k;
                i3 = this.v;
            } else if (g2 == null || g2.isEmpty() || !g2.equals(getContext().getResources().getString(j.p4))) {
                paint = this.k;
                i3 = this.u;
            } else {
                paint = this.k;
                i3 = this.x;
            }
            paint.setColor(i3);
        }
        canvas.drawRect(rect, this.k);
        int i5 = rect.left;
        int i6 = this.o;
        rect.left = i5 + i6 + 16;
        rect.right -= i6;
        this.k.setColor(this.y);
        if (this.U0.A().equals(m7.a.K0)) {
            paint2 = this.k;
            i4 = this.z + 6;
        } else {
            paint2 = this.k;
            i4 = this.z;
        }
        paint2.setTextSize(i4);
        this.k.getTextBounds(bVar.g(), 0, bVar.g().length(), this.j);
        int i7 = rect.top;
        rect.top = i7 + ((rect.bottom - i7) / 2) + (this.j.height() / 2);
        canvas.drawText(g2.substring(0, this.k.breakText(g2, true, rect.right - rect.left, (float[]) null)), rect.left, rect.top, this.k);
    }

    public final void N(Canvas canvas, Rect rect) {
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            this.h.left = getScrollX() + this.s + this.n;
            this.h.top = Z(firstVisibleChannelPosition);
            this.h.right = getScrollX() + getWidth();
            Rect rect2 = this.h;
            rect2.bottom = rect2.top + this.p;
            canvas.save();
            canvas.clipRect(this.h);
            boolean z = false;
            for (D7.b bVar : this.U.d(firstVisibleChannelPosition)) {
                if (!e0(bVar.f(), bVar.c())) {
                    if (z) {
                        break;
                    }
                } else {
                    M(canvas, firstVisibleChannelPosition, bVar, rect);
                    z = true;
                }
            }
            canvas.restore();
        }
    }

    public final void O(Canvas canvas, Rect rect) {
        if (Math.abs(getXPositionStart() - getScrollX()) > getWidth() / 3) {
            Rect E = E();
            this.k.setColor(this.B);
            int i2 = E.right;
            int i3 = this.E;
            canvas.drawCircle(i2 - (i3 / 2), E.bottom - (i3 / 2), Math.min(E.width(), E.height()) / 2, this.k);
            int i4 = E.left;
            int i5 = this.F;
            E.left = i4 + i5;
            E.right -= i5;
            E.top += i5;
            E.bottom -= i5;
            canvas.drawBitmap(this.G, (Rect) null, E, this.k);
        }
    }

    public final void P(Canvas canvas, Rect rect) {
        long currentTimeMillis = System.currentTimeMillis() + getTimeShiftMilliSeconds();
        if (t0(currentTimeMillis)) {
            rect.left = a0(currentTimeMillis);
            int scrollY = getScrollY();
            rect.top = scrollY;
            rect.right = rect.left + this.A;
            rect.bottom = scrollY + getHeight();
            this.k.setColor(this.B);
            canvas.drawRect(rect, this.k);
            if (this.R0) {
                return;
            }
            this.R0 = true;
            scrollTo(this.U0.A().equals(m7.a.K0) ? ((a0(currentTimeMillis) - this.s) + this.n) - 200 : ((a0(currentTimeMillis) - this.s) + this.n) - 100, 0);
        }
    }

    public final void Q(Canvas canvas, Rect rect) {
        rect.left = getScrollX() + this.s + this.n;
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.C;
        this.h.left = getScrollX() + this.s + this.n;
        this.h.top = getScrollY();
        this.h.right = getScrollX() + getWidth();
        Rect rect2 = this.h;
        rect2.bottom = rect2.top + this.C;
        canvas.save();
        canvas.clipRect(this.h);
        this.k.setColor(this.t);
        canvas.drawRect(rect, this.k);
        this.k.setColor(this.y);
        this.k.setTextSize(this.D);
        for (int i2 = 0; i2 < h1 / 1800000; i2++) {
            long j = (((this.P + (1800000 * i2)) + 900000) / 1800000) * 1800000;
            String b2 = E7.b.b(this.m0, j);
            float a0 = a0(j);
            int i3 = rect.top;
            canvas.drawText(b2, a0, i3 + ((rect.bottom - i3) / 2) + (this.D / 2), this.k);
        }
        canvas.restore();
        S(canvas, rect);
        R(canvas, rect);
    }

    public final void R(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + this.C;
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.n;
        this.k.setColor(this.H);
        canvas.drawRect(rect, this.k);
    }

    public final void S(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        int scrollY = getScrollY();
        rect.top = scrollY;
        rect.right = rect.left + this.s;
        rect.bottom = scrollY + this.C;
        this.k.setColor(this.t);
        this.k.setTextAlign(Paint.Align.CENTER);
        canvas.drawRect(rect, this.k);
        this.k.setColor(this.y);
        this.k.setTextSize(this.D);
        String a2 = E7.b.a(this.P);
        int i2 = rect.left;
        float f2 = i2 + ((rect.right - i2) / 2);
        int i3 = rect.top;
        canvas.drawText(a2, f2, i3 + ((rect.bottom - i3) / 2) + (this.D / 2), this.k);
        this.k.setTextAlign(Paint.Align.LEFT);
    }

    public final int U(int i2) {
        int i3 = i2 - this.C;
        int i4 = this.n;
        int i5 = (i3 + i4) / (this.p + i4);
        if (this.U.f() == 0) {
            return -1;
        }
        return i5;
    }

    public final Rect V(Rect rect, Bitmap bitmap) {
        int i2 = rect.left;
        int i3 = this.o;
        rect.left = i2 + i3;
        rect.top += i3;
        rect.right -= i3;
        rect.bottom -= i3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = height / width;
        int i4 = rect.right;
        int i5 = rect.left;
        int i6 = i4 - i5;
        int i7 = rect.bottom;
        int i8 = rect.top;
        int i9 = i7 - i8;
        if (width > height) {
            int i10 = ((int) (i9 - (i6 * f2))) / 2;
            rect.top = i8 + i10;
            rect.bottom = i7 - i10;
        } else if (width <= height) {
            int i11 = ((int) (i6 - (i9 / f2))) / 2;
            rect.left = i5 + i11;
            rect.right = i4 - i11;
        }
        return rect;
    }

    public final D7.b W(int i2, long j) {
        List d2 = this.U.d(i2);
        if (d2 == null) {
            return null;
        }
        for (int i3 = 0; i3 < d2.size(); i3++) {
            D7.b bVar = (D7.b) d2.get(i3);
            if (bVar.f() <= j && bVar.c() >= j) {
                return bVar;
            }
        }
        return null;
    }

    public final int X(int i2, long j) {
        List d2 = this.U.d(i2);
        if (d2 == null) {
            return -1;
        }
        for (int i3 = 0; i3 < d2.size(); i3++) {
            D7.b bVar = (D7.b) d2.get(i3);
            if (bVar.f() <= j && bVar.c() >= j) {
                return i3;
            }
        }
        return -1;
    }

    public final long Y(int i2) {
        return (i2 * this.N) + this.O;
    }

    public final int Z(int i2) {
        int i3 = this.p;
        int i4 = this.n;
        return (i2 * (i3 + i4)) + i4 + this.C;
    }

    public void a(Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        try {
            this.a = new DatabaseHandler(context);
            this.c = new LiveStreamDBHandler(context);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.C2, findViewById(a7.f.ke));
            PopupWindow popupWindow = new PopupWindow(context);
            this.l0 = popupWindow;
            popupWindow.setContentView(inflate);
            this.l0.setWidth(-1);
            this.l0.setHeight(-1);
            this.l0.setFocusable(true);
            this.l0.setBackgroundDrawable(new BitmapDrawable());
            this.l0.showAtLocation(inflate, 17, 0, 0);
            RelativeLayout findViewById = inflate.findViewById(a7.f.o9);
            RelativeLayout findViewById2 = inflate.findViewById(a7.f.P8);
            RelativeLayout findViewById3 = inflate.findViewById(a7.f.Q8);
            RelativeLayout findViewById4 = inflate.findViewById(a7.f.A7);
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u")) {
                ArrayList checkFavourite = this.c.checkFavourite(str7, SharepreferenceDBHandler.getUserID(context));
                if (checkFavourite == null || checkFavourite.size() <= 0) {
                    findViewById2.setVisibility(0);
                } else {
                    findViewById3.setVisibility(0);
                }
            } else {
                ArrayList checkFavourite2 = this.a.checkFavourite(i2, str8, "live", SharepreferenceDBHandler.getUserID(context), str9);
                if (checkFavourite2 != null && checkFavourite2.size() > 0) {
                    findViewById3.setVisibility(0);
                }
                findViewById2.setVisibility(0);
            }
            try {
                findViewById.setOnClickListener(new c(context, str, i2, str2, str3, str4, str5, str6, str7, str9));
                findViewById2.setOnClickListener(new d(context, str8, str7, str3, i2, str2, str9));
                findViewById3.setOnClickListener(new e(context, str7, str3, str8, i2, str9));
                try {
                    findViewById4.setOnClickListener(new f());
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    public final int a0(long j) {
        int i2 = (int) ((j - this.O) / this.N);
        int i3 = this.n;
        return i2 + i3 + this.s + i3;
    }

    public void d0() {
        i.a(new i(this, null));
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public final boolean e0(long j, long j2) {
        long j3 = this.P;
        return (j >= j3 && j <= this.Q) || (j2 >= j3 && j2 <= this.Q) || (j <= j3 && j2 >= this.Q);
    }

    public final void f0(Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        int i3;
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            if (this.Y0.booleanValue()) {
                w.y0(getContext(), str, i2, "live", str3, str4, str5, str6, str7, str8, str9);
                return;
            }
            return;
        }
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(context, k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.e1 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new g(str, i2, str3, str4, str5, str6, str7, str8, str9, dialog));
        this.e1.setOnClickListener(new h(str, i2, str3, str4, str5, str6, str7, str8, str9, dialog));
        findViewById2.setOnFocusChangeListener(new w.k(findViewById2, context));
        findViewById2.setOnFocusChangeListener(new b(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        t.q(this.m0).l((String) a2.get(m7.a.k1)).g(findViewById);
                        i3 = m7.a.k1;
                    } else {
                        t.q(this.m0).l((String) a2.get(0)).g(findViewById);
                        i3 = m7.a.k1;
                    }
                    m7.a.k1 = i3 + 1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        findViewById2.requestFocus();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    public final void g0(D7.b bVar) {
        SharedPreferences sharedPreferences = this.m0.getSharedPreferences("timeFormat", 0);
        this.g = sharedPreferences;
        String string = sharedPreferences.getString("timeFormat", m7.a.E0);
        Locale locale = Locale.US;
        this.e = new SimpleDateFormat(string, locale);
        this.f = new SimpleDateFormat(string, locale);
        this.f0.setText(bVar.g());
        this.h0.setText(this.e.format(Long.valueOf(bVar.f())) + " - " + this.f.format(Long.valueOf(bVar.c())));
        this.g0.setText(bVar.b());
        j0(bVar);
    }

    public String getExtensionType() {
        return this.r0;
    }

    public int getOpenedStreamID() {
        return this.o0;
    }

    public String getOpenedVideoUrl() {
        return this.q0;
    }

    public D7.b getSelectedEvent() {
        return this.e0;
    }

    public int getTimeShiftMilliSeconds() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("loginPrefs", 0);
        this.k0 = sharedPreferences;
        return w.J(sharedPreferences.getString("selectedEPGShift", m7.a.C0));
    }

    public String getVideoPathUrl() {
        return this.E0;
    }

    public final C7.b h0(C7.b bVar, C7.b bVar2) {
        if (bVar == null) {
            try {
                bVar = new E7.a(I.h());
            } catch (Throwable th) {
                throw new RuntimeException("Could not merge EPG data: " + th.getClass().getSimpleName() + " " + th.getMessage(), th);
            }
        }
        if (bVar2 != null) {
            for (int i2 = 0; i2 < bVar2.f(); i2++) {
                D7.a c2 = bVar2.c(i2);
                D7.a e2 = bVar.e(c2.g(), c2.f(), c2.l(), c2.i(), c2.d(), c2.b(), c2.m());
                for (int i3 = 0; i3 < c2.e().size(); i3++) {
                    e2.a((D7.b) c2.e().get(i3));
                }
            }
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e9 A[PHI: r13 r14 r15
      0x00e9: PHI (r13v6 android.widget.Scroller) = (r13v0 android.widget.Scroller), (r13v7 android.widget.Scroller) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r14v3 int) = (r14v0 int), (r14v4 int) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r15v3 int) = (r15v0 int), (r15v4 int) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec A[PHI: r13 r14 r15
      0x00ec: PHI (r13v4 android.widget.Scroller) = (r13v0 android.widget.Scroller), (r13v7 android.widget.Scroller) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r14v1 int) = (r14v0 int), (r14v4 int) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r15v1 int) = (r15v0 int), (r15v4 int) binds: [B:44:0x011e, B:28:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i0(D7.b r20, boolean r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.utility.epg.EPG.i0(D7.b, boolean, java.lang.String):void");
    }

    public final void j0(D7.b bVar) {
        int i2;
        NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG;
        NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG2;
        try {
            if (bVar.a() == null || bVar.a().m() == null || bVar.a().m().equals("")) {
                if (bVar.a() == null || bVar.a().l() == null) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(bVar.a().l());
                } catch (NumberFormatException unused) {
                    i2 = -1;
                }
                String l = bVar.a().l();
                if (getOpenedStreamID() != 0) {
                    return;
                }
                I();
                if (SharepreferenceDBHandler.getCurrentAPPType(getContext()).equals("onestream_api")) {
                    setOpenedStreamIDOneStream(l);
                } else {
                    setOpenedStreamID(i2);
                }
                if (this.U0.x() == 3 || this.N0 == null) {
                    return;
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(getContext()).equals("onestream_api")) {
                    this.N0.b0(Uri.parse(getVideoPathUrl() + l + getExtensionType()), true, "");
                } else {
                    this.N0.b0(Uri.parse(getVideoPathUrl() + i2 + getExtensionType()), true, "");
                }
                nSTIJKPlayerSmallEPG = this.N0;
                nSTIJKPlayerSmallEPG.J = 0;
            } else {
                if (getOpenedVideoUrl() == null || !getOpenedVideoUrl().equals("")) {
                    return;
                }
                I();
                setOpenedVideoUrl(bVar.a().m());
                if (this.U0.x() == 3 || (nSTIJKPlayerSmallEPG2 = this.N0) == null) {
                    return;
                }
                nSTIJKPlayerSmallEPG2.b0(Uri.parse(bVar.a().m()), true, "");
                nSTIJKPlayerSmallEPG = this.N0;
                nSTIJKPlayerSmallEPG.J = 0;
            }
            nSTIJKPlayerSmallEPG.L = false;
            nSTIJKPlayerSmallEPG.start();
        } catch (Exception unused2) {
        }
    }

    public void k0(D7.b bVar, boolean z, RelativeLayout relativeLayout, EPG epg) {
        C7.b bVar2 = this.U;
        if (bVar2 == null || !bVar2.b()) {
            return;
        }
        o0();
        B();
        A();
        Boolean bool = Boolean.FALSE;
        if (!this.P0.booleanValue()) {
            if (bVar != null) {
                this.P0 = Boolean.TRUE;
            } else {
                int i2 = 0;
                if (X(0, Y(getXPositionStart() + (getWidth() / 2))) != -1) {
                    bool = Boolean.TRUE;
                    this.P0 = bool;
                    bVar = this.U.a(0, X(0, System.currentTimeMillis() + getTimeShiftMilliSeconds()));
                } else if (this.U != null) {
                    while (true) {
                        if (i2 >= this.U.f()) {
                            break;
                        }
                        List e2 = this.U.c(i2).e();
                        if (e2 == null || e2.size() == 0) {
                            i2++;
                        } else {
                            bool = Boolean.TRUE;
                            int c2 = this.U.c(i2).c();
                            int X = X(c2, Y(getXPositionStart() + (getWidth() / 2)));
                            if (X != -1) {
                                this.P0 = bool;
                                bVar = this.U.a(c2, X);
                            }
                        }
                    }
                }
            }
            q0(bVar, z);
        }
        if (bool.equals(Boolean.TRUE) && relativeLayout != null) {
            relativeLayout.setFocusable(true);
            relativeLayout.setNextFocusDownId(a7.f.S2);
        }
        l0();
    }

    public void l0() {
        invalidate();
        requestLayout();
    }

    public final void m0(Context context, String str, int i2, String str2, String str3) {
        DatabaseHandler databaseHandler;
        if (context == null || (databaseHandler = this.a) == null) {
            return;
        }
        databaseHandler.deleteFavourite(i2, str, "live", str2, SharepreferenceDBHandler.getUserID(context), str3);
        w.P0(context, str2 + context.getResources().getString(j.c6));
    }

    public final void n0(Context context, String str, String str2) {
        LiveStreamDBHandler liveStreamDBHandler;
        if (context == null || (liveStreamDBHandler = this.c) == null) {
            return;
        }
        liveStreamDBHandler.deleteFavourite(str, SharepreferenceDBHandler.getUserID(context));
        w.P0(context, str2 + context.getResources().getString(j.c6));
    }

    public final void o0() {
        this.N = C();
        this.O = F();
        this.P = Y(getWidth());
        this.Q = Y(getWidth());
    }

    public void onDraw(Canvas canvas) {
        C7.b bVar = this.U;
        if (bVar == null || !bVar.b()) {
            return;
        }
        this.P = Y(getScrollX());
        this.Q = Y(getScrollX() + getWidth());
        Rect rect = this.i;
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + getHeight();
        N(canvas, rect);
        L(canvas, rect);
        Q(canvas, rect);
        P(canvas, rect);
        String A = this.U0.A();
        if (!A.equals(m7.a.K0)) {
            O(canvas, rect);
        }
        if (this.l.computeScrollOffset()) {
            scrollTo(this.l.getCurrX(), this.l.getCurrY());
            if (this.R0) {
                return;
            }
            this.R0 = true;
            long currentTimeMillis = System.currentTimeMillis() + getTimeShiftMilliSeconds();
            scrollTo(A.equals(m7.a.K0) ? ((a0(currentTimeMillis) - this.s) + this.n) - 200 : ((a0(currentTimeMillis) - this.s) + this.n) - 100, 0);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        String str;
        int i3;
        D7.b W;
        this.P = Y(getScrollX());
        this.Q = Y(getScrollX() + getWidth());
        if (keyEvent.getKeyCode() != 4 && this.e0 != null) {
            String str2 = "horizontal";
            if (keyEvent.getKeyCode() == 22) {
                if (this.e0.d() != null) {
                    D7.b bVar = this.e0;
                    bVar.i = false;
                    W = bVar.d();
                    this.e0 = W;
                    W.i = true;
                    i0(W, true, str2);
                }
            } else if (keyEvent.getKeyCode() != 21) {
                str2 = "vertical";
                if (keyEvent.getKeyCode() == 19) {
                    if (this.e0.a().k() == null || this.e0.a().k().c() == this.W.c()) {
                        super.requestFocus();
                        super.requestFocusFromTouch();
                    } else {
                        long max = (Math.max(this.P, this.e0.f()) + Math.min(this.Q, this.e0.c())) / 2;
                        D7.b W2 = W(this.e0.a().k().c(), max);
                        if (W2 != null) {
                            this.e0.i = false;
                            this.e0 = W2;
                            W2.i = true;
                        } else {
                            G(this.e0.a().k().c(), max);
                        }
                        W = this.e0;
                        i0(W, true, str2);
                    }
                } else if (keyEvent.getKeyCode() == 20) {
                    if (this.e0.a().h() != null) {
                        W = W(this.e0.a().h().c(), (Math.max(this.P, this.e0.f()) + Math.min(this.Q, this.e0.c())) / 2);
                        if (W == null) {
                            if (this.S0 == 1) {
                                i.b(new i(this, null));
                            }
                            return true;
                        }
                        this.e0.i = false;
                        this.e0 = W;
                        W.i = true;
                        i0(W, true, str2);
                    }
                } else if (keyEvent.getKeyCode() == 103 || keyEvent.getKeyCode() == 90) {
                    b0(this.e0);
                } else if (keyEvent.getKeyCode() == 102 || keyEvent.getKeyCode() == 89) {
                    c0(this.e0);
                } else if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 23) {
                    Context context = getContext();
                    getContext();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("selectedPlayer", 0);
                    this.j0 = sharedPreferences;
                    String str3 = "";
                    String string = sharedPreferences.getString("selectedPlayer", "");
                    String j = this.e0.a().j();
                    String b2 = this.e0.a().b();
                    try {
                        str3 = this.e0.a().l();
                        i3 = Integer.parseInt(this.e0.a().l());
                        str = str3;
                    } catch (NumberFormatException unused) {
                        str = str3;
                        i3 = -1;
                    }
                    a(getContext(), string, i3, this.e0.a().i(), this.e0.a().g(), this.e0.a().d(), this.e0.a().f(), j, this.e0.a().m(), b2, str);
                }
            } else if (this.e0.e() != null) {
                D7.b bVar2 = this.e0;
                bVar2.i = false;
                W = bVar2.e();
                this.e0 = W;
                W.i = true;
                i0(W, true, str2);
            }
            g0(this.e0);
            l0();
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof D7.c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        D7.c cVar = (D7.c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.e0 = cVar.a();
    }

    public Parcelable onSaveInstanceState() {
        D7.c cVar = new D7.c(super.onSaveInstanceState());
        cVar.c(this.e0);
        return cVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        k0(this.e0, false, null, null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.m.onTouchEvent(motionEvent);
    }

    public void p0() {
        long currentTimeMillis = System.currentTimeMillis() + getTimeShiftMilliSeconds();
        boolean equals = this.U0.A().equals(m7.a.K0);
        int a0 = (a0(currentTimeMillis) - this.s) + this.n;
        scrollTo(equals ? a0 - 200 : a0 - 100, getScrollY());
    }

    public void q0(D7.b bVar, boolean z) {
        D7.b bVar2 = this.e0;
        if (bVar2 != null) {
            bVar2.i = false;
        }
        bVar.i = true;
        this.e0 = bVar;
        i0(bVar, z, "vertical");
        g0(bVar);
        l0();
    }

    public void r0(Activity activity, NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        this.O0 = activity;
        this.N0 = nSTIJKPlayerSmallEPG;
    }

    public final void s0(int i2, long j, long j2, Rect rect) {
        rect.left = a0(j);
        rect.top = Z(i2);
        rect.right = a0(j2) - this.n;
        rect.bottom = rect.top + this.p;
    }

    public void setActivity(Activity activity) {
        this.O0 = activity;
    }

    public void setCurrentEventDescriptionTextView(TextView textView) {
        this.g0 = textView;
    }

    public void setCurrentEventTextView(TextView textView) {
        this.f0 = textView;
    }

    public void setCurrentEventTimeTextView(TextView textView) {
        this.h0 = textView;
    }

    public void setEPGClickListener(C7.a aVar) {
        this.K = aVar;
    }

    public void setEPGData(C7.b bVar) {
        try {
            C7.b h0 = h0(this.U, bVar);
            this.U = h0;
            if (h0 == null || h0.f() <= 0) {
                return;
            }
            this.V = this.U.c(0);
            this.W = this.U.c(r2.f() - 1);
        } catch (Exception unused) {
        }
    }

    public void setExtensionType(String str) {
        this.r0 = str;
    }

    public void setLoader(ProgressBar progressBar) {
        this.n0 = progressBar;
    }

    public void setOpenedStreamID(int i2) {
        this.o0 = i2;
    }

    public void setOpenedStreamIDOneStream(String str) {
        this.p0 = str;
    }

    public void setOpenedVideoUrl(String str) {
        this.q0 = str;
    }

    public void setOrientation(int i2) {
        this.i0 = i2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        i1 = displayMetrics.widthPixels;
        j1 = displayMetrics.heightPixels;
    }

    public void setVideoPathUrl(String str) {
        this.E0 = str;
    }

    public void setVideoStatus(LinearLayout linearLayout) {
        this.B0 = linearLayout;
    }

    public void setVideoStatusText(TextView textView) {
        this.C0 = textView;
    }

    public void setVideoView(SurfaceView surfaceView) {
        this.L0 = surfaceView;
    }

    public final boolean t0(long j) {
        return j >= this.P && j < this.Q;
    }

    public void x(Context context, String str, int i2, String str2, String str3, String str4) {
        if (context == null || this.a == null) {
            return;
        }
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(str);
        favouriteDBModel.setStreamID(i2);
        favouriteDBModel.setStreamIDOneStream(str4);
        favouriteDBModel.setNum(str3);
        favouriteDBModel.setName(str2);
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(context));
        this.a.addToFavourite(favouriteDBModel, "live");
        w.P0(context, str2 + context.getResources().getString(j.q));
    }

    public final void y(Context context, String str, String str2, String str3) {
        if (context == null || this.c == null) {
            return;
        }
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(str2);
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(context));
        favouriteM3UModel.setName(str3);
        favouriteM3UModel.setCategoryID(str);
        this.c.addToFavourite(favouriteM3UModel);
        w.P0(context, str3 + context.getResources().getString(j.q));
    }

    public final Rect z() {
        this.j.top = this.C;
        int f2 = this.U.f() * (this.p + this.n);
        Rect rect = this.j;
        if (f2 >= getHeight()) {
            f2 = getHeight();
        }
        rect.bottom = f2;
        Rect rect2 = this.j;
        rect2.left = 0;
        rect2.right = this.s;
        return rect2;
    }

    public EPG(Context context, AttributeSet attributeSet, int i2) {
        String str;
        String str2;
        super(context, attributeSet, i2);
        this.d = getClass().getSimpleName();
        this.T = 200000L;
        this.U = null;
        this.V = null;
        this.W = null;
        this.e0 = null;
        this.q0 = "";
        this.s0 = -1;
        this.t0 = 0;
        this.u0 = 1;
        this.v0 = 2;
        this.w0 = 3;
        this.x0 = 4;
        this.y0 = 5;
        this.z0 = 0;
        this.A0 = false;
        this.D0 = 5000L;
        this.F0 = 0;
        this.G0 = 5;
        this.I0 = false;
        this.M0 = 3;
        Boolean bool = Boolean.FALSE;
        this.P0 = bool;
        this.Q0 = 0;
        this.R0 = false;
        this.W0 = false;
        this.X0 = false;
        this.Y0 = Boolean.TRUE;
        this.m0 = context;
        this.J0 = new Handler();
        this.K0 = new Handler();
        this.U0 = new u7.a(context);
        this.H0 = context.getSharedPreferences("loginPrefs", 0);
        setWillNotDraw(false);
        o0();
        this.n = getResources().getDimensionPixelSize(a7.d.b);
        this.s = getResources().getDimensionPixelSize(a7.d.e);
        this.r = getResources().getDimensionPixelSize(a7.d.f);
        this.D = getResources().getDimensionPixelSize(a7.d.l);
        if (this.U0.A().equals(m7.a.K0)) {
            h1 = 14400000;
            this.s += 125;
            this.r += 95;
        }
        this.i = new Rect();
        this.h = new Rect();
        this.j = new Rect();
        this.k = new Paint(1);
        this.m = new GestureDetector(context, new i(this, null));
        this.I = I.f();
        this.J = I.f();
        this.l = new Scroller(context);
        this.H = getResources().getColor(a7.c.m);
        this.o = getResources().getDimensionPixelSize(a7.d.d);
        this.p = getResources().getDimensionPixelSize(a7.d.a);
        this.q = getResources().getDimensionPixelSize(a7.d.c);
        this.t = getResources().getColor(a7.c.o);
        this.u = getResources().getColor(a7.c.o);
        this.v = getResources().getColor(a7.c.n);
        this.w = getResources().getColor(a7.c.r);
        this.x = getResources().getColor(a7.c.o);
        this.y = getResources().getColor(a7.c.p);
        this.z = getResources().getDimensionPixelSize(a7.d.g);
        this.C = getResources().getDimensionPixelSize(a7.d.j);
        this.A = getResources().getDimensionPixelSize(a7.d.k);
        this.B = getResources().getColor(a7.c.r);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a7.d.i);
        this.E = dimensionPixelSize;
        this.F = getResources().getDimensionPixelSize(a7.d.h);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = dimensionPixelSize;
        options.outHeight = dimensionPixelSize;
        this.G = BitmapFactory.decodeResource(getResources(), a7.e.v1, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.outWidth = dimensionPixelSize;
        options2.outHeight = dimensionPixelSize;
        this.c1 = w.S0(w7.a.a());
        l1 = context.getApplicationContext().getPackageName();
        m1 = T(context);
        this.d1 = w.S0(w7.d.d());
        Locale locale = Locale.US;
        this.b1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.a1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.Z0 = new Date();
        SimpleDateFormat simpleDateFormat = this.b1;
        if (J(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(context))), this.a1.format(this.Z0)) < w7.c.p() || (str = this.c1) == null || this.d1 == null) {
            return;
        }
        if (m1.equals(str) && (this.c1 == null || (str2 = this.d1) == null || l1.equals(str2))) {
            return;
        }
        this.Y0 = bool;
    }

    public final void b0(D7.b bVar) {
    }

    public final void c0(D7.b bVar) {
    }
}
