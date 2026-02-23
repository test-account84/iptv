package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import a7.j;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.io.File;
import java.util.Calendar;
import m7.w;
import n7.c;
import p7.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CheckAppupdateActivity extends androidx.appcompat.app.b implements c.b, View.OnClickListener {
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ProgressBar h;
    public NestedScrollView i;
    public LinearLayout j;
    public Button k;
    public Button l;
    public ImageView m;
    public Context p;
    public u7.a q;
    public n7.c s;
    public String t;
    public String n = "";
    public boolean o = false;
    public Thread r = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(CheckAppupdateActivity.this.p);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(CheckAppupdateActivity.this.p);
                String A = w.A(date);
                TextView textView = CheckAppupdateActivity.this.e;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = CheckAppupdateActivity.this.d;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    CheckAppupdateActivity.this.v1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class d extends AsyncTask {
        public Context a;
        public ProgressDialog b;
        public String c;

        public d(Context context, String str) {
            this.a = context;
            this.c = str;
        }

        public static /* synthetic */ void a(d dVar, DialogInterface dialogInterface) {
            dVar.c(dialogInterface);
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean doInBackground(java.lang.String... r15) {
            /*
                Method dump skipped, instructions count: 230
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.CheckAppupdateActivity.d.doInBackground(java.lang.String[]):java.lang.Boolean");
        }

        public final /* synthetic */ void c(DialogInterface dialogInterface) {
            cancel(true);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            this.b.dismiss();
            if (bool.booleanValue()) {
                CheckAppupdateActivity checkAppupdateActivity = CheckAppupdateActivity.this;
                CheckAppupdateActivity.u1(checkAppupdateActivity, checkAppupdateActivity);
            } else {
                Toast.makeText(CheckAppupdateActivity.this.getApplicationContext(), "Downloading failed. Please try again.", 0).show();
                Log.e("DownloadTask", "Download failed or canceled.");
            }
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            this.b.setMessage("Downloaded " + numArr[0] + "%");
        }

        public void onCancelled() {
            super.onCancelled();
            this.b.dismiss();
            Log.e("DownloadTask", "Download canceled.");
        }

        public void onPreExecute() {
            super.onPreExecute();
            ProgressDialog progressDialog = new ProgressDialog(this.a);
            this.b = progressDialog;
            progressDialog.setMessage("Downloading 0%");
            this.b.setCancelable(false);
            this.b.setOnCancelListener(new l(this));
            this.b.show();
        }
    }

    public static /* synthetic */ void u1(CheckAppupdateActivity checkAppupdateActivity, Activity activity) {
        checkAppupdateActivity.x1(activity);
    }

    public void A1(boolean z) {
        if (!z) {
            this.g.setText(getResources().getString(j.j8) + this.n + " " + getResources().getString(j.k8));
            this.f.setText(getResources().getString(j.D4));
            this.l.setVisibility(8);
            this.k.setText(getResources().getString(j.O));
            this.j.setVisibility(8);
            this.k.requestFocus();
            this.k.requestFocusFromTouch();
            return;
        }
        this.i.setVisibility(0);
        String updateVersionName = SharepreferenceDBHandler.getUpdateVersionName(this.p);
        if (updateVersionName == null || updateVersionName.length() <= 0) {
            return;
        }
        String str = getResources().getString(j.H) + " " + getResources().getString(j.G) + " " + getResources().getString(j.I);
        this.g.setText(str + " " + updateVersionName);
    }

    public void R0() {
        b();
        A1(false);
    }

    public void a() {
        ProgressBar progressBar = this.h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.i.setVisibility(8);
    }

    public void b() {
        ProgressBar progressBar = this.h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.i.setVisibility(0);
    }

    public void f(String str) {
        this.t = str;
        b();
        A1(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        if (i == 101) {
            try {
                this.n = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != f.t1) {
            if (id == f.e1) {
                onBackPressed();
                return;
            }
            return;
        }
        try {
            if (w1(this) && y1()) {
                try {
                    x1(this);
                } catch (Exception unused) {
                    Toast.makeText(this.p, "Latest Version is Already installed", 0).show();
                }
            } else if (w1(this)) {
                this.h.setVisibility(8);
                new d(this, "IPTVSmartersPro.apk").execute(new String[]{this.t});
            } else {
                try {
                    D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("Exception ppp", e2.toString());
        }
    }

    public void onCreate(Bundle bundle) {
        this.p = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.p);
        this.q = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.s : g.r);
        w.Y(this);
        this.d = findViewById(f.E2);
        this.e = findViewById(f.gh);
        this.f = findViewById(f.hi);
        this.g = findViewById(f.gi);
        this.h = findViewById(f.oc);
        this.i = findViewById(f.Ob);
        this.j = findViewById(f.M8);
        this.k = findViewById(f.e1);
        Button findViewById = findViewById(f.t1);
        this.l = findViewById;
        findViewById.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.m = findViewById(f.Xa);
        Thread thread = this.r;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.r = thread2;
            thread2.start();
        }
        try {
            this.n = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Button button = this.l;
        button.setOnFocusChangeListener(new w.k(button, this));
        Button button2 = this.k;
        button2.setOnFocusChangeListener(new w.k(button2, this));
        this.l.requestFocus();
        this.l.requestFocusFromTouch();
        a();
        n7.c cVar = new n7.c(this, this.p);
        this.s = cVar;
        cVar.d();
        this.m.setOnClickListener(new a());
    }

    public void onDestroy() {
        super.onDestroy();
        if (y1()) {
            z1();
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.r;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.r.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        Log.v("TAG", "Permission: " + strArr[0] + "was " + iArr[0]);
        if (Build.VERSION.SDK_INT >= 33) {
            return;
        }
        new d(this, "IPTVSmartersPro.apk").execute(new String[]{this.t});
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.r;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.r = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        w.z0(this.p);
    }

    public void v1() {
        runOnUiThread(new b());
    }

    public final boolean w1(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && i >= 23) {
            return E.b.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && E.b.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public final void x1(Activity activity) {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setDataAndType(FileProvider.f(activity, "com.nst.iptvsmarterstvbox.ApkProvider", new File(activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk")), "application/vnd.android.package-archive");
                intent.setFlags(1);
            } else {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk")), "application/vnd.android.package-archive");
                intent.setFlags(67108864);
            }
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean y1() {
        return new File(this.p.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk").exists();
    }

    public final boolean z1() {
        return new File(this.p.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk").delete();
    }
}
