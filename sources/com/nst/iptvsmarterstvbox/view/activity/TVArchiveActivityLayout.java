package com.nst.iptvsmarterstvbox.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
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
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import m7.w;
import q7.g0;
import q7.v;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TVArchiveActivityLayout extends androidx.appcompat.app.b implements View.OnClickListener {
    public DatabaseHandler B;
    public v C;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public ArrayList I;
    public ArrayList J;
    public SharedPreferences K;
    public SharedPreferences.Editor L;
    public SharedPreferences M;
    public SharedPreferences.Editor N;
    public PopupWindow O;
    public g0 P;
    public GridLayoutManager Q;
    public Toolbar d;
    public AppBarLayout e;
    public ProgressBar f;
    public RecyclerView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public Context o;
    public SharedPreferences p;
    public LiveStreamDBHandler t;
    public SearchView v;
    public RecyclerView.o y;
    public SharedPreferences z;
    public String q = "";
    public String r = "";
    public DatabaseUpdatedStatusDBModel s = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel u = new DatabaseUpdatedStatusDBModel();
    public String w = "";
    public String x = "";
    public ArrayList A = new ArrayList();
    public ArrayList D = new ArrayList();
    public Thread R = null;

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
            TVArchiveActivityLayout.w1(TVArchiveActivityLayout.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;

        public c(RadioGroup radioGroup, View view) {
            this.a = radioGroup;
            this.c = view;
        }

        public void onClick(View view) {
            SharedPreferences.Editor x1;
            String str;
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            if (findViewById.getText().toString().equals(TVArchiveActivityLayout.this.getResources().getString(a7.j.i7))) {
                x1 = TVArchiveActivityLayout.x1(TVArchiveActivityLayout.this);
                str = "1";
            } else if (findViewById.getText().toString().equals(TVArchiveActivityLayout.this.getResources().getString(a7.j.f7))) {
                x1 = TVArchiveActivityLayout.x1(TVArchiveActivityLayout.this);
                str = "2";
            } else if (findViewById.getText().toString().equals(TVArchiveActivityLayout.this.getResources().getString(a7.j.k7))) {
                x1 = TVArchiveActivityLayout.x1(TVArchiveActivityLayout.this);
                str = "3";
            } else {
                x1 = TVArchiveActivityLayout.x1(TVArchiveActivityLayout.this);
                str = "0";
            }
            x1.putString("sort", str);
            TVArchiveActivityLayout.x1(TVArchiveActivityLayout.this).apply();
            TVArchiveActivityLayout tVArchiveActivityLayout = TVArchiveActivityLayout.this;
            TVArchiveActivityLayout.z1(tVArchiveActivityLayout, tVArchiveActivityLayout.getSharedPreferences("listgridview", 0));
            int i = TVArchiveActivityLayout.y1(TVArchiveActivityLayout.this).getInt("livestream", 0);
            m7.a.M = i;
            if (i == 1) {
                TVArchiveActivityLayout.A1(TVArchiveActivityLayout.this);
            } else {
                TVArchiveActivityLayout.B1(TVArchiveActivityLayout.this);
            }
            TVArchiveActivityLayout.w1(TVArchiveActivityLayout.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            w.j(TVArchiveActivityLayout.u1(TVArchiveActivityLayout.this));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            TVArchiveActivityLayout.this.onBackPressed();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(TVArchiveActivityLayout.u1(TVArchiveActivityLayout.this));
                String A = w.A(date);
                TextView textView = TVArchiveActivityLayout.this.l;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = TVArchiveActivityLayout.this.k;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(TVArchiveActivityLayout.u1(TVArchiveActivityLayout.this));
        }
    }

    public class i implements SearchView.m {
        public i() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            TVArchiveActivityLayout.this.i.setVisibility(8);
            if (TVArchiveActivityLayout.v1(TVArchiveActivityLayout.this) == null || (textView = TVArchiveActivityLayout.this.h) == null || textView.getVisibility() == 0) {
                return false;
            }
            TVArchiveActivityLayout.v1(TVArchiveActivityLayout.this).s0(str, TVArchiveActivityLayout.this.i);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(TVArchiveActivityLayout.u1(TVArchiveActivityLayout.this));
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

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TVArchiveActivityLayout.this.D1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static /* synthetic */ void A1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        tVArchiveActivityLayout.J1();
    }

    public static /* synthetic */ void B1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        tVArchiveActivityLayout.K1();
    }

    private void C1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList F1() {
        ArrayList allPasswordStatus = this.t.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.o));
        this.E = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.D.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.D;
    }

    private ArrayList G1(ArrayList arrayList, ArrayList arrayList2) {
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
                        ArrayList arrayList3 = this.F;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamsDBModel);
                        }
                    }
                }
            }
        }
        return this.F;
    }

    private void I1() {
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.ec);
        this.g = findViewById(a7.f.ub);
        this.h = findViewById(a7.f.sk);
        this.i = findViewById(a7.f.wk);
        this.j = findViewById(a7.f.lm);
        this.k = findViewById(a7.f.E2);
        this.l = findViewById(a7.f.gh);
        this.m = findViewById(a7.f.Xa);
        this.n = findViewById(a7.f.F4);
    }

    private void J1() {
        this.o = this;
        this.t = new LiveStreamDBHandler(this.o);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.o == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, w.L(this.o) + 1);
        this.y = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.z = this.o.getSharedPreferences("loginPrefs", 0);
        M1();
    }

    private void K1() {
        this.o = this;
        this.t = new LiveStreamDBHandler(this.o);
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || this.o == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
        this.y = linearLayoutManager;
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.z = this.o.getSharedPreferences("loginPrefs", 0);
        M1();
    }

    private void M1() {
        try {
            if (this.o != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.o);
                this.E = new ArrayList();
                this.F = new ArrayList();
                this.G = new ArrayList();
                this.H = new ArrayList();
                this.I = new ArrayList();
                this.J = new ArrayList();
                ArrayList allLiveStreamsArchive = liveStreamDBHandler.getAllLiveStreamsArchive(this.w);
                Log.e("channelAvailable size", " >>>>>>>> " + allLiveStreamsArchive.size());
                Log.e("channelAvailable", " >>>>>>>> " + allLiveStreamsArchive.toString());
                if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.o)) > 0) {
                    ArrayList F1 = F1();
                    this.D = F1;
                    if (F1 != null) {
                        this.G = G1(allLiveStreamsArchive, F1);
                    }
                    this.H = this.G;
                } else {
                    this.H = allLiveStreamsArchive;
                }
                if (this.w.equals("-1")) {
                    b();
                    return;
                }
                ArrayList arrayList = this.H;
                if (arrayList != null && this.g != null && arrayList.size() != 0) {
                    b();
                    L1(this.H);
                    return;
                }
                b();
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void N1(Activity activity) {
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
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            String string = this.M.getString("sort", "");
            switch (string.hashCode()) {
                case 49:
                    if (string.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (string.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                findViewById5.setChecked(true);
            } else if (c2 == 1) {
                findViewById6.setChecked(true);
            } else if (c2 != 2) {
                findViewById4.setChecked(true);
            } else {
                findViewById7.setChecked(true);
            }
            findViewById2.setOnClickListener(new b());
            findViewById.setOnClickListener(new c(findViewById3, inflate));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        return tVArchiveActivityLayout.o;
    }

    public static /* synthetic */ v v1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        return tVArchiveActivityLayout.C;
    }

    public static /* synthetic */ PopupWindow w1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        return tVArchiveActivityLayout.O;
    }

    public static /* synthetic */ SharedPreferences.Editor x1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        return tVArchiveActivityLayout.N;
    }

    public static /* synthetic */ SharedPreferences y1(TVArchiveActivityLayout tVArchiveActivityLayout) {
        return tVArchiveActivityLayout.K;
    }

    public static /* synthetic */ SharedPreferences z1(TVArchiveActivityLayout tVArchiveActivityLayout, SharedPreferences sharedPreferences) {
        tVArchiveActivityLayout.K = sharedPreferences;
        return sharedPreferences;
    }

    public void D1() {
        runOnUiThread(new f());
    }

    public void E1() {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.A.clear();
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.C);
        }
        if (this.o != null) {
            DatabaseHandler databaseHandler = new DatabaseHandler(this.o);
            this.B = databaseHandler;
            Iterator it = databaseHandler.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.o)).iterator();
            while (it.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                this.A.add(new LiveStreamDBHandler(this.o).getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), ""));
            }
            b();
            if (this.g != null && (arrayList2 = this.A) != null && arrayList2.size() != 0) {
                v vVar = new v(this.A, this.o);
                this.C = vVar;
                this.g.setAdapter(vVar);
                this.C.w();
                this.h.setVisibility(4);
            }
            if (this.h == null || (arrayList = this.A) == null || arrayList.size() != 0) {
                return;
            }
            RecyclerView recyclerView2 = this.g;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.C);
            }
            this.h.setText(getResources().getString(a7.j.k4));
            this.h.setVisibility(0);
        }
    }

    public void H1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void L1(ArrayList arrayList) {
        this.P = new g0(arrayList, this.o);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        this.Q = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setItemAnimator(new androidx.recyclerview.widget.c());
        this.g.setAdapter(this.P);
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
        this.g.setClickable(true);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        this.o = this;
        H1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.m1);
        I1();
        overridePendingTransition(a7.b.f, a7.b.d);
        AppBarLayout appBarLayout = this.e;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        SharedPreferences sharedPreferences = getSharedPreferences("sort", 0);
        this.M = sharedPreferences;
        this.N = sharedPreferences.edit();
        if (this.M.getString("sort", "").equals("")) {
            this.N.putString("sort", "0");
            this.N.apply();
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.w = intent.getStringExtra("category_id");
            this.x = intent.getStringExtra("category_name");
        }
        this.t = new LiveStreamDBHandler(this.o);
        SharedPreferences sharedPreferences2 = getSharedPreferences("listgridview", 0);
        this.K = sharedPreferences2;
        m7.a.M = sharedPreferences2.getInt("livestream", 0);
        this.m.setOnClickListener(new d());
        this.n.setOnClickListener(new e());
        if (m7.a.M == 1) {
            J1();
        } else {
            K1();
        }
        if (this.w.equals("-1")) {
            E1();
        }
        C1();
        r1(findViewById(a7.f.kh));
        this.o = this;
        Thread thread = this.R;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new m());
            this.R = thread2;
            thread2.start();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(a7.h.s);
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

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.o) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new h()).g(getResources().getString(a7.j.d4), new g()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.v = b2;
            b2.setQueryHint(getResources().getString(a7.j.A6));
            this.v.setIconifiedByDefault(false);
            this.v.setOnQueryTextListener(new i());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar.f(this.o.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.o.getResources().getString(a7.j.S8), new j());
            aVar.g(this.o.getResources().getString(a7.j.d4), new k());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar2.f(this.o.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.o.getResources().getString(a7.j.S8), new l());
            aVar2.g(this.o.getResources().getString(a7.j.d4), new a());
            aVar2.n();
        }
        if (itemId == a7.f.q6) {
            this.L.putInt("livestream", 1);
            this.L.commit();
            J1();
        }
        if (itemId == a7.f.u6) {
            this.L.putInt("livestream", 0);
            this.L.commit();
            K1();
        }
        if (itemId == a7.f.mb) {
            N1(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.R;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.R.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        H1();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.R;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new m());
            this.R = thread2;
            thread2.start();
        }
        w.m(this.o);
        w.z0(this.o);
        getWindow().setFlags(1024, 1024);
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
        H1();
    }
}
