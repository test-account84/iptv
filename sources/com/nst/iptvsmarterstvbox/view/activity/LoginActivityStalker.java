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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.FreeTrailActivity;
import com.nst.iptvsmarterstvbox.model.callback.ActivationCallBack;
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
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import m7.w;
import org.json.JSONObject;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LoginActivityStalker extends androidx.appcompat.app.b implements z7.g, b7.c, z7.a {
    public static InputFilter K0 = new a();
    public n7.e A;
    public String B0;
    public String C;
    public String C0;
    public String D;
    public String D0;
    public ProgressDialog E;
    public String E0;
    public SharedPreferences F;
    public SharedPreferences.Editor G;
    public int G0;
    public SharedPreferences H;
    public String H0;
    public SharedPreferences I;
    public n7.a I0;
    public SharedPreferences J;
    public u7.a J0;
    public SharedPreferences.Editor K;
    public SharedPreferences L;
    public SharedPreferences.Editor M;
    public LiveStreamDBHandler N;
    public SharedPreferences O;
    public SharedPreferences P;
    public SharedPreferences Q;
    public SharedPreferences R;
    public SharedPreferences S;
    public SharedPreferences.Editor T;
    public SharedPreferences.Editor U;
    public SharedPreferences.Editor V;
    public SharedPreferences.Editor W;
    public SharedPreferences.Editor X;
    public SharedPreferences.Editor Y;
    public SharedPreferences Z;
    public EditText d;
    public EditText e;
    public SharedPreferences e0;
    public EditText f;
    public SharedPreferences.Editor f0;
    public ImageView g;
    public MultiUserDBHandler g0;
    public TextView h;
    public DatabaseHandler h0;
    public LinearLayout i;
    public Button j;
    public TextView k;
    public RelativeLayout l;
    public RelativeLayout m;
    public RelativeLayout n;
    public Button o;
    public LinearLayout p;
    public RelativeLayout q;
    public String q0;
    public ImageView r;
    public SharedPreferences r0;
    public TextView s;
    public SharedPreferences.Editor s0;
    public TextView t;
    public SharedPreferences t0;
    public ImageView u;
    public SharedPreferences.Editor u0;
    public TextView v;
    public SharedPreferences v0;
    public RelativeLayout w;
    public RelativeLayout x;
    public int y = -1;
    public boolean z = false;
    public Context B = this;
    public String i0 = "";
    public String j0 = "";
    public String k0 = "";
    public String l0 = "";
    public long m0 = -1;
    public String n0 = "";
    public String o0 = "";
    public long p0 = -1;
    public String w0 = "";
    public ArrayList x0 = new ArrayList();
    public String y0 = J1();
    public long z0 = 0;
    public SimpleDateFormat A0 = new SimpleDateFormat("dd/MM/yyyy");
    public String F0 = Build.MODEL;

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

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", LoginActivityStalker.x1(LoginActivityStalker.this));
            Intent intent = new Intent(LoginActivityStalker.x1(LoginActivityStalker.this), ProfileActivity.class);
            intent.putExtra("typeid", "login");
            LoginActivityStalker.this.startActivity(intent);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            LoginActivityStalker.y1(LoginActivityStalker.this);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            LoginActivityStalker.z1(LoginActivityStalker.this);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            LoginActivityStalker.this.startActivity(new Intent(LoginActivityStalker.this, FreeTrailActivity.class));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            m7.a.y = m7.a.y.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
            LoginActivityStalker.A1(LoginActivityStalker.this);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            LoginActivityStalker.B1(LoginActivityStalker.this, false);
        }
    }

    public class h extends Dialog implements View.OnClickListener {
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
            return hVar.e;
        }

        public static /* synthetic */ LinearLayout b(h hVar) {
            return hVar.f;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.s1) {
                    dismiss();
                    LoginActivityStalker.y1(LoginActivityStalker.this);
                } else if (view.getId() != a7.f.X0) {
                } else {
                    dismiss();
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(LoginActivityStalker.D1(LoginActivityStalker.this).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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

    public class i extends AsyncTask {
        public i() {
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
                if (!m7.a.y.booleanValue()) {
                    LoginActivityStalker.this.w1();
                    return;
                } else {
                    LoginActivityStalker loginActivityStalker = LoginActivityStalker.this;
                    LoginActivityStalker.C1(loginActivityStalker, new n7.a(loginActivityStalker, LoginActivityStalker.x1(loginActivityStalker)));
                    return;
                }
            }
            LoginActivityStalker.this.b();
            LoginActivityStalker loginActivityStalker2 = LoginActivityStalker.this;
            h hVar = loginActivityStalker2.new h(LoginActivityStalker.x1(loginActivityStalker2));
            hVar.setCancelable(false);
            hVar.show();
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
            float f;
            LoginActivityStalker loginActivityStalker;
            TextView textView;
            if (z) {
                f = z ? 1.15f : 1.0f;
                try {
                    Log.e("id is", "" + this.a.getTag());
                    if (this.a.getTag().equals("3")) {
                        EditText editText = LoginActivityStalker.this.d;
                        editText.setSelection(editText.length());
                        return;
                    }
                    if (this.a.getTag().equals("rl_list_users")) {
                        LoginActivityStalker.this.q.setBackgroundResource(a7.e.c1);
                        LoginActivityStalker.this.u.setImageResource(a7.e.g1);
                        LoginActivityStalker loginActivityStalker2 = LoginActivityStalker.this;
                        loginActivityStalker2.v.setTextColor(LoginActivityStalker.x1(loginActivityStalker2).getResources().getColor(a7.c.G));
                        b(f);
                    } else {
                        if (!this.a.getTag().equals("rl_connect_vpn")) {
                            if (this.a.getTag().equals("rl_bt_submit")) {
                                LoginActivityStalker.this.n.setBackgroundResource(a7.e.s);
                                LoginActivityStalker loginActivityStalker3 = LoginActivityStalker.this;
                                loginActivityStalker3.t.setTextColor(LoginActivityStalker.x1(loginActivityStalker3).getResources().getColor(a7.c.G));
                                return;
                            }
                            return;
                        }
                        LoginActivityStalker.this.w.setBackgroundResource(a7.e.c1);
                        LoginActivityStalker.this.r.setImageResource(a7.e.e1);
                        LoginActivityStalker loginActivityStalker4 = LoginActivityStalker.this;
                        loginActivityStalker4.s.setTextColor(LoginActivityStalker.x1(loginActivityStalker4).getResources().getColor(a7.c.G));
                        b(f);
                    }
                    c(f);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (z) {
                return;
            }
            f = z ? 1.09f : 1.0f;
            b(f);
            c(f);
            a(z);
            View view2 = this.a;
            if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("rl_list_users")) {
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("rl_connect_vpn")) {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("rl_bt_submit")) {
                        return;
                    }
                    LoginActivityStalker.this.n.setBackgroundResource(a7.e.t);
                    loginActivityStalker = LoginActivityStalker.this;
                    textView = loginActivityStalker.t;
                } else {
                    LoginActivityStalker.this.w.setBackgroundResource(a7.e.d1);
                    LoginActivityStalker.this.r.setImageResource(a7.e.f1);
                    loginActivityStalker = LoginActivityStalker.this;
                    textView = loginActivityStalker.s;
                }
            } else {
                LoginActivityStalker.this.q.setBackgroundResource(a7.e.d1);
                LoginActivityStalker.this.u.setImageResource(a7.e.h1);
                loginActivityStalker = LoginActivityStalker.this;
                textView = loginActivityStalker.v;
            }
            textView.setTextColor(LoginActivityStalker.x1(loginActivityStalker).getResources().getColor(a7.c.f));
        }
    }

    public static /* synthetic */ void A1(LoginActivityStalker loginActivityStalker) {
        loginActivityStalker.L1();
    }

    public static /* synthetic */ boolean B1(LoginActivityStalker loginActivityStalker, boolean z) {
        loginActivityStalker.z = z;
        return z;
    }

    public static /* synthetic */ n7.a C1(LoginActivityStalker loginActivityStalker, n7.a aVar) {
        loginActivityStalker.I0 = aVar;
        return aVar;
    }

    public static /* synthetic */ u7.a D1(LoginActivityStalker loginActivityStalker) {
        return loginActivityStalker.J0;
    }

    private static String F1(String str) {
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

    private void G1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private String J1() {
        return w.p0(Calendar.getInstance().getTime().toString());
    }

    public static String K1() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return F1(str2);
        }
        return F1(str) + " " + str2;
    }

    private void L1() {
        TextView textView;
        int i2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ProgressDialog progressDialog;
        String string;
        try {
            this.B = this;
            this.g0 = new MultiUserDBHandler(this.B);
            this.N = new LiveStreamDBHandler(this.B);
            if (m7.a.z.booleanValue()) {
                this.k.setVisibility(0);
            }
            if (m7.a.t.booleanValue()) {
                textView = this.k;
                i2 = a7.f.Ae;
            } else {
                textView = this.k;
                i2 = a7.f.he;
            }
            textView.setNextFocusLeftId(i2);
            if (m7.a.y.booleanValue()) {
                this.k.setText(getResources().getString(a7.j.O8));
                this.h.setText(getResources().getString(a7.j.m1));
                this.m.setVisibility(8);
                this.t.setText(getResources().getString(a7.j.o0));
                if (m7.a.t.booleanValue()) {
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                    relativeLayout2 = this.q;
                } else if (m7.a.u.booleanValue()) {
                    relativeLayout2 = this.q;
                } else {
                    relativeLayout = this.q;
                    relativeLayout.setVisibility(8);
                }
                relativeLayout2.setVisibility(0);
            } else {
                if (m7.a.t.booleanValue()) {
                    this.k.setText(getResources().getString(a7.j.P8));
                    this.t.setText(getResources().getString(a7.j.s));
                    this.l.setVisibility(0);
                    if (m7.a.o.booleanValue()) {
                        this.m.setVisibility(0);
                    } else {
                        this.m.setVisibility(8);
                    }
                    if (m7.a.s.booleanValue() && m7.a.t.booleanValue()) {
                        relativeLayout2 = this.q;
                    } else if (m7.a.u.booleanValue()) {
                        relativeLayout2 = this.q;
                    } else {
                        relativeLayout = this.q;
                    }
                    relativeLayout2.setVisibility(0);
                } else {
                    this.k.setText(getResources().getString(a7.j.P8));
                    this.h.setText(getResources().getString(a7.j.B0));
                    this.t.setText(getResources().getString(a7.j.P7));
                    this.m.setVisibility(8);
                    this.l.setVisibility(8);
                    relativeLayout = this.q;
                }
                relativeLayout.setVisibility(8);
            }
            this.e.setError((CharSequence) null);
            this.h0 = new DatabaseHandler(this.B);
            if (this.B != null) {
                this.E = new ProgressDialog(this.B);
                String str = this.H0;
                if (str != null && str.equalsIgnoreCase("login_perform")) {
                    progressDialog = this.E;
                    string = "Auto Login";
                } else if (m7.a.y.booleanValue()) {
                    this.E.setMessage("");
                    progressDialog = this.E;
                    string = getResources().getString(a7.j.u5);
                } else {
                    this.E.setMessage("");
                    progressDialog = this.E;
                    string = getResources().getString(a7.j.t5);
                }
                progressDialog.setMessage(string);
                this.E.setCanceledOnTouchOutside(false);
                this.E.setCancelable(false);
                this.E.setProgressStyle(0);
            }
            this.A = new n7.e(this, this.B);
            this.F = getSharedPreferences("sharedPreference", 0);
            this.I = getSharedPreferences("loginPrefs", 0);
            this.J = getSharedPreferences("selected_language", 0);
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefsserverurl", 0);
            this.L = sharedPreferences;
            this.M = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = getSharedPreferences("upgradeDatePref", 0);
            this.Z = sharedPreferences2;
            this.Y = sharedPreferences2.edit();
            this.K = this.H.edit();
            this.G = this.F.edit();
            SharedPreferences sharedPreferences3 = getSharedPreferences("multiDNS", 0);
            this.r0 = sharedPreferences3;
            this.s0 = sharedPreferences3.edit();
            SharedPreferences sharedPreferences4 = getSharedPreferences("multiDNSValid", 0);
            this.t0 = sharedPreferences4;
            this.u0 = sharedPreferences4.edit();
            this.v0 = getSharedPreferences("serverUrlDNS", 0);
            m7.a.t.booleanValue();
            M1();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static String N1(String str) {
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

    private void P1() {
        EditText editText;
        int i2;
        EditText editText2;
        int i3;
        this.e = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.e.setPaddingRelative(35, 0, 35, 0);
        this.e.setLayoutParams(layoutParams);
        this.e.setHint(getResources().getString(a7.j.d9));
        this.e.setHintTextColor(getResources().getColor(a7.c.G));
        this.e.setHintTextColor(-1);
        if (m7.a.t.booleanValue()) {
            editText = this.e;
            i2 = a7.f.Ae;
        } else {
            editText = this.e;
            i2 = a7.f.he;
        }
        editText.setNextFocusLeftId(i2);
        this.e.setTextSize(22.0f);
        this.e.setId(101);
        this.e.setBackground(getResources().getDrawable(a7.e.J1));
        this.e.setFocusable(true);
        EditText editText3 = this.e;
        Typeface typeface = Typeface.SANS_SERIF;
        editText3.setTypeface(typeface);
        this.e.setInputType(161);
        this.l.addView(this.e);
        this.f = new EditText(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        this.f.setPaddingRelative(35, 0, 35, 0);
        this.f.setLayoutParams(layoutParams2);
        if (m7.a.z.booleanValue()) {
            this.p.setGravity(16);
        }
        this.f.setHint(getResources().getString(a7.j.i3));
        this.f.setHintTextColor(getResources().getColor(a7.c.G));
        this.f.setHintTextColor(-1);
        this.f.setTextSize(22.0f);
        this.f.setId(102);
        if (m7.a.t.booleanValue()) {
            editText2 = this.f;
            i3 = a7.f.Ae;
        } else {
            editText2 = this.f;
            i3 = a7.f.he;
        }
        editText2.setNextFocusLeftId(i3);
        this.f.setFocusable(true);
        this.f.setBackground(getResources().getDrawable(a7.e.J1));
        this.f.setTypeface(typeface);
        this.f.setInputType(161);
        this.x.addView(this.f);
        if (m7.a.o.booleanValue()) {
            this.d = new EditText(this);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
            this.d.setPaddingRelative(35, 0, 35, 0);
            this.d.setLayoutParams(layoutParams3);
            this.d.setHint(getResources().getString(a7.j.P6));
            this.d.setHintTextColor(getResources().getColor(a7.c.G));
            this.d.setHintTextColor(-1);
            this.d.setTextSize(22.0f);
            this.d.setId(104);
            this.d.setBackground(getResources().getDrawable(a7.e.J1));
            this.d.setFocusable(true);
            this.d.setTypeface(typeface);
            this.d.setInputType(161);
            this.m.addView(this.d);
        }
        if (m7.a.t.booleanValue()) {
            this.e.requestFocus();
            this.e.requestFocusFromTouch();
        }
    }

    private void Q1() {
        SharepreferenceDBHandler.setCurrentAPPType("stalker_api", this.B);
        startActivity(new Intent(this, MultiUserActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
    }

    private void R1(String str) {
    }

    private void S1() {
        n7.e eVar;
        this.q0 = this.e.getText().toString().trim();
        this.M = this.L.edit();
        this.D = this.f.getText().toString().trim();
        if (m7.a.y.booleanValue() || !H1()) {
            return;
        }
        a();
        try {
            if (m7.a.n.booleanValue()) {
                this.M.putString(m7.a.L, "http://qqtv.nl");
                this.M.apply();
                this.G.putString(m7.a.L, "http://qqtv.nl");
                this.G.putString("mac_address", this.D);
                this.G.apply();
                if (m7.a.t.booleanValue()) {
                    R1("http://qqtv.nl");
                } else {
                    eVar = this.A;
                    eVar.v(this.D);
                }
            } else if (m7.a.o.booleanValue()) {
                String lowerCase = this.d.getText().toString().trim().toLowerCase();
                this.C = lowerCase;
                this.M.putString(m7.a.L, lowerCase);
                this.M.apply();
                this.G.putString(m7.a.L, this.C);
                this.G.apply();
                eVar = this.A;
                eVar.v(this.D);
            } else {
                new i().execute(new Void[0]);
            }
        } catch (Exception unused) {
        }
        this.K.putString("mac_address", this.D);
        this.K.putString("activationCode", "");
        this.K.putString("loginWith", "loginWithDetails");
        this.K.apply();
        this.M.apply();
    }

    public static /* synthetic */ Context x1(LoginActivityStalker loginActivityStalker) {
        return loginActivityStalker.B;
    }

    public static /* synthetic */ void y1(LoginActivityStalker loginActivityStalker) {
        loginActivityStalker.S1();
    }

    public static /* synthetic */ void z1(LoginActivityStalker loginActivityStalker) {
        loginActivityStalker.Q1();
    }

    public void E1() {
        try {
            this.E0 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
        Context context;
        String str;
        if (stalkerTokenCallback == null || stalkerTokenCallback.getJs() == null || stalkerTokenCallback.getJs().getToken() == null) {
            context = this.B;
            str = "Error Code 100: Invalid Details";
        } else {
            String token = stalkerTokenCallback.getJs().getToken();
            SharepreferenceDBHandler.setStalkerToken(token, this.B);
            n7.e eVar = this.A;
            if (eVar != null) {
                try {
                    eVar.q(this.D, token);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            context = this.B;
            str = "Error Code 101: Invalid Details";
        }
        w.P0(context, str);
        b();
    }

    public void H(String str) {
    }

    public boolean H1() {
        EditText editText;
        Resources resources;
        int i2;
        if (m7.a.t.booleanValue() && this.e.getText().toString().trim().length() == 0) {
            this.e.requestFocus();
            editText = this.e;
            resources = getResources();
            i2 = a7.j.n1;
        } else if (m7.a.o.booleanValue() && this.d.getText().toString().trim().length() == 0) {
            this.d.requestFocus();
            editText = this.d;
            resources = getResources();
            i2 = a7.j.w1;
        } else {
            if (this.f.getText().toString().trim().length() != 0) {
                return true;
            }
            this.f.requestFocus();
            editText = this.f;
            resources = getResources();
            i2 = a7.j.r1;
        }
        editText.setError(resources.getString(i2));
        return false;
    }

    public void I1() {
        Button button;
        int i2;
        P1();
        this.w.setOnClickListener(new b());
        this.n.setOnClickListener(new c());
        this.q.setOnClickListener(new d());
        if (m7.a.x.booleanValue()) {
            button = this.j;
            i2 = 0;
        } else {
            button = this.j;
            i2 = 8;
        }
        button.setVisibility(i2);
        this.j.setOnClickListener(new e());
        this.k.setOnClickListener(new f());
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
    }

    public void M1() {
        try {
            if (m7.a.t.booleanValue()) {
                this.e.requestFocus();
                this.e.requestFocusFromTouch();
            }
            b();
        } catch (Exception unused) {
        }
    }

    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i2, boolean z) {
        if (!z) {
            b();
            Toast.makeText(this, this.B.getResources().getString(a7.j.A0), 0).show();
            return;
        }
        if (i2 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (!jSONObject.getString("status").equalsIgnoreCase("true")) {
                    b();
                    Toast.makeText(this, this.B.getResources().getString(a7.j.M7), 0).show();
                    return;
                }
                this.n0 = b7.b.a.getString("su");
                this.o0 = b7.b.a.getString("ndd");
                this.p0 = System.currentTimeMillis();
                try {
                    this.D = m7.a.y.booleanValue() ? SharepreferenceDBHandler.getMacAddress(this.B) : this.f.getText().toString().trim();
                    b7.f.e(this, b7.b.a.optString("su"));
                    this.C0 = N1(b7.b.a.optString("su") + "*" + b7.f.d(this) + "*" + b7.b.b);
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(this.C0)) {
                        b();
                        Toast.makeText(this, this.B.getResources().getString(a7.j.A0), 0).show();
                        return;
                    }
                    this.M.putString(m7.a.L, b7.f.a(this));
                    this.M.apply();
                    this.G.putString(m7.a.L, b7.f.a(this));
                    this.G.putString("mac_address", this.D);
                    this.G.apply();
                    if (m7.a.t.booleanValue()) {
                        R1(this.n0.toLowerCase());
                    } else {
                        this.A.v(this.D);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                Log.e("Login check", e3.getMessage());
            }
        }
    }

    public void P0(String str) {
    }

    public void S(String str) {
        b();
        if (str != null) {
            w.P0(this.B, str);
        } else {
            w.P0(this.B, "Your Activation code is not invalid");
        }
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
        if (stalkerProfilesCallback != null) {
            if (stalkerProfilesCallback.getJs() == null || stalkerProfilesCallback.getJs().getId() == null || stalkerProfilesCallback.getJs().getPassword().equals("")) {
                b();
                w.P0(this.B, "Error Code 102: Invalid Details");
                return;
            }
            try {
                SharedPreferences.Editor edit = getSharedPreferences("loginPrefs", 0).edit();
                edit.putString("username", "stalker");
                edit.putString("password", "stalker");
                edit.putString("mac_address", this.D);
                edit.putString("serverPort", "");
                edit.putString("serverUrl", this.C);
                edit.putString("serverTimeZone", stalkerProfilesCallback.getJs().getDefaultTimezone());
                edit.putString("anyName", this.q0);
                edit.apply();
                this.O = this.B.getSharedPreferences("allowedFormat", 0);
                this.P = this.B.getSharedPreferences("timeFormat", 0);
                this.Q = this.B.getSharedPreferences("epgchannelupdate", 0);
                this.R = this.B.getSharedPreferences("automation_channels", 0);
                this.S = this.B.getSharedPreferences("automation_epg", 0);
                this.V = this.O.edit();
                this.T = this.P.edit();
                this.U = this.Q.edit();
                this.W = this.R.edit();
                this.X = this.S.edit();
                SharedPreferences sharedPreferences = this.B.getSharedPreferences("auto_start", 0);
                this.e0 = sharedPreferences;
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                this.f0 = edit2;
                if (edit2 != null) {
                    edit2.putBoolean("full_epg", true);
                    this.f0.apply();
                }
                String string = this.O.getString("allowedFormat", "");
                if (string != null && string.equals("")) {
                    this.V.putString("allowedFormat", "ts");
                    this.V.apply();
                }
                if (this.R.getString("automation_channels", "").equals("")) {
                    this.W.putString("automation_channels", "checked");
                    this.W.apply();
                }
                if (this.S.getString("automation_epg", "").equals("")) {
                    this.X.putString("automation_epg", "checked");
                    this.X.apply();
                }
                if (this.P.getString("timeFormat", m7.a.E0).equals("")) {
                    this.T.putString("timeFormat", m7.a.E0);
                    this.T.apply();
                }
                if (this.Q.getString("epgchannelupdate", "").equals("")) {
                    this.U.putString("epgchannelupdate", "all");
                    this.U.apply();
                }
                m7.a.d0 = Boolean.TRUE;
                SharepreferenceDBHandler.setCurrentAPPType("stalker_api", this.B);
                if (!this.g0.checkregistration(this.q0, "", "", this.C, "stalker_api", "", this.D)) {
                    this.g0.addmultiusersStalker(this.q0, this.C, this.D);
                    Toast.makeText(this.B, getResources().getString(a7.j.r8), 0).show();
                }
                SharedPreferences.Editor edit3 = this.B.getSharedPreferences("loginprefsmultiuser", 0).edit();
                edit3.putString("name", this.q0);
                edit3.putString("username", "stalker");
                edit3.putString("password", "stalker");
                edit3.putString(m7.a.L, this.C);
                edit3.putString("mac_address", this.D);
                edit3.apply();
                if (this.B != null) {
                    MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(this.B);
                    this.g0 = multiUserDBHandler;
                    SharepreferenceDBHandler.setUserID(multiUserDBHandler.getAutoIdLoggedInUser(this.q0, "", "", this.C, "stalker_api", "", this.D), this.B);
                }
                b();
                if (this.N.getImportTableCount("stalker_api") == 0) {
                    ArrayList arrayList = new ArrayList();
                    ImportStatusModel importStatusModel = new ImportStatusModel();
                    importStatusModel.setType("all_stalker");
                    importStatusModel.setStatus("0");
                    importStatusModel.setDate("");
                    arrayList.add(0, importStatusModel);
                    this.N.importDataStatusArrayList(arrayList, "stalker_api");
                }
                ImportStatusModel importStatusModel2 = this.N.getdateDBStatus("all_stalker");
                if (importStatusModel2 != null) {
                    if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("0")) && (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("2"))) {
                        if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("1")) && importStatusModel2.getStatus() != null) {
                            importStatusModel2.getStatus().equals("3");
                            return;
                        }
                        return;
                    }
                    if (this.B != null) {
                        this.B.startActivity(new Intent(this.B, ImportStalkerActivity.class));
                        this.B.finish();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        ProgressDialog progressDialog = this.E;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void b() {
        try {
            ProgressDialog progressDialog = this.E;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void b0(int i2) {
        if (this.B != null) {
            b();
            Toast.makeText(this, this.B.getResources().getString(a7.j.A0), 0).show();
        }
    }

    public void c(String str) {
        b();
        if (!str.equals("")) {
            w.P0(this.B, str);
        } else if (m7.a.n.booleanValue()) {
            Toast.makeText(this, getResources().getString(a7.j.C2), 0).show();
        } else {
            w.P0(this.B, "Your Account is invalid or has expired !");
        }
    }

    public void e(String str) {
        ProgressDialog progressDialog = this.E;
        if (progressDialog != null) {
            progressDialog.dismiss();
            Toast.makeText(this, this.B.getResources().getString(a7.j.G2), 0).show();
        }
    }

    public void e0(String str) {
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void o0(String str) {
    }

    public void onBackPressed() {
        if (m7.a.u.booleanValue()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            if (this.z) {
                super/*androidx.activity.ComponentActivity*/.onBackPressed();
                return;
            }
            this.z = true;
            try {
                Toast.makeText(this, getResources().getString(a7.j.F5), 0).show();
            } catch (Exception unused) {
            }
            new Handler().postDelayed(new g(), 2000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r3) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginActivityStalker.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 19) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.B);
        w.z0(this.B);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void r0(ActivationCallBack activationCallBack, String str) {
        w1();
    }

    public void u1() {
        this.D0 = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public void v0(String str) {
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.G0 = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void w1() {
        this.B0 = N1(b7.f.c(this) + "*" + b7.f.d(this) + "--" + b7.b.b + "-" + this.E0 + "-unknown-" + K1() + "-" + this.D0);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this)));
        b7.g.b.add(b7.g.a("sc", this.B0));
        b7.g.b.add(b7.g.a("u", ""));
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", this.E0));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", K1()));
        b7.g.b.add(b7.g.a("do", this.D0));
        b7.g.c.b(this);
    }

    public void y0(String str) {
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
