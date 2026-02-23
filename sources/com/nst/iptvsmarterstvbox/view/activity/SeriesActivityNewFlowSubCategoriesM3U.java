package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import m7.w;
import q7.W;
import q7.j0;
import q7.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesActivityNewFlowSubCategoriesM3U extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ArrayList X = new ArrayList();
    public static ArrayList Y = new ArrayList();
    public static ArrayList Z = new ArrayList();
    public static ProgressBar e0;
    public SearchView A;
    public ProgressDialog B;
    public n0 F;
    public SharedPreferences G;
    public SharedPreferences.Editor H;
    public RecyclerView.o I;
    public SharedPreferences J;
    public W K;
    public j0 M;
    public PopupWindow O;
    public SharedPreferences P;
    public SharedPreferences.Editor Q;
    public GridLayoutManager R;
    public Handler S;
    public MenuItem T;
    public Menu U;
    public RecentWatchDBHandler V;
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
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    public ArrayList t;
    public ArrayList u;
    public LiveStreamDBHandler y;
    public ArrayList p = new ArrayList();
    public String v = "";
    public String w = "";
    public DatabaseUpdatedStatusDBModel x = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel z = new DatabaseUpdatedStatusDBModel();
    public String C = "";
    public String D = "";
    public boolean E = false;
    public ArrayList L = new ArrayList();
    public boolean N = false;
    public boolean W = true;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SeriesActivityNewFlowSubCategoriesM3U.H1(SeriesActivityNewFlowSubCategoriesM3U.this));
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

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            Menu menu = SeriesActivityNewFlowSubCategoriesM3U.this.U;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            }
            SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U = SeriesActivityNewFlowSubCategoriesM3U.this;
            seriesActivityNewFlowSubCategoriesM3U.V.deleteALLRecentwatch("movie", SharepreferenceDBHandler.getUserID(SeriesActivityNewFlowSubCategoriesM3U.H1(seriesActivityNewFlowSubCategoriesM3U)));
            SeriesActivityNewFlowSubCategoriesM3U.L1(SeriesActivityNewFlowSubCategoriesM3U.this).clear();
            SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this).w();
            SeriesActivityNewFlowSubCategoriesM3U.this.i.setVisibility(0);
            Toast.makeText(SeriesActivityNewFlowSubCategoriesM3U.H1(SeriesActivityNewFlowSubCategoriesM3U.this), SeriesActivityNewFlowSubCategoriesM3U.this.getResources().getString(a7.j.A), 0).show();
            SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public h(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setSeriesSubCatSort(findViewById.getText().toString().equals(SeriesActivityNewFlowSubCategoriesM3U.this.getResources().getString(a7.j.i7)) ? "1" : findViewById.getText().toString().equals(SeriesActivityNewFlowSubCategoriesM3U.this.getResources().getString(a7.j.f7)) ? "2" : findViewById.getText().toString().equals(SeriesActivityNewFlowSubCategoriesM3U.this.getResources().getString(a7.j.k7)) ? "3" : "0", this.d);
            SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U = SeriesActivityNewFlowSubCategoriesM3U.this;
            SeriesActivityNewFlowSubCategoriesM3U.N1(seriesActivityNewFlowSubCategoriesM3U, seriesActivityNewFlowSubCategoriesM3U.getSharedPreferences("listgridview", 0));
            int i = SeriesActivityNewFlowSubCategoriesM3U.M1(SeriesActivityNewFlowSubCategoriesM3U.this).getInt("series", 0);
            m7.a.O = i;
            if (i == 1) {
                SeriesActivityNewFlowSubCategoriesM3U.O1(SeriesActivityNewFlowSubCategoriesM3U.this);
            } else {
                SeriesActivityNewFlowSubCategoriesM3U.w1(SeriesActivityNewFlowSubCategoriesM3U.this);
            }
            SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ RecentWatchDBHandler a;
        public final /* synthetic */ int c;
        public final /* synthetic */ Context d;

        public j(RecentWatchDBHandler recentWatchDBHandler, int i, Context context) {
            this.a = recentWatchDBHandler;
            this.c = i;
            this.d = context;
        }

        public void onClick(View view) {
            RecentWatchDBHandler recentWatchDBHandler = this.a;
            if (recentWatchDBHandler != null) {
                recentWatchDBHandler.deleteRecentwatch(this.c, "movie");
            }
            int i = 0;
            Toast.makeText(this.d, SeriesActivityNewFlowSubCategoriesM3U.this.getResources().getString(a7.j.J3), 0).show();
            if (SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this) != null) {
                SeriesActivityNewFlowSubCategoriesM3U.x1(SeriesActivityNewFlowSubCategoriesM3U.this, new ArrayList());
                SeriesActivityNewFlowSubCategoriesM3U.y1(SeriesActivityNewFlowSubCategoriesM3U.this, new ArrayList());
                SeriesActivityNewFlowSubCategoriesM3U.A1(SeriesActivityNewFlowSubCategoriesM3U.this, new ArrayList());
                ArrayList allLiveStreasWithCategoryId = this.a.getAllLiveStreasWithCategoryId("movie", SharepreferenceDBHandler.getUserID(this.d), "getalldata");
                if (SeriesActivityNewFlowSubCategoriesM3U.B1(SeriesActivityNewFlowSubCategoriesM3U.this).getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.d)) <= 0 || allLiveStreasWithCategoryId == null) {
                    SeriesActivityNewFlowSubCategoriesM3U.L1(SeriesActivityNewFlowSubCategoriesM3U.this).clear();
                    if (allLiveStreasWithCategoryId.isEmpty()) {
                        SeriesActivityNewFlowSubCategoriesM3U.this.i.setVisibility(0);
                        SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this).w();
                    } else {
                        while (i < allLiveStreasWithCategoryId.size()) {
                            SeriesActivityNewFlowSubCategoriesM3U.L1(SeriesActivityNewFlowSubCategoriesM3U.this).add((LiveStreamsDBModel) allLiveStreasWithCategoryId.get(i));
                            SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this).w();
                            i++;
                        }
                    }
                } else {
                    SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U = SeriesActivityNewFlowSubCategoriesM3U.this;
                    SeriesActivityNewFlowSubCategoriesM3U.D1(seriesActivityNewFlowSubCategoriesM3U, SeriesActivityNewFlowSubCategoriesM3U.E1(seriesActivityNewFlowSubCategoriesM3U));
                    if (SeriesActivityNewFlowSubCategoriesM3U.C1(SeriesActivityNewFlowSubCategoriesM3U.this) != null) {
                        SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U2 = SeriesActivityNewFlowSubCategoriesM3U.this;
                        SeriesActivityNewFlowSubCategoriesM3U.A1(seriesActivityNewFlowSubCategoriesM3U2, SeriesActivityNewFlowSubCategoriesM3U.F1(seriesActivityNewFlowSubCategoriesM3U2, allLiveStreasWithCategoryId, SeriesActivityNewFlowSubCategoriesM3U.C1(seriesActivityNewFlowSubCategoriesM3U2)));
                    }
                    SeriesActivityNewFlowSubCategoriesM3U.L1(SeriesActivityNewFlowSubCategoriesM3U.this).clear();
                    if (SeriesActivityNewFlowSubCategoriesM3U.z1(SeriesActivityNewFlowSubCategoriesM3U.this) != null) {
                        while (i < SeriesActivityNewFlowSubCategoriesM3U.z1(SeriesActivityNewFlowSubCategoriesM3U.this).size()) {
                            SeriesActivityNewFlowSubCategoriesM3U.L1(SeriesActivityNewFlowSubCategoriesM3U.this).add((LiveStreamsDBModel) SeriesActivityNewFlowSubCategoriesM3U.z1(SeriesActivityNewFlowSubCategoriesM3U.this).get(i));
                            SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this).w();
                            i++;
                        }
                    }
                }
                SeriesActivityNewFlowSubCategoriesM3U.K1(SeriesActivityNewFlowSubCategoriesM3U.this).dismiss();
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            SeriesActivityNewFlowSubCategoriesM3U.u1(SeriesActivityNewFlowSubCategoriesM3U.this);
            ProgressBar progressBar = SeriesActivityNewFlowSubCategoriesM3U.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        public void run() {
            SeriesActivityNewFlowSubCategoriesM3U.u1(SeriesActivityNewFlowSubCategoriesM3U.this);
            ProgressBar progressBar = SeriesActivityNewFlowSubCategoriesM3U.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            SeriesActivityNewFlowSubCategoriesM3U.u1(SeriesActivityNewFlowSubCategoriesM3U.this);
            ProgressBar progressBar = SeriesActivityNewFlowSubCategoriesM3U.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            SeriesActivityNewFlowSubCategoriesM3U.G1(SeriesActivityNewFlowSubCategoriesM3U.this, SeriesActivityNewFlowSubCategoriesM3U.v1());
            ProgressBar progressBar = SeriesActivityNewFlowSubCategoriesM3U.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            w.j(SeriesActivityNewFlowSubCategoriesM3U.H1(SeriesActivityNewFlowSubCategoriesM3U.this));
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SeriesActivityNewFlowSubCategoriesM3U.H1(SeriesActivityNewFlowSubCategoriesM3U.this));
        }
    }

    public class r implements SearchView.m {
        public r() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            SeriesActivityNewFlowSubCategoriesM3U.this.i.setVisibility(8);
            if (SeriesActivityNewFlowSubCategoriesM3U.I1(SeriesActivityNewFlowSubCategoriesM3U.this) == null || (textView = SeriesActivityNewFlowSubCategoriesM3U.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            SeriesActivityNewFlowSubCategoriesM3U.I1(SeriesActivityNewFlowSubCategoriesM3U.this).z0(str, SeriesActivityNewFlowSubCategoriesM3U.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class s implements SearchView.m {
        public s() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            SeriesActivityNewFlowSubCategoriesM3U.this.i.setVisibility(8);
            if (SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this) == null || (textView = SeriesActivityNewFlowSubCategoriesM3U.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            SeriesActivityNewFlowSubCategoriesM3U.J1(SeriesActivityNewFlowSubCategoriesM3U.this).F0(str, SeriesActivityNewFlowSubCategoriesM3U.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class t implements View.OnFocusChangeListener {
        public final View a;

        public t(View view) {
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
            if (z) {
                b(1.15f);
                c(1.15f);
            } else {
                if (z) {
                    return;
                }
                b(1.0f);
                c(1.0f);
                a(z);
            }
        }
    }

    public static /* synthetic */ ArrayList A1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList) {
        seriesActivityNewFlowSubCategoriesM3U.s = arrayList;
        return arrayList;
    }

    public static /* synthetic */ LiveStreamDBHandler B1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.y;
    }

    public static /* synthetic */ ArrayList C1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.p;
    }

    public static /* synthetic */ ArrayList D1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList) {
        seriesActivityNewFlowSubCategoriesM3U.p = arrayList;
        return arrayList;
    }

    public static /* synthetic */ ArrayList E1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.S1();
    }

    public static /* synthetic */ ArrayList F1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList, ArrayList arrayList2) {
        return seriesActivityNewFlowSubCategoriesM3U.T1(arrayList, arrayList2);
    }

    public static /* synthetic */ void G1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList) {
        seriesActivityNewFlowSubCategoriesM3U.Z1(arrayList);
    }

    public static /* synthetic */ Context H1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.n;
    }

    public static /* synthetic */ n0 I1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.F;
    }

    public static /* synthetic */ W J1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.K;
    }

    public static /* synthetic */ PopupWindow K1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.O;
    }

    public static /* synthetic */ ArrayList L1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.t;
    }

    public static /* synthetic */ SharedPreferences M1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.G;
    }

    public static /* synthetic */ SharedPreferences N1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, SharedPreferences sharedPreferences) {
        seriesActivityNewFlowSubCategoriesM3U.G = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ void O1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        seriesActivityNewFlowSubCategoriesM3U.W1();
    }

    private void P1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList S1() {
        ArrayList allPasswordStatus = this.y.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.n));
        this.q = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.p.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.p;
    }

    private ArrayList T1(ArrayList arrayList, ArrayList arrayList2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.r.add(liveStreamsDBModel);
                    liveStreamsDBModel.getCategoryId();
                    break;
                }
                if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                    break;
                }
            }
        }
        return this.r;
    }

    private ArrayList U1(ArrayList arrayList, ArrayList arrayList2) {
        this.u = new ArrayList();
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
                        this.u.add(favouriteM3UModel);
                        break;
                    }
                    if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        }
        return this.u;
    }

    private void V1() {
        this.n = this;
        this.y = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.n, w.L(this.n) + 1);
        this.I = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.J = this.n.getSharedPreferences("loginPrefs", 0);
        a2();
    }

    private void W1() {
        this.n = this;
        this.y = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.n);
        this.I = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.J = this.n.getSharedPreferences("loginPrefs", 0);
        a2();
    }

    private void X1(ArrayList arrayList) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        this.R = new u7.a(this.n).A().equals(m7.a.K0) ? new GridLayoutManager(this, 2) : new GridLayoutManager(this, 2);
        this.g.setLayoutManager(this.R);
        this.g.setHasFixedSize(true);
        b();
        n0 n0Var = new n0(arrayList, this.n, this.y);
        this.F = n0Var;
        this.g.setAdapter(n0Var);
    }

    private void Y1() {
        SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
        this.G = sharedPreferences;
        this.H = sharedPreferences.edit();
        int i2 = this.G.getInt("series", 0);
        m7.a.O = i2;
        if (i2 == 1) {
            W1();
        } else {
            V1();
        }
    }

    private void Z1(ArrayList arrayList) {
        X1(arrayList);
    }

    private void a2() {
        TextView textView;
        Context context;
        Resources resources;
        int i2;
        try {
            if (this.n != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.n);
                RecentWatchDBHandler recentWatchDBHandler = new RecentWatchDBHandler(this.n);
                if (this.C.equals("-1")) {
                    R1();
                } else if (this.C.equals("-4")) {
                    this.q = new ArrayList();
                    this.r = new ArrayList();
                    this.s = new ArrayList();
                    this.t = new ArrayList();
                    ArrayList allLiveStreasWithCategoryId = recentWatchDBHandler.getAllLiveStreasWithCategoryId("movie", SharepreferenceDBHandler.getUserID(this.n), "getalldata");
                    if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.n)) <= 0 || allLiveStreasWithCategoryId == null) {
                        this.t = allLiveStreasWithCategoryId;
                    } else {
                        ArrayList S1 = S1();
                        this.p = S1;
                        if (S1 != null) {
                            this.s = T1(allLiveStreasWithCategoryId, S1);
                        }
                        this.t = this.s;
                    }
                    b();
                    ProgressDialog progressDialog = this.B;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    ArrayList arrayList = this.t;
                    if (arrayList == null || this.g == null || arrayList.size() == 0) {
                        textView = this.h;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    } else {
                        this.W = false;
                        this.K = new W(this.t, this.n, false, this, this.D);
                        VodAllCategoriesSingleton.getInstance().setVodList(this.t);
                        this.g.setAdapter(this.K);
                        context = this.n;
                        resources = getResources();
                        i2 = a7.j.q8;
                        w.Q0(context, resources.getString(i2));
                    }
                } else if (this.C.equals("0")) {
                    this.q = new ArrayList();
                    this.r = new ArrayList();
                    this.s = new ArrayList();
                    this.t = new ArrayList();
                    ArrayList allLiveStreasWithCategoryId2 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.C, "series");
                    if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.n)) <= 0 || allLiveStreasWithCategoryId2 == null) {
                        this.t = allLiveStreasWithCategoryId2;
                    } else {
                        ArrayList S12 = S1();
                        this.p = S12;
                        if (S12 != null) {
                            this.s = T1(allLiveStreasWithCategoryId2, S12);
                        }
                        this.t = this.s;
                    }
                    b();
                    ProgressDialog progressDialog2 = this.B;
                    if (progressDialog2 != null) {
                        progressDialog2.dismiss();
                    }
                    ArrayList arrayList2 = this.t;
                    if (arrayList2 == null || this.g == null || arrayList2.size() == 0) {
                        textView = this.h;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    } else {
                        this.W = true;
                        this.K = new W(this.t, this.n, true, this.D);
                        VodAllCategoriesSingleton.getInstance().setVodList(this.t);
                        this.g.setAdapter(this.K);
                        context = this.n;
                        resources = getResources();
                        i2 = a7.j.q8;
                        w.Q0(context, resources.getString(i2));
                    }
                } else {
                    ArrayList allLiveStreasWithCategoryId3 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.C, "series");
                    b();
                    ProgressDialog progressDialog3 = this.B;
                    if (progressDialog3 != null) {
                        progressDialog3.dismiss();
                    }
                    if (allLiveStreasWithCategoryId3 != null && this.g != null && allLiveStreasWithCategoryId3.size() != 0) {
                        this.W = true;
                        this.K = new W(allLiveStreasWithCategoryId3, this.n, true, this.D);
                        VodAllCategoriesSingleton.getInstance().setVodList(allLiveStreasWithCategoryId3);
                        this.g.setAdapter(this.K);
                        this.K.w();
                        context = this.n;
                        resources = getResources();
                        i2 = a7.j.q8;
                        w.Q0(context, resources.getString(i2));
                    } else if (this.h != null) {
                        ProgressBar progressBar = this.f;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        textView = this.h;
                        textView.setVisibility(0);
                    }
                }
            }
            ProgressDialog progressDialog4 = this.B;
            if (progressDialog4 != null) {
                progressDialog4.dismiss();
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    private void b2() {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(this);
        this.O = popupWindow;
        popupWindow.setContentView(inflate);
        this.O.setWidth(-1);
        this.O.setHeight(-1);
        this.O.setFocusable(true);
        this.O.showAtLocation(inflate, 17, 0, 0);
        inflate.findViewById(a7.f.Ai).setText(getResources().getString(a7.j.L0));
        Button findViewById = inflate.findViewById(a7.f.L0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        if (findViewById != null) {
            findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
        }
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
        }
        findViewById2.setOnClickListener(new e());
        if (findViewById != null) {
            findViewById.setOnClickListener(new f());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void c2(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.O = popupWindow;
            popupWindow.setContentView(inflate);
            char c2 = 65535;
            this.O.setWidth(-1);
            this.O.setHeight(-1);
            this.O.setFocusable(true);
            this.O.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            findViewById5.setVisibility(8);
            RadioButton findViewById6 = inflate.findViewById(a7.f.gd);
            findViewById6.setVisibility(8);
            RadioButton findViewById7 = inflate.findViewById(a7.f.hd);
            findViewById7.setVisibility(8);
            RadioButton findViewById8 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById9 = inflate.findViewById(a7.f.zd);
            findViewById4.setOnFocusChangeListener(new t(findViewById4));
            findViewById5.setOnFocusChangeListener(new t(findViewById5));
            findViewById8.setOnFocusChangeListener(new t(findViewById8));
            findViewById9.setOnFocusChangeListener(new t(findViewById9));
            findViewById6.setOnFocusChangeListener(new t(findViewById6));
            findViewById7.setOnFocusChangeListener(new t(findViewById7));
            String seriesSubCatSort = SharepreferenceDBHandler.getSeriesSubCatSort(activity);
            switch (seriesSubCatSort.hashCode()) {
                case 49:
                    if (seriesSubCatSort.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (seriesSubCatSort.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (seriesSubCatSort.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                findViewById5.setChecked(true);
            } else if (c2 == 1) {
                findViewById8.setChecked(true);
            } else if (c2 != 2) {
                findViewById4.setChecked(true);
            } else {
                findViewById9.setChecked(true);
            }
            findViewById2.setOnClickListener(new g());
            findViewById.setOnClickListener(new h(findViewById3, inflate, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ void u1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        seriesActivityNewFlowSubCategoriesM3U.Y1();
    }

    public static /* synthetic */ ArrayList v1() {
        return Y;
    }

    public static /* synthetic */ void w1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        seriesActivityNewFlowSubCategoriesM3U.V1();
    }

    public static /* synthetic */ ArrayList x1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList) {
        seriesActivityNewFlowSubCategoriesM3U.q = arrayList;
        return arrayList;
    }

    public static /* synthetic */ ArrayList y1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U, ArrayList arrayList) {
        seriesActivityNewFlowSubCategoriesM3U.r = arrayList;
        return arrayList;
    }

    public static /* synthetic */ ArrayList z1(SeriesActivityNewFlowSubCategoriesM3U seriesActivityNewFlowSubCategoriesM3U) {
        return seriesActivityNewFlowSubCategoriesM3U.s;
    }

    public void Q1(int i2, String str, Context context, RecentWatchDBHandler recentWatchDBHandler) {
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            this.O = popupWindow;
            popupWindow.setContentView(inflate);
            this.O.setWidth(-1);
            this.O.setHeight(-1);
            this.O.setFocusable(true);
            this.O.showAtLocation(inflate, 17, 0, 0);
            inflate.findViewById(a7.f.Ai).setText(getResources().getString(a7.j.M0));
            Button findViewById = inflate.findViewById(a7.f.L0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
            }
            findViewById2.setOnClickListener(new i());
            if (findViewById != null) {
                findViewById.setOnClickListener(new j(recentWatchDBHandler, i2, context));
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void R1() {
        ArrayList arrayList;
        ArrayList arrayList2;
        new ArrayList();
        this.L.clear();
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.K);
        }
        if (this.n != null) {
            ArrayList favouriteM3U = this.y.getFavouriteM3U("series");
            if (this.p != null) {
                this.p = S1();
            }
            ArrayList arrayList3 = this.p;
            if (arrayList3 != null && arrayList3.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                favouriteM3U = U1(favouriteM3U, this.p);
            }
            if (favouriteM3U != null && favouriteM3U.size() > 0) {
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.y.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        this.L.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
            }
            b();
            if (this.g != null && (arrayList2 = this.L) != null && arrayList2.size() != 0) {
                this.K = new W(this.L, this.n, true, this.D);
                VodAllCategoriesSingleton.getInstance().setVodList(this.L);
                this.g.setAdapter(this.K);
                w.Q0(this.n, getResources().getString(a7.j.q8));
                this.h.setVisibility(4);
            }
            if (this.h == null || (arrayList = this.L) == null || arrayList.size() != 0) {
                return;
            }
            RecyclerView recyclerView2 = this.g;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.K);
            }
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.h.setText(getResources().getString(a7.j.l4));
            this.h.setVisibility(0);
        }
    }

    public void a() {
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(0);
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
        j0 j0Var = this.M;
        if (j0Var != null && (progressBar = e0) != null) {
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
        Handler handler;
        Runnable lVar;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("sort", 0);
        this.P = sharedPreferences;
        this.Q = sharedPreferences.edit();
        if (this.P.getString("sort", "").equals("")) {
            this.Q.putString("sort", "0");
            this.Q.commit();
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.C = intent.getStringExtra("category_id");
            this.D = intent.getStringExtra("category_name");
        }
        this.n = this;
        this.M = new j0();
        this.y = new LiveStreamDBHandler(this.n);
        this.S = new Handler();
        this.V = new RecentWatchDBHandler(this.n);
        String str = this.C;
        str.hashCode();
        if (str.equals("0")) {
            setContentView(a7.g.C1);
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
            a();
            this.S.removeCallbacksAndMessages((Object) null);
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            handler = this.S;
            lVar = new l();
        } else if (str.equals("-1")) {
            setContentView(a7.g.C1);
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
            this.S.removeCallbacksAndMessages((Object) null);
            ProgressBar progressBar2 = this.f;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
            handler = this.S;
            lVar = new k();
        } else {
            ArrayList allMovieCategoriesHavingParentIdNotZero = this.y.getAllMovieCategoriesHavingParentIdNotZero(this.C);
            Y = allMovieCategoriesHavingParentIdNotZero;
            if (allMovieCategoriesHavingParentIdNotZero == null || allMovieCategoriesHavingParentIdNotZero.size() != 0) {
                setContentView(a7.g.E1);
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
                a();
                this.N = true;
                this.S.removeCallbacksAndMessages((Object) null);
                ProgressBar progressBar3 = this.f;
                if (progressBar3 != null) {
                    progressBar3.setVisibility(0);
                }
                handler = this.S;
                lVar = new n();
            } else {
                setContentView(a7.g.C1);
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
                a();
                this.S.removeCallbacksAndMessages((Object) null);
                ProgressBar progressBar4 = this.f;
                if (progressBar4 != null) {
                    progressBar4.setVisibility(0);
                }
                handler = this.S;
                lVar = new m();
            }
        }
        handler.postDelayed(lVar, 1000L);
        overridePendingTransition(a7.b.f, a7.b.d);
        AppBarLayout appBarLayout = this.e;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        P1();
        r1(findViewById(a7.f.kh));
        this.n = this;
        if (!this.D.isEmpty()) {
            this.k.setText(this.D);
        }
        this.k.setSelected(true);
        this.m.setOnClickListener(new o());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        if (this.N) {
            this.d.x(a7.h.r);
        } else {
            this.d.x(a7.h.s);
            if (this.V.getLiveStreamsCount(SharepreferenceDBHandler.getUserID(this.n)) > 0 && this.C.equals("-4")) {
                menu.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
        }
        this.U = menu;
        this.T = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
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
        Menu menu = this.U;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r9) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivityNewFlowSubCategoriesM3U.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.n);
        w.z0(this.n);
        getWindow().setFlags(1024, 1024);
        this.M.F0(e0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.o = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.o.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.n != null) {
            b();
        }
    }
}
