package com.nst.iptvsmarterstvbox.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import m7.w;
import q7.i0;
import q7.j0;
import q7.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VodActivityNewFlowSecondSubCategories extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ArrayList R = new ArrayList();
    public static ArrayList S = new ArrayList();
    public static ArrayList T = new ArrayList();
    public static ProgressBar U;
    public SharedPreferences A;
    public SharedPreferences.Editor B;
    public RecyclerView.o C;
    public SharedPreferences D;
    public i0 E;
    public j0 G;
    public PopupWindow I;
    public SharedPreferences J;
    public SharedPreferences.Editor K;
    public GridLayoutManager L;
    public ArrayList N;
    public ArrayList O;
    public ArrayList P;
    public ArrayList Q;
    public Toolbar d;
    public AppBarLayout e;
    public ProgressBar f;
    public RecyclerView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public ImageView m;
    public Context n;
    public SharedPreferences o;
    public LiveStreamDBHandler s;
    public SearchView u;
    public ProgressDialog v;
    public n0 z;
    public String p = "";
    public String q = "";
    public DatabaseUpdatedStatusDBModel r = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel t = new DatabaseUpdatedStatusDBModel();
    public String w = "";
    public String x = "";
    public boolean y = false;
    public ArrayList F = new ArrayList();
    public boolean H = false;
    public ArrayList M = new ArrayList();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            VodActivityNewFlowSecondSubCategories.x1(VodActivityNewFlowSecondSubCategories.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;

        public b(RadioGroup radioGroup, View view) {
            this.a = radioGroup;
            this.c = view;
        }

        public void onClick(View view) {
            SharedPreferences.Editor y1;
            String str;
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            if (findViewById.getText().toString().equals(VodActivityNewFlowSecondSubCategories.this.getResources().getString(a7.j.i7))) {
                y1 = VodActivityNewFlowSecondSubCategories.y1(VodActivityNewFlowSecondSubCategories.this);
                str = "1";
            } else if (findViewById.getText().toString().equals(VodActivityNewFlowSecondSubCategories.this.getResources().getString(a7.j.f7))) {
                y1 = VodActivityNewFlowSecondSubCategories.y1(VodActivityNewFlowSecondSubCategories.this);
                str = "2";
            } else if (findViewById.getText().toString().equals(VodActivityNewFlowSecondSubCategories.this.getResources().getString(a7.j.k7))) {
                y1 = VodActivityNewFlowSecondSubCategories.y1(VodActivityNewFlowSecondSubCategories.this);
                str = "3";
            } else {
                y1 = VodActivityNewFlowSecondSubCategories.y1(VodActivityNewFlowSecondSubCategories.this);
                str = "0";
            }
            y1.putString("sort", str);
            VodActivityNewFlowSecondSubCategories.y1(VodActivityNewFlowSecondSubCategories.this).commit();
            VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories = VodActivityNewFlowSecondSubCategories.this;
            VodActivityNewFlowSecondSubCategories.A1(vodActivityNewFlowSecondSubCategories, vodActivityNewFlowSecondSubCategories.getSharedPreferences("listgridview", 0));
            VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories2 = VodActivityNewFlowSecondSubCategories.this;
            VodActivityNewFlowSecondSubCategories.B1(vodActivityNewFlowSecondSubCategories2, VodActivityNewFlowSecondSubCategories.z1(vodActivityNewFlowSecondSubCategories2).edit());
            int i = VodActivityNewFlowSecondSubCategories.z1(VodActivityNewFlowSecondSubCategories.this).getInt("vod", 0);
            m7.a.N = i;
            if (i == 1) {
                VodActivityNewFlowSecondSubCategories.C1(VodActivityNewFlowSecondSubCategories.this);
            } else {
                VodActivityNewFlowSecondSubCategories.D1(VodActivityNewFlowSecondSubCategories.this);
            }
            VodActivityNewFlowSecondSubCategories.x1(VodActivityNewFlowSecondSubCategories.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            w.j(VodActivityNewFlowSecondSubCategories.u1(VodActivityNewFlowSecondSubCategories.this));
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(VodActivityNewFlowSecondSubCategories.u1(VodActivityNewFlowSecondSubCategories.this));
        }
    }

    public class f implements SearchView.m {
        public f() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            VodActivityNewFlowSecondSubCategories.this.i.setVisibility(8);
            if (VodActivityNewFlowSecondSubCategories.v1(VodActivityNewFlowSecondSubCategories.this) == null || (textView = VodActivityNewFlowSecondSubCategories.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityNewFlowSecondSubCategories.v1(VodActivityNewFlowSecondSubCategories.this).z0(str, VodActivityNewFlowSecondSubCategories.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class g implements SearchView.m {
        public g() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            VodActivityNewFlowSecondSubCategories.this.i.setVisibility(8);
            if (VodActivityNewFlowSecondSubCategories.w1(VodActivityNewFlowSecondSubCategories.this) == null || (textView = VodActivityNewFlowSecondSubCategories.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityNewFlowSecondSubCategories.w1(VodActivityNewFlowSecondSubCategories.this).J0(str, VodActivityNewFlowSecondSubCategories.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(VodActivityNewFlowSecondSubCategories.u1(VodActivityNewFlowSecondSubCategories.this));
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

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public static /* synthetic */ SharedPreferences A1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories, SharedPreferences sharedPreferences) {
        vodActivityNewFlowSecondSubCategories.A = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor B1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories, SharedPreferences.Editor editor) {
        vodActivityNewFlowSecondSubCategories.B = editor;
        return editor;
    }

    public static /* synthetic */ void C1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        vodActivityNewFlowSecondSubCategories.K1();
    }

    public static /* synthetic */ void D1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        vodActivityNewFlowSecondSubCategories.J1();
    }

    private void E1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList G1() {
        ArrayList allPasswordStatus = this.s.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.n));
        this.N = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.M.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.M;
    }

    private ArrayList H1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = this.O;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamsDBModel);
                        }
                    }
                }
            }
        }
        return this.O;
    }

    private void I1() {
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.ec);
        this.g = findViewById(a7.f.ub);
        this.h = findViewById(a7.f.sk);
        this.i = findViewById(a7.f.wk);
        this.j = findViewById(a7.f.lm);
        this.k = findViewById(a7.f.Jl);
        this.l = findViewById(a7.f.rf);
        this.m = findViewById(a7.f.Xa);
    }

    private void J1() {
        this.n = this;
        this.s = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.n, w.L(this.n) + 1);
        this.C = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.n.getSharedPreferences("loginPrefs", 0);
        this.D = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.D.getString("password", "");
        N1();
    }

    private void K1() {
        this.n = this;
        this.s = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.n);
        this.C = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.n.getSharedPreferences("loginPrefs", 0);
        this.D = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.D.getString("password", "");
        N1();
    }

    private void L1(ArrayList arrayList) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        this.L = new u7.a(this.n).A().equals(m7.a.K0) ? new GridLayoutManager(this, 2) : new GridLayoutManager(this, 2);
        this.g.setLayoutManager(this.L);
        this.g.setHasFixedSize(true);
        b();
        n0 n0Var = new n0(arrayList, this.n, this.s);
        this.z = n0Var;
        this.g.setAdapter(n0Var);
    }

    private void M1(ArrayList arrayList) {
        L1(arrayList);
    }

    private void N1() {
        TextView textView;
        try {
            if (this.n != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.n);
                if (!this.w.equals("-1")) {
                    if (this.w.equals("0")) {
                        this.N = new ArrayList();
                        this.O = new ArrayList();
                        this.P = new ArrayList();
                        this.Q = new ArrayList();
                        ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.w, "movie");
                        if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.n)) <= 0 || allLiveStreasWithCategoryId == null) {
                            this.Q = allLiveStreasWithCategoryId;
                        } else {
                            ArrayList G1 = G1();
                            this.M = G1;
                            if (G1 != null) {
                                this.P = H1(allLiveStreasWithCategoryId, G1);
                            }
                            this.Q = this.P;
                        }
                        b();
                        ProgressDialog progressDialog = this.v;
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                        ArrayList arrayList = this.Q;
                        if (arrayList == null || this.g == null || arrayList.size() == 0) {
                            textView = this.h;
                            if (textView != null) {
                                textView.setVisibility(0);
                            }
                        } else {
                            i0 i0Var = new i0(this.Q, this.n, true);
                            this.E = i0Var;
                            this.g.setAdapter(i0Var);
                            w.Q0(this.n, getResources().getString(a7.j.q8));
                        }
                    } else {
                        ArrayList allLiveStreasWithCategoryId2 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.w, "movie");
                        b();
                        ProgressDialog progressDialog2 = this.v;
                        if (progressDialog2 != null) {
                            progressDialog2.dismiss();
                        }
                        if (allLiveStreasWithCategoryId2 == null || this.g == null || allLiveStreasWithCategoryId2.size() == 0) {
                            textView = this.h;
                            if (textView != null) {
                                textView.setVisibility(0);
                            }
                        } else {
                            i0 i0Var2 = new i0(allLiveStreasWithCategoryId2, this.n, true);
                            this.E = i0Var2;
                            this.g.setAdapter(i0Var2);
                        }
                    }
                }
            }
            ProgressDialog progressDialog3 = this.v;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    private void O1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.I = popupWindow;
            popupWindow.setContentView(inflate);
            this.I.setWidth(-1);
            this.I.setHeight(-1);
            this.I.setFocusable(true);
            this.I.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            String string = this.J.getString("sort", "");
            if (string.equals("1")) {
                findViewById5.setChecked(true);
            } else if (string.equals("2")) {
                findViewById6.setChecked(true);
            } else if (string.equals("3")) {
                findViewById7.setChecked(true);
            } else {
                findViewById4.setChecked(true);
            }
            findViewById2.setOnClickListener(new a());
            findViewById.setOnClickListener(new b(findViewById3, inflate));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.n;
    }

    public static /* synthetic */ n0 v1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.z;
    }

    public static /* synthetic */ i0 w1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.E;
    }

    public static /* synthetic */ PopupWindow x1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.I;
    }

    public static /* synthetic */ SharedPreferences.Editor y1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.K;
    }

    public static /* synthetic */ SharedPreferences z1(VodActivityNewFlowSecondSubCategories vodActivityNewFlowSecondSubCategories) {
        return vodActivityNewFlowSecondSubCategories.A;
    }

    public void F1() {
        RecyclerView recyclerView;
        androidx.recyclerview.widget.c cVar;
        try {
            a();
            SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
            this.A = sharedPreferences;
            this.B = sharedPreferences.edit();
            int i2 = this.A.getInt("vod", 0);
            m7.a.N = i2;
            if (i2 == 1) {
                this.n = this;
                this.s = new LiveStreamDBHandler(this.n);
                RecyclerView recyclerView2 = this.g;
                if (recyclerView2 != null && this.n != null) {
                    recyclerView2.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.n);
                    this.C = linearLayoutManager;
                    this.g.setLayoutManager(linearLayoutManager);
                    recyclerView = this.g;
                    cVar = new androidx.recyclerview.widget.c();
                    recyclerView.setItemAnimator(cVar);
                }
            } else {
                this.n = this;
                this.s = new LiveStreamDBHandler(this.n);
                RecyclerView recyclerView3 = this.g;
                if (recyclerView3 != null && this.n != null) {
                    recyclerView3.setHasFixedSize(true);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.n, w.L(this.n) + 1);
                    this.C = gridLayoutManager;
                    this.g.setLayoutManager(gridLayoutManager);
                    recyclerView = this.g;
                    cVar = new androidx.recyclerview.widget.c();
                    recyclerView.setItemAnimator(cVar);
                }
            }
            if (this.n != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.n);
                ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", "movie");
                this.N = new ArrayList();
                this.O = new ArrayList();
                this.P = new ArrayList();
                this.Q = new ArrayList();
                if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.n)) <= 0 || allLiveStreasWithCategoryId == null) {
                    this.Q = allLiveStreasWithCategoryId;
                } else {
                    ArrayList G1 = G1();
                    this.M = G1;
                    if (G1 != null) {
                        this.P = H1(allLiveStreasWithCategoryId, G1);
                    }
                    this.Q = this.P;
                }
                b();
                ArrayList arrayList = this.Q;
                if (arrayList == null || this.g == null || arrayList.size() == 0) {
                    ProgressDialog progressDialog = this.v;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    TextView textView = this.h;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                } else {
                    ProgressDialog progressDialog2 = this.v;
                    if (progressDialog2 != null) {
                        progressDialog2.dismiss();
                    }
                    i0 i0Var = new i0(allLiveStreasWithCategoryId, this.n, true);
                    this.E = i0Var;
                    this.g.setAdapter(i0Var);
                }
            }
            ProgressDialog progressDialog3 = this.v;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
        } catch (NullPointerException | Exception unused) {
        }
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

    public void onBackPressed() {
        ProgressBar progressBar;
        j0 j0Var = this.G;
        if (j0Var != null && (progressBar = U) != null) {
            j0Var.F0(progressBar);
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
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("sort", 0);
        this.J = sharedPreferences;
        this.K = sharedPreferences.edit();
        if (this.J.getString("sort", "").equals("")) {
            this.K.putString("sort", "0");
            this.K.commit();
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.w = intent.getStringExtra("category_id");
            this.x = intent.getStringExtra("category_name");
        }
        this.n = this;
        this.G = new j0();
        this.m.setOnClickListener(new c());
        LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.n);
        this.s = liveStreamDBHandler;
        S = liveStreamDBHandler.getAllMovieCategoriesHavingParentIdNotZero(this.w);
        setContentView(a7.g.E1);
        I1();
        a();
        this.H = true;
        M1(S);
        overridePendingTransition(a7.b.f, a7.b.d);
        AppBarLayout appBarLayout = this.e;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        E1();
        r1(findViewById(a7.f.kh));
        this.n = this;
        if (!this.x.isEmpty()) {
            this.k.setText(this.x);
        }
        this.k.setSelected(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar toolbar;
        int i2;
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        if (this.H) {
            toolbar = this.d;
            i2 = a7.h.r;
        } else {
            toolbar = this.d;
            i2 = a7.h.s;
        }
        toolbar.x(i2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i3 = 0; i3 < this.d.getChildCount(); i3++) {
            if (this.d.getChildAt(i3) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i3).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x020b, code lost:
    
        if (r1.size() > 0) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r9) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSecondSubCategories.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.n);
        w.z0(this.n);
        getWindow().setFlags(1024, 1024);
        this.G.F0(U);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.o = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.o.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.n != null) {
            b();
        }
    }
}
