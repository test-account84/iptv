package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.callback.TMDBPersonInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.model.pojo.TMDBTrailerPojo;
import d.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k.U;
import m7.w;
import p7.A1;
import p7.x1;
import p7.y1;
import p7.z1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ViewDetailsTMDBActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.k {
    public static String N0;
    public static String O0;
    public LinearLayout A;
    public LinearLayout B;
    public DatabaseHandler B0;
    public LinearLayout C;
    public PopupWindow C0;
    public LinearLayout D;
    public LinearLayout E;
    public LinearLayout F;
    public n7.h F0;
    public LinearLayout G;
    public LinearLayout H;
    public LinearLayout I;
    public q7.f I0;
    public LinearLayout J;
    public LinearLayout K;
    public o4.e K0;
    public TextView L;
    public LinearLayout M;
    public TextView N;
    public RelativeLayout O;
    public ScrollView P;
    public NestedScrollView Q;
    public RecyclerView R;
    public ImageView S;
    public LinearLayout T;
    public LinearLayout U;
    public SimpleDateFormat V;
    public Date W;
    public Button X;
    public String Y;
    public DateFormat Z;
    public String d;
    public String e;
    public String e0;
    public RelativeLayout f;
    public TextView f0;
    public ImageView g;
    public MenuItem g0;
    public Toolbar h;
    public Menu h0;
    public LinearLayout i;
    public Button i0;
    public AppBarLayout j;
    public TextView k;
    public ProgressDialog k0;
    public TextView l;
    public SharedPreferences l0;
    public TextView m;
    public SharedPreferences m0;
    public TextView n;
    public LiveStreamDBHandler n0;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public RatingBar u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    public Context j0 = this;
    public DatabaseUpdatedStatusDBModel o0 = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel p0 = new DatabaseUpdatedStatusDBModel();
    public String q0 = "";
    public String r0 = "";
    public String s0 = "";
    public String t0 = "";
    public String u0 = "";
    public String v0 = "";
    public String w0 = "";
    public String x0 = "";
    public String y0 = "";
    public int z0 = -1;
    public String A0 = "";
    public String D0 = "";
    public Boolean E0 = Boolean.TRUE;
    public String G0 = "mobile";
    public String H0 = "";
    public String J0 = "";
    public ArrayList L0 = new ArrayList();
    public ArrayList M0 = new ArrayList();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this));
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class e extends o2.g {
        public e() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            ViewDetailsTMDBActivity.this.j.setBackground(new BitmapDrawable(bitmap));
            ViewDetailsTMDBActivity viewDetailsTMDBActivity = ViewDetailsTMDBActivity.this;
            viewDetailsTMDBActivity.O.setBackgroundColor(viewDetailsTMDBActivity.getResources().getColor(a7.c.A));
            ViewDetailsTMDBActivity viewDetailsTMDBActivity2 = ViewDetailsTMDBActivity.this;
            viewDetailsTMDBActivity2.h.setBackgroundColor(viewDetailsTMDBActivity2.getResources().getColor(a7.c.A));
        }
    }

    public class f extends o2.g {
        public f() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            ViewDetailsTMDBActivity.this.j.setBackground(new BitmapDrawable(bitmap));
            ViewDetailsTMDBActivity viewDetailsTMDBActivity = ViewDetailsTMDBActivity.this;
            viewDetailsTMDBActivity.O.setBackgroundColor(viewDetailsTMDBActivity.getResources().getColor(a7.c.A));
            ViewDetailsTMDBActivity viewDetailsTMDBActivity2 = ViewDetailsTMDBActivity.this;
            viewDetailsTMDBActivity2.h.setBackgroundColor(viewDetailsTMDBActivity2.getResources().getColor(a7.c.A));
        }
    }

    public class g implements U.d {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ String b;

        public g(ArrayList arrayList, String str) {
            this.a = arrayList;
            this.b = str;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ArrayList arrayList;
            if (ViewDetailsTMDBActivity.K1(ViewDetailsTMDBActivity.this).booleanValue() && (arrayList = this.a) != null && arrayList.size() > 0) {
                int i = 0;
                while (true) {
                    if (i < this.a.size()) {
                        if (menuItem.getItemId() != i) {
                            i++;
                        } else if (menuItem.getItemId() == 0) {
                            w.w0(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this), this.b, ViewDetailsTMDBActivity.y1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.z1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.A1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.B1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.C1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.F1(ViewDetailsTMDBActivity.this), 0, "", "", ViewDetailsTMDBActivity.D1(ViewDetailsTMDBActivity.this));
                        } else {
                            Intent intent = new Intent(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this), PlayExternalPlayerActivity.class);
                            intent.putExtra("url", ViewDetailsTMDBActivity.F1(ViewDetailsTMDBActivity.this));
                            intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                            intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                            ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this).startActivity(intent);
                        }
                    }
                }
                return false;
            }
            return false;
        }
    }

    public class i implements U.d {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ String b;

        public i(ArrayList arrayList, String str) {
            this.a = arrayList;
            this.b = str;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ArrayList arrayList;
            if (ViewDetailsTMDBActivity.K1(ViewDetailsTMDBActivity.this).booleanValue() && (arrayList = this.a) != null && arrayList.size() > 0) {
                int i = 0;
                while (true) {
                    if (i < this.a.size()) {
                        if (menuItem.getItemId() != i) {
                            i++;
                        } else if (menuItem.getItemId() == 0) {
                            w.w0(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this), this.b, ViewDetailsTMDBActivity.y1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.z1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.A1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.B1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.C1(ViewDetailsTMDBActivity.this), ViewDetailsTMDBActivity.F1(ViewDetailsTMDBActivity.this), 0, "", "", ViewDetailsTMDBActivity.D1(ViewDetailsTMDBActivity.this));
                        } else {
                            Intent intent = new Intent(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this), PlayExternalPlayerActivity.class);
                            intent.putExtra("url", ViewDetailsTMDBActivity.F1(ViewDetailsTMDBActivity.this));
                            intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                            intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                            ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this).startActivity(intent);
                        }
                    }
                }
                return false;
            }
            return false;
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            ViewDetailsTMDBActivity.I1(ViewDetailsTMDBActivity.this).dismiss();
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            ViewDetailsTMDBActivity.I1(ViewDetailsTMDBActivity.this).dismiss();
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            ViewDetailsTMDBActivity.I1(ViewDetailsTMDBActivity.this).dismiss();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        public void onClick(View view) {
            w.j(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this));
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            ViewDetailsTMDBActivity.this.onBackPressed();
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public p(Context context) {
            this.a = context;
        }

        public void onClick(View view) {
            if (ViewDetailsTMDBActivity.E1(ViewDetailsTMDBActivity.this).checkFavourite(ViewDetailsTMDBActivity.F1(ViewDetailsTMDBActivity.this), SharepreferenceDBHandler.getUserID(this.a)).size() > 0) {
                ViewDetailsTMDBActivity.H1(ViewDetailsTMDBActivity.this);
            } else {
                ViewDetailsTMDBActivity.G1(ViewDetailsTMDBActivity.this);
            }
        }
    }

    public class q extends o2.g {
        public q() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            ViewDetailsTMDBActivity.this.g.setBackground(new BitmapDrawable(bitmap));
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(ViewDetailsTMDBActivity.J1(ViewDetailsTMDBActivity.this));
        }
    }

    public class t implements View.OnFocusChangeListener {
        public final View a;

        public t(View view) {
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
            LinearLayout linearLayout;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("1")) {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsTMDBActivity.this.T;
                } else if (this.a.getTag().equals("2")) {
                    a(f);
                    b(f);
                    linearLayout = this.a;
                } else if (this.a.getTag().equals("5")) {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsTMDBActivity.this.U;
                } else if (!this.a.getTag().equals("8")) {
                    a(1.15f);
                    b(1.15f);
                    return;
                } else {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsTMDBActivity.this.i0;
                    i = a7.e.h;
                }
                i = a7.e.p;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("1")) {
                    linearLayout = ViewDetailsTMDBActivity.this.T;
                } else {
                    if (this.a.getTag().equals("3")) {
                        linearLayout = this.a;
                    } else if (this.a.getTag().equals("5")) {
                        linearLayout = ViewDetailsTMDBActivity.this.U;
                    } else if (this.a.getTag() == null || !this.a.getTag().equals("8")) {
                        return;
                    } else {
                        linearLayout = ViewDetailsTMDBActivity.this.i0;
                    }
                    i = a7.e.o;
                }
                i = a7.e.A1;
            }
            linearLayout.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ String A1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.w0;
    }

    public static /* synthetic */ String B1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.x0;
    }

    public static /* synthetic */ String C1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.s0;
    }

    public static /* synthetic */ String D1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.A0;
    }

    public static /* synthetic */ LiveStreamDBHandler E1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.n0;
    }

    public static /* synthetic */ String F1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.y0;
    }

    public static /* synthetic */ void G1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        viewDetailsTMDBActivity.L1();
    }

    public static /* synthetic */ void H1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        viewDetailsTMDBActivity.X1();
    }

    public static /* synthetic */ PopupWindow I1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.C0;
    }

    public static /* synthetic */ Context J1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.j0;
    }

    public static /* synthetic */ Boolean K1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.E0;
    }

    private void L1() {
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(this.y0);
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.j0));
        favouriteM3UModel.setName(this.s0);
        favouriteM3UModel.setCategoryID(this.A0);
        this.n0.addToFavourite(favouriteM3UModel);
        if (Build.VERSION.SDK_INT <= 21) {
            this.v.setImageResource(a7.e.V);
        }
        this.v.setImageDrawable(this.j0.getResources().getDrawable(a7.e.V, (Resources.Theme) null));
    }

    private void M1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static long N1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String O1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void Q1() {
        this.f = findViewById(a7.f.Nd);
        this.g = findViewById(a7.f.B5);
        this.h = findViewById(a7.f.kh);
        this.i = findViewById(a7.f.P7);
        this.j = findViewById(a7.f.W);
        this.k = findViewById(a7.f.lk);
        this.l = findViewById(a7.f.Pk);
        this.m = findViewById(a7.f.kk);
        this.n = findViewById(a7.f.Hi);
        this.o = findViewById(a7.f.Ii);
        this.p = findViewById(a7.f.Rh);
        this.q = findViewById(a7.f.Th);
        this.r = findViewById(a7.f.tl);
        this.s = findViewById(a7.f.ul);
        this.t = findViewById(a7.f.Xa);
        this.u = findViewById(a7.f.bd);
        this.v = findViewById(a7.f.g5);
        this.w = findViewById(a7.f.ik);
        this.x = findViewById(a7.f.zj);
        this.y = findViewById(a7.f.gk);
        this.z = findViewById(a7.f.hk);
        this.A = findViewById(a7.f.R8);
        this.B = findViewById(a7.f.I7);
        this.C = findViewById(a7.f.H9);
        this.D = findViewById(a7.f.S7);
        this.E = findViewById(a7.f.r8);
        this.F = findViewById(a7.f.p7);
        this.G = findViewById(a7.f.J7);
        this.H = findViewById(a7.f.I9);
        this.I = findViewById(a7.f.T7);
        this.J = findViewById(a7.f.s8);
        this.K = findViewById(a7.f.q7);
        this.L = findViewById(a7.f.kl);
        this.M = findViewById(a7.f.Ga);
        this.N = findViewById(a7.f.qm);
        this.O = findViewById(a7.f.vf);
        this.P = findViewById(a7.f.Tf);
        this.Q = findViewById(a7.f.Nb);
        this.R = findViewById(a7.f.Df);
        this.S = findViewById(a7.f.F4);
        this.T = findViewById(a7.f.p9);
        this.U = findViewById(a7.f.Ha);
    }

    private void R1() {
        this.n0 = new LiveStreamDBHandler(this.j0);
        this.B0 = new DatabaseHandler(this.j0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.l0 = sharedPreferences;
        String string = sharedPreferences.getString("username", "");
        String string2 = this.l0.getString("password", "");
        if (string.isEmpty() || string2.isEmpty()) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else {
            a2(this.j0, string, string2);
        }
        this.t.setOnClickListener(new n());
        this.S.setOnClickListener(new o());
    }

    private /* synthetic */ void S1(View view) {
        String str;
        String str2;
        SharedPreferences sharedPreferences = this.j0.getSharedPreferences("selectedPlayer", 0);
        this.m0 = sharedPreferences;
        String str3 = "";
        String string = sharedPreferences.getString("selectedPlayer", "");
        SimpleDateFormat simpleDateFormat = this.V;
        if (N1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.j0))), this.Z.format(this.W)) >= w7.c.p() && (str = this.d) != null && this.e != null && (!N0.equals(str) || (this.d != null && (str2 = this.e) != null && !O0.equals(str2)))) {
            this.E0 = Boolean.FALSE;
        }
        if (this.E0.booleanValue()) {
            try {
                o4.e c2 = o4.b.e(this.j0).c().c();
                this.K0 = c2;
                if (c2 != null && c2.c()) {
                    o4.e eVar = this.K0;
                    if (eVar != null && eVar.r() != null && this.K0.r().j() != null && this.K0.r().j().J() != null) {
                        str3 = this.K0.r().j().J();
                    }
                    if (str3.contains(this.y0)) {
                        this.j0.startActivity(new Intent(this.j0, ExpandedControlsActivity.class));
                        return;
                    } else {
                        i7.a.c(0, true, i7.a.a(this.s0, "", "", 0, this.y0, "videos/mp4", this.u0, "", (List) null), this.K0, this.j0);
                        return;
                    }
                }
                new ArrayList();
                ArrayList arrayList = new ArrayList();
                U u = new U(this, view);
                u.c().inflate(a7.h.m, u.b());
                ArrayList externalPlayer = new ExternalPlayerDataBase(this.j0).getExternalPlayer();
                if (externalPlayer != null) {
                    try {
                        if (externalPlayer.size() > 0) {
                            u.b().add(0, 0, 0, this.j0.getResources().getString(a7.j.V3));
                            ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                            externalPlayerModelClass.setId(0);
                            externalPlayerModelClass.setAppname(this.j0.getResources().getString(a7.j.h5));
                            arrayList.add(externalPlayerModelClass);
                            int i2 = 0;
                            while (i2 < externalPlayer.size()) {
                                int i3 = i2 + 1;
                                u.b().add(0, i3, 0, this.j0.getResources().getString(a7.j.h5) + " " + ((ExternalPlayerModelClass) externalPlayer.get(i2)).getAppname());
                                arrayList.add((ExternalPlayerModelClass) externalPlayer.get(i2));
                                i2 = i3;
                            }
                            u.f(new g(arrayList, string));
                            u.e(new h());
                            u.g();
                            return;
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (this.E0.booleanValue()) {
                    w.w0(this.j0, string, this.z0, this.v0, this.w0, this.x0, this.s0, this.y0, 0, "", "", this.A0);
                }
            } catch (Exception unused2) {
                if (this.E0.booleanValue()) {
                    w.w0(this.j0, string, this.z0, this.v0, this.w0, this.x0, this.s0, this.y0, 0, "", "", this.A0);
                }
            }
        }
    }

    private /* synthetic */ void T1(View view) {
        String str;
        String str2;
        SharedPreferences sharedPreferences = this.j0.getSharedPreferences("selectedPlayer", 0);
        this.m0 = sharedPreferences;
        String str3 = "";
        String string = sharedPreferences.getString("selectedPlayer", "");
        SimpleDateFormat simpleDateFormat = this.V;
        if (N1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.j0))), this.Z.format(this.W)) >= w7.c.p() && (str = this.d) != null && this.e != null && (!N0.equals(str) || (this.d != null && (str2 = this.e) != null && !O0.equals(str2)))) {
            this.E0 = Boolean.FALSE;
        }
        if (this.E0.booleanValue()) {
            try {
                o4.e c2 = o4.b.e(this.j0).c().c();
                this.K0 = c2;
                if (c2 != null && c2.c()) {
                    o4.e eVar = this.K0;
                    if (eVar != null && eVar.r() != null && this.K0.r().j() != null && this.K0.r().j().J() != null) {
                        str3 = this.K0.r().j().J();
                    }
                    if (str3.contains(this.y0)) {
                        this.j0.startActivity(new Intent(this.j0, ExpandedControlsActivity.class));
                        return;
                    } else {
                        i7.a.c(0, true, i7.a.a(this.s0, "", "", 0, this.y0, "videos/mp4", this.u0, "", (List) null), this.K0, this.j0);
                        return;
                    }
                }
                new ArrayList();
                ArrayList arrayList = new ArrayList();
                U u = new U(this, view);
                u.c().inflate(a7.h.m, u.b());
                ArrayList externalPlayer = new ExternalPlayerDataBase(this.j0).getExternalPlayer();
                if (externalPlayer != null) {
                    try {
                        if (externalPlayer.size() > 0) {
                            u.b().add(0, 0, 0, this.j0.getResources().getString(a7.j.V3));
                            ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                            externalPlayerModelClass.setId(0);
                            externalPlayerModelClass.setAppname(this.j0.getResources().getString(a7.j.h5));
                            arrayList.add(externalPlayerModelClass);
                            int i2 = 0;
                            while (i2 < externalPlayer.size()) {
                                int i3 = i2 + 1;
                                u.b().add(0, i3, 0, this.j0.getResources().getString(a7.j.h5) + " " + ((ExternalPlayerModelClass) externalPlayer.get(i2)).getAppname());
                                arrayList.add((ExternalPlayerModelClass) externalPlayer.get(i2));
                                i2 = i3;
                            }
                            u.f(new i(arrayList, string));
                            u.e(new j());
                            u.g();
                            return;
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (this.E0.booleanValue()) {
                    w.w0(this.j0, string, this.z0, this.v0, this.w0, this.x0, this.s0, this.y0, 0, "", "", this.A0);
                }
            } catch (Exception unused2) {
                if (this.E0.booleanValue()) {
                    w.w0(this.j0, string, this.z0, this.v0, this.w0, this.x0, this.s0, this.y0, 0, "", "", this.A0);
                }
            }
        }
    }

    private /* synthetic */ void V1(View view) {
        String str = this.D0;
        if (str == null || str.isEmpty()) {
            W1(this);
        } else {
            startActivity(new Intent(this, YouTubePlayerActivity.class).putExtra("you_tube_trailer", this.D0));
        }
    }

    private void X1() {
        this.n0.deleteFavourite(this.y0, SharepreferenceDBHandler.getUserID(this.j0));
        if (Build.VERSION.SDK_INT <= 21) {
            this.v.setImageResource(a7.e.W);
        }
        this.v.setImageDrawable(this.j0.getResources().getDrawable(a7.e.W, (Resources.Theme) null));
    }

    private void a2(Context context, String str, String str2) {
        ImageView imageView;
        Resources resources;
        int i2;
        String str3;
        String str4;
        String str5;
        TextView textView;
        this.F0 = new n7.h(this, context);
        (this.G0.equals("mobile") ? this.Q : this.P).setVisibility(0);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.z0 = Integer.parseInt(intent.getStringExtra(m7.a.Q));
            } catch (NumberFormatException unused) {
                this.z0 = -1;
            }
            this.s0 = intent.getStringExtra("movie");
            this.A0 = intent.getStringExtra("categoryID");
            this.t0 = intent.getStringExtra("selectedPlayer");
            this.u0 = intent.getStringExtra("movie_icon");
            this.v0 = intent.getStringExtra("streamType");
            this.w0 = intent.getStringExtra("containerExtension");
            this.x0 = intent.getStringExtra("num");
            String stringExtra = intent.getStringExtra("videoURL");
            this.y0 = stringExtra;
            if (this.n0.checkFavourite(stringExtra, SharepreferenceDBHandler.getUserID(context)).size() > 0) {
                if (Build.VERSION.SDK_INT <= 21) {
                    this.v.setImageResource(a7.e.V);
                }
                imageView = this.v;
                resources = context.getResources();
                i2 = a7.e.V;
            } else {
                if (Build.VERSION.SDK_INT <= 21) {
                    this.v.setImageResource(a7.e.W);
                }
                imageView = this.v;
                resources = context.getResources();
                i2 = a7.e.W;
            }
            imageView.setImageDrawable(resources.getDrawable(i2, (Resources.Theme) null));
            ImageView imageView2 = this.v;
            if (imageView2 != null) {
                imageView2.setOnFocusChangeListener(new t(imageView2));
                this.v.setOnClickListener(new p(context));
            }
            if (context != null) {
                try {
                    String str6 = this.u0;
                    if (str6 != null && !str6.isEmpty()) {
                        O1.g.u(getApplicationContext()).q(this.u0).I().m(new q());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            String str7 = this.s0;
            if (str7 != null && (textView = this.k) != null) {
                textView.setText(str7);
            }
            String str8 = this.s0;
            if (str8 == null || !str8.contains("(") || (str5 = this.s0) == null || !str5.contains(")")) {
                String str9 = this.s0;
                if (str9 == null || !str9.contains("[") || (str3 = this.s0) == null || !str3.contains("]")) {
                    this.F0.e(this.s0);
                    return;
                }
                str4 = this.s0.split("\\[")[0];
            } else {
                str4 = this.s0.split("\\(")[0];
            }
            this.H0 = str4;
            this.F0.e(str4);
        }
    }

    public static /* synthetic */ void u1(ViewDetailsTMDBActivity viewDetailsTMDBActivity, View view) {
        viewDetailsTMDBActivity.T1(view);
    }

    public static /* synthetic */ void v1(ViewDetailsTMDBActivity viewDetailsTMDBActivity, View view) {
        viewDetailsTMDBActivity.V1(view);
    }

    public static /* synthetic */ void w1(ViewDetailsTMDBActivity viewDetailsTMDBActivity, View view) {
        viewDetailsTMDBActivity.U1(view);
    }

    public static /* synthetic */ void x1(ViewDetailsTMDBActivity viewDetailsTMDBActivity, View view) {
        viewDetailsTMDBActivity.S1(view);
    }

    public static /* synthetic */ int y1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.z0;
    }

    public static /* synthetic */ String z1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        return viewDetailsTMDBActivity.v0;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback r14) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity.C(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback):void");
    }

    public void P1() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX WARN: Removed duplicated region for block: B:2:0x0042 A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #0 {Exception -> 0x0049, blocks: (B:10:0x0002, B:12:0x0008, B:14:0x0012, B:2:0x0042), top: B:9:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void U0(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L42
            java.util.List r0 = r6.getCast()     // Catch: java.lang.Exception -> L49
            if (r0 == 0) goto L42
            java.util.List r0 = r6.getCast()     // Catch: java.lang.Exception -> L49
            int r0 = r0.size()     // Catch: java.lang.Exception -> L49
            if (r0 <= 0) goto L42
            androidx.recyclerview.widget.RecyclerView r0 = r5.R     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch: java.lang.Exception -> L49
            r2 = 0
            r1.<init>(r5, r2, r2)     // Catch: java.lang.Exception -> L49
            r0.setLayoutManager(r1)     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r0 = r5.R     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.c r1 = new androidx.recyclerview.widget.c     // Catch: java.lang.Exception -> L49
            r1.<init>()     // Catch: java.lang.Exception -> L49
            r0.setItemAnimator(r1)     // Catch: java.lang.Exception -> L49
            q7.f r0 = new q7.f     // Catch: java.lang.Exception -> L49
            java.util.List r6 = r6.getCast()     // Catch: java.lang.Exception -> L49
            android.content.Context r1 = r5.j0     // Catch: java.lang.Exception -> L49
            java.lang.String r3 = r5.J0     // Catch: java.lang.Exception -> L49
            r4 = 1
            r0.<init>(r6, r1, r4, r3)     // Catch: java.lang.Exception -> L49
            r5.I0 = r0     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r6 = r5.R     // Catch: java.lang.Exception -> L49
            r6.setAdapter(r0)     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r6 = r5.R     // Catch: java.lang.Exception -> L49
            r6.setVisibility(r2)     // Catch: java.lang.Exception -> L49
            goto L49
        L42:
            androidx.recyclerview.widget.RecyclerView r6 = r5.R     // Catch: java.lang.Exception -> L49
            r0 = 8
            r6.setVisibility(r0)     // Catch: java.lang.Exception -> L49
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity.U0(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback):void");
    }

    public final void W1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        View inflate = ((LayoutInflater) viewDetailsTMDBActivity.getSystemService("layout_inflater")).inflate(a7.g.l3, viewDetailsTMDBActivity.findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(viewDetailsTMDBActivity);
        this.C0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.C0.setWidth(-1);
        this.C0.setHeight(-1);
        this.C0.setFocusable(true);
        this.C0.setBackgroundDrawable(new BitmapDrawable());
        this.C0.showAtLocation(inflate, 17, 0, 0);
        this.i0 = inflate.findViewById(a7.f.H0);
        this.X = inflate.findViewById(a7.f.o0);
        Button button = this.i0;
        if (button != null) {
            button.setOnFocusChangeListener(new t(button));
        }
        Button button2 = this.X;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new t(button2));
        }
        this.X.setOnClickListener(new k());
        this.i0.setOnClickListener(new l());
    }

    public void X0(TMDBTrailerCallback tMDBTrailerCallback) {
        LinearLayout linearLayout;
        if (tMDBTrailerCallback == null || tMDBTrailerCallback.getResults() == null || tMDBTrailerCallback.getResults().size() <= 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < tMDBTrailerCallback.getResults().size(); i3++) {
            if (((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i3)).getType().equals("Trailer")) {
                String key = ((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i3)).getKey();
                this.D0 = key;
                if (key == null || key.isEmpty()) {
                    TextView textView = this.N;
                    i2 = 8;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    linearLayout = this.M;
                    if (linearLayout == null) {
                        return;
                    }
                } else {
                    TextView textView2 = this.N;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    linearLayout = this.M;
                    if (linearLayout == null) {
                        return;
                    }
                }
                linearLayout.setVisibility(i2);
                return;
            }
        }
    }

    public void Y1() {
        this.l.setOnClickListener(new x1(this));
        this.g.setOnClickListener(new y1(this));
        this.L.setOnClickListener(new z1(this));
        this.N.setOnClickListener(new A1(this));
    }

    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public final void U1(ViewDetailsTMDBActivity viewDetailsTMDBActivity) {
        View inflate = ((LayoutInflater) viewDetailsTMDBActivity.getSystemService("layout_inflater")).inflate(a7.g.g3, viewDetailsTMDBActivity.findViewById(a7.f.We));
        TextView findViewById = inflate.findViewById(a7.f.Wh);
        this.f0 = findViewById;
        findViewById.setText(this.Y);
        PopupWindow popupWindow = new PopupWindow(viewDetailsTMDBActivity);
        this.C0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.C0.setWidth(-1);
        this.C0.setHeight(-1);
        this.C0.setFocusable(true);
        this.C0.showAtLocation(inflate, 17, 0, 0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        this.X = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new t(findViewById2));
        }
        this.X.setOnClickListener(new m());
    }

    public void a() {
    }

    public void b() {
        ProgressDialog progressDialog = this.k0;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void d(String str) {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:39:0x0136
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6 A[PHI: r3
      0x00a6: PHI (r3v3 android.widget.TextView) = (r3v2 android.widget.TextView), (r3v22 android.widget.TextView) binds: [B:71:0x00a4, B:62:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g0(com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback r9) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity.g0(com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback):void");
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
        P1();
        setContentView(a7.g.r1);
        Q1();
        Y1();
        overridePendingTransition(a7.b.f, a7.b.d);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.j0).equals("api")) {
            Log.i("hereIS", "typeAPI");
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
            Log.i("hereIS", "notTypeAPI");
        }
        AppBarLayout appBarLayout = this.j;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.H));
        }
        this.G0 = new u7.a(this.j0).A().equals(m7.a.K0) ? "tv" : "mobile";
        M1();
        this.W = new Date();
        TextView textView = this.l;
        if (textView != null) {
            textView.setOnFocusChangeListener(new t(textView));
            this.l.requestFocus();
            this.l.setFocusable(true);
        }
        N0 = O1(this.j0);
        Locale locale = Locale.US;
        this.Z = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setOnFocusChangeListener(new t(textView2));
        }
        this.e = w.S0(w7.d.d());
        O0 = getApplicationContext().getPackageName();
        TextView textView3 = this.N;
        if (textView3 != null) {
            textView3.setOnFocusChangeListener(new t(textView3));
        }
        this.d = w.S0(w7.a.a());
        this.V = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        getWindow().setFlags(1024, 1024);
        r1(findViewById(a7.f.kh));
        R1();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.h.x(a7.h.v);
        this.h0 = menu;
        this.g0 = menu.getItem(1).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.h.getChildCount(); i2++) {
            if (this.h.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.h.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.h0;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.g0 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.j0) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new s()).g(getResources().getString(a7.j.d4), new r()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.j0.getResources().getString(a7.j.u0));
            aVar.f(this.j0.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.j0.getResources().getString(a7.j.S8), new a());
            aVar.g(this.j0.getResources().getString(a7.j.d4), new b());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.j0.getResources().getString(a7.j.u0));
            aVar2.f(this.j0.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.j0.getResources().getString(a7.j.S8), new c());
            aVar2.g(this.j0.getResources().getString(a7.j.d4), new d());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        P1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.j0);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.l0 = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.l0.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.j0 != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        P1();
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x00db A[PHI: r1
      0x00db: PHI (r1v2 android.widget.TextView) = (r1v1 android.widget.TextView), (r1v9 android.widget.TextView), (r1v10 android.widget.TextView) binds: [B:118:0x00d9, B:107:0x00bf, B:95:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback r9) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity.s(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback):void");
    }

    public void t(TMDBPersonInfoCallback tMDBPersonInfoCallback) {
    }

    public class h implements U.c {
        public h() {
        }

        public void a(U u) {
        }
    }

    public class j implements U.c {
        public j() {
        }

        public void a(U u) {
        }
    }
}
