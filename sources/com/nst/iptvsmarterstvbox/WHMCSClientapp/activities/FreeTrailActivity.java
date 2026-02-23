package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.c;
import a7.e;
import a7.f;
import a7.j;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import b7.g;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.model.FreeTrailModelClass;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import m7.a;
import m7.w;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FreeTrailActivity extends b {
    public static InputFilter W = new 4();
    public int C;
    public Context D;
    public ProgressDialog G;
    public String H;
    public SharedPreferences I;
    public SharedPreferences.Editor J;
    public SharedPreferences K;
    public SharedPreferences L;
    public SharedPreferences M;
    public SharedPreferences.Editor N;
    public Boolean O;
    public SharedPreferences P;
    public SharedPreferences.Editor Q;
    public LiveStreamDBHandler R;
    public SharedPreferences.Editor S;
    public SharedPreferences T;
    public DatabaseHandler U;
    public MultiUserDBHandler V;
    public RelativeLayout d;
    public RelativeLayout e;
    public RelativeLayout f;
    public RelativeLayout g;
    public RelativeLayout h;
    public RelativeLayout i;
    public EditText j;
    public EditText k;
    public EditText l;
    public EditText m;
    public Button n;
    public TextView o;
    public String t;
    public String u;
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public long z = -1;
    public String A = "";
    public String B = Build.MODEL;
    public String E = "";
    public long F = -1;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            FreeTrailActivity.this.startActivity(new Intent(FreeTrailActivity.this, LoginActivity.class));
            FreeTrailActivity.this.finish();
        }
    }

    public class 2 implements View.OnClickListener {
        public 2() {
        }

        public final void a() {
            Context context;
            Resources resources;
            int i;
            FreeTrailActivity freeTrailActivity = FreeTrailActivity.this;
            FreeTrailActivity.y1(freeTrailActivity, freeTrailActivity.l.getText().toString().trim());
            FreeTrailActivity freeTrailActivity2 = FreeTrailActivity.this;
            FreeTrailActivity.A1(freeTrailActivity2, freeTrailActivity2.j.getText().toString().trim());
            FreeTrailActivity freeTrailActivity3 = FreeTrailActivity.this;
            FreeTrailActivity.C1(freeTrailActivity3, freeTrailActivity3.k.getText().toString().trim());
            FreeTrailActivity freeTrailActivity4 = FreeTrailActivity.this;
            FreeTrailActivity.E1(freeTrailActivity4, freeTrailActivity4.m.getText().toString().trim());
            if (FreeTrailActivity.x1(FreeTrailActivity.this).isEmpty()) {
                FreeTrailActivity freeTrailActivity5 = FreeTrailActivity.this;
                context = freeTrailActivity5.D;
                resources = freeTrailActivity5.getResources();
                i = j.o5;
            } else {
                FreeTrailActivity freeTrailActivity6 = FreeTrailActivity.this;
                if (!freeTrailActivity6.K1(FreeTrailActivity.x1(freeTrailActivity6))) {
                    FreeTrailActivity freeTrailActivity7 = FreeTrailActivity.this;
                    context = freeTrailActivity7.D;
                    resources = freeTrailActivity7.getResources();
                    i = j.R8;
                } else if (FreeTrailActivity.z1(FreeTrailActivity.this).isEmpty()) {
                    FreeTrailActivity freeTrailActivity8 = FreeTrailActivity.this;
                    context = freeTrailActivity8.D;
                    resources = freeTrailActivity8.getResources();
                    i = j.s5;
                } else if (FreeTrailActivity.B1(FreeTrailActivity.this).isEmpty()) {
                    FreeTrailActivity freeTrailActivity9 = FreeTrailActivity.this;
                    context = freeTrailActivity9.D;
                    resources = freeTrailActivity9.getResources();
                    i = j.p5;
                } else if (FreeTrailActivity.D1(FreeTrailActivity.this).equalsIgnoreCase("")) {
                    FreeTrailActivity freeTrailActivity10 = FreeTrailActivity.this;
                    context = freeTrailActivity10.D;
                    resources = freeTrailActivity10.getResources();
                    i = j.m5;
                } else {
                    if (FreeTrailActivity.B1(FreeTrailActivity.this).equals(FreeTrailActivity.D1(FreeTrailActivity.this))) {
                        SharepreferenceDBHandler.setUserName("", FreeTrailActivity.this.D);
                        SharepreferenceDBHandler.setUserPassword("", FreeTrailActivity.this.D);
                        FreeTrailActivity.this.a();
                        FreeTrailActivity.this.v1();
                        return;
                    }
                    FreeTrailActivity freeTrailActivity11 = FreeTrailActivity.this;
                    context = freeTrailActivity11.D;
                    resources = freeTrailActivity11.getResources();
                    i = j.Y4;
                }
            }
            Toast.makeText(context, resources.getString(i), 0).show();
        }

        public void onClick(View view) {
            a();
        }
    }

    public class 3 implements Callback {
        public 3() {
        }

        public void onFailure(Call call, Throwable th) {
            FreeTrailActivity freeTrailActivity = FreeTrailActivity.this;
            freeTrailActivity.e(freeTrailActivity.getResources().getString(j.A0));
        }

        public void onResponse(Call call, Response response) {
            FreeTrailActivity freeTrailActivity;
            String str;
            if (response == null || !response.isSuccessful() || response.body() == null) {
                freeTrailActivity = FreeTrailActivity.this;
                str = "No Response from server";
            } else {
                if (((FreeTrailModelClass) response.body()).getResult() != null && ((FreeTrailModelClass) response.body()).getResult().equalsIgnoreCase("success")) {
                    ClientSharepreferenceHandler.h("", FreeTrailActivity.this.D);
                    if (a.y.booleanValue()) {
                        a.y = Boolean.FALSE;
                    }
                    SharepreferenceDBHandler.setUserName(FreeTrailActivity.z1(FreeTrailActivity.this), FreeTrailActivity.this.D);
                    SharepreferenceDBHandler.setUserPassword(FreeTrailActivity.B1(FreeTrailActivity.this), FreeTrailActivity.this.D);
                    Intent intent = new Intent(FreeTrailActivity.this, LoginActivity.class);
                    intent.setAction("login_perform");
                    FreeTrailActivity.this.startActivity(intent);
                    FreeTrailActivity.this.finish();
                    return;
                }
                freeTrailActivity = FreeTrailActivity.this;
                str = ((FreeTrailModelClass) response.body()).getMessage();
            }
            freeTrailActivity.e(str);
        }
    }

    public class 4 implements InputFilter {
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

    public static /* synthetic */ String A1(FreeTrailActivity freeTrailActivity, String str) {
        freeTrailActivity.q = str;
        return str;
    }

    public static /* synthetic */ String B1(FreeTrailActivity freeTrailActivity) {
        return freeTrailActivity.r;
    }

    public static /* synthetic */ String C1(FreeTrailActivity freeTrailActivity, String str) {
        freeTrailActivity.r = str;
        return str;
    }

    public static /* synthetic */ String D1(FreeTrailActivity freeTrailActivity) {
        return freeTrailActivity.s;
    }

    public static /* synthetic */ String E1(FreeTrailActivity freeTrailActivity, String str) {
        freeTrailActivity.s = str;
        return str;
    }

    public static String G1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (z && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                z = false;
            } else {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String H1() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return G1(str2);
        }
        return G1(str) + " " + str2;
    }

    public static String I1() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(b)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static /* synthetic */ String x1(FreeTrailActivity freeTrailActivity) {
        return freeTrailActivity.p;
    }

    public static /* synthetic */ String y1(FreeTrailActivity freeTrailActivity, String str) {
        freeTrailActivity.p = str;
        return str;
    }

    public static /* synthetic */ String z1(FreeTrailActivity freeTrailActivity) {
        return freeTrailActivity.q;
    }

    public void F1() {
        try {
            this.u = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String J1() {
        return ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public boolean K1(String str) {
        return Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(str).matches();
    }

    public void a() {
        ProgressDialog progressDialog = this.G;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void e(String str) {
        ProgressDialog progressDialog = this.G;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (str.equals("")) {
            w.P0(this.D, "Your Account is invalid or expired !");
        } else {
            w.P0(this.D, str);
        }
    }

    public void onBackPressed() {
        if (a.z.booleanValue()) {
            a.y = Boolean.TRUE;
        }
        finish();
        super.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.c = new g(this);
        setContentView(a7.g.H);
        this.d = findViewById(f.je);
        this.e = findViewById(f.xf);
        this.f = findViewById(f.Ue);
        this.g = findViewById(f.Yd);
        this.h = findViewById(f.ge);
        this.i = findViewById(f.Qd);
        F1();
        u1();
        H1();
        w1();
        String I1 = I1();
        this.H = I1;
        if (I1.equalsIgnoreCase("")) {
            this.H = J1();
        }
        this.D = this;
        this.R = new LiveStreamDBHandler(this.D);
        this.V = new MultiUserDBHandler(this.D);
        this.U = new DatabaseHandler(this.D);
        this.l = new EditText(this);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.l.setPaddingRelative(35, 0, 35, 0);
        this.l.setHint(getResources().getString(j.k1));
        this.l.setHintTextColor(getResources().getColor(c.G));
        this.l.setHintTextColor(-1);
        this.l.setTextSize(22.0f);
        this.l.setId(101);
        this.l.setBackground(getResources().getDrawable(e.J1));
        this.l.setFocusable(true);
        EditText editText = this.l;
        Typeface typeface = Typeface.SANS_SERIF;
        editText.setTypeface(typeface);
        this.l.setInputType(32);
        this.d.addView(this.l);
        this.j = new EditText(this);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.j.setPaddingRelative(35, 0, 35, 0);
        this.j.setHint(getResources().getString(j.t8));
        this.j.setHintTextColor(getResources().getColor(c.G));
        this.j.setHintTextColor(-1);
        this.j.setTextSize(22.0f);
        this.j.setId(101);
        this.j.setBackground(getResources().getDrawable(e.J1));
        this.j.setFocusable(true);
        this.j.setTypeface(typeface);
        this.j.setInputType(1);
        this.e.addView(this.j);
        this.k = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.k.setPaddingRelative(35, 0, 35, 0);
        this.k.setLayoutParams(layoutParams);
        this.k.setHint(getResources().getString(j.u1));
        this.k.setHintTextColor(getResources().getColor(c.G));
        this.k.setHintTextColor(-1);
        this.k.setTextSize(22.0f);
        this.k.setId(101);
        this.k.setBackground(getResources().getDrawable(e.J1));
        this.k.setFocusable(true);
        this.k.setTypeface(typeface);
        this.k.setInputType(129);
        this.f.addView(this.k);
        this.m = new EditText(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        this.m.setPaddingRelative(35, 0, 35, 0);
        this.m.setLayoutParams(layoutParams2);
        this.m.setHint(getResources().getString(j.t0));
        this.m.setHintTextColor(getResources().getColor(c.G));
        this.m.setHintTextColor(-1);
        this.m.setTextSize(22.0f);
        this.m.setId(101);
        this.m.setBackground(getResources().getDrawable(e.J1));
        this.m.setFocusable(true);
        this.m.setTypeface(typeface);
        this.m.setInputType(129);
        this.h.addView(this.m);
        this.n = new Button(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        this.n.setPaddingRelative(35, 0, 35, 0);
        this.n.setLayoutParams(layoutParams3);
        this.n.setText(getResources().getString(j.Z6));
        this.n.setTextColor(-16777216);
        this.n.setTextSize(22.0f);
        this.n.setId(105);
        this.n.setBackground(getResources().getDrawable(e.H1));
        this.n.setFocusable(true);
        this.n.setGravity(17);
        this.n.setTypeface(typeface);
        this.g.addView(this.n);
        this.o = new TextView(this);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        this.o.setPaddingRelative(35, 0, 35, 0);
        this.o.setLayoutParams(layoutParams4);
        this.o.setTextColor(-1);
        if (new u7.a(this.D).A().equals(a.K0)) {
            this.o.setTextSize(22.0f);
        } else {
            this.o.setTextSize(15.0f);
        }
        this.o.setText(getResources().getString(j.E));
        this.o.setId(105);
        this.o.setGravity(16);
        this.o.setBackground(getResources().getDrawable(e.I1));
        this.o.setFocusable(true);
        this.i.addView(this.o);
        if (this.D != null) {
            ProgressDialog progressDialog = new ProgressDialog(this.D);
            this.G = progressDialog;
            progressDialog.setMessage("Please wait while we are creating free trial for you");
            this.G.setCanceledOnTouchOutside(false);
            this.G.setCancelable(false);
            this.G.setProgressStyle(0);
        }
        this.I = getSharedPreferences("sharedPreference", 0);
        this.K = getSharedPreferences("sharedprefremberme", 0);
        this.L = getSharedPreferences("loginPrefs", 0);
        this.M = getSharedPreferences("selected_language", 0);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefsserverurl", 0);
        this.P = sharedPreferences;
        this.Q = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = getSharedPreferences("upgradeDatePref", 0);
        this.T = sharedPreferences2;
        this.S = sharedPreferences2.edit();
        this.N = this.K.edit();
        this.J = this.I.edit();
        this.O = Boolean.valueOf(this.K.getBoolean("savelogin", false));
        this.o.setOnClickListener(new 1());
        B7.c.a(this.k);
        this.j.setFilters(new InputFilter[]{W});
        this.n.setOnClickListener(new 2());
    }

    public void onResume() {
        super.onResume();
        w.m(this.D);
    }

    public void u1() {
        this.t = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public void v1() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ((ApiService) new Retrofit.Builder().baseUrl("https://cms.alldrama.tv/").client(builder.connectTimeout(300L, timeUnit).writeTimeout(300L, timeUnit).readTimeout(300L, timeUnit).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.class)).k("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "freetrail", "yes", this.p, this.q, this.r, this.H, "com.nst.iptvsmarterstvbox").enqueue(new 3());
    }

    public void w1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.C = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }
}
