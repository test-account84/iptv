package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RateUsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Button d;
    public Button e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public Context i;
    public u7.a j;
    public Thread k = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(RateUsActivity.this.i);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(RateUsActivity.this.i);
                String A = w.A(date);
                TextView textView = RateUsActivity.this.g;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = RateUsActivity.this.f;
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
                    RateUsActivity.this.u1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != f.m1) {
            if (id == f.e1) {
                SharepreferenceDBHandler.setRateUsCount(0, this.i);
                onBackPressed();
                return;
            }
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName()));
            SharepreferenceDBHandler.setRateUsDontaskagain(true, this.i);
            startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this.i, getResources().getString(j.O0), 0).show();
        }
    }

    public void onCreate(Bundle bundle) {
        this.i = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.i);
        this.j = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.v0 : g.u0);
        this.d = findViewById(f.m1);
        this.e = findViewById(f.e1);
        this.f = findViewById(f.E2);
        this.g = findViewById(f.gh);
        this.h = findViewById(f.Xa);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        Button button = this.d;
        button.setOnFocusChangeListener(new w.k(button, this));
        this.d.requestFocus();
        this.d.requestFocusFromTouch();
        Button button2 = this.e;
        button2.setOnFocusChangeListener(new w.k(button2, this));
        Thread thread = this.k;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.k = thread2;
            thread2.start();
        }
        this.h.setOnClickListener(new a());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.k;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.k.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.k;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.k = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void u1() {
        runOnUiThread(new b());
    }
}
