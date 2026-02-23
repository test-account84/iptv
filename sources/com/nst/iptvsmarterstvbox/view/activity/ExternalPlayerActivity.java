package com.nst.iptvsmarterstvbox.view.activity;

import a7.g;
import a7.j;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ExternalPlayerActivity extends androidx.appcompat.app.b implements o.b {
    public List d;
    public List e;
    public PackageManager f;
    public Context g;
    public LinearLayout h;
    public LinearLayout i;
    public RecyclerView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public ExternalPlayerDataBase o;
    public u7.a p;
    public AlertDialog n = null;
    public Thread q = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(ExternalPlayerActivity.u1(ExternalPlayerActivity.this));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ExternalPlayerActivity.u1(ExternalPlayerActivity.this));
                String A = w.A(date);
                TextView textView = ExternalPlayerActivity.this.l;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ExternalPlayerActivity.this.k;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public c(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        public void onClick(View view) {
            PopupWindow popupWindow = this.a;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            this.a.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PopupWindow d;

        public d(String str, String str2, PopupWindow popupWindow) {
            this.a = str;
            this.c = str2;
            this.d = popupWindow;
        }

        public void onClick(View view) {
            ExternalPlayerActivity.y1(ExternalPlayerActivity.this, new ExternalPlayerDataBase(ExternalPlayerActivity.u1(ExternalPlayerActivity.this)));
            if (ExternalPlayerActivity.x1(ExternalPlayerActivity.this).CheckPlayerExistense(this.a)) {
                w.P0(ExternalPlayerActivity.u1(ExternalPlayerActivity.this), "Already Added");
            } else {
                ExternalPlayerActivity.x1(ExternalPlayerActivity.this).addExternalPlayer(this.a, this.c);
                w.P0(ExternalPlayerActivity.u1(ExternalPlayerActivity.this), this.a + " " + ExternalPlayerActivity.this.getResources().getString(j.t));
                ExternalPlayerActivity.this.onBackPressed();
            }
            PopupWindow popupWindow = this.d;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            this.d.dismiss();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ExternalPlayerActivity.this.A1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class f extends AsyncTask {
        public f() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Boolean... boolArr) {
            return ExternalPlayerActivity.v1(ExternalPlayerActivity.this);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            List list;
            super.onPostExecute(bool);
            ExternalPlayerActivity.this.h.setVisibility(8);
            if (!bool.booleanValue() || (list = ExternalPlayerActivity.this.e) == null || list.size() <= 0) {
                ExternalPlayerActivity.w1(ExternalPlayerActivity.this, Boolean.FALSE);
                return;
            }
            ExternalPlayerActivity.w1(ExternalPlayerActivity.this, Boolean.TRUE);
            ExternalPlayerActivity externalPlayerActivity = ExternalPlayerActivity.this;
            externalPlayerActivity.j.setLayoutManager(new LinearLayoutManager(ExternalPlayerActivity.u1(externalPlayerActivity), 1, false));
            ExternalPlayerActivity externalPlayerActivity2 = ExternalPlayerActivity.this;
            RecyclerView recyclerView = externalPlayerActivity2.j;
            Context u1 = ExternalPlayerActivity.u1(externalPlayerActivity2);
            ExternalPlayerActivity externalPlayerActivity3 = ExternalPlayerActivity.this;
            recyclerView.setAdapter(new o(u1, externalPlayerActivity3.e, externalPlayerActivity3));
        }

        public void onPreExecute() {
            super.onPreExecute();
            ExternalPlayerActivity.this.i.setVisibility(8);
            ExternalPlayerActivity.this.j.setVisibility(8);
            ExternalPlayerActivity.this.h.setVisibility(0);
        }

        public /* synthetic */ f(ExternalPlayerActivity externalPlayerActivity, a aVar) {
            this();
        }
    }

    private Boolean B1() {
        this.d = new ArrayList();
        this.e = new ArrayList();
        PackageManager packageManager = this.g.getPackageManager();
        this.f = packageManager;
        this.d = packageManager.getInstalledApplications(128);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File("content://media/internal/video/media")), "video/*");
        Iterator it = getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            try {
                this.e.add(this.f.getApplicationInfo(((ResolveInfo) it.next()).activityInfo.packageName, 128));
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return Boolean.TRUE;
    }

    private void C1(Boolean bool) {
        if (bool.booleanValue()) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
        } else {
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        }
    }

    public static /* synthetic */ Context u1(ExternalPlayerActivity externalPlayerActivity) {
        return externalPlayerActivity.g;
    }

    public static /* synthetic */ Boolean v1(ExternalPlayerActivity externalPlayerActivity) {
        return externalPlayerActivity.B1();
    }

    public static /* synthetic */ void w1(ExternalPlayerActivity externalPlayerActivity, Boolean bool) {
        externalPlayerActivity.C1(bool);
    }

    public static /* synthetic */ ExternalPlayerDataBase x1(ExternalPlayerActivity externalPlayerActivity) {
        return externalPlayerActivity.o;
    }

    public static /* synthetic */ ExternalPlayerDataBase y1(ExternalPlayerActivity externalPlayerActivity, ExternalPlayerDataBase externalPlayerDataBase) {
        externalPlayerActivity.o = externalPlayerDataBase;
        return externalPlayerDataBase;
    }

    private void z1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public void A1() {
        runOnUiThread(new b());
    }

    public final void D1(String str, String str2) {
        try {
            View inflate = ((LayoutInflater) this.g.getSystemService("layout_inflater")).inflate(g.c4, findViewById(a7.f.Re));
            PopupWindow popupWindow = new PopupWindow(this.g);
            popupWindow.setContentView(inflate);
            popupWindow.setWidth(-1);
            popupWindow.setHeight(-1);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.h1);
            Button findViewById2 = inflate.findViewById(a7.f.u1);
            inflate.findViewById(a7.f.Di).setText(getResources().getString(j.J));
            findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
            findViewById.setOnClickListener(new c(popupWindow));
            findViewById2.setOnClickListener(new d(str, str2, popupWindow));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void E1() {
        new f(this, null).execute(new Boolean[0]);
    }

    public void onCreate(Bundle bundle) {
        this.g = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.g);
        this.p = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.E : g.D);
        w.Y(this);
        this.h = findViewById(a7.f.B9);
        this.i = findViewById(a7.f.Y8);
        this.j = findViewById(a7.f.Cd);
        this.k = findViewById(a7.f.E2);
        this.l = findViewById(a7.f.gh);
        this.m = findViewById(a7.f.Xa);
        getWindow().setFlags(1024, 1024);
        z1();
        Thread thread = this.q;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new e());
            this.q = thread2;
            thread2.start();
        }
        E1();
        this.m.setOnClickListener(new a());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.q;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.q.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.q;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new e());
            this.q = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        w.z0(this.g);
    }

    public void s0(View view, String str, String str2) {
        D1(str, str2);
    }
}
