package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m7.w;
import q7.V;
import q7.j0;
import q7.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesActivitNewFlowSubCat extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ArrayList f0 = new ArrayList();
    public static ArrayList g0 = new ArrayList();
    public static ArrayList h0 = new ArrayList();
    public static ProgressBar i0;
    public SharedPreferences.Editor A;
    public RecyclerView.o B;
    public SharedPreferences C;
    public V D;
    public DatabaseHandler F;
    public j0 G;
    public PopupWindow I;
    public GridLayoutManager J;
    public Handler K;
    public MenuItem L;
    public Menu M;
    public String O;
    public ArrayList P;
    public ArrayList Q;
    public ArrayList R;
    public ArrayList S;
    public SeriesRecentWatchDatabase Z;
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
    public ProgressDialog u;
    public n0 y;
    public SharedPreferences z;
    public String p = "";
    public String q = "";
    public DatabaseUpdatedStatusDBModel r = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel t = new DatabaseUpdatedStatusDBModel();
    public String v = "";
    public String w = "";
    public boolean x = false;
    public ArrayList E = new ArrayList();
    public boolean H = false;
    public ArrayList N = new ArrayList();
    public ArrayList T = new ArrayList();
    public Map U = new HashMap();
    public Map V = new HashMap();
    public ArrayList W = new ArrayList();
    public ArrayList X = new ArrayList();
    public ArrayList Y = new ArrayList();
    public List e0 = new ArrayList();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(SeriesActivitNewFlowSubCat.w1(SeriesActivitNewFlowSubCat.this));
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SeriesActivitNewFlowSubCat.w1(SeriesActivitNewFlowSubCat.this));
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            SeriesActivitNewFlowSubCat.x1(SeriesActivitNewFlowSubCat.this).dismiss();
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
            SharepreferenceDBHandler.setSeriesSubCatSort(findViewById.getText().toString().equals(SeriesActivitNewFlowSubCat.this.getResources().getString(a7.j.i7)) ? "1" : findViewById.getText().toString().equals(SeriesActivitNewFlowSubCat.this.getResources().getString(a7.j.f7)) ? "2" : findViewById.getText().toString().equals(SeriesActivitNewFlowSubCat.this.getResources().getString(a7.j.k7)) ? "3" : "0", this.d);
            SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat = SeriesActivitNewFlowSubCat.this;
            SeriesActivitNewFlowSubCat.z1(seriesActivitNewFlowSubCat, seriesActivitNewFlowSubCat.getSharedPreferences("listgridview", 0));
            int i = SeriesActivitNewFlowSubCat.y1(SeriesActivitNewFlowSubCat.this).getInt("series", 0);
            m7.a.O = i;
            if (i == 1) {
                SeriesActivitNewFlowSubCat.A1(SeriesActivitNewFlowSubCat.this);
            } else {
                SeriesActivitNewFlowSubCat.B1(SeriesActivitNewFlowSubCat.this);
            }
            SeriesActivitNewFlowSubCat.x1(SeriesActivitNewFlowSubCat.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            new i(SeriesActivitNewFlowSubCat.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            SeriesActivitNewFlowSubCat.x1(SeriesActivitNewFlowSubCat.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            SeriesActivitNewFlowSubCat.x1(SeriesActivitNewFlowSubCat.this).dismiss();
        }
    }

    public class h extends AsyncTask {
        public h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                r0 = 0
                r1 = r7[r0]     // Catch: java.lang.Exception -> L56
                int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L56
                r3 = -74801864(0xfffffffffb8a9d38, float:-1.4394515E36)
                r4 = 2
                r5 = 1
                if (r2 == r3) goto L2c
                r3 = -74797390(0xfffffffffb8aaeb2, float:-1.4401604E36)
                if (r2 == r3) goto L23
                r0 = 1997009972(0x7707f434, float:2.757473E33)
                if (r2 == r0) goto L19
                goto L36
            L19:
                java.lang.String r0 = "get_recent_watch"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L56
                if (r0 == 0) goto L36
                r0 = 2
                goto L37
            L23:
                java.lang.String r2 = "get_fav"
                boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L56
                if (r1 == 0) goto L36
                goto L37
            L2c:
                java.lang.String r0 = "get_all"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L56
                if (r0 == 0) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = -1
            L37:
                if (r0 == 0) goto L4f
                if (r0 == r5) goto L46
                if (r0 == r4) goto L3f
                r7 = 0
                return r7
            L3f:
                com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.this     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.D1(r7)     // Catch: java.lang.Exception -> L56
                return r7
            L46:
                com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat r0 = com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.this     // Catch: java.lang.Exception -> L56
                r7 = r7[r5]     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = r0.I1(r7)     // Catch: java.lang.Exception -> L56
                return r7
            L4f:
                com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.this     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = r7.J1()     // Catch: java.lang.Exception -> L56
                return r7
            L56:
                java.lang.String r7 = "error"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.h.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -74801864:
                    if (str.equals("get_all")) {
                        c = 0;
                        break;
                    }
                    break;
                case -74797390:
                    if (str.equals("get_fav")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1997009972:
                    if (str.equals("get_recent_watch")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat = SeriesActivitNewFlowSubCat.this;
            switch (c) {
                case 0:
                    seriesActivitNewFlowSubCat.u1();
                    break;
                case 1:
                    seriesActivitNewFlowSubCat.H1();
                    break;
                case 2:
                    SeriesActivitNewFlowSubCat.E1(seriesActivitNewFlowSubCat);
                    break;
                default:
                    seriesActivitNewFlowSubCat.P1(false);
                    break;
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class i extends AsyncTask {
        public i() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return SeriesActivitNewFlowSubCat.this.G1();
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ProgressBar progressBar = SeriesActivitNewFlowSubCat.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (bool.booleanValue()) {
                Toast.makeText(SeriesActivitNewFlowSubCat.w1(SeriesActivitNewFlowSubCat.this), SeriesActivitNewFlowSubCat.this.getResources().getString(a7.j.B), 0).show();
                SeriesActivitNewFlowSubCat.this.P1(false);
                return;
            }
            SeriesActivitNewFlowSubCat.C1(SeriesActivitNewFlowSubCat.this).clear();
            SeriesActivitNewFlowSubCat.this.g.setVisibility(8);
            SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat = SeriesActivitNewFlowSubCat.this;
            seriesActivitNewFlowSubCat.i.setText(seriesActivitNewFlowSubCat.getResources().getString(a7.j.i4));
            SeriesActivitNewFlowSubCat.this.i.setVisibility(0);
        }

        public void onPreExecute() {
            super.onPreExecute();
            ProgressBar progressBar = SeriesActivitNewFlowSubCat.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }

        public /* synthetic */ i(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat, a aVar) {
            this();
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
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

    public static /* synthetic */ void A1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        seriesActivitNewFlowSubCat.N1();
    }

    public static /* synthetic */ void B1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        seriesActivitNewFlowSubCat.M1();
    }

    public static /* synthetic */ List C1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        return seriesActivitNewFlowSubCat.e0;
    }

    public static /* synthetic */ String D1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        return seriesActivitNewFlowSubCat.L1();
    }

    public static /* synthetic */ void E1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        seriesActivitNewFlowSubCat.v1();
    }

    private void F1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList K1() {
        ArrayList allPasswordStatus = this.s.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.n));
        this.S = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.N.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.N;
    }

    private void M1() {
        this.n = this;
        this.s = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.n, w.L(this.n) + 1);
        this.B = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.C = this.n.getSharedPreferences("loginPrefs", 0);
        T1();
    }

    private void U1() {
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            this.I = popupWindow;
            popupWindow.setContentView(inflate);
            this.I.setWidth(-1);
            this.I.setHeight(-1);
            this.I.setFocusable(true);
            this.I.showAtLocation(inflate, 17, 0, 0);
            inflate.findViewById(a7.f.Ai).setText(getResources().getString(a7.j.I0));
            Button findViewById = inflate.findViewById(a7.f.L0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
            }
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            }
            findViewById.setOnClickListener(new f());
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new g());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V1(android.app.Activity r17) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.V1(android.app.Activity):void");
    }

    private void v1() {
    }

    public static /* synthetic */ Context w1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        return seriesActivitNewFlowSubCat.n;
    }

    public static /* synthetic */ PopupWindow x1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        return seriesActivitNewFlowSubCat.I;
    }

    public static /* synthetic */ SharedPreferences y1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat) {
        return seriesActivitNewFlowSubCat.z;
    }

    public static /* synthetic */ SharedPreferences z1(SeriesActivitNewFlowSubCat seriesActivitNewFlowSubCat, SharedPreferences sharedPreferences) {
        seriesActivitNewFlowSubCat.z = sharedPreferences;
        return sharedPreferences;
    }

    public Boolean G1() {
        List list = this.e0;
        if (list == null || list.size() <= 0) {
            return Boolean.FALSE;
        }
        if (this.Z == null) {
            this.Z = new SeriesRecentWatchDatabase(this.n);
        }
        for (int i2 = 0; i2 < this.e0.size(); i2++) {
            this.Z.deleteSeriesRecentwatch(((GetEpisdoeDetailsCallback) this.e0.get(i2)).getId());
        }
        return Boolean.TRUE;
    }

    public void H1() {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            if (this.g != null && (arrayList2 = this.E) != null && arrayList2.size() != 0) {
                V v = new V(this.E, this.n);
                this.D = v;
                this.g.setAdapter(v);
                this.D.w();
                w.Q0(this.n, getResources().getString(a7.j.q8));
                this.h.setVisibility(4);
            }
            if (this.h != null && (arrayList = this.E) != null && arrayList.size() == 0) {
                RecyclerView recyclerView = this.g;
                if (recyclerView != null) {
                    recyclerView.setAdapter(this.D);
                }
                this.h.setText(getResources().getString(a7.j.B4));
                this.h.setVisibility(0);
            }
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public String I1(String str) {
        try {
            this.S = new ArrayList();
            this.P = new ArrayList();
            this.Q = new ArrayList();
            this.R = new ArrayList();
            this.R = this.s.getAllSeriesStreamsWithCategoryId(str);
            return "get_all";
        } catch (Exception unused) {
            return "get_all";
        }
    }

    public String J1() {
        return "get_fav";
    }

    public final String L1() {
        this.N = new ArrayList();
        new ArrayList();
        this.e0 = new ArrayList();
        SeriesRecentWatchDatabase seriesRecentWatchDatabase = new SeriesRecentWatchDatabase(this.n);
        this.Z = seriesRecentWatchDatabase;
        ArrayList allSeriesRecentWatch = seriesRecentWatchDatabase.getAllSeriesRecentWatch("getalldata");
        if (this.s == null) {
            this.s = new LiveStreamDBHandler(this.n);
        }
        if (this.s.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.n)) <= 0) {
            this.e0 = allSeriesRecentWatch;
            return "get_recent_watch";
        }
        this.N = K1();
        Iterator it = allSeriesRecentWatch.iterator();
        while (it.hasNext()) {
            GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = (GetEpisdoeDetailsCallback) it.next();
            Iterator it2 = this.N.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.e0.add(getEpisdoeDetailsCallback);
                    break;
                }
                if (getEpisdoeDetailsCallback.getCategoryId().equals((String) it2.next())) {
                    break;
                }
            }
        }
        return "get_recent_watch";
    }

    public final void N1() {
        this.n = this;
        this.s = new LiveStreamDBHandler(this.n);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.n);
        this.B = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.C = this.n.getSharedPreferences("loginPrefs", 0);
        T1();
    }

    public final void O1(ArrayList arrayList) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.n == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.J = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setHasFixedSize(true);
        b();
        n0 n0Var = new n0(arrayList, this.n, this.s);
        this.y = n0Var;
        this.g.setAdapter(n0Var);
    }

    public void P1(boolean z) {
        RecyclerView recyclerView;
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (z) {
            this.h.setVisibility(8);
            recyclerView = this.g;
        } else {
            this.g.setVisibility(8);
            this.h.setText(getResources().getString(a7.j.i4));
            recyclerView = this.h;
        }
        recyclerView.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009e A[PHI: r0
      0x009e: PHI (r0v42 android.widget.ProgressBar) = (r0v33 android.widget.ProgressBar), (r0v115 android.widget.ProgressBar) binds: [B:29:0x01a3, B:10:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q1() {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.Q1():void");
    }

    public final void R1() {
        SharedPreferences sharedPreferences = getSharedPreferences("listgridview", 0);
        this.z = sharedPreferences;
        this.A = sharedPreferences.edit();
        int i2 = this.z.getInt("series", 0);
        m7.a.O = i2;
        if (i2 == 1) {
            N1();
        } else {
            M1();
        }
    }

    public final void S1(ArrayList arrayList) {
        O1(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[Catch: NullPointerException | Exception -> 0x006f, TryCatch #0 {NullPointerException | Exception -> 0x006f, blocks: (B:2:0x0000, B:4:0x0004, B:12:0x0034, B:13:0x0047, B:14:0x0058, B:15:0x001b, B:18:0x0025, B:21:0x0068, B:23:0x006c), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T1() {
        /*
            r4 = this;
            android.content.Context r0 = r4.n     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L68
            com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = new com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler     // Catch: java.lang.Throwable -> L6f
            android.content.Context r1 = r4.n     // Catch: java.lang.Throwable -> L6f
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r4.v     // Catch: java.lang.Throwable -> L6f
            int r1 = r0.hashCode()     // Catch: java.lang.Throwable -> L6f
            r2 = 1444(0x5a4, float:2.023E-42)
            r3 = 1
            if (r1 == r2) goto L25
            r2 = 1447(0x5a7, float:2.028E-42)
            if (r1 == r2) goto L1b
            goto L2f
        L1b:
            java.lang.String r1 = "-4"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L25:
            java.lang.String r1 = "-1"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L2f
            r0 = 0
            goto L30
        L2f:
            r0 = -1
        L30:
            if (r0 == 0) goto L58
            if (r0 == r3) goto L47
            com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h r0 = new com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "get_all"
            java.lang.String r3 = r4.v     // Catch: java.lang.Throwable -> L6f
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L6f
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L6f
            goto L68
        L47:
            com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h r0 = new com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "get_recent_watch"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L6f
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L6f
            goto L68
        L58:
            com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h r0 = new com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat$h     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "get_fav"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L6f
            r0.executeOnExecutor(r1, r2)     // Catch: java.lang.Throwable -> L6f
        L68:
            android.app.ProgressDialog r0 = r4.u     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L6f
            r0.dismiss()     // Catch: java.lang.Throwable -> L6f
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.T1():void");
    }

    public void a() {
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(0);
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
        j0 j0Var = this.G;
        if (j0Var != null) {
            j0Var.F0(i0);
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
        setContentView(a7.g.J0);
        getWindow().setFlags(1024, 1024);
        this.n = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.v = intent.getStringExtra("category_id");
            this.w = intent.getStringExtra("category_name");
        }
        this.S = new ArrayList();
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.G = new j0();
        this.F = new DatabaseHandler(this.n);
        this.s = new LiveStreamDBHandler(this.n);
        this.K = new Handler();
        Q1();
        this.O = this.O;
        this.m.setOnClickListener(new a());
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
        this.M = menu;
        this.L = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i3 = 0; i3 < this.d.getChildCount(); i3++) {
            if (this.d.getChildAt(i3) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i3).getLayoutParams()).a = 16;
            }
        }
        if (this.v.equalsIgnoreCase("-4")) {
            this.L = menu.getItem(2).getSubMenu().findItem(a7.f.u6).setVisible(true);
            this.L = menu.getItem(2).getSubMenu().findItem(a7.f.q6).setVisible(true);
            if (this.Z == null) {
                this.Z = new SeriesRecentWatchDatabase(this.n);
            }
            if (this.Z.getSeriesRecentwatchmCount() > 0) {
                menu.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.M;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r8) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivitNewFlowSubCat.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onResume() {
        ProgressBar progressBar;
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.n);
        w.z0(this.n);
        getWindow().setFlags(1024, 1024);
        j0 j0Var = this.G;
        if (j0Var != null && (progressBar = i0) != null) {
            j0Var.F0(progressBar);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.o = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.o.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void u1() {
        try {
            ArrayList arrayList = this.R;
            if (arrayList == null || this.g == null || arrayList.size() == 0) {
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else {
                V v = new V(this.R, this.n);
                this.D = v;
                this.g.setAdapter(v);
                w.Q0(this.n, getResources().getString(a7.j.q8));
            }
            ProgressBar progressBar = this.f;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }
}
