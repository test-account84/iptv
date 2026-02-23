package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.CallBacks.InvoiceData;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.UnpaidAdapter;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.InvoicesApiHitClass;
import java.util.Calendar;
import java.util.List;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PaidInvoiceActivity extends b implements InvoiceData {
    public RecyclerView d;
    public TextView e;
    public SpinKitView f;
    public TextView g;
    public TextView h;
    public Context i;

    public class countDown implements Runnable {

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(PaidInvoiceActivity.this.i);
                String A = w.A(date);
                TextView textView = PaidInvoiceActivity.this.g;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = PaidInvoiceActivity.this.h;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            }
        }

        public countDown() {
        }

        public final void a() {
            PaidInvoiceActivity.this.runOnUiThread(new 1());
        }

        public void run() {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            try {
                a();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public void b() {
        this.f.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    public void j0(String str) {
        this.f.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText(getResources().getString(j.y4));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.k0);
        this.d = findViewById(f.Bd);
        this.e = findViewById(f.fh);
        this.f = findViewById(f.Mc);
        this.g = findViewById(f.gh);
        this.h = findViewById(f.E2);
        this.i = this;
        new Thread(new countDown()).start();
        this.d.setLayoutManager(new GridLayoutManager(this, 2));
        new InvoicesApiHitClass(this, this.i, "Paid").a();
    }

    public void w(List list) {
        if (list != null && list.size() > 0) {
            b();
            this.d.setAdapter(new UnpaidAdapter(this.i, list));
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.e.setText(getResources().getString(j.y4));
            this.f.setVisibility(8);
        }
    }
}
