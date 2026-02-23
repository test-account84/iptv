package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import b7.g;
import com.nst.iptvsmarterstvbox.model.callback.ActivationCallBack;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.MobileCodeActiveCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeGenerateCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeVerifyCallBack;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import m7.w;
import org.json.JSONObject;
import x6.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FirebaseRegisterDeviceActivity extends androidx.appcompat.app.b implements FirebasePresenter.OnTvCodeProcessListener, z7.f, z7.a, b7.c {
    public u7.a C;
    public SharedPreferences D;
    public SharedPreferences.Editor E;
    public SharedPreferences F;
    public SharedPreferences.Editor G;
    public n7.d H;
    public SharedPreferences I;
    public SharedPreferences.Editor J;
    public MultiUserDBHandler K;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public SharedPreferences V;
    public SharedPreferences W;
    public SharedPreferences X;
    public SharedPreferences Y;
    public SharedPreferences Z;
    public int d;
    public SharedPreferences.Editor e0;
    public SharedPreferences.Editor f0;
    public RecyclerView g;
    public SharedPreferences.Editor g0;
    public ProgressBar h;
    public SharedPreferences.Editor h0;
    public TextView i;
    public SharedPreferences.Editor i0;
    public TextView j;
    public SharedPreferences j0;
    public TextView k;
    public SharedPreferences.Editor k0;
    public ImageView l;
    public ProgressDialog l0;
    public ImageView m;
    public ProgressDialog m0;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public RelativeLayout q;
    public TextView r;
    public TextView s;
    public Context t;
    public FirebasePresenter v;
    public CountDownTimer x;
    public String e = "";
    public String f = "";
    public Thread u = null;
    public Handler w = new Handler();
    public int y = 60000;
    public Handler z = new Handler(Looper.getMainLooper());
    public int A = 5;
    public int B = 0;
    public ArrayList L = new ArrayList();
    public String S = "";
    public String T = "";
    public long U = -1;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(FirebaseRegisterDeviceActivity.this.t);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            FirebaseRegisterDeviceActivity.this.H1();
        }
    }

    public class c extends CountDownTimer {
        public c(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
        }

        public void onTick(long j) {
            FirebaseRegisterDeviceActivity.this.r.setText((j / 1000) + " Secs");
            FirebaseRegisterDeviceActivity.A1(FirebaseRegisterDeviceActivity.this);
            if (FirebaseRegisterDeviceActivity.y1(FirebaseRegisterDeviceActivity.this) >= FirebaseRegisterDeviceActivity.B1(FirebaseRegisterDeviceActivity.this)) {
                FirebaseRegisterDeviceActivity.z1(FirebaseRegisterDeviceActivity.this, 0);
                if (m7.a.o1) {
                    m7.a.o1 = false;
                    FirebaseRegisterDeviceActivity.this.P1();
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            FirebaseRegisterDeviceActivity.this.H1();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(FirebaseRegisterDeviceActivity.this.t);
                String A = w.A(date);
                TextView textView = FirebaseRegisterDeviceActivity.this.k;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = FirebaseRegisterDeviceActivity.this.j;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    FirebaseRegisterDeviceActivity.this.G1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static /* synthetic */ int A1(FirebaseRegisterDeviceActivity firebaseRegisterDeviceActivity) {
        int i = firebaseRegisterDeviceActivity.B;
        firebaseRegisterDeviceActivity.B = i + 1;
        return i;
    }

    public static /* synthetic */ int B1(FirebaseRegisterDeviceActivity firebaseRegisterDeviceActivity) {
        return firebaseRegisterDeviceActivity.A;
    }

    private static String D1(String str) {
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

    public static String J1() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return D1(str2);
        }
        return D1(str) + " " + str2;
    }

    public static String L1(String str) {
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

    public static /* synthetic */ int y1(FirebaseRegisterDeviceActivity firebaseRegisterDeviceActivity) {
        return firebaseRegisterDeviceActivity.B;
    }

    public static /* synthetic */ int z1(FirebaseRegisterDeviceActivity firebaseRegisterDeviceActivity, int i) {
        firebaseRegisterDeviceActivity.B = i;
        return i;
    }

    public void C1() {
        try {
            this.Q = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public final void E1(String str) {
        Bitmap I1 = I1(str);
        if (I1 != null) {
            this.m.setImageBitmap(I1);
        }
    }

    public void F1() {
        this.m0.dismiss();
    }

    public void G1() {
        runOnUiThread(new e());
    }

    public void H1() {
        try {
            N1();
            this.n.setVisibility(4);
            String T0 = w.T0(this.t);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            v1();
            w1();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            FirebasePresenter firebasePresenter = this.v;
            if (firebasePresenter != null) {
                firebasePresenter.m(m7.a.S0, m7.a.T0, format, o0, T0, this.f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap I1(String str) {
        try {
            D6.b a2 = new U6.b().a(str, x6.a.QR_CODE, 400, 400);
            int l = a2.l();
            int i = a2.i();
            Bitmap createBitmap = Bitmap.createBitmap(l, i, Bitmap.Config.RGB_565);
            for (int i2 = 0; i2 < l; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    createBitmap.setPixel(i2, i3, a2.f(i2, i3) ? -16777216 : -1);
                }
            }
            return createBitmap;
        } catch (s e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void K1(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            ProgressDialog progressDialog = new ProgressDialog(this.t);
            this.l0 = progressDialog;
            progressDialog.setMessage("Please wait!");
            this.l0.setCanceledOnTouchOutside(false);
            this.l0.setCancelable(false);
            this.l0.setProgressStyle(0);
            C1();
            u1();
            J1();
            v1();
            g.c = new g(this);
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefsserverurl", 0);
            this.D = sharedPreferences;
            this.E = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = getSharedPreferences("sharedPreference", 0);
            this.F = sharedPreferences2;
            this.G = sharedPreferences2.edit();
            this.H = new n7.d(this, getApplicationContext());
            SharedPreferences sharedPreferences3 = getSharedPreferences("sharedprefremberme", 0);
            this.I = sharedPreferences3;
            this.J = sharedPreferences3.edit();
            this.K = new MultiUserDBHandler(getApplicationContext());
            this.M = str;
            this.N = str2;
            this.O = str3;
            if (m7.a.n.booleanValue()) {
                this.E.putString(m7.a.L, "http://qqtv.nl");
                this.E.apply();
                this.G.putString(m7.a.L, "http://qqtv.nl");
                this.G.putString("username", this.M);
                this.G.apply();
                if (m7.a.t.booleanValue()) {
                    O1("http://qqtv.nl");
                } else {
                    try {
                        this.H.g(this.M, this.N);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        this.J.putString("username", this.M);
                        this.J.putString("password", this.N);
                        this.J.putString("activationCode", "");
                        this.J.putString("loginWith", "loginWithDetails");
                        this.J.apply();
                        this.E.apply();
                    }
                }
            } else {
                try {
                    if (str5.equalsIgnoreCase("api")) {
                        a();
                        this.E.putString(m7.a.L, str4);
                        this.E.apply();
                        this.G.putString(m7.a.L, str4);
                        this.G.apply();
                        this.H.g(this.M, this.N);
                    } else if (str5.equalsIgnoreCase("onestream_api")) {
                        a();
                        this.E.putString(m7.a.L, str4);
                        this.E.apply();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str4);
                        new m7.e(this.t, str5).z(arrayList, this.M, this.N, str3);
                    } else if (str5.equalsIgnoreCase("m3u")) {
                        new m7.e(this.t, "m3u").y(str6, true, str3);
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    this.J.putString("username", this.M);
                    this.J.putString("password", this.N);
                    this.J.putString("activationCode", "");
                    this.J.putString("loginWith", "loginWithDetails");
                    this.J.apply();
                    this.E.apply();
                }
            }
            this.J.putString("username", this.M);
            this.J.putString("password", this.N);
            this.J.putString("activationCode", "");
            this.J.putString("loginWith", "loginWithDetails");
            this.J.apply();
            this.E.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00da -> B:15:0x011b). Please report as a decompilation issue!!! */
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i, boolean z) {
        if (!z) {
            b();
            Toast.makeText(this, getApplicationContext().getResources().getString(j.A0), 0).show();
            return;
        }
        if (i == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (jSONObject.getString("status").equalsIgnoreCase("true")) {
                    this.S = b7.b.a.getString("su");
                    this.T = b7.b.a.getString("ndd");
                    this.U = System.currentTimeMillis();
                    try {
                        b7.f.e(this, b7.b.a.optString("su"));
                        this.R = L1(b7.b.a.optString("su") + "*" + b7.f.d(this) + "*" + b7.b.b);
                        if (b7.b.a.getString("sc").equalsIgnoreCase(this.R)) {
                            this.E.putString(m7.a.L, b7.f.a(this));
                            this.E.apply();
                            this.G.putString(m7.a.L, b7.f.a(this));
                            this.G.putString("username", this.M);
                            this.G.apply();
                            if (m7.a.t.booleanValue()) {
                                O1(this.S.toLowerCase());
                            } else {
                                this.H.g(this.M, this.N);
                            }
                        } else {
                            b();
                            Toast.makeText(this, getApplicationContext().getResources().getString(j.A0), 0).show();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    b();
                    Toast.makeText(this, getApplicationContext().getResources().getString(j.M7), 0).show();
                }
            } catch (Exception e3) {
                Log.e("Login check", e3.getMessage());
            }
        }
    }

    public void N1() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.m0 = progressDialog;
        progressDialog.setMessage("Please Wait");
        this.m0.show();
    }

    public void O0(TVCodeVerifyCallBack tVCodeVerifyCallBack) {
        try {
            F1();
            if (tVCodeVerifyCallBack == null || tVCodeVerifyCallBack.getResult() == null || !tVCodeVerifyCallBack.getResult().equals("success") || tVCodeVerifyCallBack.getSc() == null || tVCodeVerifyCallBack.getData() == null) {
                return;
            }
            if (tVCodeVerifyCallBack.getSc().equalsIgnoreCase(w.o0(m7.a.S0 + "*JNHGHG34534543HSDHSHSSH*&^klih*" + this.e + "*" + new SimpleDateFormat("yyyy-MM").format(new Date())))) {
                String str = "";
                String S0 = (tVCodeVerifyCallBack.getData().getUsername() == null || tVCodeVerifyCallBack.getData().getUsername().length() <= 0) ? "" : w.S0(tVCodeVerifyCallBack.getData().getUsername());
                String S02 = (tVCodeVerifyCallBack.getData().getPassword() == null || tVCodeVerifyCallBack.getData().getPassword().length() <= 0) ? "" : w.S0(tVCodeVerifyCallBack.getData().getPassword());
                String S03 = (tVCodeVerifyCallBack.getData().getAnyName() == null || tVCodeVerifyCallBack.getData().getAnyName().length() <= 0) ? "" : w.S0(tVCodeVerifyCallBack.getData().getAnyName());
                String S04 = (tVCodeVerifyCallBack.getData().getDns() == null || tVCodeVerifyCallBack.getData().getDns().length() <= 0) ? "" : w.S0(tVCodeVerifyCallBack.getData().getDns());
                String type = (tVCodeVerifyCallBack.getData().getType() == null || tVCodeVerifyCallBack.getData().getType().length() <= 0) ? "" : tVCodeVerifyCallBack.getData().getType();
                if (tVCodeVerifyCallBack.getData().getM3ulink() != null && tVCodeVerifyCallBack.getData().getM3ulink().length() > 0) {
                    str = w.S0(tVCodeVerifyCallBack.getData().getM3ulink());
                }
                String str2 = str;
                Handler handler = this.w;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
                Handler handler2 = this.z;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages((Object) null);
                }
                CountDownTimer countDownTimer = this.x;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                K1(S0, S02, S03, S04, type, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void O1(String str) {
        if (str != null && !str.equals("") && !str.isEmpty()) {
            this.L = new ArrayList(Arrays.asList(str.split(",")));
        }
        ArrayList arrayList = this.L;
        if (arrayList == null || arrayList.size() < 1) {
            ArrayList arrayList2 = this.L;
            if (arrayList2 == null || arrayList2.size() != 0) {
                return;
            }
            b();
            Toast.makeText(this, this.t.getResources().getString(j.l5), 0).show();
            return;
        }
        try {
            this.E.putString(m7.a.L, ((String) this.L.get(0)).trim());
            this.E.commit();
            this.L.remove(0);
            this.H.h(this.M, this.N, this.L);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void P1() {
        try {
            String T0 = w.T0(this.t);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            x1();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + this.e + "*" + format);
            FirebasePresenter firebasePresenter = this.v;
            if (firebasePresenter != null) {
                firebasePresenter.n(m7.a.S0, m7.a.T0, format, o0, T0, this.f, this.e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void S(String str) {
    }

    public void S0(MobileCodeActiveCallBack mobileCodeActiveCallBack) {
    }

    public void W0() {
    }

    public void a() {
        ProgressDialog progressDialog = this.l0;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void b() {
        try {
            ProgressDialog progressDialog = this.l0;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void b0(int i) {
        if (getApplicationContext() != null) {
            b();
            Toast.makeText(this, getApplicationContext().getResources().getString(j.A0), 0).show();
        }
    }

    public void c(String str) {
        b();
        if (!str.equals("")) {
            w.P0(this.t, str);
        } else if (m7.a.n.booleanValue()) {
            Toast.makeText(this, getResources().getString(j.C2), 0).show();
        } else {
            w.P0(this.t, "Your Account is invalid or has expired !");
        }
    }

    public void d(String str) {
        if (this.t == null || str.isEmpty()) {
            return;
        }
        w.P0(this.t, str);
    }

    public void e(String str) {
        if (this.l0 != null) {
            F1();
            Toast.makeText(this, this.t.getResources().getString(j.G2), 0).show();
        }
    }

    public void h0(ArrayList arrayList, String str) {
    }

    public void m(LoginCallback loginCallback, String str) {
        int i;
        String string;
        if (this.t != null) {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null) {
                b();
                d(getResources().getString(j.F2));
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
                    this.t.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
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
                    this.V = this.t.getSharedPreferences("allowedFormat", 0);
                    this.W = this.t.getSharedPreferences("timeFormat", 0);
                    this.X = this.t.getSharedPreferences("epgchannelupdate", 0);
                    this.Y = this.t.getSharedPreferences("automation_channels", 0);
                    this.Z = this.t.getSharedPreferences("automation_epg", 0);
                    this.g0 = this.V.edit();
                    this.e0 = this.W.edit();
                    this.f0 = this.X.edit();
                    this.h0 = this.Y.edit();
                    this.i0 = this.Z.edit();
                    SharedPreferences sharedPreferences = this.t.getSharedPreferences("auto_start", 0);
                    this.j0 = sharedPreferences;
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    this.k0 = edit2;
                    if (edit2 != null) {
                        edit2.putBoolean("full_epg", true);
                        this.k0.apply();
                    }
                    if (this.Y.getString("automation_channels", "").equals("")) {
                        this.h0.putString("automation_channels", "checked");
                        this.h0.apply();
                    }
                    if (this.Z.getString("automation_epg", "").equals("")) {
                        this.i0.putString("automation_epg", "checked");
                        this.i0.apply();
                    }
                    m7.a.c0 = Boolean.FALSE;
                    if (this.V.getString("allowedFormat", "").equals("")) {
                        this.g0.putString("allowedFormat", "ts");
                        this.g0.apply();
                    }
                    if (this.W.getString("timeFormat", m7.a.E0).equals("")) {
                        this.e0.putString("timeFormat", m7.a.E0);
                        this.e0.apply();
                    }
                    if (this.X.getString("epgchannelupdate", "").equals("")) {
                        this.f0.putString("epgchannelupdate", "all");
                        this.f0.apply();
                    }
                    this.K = new MultiUserDBHandler(this.t);
                    SharepreferenceDBHandler.setCurrentAPPType("api", this.t);
                    boolean booleanValue = m7.a.s.booleanValue();
                    MultiUserDBHandler multiUserDBHandler = this.K;
                    if (booleanValue) {
                        try {
                            if (multiUserDBHandler.checkregistration(this.O, username, password, url, "api", url, "")) {
                                b();
                                Toast.makeText(this.t, getString(j.D) + this.O + getString(j.u8) + username + getString(j.F) + m7.a.Z, 0).show();
                            } else {
                                this.K.addmultiusers(this.O, username, password, m7.a.Z, url, "api");
                                Toast.makeText(this.t, getResources().getString(j.r8), 0).show();
                            }
                        } catch (WindowManager.BadTokenException e2) {
                            e2.printStackTrace();
                        }
                        SharedPreferences.Editor edit3 = this.t.getSharedPreferences("loginprefsmultiuser", 0).edit();
                        edit3.putString("name", this.O);
                        edit3.putString("username", username);
                        edit3.putString("password", password);
                        edit3.putString(m7.a.L, url);
                        edit3.apply();
                    } else if (!multiUserDBHandler.checkregistration("", username, password, url, "api", url, "")) {
                        this.K.addmultiusers("", username, password, m7.a.Z, url, "api");
                    }
                    Toast.makeText(this.t, getResources().getString(j.b3), 0).show();
                    if (this.t != null) {
                        SharepreferenceDBHandler.setUserID(this.K.getAutoIdLoggedInUser(this.O, username, password, url, "api", url, ""), this.t);
                    }
                    b();
                    startActivity(new Intent(this, NewDashboardActivity.class));
                    finish();
                    return;
                }
                b();
                string = getResources().getString(j.H2) + status;
                i = 0;
            } else {
                i = 0;
                if (!str.equals("validateLogin")) {
                    return;
                }
                b();
                string = getResources().getString(j.D2);
            }
            Toast.makeText(this, string, i).show();
        }
    }

    public void n0() {
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.F);
        this.t = this;
        this.g = findViewById(a7.f.ub);
        this.h = findViewById(a7.f.oc);
        this.i = findViewById(a7.f.Qb);
        this.j = findViewById(a7.f.E2);
        this.k = findViewById(a7.f.gh);
        this.l = findViewById(a7.f.Xa);
        this.m = findViewById(a7.f.Xc);
        this.n = findViewById(a7.f.fe);
        this.o = findViewById(a7.f.li);
        this.p = findViewById(a7.f.Wm);
        this.q = findViewById(a7.f.Xd);
        this.r = findViewById(a7.f.zl);
        this.s = findViewById(a7.f.mi);
        this.v = new FirebasePresenter(this.t, this);
        v1();
        Thread thread = this.u;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new f());
            this.u = thread2;
            thread2.start();
        }
        this.q.requestFocus();
        this.C = new u7.a(getApplicationContext());
        this.l.setOnClickListener(new a());
        this.q.setOnClickListener(new b());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Handler handler = this.w;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            Handler handler2 = this.z;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            CountDownTimer countDownTimer = this.x;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Thread thread = this.u;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.u.interrupt();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        m7.a.o1 = true;
        this.B = 0;
        Handler handler2 = this.z;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        H1();
        Thread thread = this.u;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new f());
            this.u = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void r0(ActivationCallBack activationCallBack, String str) {
    }

    public void t0() {
        try {
            F1();
            this.n.setVisibility(4);
            Toast.makeText(this, getResources().getString(j.e7), 0).show();
        } catch (Exception unused) {
        }
    }

    public void u1() {
        this.P = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.d = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void w0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (m7.a.n.booleanValue()) {
                Toast.makeText(this, getResources().getString(j.C2), 0).show();
                return;
            } else {
                w.P0(this.t, "Your Account is invalid or has expired !");
                return;
            }
        }
        try {
            this.E.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.E.apply();
            arrayList.remove(0);
            this.H.h(this.M, this.N, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void w1() {
        this.f = String.format("%06d", new Object[]{Integer.valueOf(new Random().nextInt(999999))});
    }

    public void x(TVCodeGenerateCallBack tVCodeGenerateCallBack) {
        Toast makeText;
        try {
            F1();
            if (tVCodeGenerateCallBack == null || tVCodeGenerateCallBack.getResult() == null || !tVCodeGenerateCallBack.getResult().equals("success") || tVCodeGenerateCallBack.getSc() == null) {
                this.q.requestFocus();
                this.n.setVisibility(4);
                makeText = Toast.makeText(this, "Error Code:603 =>" + getResources().getString(j.e7), 0);
            } else {
                if (tVCodeGenerateCallBack.getSc().equalsIgnoreCase(w.o0(m7.a.S0 + "*JNHGHG34534543HSDHSHSSH*&^klih*" + b7.b.b + "*" + new SimpleDateFormat("yyyy-MM").format(new Date())))) {
                    this.q.requestFocus();
                    if (!this.f.equals("")) {
                        this.o.setText(this.f);
                        E1(this.f);
                        this.n.setVisibility(0);
                        try {
                            CountDownTimer countDownTimer = this.x;
                            if (countDownTimer != null) {
                                countDownTimer.cancel();
                            }
                            this.x = new c(this.y, 1000L).start();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        Handler handler = this.w;
                        if (handler != null) {
                            handler.removeCallbacksAndMessages((Object) null);
                            this.w.postDelayed(new d(), this.y);
                            return;
                        }
                        return;
                    }
                    this.n.setVisibility(4);
                    makeText = Toast.makeText(this, "Error Code:601 =>" + getResources().getString(j.e7), 0);
                } else {
                    this.q.requestFocus();
                    this.n.setVisibility(4);
                    makeText = Toast.makeText(this, "Error Code:602 =>" + getResources().getString(j.e7), 0);
                }
            }
            makeText.show();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void x1() {
        this.e = String.valueOf(new Random().nextInt(8378600) + 10000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0377, code lost:
    
        if (m7.a.n.booleanValue() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x03ef, code lost:
    
        m7.w.P0(r18.t, "Your Account is invalid or has expired !");
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
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.FirebaseRegisterDeviceActivity.y(com.nst.iptvsmarterstvbox.model.callback.LoginCallback, java.lang.String, java.util.ArrayList):void");
    }
}
