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
public class MySerivcesActiviy extends b implements View.OnClickListener {
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public LinearLayout g;
    public LinearLayout h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public AVLoadingIndicatorView l;
    public AVLoadingIndicatorView m;
    public AVLoadingIndicatorView n;
    public AVLoadingIndicatorView o;
    public AVLoadingIndicatorView p;
    public AVLoadingIndicatorView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public Context x;
    public Thread y = null;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            MySerivcesActiviy.this.w1();
        }

        public void onResponse(Call call, Response response) {
            Context u1;
            String str;
            if (!response.isSuccessful() || response.body() == null) {
                u1 = MySerivcesActiviy.u1(MySerivcesActiviy.this);
                str = "" + response.code() + " | Error";
            } else {
                if (((ServicesIncoiveTicketCoutModelClass) response.body()).b().equalsIgnoreCase("success")) {
                    if (((ServicesIncoiveTicketCoutModelClass) response.body()).a().b() == null || ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a() == null || ((ServicesIncoiveTicketCoutModelClass) response.body()).a().c() == null) {
                        return;
                    }
                    int intValue = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().a().intValue();
                    int intValue2 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().b().intValue();
                    int intValue3 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().d().intValue();
                    int intValue4 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().e().intValue();
                    int intValue5 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().f().intValue();
                    int intValue6 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().c().intValue();
                    MySerivcesActiviy.this.r.setText(String.valueOf(intValue));
                    MySerivcesActiviy.this.m.f();
                    MySerivcesActiviy.this.r.setVisibility(0);
                    MySerivcesActiviy.this.s.setText(String.valueOf(intValue2));
                    MySerivcesActiviy.this.n.f();
                    MySerivcesActiviy.this.s.setVisibility(0);
                    MySerivcesActiviy.this.t.setText(String.valueOf(intValue3));
                    MySerivcesActiviy.this.l.f();
                    MySerivcesActiviy.this.t.setVisibility(0);
                    MySerivcesActiviy.this.u.setText(String.valueOf(intValue4));
                    MySerivcesActiviy.this.o.f();
                    MySerivcesActiviy.this.u.setVisibility(0);
                    MySerivcesActiviy.this.v.setText(String.valueOf(intValue5));
                    MySerivcesActiviy.this.p.f();
                    MySerivcesActiviy.this.v.setVisibility(0);
                    MySerivcesActiviy.this.w.setText(String.valueOf(intValue6));
                    MySerivcesActiviy.this.q.f();
                    MySerivcesActiviy.this.w.setVisibility(0);
                    return;
                }
                u1 = MySerivcesActiviy.u1(MySerivcesActiviy.this);
                str = "Failed";
            }
            Toast.makeText(u1, str, 0).show();
        }
    }

    public class 2 implements Runnable {
        public 2() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(MySerivcesActiviy.u1(MySerivcesActiviy.this));
                String A = w.A(date);
                TextView textView = MySerivcesActiviy.this.e;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = MySerivcesActiviy.this.d;
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
                    MySerivcesActiviy.this.v1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;

        public OnFocusChangeAccountListener(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            float f2;
            if (z) {
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("7")) {
                    f2 = z ? 2.0f : 1.0f;
                    b(f2);
                    c(f2);
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                if (this.a.getTag().equals("1")) {
                    view2 = this.a;
                    i = e.c;
                } else if (this.a.getTag().equals("2")) {
                    view2 = this.a;
                    i = e.x;
                } else if (this.a.getTag().equals("3")) {
                    view2 = this.a;
                    i = e.H2;
                } else if (this.a.getTag().equals("4")) {
                    view2 = this.a;
                    i = e.D2;
                } else if (this.a.getTag().equals("5")) {
                    view2 = this.a;
                    i = e.F2;
                } else {
                    if (!this.a.getTag().equals("6")) {
                        return;
                    }
                    view2 = this.a;
                    i = e.c0;
                }
            } else {
                if (z) {
                    return;
                }
                if (this.a.getTag().equals("7")) {
                    f2 = z ? 2.0f : 1.0f;
                    b(f2);
                    c(f2);
                    a(z);
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                if (this.a.getTag().equals("1")) {
                    view2 = this.a;
                    i = e.b;
                } else if (this.a.getTag().equals("2")) {
                    view2 = this.a;
                    i = e.w;
                } else if (this.a.getTag().equals("3")) {
                    view2 = this.a;
                    i = e.G2;
                } else if (this.a.getTag().equals("4")) {
                    view2 = this.a;
                    i = e.C2;
                } else if (this.a.getTag().equals("5")) {
                    view2 = this.a;
                    i = e.E2;
                } else {
                    if (!this.a.getTag().equals("6")) {
                        return;
                    }
                    view2 = this.a;
                    i = e.b0;
                }
            }
            view2.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ Context u1(MySerivcesActiviy mySerivcesActiviy) {
        return mySerivcesActiviy.x;
    }

    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == f.Q6) {
            intent = new Intent(this, ActiveServiceActivity.class);
        } else if (id == f.o7) {
            intent = new Intent(this, CancelledSerivceActivity.class);
        } else if (id == f.m9) {
            intent = new Intent(this, PendingServiceActivity.class);
        } else if (id == f.na) {
            intent = new Intent(this, SuspendedServiceActivity.class);
        } else if (id == f.ra) {
            intent = new Intent(this, TerminatedServiceActivity.class);
        } else if (id != f.o8) {
            return;
        } else {
            intent = new Intent(this, FraudServiceActivity.class);
        }
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.d0);
        this.d = findViewById(f.E2);
        this.e = findViewById(f.gh);
        this.f = findViewById(f.Q6);
        this.g = findViewById(f.o7);
        this.h = findViewById(f.m9);
        this.i = findViewById(f.na);
        this.j = findViewById(f.ra);
        this.k = findViewById(f.o8);
        this.l = findViewById(f.jc);
        this.m = findViewById(f.fc);
        this.n = findViewById(f.gc);
        this.o = findViewById(f.lc);
        this.p = findViewById(f.mc);
        this.q = findViewById(f.hc);
        this.r = findViewById(f.vh);
        this.s = findViewById(f.Qh);
        this.t = findViewById(f.Lk);
        this.u = findViewById(f.Xl);
        this.v = findViewById(f.am);
        this.w = findViewById(f.vj);
        this.x = this;
        Thread thread = this.y;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.y = thread2;
            thread2.start();
        }
        LinearLayout linearLayout = this.f;
        linearLayout.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout));
        LinearLayout linearLayout2 = this.g;
        linearLayout2.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout2));
        LinearLayout linearLayout3 = this.h;
        linearLayout3.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout3));
        LinearLayout linearLayout4 = this.i;
        linearLayout4.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout4));
        LinearLayout linearLayout5 = this.j;
        linearLayout5.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout5));
        LinearLayout linearLayout6 = this.k;
        linearLayout6.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout6));
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.y;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.y.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.y;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.y = thread2;
            thread2.start();
        }
        w1();
    }

    public void v1() {
        runOnUiThread(new 2());
    }

    public void w1() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).h("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "sitcount", "yes", ClientSharepreferenceHandler.a(this.x)).enqueue(new 1());
    }
}
