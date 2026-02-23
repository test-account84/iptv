package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.NativeAd;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.X;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesActivtyNewFlow extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar N;
    public ArrayList A;
    public ArrayList B;
    public ArrayList C;
    public ArrayList D;
    public ArrayList E;
    public PopupWindow G;
    public SeriesRecentWatchDatabase I;
    public List K;
    public Boolean L;
    public Boolean M;
    public ProgressBar d;
    public Toolbar e;
    public AppBarLayout f;
    public LinearLayout g;
    public ProgressBar h;
    public RecyclerView i;
    public TextView j;
    public FrameLayout k;
    public TextView l;
    public RelativeLayout m;
    public ImageView n;
    public Context o;
    public SharedPreferences p;
    public RecyclerView.o q;
    public X u;
    public SearchView v;
    public Handler w;
    public MenuItem x;
    public Menu y;
    public LiveStreamDBHandler z;
    public String r = "";
    public String s = "";
    public DatabaseUpdatedStatusDBModel t = new DatabaseUpdatedStatusDBModel();
    public int F = -1;
    public ArrayList H = new ArrayList();
    public ArrayList J = new ArrayList();

    public class a implements SearchView.m {
        public a() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            m7.a.k0 = str.length() > 0 ? Boolean.FALSE : Boolean.TRUE;
            SeriesActivtyNewFlow.this.j.setVisibility(8);
            if (SeriesActivtyNewFlow.z1(SeriesActivtyNewFlow.this) == null || (textView = SeriesActivtyNewFlow.this.j) == null || textView.getVisibility() == 0) {
                return false;
            }
            SeriesActivtyNewFlow.z1(SeriesActivtyNewFlow.this).s0(str, SeriesActivtyNewFlow.this.j);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            SeriesActivtyNewFlow.A1(SeriesActivtyNewFlow.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public c(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setseriesActivitynewFlowSort(findViewById.getText().toString().equals(SeriesActivtyNewFlow.this.getResources().getString(a7.j.f7)) ? "1" : findViewById.getText().toString().equals(SeriesActivtyNewFlow.this.getResources().getString(a7.j.k7)) ? "2" : "0", this.d);
            SeriesActivtyNewFlow.A1(SeriesActivtyNewFlow.this).dismiss();
            SeriesActivtyNewFlow.this.new m().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this).startActivity(new Intent(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this), NewDashboardActivity.class));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            w.j(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this));
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
            w.n0(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this));
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this));
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

    public class l implements View.OnFocusChangeListener {
        public final View a;

        public l(View view) {
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

    public class m extends AsyncTask {
        public m() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return SeriesActivtyNewFlow.w1(SeriesActivtyNewFlow.this);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (!new u7.a(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this)).A().equals(m7.a.K0)) {
                if (SeriesActivtyNewFlow.y1(SeriesActivtyNewFlow.this).booleanValue()) {
                    SeriesActivtyNewFlow.v1(SeriesActivtyNewFlow.this);
                    return;
                }
                w.i(SeriesActivtyNewFlow.u1(SeriesActivtyNewFlow.this)).booleanValue();
            }
            SeriesActivtyNewFlow.x1(SeriesActivtyNewFlow.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public SeriesActivtyNewFlow() {
        Boolean bool = Boolean.FALSE;
        this.L = bool;
        this.M = bool;
    }

    public static /* synthetic */ PopupWindow A1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        return seriesActivtyNewFlow.G;
    }

    private void B1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList C1() {
        ArrayList allPasswordStatus = this.z.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.o));
        this.A = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.H.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.H;
    }

    private ArrayList D1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = this.B;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.B;
    }

    private void E1() {
        if (this.J.size() <= 0) {
            G1();
            return;
        }
        List list = this.K;
        if (list != null && list.size() > 0) {
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof NativeAd) {
                    Log.e("ads", "ads already exists");
                    G1();
                    return;
                }
            }
            int size = this.K.size() / this.J.size();
            Iterator it2 = this.J.iterator();
            int i2 = size;
            while (it2.hasNext()) {
                try {
                    this.K.add(i2, (NativeAd) it2.next());
                    i2 += size;
                } catch (Exception unused) {
                }
            }
        }
        G1();
    }

    private void G1() {
        if (this.E != null) {
            this.u = new X(this.K, this.o);
            this.i.setItemAnimator(new androidx.recyclerview.widget.c());
            this.i.setAdapter(this.u);
        }
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void H1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.G = popupWindow;
            popupWindow.setContentView(inflate);
            char c2 = 65535;
            this.G.setWidth(-1);
            this.G.setHeight(-1);
            this.G.setFocusable(true);
            this.G.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            findViewById5.setVisibility(8);
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            RadioButton findViewById8 = inflate.findViewById(a7.f.gd);
            findViewById8.setVisibility(8);
            RadioButton findViewById9 = inflate.findViewById(a7.f.hd);
            findViewById9.setVisibility(8);
            findViewById4.setOnFocusChangeListener(new l(findViewById4));
            findViewById5.setOnFocusChangeListener(new l(findViewById5));
            findViewById6.setOnFocusChangeListener(new l(findViewById6));
            findViewById7.setOnFocusChangeListener(new l(findViewById7));
            findViewById8.setOnFocusChangeListener(new l(findViewById8));
            findViewById9.setOnFocusChangeListener(new l(findViewById9));
            String str = SharepreferenceDBHandler.getseriesActivitynewFlowSort(activity);
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals("2")) {
                    c2 = 1;
                }
            } else if (str.equals("1")) {
                c2 = 0;
            }
            if (c2 == 0) {
                findViewById6.setChecked(true);
            } else if (c2 != 1) {
                findViewById4.setChecked(true);
            } else {
                findViewById7.setChecked(true);
            }
            findViewById2.setOnClickListener(new b());
            findViewById.setOnClickListener(new c(findViewById3, inflate, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        return seriesActivtyNewFlow.o;
    }

    public static /* synthetic */ void v1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        seriesActivtyNewFlow.E1();
    }

    public static /* synthetic */ Boolean w1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        return seriesActivtyNewFlow.F1();
    }

    public static /* synthetic */ void x1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        seriesActivtyNewFlow.G1();
    }

    public static /* synthetic */ Boolean y1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        return seriesActivtyNewFlow.L;
    }

    public static /* synthetic */ X z1(SeriesActivtyNewFlow seriesActivtyNewFlow) {
        return seriesActivtyNewFlow.u;
    }

    public final Boolean F1() {
        try {
            if (this.o != null) {
                this.B = new ArrayList();
                this.C = new ArrayList();
                this.K = new ArrayList();
                this.i.setVisibility(0);
                this.z = new LiveStreamDBHandler(this.o);
                this.A = new ArrayList();
                this.D = new ArrayList();
                this.E = new ArrayList();
                this.E = this.z.getAllSeriesCategoriesMain();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel4 = new LiveStreamCategoryIdDBModel();
                liveStreamCategoryIdDBModel.setLiveStreamCategoryID("0");
                liveStreamCategoryIdDBModel.setLiveStreamCategoryName(getResources().getString(a7.j.x));
                liveStreamCategoryIdDBModel2.setLiveStreamCategoryID("-1");
                liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(getResources().getString(a7.j.b2));
                this.F = this.z.getUncatCountSeries("-5");
                this.I = new SeriesRecentWatchDatabase(this.o);
                int i2 = this.F;
                if (i2 != 0 && i2 > 0) {
                    liveStreamCategoryIdDBModel3.setLiveStreamCategoryID("-5");
                    liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(getResources().getString(a7.j.b8));
                    ArrayList arrayList = this.E;
                    arrayList.add(arrayList.size(), liveStreamCategoryIdDBModel3);
                }
                liveStreamCategoryIdDBModel4.setLiveStreamCategoryID("-4");
                liveStreamCategoryIdDBModel4.setLiveStreamCategoryName(getResources().getString(a7.j.R5));
                if (this.z.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.o)) > 0 && this.E != null) {
                    ArrayList C1 = C1();
                    this.H = C1;
                    ArrayList D1 = D1(this.E, C1);
                    this.C = D1;
                    this.E = D1;
                }
                this.E.add(0, liveStreamCategoryIdDBModel);
                this.E.add(1, liveStreamCategoryIdDBModel2);
                liveStreamCategoryIdDBModel4.setLiveStreamCategoryID("-4");
                liveStreamCategoryIdDBModel4.setLiveStreamCategoryName(getResources().getString(a7.j.R5));
                this.E.add(2, liveStreamCategoryIdDBModel4);
                if (this.E != null) {
                    for (int i3 = 0; i3 < this.E.size(); i3++) {
                        this.K.add(new q7.w(((LiveStreamCategoryIdDBModel) this.E.get(i3)).getLiveStreamCategoryName(), ((LiveStreamCategoryIdDBModel) this.E.get(i3)).getLiveStreamCategoryID(), ((LiveStreamCategoryIdDBModel) this.E.get(i3)).getId(), ((LiveStreamCategoryIdDBModel) this.E.get(i3)).getLiveStreamCounter(), ((LiveStreamCategoryIdDBModel) this.E.get(i3)).getParentId()));
                    }
                }
            }
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        } catch (NullPointerException unused2) {
            return Boolean.FALSE;
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
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        RecyclerView recyclerView = this.i;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
        }
        X x = this.u;
        if (x != null && (progressBar = N) != null) {
            x.A0(progressBar);
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (view.getId() == a7.f.M4) {
            new m().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.K0);
        this.d = findViewById(a7.f.ec);
        this.e = findViewById(a7.f.kh);
        this.f = findViewById(a7.f.W);
        this.g = findViewById(a7.f.cb);
        this.h = findViewById(a7.f.oc);
        this.i = findViewById(a7.f.ub);
        this.j = findViewById(a7.f.Q2);
        this.k = findViewById(a7.f.Q3);
        this.l = findViewById(a7.f.j4);
        this.m = findViewById(a7.f.Af);
        this.n = findViewById(a7.f.Xa);
        AppBarLayout appBarLayout = this.f;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        m7.a.k0 = Boolean.FALSE;
        B1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        this.o = this;
        Handler handler = new Handler();
        this.w = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.i.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.q = gridLayoutManager;
        this.i.setLayoutManager(gridLayoutManager);
        this.i.setVisibility(0);
        new m().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.l.setOnClickListener(new d());
        this.k.setVisibility(8);
        this.n.setOnClickListener(new e());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.e.x(a7.h.r);
        this.y = menu;
        this.x = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            if (this.e.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.e.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.y;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.x = menuItem;
        this.e.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.o) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new g()).g(getResources().getString(a7.j.d4), new f()).n();
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar.f(this.o.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.o.getResources().getString(a7.j.S8), new h());
            aVar.g(this.o.getResources().getString(a7.j.d4), new i());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar2.f(this.o.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.o.getResources().getString(a7.j.S8), new j());
            aVar2.g(this.o.getResources().getString(a7.j.d4), new k());
            aVar2.n();
        }
        if (itemId != a7.f.g) {
            if (itemId == a7.f.mb) {
                H1(this);
                b();
            }
            return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
        }
        SearchView b2 = P.w.b(menuItem);
        this.v = b2;
        b2.setQueryHint(getResources().getString(a7.j.F6));
        this.v.setIconifiedByDefault(false);
        this.v.setOnQueryTextListener(new a());
        return true;
    }

    public void onResume() {
        ProgressBar progressBar;
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.o);
        w.z0(this.o);
        getWindow().setFlags(1024, 1024);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        X x = this.u;
        if (x != null && (progressBar = N) != null) {
            x.A0(progressBar);
            this.u.w();
        }
        X x2 = this.u;
        if (x2 != null) {
            x2.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.p.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.o != null) {
            b();
        }
    }
}
