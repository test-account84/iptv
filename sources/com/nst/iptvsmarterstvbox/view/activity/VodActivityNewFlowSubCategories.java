package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import android.widget.Toast;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import m7.w;
import q7.i0;
import q7.j0;
import q7.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VodActivityNewFlowSubCategories extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ArrayList g0 = new ArrayList();
    public static ArrayList h0 = new ArrayList();
    public static ArrayList i0 = new ArrayList();
    public static ProgressBar j0;
    public LiveStreamDBHandler A;
    public SearchView C;
    public ProgressDialog D;
    public n0 H;
    public SharedPreferences I;
    public SharedPreferences.Editor J;
    public SharedPreferences K;
    public SharedPreferences.Editor L;
    public RecyclerView.o M;
    public SharedPreferences N;
    public i0 O;
    public DatabaseHandler Q;
    public j0 R;
    public PopupWindow T;
    public SharedPreferences U;
    public SharedPreferences.Editor V;
    public GridLayoutManager W;
    public Handler X;
    public MenuItem Y;
    public Menu Z;
    public Toolbar d;
    public AppBarLayout e;
    public RecentWatchDBHandler e0;
    public ProgressBar f;
    public RecyclerView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public ImageView m;
    public ImageView n;
    public Context o;
    public SharedPreferences p;
    public ArrayList r;
    public ArrayList s;
    public ArrayList t;
    public ArrayList u;
    public ArrayList v;
    public ArrayList w;
    public ArrayList q = new ArrayList();
    public String x = "";
    public String y = "";
    public DatabaseUpdatedStatusDBModel z = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel B = new DatabaseUpdatedStatusDBModel();
    public String E = "";
    public String F = "";
    public boolean G = false;
    public ArrayList P = new ArrayList();
    public boolean S = false;
    public boolean f0 = true;

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
            VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this)).equals("m3u")) {
                VodActivityNewFlowSubCategories.B1(VodActivityNewFlowSubCategories.this).deleteALLRecentwatch("movie", SharepreferenceDBHandler.getUserID(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this)));
            } else {
                new r(VodActivityNewFlowSubCategories.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public e(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setVODSubCatSort(findViewById.getText().toString().equals(VodActivityNewFlowSubCategories.this.getResources().getString(a7.j.i7)) ? "1" : findViewById.getText().toString().equals(VodActivityNewFlowSubCategories.this.getResources().getString(a7.j.f7)) ? "2" : findViewById.getText().toString().equals(VodActivityNewFlowSubCategories.this.getResources().getString(a7.j.k7)) ? "3" : "0", this.d);
            VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories = VodActivityNewFlowSubCategories.this;
            VodActivityNewFlowSubCategories.F1(vodActivityNewFlowSubCategories, vodActivityNewFlowSubCategories.getSharedPreferences("listgridview", 0));
            VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories2 = VodActivityNewFlowSubCategories.this;
            VodActivityNewFlowSubCategories.G1(vodActivityNewFlowSubCategories2, VodActivityNewFlowSubCategories.E1(vodActivityNewFlowSubCategories2).edit());
            int i = VodActivityNewFlowSubCategories.E1(VodActivityNewFlowSubCategories.this).getInt("vod", 0);
            m7.a.N = i;
            if (i == 1) {
                VodActivityNewFlowSubCategories.x1(VodActivityNewFlowSubCategories.this);
            } else {
                VodActivityNewFlowSubCategories.C1(VodActivityNewFlowSubCategories.this);
            }
            VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ RecentWatchDBHandler a;
        public final /* synthetic */ int c;
        public final /* synthetic */ Context d;

        public g(RecentWatchDBHandler recentWatchDBHandler, int i, Context context) {
            this.a = recentWatchDBHandler;
            this.c = i;
            this.d = context;
        }

        public void onClick(View view) {
            RecentWatchDBHandler recentWatchDBHandler = this.a;
            if (recentWatchDBHandler != null) {
                recentWatchDBHandler.deleteRecentwatch(this.c, "movie");
            }
            Toast.makeText(this.d, VodActivityNewFlowSubCategories.this.getResources().getString(a7.j.J3), 0).show();
            if (VodActivityNewFlowSubCategories.z1(VodActivityNewFlowSubCategories.this) != null) {
                VodActivityNewFlowSubCategories.y1(VodActivityNewFlowSubCategories.this);
                VodActivityNewFlowSubCategories.A1(VodActivityNewFlowSubCategories.this).dismiss();
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            w.j(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this));
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            VodActivityNewFlowSubCategories.this.onBackPressed();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this));
        }
    }

    public class l implements SearchView.m {
        public l() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            VodActivityNewFlowSubCategories.this.i.setVisibility(8);
            if (VodActivityNewFlowSubCategories.w1(VodActivityNewFlowSubCategories.this) == null || (textView = VodActivityNewFlowSubCategories.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityNewFlowSubCategories.w1(VodActivityNewFlowSubCategories.this).z0(str, VodActivityNewFlowSubCategories.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class m implements SearchView.m {
        public m() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            VodActivityNewFlowSubCategories.this.i.setVisibility(8);
            if (VodActivityNewFlowSubCategories.z1(VodActivityNewFlowSubCategories.this) == null || (textView = VodActivityNewFlowSubCategories.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityNewFlowSubCategories.z1(VodActivityNewFlowSubCategories.this).J0(str, VodActivityNewFlowSubCategories.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this));
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class q extends AsyncTask {
        public q() {
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                r0 = 0
                r1 = r7[r0]     // Catch: java.lang.Exception -> L5e
                int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L5e
                r3 = 3
                r4 = 2
                r5 = 1
                switch(r2) {
                    case -998452030: goto L2c;
                    case -723794989: goto L22;
                    case -74801864: goto L18;
                    case -74797390: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L5e
            Ld:
                goto L35
            Le:
                java.lang.String r0 = "get_fav"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L5e
                if (r0 == 0) goto L35
                r0 = 1
                goto L36
            L18:
                java.lang.String r0 = "get_all"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L5e
                if (r0 == 0) goto L35
                r0 = 2
                goto L36
            L22:
                java.lang.String r0 = "get_recent_watched"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L5e
                if (r0 == 0) goto L35
                r0 = 3
                goto L36
            L2c:
                java.lang.String r2 = "get_fav_m3u"
                boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L5e
                if (r1 == 0) goto L35
                goto L36
            L35:
                r0 = -1
            L36:
                if (r0 == 0) goto L57
                if (r0 == r5) goto L50
                if (r0 == r4) goto L47
                if (r0 == r3) goto L40
                r7 = 0
                return r7
            L40:
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r7 = com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.this     // Catch: java.lang.Exception -> L5e
                java.lang.String r7 = r7.R1()     // Catch: java.lang.Exception -> L5e
                return r7
            L47:
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r0 = com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.this     // Catch: java.lang.Exception -> L5e
                r7 = r7[r5]     // Catch: java.lang.Exception -> L5e
                java.lang.String r7 = r0.M1(r7)     // Catch: java.lang.Exception -> L5e
                return r7
            L50:
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r7 = com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.this     // Catch: java.lang.Exception -> L5e
                java.lang.String r7 = r7.O1()     // Catch: java.lang.Exception -> L5e
                return r7
            L57:
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r7 = com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.this     // Catch: java.lang.Exception -> L5e
                java.lang.String r7 = r7.P1()     // Catch: java.lang.Exception -> L5e
                return r7
            L5e:
                java.lang.String r7 = "error"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.q.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            str.hashCode();
            switch (str) {
                case "get_fav_m3u":
                    VodActivityNewFlowSubCategories.this.L1();
                    break;
                case "get_recent_watched":
                    VodActivityNewFlowSubCategories.this.a2();
                    break;
                case "get_all":
                    VodActivityNewFlowSubCategories.this.u1();
                    break;
                case "get_fav":
                    VodActivityNewFlowSubCategories.this.K1();
                    break;
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class r extends AsyncTask {
        public r() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return VodActivityNewFlowSubCategories.this.I1();
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ProgressBar progressBar = VodActivityNewFlowSubCategories.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (bool.booleanValue()) {
                Toast.makeText(VodActivityNewFlowSubCategories.v1(VodActivityNewFlowSubCategories.this), VodActivityNewFlowSubCategories.this.getResources().getString(a7.j.A), 0).show();
                VodActivityNewFlowSubCategories.C1(VodActivityNewFlowSubCategories.this);
            } else {
                VodActivityNewFlowSubCategories.D1(VodActivityNewFlowSubCategories.this).clear();
                VodActivityNewFlowSubCategories.z1(VodActivityNewFlowSubCategories.this).w();
                VodActivityNewFlowSubCategories.this.g.setVisibility(8);
                VodActivityNewFlowSubCategories.this.i.setVisibility(0);
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            ProgressBar progressBar = VodActivityNewFlowSubCategories.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }

        public /* synthetic */ r(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories, h hVar) {
            this();
        }
    }

    public class s implements View.OnFocusChangeListener {
        public final View a;

        public s(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            int i;
            if (z) {
                if (this.a.getTag() != null && this.a.getTag().equals("1")) {
                    b(1.15f);
                    c(1.15f);
                    view2 = this.a;
                    i = a7.e.h;
                } else {
                    if (this.a.getTag() == null || !this.a.getTag().equals("2")) {
                        b(1.15f);
                        return;
                    }
                    b(1.15f);
                    c(1.15f);
                    view2 = this.a;
                    i = a7.e.k1;
                }
            } else {
                if (z) {
                    return;
                }
                a(z);
                if ((this.a.getTag() == null || !this.a.getTag().equals("1")) && (this.a.getTag() == null || !this.a.getTag().equals("2"))) {
                    b(1.0f);
                    c(1.0f);
                    return;
                } else {
                    b(1.0f);
                    c(1.0f);
                    view2 = this.a;
                    i = a7.e.o;
                }
            }
            view2.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ PopupWindow A1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.T;
    }

    public static /* synthetic */ LiveStreamDBHandler B1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.A;
    }

    public static /* synthetic */ void C1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        vodActivityNewFlowSubCategories.X1();
    }

    public static /* synthetic */ ArrayList D1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.u;
    }

    public static /* synthetic */ SharedPreferences E1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.I;
    }

    public static /* synthetic */ SharedPreferences F1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories, SharedPreferences sharedPreferences) {
        vodActivityNewFlowSubCategories.I = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor G1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories, SharedPreferences.Editor editor) {
        vodActivityNewFlowSubCategories.J = editor;
        return editor;
    }

    private void H1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList Q1() {
        ArrayList allPasswordStatus = this.A.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.o));
        this.r = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.q.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.q;
    }

    private ArrayList S1(ArrayList arrayList, ArrayList arrayList2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.s.add(liveStreamsDBModel);
                    liveStreamsDBModel.getCategoryId();
                    break;
                }
                if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                    break;
                }
            }
        }
        return this.s;
    }

    private ArrayList T1(ArrayList arrayList, ArrayList arrayList2) {
        this.v = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.v.add(favouriteDBModel);
                        break;
                    }
                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        }
        return this.v;
    }

    private ArrayList U1(ArrayList arrayList, ArrayList arrayList2) {
        this.w = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.w.add(favouriteM3UModel);
                        break;
                    }
                    if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        }
        return this.w;
    }

    private void W1() {
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
        this.n = findViewById(a7.f.F4);
    }

    private void X1() {
        this.o = this;
        this.A = new LiveStreamDBHandler(this.o);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.o == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 7);
        this.M = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.N = this.o.getSharedPreferences("loginPrefs", 0);
        d2();
    }

    private void Y1() {
        this.o = this;
        this.A = new LiveStreamDBHandler(this.o);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.o == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
        this.M = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.N = this.o.getSharedPreferences("loginPrefs", 0);
        d2();
    }

    private void Z1(ArrayList arrayList) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.o == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        this.W = new u7.a(this.o).A().equals(m7.a.K0) ? new GridLayoutManager(this, 2) : new GridLayoutManager(this, 2);
        this.g.setLayoutManager(this.W);
        this.g.setHasFixedSize(true);
        b();
        n0 n0Var = new n0(arrayList, this.o, this.A);
        this.H = n0Var;
        this.g.setAdapter(n0Var);
    }

    private void b2() {
        SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
        this.I = sharedPreferences;
        this.J = sharedPreferences.edit();
        int i2 = this.I.getInt("vod", 0);
        m7.a.N = i2;
        if (i2 == 1) {
            Y1();
        } else {
            X1();
        }
    }

    private void c2(ArrayList arrayList) {
        Z1(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: NullPointerException | Exception -> 0x0089, TryCatch #0 {NullPointerException | Exception -> 0x0089, blocks: (B:2:0x0000, B:4:0x0004, B:12:0x002d, B:13:0x0040, B:14:0x0053, B:16:0x0061, B:17:0x0072, B:18:0x0014, B:21:0x001e, B:24:0x0082, B:26:0x0086), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d2() {
        /*
            r4 = this;
            android.content.Context r0 = r4.o     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L82
            java.lang.String r0 = r4.E     // Catch: java.lang.Throwable -> L89
            int r1 = r0.hashCode()     // Catch: java.lang.Throwable -> L89
            r2 = 1444(0x5a4, float:2.023E-42)
            r3 = 1
            if (r1 == r2) goto L1e
            r2 = 1447(0x5a7, float:2.028E-42)
            if (r1 == r2) goto L14
            goto L28
        L14:
            java.lang.String r1 = "-4"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L28
            r0 = 1
            goto L29
        L1e:
            java.lang.String r1 = "-1"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L28
            r0 = 0
            goto L29
        L28:
            r0 = -1
        L29:
            if (r0 == 0) goto L53
            if (r0 == r3) goto L40
            com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q r0 = new com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "get_all"
            java.lang.String r3 = r4.E     // Catch: java.lang.Throwable -> L89
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L89
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L89
            goto L82
        L40:
            com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q r0 = new com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "get_recent_watched"
            java.lang.String r3 = r4.E     // Catch: java.lang.Throwable -> L89
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L89
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L89
            goto L82
        L53:
            android.content.Context r0 = r4.o     // Catch: java.lang.Throwable -> L89
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r0)     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = "m3u"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L72
            com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q r0 = new com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "get_fav_m3u"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L89
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L89
            goto L82
        L72:
            com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q r0 = new com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories$q     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "get_fav"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L89
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L89
        L82:
            android.app.ProgressDialog r0 = r4.D     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L89
            r0.dismiss()     // Catch: java.lang.Throwable -> L89
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.d2():void");
    }

    private void e2() {
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            this.T = popupWindow;
            popupWindow.setContentView(inflate);
            this.T.setWidth(-1);
            this.T.setHeight(-1);
            this.T.setFocusable(true);
            this.T.showAtLocation(inflate, 17, 0, 0);
            inflate.findViewById(a7.f.Ai).setText(getResources().getString(a7.j.L0));
            Button findViewById = inflate.findViewById(a7.f.L0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
            }
            findViewById2.setOnClickListener(new b());
            if (findViewById != null) {
                findViewById.setOnClickListener(new c());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f2(android.app.Activity r17) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.f2(android.app.Activity):void");
    }

    public static /* synthetic */ Context v1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.o;
    }

    public static /* synthetic */ n0 w1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.H;
    }

    public static /* synthetic */ void x1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        vodActivityNewFlowSubCategories.Y1();
    }

    public static /* synthetic */ void y1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        vodActivityNewFlowSubCategories.b2();
    }

    public static /* synthetic */ i0 z1(VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        return vodActivityNewFlowSubCategories.O;
    }

    public Boolean I1() {
        ArrayList arrayList = this.u;
        if (arrayList == null || arrayList.size() <= 0) {
            return Boolean.FALSE;
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.e0.deleteRecentwatch(w.r0(((LiveStreamsDBModel) this.u.get(i2)).getStreamId()), "movie");
        }
        return Boolean.TRUE;
    }

    public void J1(int i2, String str, Context context, RecentWatchDBHandler recentWatchDBHandler) {
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            this.T = popupWindow;
            popupWindow.setContentView(inflate);
            this.T.setWidth(-1);
            this.T.setHeight(-1);
            this.T.setFocusable(true);
            this.T.showAtLocation(inflate, 17, 0, 0);
            inflate.findViewById(a7.f.Ai).setText(getResources().getString(a7.j.M0));
            Button findViewById = inflate.findViewById(a7.f.L0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new s(findViewById));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new s(findViewById2));
            }
            findViewById2.setOnClickListener(new f());
            if (findViewById != null) {
                findViewById.setOnClickListener(new g(recentWatchDBHandler, i2, context));
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void K1() {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (this.g != null && (arrayList2 = this.P) != null && arrayList2.size() != 0) {
            this.O = new i0(this.P, this.o, true);
            VodAllCategoriesSingleton.getInstance().setVodList(this.P);
            this.g.setAdapter(this.O);
            w.Q0(this.o, getResources().getString(a7.j.q8));
            this.h.setVisibility(4);
        }
        if (this.h != null && (arrayList = this.P) != null && arrayList.size() == 0) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.O);
            }
            this.h.setText(getResources().getString(a7.j.o4));
            this.h.setVisibility(0);
        }
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void L1() {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (this.g != null && (arrayList2 = this.P) != null && arrayList2.size() != 0) {
            this.O = new i0(this.P, this.o, true);
            VodAllCategoriesSingleton.getInstance().setVodList(this.P);
            this.g.setAdapter(this.O);
            w.Q0(this.o, getResources().getString(a7.j.q8));
            this.h.setVisibility(4);
        }
        if (this.h != null && (arrayList = this.P) != null && arrayList.size() == 0) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.O);
            }
            this.h.setText(getResources().getString(a7.j.o4));
            this.h.setVisibility(0);
        }
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public String M1(String str) {
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.u = this.A.getAllLiveStreasWithCategoryId(str, "movie");
        return "get_all";
    }

    public void N1() {
        RecyclerView recyclerView;
        androidx.recyclerview.widget.c cVar;
        try {
            a();
            SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
            this.I = sharedPreferences;
            this.J = sharedPreferences.edit();
            int i2 = this.I.getInt("vod", 0);
            m7.a.N = i2;
            if (i2 == 1) {
                this.o = this;
                this.A = new LiveStreamDBHandler(this.o);
                RecyclerView recyclerView2 = this.g;
                if (recyclerView2 != null && this.o != null) {
                    recyclerView2.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
                    this.M = linearLayoutManager;
                    this.g.setLayoutManager(linearLayoutManager);
                    recyclerView = this.g;
                    cVar = new androidx.recyclerview.widget.c();
                    recyclerView.setItemAnimator(cVar);
                }
            } else {
                this.o = this;
                this.A = new LiveStreamDBHandler(this.o);
                RecyclerView recyclerView3 = this.g;
                if (recyclerView3 != null && this.o != null) {
                    recyclerView3.setHasFixedSize(true);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 7);
                    this.M = gridLayoutManager;
                    this.g.setLayoutManager(gridLayoutManager);
                    recyclerView = this.g;
                    cVar = new androidx.recyclerview.widget.c();
                    recyclerView.setItemAnimator(cVar);
                }
            }
            if (this.o != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.o);
                ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", "movie");
                this.r = new ArrayList();
                this.s = new ArrayList();
                this.t = new ArrayList();
                this.u = new ArrayList();
                if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.o)) <= 0 || allLiveStreasWithCategoryId == null) {
                    this.u = allLiveStreasWithCategoryId;
                } else {
                    ArrayList Q1 = Q1();
                    this.q = Q1;
                    if (Q1 != null) {
                        this.t = S1(allLiveStreasWithCategoryId, Q1);
                    }
                    this.u = this.t;
                }
                b();
                ProgressBar progressBar = this.f;
                if (progressBar != null) {
                    progressBar.setVisibility(4);
                }
                ArrayList arrayList = this.u;
                if (arrayList == null || this.g == null || arrayList.size() == 0) {
                    ProgressDialog progressDialog = this.D;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    TextView textView = this.h;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    ProgressBar progressBar2 = this.f;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(4);
                    }
                } else {
                    ProgressDialog progressDialog2 = this.D;
                    if (progressDialog2 != null) {
                        progressDialog2.dismiss();
                    }
                    i0 i0Var = new i0(allLiveStreasWithCategoryId, this.o, true);
                    this.O = i0Var;
                    this.g.setAdapter(i0Var);
                }
            }
            ProgressDialog progressDialog3 = this.D;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public String O1() {
        new ArrayList();
        this.P.clear();
        DatabaseHandler databaseHandler = new DatabaseHandler(this.o);
        this.Q = databaseHandler;
        ArrayList allFavourites = databaseHandler.getAllFavourites("vod", SharepreferenceDBHandler.getUserID(this.o));
        if (this.q != null) {
            this.q = Q1();
        }
        ArrayList arrayList = this.q;
        if (arrayList != null && arrayList.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
            allFavourites = T1(allFavourites, this.q);
        }
        if (allFavourites == null || allFavourites.size() <= 0) {
            return "get_fav";
        }
        Iterator it = allFavourites.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            LiveStreamsDBModel liveStreamFavouriteRow = new LiveStreamDBHandler(this.o).getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), "");
            if (liveStreamFavouriteRow != null) {
                this.P.add(liveStreamFavouriteRow);
            }
        }
        return "get_fav";
    }

    public String P1() {
        new ArrayList();
        this.P.clear();
        ArrayList favouriteM3U = this.A.getFavouriteM3U("movie");
        if (this.q != null) {
            this.q = Q1();
        }
        ArrayList arrayList = this.q;
        if (arrayList != null && arrayList.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
            favouriteM3U = U1(favouriteM3U, this.q);
        }
        if (favouriteM3U == null || favouriteM3U.size() <= 0) {
            return "get_fav_m3u";
        }
        Iterator it = favouriteM3U.iterator();
        while (it.hasNext()) {
            FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
            ArrayList m3UFavouriteRow = this.A.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
            if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                this.P.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
            }
        }
        return "get_fav_m3u";
    }

    public String R1() {
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        ArrayList allLiveStreasWithCategoryId = SharepreferenceDBHandler.getCurrentAPPType(this.o).equals("m3u") ? this.A.getAllLiveStreasWithCategoryId("movie", SharepreferenceDBHandler.getUserID(this.o), "getalldata") : this.e0.getAllLiveStreasWithCategoryId("movie", SharepreferenceDBHandler.getUserID(this.o), "getalldata");
        if (this.A.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.o)) > 0 && allLiveStreasWithCategoryId != null) {
            ArrayList Q1 = Q1();
            this.q = Q1;
            if (Q1 != null) {
                this.t = S1(allLiveStreasWithCategoryId, Q1);
            }
            allLiveStreasWithCategoryId = this.t;
        }
        this.u = allLiveStreasWithCategoryId;
        return "get_recent_watched";
    }

    public void V1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void a() {
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void a2() {
        ProgressDialog progressDialog = this.D;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        ArrayList arrayList = this.u;
        if (arrayList == null || this.g == null || arrayList.size() == 0) {
            TextView textView = this.h;
            if (textView != null) {
                textView.setVisibility(0);
                this.g.setVisibility(8);
            }
        } else {
            this.f0 = false;
            this.O = new i0(this.u, this.o, false, this);
            VodAllCategoriesSingleton.getInstance().setVodList(this.u);
            this.g.setAdapter(this.O);
            w.Q0(this.o, getResources().getString(a7.j.q8));
        }
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void b() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        ProgressBar progressBar;
        j0 j0Var = this.R;
        if (j0Var != null && (progressBar = j0) != null) {
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5 A[PHI: r6
      0x00b5: PHI (r6v26 android.widget.ProgressBar) = (r6v14 android.widget.ProgressBar), (r6v37 android.widget.ProgressBar), (r6v41 android.widget.ProgressBar) binds: [B:40:0x0110, B:31:0x00d9, B:16:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.onCreate(android.os.Bundle):void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        if (this.S) {
            this.d.x(a7.h.r);
        } else {
            this.d.x(a7.h.s);
            int userID = SharepreferenceDBHandler.getUserID(this.o);
            if ((SharepreferenceDBHandler.getCurrentAPPType(this.o).equals("m3u") ? this.A.getRecentwatchCount(userID, "movie") : this.e0.getLiveStreamsCount(userID)) > 0 && this.E.equals("-4")) {
                menu.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
            SharedPreferences sharedPreferences = this.K;
            if (sharedPreferences != null) {
                if (sharedPreferences.getInt("vod", 1) == 1) {
                    menu.getItem(2).getSubMenu().findItem(a7.f.w6).setVisible(false);
                    menu.getItem(2).getSubMenu().findItem(a7.f.s6).setVisible(true);
                } else {
                    menu.getItem(2).getSubMenu().findItem(a7.f.w6).setVisible(true);
                    menu.getItem(2).getSubMenu().findItem(a7.f.s6).setVisible(false);
                }
            }
        }
        this.Z = menu;
        this.Y = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
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
        Menu menu = this.Z;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r10) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        V1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.o);
        w.z0(this.o);
        getWindow().setFlags(1024, 1024);
        this.R.F0(j0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.p.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.o != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        V1();
    }

    public void u1() {
        ProgressDialog progressDialog = this.D;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        ArrayList arrayList = this.u;
        if (arrayList == null || this.g == null || arrayList.size() == 0) {
            TextView textView = this.h;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            this.f0 = true;
            this.O = new i0(this.u, this.o, true);
            VodAllCategoriesSingleton.getInstance().setVodList(this.u);
            this.g.setAdapter(this.O);
            w.Q0(this.o, getResources().getString(a7.j.q8));
        }
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
