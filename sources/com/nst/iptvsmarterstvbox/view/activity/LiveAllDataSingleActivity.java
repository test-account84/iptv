package com.nst.iptvsmarterstvbox.view.activity;

import a7.k;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.DataBaseViewModel;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.StalkerLiveFavIdsSingleton;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.Z;
import q7.m0;
import q7.s;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LiveAllDataSingleActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.g {
    public ArrayList A;
    public SharedPreferences D;
    public SharedPreferences.Editor E;
    public Menu F;
    public MenuItem G;
    public SearchView H;
    public n7.e L;
    public RelativeLayout M;
    public RelativeLayout N;
    public ImageView O;
    public RelativeLayout P;
    public ImageView Q;
    public RecyclerView R;
    public RecyclerView S;
    public LinearLayout T;
    public LinearLayout U;
    public TextView V;
    public TextView W;
    public EditText X;
    public LinearLayout Y;
    public Toolbar Z;
    public Context d;
    public Animation e;
    public AppBarLayout e0;
    public Animation f;
    public ImageView f0;
    public Animation g;
    public ImageView g0;
    public Animation h;
    public ImageView h0;
    public Animation i;
    public GridLayoutManager j;
    public LinearLayoutManager k;
    public t l;
    public s m;
    public ArrayList n;
    public LinearLayout n0;
    public ArrayList o;
    public LiveStreamDBHandler p;
    public DataBaseViewModel p0;
    public ArrayList q;
    public boolean q0;
    public ArrayList r;
    public ArrayList s;
    public DatabaseHandler v;
    public ArrayList w;
    public ArrayList x;
    public ArrayList y;
    public ArrayList z;
    public int t = -1;
    public ArrayList u = new ArrayList();
    public ArrayList B = new ArrayList();
    public ArrayList C = new ArrayList();
    public String I = "0";
    public String J = "0";
    public int K = -1;
    public String i0 = "";
    public String j0 = "0";
    public String k0 = "false";
    public String l0 = "";
    public String m0 = "";
    public int o0 = 0;
    public String r0 = "";

    public class a extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public LinearLayout f;
        public LinearLayout g;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                LiveAllDataSingleActivity.this.j2();
            }
        }

        public class b implements View.OnFocusChangeListener {
            public View a;

            public b(View view) {
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
                            b = a.b(a.this);
                        }
                    } else {
                        b = a.a(a.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = a.b(a.this);
                        }
                    } else {
                        b = a.a(a.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public a(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(a aVar) {
            return aVar.f;
        }

        public static /* synthetic */ LinearLayout b(a aVar) {
            return aVar.g;
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == a7.f.u1) {
                try {
                    LiveAllDataSingleActivity.A1(LiveAllDataSingleActivity.this).deleteALLLiveRecentlyWatched();
                    LiveAllDataSingleActivity.this.p2();
                    new Handler().postDelayed(new a(), 100L);
                } catch (Exception unused) {
                }
            } else if (id == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(new u7.a(LiveAllDataSingleActivity.E1(LiveAllDataSingleActivity.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.f = findViewById(a7.f.V8);
            this.g = findViewById(a7.f.Ia);
            TextView findViewById = findViewById(a7.f.um);
            this.e = findViewById;
            findViewById.setText(LiveAllDataSingleActivity.this.getResources().getString(a7.j.V8));
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new b(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new b(textView2));
        }
    }

    public class b implements View.OnFocusChangeListener {
        public View a;

        public b(View view) {
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
            view.setBackground(LiveAllDataSingleActivity.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class c extends Dialog implements View.OnClickListener {
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
                            b = c.b(c.this);
                        }
                    } else {
                        b = c.a(c.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = c.b(c.this);
                        }
                    } else {
                        b = c.a(c.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, Activity activity2) {
            super(activity);
            this.h = activity2;
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(c cVar) {
            return cVar.e;
        }

        public static /* synthetic */ LinearLayout b(c cVar) {
            return cVar.f;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: Exception -> 0x011c, PHI: r0
          0x003e: PHI (r0v23 java.lang.String) = 
          (r0v16 java.lang.String)
          (r0v17 java.lang.String)
          (r0v18 java.lang.String)
          (r0v19 java.lang.String)
          (r0v20 java.lang.String)
          (r0v24 java.lang.String)
         binds: [B:42:0x00fe, B:39:0x00ee, B:34:0x00c4, B:29:0x009b, B:24:0x0072, B:15:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {Exception -> 0x011c, blocks: (B:10:0x0008, B:13:0x0030, B:16:0x003e, B:17:0x0102, B:19:0x0045, B:20:0x004c, B:22:0x0066, B:25:0x0075, B:27:0x008f, B:30:0x009e, B:32:0x00b8, B:35:0x00c8, B:37:0x00e2, B:40:0x00f2), top: B:9:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[Catch: Exception -> 0x011c, PHI: r0
          0x0045: PHI (r0v21 java.lang.String) = 
          (r0v16 java.lang.String)
          (r0v17 java.lang.String)
          (r0v18 java.lang.String)
          (r0v19 java.lang.String)
          (r0v20 java.lang.String)
          (r0v24 java.lang.String)
         binds: [B:42:0x00fe, B:39:0x00ee, B:34:0x00c4, B:29:0x009b, B:24:0x0072, B:15:0x003c] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x011c, blocks: (B:10:0x0008, B:13:0x0030, B:16:0x003e, B:17:0x0102, B:19:0x0045, B:20:0x004c, B:22:0x0066, B:25:0x0075, B:27:0x008f, B:30:0x009e, B:32:0x00b8, B:35:0x00c8, B:37:0x00e2, B:40:0x00f2), top: B:9:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r5) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.c.onClick(android.view.View):void");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:6:0x00eb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCreate(android.os.Bundle r11) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.c.onCreate(android.os.Bundle):void");
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (LiveAllDataSingleActivity.B1(LiveAllDataSingleActivity.this) != null) {
                LiveAllDataSingleActivity.B1(LiveAllDataSingleActivity.this).getFilter().filter(charSequence.toString());
            }
        }
    }

    public class e implements SearchView.m {
        public e() {
        }

        public boolean onQueryTextChange(String str) {
            if (LiveAllDataSingleActivity.C1(LiveAllDataSingleActivity.this) == null) {
                return false;
            }
            LiveAllDataSingleActivity.C1(LiveAllDataSingleActivity.this).getFilter().filter(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public f(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public g(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
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
                r0 = 1768729440(0x696cab60, float:1.7882237E25)
                if (r2 == r0) goto L19
                goto L36
            L19:
                java.lang.String r0 = "get_recently_watched"
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
                com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.this     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = r7.O1()     // Catch: java.lang.Exception -> L56
                return r7
            L46:
                com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity r0 = com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.this     // Catch: java.lang.Exception -> L56
                r7 = r7[r5]     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = r0.N1(r7)     // Catch: java.lang.Exception -> L56
                return r7
            L4f:
                com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.this     // Catch: java.lang.Exception -> L56
                java.lang.String r7 = r7.Q1()     // Catch: java.lang.Exception -> L56
                return r7
            L56:
                java.lang.String r7 = "error"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.h.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LiveAllDataSingleActivity.this.Y1();
            str.hashCode();
            switch (str) {
                case "get_fav_local":
                    LiveAllDataSingleActivity.this.K1();
                    break;
                case "get_all":
                    LiveAllDataSingleActivity.this.u1();
                    break;
                case "get_fav_real_time":
                    LiveAllDataSingleActivity.this.L1();
                    break;
                case "get_recent_watch":
                    LiveAllDataSingleActivity.G1(LiveAllDataSingleActivity.this);
                    break;
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            LiveAllDataSingleActivity.F1(LiveAllDataSingleActivity.this);
            LiveAllDataSingleActivity.this.V1();
            LiveAllDataSingleActivity.this.X1();
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final View a;

        public i(View view) {
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
            Resources resources;
            int i;
            if (!z) {
                if (z) {
                    return;
                }
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("3")) {
                            b(1.0f);
                            c(1.0f);
                            a(z);
                            return;
                        }
                    } else {
                        resources = LiveAllDataSingleActivity.this.getResources();
                        i = a7.c.i;
                    }
                }
                view.setBackgroundResource(0);
                return;
            }
            View view5 = this.a;
            if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("1")) {
                View view6 = this.a;
                if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("2")) {
                    View view7 = this.a;
                    if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("3")) {
                        b(1.15f);
                        c(1.15f);
                        return;
                    }
                    resources = LiveAllDataSingleActivity.this.getResources();
                    i = a7.e.O0;
                } else {
                    resources = LiveAllDataSingleActivity.this.getResources();
                    i = a7.c.s;
                }
            } else {
                resources = LiveAllDataSingleActivity.this.getResources();
                i = a7.e.O0;
            }
            view.setBackground(resources.getDrawable(i));
        }
    }

    public class j extends AsyncTask {
        public j() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return LiveAllDataSingleActivity.w1(LiveAllDataSingleActivity.this);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            LiveAllDataSingleActivity.x1(LiveAllDataSingleActivity.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ LiveStreamDBHandler A1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.p;
    }

    public static /* synthetic */ s B1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.m;
    }

    public static /* synthetic */ t C1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.l;
    }

    public static /* synthetic */ String D1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.I;
    }

    public static /* synthetic */ Context E1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.d;
    }

    public static /* synthetic */ void F1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        liveAllDataSingleActivity.w2();
    }

    public static /* synthetic */ void G1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        liveAllDataSingleActivity.v1();
    }

    private void H1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList R1() {
        ArrayList allPasswordStatus = this.p.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.q = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.u.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.u;
    }

    public static void U1(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    private void b2() {
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new LiveStreamDBHandler(this.d);
        this.q = new ArrayList();
        this.s = new ArrayList();
        this.r = new ArrayList();
        this.k = new LinearLayoutManager(this.d);
        this.v = new DatabaseHandler(this.d);
        this.L = new n7.e(this, this.d);
        w.y(this.d);
        this.y = new ArrayList();
        SharedPreferences sharedPreferences = getSharedPreferences("showhidemoviename", 0);
        this.D = sharedPreferences;
        this.E = sharedPreferences.edit();
        String stringExtra = getIntent().getStringExtra("RADIO");
        this.k0 = stringExtra;
        if (stringExtra == null) {
            this.k0 = "false";
        }
        this.r0 = this.k0.equalsIgnoreCase("true") ? "radio_streams" : "live";
        M1();
        z2();
        l2();
        m2();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            try {
                this.m0 = SharepreferenceDBHandler.getStalkerToken(this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
                this.l0 = loggedInMacAddress;
                this.L.f(loggedInMacAddress, this.m0, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            f2();
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            return;
        }
        w.Z(this.d);
    }

    private void l2() {
        this.Q.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.h0.setOnClickListener(this);
    }

    private void q2(String str) {
        this.j0 = str;
        s sVar = this.m;
        if (sVar != null) {
            sVar.A0(str);
        }
    }

    public static /* synthetic */ Boolean w1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.e2();
    }

    public static /* synthetic */ void x1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        liveAllDataSingleActivity.s2();
    }

    public static /* synthetic */ String y1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.k0;
    }

    private void y2(Activity activity) {
        new c((LiveAllDataSingleActivity) activity, activity).show();
    }

    public static /* synthetic */ String z1(LiveAllDataSingleActivity liveAllDataSingleActivity) {
        return liveAllDataSingleActivity.J;
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
        f2();
    }

    public boolean I1() {
        t tVar = this.l;
        if (tVar != null) {
            return tVar.b1();
        }
        return false;
    }

    public final void J1() {
        EditText editText = this.X;
        if (editText != null) {
            editText.setText("");
            this.X.clearFocus();
        }
    }

    public void K1() {
        try {
            ArrayList arrayList = this.B;
            if (arrayList == null || arrayList.size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setLiveList((ArrayList) null);
                t tVar = new t(this.d, "live", this.i0, this.j0, this.r0);
                this.l = tVar;
                this.S.setAdapter(tVar);
                v2(getResources().getString(a7.j.k4));
                return;
            }
            VodAllCategoriesSingleton.getInstance().setLiveList(this.B);
            t tVar2 = new t(this.d, "live", this.i0, this.j0, this.r0);
            this.l = tVar2;
            this.S.setAdapter(tVar2);
            RelativeLayout relativeLayout = this.M;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.S.setLayoutManager(this.j);
            u2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void L1() {
        String string;
        try {
            if (this.k0.equalsIgnoreCase("true")) {
                if (VodAllCategoriesSingleton.getInstance().getRadioFavList() == null || VodAllCategoriesSingleton.getInstance().getRadioFavList().size() <= 0) {
                    VodAllCategoriesSingleton.getInstance().setLiveList((ArrayList) null);
                    t tVar = new t(this.d, "live", this.i0, this.j0, this.r0);
                    this.l = tVar;
                    this.S.setAdapter(tVar);
                    string = getResources().getString(a7.j.k4);
                    v2(string);
                    return;
                }
                t tVar2 = new t(this.d, "live", this.i0, this.j0, this.r0);
                this.l = tVar2;
                this.S.setAdapter(tVar2);
                RelativeLayout relativeLayout = this.M;
                this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
                this.S.setLayoutManager(this.j);
                u2();
            }
            if (VodAllCategoriesSingleton.getInstance().getLiveFavList() == null || VodAllCategoriesSingleton.getInstance().getLiveFavList().size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setLiveList((ArrayList) null);
                t tVar3 = new t(this.d, "live", this.i0, this.j0, this.r0);
                this.l = tVar3;
                this.S.setAdapter(tVar3);
                string = getResources().getString(a7.j.k4);
                v2(string);
                return;
            }
            t tVar4 = new t(this.d, "live", this.i0, this.j0, this.r0);
            this.l = tVar4;
            this.S.setAdapter(tVar4);
            RelativeLayout relativeLayout2 = this.M;
            this.j = (relativeLayout2 == null || relativeLayout2.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.S.setLayoutManager(this.j);
            u2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.L.i(this.l0, this.m0);
        } catch (Exception unused) {
        }
    }

    public final void M1() {
        ImageView imageView = this.Q;
        imageView.setOnFocusChangeListener(new i(imageView));
        RelativeLayout relativeLayout = this.P;
        relativeLayout.setOnFocusChangeListener(new i(relativeLayout));
        ImageView imageView2 = this.O;
        imageView2.setOnFocusChangeListener(new i(imageView2));
    }

    public String N1(String str) {
        try {
            this.w = new ArrayList();
            this.n = new ArrayList();
            this.x = new ArrayList();
            this.y = this.k0.equals("true") ? this.p.getAllLiveStreasWithCategoryId(str, "radio_streams") : this.p.getAllLiveStreasWithCategoryId(str, "live");
            return "get_all";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_all";
        }
    }

    public String O1() {
        try {
            this.w = new ArrayList();
            this.n = new ArrayList();
            this.x = new ArrayList();
            this.y = this.k0.equalsIgnoreCase("true") ? this.p.getAllRecentlyWatchedLiveStreams("radio_streams") : this.p.getAllRecentlyWatchedLiveStreams("live");
            return "get_recent_watch";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_recent_watch";
        }
    }

    public void P0(String str) {
    }

    public void P1() {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            return;
        }
        m7.a.i1 = true;
        g2();
    }

    public String Q1() {
        LiveStreamsDBModel liveStreamFavouriteRow;
        ArrayList arrayList;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                new ArrayList();
                this.B.clear();
                ArrayList favouriteM3U = this.p.getFavouriteM3U("live");
                if (this.u != null) {
                    this.u = R1();
                }
                ArrayList arrayList2 = this.u;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = T1(favouriteM3U, this.u);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return "get_fav_local";
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.p.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        this.B.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
                return "get_fav_local";
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                List<Integer> favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
                String str = "";
                if (favIdsList != null && favIdsList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : favIdsList) {
                        if (sb.length() > 0) {
                            sb.append(',');
                        }
                        sb.append("'");
                        sb.append(num);
                        sb.append("'");
                    }
                    str = sb.toString();
                }
                this.B.clear();
                this.B = this.p.getLiveFavStalker(str);
                return "get_fav_local";
            }
            new ArrayList();
            this.B.clear();
            ArrayList allFavourites = this.k0.equals("true") ? this.v.getAllFavourites("radio_streams", SharepreferenceDBHandler.getUserID(this.d)) : this.v.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.d));
            if (this.u != null) {
                this.u = R1();
            }
            ArrayList arrayList3 = this.u;
            if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                allFavourites = S1(allFavourites, this.u);
            }
            if (allFavourites == null || allFavourites.size() <= 0) {
                return "get_fav_local";
            }
            Iterator it2 = allFavourites.iterator();
            while (it2.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    liveStreamFavouriteRow = this.p.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), favouriteDBModel.getStreamIDOneStream(), favouriteDBModel.getTimestamp(), this.r0);
                    if (liveStreamFavouriteRow != null) {
                        arrayList = this.B;
                        arrayList.add(liveStreamFavouriteRow);
                    }
                } else {
                    liveStreamFavouriteRow = this.p.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), this.r0);
                    if (liveStreamFavouriteRow != null) {
                        arrayList = this.B;
                        arrayList.add(liveStreamFavouriteRow);
                    }
                }
            }
            return "get_fav_local";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav_local";
        }
    }

    public final ArrayList S1(ArrayList arrayList, ArrayList arrayList2) {
        this.z = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.z.add(favouriteDBModel);
                    break;
                }
                String str = (String) it2.next();
                if (favouriteDBModel.getCategoryID() == null || !favouriteDBModel.getCategoryID().equals(str)) {
                }
            }
        }
        return this.z;
    }

    public final ArrayList T1(ArrayList arrayList, ArrayList arrayList2) {
        this.A = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            this.A.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.A;
        } catch (Exception unused) {
            return null;
        }
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
        if (stalkerLiveFavIdsCallback != null && stalkerLiveFavIdsCallback.getJs() != null && stalkerLiveFavIdsCallback.getJs().size() > 0) {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(stalkerLiveFavIdsCallback.getJs());
        }
        f2();
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void V1() {
        LinearLayout linearLayout = this.T;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.T.setVisibility(8);
    }

    public void W1() {
        LinearLayout linearLayout = this.Y;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void X1() {
        TextView textView = this.V;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.V.setVisibility(8);
    }

    public void Y1() {
        LinearLayout linearLayout = this.U;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.U.setVisibility(8);
    }

    public final void Z1() {
        if (this.M.getVisibility() == 0) {
            U1(this);
            this.N.startAnimation(this.h);
            this.N.setVisibility(0);
            this.M.startAnimation(this.f);
            this.M.setVisibility(8);
            this.O.startAnimation(this.i);
            this.O.setVisibility(0);
            this.h0.setVisibility(0);
            this.O.requestFocus();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 7);
            this.j = gridLayoutManager;
            this.S.setLayoutManager(gridLayoutManager);
        }
    }

    public void a2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void c(String str) {
    }

    public final boolean c2() {
        EditText editText = this.X;
        return editText != null && editText.getText().toString().length() > 0;
    }

    public boolean d2() {
        EditText editText = this.X;
        if (editText != null) {
            return editText.isFocused();
        }
        return false;
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5 A[Catch: Exception -> 0x016d, NullPointerException -> 0x0170, TryCatch #2 {Exception -> 0x016d, NullPointerException -> 0x0170, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000a, B:8:0x000d, B:11:0x0037, B:13:0x0047, B:14:0x0092, B:16:0x00c5, B:18:0x00cd, B:19:0x00d3, B:20:0x00dd, B:23:0x00e3, B:24:0x00fa, B:25:0x013a, B:27:0x0152, B:28:0x00d6, B:29:0x0102, B:32:0x010c, B:33:0x0112, B:34:0x011c, B:37:0x0122, B:38:0x0115, B:39:0x004e, B:40:0x0055, B:42:0x0061, B:43:0x0070, B:45:0x0078, B:46:0x0089, B:47:0x016a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0152 A[Catch: Exception -> 0x016d, NullPointerException -> 0x0170, TryCatch #2 {Exception -> 0x016d, NullPointerException -> 0x0170, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000a, B:8:0x000d, B:11:0x0037, B:13:0x0047, B:14:0x0092, B:16:0x00c5, B:18:0x00cd, B:19:0x00d3, B:20:0x00dd, B:23:0x00e3, B:24:0x00fa, B:25:0x013a, B:27:0x0152, B:28:0x00d6, B:29:0x0102, B:32:0x010c, B:33:0x0112, B:34:0x011c, B:37:0x0122, B:38:0x0115, B:39:0x004e, B:40:0x0055, B:42:0x0061, B:43:0x0070, B:45:0x0078, B:46:0x0089, B:47:0x016a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0102 A[Catch: Exception -> 0x016d, NullPointerException -> 0x0170, TRY_LEAVE, TryCatch #2 {Exception -> 0x016d, NullPointerException -> 0x0170, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000a, B:8:0x000d, B:11:0x0037, B:13:0x0047, B:14:0x0092, B:16:0x00c5, B:18:0x00cd, B:19:0x00d3, B:20:0x00dd, B:23:0x00e3, B:24:0x00fa, B:25:0x013a, B:27:0x0152, B:28:0x00d6, B:29:0x0102, B:32:0x010c, B:33:0x0112, B:34:0x011c, B:37:0x0122, B:38:0x0115, B:39:0x004e, B:40:0x0055, B:42:0x0061, B:43:0x0070, B:45:0x0078, B:46:0x0089, B:47:0x016a), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean e2() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.e2():java.lang.Boolean");
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f2() {
        new j().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public final void g2() {
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.n0 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new f(dialog));
        this.n0.setOnClickListener(new g(dialog));
        findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
        findViewById2.setOnFocusChangeListener(new b(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        com.squareup.picasso.t.q(this.d).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        com.squareup.picasso.t.q(this.d).l((String) a2.get(0)).g(findViewById);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098 A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:10:0x0029, B:12:0x002d, B:14:0x0035, B:16:0x003d, B:19:0x0046, B:21:0x0054, B:22:0x0064, B:23:0x0090, B:25:0x0098, B:27:0x00a2, B:29:0x00a8, B:30:0x00bc, B:31:0x00cc, B:32:0x00d0, B:33:0x006b, B:34:0x007f), top: B:9:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:10:0x0029, B:12:0x002d, B:14:0x0035, B:16:0x003d, B:19:0x0046, B:21:0x0054, B:22:0x0064, B:23:0x0090, B:25:0x0098, B:27:0x00a2, B:29:0x00a8, B:30:0x00bc, B:31:0x00cc, B:32:0x00d0, B:33:0x006b, B:34:0x007f), top: B:9:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h2(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity.h2(java.lang.String, java.lang.String):void");
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i2() {
        LinearLayout linearLayout = this.Y;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j2() {
        s sVar = this.m;
        if (sVar != null) {
            sVar.w();
        }
    }

    public void k2() {
        t tVar = this.l;
        if (tVar != null) {
            tVar.w();
        }
    }

    public final void m2() {
        EditText editText = this.X;
        if (editText != null) {
            editText.addTextChangedListener(new d());
        }
    }

    public void n2() {
        t tVar = this.l;
        if (tVar != null) {
            tVar.i1();
        }
    }

    public void o0(String str) {
    }

    public void o2() {
        w.o = new h().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_recent_watch", "-4"});
    }

    public void onBackPressed() {
        if (c2()) {
            J1();
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.U4) {
            Z1();
            return;
        }
        if (id == a7.f.G4 || id == a7.f.H4) {
            onBackPressed();
            return;
        }
        if (id == a7.f.l5) {
            this.K = -1;
            x2();
        } else if (id == a7.f.Xa) {
            w.j(this.d);
        } else if (id == a7.f.if) {
            this.X.requestFocus();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        a2();
        H1();
        this.d = this;
        setContentView(a7.g.Q);
        this.M = findViewById(a7.f.ye);
        this.N = findViewById(a7.f.hf);
        this.O = findViewById(a7.f.l5);
        this.P = findViewById(a7.f.if);
        this.Q = findViewById(a7.f.U4);
        this.R = findViewById(a7.f.Fd);
        this.S = findViewById(a7.f.Dd);
        this.T = findViewById(a7.f.W9);
        this.U = findViewById(a7.f.I8);
        this.V = findViewById(a7.f.wk);
        this.W = findViewById(a7.f.Zj);
        this.X = findViewById(a7.f.m3);
        this.Y = findViewById(a7.f.W8);
        this.Z = findViewById(a7.f.kh);
        this.e0 = findViewById(a7.f.W);
        this.f0 = findViewById(a7.f.Xa);
        this.g0 = findViewById(a7.f.G4);
        this.h0 = findViewById(a7.f.H4);
        Toolbar toolbar = this.Z;
        if (toolbar != null) {
            r1(toolbar);
        }
        this.q0 = true;
        b2();
        if (m7.a.V0.booleanValue() && m7.a.e1.equalsIgnoreCase("1")) {
            if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
            } else {
                SharepreferenceDBHandler.setEventAdsView(0, this);
                P1();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        ArrayList liveList;
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        Toolbar toolbar = this.Z;
        if (toolbar != null) {
            toolbar.x(a7.h.t);
            SharedPreferences sharedPreferences = this.D;
            if (sharedPreferences != null) {
                if (sharedPreferences.getInt("livestream", 1) == 1) {
                    menu.getItem(1).getSubMenu().findItem(a7.f.v6).setVisible(false);
                    menu.getItem(1).getSubMenu().findItem(a7.f.r6).setVisible(true);
                } else {
                    menu.getItem(1).getSubMenu().findItem(a7.f.v6).setVisible(true);
                    menu.getItem(1).getSubMenu().findItem(a7.f.r6).setVisible(false);
                }
            }
            this.F = menu;
            TextView textView = this.W;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (this.I.equals("-5") || this.I.equals("-4") || this.I.equals("-6") || SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                this.F.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(false);
            } else {
                this.F.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(true);
            }
            if (!this.I.equals("-6") || (liveList = VodAllCategoriesSingleton.getInstance().getLiveList()) == null || liveList.size() <= 0) {
                this.F.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            } else {
                this.F.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") || SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                menu.getItem(1).getSubMenu().findItem(a7.f.gb).setVisible(true);
            } else {
                menu.getItem(1).getSubMenu().findItem(a7.f.gb).setVisible(false);
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.m != null) {
            this.m = null;
        }
        AsyncTask asyncTask = w.o;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        w.o.cancel(true);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        t tVar;
        if (i2 != 21) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.M.getVisibility() != 8 || (tVar = this.l) == null) {
            return false;
        }
        int c1 = tVar.c1();
        this.K = c1;
        if (c1 % 7 != 0) {
            return false;
        }
        x2();
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.G = menuItem;
        this.Z.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.g) {
            try {
                SearchView actionView = menuItem.getActionView();
                this.H = actionView;
                if (actionView != null) {
                    actionView.setQueryHint(getResources().getString(a7.j.A6));
                    this.H.setIconifiedByDefault(false);
                    ImageView findViewById = this.H.findViewById(a7.f.Uf);
                    this.H.findViewById(a7.f.Vf).setImageResource(a7.e.m1);
                    findViewById.setImageResource(a7.e.m1);
                    findViewById.setPadding(15, 15, 15, 15);
                    findViewById.setBackground((Drawable) null);
                    this.H.setOnQueryTextListener(new e());
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        if (itemId == a7.f.mb) {
            y2(this);
        }
        if (itemId == a7.f.v6) {
            SharedPreferences.Editor editor = this.E;
            if (editor != null) {
                editor.putInt("livestream", 1);
                this.E.commit();
            }
            Menu menu = this.F;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.v6).setVisible(false);
                this.F.getItem(1).getSubMenu().findItem(a7.f.r6).setVisible(true);
            }
            k2();
        }
        if (itemId == a7.f.r6) {
            SharedPreferences.Editor editor2 = this.E;
            if (editor2 != null) {
                editor2.putInt("livestream", 0);
                this.E.commit();
            }
            Menu menu2 = this.F;
            if (menu2 != null) {
                menu2.getItem(1).getSubMenu().findItem(a7.f.v6).setVisible(true);
                this.F.getItem(1).getSubMenu().findItem(a7.f.r6).setVisible(false);
            }
            k2();
        }
        if (itemId == a7.f.gb) {
            w.A0(this.d);
        }
        if (itemId == a7.f.Db && VodAllCategoriesSingleton.getInstance().getLiveList() != null && VodAllCategoriesSingleton.getInstance().getLiveList().size() > 0) {
            t2();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        DataBaseViewModel dataBaseViewModel = this.p0;
        if (dataBaseViewModel != null) {
            dataBaseViewModel.getDataForMovies().n(this);
        }
    }

    public void onResume() {
        a2();
        super/*androidx.fragment.app.e*/.onResume();
        if (this.q0) {
            this.q0 = false;
        } else {
            j2();
        }
        w.z0(this.d);
        if (this.I.equals("-4")) {
            o2();
        } else {
            k2();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        a2();
    }

    public void p2() {
        w.o = new h().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_recently_watched", "-6"});
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void r2(String str) {
        this.i0 = str;
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void s2() {
        ArrayList arrayList;
        String string;
        ArrayList arrayList2 = this.r;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = this.s;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList arrayList4 = new ArrayList();
        this.s = arrayList4;
        arrayList4.addAll(this.r);
        int i2 = 3;
        String str = "0";
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            ArrayList arrayList5 = this.r;
            if (arrayList5 != null && arrayList5.size() >= 3) {
                arrayList = this.r;
                i2 = 2;
                str = ((LiveStreamCategoryIdDBModel) arrayList.get(i2)).getLiveStreamCategoryID();
                string = ((LiveStreamCategoryIdDBModel) this.r.get(i2)).getLiveStreamCategoryName();
            }
            string = this.d.getResources().getString(a7.j.x);
        } else {
            ArrayList arrayList6 = this.r;
            if (arrayList6 != null && arrayList6.size() >= 4) {
                arrayList = this.r;
                str = ((LiveStreamCategoryIdDBModel) arrayList.get(i2)).getLiveStreamCategoryID();
                string = ((LiveStreamCategoryIdDBModel) this.r.get(i2)).getLiveStreamCategoryName();
            }
            string = this.d.getResources().getString(a7.j.x);
        }
        h2(str, string);
        ArrayList arrayList7 = this.s;
        if (arrayList7 != null && arrayList7.size() > 0) {
            VodAllCategoriesSingleton.getInstance().setLiveCategoriesList(this.s);
        }
        s sVar = new s(this.d, this.k0, str);
        this.m = sVar;
        this.R.setAdapter(sVar);
        this.R.setLayoutManager(this.k);
    }

    public final void t2() {
        try {
            new a(this).show();
        } catch (Exception unused) {
        }
    }

    public void u1() {
        try {
            ArrayList arrayList = this.y;
            if (arrayList == null || arrayList.size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setLiveList((ArrayList) null);
                t tVar = new t(this.d, "live", this.i0, this.j0, this.r0);
                this.l = tVar;
                this.S.setAdapter(tVar);
                v2(getResources().getString(a7.j.g4));
                return;
            }
            VodAllCategoriesSingleton.getInstance().setLiveList(this.y);
            t tVar2 = new t(this.d, "live", this.i0, this.j0, this.r0);
            this.l = tVar2;
            this.S.setAdapter(tVar2);
            RelativeLayout relativeLayout = this.M;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.S.setLayoutManager(this.j);
            u2();
        } catch (Exception unused) {
        }
    }

    public void u2() {
        LinearLayout linearLayout = this.T;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.T.setVisibility(0);
    }

    public void v0(String str) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.L.i(this.l0, this.m0);
        } catch (Exception unused) {
        }
    }

    public final void v1() {
        try {
            ArrayList arrayList = this.y;
            if (arrayList == null || arrayList.size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setLiveList((ArrayList) null);
                Menu menu = this.F;
                if (menu != null) {
                    menu.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
                }
                t tVar = new t(this.d, "live", this.i0, this.j0, this.r0);
                this.l = tVar;
                this.S.setAdapter(tVar);
                v2(getResources().getString(a7.j.g4));
                return;
            }
            VodAllCategoriesSingleton.getInstance().setLiveList(this.y);
            Menu menu2 = this.F;
            if (menu2 != null) {
                menu2.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
            t tVar2 = new t(this.d, "live", this.i0, this.j0, this.r0);
            this.l = tVar2;
            this.S.setAdapter(tVar2);
            RelativeLayout relativeLayout = this.M;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.S.setLayoutManager(this.j);
            u2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void v2(String str) {
        TextView textView = this.V;
        if (textView != null) {
            textView.setText(str);
            this.V.setVisibility(0);
        }
    }

    public final void w2() {
        LinearLayout linearLayout = this.U;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.U.setVisibility(0);
    }

    public final void x2() {
        if (this.M.getVisibility() == 8) {
            this.O.setVisibility(8);
            this.h0.setVisibility(8);
            this.Q.startAnimation(this.i);
            this.Q.setVisibility(0);
            this.Q.requestFocus();
            this.M.startAnimation(this.e);
            this.M.setVisibility(0);
            this.N.startAnimation(this.g);
            this.N.setVisibility(0);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 5);
            this.j = gridLayoutManager;
            this.S.setLayoutManager(gridLayoutManager);
            if (this.l != null) {
                this.S.m1(this.K);
                this.K = -1;
            }
        }
    }

    public void y0(String str) {
    }

    public final void z2() {
        this.e = AnimationUtils.loadAnimation(this.d, a7.b.b);
        this.f = AnimationUtils.loadAnimation(this.d, a7.b.c);
        this.g = AnimationUtils.loadAnimation(this.d, a7.b.g);
        this.h = AnimationUtils.loadAnimation(this.d, a7.b.e);
        this.i = AnimationUtils.loadAnimation(this.d, a7.b.a);
    }

    public void I(m0.x xVar, int i2) {
    }

    public void O(Z.E e2, int i2) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i2) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
