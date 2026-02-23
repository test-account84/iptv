package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.ServicesIncoiveTicketCoutModelClass;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.Calendar;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyInvoiceActivity extends b implements View.OnClickListener {
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public AVLoadingIndicatorView j;
    public AVLoadingIndicatorView k;
    public AVLoadingIndicatorView l;
    public AVLoadingIndicatorView m;
    public LinearLayout n;
    public LinearLayout o;
    public LinearLayout p;
    public LinearLayout q;
    public Context r;
    public Thread s = null;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            MyInvoiceActivity.this.o.setVisibility(8);
            MyInvoiceActivity.this.q.setVisibility(8);
            MyInvoiceActivity.this.p.setVisibility(8);
            MyInvoiceActivity.this.n.setVisibility(8);
            Toast.makeText(MyInvoiceActivity.u1(MyInvoiceActivity.this), "No Response from server", 0).show();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                Toast.makeText(MyInvoiceActivity.u1(MyInvoiceActivity.this), "" + response.code() + " | Error", 0).show();
                return;
            }
            if (((ServicesIncoiveTicketCoutModelClass) response.body()).a().a() != null) {
                int intValue = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a().b().intValue();
                int intValue2 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a().d().intValue();
                int intValue3 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a().c().intValue();
                int intValue4 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a().a().intValue();
                MyInvoiceActivity.this.f.setText(String.valueOf(intValue));
                MyInvoiceActivity.this.j.setVisibility(8);
                MyInvoiceActivity.this.f.setVisibility(0);
                MyInvoiceActivity.this.g.setText(String.valueOf(intValue2));
                MyInvoiceActivity.this.k.setVisibility(8);
                MyInvoiceActivity.this.g.setVisibility(0);
                MyInvoiceActivity.this.h.setText(String.valueOf(intValue3));
                MyInvoiceActivity.this.l.setVisibility(8);
                MyInvoiceActivity.this.h.setVisibility(0);
                MyInvoiceActivity.this.i.setText(String.valueOf(intValue4));
                MyInvoiceActivity.this.m.setVisibility(8);
                MyInvoiceActivity.this.i.setVisibility(0);
            }
        }
    }

    public class CountTime implements Runnable {

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                try {
                    String date = Calendar.getInstance().getTime().toString();
                    String R = w.R(MyInvoiceActivity.u1(MyInvoiceActivity.this));
                    String A = w.A(date);
                    TextView textView = MyInvoiceActivity.this.d;
                    if (textView != null) {
                        textView.setText(R);
                    }
                    TextView textView2 = MyInvoiceActivity.this.e;
                    if (textView2 != null) {
                        textView2.setText(A);
                    }
                } catch (Exception unused) {
                }
            }
        }

        public CountTime() {
        }

        public final void a() {
            MyInvoiceActivity.this.runOnUiThread(new 1());
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    a();
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class onFocusChange implements View.OnFocusChangeListener {
        public final View a;

        public onFocusChange(View view) {
            this.a = view;
        }

        public void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("7")) {
                    float f = z ? 2.0f : 1.0f;
                    b(f);
                    c(f);
                } else {
                    float f2 = z ? 1.09f : 1.0f;
                    b(f2);
                    c(f2);
                    if (this.a.getTag().equals("1")) {
                        this.a.setBackgroundResource(e.r1);
                    }
                    if (this.a.getTag().equals("2")) {
                        this.a.setBackgroundResource(e.M2);
                    }
                    if (this.a.getTag().equals("3")) {
                        this.a.setBackgroundResource(e.u1);
                    }
                    if (this.a.getTag().equals("4")) {
                        this.a.setBackgroundResource(e.x);
                    }
                }
            }
            if (z) {
                return;
            }
            if (this.a.getTag().equals("7")) {
                float f3 = z ? 2.0f : 1.0f;
                b(f3);
                c(f3);
                a(z);
                return;
            }
            float f4 = z ? 1.09f : 1.0f;
            b(f4);
            c(f4);
            a(z);
            if (this.a.getTag().equals("1")) {
                this.a.setBackgroundResource(e.q1);
            }
            if (this.a.getTag().equals("2")) {
                this.a.setBackgroundResource(e.L2);
            }
            if (this.a.getTag().equals("3")) {
                this.a.setBackgroundResource(e.t1);
            }
            if (this.a.getTag().equals("4")) {
                this.a.setBackgroundResource(e.w);
            }
        }
    }

    public static /* synthetic */ Context u1(MyInvoiceActivity myInvoiceActivity) {
        return myInvoiceActivity.r;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == f.Xb) {
            intent = new Intent(this, PaidInvoiceActivity.class);
        } else if (id == f.zm) {
            intent = new Intent(this, UnpiadInvoiceActivity.class);
        } else if (id == f.z1) {
            intent = new Intent(this, CancelInvoiceActivity.class);
        } else if (id != f.Id) {
            return;
        } else {
            intent = new Intent(this, InvoiceRefundedActivity.class);
        }
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.c0);
        this.d = findViewById(f.gh);
        this.e = findViewById(f.E2);
        this.f = findViewById(f.kg);
        this.g = findViewById(f.mg);
        this.h = findViewById(f.lg);
        this.i = findViewById(f.jg);
        this.j = findViewById(f.Ja);
        this.k = findViewById(f.Ma);
        this.l = findViewById(f.La);
        this.m = findViewById(f.Ka);
        this.n = findViewById(f.zm);
        this.o = findViewById(f.Xb);
        this.p = findViewById(f.Id);
        this.q = findViewById(f.z1);
        this.r = this;
        Thread thread = this.s;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountTime());
            this.s = thread2;
            thread2.start();
        }
        LinearLayout linearLayout = this.o;
        linearLayout.setOnFocusChangeListener(new onFocusChange(linearLayout));
        LinearLayout linearLayout2 = this.n;
        linearLayout2.setOnFocusChangeListener(new onFocusChange(linearLayout2));
        LinearLayout linearLayout3 = this.q;
        linearLayout3.setOnFocusChangeListener(new onFocusChange(linearLayout3));
        LinearLayout linearLayout4 = this.p;
        linearLayout4.setOnFocusChangeListener(new onFocusChange(linearLayout4));
        v1();
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.s;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.s.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.s;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountTime());
            this.s = thread2;
            thread2.start();
        }
    }

    public final void v1() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).h("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "sitcount", "yes", ClientSharepreferenceHandler.a(this.r)).enqueue(new 1());
    }
}
