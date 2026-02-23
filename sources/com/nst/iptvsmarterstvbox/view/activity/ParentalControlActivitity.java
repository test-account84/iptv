package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import a7.k;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import d.a;
import java.util.Calendar;
import m7.w;
import s7.b;
import s7.c;
import s7.d;
import s7.e;
import s7.f;
import s7.g;
import s7.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ParentalControlActivitity extends androidx.appcompat.app.b implements View.OnClickListener, h.b, f.b, b.f, g.f, e.f, c.f, d.f {
    public Toolbar d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public Context i;
    public SharedPreferences j;
    public LiveStreamDBHandler k;
    public DatabaseUpdatedStatusDBModel l = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel m = new DatabaseUpdatedStatusDBModel();
    public String n = "";
    public String o = "";
    public Thread p = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(ParentalControlActivitity.u1(ParentalControlActivitity.this));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ParentalControlActivitity.u1(ParentalControlActivitity.this));
                String A = w.A(date);
                TextView textView = ParentalControlActivitity.this.g;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ParentalControlActivitity.this.f;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(ParentalControlActivitity.u1(ParentalControlActivitity.this));
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(ParentalControlActivitity.u1(ParentalControlActivitity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ParentalControlActivitity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static /* synthetic */ Context u1(ParentalControlActivitity parentalControlActivitity) {
        return parentalControlActivitity.i;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void x1() {
        this.i = this;
        this.k = new LiveStreamDBHandler(this.i);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.j = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.j.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else if (this.i != null) {
            s7.h hVar = new s7.h();
            androidx.fragment.app.w m = getSupportFragmentManager().m();
            m.s(17432576, 17432577);
            m.r(a7.f.Y3, hVar, "PARENTAL_CONTROL_SETTINGS");
            m.j();
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.l0);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.Bj);
        this.f = findViewById(a7.f.E2);
        this.g = findViewById(a7.f.gh);
        this.h = findViewById(a7.f.Xa);
        v1();
        r1(findViewById(a7.f.kh));
        x1();
        Thread thread = this.p;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.p = thread2;
            thread2.start();
        }
        this.h.setOnClickListener(new a());
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(a7.h.v);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            if (this.d.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.i) != null) {
            new a.a(context, k.a).setTitle(getResources().getString(j.f3)).f(getResources().getString(j.e3)).j(getResources().getString(j.S8), new d()).g(getResources().getString(j.d4), new c()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.i.getResources().getString(j.u0));
            aVar.f(this.i.getResources().getString(j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.i.getResources().getString(j.S8), new e());
            aVar.g(this.i.getResources().getString(j.d4), new f());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.i.getResources().getString(j.u0));
            aVar2.f(this.i.getResources().getString(j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.i.getResources().getString(j.S8), new g());
            aVar2.g(this.i.getResources().getString(j.d4), new h());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.p;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.p.interrupt();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.p;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.p = thread2;
            thread2.start();
        }
        w.m(this.i);
        w.z0(this.i);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.j = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.j.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void w1() {
        runOnUiThread(new b());
    }
}
