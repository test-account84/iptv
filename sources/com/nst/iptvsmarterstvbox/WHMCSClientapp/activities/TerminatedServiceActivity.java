package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.CallBacks.AllServiceApiCallBack;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.MyAllServiceAdapter;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.CommanApiHitClass;
import java.util.ArrayList;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TerminatedServiceActivity extends b implements AllServiceApiCallBack {
    public RecyclerView d;
    public TextView e;
    public SpinKitView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public Context j;
    public Thread k = null;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(TerminatedServiceActivity.this.j);
                String A = w.A(date);
                TextView textView = TerminatedServiceActivity.this.h;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = TerminatedServiceActivity.this.g;
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
                    TerminatedServiceActivity.this.u1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void W(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            b();
            this.d.setAdapter(new MyAllServiceAdapter(this.j, arrayList));
        }
    }

    public void b() {
        this.f.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.g1);
        this.d = findViewById(f.Cd);
        this.e = findViewById(f.tk);
        this.f = findViewById(f.Mc);
        this.g = findViewById(f.E2);
        this.h = findViewById(f.gh);
        TextView findViewById = findViewById(f.fm);
        this.i = findViewById;
        findViewById.setText(getResources().getString(j.R3));
        this.j = this;
        Thread thread = this.k;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.k = thread2;
            thread2.start();
        }
        this.d.setLayoutManager(new GridLayoutManager(this, 2));
        new CommanApiHitClass(this, this.j, "Terminated").a();
    }

    public void onPause() {
        super.onPause();
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
        super.onResume();
        Thread thread = this.k;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.k = thread2;
            thread2.start();
        }
    }

    public void r(String str) {
        Toast.makeText(this.j, "" + str, 0).show();
        this.f.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
    }

    public void u1() {
        runOnUiThread(new 1());
    }
}
