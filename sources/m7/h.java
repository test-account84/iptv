package m7;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h implements b7.c {
    public Context a;
    public String c;
    public String d;
    public String e;
    public String f;
    public Activity g;
    public SharedPreferences.Editor h;
    public SharedPreferences i;
    public ProgressDialog j;
    public boolean k;
    public LiveStreamDBHandler l;
    public RecentWatchDBHandler m;
    public boolean n;
    public ArrayList o = new ArrayList();

    public class a implements MyApplication.d {
        public final /* synthetic */ String a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                a aVar = a.this;
                if (aVar.a.equalsIgnoreCase(SharepreferenceDBHandler.getClientSecurityUrl(h.l(h.this)))) {
                    h.h(h.this);
                } else {
                    h.i(h.this);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                h.h(h.this);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            public void run() {
                MyApplication.p().D("MU" + this.a, h.l(h.this));
                h.h(h.this);
            }
        }

        public a(String str) {
            this.a = str;
        }

        public void a(String str) {
            h.k(h.this).runOnUiThread(new b());
        }

        public void b(String str) {
            h.k(h.this).runOnUiThread(new c(str));
        }

        public void onSuccess() {
            h.k(h.this).runOnUiThread(new a());
        }
    }

    public class b implements p1.c {
        public b() {
        }

        public void a(JSONObject jSONObject) {
            h hVar;
            String str;
            Log.e("AUTH_API", String.valueOf(jSONObject));
            try {
                String string = jSONObject.getString("auth_token");
                if (a7.m.a(string)) {
                    SharepreferenceDBHandler.setOneStreamToken(string, h.l(h.this));
                    hVar = h.this;
                    str = m7.a.Z;
                } else {
                    Log.e("AUTHAPI", "AUTHTOKEN IS EMPTY");
                    if (!m7.a.o.booleanValue()) {
                        h.h(h.this);
                        return;
                    } else {
                        SharepreferenceDBHandler.setOneStreamToken(string, h.l(h.this));
                        hVar = h.this;
                        str = m7.a.Z;
                    }
                }
                h.m(hVar, str);
            } catch (Exception e) {
                h.h(h.this);
                e.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            h.h(h.this);
        }
    }

    public class c implements p1.c {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0071 A[Catch: JSONException -> 0x006e, TryCatch #2 {JSONException -> 0x006e, blocks: (B:7:0x0067, B:10:0x0071, B:12:0x00cb, B:35:0x020f, B:38:0x0265, B:41:0x0287, B:43:0x02ab, B:44:0x02ce, B:45:0x0437, B:46:0x0452, B:50:0x02cb, B:55:0x02ed, B:57:0x02fa, B:58:0x030a, B:60:0x0318, B:62:0x031e, B:64:0x033c, B:65:0x0356, B:66:0x032a, B:68:0x0330, B:70:0x035b, B:72:0x0361, B:74:0x036d, B:76:0x0395, B:78:0x039e, B:79:0x03b9, B:80:0x03ed, B:82:0x03f3, B:84:0x03ff, B:85:0x041b, B:89:0x0456, B:91:0x0030, B:94:0x0042, B:97:0x004a, B:100:0x0055, B:103:0x005c), top: B:90:0x0030, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0067 A[Catch: JSONException -> 0x006e, TryCatch #2 {JSONException -> 0x006e, blocks: (B:7:0x0067, B:10:0x0071, B:12:0x00cb, B:35:0x020f, B:38:0x0265, B:41:0x0287, B:43:0x02ab, B:44:0x02ce, B:45:0x0437, B:46:0x0452, B:50:0x02cb, B:55:0x02ed, B:57:0x02fa, B:58:0x030a, B:60:0x0318, B:62:0x031e, B:64:0x033c, B:65:0x0356, B:66:0x032a, B:68:0x0330, B:70:0x035b, B:72:0x0361, B:74:0x036d, B:76:0x0395, B:78:0x039e, B:79:0x03b9, B:80:0x03ed, B:82:0x03f3, B:84:0x03ff, B:85:0x041b, B:89:0x0456, B:91:0x0030, B:94:0x0042, B:97:0x004a, B:100:0x0055, B:103:0x005c), top: B:90:0x0030, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(org.json.JSONObject r24) {
            /*
                Method dump skipped, instructions count: 1161
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: m7.h.c.a(org.json.JSONObject):void");
        }

        public void b(m1.a aVar) {
            Log.e("INFO_API", String.valueOf(aVar));
            Toast.makeText(h.l(h.this).getApplicationContext(), h.l(h.this).getResources().getString(a7.j.D2), 0).show();
        }
    }

    public class d extends Dialog implements View.OnClickListener {
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
                            c = d.c(d.this);
                        }
                    } else {
                        c = d.b(d.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            c = d.c(d.this);
                        }
                    } else {
                        c = d.b(d.this);
                    }
                    i = a7.e.o;
                }
                c.setBackgroundResource(i);
            }
        }

        public d(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ void a(d dVar) {
            dVar.d();
        }

        public static /* synthetic */ LinearLayout b(d dVar) {
            return dVar.e;
        }

        public static /* synthetic */ LinearLayout c(d dVar) {
            return dVar.f;
        }

        public final /* synthetic */ void d() {
            new e(h.this, null).execute(new Void[0]);
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == a7.f.s1) {
                new Handler(Looper.getMainLooper()).postDelayed(new i(this), 200L);
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
            setContentView(new u7.a(h.l(h.this)).A().equals(m7.a.K0) ? a7.g.j2 : a7.g.i2);
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
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[PHI: r3
          0x001f: PHI (r3v9 java.util.ArrayList) = (r3v7 java.util.ArrayList), (r3v16 java.util.ArrayList) binds: [B:16:0x003d, B:8:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.lang.Boolean r3) {
            /*
                r2 = this;
                super.onPostExecute(r3)
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L40
                java.lang.Boolean r3 = m7.a.o
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L39
                java.lang.Boolean r3 = m7.a.n
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L33
                m7.h r3 = m7.h.this
                java.util.ArrayList r3 = r3.o
                if (r3 == 0) goto L2d
            L1f:
                r3.clear()
                m7.h r3 = m7.h.this
                java.util.ArrayList r0 = r3.o
                java.lang.String r3 = m7.h.a(r3)
                r0.add(r3)
            L2d:
                m7.h r3 = m7.h.this
                m7.h.h(r3)
                goto L57
            L33:
                m7.h r3 = m7.h.this
                m7.h.i(r3)
                goto L57
            L39:
                m7.h r3 = m7.h.this
                java.util.ArrayList r3 = r3.o
                if (r3 == 0) goto L2d
                goto L1f
            L40:
                m7.h r3 = m7.h.this
                m7.h.j(r3)
                m7.h$d r3 = new m7.h$d
                m7.h r0 = m7.h.this
                android.app.Activity r1 = m7.h.k(r0)
                r3.<init>(r1)
                r0 = 0
                r3.setCancelable(r0)
                r3.show()
            L57:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m7.h.e.onPostExecute(java.lang.Boolean):void");
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    public h(Context context, Activity activity) {
        this.a = context;
        this.g = activity;
        this.l = new LiveStreamDBHandler(context);
        this.m = new RecentWatchDBHandler(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefsserverurl", 0);
        this.i = sharedPreferences;
        this.h = sharedPreferences.edit();
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.j = progressDialog;
        progressDialog.setMessage(context.getResources().getString(a7.j.t5));
        this.j.setCanceledOnTouchOutside(false);
        this.j.setCancelable(false);
        this.j.setProgressStyle(0);
    }

    public static /* synthetic */ String a(h hVar) {
        return hVar.f;
    }

    public static /* synthetic */ String b(h hVar) {
        return hVar.d;
    }

    public static /* synthetic */ String c(h hVar) {
        return hVar.e;
    }

    public static /* synthetic */ String d(h hVar) {
        return hVar.c;
    }

    public static /* synthetic */ boolean e(h hVar) {
        return hVar.n;
    }

    public static /* synthetic */ boolean f(h hVar) {
        return hVar.k;
    }

    public static /* synthetic */ LiveStreamDBHandler g(h hVar) {
        return hVar.l;
    }

    public static /* synthetic */ void h(h hVar) {
        hVar.w();
    }

    public static /* synthetic */ void i(h hVar) {
        hVar.r();
    }

    public static /* synthetic */ void j(h hVar) {
        hVar.o();
    }

    public static /* synthetic */ Activity k(h hVar) {
        return hVar.g;
    }

    public static /* synthetic */ Context l(h hVar) {
        return hVar.a;
    }

    public static /* synthetic */ void m(h hVar, String str) {
        hVar.p(str);
    }

    private void o() {
        try {
            ProgressDialog progressDialog = this.j;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p(String str) {
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.a);
        SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.a);
        j1.a.a(str + "play/b2c/v1/user-info?token=" + oneStreamToken).s(k1.e.MEDIUM).q().o(new c(str));
    }

    public static long q(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void r() {
        StringBuilder sb;
        List list;
        b7.e a2;
        String j = MyApplication.j(this.g);
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
        b7.g.b.add(b7.g.a("k", b7.f.c(this.g)));
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

    private void u() {
        try {
            ProgressDialog progressDialog = this.j;
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
            w();
        } else {
            r();
        }
    }

    public boolean n() {
        return this.a.getSharedPreferences("automation_channels", 0).getString("automation_channels", "").equals("checked");
    }

    public void s(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.n = z2;
        this.k = z;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i, boolean z) {
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
                    b7.f.e(this.g, b7.b.a.optString("su"));
                    if (!b7.b.a.getString("sc").equalsIgnoreCase(MyApplication.z(b7.b.a.optString("su") + "*" + b7.f.d(this.g) + "*" + b7.b.b))) {
                        Context context3 = this.a;
                        Toast.makeText(context3, context3.getResources().getString(a7.j.A0), 0).show();
                        return;
                    }
                    if (string != null && !string.equals("") && !string.isEmpty()) {
                        this.o = new ArrayList(Arrays.asList(string.split(",")));
                    }
                    w();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void v() {
        u();
        new e(this, null).execute(new Void[0]);
    }

    public final void w() {
        ArrayList arrayList = this.o;
        if (arrayList != null && arrayList.size() >= 1) {
            this.h.putString(m7.a.L, ((String) this.o.get(0)).trim());
            this.h.commit();
            this.o.remove(0);
            x();
            return;
        }
        ArrayList arrayList2 = this.o;
        if (arrayList2 == null || arrayList2.size() != 0) {
            return;
        }
        o();
        Toast.makeText(this.a, "Your Account is invalid or has expired !", 0).show();
    }

    public final void x() {
        String lowerCase = this.i.getString(m7.a.L, "").toLowerCase();
        if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
            lowerCase = "http://" + lowerCase;
        }
        if (!lowerCase.endsWith("/")) {
            lowerCase = lowerCase + "/";
        }
        m7.a.Z = lowerCase;
        j1.a.b(lowerCase + "play/b2c/v1/auth").s("username", this.d).s("password", this.e).t("Content-Type", "FormUrlEncoded").v(k1.e.MEDIUM).u().o(new b());
    }
}
