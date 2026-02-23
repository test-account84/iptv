package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import a7.k;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.TicketMessageAdapter;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.TickedMessageModelClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.TicketModelClass;
import java.util.Calendar;
import java.util.List;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ViewTicketActivity extends b implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public RecyclerView g;
    public TextView h;
    public Button i;
    public Button j;
    public SpinKitView k;
    public TextView l;
    public LinearLayout m;
    public List n;
    public AlertDialog p;
    public RecyclerView.g r;
    public Context s;
    public Bundle d = null;
    public String o = "";
    public String q = "";
    public Thread t = null;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ViewTicketActivity.v1(ViewTicketActivity.this));
                String A = w.A(date);
                TextView textView = ViewTicketActivity.this.e;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ViewTicketActivity.this.f;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class 2 implements Callback {
        public final /* synthetic */ AlertDialog a;

        public 2(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public void onFailure(Call call, Throwable th) {
            Toast.makeText(ViewTicketActivity.v1(ViewTicketActivity.this), "Network error occured! Please try again", 0).show();
            w.X();
        }

        public void onResponse(Call call, Response response) {
            Context v1;
            String str;
            w.X();
            if (!response.isSuccessful() || response.body() == null) {
                v1 = ViewTicketActivity.v1(ViewTicketActivity.this);
                str = "Response Error";
            } else {
                if (((TicketModelClass) response.body()).a().equals("success")) {
                    Toast.makeText(ViewTicketActivity.this.getApplicationContext(), "Your ticket added successfully", 0).show();
                    AlertDialog alertDialog = this.a;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    ViewTicketActivity.w1(ViewTicketActivity.this);
                    return;
                }
                v1 = ViewTicketActivity.v1(ViewTicketActivity.this);
                str = "Error";
            }
            Toast.makeText(v1, str, 0).show();
        }
    }

    public class 3 implements Callback {
        public 3() {
        }

        public void onFailure(Call call, Throwable th) {
            ViewTicketActivity.this.C1(Boolean.FALSE);
        }

        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful() || response.body() == null || !((TickedMessageModelClass) response.body()).b().equals("success")) {
                ViewTicketActivity.this.C1(Boolean.FALSE);
                return;
            }
            ViewTicketActivity.this.C1(Boolean.TRUE);
            ViewTicketActivity.this.n = ((TickedMessageModelClass) response.body()).a().a();
            List list = ViewTicketActivity.this.n;
            if (list == null || list.size() <= 0) {
                return;
            }
            ViewTicketActivity viewTicketActivity = ViewTicketActivity.this;
            viewTicketActivity.g.setLayoutManager(new LinearLayoutManager(viewTicketActivity));
            ViewTicketActivity viewTicketActivity2 = ViewTicketActivity.this;
            ViewTicketActivity.y1(viewTicketActivity2, new TicketMessageAdapter(ViewTicketActivity.v1(viewTicketActivity2), ViewTicketActivity.this.n));
            ViewTicketActivity viewTicketActivity3 = ViewTicketActivity.this;
            viewTicketActivity3.g.setAdapter(ViewTicketActivity.x1(viewTicketActivity3));
            ViewTicketActivity.x1(ViewTicketActivity.this).w();
        }
    }

    public class 4 implements View.OnClickListener {
        public final /* synthetic */ EditText a;

        public 4(EditText editText) {
            this.a = editText;
        }

        public void onClick(View view) {
            String obj = this.a.getText().toString();
            if (obj != null && obj.equalsIgnoreCase("")) {
                w.P0(ViewTicketActivity.v1(ViewTicketActivity.this), "Please enter message");
            } else {
                ViewTicketActivity viewTicketActivity = ViewTicketActivity.this;
                ViewTicketActivity.z1(viewTicketActivity, obj, viewTicketActivity.p);
            }
        }
    }

    public class 5 implements View.OnClickListener {
        public 5() {
        }

        public void onClick(View view) {
            ViewTicketActivity.this.p.dismiss();
        }
    }

    public class CountDownRunner implements Runnable {
        public CountDownRunner() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ViewTicketActivity.this.A1();
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
            if (!z) {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                return;
            }
            Log.e("id is", "" + this.a.getTag());
            f = z ? 1.09f : 1.0f;
            b(f);
            c(f);
        }
    }

    public static /* synthetic */ Context v1(ViewTicketActivity viewTicketActivity) {
        return viewTicketActivity.s;
    }

    public static /* synthetic */ void w1(ViewTicketActivity viewTicketActivity) {
        viewTicketActivity.u1();
    }

    public static /* synthetic */ RecyclerView.g x1(ViewTicketActivity viewTicketActivity) {
        return viewTicketActivity.r;
    }

    public static /* synthetic */ RecyclerView.g y1(ViewTicketActivity viewTicketActivity, RecyclerView.g gVar) {
        viewTicketActivity.r = gVar;
        return gVar;
    }

    public static /* synthetic */ void z1(ViewTicketActivity viewTicketActivity, String str, AlertDialog alertDialog) {
        viewTicketActivity.B1(str, alertDialog);
    }

    public void A1() {
        runOnUiThread(new 1());
    }

    public final void B1(String str, AlertDialog alertDialog) {
        if (this.s != null) {
            w.M0(this);
            ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).i("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "AddTicketReply", "no", str, ClientSharepreferenceHandler.a(this.s), this.o).enqueue(new 2(alertDialog));
        }
    }

    public void C1(Boolean bool) {
        if (bool.booleanValue()) {
            this.g.setVisibility(0);
            this.i.setVisibility(0);
            this.m.setVisibility(0);
        } else {
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.k.setVisibility(8);
    }

    public void D1() {
        if (this.s != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, k.a);
            View inflate = LayoutInflater.from(this).inflate(g.k4, (ViewGroup) null);
            Button findViewById = inflate.findViewById(f.q1);
            Button findViewById2 = inflate.findViewById(f.l0);
            findViewById.setOnFocusChangeListener(new w.k((View) findViewById, (Activity) this));
            findViewById2.setOnFocusChangeListener(new w.k((View) findViewById2, (Activity) this));
            findViewById.setOnClickListener(new 4(inflate.findViewById(f.h3)));
            findViewById2.setOnClickListener(new 5());
            builder.setView(inflate);
            this.p = builder.create();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(this.p.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.p.show();
            this.p.getWindow().setAttributes(layoutParams);
            this.p.setCancelable(false);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.y0) {
            D1();
        } else if (id == f.l0) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.t1);
        this.e = findViewById(f.gh);
        this.f = findViewById(f.E2);
        this.g = findViewById(f.Cd);
        this.h = findViewById(f.fh);
        this.i = findViewById(f.y0);
        this.j = findViewById(f.l0);
        this.k = findViewById(f.Mc);
        this.l = findViewById(f.fm);
        this.m = findViewById(f.J9);
        this.s = this;
        Thread thread = this.t;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.t = thread2;
            thread2.start();
        }
        Button button = this.i;
        button.setOnFocusChangeListener(new w.k((View) button, (Activity) this));
        Button button2 = this.j;
        button2.setOnFocusChangeListener(new w.k((View) button2, (Activity) this));
        Intent intent = getIntent();
        this.o = intent.getStringExtra("ticketid");
        String stringExtra = intent.getStringExtra("Title");
        this.q = stringExtra;
        if (stringExtra == null || stringExtra.equalsIgnoreCase("")) {
            this.l.setVisibility(8);
        } else {
            this.l.setText("#" + this.q);
        }
        u1();
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.t;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.t.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.t;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.t = thread2;
            thread2.start();
        }
    }

    public final void u1() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).a("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "GetTicket", "no", this.o).enqueue(new 3());
    }
}
