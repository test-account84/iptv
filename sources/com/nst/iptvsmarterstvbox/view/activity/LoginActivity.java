package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.FreeTrailActivity;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.callback.ActivationCallBack;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import m7.w;
import org.json.JSONObject;
import p7.K;
import p7.L;
import p7.M;
import p7.N;
import p7.O;
import p7.P;
import p7.Q;
import p7.S;
import p7.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LoginActivity extends androidx.appcompat.app.b implements z7.f, b7.c, z7.a {
    public static InputFilter T0 = new a();
    public TextView A;
    public SharedPreferences.Editor A0;
    public TextView B;
    public SharedPreferences B0;
    public ImageView C;
    public SharedPreferences.Editor C0;
    public TextView D;
    public SharedPreferences D0;
    public RelativeLayout E;
    public n7.d H;
    public String J;
    public String J0;
    public String K;
    public String K0;
    public String L;
    public String L0;
    public ProgressDialog M;
    public String M0;
    public SharedPreferences N;
    public SharedPreferences.Editor O;
    public int O0;
    public SharedPreferences P;
    public String P0;
    public SharedPreferences Q;
    public n7.a Q0;
    public SharedPreferences R;
    public u7.a R0;
    public SharedPreferences.Editor S;
    public String S0;
    public SharedPreferences T;
    public SharedPreferences.Editor U;
    public LiveStreamDBHandler V;
    public SharedPreferences W;
    public SharedPreferences X;
    public SharedPreferences Y;
    public SharedPreferences Z;
    public EditText d;
    public EditText e;
    public SharedPreferences e0;
    public EditText f;
    public SharedPreferences.Editor f0;
    public EditText g;
    public SharedPreferences.Editor g0;
    public ImageView h;
    public SharedPreferences.Editor h0;
    public TextView i;
    public SharedPreferences.Editor i0;
    public LinearLayout j;
    public SharedPreferences.Editor j0;
    public Button k;
    public SharedPreferences.Editor k0;
    public TextView l;
    public SharedPreferences l0;
    public RelativeLayout m;
    public SharedPreferences m0;
    public RelativeLayout n;
    public SharedPreferences.Editor n0;
    public RelativeLayout o;
    public MultiUserDBHandler o0;
    public RelativeLayout p;
    public DatabaseHandler p0;
    public RelativeLayout q;
    public Button r;
    public LinearLayout s;
    public ImageView t;
    public LinearLayout u;
    public RelativeLayout v;
    public ConstraintLayout w;
    public TextView x;
    public ImageView y;
    public String y0;
    public ImageView z;
    public SharedPreferences z0;
    public int F = -1;
    public boolean G = false;
    public Context I = this;
    public String q0 = "";
    public String r0 = "";
    public String s0 = "";
    public String t0 = "";
    public long u0 = -1;
    public String v0 = "";
    public String w0 = "";
    public long x0 = -1;
    public String E0 = "";
    public ArrayList F0 = new ArrayList();
    public String G0 = M1();
    public long H0 = 0;
    public SimpleDateFormat I0 = new SimpleDateFormat("dd/MM/yyyy");
    public String N0 = Build.MODEL;

    public class a implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                if (Character.getType(charSequence.charAt(i)) == 19) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    public class b implements MyApplication.d {
        public b() {
        }

        public static /* synthetic */ void c(b bVar, String str) {
            bVar.g(str);
        }

        public static /* synthetic */ void d(b bVar, String str) {
            bVar.f(str);
        }

        public static /* synthetic */ void e(b bVar) {
            bVar.h();
        }

        public void a(String str) {
            LoginActivity.this.runOnUiThread(new M(this, str));
        }

        public void b(String str) {
            LoginActivity.this.runOnUiThread(new O(this, str));
        }

        public final /* synthetic */ void f(String str) {
            MyApplication.p().D("LX" + str, LoginActivity.C1(LoginActivity.this));
        }

        public final /* synthetic */ void g(String str) {
            MyApplication.p().D("LX" + str, LoginActivity.C1(LoginActivity.this));
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", LoginActivity.C1(LoginActivity.this));
            LoginActivity.this.startActivity(new Intent(LoginActivity.C1(LoginActivity.this), ProfileActivity.class).putExtra("typeid", "login"));
        }

        public final /* synthetic */ void h() {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", LoginActivity.C1(LoginActivity.this));
            LoginActivity.this.startActivity(new Intent(LoginActivity.C1(LoginActivity.this), ProfileActivity.class).putExtra("typeid", "login"));
        }

        public void onSuccess() {
            LoginActivity.this.runOnUiThread(new N(this));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            LoginActivity.A1(LoginActivity.this);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            LoginActivity.B1(LoginActivity.this);
        }
    }

    public class e implements View.OnClickListener {

        public class a implements MyApplication.d {

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    LoginActivity.D1(LoginActivity.this);
                }
            }

            public class b implements Runnable {
                public final /* synthetic */ String a;

                public b(String str) {
                    this.a = str;
                }

                public void run() {
                    MyApplication.p().D("LX" + this.a, LoginActivity.C1(LoginActivity.this));
                    LoginActivity.D1(LoginActivity.this);
                }
            }

            public class c implements Runnable {
                public final /* synthetic */ String a;

                public c(String str) {
                    this.a = str;
                }

                public void run() {
                    MyApplication.p().D("LX" + this.a, LoginActivity.C1(LoginActivity.this));
                }
            }

            public a() {
            }

            public void a(String str) {
                LoginActivity.this.runOnUiThread(new b(str));
            }

            public void b(String str) {
                LoginActivity.this.runOnUiThread(new c(str));
            }

            public void onSuccess() {
                LoginActivity.this.runOnUiThread(new a());
            }
        }

        public e() {
        }

        public void onClick(View view) {
            if (!m7.a.W0.booleanValue() || (SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginActivity.C1(LoginActivity.this)) != null && SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginActivity.C1(LoginActivity.this)).length() > 0)) {
                LoginActivity.D1(LoginActivity.this);
            } else {
                MyApplication.p().G(LoginActivity.C1(LoginActivity.this), new a());
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, FreeTrailActivity.class));
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            m7.a.y = m7.a.y.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
            LoginActivity.E1(LoginActivity.this);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            LoginActivity loginActivity = LoginActivity.this;
            int i = loginActivity.F;
            if (i != -1) {
                loginActivity.F = i - 1;
                loginActivity.e.setInputType(129);
                LoginActivity.this.t.setImageResource(a7.e.h0);
            } else {
                loginActivity.e.setInputType(145);
                LoginActivity.this.t.setImageResource(a7.e.z2);
                LoginActivity.this.F++;
            }
        }
    }

    public class i extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public LinearLayout e;
        public LinearLayout f;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout c;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            c = i.c(i.this);
                        }
                    } else {
                        c = i.b(i.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            c = i.c(i.this);
                        }
                    } else {
                        c = i.b(i.this);
                    }
                    i = a7.e.o;
                }
                c.setBackgroundResource(i);
            }
        }

        public i(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ void a(i iVar) {
            iVar.d();
        }

        public static /* synthetic */ LinearLayout b(i iVar) {
            return iVar.e;
        }

        public static /* synthetic */ LinearLayout c(i iVar) {
            return iVar.f;
        }

        public final /* synthetic */ void d() {
            LoginActivity.A1(LoginActivity.this);
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.s1) {
                    new Handler(Looper.getMainLooper()).postDelayed(new P(this), 200L);
                    dismiss();
                } else if (view.getId() != a7.f.X0) {
                } else {
                    dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(LoginActivity.G1(LoginActivity.this).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
            this.c = findViewById(a7.f.s1);
            this.d = findViewById(a7.f.X0);
            this.e = findViewById(a7.f.Ia);
            this.f = findViewById(a7.f.V8);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class j extends AsyncTask {

        public class a implements MyApplication.d {
            public a() {
            }

            public static /* synthetic */ void c(a aVar, String str) {
                aVar.f(str);
            }

            public static /* synthetic */ void d(LoginActivity loginActivity) {
                h(loginActivity);
            }

            public static /* synthetic */ void e(a aVar, String str) {
                aVar.g(str);
            }

            private /* synthetic */ void f(String str) {
                MyApplication.p().D("LX" + str, LoginActivity.C1(LoginActivity.this));
                LoginActivity.this.b();
            }

            private /* synthetic */ void g(String str) {
                MyApplication.p().D("LX" + str, LoginActivity.C1(LoginActivity.this));
                LoginActivity.F1(LoginActivity.this);
            }

            public static /* synthetic */ void h(LoginActivity loginActivity) {
                LoginActivity.F1(loginActivity);
            }

            public void a(String str) {
                LoginActivity.this.runOnUiThread(new Q(this, str));
            }

            public void b(String str) {
                LoginActivity.this.runOnUiThread(new T(this, str));
            }

            public void onSuccess() {
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.runOnUiThread(new S(loginActivity));
            }
        }

        public j() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                HttpURLConnection openConnection = new URL("https://www.google.com").openConnection();
                openConnection.setRequestMethod("HEAD");
                openConnection.setReadTimeout(1500);
                openConnection.setConnectTimeout(1500);
                return Boolean.valueOf(openConnection.getResponseCode() == 200);
            } catch (Exception e) {
                Log.e("LOG_TAG", e.toString());
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                if (m7.a.W0.booleanValue()) {
                    MyApplication.p().G(LoginActivity.C1(LoginActivity.this), new a());
                    return;
                } else {
                    LoginActivity.F1(LoginActivity.this);
                    return;
                }
            }
            LoginActivity.this.b();
            LoginActivity loginActivity = LoginActivity.this;
            i iVar = loginActivity.new i(LoginActivity.C1(loginActivity));
            iVar.setCancelable(false);
            iVar.show();
        }

        public /* synthetic */ j(LoginActivity loginActivity, a aVar) {
            this();
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final View a;

        public k(View view) {
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
            float f;
            View view2;
            LoginActivity loginActivity;
            TextView textView;
            EditText editText;
            int length;
            if (!z) {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("rl_list_users")) {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("rl_connect_vpn")) {
                        View view5 = this.a;
                        if ((view5 != null && view5.getTag() != null && this.a.getTag().equals("rl_login_from_mobile_app")) || (view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("rl_bt_submit")) {
                            return;
                        }
                        LoginActivity.this.q.setBackgroundResource(a7.e.t);
                        loginActivity = LoginActivity.this;
                        textView = loginActivity.B;
                    } else {
                        LoginActivity.this.E.setBackgroundResource(a7.e.d1);
                        LoginActivity.this.z.setImageResource(a7.e.f1);
                        loginActivity = LoginActivity.this;
                        textView = loginActivity.A;
                    }
                } else {
                    LoginActivity.this.v.setBackgroundResource(a7.e.d1);
                    LoginActivity.this.C.setImageResource(a7.e.h1);
                    loginActivity = LoginActivity.this;
                    textView = loginActivity.D;
                }
                textView.setTextColor(LoginActivity.C1(loginActivity).getResources().getColor(a7.c.f));
                return;
            }
            f = z ? 1.15f : 1.0f;
            try {
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("1")) {
                    editText = LoginActivity.this.d;
                    length = editText.length();
                } else if (this.a.getTag().equals("2")) {
                    editText = LoginActivity.this.e;
                    length = editText.length();
                } else {
                    if (!this.a.getTag().equals("3")) {
                        if (this.a.getTag().equals("rl_list_users")) {
                            LoginActivity.this.v.setBackgroundResource(a7.e.c1);
                            LoginActivity.this.C.setImageResource(a7.e.g1);
                            LoginActivity loginActivity2 = LoginActivity.this;
                            loginActivity2.D.setTextColor(LoginActivity.C1(loginActivity2).getResources().getColor(a7.c.G));
                            b(f);
                        } else if (this.a.getTag().equals("rl_connect_vpn")) {
                            LoginActivity.this.E.setBackgroundResource(a7.e.c1);
                            LoginActivity.this.z.setImageResource(a7.e.e1);
                            LoginActivity loginActivity3 = LoginActivity.this;
                            loginActivity3.A.setTextColor(LoginActivity.C1(loginActivity3).getResources().getColor(a7.c.G));
                            b(f);
                        } else {
                            if (!this.a.getTag().equals("rl_login_from_mobile_app")) {
                                if (this.a.getTag().equals("rl_bt_submit")) {
                                    LoginActivity.this.q.setBackgroundResource(a7.e.s);
                                    LoginActivity loginActivity4 = LoginActivity.this;
                                    loginActivity4.B.setTextColor(LoginActivity.C1(loginActivity4).getResources().getColor(a7.c.G));
                                    return;
                                }
                                return;
                            }
                            b(f);
                        }
                        c(f);
                        return;
                    }
                    editText = LoginActivity.this.f;
                    length = editText.length();
                }
                editText.setSelection(length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void A1(LoginActivity loginActivity) {
        loginActivity.Y1();
    }

    public static /* synthetic */ void B1(LoginActivity loginActivity) {
        loginActivity.W1();
    }

    public static /* synthetic */ Context C1(LoginActivity loginActivity) {
        return loginActivity.I;
    }

    public static /* synthetic */ void D1(LoginActivity loginActivity) {
        loginActivity.z1();
    }

    public static /* synthetic */ void E1(LoginActivity loginActivity) {
        loginActivity.O1();
    }

    public static /* synthetic */ void F1(LoginActivity loginActivity) {
        loginActivity.V1();
    }

    public static /* synthetic */ u7.a G1(LoginActivity loginActivity) {
        return loginActivity.R0;
    }

    private static String I1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c2 : charArray) {
            if (z && Character.isLetter(c2)) {
                sb.append(Character.toUpperCase(c2));
                z = false;
            } else {
                if (Character.isWhitespace(c2)) {
                    z = true;
                }
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    private void J1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static String N1() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return I1(str2);
        }
        return I1(str) + " " + str2;
    }

    private void O1() {
        TextView textView;
        int i2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ProgressDialog progressDialog;
        String string;
        try {
            this.I = this;
            this.o0 = new MultiUserDBHandler(this.I);
            this.V = new LiveStreamDBHandler(this.I);
            if (m7.a.z.booleanValue()) {
                this.l.setVisibility(0);
            }
            if (m7.a.t.booleanValue()) {
                textView = this.l;
                i2 = a7.f.Ae;
            } else {
                textView = this.l;
                i2 = a7.f.he;
            }
            textView.setNextFocusLeftId(i2);
            if (m7.a.y.booleanValue()) {
                this.d.setHint((CharSequence) null);
                this.d.setHint("");
                this.l.setText(getResources().getString(a7.j.O8));
                this.i.setText(getResources().getString(a7.j.m1));
                this.p.setVisibility(8);
                this.s.setVisibility(8);
                this.d.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setHint(getResources().getString(a7.j.o));
                this.B.setText(getResources().getString(a7.j.o0));
                if (m7.a.t.booleanValue()) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                    relativeLayout2 = this.v;
                } else if (m7.a.u.booleanValue()) {
                    relativeLayout2 = this.v;
                } else {
                    relativeLayout = this.v;
                    relativeLayout.setVisibility(8);
                }
                relativeLayout2.setVisibility(0);
            } else {
                if (m7.a.t.booleanValue()) {
                    this.d.setHint((CharSequence) null);
                    this.d.setHint("");
                    this.l.setText(getResources().getString(a7.j.P8));
                    this.B.setText(getResources().getString(a7.j.s));
                    this.d.setVisibility(8);
                    this.d.setVisibility(0);
                    this.d.setHint(getResources().getString(a7.j.t8));
                    this.s.setVisibility(0);
                    this.m.setVisibility(0);
                    if (m7.a.o.booleanValue()) {
                        this.p.setVisibility(0);
                    } else {
                        this.p.setVisibility(8);
                    }
                    if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                        relativeLayout2 = this.v;
                    } else if (m7.a.u.booleanValue()) {
                        relativeLayout2 = this.v;
                    } else {
                        relativeLayout = this.v;
                    }
                    relativeLayout2.setVisibility(0);
                } else {
                    this.d.setHint((CharSequence) null);
                    this.d.setHint("");
                    this.l.setText(getResources().getString(a7.j.P8));
                    this.i.setText(getResources().getString(a7.j.B0));
                    this.d.setVisibility(8);
                    this.d.setVisibility(0);
                    this.s.setVisibility(0);
                    this.d.setHint(getResources().getString(a7.j.t8));
                    this.B.setText(getResources().getString(a7.j.P7));
                    this.p.setVisibility(8);
                    this.m.setVisibility(8);
                    relativeLayout = this.v;
                }
                relativeLayout.setVisibility(8);
            }
            this.g.setError((CharSequence) null);
            this.d.setError((CharSequence) null);
            this.e.setError((CharSequence) null);
            this.p0 = new DatabaseHandler(this.I);
            if (this.I != null) {
                this.M = new ProgressDialog(this.I);
                String str = this.P0;
                if (str != null && str.equalsIgnoreCase("login_perform")) {
                    progressDialog = this.M;
                    string = "Auto Login";
                } else if (m7.a.y.booleanValue()) {
                    this.M.setMessage("");
                    progressDialog = this.M;
                    string = getResources().getString(a7.j.u5);
                } else {
                    this.M.setMessage("");
                    progressDialog = this.M;
                    string = getResources().getString(a7.j.t5);
                }
                progressDialog.setMessage(string);
                this.M.setCanceledOnTouchOutside(false);
                this.M.setCancelable(false);
                this.M.setProgressStyle(0);
            }
            this.J = this.d.getText().toString();
            this.K = this.e.getText().toString();
            this.H = new n7.d(this, this.I);
            this.N = getSharedPreferences("sharedPreference", 0);
            this.Q = getSharedPreferences("loginPrefs", 0);
            this.R = getSharedPreferences("selected_language", 0);
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefsserverurl", 0);
            this.T = sharedPreferences;
            this.U = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = getSharedPreferences("upgradeDatePref", 0);
            this.l0 = sharedPreferences2;
            this.k0 = sharedPreferences2.edit();
            this.S = this.P.edit();
            this.O = this.N.edit();
            SharedPreferences sharedPreferences3 = getSharedPreferences("multiDNS", 0);
            this.z0 = sharedPreferences3;
            this.A0 = sharedPreferences3.edit();
            SharedPreferences sharedPreferences4 = getSharedPreferences("multiDNSValid", 0);
            this.B0 = sharedPreferences4;
            this.C0 = sharedPreferences4.edit();
            this.D0 = getSharedPreferences("serverUrlDNS", 0);
            if (m7.a.t.booleanValue()) {
                this.d.setText("");
                this.e.setText("");
            }
            R1();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static String S1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void X1(String str) {
        if (str != null && !str.equals("") && !str.isEmpty()) {
            this.F0 = new ArrayList(Arrays.asList(str.split(",")));
        }
        ArrayList arrayList = this.F0;
        if (arrayList == null || arrayList.size() < 1) {
            ArrayList arrayList2 = this.F0;
            if (arrayList2 == null || arrayList2.size() != 0) {
                return;
            }
            b();
            Toast.makeText(this, this.I.getResources().getString(a7.j.l5), 0).show();
            return;
        }
        try {
            this.U.putString(m7.a.L, ((String) this.F0.get(0)).trim());
            this.U.commit();
            this.F0.remove(0);
            this.H.h(this.J, this.K, this.F0);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void Y1() {
        this.J = this.d.getText().toString().trim();
        this.K = this.e.getText().toString().trim();
        this.y0 = this.g.getText().toString().trim();
        this.U = this.T.edit();
        if (K1()) {
            a();
            new j(this, null).execute(new Void[0]);
        }
    }

    public static /* synthetic */ void u1(LoginActivity loginActivity) {
        loginActivity.Q1();
    }

    public static /* synthetic */ void v1(LoginActivity loginActivity, View view) {
        loginActivity.P1(view);
    }

    public void H1() {
        try {
            this.M0 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean K1() {
        EditText editText;
        Resources resources;
        int i2;
        EditText editText2;
        Resources resources2;
        int i3;
        if (m7.a.t.booleanValue() && this.g.getText().toString().trim().length() == 0) {
            this.g.requestFocus();
            editText = this.g;
            resources = getResources();
            i2 = a7.j.n1;
        } else {
            if (this.d.getText().toString().trim().length() == 0) {
                this.d.requestFocus();
                if (m7.a.y.booleanValue()) {
                    editText2 = this.d;
                    resources2 = getResources();
                    i3 = a7.j.m1;
                } else {
                    editText2 = this.d;
                    resources2 = getResources();
                    i3 = a7.j.A1;
                }
                editText2.setError(resources2.getString(i3));
                return false;
            }
            if (!m7.a.y.booleanValue() && this.e.getText().toString().trim().length() == 0) {
                this.e.requestFocus();
                editText = this.e;
                resources = getResources();
                i2 = a7.j.v1;
            } else {
                if (!m7.a.o.booleanValue() || this.f.getText().toString().trim().length() != 0) {
                    return true;
                }
                this.f.requestFocus();
                editText = this.f;
                resources = getResources();
                i2 = a7.j.w1;
            }
        }
        editText.setError(resources.getString(i2));
        return false;
    }

    public void L1() {
        Button button;
        int i2;
        U1();
        this.E.setOnClickListener(new K(this));
        this.q.setOnClickListener(new c());
        this.v.setOnClickListener(new d());
        this.w.setOnClickListener(new e());
        if (m7.a.x.booleanValue()) {
            button = this.k;
            i2 = 0;
        } else {
            button = this.k;
            i2 = 8;
        }
        button.setVisibility(i2);
        this.k.setOnClickListener(new f());
        this.l.setOnClickListener(new g());
    }

    public final String M1() {
        return w.p0(Calendar.getInstance().getTime().toString());
    }

    public final /* synthetic */ void P1(View view) {
        Intent intent;
        if (!m7.a.W0.booleanValue()) {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", this.I);
            intent = new Intent(this.I, ProfileActivity.class);
        } else if (SharepreferenceDBHandler.getSBPDemoAndClientUrl(this.I) == null || SharepreferenceDBHandler.getSBPDemoAndClientUrl(this.I).length() <= 0) {
            MyApplication.p().G(this.I, new b());
            return;
        } else {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", this.I);
            intent = new Intent(this.I, ProfileActivity.class);
        }
        startActivity(intent.putExtra("typeid", "login"));
    }

    public final /* synthetic */ void Q1() {
        this.G = false;
    }

    public void R1() {
        EditText editText;
        try {
            if (m7.a.t.booleanValue()) {
                this.g.requestFocus();
                editText = this.g;
            } else {
                this.d.requestFocus();
                editText = this.d;
            }
            editText.requestFocusFromTouch();
            b();
        } catch (Exception unused) {
        }
    }

    public void S(String str) {
        b();
        if (str != null) {
            w.P0(this.I, str);
        } else {
            w.P0(this.I, "Your Activation code is not invalid");
        }
    }

    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i2, boolean z) {
        String trim;
        if (!z) {
            b();
            Toast.makeText(this, this.I.getResources().getString(a7.j.A0), 0).show();
            return;
        }
        if (i2 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (!jSONObject.getString("status").equalsIgnoreCase("true")) {
                    b();
                    Toast.makeText(this, this.I.getResources().getString(a7.j.M7), 0).show();
                    return;
                }
                this.v0 = b7.b.a.getString("su");
                this.w0 = b7.b.a.getString("ndd");
                this.x0 = System.currentTimeMillis();
                try {
                    if (m7.a.y.booleanValue()) {
                        this.J = SharepreferenceDBHandler.getUserName(this.I);
                        trim = SharepreferenceDBHandler.getUserPassword(this.I);
                    } else {
                        this.J = this.d.getText().toString().trim();
                        trim = this.e.getText().toString().trim();
                    }
                    this.K = trim;
                    b7.f.e(this, b7.b.a.optString("su"));
                    this.K0 = S1(b7.b.a.optString("su") + "*" + b7.f.d(this) + "*" + b7.b.b);
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(this.K0)) {
                        b();
                        Toast.makeText(this, this.I.getResources().getString(a7.j.A0), 0).show();
                        return;
                    }
                    this.U.putString(m7.a.L, b7.f.a(this));
                    this.U.apply();
                    this.O.putString(m7.a.L, b7.f.a(this));
                    this.O.putString("username", this.J);
                    this.O.apply();
                    if (m7.a.t.booleanValue()) {
                        X1(this.v0.toLowerCase());
                    } else {
                        this.H.g(this.J, this.K);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                Log.e("Login check", e3.getMessage());
            }
        }
    }

    public final void U1() {
        EditText editText;
        int i2;
        EditText editText2;
        int i3;
        EditText editText3;
        int i4;
        EditText editText4;
        this.g = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.g.setPaddingRelative(35, 0, 35, 0);
        this.g.setLayoutParams(layoutParams);
        this.g.setHint(getResources().getString(a7.j.d9));
        this.g.setHintTextColor(getResources().getColor(a7.c.G));
        this.g.setHintTextColor(-1);
        if (m7.a.t.booleanValue()) {
            editText = this.g;
            i2 = a7.f.Ae;
        } else {
            editText = this.g;
            i2 = a7.f.he;
        }
        editText.setNextFocusLeftId(i2);
        this.g.setTextSize(22.0f);
        this.g.setId(101);
        this.g.setBackground(getResources().getDrawable(a7.e.J1));
        if (this.S0.equals(m7.a.K0)) {
            this.g.setFocusable(true);
        }
        EditText editText5 = this.g;
        Typeface typeface = Typeface.SANS_SERIF;
        editText5.setTypeface(typeface);
        this.g.setInputType(161);
        this.m.addView(this.g);
        this.d = new EditText(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        this.d.setPaddingRelative(35, 0, 35, 0);
        this.d.setLayoutParams(layoutParams2);
        if (m7.a.z.booleanValue()) {
            this.u.setGravity(16);
        }
        this.d.setHint(getResources().getString(a7.j.t8));
        this.d.setHintTextColor(getResources().getColor(a7.c.G));
        this.d.setHintTextColor(-1);
        this.d.setTextSize(22.0f);
        this.d.setId(102);
        if (m7.a.t.booleanValue()) {
            editText2 = this.d;
            i3 = a7.f.Ae;
        } else {
            editText2 = this.d;
            i3 = a7.f.he;
        }
        editText2.setNextFocusLeftId(i3);
        if (this.S0.equals(m7.a.K0)) {
            this.d.setFocusable(true);
        }
        this.d.setBackground(getResources().getDrawable(a7.e.J1));
        this.d.setTypeface(typeface);
        this.d.setInputType(161);
        this.n.addView(this.d);
        this.e = new EditText(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        this.e.setPaddingRelative(35, 0, 35, 0);
        this.e.setLayoutParams(layoutParams3);
        this.e.setHint(getResources().getString(a7.j.X4));
        this.e.setHintTextColor(getResources().getColor(a7.c.G));
        this.e.setHintTextColor(-1);
        this.e.setTextSize(22.0f);
        this.e.setId(103);
        if (m7.a.t.booleanValue()) {
            editText3 = this.e;
            i4 = a7.f.Ae;
        } else {
            editText3 = this.e;
            i4 = a7.f.he;
        }
        editText3.setNextFocusLeftId(i4);
        this.e.setBackground(getResources().getDrawable(a7.e.J1));
        if (this.S0.equals(m7.a.K0)) {
            this.e.setFocusable(true);
        }
        this.e.setTypeface(typeface);
        this.e.setInputType(129);
        this.o.addView(this.e);
        this.t.setId(110);
        if (this.S0.equals(m7.a.K0)) {
            this.t.setFocusable(true);
        }
        this.e.setNextFocusDownId(104);
        this.e.setNextFocusUpId(102);
        this.t.setNextFocusDownId(104);
        this.t.setNextFocusUpId(102);
        this.t.setBackground(getResources().getDrawable(a7.e.J1));
        this.t.setOnClickListener(new h());
        if (m7.a.o.booleanValue()) {
            this.f = new EditText(this);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
            this.f.setPaddingRelative(35, 0, 35, 0);
            this.f.setLayoutParams(layoutParams4);
            this.f.setHint(getResources().getString(a7.j.P6));
            this.f.setHintTextColor(getResources().getColor(a7.c.G));
            this.f.setHintTextColor(-1);
            this.f.setTextSize(22.0f);
            this.f.setId(104);
            this.f.setBackground(getResources().getDrawable(a7.e.J1));
            this.f.setFocusable(true);
            this.f.setTypeface(typeface);
            this.f.setInputType(161);
            this.p.addView(this.f);
        }
        if (m7.a.t.booleanValue()) {
            if (!this.S0.equals(m7.a.K0)) {
                return;
            }
            this.g.requestFocus();
            editText4 = this.g;
        } else {
            if (!this.S0.equals(m7.a.K0)) {
                return;
            }
            this.d.requestFocus();
            editText4 = this.d;
        }
        editText4.requestFocusFromTouch();
    }

    public final void V1() {
        if (m7.a.y.booleanValue()) {
            SharepreferenceDBHandler.setActivationCode(this.I, this.J);
            this.y0 = this.g.getText().toString().trim();
            n7.a aVar = new n7.a(this, this.I);
            this.Q0 = aVar;
            aVar.a(this.J);
            return;
        }
        try {
            if (m7.a.n.booleanValue()) {
                this.U.putString(m7.a.L, "http://qqtv.nl");
                this.U.apply();
                this.O.putString(m7.a.L, "http://qqtv.nl");
                this.O.putString("username", this.J);
                this.O.apply();
                if (m7.a.t.booleanValue()) {
                    X1("http://qqtv.nl");
                } else {
                    this.H.g(this.J, this.K);
                }
            } else if (m7.a.o.booleanValue()) {
                String lowerCase = this.f.getText().toString().trim().toLowerCase();
                this.L = lowerCase;
                this.U.putString(m7.a.L, lowerCase);
                this.U.apply();
                this.O.putString(m7.a.L, this.L);
                this.O.apply();
                this.H.g(this.J, this.K);
            } else {
                y1();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.S.putString("username", this.J);
        this.S.putString("password", this.K);
        this.S.putString("activationCode", "");
        this.S.putString("loginWith", "loginWithDetails");
        this.S.apply();
        this.U.apply();
    }

    public final void W1() {
        SharepreferenceDBHandler.setCurrentAPPType("api", this.I);
        startActivity(new Intent(this, MultiUserActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
    }

    public void a() {
        ProgressDialog progressDialog = this.M;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void b() {
        try {
            ProgressDialog progressDialog = this.M;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void b0(int i2) {
        if (this.I != null) {
            b();
            Toast.makeText(this, this.I.getResources().getString(a7.j.A0), 0).show();
        }
    }

    public void c(String str) {
        b();
        if (!str.equals("")) {
            w.P0(this.I, str);
        } else if (m7.a.n.booleanValue()) {
            Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
        } else {
            w.P0(this.I, "Your Account is invalid or has expired !");
        }
    }

    public void d(String str) {
        if (this.I == null || str.isEmpty()) {
            return;
        }
        w.P0(this.I, str);
    }

    public void e(String str) {
        ProgressDialog progressDialog = this.M;
        if (progressDialog != null) {
            progressDialog.dismiss();
            Toast.makeText(this, this.I.getResources().getString(a7.j.G2), 0).show();
        }
    }

    public void h0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (m7.a.n.booleanValue()) {
                Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
                return;
            } else {
                w.P0(this.I, "Your Account is invalid or has expired !");
                return;
            }
        }
        try {
            this.U.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.U.apply();
            arrayList.remove(0);
            this.H.h(this.J, this.K, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void m(LoginCallback loginCallback, String str) {
        int i2;
        String string;
        if (this.I != null) {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null) {
                b();
                d(getResources().getString(a7.j.F2));
                return;
            }
            if (loginCallback.getUserLoginInfo().getAuth().intValue() == 1) {
                String status = loginCallback.getUserLoginInfo().getStatus();
                if (status.equals("Active")) {
                    String username = loginCallback.getUserLoginInfo().getUsername();
                    String password = loginCallback.getUserLoginInfo().getPassword();
                    String port = loginCallback.getServerInfo().getPort();
                    String url = loginCallback.getServerInfo().getUrl();
                    String expDate = loginCallback.getUserLoginInfo().getExpDate();
                    String isTrial = loginCallback.getUserLoginInfo().getIsTrial();
                    String activeCons = loginCallback.getUserLoginInfo().getActiveCons();
                    String createdAt = loginCallback.getUserLoginInfo().getCreatedAt();
                    String maxConnections = loginCallback.getUserLoginInfo().getMaxConnections();
                    List allowedOutputFormats = loginCallback.getUserLoginInfo().getAllowedOutputFormats();
                    String serverProtocal = loginCallback.getServerInfo().getServerProtocal();
                    String httpsPort = loginCallback.getServerInfo().getHttpsPort();
                    String rtmpPort = loginCallback.getServerInfo().getRtmpPort();
                    String timezone = loginCallback.getServerInfo().getTimezone();
                    if (allowedOutputFormats.size() != 0) {
                    }
                    this.I.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                    SharedPreferences.Editor edit = getSharedPreferences("loginPrefs", 0).edit();
                    edit.putString("username", username);
                    edit.putString("password", password);
                    edit.putString("serverPort", port);
                    edit.putString("serverUrl", url);
                    edit.putString("expDate", expDate);
                    edit.putString("isTrial", isTrial);
                    edit.putString("activeCons", activeCons);
                    edit.putString("createdAt", createdAt);
                    edit.putString("maxConnections", maxConnections);
                    edit.putString(m7.a.L, url + ":" + port);
                    edit.putString("serverProtocol", serverProtocal);
                    edit.putString("serverPortHttps", httpsPort);
                    edit.putString("serverPortRtmp", rtmpPort);
                    edit.putString("serverTimeZone", timezone);
                    edit.apply();
                    this.W = this.I.getSharedPreferences("allowedFormat", 0);
                    this.X = this.I.getSharedPreferences("timeFormat", 0);
                    this.Y = this.I.getSharedPreferences("epgchannelupdate", 0);
                    this.Z = this.I.getSharedPreferences("automation_channels", 0);
                    this.e0 = this.I.getSharedPreferences("automation_epg", 0);
                    this.h0 = this.W.edit();
                    this.f0 = this.X.edit();
                    this.g0 = this.Y.edit();
                    this.i0 = this.Z.edit();
                    this.j0 = this.e0.edit();
                    SharedPreferences sharedPreferences = this.I.getSharedPreferences("auto_start", 0);
                    this.m0 = sharedPreferences;
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    this.n0 = edit2;
                    if (edit2 != null) {
                        edit2.putBoolean("full_epg", true);
                        this.n0.apply();
                    }
                    if (this.Z.getString("automation_channels", "").equals("")) {
                        this.i0.putString("automation_channels", "checked");
                        this.i0.apply();
                    }
                    if (this.e0.getString("automation_epg", "").equals("")) {
                        this.j0.putString("automation_epg", "checked");
                        this.j0.apply();
                    }
                    m7.a.c0 = Boolean.FALSE;
                    if (this.W.getString("allowedFormat", "").equals("")) {
                        this.h0.putString("allowedFormat", "ts");
                        this.h0.apply();
                    }
                    if (this.X.getString("timeFormat", m7.a.E0).equals("")) {
                        this.f0.putString("timeFormat", m7.a.E0);
                        this.f0.apply();
                    }
                    if (this.Y.getString("epgchannelupdate", "").equals("")) {
                        this.g0.putString("epgchannelupdate", "all");
                        this.g0.apply();
                    }
                    this.o0 = new MultiUserDBHandler(this.I);
                    boolean booleanValue = m7.a.o.booleanValue();
                    MultiUserDBHandler multiUserDBHandler = this.o0;
                    if (booleanValue) {
                        try {
                            if (multiUserDBHandler.checkregistration(this.y0, username, password, url, "api", url, "")) {
                                b();
                                Toast.makeText(this.I, getString(a7.j.D) + this.y0 + getString(a7.j.u8) + username + getString(a7.j.F) + m7.a.Z, 0).show();
                            } else {
                                this.o0.addmultiusers(this.y0, username, password, m7.a.Z, url, "api");
                                Toast.makeText(this.I, getResources().getString(a7.j.r8), 0).show();
                            }
                        } catch (WindowManager.BadTokenException e2) {
                            e2.printStackTrace();
                        }
                        SharedPreferences.Editor edit3 = this.I.getSharedPreferences("loginprefsmultiuser", 0).edit();
                        edit3.putString("name", this.y0);
                        edit3.putString("username", username);
                        edit3.putString("password", password);
                        edit3.putString(m7.a.L, url);
                        edit3.apply();
                    } else if (!multiUserDBHandler.checkregistration("", username, password, url, "api", url, "")) {
                        this.o0.addmultiusers("", username, password, m7.a.Z, url, "api");
                    }
                    if (this.I != null) {
                        SharepreferenceDBHandler.setUserID(this.o0.getAutoIdLoggedInUser(this.y0, username, password, url, "api", url, ""), this.I);
                    }
                    b();
                    startActivity(new Intent(this, NewDashboardActivity.class));
                    finish();
                    return;
                }
                b();
                string = getResources().getString(a7.j.H2) + status;
                i2 = 0;
            } else {
                i2 = 0;
                if (!str.equals("validateLogin")) {
                    return;
                }
                b();
                string = getResources().getString(a7.j.D2);
            }
            Toast.makeText(this, string, i2).show();
        }
    }

    public void onBackPressed() {
        if (m7.a.u.booleanValue()) {
            finish();
            finishAffinity();
        } else {
            if (this.G) {
                finish();
                finishAffinity();
                return;
            }
            this.G = true;
            try {
                Toast.makeText(this, getResources().getString(a7.j.F5), 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            new Handler().postDelayed(new L(this), 2000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 19) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.I);
        w.z0(this.I);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void r0(ActivationCallBack activationCallBack, String str) {
        y1();
    }

    public void w0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (m7.a.n.booleanValue()) {
                Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
                return;
            } else {
                w.P0(this.I, "Your Account is invalid or has expired !");
                return;
            }
        }
        try {
            this.U.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.U.apply();
            arrayList.remove(0);
            this.H.h(this.J, this.K, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void w1() {
        this.L0 = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public void x1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.O0 = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x039a, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0428, code lost:
    
        m7.w.P0(r18.I, "Your Account is invalid or has expired !");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0415, code lost:
    
        android.widget.Toast.makeText(r18, getResources().getString(a7.j.C2), 0).show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x03d5, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0413, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0464, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(com.nst.iptvsmarterstvbox.model.callback.LoginCallback r19, java.lang.String r20, java.util.ArrayList r21) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginActivity.y(com.nst.iptvsmarterstvbox.model.callback.LoginCallback, java.lang.String, java.util.ArrayList):void");
    }

    public void y1() {
        this.J0 = S1(b7.f.c(this) + "*" + b7.f.d(this) + "-" + this.J + "-" + b7.b.b + "-" + this.M0 + "-unknown-" + N1() + "-" + this.L0);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this)));
        b7.g.b.add(b7.g.a("sc", this.J0));
        b7.g.b.add(b7.g.a("u", this.J));
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", this.M0));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", N1()));
        b7.g.b.add(b7.g.a("do", this.L0));
        b7.g.c.b(this);
    }

    public final void z1() {
        startActivity(new Intent(this, FirebaseRegisterDeviceActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }
}
