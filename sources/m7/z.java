package m7;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class z implements b7.c, z7.f {
    public Context a;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public Activity h;
    public n7.d i;
    public SharedPreferences.Editor j;
    public SharedPreferences k;
    public ProgressDialog l;
    public boolean m;
    public LiveStreamDBHandler n;
    public RecentWatchDBHandler o;

    public class b extends Dialog implements View.OnClickListener {
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
                            c = b.c(b.this);
                        }
                    } else {
                        c = b.b(b.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            c = b.c(b.this);
                        }
                    } else {
                        c = b.b(b.this);
                    }
                    i = a7.e.o;
                }
                c.setBackgroundResource(i);
            }
        }

        public b(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ void a(b bVar) {
            bVar.d();
        }

        public static /* synthetic */ LinearLayout b(b bVar) {
            return bVar.e;
        }

        public static /* synthetic */ LinearLayout c(b bVar) {
            return bVar.f;
        }

        public final /* synthetic */ void d() {
            new c(z.this, null).execute(new Void[0]);
        }

        public void onClick(View view) {
            int id = view.getId();
            try {
                if (id == a7.f.s1) {
                    new Handler(Looper.getMainLooper()).postDelayed(new A(this), 200L);
                    dismiss();
                } else if (id != a7.f.X0) {
                } else {
                    dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(new u7.a(z.o(z.this)).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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

    public class c extends AsyncTask {
        public c() {
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
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                if (m7.a.o.booleanValue() || m7.a.n.booleanValue()) {
                    z.h(z.this);
                    return;
                } else {
                    z.k(z.this);
                    return;
                }
            }
            z.l(z.this);
            z zVar = z.this;
            b bVar = zVar.new b(z.n(zVar));
            bVar.setCancelable(false);
            bVar.show();
        }

        public /* synthetic */ c(z zVar, a aVar) {
            this();
        }
    }

    public z(Context context, Activity activity) {
        this.a = context;
        this.h = activity;
        this.i = new n7.d(this, context);
        this.n = new LiveStreamDBHandler(context);
        this.o = new RecentWatchDBHandler(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefsserverurl", 0);
        this.k = sharedPreferences;
        this.j = sharedPreferences.edit();
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.l = progressDialog;
        progressDialog.setMessage(context.getResources().getString(a7.j.t5));
        this.l.setCanceledOnTouchOutside(false);
        this.l.setCancelable(false);
        this.l.setProgressStyle(0);
    }

    private void B(String str) {
        ArrayList arrayList = (str == null || str.equals("") || str.isEmpty()) ? null : new ArrayList(Arrays.asList(str.split(",")));
        if (arrayList == null || arrayList.size() < 1) {
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            b();
            Toast.makeText(this.a, "Your Account is invalid or has expired !", 0).show();
            return;
        }
        try {
            this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.j.commit();
            arrayList.remove(0);
            this.i.h(this.d, this.e, arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void f(z zVar) {
        zVar.r();
    }

    public static /* synthetic */ void g(z zVar) {
        zVar.z();
    }

    public static /* synthetic */ void h(z zVar) {
        zVar.z();
    }

    public static /* synthetic */ void k(z zVar) {
        zVar.r();
    }

    public static /* synthetic */ void l(z zVar) {
        zVar.p();
    }

    public static /* synthetic */ Activity n(z zVar) {
        return zVar.h;
    }

    public static /* synthetic */ Context o(z zVar) {
        return zVar.a;
    }

    public void A() {
        x();
        new c(this, null).execute(new Void[0]);
    }

    public void b() {
        p();
    }

    public void b0(int i) {
        Activity activity;
        Runnable yVar;
        String clientSecurityUrl = SharepreferenceDBHandler.getClientSecurityUrl(this.a);
        if (m7.a.W0.booleanValue()) {
            MyApplication.p().G(this.a, new a(clientSecurityUrl));
            return;
        }
        if (clientSecurityUrl.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(this.a))) {
            activity = this.h;
            yVar = new x(this);
        } else {
            activity = this.h;
            yVar = new y(this);
        }
        activity.runOnUiThread(yVar);
    }

    public void c(String str) {
        p();
        if (!str.equals("")) {
            w.P0(this.a, str);
        } else if (!m7.a.n.booleanValue()) {
            w.P0(this.a, "Your Account is invalid or has expired !");
        } else {
            Context context = this.a;
            Toast.makeText(context, context.getResources().getString(a7.j.C2), 0).show();
        }
    }

    public void d(String str) {
        p();
        w.P0(this.a, str);
    }

    public void e(String str) {
        p();
        w.P0(this.a, str);
    }

    public void m(LoginCallback loginCallback, String str) {
        Toast makeText;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Intent intent;
        if (this.a != null) {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null) {
                p();
                d(this.a.getResources().getString(a7.j.F2));
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
                    String serverProtocal = loginCallback.getServerInfo().getServerProtocal();
                    String httpsPort = loginCallback.getServerInfo().getHttpsPort();
                    String rtmpPort = loginCallback.getServerInfo().getRtmpPort();
                    String timezone = loginCallback.getServerInfo().getTimezone();
                    SharedPreferences.Editor edit = this.a.getSharedPreferences("loginPrefs", 0).edit();
                    SharedPreferences sharedPreferences = this.a.getSharedPreferences("loginprefsmultiuser", 0);
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    String string = sharedPreferences.getString("name", "");
                    String string2 = sharedPreferences.getString("username", "");
                    String string3 = sharedPreferences.getString("password", "");
                    String string4 = sharedPreferences.getString(m7.a.L, "");
                    edit2.putString("name", this.c);
                    edit2.putString("username", username);
                    edit2.putString("password", password);
                    edit2.putString(m7.a.L, url);
                    MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(this.a);
                    int userID = SharepreferenceDBHandler.getUserID(this.a);
                    multiUserDBHandler.updateMultiUser(userID, url);
                    if (this.m) {
                        str2 = "name";
                        str11 = string3;
                        str3 = string4;
                        str6 = "";
                        str4 = serverProtocal;
                        str10 = timezone;
                        str5 = maxConnections;
                        str9 = rtmpPort;
                        str12 = createdAt;
                        str7 = httpsPort;
                        str8 = activeCons;
                        multiUserDBHandler.updateEditMultiUserdetails(userID, this.c, this.d, this.e, m7.a.Z, url);
                    } else {
                        str2 = "name";
                        str3 = string4;
                        str4 = serverProtocal;
                        str5 = maxConnections;
                        str6 = "";
                        str7 = httpsPort;
                        str8 = activeCons;
                        str9 = rtmpPort;
                        str10 = timezone;
                        str11 = string3;
                        str12 = createdAt;
                    }
                    edit.putString("username", username);
                    edit.putString("password", password);
                    edit.putString("serverPort", port);
                    edit.putString("serverUrl", url);
                    edit.putString("expDate", expDate);
                    edit.putString("isTrial", isTrial);
                    edit.putString("activeCons", str8);
                    edit.putString("createdAt", str12);
                    edit.putString("maxConnections", str5);
                    edit.putString(m7.a.L, url);
                    edit.putString("serverProtocol", str4);
                    edit.putString("serverPortHttps", str7);
                    edit.putString("serverPortRtmp", str9);
                    edit.putString("serverTimeZone", str10);
                    edit.apply();
                    edit2.apply();
                    SharedPreferences sharedPreferences2 = this.a.getSharedPreferences("allowedFormat", 0);
                    SharedPreferences.Editor edit3 = sharedPreferences2.edit();
                    SharedPreferences sharedPreferences3 = this.a.getSharedPreferences("timeFormat", 0);
                    SharedPreferences.Editor edit4 = sharedPreferences3.edit();
                    String str13 = str6;
                    String string5 = sharedPreferences2.getString("allowedFormat", str13);
                    if (string5 != null && string5.equals(str13)) {
                        edit3.putString("allowedFormat", "ts");
                        edit3.apply();
                    }
                    String string6 = sharedPreferences3.getString("timeFormat", m7.a.E0);
                    if (string6 != null && string6.equals(str13)) {
                        edit4.putString("timeFormat", m7.a.E0);
                        edit4.apply();
                    }
                    SharedPreferences.Editor edit5 = this.a.getSharedPreferences("sharedprefremberme", 0).edit();
                    edit5.putBoolean("savelogin", true);
                    edit5.apply();
                    p();
                    try {
                        Context context = this.a;
                        Toast.makeText(context, context.getResources().getString(a7.j.b3), 0).show();
                    } catch (WindowManager.BadTokenException e) {
                        e.printStackTrace();
                    }
                    if (this.a != null && this.c.equals(string) && this.d.equals(string2) && this.e.equals(str11) && url.equals(str3)) {
                        edit2.putString(str2, this.c);
                        edit2.apply();
                        m7.a.m = this.c;
                        intent = new Intent(this.a, NewDashboardActivity.class);
                    } else {
                        String str14 = str2;
                        if (this.a == null) {
                            return;
                        }
                        if (this.m) {
                            if (this.n.getEPGCount() > 0 && this.n != null) {
                                String q = w.q();
                                this.n.makeEmptyEPG();
                                this.n.updateDBStatusAndDate("EPG", "2", str13, q);
                            }
                            if (this.g) {
                                v(userID);
                            }
                            edit2.putString(str14, this.c);
                            edit2.apply();
                            m7.a.m = this.c;
                            intent = new Intent(this.a, NewDashboardActivity.class);
                        } else {
                            edit2.putString(str14, this.c);
                            edit2.apply();
                            m7.a.m = this.c;
                            intent = new Intent(this.a, NewDashboardActivity.class);
                        }
                    }
                    this.a.startActivity(intent);
                    this.a.finish();
                    return;
                }
                p();
                makeText = Toast.makeText(this.a, this.a.getResources().getString(a7.j.H2) + status, 0);
            } else {
                p();
                Context context2 = this.a;
                makeText = Toast.makeText(context2, context2.getResources().getString(a7.j.D2), 0);
            }
            makeText.show();
        }
    }

    public final void p() {
        try {
            ProgressDialog progressDialog = this.l;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void r() {
        StringBuilder sb;
        List list;
        b7.e a2;
        String j = MyApplication.j(this.h);
        String l = MyApplication.l();
        MyApplication.p().q();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
            sb = new StringBuilder();
            sb.append(b7.f.c(this.a));
            sb.append("*");
            sb.append(b7.f.d(this.a));
            sb.append("-");
            sb.append("playlist");
        } else {
            sb = new StringBuilder();
            sb.append(b7.f.c(this.a));
            sb.append("*");
            sb.append(b7.f.d(this.a));
            sb.append("-");
            sb.append(this.d);
        }
        sb.append("-");
        sb.append(b7.b.b);
        sb.append("-");
        sb.append(j);
        sb.append("-unknown-");
        sb.append(MyApplication.n());
        sb.append("-");
        sb.append(l);
        String z = MyApplication.z(sb.toString());
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("m", "gu"));
        b7.g.b.add(b7.g.a("k", b7.f.c(this.h)));
        b7.g.b.add(b7.g.a("sc", z));
        if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
            list = b7.g.b;
            a2 = b7.g.a("u", "playlist");
        } else {
            list = b7.g.b;
            a2 = b7.g.a("u", this.d);
        }
        list.add(a2);
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", j));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", MyApplication.n()));
        b7.g.b.add(b7.g.a("do", l));
        b7.g.c.b(this);
    }

    public void u(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.m = z;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = z2;
    }

    public final void v(int i) {
        try {
            new DatabaseHandler(this.a).deleteDataForUser(i);
            new RecentWatchDBHandler(this.a).deletRecentWatchForThisUser(i);
            new SeriesRecentWatchDatabase(this.a).deleteALLSeriesRecentwatch();
            LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.a);
            liveStreamDBHandler.deletePasswordDataForUser(i, "api");
            liveStreamDBHandler.deleteImportStatusForUser(i, "api");
            liveStreamDBHandler.deleteExtraLiveRecentlyWatched();
            liveStreamDBHandler.deleteALLLiveRecentlyWatched();
            liveStreamDBHandler.deleteAllEPGSources(i, "api");
            liveStreamDBHandler.makeEmptyEPGWithSourceRef(i, "api");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i, boolean z) {
        ArrayList arrayList;
        if (!z) {
            Context context = this.a;
            Toast.makeText(context, context.getResources().getString(a7.j.A0), 0).show();
            return;
        }
        if (i == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b7.b.a = jSONObject;
                if (!jSONObject.getString("status").equalsIgnoreCase("true")) {
                    Context context2 = this.a;
                    Toast.makeText(context2, context2.getResources().getString(a7.j.M7), 0).show();
                    return;
                }
                String string = b7.b.a.getString("su");
                b7.b.a.getString("ndd");
                System.currentTimeMillis();
                try {
                    b7.f.e(this.h, b7.b.a.optString("su"));
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(MyApplication.z(b7.b.a.optString("su") + "*" + b7.f.d(this.h) + "*" + b7.b.b))) {
                        Context context3 = this.a;
                        Toast.makeText(context3, context3.getResources().getString(a7.j.A0), 0).show();
                        return;
                    }
                    if (string == null || string.equals("") || string.isEmpty()) {
                        arrayList = null;
                    } else {
                        string = string.toLowerCase();
                        arrayList = new ArrayList(Arrays.asList(string.split(",")));
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        for (int i2 = 0; i2 < arrayList.size() && !this.f.contains((CharSequence) arrayList.get(i2)); i2++) {
                        }
                    }
                    B(string.toLowerCase());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void w0(ArrayList arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            b();
            if (!m7.a.n.booleanValue()) {
                w.P0(this.a, "Your Account is invalid or has expired !");
                return;
            } else {
                Context context = this.a;
                Toast.makeText(context, context.getResources().getString(a7.j.C2), 0).show();
                return;
            }
        }
        try {
            this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
            this.j.apply();
            arrayList.remove(0);
            this.i.h(this.d, this.e, arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void x() {
        try {
            ProgressDialog progressDialog = this.l;
            if (progressDialog != null) {
                progressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void y(LoginCallback loginCallback, String str, ArrayList arrayList) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Intent intent;
        try {
            if (loginCallback == null || loginCallback.getUserLoginInfo() == null || loginCallback.getServerInfo() == null) {
                if (arrayList != null && arrayList.size() > 0) {
                    this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                    this.j.apply();
                    arrayList.remove(0);
                    this.i.h(this.d, this.e, arrayList);
                    return;
                }
                p();
                w.P0(this.a, "Your Account is invalid or has expired !");
                return;
            }
            if (loginCallback.getUserLoginInfo() == null) {
                if (arrayList != null && arrayList.size() > 0) {
                    this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                    this.j.apply();
                    arrayList.remove(0);
                    this.i.h(this.d, this.e, arrayList);
                    return;
                }
                p();
                w.P0(this.a, "Your Account is invalid or has expired !");
                return;
            }
            if (loginCallback.getUserLoginInfo().getAuth().intValue() != 1) {
                if (arrayList != null && arrayList.size() > 0) {
                    this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                    this.j.apply();
                    arrayList.remove(0);
                    this.i.h(this.d, this.e, arrayList);
                    return;
                }
                p();
                w.P0(this.a, "Your Account is invalid or has expired !");
                return;
            }
            if (!loginCallback.getUserLoginInfo().getStatus().equals("Active")) {
                if (arrayList != null && arrayList.size() > 0) {
                    this.j.putString(m7.a.L, ((String) arrayList.get(0)).trim());
                    this.j.apply();
                    arrayList.remove(0);
                    this.i.h(this.d, this.e, arrayList);
                    return;
                }
                p();
                w.P0(this.a, "Your Account is invalid or has expired !");
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
            String serverProtocal = loginCallback.getServerInfo().getServerProtocal();
            String httpsPort = loginCallback.getServerInfo().getHttpsPort();
            String rtmpPort = loginCallback.getServerInfo().getRtmpPort();
            String timezone = loginCallback.getServerInfo().getTimezone();
            SharedPreferences.Editor edit = this.a.getSharedPreferences("loginPrefs", 0).edit();
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("loginprefsmultiuser", 0);
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            String string = sharedPreferences.getString("name", "");
            String string2 = sharedPreferences.getString("username", "");
            String string3 = sharedPreferences.getString("password", "");
            String string4 = sharedPreferences.getString(m7.a.L, "");
            edit2.putString("name", this.c);
            edit2.putString("username", username);
            edit2.putString("password", password);
            edit2.putString(m7.a.L, url);
            MultiUserDBHandler multiUserDBHandler = new MultiUserDBHandler(this.a);
            int userID = SharepreferenceDBHandler.getUserID(this.a);
            multiUserDBHandler.updateMultiUser(userID, url);
            if (this.m) {
                str3 = "name";
                str10 = string3;
                str4 = string4;
                str7 = "";
                str5 = serverProtocal;
                str9 = timezone;
                str6 = maxConnections;
                str2 = rtmpPort;
                str11 = createdAt;
                str8 = httpsPort;
                str12 = activeCons;
                multiUserDBHandler.updateEditMultiUserdetails(userID, this.c, this.d, this.e, m7.a.Z, url);
            } else {
                str2 = rtmpPort;
                str3 = "name";
                str4 = string4;
                str5 = serverProtocal;
                str6 = maxConnections;
                str7 = "";
                str8 = httpsPort;
                str9 = timezone;
                str10 = string3;
                str11 = createdAt;
                str12 = activeCons;
            }
            edit.putString("username", username);
            edit.putString("password", password);
            edit.putString("serverPort", port);
            edit.putString("serverUrl", url);
            edit.putString("expDate", expDate);
            edit.putString("isTrial", isTrial);
            edit.putString("activeCons", str12);
            edit.putString("createdAt", str11);
            edit.putString("maxConnections", str6);
            edit.putString(m7.a.L, url);
            edit.putString("serverProtocol", str5);
            edit.putString("serverPortHttps", str8);
            edit.putString("serverPortRtmp", str2);
            edit.putString("serverTimeZone", str9);
            edit.apply();
            edit2.apply();
            SharedPreferences sharedPreferences2 = this.a.getSharedPreferences("allowedFormat", 0);
            SharedPreferences.Editor edit3 = sharedPreferences2.edit();
            SharedPreferences sharedPreferences3 = this.a.getSharedPreferences("timeFormat", 0);
            SharedPreferences.Editor edit4 = sharedPreferences3.edit();
            String str13 = str7;
            String string5 = sharedPreferences2.getString("allowedFormat", str13);
            if (string5 != null && string5.equals(str13)) {
                edit3.putString("allowedFormat", "ts");
                edit3.apply();
            }
            String string6 = sharedPreferences3.getString("timeFormat", m7.a.E0);
            if (string6 != null && string6.equals(str13)) {
                edit4.putString("timeFormat", m7.a.E0);
                edit4.apply();
            }
            SharedPreferences.Editor edit5 = this.a.getSharedPreferences("sharedprefremberme", 0).edit();
            edit5.putBoolean("savelogin", true);
            edit5.apply();
            p();
            try {
                Context context = this.a;
                Toast.makeText(context, context.getResources().getString(a7.j.b3), 0).show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
            if (this.a != null && this.c.equals(string) && this.d.equals(string2) && this.e.equals(str10) && url.equals(str4)) {
                edit2.putString(str3, this.c);
                edit2.apply();
                m7.a.m = this.c;
                intent = new Intent(this.a, NewDashboardActivity.class);
            } else {
                String str14 = str3;
                if (this.a == null) {
                    return;
                }
                if (this.m) {
                    if (this.g) {
                        v(userID);
                    }
                    edit2.putString(str14, this.c);
                    edit2.apply();
                    m7.a.m = this.c;
                    intent = new Intent(this.a, NewDashboardActivity.class);
                } else {
                    edit2.putString(str14, this.c);
                    edit2.apply();
                    m7.a.m = this.c;
                    intent = new Intent(this.a, NewDashboardActivity.class);
                }
            }
            this.a.startActivity(intent);
            this.a.finish();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void z() {
        try {
            this.i.g(this.d, this.e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class a implements MyApplication.d {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                z.h(z.this);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                z.k(z.this);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                z.h(z.this);
            }
        }

        public a(String str) {
            this.a = str;
        }

        public void b(String str) {
            MyApplication.p().D("MU" + str, z.o(z.this));
            z.n(z.this).runOnUiThread(new c());
        }

        public void onSuccess() {
            Activity n;
            Runnable bVar;
            if (this.a.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(z.o(z.this)))) {
                n = z.n(z.this);
                bVar = new a();
            } else {
                n = z.n(z.this);
                bVar = new b();
            }
            n.runOnUiThread(bVar);
        }

        public void a(String str) {
        }
    }

    public void h0(ArrayList arrayList, String str) {
    }
}
