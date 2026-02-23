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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
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
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetVODByCatPojo2;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.squareup.picasso.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import m7.w;
import p7.B1;
import p7.C1;
import q7.Z;
import q7.l0;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VodAllDataSingleActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.g {
    public ArrayList A;
    public SharedPreferences D;
    public SharedPreferences.Editor E;
    public Menu F;
    public MenuItem G;
    public SearchView H;
    public n7.e L;
    public RelativeLayout N;
    public RelativeLayout O;
    public ImageView P;
    public RelativeLayout Q;
    public ImageView R;
    public RecyclerView S;
    public RecyclerView T;
    public LinearLayout U;
    public LinearLayout V;
    public TextView W;
    public TextView X;
    public EditText Y;
    public LinearLayout Z;
    public Context d;
    public Animation e;
    public Toolbar e0;
    public Animation f;
    public AppBarLayout f0;
    public Animation g;
    public ImageView g0;
    public Animation h;
    public ImageView h0;
    public Animation i;
    public RelativeLayout i0;
    public GridLayoutManager j;
    public ImageView j0;
    public LinearLayoutManager k;
    public NestedScrollView k0;
    public m0 l;
    public l0 m;
    public RecentWatchDBHandler n;
    public ArrayList o;
    public ArrayList p;
    public LiveStreamDBHandler q;
    public ArrayList r;
    public Handler r0;
    public ArrayList s;
    public Runnable s0;
    public ArrayList t;
    public DatabaseHandler w;
    public ArrayList x;
    public ArrayList y;
    public ArrayList z;
    public int u = -1;
    public ArrayList v = new ArrayList();
    public ArrayList B = new ArrayList();
    public ArrayList C = new ArrayList();
    public String I = "0";
    public String J = "0";
    public int K = -1;
    public boolean M = true;
    public String l0 = "";
    public String m0 = "";
    public int n0 = 1;
    public int o0 = 0;
    public int p0 = 0;
    public int q0 = 0;
    public int t0 = 0;
    public boolean u0 = false;
    public int v0 = 0;

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
                VodAllDataSingleActivity.this.v2();
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
                    VodAllDataSingleActivity.L1(VodAllDataSingleActivity.this).updateAllRecordsRecentWatchDB();
                    VodAllDataSingleActivity.this.A2();
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
            setContentView(new u7.a(VodAllDataSingleActivity.P1(VodAllDataSingleActivity.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.f = findViewById(a7.f.V8);
            this.g = findViewById(a7.f.Ia);
            TextView findViewById = findViewById(a7.f.um);
            this.e = findViewById;
            findViewById.setText(VodAllDataSingleActivity.this.getResources().getString(a7.j.W8));
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
            view.setBackground(VodAllDataSingleActivity.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (VodAllDataSingleActivity.y1(VodAllDataSingleActivity.this) != null) {
                VodAllDataSingleActivity.y1(VodAllDataSingleActivity.this).getFilter().filter(charSequence.toString());
            }
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
            String str;
            Activity activity;
            int id = view.getId();
            if (id == a7.f.u1) {
                try {
                    String charSequence = findViewById(this.g.getCheckedRadioButtonId()).getText().toString();
                    if (charSequence.equals(this.h.getResources().getString(a7.j.i7))) {
                        str = "1";
                        activity = this.h;
                    } else if (charSequence.equals(this.h.getResources().getString(a7.j.f7))) {
                        str = "2";
                        activity = this.h;
                    } else if (charSequence.equals(this.h.getResources().getString(a7.j.k7))) {
                        str = "3";
                        activity = this.h;
                    } else if (charSequence.equals(this.h.getResources().getString(a7.j.j7))) {
                        str = "6";
                        activity = this.h;
                    } else {
                        str = "0";
                        activity = this.h;
                    }
                    SharepreferenceDBHandler.setVODSubCatSort(str, activity);
                    VodAllDataSingleActivity vodAllDataSingleActivity = VodAllDataSingleActivity.this;
                    vodAllDataSingleActivity.t2(VodAllDataSingleActivity.O1(vodAllDataSingleActivity), VodAllDataSingleActivity.M1(VodAllDataSingleActivity.this));
                    dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (id == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            RadioButton findViewById;
            RadioButton findViewById2;
            RadioButton findViewById3;
            RadioButton findViewById4;
            RadioButton findViewById5;
            super.onCreate(bundle);
            setContentView(new u7.a(this.h).A().equals(m7.a.K0) ? a7.g.A3 : a7.g.z3);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.d = findViewById(a7.f.h1);
            this.e = findViewById(a7.f.V8);
            this.f = findViewById(a7.f.Ia);
            this.g = findViewById(a7.f.Kd);
            findViewById = findViewById(a7.f.rd);
            findViewById2 = findViewById(a7.f.md);
            findViewById3 = findViewById(a7.f.fd);
            findViewById4 = findViewById(a7.f.zd);
            RadioButton findViewById6 = findViewById(a7.f.gd);
            RadioButton findViewById7 = findViewById(a7.f.hd);
            findViewById5 = findViewById(a7.f.td);
            findViewById5.setVisibility(8);
            findViewById6.setVisibility(8);
            findViewById7.setVisibility(8);
            String vODSubCatSort = SharepreferenceDBHandler.getVODSubCatSort(this.h);
            vODSubCatSort.hashCode();
            switch (vODSubCatSort) {
                case "1":
                    findViewById2.setChecked(true);
                    break;
                case "2":
                    findViewById3.setChecked(true);
                    break;
                case "3":
                    findViewById4.setChecked(true);
                    break;
                case "6":
                    findViewById5.setChecked(true);
                    break;
                default:
                    findViewById.setChecked(true);
                    break;
            }
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class e implements Comparator {
        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LiveStreamsDBModel liveStreamsDBModel, LiveStreamsDBModel liveStreamsDBModel2) {
            float f;
            float f2 = 0.0f;
            try {
                f = Float.parseFloat(liveStreamsDBModel2.getRatingFromTen());
            } catch (Exception unused) {
                f = 0.0f;
            }
            try {
                f2 = Float.parseFloat(liveStreamsDBModel.getRatingFromTen());
            } catch (Exception unused2) {
            }
            return Float.compare(f, f2);
        }
    }

    public class f implements NestedScrollView.c {
        public f() {
        }

        public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            String str;
            String O1;
            String str2;
            String str3 = "";
            StringBuilder sb = new StringBuilder();
            sb.append("scrollY :");
            sb.append(i2);
            sb.append(" a:");
            int i5 = 0;
            sb.append(nestedScrollView.getChildAt(0).getMeasuredHeight());
            sb.append(" b:");
            sb.append(nestedScrollView.getMeasuredHeight());
            Log.e("honey", sb.toString());
            if (i2 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                VodAllDataSingleActivity.this.n0++;
                Log.e("honey", "onScrollChange page:" + VodAllDataSingleActivity.this.n0 + " Total:" + VodAllDataSingleActivity.this.o0);
                VodAllDataSingleActivity vodAllDataSingleActivity = VodAllDataSingleActivity.this;
                if (vodAllDataSingleActivity.n0 <= vodAllDataSingleActivity.o0) {
                    VodAllDataSingleActivity.B1(vodAllDataSingleActivity, false);
                    w.M0(VodAllDataSingleActivity.this);
                    if (VodAllDataSingleActivity.C1(VodAllDataSingleActivity.this) != null) {
                        str = VodAllDataSingleActivity.C1(VodAllDataSingleActivity.this).getQuery().toString();
                        try {
                            i5 = VodAllDataSingleActivity.C1(VodAllDataSingleActivity.this).getQuery().toString().length();
                        } catch (Exception unused) {
                        }
                    } else {
                        str = "";
                    }
                    String str4 = str;
                    if (i5 < 3) {
                        if (VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this).equals("-1")) {
                            VodAllDataSingleActivity.E1(VodAllDataSingleActivity.this);
                            return;
                        } else {
                            VodAllDataSingleActivity.F1(VodAllDataSingleActivity.this);
                            return;
                        }
                    }
                    if (VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this).equals("0")) {
                        str2 = str3;
                        O1 = "*";
                    } else if (VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this).equals("-1")) {
                        str3 = "1";
                        str2 = str3;
                        O1 = "*";
                    } else {
                        O1 = VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this);
                        str2 = "";
                    }
                    try {
                        n7.e D1 = VodAllDataSingleActivity.D1(VodAllDataSingleActivity.this);
                        VodAllDataSingleActivity vodAllDataSingleActivity2 = VodAllDataSingleActivity.this;
                        D1.u(vodAllDataSingleActivity2.l0, vodAllDataSingleActivity2.m0, O1, str4, str2, String.valueOf(vodAllDataSingleActivity2.n0));
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    public class g implements SearchView.m {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            public void run() {
                String str = "*";
                String str2 = "";
                if (!VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this).equals("0")) {
                    if (VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this).equals("-1")) {
                        str2 = "1";
                    } else {
                        str = VodAllDataSingleActivity.O1(VodAllDataSingleActivity.this);
                    }
                }
                String str3 = str;
                String str4 = str2;
                VodAllDataSingleActivity.J1(VodAllDataSingleActivity.this, new ArrayList());
                VodAllDataSingleActivity vodAllDataSingleActivity = VodAllDataSingleActivity.this;
                vodAllDataSingleActivity.K = 0;
                VodAllDataSingleActivity.B1(vodAllDataSingleActivity, true);
                VodAllDataSingleActivity vodAllDataSingleActivity2 = VodAllDataSingleActivity.this;
                vodAllDataSingleActivity2.n0 = 1;
                VodAllDataSingleActivity.Q1(vodAllDataSingleActivity2);
                VodAllDataSingleActivity.this.j2();
                VodAllDataSingleActivity.this.f2();
                try {
                    Log.e("honey", "request:" + this.a);
                    n7.e D1 = VodAllDataSingleActivity.D1(VodAllDataSingleActivity.this);
                    VodAllDataSingleActivity vodAllDataSingleActivity3 = VodAllDataSingleActivity.this;
                    D1.u(vodAllDataSingleActivity3.l0, vodAllDataSingleActivity3.m0, str3, this.a, str4, String.valueOf(vodAllDataSingleActivity3.n0));
                } catch (Exception unused) {
                }
            }
        }

        public g() {
        }

        public boolean onQueryTextChange(String str) {
            if (VodAllDataSingleActivity.N1(VodAllDataSingleActivity.this) == null) {
                return false;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(VodAllDataSingleActivity.P1(VodAllDataSingleActivity.this)).equals("stalker_api")) {
                VodAllDataSingleActivity.N1(VodAllDataSingleActivity.this).getFilter().filter(str);
                return false;
            }
            try {
                if (str.length() >= 3) {
                    Handler handler = VodAllDataSingleActivity.this.r0;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                    VodAllDataSingleActivity.this.s0 = new a(str);
                    VodAllDataSingleActivity vodAllDataSingleActivity = VodAllDataSingleActivity.this;
                    vodAllDataSingleActivity.r0.postDelayed(vodAllDataSingleActivity.s0, 1000L);
                    return false;
                }
                Handler handler2 = VodAllDataSingleActivity.this.r0;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages((Object) null);
                }
                if (VodAllDataSingleActivity.I1(VodAllDataSingleActivity.this) == null || VodAllDataSingleActivity.K1(VodAllDataSingleActivity.this) == null || VodAllDataSingleActivity.K1(VodAllDataSingleActivity.this).size() <= 0) {
                    return false;
                }
                VodAllDataSingleActivity vodAllDataSingleActivity2 = VodAllDataSingleActivity.this;
                vodAllDataSingleActivity2.K = -1;
                VodAllDataSingleActivity.B1(vodAllDataSingleActivity2, true);
                VodAllDataSingleActivity vodAllDataSingleActivity3 = VodAllDataSingleActivity.this;
                vodAllDataSingleActivity3.n0 = 1;
                VodAllDataSingleActivity.I1(vodAllDataSingleActivity3).clear();
                VodAllDataSingleActivity.I1(VodAllDataSingleActivity.this).addAll(VodAllDataSingleActivity.K1(VodAllDataSingleActivity.this));
                VodAllDataSingleActivity vodAllDataSingleActivity4 = VodAllDataSingleActivity.this;
                vodAllDataSingleActivity4.o0 = vodAllDataSingleActivity4.q0;
                vodAllDataSingleActivity4.w1(true);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class h extends AsyncTask {
        public h() {
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
                r1 = r7[r0]     // Catch: java.lang.Exception -> L60
                int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L60
                r3 = 3
                r4 = 2
                r5 = 1
                switch(r2) {
                    case -74801864: goto L2b;
                    case -74797390: goto L22;
                    case 1976766565: goto L18;
                    case 1997009972: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L60
            Ld:
                goto L35
            Le:
                java.lang.String r0 = "get_recent_watch"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L60
                if (r0 == 0) goto L35
                r0 = 2
                goto L36
            L18:
                java.lang.String r0 = "get_recent_added"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L60
                if (r0 == 0) goto L35
                r0 = 3
                goto L36
            L22:
                java.lang.String r2 = "get_fav"
                boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L60
                if (r1 == 0) goto L35
                goto L36
            L2b:
                java.lang.String r0 = "get_all"
                boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L60
                if (r0 == 0) goto L35
                r0 = 1
                goto L36
            L35:
                r0 = -1
            L36:
                if (r0 == 0) goto L59
                if (r0 == r5) goto L50
                if (r0 == r4) goto L49
                if (r0 == r3) goto L40
                r7 = 0
                return r7
            L40:
                com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity r0 = com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                r7 = r7[r5]     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r0.c2(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L49:
                com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.z1(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L50:
                com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity r0 = com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                r7 = r7[r5]     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r0.X1(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L59:
                com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r7.Z1()     // Catch: java.lang.Exception -> L60
                return r7
            L60:
                java.lang.String r7 = "error"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.h.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            VodAllDataSingleActivity.this.g2();
            str.hashCode();
            switch (str) {
                case "get_fav_local":
                    VodAllDataSingleActivity.this.U1();
                    break;
                case "get_all":
                    VodAllDataSingleActivity.this.w1(false);
                    break;
                case "get_fav_real_time":
                    VodAllDataSingleActivity.this.V1();
                    break;
                case "get_recent_watch":
                    VodAllDataSingleActivity.A1(VodAllDataSingleActivity.this);
                    break;
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            VodAllDataSingleActivity.Q1(VodAllDataSingleActivity.this);
            VodAllDataSingleActivity.this.j2();
            VodAllDataSingleActivity.this.f2();
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
            Drawable drawable;
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
                        drawable = VodAllDataSingleActivity.this.getResources().getDrawable(a7.c.i);
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
                    resources = VodAllDataSingleActivity.this.getResources();
                    i = a7.e.O0;
                    drawable = F.h.f(resources, i, VodAllDataSingleActivity.this.getTheme());
                } else {
                    resources = VodAllDataSingleActivity.this.getResources();
                    i = a7.c.s;
                    drawable = F.h.f(resources, i, VodAllDataSingleActivity.this.getTheme());
                }
            } else {
                resources = VodAllDataSingleActivity.this.getResources();
                i = a7.e.O0;
                drawable = F.h.f(resources, i, VodAllDataSingleActivity.this.getTheme());
            }
            view.setBackground(drawable);
        }
    }

    public class j extends AsyncTask {
        public j() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return VodAllDataSingleActivity.G1(VodAllDataSingleActivity.this);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            VodAllDataSingleActivity.H1(VodAllDataSingleActivity.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ void A1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        vodAllDataSingleActivity.x1();
    }

    public static /* synthetic */ boolean B1(VodAllDataSingleActivity vodAllDataSingleActivity, boolean z) {
        vodAllDataSingleActivity.M = z;
        return z;
    }

    private void B2(String str) {
        l0 l0Var = this.m;
        if (l0Var != null) {
            l0Var.z0(str);
        }
    }

    public static /* synthetic */ SearchView C1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.H;
    }

    public static /* synthetic */ n7.e D1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.L;
    }

    public static /* synthetic */ void E1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        vodAllDataSingleActivity.N2();
    }

    public static /* synthetic */ void F1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        vodAllDataSingleActivity.M2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r0.size() >= 3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r3 = ((com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r5.s.get(2)).getLiveStreamCategoryID();
        r0 = r5.s.get(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r0.size() >= 3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F2() {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto Lc2
            int r0 = r0.size()
            if (r0 <= 0) goto Lc2
            java.util.ArrayList r0 = r5.t
            if (r0 == 0) goto L11
            r0.clear()
        L11:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.t = r0
            java.util.ArrayList r1 = r5.s
            r0.addAll(r1)
            android.content.Context r0 = r5.d
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r0)
            java.lang.String r1 = "m3u"
            boolean r0 = r0.equals(r1)
            r1 = 3
            r2 = 2
            java.lang.String r3 = "0"
            if (r0 == 0) goto L62
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto L55
            int r0 = r0.size()
            if (r0 < r1) goto L55
        L39:
            java.util.ArrayList r0 = r5.s
            java.lang.Object r0 = r0.get(r2)
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r3 = r0.getLiveStreamCategoryID()
            java.util.ArrayList r0 = r5.s
            java.lang.Object r0 = r0.get(r2)
        L4b:
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r0 = r0.getLiveStreamCategoryName()
        L51:
            r5.t2(r3, r0)
            goto L9a
        L55:
            android.content.Context r0 = r5.d
            android.content.res.Resources r0 = r0.getResources()
            int r1 = a7.j.x
            java.lang.String r0 = r0.getString(r1)
            goto L51
        L62:
            android.content.Context r0 = r5.d
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r0)
            java.lang.String r4 = "stalker_api"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L7b
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto L55
            int r0 = r0.size()
            if (r0 < r1) goto L55
            goto L39
        L7b:
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto L55
            int r0 = r0.size()
            r1 = 5
            if (r0 < r1) goto L55
            java.util.ArrayList r0 = r5.s
            r1 = 4
            java.lang.Object r0 = r0.get(r1)
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r3 = r0.getLiveStreamCategoryID()
            java.util.ArrayList r0 = r5.s
            java.lang.Object r0 = r0.get(r1)
            goto L4b
        L9a:
            java.util.ArrayList r0 = r5.t
            if (r0 == 0) goto Lad
            int r0 = r0.size()
            if (r0 <= 0) goto Lad
            com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton r0 = com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton.getInstance()
            java.util.ArrayList r1 = r5.t
            r0.setVodCategoriesList(r1)
        Lad:
            q7.l0 r0 = new q7.l0
            android.content.Context r1 = r5.d
            r0.<init>(r1, r3)
            r5.m = r0
            androidx.recyclerview.widget.RecyclerView r1 = r5.S
            r1.setAdapter(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r5.S
            androidx.recyclerview.widget.LinearLayoutManager r1 = r5.k
            r0.setLayoutManager(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.F2():void");
    }

    public static /* synthetic */ Boolean G1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.P2();
    }

    private void G2() {
        try {
            new a(this.d).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void H1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        vodAllDataSingleActivity.F2();
    }

    public static /* synthetic */ ArrayList I1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.z;
    }

    private void I2() {
        LinearLayout linearLayout = this.V;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.V.setVisibility(0);
    }

    public static /* synthetic */ ArrayList J1(VodAllDataSingleActivity vodAllDataSingleActivity, ArrayList arrayList) {
        vodAllDataSingleActivity.z = arrayList;
        return arrayList;
    }

    private void J2() {
        if (this.N.getVisibility() == 8) {
            this.P.setVisibility(8);
            if (!new u7.a(this.d).A().equals(m7.a.K0)) {
                this.j0.setVisibility(8);
            }
            this.R.startAnimation(this.i);
            this.R.setVisibility(0);
            this.R.requestFocus();
            this.N.startAnimation(this.e);
            this.N.setVisibility(0);
            this.O.startAnimation(this.g);
            this.O.setVisibility(0);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 5);
            this.j = gridLayoutManager;
            this.T.setLayoutManager(gridLayoutManager);
            if (this.l != null) {
                this.T.m1(this.K);
                this.K = -1;
            }
        }
    }

    public static /* synthetic */ ArrayList K1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.A;
    }

    private void K2(Activity activity) {
        try {
            new d(this, activity).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ RecentWatchDBHandler L1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.n;
    }

    public static /* synthetic */ String M1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.J;
    }

    public static /* synthetic */ m0 N1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.l;
    }

    public static /* synthetic */ String O1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.I;
    }

    private void O2() {
        this.e = AnimationUtils.loadAnimation(this.d, a7.b.b);
        this.f = AnimationUtils.loadAnimation(this.d, a7.b.c);
        this.g = AnimationUtils.loadAnimation(this.d, a7.b.g);
        this.h = AnimationUtils.loadAnimation(this.d, a7.b.e);
        this.i = AnimationUtils.loadAnimation(this.d, a7.b.a);
    }

    public static /* synthetic */ Context P1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.d;
    }

    public static /* synthetic */ void Q1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        vodAllDataSingleActivity.I2();
    }

    private void R1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void T1() {
        EditText editText = this.Y;
        if (editText != null) {
            editText.setText("");
            this.Y.clearFocus();
        }
    }

    private void W1() {
        ImageView imageView = this.R;
        imageView.setOnFocusChangeListener(new i(imageView));
        RelativeLayout relativeLayout = this.Q;
        relativeLayout.setOnFocusChangeListener(new i(relativeLayout));
        ImageView imageView2 = this.P;
        imageView2.setOnFocusChangeListener(new i(imageView2));
    }

    private ArrayList a2() {
        ArrayList allPasswordStatus = this.q.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.r = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.v.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.v;
    }

    private String b2() {
        this.v = new ArrayList();
        new ArrayList();
        this.C = new ArrayList();
        ArrayList allVodContiueWatching = this.n.getAllVodContiueWatching("getalldata", "1");
        if (this.q.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.d)) <= 0) {
            this.C = allVodContiueWatching;
            return "get_recent_watch";
        }
        this.v = a2();
        Iterator it = allVodContiueWatching.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            Iterator it2 = this.v.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.C.add(liveStreamsDBModel);
                    break;
                }
                String str = (String) it2.next();
                if (liveStreamsDBModel.getCategoryId() == null || !liveStreamsDBModel.getCategoryId().equals(str)) {
                }
            }
        }
        return "get_recent_watch";
    }

    public static void d2(Activity activity) {
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

    private void h2() {
        if (this.N.getVisibility() == 0) {
            d2(this);
            this.O.startAnimation(this.h);
            this.O.setVisibility(0);
            this.N.startAnimation(this.f);
            this.N.setVisibility(8);
            this.P.startAnimation(this.i);
            this.P.setVisibility(0);
            if (!new u7.a(this.d).A().equals(m7.a.K0)) {
                this.j0.setVisibility(0);
            }
            this.P.requestFocus();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 7);
            this.j = gridLayoutManager;
            this.T.setLayoutManager(gridLayoutManager);
        }
    }

    private void k2() {
        this.N = findViewById(a7.f.ye);
        this.O = findViewById(a7.f.hf);
        this.P = findViewById(a7.f.l5);
        this.Q = findViewById(a7.f.if);
        this.R = findViewById(a7.f.U4);
        this.S = findViewById(a7.f.Fd);
        this.T = findViewById(a7.f.Dd);
        this.U = findViewById(a7.f.W9);
        this.V = findViewById(a7.f.I8);
        this.W = findViewById(a7.f.wk);
        this.X = findViewById(a7.f.Zj);
        this.Y = findViewById(a7.f.m3);
        this.Z = findViewById(a7.f.W8);
        this.e0 = findViewById(a7.f.kh);
        this.f0 = findViewById(a7.f.W);
        this.g0 = findViewById(a7.f.Xa);
        this.h0 = findViewById(a7.f.G4);
        this.i0 = findViewById(a7.f.se);
        this.j0 = findViewById(a7.f.H4);
    }

    private void l2() {
        this.r0 = new Handler();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new LiveStreamDBHandler(this.d);
        this.r = new ArrayList();
        this.t = new ArrayList();
        this.s = new ArrayList();
        this.n = new RecentWatchDBHandler(this.d);
        this.k = new LinearLayoutManager(this.d);
        this.w = new DatabaseHandler(this.d);
        this.L = new n7.e(this, this.d);
        this.z = new ArrayList();
        this.A = new ArrayList();
        SharedPreferences sharedPreferences = getSharedPreferences("showhidemoviename", 0);
        this.D = sharedPreferences;
        this.E = sharedPreferences.edit();
        w.y(this.d);
        if (new u7.a(this.d).A().equals(m7.a.K0)) {
            this.h0.setVisibility(8);
        } else {
            this.h0.setVisibility(0);
        }
        W1();
        O2();
        x2();
        y2();
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            r2();
            return;
        }
        try {
            this.m0 = SharepreferenceDBHandler.getStalkerToken(this.d);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
            this.l0 = loggedInMacAddress;
            this.L.f(loggedInMacAddress, this.m0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void m2(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static /* synthetic */ void n2(Dialog dialog, View view) {
        dialog.dismiss();
    }

    private boolean o2() {
        EditText editText = this.Y;
        return editText != null && editText.getText().toString().length() > 0;
    }

    private void s2() {
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        LinearLayout findViewById3 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new B1(dialog));
        findViewById3.setOnClickListener(new C1(dialog));
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
                        t.q(this.d).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        t.q(this.d).l((String) a2.get(0)).g(findViewById);
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

    public static /* synthetic */ void u1(Dialog dialog, View view) {
        n2(dialog, view);
    }

    public static /* synthetic */ void v1(Dialog dialog, View view) {
        m2(dialog, view);
    }

    private void x1() {
        ArrayList arrayList = this.C;
        if (arrayList == null || arrayList.size() <= 0) {
            VodAllCategoriesSingleton.getInstance().setVodList((ArrayList) null);
            VodAllCategoriesSingleton.getInstance().setContinueWatchingList((ArrayList) null);
            Menu menu = this.F;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            }
            m0 m0Var = new m0(this.d, "continue_watching", this.K);
            this.l = m0Var;
            this.T.setAdapter(m0Var);
            H2(getResources().getString(a7.j.t4));
            return;
        }
        VodAllCategoriesSingleton.getInstance().setContinueWatchingList(this.C);
        if (this.F != null) {
            ArrayList arrayList2 = this.C;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                this.F.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            } else {
                this.F.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
        }
        VodAllCategoriesSingleton.getInstance().setVodList(this.C);
        m0 m0Var2 = new m0(this.d, "continue_watching", this.K);
        this.l = m0Var2;
        this.T.setAdapter(m0Var2);
        RelativeLayout relativeLayout = this.N;
        this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
        this.T.setLayoutManager(this.j);
        L2();
    }

    private void x2() {
        this.R.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.g0.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.h0.setOnClickListener(this);
        this.j0.setOnClickListener(this);
    }

    public static /* synthetic */ l0 y1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.m;
    }

    private void y2() {
        EditText editText = this.Y;
        if (editText != null) {
            editText.addTextChangedListener(new c());
        }
    }

    public static /* synthetic */ String z1(VodAllDataSingleActivity vodAllDataSingleActivity) {
        return vodAllDataSingleActivity.b2();
    }

    public void A2() {
        w.n = new h().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_recent_watch", "-4"});
    }

    public void C2(String str) {
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void D2(int i2) {
        this.K = i2;
    }

    public void E2(int i2) {
        this.v0 = i2;
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
        r2();
    }

    public void H2(String str) {
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(str);
            this.W.setVisibility(0);
        }
    }

    public void L2() {
        LinearLayout linearLayout = this.U;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.U.setVisibility(0);
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        r2();
    }

    public final void M2() {
        try {
            this.L.n(this.l0, this.m0, this.I.equals("0") ? "*" : this.I, String.valueOf(this.n0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N2() {
        try {
            this.L.o(this.l0, this.m0, String.valueOf(this.n0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void P0(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9 A[Catch: Exception -> 0x0183, NullPointerException -> 0x0186, TRY_ENTER, TryCatch #2 {NullPointerException -> 0x0186, Exception -> 0x0183, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000c, B:8:0x000f, B:12:0x0047, B:14:0x007c, B:17:0x0088, B:18:0x00a1, B:19:0x00da, B:22:0x00f9, B:23:0x0132, B:24:0x0138, B:26:0x0146, B:27:0x00a9, B:30:0x00b6, B:33:0x00c2, B:34:0x0041, B:35:0x0180), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0138 A[Catch: Exception -> 0x0183, NullPointerException -> 0x0186, TryCatch #2 {NullPointerException -> 0x0186, Exception -> 0x0183, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000c, B:8:0x000f, B:12:0x0047, B:14:0x007c, B:17:0x0088, B:18:0x00a1, B:19:0x00da, B:22:0x00f9, B:23:0x0132, B:24:0x0138, B:26:0x0146, B:27:0x00a9, B:30:0x00b6, B:33:0x00c2, B:34:0x0041, B:35:0x0180), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean P2() {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.P2():java.lang.Boolean");
    }

    public boolean S1() {
        m0 m0Var = this.l;
        if (m0Var != null) {
            return m0Var.h1();
        }
        return false;
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void U1() {
        try {
            ArrayList arrayList = this.B;
            if (arrayList == null || arrayList.size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setVodList((ArrayList) null);
                w2();
                m0 m0Var = new m0(this.d, "vod", this.K);
                this.l = m0Var;
                this.T.setAdapter(m0Var);
                H2(getResources().getString(a7.j.m4));
                return;
            }
            VodAllCategoriesSingleton.getInstance().setVodList(this.B);
            m0 m0Var2 = new m0(this.d, "vod", this.K);
            this.l = m0Var2;
            this.T.setAdapter(m0Var2);
            RelativeLayout relativeLayout = this.N;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.T.setLayoutManager(this.j);
            L2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void V1() {
        try {
            if (VodAllCategoriesSingleton.getInstance().getVodFavList() == null || VodAllCategoriesSingleton.getInstance().getVodFavList().size() <= 0) {
                VodAllCategoriesSingleton.getInstance().setVodList((ArrayList) null);
                m0 m0Var = new m0(this.d, "vod", this.K);
                this.l = m0Var;
                m0Var.p1(null);
                this.T.setAdapter(this.l);
                j2();
                H2(getResources().getString(a7.j.m4));
                return;
            }
            m0 m0Var2 = new m0(this.d, "vod", this.K);
            this.l = m0Var2;
            m0Var2.p1(null);
            this.T.setAdapter(this.l);
            RelativeLayout relativeLayout = this.N;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.T.setLayoutManager(this.j);
            f2();
            L2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String X1(String str) {
        try {
            this.x = new ArrayList();
            this.o = new ArrayList();
            this.y = new ArrayList();
            this.z = this.q.getAllLiveStreasWithCategoryId(str, "movie");
            return "get_all";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_all";
        }
    }

    public void Y1() {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            return;
        }
        m7.a.i1 = true;
        s2();
    }

    public String Z1() {
        LiveStreamsDBModel liveStreamFavouriteRow;
        ArrayList arrayList;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                new ArrayList();
                this.B.clear();
                ArrayList favouriteM3U = this.q.getFavouriteM3U("movie");
                if (this.v != null) {
                    this.v = a2();
                }
                ArrayList arrayList2 = this.v;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = MyApplication.s(favouriteM3U, this.v);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return "get_fav_local";
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.q.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        this.B.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
                return "get_fav_local";
            }
            new ArrayList();
            this.B.clear();
            ArrayList allFavourites = this.w.getAllFavourites("vod", SharepreferenceDBHandler.getUserID(this.d));
            if (this.v != null) {
                this.v = a2();
            }
            ArrayList arrayList3 = this.v;
            if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                allFavourites = MyApplication.r(allFavourites, this.v);
            }
            if (allFavourites == null || allFavourites.size() <= 0) {
                return "get_fav_local";
            }
            Iterator it2 = allFavourites.iterator();
            while (it2.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    liveStreamFavouriteRow = this.q.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamIDOneStream()), favouriteDBModel.getTimestamp(), "");
                    if (liveStreamFavouriteRow != null) {
                        arrayList = this.B;
                        arrayList.add(liveStreamFavouriteRow);
                    }
                } else {
                    liveStreamFavouriteRow = this.q.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), "");
                    if (liveStreamFavouriteRow != null) {
                        arrayList = this.B;
                        arrayList.add(liveStreamFavouriteRow);
                    }
                }
            }
            if (!SharepreferenceDBHandler.getVODSubCatSort(this.d).equalsIgnoreCase("6")) {
                return "get_fav_local";
            }
            Collections.sort(this.B, new e());
            return "get_fav_local";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav_local";
        }
    }

    public void c(String str) {
    }

    public String c2(String str) {
        try {
            this.x = new ArrayList();
            this.o = new ArrayList();
            this.y = new ArrayList();
            this.z = this.q.getAllLiveStreasWithCategoryId(str, "movie");
            return "get_all";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_all";
        }
    }

    public void e(String str) {
    }

    public void e0(String str) {
        try {
            w.X();
            g2();
        } catch (Exception unused) {
        }
    }

    public void e2() {
        LinearLayout linearLayout = this.Z;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f2() {
        TextView textView = this.W;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.W.setVisibility(8);
    }

    public void g2() {
        LinearLayout linearLayout = this.V;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.V.setVisibility(8);
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j2() {
        LinearLayout linearLayout = this.U;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.U.setVisibility(8);
    }

    public void o0(String str) {
    }

    public void onBackPressed() {
        if (o2()) {
            T1();
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.U4) {
            h2();
            return;
        }
        if (id == a7.f.G4 || id == a7.f.H4) {
            onBackPressed();
            return;
        }
        if (id == a7.f.l5) {
            this.K = -1;
            J2();
        } else if (id == a7.f.Xa) {
            w.j(this.d);
        } else if (id == a7.f.if) {
            this.Y.requestFocus();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        i2();
        R1();
        this.d = this;
        if (SharepreferenceDBHandler.getCurrentAPPType(this).equals("stalker_api")) {
            setContentView(a7.g.M0);
            this.k0 = findViewById(a7.f.n4);
        } else {
            setContentView(a7.g.L0);
        }
        k2();
        Toolbar toolbar = this.e0;
        if (toolbar != null) {
            r1(toolbar);
        }
        m7.a.M0 = "-1";
        l2();
        if (m7.a.V0.booleanValue() && m7.a.e1.equalsIgnoreCase("1")) {
            if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
            } else {
                SharepreferenceDBHandler.setEventAdsView(0, this);
                Y1();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        Toolbar toolbar = this.e0;
        if (toolbar != null) {
            toolbar.x(a7.h.t);
            SharedPreferences sharedPreferences = this.D;
            if (sharedPreferences != null) {
                if (sharedPreferences.getInt("vod", 1) == 1) {
                    menu.getItem(1).getSubMenu().findItem(a7.f.w6).setVisible(false);
                    menu.getItem(1).getSubMenu().findItem(a7.f.s6).setVisible(true);
                } else {
                    menu.getItem(1).getSubMenu().findItem(a7.f.w6).setVisible(true);
                    menu.getItem(1).getSubMenu().findItem(a7.f.s6).setVisible(false);
                }
            }
            this.F = menu;
            TextView textView = this.X;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (this.I.equals("-5") || this.I.equals("-4") || SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                this.F.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(false);
            } else {
                this.F.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(true);
            }
            if (this.I.equals("-4")) {
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
        AsyncTask asyncTask = w.n;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        w.n.cancel(true);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        m0 m0Var;
        if (i2 != 21) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.N.getVisibility() != 8 || (m0Var = this.l) == null) {
            return false;
        }
        int i1 = m0Var.i1();
        this.K = i1;
        if (i1 % 7 != 0) {
            return false;
        }
        J2();
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.G = menuItem;
        this.e0.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.g) {
            try {
                SearchView actionView = menuItem.getActionView();
                this.H = actionView;
                if (actionView != null) {
                    actionView.setQueryHint(getResources().getString(a7.j.H6));
                    this.H.setIconifiedByDefault(false);
                    ImageView findViewById = this.H.findViewById(a7.f.Uf);
                    this.H.findViewById(a7.f.Vf).setImageResource(a7.e.m1);
                    findViewById.setImageResource(a7.e.m1);
                    findViewById.setPadding(15, 15, 15, 15);
                    findViewById.setBackground((Drawable) null);
                    this.H.setOnQueryTextListener(new g());
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (itemId == a7.f.mb) {
            K2(this);
        }
        if (itemId == a7.f.w6) {
            SharedPreferences.Editor editor = this.E;
            if (editor != null) {
                editor.putInt("vod", 1);
                this.E.commit();
            }
            Menu menu = this.F;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.w6).setVisible(false);
                this.F.getItem(1).getSubMenu().findItem(a7.f.s6).setVisible(true);
            }
            w2();
        }
        if (itemId == a7.f.s6) {
            SharedPreferences.Editor editor2 = this.E;
            if (editor2 != null) {
                editor2.putInt("vod", 0);
                this.E.commit();
            }
            Menu menu2 = this.F;
            if (menu2 != null) {
                menu2.getItem(1).getSubMenu().findItem(a7.f.w6).setVisible(true);
                this.F.getItem(1).getSubMenu().findItem(a7.f.s6).setVisible(false);
            }
            w2();
        }
        if (itemId == a7.f.Db && VodAllCategoriesSingleton.getInstance().getContinueWatchingList() != null && VodAllCategoriesSingleton.getInstance().getContinueWatchingList().size() > 0) {
            G2();
        }
        if (itemId == a7.f.gb) {
            w.A0(this.d);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        i2();
        super/*androidx.fragment.app.e*/.onResume();
        v2();
        w.z0(this.d);
        if (this.I.equals("-4")) {
            A2();
        } else {
            w2();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        i2();
    }

    public boolean p2() {
        EditText editText = this.Y;
        if (editText != null) {
            return editText.isFocused();
        }
        return false;
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
        SearchView searchView;
        ArrayList arrayList;
        SearchView searchView2;
        if (stalkerGetVODByCatCallback == null || stalkerGetVODByCatCallback.getJs() == null || stalkerGetVODByCatCallback.getJs().getData() == null || stalkerGetVODByCatCallback.getJs().getData().size() <= 0) {
            try {
                searchView = this.H;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int length = searchView != null ? searchView.getQuery().toString().length() : 0;
            if (length < 3) {
                try {
                    m7.a.M0 = stalkerGetVODByCatCallback.getJs().getTotalItems().toString();
                } catch (Exception unused) {
                }
            }
        } else {
            this.x = new ArrayList();
            this.o = new ArrayList();
            this.y = new ArrayList();
            this.o0 = w.v(stalkerGetVODByCatCallback.getJs().getTotalItems().intValue(), stalkerGetVODByCatCallback.getJs().getMaxPageItems().intValue());
            try {
                searchView2 = this.H;
            } catch (Exception unused2) {
            }
            int length2 = searchView2 != null ? searchView2.getQuery().toString().length() : 0;
            if (length2 < 3) {
                try {
                    m7.a.M0 = stalkerGetVODByCatCallback.getJs().getTotalItems().toString();
                } catch (Exception unused3) {
                }
            }
            for (int i2 = 0; i2 < stalkerGetVODByCatCallback.getJs().getData().size(); i2++) {
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getId());
                liveStreamsDBModel.setName(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getName());
                liveStreamsDBModel.setStreamType("movie");
                liveStreamsDBModel.setStreamId(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getId());
                liveStreamsDBModel.setStreamIcon(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getScreenshotUri());
                liveStreamsDBModel.setAdded(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getCategoryId());
                liveStreamsDBModel.setFav(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getFav());
                liveStreamsDBModel.setDirector(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getDirector());
                liveStreamsDBModel.setCast(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getActors());
                liveStreamsDBModel.setDescription(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getDescription());
                liveStreamsDBModel.setGenre(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getGenresStr());
                liveStreamsDBModel.setCmd(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getCmd());
                liveStreamsDBModel.setYear(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getYear());
                liveStreamsDBModel.setDurationMin(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getTime());
                liveStreamsDBModel.setRatingFromTen(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getRatingImdb().equals("N/A") ? "0" : ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getRatingImdb());
                this.z.add(liveStreamsDBModel);
            }
            ArrayList arrayList2 = this.z;
            if (arrayList2 != null && arrayList2.size() > 0 && (arrayList = this.A) != null && arrayList.size() == 0) {
                this.A.addAll(this.z);
                this.q0 = this.o0;
            }
        }
        w1(false);
    }

    public void q2(String str, String str2) {
        LiveStreamsDBModel liveStreamsDBModel;
        int i2;
        try {
            ArrayList arrayList = this.A;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.A.size()) {
                    i3 = -1;
                    break;
                } else if (((LiveStreamsDBModel) this.A.get(i3)).getStreamId().equals(str)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (str2.equals("add")) {
                if (i3 == -1) {
                    return;
                }
                liveStreamsDBModel = (LiveStreamsDBModel) this.A.get(i3);
                i2 = 1;
            } else {
                if (i3 == -1) {
                    return;
                }
                liveStreamsDBModel = (LiveStreamsDBModel) this.A.get(i3);
                i2 = 0;
            }
            liveStreamsDBModel.setFav(i2);
        } catch (Exception unused) {
        }
    }

    public void r2() {
        new j().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0090 A[Catch: Exception -> 0x0060, TryCatch #0 {Exception -> 0x0060, blocks: (B:10:0x002b, B:12:0x002f, B:14:0x0037, B:17:0x0040, B:19:0x004c, B:20:0x005c, B:21:0x0088, B:23:0x0090, B:25:0x009a, B:27:0x00a0, B:28:0x00b4, B:29:0x00c4, B:30:0x00c8, B:31:0x0063, B:32:0x0077), top: B:9:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8 A[Catch: Exception -> 0x0060, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:10:0x002b, B:12:0x002f, B:14:0x0037, B:17:0x0040, B:19:0x004c, B:20:0x005c, B:21:0x0088, B:23:0x0090, B:25:0x009a, B:27:0x00a0, B:28:0x00b4, B:29:0x00c4, B:30:0x00c8, B:31:0x0063, B:32:0x0077), top: B:9:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t2(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity.t2(java.lang.String, java.lang.String):void");
    }

    public void u2() {
        LinearLayout linearLayout = this.Z;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void v0(String str) {
    }

    public void v2() {
        l0 l0Var = this.m;
        if (l0Var != null) {
            l0Var.w();
        }
    }

    public void w1(boolean z) {
        m0 m0Var;
        try {
            w.X();
            g2();
            ArrayList arrayList = this.z;
            if (arrayList == null || arrayList.size() <= 0) {
                j2();
                VodAllCategoriesSingleton.getInstance().setVodList((ArrayList) null);
                m0 m0Var2 = new m0(this.d, "vod", this.K);
                this.l = m0Var2;
                this.T.setAdapter(m0Var2);
                H2(getResources().getString(a7.j.s4));
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                    v2();
                    return;
                }
                return;
            }
            VodAllCategoriesSingleton.getInstance().setVodList(this.z);
            if (z) {
                this.K = -1;
            } else {
                this.K = 0;
                if (!this.M && (m0Var = this.l) != null) {
                    this.K = m0Var.i1();
                }
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                if (!z) {
                    v2();
                }
                m0 m0Var3 = new m0(this.d, "vod", this.K);
                this.l = m0Var3;
                this.T.setAdapter(m0Var3);
                RelativeLayout relativeLayout = this.N;
                this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
                this.T.setLayoutManager(this.j);
                if (Build.VERSION.SDK_INT >= 23) {
                    this.k0.setOnScrollChangeListener(new f());
                }
            } else {
                m0 m0Var4 = new m0(this.d, "vod", this.K);
                this.l = m0Var4;
                this.T.setAdapter(m0Var4);
                RelativeLayout relativeLayout2 = this.N;
                this.j = (relativeLayout2 == null || relativeLayout2.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
                this.T.setLayoutManager(this.j);
            }
            L2();
        } catch (Exception unused) {
        }
    }

    public void w2() {
        m0 m0Var = this.l;
        if (m0Var != null) {
            m0Var.w();
        }
    }

    public void y0(String str) {
    }

    public void z2() {
        m0 m0Var = this.l;
        if (m0Var != null) {
            m0Var.o1();
        }
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
