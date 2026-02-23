package m7;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.ImportM3uActivity;
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
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements b7.c {
    public Context a;
    public String c;
    public String d;
    public String e;
    public Activity f;
    public SharedPreferences.Editor g;
    public SharedPreferences h;
    public ProgressDialog i;
    public boolean j;
    public LiveStreamDBHandler k;
    public RecentWatchDBHandler l;
    public final A7.a m;

    public class a implements MyApplication.d {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                a aVar = a.this;
                if (aVar.a.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(f.h(f.this)))) {
                    f.a(f.this);
                } else {
                    f.e(f.this);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                f.a(f.this);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            public void run() {
                MyApplication.p().D("MU" + this.a, f.h(f.this));
                f.a(f.this);
            }
        }

        public a(String str) {
            this.a = str;
        }

        public void a(String str) {
            f.g(f.this).runOnUiThread(new b());
        }

        public void b(String str) {
            f.g(f.this).runOnUiThread(new c(str));
        }

        public void onSuccess() {
            f.g(f.this).runOnUiThread(new a());
        }
    }

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
            new d(f.this, null).execute(new Void[0]);
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == a7.f.s1) {
                new Handler(Looper.getMainLooper()).postDelayed(new g(this), 200L);
                dismiss();
            } else if (id == a7.f.X0) {
                try {
                    dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(new u7.a(f.h(f.this)).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(strArr[0]);
                f.i(f.this);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f.h(f.this).getFilesDir() + "/data_temp.txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(f.h(f.this).getFilesDir() + "/data_temp.txt").toString())));
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
                    f.this.new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{f.h(f.this).getFilesDir() + "/data_temp.txt"});
                } else {
                    f.f(f.this);
                    w.P0(f.h(f.this), f.h(f.this).getResources().getString(a7.j.h2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(String... strArr) {
        }
    }

    public class d extends AsyncTask {
        public d() {
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
                    f.a(f.this);
                    return;
                } else {
                    f.e(f.this);
                    return;
                }
            }
            f.f(f.this);
            f fVar = f.this;
            b bVar = fVar.new b(f.g(fVar));
            bVar.setCancelable(false);
            bVar.show();
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public class e extends AsyncTask {
        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return f.b(f.this).c(new FileInputStream(new File(strArr[0])), f.h(f.this));
            } catch (Exception unused) {
                return "";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            Toast makeText;
            f fVar;
            super.onPostExecute(str);
            if (str.equals("")) {
                if (f.d(f.this) != null) {
                    f.d(f.this).updateImportStatus("all", "2");
                }
                f.f(f.this);
                Toast.makeText(f.h(f.this), f.h(f.this).getResources().getString(a7.j.a8), 1).show();
                return;
            }
            try {
                if (m7.a.t.booleanValue()) {
                    if (!m7.a.o.booleanValue()) {
                        String a = b7.f.a(f.h(f.this));
                        ArrayList arrayList = (a == null || a.equals("") || a.isEmpty()) ? null : new ArrayList(Arrays.asList(a.split(",")));
                        if (arrayList == null || arrayList.size() < 1) {
                            f.f(f.this);
                            makeText = Toast.makeText(f.h(f.this), f.h(f.this).getResources().getString(a7.j.l5), 0);
                        } else {
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (str.contains((CharSequence) arrayList.get(i))) {
                                    fVar = f.this;
                                }
                            }
                            f.f(f.this);
                            makeText = Toast.makeText(f.h(f.this), f.h(f.this).getResources().getString(a7.j.G2), 0);
                        }
                        makeText.show();
                        return;
                    }
                    fVar = f.this;
                    f.c(fVar, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public f(Context context, Activity activity) {
        this.a = context;
        this.f = activity;
        this.k = new LiveStreamDBHandler(context);
        this.l = new RecentWatchDBHandler(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefsserverurl", 0);
        this.h = sharedPreferences;
        this.g = sharedPreferences.edit();
        this.m = new A7.a();
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.i = progressDialog;
        progressDialog.setMessage(context.getResources().getString(a7.j.t5));
        this.i.setCanceledOnTouchOutside(false);
        this.i.setCancelable(false);
        this.i.setProgressStyle(0);
    }

    public static /* synthetic */ void a(f fVar) {
        fVar.s();
    }

    public static /* synthetic */ A7.a b(f fVar) {
        return fVar.m;
    }

    public static /* synthetic */ void c(f fVar, String str) {
        fVar.j(str);
    }

    public static /* synthetic */ LiveStreamDBHandler d(f fVar) {
        return fVar.k;
    }

    public static /* synthetic */ void e(f fVar) {
        fVar.n();
    }

    public static /* synthetic */ void f(f fVar) {
        fVar.l();
    }

    public static /* synthetic */ Activity g(f fVar) {
        return fVar.f;
    }

    public static /* synthetic */ Context h(f fVar) {
        return fVar.a;
    }

    public static /* synthetic */ boolean i(f fVar) {
        return fVar.p();
    }

    private boolean k() {
        return this.a.getSharedPreferences("automation_channels", 0).getString("automation_channels", "").equals("checked");
    }

    private void l() {
        try {
            ProgressDialog progressDialog = this.i;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static long m(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void n() {
        StringBuilder sb;
        String j = MyApplication.j(this.f);
        String l = MyApplication.l();
        MyApplication.p().q();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
            sb = new StringBuilder();
            sb.append(b7.f.c(this.a));
            sb.append("*");
            sb.append(b7.f.d(this.a));
            sb.append("-");
            sb.append("playlist");
            sb.append("-");
        } else {
            sb = new StringBuilder();
            sb.append(b7.f.c(this.a));
            sb.append("*");
            sb.append(b7.f.d(this.a));
            sb.append("-playlist-");
        }
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
        b7.g.b.add(b7.g.a("k", b7.f.c(this.f)));
        b7.g.b.add(b7.g.a("sc", z));
        SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u");
        b7.g.b.add(b7.g.a("u", "playlist"));
        b7.g.b.add(b7.g.a("pw", "no_password"));
        b7.g.b.add(b7.g.a("r", b7.b.b));
        b7.g.b.add(b7.g.a("av", j));
        b7.g.b.add(b7.g.a("dt", "unknown"));
        b7.g.b.add(b7.g.a("d", MyApplication.n()));
        b7.g.b.add(b7.g.a("do", l));
        b7.g.c.b(this);
    }

    private boolean p() {
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i >= 33) {
            return true;
        }
        if (T.k.a(this.a, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this.a, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        return false;
    }

    private void r() {
        try {
            ProgressDialog progressDialog = this.i;
            if (progressDialog != null) {
                progressDialog.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b0(int i) {
        String clientSecurityUrl = SharepreferenceDBHandler.getClientSecurityUrl(this.a);
        if (m7.a.W0.booleanValue()) {
            MyApplication.p().G(this.a, new a(clientSecurityUrl));
        } else if (clientSecurityUrl.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(this.a))) {
            s();
        } else {
            n();
        }
    }

    public final void j(String str) {
        Activity activity;
        try {
            SharedPreferences.Editor edit = this.a.getSharedPreferences("loginPrefs", 0).edit();
            SharedPreferences.Editor edit2 = this.a.getSharedPreferences("loginprefsmultiuser", 0).edit();
            edit2.putString("name", this.e);
            edit2.putString("username", "playlist");
            edit2.putString("password", "playlist");
            edit2.putString(m7.a.L, this.d);
            edit.putString("username", "playlist");
            edit.putString("password", "playlist");
            edit.putString("serverPort", "");
            edit.putString("serverUrl", this.d);
            edit.putString("serverM3UUrl", this.d);
            edit.putString(m7.a.L, this.d);
            edit.apply();
            edit2.apply();
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("allowedFormat", 0);
            SharedPreferences.Editor edit3 = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = this.a.getSharedPreferences("timeFormat", 0);
            SharedPreferences.Editor edit4 = sharedPreferences2.edit();
            String string = sharedPreferences.getString("allowedFormat", "");
            if (string != null && string.equals("")) {
                edit3.putString("allowedFormat", "ts");
                edit3.apply();
            }
            String string2 = sharedPreferences2.getString("timeFormat", m7.a.E0);
            if (string2 != null && string2.equals("")) {
                edit4.putString("timeFormat", m7.a.E0);
                edit4.apply();
            }
            SharedPreferences.Editor edit5 = this.a.getSharedPreferences("sharedprefremberme", 0).edit();
            edit5.putBoolean("savelogin", true);
            edit5.apply();
            SharepreferenceDBHandler.getUserID(this.a);
            l();
            try {
                Context context = this.a;
                Toast.makeText(context, context.getResources().getString(a7.j.b3), 0).show();
            } catch (WindowManager.BadTokenException e2) {
                e2.printStackTrace();
            }
            int importTableCount = this.k.getImportTableCount("m3u");
            if (str != null && !str.equals("")) {
                if (SharepreferenceDBHandler.getFirebaseM3uNode(this.a).equalsIgnoreCase("")) {
                    importTableCount = 0;
                }
                SharepreferenceDBHandler.setFirebaseM3uNode(str, this.a);
            }
            if (importTableCount == 0) {
                ArrayList arrayList = new ArrayList();
                ImportStatusModel importStatusModel = new ImportStatusModel();
                importStatusModel.setType("all");
                importStatusModel.setStatus("0");
                importStatusModel.setDate("");
                arrayList.add(0, importStatusModel);
                this.k.importDataStatusArrayList(arrayList, "m3u");
            }
            ImportStatusModel importStatusModel2 = this.k.getdateDBStatus("all");
            if (importStatusModel2 != null) {
                if ((importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("0")) && (importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("2"))) {
                    if (importStatusModel2.getStatus() != null && importStatusModel2.getStatus().equals("1")) {
                        long m = m(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel2.getDate(), w.q());
                        u7.a aVar = new u7.a(this.a);
                        if (!k() || m < aVar.g()) {
                            edit2.putString("name", this.e);
                            edit2.apply();
                            m7.a.m = this.e;
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
            e3.printStackTrace();
        }
    }

    public void o(boolean z, String str, String str2, String str3) {
        this.e = str3;
        this.j = z;
        this.c = str;
        this.d = str2;
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i, boolean z) {
        Toast makeText;
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
                    b7.f.e(this.f, b7.b.a.optString("su"));
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(MyApplication.z(b7.b.a.optString("su") + "*" + b7.f.d(this.f) + "*" + b7.b.b))) {
                        Context context3 = this.a;
                        makeText = Toast.makeText(context3, context3.getResources().getString(a7.j.A0), 0);
                    } else {
                        if (string != null && string.length() > 0) {
                            if (this.c.equalsIgnoreCase("file")) {
                                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.d});
                                return;
                            } else {
                                if (this.c.equalsIgnoreCase("url")) {
                                    new c(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.d});
                                    return;
                                }
                                return;
                            }
                        }
                        Context context4 = this.a;
                        makeText = Toast.makeText(context4, context4.getResources().getString(a7.j.A0), 0);
                    }
                    makeText.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void s() {
        try {
            if (this.c.equalsIgnoreCase("file")) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.d});
            } else if (this.c.equalsIgnoreCase("url")) {
                new c(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.d});
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void t() {
        r();
        new d(this, null).execute(new Void[0]);
    }
}
