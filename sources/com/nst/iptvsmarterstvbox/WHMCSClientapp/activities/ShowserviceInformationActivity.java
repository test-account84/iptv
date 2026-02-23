package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import a7.j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ShowserviceInformationActivity extends b {
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public Button m;
    public Button n;
    public TextView o;
    public TextView p;
    public Context q;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public Thread z = null;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            ShowserviceInformationActivity.this.onBackPressed();
        }
    }

    public class 2 implements View.OnClickListener {
        public 2() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(ShowserviceInformationActivity.this, ServicesDashboardActivity.class);
            intent.setFlags(67141632);
            ShowserviceInformationActivity.this.startActivity(intent);
            ShowserviceInformationActivity.this.finish();
        }
    }

    public class 3 implements Runnable {
        public 3() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ShowserviceInformationActivity.this.q);
                String A = w.A(date);
                TextView textView = ShowserviceInformationActivity.this.p;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ShowserviceInformationActivity.this.o;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class CountDownRunner implements Runnable {
        public CountDownRunner() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ShowserviceInformationActivity.this.u1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        String string;
        TextView textView2;
        String string2;
        TextView textView3;
        String string3;
        TextView textView4;
        String string4;
        TextView textView5;
        String string5;
        TextView textView6;
        String string6;
        TextView textView7;
        String string7;
        super.onCreate(bundle);
        setContentView(g.W0);
        this.d = findViewById(f.fm);
        this.e = findViewById(f.Yk);
        this.f = findViewById(f.Rl);
        this.g = findViewById(f.sl);
        this.h = findViewById(f.pk);
        this.i = findViewById(f.rl);
        this.j = findViewById(f.Kh);
        this.k = findViewById(f.Kk);
        this.l = findViewById(f.rj);
        this.m = findViewById(f.Q0);
        this.n = findViewById(f.r1);
        this.o = findViewById(f.E2);
        this.p = findViewById(f.gh);
        this.q = this;
        Thread thread = this.z;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.z = thread2;
            thread2.start();
        }
        Intent intent = getIntent();
        this.r = intent.getStringExtra("product");
        this.s = intent.getStringExtra("status");
        this.t = intent.getStringExtra("Registration_date");
        this.u = intent.getStringExtra("next_due_date");
        this.v = intent.getStringExtra("recurring_amount");
        this.y = intent.getStringExtra("billing_cycle");
        this.w = intent.getStringExtra("payment_method");
        this.x = intent.getStringExtra("first_time_payment");
        if (this.y.equalsIgnoreCase("Free Account")) {
            string2 = "- - -";
            this.h.setText("- - -");
            textView2 = this.i;
        } else {
            String str = this.u;
            if (str == null || str.equalsIgnoreCase("")) {
                textView = this.h;
                string = getResources().getString(j.b);
            } else {
                textView = this.h;
                string = this.u;
            }
            textView.setText(string);
            String str2 = this.v;
            if (str2 == null || str2.equalsIgnoreCase("")) {
                textView2 = this.i;
                string2 = getResources().getString(j.b);
            } else {
                textView2 = this.i;
                string2 = ClientSharepreferenceHandler.d(this.q) + this.v + ClientSharepreferenceHandler.e(this.q);
            }
        }
        textView2.setText(string2);
        String str3 = this.r;
        if (str3 == null || str3.equalsIgnoreCase("")) {
            textView3 = this.e;
            string3 = getResources().getString(j.b);
        } else {
            textView3 = this.e;
            string3 = this.r;
        }
        textView3.setText(string3);
        String str4 = this.s;
        if (str4 == null || str4.equalsIgnoreCase("")) {
            this.f.setText(getResources().getString(j.b));
            this.d.setVisibility(8);
        } else {
            this.f.setText(this.s);
            this.d.setText(this.s + " Service Information");
        }
        String str5 = this.t;
        if (str5 == null || str5.equalsIgnoreCase("")) {
            textView4 = this.g;
            string4 = getResources().getString(j.b);
        } else {
            textView4 = this.g;
            string4 = this.t;
        }
        textView4.setText(string4);
        String str6 = this.y;
        if (str6 == null || str6.equalsIgnoreCase("")) {
            textView5 = this.j;
            string5 = getResources().getString(j.b);
        } else {
            textView5 = this.j;
            string5 = this.y;
        }
        textView5.setText(string5);
        String str7 = this.w;
        if (str7 == null || str7.equalsIgnoreCase("")) {
            textView6 = this.k;
            string6 = getResources().getString(j.b);
        } else {
            textView6 = this.k;
            string6 = this.w;
        }
        textView6.setText(string6);
        String str8 = this.x;
        if (str8 == null || str8.equalsIgnoreCase("")) {
            textView7 = this.l;
            string7 = getResources().getString(j.b);
        } else {
            textView7 = this.l;
            string7 = ClientSharepreferenceHandler.d(this.q) + this.x + ClientSharepreferenceHandler.e(this.q);
        }
        textView7.setText(string7);
        this.m.setOnClickListener(new 1());
        this.n.setOnClickListener(new 2());
        Button button = this.n;
        button.setOnFocusChangeListener(new w.k((View) button, (Activity) this));
        Button button2 = this.m;
        button2.setOnFocusChangeListener(new w.k((View) button2, (Activity) this));
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.z;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.z.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.z;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.z = thread2;
            thread2.start();
        }
    }

    public void u1() {
        runOnUiThread(new 3());
    }
}
