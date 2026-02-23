package com.nst.iptvsmarterstvbox.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.nst.iptvsmarterstvbox.model.callback.BillingCheckGPACallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingGetDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingLoginClientCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingUpdateDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.RegisterClientCallback;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import g1.j;
import g1.k;
import g1.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class APPInPurchaseActivity extends Activity implements View.OnClickListener, z7.d, j, l {
    public LinearLayout A;
    public LinearLayout B;
    public Button C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public LinearLayout H;
    public Button I;
    public Button J;
    public LinearLayout K;
    public Context L;
    public n7.b N;
    public String O;
    public String P;
    public int Q;
    public u7.a R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public LinearLayout a;
    public LinearLayout c;
    public EditText d;
    public EditText e;
    public g1.c e0;
    public EditText f;
    public SkuDetails f0;
    public Button g;
    public Handler g0;
    public LinearLayout h;
    public g1.b h0;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public EditText l;
    public EditText m;
    public Button n;
    public Button o;
    public Button p;
    public LinearLayout q;
    public Button r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public RelativeLayout v;
    public TextView w;
    public LinearLayout x;
    public LinearLayout y;
    public LinearLayout z;
    public boolean M = false;
    public String Y = "";
    public String Z = "";

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                w.N0(APPInPurchaseActivity.h(APPInPurchaseActivity.this));
            }
        }
    }

    public class b implements g1.b {
        public b() {
        }

        public void a(com.android.billingclient.api.a aVar) {
            if (aVar.b() == 0) {
                Log.e("honey", "onAcknowledgePurchaseResponse:1");
            }
            Log.e("honey", "onAcknowledgePurchaseResponse:2");
        }
    }

    public class c implements g1.e {

        public class a implements g1.i {
            public a() {
            }

            public void a(com.android.billingclient.api.a aVar, List list) {
                if (aVar.b() == 0 && list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Purchase purchase = (Purchase) it.next();
                        if (purchase.f().contains("com.nst.smartersplayer.billing") && APPInPurchaseActivity.m(APPInPurchaseActivity.this).k() != null && APPInPurchaseActivity.m(APPInPurchaseActivity.this).n() != null && APPInPurchaseActivity.m(APPInPurchaseActivity.this).l() == 0 && APPInPurchaseActivity.m(APPInPurchaseActivity.this).k().equals("") && APPInPurchaseActivity.m(APPInPurchaseActivity.this).n().equals("")) {
                            APPInPurchaseActivity.this.f();
                            String a = purchase.a();
                            String o0 = w.o0(a + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-");
                            try {
                                APPInPurchaseActivity.q(APPInPurchaseActivity.this).obtainMessage(1, "").sendToTarget();
                            } catch (Exception unused) {
                            }
                            APPInPurchaseActivity.r(APPInPurchaseActivity.this).d(o0, a);
                            break;
                        }
                    }
                }
                Log.e("honey", "onQueryPurchasesResponse");
            }
        }

        public c() {
        }

        public void a(com.android.billingclient.api.a aVar) {
            if (aVar.b() == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("com.nst.smartersplayer.billing");
                APPInPurchaseActivity.i(APPInPurchaseActivity.this).g(k.c().c("inapp").b(arrayList).a(), APPInPurchaseActivity.this);
                APPInPurchaseActivity.i(APPInPurchaseActivity.this).f("inapp", new a());
            } else {
                APPInPurchaseActivity.s(APPInPurchaseActivity.this, false);
                Button button = APPInPurchaseActivity.this.r;
                if (button != null) {
                    button.setVisibility(8);
                }
                Button button2 = APPInPurchaseActivity.this.J;
                if (button2 != null) {
                    button2.setVisibility(0);
                }
            }
            Log.e("honey", "onBillingSetupFinished");
        }

        public void b() {
            Log.e("honey", "onBillingServiceDisconnected");
        }
    }

    public class d implements g1.i {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ String c;
        public final /* synthetic */ RegisterClientCallback d;

        public d(boolean[] zArr, String[] strArr, String str, RegisterClientCallback registerClientCallback) {
            this.a = zArr;
            this.b = strArr;
            this.c = str;
            this.d = registerClientCallback;
        }

        public void a(com.android.billingclient.api.a aVar, List list) {
            if (aVar.b() == 0 && list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Purchase purchase = (Purchase) it.next();
                    if (purchase.f().contains("com.nst.smartersplayer.billing")) {
                        this.a[0] = true;
                        this.b[0] = purchase.a();
                        break;
                    }
                }
            }
            if (this.a[0]) {
                APPInPurchaseActivity.r(APPInPurchaseActivity.this).e(APPInPurchaseActivity.t(APPInPurchaseActivity.this), APPInPurchaseActivity.u(APPInPurchaseActivity.this), APPInPurchaseActivity.v(APPInPurchaseActivity.this), APPInPurchaseActivity.w(APPInPurchaseActivity.this), this.c, this.d.getData().getId().intValue(), "true", this.b[0]);
            } else {
                APPInPurchaseActivity.r(APPInPurchaseActivity.this).e(APPInPurchaseActivity.t(APPInPurchaseActivity.this), APPInPurchaseActivity.u(APPInPurchaseActivity.this), APPInPurchaseActivity.v(APPInPurchaseActivity.this), APPInPurchaseActivity.w(APPInPurchaseActivity.this), this.c, this.d.getData().getId().intValue(), "false", "");
            }
            Log.e("honey", "onQueryPurchasesResponse");
        }
    }

    public class e extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public LinearLayout d;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout a;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("2")) {
                        return;
                    }
                    a = e.a(e.this);
                    i = a7.e.p;
                } else {
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                        return;
                    }
                    a = e.a(e.this);
                    i = a7.e.o;
                }
                a.setBackgroundResource(i);
            }
        }

        public e(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(e eVar) {
            return eVar.d;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    dismiss();
                } catch (Exception unused) {
                }
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(APPInPurchaseActivity.m(APPInPurchaseActivity.this).A().equals(m7.a.K0) ? a7.g.h2 : a7.g.g2);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.Ia);
            this.c.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
        }
    }

    public class f extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public LinearLayout d;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout a;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("2")) {
                        return;
                    }
                    a = f.a(f.this);
                    i = a7.e.p;
                } else {
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                        return;
                    }
                    a = f.a(f.this);
                    i = a7.e.o;
                }
                a.setBackgroundResource(i);
            }
        }

        public f(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(f fVar) {
            return fVar.d;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    dismiss();
                } catch (Exception unused) {
                }
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(APPInPurchaseActivity.m(APPInPurchaseActivity.this).A().equals(m7.a.K0) ? a7.g.Z1 : a7.g.Y1);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.Ia);
            this.c.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
        }
    }

    public class g extends Dialog implements View.OnClickListener {
        public final List a;
        public final Context c;
        public Activity d;
        public TextView e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public LinearLayout i;
        public RecyclerView j;
        public q7.g k;
        public LinearLayoutManager l;

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
                            b = g.b(g.this);
                        }
                    } else {
                        b = g.a(g.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = g.b(g.this);
                        }
                    } else {
                        b = g.a(g.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public g(Activity activity, List list, Context context) {
            super(activity);
            this.d = activity;
            this.c = context;
            this.a = list;
            this.l = new LinearLayoutManager(context);
        }

        public static /* synthetic */ LinearLayout a(g gVar) {
            return gVar.h;
        }

        public static /* synthetic */ LinearLayout b(g gVar) {
            return gVar.i;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.O0) {
                    if (APPInPurchaseActivity.o(APPInPurchaseActivity.this).equals("") && APPInPurchaseActivity.p(APPInPurchaseActivity.this).equals("")) {
                        APPInPurchaseActivity.j(APPInPurchaseActivity.this, "Please select any device to activate.");
                    } else {
                        dismiss();
                        if (APPInPurchaseActivity.m(APPInPurchaseActivity.this).k() != null && APPInPurchaseActivity.m(APPInPurchaseActivity.this).n() != null && APPInPurchaseActivity.m(APPInPurchaseActivity.this).l() != 0 && !APPInPurchaseActivity.m(APPInPurchaseActivity.this).k().equals("") && !APPInPurchaseActivity.m(APPInPurchaseActivity.this).n().equals("")) {
                            APPInPurchaseActivity.this.f();
                            APPInPurchaseActivity.r(APPInPurchaseActivity.this).i(APPInPurchaseActivity.m(APPInPurchaseActivity.this).k(), w.o0(APPInPurchaseActivity.m(APPInPurchaseActivity.this).k() + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"), APPInPurchaseActivity.m(APPInPurchaseActivity.this).l(), APPInPurchaseActivity.p(APPInPurchaseActivity.this), APPInPurchaseActivity.w(APPInPurchaseActivity.this), APPInPurchaseActivity.v(APPInPurchaseActivity.this));
                        }
                    }
                } else if (view.getId() != a7.f.X0) {
                } else {
                    dismiss();
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(APPInPurchaseActivity.m(APPInPurchaseActivity.this).A().equals(m7.a.K0) ? a7.g.l2 : a7.g.k2);
            this.f = findViewById(a7.f.O0);
            this.g = findViewById(a7.f.X0);
            this.h = findViewById(a7.f.V8);
            this.i = findViewById(a7.f.Ia);
            this.j = findViewById(a7.f.Ed);
            TextView findViewById = findViewById(a7.f.fm);
            this.e = findViewById;
            findViewById.setText("Devices List");
            this.e.setTypeface((Typeface) null, 1);
            q7.g gVar = new q7.g(this.c, this.a);
            this.k = gVar;
            this.j.setAdapter(gVar);
            this.j.setLayoutManager(this.l);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            TextView textView = this.f;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.g;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class h extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public LinearLayout g;
        public LinearLayout h;

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
                            b = h.b(h.this);
                        }
                    } else {
                        b = h.a(h.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = h.b(h.this);
                        }
                    } else {
                        b = h.a(h.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public h(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(h hVar) {
            return hVar.g;
        }

        public static /* synthetic */ LinearLayout b(h hVar) {
            return hVar.h;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.u1) {
                    dismiss();
                    APPInPurchaseActivity.m(APPInPurchaseActivity.this).a();
                    try {
                        new ExternalPlayerDataBase(APPInPurchaseActivity.h(APPInPurchaseActivity.this)).removeAllPlayers();
                        SharepreferenceDBHandler.setLivePlayer("default", "Built-in Player (Hardware/Software Decoder)", APPInPurchaseActivity.h(APPInPurchaseActivity.this));
                        SharepreferenceDBHandler.setVODPlayer("default", "Default Player", APPInPurchaseActivity.h(APPInPurchaseActivity.this));
                        SharepreferenceDBHandler.setSeriesPlayer("default", "Default Player", APPInPurchaseActivity.h(APPInPurchaseActivity.this));
                        SharepreferenceDBHandler.setRecordingsPlayer("default", "Default Player", APPInPurchaseActivity.h(APPInPurchaseActivity.this));
                        new LiveStreamDBHandler(APPInPurchaseActivity.h(APPInPurchaseActivity.this)).updatePasswordStatusForAll();
                        new LiveStreamDBHandler(APPInPurchaseActivity.h(APPInPurchaseActivity.this)).deleteAllPasswordData();
                    } catch (Exception unused) {
                    }
                    APPInPurchaseActivity aPPInPurchaseActivity = APPInPurchaseActivity.this;
                    APPInPurchaseActivity.j(aPPInPurchaseActivity, aPPInPurchaseActivity.getResources().getString(a7.j.c3));
                    APPInPurchaseActivity.k(APPInPurchaseActivity.this, false);
                } else if (view.getId() != a7.f.h1) {
                } else {
                    dismiss();
                }
            } catch (Exception unused2) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(APPInPurchaseActivity.m(APPInPurchaseActivity.this).A().equals(m7.a.K0) ? a7.g.b2 : a7.g.a2);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.g = findViewById(a7.f.V8);
            this.h = findViewById(a7.f.Ia);
            this.f = findViewById(a7.f.fm);
            this.e = findViewById(a7.f.um);
            this.f.setText("Logout?");
            this.f.setTypeface((Typeface) null, 1);
            this.e.setText(APPInPurchaseActivity.this.getResources().getString(a7.j.e3));
            this.g.setVisibility(0);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final View a;

        public i(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            View view3;
            int i;
            if (z) {
                View view4 = this.a;
                if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("2")) {
                    return;
                }
                view3 = this.a;
                i = a7.e.k1;
            } else {
                if (z || (view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("2")) {
                    return;
                }
                view3 = this.a;
                i = a7.e.o;
            }
            view3.setBackgroundResource(i);
        }
    }

    private void H(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public static /* synthetic */ Context h(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.L;
    }

    public static /* synthetic */ g1.c i(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.e0;
    }

    public static /* synthetic */ void j(APPInPurchaseActivity aPPInPurchaseActivity, String str) {
        aPPInPurchaseActivity.H(str);
    }

    public static /* synthetic */ void k(APPInPurchaseActivity aPPInPurchaseActivity, boolean z) {
        aPPInPurchaseActivity.x(z);
    }

    public static /* synthetic */ u7.a m(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.R;
    }

    public static /* synthetic */ String o(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.X;
    }

    public static /* synthetic */ String p(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.W;
    }

    public static /* synthetic */ Handler q(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.g0;
    }

    public static /* synthetic */ n7.b r(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.N;
    }

    public static /* synthetic */ boolean s(APPInPurchaseActivity aPPInPurchaseActivity, boolean z) {
        aPPInPurchaseActivity.M = z;
        return z;
    }

    public static /* synthetic */ String t(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.S;
    }

    public static /* synthetic */ String u(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.T;
    }

    public static /* synthetic */ String v(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.P;
    }

    public static /* synthetic */ String w(APPInPurchaseActivity aPPInPurchaseActivity) {
        return aPPInPurchaseActivity.O;
    }

    public void B0(RegisterClientCallback registerClientCallback) {
        Resources resources;
        int i2;
        String message;
        w.X();
        if (registerClientCallback != null) {
            try {
                if (registerClientCallback.getResult() == null || !registerClientCallback.getResult().equals("success")) {
                    if (registerClientCallback.getResult() == null || !registerClientCallback.getResult().equals("error")) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (registerClientCallback.getMessage() != null) {
                        message = registerClientCallback.getMessage();
                        H(message);
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                } else if (registerClientCallback.getSc() != null) {
                    if (!registerClientCallback.getSc().equalsIgnoreCase(w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b))) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (registerClientCallback.getData() != null) {
                        this.R.O(this.S, this.T, registerClientCallback.getData().getId().intValue());
                        H(getResources().getString(a7.j.n));
                        if (this.S != null && this.T != null && registerClientCallback.getData().getId().intValue() != 0 && !this.S.equals("") && !this.T.equals("")) {
                            f();
                            String o0 = w.o0(this.S + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-");
                            this.R.Q(Boolean.FALSE);
                            this.e0.f("inapp", new d(new boolean[]{false}, new String[]{""}, o0, registerClientCallback));
                        }
                        x(false);
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                } else {
                    resources = getResources();
                    i2 = a7.j.e7;
                }
                message = resources.getString(i2);
                H(message);
            } catch (Exception unused) {
            }
        }
        Log.e("honey", "registerClientResponse:");
    }

    public final void C() {
        this.q.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
    }

    public final void D() {
        Button button = this.r;
        button.setOnFocusChangeListener(new i(button));
        Button button2 = this.J;
        button2.setOnFocusChangeListener(new i(button2));
        Button button3 = this.g;
        button3.setOnFocusChangeListener(new i(button3));
        Button button4 = this.n;
        button4.setOnFocusChangeListener(new i(button4));
        Button button5 = this.C;
        button5.setOnFocusChangeListener(new i(button5));
        Button button6 = this.I;
        button6.setOnFocusChangeListener(new i(button6));
        LinearLayout linearLayout = this.K;
        linearLayout.setOnFocusChangeListener(new i(linearLayout));
        Button button7 = this.o;
        button7.setOnFocusChangeListener(new i(button7));
        Button button8 = this.p;
        button8.setOnFocusChangeListener(new i(button8));
    }

    public final void E() {
        try {
            g1.c cVar = this.e0;
            if (cVar == null || this.f0 == null) {
                return;
            }
            cVar.d(this, g1.f.a().b(this.f0).a());
        } catch (Exception unused) {
        }
    }

    public void F(String str, String str2) {
        this.X = str;
        this.W = str2;
    }

    public final void G() {
        u7.a aVar = this.R;
        if (aVar == null || aVar.k() == null || this.R.n() == null || this.R.l() == 0 || this.R.k().equals("") || this.R.n().equals("")) {
            return;
        }
        f();
        this.N.f(this.R.k(), this.R.n(), w.o0(this.R.k() + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"), this.R.l());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[Catch: Exception -> 0x00e9, TryCatch #0 {Exception -> 0x00e9, blocks: (B:7:0x0005, B:9:0x000b, B:11:0x0017, B:13:0x001d, B:15:0x003e, B:17:0x0044, B:19:0x004f, B:21:0x005f, B:22:0x009e, B:23:0x007e, B:25:0x008b, B:26:0x008f, B:27:0x0093, B:28:0x00a2, B:29:0x00a8, B:30:0x00ac, B:31:0x00b0, B:32:0x00b7, B:33:0x00be, B:35:0x00c4, B:37:0x00d0, B:39:0x00d6, B:40:0x00db, B:41:0x00e2), top: B:6:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J(com.nst.iptvsmarterstvbox.model.callback.BillingIsPurchasedCallback r5) {
        /*
            r4 = this;
            m7.w.X()
            if (r5 == 0) goto Le9
            java.lang.String r0 = r5.getResult()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Lbe
            java.lang.String r0 = r5.getResult()     // Catch: java.lang.Exception -> Le9
            java.lang.String r1 = "success"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Lbe
            java.lang.String r0 = r5.getSc()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Lb7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le9
            r0.<init>()     // Catch: java.lang.Exception -> Le9
            java.lang.String r1 = "Vu6HilnbLo63*KJHGFkugu345*&^klih*"
            r0.append(r1)     // Catch: java.lang.Exception -> Le9
            java.lang.String r1 = b7.b.b     // Catch: java.lang.Exception -> Le9
            r0.append(r1)     // Catch: java.lang.Exception -> Le9
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Le9
            java.lang.String r0 = m7.w.o0(r0)     // Catch: java.lang.Exception -> Le9
            java.lang.String r1 = r5.getSc()     // Catch: java.lang.Exception -> Le9
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Lb0
            com.nst.iptvsmarterstvbox.model.pojo.BillingIsPurchasedPojo r0 = r5.getData()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto La2
            com.nst.iptvsmarterstvbox.model.pojo.BillingIsPurchasedPojo r0 = r5.getData()     // Catch: java.lang.Exception -> Le9
            java.lang.Boolean r0 = r0.getIsPurchased()     // Catch: java.lang.Exception -> Le9
            r1 = 0
            if (r0 == 0) goto L7e
            com.nst.iptvsmarterstvbox.model.pojo.BillingIsPurchasedPojo r0 = r5.getData()     // Catch: java.lang.Exception -> Le9
            java.lang.Boolean r0 = r0.getIsPurchased()     // Catch: java.lang.Exception -> Le9
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> Le9
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto L7e
            android.widget.LinearLayout r5 = r4.z     // Catch: java.lang.Exception -> Le9
            r5.setVisibility(r1)     // Catch: java.lang.Exception -> Le9
            android.widget.TextView r5 = r4.w     // Catch: java.lang.Exception -> Le9
            android.content.res.Resources r0 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r3 = a7.j.T7     // Catch: java.lang.Exception -> Le9
            java.lang.String r0 = r0.getString(r3)     // Catch: java.lang.Exception -> Le9
            r5.setText(r0)     // Catch: java.lang.Exception -> Le9
            u7.a r5 = r4.R     // Catch: java.lang.Exception -> Le9
            r5.Q(r2)     // Catch: java.lang.Exception -> Le9
            u7.a r5 = r4.R     // Catch: java.lang.Exception -> Le9
            r5.P()     // Catch: java.lang.Exception -> Le9
            goto L9e
        L7e:
            u7.a r0 = r4.R     // Catch: java.lang.Exception -> Le9
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> Le9
            r0.Q(r2)     // Catch: java.lang.Exception -> Le9
            java.lang.String r0 = r5.getMessage()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto L93
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Exception -> Le9
        L8f:
            r4.H(r5)     // Catch: java.lang.Exception -> Le9
            goto L9e
        L93:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
            java.lang.String r5 = r5.getString(r0)     // Catch: java.lang.Exception -> Le9
            goto L8f
        L9e:
            r4.x(r1)     // Catch: java.lang.Exception -> Le9
            goto Le9
        La2:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
        La8:
            java.lang.String r5 = r5.getString(r0)     // Catch: java.lang.Exception -> Le9
        Lac:
            r4.H(r5)     // Catch: java.lang.Exception -> Le9
            goto Le9
        Lb0:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
            goto La8
        Lb7:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
            goto La8
        Lbe:
            java.lang.String r0 = r5.getResult()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Le2
            java.lang.String r0 = r5.getResult()     // Catch: java.lang.Exception -> Le9
            java.lang.String r1 = "error"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Le2
            java.lang.String r0 = r5.getMessage()     // Catch: java.lang.Exception -> Le9
            if (r0 == 0) goto Ldb
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Exception -> Le9
            goto Lac
        Ldb:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
            goto La8
        Le2:
            android.content.res.Resources r5 = r4.getResources()     // Catch: java.lang.Exception -> Le9
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Le9
            goto La8
        Le9:
            java.lang.String r5 = "honey"
            java.lang.String r0 = "isPurchasedResponse:"
            android.util.Log.e(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.APPInPurchaseActivity.J(com.nst.iptvsmarterstvbox.model.callback.BillingIsPurchasedCallback):void");
    }

    public void L0(BillingLoginClientCallback billingLoginClientCallback) {
        Resources resources;
        int i2;
        String message;
        w.X();
        if (billingLoginClientCallback != null) {
            try {
                if (billingLoginClientCallback.getResult() == null || !billingLoginClientCallback.getResult().equals("success")) {
                    if (billingLoginClientCallback.getResult() == null || !billingLoginClientCallback.getResult().equals("error")) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (billingLoginClientCallback.getMessage() != null) {
                        message = billingLoginClientCallback.getMessage();
                        H(message);
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                } else if (billingLoginClientCallback.getSc() != null) {
                    if (!billingLoginClientCallback.getSc().equalsIgnoreCase(w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b))) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (billingLoginClientCallback.getData() != null) {
                        this.R.O(this.U, this.V, billingLoginClientCallback.getData().getId().intValue());
                        if (billingLoginClientCallback.getMessage() == null || billingLoginClientCallback.getMessage().equals("Max Connection Reached")) {
                            this.R.Q(Boolean.FALSE);
                            this.R.T(Boolean.TRUE);
                        } else {
                            f();
                            String o0 = w.o0(this.U + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-");
                            this.R.Q(Boolean.FALSE);
                            this.N.e(this.U, this.V, this.P, this.O, o0, billingLoginClientCallback.getData().getId().intValue(), "false", "");
                        }
                        H(getResources().getString(a7.j.b3));
                        x(false);
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                } else {
                    resources = getResources();
                    i2 = a7.j.e7;
                }
                message = resources.getString(i2);
                H(message);
            } catch (Exception unused) {
            }
        }
        Log.e("honey", "loginClientResponse:");
    }

    public void N0(BillingUpdateDevicesCallback billingUpdateDevicesCallback) {
        Resources resources;
        int i2;
        String message;
        w.X();
        if (billingUpdateDevicesCallback != null) {
            try {
                if (billingUpdateDevicesCallback.getResult() != null && billingUpdateDevicesCallback.getResult().equals("success")) {
                    u7.a aVar = this.R;
                    Boolean bool = Boolean.FALSE;
                    aVar.T(bool);
                    if (billingUpdateDevicesCallback.getSc() != null) {
                        if (billingUpdateDevicesCallback.getSc().equalsIgnoreCase(w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b))) {
                            if (this.R.k() != null && this.R.n() != null && this.R.l() != 0 && !this.R.k().equals("") && !this.R.n().equals("")) {
                                f();
                                String o0 = w.o0(this.R.k() + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-");
                                this.R.Q(bool);
                                this.N.e(this.R.k(), this.R.n(), this.P, this.O, o0, this.R.l(), "false", "");
                            }
                            x(false);
                        } else {
                            resources = getResources();
                            i2 = a7.j.e7;
                        }
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                } else if (billingUpdateDevicesCallback.getResult() == null || !billingUpdateDevicesCallback.getResult().equals("error")) {
                    resources = getResources();
                    i2 = a7.j.e7;
                } else if (billingUpdateDevicesCallback.getMessage() != null) {
                    message = billingUpdateDevicesCallback.getMessage();
                    H(message);
                } else {
                    resources = getResources();
                    i2 = a7.j.e7;
                }
                message = resources.getString(i2);
                H(message);
            } catch (Exception unused) {
            }
        }
        Log.e("honey", "BillingUpdateDevicesCallback:");
    }

    public void a() {
        w.M0(this);
    }

    public void c(com.android.billingclient.api.a aVar, List list) {
        StringBuilder sb;
        String str;
        Log.e("honey", "onSkuDetailsResponse");
        int b2 = aVar.b();
        String a2 = aVar.a();
        switch (b2) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.M = false;
                sb = new StringBuilder();
                break;
            case 0:
                this.M = true;
                Log.i("honey", "onSkuDetailsResponse: " + b2 + " " + a2);
                if (list == null || list.isEmpty()) {
                    str = "onSkuDetailsResponse: Found null or empty SkuDetails. Check to see if the SKUs you requested are correctly published in the Google Play Console.";
                    Log.e("honey", str);
                }
                SkuDetails skuDetails = (SkuDetails) list.get(0);
                this.f0 = skuDetails;
                if (skuDetails != null) {
                    try {
                        this.Y = skuDetails.a();
                        this.Z = this.f0.b();
                        TextView textView = this.D;
                        if (textView != null) {
                            textView.setText("One-time payment " + this.Y + " " + this.Z);
                        }
                        TextView textView2 = this.F;
                        if (textView2 != null) {
                            textView2.setText("One-time payment " + this.Y + " " + this.Z);
                        }
                        TextView textView3 = this.G;
                        if (textView3 != null) {
                            textView3.setText("One-time payment " + this.Y + " " + this.Z);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            case 1:
                this.M = false;
                sb = new StringBuilder();
                break;
            default:
                sb = new StringBuilder();
                break;
        }
        sb.append("onSkuDetailsResponse: ");
        sb.append(b2);
        sb.append(" ");
        sb.append(a2);
        str = sb.toString();
        Log.e("honey", str);
    }

    public void d(String str) {
        w.X();
        H(str);
    }

    public void e(com.android.billingclient.api.a aVar, List list) {
        if (aVar.b() == 0 && list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Purchase purchase = (Purchase) it.next();
                if (purchase.c() == 1) {
                    String a2 = purchase.a();
                    if (purchase.f().contains("com.nst.smartersplayer.billing")) {
                        this.R.Q(Boolean.FALSE);
                        if (this.R.k() != null && this.R.n() != null && this.R.l() != 0 && !this.R.k().equals("") && !this.R.n().equals("")) {
                            f();
                            this.N.c(this.R.k(), this.R.n(), this.P, this.O, w.o0(this.R.k() + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"), this.R.l(), "true", a2);
                        }
                    }
                    Log.e("honey", "purchased");
                    if (!purchase.g()) {
                        this.e0.a(g1.a.b().b(purchase.d()).a(), this.h0);
                    }
                }
            }
        }
        Log.e("honey", "onPurchasesUpdated");
    }

    public void f() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.Q = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void g(BillingGetDevicesCallback billingGetDevicesCallback) {
        Resources resources;
        int i2;
        String message;
        w.X();
        if (billingGetDevicesCallback != null) {
            try {
                if (billingGetDevicesCallback.getResult() == null || !billingGetDevicesCallback.getResult().equals("success")) {
                    if (billingGetDevicesCallback.getResult() == null || !billingGetDevicesCallback.getResult().equals("error")) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (billingGetDevicesCallback.getMessage() != null) {
                        message = billingGetDevicesCallback.getMessage();
                        H(message);
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                    message = resources.getString(i2);
                    H(message);
                } else {
                    if (billingGetDevicesCallback.getSc() != null) {
                        if (!billingGetDevicesCallback.getSc().equalsIgnoreCase(w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b))) {
                            resources = getResources();
                            i2 = a7.j.e7;
                        } else if (billingGetDevicesCallback.getData() == null || billingGetDevicesCallback.getData().getDevices() == null) {
                            message = "No Device Found";
                            H(message);
                        } else {
                            this.X = "";
                            this.W = "";
                            new g(this, billingGetDevicesCallback.getData().getDevices(), this.L).show();
                        }
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                    message = resources.getString(i2);
                    H(message);
                }
            } catch (Exception unused) {
            }
        }
        Log.e("honey", "BillingGetDevicesCallback:");
    }

    public void m0(BillingCheckGPACallback billingCheckGPACallback) {
        Resources resources;
        int i2;
        w.X();
        if (billingCheckGPACallback != null) {
            try {
                if (billingCheckGPACallback.getResult() == null || !billingCheckGPACallback.getResult().equals("success")) {
                    if (billingCheckGPACallback.getResult() == null || !billingCheckGPACallback.getResult().equals("error")) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else if (billingCheckGPACallback.getMessage() == null || !billingCheckGPACallback.getMessage().equals("Order ID Not Found")) {
                        resources = getResources();
                        i2 = a7.j.e7;
                    } else {
                        this.a.setVisibility(8);
                        (!this.M ? this.H : this.c).setVisibility(0);
                        this.k.setVisibility(8);
                        this.B.setVisibility(0);
                        this.A.setVisibility(8);
                    }
                    H(resources.getString(i2));
                } else {
                    if (billingCheckGPACallback.getSc() != null) {
                        if (!billingCheckGPACallback.getSc().equalsIgnoreCase(w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b))) {
                            resources = getResources();
                            i2 = a7.j.e7;
                        } else if (billingCheckGPACallback.getData() == null || billingCheckGPACallback.getData().getEmail() == null) {
                            resources = getResources();
                            i2 = a7.j.e7;
                        } else {
                            this.a.setVisibility(8);
                            this.c.setVisibility(8);
                            this.H.setVisibility(8);
                            this.k.setVisibility(0);
                        }
                    } else {
                        resources = getResources();
                        i2 = a7.j.e7;
                    }
                    H(resources.getString(i2));
                }
            } catch (Exception unused) {
            }
        }
        Log.e("honey", "BillingClearDevicesCallback:");
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        Dialog fVar;
        EditText editText;
        EditText editText2;
        if (view.getId() == a7.f.x0) {
            this.a.setVisibility(8);
            this.k.setVisibility(0);
            this.c.setVisibility(8);
            this.H.setVisibility(8);
            return;
        }
        if (view.getId() != a7.f.da) {
            if (view.getId() != a7.f.k0) {
                if (view.getId() == a7.f.aa || view.getId() == a7.f.ba || view.getId() == a7.f.ca) {
                    this.a.setVisibility(8);
                    this.c.setVisibility(8);
                    this.H.setVisibility(8);
                    this.k.setVisibility(0);
                    return;
                }
                if (view.getId() == a7.f.u0) {
                    if (!y() || (editText2 = this.l) == null || this.m == null) {
                        return;
                    }
                    this.U = editText2.getText().toString().trim();
                    this.V = this.m.getText().toString().trim();
                    f();
                    this.N.g(this.U, this.V, this.P, this.O, w.o0(this.U + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"));
                    return;
                }
                if (view.getId() == a7.f.J0) {
                    if (!z() || (editText = this.d) == null || this.e == null) {
                        return;
                    }
                    this.S = editText.getText().toString().trim();
                    this.T = this.e.getText().toString().trim();
                    f();
                    this.N.h(this.S, this.T, this.P, this.O, w.o0(this.S + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"));
                    return;
                }
                if (view.getId() == a7.f.Yj) {
                    fVar = new h(this);
                } else if (view.getId() != a7.f.F4) {
                    if (view.getId() == a7.f.t0) {
                        G();
                        return;
                    }
                    if (view.getId() == a7.f.v0 || view.getId() == a7.f.w0) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse("https://users.iptvsmarters.com/cart.php?a=add&pid=1&currency=2"));
                            startActivity(intent);
                            return;
                        } catch (Exception unused) {
                            fVar = new f(this);
                        }
                    } else {
                        if (view.getId() != a7.f.m8) {
                            return;
                        }
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse("https://users.iptvsmarters.com/password/reset"));
                            startActivity(intent2);
                            return;
                        } catch (Exception unused2) {
                            fVar = new e(this);
                        }
                    }
                }
            }
            onBackPressed();
            return;
        }
        try {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setData(Uri.parse("https://users.iptvsmarters.com/cart.php?a=add&pid=1&currency=2"));
            startActivity(intent3);
            return;
        } catch (Exception unused3) {
            fVar = new f(this);
        }
        fVar.show();
    }

    public void onClickButton(View view) {
        if (!this.M) {
            H("You can purchase it from your mobile and then logged in with that details here.");
        } else if (view.getId() == a7.f.Wc) {
            E();
        }
    }

    public void onCreate(Bundle bundle) {
        this.L = this;
        super.onCreate(bundle);
        u7.a aVar = new u7.a(this.L);
        this.R = aVar;
        String A = aVar.A();
        setContentView(A.equals(m7.a.K0) ? a7.g.j : a7.g.i);
        w.Y(this);
        this.a = findViewById(a7.f.za);
        this.c = findViewById(a7.f.fa);
        this.d = findViewById(a7.f.q3);
        this.e = findViewById(a7.f.r3);
        this.f = findViewById(a7.f.p3);
        this.g = findViewById(a7.f.J0);
        this.h = findViewById(a7.f.aa);
        this.i = findViewById(a7.f.ba);
        this.j = findViewById(a7.f.ca);
        this.k = findViewById(a7.f.ea);
        this.l = findViewById(a7.f.n3);
        this.m = findViewById(a7.f.o3);
        this.n = findViewById(a7.f.u0);
        this.o = findViewById(a7.f.x0);
        this.p = findViewById(a7.f.k0);
        this.q = findViewById(a7.f.da);
        this.r = findViewById(a7.f.Wc);
        this.s = findViewById(a7.f.Yj);
        this.t = findViewById(a7.f.F4);
        this.u = findViewById(a7.f.Qi);
        this.v = findViewById(a7.f.te);
        this.w = findViewById(a7.f.Ch);
        this.x = findViewById(a7.f.N8);
        this.y = findViewById(a7.f.n7);
        this.z = findViewById(a7.f.ta);
        this.A = findViewById(a7.f.u8);
        this.B = findViewById(a7.f.t8);
        this.C = findViewById(a7.f.t0);
        this.D = findViewById(a7.f.Tk);
        this.E = findViewById(a7.f.sc);
        this.F = findViewById(a7.f.Uk);
        this.G = findViewById(a7.f.Vk);
        this.H = findViewById(a7.f.ga);
        this.I = findViewById(a7.f.v0);
        this.J = findViewById(a7.f.w0);
        this.K = findViewById(a7.f.m8);
        this.O = w.I(this.L);
        this.P = w.E();
        try {
            this.g0 = new a(Looper.getMainLooper());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (A.equals(m7.a.K0)) {
            this.E.setVisibility(8);
        }
        this.h0 = new b();
        this.N = new n7.b(this.L, this);
        g1.c a2 = g1.c.e(this.L).b().d(this).a();
        this.e0 = a2;
        a2.h(new c());
        x(false);
        C();
        D();
    }

    public void onDestroy() {
        g1.c cVar = this.e0;
        if (cVar != null && cVar.c()) {
            this.e0.b();
            this.e0 = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:7:0x0005, B:9:0x000b, B:11:0x0017, B:13:0x001d, B:15:0x003e, B:17:0x0044, B:19:0x004f, B:21:0x005f, B:22:0x0082, B:23:0x008d, B:24:0x0093, B:25:0x0097, B:26:0x009b, B:27:0x00a2, B:28:0x00a9, B:30:0x00af, B:32:0x00bb, B:34:0x00c1, B:35:0x00c6, B:36:0x00cd), top: B:6:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q0(com.nst.iptvsmarterstvbox.model.callback.BillingAddOrderCallback r4) {
        /*
            r3 = this;
            m7.w.X()
            if (r4 == 0) goto Ld4
            java.lang.String r0 = r4.getResult()     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto La9
            java.lang.String r0 = r4.getResult()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = "success"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto La9
            java.lang.String r0 = r4.getSc()     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto La2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld4
            r0.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = "Vu6HilnbLo63*KJHGFkugu345*&^klih*"
            r0.append(r1)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = b7.b.b     // Catch: java.lang.Exception -> Ld4
            r0.append(r1)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r0 = m7.w.o0(r0)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = r4.getSc()     // Catch: java.lang.Exception -> Ld4
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto L9b
            com.nst.iptvsmarterstvbox.model.pojo.BillingAddOrderPojo r0 = r4.getData()     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto L8d
            com.nst.iptvsmarterstvbox.model.pojo.BillingAddOrderPojo r0 = r4.getData()     // Catch: java.lang.Exception -> Ld4
            java.lang.Boolean r0 = r0.getIsPurchased()     // Catch: java.lang.Exception -> Ld4
            r1 = 0
            if (r0 == 0) goto L82
            com.nst.iptvsmarterstvbox.model.pojo.BillingAddOrderPojo r4 = r4.getData()     // Catch: java.lang.Exception -> Ld4
            java.lang.Boolean r4 = r4.getIsPurchased()     // Catch: java.lang.Exception -> Ld4
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> Ld4
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Exception -> Ld4
            if (r4 == 0) goto L82
            android.widget.LinearLayout r4 = r3.z     // Catch: java.lang.Exception -> Ld4
            r4.setVisibility(r1)     // Catch: java.lang.Exception -> Ld4
            android.widget.TextView r4 = r3.w     // Catch: java.lang.Exception -> Ld4
            android.content.res.Resources r1 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r2 = a7.j.U7     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Exception -> Ld4
            r4.setText(r1)     // Catch: java.lang.Exception -> Ld4
            u7.a r4 = r3.R     // Catch: java.lang.Exception -> Ld4
            r4.Q(r0)     // Catch: java.lang.Exception -> Ld4
            u7.a r4 = r3.R     // Catch: java.lang.Exception -> Ld4
            r4.P()     // Catch: java.lang.Exception -> Ld4
            r4 = 1
            r3.x(r4)     // Catch: java.lang.Exception -> Ld4
            goto Ld4
        L82:
            u7.a r4 = r3.R     // Catch: java.lang.Exception -> Ld4
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> Ld4
            r4.Q(r0)     // Catch: java.lang.Exception -> Ld4
            r3.x(r1)     // Catch: java.lang.Exception -> Ld4
            goto Ld4
        L8d:
            android.content.res.Resources r4 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Ld4
        L93:
            java.lang.String r4 = r4.getString(r0)     // Catch: java.lang.Exception -> Ld4
        L97:
            r3.H(r4)     // Catch: java.lang.Exception -> Ld4
            goto Ld4
        L9b:
            android.content.res.Resources r4 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Ld4
            goto L93
        La2:
            android.content.res.Resources r4 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Ld4
            goto L93
        La9:
            java.lang.String r0 = r4.getResult()     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto Lcd
            java.lang.String r0 = r4.getResult()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = "error"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto Lcd
            java.lang.String r0 = r4.getMessage()     // Catch: java.lang.Exception -> Ld4
            if (r0 == 0) goto Lc6
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Exception -> Ld4
            goto L97
        Lc6:
            android.content.res.Resources r4 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Ld4
            goto L93
        Lcd:
            android.content.res.Resources r4 = r3.getResources()     // Catch: java.lang.Exception -> Ld4
            int r0 = a7.j.e7     // Catch: java.lang.Exception -> Ld4
            goto L93
        Ld4:
            java.lang.String r4 = "honey"
            java.lang.String r0 = "addOrderResponse:"
            android.util.Log.e(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.APPInPurchaseActivity.q0(com.nst.iptvsmarterstvbox.model.callback.BillingAddOrderCallback):void");
    }

    public final void x(boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        Resources resources;
        int i2;
        if (this.R.k() == null || this.R.n() == null || this.R.l() == 0 || this.R.k().equals("") || this.R.n().equals("")) {
            this.y.setVisibility(8);
            this.x.setVisibility(8);
            this.c.setVisibility(8);
            this.H.setVisibility(8);
            this.a.setVisibility(0);
            this.z.setVisibility(8);
            linearLayout = this.v;
        } else {
            this.u.setText(this.R.k());
            this.v.setVisibility(0);
            this.k.setVisibility(8);
            this.c.setVisibility(8);
            this.H.setVisibility(8);
            this.a.setVisibility(8);
            this.y.setVisibility(8);
            if (this.R.u().booleanValue()) {
                linearLayout2 = this.x;
            } else {
                this.x.setVisibility(8);
                if (this.R.m().booleanValue()) {
                    this.z.setVisibility(0);
                    if (z) {
                        textView = this.w;
                        resources = getResources();
                        i2 = a7.j.U7;
                    } else {
                        textView = this.w;
                        resources = getResources();
                        i2 = a7.j.T7;
                    }
                    textView.setText(resources.getString(i2));
                    return;
                }
                linearLayout2 = this.y;
            }
            linearLayout2.setVisibility(0);
            linearLayout = this.z;
        }
        linearLayout.setVisibility(8);
    }

    public final boolean y() {
        String str;
        EditText editText = this.l;
        if (editText == null || this.m == null) {
            return false;
        }
        this.U = editText.getText().toString().trim();
        this.V = this.m.getText().toString().trim();
        if (this.U.length() == 0) {
            str = "Please enter your email.";
        } else {
            if (this.V.length() != 0) {
                return true;
            }
            str = "Please enter your password.";
        }
        H(str);
        return false;
    }

    public final boolean z() {
        String str;
        EditText editText = this.d;
        if (editText == null || this.e == null || this.f == null) {
            return false;
        }
        this.S = editText.getText().toString().trim();
        this.T = this.e.getText().toString().trim();
        String trim = this.f.getText().toString().trim();
        if (this.S.length() == 0) {
            str = "Please enter any email.";
        } else if (this.T.length() == 0) {
            str = "Please enter any password.";
        } else if (trim.length() == 0) {
            str = "Please enter confirm password.";
        } else {
            if (this.T.equals(trim)) {
                return true;
            }
            str = "Please make sure your passwords match.";
        }
        H(str);
        return false;
    }
}
