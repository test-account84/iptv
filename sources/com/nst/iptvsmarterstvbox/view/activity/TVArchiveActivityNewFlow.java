package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.squareup.picasso.t;
import d.a;
import java.util.ArrayList;
import java.util.List;
import m7.w;
import q7.e0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TVArchiveActivityNewFlow extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar Z;
    public LiveStreamDBHandler B;
    public ArrayList C;
    public ArrayList D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public SharedPreferences M;
    public SharedPreferences.Editor N;
    public SearchView P;
    public Handler Q;
    public MenuItem R;
    public Menu S;
    public List V;
    public Boolean W;
    public Boolean X;
    public ImageView Y;
    public ProgressBar d;
    public ViewPager e;
    public Toolbar f;
    public AppBarLayout g;
    public ProgressBar h;
    public RecyclerView i;
    public TextView j;
    public FrameLayout k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public Context q;
    public SharedPreferences r;
    public GridLayoutManager s;
    public e0 t;
    public boolean u = false;
    public int v = -1;
    public boolean w = false;
    public int x = 1;
    public int y = 0;
    public int z = 20;
    public ArrayList A = new ArrayList();
    public String I = "";
    public String J = "";
    public DatabaseUpdatedStatusDBModel K = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel L = new DatabaseUpdatedStatusDBModel();
    public ArrayList O = new ArrayList();
    public AsyncTask T = null;
    public ArrayList U = new ArrayList();

    public class a implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public a(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public b(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            w.j(TVArchiveActivityNewFlow.u1(TVArchiveActivityNewFlow.this));
        }
    }

    public class d extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public LinearLayout e;
        public LinearLayout f;
        public RadioGroup g;
        public final /* synthetic */ Activity h;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = d.b(d.this);
                        }
                    } else {
                        b = d.a(d.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = d.b(d.this);
                        }
                    } else {
                        b = d.a(d.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, Activity activity2) {
            super(activity);
            this.h = activity2;
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(d dVar) {
            return dVar.e;
        }

        public static /* synthetic */ LinearLayout b(d dVar) {
            return dVar.f;
        }

        public void onClick(View view) {
            TVArchiveActivityNewFlow tVArchiveActivityNewFlow;
            int id = view.getId();
            if (id == a7.f.u1) {
                try {
                    RadioButton findViewById = findViewById(this.g.getCheckedRadioButtonId());
                    if (findViewById.getText().toString().equals(this.h.getResources().getString(a7.j.f7))) {
                        TVArchiveActivityNewFlow.y1(TVArchiveActivityNewFlow.this).putString("sort", "1");
                        tVArchiveActivityNewFlow = TVArchiveActivityNewFlow.this;
                    } else if (findViewById.getText().toString().equals(this.h.getResources().getString(a7.j.k7))) {
                        TVArchiveActivityNewFlow.y1(TVArchiveActivityNewFlow.this).putString("sort", "2");
                        tVArchiveActivityNewFlow = TVArchiveActivityNewFlow.this;
                    } else {
                        TVArchiveActivityNewFlow.y1(TVArchiveActivityNewFlow.this).putString("sort", "0");
                        tVArchiveActivityNewFlow = TVArchiveActivityNewFlow.this;
                    }
                    TVArchiveActivityNewFlow.y1(tVArchiveActivityNewFlow).commit();
                    TVArchiveActivityNewFlow.z1(TVArchiveActivityNewFlow.this, TVArchiveActivityNewFlow.this.new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
                    dismiss();
                } catch (Exception unused) {
                }
            } else if (id == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(a7.g.z3);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.d = findViewById(a7.f.h1);
            this.e = findViewById(a7.f.V8);
            this.f = findViewById(a7.f.Ia);
            this.g = findViewById(a7.f.Kd);
            RadioButton findViewById = findViewById(a7.f.rd);
            RadioButton findViewById2 = findViewById(a7.f.md);
            RadioButton findViewById3 = findViewById(a7.f.fd);
            RadioButton findViewById4 = findViewById(a7.f.zd);
            RadioButton findViewById5 = findViewById(a7.f.gd);
            RadioButton findViewById6 = findViewById(a7.f.hd);
            findViewById(a7.f.td).setVisibility(8);
            findViewById5.setVisibility(8);
            findViewById6.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setOnFocusChangeListener(TVArchiveActivityNewFlow.this.new n(findViewById3));
            findViewById4.setOnFocusChangeListener(TVArchiveActivityNewFlow.this.new n(findViewById4));
            String string = TVArchiveActivityNewFlow.x1(TVArchiveActivityNewFlow.this).getString("sort", "");
            string.hashCode();
            if (string.equals("1")) {
                findViewById3.setChecked(true);
            } else if (string.equals("2")) {
                findViewById4.setChecked(true);
            } else {
                findViewById.setChecked(true);
            }
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class e implements View.OnFocusChangeListener {
        public View a;

        public e(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                this.a.getTag().equals("iv_cross");
                return;
            }
            View view3 = this.a;
            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                return;
            }
            view.setBackground(TVArchiveActivityNewFlow.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            TVArchiveActivityNewFlow.this.onBackPressed();
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
            w.n0(TVArchiveActivityNewFlow.u1(TVArchiveActivityNewFlow.this));
        }
    }

    public class i implements SearchView.m {
        public i() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            m7.a.k0 = str.length() > 0 ? Boolean.FALSE : Boolean.TRUE;
            TVArchiveActivityNewFlow.this.n.setVisibility(8);
            TVArchiveActivityNewFlow tVArchiveActivityNewFlow = TVArchiveActivityNewFlow.this;
            if (tVArchiveActivityNewFlow.t == null || (textView = tVArchiveActivityNewFlow.m) == null || textView.getVisibility() == 0) {
                return false;
            }
            TVArchiveActivityNewFlow tVArchiveActivityNewFlow2 = TVArchiveActivityNewFlow.this;
            tVArchiveActivityNewFlow2.t.A0(str, tVArchiveActivityNewFlow2.n);
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
            w.m0(TVArchiveActivityNewFlow.u1(TVArchiveActivityNewFlow.this));
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

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
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
                return Boolean.valueOf(TVArchiveActivityNewFlow.v1(TVArchiveActivityNewFlow.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            TVArchiveActivityNewFlow.w1(TVArchiveActivityNewFlow.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public TVArchiveActivityNewFlow() {
        Boolean bool = Boolean.FALSE;
        this.W = bool;
        this.X = bool;
    }

    private void A1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void D1() {
        this.d = findViewById(a7.f.ec);
        this.e = findViewById(a7.f.Om);
        this.f = findViewById(a7.f.kh);
        this.g = findViewById(a7.f.W);
        this.h = findViewById(a7.f.oc);
        this.i = findViewById(a7.f.ub);
        this.j = findViewById(a7.f.Q2);
        this.k = findViewById(a7.f.Q3);
        this.l = findViewById(a7.f.M4);
        this.m = findViewById(a7.f.sk);
        this.n = findViewById(a7.f.wk);
        this.o = findViewById(a7.f.Xa);
        this.Y = findViewById(a7.f.F4);
    }

    private boolean E1() {
        AsyncTask asyncTask;
        try {
            if (this.q == null) {
                return true;
            }
            this.B = new LiveStreamDBHandler(this.q);
            this.C = new ArrayList();
            this.D = new ArrayList();
            this.E = new ArrayList();
            this.F = new ArrayList();
            this.G = new ArrayList();
            this.H = new ArrayList();
            this.V = new ArrayList();
            this.G = this.B.getAllliveCategories();
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
            liveStreamCategoryIdDBModel.setLiveStreamCategoryID("0");
            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(getResources().getString(a7.j.x));
            this.G.add(0, liveStreamCategoryIdDBModel);
            this.F = this.G;
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("m3u")) {
                ArrayList arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.F.size() && ((asyncTask = this.T) == null || !asyncTask.isCancelled()); i3++) {
                        if (((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryID().equals("0") || ((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryID().equals("-1")) {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel2.setLiveStreamCounter(0);
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryName());
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryID(((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryID());
                            this.H.add(i2, liveStreamCategoryIdDBModel2);
                        } else {
                            ArrayList allLiveStreamsArchive = this.B.getAllLiveStreamsArchive(((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryID());
                            if (allLiveStreamsArchive != null && allLiveStreamsArchive.size() != 0) {
                                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                                liveStreamCategoryIdDBModel3.setLiveStreamCounter(allLiveStreamsArchive.size());
                                liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryName());
                                liveStreamCategoryIdDBModel3.setLiveStreamCategoryID(((LiveStreamCategoryIdDBModel) this.F.get(i3)).getLiveStreamCategoryID());
                                this.H.add(i2, liveStreamCategoryIdDBModel3);
                            }
                        }
                        i2++;
                    }
                }
                ArrayList arrayList2 = this.H;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.F = this.H;
                }
            }
            if (this.F == null) {
                return true;
            }
            for (int i4 = 0; i4 < this.F.size(); i4++) {
                this.V.add(new q7.w(((LiveStreamCategoryIdDBModel) this.F.get(i4)).getLiveStreamCategoryName(), ((LiveStreamCategoryIdDBModel) this.F.get(i4)).getLiveStreamCategoryID(), ((LiveStreamCategoryIdDBModel) this.F.get(i4)).getId(), ((LiveStreamCategoryIdDBModel) this.F.get(i4)).getLiveStreamCounter(), ((LiveStreamCategoryIdDBModel) this.F.get(i4)).getParentId()));
            }
            return true;
        } catch (NullPointerException | Exception unused) {
            return true;
        }
    }

    private void F1() {
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, a7.k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.p = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new a(dialog));
        this.p.setOnClickListener(new b(dialog));
        findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
        findViewById2.setOnFocusChangeListener(new e(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        t.q(this.q).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        t.q(this.q).l((String) a2.get(0)).g(findViewById);
                        m7.a.k1 = 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    private void G1() {
        if (this.F != null) {
            this.t = new e0(this.V, this.q);
            this.s = new u7.a(this.q).A().equals(m7.a.K0) ? new GridLayoutManager(this.q, 2) : new GridLayoutManager(this.q, 2);
            this.i.setLayoutManager(this.s);
            this.i.setItemAnimator(new androidx.recyclerview.widget.c());
            this.i.setAdapter(this.t);
        }
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void H1(Activity activity) {
        new d((TVArchiveActivityNewFlow) activity, activity).show();
    }

    public static /* synthetic */ Context u1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow) {
        return tVArchiveActivityNewFlow.q;
    }

    public static /* synthetic */ boolean v1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow) {
        return tVArchiveActivityNewFlow.E1();
    }

    public static /* synthetic */ void w1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow) {
        tVArchiveActivityNewFlow.G1();
    }

    public static /* synthetic */ SharedPreferences x1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow) {
        return tVArchiveActivityNewFlow.M;
    }

    public static /* synthetic */ SharedPreferences.Editor y1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow) {
        return tVArchiveActivityNewFlow.N;
    }

    public static /* synthetic */ AsyncTask z1(TVArchiveActivityNewFlow tVArchiveActivityNewFlow, AsyncTask asyncTask) {
        tVArchiveActivityNewFlow.T = asyncTask;
        return asyncTask;
    }

    public void B1() {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            return;
        }
        m7.a.i1 = true;
        F1();
    }

    public void C1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void b() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        this.i.setClickable(true);
        e0 e0Var = this.t;
        if (e0Var != null) {
            e0Var.J0(Z);
            this.t.w();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (id == a7.f.M4) {
            this.T = new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        this.q = this;
        C1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.l1);
        D1();
        m7.a.k0 = Boolean.FALSE;
        AppBarLayout appBarLayout = this.g;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        SharedPreferences sharedPreferences = getSharedPreferences("sortcatch", 0);
        this.M = sharedPreferences;
        this.N = sharedPreferences.edit();
        if (this.M.getString("sort", "").equals("")) {
            this.N.putString("sort", "0");
            this.N.apply();
        }
        A1();
        r1(findViewById(a7.f.kh));
        Handler handler = new Handler();
        this.Q = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.o.setOnClickListener(new c());
        this.Y.setOnClickListener(new f());
        this.T = new o().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.k.setVisibility(8);
        if (m7.a.e1.equalsIgnoreCase("1")) {
            if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
            } else {
                SharepreferenceDBHandler.setEventAdsView(0, this);
                B1();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.f.x(a7.h.r);
        this.S = menu;
        this.R = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("onestream_api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.f.getChildCount(); i2++) {
            if (this.f.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.f.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.S;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.R = menuItem;
        this.f.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.q) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new h()).g(getResources().getString(a7.j.d4), new g()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.P = b2;
            b2.setQueryHint(getResources().getString(a7.j.y6));
            this.P.setIconifiedByDefault(false);
            this.P.setOnQueryTextListener(new i());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar.f(this.q.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.q.getResources().getString(a7.j.S8), new j());
            aVar.g(this.q.getResources().getString(a7.j.d4), new k());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar2.f(this.q.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.q.getResources().getString(a7.j.S8), new l());
            aVar2.g(this.q.getResources().getString(a7.j.d4), new m());
            aVar2.n();
        }
        if (itemId == a7.f.mb) {
            H1(this);
            b();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        C1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.q);
        w.z0(this.q);
        getWindow().setFlags(1024, 1024);
        this.k.setVisibility(8);
        e0 e0Var = this.t;
        if (e0Var != null) {
            e0Var.J0(Z);
            this.t.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.r = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.r.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.q != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        C1();
    }
}
