package com.nst.iptvsmarterstvbox.view.activity;

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
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.SeriesAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.SeriesDBModel;
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
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetVODByCatPojo2;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.squareup.picasso.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m7.w;
import p7.s0;
import q7.Y;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesAllDataSingleActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.g {
    public ArrayList A;
    public ArrayList B;
    public ArrayList C;
    public SharedPreferences F;
    public SharedPreferences.Editor G;
    public Menu H;
    public MenuItem I;
    public SearchView J;
    public LinearLayout O;
    public RelativeLayout P;
    public RelativeLayout Q;
    public ImageView R;
    public RelativeLayout S;
    public ImageView T;
    public RecyclerView U;
    public RecyclerView V;
    public LinearLayout W;
    public LinearLayout X;
    public TextView Y;
    public TextView Z;
    public Context d;
    public Animation e;
    public EditText e0;
    public Animation f;
    public LinearLayout f0;
    public Animation g;
    public Toolbar g0;
    public Animation h;
    public AppBarLayout h0;
    public Animation i;
    public ImageView i0;
    public GridLayoutManager j;
    public ImageView j0;
    public LinearLayoutManager k;
    public ImageView k0;
    public Z l;
    public NestedScrollView l0;
    public Y m;
    public ArrayList n;
    public ArrayList o;
    public LiveStreamDBHandler p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    public Handler s0;
    public SeriesRecentWatchDatabase t;
    public Runnable t0;
    public n7.e u0;
    public boolean v0;
    public DatabaseHandler w;
    public ArrayList x;
    public ArrayList y;
    public ArrayList z;
    public int u = -1;
    public ArrayList v = new ArrayList();
    public ArrayList D = new ArrayList();
    public List E = new ArrayList();
    public String K = "0";
    public String L = "0";
    public int M = -1;
    public boolean N = true;
    public String m0 = "";
    public String n0 = "";
    public int o0 = 1;
    public int p0 = 0;
    public int q0 = 0;
    public int r0 = 0;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SeriesAllDataSingleActivity.x1(SeriesAllDataSingleActivity.this) != null) {
                SeriesAllDataSingleActivity.x1(SeriesAllDataSingleActivity.this).getFilter().filter(charSequence.toString());
            }
        }
    }

    public class b extends Dialog implements View.OnClickListener {
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
                SeriesAllDataSingleActivity.this.t2();
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
                            b = b.b(b.this);
                        }
                    } else {
                        b = b.a(b.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = b.b(b.this);
                        }
                    } else {
                        b = b.a(b.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public b(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(b bVar) {
            return bVar.f;
        }

        public static /* synthetic */ LinearLayout b(b bVar) {
            return bVar.g;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    SeriesAllDataSingleActivity.M1(SeriesAllDataSingleActivity.this).updateAllRecordsBySeriesNumRecentWatchDB();
                    SeriesAllDataSingleActivity.this.y2();
                    new Handler().postDelayed(new a(), 100L);
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(new u7.a(SeriesAllDataSingleActivity.A1(SeriesAllDataSingleActivity.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.f = findViewById(a7.f.V8);
            this.g = findViewById(a7.f.Ia);
            TextView findViewById = findViewById(a7.f.um);
            this.e = findViewById;
            findViewById.setText(SeriesAllDataSingleActivity.this.getResources().getString(a7.j.X8));
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new b(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new b(textView2));
        }
    }

    public class c implements View.OnFocusChangeListener {
        public View a;

        public c(View view) {
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
            view.setBackground(SeriesAllDataSingleActivity.this.getResources().getDrawable(a7.e.L));
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
            if (view.getId() == a7.f.u1) {
                try {
                    String charSequence = findViewById(this.g.getCheckedRadioButtonId()).getText().toString();
                    SharepreferenceDBHandler.setSeriesSubCatSort(charSequence.equals(this.h.getResources().getString(a7.j.i7)) ? "1" : charSequence.equals(this.h.getResources().getString(a7.j.f7)) ? "2" : charSequence.equals(this.h.getResources().getString(a7.j.k7)) ? "3" : charSequence.equals(this.h.getResources().getString(a7.j.j7)) ? "6" : "0", this.h);
                    SeriesAllDataSingleActivity seriesAllDataSingleActivity = SeriesAllDataSingleActivity.this;
                    seriesAllDataSingleActivity.r2(SeriesAllDataSingleActivity.z1(seriesAllDataSingleActivity), SeriesAllDataSingleActivity.N1(SeriesAllDataSingleActivity.this));
                    dismiss();
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
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
            String seriesSubCatSort = SharepreferenceDBHandler.getSeriesSubCatSort(this.h);
            seriesSubCatSort.hashCode();
            switch (seriesSubCatSort) {
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

    public class e implements NestedScrollView.c {
        public e() {
        }

        public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            String str;
            String z1;
            String str2;
            String str3 = "";
            int i5 = 0;
            if (i2 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                SeriesAllDataSingleActivity.this.o0++;
                Log.e("honey", "onScrollChange page:" + SeriesAllDataSingleActivity.this.o0 + " Total:" + SeriesAllDataSingleActivity.this.p0);
                SeriesAllDataSingleActivity seriesAllDataSingleActivity = SeriesAllDataSingleActivity.this;
                if (seriesAllDataSingleActivity.o0 <= seriesAllDataSingleActivity.p0) {
                    SeriesAllDataSingleActivity.B1(seriesAllDataSingleActivity, false);
                    w.M0(SeriesAllDataSingleActivity.this);
                    if (SeriesAllDataSingleActivity.C1(SeriesAllDataSingleActivity.this) != null) {
                        str = SeriesAllDataSingleActivity.C1(SeriesAllDataSingleActivity.this).getQuery().toString();
                        try {
                            i5 = SeriesAllDataSingleActivity.C1(SeriesAllDataSingleActivity.this).getQuery().toString().length();
                        } catch (Exception unused) {
                        }
                    } else {
                        str = "";
                    }
                    String str4 = str;
                    if (i5 < 3) {
                        if (SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this).equals("-1")) {
                            SeriesAllDataSingleActivity.E1(SeriesAllDataSingleActivity.this);
                            return;
                        } else {
                            SeriesAllDataSingleActivity.F1(SeriesAllDataSingleActivity.this);
                            return;
                        }
                    }
                    if (SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this).equals("0")) {
                        str2 = str3;
                        z1 = "*";
                    } else if (SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this).equals("-1")) {
                        str3 = "1";
                        str2 = str3;
                        z1 = "*";
                    } else {
                        z1 = SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this);
                        str2 = "";
                    }
                    try {
                        n7.e D1 = SeriesAllDataSingleActivity.D1(SeriesAllDataSingleActivity.this);
                        SeriesAllDataSingleActivity seriesAllDataSingleActivity2 = SeriesAllDataSingleActivity.this;
                        D1.t(seriesAllDataSingleActivity2.m0, seriesAllDataSingleActivity2.n0, z1, str4, str2, String.valueOf(seriesAllDataSingleActivity2.o0));
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    public class f implements SearchView.m {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            public void run() {
                String str = "*";
                String str2 = "";
                if (!SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this).equals("0")) {
                    if (SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this).equals("-1")) {
                        str2 = "1";
                    } else {
                        str = SeriesAllDataSingleActivity.z1(SeriesAllDataSingleActivity.this);
                    }
                }
                String str3 = str;
                String str4 = str2;
                SeriesAllDataSingleActivity.J1(SeriesAllDataSingleActivity.this, new ArrayList());
                SeriesAllDataSingleActivity seriesAllDataSingleActivity = SeriesAllDataSingleActivity.this;
                seriesAllDataSingleActivity.M = 0;
                SeriesAllDataSingleActivity.B1(seriesAllDataSingleActivity, true);
                SeriesAllDataSingleActivity seriesAllDataSingleActivity2 = SeriesAllDataSingleActivity.this;
                seriesAllDataSingleActivity2.o0 = 1;
                SeriesAllDataSingleActivity.y1(seriesAllDataSingleActivity2);
                SeriesAllDataSingleActivity.this.h2();
                SeriesAllDataSingleActivity.this.f2();
                try {
                    Log.e("honey", "request:" + this.a);
                    n7.e D1 = SeriesAllDataSingleActivity.D1(SeriesAllDataSingleActivity.this);
                    SeriesAllDataSingleActivity seriesAllDataSingleActivity3 = SeriesAllDataSingleActivity.this;
                    D1.t(seriesAllDataSingleActivity3.m0, seriesAllDataSingleActivity3.n0, str3, this.a, str4, String.valueOf(seriesAllDataSingleActivity3.o0));
                } catch (Exception unused) {
                }
            }
        }

        public f() {
        }

        public boolean onQueryTextChange(String str) {
            if (SeriesAllDataSingleActivity.P1(SeriesAllDataSingleActivity.this) == null) {
                return false;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(SeriesAllDataSingleActivity.A1(SeriesAllDataSingleActivity.this)).equals("stalker_api")) {
                SeriesAllDataSingleActivity.P1(SeriesAllDataSingleActivity.this).getFilter().filter(str);
                return false;
            }
            try {
                if (str.length() >= 3) {
                    Handler handler = SeriesAllDataSingleActivity.this.s0;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                    SeriesAllDataSingleActivity.this.t0 = new a(str);
                    SeriesAllDataSingleActivity seriesAllDataSingleActivity = SeriesAllDataSingleActivity.this;
                    seriesAllDataSingleActivity.s0.postDelayed(seriesAllDataSingleActivity.t0, 1000L);
                    return false;
                }
                Handler handler2 = SeriesAllDataSingleActivity.this.s0;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages((Object) null);
                }
                if (SeriesAllDataSingleActivity.I1(SeriesAllDataSingleActivity.this) == null || SeriesAllDataSingleActivity.L1(SeriesAllDataSingleActivity.this) == null || SeriesAllDataSingleActivity.L1(SeriesAllDataSingleActivity.this).size() <= 0) {
                    return false;
                }
                SeriesAllDataSingleActivity seriesAllDataSingleActivity2 = SeriesAllDataSingleActivity.this;
                seriesAllDataSingleActivity2.M = -1;
                SeriesAllDataSingleActivity.B1(seriesAllDataSingleActivity2, true);
                SeriesAllDataSingleActivity seriesAllDataSingleActivity3 = SeriesAllDataSingleActivity.this;
                seriesAllDataSingleActivity3.o0 = 1;
                SeriesAllDataSingleActivity.I1(seriesAllDataSingleActivity3).clear();
                SeriesAllDataSingleActivity.I1(SeriesAllDataSingleActivity.this).addAll(SeriesAllDataSingleActivity.L1(SeriesAllDataSingleActivity.this));
                SeriesAllDataSingleActivity seriesAllDataSingleActivity4 = SeriesAllDataSingleActivity.this;
                seriesAllDataSingleActivity4.p0 = seriesAllDataSingleActivity4.r0;
                seriesAllDataSingleActivity4.v1(true);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
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

    public class h implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public h(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class i extends AsyncTask {
        public i() {
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
                com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity r0 = com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                r7 = r7[r5]     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r0.a2(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L49:
                com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.K1(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L50:
                com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity r0 = com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                r7 = r7[r5]     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r0.V1(r7)     // Catch: java.lang.Exception -> L60
                return r7
            L59:
                com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity r7 = com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.this     // Catch: java.lang.Exception -> L60
                java.lang.String r7 = r7.X1()     // Catch: java.lang.Exception -> L60
                return r7
            L60:
                java.lang.String r7 = "error"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.i.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SeriesAllDataSingleActivity.this.g2();
            str.hashCode();
            switch (str) {
                case "get_all":
                    SeriesAllDataSingleActivity.this.v1(false);
                    break;
                case "get_fav":
                    SeriesAllDataSingleActivity.this.T1();
                    break;
                case "get_recent_watch":
                    SeriesAllDataSingleActivity.O1(SeriesAllDataSingleActivity.this);
                    break;
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            SeriesAllDataSingleActivity.y1(SeriesAllDataSingleActivity.this);
            SeriesAllDataSingleActivity.this.h2();
            SeriesAllDataSingleActivity.this.f2();
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
                        resources = SeriesAllDataSingleActivity.this.getResources();
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
                    resources = SeriesAllDataSingleActivity.this.getResources();
                    i = a7.e.O0;
                } else {
                    resources = SeriesAllDataSingleActivity.this.getResources();
                    i = a7.c.s;
                }
            } else {
                resources = SeriesAllDataSingleActivity.this.getResources();
                i = a7.e.O0;
            }
            view.setBackground(resources.getDrawable(i));
        }
    }

    public class k extends AsyncTask {
        public k() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return SeriesAllDataSingleActivity.G1(SeriesAllDataSingleActivity.this);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            SeriesAllDataSingleActivity.H1(SeriesAllDataSingleActivity.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ Context A1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.d;
    }

    public static /* synthetic */ boolean B1(SeriesAllDataSingleActivity seriesAllDataSingleActivity, boolean z) {
        seriesAllDataSingleActivity.N = z;
        return z;
    }

    public static /* synthetic */ SearchView C1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.J;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r0.size() >= 3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r3 = ((com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r5.r.get(2)).getLiveStreamCategoryID();
        r0 = r5.r.get(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r0.size() >= 3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void C2() {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.r
            if (r0 == 0) goto Lc2
            int r0 = r0.size()
            if (r0 <= 0) goto Lc2
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto L11
            r0.clear()
        L11:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.s = r0
            java.util.ArrayList r1 = r5.r
            r0.addAll(r1)
            android.content.Context r0 = r5.d
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r0)
            java.lang.String r1 = "m3u"
            boolean r0 = r0.equals(r1)
            r1 = 3
            r2 = 2
            java.lang.String r3 = "0"
            if (r0 == 0) goto L62
            java.util.ArrayList r0 = r5.r
            if (r0 == 0) goto L55
            int r0 = r0.size()
            if (r0 < r1) goto L55
        L39:
            java.util.ArrayList r0 = r5.r
            java.lang.Object r0 = r0.get(r2)
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r3 = r0.getLiveStreamCategoryID()
            java.util.ArrayList r0 = r5.r
            java.lang.Object r0 = r0.get(r2)
        L4b:
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r0 = r0.getLiveStreamCategoryName()
        L51:
            r5.r2(r3, r0)
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
            java.util.ArrayList r0 = r5.r
            if (r0 == 0) goto L55
            int r0 = r0.size()
            if (r0 < r1) goto L55
            goto L39
        L7b:
            java.util.ArrayList r0 = r5.r
            if (r0 == 0) goto L55
            int r0 = r0.size()
            r1 = 5
            if (r0 < r1) goto L55
            java.util.ArrayList r0 = r5.r
            r1 = 4
            java.lang.Object r0 = r0.get(r1)
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r0
            java.lang.String r3 = r0.getLiveStreamCategoryID()
            java.util.ArrayList r0 = r5.r
            java.lang.Object r0 = r0.get(r1)
            goto L4b
        L9a:
            java.util.ArrayList r0 = r5.s
            if (r0 == 0) goto Lad
            int r0 = r0.size()
            if (r0 <= 0) goto Lad
            com.nst.iptvsmarterstvbox.model.SeriesAllCategoriesSingleton r0 = com.nst.iptvsmarterstvbox.model.SeriesAllCategoriesSingleton.getInstance()
            java.util.ArrayList r1 = r5.s
            r0.setSeriesCategoriesList(r1)
        Lad:
            q7.Y r0 = new q7.Y
            android.content.Context r1 = r5.d
            r0.<init>(r1, r3)
            r5.m = r0
            androidx.recyclerview.widget.RecyclerView r1 = r5.U
            r1.setAdapter(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r5.U
            androidx.recyclerview.widget.LinearLayoutManager r1 = r5.k
            r0.setLayoutManager(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.C2():void");
    }

    public static /* synthetic */ n7.e D1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.u0;
    }

    private void D2() {
        try {
            new b(this).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void E1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        seriesAllDataSingleActivity.K2();
    }

    public static /* synthetic */ void F1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        seriesAllDataSingleActivity.J2();
    }

    private void F2() {
        LinearLayout linearLayout = this.X;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.X.setVisibility(0);
    }

    public static /* synthetic */ Boolean G1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.A2();
    }

    public static /* synthetic */ void H1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        seriesAllDataSingleActivity.C2();
    }

    private void H2() {
        if (this.P.getVisibility() == 8) {
            this.R.setVisibility(8);
            if (!new u7.a(this.d).A().equals(m7.a.K0)) {
                this.k0.setVisibility(8);
            }
            this.T.startAnimation(this.i);
            this.T.setVisibility(0);
            this.T.requestFocus();
            this.P.startAnimation(this.e);
            this.P.setVisibility(0);
            this.Q.startAnimation(this.g);
            this.Q.setVisibility(0);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 5);
            this.j = gridLayoutManager;
            this.V.setLayoutManager(gridLayoutManager);
            if (this.l != null) {
                this.V.m1(this.M);
                this.M = -1;
            }
        }
    }

    public static /* synthetic */ ArrayList I1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.z;
    }

    private void I2(Activity activity) {
        try {
            new d(this, activity).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ ArrayList J1(SeriesAllDataSingleActivity seriesAllDataSingleActivity, ArrayList arrayList) {
        seriesAllDataSingleActivity.z = arrayList;
        return arrayList;
    }

    public static /* synthetic */ String K1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.Z1();
    }

    public static /* synthetic */ ArrayList L1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.A;
    }

    private void L2() {
        this.e = AnimationUtils.loadAnimation(this.d, a7.b.b);
        this.f = AnimationUtils.loadAnimation(this.d, a7.b.c);
        this.g = AnimationUtils.loadAnimation(this.d, a7.b.g);
        this.h = AnimationUtils.loadAnimation(this.d, a7.b.e);
        this.i = AnimationUtils.loadAnimation(this.d, a7.b.a);
    }

    public static /* synthetic */ SeriesRecentWatchDatabase M1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.t;
    }

    public static /* synthetic */ String N1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.L;
    }

    public static /* synthetic */ void O1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        seriesAllDataSingleActivity.w1();
    }

    public static /* synthetic */ Z P1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.l;
    }

    private void Q1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void S1() {
        EditText editText = this.e0;
        if (editText != null) {
            editText.setText("");
            this.e0.clearFocus();
        }
    }

    private void U1() {
        ImageView imageView = this.T;
        imageView.setOnFocusChangeListener(new j(imageView));
        RelativeLayout relativeLayout = this.S;
        relativeLayout.setOnFocusChangeListener(new j(relativeLayout));
        ImageView imageView2 = this.R;
        imageView2.setOnFocusChangeListener(new j(imageView2));
    }

    private ArrayList Y1() {
        ArrayList allPasswordStatus = this.p.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.q = allPasswordStatus;
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

    private ArrayList b2(ArrayList arrayList, ArrayList arrayList2) {
        this.B = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.B.add(favouriteDBModel);
                    break;
                }
                String str = (String) it2.next();
                if (favouriteDBModel.getCategoryID() == null || !favouriteDBModel.getCategoryID().equals(str)) {
                }
            }
        }
        return this.B;
    }

    private ArrayList c2(ArrayList arrayList, ArrayList arrayList2) {
        this.C = new ArrayList();
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
                            this.C.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.C;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void d2(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void i2() {
        if (this.P.getVisibility() == 0) {
            d2(this);
            this.Q.startAnimation(this.h);
            this.Q.setVisibility(0);
            this.P.startAnimation(this.f);
            this.P.setVisibility(8);
            this.R.startAnimation(this.i);
            this.R.setVisibility(0);
            if (!new u7.a(this.d).A().equals(m7.a.K0)) {
                this.k0.setVisibility(0);
            }
            this.R.requestFocus();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 7);
            this.j = gridLayoutManager;
            this.V.setLayoutManager(gridLayoutManager);
        }
    }

    private void k2() {
        this.s0 = new Handler();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new LiveStreamDBHandler(this.d);
        this.q = new ArrayList();
        this.s = new ArrayList();
        this.r = new ArrayList();
        this.t = new SeriesRecentWatchDatabase(this.d);
        this.k = new LinearLayoutManager(this.d);
        this.w = new DatabaseHandler(this.d);
        this.u0 = new n7.e(this, this.d);
        this.z = new ArrayList();
        this.A = new ArrayList();
        SharedPreferences sharedPreferences = getSharedPreferences("showhidemoviename", 0);
        this.F = sharedPreferences;
        this.G = sharedPreferences.edit();
        w.y(this.d);
        if (new u7.a(this.d).A().equals(m7.a.K0)) {
            this.j0.setVisibility(8);
        }
        U1();
        L2();
        v2();
        w2();
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            p2();
            return;
        }
        try {
            this.n0 = SharepreferenceDBHandler.getStalkerToken(this.d);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
            this.m0 = loggedInMacAddress;
            this.u0.f(loggedInMacAddress, this.n0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ int l2(SeriesDBModel seriesDBModel, SeriesDBModel seriesDBModel2) {
        float f2;
        float f3 = 0.0f;
        try {
            f2 = Float.parseFloat(seriesDBModel2.getrating());
        } catch (Exception e2) {
            e2.printStackTrace();
            f2 = 0.0f;
        }
        try {
            f3 = Float.parseFloat(seriesDBModel.getrating());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return Float.compare(f2, f3);
    }

    private boolean m2() {
        EditText editText = this.e0;
        return editText != null && editText.getText().toString().length() > 0;
    }

    private void q2() {
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, a7.k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.O = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new g(dialog));
        this.O.setOnClickListener(new h(dialog));
        findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
        findViewById2.setOnFocusChangeListener(new c(findViewById2));
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

    public static /* synthetic */ int u1(SeriesDBModel seriesDBModel, SeriesDBModel seriesDBModel2) {
        return l2(seriesDBModel, seriesDBModel2);
    }

    private void v2() {
        this.T.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.i0.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.j0.setOnClickListener(this);
        this.k0.setOnClickListener(this);
    }

    private void w1() {
        List list = this.E;
        if (list == null || list.size() <= 0) {
            SeriesAllCategoriesSingleton.getInstance().setContinueWatchingList((List) null);
            Menu menu = this.H;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            }
            Z z = new Z(this.d, "continue_watching", this.M);
            this.l = z;
            z.E1(null);
            this.V.setAdapter(this.l);
            E2(getResources().getString(a7.j.C4));
            return;
        }
        SeriesAllCategoriesSingleton.getInstance().setContinueWatchingList(this.E);
        if (this.H != null) {
            List list2 = this.E;
            if (list2 == null || list2.size() <= 0) {
                this.H.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(false);
            } else {
                this.H.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(true);
            }
        }
        Z z2 = new Z(this.d, "continue_watching", this.M);
        this.l = z2;
        z2.E1(null);
        this.V.setAdapter(this.l);
        RelativeLayout relativeLayout = this.P;
        this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
        this.V.setLayoutManager(this.j);
        G2();
    }

    private void w2() {
        EditText editText = this.e0;
        if (editText != null) {
            editText.addTextChangedListener(new a());
        }
    }

    public static /* synthetic */ Y x1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.m;
    }

    public static /* synthetic */ void y1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        seriesAllDataSingleActivity.F2();
    }

    public static /* synthetic */ String z1(SeriesAllDataSingleActivity seriesAllDataSingleActivity) {
        return seriesAllDataSingleActivity.K;
    }

    private void z2(String str) {
        Y y = this.m;
        if (y != null) {
            y.x0(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e7 A[Catch: Exception -> 0x000c, NullPointerException -> 0x000f, TRY_ENTER, TryCatch #2 {Exception -> 0x000c, NullPointerException -> 0x000f, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0008, B:7:0x0012, B:10:0x0070, B:13:0x007e, B:14:0x009b, B:15:0x00c9, B:18:0x00e7, B:19:0x012b, B:20:0x012f, B:22:0x013d, B:23:0x009f, B:26:0x00ab, B:27:0x0182), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012f A[Catch: Exception -> 0x000c, NullPointerException -> 0x000f, TryCatch #2 {Exception -> 0x000c, NullPointerException -> 0x000f, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0008, B:7:0x0012, B:10:0x0070, B:13:0x007e, B:14:0x009b, B:15:0x00c9, B:18:0x00e7, B:19:0x012b, B:20:0x012f, B:22:0x013d, B:23:0x009f, B:26:0x00ab, B:27:0x0182), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean A2() {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.A2():java.lang.Boolean");
    }

    public void B2(String str) {
        TextView textView = this.Z;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void E2(String str) {
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText(str);
            this.Y.setVisibility(0);
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void G2() {
        LinearLayout linearLayout = this.W;
        if (linearLayout == null || linearLayout.getVisibility() != 8) {
            return;
        }
        this.W.setVisibility(0);
    }

    public void H(String str) {
    }

    public final void J2() {
        try {
            this.u0.k(this.m0, this.n0, this.K.equals("0") ? "*" : this.K, String.valueOf(this.o0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void K2() {
        try {
            this.u0.m(this.m0, this.n0, String.valueOf(this.o0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        p2();
    }

    public void P0(String str) {
    }

    public boolean R1() {
        Z z = this.l;
        if (z != null) {
            return z.q1();
        }
        return false;
    }

    public void T1() {
        try {
            ArrayList arrayList = this.D;
            if (arrayList == null || arrayList.size() <= 0) {
                SeriesAllCategoriesSingleton.getInstance().setSeriesList((ArrayList) null);
                Z z = new Z(this.d, "series", this.M);
                this.l = z;
                this.V.setAdapter(z);
                E2(getResources().getString(a7.j.n4));
                return;
            }
            SeriesAllCategoriesSingleton.getInstance().setSeriesList(this.D);
            Z z2 = new Z(this.d, "series", this.M);
            this.l = z2;
            this.V.setAdapter(z2);
            RelativeLayout relativeLayout = this.P;
            this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
            this.V.setLayoutManager(this.j);
            G2();
        } catch (Exception unused) {
        }
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public String V1(String str) {
        try {
            this.x = new ArrayList();
            this.n = new ArrayList();
            this.y = new ArrayList();
            this.z = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.p.getAllSeriesStreamsWithCategoryIdM3U(str) : SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.p.getOneStreamAllSeriesStreamsWithCategoryId(str) : this.p.getAllSeriesStreamsWithCategoryId(str);
            return "get_all";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_all";
        }
    }

    public void W1() {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            return;
        }
        m7.a.i1 = true;
        q2();
    }

    public String X1() {
        ArrayList arrayList;
        SeriesDBModel seriesStreamsWithSeriesId;
        ArrayList arrayList2;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                new ArrayList();
                this.D.clear();
                ArrayList favouriteM3U = this.p.getFavouriteM3U("series");
                if (this.v != null) {
                    this.v = Y1();
                }
                ArrayList arrayList3 = this.v;
                if (arrayList3 != null && arrayList3.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = c2(favouriteM3U, this.v);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return "get_fav";
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    SeriesDBModel m3UFavouriteRowSeries = this.p.getM3UFavouriteRowSeries(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRowSeries != null) {
                        this.D.add(m3UFavouriteRowSeries);
                    }
                }
                return "get_fav";
            }
            new ArrayList();
            this.D.clear();
            ArrayList allFavourites = this.w.getAllFavourites("series", SharepreferenceDBHandler.getUserID(this.d));
            if (this.v != null) {
                this.v = Y1();
            }
            ArrayList arrayList4 = this.v;
            if (arrayList4 != null && arrayList4.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                allFavourites = b2(allFavourites, this.v);
            }
            if (allFavourites == null || allFavourites.size() <= 0) {
                return "get_fav";
            }
            Iterator it2 = allFavourites.iterator();
            while (it2.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    seriesStreamsWithSeriesId = this.p.getSeriesStreamsWithSeriesId(String.valueOf(favouriteDBModel.getStreamIDOneStream()));
                    if (seriesStreamsWithSeriesId != null) {
                        arrayList2 = this.D;
                        arrayList2.add(seriesStreamsWithSeriesId);
                    }
                } else {
                    seriesStreamsWithSeriesId = this.p.getSeriesStreamsWithSeriesId(String.valueOf(favouriteDBModel.getStreamID()));
                    if (seriesStreamsWithSeriesId != null) {
                        arrayList2 = this.D;
                        arrayList2.add(seriesStreamsWithSeriesId);
                    }
                }
            }
            if (!SharepreferenceDBHandler.getSeriesSubCatSort(this.d).equalsIgnoreCase("6") || (arrayList = this.D) == null || arrayList.size() <= 1) {
                return "get_fav";
            }
            Collections.sort(this.D, new s0());
            return "get_fav";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav";
        }
    }

    public final String Z1() {
        this.v = new ArrayList();
        new ArrayList();
        this.E = new ArrayList();
        ArrayList allSeriesContiueWatching = this.t.getAllSeriesContiueWatching("getalldata", "1");
        if (this.p.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.d)) <= 0) {
            this.E = allSeriesContiueWatching;
            return "get_recent_watch";
        }
        this.v = Y1();
        Iterator it = allSeriesContiueWatching.iterator();
        while (it.hasNext()) {
            GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = (GetEpisdoeDetailsCallback) it.next();
            Iterator it2 = this.v.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.E.add(getEpisdoeDetailsCallback);
                    break;
                }
                String str = (String) it2.next();
                if (getEpisdoeDetailsCallback.getCategoryId() == null || !getEpisdoeDetailsCallback.getCategoryId().equals(str)) {
                }
            }
        }
        return "get_recent_watch";
    }

    public String a2(String str) {
        try {
            this.x = new ArrayList();
            this.n = new ArrayList();
            this.y = new ArrayList();
            this.z = this.p.getAllSeriesStreamsWithCategoryId(str);
            return "get_all";
        } catch (Exception unused) {
            return "get_all";
        }
    }

    public void c(String str) {
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
        LinearLayout linearLayout = this.f0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f2() {
        TextView textView = this.Y;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.Y.setVisibility(8);
    }

    public void g2() {
        LinearLayout linearLayout = this.X;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.X.setVisibility(8);
    }

    public void h2() {
        LinearLayout linearLayout = this.W;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.W.setVisibility(8);
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public boolean n2() {
        EditText editText = this.e0;
        if (editText != null) {
            return editText.isFocused();
        }
        return false;
    }

    public void o0(String str) {
    }

    public void o2(int i2, String str) {
        SeriesDBModel seriesDBModel;
        int i3;
        Log.e("honey", "seriesid: " + i2);
        Log.e("honey", "size: " + this.A.size());
        if (i2 != 0) {
            try {
                ArrayList arrayList = this.A;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= this.A.size()) {
                        i4 = -1;
                        break;
                    } else if (((SeriesDBModel) this.A.get(i4)).getseriesID() == i2) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (str.equals("add")) {
                    if (i4 == -1) {
                        return;
                    }
                    seriesDBModel = (SeriesDBModel) this.A.get(i4);
                    i3 = 1;
                } else {
                    if (i4 == -1) {
                        return;
                    }
                    seriesDBModel = (SeriesDBModel) this.A.get(i4);
                    i3 = 0;
                }
                seriesDBModel.setFav(i3);
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        if (m2()) {
            S1();
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.U4) {
            i2();
            return;
        }
        if (view.getId() == a7.f.G4 || view.getId() == a7.f.H4) {
            onBackPressed();
            return;
        }
        if (view.getId() == a7.f.l5) {
            this.M = -1;
            H2();
        } else if (view.getId() == a7.f.Xa) {
            w.j(this.d);
        } else if (view.getId() == a7.f.if) {
            this.e0.requestFocus();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        j2();
        Q1();
        this.d = this;
        if (SharepreferenceDBHandler.getCurrentAPPType(this).equals("stalker_api")) {
            setContentView(a7.g.M0);
            this.l0 = findViewById(a7.f.n4);
        } else {
            setContentView(a7.g.L0);
        }
        this.P = findViewById(a7.f.ye);
        this.Q = findViewById(a7.f.hf);
        this.R = findViewById(a7.f.l5);
        this.S = findViewById(a7.f.if);
        this.T = findViewById(a7.f.U4);
        this.U = findViewById(a7.f.Fd);
        this.V = findViewById(a7.f.Dd);
        this.W = findViewById(a7.f.W9);
        this.X = findViewById(a7.f.I8);
        this.Y = findViewById(a7.f.wk);
        this.Z = findViewById(a7.f.Zj);
        this.e0 = findViewById(a7.f.m3);
        this.f0 = findViewById(a7.f.W8);
        this.g0 = findViewById(a7.f.kh);
        this.h0 = findViewById(a7.f.W);
        this.i0 = findViewById(a7.f.Xa);
        this.j0 = findViewById(a7.f.G4);
        this.k0 = findViewById(a7.f.H4);
        Toolbar toolbar = this.g0;
        if (toolbar != null) {
            r1(toolbar);
        }
        m7.a.M0 = "-1";
        k2();
        if (m7.a.V0.booleanValue() && m7.a.e1.equalsIgnoreCase("1")) {
            if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
            } else {
                SharepreferenceDBHandler.setEventAdsView(0, this);
                W1();
            }
        }
        this.v0 = true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        Toolbar toolbar = this.g0;
        if (toolbar != null) {
            toolbar.x(a7.h.t);
            SharedPreferences sharedPreferences = this.F;
            if (sharedPreferences != null) {
                if (sharedPreferences.getInt("series", 1) == 1) {
                    menu.getItem(1).getSubMenu().findItem(a7.f.x6).setVisible(false);
                    menu.getItem(1).getSubMenu().findItem(a7.f.t6).setVisible(true);
                } else {
                    menu.getItem(1).getSubMenu().findItem(a7.f.x6).setVisible(true);
                    menu.getItem(1).getSubMenu().findItem(a7.f.t6).setVisible(false);
                }
            }
            this.H = menu;
            TextView textView = this.Z;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (this.K.equals("-5") || this.K.equals("-4") || SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                this.H.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(false);
            } else {
                this.H.getItem(1).getSubMenu().findItem(a7.f.mb).setVisible(true);
            }
            if (this.K.equals("-4")) {
                this.H.getItem(1).getSubMenu().findItem(a7.f.Db).setVisible(true);
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
        AsyncTask asyncTask = w.m;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        w.m.cancel(true);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Z z;
        if (i2 != 21) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.P.getVisibility() != 8 || (z = this.l) == null) {
            return false;
        }
        int s1 = z.s1();
        this.M = s1;
        if (s1 % 7 != 0) {
            return false;
        }
        H2();
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.I = menuItem;
        this.g0.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.g) {
            try {
                SearchView actionView = menuItem.getActionView();
                this.J = actionView;
                if (actionView != null) {
                    actionView.setQueryHint(getResources().getString(a7.j.E6));
                    this.J.setIconifiedByDefault(false);
                    ImageView findViewById = this.J.findViewById(a7.f.Uf);
                    this.J.findViewById(a7.f.Vf).setImageResource(a7.e.m1);
                    findViewById.setImageResource(a7.e.m1);
                    findViewById.setPadding(15, 15, 15, 15);
                    findViewById.setBackground((Drawable) null);
                    this.J.setOnQueryTextListener(new f());
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        if (itemId == a7.f.gb) {
            w.A0(this.d);
        }
        if (itemId == a7.f.mb) {
            I2(this);
        }
        if (itemId == a7.f.x6) {
            SharedPreferences.Editor editor = this.G;
            if (editor != null) {
                editor.putInt("series", 1);
                this.G.commit();
            }
            Menu menu = this.H;
            if (menu != null) {
                menu.getItem(1).getSubMenu().findItem(a7.f.x6).setVisible(false);
                this.H.getItem(1).getSubMenu().findItem(a7.f.t6).setVisible(true);
            }
            u2();
        }
        if (itemId == a7.f.t6) {
            SharedPreferences.Editor editor2 = this.G;
            if (editor2 != null) {
                editor2.putInt("series", 0);
                this.G.commit();
            }
            Menu menu2 = this.H;
            if (menu2 != null) {
                menu2.getItem(1).getSubMenu().findItem(a7.f.x6).setVisible(true);
                this.H.getItem(1).getSubMenu().findItem(a7.f.t6).setVisible(false);
            }
            u2();
        }
        if (itemId == a7.f.Db && SeriesAllCategoriesSingleton.getInstance().getContinueWatchingList() != null && SeriesAllCategoriesSingleton.getInstance().getContinueWatchingList().size() > 0) {
            D2();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        j2();
        super/*androidx.fragment.app.e*/.onResume();
        if (this.v0) {
            this.v0 = false;
        } else {
            t2();
        }
        w.z0(this.d);
        if (this.K.equals("-4")) {
            y2();
        } else {
            u2();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        j2();
    }

    public void p2() {
        new k().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
        SearchView searchView;
        ArrayList arrayList;
        SearchView searchView2;
        if (stalkerGetVODByCatCallback == null || stalkerGetVODByCatCallback.getJs() == null || stalkerGetVODByCatCallback.getJs().getData() == null || stalkerGetVODByCatCallback.getJs().getData().size() <= 0) {
            try {
                searchView = this.J;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int length = searchView != null ? searchView.getQuery().toString().length() : 0;
            if (length < 3) {
                try {
                    m7.a.M0 = stalkerGetVODByCatCallback.getJs().getTotalItems().toString();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            this.x = new ArrayList();
            this.n = new ArrayList();
            this.y = new ArrayList();
            try {
                searchView2 = this.J;
            } catch (Exception unused) {
            }
            int length2 = searchView2 != null ? searchView2.getQuery().toString().length() : 0;
            if (length2 < 3) {
                try {
                    m7.a.M0 = stalkerGetVODByCatCallback.getJs().getTotalItems().toString();
                } catch (Exception unused2) {
                }
            }
            this.p0 = w.v(stalkerGetVODByCatCallback.getJs().getTotalItems().intValue(), stalkerGetVODByCatCallback.getJs().getMaxPageItems().intValue());
            for (int i2 = 0; i2 < stalkerGetVODByCatCallback.getJs().getData().size(); i2++) {
                SeriesDBModel seriesDBModel = new SeriesDBModel();
                seriesDBModel.setNum(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getId());
                seriesDBModel.setName(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getName());
                seriesDBModel.setStreamType("series");
                seriesDBModel.setseriesID(w.r0(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getId()));
                seriesDBModel.setcover(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getScreenshotUri());
                seriesDBModel.setreleaseDate(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getYear());
                seriesDBModel.setCategoryId(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getCategoryId());
                seriesDBModel.setFav(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getFav());
                seriesDBModel.setdirector(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getDirector());
                seriesDBModel.setcast(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getActors());
                seriesDBModel.setplot(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getDescription());
                seriesDBModel.setgenre(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getGenresStr());
                seriesDBModel.setCmd(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getCmd());
                seriesDBModel.setDurationMin(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getTime());
                seriesDBModel.setrating(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getRatingImdb().equals("N/A") ? "0" : ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i2)).getRatingImdb());
                this.z.add(seriesDBModel);
            }
            ArrayList arrayList2 = this.z;
            if (arrayList2 != null && arrayList2.size() > 0 && (arrayList = this.A) != null && arrayList.size() == 0) {
                this.A.addAll(this.z);
                this.r0 = this.p0;
            }
        }
        v1(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:10:0x0029, B:12:0x002d, B:14:0x0035, B:17:0x003e, B:19:0x004a, B:20:0x005a, B:21:0x0086, B:23:0x008e, B:25:0x0098, B:27:0x009e, B:28:0x00b2, B:29:0x00c2, B:30:0x00c6, B:31:0x0061, B:32:0x0075), top: B:9:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:10:0x0029, B:12:0x002d, B:14:0x0035, B:17:0x003e, B:19:0x004a, B:20:0x005a, B:21:0x0086, B:23:0x008e, B:25:0x0098, B:27:0x009e, B:28:0x00b2, B:29:0x00c2, B:30:0x00c6, B:31:0x0061, B:32:0x0075), top: B:9:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r2(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesAllDataSingleActivity.r2(java.lang.String, java.lang.String):void");
    }

    public void s2() {
        LinearLayout linearLayout = this.f0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void t2() {
        Y y = this.m;
        if (y != null) {
            y.w();
        }
    }

    public void u2() {
        Z z = this.l;
        if (z != null) {
            z.w();
        }
    }

    public void v0(String str) {
    }

    public void v1(boolean z) {
        Z z2;
        try {
            w.X();
            g2();
            this.M = 0;
            ArrayList arrayList = this.z;
            if (arrayList == null || arrayList.size() <= 0) {
                h2();
                SeriesAllCategoriesSingleton.getInstance().setSeriesList((ArrayList) null);
                Z z3 = new Z(this.d, "series", this.M);
                this.l = z3;
                this.V.setAdapter(z3);
                E2(getResources().getString(a7.j.B4));
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                    t2();
                    return;
                }
                return;
            }
            SeriesAllCategoriesSingleton.getInstance().setSeriesList(this.z);
            if (z) {
                this.M = -1;
            } else {
                this.M = 0;
                if (!this.N && (z2 = this.l) != null) {
                    this.M = z2.s1();
                }
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                if (!z) {
                    t2();
                }
                Z z4 = new Z(this.d, "series", this.M);
                this.l = z4;
                this.V.setAdapter(z4);
                RelativeLayout relativeLayout = this.P;
                this.j = (relativeLayout == null || relativeLayout.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
                this.V.setLayoutManager(this.j);
                if (Build.VERSION.SDK_INT >= 23) {
                    this.l0.setOnScrollChangeListener(new e());
                }
            } else {
                Z z5 = new Z(this.d, "series", this.M);
                this.l = z5;
                this.V.setAdapter(z5);
                RelativeLayout relativeLayout2 = this.P;
                this.j = (relativeLayout2 == null || relativeLayout2.getVisibility() != 8) ? new GridLayoutManager(this, 5) : new GridLayoutManager(this, 7);
                this.V.setLayoutManager(this.j);
            }
            G2();
        } catch (Exception unused) {
        }
    }

    public void x2() {
        Z z = this.l;
        if (z != null) {
            z.A1();
        }
    }

    public void y0(String str) {
    }

    public void y2() {
        w.m = new i().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_recent_watch", "-4"});
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
