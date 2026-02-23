package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import g7.f;
import j$.util.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import m7.w;
import org.json.JSONObject;
import p7.X;
import p7.Y;
import p7.Z;
import p7.a0;
import p7.b0;
import p7.c0;
import p7.d0;
import p7.e0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LoginM3uActivity extends androidx.appcompat.app.b implements b7.c, View.OnClickListener {
    public static final File p0;
    public static final File q0;
    public static u7.a r0;
    public String A;
    public LiveStreamDBHandler B;
    public MultiUserDBHandler C;
    public DatabaseHandler D;
    public SharedPreferences E;
    public SharedPreferences.Editor F;
    public SharedPreferences G;
    public SharedPreferences H;
    public SharedPreferences I;
    public SharedPreferences J;
    public SharedPreferences.Editor K;
    public SharedPreferences.Editor L;
    public SharedPreferences.Editor M;
    public SharedPreferences.Editor N;
    public RadioGroup O;
    public SharedPreferences Q;
    public SharedPreferences.Editor R;
    public String S;
    public String T;
    public String U;
    public int V;
    public String Z;
    public EditText d;
    public EditText e;
    public SharedPreferences e0;
    public EditText f;
    public SharedPreferences.Editor f0;
    public RelativeLayout g;
    public SharedPreferences.Editor g0;
    public ImageView h;
    public SharedPreferences h0;
    public TextView i;
    public SharedPreferences i0;
    public RelativeLayout j;
    public ImageView k;
    public TextView l;
    public RelativeLayout m;
    public String m0;
    public ImageView n;
    public androidx.appcompat.app.a n0;
    public TextView o;
    public Uri o0;
    public Button p;
    public RadioButton q;
    public RadioButton r;
    public TextView s;
    public TextView t;
    public Button u;
    public RelativeLayout v;
    public InputStream w;
    public String y;
    public String z;
    public Context x = this;
    public final A7.a P = new A7.a();
    public String W = "";
    public String X = "";
    public long Y = -1;
    public String j0 = "";
    public ArrayList k0 = new ArrayList();
    public String l0 = "file";

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            m7.a.c = true;
            SharepreferenceDBHandler.setTypeLogin("login", LoginM3uActivity.x1(LoginM3uActivity.this));
            Intent intent = new Intent(LoginM3uActivity.x1(LoginM3uActivity.this), ProfileActivity.class);
            intent.putExtra("typeid", "login");
            LoginM3uActivity.this.startActivity(intent);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(LoginM3uActivity.x1(LoginM3uActivity.this), MultiUserActivity.class);
            SharepreferenceDBHandler.setCurrentAPPType("m3u", LoginM3uActivity.x1(LoginM3uActivity.this));
            LoginM3uActivity.this.startActivity(intent);
            LoginM3uActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
            LoginM3uActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements MyApplication.d {
            public a() {
            }

            public static /* synthetic */ void c(a aVar, String str) {
                aVar.g(str);
            }

            public static /* synthetic */ void d(a aVar) {
                aVar.h();
            }

            public static /* synthetic */ void e(a aVar, String str) {
                aVar.f(str);
            }

            private /* synthetic */ void f(String str) {
                MyApplication.p().D("LM" + str, LoginM3uActivity.x1(LoginM3uActivity.this));
            }

            private /* synthetic */ void g(String str) {
                MyApplication.p().D("LM" + str, LoginM3uActivity.x1(LoginM3uActivity.this));
                LoginM3uActivity.this.startActivity(new Intent(LoginM3uActivity.this.getApplicationContext(), FirebaseRegisterDeviceActivity.class));
                LoginM3uActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
            }

            private /* synthetic */ void h() {
                LoginM3uActivity.this.startActivity(new Intent(LoginM3uActivity.this.getApplicationContext(), FirebaseRegisterDeviceActivity.class));
                LoginM3uActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
            }

            public void a(String str) {
                LoginM3uActivity.this.runOnUiThread(new Z(this, str));
            }

            public void b(String str) {
                LoginM3uActivity.this.runOnUiThread(new a0(this, str));
            }

            public void onSuccess() {
                LoginM3uActivity.this.runOnUiThread(new b0(this));
            }
        }

        public c() {
        }

        public void onClick(View view) {
            if (m7.a.W0.booleanValue()) {
                if (SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginM3uActivity.x1(LoginM3uActivity.this)) == null || SharepreferenceDBHandler.getSBPDemoAndClientUrl(LoginM3uActivity.x1(LoginM3uActivity.this)).length() <= 0) {
                    MyApplication.p().G(LoginM3uActivity.x1(LoginM3uActivity.this), new a());
                } else {
                    LoginM3uActivity.this.startActivity(new Intent(LoginM3uActivity.this.getApplicationContext(), FirebaseRegisterDeviceActivity.class));
                    LoginM3uActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                }
            }
        }
    }

    public class d implements f.g {
        public final /* synthetic */ String[] a;

        public d(String[] strArr) {
            this.a = strArr;
        }

        public void a(String str) {
            this.a[0] = str;
            LoginM3uActivity.this.f.setText(str);
            LoginM3uActivity.this.s.setVisibility(8);
            LoginM3uActivity.this.t.setVisibility(0);
            LoginM3uActivity.this.t.setText(str);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", LoginM3uActivity.this.getPackageName(), (String) null));
                LoginM3uActivity.this.startActivityForResult(intent, 101);
                Toast.makeText(LoginM3uActivity.x1(LoginM3uActivity.this), LoginM3uActivity.x1(LoginM3uActivity.this).getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            LoginM3uActivity.J1(LoginM3uActivity.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            LoginM3uActivity.J1(LoginM3uActivity.this).dismiss();
            LoginM3uActivity.this.onBackPressed();
        }
    }

    public class g extends Dialog implements View.OnClickListener {
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

        public g(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(g gVar) {
            return gVar.e;
        }

        public static /* synthetic */ LinearLayout b(g gVar) {
            return gVar.f;
        }

        public void onClick(View view) {
            int id = view.getId();
            try {
                if (id != a7.f.s1) {
                    if (id == a7.f.X0) {
                        dismiss();
                        return;
                    }
                    return;
                }
                dismiss();
                int checkedRadioButtonId = LoginM3uActivity.A1(LoginM3uActivity.this).getCheckedRadioButtonId();
                if (checkedRadioButtonId == a7.f.kd && LoginM3uActivity.this.P1()) {
                    LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity, loginM3uActivity.d.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity2 = LoginM3uActivity.this;
                    LoginM3uActivity.C1(loginM3uActivity2, loginM3uActivity2.f.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "file");
                    LoginM3uActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.B1(LoginM3uActivity.this)});
                }
                if (checkedRadioButtonId == a7.f.nd && LoginM3uActivity.this.Q1()) {
                    LoginM3uActivity loginM3uActivity3 = LoginM3uActivity.this;
                    LoginM3uActivity.G1(loginM3uActivity3, loginM3uActivity3.e.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity4 = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity4, loginM3uActivity4.d.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "url");
                    LoginM3uActivity.this.new k().execute(new Void[0]);
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(LoginM3uActivity.y1().A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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

    public class h extends AsyncTask {
        public h() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(strArr[0]);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(LoginM3uActivity.x1(LoginM3uActivity.this).getFilesDir() + "/data_temp.txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(LoginM3uActivity.x1(LoginM3uActivity.this).getFilesDir() + "/data_temp.txt").toString())));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!(((!readLine.contains("http://") || readLine.contains("tvg-logo")) && (!readLine.contains("https://") || readLine.contains("tvg-logo"))) ? "" : readLine).equals("")) {
                        sb.append(readLine);
                        break;
                    }
                }
                bufferedWriter.write(sb.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
                return Boolean.TRUE;
            } catch (Exception e2) {
                Log.d("Google", "DownloadFileFromUrl " + e2.getMessage());
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    LoginM3uActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.x1(LoginM3uActivity.this).getFilesDir() + "/data_temp.txt"});
                } else {
                    w.X();
                    w.P0(LoginM3uActivity.x1(LoginM3uActivity.this), "Incorrect File/URL");
                }
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(String... strArr) {
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ h(LoginM3uActivity loginM3uActivity, a aVar) {
            this();
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
                LoginM3uActivity.this.w1();
                return;
            }
            w.X();
            LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
            g gVar = loginM3uActivity.new g(LoginM3uActivity.x1(loginM3uActivity));
            gVar.setCancelable(false);
            gVar.show();
        }
    }

    public class j extends AsyncTask {
        public int a;

        public class a implements MyApplication.d {
            public a() {
            }

            public static /* synthetic */ void c(a aVar, String str) {
                aVar.g(str);
            }

            public static /* synthetic */ void d(a aVar) {
                aVar.h();
            }

            public static /* synthetic */ void e(a aVar, String str) {
                aVar.f(str);
            }

            private /* synthetic */ void f(String str) {
                MyApplication.p().D("LM" + str, LoginM3uActivity.x1(LoginM3uActivity.this));
            }

            private /* synthetic */ void g(String str) {
                MyApplication.p().D("LM" + str, LoginM3uActivity.x1(LoginM3uActivity.this));
                j jVar = j.this;
                int i = jVar.a;
                if (i == a7.f.kd) {
                    LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity, loginM3uActivity.d.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity2 = LoginM3uActivity.this;
                    LoginM3uActivity.C1(loginM3uActivity2, loginM3uActivity2.f.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "file");
                    LoginM3uActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.B1(LoginM3uActivity.this)});
                    return;
                }
                if (i == a7.f.nd) {
                    LoginM3uActivity loginM3uActivity3 = LoginM3uActivity.this;
                    LoginM3uActivity.G1(loginM3uActivity3, loginM3uActivity3.e.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity4 = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity4, loginM3uActivity4.d.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "url");
                    LoginM3uActivity.this.new k().execute(new Void[0]);
                }
            }

            private /* synthetic */ void h() {
                j jVar = j.this;
                int i = jVar.a;
                if (i == a7.f.kd) {
                    LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity, loginM3uActivity.d.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity2 = LoginM3uActivity.this;
                    LoginM3uActivity.C1(loginM3uActivity2, loginM3uActivity2.f.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "file");
                    LoginM3uActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.B1(LoginM3uActivity.this)});
                    return;
                }
                if (i == a7.f.nd) {
                    LoginM3uActivity loginM3uActivity3 = LoginM3uActivity.this;
                    LoginM3uActivity.G1(loginM3uActivity3, loginM3uActivity3.e.getText().toString().trim());
                    LoginM3uActivity loginM3uActivity4 = LoginM3uActivity.this;
                    LoginM3uActivity.z1(loginM3uActivity4, loginM3uActivity4.d.getText().toString().trim());
                    LoginM3uActivity.E1(LoginM3uActivity.this, "url");
                    LoginM3uActivity.this.new k().execute(new Void[0]);
                }
            }

            public void a(String str) {
                LoginM3uActivity.this.runOnUiThread(new c0(this, str));
            }

            public void b(String str) {
                LoginM3uActivity.this.runOnUiThread(new d0(this, str));
            }

            public void onSuccess() {
                LoginM3uActivity.this.runOnUiThread(new e0(this));
            }
        }

        public j(int i) {
            this.a = i;
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
            if (!bool.booleanValue()) {
                w.X();
                LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
                g gVar = loginM3uActivity.new g(LoginM3uActivity.x1(loginM3uActivity));
                gVar.setCancelable(false);
                gVar.show();
                return;
            }
            if (m7.a.W0.booleanValue()) {
                MyApplication.p().G(LoginM3uActivity.x1(LoginM3uActivity.this), new a());
                return;
            }
            int i = this.a;
            if (i == a7.f.kd) {
                LoginM3uActivity loginM3uActivity2 = LoginM3uActivity.this;
                LoginM3uActivity.z1(loginM3uActivity2, loginM3uActivity2.d.getText().toString().trim());
                LoginM3uActivity loginM3uActivity3 = LoginM3uActivity.this;
                LoginM3uActivity.C1(loginM3uActivity3, loginM3uActivity3.f.getText().toString().trim());
                LoginM3uActivity.E1(LoginM3uActivity.this, "file");
                LoginM3uActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.B1(LoginM3uActivity.this)});
                return;
            }
            if (i == a7.f.nd) {
                LoginM3uActivity loginM3uActivity4 = LoginM3uActivity.this;
                LoginM3uActivity.G1(loginM3uActivity4, loginM3uActivity4.e.getText().toString().trim());
                LoginM3uActivity loginM3uActivity5 = LoginM3uActivity.this;
                LoginM3uActivity.z1(loginM3uActivity5, loginM3uActivity5.d.getText().toString().trim());
                LoginM3uActivity.E1(LoginM3uActivity.this, "url");
                LoginM3uActivity.this.new k().execute(new Void[0]);
            }
        }
    }

    public class k extends AsyncTask {
        public k() {
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
                new m(LoginM3uActivity.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.F1(LoginM3uActivity.this)});
                return;
            }
            w.X();
            LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
            g gVar = loginM3uActivity.new g(LoginM3uActivity.x1(loginM3uActivity));
            gVar.setCancelable(false);
            gVar.show();
        }

        public void onPreExecute() {
            super.onPreExecute();
            w.M0(LoginM3uActivity.this);
        }
    }

    public class l implements View.OnFocusChangeListener {
        public final View a;

        public l(View view) {
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
            LoginM3uActivity loginM3uActivity;
            TextView textView;
            TextView textView2;
            int color;
            if (!z) {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("3")) {
                    view.setBackgroundResource(a7.e.j1);
                    return;
                }
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("rl_add_user")) {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("rl_list_users")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("rl_login_from_mobile_app")) {
                            return;
                        }
                        LoginM3uActivity.this.m.setBackgroundResource(a7.e.d1);
                        LoginM3uActivity.this.n.setImageResource(a7.e.h1);
                        loginM3uActivity = LoginM3uActivity.this;
                        textView = loginM3uActivity.o;
                    } else {
                        LoginM3uActivity.this.j.setBackgroundResource(a7.e.d1);
                        LoginM3uActivity.this.k.setImageResource(a7.e.h1);
                        loginM3uActivity = LoginM3uActivity.this;
                        textView = loginM3uActivity.l;
                    }
                } else {
                    LoginM3uActivity.this.g.setBackgroundResource(a7.e.d1);
                    LoginM3uActivity.this.h.setImageResource(a7.e.d);
                    loginM3uActivity = LoginM3uActivity.this;
                    textView = loginM3uActivity.i;
                }
                textView.setTextColor(LoginM3uActivity.x1(loginM3uActivity).getResources().getColor(a7.c.f));
                return;
            }
            f = z ? 1.1f : 1.0f;
            try {
                b(f);
                c(f);
                View view6 = this.a;
                if (view6 != null && view6.getTag() != null && this.a.getTag().equals("3")) {
                    b(f);
                    c(f);
                    view.setBackgroundResource(a7.e.p);
                    return;
                }
                View view7 = this.a;
                if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("rl_add_user")) {
                    View view8 = this.a;
                    if (view8 == null || view8.getTag() == null || !this.a.getTag().equals("rl_list_users")) {
                        View view9 = this.a;
                        if (view9 == null || view9.getTag() == null || !this.a.getTag().equals("rl_login_from_mobile_app")) {
                            return;
                        }
                        LoginM3uActivity.this.m.setBackgroundResource(a7.e.c1);
                        LoginM3uActivity.this.n.setImageResource(a7.e.g1);
                        LoginM3uActivity loginM3uActivity2 = LoginM3uActivity.this;
                        textView2 = loginM3uActivity2.o;
                        color = LoginM3uActivity.x1(loginM3uActivity2).getResources().getColor(a7.c.G);
                    } else {
                        LoginM3uActivity.this.j.setBackgroundResource(a7.e.c1);
                        LoginM3uActivity.this.k.setImageResource(a7.e.g1);
                        LoginM3uActivity loginM3uActivity3 = LoginM3uActivity.this;
                        textView2 = loginM3uActivity3.l;
                        color = LoginM3uActivity.x1(loginM3uActivity3).getResources().getColor(a7.c.G);
                    }
                } else {
                    LoginM3uActivity.this.g.setBackgroundResource(a7.e.c1);
                    LoginM3uActivity.this.h.setImageResource(a7.e.e);
                    LoginM3uActivity loginM3uActivity4 = LoginM3uActivity.this;
                    textView2 = loginM3uActivity4.i;
                    color = LoginM3uActivity.x1(loginM3uActivity4).getResources().getColor(a7.c.G);
                }
                textView2.setTextColor(color);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m extends AsyncTask {
        public m() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                HttpURLConnection openConnection = new URL(strArr[0]).openConnection();
                openConnection.setInstanceFollowRedirects(true);
                openConnection.setConnectTimeout(30000);
                openConnection.setReadTimeout(30000);
                openConnection.setRequestMethod("POST");
                openConnection.setDoOutput(true);
                openConnection.setDoInput(true);
                openConnection.connect();
                int responseCode = openConnection.getResponseCode();
                return Boolean.valueOf(responseCode == 200 || responseCode == 405 || responseCode == 404);
            } catch (Exception e) {
                Log.e("Google", e.toString());
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                new h(LoginM3uActivity.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LoginM3uActivity.F1(LoginM3uActivity.this)});
            } else {
                w.X();
                w.P0(LoginM3uActivity.x1(LoginM3uActivity.this), LoginM3uActivity.x1(LoginM3uActivity.this).getResources().getString(a7.j.h2));
            }
        }

        public void onPreExecute() {
        }

        public /* synthetic */ m(LoginM3uActivity loginM3uActivity, a aVar) {
            this();
        }
    }

    public class n extends AsyncTask {
        public n() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                LoginM3uActivity.this.w = new FileInputStream(new File(strArr[0]));
                LoginM3uActivity loginM3uActivity = LoginM3uActivity.this;
                return loginM3uActivity.P.c(loginM3uActivity.w, LoginM3uActivity.x1(loginM3uActivity));
            } catch (Exception unused) {
                return "";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (str.equals("")) {
                    w.X();
                    Toast.makeText(LoginM3uActivity.x1(LoginM3uActivity.this), LoginM3uActivity.x1(LoginM3uActivity.this).getResources().getString(a7.j.Z7), 1).show();
                } else {
                    LoginM3uActivity.H1(LoginM3uActivity.this, str);
                    if (m7.a.o.booleanValue()) {
                        LoginM3uActivity.I1(LoginM3uActivity.this);
                    } else if (LoginM3uActivity.D1(LoginM3uActivity.this) == null || !LoginM3uActivity.D1(LoginM3uActivity.this).equals("url")) {
                        LoginM3uActivity.this.new i().execute(new Void[0]);
                    } else {
                        LoginM3uActivity.this.w1();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (LoginM3uActivity.D1(LoginM3uActivity.this) == null || !LoginM3uActivity.D1(LoginM3uActivity.this).equals("url")) {
                w.M0(LoginM3uActivity.this);
            }
        }
    }

    static {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        p0 = externalStorageDirectory;
        q0 = new File(externalStorageDirectory.getPath() + "/IPTVSmartersM3u");
    }

    public static /* synthetic */ RadioGroup A1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.O;
    }

    public static /* synthetic */ String B1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.z;
    }

    public static /* synthetic */ String C1(LoginM3uActivity loginM3uActivity, String str) {
        loginM3uActivity.z = str;
        return str;
    }

    public static /* synthetic */ String D1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.l0;
    }

    public static /* synthetic */ String E1(LoginM3uActivity loginM3uActivity, String str) {
        loginM3uActivity.l0 = str;
        return str;
    }

    public static /* synthetic */ String F1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.y;
    }

    public static /* synthetic */ String G1(LoginM3uActivity loginM3uActivity, String str) {
        loginM3uActivity.y = str;
        return str;
    }

    public static /* synthetic */ String H1(LoginM3uActivity loginM3uActivity, String str) {
        loginM3uActivity.j0 = str;
        return str;
    }

    public static /* synthetic */ void I1(LoginM3uActivity loginM3uActivity) {
        loginM3uActivity.K1();
    }

    public static /* synthetic */ androidx.appcompat.app.a J1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.n0;
    }

    private static String M1(String str) {
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

    private void N1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static String S1() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return M1(str2);
        }
        return M1(str) + " " + str2;
    }

    private void T1() {
        RelativeLayout relativeLayout;
        try {
            this.C = new MultiUserDBHandler(this.x);
            this.B = new LiveStreamDBHandler(this.x);
            this.D = new DatabaseHandler(this.x);
            b7.g.c = new b7.g(this);
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefsserverurl", 0);
            this.e0 = sharedPreferences;
            this.f0 = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = getSharedPreferences("sharedPreference", 0);
            this.h0 = sharedPreferences2;
            this.g0 = sharedPreferences2.edit();
            this.i0 = getSharedPreferences("loginPrefs", 0);
            this.O = findViewById(a7.f.Kd);
            if (m7.a.t.booleanValue()) {
                this.v.setVisibility(0);
                this.d.requestFocus();
                this.j.setVisibility(0);
            } else {
                this.v.setVisibility(8);
                this.q.requestFocus();
                this.j.setVisibility(4);
                this.i.setText(getResources().getString(a7.j.d3));
            }
            if (!this.m0.equals(m7.a.K0)) {
                relativeLayout = this.m;
            } else {
                if (m7.a.V0.booleanValue()) {
                    this.m.setVisibility(0);
                    this.E = this.x.getSharedPreferences("allowedFormat", 0);
                    Button button = this.p;
                    button.setOnFocusChangeListener(new l(button));
                    RelativeLayout relativeLayout2 = this.g;
                    relativeLayout2.setOnFocusChangeListener(new l(relativeLayout2));
                    RelativeLayout relativeLayout3 = this.j;
                    relativeLayout3.setOnFocusChangeListener(new l(relativeLayout3));
                    RelativeLayout relativeLayout4 = this.m;
                    relativeLayout4.setOnFocusChangeListener(new l(relativeLayout4));
                    this.u.setOnClickListener(new a());
                    this.j.setOnClickListener(new b());
                    this.m.setOnClickListener(new c());
                }
                relativeLayout = this.m;
            }
            relativeLayout.setVisibility(8);
            this.E = this.x.getSharedPreferences("allowedFormat", 0);
            Button button2 = this.p;
            button2.setOnFocusChangeListener(new l(button2));
            RelativeLayout relativeLayout22 = this.g;
            relativeLayout22.setOnFocusChangeListener(new l(relativeLayout22));
            RelativeLayout relativeLayout32 = this.j;
            relativeLayout32.setOnFocusChangeListener(new l(relativeLayout32));
            RelativeLayout relativeLayout42 = this.m;
            relativeLayout42.setOnFocusChangeListener(new l(relativeLayout42));
            this.u.setOnClickListener(new a());
            this.j.setOnClickListener(new b());
            this.m.setOnClickListener(new c());
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static String V1(String str) {
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

    public static /* synthetic */ Context x1(LoginM3uActivity loginM3uActivity) {
        return loginM3uActivity.x;
    }

    public static /* synthetic */ u7.a y1() {
        return r0;
    }

    public static /* synthetic */ String z1(LoginM3uActivity loginM3uActivity, String str) {
        loginM3uActivity.A = str;
        return str;
    }

    public final void K1() {
        String str;
        int autoIdLoggedInUser;
        Context context;
        try {
            SharedPreferences.Editor edit = getSharedPreferences("loginPrefs", 0).edit();
            edit.putString("username", "playlist");
            edit.putString("password", "playlist");
            edit.putString("serverPort", "");
            String str2 = this.l0;
            if (str2 == null || !str2.equals("url")) {
                edit.putString("serverUrl", this.z);
                str = this.z;
            } else {
                edit.putString("serverUrl", this.y);
                str = this.y;
            }
            edit.putString("serverM3UUrl", str);
            edit.putString("anyName", this.A);
            edit.apply();
            this.E = this.x.getSharedPreferences("allowedFormat", 0);
            this.G = this.x.getSharedPreferences("timeFormat", 0);
            this.H = this.x.getSharedPreferences("epgchannelupdate", 0);
            this.I = this.x.getSharedPreferences("automation_channels", 0);
            this.J = this.x.getSharedPreferences("automation_epg", 0);
            this.F = this.E.edit();
            this.K = this.G.edit();
            this.L = this.H.edit();
            this.M = this.I.edit();
            this.N = this.J.edit();
            SharedPreferences sharedPreferences = this.x.getSharedPreferences("auto_start", 0);
            this.Q = sharedPreferences;
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            this.R = edit2;
            if (edit2 != null) {
                edit2.putBoolean("full_epg", true);
                this.R.apply();
            }
            String string = this.E.getString("allowedFormat", "");
            if (string != null && string.equals("")) {
                this.F.putString("allowedFormat", "ts");
                this.F.apply();
            }
            if (this.I.getString("automation_channels", "").equals("")) {
                this.M.putString("automation_channels", "checked");
                this.M.apply();
            }
            if (this.J.getString("automation_epg", "").equals("")) {
                this.N.putString("automation_epg", "checked");
                this.N.apply();
            }
            if (this.G.getString("timeFormat", m7.a.E0).equals("")) {
                this.K.putString("timeFormat", m7.a.E0);
                this.K.apply();
            }
            if (this.H.getString("epgchannelupdate", "").equals("")) {
                this.L.putString("epgchannelupdate", "all");
                this.L.apply();
            }
            m7.a.d0 = Boolean.TRUE;
            SharepreferenceDBHandler.setCurrentAPPType("m3u", this.x);
            String str3 = this.l0;
            if (str3 == null || !str3.equals("url")) {
                if (!this.C.checkregistration(this.A, "playlist", "playlist", this.z, "m3u", "", "")) {
                    this.C.addmultiusersM3U(this.A, "playlist", "playlist", this.z, "file");
                    Toast.makeText(this.x, getResources().getString(a7.j.r8), 0).show();
                }
                SharedPreferences.Editor edit3 = this.x.getSharedPreferences("loginprefsmultiuser", 0).edit();
                edit3.putString("name", this.A);
                edit3.putString("username", "playlist");
                edit3.putString("password", "playlist");
                edit3.putString(m7.a.L, this.z);
                edit3.apply();
                if (this.x != null) {
                    MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(this.x);
                    this.C = multiUserDBHandler;
                    autoIdLoggedInUser = multiUserDBHandler.getAutoIdLoggedInUser(this.A, "playlist", "playlist", this.z, "m3u", "", "");
                    SharepreferenceDBHandler.setUserID(autoIdLoggedInUser, this.x);
                }
            } else {
                if (!this.C.checkregistration(this.A, "playlist", "playlist", this.y, "m3u", "", "")) {
                    this.C.addmultiusersM3U(this.A, "playlist", "playlist", this.y, "url");
                    Toast.makeText(this.x, getResources().getString(a7.j.r8), 0).show();
                }
                SharedPreferences.Editor edit4 = this.x.getSharedPreferences("loginprefsmultiuser", 0).edit();
                edit4.putString("name", this.A);
                edit4.putString("username", "playlist");
                edit4.putString("password", "playlist");
                edit4.putString(m7.a.L, this.y);
                edit4.apply();
                if (this.x != null) {
                    MultiUserDBHandler multiUserDBHandler2 = new MultiUserDBHandler(this.x);
                    this.C = multiUserDBHandler2;
                    autoIdLoggedInUser = multiUserDBHandler2.getAutoIdLoggedInUser(this.A, "playlist", "playlist", this.y, "m3u", "", "");
                    SharepreferenceDBHandler.setUserID(autoIdLoggedInUser, this.x);
                }
            }
            w.X();
            String str4 = this.j0;
            if (str4 != null && !str4.equals("")) {
                Log.e("jaskirat", "m3uURLGlobal::: " + this.j0);
                SharepreferenceDBHandler.setFirebaseM3uNode(this.j0, this.x);
            }
            if (this.B.getImportTableCount("m3u") == 0) {
                ArrayList arrayList = new ArrayList();
                ImportStatusModel importStatusModel = new ImportStatusModel();
                importStatusModel.setType("all");
                importStatusModel.setStatus("0");
                importStatusModel.setDate("");
                arrayList.add(0, importStatusModel);
                this.B.importDataStatusArrayList(arrayList, "m3u");
            }
            ImportStatusModel importStatusModel2 = this.B.getdateDBStatus("all");
            if (importStatusModel2 != null) {
                if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("0")) && (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("2"))) {
                    if (importStatusModel2.getStatus() != null && importStatusModel2.getStatus().equals("1")) {
                        long C = w.C(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel2.getDate(), w.q());
                        if (!O1() || C < r0.g()) {
                            this.x.startActivity(new Intent(this.x, NewDashboardActivity.class));
                            context = this.x;
                        } else {
                            this.x.startActivity(new Intent(this.x, ImportM3uActivity.class));
                            context = this.x;
                        }
                    } else {
                        if (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("3")) {
                            return;
                        }
                        this.x.startActivity(new Intent(this.x, ImportM3uActivity.class));
                        context = this.x;
                    }
                } else {
                    if (this.x == null) {
                        return;
                    }
                    this.x.startActivity(new Intent(this.x, ImportM3uActivity.class));
                    context = this.x;
                }
                ((Activity) context).finish();
            }
        } catch (Exception unused) {
        }
    }

    public void L1() {
        try {
            this.U = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean O1() {
        return this.x.getSharedPreferences("automation_channels", 0).getString("automation_channels", "").equals("checked");
    }

    public boolean P1() {
        EditText editText;
        Resources resources;
        int i2;
        if (m7.a.t.booleanValue()) {
            if (this.d.getText().toString().trim().length() == 0) {
                this.d.requestFocus();
                editText = this.d;
                resources = getResources();
                i2 = a7.j.n1;
                editText.setError(resources.getString(i2));
                return false;
            }
            if (this.f.getText().toString().trim().length() != 0) {
                return true;
            }
        } else if (this.f.getText().toString().trim().length() != 0) {
            return true;
        }
        this.s.setVisibility(0);
        this.s.requestFocus();
        editText = this.s;
        resources = this.x.getResources();
        i2 = a7.j.i0;
        editText.setError(resources.getString(i2));
        return false;
    }

    public boolean Q1() {
        EditText editText;
        Resources resources;
        int i2;
        if (m7.a.t.booleanValue()) {
            if (this.d.getText().toString().trim().length() == 0) {
                this.d.requestFocus();
                editText = this.d;
                resources = getResources();
                i2 = a7.j.n1;
                editText.setError(resources.getString(i2));
                return false;
            }
            if (this.e.getText().toString().trim().length() != 0) {
                return true;
            }
        } else if (this.e.getText().toString().trim().length() != 0) {
            return true;
        }
        this.e.requestFocus();
        editText = this.e;
        resources = getResources();
        i2 = a7.j.q1;
        editText.setError(resources.getString(i2));
        return false;
    }

    public void R1() {
        g7.f fVar = new g7.f(this.x, new d(new String[]{""}));
        if (Build.VERSION.SDK_INT >= 30) {
            fVar.v("");
        } else {
            fVar.u("");
        }
    }

    public void U1() {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                if (i2 >= 33) {
                    if (X.a(this, "android.permission.READ_MEDIA_AUDIO") != 0) {
                        D.b.h(this, new String[]{"android.permission.READ_MEDIA_AUDIO"}, 101);
                    }
                } else if (X.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0 || X.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i2, boolean z) {
        Toast makeText;
        if (z && i2 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (jSONObject.getString("status").equalsIgnoreCase("true")) {
                    this.W = b7.b.a.getString("su");
                    this.X = b7.b.a.getString("ndd");
                    this.Y = System.currentTimeMillis();
                    b7.f.e(this, b7.b.a.optString("su"));
                    this.Z = V1(b7.b.a.optString("su") + "*" + b7.f.d(this) + "*" + b7.b.b);
                    if (b7.b.a.getString("sc").equalsIgnoreCase(this.Z)) {
                        if (!m7.a.t.booleanValue()) {
                            String str2 = this.j0;
                            if (str2 != null && str2.contains(b7.f.a(this))) {
                                K1();
                                return;
                            }
                            w.X();
                            makeText = Toast.makeText(this, this.x.getResources().getString(a7.j.G2), 0);
                            makeText.show();
                        }
                        String str3 = this.W;
                        if (str3 != null && !str3.equals("") && !this.W.isEmpty()) {
                            this.k0 = new ArrayList(Arrays.asList(this.W.split(",")));
                        }
                        ArrayList arrayList = this.k0;
                        if (arrayList == null || arrayList.size() < 1) {
                            makeText = Toast.makeText(this, this.x.getResources().getString(a7.j.l5), 0);
                        } else {
                            for (int i3 = 0; i3 < this.k0.size(); i3++) {
                                String str4 = this.j0;
                                if (str4 != null && str4.contains((CharSequence) this.k0.get(i3))) {
                                    K1();
                                    return;
                                }
                            }
                            w.X();
                            makeText = Toast.makeText(this, this.x.getResources().getString(a7.j.e2), 0);
                        }
                        makeText.show();
                    }
                }
            } catch (Exception e2) {
                Log.e("Login check", e2.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f A[Catch: Exception -> 0x0038, TryCatch #2 {Exception -> 0x0038, blocks: (B:6:0x000a, B:9:0x0019, B:11:0x0025, B:14:0x005f, B:16:0x006e, B:18:0x0076, B:20:0x007a, B:22:0x0080, B:24:0x0088, B:26:0x0095, B:29:0x00b4, B:31:0x00cf, B:33:0x00d7, B:34:0x00da, B:35:0x00f4, B:41:0x013f, B:50:0x0146, B:51:0x0149, B:55:0x014a, B:61:0x016e, B:57:0x018c, B:65:0x0175, B:66:0x0178, B:67:0x003b, B:69:0x0041, B:71:0x004d, B:73:0x0179, B:60:0x0150), top: B:5:0x000a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X1(android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LoginM3uActivity.X1(android.content.Intent):void");
    }

    public void b0(int i2) {
        String string;
        w.X();
        try {
            if (!m7.a.t.booleanValue()) {
                String str = this.j0;
                if (str != null && str.contains(b7.f.a(this))) {
                    K1();
                    return;
                }
                w.X();
                string = this.x.getResources().getString(a7.j.l5);
                Toast.makeText(this, string, 0).show();
            }
            String a2 = b7.f.a(this);
            this.W = a2;
            if (a2 != null && !a2.equals("") && !this.W.isEmpty()) {
                this.k0 = new ArrayList(Arrays.asList(this.W.split(",")));
            }
            ArrayList arrayList = this.k0;
            if (arrayList == null || arrayList.size() < 1) {
                string = this.x.getResources().getString(a7.j.l5);
            } else {
                for (int i3 = 0; i3 < this.k0.size(); i3++) {
                    String str2 = this.j0;
                    if (str2 != null && str2.contains((CharSequence) this.k0.get(i3))) {
                        K1();
                        return;
                    }
                }
                w.X();
                string = this.x.getResources().getString(a7.j.e2);
            }
            Toast.makeText(this, string, 0).show();
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            try {
                U1();
            } catch (Exception unused) {
            }
        } else if (i2 == 201) {
            X1(intent);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int i2;
        if (view.getId() == a7.f.Pd) {
            int checkedRadioButtonId = this.O.getCheckedRadioButtonId();
            if (checkedRadioButtonId == a7.f.kd && P1()) {
                new j(checkedRadioButtonId).execute(new Void[0]);
            }
            if (checkedRadioButtonId == a7.f.nd && Q1()) {
                new j(checkedRadioButtonId).execute(new Void[0]);
                return;
            }
            return;
        }
        if (view.getId() == a7.f.j0) {
            try {
                if (!this.m0.equals(m7.a.K0) && (i2 = Build.VERSION.SDK_INT) >= 23) {
                    Intent intent = new Intent();
                    intent.setType((i2 == 23 || i2 == 24 || i2 == 25 || i2 == 26 || i2 == 27 || i2 == 28) ? "audio/mpegurl" : (i2 == 29 || i2 == 30) ? "audio/x-mpegurl" : "audio/*");
                    intent.setAction("android.intent.action.GET_CONTENT");
                    startActivityForResult(Intent.createChooser(intent, "Select File"), 201);
                } else {
                    R1();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.x = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.x);
        r0 = aVar;
        String A = aVar.A();
        this.m0 = A;
        setContentView(A.equals(m7.a.K0) ? a7.g.V : a7.g.U);
        this.d = findViewById(a7.f.i3);
        this.e = findViewById(a7.f.e3);
        this.f = findViewById(a7.f.f3);
        this.g = findViewById(a7.f.Pd);
        this.h = findViewById(a7.f.x4);
        this.i = findViewById(a7.f.yh);
        this.j = findViewById(a7.f.Ae);
        this.k = findViewById(a7.f.q5);
        this.l = findViewById(a7.f.Sj);
        this.m = findViewById(a7.f.Be);
        this.n = findViewById(a7.f.t5);
        this.o = findViewById(a7.f.Tj);
        this.p = findViewById(a7.f.j0);
        this.q = findViewById(a7.f.kd);
        this.r = findViewById(a7.f.nd);
        this.s = findViewById(a7.f.Nh);
        this.t = findViewById(a7.f.pj);
        this.u = findViewById(a7.f.Rm);
        this.v = findViewById(a7.f.df);
        this.g.setOnClickListener(this);
        this.p.setOnClickListener(this);
        U1();
        T1();
        if (m7.a.o.booleanValue()) {
            return;
        }
        L1();
        u1();
        S1();
        v1();
        N1();
    }

    public void onRadioButtonClicked(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        int id = view.getId();
        if (id == a7.f.kd) {
            if (isChecked) {
                this.t.setVisibility(0);
                this.p.setVisibility(0);
                this.e.setVisibility(8);
                this.s.setVisibility(8);
                return;
            }
            return;
        }
        if (id == a7.f.nd && isChecked) {
            this.t.setVisibility(8);
            this.p.setVisibility(8);
            this.s.setVisibility(8);
            this.e.setVisibility(0);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
                U1();
            } else if (Build.VERSION.SDK_INT < 23 || Y.a(this, strArr[0])) {
                onBackPressed();
            } else {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.requestFocus();
                findViewById.setOnClickListener(new e());
                findViewById2.setOnClickListener(new f());
                aVar.setView(inflate);
                this.n0 = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.n0.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.n0.show();
                this.n0.getWindow().setAttributes(layoutParams);
                this.n0.setCancelable(false);
                this.n0.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.x);
        w.z0(this.x);
    }

    public void u1() {
        this.T = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.V = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void w1() {
        this.S = V1(b7.f.c(this) + "*" + b7.f.d(this) + "-playlist-" + b7.b.b + "-" + this.U + "-unknown-" + S1() + "-" + this.T);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this)));
        b7.g.b.add(b7.g.a("sc", this.S));
        b7.g.b.add(b7.g.a("u", "playlist"));
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", this.U));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", S1()));
        b7.g.b.add(b7.g.a("do", this.T));
        b7.g.c.b(this);
    }
}
