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
import org.json.JSONException;
import org.json.JSONObject;
import p7.U;
import p7.V;
import p7.W;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LoginActivityOneStream extends androidx.appcompat.app.b implements z7.f, b7.c, z7.a {
    public static InputFilter U0 = new c();
    public ImageView A;
    public String A0;
    public TextView B;
    public SharedPreferences B0;
    public TextView C;
    public SharedPreferences.Editor C0;
    public ImageView D;
    public SharedPreferences D0;
    public TextView E;
    public SharedPreferences.Editor E0;
    public RelativeLayout F;
    public SharedPreferences F0;
    public n7.d I;
    public String K;
    public String L;
    public String L0;
    public ProgressDialog M;
    public String M0;
    public SharedPreferences N;
    public String N0;
    public SharedPreferences.Editor O;
    public String O0;
    public SharedPreferences P;
    public SharedPreferences Q;
    public int Q0;
    public SharedPreferences R;
    public String R0;
    public SharedPreferences.Editor S;
    public n7.a S0;
    public SharedPreferences T;
    public u7.a T0;
    public SharedPreferences.Editor U;
    public LiveStreamDBHandler V;
    public SharedPreferences W;
    public SharedPreferences X;
    public SharedPreferences Y;
    public SharedPreferences Z;
    public String d;
    public EditText e;
    public SharedPreferences e0;
    public EditText f;
    public SharedPreferences.Editor f0;
    public EditText g;
    public SharedPreferences.Editor g0;
    public EditText h;
    public SharedPreferences.Editor h0;
    public ImageView i;
    public SharedPreferences.Editor i0;
    public TextView j;
    public SharedPreferences.Editor j0;
    public LinearLayout k;
    public SharedPreferences.Editor k0;
    public Button l;
    public SharedPreferences l0;
    public TextView m;
    public SharedPreferences m0;
    public RelativeLayout n;
    public SharedPreferences.Editor n0;
    public RelativeLayout o;
    public MultiUserDBHandler o0;
    public RelativeLayout p;
    public DatabaseHandler p0;
    public RelativeLayout q;
    public RelativeLayout r;
    public Button s;
    public LinearLayout t;
    public ImageView u;
    public LinearLayout v;
    public RelativeLayout w;
    public ConstraintLayout x;
    public TextView y;
    public String y0;
    public ImageView z;
    public String z0;
    public int G = -1;
    public boolean H = false;
    public Context J = this;
    public String q0 = "";
    public String r0 = "";
    public String s0 = "";
    public String t0 = "";
    public long u0 = -1;
    public String v0 = "";
    public String w0 = "";
    public long x0 = -1;
    public String G0 = "";
    public ArrayList H0 = new ArrayList();
    public String I0 = t2();
    public long J0 = 0;
    public SimpleDateFormat K0 = new SimpleDateFormat("dd/MM/yyyy");
    public String P0 = Build.MODEL;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
            int i = loginActivityOneStream.G;
            if (i != -1) {
                loginActivityOneStream.G = i - 1;
                loginActivityOneStream.f.setInputType(129);
                LoginActivityOneStream.this.u.setImageResource(a7.e.h0);
            } else {
                loginActivityOneStream.f.setInputType(145);
                LoginActivityOneStream.this.u.setImageResource(a7.e.z2);
                LoginActivityOneStream.this.G++;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            LoginActivityOneStream.e2(LoginActivityOneStream.this, false);
        }
    }

    public class c implements InputFilter {
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

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", LoginActivityOneStream.z1(LoginActivityOneStream.this));
            Intent intent = new Intent(LoginActivityOneStream.z1(LoginActivityOneStream.this), ProfileActivity.class);
            intent.putExtra("typeid", "login");
            LoginActivityOneStream.this.startActivity(intent);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
            LoginActivityOneStream.B1(loginActivityOneStream, loginActivityOneStream.e.getText().toString().trim());
            LoginActivityOneStream loginActivityOneStream2 = LoginActivityOneStream.this;
            LoginActivityOneStream.X1(loginActivityOneStream2, loginActivityOneStream2.f.getText().toString().trim());
            LoginActivityOneStream loginActivityOneStream3 = LoginActivityOneStream.this;
            loginActivityOneStream3.y0 = loginActivityOneStream3.h.getText().toString().trim();
            LoginActivityOneStream loginActivityOneStream4 = LoginActivityOneStream.this;
            LoginActivityOneStream.h2(loginActivityOneStream4, LoginActivityOneStream.i2(loginActivityOneStream4).edit());
            LoginActivityOneStream.j2(LoginActivityOneStream.this);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            LoginActivityOneStream.k2(LoginActivityOneStream.this);
        }
    }

    public class g implements View.OnClickListener {

        public class a implements MyApplication.d {

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    LoginActivityOneStream.l2(LoginActivityOneStream.this);
                }
            }

            public class b implements Runnable {
                public final /* synthetic */ String a;

                public b(String str) {
                    this.a = str;
                }

                public void run() {
                    MyApplication.p().D("LOS" + this.a, LoginActivityOneStream.z1(LoginActivityOneStream.this));
                    LoginActivityOneStream.l2(LoginActivityOneStream.this);
                }
            }

            public class c implements Runnable {
                public final /* synthetic */ String a;

                public c(String str) {
                    this.a = str;
                }

                public void run() {
                    MyApplication.p().D("LOS" + this.a, LoginActivityOneStream.z1(LoginActivityOneStream.this));
                }
            }

            public a() {
            }

            public void a(String str) {
                LoginActivityOneStream.this.runOnUiThread(new b(str));
            }

            public void b(String str) {
                LoginActivityOneStream.this.runOnUiThread(new c(str));
            }

            public void onSuccess() {
                LoginActivityOneStream.this.runOnUiThread(new a());
            }
        }

        public g() {
        }

        public void onClick(View view) {
            if (!m7.a.W0.booleanValue() || (SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginActivityOneStream.z1(LoginActivityOneStream.this)) != null && SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginActivityOneStream.z1(LoginActivityOneStream.this)).length() > 0)) {
                LoginActivityOneStream.l2(LoginActivityOneStream.this);
            } else {
                MyApplication.p().G(LoginActivityOneStream.z1(LoginActivityOneStream.this), new a());
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            LoginActivityOneStream.this.startActivity(new Intent(LoginActivityOneStream.this, FreeTrailActivity.class));
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            m7.a.y = m7.a.y.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
            LoginActivityOneStream.m2(LoginActivityOneStream.this);
        }
    }

    public class j implements p1.c {
        public final /* synthetic */ ArrayList a;

        public j(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void a(JSONObject jSONObject) {
            Log.e("AUTH_API", String.valueOf(jSONObject));
            try {
                String string = jSONObject.getString("auth_token");
                if (string.isEmpty()) {
                    Log.e("AUTHAPI", "AUTHTOKEN IS EMPTY");
                    LoginActivityOneStream.n2(LoginActivityOneStream.this, this.a);
                } else {
                    LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
                    SharepreferenceDBHandler.setFirebaseOneStreamNode(loginActivityOneStream.d, LoginActivityOneStream.z1(loginActivityOneStream));
                    SharepreferenceDBHandler.setOneStreamToken(string, LoginActivityOneStream.z1(LoginActivityOneStream.this));
                    LoginActivityOneStream loginActivityOneStream2 = LoginActivityOneStream.this;
                    LoginActivityOneStream.A1(loginActivityOneStream2, loginActivityOneStream2.H0);
                }
            } catch (Exception e) {
                LoginActivityOneStream.n2(LoginActivityOneStream.this, this.a);
                e.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            LoginActivityOneStream.n2(LoginActivityOneStream.this, this.a);
        }
    }

    public class k implements p1.c {
        public final /* synthetic */ ArrayList a;

        public k(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void a(JSONObject jSONObject) {
            Toast makeText;
            Log.e("AUTH_API", String.valueOf(jSONObject));
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(String.valueOf(jSONObject)).getJSONObject("user_info");
                    if (jSONObject2 != null) {
                        LoginActivityOneStream.this.z0 = jSONObject2.getString("auth");
                        String str = LoginActivityOneStream.this.z0;
                        if (str != null && Integer.valueOf(str).intValue() != 0) {
                            LoginActivityOneStream.this.A0 = jSONObject2.getString("status");
                            String str2 = LoginActivityOneStream.this.A0;
                            if (str2 != null && str2.equals("Active")) {
                                LoginActivityOneStream.this.b();
                                JSONObject jSONObject3 = new JSONObject(String.valueOf(jSONObject));
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("user_info");
                                String string = jSONObject4.getString("username");
                                jSONObject4.getString("message");
                                String string2 = jSONObject4.getString("expire_at");
                                String string3 = jSONObject4.getString("active_connections");
                                String string4 = jSONObject4.getString("created_at");
                                String string5 = jSONObject4.getString("max_connections");
                                jSONObject4.getJSONArray("allowed_output_formats");
                                JSONObject jSONObject5 = jSONObject3.getJSONObject("server_info");
                                jSONObject5.getString("time_now");
                                String string6 = jSONObject5.getString("timezone");
                                if (!LoginActivityOneStream.this.A0.equals("Active")) {
                                    Toast.makeText(LoginActivityOneStream.this.getApplicationContext(), LoginActivityOneStream.this.getResources().getString(a7.j.H2) + LoginActivityOneStream.this.A0, 0).show();
                                    return;
                                }
                                LoginActivityOneStream.z1(LoginActivityOneStream.this).getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                                SharedPreferences.Editor edit = LoginActivityOneStream.this.getSharedPreferences("loginPrefs", 0).edit();
                                edit.putString("username", string);
                                edit.putString("password", LoginActivityOneStream.U1(LoginActivityOneStream.this));
                                edit.putString("auth", LoginActivityOneStream.this.z0);
                                edit.putString("status", LoginActivityOneStream.this.A0);
                                edit.putString("expDate", string2);
                                edit.putString("activeCons", string3);
                                edit.putString("createdAt", string4);
                                edit.putString("maxConnections", string5);
                                edit.putString("serverTimeZone", string6);
                                edit.apply();
                                LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
                                LoginActivityOneStream.D1(loginActivityOneStream, LoginActivityOneStream.z1(loginActivityOneStream).getSharedPreferences("allowedFormat", 0));
                                LoginActivityOneStream loginActivityOneStream2 = LoginActivityOneStream.this;
                                LoginActivityOneStream.F1(loginActivityOneStream2, LoginActivityOneStream.z1(loginActivityOneStream2).getSharedPreferences("timeFormat", 0));
                                LoginActivityOneStream loginActivityOneStream3 = LoginActivityOneStream.this;
                                LoginActivityOneStream.H1(loginActivityOneStream3, LoginActivityOneStream.z1(loginActivityOneStream3).getSharedPreferences("epgchannelupdate", 0));
                                LoginActivityOneStream loginActivityOneStream4 = LoginActivityOneStream.this;
                                LoginActivityOneStream.J1(loginActivityOneStream4, LoginActivityOneStream.z1(loginActivityOneStream4).getSharedPreferences("automation_channels", 0));
                                LoginActivityOneStream loginActivityOneStream5 = LoginActivityOneStream.this;
                                LoginActivityOneStream.L1(loginActivityOneStream5, LoginActivityOneStream.z1(loginActivityOneStream5).getSharedPreferences("automation_epg", 0));
                                LoginActivityOneStream loginActivityOneStream6 = LoginActivityOneStream.this;
                                LoginActivityOneStream.N1(loginActivityOneStream6, LoginActivityOneStream.C1(loginActivityOneStream6).edit());
                                LoginActivityOneStream loginActivityOneStream7 = LoginActivityOneStream.this;
                                LoginActivityOneStream.P1(loginActivityOneStream7, LoginActivityOneStream.E1(loginActivityOneStream7).edit());
                                LoginActivityOneStream loginActivityOneStream8 = LoginActivityOneStream.this;
                                LoginActivityOneStream.R1(loginActivityOneStream8, LoginActivityOneStream.G1(loginActivityOneStream8).edit());
                                LoginActivityOneStream loginActivityOneStream9 = LoginActivityOneStream.this;
                                LoginActivityOneStream.T1(loginActivityOneStream9, LoginActivityOneStream.I1(loginActivityOneStream9).edit());
                                LoginActivityOneStream loginActivityOneStream10 = LoginActivityOneStream.this;
                                LoginActivityOneStream.W1(loginActivityOneStream10, LoginActivityOneStream.K1(loginActivityOneStream10).edit());
                                LoginActivityOneStream loginActivityOneStream11 = LoginActivityOneStream.this;
                                LoginActivityOneStream.Z1(loginActivityOneStream11, LoginActivityOneStream.z1(loginActivityOneStream11).getSharedPreferences("auto_start", 0));
                                LoginActivityOneStream loginActivityOneStream12 = LoginActivityOneStream.this;
                                LoginActivityOneStream.b2(loginActivityOneStream12, LoginActivityOneStream.Y1(loginActivityOneStream12).edit());
                                if (LoginActivityOneStream.a2(LoginActivityOneStream.this) != null) {
                                    LoginActivityOneStream.a2(LoginActivityOneStream.this).putBoolean("full_epg", true);
                                    LoginActivityOneStream.a2(LoginActivityOneStream.this).apply();
                                }
                                if (LoginActivityOneStream.I1(LoginActivityOneStream.this).getString("automation_channels", "").equals("")) {
                                    LoginActivityOneStream.S1(LoginActivityOneStream.this).putString("automation_channels", "checked");
                                    LoginActivityOneStream.S1(LoginActivityOneStream.this).apply();
                                }
                                if (LoginActivityOneStream.K1(LoginActivityOneStream.this).getString("automation_epg", "").equals("")) {
                                    LoginActivityOneStream.V1(LoginActivityOneStream.this).putString("automation_epg", "checked");
                                    LoginActivityOneStream.V1(LoginActivityOneStream.this).apply();
                                }
                                m7.a.c0 = Boolean.FALSE;
                                if (LoginActivityOneStream.C1(LoginActivityOneStream.this).getString("allowedFormat", "").equals("")) {
                                    LoginActivityOneStream.M1(LoginActivityOneStream.this).putString("allowedFormat", "ts");
                                    LoginActivityOneStream.M1(LoginActivityOneStream.this).apply();
                                }
                                if (LoginActivityOneStream.E1(LoginActivityOneStream.this).getString("timeFormat", m7.a.E0).equals("")) {
                                    LoginActivityOneStream.O1(LoginActivityOneStream.this).putString("timeFormat", m7.a.E0);
                                    LoginActivityOneStream.O1(LoginActivityOneStream.this).apply();
                                }
                                if (LoginActivityOneStream.G1(LoginActivityOneStream.this).getString("epgchannelupdate", "").equals("")) {
                                    LoginActivityOneStream.Q1(LoginActivityOneStream.this).putString("epgchannelupdate", "all");
                                    LoginActivityOneStream.Q1(LoginActivityOneStream.this).apply();
                                }
                                LoginActivityOneStream.d2(LoginActivityOneStream.this, new MultiUserDBHandler(LoginActivityOneStream.z1(LoginActivityOneStream.this)));
                                if (m7.a.o.booleanValue()) {
                                    MultiUserDBHandler c2 = LoginActivityOneStream.c2(LoginActivityOneStream.this);
                                    LoginActivityOneStream loginActivityOneStream13 = LoginActivityOneStream.this;
                                    String str3 = loginActivityOneStream13.y0;
                                    String U1 = LoginActivityOneStream.U1(loginActivityOneStream13);
                                    String str4 = LoginActivityOneStream.this.d;
                                    try {
                                        if (c2.checkregistration(str3, string, U1, str4, "onestream_api", str4, "")) {
                                            LoginActivityOneStream.this.b();
                                            makeText = Toast.makeText(LoginActivityOneStream.z1(LoginActivityOneStream.this), LoginActivityOneStream.this.getString(a7.j.D) + LoginActivityOneStream.this.y0 + LoginActivityOneStream.this.getString(a7.j.u8) + string + LoginActivityOneStream.this.getString(a7.j.F) + m7.a.Z, 0);
                                        } else {
                                            MultiUserDBHandler c22 = LoginActivityOneStream.c2(LoginActivityOneStream.this);
                                            LoginActivityOneStream loginActivityOneStream14 = LoginActivityOneStream.this;
                                            c22.addmultiusers(loginActivityOneStream14.y0, string, LoginActivityOneStream.U1(loginActivityOneStream14), m7.a.Z, "", "onestream_api");
                                            makeText = Toast.makeText(LoginActivityOneStream.z1(LoginActivityOneStream.this), LoginActivityOneStream.this.getResources().getString(a7.j.r8), 0);
                                        }
                                        makeText.show();
                                    } catch (WindowManager.BadTokenException unused) {
                                    }
                                } else {
                                    MultiUserDBHandler c23 = LoginActivityOneStream.c2(LoginActivityOneStream.this);
                                    LoginActivityOneStream loginActivityOneStream15 = LoginActivityOneStream.this;
                                    String str5 = loginActivityOneStream15.y0;
                                    String U12 = LoginActivityOneStream.U1(loginActivityOneStream15);
                                    String str6 = LoginActivityOneStream.this.d;
                                    if (!c23.checkregistration(str5, string, U12, str6, "onestream_api", str6, "")) {
                                        MultiUserDBHandler c24 = LoginActivityOneStream.c2(LoginActivityOneStream.this);
                                        LoginActivityOneStream loginActivityOneStream16 = LoginActivityOneStream.this;
                                        c24.addmultiusers(loginActivityOneStream16.y0, string, LoginActivityOneStream.U1(loginActivityOneStream16), m7.a.Z, "", "onestream_api");
                                    }
                                }
                                SharedPreferences.Editor edit2 = LoginActivityOneStream.z1(LoginActivityOneStream.this).getSharedPreferences("loginprefsmultiuser", 0).edit();
                                edit2.putString("name", LoginActivityOneStream.this.y0);
                                edit2.putString("username", string);
                                edit2.putString("password", LoginActivityOneStream.U1(LoginActivityOneStream.this));
                                edit2.putString(m7.a.L, LoginActivityOneStream.this.d);
                                edit2.putString("expDate", string2);
                                edit2.apply();
                                if (LoginActivityOneStream.z1(LoginActivityOneStream.this) != null) {
                                    MultiUserDBHandler c25 = LoginActivityOneStream.c2(LoginActivityOneStream.this);
                                    LoginActivityOneStream loginActivityOneStream17 = LoginActivityOneStream.this;
                                    String str7 = loginActivityOneStream17.y0;
                                    String U13 = LoginActivityOneStream.U1(loginActivityOneStream17);
                                    String str8 = LoginActivityOneStream.this.d;
                                    SharepreferenceDBHandler.setUserID(c25.getAutoIdLoggedInUser(str7, string, U13, str8, "onestream_api", str8, ""), LoginActivityOneStream.z1(LoginActivityOneStream.this));
                                }
                                LoginActivityOneStream.this.b();
                                LoginActivityOneStream.this.startActivity(new Intent(LoginActivityOneStream.this.getApplicationContext(), ImportOneStreamActivity.class));
                                return;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            LoginActivityOneStream.n2(LoginActivityOneStream.this, this.a);
        }

        public void b(m1.a aVar) {
            Log.e("INFO_API", String.valueOf(aVar));
            Toast.makeText(LoginActivityOneStream.this.getApplicationContext(), LoginActivityOneStream.this.getResources().getString(a7.j.D2), 0).show();
        }
    }

    public class l extends Dialog implements View.OnClickListener {
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
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = l.b(l.this);
                        }
                    } else {
                        b = l.a(l.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = l.b(l.this);
                        }
                    } else {
                        b = l.a(l.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public l(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(l lVar) {
            return lVar.e;
        }

        public static /* synthetic */ LinearLayout b(l lVar) {
            return lVar.f;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.s1) {
                    dismiss();
                    LoginActivityOneStream.j2(LoginActivityOneStream.this);
                } else if (view.getId() != a7.f.X0) {
                } else {
                    dismiss();
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(LoginActivityOneStream.g2(LoginActivityOneStream.this).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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

    public class m extends AsyncTask {

        public class a implements MyApplication.d {
            public a() {
            }

            public static /* synthetic */ void c(a aVar, String str) {
                aVar.f(str);
            }

            public static /* synthetic */ void d(a aVar, String str) {
                aVar.g(str);
            }

            public static /* synthetic */ void e(LoginActivityOneStream loginActivityOneStream) {
                h(loginActivityOneStream);
            }

            private /* synthetic */ void f(String str) {
                MyApplication.p().D("LOS" + str, LoginActivityOneStream.z1(LoginActivityOneStream.this));
            }

            private /* synthetic */ void g(String str) {
                MyApplication.p().D("LOS" + str, LoginActivityOneStream.z1(LoginActivityOneStream.this));
                LoginActivityOneStream.f2(LoginActivityOneStream.this);
            }

            public static /* synthetic */ void h(LoginActivityOneStream loginActivityOneStream) {
                LoginActivityOneStream.f2(loginActivityOneStream);
            }

            public void a(String str) {
                LoginActivityOneStream.this.runOnUiThread(new W(this, str));
            }

            public void b(String str) {
                LoginActivityOneStream.this.runOnUiThread(new U(this, str));
            }

            public void onSuccess() {
                LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
                loginActivityOneStream.runOnUiThread(new V(loginActivityOneStream));
            }
        }

        public m() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                HttpURLConnection openConnection = new URL("http://www.google.com").openConnection();
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
                    MyApplication.p().G(LoginActivityOneStream.z1(LoginActivityOneStream.this), new a());
                    return;
                } else {
                    LoginActivityOneStream.f2(LoginActivityOneStream.this);
                    return;
                }
            }
            LoginActivityOneStream.this.b();
            LoginActivityOneStream loginActivityOneStream = LoginActivityOneStream.this;
            l lVar = loginActivityOneStream.new l(LoginActivityOneStream.z1(loginActivityOneStream));
            lVar.setCancelable(false);
            lVar.show();
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
            float f;
            View view2;
            LoginActivityOneStream loginActivityOneStream;
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
                        LoginActivityOneStream.this.r.setBackgroundResource(a7.e.t);
                        loginActivityOneStream = LoginActivityOneStream.this;
                        textView = loginActivityOneStream.C;
                    } else {
                        LoginActivityOneStream.this.F.setBackgroundResource(a7.e.d1);
                        LoginActivityOneStream.this.A.setImageResource(a7.e.f1);
                        loginActivityOneStream = LoginActivityOneStream.this;
                        textView = loginActivityOneStream.B;
                    }
                } else {
                    LoginActivityOneStream.this.w.setBackgroundResource(a7.e.d1);
                    LoginActivityOneStream.this.D.setImageResource(a7.e.h1);
                    loginActivityOneStream = LoginActivityOneStream.this;
                    textView = loginActivityOneStream.E;
                }
                textView.setTextColor(LoginActivityOneStream.z1(loginActivityOneStream).getResources().getColor(a7.c.f));
                return;
            }
            f = z ? 1.15f : 1.0f;
            try {
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("1")) {
                    editText = LoginActivityOneStream.this.e;
                    length = editText.length();
                } else if (this.a.getTag().equals("2")) {
                    editText = LoginActivityOneStream.this.f;
                    length = editText.length();
                } else {
                    if (!this.a.getTag().equals("3")) {
                        if (this.a.getTag().equals("rl_list_users")) {
                            LoginActivityOneStream.this.w.setBackgroundResource(a7.e.c1);
                            LoginActivityOneStream.this.D.setImageResource(a7.e.g1);
                            LoginActivityOneStream loginActivityOneStream2 = LoginActivityOneStream.this;
                            loginActivityOneStream2.E.setTextColor(LoginActivityOneStream.z1(loginActivityOneStream2).getResources().getColor(a7.c.G));
                            b(f);
                        } else if (this.a.getTag().equals("rl_login_from_mobile_app")) {
                            b(f);
                        } else {
                            if (!this.a.getTag().equals("rl_connect_vpn")) {
                                if (this.a.getTag().equals("rl_bt_submit")) {
                                    LoginActivityOneStream.this.r.setBackgroundResource(a7.e.s);
                                    LoginActivityOneStream loginActivityOneStream3 = LoginActivityOneStream.this;
                                    loginActivityOneStream3.C.setTextColor(LoginActivityOneStream.z1(loginActivityOneStream3).getResources().getColor(a7.c.G));
                                    return;
                                }
                                return;
                            }
                            LoginActivityOneStream.this.F.setBackgroundResource(a7.e.c1);
                            LoginActivityOneStream.this.A.setImageResource(a7.e.e1);
                            LoginActivityOneStream loginActivityOneStream4 = LoginActivityOneStream.this;
                            loginActivityOneStream4.B.setTextColor(LoginActivityOneStream.z1(loginActivityOneStream4).getResources().getColor(a7.c.G));
                            b(f);
                        }
                        c(f);
                        return;
                    }
                    editText = LoginActivityOneStream.this.g;
                    length = editText.length();
                }
                editText.setSelection(length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void A1(LoginActivityOneStream loginActivityOneStream, ArrayList arrayList) {
        loginActivityOneStream.u2(arrayList);
    }

    private void A2() {
        EditText editText;
        int i2;
        EditText editText2;
        int i3;
        EditText editText3;
        int i4;
        EditText editText4;
        this.h = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.h.setPaddingRelative(35, 0, 35, 0);
        this.h.setLayoutParams(layoutParams);
        this.h.setHint(getResources().getString(a7.j.d9));
        this.h.setHintTextColor(getResources().getColor(a7.c.G));
        this.h.setHintTextColor(-1);
        if (m7.a.t.booleanValue()) {
            editText = this.h;
            i2 = a7.f.Ae;
        } else {
            editText = this.h;
            i2 = a7.f.he;
        }
        editText.setNextFocusLeftId(i2);
        this.h.setTextSize(22.0f);
        this.h.setId(101);
        this.h.setBackground(getResources().getDrawable(a7.e.J1));
        this.h.setFocusable(true);
        EditText editText5 = this.h;
        Typeface typeface = Typeface.SANS_SERIF;
        editText5.setTypeface(typeface);
        this.h.setInputType(161);
        this.n.addView(this.h);
        this.e = new EditText(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        this.e.setPaddingRelative(35, 0, 35, 0);
        this.e.setLayoutParams(layoutParams2);
        if (m7.a.z.booleanValue()) {
            this.v.setGravity(16);
        }
        this.e.setHint(getResources().getString(a7.j.t8));
        this.e.setHintTextColor(getResources().getColor(a7.c.G));
        this.e.setHintTextColor(-1);
        this.e.setTextSize(22.0f);
        this.e.setId(102);
        if (m7.a.t.booleanValue()) {
            editText2 = this.e;
            i3 = a7.f.Ae;
        } else {
            editText2 = this.e;
            i3 = a7.f.he;
        }
        editText2.setNextFocusLeftId(i3);
        this.e.setFocusable(true);
        this.e.setBackground(getResources().getDrawable(a7.e.J1));
        this.e.setTypeface(typeface);
        this.e.setInputType(161);
        this.o.addView(this.e);
        this.f = new EditText(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        this.f.setPaddingRelative(35, 0, 35, 0);
        this.f.setLayoutParams(layoutParams3);
        this.f.setHint(getResources().getString(a7.j.X4));
        this.f.setHintTextColor(getResources().getColor(a7.c.G));
        this.f.setHintTextColor(-1);
        this.f.setTextSize(22.0f);
        this.f.setId(103);
        if (m7.a.t.booleanValue()) {
            editText3 = this.f;
            i4 = a7.f.Ae;
        } else {
            editText3 = this.f;
            i4 = a7.f.he;
        }
        editText3.setNextFocusLeftId(i4);
        this.f.setBackground(getResources().getDrawable(a7.e.J1));
        this.f.setFocusable(true);
        this.f.setTypeface(typeface);
        this.f.setInputType(129);
        this.p.addView(this.f);
        this.u.setId(110);
        this.u.setFocusable(true);
        this.f.setNextFocusDownId(104);
        this.f.setNextFocusUpId(102);
        this.u.setNextFocusDownId(104);
        this.u.setNextFocusUpId(102);
        this.u.setBackground(getResources().getDrawable(a7.e.J1));
        this.u.setOnClickListener(new a());
        if (m7.a.o.booleanValue()) {
            this.g = new EditText(this);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
            this.g.setPaddingRelative(35, 0, 35, 0);
            this.g.setLayoutParams(layoutParams4);
            this.g.setHint(getResources().getString(a7.j.P6));
            this.g.setHintTextColor(getResources().getColor(a7.c.G));
            this.g.setHintTextColor(-1);
            this.g.setTextSize(22.0f);
            this.g.setId(104);
            this.g.setBackground(getResources().getDrawable(a7.e.J1));
            this.g.setFocusable(true);
            this.g.setTypeface(typeface);
            this.g.setInputType(161);
            this.q.addView(this.g);
        }
        if (m7.a.t.booleanValue()) {
            this.h.requestFocus();
            editText4 = this.h;
        } else {
            this.e.requestFocus();
            editText4 = this.e;
        }
        editText4.requestFocusFromTouch();
    }

    public static /* synthetic */ String B1(LoginActivityOneStream loginActivityOneStream, String str) {
        loginActivityOneStream.K = str;
        return str;
    }

    private void B2() {
        if (m7.a.y.booleanValue()) {
            if (m7.a.y.booleanValue()) {
                SharepreferenceDBHandler.setActivationCode(this.J, this.K);
                this.y0 = this.h.getText().toString().trim();
                n7.a aVar = new n7.a(this, this.J);
                this.S0 = aVar;
                aVar.a(this.K);
                return;
            }
            return;
        }
        if (m7.a.n.booleanValue()) {
            this.U.putString(m7.a.L, "http://qqtv.nl");
            this.U.apply();
            this.O.putString(m7.a.L, "http://qqtv.nl");
            this.O.putString("username", this.K);
            this.O.apply();
            if (m7.a.t.booleanValue()) {
                D2("http://qqtv.nl");
            }
        } else if (m7.a.o.booleanValue()) {
            try {
                String lowerCase = this.g.getText().toString().trim().toLowerCase();
                this.d = lowerCase;
                this.U.putString(m7.a.L, lowerCase);
                this.U.apply();
                this.O.putString(m7.a.L, this.d);
                this.O.apply();
                D2(this.d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            x1();
        }
        this.S.putString("username", this.K);
        this.S.putString("password", this.L);
        this.S.putString("activationCode", "");
        this.S.putString("loginWith", "loginWithDetails");
        this.S.apply();
        this.U.apply();
    }

    public static /* synthetic */ SharedPreferences C1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.W;
    }

    private void C2() {
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.J);
        startActivity(new Intent(this, MultiUserActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
    }

    public static /* synthetic */ SharedPreferences D1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.W = sharedPreferences;
        return sharedPreferences;
    }

    private void D2(String str) {
        ArrayList arrayList;
        if (!m7.a.o.booleanValue()) {
            if (str != null && !str.isEmpty()) {
                arrayList = new ArrayList(Arrays.asList(str.split(",")));
            }
            G2(this.H0);
        }
        arrayList = new ArrayList();
        arrayList.add(str);
        this.H0 = arrayList;
        G2(this.H0);
    }

    public static /* synthetic */ SharedPreferences E1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.X;
    }

    private void E2() {
        this.K = this.e.getText().toString().trim();
        this.L = this.f.getText().toString().trim();
        this.y0 = this.h.getText().toString().trim();
        this.U = this.T.edit();
        if (r2()) {
            a();
            new m().execute(new Void[0]);
        }
    }

    public static /* synthetic */ SharedPreferences F1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.X = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences G1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.Y;
    }

    public static /* synthetic */ SharedPreferences H1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.Y = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences I1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.Z;
    }

    public static /* synthetic */ SharedPreferences J1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.Z = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences K1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.e0;
    }

    public static /* synthetic */ SharedPreferences L1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.e0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor M1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.h0;
    }

    public static /* synthetic */ SharedPreferences.Editor N1(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.h0 = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor O1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.f0;
    }

    public static /* synthetic */ SharedPreferences.Editor P1(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.f0 = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor Q1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.g0;
    }

    public static /* synthetic */ SharedPreferences.Editor R1(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.g0 = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor S1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.i0;
    }

    public static /* synthetic */ SharedPreferences.Editor T1(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.i0 = editor;
        return editor;
    }

    public static /* synthetic */ String U1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.L;
    }

    public static /* synthetic */ SharedPreferences.Editor V1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.j0;
    }

    public static /* synthetic */ SharedPreferences.Editor W1(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.j0 = editor;
        return editor;
    }

    public static /* synthetic */ String X1(LoginActivityOneStream loginActivityOneStream, String str) {
        loginActivityOneStream.L = str;
        return str;
    }

    public static /* synthetic */ SharedPreferences Y1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.m0;
    }

    public static /* synthetic */ SharedPreferences Z1(LoginActivityOneStream loginActivityOneStream, SharedPreferences sharedPreferences) {
        loginActivityOneStream.m0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor a2(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.n0;
    }

    public static /* synthetic */ SharedPreferences.Editor b2(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.n0 = editor;
        return editor;
    }

    public static /* synthetic */ MultiUserDBHandler c2(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.o0;
    }

    public static /* synthetic */ MultiUserDBHandler d2(LoginActivityOneStream loginActivityOneStream, MultiUserDBHandler multiUserDBHandler) {
        loginActivityOneStream.o0 = multiUserDBHandler;
        return multiUserDBHandler;
    }

    public static /* synthetic */ boolean e2(LoginActivityOneStream loginActivityOneStream, boolean z) {
        loginActivityOneStream.H = z;
        return z;
    }

    public static /* synthetic */ void f2(LoginActivityOneStream loginActivityOneStream) {
        loginActivityOneStream.B2();
    }

    public static /* synthetic */ u7.a g2(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.T0;
    }

    public static /* synthetic */ SharedPreferences.Editor h2(LoginActivityOneStream loginActivityOneStream, SharedPreferences.Editor editor) {
        loginActivityOneStream.U = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences i2(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.T;
    }

    public static /* synthetic */ void j2(LoginActivityOneStream loginActivityOneStream) {
        loginActivityOneStream.E2();
    }

    public static /* synthetic */ void k2(LoginActivityOneStream loginActivityOneStream) {
        loginActivityOneStream.C2();
    }

    public static /* synthetic */ void l2(LoginActivityOneStream loginActivityOneStream) {
        loginActivityOneStream.y1();
    }

    public static /* synthetic */ void m2(LoginActivityOneStream loginActivityOneStream) {
        loginActivityOneStream.w2();
    }

    public static /* synthetic */ void n2(LoginActivityOneStream loginActivityOneStream, ArrayList arrayList) {
        loginActivityOneStream.G2(arrayList);
    }

    private static String p2(String str) {
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

    private void q2() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private String t2() {
        return w.p0(Calendar.getInstance().getTime().toString());
    }

    public static String v2() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return p2(str2);
        }
        return p2(str) + " " + str2;
    }

    private void w2() {
        TextView textView;
        int i2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ProgressDialog progressDialog;
        String string;
        try {
            this.J = this;
            this.o0 = new MultiUserDBHandler(this.J);
            this.V = new LiveStreamDBHandler(this.J);
            if (m7.a.z.booleanValue()) {
                this.m.setVisibility(0);
            }
            if (m7.a.t.booleanValue()) {
                textView = this.m;
                i2 = a7.f.Ae;
            } else {
                textView = this.m;
                i2 = a7.f.he;
            }
            textView.setNextFocusLeftId(i2);
            if (m7.a.y.booleanValue()) {
                this.e.setHint((CharSequence) null);
                this.e.setHint("");
                this.m.setText(getResources().getString(a7.j.O8));
                this.j.setText(getResources().getString(a7.j.m1));
                this.q.setVisibility(8);
                this.t.setVisibility(8);
                this.e.setVisibility(8);
                this.e.setVisibility(0);
                this.e.setHint(getResources().getString(a7.j.o));
                this.C.setText(getResources().getString(a7.j.o0));
                if (m7.a.t.booleanValue()) {
                    this.n.setVisibility(0);
                } else {
                    this.n.setVisibility(8);
                }
                if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                    relativeLayout2 = this.w;
                } else if (m7.a.u.booleanValue()) {
                    relativeLayout2 = this.w;
                } else {
                    relativeLayout = this.w;
                    relativeLayout.setVisibility(8);
                }
                relativeLayout2.setVisibility(0);
            } else {
                if (m7.a.t.booleanValue()) {
                    this.e.setHint((CharSequence) null);
                    this.e.setHint("");
                    this.m.setText(getResources().getString(a7.j.P8));
                    this.C.setText(getResources().getString(a7.j.s));
                    this.e.setVisibility(8);
                    this.e.setVisibility(0);
                    this.e.setHint(getResources().getString(a7.j.t8));
                    this.t.setVisibility(0);
                    this.n.setVisibility(0);
                    if (m7.a.o.booleanValue()) {
                        this.q.setVisibility(0);
                    } else {
                        this.q.setVisibility(8);
                    }
                    if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                        relativeLayout2 = this.w;
                    } else if (m7.a.u.booleanValue()) {
                        relativeLayout2 = this.w;
                    } else {
                        relativeLayout = this.w;
                    }
                    relativeLayout2.setVisibility(0);
                } else {
                    this.e.setHint((CharSequence) null);
                    this.e.setHint("");
                    this.m.setText(getResources().getString(a7.j.P8));
                    this.j.setText(getResources().getString(a7.j.B0));
                    this.e.setVisibility(8);
                    this.e.setVisibility(0);
                    this.t.setVisibility(0);
                    this.e.setHint(getResources().getString(a7.j.t8));
                    this.C.setText(getResources().getString(a7.j.P7));
                    this.q.setVisibility(8);
                    this.n.setVisibility(8);
                    relativeLayout = this.w;
                }
                relativeLayout.setVisibility(8);
            }
            this.h.setError((CharSequence) null);
            this.e.setError((CharSequence) null);
            this.f.setError((CharSequence) null);
            this.p0 = new DatabaseHandler(this.J);
            if (this.J != null) {
                this.M = new ProgressDialog(this.J);
                String str = this.R0;
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
            this.K = this.e.getText().toString();
            this.L = this.f.getText().toString();
            this.I = new n7.d(this, this.J);
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
            this.B0 = sharedPreferences3;
            this.C0 = sharedPreferences3.edit();
            SharedPreferences sharedPreferences4 = getSharedPreferences("multiDNSValid", 0);
            this.D0 = sharedPreferences4;
            this.E0 = sharedPreferences4.edit();
            this.F0 = getSharedPreferences("serverUrlDNS", 0);
            if (m7.a.t.booleanValue()) {
                this.e.setText("");
                this.f.setText("");
            }
            x2();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private void y1() {
        startActivity(new Intent(this, FirebaseRegisterDeviceActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public static String y2(String str) {
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

    public static /* synthetic */ Context z1(LoginActivityOneStream loginActivityOneStream) {
        return loginActivityOneStream.J;
    }

    public final void F2(ArrayList arrayList) {
        m7.a.Z = this.d;
        j1.a.b(this.d + "play/b2c/v1/auth").s("username", this.K).s("password", this.L).t("Content-Type", "FormUrlEncoded").v(k1.e.MEDIUM).u().o(new j(arrayList));
    }

    public final void G2(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            b();
            Toast.makeText(this, this.J.getResources().getString(a7.j.D2), 0).show();
            return;
        }
        try {
            String trim = ((String) arrayList.get(0)).trim();
            this.d = trim;
            if (!trim.startsWith("http://") && !this.d.startsWith("https://")) {
                this.d = "http://" + this.d;
            }
            if (!this.d.endsWith("/")) {
                this.d += "/";
            }
            this.U.putString(m7.a.L, this.d);
            this.U.apply();
            arrayList.remove(0);
            w1(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void S(String str) {
        b();
        if (str != null) {
            w.P0(this.J, str);
        } else {
            w.P0(this.J, "Your Activation code is not invalid");
        }
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
        if (this.J != null) {
            b();
            Toast.makeText(this, this.J.getResources().getString(a7.j.A0), 0).show();
        }
    }

    public void c(String str) {
        b();
        if (!str.equals("")) {
            w.P0(this.J, str);
        } else if (m7.a.n.booleanValue()) {
            Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
        } else {
            w.P0(this.J, "Your Account is invalid or has expired !");
        }
    }

    public void d(String str) {
        if (this.J == null || str.isEmpty()) {
            return;
        }
        w.P0(this.J, str);
    }

    public void e(String str) {
        ProgressDialog progressDialog = this.M;
        if (progressDialog != null) {
            progressDialog.dismiss();
            Toast.makeText(this, this.J.getResources().getString(a7.j.G2), 0).show();
        }
    }

    public void h0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (m7.a.n.booleanValue()) {
                Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
                return;
            } else {
                w.P0(this.J, "Your Account is invalid or has expired !");
                return;
            }
        }
        try {
            this.U.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.U.apply();
            arrayList.remove(0);
            this.I.h(this.K, this.L, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void m(LoginCallback loginCallback, String str) {
        Context context;
        String str2;
        int i2;
        if (this.J != null) {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null) {
                b();
                d(getResources().getString(a7.j.F2));
                return;
            }
            if (loginCallback.getUserLoginInfo().getAuth().intValue() == 1) {
                String status = loginCallback.getUserLoginInfo().getStatus();
                if (!status.equals("Active")) {
                    b();
                    Toast.makeText(this, getResources().getString(a7.j.H2) + status, 0).show();
                    return;
                }
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
                this.J.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
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
                this.W = this.J.getSharedPreferences("allowedFormat", 0);
                this.X = this.J.getSharedPreferences("timeFormat", 0);
                this.Y = this.J.getSharedPreferences("epgchannelupdate", 0);
                this.Z = this.J.getSharedPreferences("automation_channels", 0);
                this.e0 = this.J.getSharedPreferences("automation_epg", 0);
                this.h0 = this.W.edit();
                this.f0 = this.X.edit();
                this.g0 = this.Y.edit();
                this.i0 = this.Z.edit();
                this.j0 = this.e0.edit();
                SharedPreferences sharedPreferences = this.J.getSharedPreferences("auto_start", 0);
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
                this.o0 = new MultiUserDBHandler(this.J);
                boolean booleanValue = m7.a.o.booleanValue();
                MultiUserDBHandler multiUserDBHandler = this.o0;
                if (booleanValue) {
                    try {
                        if (multiUserDBHandler.checkregistration(this.y0, username, password, url, "onestream_api", url, "")) {
                            b();
                            context = this.J;
                            str2 = getString(a7.j.D) + this.y0 + getString(a7.j.u8) + username + getString(a7.j.F) + m7.a.Z;
                            i2 = 0;
                        } else {
                            this.o0.addmultiusers(this.y0, username, password, m7.a.Z, url, "onestream_api");
                            context = this.J;
                            str2 = getResources().getString(a7.j.r8);
                            i2 = 0;
                        }
                        Toast.makeText(context, str2, i2).show();
                    } catch (WindowManager.BadTokenException unused) {
                    }
                    SharedPreferences.Editor edit3 = this.J.getSharedPreferences("loginprefsmultiuser", 0).edit();
                    edit3.putString("name", this.y0);
                    edit3.putString("username", username);
                    edit3.putString("password", password);
                    edit3.putString(m7.a.L, url);
                    edit3.apply();
                } else if (!multiUserDBHandler.checkregistration("", username, password, url, "onestream_api", url, "")) {
                    this.o0.addmultiusers("", username, password, m7.a.Z, url, "onestream_api");
                }
                try {
                    if (Build.VERSION.SDK_INT != 25) {
                        Toast.makeText(this.J, getResources().getString(a7.j.b3), 0).show();
                    }
                } catch (WindowManager.BadTokenException unused2) {
                }
                if (this.J != null) {
                    SharepreferenceDBHandler.setUserID(this.o0.getAutoIdLoggedInUser(this.y0, username, password, url, "onestream_api", url, ""), this.J);
                }
                b();
                startActivity(new Intent(this, ImportOneStreamActivity.class));
                finish();
            }
        }
    }

    public void o2() {
        try {
            this.O0 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (m7.a.u.booleanValue()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            if (this.H) {
                super/*androidx.activity.ComponentActivity*/.onBackPressed();
                return;
            }
            this.H = true;
            try {
                Toast.makeText(this, getResources().getString(a7.j.F5), 0).show();
            } catch (Exception unused) {
            }
            new Handler().postDelayed(new b(), 2000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginActivityOneStream.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 19) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.J);
        w.z0(this.J);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void r0(ActivationCallBack activationCallBack, String str) {
        x1();
    }

    public boolean r2() {
        EditText editText;
        Resources resources;
        int i2;
        EditText editText2;
        Resources resources2;
        int i3;
        if (m7.a.t.booleanValue() && this.h.getText().toString().trim().length() == 0) {
            this.h.requestFocus();
            editText = this.h;
            resources = getResources();
            i2 = a7.j.n1;
        } else {
            if (this.e.getText().toString().trim().length() == 0) {
                this.e.requestFocus();
                if (m7.a.y.booleanValue()) {
                    editText2 = this.e;
                    resources2 = getResources();
                    i3 = a7.j.m1;
                } else {
                    editText2 = this.e;
                    resources2 = getResources();
                    i3 = a7.j.A1;
                }
                editText2.setError(resources2.getString(i3));
                return false;
            }
            if (!m7.a.y.booleanValue() && this.f.getText().toString().trim().length() == 0) {
                this.f.requestFocus();
                editText = this.f;
                resources = getResources();
                i2 = a7.j.v1;
            } else {
                if (!m7.a.o.booleanValue() || this.g.getText().toString().trim().length() != 0) {
                    return true;
                }
                this.g.requestFocus();
                editText = this.g;
                resources = getResources();
                i2 = a7.j.w1;
            }
        }
        editText.setError(resources.getString(i2));
        return false;
    }

    public void s2() {
        Button button;
        int i2;
        A2();
        this.F.setOnClickListener(new d());
        this.r.setOnClickListener(new e());
        this.w.setOnClickListener(new f());
        this.x.setOnClickListener(new g());
        if (m7.a.x.booleanValue()) {
            button = this.l;
            i2 = 0;
        } else {
            button = this.l;
            i2 = 8;
        }
        button.setVisibility(i2);
        this.l.setOnClickListener(new h());
        this.m.setOnClickListener(new i());
    }

    public void u1() {
        this.N0 = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public final void u2(ArrayList arrayList) {
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.J);
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.J);
        m7.a.Z = this.d;
        j1.a.a(this.d + "play/b2c/v1/user-info?token=" + oneStreamToken).s(k1.e.MEDIUM).q().o(new k(arrayList));
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.Q0 = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void w0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (m7.a.n.booleanValue()) {
                Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
                return;
            } else {
                w.P0(this.J, "Your Account is invalid or has expired !");
                return;
            }
        }
        try {
            this.U.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.U.apply();
            arrayList.remove(0);
            this.I.h(this.K, this.L, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void w1(ArrayList arrayList) {
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.J);
        String string = this.J.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "");
        this.d = string;
        this.d = string.toLowerCase();
        Log.e("URl from Back", ">>>>>>>>" + this.d);
        if (!this.d.startsWith("http://") && !this.d.startsWith("https://")) {
            this.d = "http://" + this.d;
        }
        if (!this.d.endsWith("/")) {
            this.d += "/";
        }
        F2(arrayList);
    }

    public void x1() {
        this.L0 = y2(b7.f.c(this) + "*" + b7.f.d(this) + "-" + this.K + "-" + b7.b.b + "-" + this.O0 + "-unknown-" + v2() + "-" + this.N0);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this)));
        b7.g.b.add(b7.g.a("sc", this.L0));
        b7.g.b.add(b7.g.a("u", this.K));
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", this.O0));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", v2()));
        b7.g.b.add(b7.g.a("do", this.N0));
        b7.g.c.b(this);
    }

    public void x2() {
        EditText editText;
        try {
            if (m7.a.t.booleanValue()) {
                this.h.requestFocus();
                editText = this.h;
            } else {
                this.e.requestFocus();
                editText = this.e;
            }
            editText.requestFocusFromTouch();
            b();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0377, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x03ef, code lost:
    
        m7.w.P0(r18.J, "Your Account is invalid or has expired !");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x03f4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x03dc, code lost:
    
        r0 = getResources();
        r2 = a7.j.C2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x03da, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(com.nst.iptvsmarterstvbox.model.callback.LoginCallback r19, java.lang.String r20, java.util.ArrayList r21) {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginActivityOneStream.y(com.nst.iptvsmarterstvbox.model.callback.LoginCallback, java.lang.String, java.util.ArrayList):void");
    }

    /* renamed from: z2, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i2, boolean z) {
        String trim;
        if (!z) {
            b();
            Toast.makeText(this, this.J.getResources().getString(a7.j.A0), 0).show();
            return;
        }
        if (i2 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (!jSONObject.getString("status").equalsIgnoreCase("true")) {
                    b();
                    Toast.makeText(this, this.J.getResources().getString(a7.j.M7), 0).show();
                    return;
                }
                this.v0 = b7.b.a.getString("su");
                this.w0 = b7.b.a.getString("ndd");
                this.x0 = System.currentTimeMillis();
                try {
                    if (m7.a.y.booleanValue()) {
                        this.K = SharepreferenceDBHandler.getUserName(this.J);
                        trim = SharepreferenceDBHandler.getUserPassword(this.J);
                    } else {
                        this.K = this.e.getText().toString().trim();
                        trim = this.f.getText().toString().trim();
                    }
                    this.L = trim;
                    b7.f.e(this, b7.b.a.optString("su"));
                    this.M0 = y2(b7.b.a.optString("su") + "*" + b7.f.d(this) + "*" + b7.b.b);
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(this.M0)) {
                        b();
                        Toast.makeText(this, this.J.getResources().getString(a7.j.A0), 0).show();
                        return;
                    }
                    this.U.putString(m7.a.L, b7.f.a(this));
                    this.U.apply();
                    this.O.putString(m7.a.L, b7.f.a(this));
                    this.O.putString("username", this.K);
                    this.O.apply();
                    D2(this.v0.toLowerCase());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                Log.e("Login check", e3.getMessage());
            }
        }
    }
}
