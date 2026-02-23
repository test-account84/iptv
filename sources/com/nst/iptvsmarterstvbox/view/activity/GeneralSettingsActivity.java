package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.Calendar;
import m7.w;
import p7.B;
import p7.C;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GeneralSettingsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public AppBarLayout A;
    public Button B;
    public Button C;
    public TextView D;
    public TextView E;
    public TextView F;
    public Spinner G;
    public EditText H;
    public ImageView I;
    public CheckBox J;
    public TextView K;
    public FrameLayout L;
    public FrameLayout M;
    public FrameLayout N;
    public CheckBox O;
    public CheckBox P;
    public CheckBox Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public CheckBox U;
    public LinearLayout V;
    public LinearLayout W;
    public LinearLayout X;
    public LinearLayout Y;
    public ImageView Z;
    public SharedPreferences d;
    public SharedPreferences.Editor e;
    public FrameLayout e0;
    public SharedPreferences f;
    public TextView f0;
    public SharedPreferences.Editor g;
    public Context g0;
    public SharedPreferences h;
    public androidx.appcompat.app.a h0;
    public SharedPreferences.Editor i;
    public LiveStreamDBHandler j;
    public SharedPreferences o;
    public SharedPreferences p;
    public SharedPreferences.Editor q;
    public SharedPreferences.Editor r;
    public SharedPreferences.Editor s;
    public SharedPreferences t;
    public String u;
    public u7.a v;
    public CheckBox w;
    public CheckBox x;
    public CheckBox y;
    public Toolbar z;
    public DatabaseUpdatedStatusDBModel k = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel l = new DatabaseUpdatedStatusDBModel();
    public String m = "";
    public String n = "";
    public String i0 = "mobile";
    public boolean j0 = false;
    public int k0 = m7.a.r0;
    public int l0 = m7.a.s0;
    public String m0 = m7.a.t0;
    public Thread n0 = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(GeneralSettingsActivity.w1(GeneralSettingsActivity.this));
        }
    }

    public class b extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public LinearLayout f;
        public LinearLayout g;

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
            int id = view.getId();
            if (id == a7.f.u1) {
                try {
                    w.r(GeneralSettingsActivity.w1(GeneralSettingsActivity.this));
                    GeneralSettingsActivity generalSettingsActivity = GeneralSettingsActivity.this;
                    Toast.makeText(generalSettingsActivity, generalSettingsActivity.getResources().getString(a7.j.a0), 0).show();
                } catch (Exception unused) {
                }
            } else if (id == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(new u7.a(GeneralSettingsActivity.w1(GeneralSettingsActivity.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.f = findViewById(a7.f.V8);
            this.g = findViewById(a7.f.Ia);
            TextView findViewById = findViewById(a7.f.um);
            this.e = findViewById;
            findViewById.setText(GeneralSettingsActivity.w1(GeneralSettingsActivity.this).getResources().getString(a7.j.U8));
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            if (i == 0) {
                textView = GeneralSettingsActivity.this.R;
                str = "10";
            } else if (i == 1) {
                textView = GeneralSettingsActivity.this.R;
                str = "20";
            } else if (i == 2) {
                textView = GeneralSettingsActivity.this.R;
                str = "30";
            } else if (i == 3) {
                textView = GeneralSettingsActivity.this.R;
                str = "40";
            } else if (i == 4) {
                textView = GeneralSettingsActivity.this.R;
                str = "50";
            } else {
                if (i != 5) {
                    return;
                }
                textView = GeneralSettingsActivity.this.R;
                str = "100";
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            if (i == 0) {
                textView = GeneralSettingsActivity.this.S;
                str = "5";
            } else if (i == 1) {
                textView = GeneralSettingsActivity.this.S;
                str = "10";
            } else if (i == 2) {
                textView = GeneralSettingsActivity.this.S;
                str = "20";
            } else if (i == 3) {
                textView = GeneralSettingsActivity.this.S;
                str = "30";
            } else if (i == 4) {
                textView = GeneralSettingsActivity.this.S;
                str = "40";
            } else {
                if (i != 5) {
                    return;
                }
                textView = GeneralSettingsActivity.this.S;
                str = "50";
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            if (i == 0) {
                textView = GeneralSettingsActivity.this.K;
                str = "10s";
            } else if (i == 1) {
                textView = GeneralSettingsActivity.this.K;
                str = "20s";
            } else if (i == 2) {
                textView = GeneralSettingsActivity.this.K;
                str = "30s";
            } else if (i == 3) {
                textView = GeneralSettingsActivity.this.K;
                str = "40s";
            } else if (i == 4) {
                textView = GeneralSettingsActivity.this.K;
                str = "50s";
            } else {
                if (i != 5) {
                    return;
                }
                textView = GeneralSettingsActivity.this.K;
                str = "60s";
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class h implements DialogInterface.OnDismissListener {
        public h() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    GeneralSettingsActivity.this.A1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            View view3;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                View view4 = this.a;
                if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                    View view5 = this.a;
                    if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                        View view6 = this.a;
                        if (view6 == null || view6.getTag() == null) {
                            return;
                        }
                        this.a.setBackground(GeneralSettingsActivity.this.getResources().getDrawable(a7.e.K1));
                        return;
                    }
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.k1;
                } else {
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.h;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.05f : 1.0f;
                a(f);
                b(f);
                View view7 = this.a;
                if ((view7 == null || view7.getTag() == null || !this.a.getTag().equals("1")) && ((view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("2"))) {
                    return;
                }
                view3 = this.a;
                i = a7.e.o;
            }
            view3.setBackgroundResource(i);
        }
    }

    private void B1() {
        Button button = this.C;
        if (button != null) {
            button.setOnFocusChangeListener(new j(button));
        }
        CheckBox checkBox = this.w;
        if (checkBox != null) {
            checkBox.setOnFocusChangeListener(new j(checkBox));
            this.w.requestFocus();
        }
        EditText editText = this.H;
        if (editText != null) {
            editText.setOnFocusChangeListener(new j(editText));
        }
        CheckBox checkBox2 = this.x;
        if (checkBox2 != null) {
            checkBox2.setOnFocusChangeListener(new j(checkBox2));
        }
        Spinner spinner = this.G;
        if (spinner != null) {
            spinner.setOnFocusChangeListener(new j(spinner));
        }
        CheckBox checkBox3 = this.y;
        if (checkBox3 != null) {
            checkBox3.setOnFocusChangeListener(new j(checkBox3));
        }
        CheckBox checkBox4 = this.O;
        if (checkBox4 != null) {
            checkBox4.setOnFocusChangeListener(new j(checkBox4));
        }
        CheckBox checkBox5 = this.J;
        if (checkBox5 != null) {
            checkBox5.setOnFocusChangeListener(new j(checkBox5));
        }
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.setOnFocusChangeListener(new j(frameLayout));
        }
        FrameLayout frameLayout2 = this.M;
        if (frameLayout2 != null) {
            frameLayout2.setOnFocusChangeListener(new j(frameLayout2));
        }
        FrameLayout frameLayout3 = this.N;
        if (frameLayout3 != null) {
            frameLayout3.setOnFocusChangeListener(new j(frameLayout3));
        }
        TextView textView = this.T;
        if (textView != null) {
            textView.setOnFocusChangeListener(new j(textView));
        }
        CheckBox checkBox6 = this.P;
        if (checkBox6 != null) {
            checkBox6.setOnFocusChangeListener(new j(checkBox6));
        }
        CheckBox checkBox7 = this.Q;
        if (checkBox7 != null) {
            checkBox7.setOnFocusChangeListener(new j(checkBox7));
        }
        CheckBox checkBox8 = this.U;
        if (checkBox8 != null) {
            checkBox8.setOnFocusChangeListener(new j(checkBox8));
        }
        Button button2 = this.B;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new j(button2));
        }
    }

    private void D1() {
        this.g0 = this;
        this.j = new LiveStreamDBHandler(this.g0);
        this.d = getSharedPreferences("automation_channels", 0);
        this.f = getSharedPreferences("automation_epg", 0);
        this.h = getSharedPreferences("user_agent", 0);
        String string = this.d.getString("auto_start_on_bootup", "");
        String string2 = this.h.getString("user_agent", "IPTVSmartersPlayer");
        if (string.equals("checked")) {
            this.w.setChecked(true);
        }
        EditText editText = this.H;
        if (editText != null) {
            editText.setText(string2);
        }
        this.o = getSharedPreferences("loginPrefs", 0);
        this.p = getSharedPreferences("selected_language", 0);
        this.o = getSharedPreferences("loginPrefs", 0);
        String string3 = this.p.getString("selected_language", "");
        this.u = string3;
        if (string3.equals("English")) {
            string3 = "en";
        } else if (string3.equals("Polish")) {
            string3 = "pl";
        } else if (string3.equals("Portuguese")) {
            string3 = "pt";
        } else if (string3.equals("Turkish")) {
            string3 = "tr";
        } else if (string3.equals("Croatian")) {
            string3 = "hr";
        } else if (string3.equals("Spanish")) {
            string3 = "es";
        } else if (string3.equals("Arabic")) {
            string3 = "ar";
        } else if (string3.equals("French")) {
            string3 = "fr";
        } else if (string3.equals("German")) {
            string3 = "de";
        } else if (string3.equals("Italian")) {
            string3 = "it";
        } else if (string3.equals("Romanian")) {
            string3 = "ro";
        } else if (string3.equals("Hungary")) {
            string3 = "hu";
        } else if (string3.equals("Albanian")) {
            string3 = "sq";
        } else if (string3.equals("Korean")) {
            string3 = "ko";
        } else if (string3.equals("Hebrew")) {
            string3 = "he";
        } else if (string3.equals("Ukrainian")) {
            string3 = "uk";
        } else if (string3.equals("Malay")) {
            string3 = "ms";
        } else if (string3.equals("Dutch")) {
            string3 = "nl";
        } else if (string3.equals("Indonesian")) {
            string3 = "in";
        } else if (string3.equals("Swedish")) {
            string3 = "sv";
        }
        try {
            this.G.setSelection(w.H(string3));
        } catch (Exception unused) {
        }
    }

    private void H1(String str) {
        SharedPreferences.Editor editor = this.s;
        if (editor != null) {
            editor.putString("autoplay_seconds", str);
            this.s.apply();
        }
    }

    public static /* synthetic */ void u1(GeneralSettingsActivity generalSettingsActivity, View view) {
        generalSettingsActivity.E1(view);
    }

    public static /* synthetic */ void v1(GeneralSettingsActivity generalSettingsActivity) {
        generalSettingsActivity.F1();
    }

    public static /* synthetic */ Context w1(GeneralSettingsActivity generalSettingsActivity) {
        return generalSettingsActivity.g0;
    }

    private void y1() {
        ImageView imageView;
        this.v = new u7.a(this.g0);
        int i2 = 8;
        if (m7.a.o.booleanValue() && m7.a.V0.booleanValue() && (this.v.k() == null || this.v.n() == null || this.v.l() == 0 || this.v.k().equals("") || this.v.n().equals(""))) {
            this.e0.setOnClickListener(new C(this));
            imageView = this.Z;
            i2 = 0;
        } else {
            imageView = this.Z;
        }
        imageView.setVisibility(i2);
    }

    public void A1() {
        runOnUiThread(new B(this));
    }

    public void C1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void E1(View view) {
        try {
            Activity activity = this.g0;
            new w.j(activity, activity, this.v).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final /* synthetic */ void F1() {
        try {
            String date = Calendar.getInstance().getTime().toString();
            String R = w.R(this.g0);
            String A = w.A(date);
            TextView textView = this.F;
            if (textView != null) {
                textView.setText(R);
            }
            TextView textView2 = this.E;
            if (textView2 != null) {
                textView2.setText(A);
            }
        } catch (Exception unused) {
        }
    }

    public void G1() {
        AppOpsManager appOpsManager;
        this.g0 = this;
        Application application = getApplication();
        this.g0 = application;
        String A = new u7.a(application).A();
        setContentView(A.equals(m7.a.K0) ? a7.g.K : a7.g.J);
        C1();
        this.w = findViewById(a7.f.e0);
        this.x = findViewById(a7.f.U2);
        this.y = findViewById(a7.f.Mg);
        this.z = findViewById(a7.f.kh);
        this.A = findViewById(a7.f.W);
        this.B = findViewById(a7.f.D0);
        this.C = findViewById(a7.f.S0);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D = findViewById(a7.f.im);
        this.E = findViewById(a7.f.E2);
        this.F = findViewById(a7.f.gh);
        this.G = findViewById(a7.f.l6);
        this.H = findViewById(a7.f.v3);
        this.I = findViewById(a7.f.Xa);
        this.J = findViewById(a7.f.f0);
        this.K = findViewById(a7.f.Fh);
        this.L = findViewById(a7.f.M3);
        this.M = findViewById(a7.f.S3);
        this.N = findViewById(a7.f.T3);
        this.O = findViewById(a7.f.tc);
        this.P = findViewById(a7.f.c0);
        this.Q = findViewById(a7.f.gg);
        this.R = findViewById(a7.f.ml);
        this.S = findViewById(a7.f.nl);
        this.T = findViewById(a7.f.n0);
        this.U = findViewById(a7.f.d0);
        this.V = findViewById(a7.f.a7);
        this.X = findViewById(a7.f.D9);
        this.Y = findViewById(a7.f.E9);
        this.Z = findViewById(a7.f.Na);
        this.e0 = findViewById(a7.f.R3);
        this.f0 = findViewById(a7.f.Tl);
        this.W = findViewById(a7.f.la);
        B1();
        y1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        w.w(this, findViewById(16908290));
        if (A.equals(m7.a.K0)) {
            this.i0 = "tv";
        } else {
            this.i0 = "mobile";
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.g0).equals("m3u")) {
            this.V.setVisibility(8);
            this.X.setVisibility(8);
        } else {
            this.V.setVisibility(0);
            this.X.setVisibility(0);
        }
        SharedPreferences sharedPreferences = this.g0.getSharedPreferences("auto_start", 0);
        this.t = sharedPreferences;
        this.s = sharedPreferences.edit();
        boolean z = this.t.getBoolean("auto_start", true);
        boolean z2 = this.t.getBoolean("full_epg", true);
        boolean z3 = this.t.getBoolean("subtitle_active", true);
        boolean z4 = this.t.getBoolean("autoplay", true);
        this.m0 = this.t.getString("autoplay_seconds", m7.a.t0);
        boolean z5 = this.t.getBoolean("picinpic", m7.a.u0);
        this.k0 = this.t.getInt("recently_added_limit", m7.a.r0);
        this.l0 = this.t.getInt("recently_watched_limit_live", m7.a.s0);
        boolean z6 = this.t.getBoolean("auto_clear_cache", m7.a.z0);
        boolean z7 = this.t.getBoolean("show_epg_in_channels_list", m7.a.A0);
        boolean z8 = this.t.getBoolean("auto_play_channel_in_live", m7.a.B0);
        if (m7.a.V0.booleanValue()) {
            this.f0.setText("LOCAL STORAGE");
        } else {
            this.W.setVisibility(8);
        }
        if (!this.i0.equals("mobile")) {
            this.O.setVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 26) {
            try {
                if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.g0.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.g0.getPackageName()) == 0) {
                    this.j0 = true;
                }
            } catch (Exception unused) {
            }
        }
        if (this.j0) {
            this.O.setTextColor(this.g0.getResources().getColor(a7.c.G));
            this.O.setEnabled(true);
            this.O.setButtonTintList(ColorStateList.valueOf(this.g0.getResources().getColor(a7.c.d)));
            CheckBox checkBox = this.O;
            if (z5) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } else {
            this.O.setTextColor(this.g0.getResources().getColor(a7.c.b));
            this.O.setEnabled(false);
            this.O.setChecked(false);
            this.O.setButtonTintList(ColorStateList.valueOf(this.g0.getResources().getColor(a7.c.b)));
        }
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(this.m0);
        }
        CheckBox checkBox2 = this.y;
        if (z3) {
            checkBox2.setChecked(true);
        } else {
            checkBox2.setChecked(false);
        }
        if (z) {
            this.w.setChecked(true);
        } else {
            this.w.setChecked(false);
        }
        CheckBox checkBox3 = this.x;
        if (z2) {
            checkBox3.setChecked(true);
        } else {
            checkBox3.setChecked(false);
        }
        CheckBox checkBox4 = this.J;
        if (z4) {
            checkBox4.setChecked(true);
        } else {
            checkBox4.setChecked(false);
        }
        CheckBox checkBox5 = this.P;
        if (z6) {
            checkBox5.setChecked(true);
        } else {
            checkBox5.setChecked(false);
        }
        CheckBox checkBox6 = this.Q;
        if (z7) {
            checkBox6.setChecked(true);
        } else {
            checkBox6.setChecked(false);
        }
        CheckBox checkBox7 = this.U;
        if (z8) {
            checkBox7.setChecked(true);
        } else {
            checkBox7.setChecked(false);
        }
        TextView textView2 = this.R;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.k0));
        }
        TextView textView3 = this.S;
        if (textView3 != null) {
            textView3.setText(String.valueOf(this.l0));
        }
        D1();
        Thread thread = this.n0;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.n0 = thread2;
            thread2.start();
        }
        this.I.setOnClickListener(new a());
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.T.setOnClickListener(this);
    }

    public final void I1() {
        int i2 = 0;
        CharSequence[] charSequenceArr = {"10", "20", "30", "40", "50", "100"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.T5));
        int i3 = this.t.getInt("recently_added_limit", m7.a.r0);
        this.k0 = i3;
        if (i3 != 10) {
            if (i3 == 20) {
                i2 = 1;
            } else if (i3 == 30) {
                i2 = 2;
            } else if (i3 == 40) {
                i2 = 3;
            } else if (i3 == 50) {
                i2 = 4;
            } else if (i3 == 100) {
                i2 = 5;
            }
        }
        aVar.l(charSequenceArr, i2, new c());
        androidx.appcompat.app.a create = aVar.create();
        this.h0 = create;
        create.setOnDismissListener(new d());
        this.h0.show();
    }

    public final void J1(int i2) {
        SharedPreferences.Editor editor = this.s;
        if (editor != null) {
            editor.putInt("recently_added_limit", i2);
            this.s.apply();
        }
    }

    public final void K1() {
        int i2 = 0;
        CharSequence[] charSequenceArr = {"5", "10", "20", "30", "40", "50"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.V5));
        int i3 = this.t.getInt("recently_watched_limit_live", m7.a.s0);
        this.l0 = i3;
        if (i3 != 5) {
            if (i3 == 10) {
                i2 = 1;
            } else if (i3 == 20) {
                i2 = 2;
            } else if (i3 == 30) {
                i2 = 3;
            } else if (i3 == 40) {
                i2 = 4;
            } else if (i3 == 50) {
                i2 = 5;
            }
        }
        aVar.l(charSequenceArr, i2, new e());
        androidx.appcompat.app.a create = aVar.create();
        this.h0 = create;
        create.setOnDismissListener(new f());
        this.h0.show();
    }

    public final void L1(int i2) {
        SharedPreferences.Editor editor = this.s;
        if (editor != null) {
            editor.putInt("recently_watched_limit_live", i2);
            this.s.apply();
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        String str;
        Resources resources;
        int i2;
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (id == a7.f.M3) {
            x1();
            return;
        }
        if (id == a7.f.S3) {
            I1();
            return;
        }
        if (id == a7.f.T3) {
            K1();
            return;
        }
        if (id == a7.f.n0) {
            z1();
            return;
        }
        if (id != a7.f.D0) {
            if (id == a7.f.S0) {
                onBackPressed();
                return;
            }
            return;
        }
        this.d = getSharedPreferences("automation_channels", 0);
        this.f = getSharedPreferences("auto_start_on_bootup", 0);
        this.e = this.d.edit();
        this.i = this.h.edit();
        this.g = this.f.edit();
        if (this.w.isChecked()) {
            SharedPreferences.Editor editor = this.s;
            if (editor != null) {
                editor.putBoolean("auto_start", true);
            }
        } else {
            SharedPreferences.Editor editor2 = this.s;
            if (editor2 != null) {
                editor2.putBoolean("auto_start", false);
            }
        }
        H1(this.K.getText().toString());
        J1(Integer.parseInt(this.R.getText().toString()));
        L1(Integer.parseInt(this.S.getText().toString()));
        if (this.x.isChecked()) {
            SharedPreferences.Editor editor3 = this.s;
            if (editor3 != null) {
                editor3.putBoolean("full_epg", true);
            }
        } else {
            SharedPreferences.Editor editor4 = this.s;
            if (editor4 != null) {
                editor4.putBoolean("full_epg", false);
            }
        }
        if (this.y.isChecked()) {
            SharedPreferences.Editor editor5 = this.s;
            if (editor5 != null) {
                editor5.putBoolean("subtitle_active", true);
            }
        } else {
            SharedPreferences.Editor editor6 = this.s;
            if (editor6 != null) {
                editor6.putBoolean("subtitle_active", false);
            }
        }
        if (this.J.isChecked()) {
            SharedPreferences.Editor editor7 = this.s;
            if (editor7 != null) {
                editor7.putBoolean("autoplay", true);
            }
        } else {
            SharedPreferences.Editor editor8 = this.s;
            if (editor8 != null) {
                editor8.putBoolean("autoplay", false);
            }
        }
        if (this.O.isChecked()) {
            SharedPreferences.Editor editor9 = this.s;
            if (editor9 != null) {
                editor9.putBoolean("picinpic", true);
            }
        } else {
            SharedPreferences.Editor editor10 = this.s;
            if (editor10 != null) {
                editor10.putBoolean("picinpic", false);
            }
        }
        if (this.P.isChecked()) {
            SharedPreferences.Editor editor11 = this.s;
            if (editor11 != null) {
                editor11.putBoolean("auto_clear_cache", true);
            }
        } else {
            SharedPreferences.Editor editor12 = this.s;
            if (editor12 != null) {
                editor12.putBoolean("auto_clear_cache", false);
            }
        }
        if (this.Q.isChecked()) {
            SharedPreferences.Editor editor13 = this.s;
            if (editor13 != null) {
                editor13.putBoolean("show_epg_in_channels_list", true);
            }
        } else {
            SharedPreferences.Editor editor14 = this.s;
            if (editor14 != null) {
                editor14.putBoolean("show_epg_in_channels_list", false);
            }
        }
        if (this.U.isChecked()) {
            SharedPreferences.Editor editor15 = this.s;
            if (editor15 != null) {
                editor15.putBoolean("auto_play_channel_in_live", true);
            }
        } else {
            SharedPreferences.Editor editor16 = this.s;
            if (editor16 != null) {
                editor16.putBoolean("auto_play_channel_in_live", false);
            }
        }
        if (this.H.getText().toString().equals("")) {
            SharedPreferences.Editor editor17 = this.i;
            if (editor17 != null) {
                editor17.putString("user_agent", "IPTVSmartersPlayer");
            }
        } else {
            SharedPreferences.Editor editor18 = this.i;
            if (editor18 != null) {
                editor18.putString("user_agent", this.H.getText().toString());
            }
        }
        this.q = this.o.edit();
        SharedPreferences.Editor edit = this.p.edit();
        this.r = edit;
        if (edit != null) {
            this.G.getSelectedItemPosition();
            str = String.valueOf(this.G.getSelectedItem());
            this.r.putString("selected_language", String.valueOf(this.G.getSelectedItem()));
            SharepreferenceDBHandler.setSelectedLanguage(String.valueOf(this.G.getSelectedItem()), this.g0);
            this.r.commit();
            w.J0(this.g0, str);
        } else {
            str = "";
        }
        this.s.apply();
        this.e.apply();
        this.g.apply();
        this.i.apply();
        if (this.H.getText().toString().equals("")) {
            this.H.setText("IPTVSmartersPlayer");
            resources = getResources();
            i2 = a7.j.r5;
        } else if (this.u.equalsIgnoreCase(str)) {
            resources = getResources();
            i2 = a7.j.k5;
        } else {
            startActivity(new Intent(this, NewDashboardActivity.class));
            resources = getResources();
            i2 = a7.j.b6;
        }
        Toast.makeText(this, resources.getString(i2), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        G1();
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.n0;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.n0.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.n0;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.n0 = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        w.m(this.g0);
        w.z0(this.g0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void x1() {
        int i2;
        CharSequence[] charSequenceArr = {"10s", "20s", "30s", "40s", "50s", "60s"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.M));
        String string = this.t.getString("autoplay_seconds", m7.a.t0);
        this.m0 = string;
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case 48692:
                if (string.equals("10s")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49653:
                if (string.equals("20s")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50614:
                if (string.equals("30s")) {
                    c2 = 2;
                    break;
                }
                break;
            case 51575:
                if (string.equals("40s")) {
                    c2 = 3;
                    break;
                }
                break;
            case 52536:
                if (string.equals("50s")) {
                    c2 = 4;
                    break;
                }
                break;
            case 53497:
                if (string.equals("60s")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
        }
        aVar.l(charSequenceArr, i2, new g());
        androidx.appcompat.app.a create = aVar.create();
        this.h0 = create;
        create.setOnDismissListener(new h());
        this.h0.show();
    }

    public final void z1() {
        new b(this).show();
    }
}
