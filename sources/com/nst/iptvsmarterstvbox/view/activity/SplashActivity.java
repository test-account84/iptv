package com.nst.iptvsmarterstvbox.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.miscelleneious.StopProcessingTasksService;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
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
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import m7.w;
import org.json.JSONObject;
import p7.j1;
import p7.k1;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SplashActivity extends androidx.appcompat.app.b implements z7.f, b7.c, z7.g {
    public SharedPreferences.Editor A;
    public SharedPreferences.Editor B;
    public SharedPreferences.Editor C;
    public SharedPreferences D;
    public SharedPreferences E;
    public SharedPreferences F;
    public SharedPreferences G;
    public SharedPreferences H;
    public SharedPreferences.Editor I;
    public SharedPreferences.Editor J;
    public SharedPreferences.Editor K;
    public SharedPreferences.Editor L;
    public SharedPreferences.Editor M;
    public SharedPreferences N;
    public SharedPreferences.Editor O;
    public LiveStreamDBHandler P;
    public SharedPreferences Q;
    public String S;
    public String T;
    public String U;
    public n7.d W;
    public InputStream X;
    public String Z;
    public SharedPreferences d;
    public SharedPreferences e;
    public LinearLayout e0;
    public Context f;
    public n7.e f0;
    public MultiUserDBHandler g;
    public String g0;
    public String h0;
    public String i0;
    public ImageView j;
    public String j0;
    public ImageView k;
    public VideoView m;
    public u7.a n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public String t;
    public Boolean x;
    public SharedPreferences y;
    public SharedPreferences z;
    public Boolean h = Boolean.FALSE;
    public String i = "";
    public int l = 0;
    public String u = "";
    public String v = "";
    public long w = -1;
    public ArrayList R = new ArrayList();
    public int V = 1500;
    public final A7.a Y = new A7.a();

    public class a implements p1.c {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        public void a(JSONObject jSONObject) {
            try {
                String string = jSONObject.getString("auth_token");
                if (string.isEmpty()) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, MultiUserActivity.class));
                    SplashActivity.this.finish();
                    Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
                } else {
                    SharepreferenceDBHandler.setFirebaseOneStreamNode(this.a, SplashActivity.this.f);
                    SharepreferenceDBHandler.setOneStreamToken(string, SplashActivity.this.f);
                    SplashActivity.O1(SplashActivity.this, this.a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, MultiUserActivity.class));
            SplashActivity.this.finish();
            Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
        }
    }

    public class b implements p1.c {
        public b() {
        }

        public void a(JSONObject jSONObject) {
            Intent intent;
            SplashActivity splashActivity;
            Class<MultiUserActivity> cls = "status";
            Class<MultiUserActivity> cls2 = MultiUserActivity.class;
            if (jSONObject == null) {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, cls2));
                SplashActivity.this.finish();
                Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(String.valueOf(jSONObject)).getJSONObject("user_info");
                    if (jSONObject2 != null) {
                        SplashActivity.this.i0 = jSONObject2.getString("auth");
                        String str = SplashActivity.this.i0;
                        if (str != null && Integer.valueOf(str).intValue() != 0) {
                            SplashActivity.this.j0 = jSONObject2.getString("status");
                            String str2 = SplashActivity.this.j0;
                            if (str2 != null && str2.equals("Active")) {
                                SplashActivity.this.b();
                                JSONObject jSONObject3 = new JSONObject(String.valueOf(jSONObject));
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("user_info");
                                String string = jSONObject4.getString("username");
                                jSONObject4.getString("message");
                                String string2 = jSONObject4.getString("expire_at");
                                try {
                                    cls2 = jSONObject4.getString("active_connections");
                                    String string3 = jSONObject4.getString("created_at");
                                    String string4 = jSONObject4.getString("max_connections");
                                    jSONObject4.getJSONArray("allowed_output_formats");
                                    String string5 = jSONObject3.getJSONObject("server_info").getString("time_now");
                                    try {
                                        if (SplashActivity.this.j0.equals("Active")) {
                                            SplashActivity.this.f.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                                            SharedPreferences.Editor edit = SplashActivity.this.getSharedPreferences("loginPrefs", 0).edit();
                                            edit.putString("username", string);
                                            edit.putString("password", SplashActivity.U1(SplashActivity.this));
                                            edit.putString("auth", SplashActivity.this.i0);
                                            edit.putString("status", SplashActivity.this.j0);
                                            edit.putString("expDate", string2);
                                            edit.putString("activeCons", cls2);
                                            edit.putString("createdAt", string3);
                                            edit.putString("maxConnections", string4);
                                            edit.putString("serverTimeZone", string5);
                                            edit.apply();
                                            SplashActivity splashActivity2 = SplashActivity.this;
                                            SplashActivity.W1(splashActivity2, splashActivity2.f.getSharedPreferences("allowedFormat", 0));
                                            SplashActivity splashActivity3 = SplashActivity.this;
                                            SplashActivity.Y1(splashActivity3, splashActivity3.f.getSharedPreferences("timeFormat", 0));
                                            SplashActivity splashActivity4 = SplashActivity.this;
                                            SplashActivity.a2(splashActivity4, splashActivity4.f.getSharedPreferences("epgchannelupdate", 0));
                                            SplashActivity splashActivity5 = SplashActivity.this;
                                            SplashActivity.c2(splashActivity5, splashActivity5.f.getSharedPreferences("automation_channels", 0));
                                            SplashActivity splashActivity6 = SplashActivity.this;
                                            SplashActivity.e2(splashActivity6, splashActivity6.f.getSharedPreferences("automation_epg", 0));
                                            SplashActivity splashActivity7 = SplashActivity.this;
                                            SplashActivity.g2(splashActivity7, SplashActivity.V1(splashActivity7).edit());
                                            SplashActivity splashActivity8 = SplashActivity.this;
                                            SplashActivity.B1(splashActivity8, SplashActivity.X1(splashActivity8).edit());
                                            SplashActivity splashActivity9 = SplashActivity.this;
                                            SplashActivity.D1(splashActivity9, SplashActivity.Z1(splashActivity9).edit());
                                            SplashActivity splashActivity10 = SplashActivity.this;
                                            SplashActivity.F1(splashActivity10, SplashActivity.b2(splashActivity10).edit());
                                            SplashActivity splashActivity11 = SplashActivity.this;
                                            SplashActivity.H1(splashActivity11, SplashActivity.d2(splashActivity11).edit());
                                            SplashActivity splashActivity12 = SplashActivity.this;
                                            SplashActivity.J1(splashActivity12, splashActivity12.f.getSharedPreferences("auto_start", 0));
                                            SplashActivity splashActivity13 = SplashActivity.this;
                                            SplashActivity.L1(splashActivity13, SplashActivity.I1(splashActivity13).edit());
                                            if (SplashActivity.K1(SplashActivity.this) != null) {
                                                SplashActivity.K1(SplashActivity.this).putBoolean("full_epg", true);
                                                SplashActivity.K1(SplashActivity.this).apply();
                                            }
                                            if (SplashActivity.b2(SplashActivity.this).getString("automation_channels", "").equals("")) {
                                                SplashActivity.E1(SplashActivity.this).putString("automation_channels", "checked");
                                                SplashActivity.E1(SplashActivity.this).apply();
                                            }
                                            if (SplashActivity.d2(SplashActivity.this).getString("automation_epg", "").equals("")) {
                                                SplashActivity.G1(SplashActivity.this).putString("automation_epg", "checked");
                                                SplashActivity.G1(SplashActivity.this).apply();
                                            }
                                            m7.a.c0 = Boolean.FALSE;
                                            if (SplashActivity.V1(SplashActivity.this).getString("allowedFormat", "").equals("")) {
                                                SplashActivity.f2(SplashActivity.this).putString("allowedFormat", "ts");
                                                SplashActivity.f2(SplashActivity.this).apply();
                                            }
                                            if (SplashActivity.X1(SplashActivity.this).getString("timeFormat", m7.a.E0).equals("")) {
                                                SplashActivity.A1(SplashActivity.this).putString("timeFormat", m7.a.E0);
                                                SplashActivity.A1(SplashActivity.this).apply();
                                            }
                                            if (SplashActivity.Z1(SplashActivity.this).getString("epgchannelupdate", "").equals("")) {
                                                SplashActivity.C1(SplashActivity.this).putString("epgchannelupdate", "all");
                                                SplashActivity.C1(SplashActivity.this).apply();
                                            }
                                            ImportStatusModel importStatusModel = SplashActivity.M1(SplashActivity.this).getdateDBStatus("onestream_api");
                                            if (importStatusModel != null) {
                                                if ((importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("0")) || (importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("2"))) {
                                                    intent = new Intent(SplashActivity.this.getApplicationContext(), ImportOneStreamActivity.class);
                                                    splashActivity = SplashActivity.this;
                                                } else if (importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("1")) {
                                                    long c = c(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel.getDate(), w.q());
                                                    if (!SplashActivity.this.l2() || c < SplashActivity.N1(SplashActivity.this).g()) {
                                                        intent = new Intent(SplashActivity.this.getApplicationContext(), NewDashboardActivity.class);
                                                        splashActivity = SplashActivity.this;
                                                    } else {
                                                        intent = new Intent(SplashActivity.this.getApplicationContext(), ImportOneStreamActivity.class);
                                                        splashActivity = SplashActivity.this;
                                                    }
                                                } else if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("3")) {
                                                    cls = cls2;
                                                    SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, cls));
                                                    SplashActivity.this.finish();
                                                } else {
                                                    intent = new Intent(SplashActivity.this.getApplicationContext(), ImportOneStreamActivity.class);
                                                    splashActivity = SplashActivity.this;
                                                }
                                                splashActivity.startActivity(intent);
                                            }
                                        } else {
                                            cls = cls2;
                                            SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, cls));
                                            SplashActivity.this.finish();
                                            Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.H2) + SplashActivity.this.j0, 0).show();
                                        }
                                    } catch (Exception unused) {
                                        SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, cls));
                                        SplashActivity.this.finish();
                                        Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
                                        return;
                                    }
                                } catch (Exception unused2) {
                                    cls = cls2;
                                }
                            }
                        }
                    }
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, cls2));
                    SplashActivity.this.finish();
                    Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
                } catch (Exception unused3) {
                    cls = cls2;
                }
            }
        }

        public void b(m1.a aVar) {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this.f, MultiUserActivity.class));
            SplashActivity.this.finish();
            Toast.makeText(SplashActivity.this.getApplicationContext(), SplashActivity.this.getResources().getString(a7.j.Y3), 0).show();
        }

        public long c(SimpleDateFormat simpleDateFormat, String str, String str2) {
            try {
                return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            SplashActivity.z1(SplashActivity.this, 0);
            SplashActivity.this.p2();
        }
    }

    public class d implements MediaPlayer.OnPreparedListener {
        public d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            SplashActivity splashActivity = SplashActivity.this;
            splashActivity.m.seekTo(splashActivity.l);
            SplashActivity splashActivity2 = SplashActivity.this;
            int i = splashActivity2.l;
            VideoView videoView = splashActivity2.m;
            if (i == 0) {
                videoView.start();
            } else {
                videoView.pause();
                SplashActivity.this.p2();
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            SplashActivity.this.q2();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            SplashActivity.this.q2();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            SplashActivity.this.q2();
        }
    }

    public class h implements MyApplication.d {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                h hVar = h.this;
                if (hVar.a.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(SplashActivity.this.f))) {
                    SplashActivity.this.w2();
                } else {
                    SplashActivity.this.y1();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                SplashActivity.this.w2();
            }
        }

        public h(String str) {
            this.a = str;
        }

        public void a(String str) {
        }

        public void b(String str) {
            MyApplication.p().D("SP" + str, SplashActivity.this.f);
            SplashActivity.this.runOnUiThread(new b());
        }

        public void onSuccess() {
            SplashActivity.this.runOnUiThread(new a());
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
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = i.b(i.this);
                        }
                    } else {
                        b = i.a(i.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = i.b(i.this);
                        }
                    } else {
                        b = i.a(i.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public i(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(i iVar) {
            return iVar.e;
        }

        public static /* synthetic */ LinearLayout b(i iVar) {
            return iVar.f;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.s1) {
                    dismiss();
                    SplashActivity.this.new k().execute(new Void[0]);
                } else {
                    if (view.getId() != a7.f.X0) {
                        return;
                    }
                    dismiss();
                    SplashActivity.this.finishAffinity();
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(SplashActivity.N1(SplashActivity.this).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
            Log.d("DeviceTypeRuntimeCheck", ((UiModeManager) SplashActivity.this.getSystemService("uimode")).getCurrentModeType() == 4 ? "Running on a TV Device" : "Running on a non-TV Device");
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
        public j() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(strArr[0]);
                SplashActivity.this.r2();
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(SplashActivity.this.f.getFilesDir() + "/data_temp.txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(SplashActivity.this.f.getFilesDir() + "/data_temp.txt").toString())));
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
                if (!bool.booleanValue()) {
                    Context context = SplashActivity.this.f;
                    w.P0(context, context.getResources().getString(a7.j.h2));
                    SplashActivity.this.startActivity(m7.a.s.booleanValue() ? new Intent(SplashActivity.this, MultiUserActivity.class) : new Intent(SplashActivity.this, RoutingActivity.class));
                    SplashActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                    SplashActivity.this.finish();
                    return;
                }
                SplashActivity.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{SplashActivity.this.f.getFilesDir() + "/data_temp.txt"});
            } catch (Exception unused) {
                Context context2 = SplashActivity.this.f;
                w.P0(context2, context2.getResources().getString(a7.j.h2));
                SplashActivity.this.startActivity(m7.a.s.booleanValue() ? new Intent(SplashActivity.this, MultiUserActivity.class) : new Intent(SplashActivity.this, RoutingActivity.class));
                SplashActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                SplashActivity.this.finish();
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(String... strArr) {
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ j(SplashActivity splashActivity, c cVar) {
            this();
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
                SplashActivity.this.y1();
                return;
            }
            SplashActivity splashActivity = SplashActivity.this;
            i iVar = splashActivity.new i(splashActivity.f);
            iVar.setCancelable(false);
            iVar.show();
        }
    }

    public class l extends AsyncTask {
        public l() {
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
                new m(SplashActivity.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{SplashActivity.T1(SplashActivity.this)});
                return;
            }
            SplashActivity splashActivity = SplashActivity.this;
            i iVar = splashActivity.new i(splashActivity.f);
            iVar.setCancelable(false);
            iVar.show();
        }

        public void onPreExecute() {
            super.onPreExecute();
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
                new j(SplashActivity.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{SplashActivity.T1(SplashActivity.this)});
                return;
            }
            Context context = SplashActivity.this.f;
            w.P0(context, context.getResources().getString(a7.j.h2));
            SplashActivity.this.startActivity(m7.a.s.booleanValue() ? new Intent(SplashActivity.this, MultiUserActivity.class) : new Intent(SplashActivity.this, RoutingActivity.class));
            SplashActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
            SplashActivity.this.finish();
        }

        public void onPreExecute() {
        }

        public /* synthetic */ m(SplashActivity splashActivity, c cVar) {
            this();
        }
    }

    public class n extends AsyncTask {
        public n() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                SplashActivity.Q1(SplashActivity.this, new FileInputStream(new File(strArr[0])));
                SplashActivity splashActivity = SplashActivity.this;
                return splashActivity.Y.c(SplashActivity.P1(splashActivity), SplashActivity.this.f);
            } catch (Exception unused) {
                return "";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (str.equals("")) {
                    Context context = SplashActivity.this.f;
                    Toast.makeText(context, context.getResources().getString(a7.j.a8), 1).show();
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, MultiUserActivity.class));
                    SplashActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                    SplashActivity.this.finish();
                } else {
                    SplashActivity.R1(SplashActivity.this, str);
                    SplashActivity.S1(SplashActivity.this);
                }
            } catch (Exception unused) {
                Context context2 = SplashActivity.this.f;
                Toast.makeText(context2, context2.getResources().getString(a7.j.h2), 0).show();
                SplashActivity.this.startActivity(m7.a.s.booleanValue() ? new Intent(SplashActivity.this, MultiUserActivity.class) : new Intent(SplashActivity.this, RoutingActivity.class));
                SplashActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                SplashActivity.this.finish();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ SharedPreferences.Editor A1(SplashActivity splashActivity) {
        return splashActivity.I;
    }

    private void A2(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            startActivity(new Intent(this, MultiUserActivity.class));
            finish();
            b();
            Toast.makeText(this, this.f.getResources().getString(a7.j.D2), 0).show();
            return;
        }
        try {
            String trim = ((String) arrayList.get(0)).trim();
            this.h0 = trim;
            if (!trim.startsWith("http://") && !this.h0.startsWith("https://")) {
                this.h0 = "http://" + this.h0;
            }
            if (!this.h0.endsWith("/")) {
                this.h0 += "/";
            }
            this.A.putString(m7.a.L, this.h0);
            this.A.apply();
            arrayList.remove(0);
            x1(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ SharedPreferences.Editor B1(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.I = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor C1(SplashActivity splashActivity) {
        return splashActivity.J;
    }

    public static /* synthetic */ SharedPreferences.Editor D1(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.J = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor E1(SplashActivity splashActivity) {
        return splashActivity.L;
    }

    public static /* synthetic */ SharedPreferences.Editor F1(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.L = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor G1(SplashActivity splashActivity) {
        return splashActivity.M;
    }

    public static /* synthetic */ SharedPreferences.Editor H1(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.M = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences I1(SplashActivity splashActivity) {
        return splashActivity.N;
    }

    public static /* synthetic */ SharedPreferences J1(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.N = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor K1(SplashActivity splashActivity) {
        return splashActivity.O;
    }

    public static /* synthetic */ SharedPreferences.Editor L1(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.O = editor;
        return editor;
    }

    public static /* synthetic */ LiveStreamDBHandler M1(SplashActivity splashActivity) {
        return splashActivity.P;
    }

    public static /* synthetic */ u7.a N1(SplashActivity splashActivity) {
        return splashActivity.n;
    }

    public static /* synthetic */ void O1(SplashActivity splashActivity, String str) {
        splashActivity.m2(str);
    }

    public static /* synthetic */ InputStream P1(SplashActivity splashActivity) {
        return splashActivity.X;
    }

    public static /* synthetic */ InputStream Q1(SplashActivity splashActivity, InputStream inputStream) {
        splashActivity.X = inputStream;
        return inputStream;
    }

    public static /* synthetic */ String R1(SplashActivity splashActivity, String str) {
        splashActivity.Z = str;
        return str;
    }

    public static /* synthetic */ void S1(SplashActivity splashActivity) {
        splashActivity.h2();
    }

    public static /* synthetic */ String T1(SplashActivity splashActivity) {
        return splashActivity.U;
    }

    public static /* synthetic */ String U1(SplashActivity splashActivity) {
        return splashActivity.t;
    }

    public static /* synthetic */ SharedPreferences V1(SplashActivity splashActivity) {
        return splashActivity.D;
    }

    public static /* synthetic */ SharedPreferences W1(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.D = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences X1(SplashActivity splashActivity) {
        return splashActivity.E;
    }

    public static /* synthetic */ SharedPreferences Y1(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.E = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences Z1(SplashActivity splashActivity) {
        return splashActivity.F;
    }

    public static /* synthetic */ SharedPreferences a2(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.F = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences b2(SplashActivity splashActivity) {
        return splashActivity.G;
    }

    public static /* synthetic */ SharedPreferences c2(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.G = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences d2(SplashActivity splashActivity) {
        return splashActivity.H;
    }

    public static /* synthetic */ SharedPreferences e2(SplashActivity splashActivity, SharedPreferences sharedPreferences) {
        splashActivity.H = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor f2(SplashActivity splashActivity) {
        return splashActivity.K;
    }

    public static /* synthetic */ SharedPreferences.Editor g2(SplashActivity splashActivity, SharedPreferences.Editor editor) {
        splashActivity.K = editor;
        return editor;
    }

    private void h2() {
        Activity activity;
        try {
            if (this.P.getImportTableCount("m3u") == 0) {
                ArrayList arrayList = new ArrayList();
                ImportStatusModel importStatusModel = new ImportStatusModel();
                importStatusModel.setType("all");
                importStatusModel.setStatus("0");
                importStatusModel.setDate("");
                arrayList.add(0, importStatusModel);
                this.P.importDataStatusArrayList(arrayList, "m3u");
            }
            ImportStatusModel importStatusModel2 = this.P.getdateDBStatus("all");
            if (importStatusModel2 != null) {
                if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("0")) && (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("2"))) {
                    if (importStatusModel2.getStatus() != null && importStatusModel2.getStatus().equals("1")) {
                        long C = w.C(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel2.getDate(), w.q());
                        if (!l2() || C < this.n.g()) {
                            this.f.startActivity(new Intent(this.f, NewDashboardActivity.class));
                            activity = (Activity) this.f;
                        } else {
                            this.f.startActivity(new Intent(this.f, ImportM3uActivity.class));
                            activity = (Activity) this.f;
                        }
                    } else {
                        if (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("3")) {
                            return;
                        }
                        this.f.startActivity(new Intent(this.f, ImportM3uActivity.class));
                        activity = this.f;
                    }
                } else {
                    if (this.f == null) {
                        return;
                    }
                    this.f.startActivity(new Intent(this.f, ImportM3uActivity.class));
                    activity = (Activity) this.f;
                }
                activity.finish();
            }
        } catch (Exception unused) {
            Context context = this.f;
            Toast.makeText(context, context.getResources().getString(a7.j.h2), 0).show();
            startActivity(m7.a.s.booleanValue() ? new Intent(this, MultiUserActivity.class) : new Intent(this, RoutingActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            finish();
        }
    }

    private static String j2(String str) {
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

    private void k2() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static String n2() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return j2(str2);
        }
        return j2(str) + " " + str2;
    }

    public static /* synthetic */ void s2(Task task) {
        if (task.isSuccessful()) {
            return;
        }
        Log.e("TAG", task.toString());
    }

    public static String t2(String str) {
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

    public static /* synthetic */ void u1(Task task) {
        s2(task);
    }

    private void x1(ArrayList arrayList) {
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.f);
        String string = this.f.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "");
        this.h0 = string;
        this.h0 = string.toLowerCase();
        Log.e("URl from Back", ">>>>>>>>" + this.h0);
        if (!this.h0.startsWith("http://") && !this.h0.startsWith("https://")) {
            this.h0 = "http://" + this.h0;
        }
        if (this.h0.endsWith("/")) {
            return;
        }
        this.h0 += "/";
    }

    private void x2(String str) {
        if (str != null && !str.equals("") && !str.isEmpty()) {
            this.R = new ArrayList(Arrays.asList(str.split(",")));
        }
        ArrayList arrayList = this.R;
        if (arrayList == null || arrayList.size() < 1) {
            ArrayList arrayList2 = this.R;
            if (arrayList2 == null || arrayList2.size() != 0) {
                return;
            }
            Toast.makeText(this, this.f.getResources().getString(a7.j.l5), 0).show();
            return;
        }
        try {
            this.A.putString(m7.a.L, ((String) this.R.get(0)).trim());
            this.A.commit();
            this.R.remove(0);
            this.W.h(this.s, this.t, this.R);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ int z1(SplashActivity splashActivity, int i2) {
        splashActivity.V = i2;
        return i2;
    }

    public void B2() {
        this.m.setVisibility(8);
        this.k.setVisibility(0);
        this.j.setVisibility(0);
    }

    public void C2() {
        this.m.setVisibility(0);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
        if (stalkerTokenCallback == null || stalkerTokenCallback.getJs() == null || stalkerTokenCallback.getJs().getToken() == null) {
            w.P0(this.f, "Error Code 100: Something went wrong!");
            b();
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            finish();
            return;
        }
        String token = stalkerTokenCallback.getJs().getToken();
        SharepreferenceDBHandler.setStalkerToken(token, this.f);
        n7.e eVar = this.f0;
        if (eVar == null) {
            w.P0(this.f, "Error Code 101: Invalid Details");
            b();
        } else {
            try {
                eVar.q(this.g0, token);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void H(String str) {
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
    }

    public void P0(String str) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
        startActivity(new Intent(this, NewDashboardActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
        if (stalkerProfilesCallback == null || stalkerProfilesCallback.getJs() == null || stalkerProfilesCallback.getJs().getId() == null || stalkerProfilesCallback.getJs().getPassword().equals("")) {
            return;
        }
        try {
            SharedPreferences.Editor edit = getSharedPreferences("loginPrefs", 0).edit();
            edit.putString("serverTimeZone", stalkerProfilesCallback.getJs().getDefaultTimezone());
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public void b() {
    }

    public void b0(int i2) {
        if (this.f != null) {
            if (!m7.a.W0.booleanValue()) {
                w2();
            } else {
                MyApplication.p().G(this.f, new h(SharepreferenceDBHandler.getClientSecurityUrl(this.f)));
            }
        }
    }

    public void c(String str) {
        startActivity(new Intent(this, MultiUserActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
    }

    public void d(String str) {
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void h0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            startActivity(new Intent(this, MultiUserActivity.class));
            finish();
            w.P0(this.f, "Your Account is invalid or has expired !");
            return;
        }
        try {
            this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.A.apply();
            arrayList.remove(0);
            this.W.h(this.s, this.t, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i2() {
        try {
            this.q = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public boolean l2() {
        return this.f.getSharedPreferences("automation_channels", 0).getString("automation_channels", "").equals("checked");
    }

    public void m(LoginCallback loginCallback, String str) {
        int i2;
        String string;
        Class cls;
        int i3;
        if (this.f != null) {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null) {
                startActivity(new Intent(this, NewDashboardActivity.class));
                finish();
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
                        cls = NewDashboardActivity.class;
                        i3 = 0;
                    } else {
                        cls = NewDashboardActivity.class;
                        i3 = 0;
                    }
                    this.f.getSharedPreferences("loginPrefsserverurl", i3).getString(m7.a.L, "").toLowerCase();
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
                    this.D = this.f.getSharedPreferences("allowedFormat", 0);
                    this.E = this.f.getSharedPreferences("timeFormat", 0);
                    this.F = this.f.getSharedPreferences("epgchannelupdate", 0);
                    this.G = this.f.getSharedPreferences("automation_channels", 0);
                    this.H = this.f.getSharedPreferences("automation_epg", 0);
                    this.K = this.D.edit();
                    this.I = this.E.edit();
                    this.J = this.F.edit();
                    this.L = this.G.edit();
                    this.M = this.H.edit();
                    SharedPreferences sharedPreferences = this.f.getSharedPreferences("auto_start", 0);
                    this.N = sharedPreferences;
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    this.O = edit2;
                    if (edit2 != null) {
                        edit2.putBoolean("full_epg", true);
                        this.O.apply();
                    }
                    if (this.G.getString("automation_channels", "").equals("")) {
                        this.L.putString("automation_channels", "checked");
                        this.L.apply();
                    }
                    if (this.H.getString("automation_epg", "").equals("")) {
                        this.M.putString("automation_epg", "checked");
                        this.M.apply();
                    }
                    m7.a.c0 = Boolean.FALSE;
                    if (this.D.getString("allowedFormat", "").equals("")) {
                        this.K.putString("allowedFormat", "ts");
                        this.K.apply();
                    }
                    if (this.E.getString("timeFormat", m7.a.E0).equals("")) {
                        this.I.putString("timeFormat", m7.a.E0);
                        this.I.apply();
                    }
                    if (this.F.getString("epgchannelupdate", "").equals("")) {
                        this.J.putString("epgchannelupdate", "all");
                        this.J.apply();
                    }
                    startActivity(new Intent(this, cls));
                    finish();
                    return;
                }
                startActivity(new Intent(this, NewDashboardActivity.class));
                finish();
                string = getResources().getString(a7.j.H2) + status;
                i2 = 0;
            } else {
                i2 = 0;
                startActivity(new Intent(this, NewDashboardActivity.class));
                finish();
                string = getResources().getString(a7.j.D2);
            }
            Toast.makeText(this, string, i2).show();
        }
    }

    public final void m2(String str) {
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.f);
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.f);
        m7.a.Z = str;
        j1.a.a(str + "play/b2c/v1/user-info?token=" + oneStreamToken).t("test").s(k1.e.MEDIUM).q().o(new b());
    }

    public void o0(String str) {
    }

    public void o2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        this.f = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        try {
            startService(new Intent(getBaseContext(), StopProcessingTasksService.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        o2();
        m7.a.l = Boolean.TRUE;
        setContentView(a7.g.Z0);
        if (!m7.a.o.booleanValue()) {
            i2();
            v1();
            n2();
            w1();
        }
        Log.d("DeviceTypeRuntimeCheck", ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4 ? "Running on a TV Device" : "Running on a non-TV Device");
        this.f0 = new n7.e(this, this.f);
        this.n = new u7.a(this.f);
        b7.g.c = new b7.g(this);
        this.m = findViewById(a7.f.Hm);
        this.e0 = findViewById(a7.f.qa);
        if (m7.a.o.booleanValue()) {
            this.e0.setVisibility(0);
        } else {
            this.e0.setVisibility(8);
        }
        findViewById(a7.f.cb).setSystemUiVisibility(4871);
        this.j = findViewById(a7.f.d6);
        this.k = findViewById(a7.f.A5);
        this.P = new LiveStreamDBHandler(this.f);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreference", 0);
        this.Q = sharedPreferences;
        this.C = sharedPreferences.edit();
        this.d = getSharedPreferences("loginPrefs", 0);
        SharedPreferences sharedPreferences2 = getSharedPreferences("sharedprefremberme", 0);
        this.y = sharedPreferences2;
        this.x = Boolean.valueOf(sharedPreferences2.getBoolean("savelogin", true));
        SharedPreferences sharedPreferences3 = getSharedPreferences("loginPrefsserverurl", 0);
        this.z = sharedPreferences3;
        this.A = sharedPreferences3.edit();
        this.e = getSharedPreferences("selected_language", 0);
        this.B = this.y.edit();
        String string = this.e.getString("selected_language", "");
        if (!string.equals("")) {
            w.J0(this.f, string);
        }
        this.W = new n7.d(this, this.f);
        this.g = new MultiUserDBHandler(this.f);
        if (SharepreferenceDBHandler.getisAutoPlayVideos(this.f)) {
            SharepreferenceDBHandler.setisAutoPlayVideos(true, this.f);
        }
        FirebaseMessaging.f().y("all").addOnCompleteListener(new k1());
        if (m7.a.G.booleanValue()) {
            try {
                C2();
            } catch (Exception unused) {
                B2();
                this.V = 1500;
                p2();
            }
            this.m.setOnCompletionListener(new c());
            this.m.setOnPreparedListener(new d());
        } else {
            B2();
            this.V = 1500;
            p2();
        }
        k2();
        b7.f.g(this, "Kb4ca3fc171069dfdbfe5e0beaf2b8282");
        b7.f.f(this, "Kb4ca3fc171069dfdbfe5e0beaf2b8282");
        b7.f.h(this, "NB!@#12ZKWd");
        this.e = getSharedPreferences("selected_language", 0);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        String string = this.e.getString("selected_language", "");
        if (string.equals("")) {
            return;
        }
        w.J0(this.f, string);
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        o2();
    }

    public void p2() {
        Handler handler;
        Runnable gVar;
        if (m7.a.o.booleanValue()) {
            this.g0 = SharepreferenceDBHandler.getLoggedInMacAddress(this.f);
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api") || this.g0.equals("")) {
                handler = new Handler();
                gVar = new e();
                handler.postDelayed(gVar, this.V);
                return;
            }
            q2();
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("serverUrl", "");
                this.U = string;
                if (string == null || string.equals("")) {
                    handler = new Handler();
                    gVar = new f();
                    handler.postDelayed(gVar, this.V);
                    return;
                }
                q2();
            }
            return;
        }
        SharedPreferences sharedPreferences2 = this.d;
        if (sharedPreferences2 != null) {
            String string2 = sharedPreferences2.getString("username", "");
            String string3 = this.d.getString("password", "");
            if (string2 == null || string3 == null || string2.equals("") || string3.equals("") || m7.a.n.booleanValue()) {
                handler = new Handler();
                gVar = new g();
                handler.postDelayed(gVar, this.V);
                return;
            }
        }
        q2();
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x02af, code lost:
    
        if (m7.a.s.booleanValue() != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03ca, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r15.f).equals("onestream_api") != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03cc, code lost:
    
        v2(true, false, false, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03d7, code lost:
    
        v2(false, false, false, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ec, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r15.f).equals("onestream_api") != false) goto L161;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q2() {
        /*
            Method dump skipped, instructions count: 1110
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SplashActivity.q2():void");
    }

    public boolean r2() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i2 >= 33) {
            return true;
        }
        if (j1.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c3, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r9.f).equals("onestream_api") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0217, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r9.f).equals("onestream_api") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x022d, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r9.f).equals("onestream_api") != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0265, code lost:
    
        r4 = false;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0261, code lost:
    
        r4 = false;
        r5 = false;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x025f, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r9.f).equals("onestream_api") != false) goto L79;
     */
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K0(java.lang.String r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SplashActivity.K0(java.lang.String, int, boolean):void");
    }

    public void v0(String str) {
    }

    public void v1() {
        this.p = Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public final void v2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intent intent = z ? new Intent(this, LoginActivityOneStream.class) : z2 ? new Intent(this, NewDashboardActivity.class) : z3 ? new Intent(this, MultiUserActivity.class) : z4 ? new Intent(this, RoutingActivity.class) : z5 ? new Intent(this, LoginActivity.class) : null;
        if (intent != null) {
            startActivity(intent);
            overridePendingTransition(a7.b.f, a7.b.d);
            finish();
        }
    }

    public void w0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            startActivity(new Intent(this, MultiUserActivity.class));
            finish();
            w.P0(this.f, "Your Account is invalid or has expired !");
            return;
        }
        try {
            this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.A.apply();
            arrayList.remove(0);
            this.W.h(this.s, this.t, arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void w1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.r = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void w2() {
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                String str = this.T;
                if (str == null || !str.equals("file")) {
                    String str2 = this.T;
                    if (str2 != null && str2.equals("url")) {
                        new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.f.getFilesDir() + "/data_temp.txt"});
                    }
                } else {
                    new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.U});
                }
            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                try {
                    m7.h hVar = new m7.h(this.f, this);
                    hVar.s("", this.s, this.t, "", false, true);
                    hVar.v();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                this.W.g(this.s, this.t);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void y(LoginCallback loginCallback, String str, ArrayList arrayList) {
        Intent intent;
        try {
            if (loginCallback.getUserLoginInfo() == null || loginCallback.getServerInfo() == null) {
                if (arrayList == null || arrayList.size() <= 0) {
                    intent = new Intent(this, MultiUserActivity.class);
                    startActivity(intent);
                    finish();
                    w.P0(this.f, "Your Account is invalid or has expired !");
                    return;
                }
                this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                this.A.apply();
                arrayList.remove(0);
                this.W.h(this.s, this.t, arrayList);
                return;
            }
            if (loginCallback.getUserLoginInfo() == null) {
                if (arrayList == null || arrayList.size() <= 0) {
                    intent = new Intent(this, MultiUserActivity.class);
                    startActivity(intent);
                    finish();
                    w.P0(this.f, "Your Account is invalid or has expired !");
                    return;
                }
                this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                this.A.apply();
                arrayList.remove(0);
                this.W.h(this.s, this.t, arrayList);
                return;
            }
            if (loginCallback.getUserLoginInfo().getAuth().intValue() != 1) {
                if (arrayList == null || arrayList.size() <= 0) {
                    intent = new Intent(this, MultiUserActivity.class);
                    startActivity(intent);
                    finish();
                    w.P0(this.f, "Your Account is invalid or has expired !");
                    return;
                }
                this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                this.A.apply();
                arrayList.remove(0);
                this.W.h(this.s, this.t, arrayList);
                return;
            }
            if (!loginCallback.getUserLoginInfo().getStatus().equals("Active")) {
                if (arrayList == null || arrayList.size() <= 0) {
                    intent = new Intent(this, MultiUserActivity.class);
                    startActivity(intent);
                    finish();
                    w.P0(this.f, "Your Account is invalid or has expired !");
                    return;
                }
                this.A.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                this.A.apply();
                arrayList.remove(0);
                this.W.h(this.s, this.t, arrayList);
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
            this.f.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
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
            this.D = this.f.getSharedPreferences("allowedFormat", 0);
            this.E = this.f.getSharedPreferences("timeFormat", 0);
            this.F = this.f.getSharedPreferences("epgchannelupdate", 0);
            this.G = this.f.getSharedPreferences("automation_channels", 0);
            this.H = this.f.getSharedPreferences("automation_epg", 0);
            this.K = this.D.edit();
            this.I = this.E.edit();
            this.J = this.F.edit();
            this.L = this.G.edit();
            this.M = this.H.edit();
            SharedPreferences sharedPreferences = this.f.getSharedPreferences("auto_start", 0);
            this.N = sharedPreferences;
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            this.O = edit2;
            if (edit2 != null) {
                edit2.putBoolean("full_epg", true);
                this.O.apply();
            }
            if (this.G.getString("automation_channels", "").equals("")) {
                this.L.putString("automation_channels", "checked");
                this.L.apply();
            }
            if (this.H.getString("automation_epg", "").equals("")) {
                this.M.putString("automation_epg", "checked");
                this.M.apply();
            }
            m7.a.c0 = Boolean.FALSE;
            if (this.D.getString("allowedFormat", "").equals("")) {
                this.K.putString("allowedFormat", "ts");
                this.K.apply();
            }
            if (this.E.getString("timeFormat", m7.a.E0).equals("")) {
                this.I.putString("timeFormat", m7.a.E0);
                this.I.apply();
            }
            if (this.F.getString("epgchannelupdate", "").equals("")) {
                this.J.putString("epgchannelupdate", "all");
                this.J.apply();
            }
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void y0(String str) {
    }

    public void y1() {
        StringBuilder sb;
        List list;
        b7.e a2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
            sb = new StringBuilder();
            sb.append(b7.f.c(this));
            sb.append("*");
            sb.append(b7.f.d(this));
            sb.append("-");
            sb.append("playlist");
        } else {
            sb = new StringBuilder();
            sb.append(b7.f.c(this));
            sb.append("*");
            sb.append(b7.f.d(this));
            sb.append("-");
            sb.append(this.s);
        }
        sb.append("-");
        sb.append(b7.b.b);
        sb.append("-");
        sb.append(this.q);
        sb.append("-unknown-");
        sb.append(n2());
        sb.append("-");
        sb.append(this.p);
        this.o = t2(sb.toString());
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this)));
        b7.g.b.add(b7.g.a("sc", this.o));
        if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
            list = b7.g.b;
            a2 = b7.g.a("u", "playlist");
        } else {
            list = b7.g.b;
            a2 = b7.g.a("u", this.s);
        }
        list.add(a2);
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", this.q));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", n2()));
        b7.g.b.add(b7.g.a("do", this.p));
        b7.g.c.b(this);
    }

    public final void y2(String str) {
        ArrayList arrayList;
        if (!m7.a.o.booleanValue()) {
            if (str != null && !str.isEmpty()) {
                arrayList = new ArrayList(Arrays.asList(str.split(",")));
            }
            A2(this.R);
        }
        arrayList = new ArrayList();
        arrayList.add(str);
        this.R = arrayList;
        A2(this.R);
    }

    public final void z2(String str) {
        m7.a.Z = str;
        j1.a.b(str + "play/b2c/v1/auth").s("username", this.s).s("password", this.t).w("test").t("Content-Type", "FormUrlEncoded").v(k1.e.MEDIUM).u().o(new a(str));
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
