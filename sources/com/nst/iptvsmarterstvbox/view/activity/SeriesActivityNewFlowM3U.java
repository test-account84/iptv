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
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.X;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesActivityNewFlowM3U extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar X;
    public static int Y;
    public ArrayList A;
    public ArrayList B;
    public X C;
    public SearchView D;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public PopupWindow M;
    public Handler N;
    public MenuItem O;
    public Menu P;
    public NativeAdsManager S;
    public List U;
    public Boolean V;
    public Boolean W;
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
    public TextView n;
    public ImageView o;
    public ImageView p;
    public RelativeLayout q;
    public Button r;
    public Context s;
    public SharedPreferences t;
    public RecyclerView.o u;
    public LiveStreamDBHandler y;
    public String v = "";
    public String w = "";
    public DatabaseUpdatedStatusDBModel x = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel z = new DatabaseUpdatedStatusDBModel();
    public ArrayList E = new ArrayList();
    public int L = -1;
    public AsyncTask Q = null;
    public int R = 0;
    public ArrayList T = new ArrayList();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class b implements SearchView.m {
        public b() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            SeriesActivityNewFlowM3U.this.j.setVisibility(8);
            if (SeriesActivityNewFlowM3U.B1(SeriesActivityNewFlowM3U.this) == null || (textView = SeriesActivityNewFlowM3U.this.j) == null || textView.getVisibility() == 0) {
                return false;
            }
            SeriesActivityNewFlowM3U.B1(SeriesActivityNewFlowM3U.this).s0(str, SeriesActivityNewFlowM3U.this.j);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowM3U.C1(SeriesActivityNewFlowM3U.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public d(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setseriesActivitynewFlowSort(findViewById.getText().toString().equals(SeriesActivityNewFlowM3U.this.getResources().getString(a7.j.f7)) ? "1" : findViewById.getText().toString().equals(SeriesActivityNewFlowM3U.this.getResources().getString(a7.j.k7)) ? "2" : "0", this.d);
            SeriesActivityNewFlowM3U.D1(SeriesActivityNewFlowM3U.this, SeriesActivityNewFlowM3U.this.new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
            SeriesActivityNewFlowM3U.C1(SeriesActivityNewFlowM3U.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            w.j(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowM3U.this.onBackPressed();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this).startActivity(new Intent(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this), NewDashboardActivity.class));
        }
    }

    public class h implements NativeAdsManager.Listener {
        public h() {
        }

        public void onAdError(AdError adError) {
            Log.e("ads", "ads failed");
            SeriesActivityNewFlowM3U.w1(SeriesActivityNewFlowM3U.this);
        }

        public void onAdsLoaded() {
            Log.i("fbads", "onAdsLoaded!" + SeriesActivityNewFlowM3U.v1(SeriesActivityNewFlowM3U.this).getUniqueNativeAdCount());
            int uniqueNativeAdCount = SeriesActivityNewFlowM3U.v1(SeriesActivityNewFlowM3U.this).getUniqueNativeAdCount();
            for (int i = 0; i < uniqueNativeAdCount; i++) {
                SeriesActivityNewFlowM3U.this.E1(i, SeriesActivityNewFlowM3U.v1(SeriesActivityNewFlowM3U.this).nextNativeAd());
            }
            if (SeriesActivityNewFlowM3U.v1(SeriesActivityNewFlowM3U.this).isLoaded()) {
                Log.e("ads", "ads loaded");
                SeriesActivityNewFlowM3U.w1(SeriesActivityNewFlowM3U.this);
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this));
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this));
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n implements View.OnFocusChangeListener {
        public final View a;

        public n(View view) {
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

    public class o extends AsyncTask {
        public o() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(SeriesActivityNewFlowM3U.x1(SeriesActivityNewFlowM3U.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (!new u7.a(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this)).A().equals(m7.a.K0)) {
                if (SeriesActivityNewFlowM3U.z1(SeriesActivityNewFlowM3U.this).booleanValue()) {
                    SeriesActivityNewFlowM3U.w1(SeriesActivityNewFlowM3U.this);
                    return;
                } else if (!w.i(SeriesActivityNewFlowM3U.u1(SeriesActivityNewFlowM3U.this)).booleanValue()) {
                    SeriesActivityNewFlowM3U.A1(SeriesActivityNewFlowM3U.this);
                    return;
                }
            }
            SeriesActivityNewFlowM3U.y1(SeriesActivityNewFlowM3U.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public SeriesActivityNewFlowM3U() {
        Boolean bool = Boolean.FALSE;
        this.V = bool;
        this.W = bool;
    }

    public static /* synthetic */ void A1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        seriesActivityNewFlowM3U.M1();
    }

    public static /* synthetic */ X B1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.C;
    }

    public static /* synthetic */ PopupWindow C1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.M;
    }

    public static /* synthetic */ AsyncTask D1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U, AsyncTask asyncTask) {
        seriesActivityNewFlowM3U.Q = asyncTask;
        return asyncTask;
    }

    private void F1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList G1() {
        ArrayList allPasswordStatus = this.y.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.s));
        this.F = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.E.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.E;
    }

    private ArrayList H1(ArrayList arrayList, ArrayList arrayList2) {
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
                        ArrayList arrayList3 = this.G;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.G;
    }

    private void I1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x015d A[Catch: NullPointerException | Exception -> 0x021a, TryCatch #0 {NullPointerException | Exception -> 0x021a, blocks: (B:3:0x0007, B:5:0x001a, B:8:0x0095, B:9:0x00ae, B:11:0x00c4, B:13:0x00c8, B:15:0x00d6, B:16:0x00dc, B:18:0x00e0, B:21:0x00e8, B:23:0x00f0, B:25:0x00f4, B:29:0x00fc, B:31:0x010e, B:33:0x0120, B:35:0x0134, B:36:0x01ab, B:38:0x01b0, B:40:0x015d, B:42:0x0181, B:43:0x0183, B:45:0x01b4, B:47:0x01b8, B:49:0x01be, B:50:0x01c2, B:53:0x01c7, B:55:0x01cf, B:59:0x00d9), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181 A[Catch: NullPointerException | Exception -> 0x021a, TryCatch #0 {NullPointerException | Exception -> 0x021a, blocks: (B:3:0x0007, B:5:0x001a, B:8:0x0095, B:9:0x00ae, B:11:0x00c4, B:13:0x00c8, B:15:0x00d6, B:16:0x00dc, B:18:0x00e0, B:21:0x00e8, B:23:0x00f0, B:25:0x00f4, B:29:0x00fc, B:31:0x010e, B:33:0x0120, B:35:0x0134, B:36:0x01ab, B:38:0x01b0, B:40:0x015d, B:42:0x0181, B:43:0x0183, B:45:0x01b4, B:47:0x01b8, B:49:0x01be, B:50:0x01c2, B:53:0x01c7, B:55:0x01cf, B:59:0x00d9), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean K1() {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesActivityNewFlowM3U.K1():boolean");
    }

    private void L1() {
        ProgressBar progressBar;
        int i2 = 8;
        if (this.I == null || this.R == 0) {
            ProgressBar progressBar2 = this.d;
            if (progressBar2 == null) {
                return;
            }
            progressBar2.setVisibility(8);
            progressBar = this.q;
            i2 = 0;
        } else {
            this.C = new X(this.U, this.s);
            this.i.setItemAnimator(new androidx.recyclerview.widget.c());
            this.i.setAdapter(this.C);
            progressBar = this.d;
            if (progressBar == null) {
                return;
            }
        }
        progressBar.setVisibility(i2);
    }

    private void N1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.M = popupWindow;
            popupWindow.setContentView(inflate);
            char c2 = 65535;
            this.M.setWidth(-1);
            this.M.setHeight(-1);
            this.M.setFocusable(true);
            this.M.showAtLocation(inflate, 17, 0, 0);
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
            findViewById4.setOnFocusChangeListener(new n(findViewById4));
            findViewById5.setOnFocusChangeListener(new n(findViewById5));
            findViewById6.setOnFocusChangeListener(new n(findViewById6));
            findViewById7.setOnFocusChangeListener(new n(findViewById7));
            findViewById8.setOnFocusChangeListener(new n(findViewById8));
            findViewById9.setOnFocusChangeListener(new n(findViewById9));
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
            findViewById2.setOnClickListener(new c());
            findViewById.setOnClickListener(new d(findViewById3, inflate, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.s;
    }

    public static /* synthetic */ NativeAdsManager v1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.S;
    }

    public static /* synthetic */ void w1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        seriesActivityNewFlowM3U.J1();
    }

    public static /* synthetic */ boolean x1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.K1();
    }

    public static /* synthetic */ void y1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        seriesActivityNewFlowM3U.L1();
    }

    public static /* synthetic */ Boolean z1(SeriesActivityNewFlowM3U seriesActivityNewFlowM3U) {
        return seriesActivityNewFlowM3U.V;
    }

    public void E1(int i2, NativeAd nativeAd) {
        if (nativeAd == null) {
            return;
        }
        this.T.add(i2, nativeAd);
    }

    public final void J1() {
        if (this.T.size() <= 0) {
            L1();
            return;
        }
        List list = this.U;
        if (list != null && list.size() > 0) {
            Iterator it = this.U.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof NativeAd) {
                    Log.e("ads", "ads already exists");
                    L1();
                    return;
                }
            }
            int size = this.U.size() / this.T.size();
            Iterator it2 = this.T.iterator();
            int i2 = size;
            while (it2.hasNext()) {
                try {
                    this.U.add(i2, (NativeAd) it2.next());
                    i2 += size;
                } catch (Exception unused) {
                }
            }
        }
        L1();
    }

    public final void M1() {
        Log.e("ads", "loadNativeAds");
        this.V = Boolean.TRUE;
        List list = this.U;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            Y = this.U.size() / 10;
        } catch (Exception unused) {
            Y = 0;
        }
        NativeAdsManager nativeAdsManager = new NativeAdsManager(this.s, "269613774129228_336799674077304", Y);
        this.S = nativeAdsManager;
        nativeAdsManager.setListener(new h());
        if (Y > 0) {
            this.S.loadAds();
        } else {
            L1();
        }
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
        X x = this.C;
        if (x != null && (progressBar = X) != null) {
            x.A0(progressBar);
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (view.getId() == a7.f.M4) {
            this.Q = new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        I1();
        setContentView(a7.g.D1);
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
        this.n = findViewById(a7.f.Jl);
        this.o = findViewById(a7.f.Xa);
        this.p = findViewById(a7.f.F4);
        this.q = findViewById(a7.f.Oe);
        this.r = findViewById(a7.f.s0);
        AppBarLayout appBarLayout = this.f;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(getResources().getString(a7.j.N6));
        }
        F1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        this.s = this;
        Handler handler = new Handler();
        this.N = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.o.setOnClickListener(new e());
        this.p.setOnClickListener(new f());
        this.y = new LiveStreamDBHandler(this.s);
        this.i.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.u = gridLayoutManager;
        this.i.setLayoutManager(gridLayoutManager);
        this.i.setVisibility(0);
        this.Q = new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.l.setOnClickListener(new g());
        this.k.setVisibility(8);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.e.x(a7.h.r);
        this.P = menu;
        this.O = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
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

    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.Q;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        this.Q.cancel(true);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.P;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.O = menuItem;
        this.e.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.s) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new j()).g(getResources().getString(a7.j.d4), new i()).n();
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.s.getResources().getString(a7.j.u0));
            aVar.f(this.s.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.s.getResources().getString(a7.j.S8), new k());
            aVar.g(this.s.getResources().getString(a7.j.d4), new l());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.s.getResources().getString(a7.j.u0));
            aVar2.f(this.s.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.s.getResources().getString(a7.j.S8), new m());
            aVar2.g(this.s.getResources().getString(a7.j.d4), new a());
            aVar2.n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.D = b2;
            b2.setQueryHint(getResources().getString(a7.j.F6));
            this.D.setIconifiedByDefault(false);
            this.D.setOnQueryTextListener(new b());
        }
        if (itemId == a7.f.mb) {
            N1(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        I1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.s);
        w.z0(this.s);
        getWindow().setFlags(1024, 1024);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        X x = this.C;
        if (x != null) {
            x.A0(X);
            this.C.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.t = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.t.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        I1();
    }
}
