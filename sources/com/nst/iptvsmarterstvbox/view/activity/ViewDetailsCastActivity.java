package com.nst.iptvsmarterstvbox.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBPersonInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.squareup.picasso.C;
import com.squareup.picasso.t;
import d.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import m7.w;
import q7.M;
import z7.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ViewDetailsCastActivity extends androidx.appcompat.app.b implements View.OnClickListener, k {
    public static String f0;
    public static String g0;
    public RelativeLayout A;
    public ProgressDialog C;
    public SharedPreferences D;
    public DateFormat G;
    public MenuItem H;
    public Menu I;
    public n7.h K;
    public LinearLayout L;
    public LinearLayout M;
    public LinearLayout N;
    public RecyclerView O;
    public M P;
    public String Q;
    public String R;
    public String S;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;
    public String d;
    public String e;
    public ImageView e0;
    public SimpleDateFormat f;
    public Date g;
    public Toolbar h;
    public AppBarLayout i;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public ProgressBar m;
    public LinearLayout n;
    public ScrollView o;
    public LinearLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public LinearLayout u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public ImageView z;
    public Context B = this;
    public String E = "";
    public String F = "";
    public Boolean J = Boolean.TRUE;
    public String T = "";

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            w.j(ViewDetailsCastActivity.u1(ViewDetailsCastActivity.this));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ViewDetailsCastActivity.this.onBackPressed();
        }
    }

    public class d implements C {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        public void a(Drawable drawable) {
            Log.d("TAG", "FAILED");
        }

        public void b(Bitmap bitmap, t.e eVar) {
            ViewDetailsCastActivity.this.i.setBackground(new BitmapDrawable(this.a.getResources(), bitmap));
            ViewDetailsCastActivity viewDetailsCastActivity = ViewDetailsCastActivity.this;
            viewDetailsCastActivity.A.setBackgroundColor(viewDetailsCastActivity.getResources().getColor(a7.c.B));
            ViewDetailsCastActivity viewDetailsCastActivity2 = ViewDetailsCastActivity.this;
            viewDetailsCastActivity2.h.setBackgroundColor(viewDetailsCastActivity2.getResources().getColor(a7.c.B));
        }

        public void c(Drawable drawable) {
            Log.d("TAG", "Prepare Load");
        }
    }

    public class e extends o2.g {
        public e() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            ViewDetailsCastActivity.this.k.setBackground(new BitmapDrawable(bitmap));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(ViewDetailsCastActivity.u1(ViewDetailsCastActivity.this));
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(ViewDetailsCastActivity.u1(ViewDetailsCastActivity.this));
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void A1(Context context, String str, String str2) {
        String str3;
        this.K = new n7.h(this, context);
        Intent intent = getIntent();
        if (intent != null) {
            this.Q = intent.getStringExtra("castID");
            this.R = intent.getStringExtra("castName");
            this.S = intent.getStringExtra("profilePath");
            String stringExtra = intent.getStringExtra("streamBackdrop");
            this.T = stringExtra;
            if (stringExtra != null && !stringExtra.equals("") && context != null) {
                t.q(context).l(this.T).i(new d(context));
            }
            String str4 = this.Q;
            if (str4 == null || str4.equals("0")) {
                return;
            }
            TextView textView = this.U;
            if (textView != null) {
                textView.setText(this.R);
            }
            if (context != null) {
                try {
                    if (this.k != null && (str3 = this.S) != null && !str3.isEmpty()) {
                        O1.g.u(getApplicationContext()).q("https://image.tmdb.org/t/p/w500/" + this.S).I().m(new e());
                    }
                } catch (Exception unused) {
                }
            }
            this.K.f(this.Q);
        }
    }

    public static /* synthetic */ Context u1(ViewDetailsCastActivity viewDetailsCastActivity) {
        return viewDetailsCastActivity.B;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static String w1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void y1() {
        this.U = findViewById(a7.f.Uh);
        this.V = findViewById(a7.f.Ok);
        this.W = findViewById(a7.f.yj);
        this.X = findViewById(a7.f.Kj);
        this.Y = findViewById(a7.f.Sh);
        this.Z = findViewById(a7.f.yi);
        this.e0 = findViewById(a7.f.F4);
        this.L = findViewById(a7.f.E7);
        this.M = findViewById(a7.f.F7);
        this.N = findViewById(a7.f.G7);
        this.O = findViewById(a7.f.Df);
        this.h = findViewById(a7.f.kh);
        this.i = findViewById(a7.f.W);
        this.j = findViewById(a7.f.Nd);
        this.k = findViewById(a7.f.B5);
        this.l = findViewById(a7.f.Ji);
        this.m = findViewById(a7.f.Ei);
        this.n = findViewById(a7.f.n9);
        this.o = findViewById(a7.f.Tf);
        this.p = findViewById(a7.f.K7);
        this.q = findViewById(a7.f.v9);
        this.r = findViewById(a7.f.p8);
        this.s = findViewById(a7.f.B8);
        this.t = findViewById(a7.f.M7);
        this.u = findViewById(a7.f.L7);
        this.v = findViewById(a7.f.w9);
        this.w = findViewById(a7.f.q8);
        this.x = findViewById(a7.f.A8);
        this.y = findViewById(a7.f.N7);
        this.z = findViewById(a7.f.Xa);
        this.A = findViewById(a7.f.vf);
    }

    private void z1() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.D = sharedPreferences;
        String string = sharedPreferences.getString("username", "");
        String string2 = this.D.getString("password", "");
        if (string.isEmpty() || string2.isEmpty()) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else {
            A1(this.B, string, string2);
        }
        this.z.setOnClickListener(new b());
        this.e0.setOnClickListener(new c());
    }

    public void C(SearchTMDBMoviesCallback searchTMDBMoviesCallback) {
    }

    public void U0(TMDBCastsCallback tMDBCastsCallback) {
    }

    public void X0(TMDBTrailerCallback tMDBTrailerCallback) {
    }

    public void a() {
    }

    public void b() {
        ProgressDialog progressDialog = this.C;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void d(String str) {
        this.m.setVisibility(8);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void g0(TMDBGenreCallback tMDBGenreCallback) {
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
        this.B = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        x1();
        setContentView(new u7.a(this.B).A().equals(m7.a.K0) ? a7.g.q1 : a7.g.p1);
        y1();
        overridePendingTransition(a7.b.f, a7.b.d);
        v1();
        this.g = new Date();
        f0 = w1(this.B);
        Locale locale = Locale.US;
        this.G = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.e = w.S0(w7.d.d());
        g0 = getApplicationContext().getPackageName();
        this.d = w.S0(w7.a.a());
        this.f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        getWindow().setFlags(1024, 1024);
        r1(findViewById(a7.f.kh));
        AppBarLayout appBarLayout = this.i;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.H));
        }
        z1();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.h.x(a7.h.v);
        this.I = menu;
        this.H = menu.getItem(1).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.B).equals("api")) {
            menu.getItem(1).getSubMenu().findItem(a7.f.fb).setVisible(false);
        }
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
        Menu menu = this.I;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.H = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.B) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new g()).g(getResources().getString(a7.j.d4), new f()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.B.getResources().getString(a7.j.u0));
            aVar.f(this.B.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.B.getResources().getString(a7.j.S8), new h());
            aVar.g(this.B.getResources().getString(a7.j.d4), new i());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.B.getResources().getString(a7.j.u0));
            aVar2.f(this.B.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.B.getResources().getString(a7.j.S8), new j());
            aVar2.g(this.B.getResources().getString(a7.j.d4), new a());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.B);
        w.z0(this.B);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.D = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.D.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.B != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        x1();
    }

    public void s(TMDBCastsCallback tMDBCastsCallback) {
    }

    public void t(TMDBPersonInfoCallback tMDBPersonInfoCallback) {
        TextView textView;
        TextView textView2;
        String str;
        this.m.setVisibility(8);
        if (tMDBPersonInfoCallback != null) {
            String name = tMDBPersonInfoCallback.getName() != null ? tMDBPersonInfoCallback.getName() : "N/A";
            if (tMDBPersonInfoCallback.getProfilePath() != null) {
                tMDBPersonInfoCallback.getProfilePath();
            }
            String birthday = tMDBPersonInfoCallback.getBirthday() != null ? tMDBPersonInfoCallback.getBirthday() : "N/A";
            String placeOfBirth = tMDBPersonInfoCallback.getPlaceOfBirth() != null ? tMDBPersonInfoCallback.getPlaceOfBirth() : "N/A";
            String deathday = tMDBPersonInfoCallback.getDeathday() != null ? tMDBPersonInfoCallback.getDeathday() : "N/A";
            int intValue = tMDBPersonInfoCallback.getGender() != null ? tMDBPersonInfoCallback.getGender().intValue() : 5;
            String knownForDepartment = tMDBPersonInfoCallback.getKnownForDepartment() != null ? tMDBPersonInfoCallback.getKnownForDepartment() : "N/A";
            String biography = tMDBPersonInfoCallback.getBiography() != null ? tMDBPersonInfoCallback.getBiography() : "N/A";
            if (tMDBPersonInfoCallback.getImages() != null && tMDBPersonInfoCallback.getImages().getProfiles() != null && tMDBPersonInfoCallback.getImages().getProfiles().size() > 0) {
                this.O.setLayoutManager(new LinearLayoutManager(this, 0, false));
                this.O.setItemAnimator(new androidx.recyclerview.widget.c());
                M m = new M(tMDBPersonInfoCallback.getImages().getProfiles(), this.B, true);
                this.P = m;
                this.O.setAdapter(m);
            }
            TextView textView3 = this.U;
            if (textView3 != null) {
                textView3.setText(name);
            }
            if (this.q == null || this.v == null || this.V == null || placeOfBirth == null || placeOfBirth.isEmpty() || placeOfBirth.equals("N/A")) {
                LinearLayout linearLayout = this.q;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.v;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView4 = this.V;
                if (textView4 != null) {
                    textView4.setText("N/A");
                }
            } else {
                this.q.setVisibility(0);
                this.v.setVisibility(0);
                this.V.setText(placeOfBirth);
            }
            if (this.Z == null || this.u == null || this.p == null || birthday == null || birthday.isEmpty() || birthday.equals("N/A")) {
                LinearLayout linearLayout3 = this.p;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.u;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                TextView textView5 = this.Z;
                if (textView5 != null) {
                    textView5.setText("N/A");
                }
            } else {
                this.p.setVisibility(0);
                this.u.setVisibility(0);
                this.Z.setText(birthday);
            }
            LinearLayout linearLayout5 = this.r;
            if (linearLayout5 == null || this.w == null || this.W == null || intValue == 5) {
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                LinearLayout linearLayout6 = this.w;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                textView = this.W;
                if (textView != null) {
                    textView.setText("N/A");
                }
            } else {
                linearLayout5.setVisibility(0);
                this.w.setVisibility(0);
                if (intValue == 1) {
                    textView2 = this.W;
                    str = "Female";
                } else if (intValue == 2) {
                    textView2 = this.W;
                    str = "Male";
                } else {
                    textView = this.W;
                    textView.setText("N/A");
                }
                textView2.setText(str);
            }
            LinearLayout linearLayout7 = this.s;
            if (linearLayout7 == null || this.x == null || this.X == null) {
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
                LinearLayout linearLayout8 = this.x;
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(0);
                }
                TextView textView6 = this.X;
                if (textView6 != null) {
                    textView6.setText("N/A");
                }
            } else {
                linearLayout7.setVisibility(0);
                this.x.setVisibility(0);
                TextView textView7 = this.X;
                if (textView7 != null) {
                    textView7.setText(knownForDepartment);
                }
            }
            if (this.Y == null || biography == null || biography.isEmpty() || biography.equals("N/A")) {
                TextView textView8 = this.Y;
                if (textView8 != null) {
                    textView8.setVisibility(8);
                }
            } else {
                this.Y.setText(biography);
            }
            if (this.t != null && this.y != null && this.l != null && deathday != null && !deathday.equals("N/A") && !deathday.isEmpty()) {
                this.t.setVisibility(0);
                this.y.setVisibility(0);
                this.l.setText(deathday);
                return;
            }
            LinearLayout linearLayout9 = this.t;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
            LinearLayout linearLayout10 = this.y;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(8);
            }
        }
    }

    public void x1() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
