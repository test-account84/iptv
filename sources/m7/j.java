package m7;

import D.l;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.view.activity.NotificationActivity;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j {
    public static SharedPreferences F;
    public static SharedPreferences G;
    public b D;
    public c E;
    public Context a;
    public int b;
    public int c;
    public String d;
    public int e;
    public String f;
    public String g;
    public NotificationManager i;
    public NotificationManager j;
    public Notification k;
    public l.e l;
    public l.e m;
    public boolean r;
    public CountDownTimer s;
    public CountDownTimer t;
    public String h = "";
    public int n = 234231;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public final String u = "CANCELLED";
    public boolean v = false;
    public boolean w = false;
    public long x = -1;
    public int y = 0;
    public boolean z = false;
    public int[] A = {1};
    public HttpURLConnection B = null;
    public final int C = 10;

    public class a extends CountDownTimer {

        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            public void onFinish() {
                j.c(j.this).cancel();
                j.k(j.this, true);
            }

            public void onTick(long j) {
                NotificationManager notificationManager;
                int i;
                Notification c;
                if (j.E(j.this)) {
                    j jVar = j.this;
                    if (!jVar.z) {
                        MyApplication.E("Debugging:cancelled recording");
                        j.this.i.cancelAll();
                        j.c(j.this).cancel();
                        j.i(j.this, "stopped");
                        return;
                    }
                    j.g(jVar, j.f(jVar) - j.G(j.this)[0]);
                    j jVar2 = j.this;
                    j.v(jVar2, j.f(jVar2) * 1000);
                    MyApplication.E("Debugging:retrying: " + j.s(j.this));
                    j.c(j.this).cancel();
                    return;
                }
                MyApplication.E("startingSeconds" + j.G(j.this)[0]);
                int[] G = j.G(j.this);
                int i2 = G[0];
                G[0] = i2 + 1;
                if (Build.VERSION.SDK_INT >= 26) {
                    SharedPreferences a = z0.b.a(j.H(j.this));
                    j.G = a;
                    SharedPreferences.Editor edit = a.edit();
                    edit.putBoolean("CANCELLED", false);
                    edit.apply();
                    j jVar3 = j.this;
                    NotificationActivity.a(jVar3.n, j.H(jVar3));
                    j.J(j.this, com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.b.a(new Notification.Builder(j.H(j.this)).setContentTitle(j.H(j.this).getResources().getString(a7.j.Y5) + j.K(i2) + " - " + j.K(j.L(j.this) / 1000)).setSmallIcon(a7.i.a), "ksjadf87").setSound((Uri) null, (AudioAttributes) null).build());
                    com.amplifyframework.storage.s3.service.c.a();
                    com.amplifyframework.storage.s3.service.a.a(j.this.i, com.amplifyframework.storage.s3.service.b.a("ksjadf87", j.H(j.this).getResources().getString(a7.j.Y5), 2));
                    j jVar4 = j.this;
                    notificationManager = jVar4.i;
                    i = jVar4.n;
                    c = j.I(jVar4);
                } else {
                    j.M(j.this).m(j.H(j.this).getResources().getString(a7.j.Y5) + j.K(i2) + " - " + j.K(j.L(j.this) / 1000));
                    j jVar5 = j.this;
                    notificationManager = jVar5.i;
                    i = jVar5.n;
                    c = j.M(jVar5).c();
                }
                notificationManager.notify(i, c);
                if (j.d(j.this)) {
                    j.this.i.cancelAll();
                    j.c(j.this).cancel();
                }
                MyApplication.E("Debugging:Seconds:" + j.K(i2) + "   Reverse Seconds:" + j.K((int) (j / 1000)) + " asdf:" + j.s(j.this) + " Timeinseconds:" + j.f(j.this));
                j.h(j.H(j.this), "processing");
            }
        }

        public a(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            cancel();
            j jVar = j.this;
            if (jVar.z || !j.l(jVar)) {
                return;
            }
            j.i(j.this, "failed");
        }

        public void onTick(long j) {
            MyApplication.E("testing " + j);
            if (j.a(j.this)) {
                MyApplication.E("download started " + j);
                cancel();
                j jVar = j.this;
                j.e(jVar, new a((long) j.s(jVar), 1000L).start());
            }
        }
    }

    public class b extends AsyncTask {
        public FileOutputStream a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                j jVar = j.this;
                jVar.y++;
                w.P0(j.H(jVar), "Retrying (" + j.this.y + "/10)");
                j.C(j.this);
            }
        }

        public b() {
            this.a = null;
        }

        public static /* synthetic */ void a(b bVar) {
            bVar.e();
        }

        public static /* synthetic */ void b(b bVar) {
            bVar.d();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            File file;
            MyApplication.E("start do in background");
            try {
                j.r(j.this, new URL(j.p(j.this)).openConnection());
                j.q(j.this).setRequestMethod("GET");
                j.q(j.this).setUseCaches(false);
                j.q(j.this).setInstanceFollowRedirects(false);
                j.q(j.this).connect();
                int responseCode = j.q(j.this).getResponseCode();
                MyApplication.E("responseCode" + responseCode);
                if (responseCode == 302 || responseCode == 301) {
                    String headerField = j.q(j.this).getHeaderField("Location");
                    j.q(j.this).disconnect();
                    j.r(j.this, new URL(headerField).openConnection());
                    j.q(j.this).setRequestMethod("GET");
                    j.q(j.this).connect();
                    responseCode = j.q(j.this).getResponseCode();
                }
                if (responseCode != 200) {
                    MyApplication.E("Server returned HTTP " + responseCode + " " + j.q(j.this).getResponseMessage());
                    SharedPreferences.Editor edit = j.G.edit();
                    edit.putBoolean("CANCELLED", true);
                    edit.apply();
                    j.F(j.this, true);
                    j jVar = j.this;
                    jVar.z = true;
                    j.b(jVar, false);
                } else {
                    if (j.t(j.this) == null || j.t(j.this).isEmpty()) {
                        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        j.u(j.this, file2.getAbsolutePath());
                    }
                    if (j.w(j.this) == null || j.w(j.this).isEmpty()) {
                        if (!j.y(j.this).contains(".ts")) {
                            j.z(j.this, ".ts");
                        }
                        file = new File(j.t(j.this), j.y(j.this));
                        if (file.exists() && !j.this.z) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                            j.x(j.this, simpleDateFormat.format(new Date()) + "_" + j.y(j.this));
                            file = new File(j.t(j.this), j.w(j.this));
                        }
                    } else {
                        file = new File(j.t(j.this), j.w(j.this));
                    }
                    MyApplication.E("checkIfCancelled default" + j.E(j.this));
                    MyApplication.E("retrying default" + j.this.z);
                    MyApplication.E("downloadStarted default" + j.a(j.this));
                    try {
                        this.a = new FileOutputStream(file, true);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.a);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(j.q(j.this).getInputStream());
                        byte[] bArr = new byte[1024];
                        if (j.A(j.this) == -1) {
                            j.B(j.this, (System.currentTimeMillis() / 1000) + j.f(j.this));
                        }
                        j.b(j.this, true);
                        j.F(j.this, false);
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1 && System.currentTimeMillis() / 1000 < j.A(j.this) && !j.j(j.this)) {
                                j.F(j.this, j.G.getBoolean("CANCELLED", false));
                                if (j.E(j.this)) {
                                    MyApplication.E("CANCELLED called");
                                    SharedPreferences.Editor edit2 = j.G.edit();
                                    edit2.putBoolean("CANCELLED", true);
                                    edit2.apply();
                                    break;
                                }
                                j jVar2 = j.this;
                                jVar2.y = 0;
                                jVar2.z = false;
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                break;
                            }
                        }
                        MyApplication.E("checkIfCancelled" + j.E(j.this));
                        MyApplication.E("retrying" + j.this.z);
                        MyApplication.E("downloadStarted" + j.a(j.this));
                    } catch (IOException e) {
                        MyApplication.E("IOException");
                        e.printStackTrace();
                    }
                }
                MyApplication.E("connection.disconnect()");
                j.q(j.this).disconnect();
                return null;
            } catch (Exception e2) {
                SharedPreferences.Editor edit3 = j.G.edit();
                edit3.putBoolean("CANCELLED", true);
                edit3.apply();
                MyApplication.E("Exception");
                j.F(j.this, true);
                j jVar3 = j.this;
                jVar3.z = true;
                j.b(jVar3, false);
                MyApplication.E("Retrying " + e2.getMessage());
                return null;
            }
        }

        public final /* synthetic */ void d() {
            j jVar = j.this;
            jVar.y++;
            w.P0(j.H(jVar), "Retrying (" + j.this.y + "/10)");
            j.C(j.this);
        }

        public final /* synthetic */ void e() {
            j jVar = j.this;
            jVar.y++;
            w.P0(j.H(jVar), "Retrying (" + j.this.y + "/10)");
            j.C(j.this);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            Handler handler;
            Runnable aVar;
            j jVar;
            String string;
            try {
                if (this.a != null) {
                    MyApplication.E("outputFile found");
                    if (j.E(j.this)) {
                        MyApplication.E("retrying" + j.this.z);
                        if (j.this.z) {
                            MyApplication.E("retrying true");
                            j jVar2 = j.this;
                            if (jVar2.y >= 10) {
                                MyApplication.E("DownloadFailed");
                                w.P0(j.H(j.this), j.H(j.this).getResources().getString(a7.j.a));
                                j jVar3 = j.this;
                                jVar3.z = false;
                                j.m(jVar3, true);
                                jVar = j.this;
                                string = j.H(jVar).getResources().getString(a7.j.X1);
                                j.i(jVar, string);
                            } else {
                                jVar2.z = true;
                                handler = new Handler();
                                aVar = new l(this);
                                handler.postDelayed(aVar, 10000L);
                            }
                        }
                    } else {
                        if (System.currentTimeMillis() / 1000 < j.A(j.this)) {
                            j.b(j.this, false);
                            MyApplication.E("Recording retry with playback error");
                            j jVar4 = j.this;
                            if (jVar4.y >= 10) {
                                MyApplication.E("DownloadFailed");
                                w.P0(j.H(j.this), j.H(j.this).getResources().getString(a7.j.a));
                                j jVar5 = j.this;
                                jVar5.z = false;
                                j.m(jVar5, true);
                                jVar = j.this;
                                string = j.H(jVar).getResources().getString(a7.j.X1);
                            } else {
                                jVar4.z = true;
                                handler = new Handler();
                                aVar = new k(this);
                                handler.postDelayed(aVar, 10000L);
                            }
                        } else {
                            MyApplication.E("completed");
                            jVar = j.this;
                            string = j.H(jVar).getResources().getString(a7.j.q0);
                        }
                        j.i(jVar, string);
                    }
                } else {
                    MyApplication.E("outputFile null");
                    j jVar6 = j.this;
                    if (jVar6.z) {
                        if (jVar6.y >= 10) {
                            jVar6.z = false;
                            j.m(jVar6, true);
                            jVar = j.this;
                            string = j.H(jVar).getResources().getString(a7.j.X1);
                            j.i(jVar, string);
                        } else {
                            jVar6.z = true;
                            handler = new Handler();
                            aVar = new a();
                            handler.postDelayed(aVar, 10000L);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                j.m(j.this, true);
                j jVar7 = j.this;
                j.i(jVar7, j.H(jVar7).getResources().getString(a7.j.X1));
            }
            super.onPostExecute(r12);
        }

        public void onCancelled() {
            super.onCancelled();
            MyApplication.E("DownloadingTask cancelled");
            if (j.q(j.this) != null) {
                j.q(j.this).disconnect();
            }
            FileOutputStream fileOutputStream = this.a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            j.i(j.this, "stopped");
            if (j.D(j.this) != null) {
                j.D(j.this).a();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            j.n(j.this);
            j.o(j.this);
        }

        public /* synthetic */ b(j jVar, a aVar) {
            this();
        }
    }

    public interface c {
        void a();
    }

    public j(String str, int i, String str2, boolean z, String str3) {
        this.f = "";
        this.g = "";
        this.r = true;
        Context m = MyApplication.m();
        this.a = m;
        this.f = str;
        int i2 = i * 60;
        int i3 = i * 60000;
        this.c = i3;
        this.e = i3;
        this.b = i2;
        this.r = z;
        this.d = str3;
        this.g = str2;
        G = z0.b.a(m);
        S();
    }

    public static /* synthetic */ long A(j jVar) {
        return jVar.x;
    }

    public static /* synthetic */ long B(j jVar, long j) {
        jVar.x = j;
        return j;
    }

    public static /* synthetic */ void C(j jVar) {
        jVar.S();
    }

    public static /* synthetic */ c D(j jVar) {
        return jVar.E;
    }

    public static /* synthetic */ boolean E(j jVar) {
        return jVar.v;
    }

    public static /* synthetic */ boolean F(j jVar, boolean z) {
        jVar.v = z;
        return z;
    }

    public static /* synthetic */ int[] G(j jVar) {
        return jVar.A;
    }

    public static /* synthetic */ Context H(j jVar) {
        return jVar.a;
    }

    public static /* synthetic */ Notification I(j jVar) {
        return jVar.k;
    }

    public static /* synthetic */ Notification J(j jVar, Notification notification) {
        jVar.k = notification;
        return notification;
    }

    public static /* synthetic */ String K(int i) {
        return O(i);
    }

    public static /* synthetic */ int L(j jVar) {
        return jVar.e;
    }

    public static /* synthetic */ l.e M(j jVar) {
        return jVar.l;
    }

    public static String O(int i) {
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)});
    }

    public static void U(Context context, String str) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("downloadStatus", 0);
            F = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("downloadStatus", str);
            edit.apply();
        }
    }

    public static /* synthetic */ boolean a(j jVar) {
        return jVar.p;
    }

    public static /* synthetic */ boolean b(j jVar, boolean z) {
        jVar.p = z;
        return z;
    }

    public static /* synthetic */ CountDownTimer c(j jVar) {
        return jVar.t;
    }

    public static /* synthetic */ boolean d(j jVar) {
        return jVar.w;
    }

    public static /* synthetic */ CountDownTimer e(j jVar, CountDownTimer countDownTimer) {
        jVar.t = countDownTimer;
        return countDownTimer;
    }

    public static /* synthetic */ int f(j jVar) {
        return jVar.b;
    }

    public static /* synthetic */ int g(j jVar, int i) {
        jVar.b = i;
        return i;
    }

    public static /* synthetic */ void h(Context context, String str) {
        U(context, str);
    }

    public static /* synthetic */ void i(j jVar, String str) {
        jVar.V(str);
    }

    public static /* synthetic */ boolean j(j jVar) {
        return jVar.o;
    }

    public static /* synthetic */ boolean k(j jVar, boolean z) {
        jVar.o = z;
        return z;
    }

    public static /* synthetic */ boolean l(j jVar) {
        return jVar.q;
    }

    public static /* synthetic */ boolean m(j jVar, boolean z) {
        jVar.q = z;
        return z;
    }

    public static /* synthetic */ void n(j jVar) {
        jVar.Q();
    }

    public static /* synthetic */ void o(j jVar) {
        jVar.N();
    }

    public static /* synthetic */ String p(j jVar) {
        return jVar.f;
    }

    public static /* synthetic */ HttpURLConnection q(j jVar) {
        return jVar.B;
    }

    public static /* synthetic */ HttpURLConnection r(j jVar, HttpURLConnection httpURLConnection) {
        jVar.B = httpURLConnection;
        return httpURLConnection;
    }

    public static /* synthetic */ int s(j jVar) {
        return jVar.c;
    }

    public static /* synthetic */ String t(j jVar) {
        return jVar.d;
    }

    public static /* synthetic */ String u(j jVar, String str) {
        jVar.d = str;
        return str;
    }

    public static /* synthetic */ int v(j jVar, int i) {
        jVar.c = i;
        return i;
    }

    public static /* synthetic */ String w(j jVar) {
        return jVar.h;
    }

    public static /* synthetic */ String x(j jVar, String str) {
        jVar.h = str;
        return str;
    }

    public static /* synthetic */ String y(j jVar) {
        return jVar.g;
    }

    public static /* synthetic */ String z(j jVar, Object obj) {
        String str = jVar.g + obj;
        jVar.g = str;
        return str;
    }

    public final void N() {
        SharedPreferences a2 = z0.b.a(this.a);
        G = a2;
        SharedPreferences.Editor edit = a2.edit();
        edit.putBoolean("CANCELLED", false);
        edit.apply();
        PendingIntent a3 = NotificationActivity.a(this.n, this.a);
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        this.l.a(a7.e.A2, "Stop", a3);
    }

    public void P(c cVar) {
        this.E = cVar;
    }

    public final void Q() {
        NotificationManager notificationManager;
        int i;
        Notification c2;
        NotificationManager notificationManager2 = this.i;
        if (notificationManager2 != null) {
            notificationManager2.cancelAll();
        }
        NotificationManager notificationManager3 = this.j;
        if (notificationManager3 != null) {
            notificationManager3.cancelAll();
        }
        if (!this.z) {
            Context context = this.a;
            Toast.makeText(context, context.getResources().getString(a7.j.e1), 0).show();
        }
        this.i = (NotificationManager) this.a.getSystemService("notification");
        l.e eVar = new l.e(this.a);
        this.l = eVar;
        if (Build.VERSION.SDK_INT >= 26) {
            com.amplifyframework.storage.s3.service.c.a();
            NotificationChannel a2 = com.amplifyframework.storage.s3.service.b.a("ksjadf87", this.a.getResources().getString(a7.j.Y5), 2);
            this.k = com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.b.a(new Notification.Builder(this.a).setContentTitle(this.a.getResources().getString(a7.j.U2)).setContentText(this.a.getResources().getString(a7.j.Y5)).setSmallIcon(a7.i.a), "ksjadf87").setProgress(100, 0, true).build();
            com.amplifyframework.storage.s3.service.a.a(this.i, a2);
            notificationManager = this.i;
            i = this.n;
            c2 = this.k;
        } else {
            eVar.n(this.a.getResources().getString(a7.j.U2)).B(100, 0, true).m(this.a.getResources().getString(a7.j.Y5)).D(a7.i.a);
            notificationManager = this.i;
            i = this.n;
            c2 = this.l.c();
        }
        notificationManager.notify(i, c2);
        R();
    }

    public final void R() {
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.t;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.s = new a(20000L, 1000L).start();
    }

    public final void S() {
        b bVar = new b(this, null);
        this.D = bVar;
        bVar.execute(new Void[0]);
    }

    public void T() {
        MyApplication.E("downloadingTask: " + this.D);
        MyApplication.E("countDownTimer: " + this.s);
        MyApplication.E("countDownTimerInternal: " + this.t);
        b bVar = this.D;
        if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.D.cancel(true);
        }
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.s = null;
        }
        CountDownTimer countDownTimer2 = this.t;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.t = null;
        }
        V("stopped");
    }

    public final void V(String str) {
        Context context;
        Resources resources;
        int i;
        this.i.cancelAll();
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.m = new l.e(this.a).D(a7.i.a).n(this.a.getResources().getString(a7.j.U2));
        if (str.equals("completed")) {
            U(this.a, "completed");
            this.w = true;
            this.m.m(this.a.getResources().getString(a7.j.X0));
            if (!this.z) {
                context = this.a;
                resources = context.getResources();
                i = a7.j.X0;
                Toast.makeText(context, resources.getString(i), 0).show();
            }
        } else if (str.equals("failed")) {
            U(this.a, "failed");
            this.m.m(this.a.getResources().getString(a7.j.Y0));
            if (!this.z) {
                context = this.a;
                resources = context.getResources();
                i = a7.j.Y0;
                Toast.makeText(context, resources.getString(i), 0).show();
            }
        } else if (str.equals("stopped")) {
            U(this.a, "stopped");
            this.m.m(this.a.getResources().getString(a7.j.f1));
            if (!this.z) {
                context = this.a;
                resources = context.getResources();
                i = a7.j.f1;
                Toast.makeText(context, resources.getString(i), 0).show();
            }
        }
        NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
        this.j = notificationManager;
        if (notificationManager != null) {
            notificationManager.notify(455, this.m.c());
        }
    }
}
