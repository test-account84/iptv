package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import d.a;
import java.util.ArrayList;
import m7.w;
import q7.i0;
import q7.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VodActivityLayout extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ArrayList J = new ArrayList();
    public static ArrayList K = new ArrayList();
    public static ArrayList L = new ArrayList();
    public static ProgressBar M;
    public SharedPreferences A;
    public i0 B;
    public n0 D;
    public SharedPreferences E;
    public SharedPreferences.Editor F;
    public PopupWindow G;
    public MenuItem H;
    public Menu I;
    public Toolbar d;
    public AppBarLayout e;
    public ProgressBar f;
    public RecyclerView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public Context l;
    public SharedPreferences m;
    public LiveStreamDBHandler q;
    public SearchView s;
    public ProgressDialog t;
    public SharedPreferences x;
    public SharedPreferences.Editor y;
    public RecyclerView.o z;
    public String n = "";
    public String o = "";
    public DatabaseUpdatedStatusDBModel p = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel r = new DatabaseUpdatedStatusDBModel();
    public String u = "";
    public String v = "";
    public boolean w = false;
    public ArrayList C = new ArrayList();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(VodActivityLayout.u1(VodActivityLayout.this));
        }
    }

    public class c implements SearchView.m {
        public c() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            VodActivityLayout.this.i.setVisibility(8);
            if (VodActivityLayout.v1(VodActivityLayout.this) == null || (textView = VodActivityLayout.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityLayout.v1(VodActivityLayout.this).J0(str, VodActivityLayout.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(VodActivityLayout.u1(VodActivityLayout.this));
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            VodActivityLayout.w1(VodActivityLayout.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;

        public i(RadioGroup radioGroup, View view) {
            this.a = radioGroup;
            this.c = view;
        }

        public void onClick(View view) {
            SharedPreferences.Editor x1;
            String str;
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            if (findViewById.getText().toString().equals(VodActivityLayout.this.getResources().getString(j.i7))) {
                x1 = VodActivityLayout.x1(VodActivityLayout.this);
                str = "1";
            } else if (findViewById.getText().toString().equals(VodActivityLayout.this.getResources().getString(j.f7))) {
                x1 = VodActivityLayout.x1(VodActivityLayout.this);
                str = "2";
            } else if (findViewById.getText().toString().equals(VodActivityLayout.this.getResources().getString(j.k7))) {
                x1 = VodActivityLayout.x1(VodActivityLayout.this);
                str = "3";
            } else {
                x1 = VodActivityLayout.x1(VodActivityLayout.this);
                str = "0";
            }
            x1.putString("sort", str);
            VodActivityLayout.x1(VodActivityLayout.this).commit();
            VodActivityLayout vodActivityLayout = VodActivityLayout.this;
            VodActivityLayout.z1(vodActivityLayout, vodActivityLayout.getSharedPreferences("listgridview", 0));
            VodActivityLayout vodActivityLayout2 = VodActivityLayout.this;
            VodActivityLayout.A1(vodActivityLayout2, VodActivityLayout.y1(vodActivityLayout2).edit());
            int i = VodActivityLayout.y1(VodActivityLayout.this).getInt("vod", 0);
            m7.a.N = i;
            if (i == 1) {
                VodActivityLayout.B1(VodActivityLayout.this);
            } else {
                VodActivityLayout.C1(VodActivityLayout.this);
            }
            VodActivityLayout.w1(VodActivityLayout.this).dismiss();
        }
    }

    public static /* synthetic */ SharedPreferences.Editor A1(VodActivityLayout vodActivityLayout, SharedPreferences.Editor editor) {
        vodActivityLayout.y = editor;
        return editor;
    }

    public static /* synthetic */ void B1(VodActivityLayout vodActivityLayout) {
        vodActivityLayout.H1();
    }

    public static /* synthetic */ void C1(VodActivityLayout vodActivityLayout) {
        vodActivityLayout.G1();
    }

    private void D1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void F1() {
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.ec);
        this.g = findViewById(a7.f.ub);
        this.h = findViewById(a7.f.sk);
        this.i = findViewById(a7.f.wk);
        this.j = findViewById(a7.f.lm);
        this.k = findViewById(a7.f.Jl);
    }

    private void G1() {
        this.l = this;
        this.q = new LiveStreamDBHandler(this.l);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.l == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.l, w.L(this.l) + 2);
        this.z = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.l.getSharedPreferences("loginPrefs", 0);
        this.A = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.A.getString("password", "");
        K1();
    }

    private void H1() {
        this.l = this;
        this.q = new LiveStreamDBHandler(this.l);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.l == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.l);
        this.z = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.l.getSharedPreferences("loginPrefs", 0);
        this.A = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.A.getString("password", "");
        K1();
    }

    private void J1() {
        SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
        this.x = sharedPreferences;
        this.y = sharedPreferences.edit();
        int i2 = this.x.getInt("vod", 0);
        m7.a.N = i2;
        if (i2 == 1) {
            H1();
        } else {
            G1();
        }
    }

    private void K1() {
        if (this.l != null) {
            LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.l);
            if (!this.u.equals("-1")) {
                ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.u, "movie");
                b();
                ProgressDialog progressDialog = this.t;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                if (allLiveStreasWithCategoryId == null || this.g == null || allLiveStreasWithCategoryId.size() == 0) {
                    TextView textView = this.h;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                } else {
                    i0 i0Var = new i0(allLiveStreasWithCategoryId, this.l, true);
                    this.B = i0Var;
                    this.g.setAdapter(i0Var);
                    w.Q0(this.l, getResources().getString(j.q8));
                }
            }
        }
        ProgressDialog progressDialog2 = this.t;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
    }

    private void L1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.G = popupWindow;
            popupWindow.setContentView(inflate);
            this.G.setWidth(-1);
            this.G.setHeight(-1);
            this.G.setFocusable(true);
            this.G.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            String string = this.E.getString("sort", "");
            if (string.equals("1")) {
                findViewById5.setChecked(true);
            } else if (string.equals("2")) {
                findViewById6.setChecked(true);
            } else if (string.equals("3")) {
                findViewById7.setChecked(true);
            } else {
                findViewById4.setChecked(true);
            }
            findViewById2.setOnClickListener(new h());
            findViewById.setOnClickListener(new i(findViewById3, inflate));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(VodActivityLayout vodActivityLayout) {
        return vodActivityLayout.l;
    }

    public static /* synthetic */ i0 v1(VodActivityLayout vodActivityLayout) {
        return vodActivityLayout.B;
    }

    public static /* synthetic */ PopupWindow w1(VodActivityLayout vodActivityLayout) {
        return vodActivityLayout.G;
    }

    public static /* synthetic */ SharedPreferences.Editor x1(VodActivityLayout vodActivityLayout) {
        return vodActivityLayout.F;
    }

    public static /* synthetic */ SharedPreferences y1(VodActivityLayout vodActivityLayout) {
        return vodActivityLayout.x;
    }

    public static /* synthetic */ SharedPreferences z1(VodActivityLayout vodActivityLayout, SharedPreferences sharedPreferences) {
        vodActivityLayout.x = sharedPreferences;
        return sharedPreferences;
    }

    public void E1() {
        RecyclerView recyclerView;
        androidx.recyclerview.widget.c cVar;
        a();
        SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
        this.x = sharedPreferences;
        this.y = sharedPreferences.edit();
        int i2 = this.x.getInt("vod", 0);
        m7.a.N = i2;
        this.l = this;
        if (i2 == 1) {
            this.q = new LiveStreamDBHandler(this.l);
            RecyclerView recyclerView2 = this.g;
            if (recyclerView2 != null && this.l != null) {
                recyclerView2.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.l);
                this.z = linearLayoutManager;
                this.g.setLayoutManager(linearLayoutManager);
                recyclerView = this.g;
                cVar = new androidx.recyclerview.widget.c();
                recyclerView.setItemAnimator(cVar);
            }
        } else {
            this.q = new LiveStreamDBHandler(this.l);
            RecyclerView recyclerView3 = this.g;
            if (recyclerView3 != null && this.l != null) {
                recyclerView3.setHasFixedSize(true);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.l, w.L(this.l) + 2);
                this.z = gridLayoutManager;
                this.g.setLayoutManager(gridLayoutManager);
                recyclerView = this.g;
                cVar = new androidx.recyclerview.widget.c();
                recyclerView.setItemAnimator(cVar);
            }
        }
        if (this.l != null) {
            ArrayList allLiveStreasWithCategoryId = new LiveStreamDBHandler(this.l).getAllLiveStreasWithCategoryId("0", "movie");
            b();
            if (allLiveStreasWithCategoryId == null || this.g == null || allLiveStreasWithCategoryId.size() == 0) {
                ProgressDialog progressDialog = this.t;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else {
                ProgressDialog progressDialog2 = this.t;
                if (progressDialog2 != null) {
                    progressDialog2.dismiss();
                }
                this.B = new i0(allLiveStreasWithCategoryId, this.l, true);
                w.Q0(this.l, getResources().getString(j.q8));
                this.g.setAdapter(this.B);
            }
        }
        ProgressDialog progressDialog3 = this.t;
        if (progressDialog3 != null) {
            progressDialog3.dismiss();
        }
    }

    public void I1(ProgressBar progressBar) {
        M = progressBar;
    }

    public void a() {
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public void b() {
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        ProgressBar progressBar;
        n0 n0Var = this.D;
        if (n0Var != null && (progressBar = M) != null) {
            n0Var.F0(progressBar);
        }
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
        }
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
        SharedPreferences sharedPreferences = getSharedPreferences("sort", 0);
        this.E = sharedPreferences;
        this.F = sharedPreferences.edit();
        if (this.E.getString("sort", "").equals("")) {
            this.F.putString("sort", "0");
            this.F.commit();
        }
        getWindow().setFlags(1024, 1024);
        Intent intent = getIntent();
        if (intent != null) {
            this.u = intent.getStringExtra("category_id");
            this.v = intent.getStringExtra("category_name");
        }
        this.l = this;
        this.D = new n0();
        this.q = new LiveStreamDBHandler(this.l);
        setContentView(a7.g.C1);
        overridePendingTransition(a7.b.f, a7.b.d);
        F1();
        a();
        J1();
        D1();
        r1(findViewById(a7.f.kh));
        AppBarLayout appBarLayout = this.e;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        this.l = this;
        if (!this.v.isEmpty()) {
            this.k.setText(this.v);
        }
        this.k.setSelected(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(a7.h.s);
        this.I = menu;
        this.H = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            if (this.d.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i2).getLayoutParams()).a = 16;
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

    /* JADX WARN: Code restructure failed: missing block: B:43:0x01de, code lost:
    
        if (r1.size() > 0) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r9) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityLayout.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.l);
        getWindow().setFlags(1024, 1024);
        this.D.F0(M);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.m = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.m.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.l != null) {
            b();
        }
    }
}
