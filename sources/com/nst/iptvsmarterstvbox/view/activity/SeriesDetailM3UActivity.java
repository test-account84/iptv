package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.callback.SearchTMDBTVShowsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo;
import com.nst.iptvsmarterstvbox.model.pojo.TMDBTrailerPojo;
import d.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.w;
import p7.t0;
import p7.u0;
import p7.v0;
import p7.w0;
import p7.x0;
import p7.y0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesDetailM3UActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.l {
    public static String Y0;
    public static String Z0;
    public TextView A;
    public TextView B;
    public TextView C;
    public DatabaseHandler C0;
    public TextView D;
    public PopupWindow D0;
    public TextView E;
    public Button E0;
    public TextView F;
    public String F0;
    public TextView G;
    public String G0;
    public TextView H;
    public TextView H0;
    public TextView I;
    public TextView I0;
    public TextView J;
    public TextView J0;
    public RatingBar K;
    public MenuItem K0;
    public ImageView L;
    public Menu L0;
    public TextView M;
    public Button M0;
    public TextView N;
    public ProgressBar O;
    public n7.i O0;
    public TextView P;
    public LinearLayout P0;
    public TextView Q;
    public LinearLayout Q0;
    public TextView R;
    public LinearLayout R0;
    public LinearLayout S;
    public String S0;
    public ScrollView T;
    public SimpleDateFormat T0;
    public LinearLayout U;
    public DateFormat U0;
    public LinearLayout V;
    public Date V0;
    public LinearLayout W;
    public String W0;
    public LinearLayout X;
    public LinearLayout Y;
    public LinearLayout Z;
    public LinearLayout e0;
    public LinearLayout f0;
    public LinearLayout g0;
    public LinearLayout h0;
    public TextView i0;
    public TextView j0;
    public TextView k0;
    public RelativeLayout l0;
    public Context m0;
    public ProgressDialog n0;
    public SharedPreferences o0;
    public SharedPreferences p0;
    public LiveStreamDBHandler q0;
    public ImageView t;
    public ImageView u;
    public Toolbar v;
    public AppBarLayout w;
    public TextView x;
    public RelativeLayout y;
    public ImageView z;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public DatabaseUpdatedStatusDBModel r0 = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel s0 = new DatabaseUpdatedStatusDBModel();
    public String t0 = "";
    public String u0 = "";
    public String v0 = "";
    public String w0 = "";
    public String x0 = "";
    public String y0 = "";
    public String z0 = "";
    public int A0 = -1;
    public String B0 = "";
    public String N0 = "";
    public Boolean X0 = Boolean.TRUE;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            SeriesDetailM3UActivity.B1(SeriesDetailM3UActivity.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            SeriesDetailM3UActivity.B1(SeriesDetailM3UActivity.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            SeriesDetailM3UActivity.B1(SeriesDetailM3UActivity.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            SeriesDetailM3UActivity.B1(SeriesDetailM3UActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            w.j(SeriesDetailM3UActivity.A1(SeriesDetailM3UActivity.this));
        }
    }

    public class f extends o2.g {
        public f() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            SeriesDetailM3UActivity.this.w.setBackground(new BitmapDrawable(bitmap));
            SeriesDetailM3UActivity seriesDetailM3UActivity = SeriesDetailM3UActivity.this;
            seriesDetailM3UActivity.l0.setBackgroundColor(seriesDetailM3UActivity.getResources().getColor(a7.c.A));
            SeriesDetailM3UActivity seriesDetailM3UActivity2 = SeriesDetailM3UActivity.this;
            seriesDetailM3UActivity2.v.setBackgroundColor(seriesDetailM3UActivity2.getResources().getColor(a7.c.A));
        }
    }

    public class g extends o2.g {
        public g() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            SeriesDetailM3UActivity.this.z.setBackground(new BitmapDrawable(bitmap));
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SeriesDetailM3UActivity.A1(SeriesDetailM3UActivity.this));
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SeriesDetailM3UActivity.A1(SeriesDetailM3UActivity.this));
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class n implements View.OnFocusChangeListener {
        public final View a;

        public n(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("1")) {
                    a(f);
                    b(f);
                    view2 = this.a;
                } else if (this.a.getTag().equals("2")) {
                    a(f);
                    b(f);
                    view2 = this.a;
                    i = a7.e.k1;
                } else if (this.a.getTag().equals("3") || this.a.getTag().equals("5")) {
                    a(f);
                    b(f);
                    view2 = this.a;
                    i = a7.e.p;
                } else {
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("8")) {
                        a(1.15f);
                        b(1.15f);
                        return;
                    } else {
                        a(f);
                        b(f);
                        view2 = SeriesDetailM3UActivity.this.M0;
                    }
                }
                i = a7.e.h;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (this.a.getTag().equals("1") || this.a.getTag().equals("2") || this.a.getTag().equals("3") || this.a.getTag().equals("5")) {
                    view2 = this.a;
                } else if (this.a.getTag() == null || !this.a.getTag().equals("8")) {
                    return;
                } else {
                    view2 = SeriesDetailM3UActivity.this.M0;
                }
                i = a7.e.o;
            }
            view2.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ Context A1(SeriesDetailM3UActivity seriesDetailM3UActivity) {
        return seriesDetailM3UActivity.m0;
    }

    public static /* synthetic */ PopupWindow B1(SeriesDetailM3UActivity seriesDetailM3UActivity) {
        return seriesDetailM3UActivity.D0;
    }

    private void C1() {
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(this.s);
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.m0));
        favouriteM3UModel.setName(this.d);
        favouriteM3UModel.setCategoryID(this.k);
        this.q0.addToFavourite(favouriteM3UModel);
        this.A.setText(getResources().getString(a7.j.e6));
        this.L.setVisibility(0);
    }

    private void D1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static long E1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String F1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void G1() {
        this.m0 = this;
        this.C0 = new DatabaseHandler(this.m0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.o0 = sharedPreferences;
        String string = sharedPreferences.getString("username", "");
        String string2 = this.o0.getString("password", "");
        if (string == null || string2 == null || string.isEmpty() || string2.isEmpty()) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            S1(this.m0, string, string2);
        }
    }

    public static /* synthetic */ void L1(View view) {
    }

    private void O1() {
        this.q0.deleteFavourite(this.s, SharepreferenceDBHandler.getUserID(this.m0));
        this.A.setText(getResources().getString(a7.j.r));
        this.L.setVisibility(4);
    }

    private void S1(Context context, String str, String str2) {
        ImageView imageView;
        TextView textView;
        String str3;
        this.O0 = new n7.i(this, context);
        int i2 = 0;
        this.T.setVisibility(0);
        Intent intent = getIntent();
        if (intent != null) {
            this.d = intent.getStringExtra("episode_name");
            this.q = intent.getStringExtra("series_name");
            this.r = intent.getStringExtra("series_icon");
            this.s = intent.getStringExtra("episode_url");
            this.z0 = intent.getStringExtra("series_num");
            this.k = intent.getStringExtra("series_categoryId");
            if (this.q0.checkFavourite(this.s, SharepreferenceDBHandler.getUserID(context)).size() > 0) {
                this.A.setText(getResources().getString(a7.j.e6));
                imageView = this.L;
            } else {
                this.A.setText(getResources().getString(a7.j.r));
                imageView = this.L;
                i2 = 4;
            }
            imageView.setVisibility(i2);
            if (context != null && (str3 = this.r) != null && !str3.isEmpty()) {
                O1.g.u(context).q(this.r).I().m(new g());
            }
            if (this.v0 != null && (textView = this.B) != null) {
                textView.setText(this.d);
            }
            this.O0.d(this.q);
        }
    }

    public static /* synthetic */ void u1(SeriesDetailM3UActivity seriesDetailM3UActivity, View view) {
        seriesDetailM3UActivity.K1(view);
    }

    public static /* synthetic */ void v1(SeriesDetailM3UActivity seriesDetailM3UActivity, View view) {
        seriesDetailM3UActivity.H1(view);
    }

    public static /* synthetic */ void w1(View view) {
        L1(view);
    }

    public static /* synthetic */ void x1(SeriesDetailM3UActivity seriesDetailM3UActivity, View view) {
        seriesDetailM3UActivity.J1(view);
    }

    public static /* synthetic */ void y1(SeriesDetailM3UActivity seriesDetailM3UActivity, View view) {
        seriesDetailM3UActivity.I1(view);
    }

    public static /* synthetic */ void z1(SeriesDetailM3UActivity seriesDetailM3UActivity, View view) {
        seriesDetailM3UActivity.M1(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0150 A[PHI: r7
      0x0150: PHI (r7v5 android.widget.TextView) = (r7v4 android.widget.TextView), (r7v14 android.widget.TextView) binds: [B:69:0x014e, B:57:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0093 A[PHI: r2
      0x0093: PHI (r2v3 android.widget.TextView) = (r2v2 android.widget.TextView), (r2v12 android.widget.TextView) binds: [B:86:0x0091, B:77:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C0(com.nst.iptvsmarterstvbox.model.callback.TMDBTVShowsInfoCallback r7) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailM3UActivity.C0(com.nst.iptvsmarterstvbox.model.callback.TMDBTVShowsInfoCallback):void");
    }

    public void H0(TMDBTrailerCallback tMDBTrailerCallback) {
        if (tMDBTrailerCallback == null || tMDBTrailerCallback.getResults() == null || tMDBTrailerCallback.getResults().size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < tMDBTrailerCallback.getResults().size(); i2++) {
            if (((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i2)).getType().equals("Trailer")) {
                this.m = ((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i2)).getKey();
                TextView textView = this.k0;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
        }
    }

    public final /* synthetic */ void H1(View view) {
        String str;
        String str2;
        SharedPreferences sharedPreferences = this.m0.getSharedPreferences("selectedPlayer", 0);
        this.p0 = sharedPreferences;
        String string = sharedPreferences.getString("selectedPlayer", "");
        SimpleDateFormat simpleDateFormat = this.T0;
        if (E1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.m0))), this.U0.format(this.V0)) >= w7.c.p() && (str = this.S0) != null && this.W0 != null && (!Z0.equals(str) || (this.S0 != null && (str2 = this.W0) != null && !Y0.equals(str2)))) {
            this.X0 = Boolean.FALSE;
        }
        if (this.X0.booleanValue()) {
            try {
                w.v0(this.m0, string, 0, "series", "", this.z0, this.d, (List) null, this.s, "", "");
            } catch (Exception unused) {
            }
        }
    }

    public final /* synthetic */ void I1(View view) {
        if (this.q0.checkFavourite(this.s, SharepreferenceDBHandler.getUserID(this.m0)).size() > 0) {
            O1();
        } else {
            C1();
        }
    }

    public final /* synthetic */ void M1(View view) {
        String str = this.m;
        if (str == null || str.isEmpty()) {
            N1(this);
        } else {
            startActivity(new Intent(this, YouTubePlayerActivity.class).putExtra("you_tube_trailer", this.m));
        }
    }

    public final void N1(SeriesDetailM3UActivity seriesDetailM3UActivity) {
        View inflate = ((LayoutInflater) seriesDetailM3UActivity.getSystemService("layout_inflater")).inflate(a7.g.l3, seriesDetailM3UActivity.findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(seriesDetailM3UActivity);
        this.D0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.D0.setWidth(-1);
        this.D0.setHeight(-1);
        this.D0.setFocusable(true);
        this.D0.setBackgroundDrawable(new BitmapDrawable());
        this.D0.showAtLocation(inflate, 17, 0, 0);
        this.M0 = inflate.findViewById(a7.f.H0);
        TextView findViewById = inflate.findViewById(a7.f.j3);
        this.E0 = inflate.findViewById(a7.f.o0);
        findViewById.setText("Series trailer is not available");
        Button button = this.M0;
        if (button != null) {
            button.setOnFocusChangeListener(new n(button));
        }
        Button button2 = this.E0;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new n(button2));
        }
        this.E0.setOnClickListener(new c());
        this.M0.setOnClickListener(new d());
    }

    public void P1() {
        this.C.setOnClickListener(new t0(this));
        this.A.setOnClickListener(new u0(this));
        this.i0.setOnClickListener(new v0(this));
        this.j0.setOnClickListener(new w0(this));
        this.P.setOnClickListener(new x0());
        this.k0.setOnClickListener(new y0(this));
    }

    public void Q(TMDBCastsCallback tMDBCastsCallback) {
    }

    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public final void J1(SeriesDetailM3UActivity seriesDetailM3UActivity) {
        View inflate = ((LayoutInflater) seriesDetailM3UActivity.getSystemService("layout_inflater")).inflate(a7.g.g3, seriesDetailM3UActivity.findViewById(a7.f.We));
        this.H0 = inflate.findViewById(a7.f.Wh);
        TextView findViewById = inflate.findViewById(a7.f.Ik);
        this.J0 = findViewById;
        findViewById.setText(getResources().getString(a7.j.w5));
        this.H0.setText(this.F0);
        PopupWindow popupWindow = new PopupWindow(seriesDetailM3UActivity);
        this.D0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.D0.setWidth(-1);
        this.D0.setHeight(-1);
        this.D0.setFocusable(true);
        this.D0.showAtLocation(inflate, 17, 0, 0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        this.E0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new n(findViewById2));
        }
        this.E0.setOnClickListener(new a());
    }

    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public final void K1(SeriesDetailM3UActivity seriesDetailM3UActivity) {
        View inflate = ((LayoutInflater) seriesDetailM3UActivity.getSystemService("layout_inflater")).inflate(a7.g.i3, seriesDetailM3UActivity.findViewById(a7.f.We));
        TextView findViewById = inflate.findViewById(a7.f.Aj);
        this.I0 = findViewById;
        findViewById.setText(this.G0);
        PopupWindow popupWindow = new PopupWindow(seriesDetailM3UActivity);
        this.D0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.D0.setWidth(-1);
        this.D0.setHeight(-1);
        this.D0.setFocusable(true);
        this.D0.showAtLocation(inflate, 17, 0, 0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        this.E0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new n(findViewById2));
        }
        this.E0.setOnClickListener(new b());
    }

    public void a() {
    }

    public void b() {
        ProgressDialog progressDialog = this.n0;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void d(String str) {
        this.P0.setVisibility(8);
        this.R0.setVisibility(0);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.O0);
        this.u = findViewById(a7.f.Xa);
        this.v = findViewById(a7.f.kh);
        this.w = findViewById(a7.f.W);
        this.x = findViewById(a7.f.qh);
        this.y = findViewById(a7.f.Nd);
        this.z = findViewById(a7.f.B5);
        this.A = findViewById(a7.f.xh);
        this.B = findViewById(a7.f.lk);
        this.C = findViewById(a7.f.Pk);
        this.D = findViewById(a7.f.kk);
        this.E = findViewById(a7.f.Hi);
        this.F = findViewById(a7.f.Ii);
        this.G = findViewById(a7.f.Rh);
        this.H = findViewById(a7.f.Th);
        this.I = findViewById(a7.f.tl);
        this.J = findViewById(a7.f.ul);
        this.K = findViewById(a7.f.bd);
        this.L = findViewById(a7.f.g5);
        this.M = findViewById(a7.f.ik);
        this.N = findViewById(a7.f.zj);
        this.O = findViewById(a7.f.Ei);
        this.P = findViewById(a7.f.Fi);
        this.Q = findViewById(a7.f.gk);
        this.R = findViewById(a7.f.hk);
        this.S = findViewById(a7.f.R8);
        this.T = findViewById(a7.f.Tf);
        this.U = findViewById(a7.f.I7);
        this.V = findViewById(a7.f.H9);
        this.W = findViewById(a7.f.S7);
        this.X = findViewById(a7.f.r8);
        this.Y = findViewById(a7.f.p7);
        this.Z = findViewById(a7.f.J7);
        this.e0 = findViewById(a7.f.I9);
        this.f0 = findViewById(a7.f.T7);
        this.g0 = findViewById(a7.f.s8);
        this.h0 = findViewById(a7.f.q7);
        this.i0 = findViewById(a7.f.kl);
        this.j0 = findViewById(a7.f.ll);
        this.k0 = findViewById(a7.f.qm);
        this.l0 = findViewById(a7.f.vf);
        this.P0 = findViewById(a7.f.E7);
        this.Q0 = findViewById(a7.f.F7);
        this.R0 = findViewById(a7.f.G7);
        overridePendingTransition(a7.b.f, a7.b.d);
        this.m0 = this;
        P1();
        AppBarLayout appBarLayout = this.w;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.H));
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setOnFocusChangeListener(new n(textView));
            this.C.requestFocus();
            this.C.setFocusable(true);
        }
        TextView textView2 = this.A;
        if (textView2 != null) {
            textView2.setOnFocusChangeListener(new n(textView2));
        }
        TextView textView3 = this.P;
        if (textView3 != null) {
            textView3.setOnFocusChangeListener(new n(textView3));
        }
        TextView textView4 = this.i0;
        if (textView4 != null) {
            textView4.setOnFocusChangeListener(new n(textView4));
        }
        TextView textView5 = this.j0;
        if (textView5 != null) {
            textView5.setOnFocusChangeListener(new n(textView5));
        }
        TextView textView6 = this.k0;
        if (textView6 != null) {
            textView6.setOnFocusChangeListener(new n(textView6));
        }
        this.S0 = w.S0(w7.a.a());
        Locale locale = Locale.US;
        this.T0 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.V0 = new Date();
        this.U0 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        Y0 = getApplicationContext().getPackageName();
        this.W0 = w.S0(w7.d.d());
        Z0 = F1(this.m0);
        getWindow().setFlags(1024, 1024);
        r1(findViewById(a7.f.kh));
        D1();
        SharepreferenceDBHandler.setCurrentAPPType("m3u", this.m0);
        this.q0 = new LiveStreamDBHandler(this.m0);
        this.u.setOnClickListener(new e());
        G1();
        SharedPreferences sharedPreferences = this.m0.getSharedPreferences("selectedPlayer", 0);
        this.p0 = sharedPreferences;
        this.w0 = sharedPreferences.getString("selectedPlayer", "");
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.v.x(a7.h.v);
        this.L0 = menu;
        this.K0 = menu.getItem(1).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.v.getChildCount(); i2++) {
            if (this.v.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.v.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.L0;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.K0 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.m0) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new i()).g(getResources().getString(a7.j.d4), new h()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.m0.getResources().getString(a7.j.u0));
            aVar.f(this.m0.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.m0.getResources().getString(a7.j.S8), new j());
            aVar.g(this.m0.getResources().getString(a7.j.d4), new k());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.m0.getResources().getString(a7.j.u0));
            aVar2.f(this.m0.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.m0.getResources().getString(a7.j.S8), new l());
            aVar2.g(this.m0.getResources().getString(a7.j.d4), new m());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.m0);
        w.z0(this.m0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.o0 = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.o0.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.m0 != null) {
            b();
        }
    }

    public void u0(SearchTMDBTVShowsCallback searchTMDBTVShowsCallback) {
        TextView textView;
        TextView textView2;
        StringBuilder sb;
        String str;
        if (searchTMDBTVShowsCallback == null || searchTMDBTVShowsCallback.getTotalResults() == null || !searchTMDBTVShowsCallback.getTotalResults().equals(1) || searchTMDBTVShowsCallback.getResults() == null || searchTMDBTVShowsCallback.getResults().get(0) == null) {
            String str2 = this.d;
            if (str2 != null && (textView2 = this.B) != null) {
                textView2.setText(str2);
            }
            TextView textView3 = this.R;
            if (textView3 != null) {
                textView3.setText("N/A");
            }
            TextView textView4 = this.H;
            if (textView4 != null) {
                textView4.setText("N/A");
            }
            TextView textView5 = this.F;
            if (textView5 != null) {
                textView5.setText("N/A");
            }
            TextView textView6 = this.J;
            if (textView6 != null) {
                textView6.setText("N/A");
            }
            TextView textView7 = this.j0;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView textView8 = this.N;
            if (textView8 != null) {
                textView8.setText("N/A");
            }
            TextView textView9 = this.i0;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
            this.P0.setVisibility(8);
            textView = this.R0;
        } else {
            int intValue = ((SearchTMDBTVShowsResultPojo) searchTMDBTVShowsCallback.getResults().get(0)).getId().intValue();
            this.O0.c(intValue);
            this.O0.e(intValue);
            String firstAirDate = ((SearchTMDBTVShowsResultPojo) searchTMDBTVShowsCallback.getResults().get(0)).getFirstAirDate();
            Double voteAverage = ((SearchTMDBTVShowsResultPojo) searchTMDBTVShowsCallback.getResults().get(0)).getVoteAverage();
            this.e = ((SearchTMDBTVShowsResultPojo) searchTMDBTVShowsCallback.getResults().get(0)).getOverview();
            String backdropPath = ((SearchTMDBTVShowsResultPojo) searchTMDBTVShowsCallback.getResults().get(0)).getBackdropPath();
            if (new u7.a(this.m0).A().equals(m7.a.K0)) {
                sb = new StringBuilder();
                str = "https://image.tmdb.org/t/p/w1280/";
            } else {
                sb = new StringBuilder();
                str = "https://image.tmdb.org/t/p/w500/";
            }
            sb.append(str);
            sb.append(backdropPath);
            String sb2 = sb.toString();
            if (this.w != null && backdropPath != null) {
                O1.g.u(getApplicationContext()).q(sb2).I().m(new f());
            }
            if (this.V == null || this.e0 == null || this.J == null || firstAirDate == null || firstAirDate.isEmpty() || firstAirDate.equals("n/A")) {
                LinearLayout linearLayout = this.V;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.e0;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView10 = this.J;
                if (textView10 != null) {
                    textView10.setText("N/A");
                }
            } else {
                this.V.setVisibility(0);
                this.e0.setVisibility(0);
                this.J.setText(firstAirDate);
            }
            if (this.K != null && voteAverage != null && !voteAverage.equals("n/A")) {
                this.K.setVisibility(0);
                try {
                    this.K.setRating(Float.parseFloat(String.valueOf(voteAverage)) / 2.0f);
                } catch (NumberFormatException unused) {
                    this.K.setRating(0.0f);
                }
            }
            String str3 = this.e;
            this.F0 = str3;
            if (this.Y == null || this.h0 == null || this.H == null || str3 == null || str3.isEmpty()) {
                LinearLayout linearLayout3 = this.Y;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.h0;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                TextView textView11 = this.i0;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
                TextView textView12 = this.H;
                if (textView12 != null) {
                    textView12.setText("N/A");
                    return;
                }
                return;
            }
            this.Y.setVisibility(0);
            this.h0.setVisibility(0);
            if (this.e.length() <= 150) {
                this.H.setText(this.e);
                this.i0.setVisibility(8);
                return;
            } else {
                this.H.setText(this.e);
                textView = this.i0;
            }
        }
        textView.setVisibility(0);
    }
}
