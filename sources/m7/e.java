package m7;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.ImportM3uActivity;
import com.nst.iptvsmarterstvbox.view.activity.ImportOneStreamActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public Context a;
    public String b;
    public u7.a c;
    public String d = "";
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    public class a implements p1.c {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void a(JSONObject jSONObject) {
            Log.e("AUTH_API", String.valueOf(jSONObject));
            try {
                String string = jSONObject.getString("auth_token");
                if (string.isEmpty()) {
                    Log.e("AUTHAPI", "AUTHTOKEN IS EMPTY");
                    e.q(e.this, this.a);
                } else {
                    if (e.b(e.this) != null) {
                        SharepreferenceDBHandler.setFirebaseOneStreamNode(e.r(e.this), e.b(e.this));
                        SharepreferenceDBHandler.setOneStreamToken(string, e.b(e.this));
                    }
                    e.s(e.this, this.a);
                }
            } catch (Exception e) {
                e.q(e.this, this.a);
                e.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            e.q(e.this, this.a);
        }
    }

    public class b implements p1.c {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            Intent intent;
            Context b;
            Log.e("AUTH_API", String.valueOf(jSONObject));
            if (jSONObject == null) {
                e.q(e.this, this.a);
            } else {
                try {
                    jSONObject2 = new JSONObject(String.valueOf(jSONObject)).getJSONObject("user_info");
                } catch (JSONException e) {
                    e = e;
                }
                if (jSONObject2 != null) {
                    e.d(e.this, jSONObject2.getString("auth"));
                    if (e.c(e.this) != null && Integer.valueOf(e.c(e.this)).intValue() != 0) {
                        e.f(e.this, jSONObject2.getString("status"));
                        if (e.e(e.this) != null && e.e(e.this).equals("Active")) {
                            JSONObject jSONObject3 = new JSONObject(String.valueOf(jSONObject));
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("user_info");
                            jSONObject4.getString("username");
                            jSONObject4.getString("message");
                            String string = jSONObject4.getString("expire_at");
                            String string2 = jSONObject4.getString("active_connections");
                            String string3 = jSONObject4.getString("created_at");
                            String string4 = jSONObject4.getString("max_connections");
                            jSONObject4.getJSONArray("allowed_output_formats");
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("server_info");
                            jSONObject5.getString("time_now");
                            String string5 = jSONObject5.getString("timezone");
                            try {
                            } catch (JSONException e2) {
                                e = e2;
                            }
                            if (e.e(e.this) == null || !e.e(e.this).equals("Active")) {
                                if (e.b(e.this) != null) {
                                    Toast.makeText(e.b(e.this).getApplicationContext(), e.b(e.this).getResources().getString(a7.j.H2) + e.e(e.this), 0).show();
                                    return;
                                }
                                return;
                            }
                            if (e.b(e.this) != null) {
                                e.b(e.this).getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                                SharedPreferences.Editor edit = e.b(e.this).getSharedPreferences("loginPrefs", 0).edit();
                                edit.putString("username", e.g(e.this));
                                edit.putString("password", e.h(e.this));
                                edit.putString("auth", e.c(e.this));
                                edit.putString("status", e.e(e.this));
                                edit.putString("expDate", string);
                                edit.putString("activeCons", string2);
                                edit.putString("createdAt", string3);
                                edit.putString("maxConnections", string4);
                                edit.putString("serverTimeZone", string5);
                                edit.apply();
                                SharedPreferences sharedPreferences = e.b(e.this).getSharedPreferences("allowedFormat", 0);
                                SharedPreferences sharedPreferences2 = e.b(e.this).getSharedPreferences("timeFormat", 0);
                                SharedPreferences sharedPreferences3 = e.b(e.this).getSharedPreferences("epgchannelupdate", 0);
                                SharedPreferences sharedPreferences4 = e.b(e.this).getSharedPreferences("automation_channels", 0);
                                SharedPreferences sharedPreferences5 = e.b(e.this).getSharedPreferences("automation_epg", 0);
                                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                                SharedPreferences.Editor edit3 = sharedPreferences2.edit();
                                SharedPreferences.Editor edit4 = sharedPreferences3.edit();
                                SharedPreferences.Editor edit5 = sharedPreferences4.edit();
                                SharedPreferences.Editor edit6 = sharedPreferences5.edit();
                                try {
                                    SharedPreferences.Editor edit7 = e.b(e.this).getSharedPreferences("auto_start", 0).edit();
                                    if (edit7 != null) {
                                        edit7.putBoolean("full_epg", true);
                                        edit7.apply();
                                    }
                                    if (sharedPreferences4.getString("automation_channels", "").equals("")) {
                                        edit5.putString("automation_channels", "checked");
                                        edit5.apply();
                                    }
                                    if (sharedPreferences5.getString("automation_epg", "").equals("")) {
                                        edit6.putString("automation_epg", "checked");
                                        edit6.apply();
                                    }
                                    m7.a.c0 = Boolean.FALSE;
                                    if (sharedPreferences.getString("allowedFormat", "").equals("")) {
                                        edit2.putString("allowedFormat", "ts");
                                        edit2.apply();
                                    }
                                    if (sharedPreferences2.getString("timeFormat", m7.a.E0).equals("")) {
                                        edit3.putString("timeFormat", m7.a.E0);
                                        edit3.apply();
                                    }
                                    if (sharedPreferences3.getString("epgchannelupdate", "").equals("")) {
                                        edit4.putString("epgchannelupdate", "all");
                                        edit4.apply();
                                    }
                                    MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(e.b(e.this));
                                    LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(e.b(e.this));
                                    if (!multiUserDBHandler.checkregistration(e.i(e.this), e.g(e.this), e.h(e.this), e.r(e.this), "onestream_api", e.r(e.this), "")) {
                                        multiUserDBHandler.addmultiusers(e.i(e.this), e.g(e.this), e.h(e.this), m7.a.Z, "", "onestream_api");
                                        try {
                                            Toast.makeText(e.b(e.this).getApplicationContext(), e.b(e.this).getResources().getString(a7.j.r8), 0).show();
                                        } catch (WindowManager.BadTokenException e3) {
                                            e3.printStackTrace();
                                        }
                                        SharedPreferences.Editor edit8 = e.b(e.this).getSharedPreferences("loginprefsmultiuser", 0).edit();
                                        edit8.putString("name", e.i(e.this));
                                        edit8.putString("username", e.g(e.this));
                                        edit8.putString("password", e.h(e.this));
                                        edit8.putString(m7.a.L, e.r(e.this));
                                        edit8.putString("expDate", string);
                                        edit8.apply();
                                        Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(a7.j.b3), 0).show();
                                        SharepreferenceDBHandler.setUserID(multiUserDBHandler.getAutoIdLoggedInUser(e.i(e.this), e.g(e.this), e.h(e.this), e.r(e.this), "onestream_api", e.r(e.this), ""), e.b(e.this));
                                        e.b(e.this).startActivity(new Intent(e.b(e.this).getApplicationContext(), ImportOneStreamActivity.class));
                                        return;
                                    }
                                    try {
                                        Toast.makeText(e.b(e.this).getApplicationContext(), e.b(e.this).getString(a7.j.D) + e.i(e.this) + e.b(e.this).getString(a7.j.u8) + e.g(e.this) + e.b(e.this).getString(a7.j.F) + m7.a.Z, 0).show();
                                    } catch (WindowManager.BadTokenException e4) {
                                        e4.printStackTrace();
                                    }
                                    SharedPreferences sharedPreferences6 = e.b(e.this).getSharedPreferences("loginprefsmultiuser", 0);
                                    SharedPreferences.Editor edit9 = sharedPreferences6.edit();
                                    edit9.putString("name", e.i(e.this));
                                    edit9.putString("username", e.g(e.this));
                                    edit9.putString("password", e.h(e.this));
                                    edit9.putString(m7.a.L, e.r(e.this));
                                    edit9.putString("expDate", string);
                                    edit9.apply();
                                    Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(a7.j.b3), 0).show();
                                    ImportStatusModel importStatusModel = liveStreamDBHandler.getdateDBStatus("onestream_api");
                                    if (importStatusModel == null) {
                                        intent = new Intent(e.b(e.this), ImportOneStreamActivity.class);
                                        b = e.b(e.this);
                                    } else if ((importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("0")) || (importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("2"))) {
                                        intent = new Intent(e.b(e.this), ImportOneStreamActivity.class);
                                        b = e.b(e.this);
                                    } else if (importStatusModel.getStatus() != null && importStatusModel.getStatus().equals("1")) {
                                        long j = e.j(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel.getDate(), w.q());
                                        if (!e.this.u() || j < e.k(e.this).g()) {
                                            sharedPreferences6.edit().putString("name", e.i(e.this));
                                            edit9.apply();
                                            m7.a.m = e.i(e.this);
                                            intent = new Intent(e.b(e.this), NewDashboardActivity.class);
                                            b = e.b(e.this);
                                        } else {
                                            intent = new Intent(e.b(e.this), ImportOneStreamActivity.class);
                                            b = e.b(e.this);
                                        }
                                    } else {
                                        if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("3")) {
                                            return;
                                        }
                                        intent = new Intent(e.b(e.this), ImportOneStreamActivity.class);
                                        b = e.b(e.this);
                                    }
                                    b.startActivity(intent);
                                    return;
                                } catch (JSONException e5) {
                                    e = e5;
                                }
                                e = e2;
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                }
                e.q(e.this, this.a);
            }
        }

        public void b(m1.a aVar) {
            Log.e("INFO_API", String.valueOf(aVar));
            if (e.b(e.this) != null) {
                Toast.makeText(e.b(e.this).getApplicationContext(), e.b(e.this).getResources().getString(a7.j.D2), 0).show();
            }
        }
    }

    public class c extends Dialog implements View.OnClickListener {
        public Activity a;
        public String c;
        public String d;
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
                            b = c.b(c.this);
                        }
                    } else {
                        b = c.a(c.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = c.b(c.this);
                        }
                    } else {
                        b = c.a(c.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public c(Activity activity, String str, String str2) {
            super(activity);
            this.c = str;
            this.d = str2;
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(c cVar) {
            return cVar.g;
        }

        public static /* synthetic */ LinearLayout b(c cVar) {
            return cVar.h;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.s1) {
                    dismiss();
                    if (e.l(e.this).equalsIgnoreCase("m3u")) {
                        if (this.c.equalsIgnoreCase("file")) {
                            e eVar = e.this;
                            eVar.y("", false, e.n(eVar));
                        } else {
                            e eVar2 = e.this;
                            eVar2.y(this.d, true, e.n(eVar2));
                        }
                    } else if (!e.l(e.this).equalsIgnoreCase("api")) {
                        e.l(e.this).equalsIgnoreCase("onestream_api");
                    }
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
            setContentView(e.k(e.this).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
            this.e = findViewById(a7.f.s1);
            this.f = findViewById(a7.f.X0);
            this.g = findViewById(a7.f.Ia);
            this.h = findViewById(a7.f.V8);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            TextView textView = this.e;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.f;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class d extends AsyncTask {
        public d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(strArr[0]);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(e.b(e.this).getFilesDir() + "/data_temp.txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(e.b(e.this).getFilesDir() + "/data_temp.txt").toString())));
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
                e2.printStackTrace();
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                if (bool.booleanValue()) {
                    e.this.new g(true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{e.b(e.this).getFilesDir() + "/data_temp.txt"});
                } else {
                    w.X();
                    w.P0(e.b(e.this), "Incorrect File/URL");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(String... strArr) {
        }
    }

    public class e extends AsyncTask {
        public e() {
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
                new f(e.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{e.m(e.this)});
                return;
            }
            w.X();
            e eVar = e.this;
            c cVar = eVar.new c(e.b(eVar), "url", e.m(e.this));
            cVar.setCancelable(false);
            cVar.show();
        }

        public void onPreExecute() {
            super.onPreExecute();
            w.N0(e.b(e.this));
        }

        public /* synthetic */ e(e eVar, a aVar) {
            this();
        }
    }

    public class f extends AsyncTask {
        public f() {
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
                new d(e.this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{e.m(e.this)});
            } else {
                w.X();
                w.P0(e.b(e.this), e.b(e.this).getResources().getString(a7.j.h2));
            }
        }

        public /* synthetic */ f(e eVar, a aVar) {
            this();
        }

        public void onPreExecute() {
        }
    }

    public class g extends AsyncTask {
        public final boolean a;
        public final A7.a b = new A7.a();

        public g(boolean z) {
            this.a = z;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return this.b.c(new FileInputStream(new File(strArr[0])), e.b(e.this));
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
                    Toast.makeText(e.b(e.this), e.b(e.this).getResources().getString(a7.j.Z7), 1).show();
                } else {
                    e.o(e.this, str);
                    e.p(e.this, this.a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (this.a) {
                return;
            }
            w.N0(e.b(e.this));
        }
    }

    public e(Context context, String str) {
        this.a = context;
        this.b = str;
        this.c = new u7.a(context);
    }

    public static /* synthetic */ Context b(e eVar) {
        return eVar.a;
    }

    public static /* synthetic */ String c(e eVar) {
        return eVar.l;
    }

    public static /* synthetic */ String d(e eVar, String str) {
        eVar.l = str;
        return str;
    }

    public static /* synthetic */ String e(e eVar) {
        return eVar.m;
    }

    public static /* synthetic */ String f(e eVar, String str) {
        eVar.m = str;
        return str;
    }

    public static /* synthetic */ String g(e eVar) {
        return eVar.i;
    }

    public static /* synthetic */ String h(e eVar) {
        return eVar.j;
    }

    public static /* synthetic */ String i(e eVar) {
        return eVar.k;
    }

    public static /* synthetic */ long j(SimpleDateFormat simpleDateFormat, String str, String str2) {
        return w(simpleDateFormat, str, str2);
    }

    public static /* synthetic */ u7.a k(e eVar) {
        return eVar.c;
    }

    public static /* synthetic */ String l(e eVar) {
        return eVar.b;
    }

    public static /* synthetic */ String m(e eVar) {
        return eVar.e;
    }

    public static /* synthetic */ String n(e eVar) {
        return eVar.g;
    }

    public static /* synthetic */ String o(e eVar, String str) {
        eVar.d = str;
        return str;
    }

    public static /* synthetic */ void p(e eVar, boolean z) {
        eVar.t(z);
    }

    public static /* synthetic */ void q(e eVar, ArrayList arrayList) {
        eVar.x(arrayList);
    }

    public static /* synthetic */ String r(e eVar) {
        return eVar.h;
    }

    public static /* synthetic */ void s(e eVar, ArrayList arrayList) {
        eVar.v(arrayList);
    }

    public static long w(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public final void A(ArrayList arrayList) {
        m7.a.Z = this.h;
        j1.a.b(this.h + "play/b2c/v1/auth").s("username", this.i).s("password", this.j).t("Content-Type", "FormUrlEncoded").v(k1.e.MEDIUM).u().o(new a(arrayList));
    }

    public final void a(ArrayList arrayList) {
        Context context = this.a;
        if (context != null) {
            SharepreferenceDBHandler.setCurrentAPPType("onestream_api", context);
            String string = this.a.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "");
            this.h = string;
            this.h = string.toLowerCase();
            Log.e("jaskirat", "one stream URl from Back in login helper " + this.h);
            if (!this.h.startsWith("http://") && !this.h.startsWith("https://")) {
                this.h = "http://" + this.h;
            }
            if (!this.h.endsWith("/")) {
                this.h += "/";
            }
            A(arrayList);
        }
    }

    public final void t(boolean z) {
        String str;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences sharedPreferences3;
        SharedPreferences sharedPreferences4;
        SharedPreferences sharedPreferences5;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        String str2;
        int autoIdLoggedInUser;
        Context context;
        Activity activity;
        try {
            SharedPreferences.Editor edit6 = this.a.getSharedPreferences("loginPrefs", 0).edit();
            edit6.putString("username", "playlist");
            edit6.putString("password", "playlist");
            edit6.putString("serverPort", "");
            if (z) {
                edit6.putString("serverUrl", this.e);
                str = this.e;
            } else {
                edit6.putString("serverUrl", this.f);
                str = this.f;
            }
            edit6.putString("serverM3UUrl", str);
            edit6.putString("anyName", this.g);
            edit6.apply();
            sharedPreferences = this.a.getSharedPreferences("allowedFormat", 0);
            sharedPreferences2 = this.a.getSharedPreferences("timeFormat", 0);
            sharedPreferences3 = this.a.getSharedPreferences("epgchannelupdate", 0);
            sharedPreferences4 = this.a.getSharedPreferences("automation_channels", 0);
            sharedPreferences5 = this.a.getSharedPreferences("automation_epg", 0);
            edit = sharedPreferences.edit();
            edit2 = sharedPreferences2.edit();
            edit3 = sharedPreferences3.edit();
            edit4 = sharedPreferences4.edit();
            edit5 = sharedPreferences5.edit();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            SharedPreferences.Editor edit7 = this.a.getSharedPreferences("auto_start", 0).edit();
            if (edit7 != null) {
                edit7.putBoolean("full_epg", true);
                edit7.apply();
            }
            String string = sharedPreferences.getString("allowedFormat", "");
            if (string != null && string.equals("")) {
                edit.putString("allowedFormat", "ts");
                edit.apply();
            }
            if (sharedPreferences4.getString("automation_channels", "").equals("")) {
                edit4.putString("automation_channels", "checked");
                edit4.apply();
            }
            if (sharedPreferences5.getString("automation_epg", "").equals("")) {
                edit5.putString("automation_epg", "checked");
                edit5.apply();
            }
            if (sharedPreferences2.getString("timeFormat", m7.a.E0).equals("")) {
                edit2.putString("timeFormat", m7.a.E0);
                edit2.apply();
            }
            if (sharedPreferences3.getString("epgchannelupdate", "").equals("")) {
                edit3.putString("epgchannelupdate", "all");
                edit3.apply();
            }
            m7.a.d0 = Boolean.TRUE;
            SharepreferenceDBHandler.setCurrentAPPType("m3u", this.a);
            MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(this.a);
            LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.a);
            if (z) {
                if (!multiUserDBHandler.checkregistration(this.g, "playlist", "playlist", this.e, "m3u", "", "")) {
                    multiUserDBHandler.addmultiusersM3U(this.g, "playlist", "playlist", this.e, "url");
                    Context context2 = this.a;
                    Toast.makeText(context2, context2.getResources().getString(a7.j.r8), 0).show();
                }
                SharedPreferences.Editor edit8 = this.a.getSharedPreferences("loginprefsmultiuser", 0).edit();
                edit8.putString("name", this.g);
                edit8.putString("username", "playlist");
                edit8.putString("password", "playlist");
                edit8.putString(m7.a.L, this.e);
                edit8.apply();
                if (this.a != null) {
                    autoIdLoggedInUser = multiUserDBHandler.getAutoIdLoggedInUser(this.g, "playlist", "playlist", this.e, "m3u", "", "");
                    context = this.a;
                    SharepreferenceDBHandler.setUserID(autoIdLoggedInUser, context);
                }
            } else {
                if (multiUserDBHandler.checkregistration(this.g, "playlist", "playlist", this.f, "m3u", "", "")) {
                    str2 = "password";
                } else {
                    str2 = "password";
                    multiUserDBHandler.addmultiusersM3U(this.g, "playlist", "playlist", this.f, "file");
                    Context context3 = this.a;
                    Toast.makeText(context3, context3.getResources().getString(a7.j.r8), 0).show();
                }
                SharedPreferences.Editor edit9 = this.a.getSharedPreferences("loginprefsmultiuser", 0).edit();
                edit9.putString("name", this.g);
                edit9.putString("username", "playlist");
                edit9.putString(str2, "playlist");
                edit9.putString(m7.a.L, this.f);
                edit9.apply();
                if (this.a != null) {
                    autoIdLoggedInUser = new MultiUserDBHandler(this.a).getAutoIdLoggedInUser(this.g, "playlist", "playlist", this.f, "m3u", "", "");
                    context = this.a;
                    SharepreferenceDBHandler.setUserID(autoIdLoggedInUser, context);
                }
            }
            w.X();
            String str3 = this.d;
            if (str3 != null && !str3.equals("")) {
                Log.e("jaskirat", "m3uURLGlobal::: " + this.d);
                SharepreferenceDBHandler.setFirebaseM3uNode(this.d, this.a);
            }
            if (liveStreamDBHandler.getImportTableCount("m3u") == 0) {
                ArrayList arrayList = new ArrayList();
                ImportStatusModel importStatusModel = new ImportStatusModel();
                importStatusModel.setType("all");
                importStatusModel.setStatus("0");
                importStatusModel.setDate("");
                arrayList.add(0, importStatusModel);
                liveStreamDBHandler.importDataStatusArrayList(arrayList, "m3u");
            }
            ImportStatusModel importStatusModel2 = liveStreamDBHandler.getdateDBStatus("all");
            if (importStatusModel2 != null) {
                if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("0")) && (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("2"))) {
                    if (importStatusModel2.getStatus() != null && importStatusModel2.getStatus().equals("1")) {
                        long C = w.C(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel2.getDate(), w.q());
                        if (!u() || C < this.c.g()) {
                            this.a.startActivity(new Intent(this.a, NewDashboardActivity.class));
                            activity = (Activity) this.a;
                        } else {
                            this.a.startActivity(new Intent(this.a, ImportM3uActivity.class));
                            activity = (Activity) this.a;
                        }
                    } else {
                        if (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("3")) {
                            return;
                        }
                        this.a.startActivity(new Intent(this.a, ImportM3uActivity.class));
                        activity = this.a;
                    }
                } else {
                    if (this.a == null) {
                        return;
                    }
                    this.a.startActivity(new Intent(this.a, ImportM3uActivity.class));
                    activity = (Activity) this.a;
                }
                activity.finish();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public boolean u() {
        Context context = this.a;
        if (context != null) {
            return context.getSharedPreferences("automation_channels", 0).getString("automation_channels", "").equals("checked");
        }
        return false;
    }

    public final void v(ArrayList arrayList) {
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.a);
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.a);
        m7.a.Z = this.h;
        j1.a.a(this.h + "play/b2c/v1/user-info?token=" + oneStreamToken).s(k1.e.MEDIUM).q().o(new b(arrayList));
    }

    public final void x(ArrayList arrayList) {
        if (this.a != null) {
            if (arrayList == null || arrayList.size() <= 0) {
                Toast.makeText(this.a.getApplicationContext(), this.a.getResources().getString(a7.j.D2), 0).show();
                return;
            }
            try {
                String trim = ((String) arrayList.get(0)).trim();
                this.h = trim;
                if (!trim.startsWith("http://") && !this.h.startsWith("https://")) {
                    this.h = "http://" + this.h;
                }
                if (!this.h.endsWith("/")) {
                    this.h += "/";
                }
                SharedPreferences.Editor edit = this.a.getSharedPreferences("loginPrefsserverurl", 0).edit();
                edit.putString(m7.a.L, this.h);
                edit.apply();
                arrayList.remove(0);
                a(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void y(String str, boolean z, String str2) {
        this.g = str2;
        if (z) {
            this.e = str;
            new e(this, null).execute(new Void[0]);
        } else {
            this.f = str;
            new g(false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.f});
        }
    }

    public void z(ArrayList arrayList, String str, String str2, String str3) {
        this.i = str;
        this.j = str2;
        this.k = str3;
        a(arrayList);
    }
}
