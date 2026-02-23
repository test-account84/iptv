package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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
import android.widget.Toast;
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
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.squareup.picasso.t;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NewEPGCategoriesActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar f0;
    public LiveStreamDBHandler D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public ArrayList I;
    public ArrayList J;
    public SearchView P;
    public SharedPreferences Q;
    public SharedPreferences.Editor R;
    public MenuItem T;
    public Menu U;
    public List X;
    public Boolean Y;
    public Boolean Z;
    public ProgressBar d;
    public ViewPager e;
    public u7.a e0;
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
    public ImageView p;
    public LinearLayout q;
    public Context r;
    public SharedPreferences s;
    public Handler t;
    public GridLayoutManager u;
    public q7.l v;
    public boolean w = false;
    public int x = -1;
    public boolean y = false;
    public int z = 1;
    public int A = 0;
    public int B = 20;
    public ArrayList C = new ArrayList();
    public String K = "";
    public String L = "";
    public DatabaseUpdatedStatusDBModel M = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel N = new DatabaseUpdatedStatusDBModel();
    public ArrayList O = new ArrayList();
    public int S = -1;
    public AsyncTask V = null;
    public ArrayList W = new ArrayList();

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
            w.j(NewEPGCategoriesActivity.u1(NewEPGCategoriesActivity.this));
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
            NewEPGCategoriesActivity newEPGCategoriesActivity;
            if (view.getId() == a7.f.u1) {
                try {
                    RadioButton findViewById = findViewById(this.g.getCheckedRadioButtonId());
                    if (findViewById.getText().toString().equals(this.h.getResources().getString(a7.j.f7))) {
                        NewEPGCategoriesActivity.y1(NewEPGCategoriesActivity.this).putString("sort", "1");
                        newEPGCategoriesActivity = NewEPGCategoriesActivity.this;
                    } else if (findViewById.getText().toString().equals(this.h.getResources().getString(a7.j.k7))) {
                        NewEPGCategoriesActivity.y1(NewEPGCategoriesActivity.this).putString("sort", "2");
                        newEPGCategoriesActivity = NewEPGCategoriesActivity.this;
                    } else {
                        NewEPGCategoriesActivity.y1(NewEPGCategoriesActivity.this).putString("sort", "0");
                        newEPGCategoriesActivity = NewEPGCategoriesActivity.this;
                    }
                    NewEPGCategoriesActivity.y1(newEPGCategoriesActivity).commit();
                    NewEPGCategoriesActivity.z1(NewEPGCategoriesActivity.this, NewEPGCategoriesActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
                    dismiss();
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
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
            findViewById3.setOnFocusChangeListener(NewEPGCategoriesActivity.this.new o(findViewById3));
            findViewById4.setOnFocusChangeListener(NewEPGCategoriesActivity.this.new o(findViewById4));
            String string = NewEPGCategoriesActivity.x1(NewEPGCategoriesActivity.this).getString("sort", "");
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
            Resources resources;
            int i;
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                    return;
                }
                resources = NewEPGCategoriesActivity.this.getResources();
                i = a7.e.M;
            } else {
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                    return;
                }
                resources = NewEPGCategoriesActivity.this.getResources();
                i = a7.e.L;
            }
            view.setBackground(resources.getDrawable(i));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            NewEPGCategoriesActivity.this.onBackPressed();
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
            w.n0(NewEPGCategoriesActivity.u1(NewEPGCategoriesActivity.this));
        }
    }

    public class i implements SearchView.m {
        public i() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            m7.a.k0 = str.length() > 0 ? Boolean.FALSE : Boolean.TRUE;
            NewEPGCategoriesActivity.this.n.setVisibility(8);
            NewEPGCategoriesActivity newEPGCategoriesActivity = NewEPGCategoriesActivity.this;
            if (newEPGCategoriesActivity.v == null || (textView = newEPGCategoriesActivity.m) == null || textView.getVisibility() == 0) {
                return false;
            }
            NewEPGCategoriesActivity newEPGCategoriesActivity2 = NewEPGCategoriesActivity.this;
            newEPGCategoriesActivity2.v.F0(str, newEPGCategoriesActivity2.n);
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
            ImportStatusModel importStatusModel;
            Context applicationContext;
            String str;
            LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(NewEPGCategoriesActivity.u1(NewEPGCategoriesActivity.this));
            new u7.a(NewEPGCategoriesActivity.u1(NewEPGCategoriesActivity.this));
            ArrayList activeEPGSource = liveStreamDBHandler.getActiveEPGSource();
            String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
            if (!valueOf.equals("0") && (importStatusModel = liveStreamDBHandler.getdateDBStatus("epg", valueOf)) != null) {
                if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equalsIgnoreCase("3")) {
                    w.a0(liveStreamDBHandler, valueOf, NewEPGCategoriesActivity.u1(NewEPGCategoriesActivity.this));
                    applicationContext = NewEPGCategoriesActivity.this.getApplicationContext();
                    str = "Updating EPG in background.";
                } else {
                    applicationContext = NewEPGCategoriesActivity.this.getApplicationContext();
                    str = "EPG Update in progress.";
                }
                Toast.makeText(applicationContext, str, 0).show();
            }
            dialogInterface.dismiss();
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
            dialogInterface.dismiss();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class n extends AsyncTask {
        public n() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NewEPGCategoriesActivity.v1(NewEPGCategoriesActivity.this));
            } catch (Exception e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            NewEPGCategoriesActivity.w1(NewEPGCategoriesActivity.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class o implements View.OnFocusChangeListener {
        public final View a;

        public o(View view) {
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

    public NewEPGCategoriesActivity() {
        Boolean bool = Boolean.FALSE;
        this.Y = bool;
        this.Z = bool;
    }

    private void A1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList C1() {
        ArrayList allPasswordStatus = this.D.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.r));
        this.E = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.C.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.C;
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
                        ArrayList arrayList3 = this.F;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean F1() {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewEPGCategoriesActivity.F1():boolean");
    }

    private void G1() {
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, a7.k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.q = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new a(dialog));
        this.q.setOnClickListener(new b(dialog));
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
                        t.q(this.r).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        t.q(this.r).l((String) a2.get(0)).g(findViewById);
                        m7.a.k1 = 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        findViewById2.requestFocus();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    private void H1() {
        List list;
        if (this.H == null || (list = this.X) == null) {
            return;
        }
        this.v = new q7.l(this.r, list);
        this.u = new u7.a(this.r).A().equals(m7.a.K0) ? new GridLayoutManager(this.r, 2) : new GridLayoutManager(this.r, 2);
        this.i.setLayoutManager(this.u);
        this.i.setItemAnimator(new androidx.recyclerview.widget.c());
        this.i.setAdapter(this.v);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void I1(Activity activity) {
        new d((NewEPGCategoriesActivity) activity, activity).show();
    }

    public static /* synthetic */ Context u1(NewEPGCategoriesActivity newEPGCategoriesActivity) {
        return newEPGCategoriesActivity.r;
    }

    public static /* synthetic */ boolean v1(NewEPGCategoriesActivity newEPGCategoriesActivity) {
        return newEPGCategoriesActivity.F1();
    }

    public static /* synthetic */ void w1(NewEPGCategoriesActivity newEPGCategoriesActivity) {
        newEPGCategoriesActivity.H1();
    }

    public static /* synthetic */ SharedPreferences x1(NewEPGCategoriesActivity newEPGCategoriesActivity) {
        return newEPGCategoriesActivity.Q;
    }

    public static /* synthetic */ SharedPreferences.Editor y1(NewEPGCategoriesActivity newEPGCategoriesActivity) {
        return newEPGCategoriesActivity.R;
    }

    public static /* synthetic */ AsyncTask z1(NewEPGCategoriesActivity newEPGCategoriesActivity, AsyncTask asyncTask) {
        newEPGCategoriesActivity.V = asyncTask;
        return asyncTask;
    }

    public void B1() {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            return;
        }
        m7.a.i1 = true;
        G1();
    }

    public void E1() {
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
        q7.l lVar = this.v;
        if (lVar != null) {
            lVar.N0(f0);
            this.v.w();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (view.getId() == a7.f.M4) {
            this.V = new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        this.r = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        E1();
        setContentView(a7.g.v);
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
        this.p = findViewById(a7.f.F4);
        m7.a.k0 = Boolean.FALSE;
        AppBarLayout appBarLayout = this.g;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        A1();
        r1(findViewById(a7.f.kh));
        this.e0 = new u7.a(this.r);
        this.D = new LiveStreamDBHandler(this.r);
        SharedPreferences sharedPreferences = getSharedPreferences("sortepg", 0);
        this.Q = sharedPreferences;
        this.R = sharedPreferences.edit();
        if (this.Q.getString("sort", "").equals("")) {
            this.R.putString("sort", "0");
            this.R.commit();
        }
        Handler handler = new Handler();
        this.t = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.V = new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.k.setVisibility(8);
        this.o.setOnClickListener(new c());
        this.p.setOnClickListener(new f());
        w.Z(this.r);
        if (m7.a.V0.booleanValue() && m7.a.e1.equalsIgnoreCase("1")) {
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
        this.U = menu;
        this.T = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.r).equals("api") || SharepreferenceDBHandler.getCurrentAPPType(this.r).equals("m3u")) {
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

    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.V;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        this.V.cancel(true);
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

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.T = menuItem;
        this.f.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.r) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new h()).g(getResources().getString(a7.j.d4), new g()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.P = b2;
            b2.setQueryHint(getResources().getString(a7.j.B6));
            this.P.setIconifiedByDefault(false);
            this.P.setOnQueryTextListener(new i());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.r.getResources().getString(a7.j.u0));
            aVar.f(this.r.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.r.getResources().getString(a7.j.S8), new j());
            aVar.g(this.r.getResources().getString(a7.j.d4), new k());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.r.getResources().getString(a7.j.u0));
            aVar2.f(this.r.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.r.getResources().getString(a7.j.S8), new l());
            aVar2.g(this.r.getResources().getString(a7.j.d4), new m());
            aVar2.n();
        }
        if (itemId == a7.f.mb) {
            I1(this);
            b();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        E1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.r);
        w.z0(this.r);
        getWindow().setFlags(1024, 1024);
        this.k.setVisibility(8);
        q7.l lVar = this.v;
        if (lVar != null) {
            lVar.N0(f0);
            this.v.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.s = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.s.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.r != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        E1();
    }
}
