package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.e;
import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.CallBacks.AllServiceApiCallBack;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.CommanApiHitClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.ActiveServiceModelClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.BuyNowModelClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.LoginWHMCSModelClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.ServicesIncoiveTicketCoutModelClass;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.AnnouncementsActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.ArrayList;
import java.util.Calendar;
import m7.a;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ServicesDashboardActivity extends b implements AllServiceApiCallBack, View.OnClickListener {
    public static PopupWindow J;
    public Context A;
    public TextView B;
    public TextView C;
    public Button D;
    public Button E;
    public CountDownTimer H;
    public TextView d;
    public TextView e;
    public AVLoadingIndicatorView f;
    public AVLoadingIndicatorView g;
    public AVLoadingIndicatorView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public TextView q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public LinearLayout u;
    public TextView v;
    public TextView w;
    public Button x;
    public TextView y;
    public TextView z;
    public String F = "";
    public String G = "";
    public Thread I = null;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            w.X();
            ServicesDashboardActivity servicesDashboardActivity = ServicesDashboardActivity.this;
            Toast.makeText(servicesDashboardActivity.A, servicesDashboardActivity.getResources().getString(j.e7), 0).show();
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            if (!response.isSuccessful()) {
                makeText = Toast.makeText(ServicesDashboardActivity.this.A, "", 0);
            } else {
                if (response.body() != null && ((LoginWHMCSModelClass) response.body()).c() != null && ((LoginWHMCSModelClass) response.body()).c().equalsIgnoreCase("success")) {
                    ClientSharepreferenceHandler.g(((LoginWHMCSModelClass) response.body()).a().c(), ServicesDashboardActivity.this.A);
                    ClientSharepreferenceHandler.f(((LoginWHMCSModelClass) response.body()).a().a().intValue(), ServicesDashboardActivity.this.A);
                    ClientSharepreferenceHandler.i(((LoginWHMCSModelClass) response.body()).a().b(), ServicesDashboardActivity.this.A);
                    ClientSharepreferenceHandler.j(((LoginWHMCSModelClass) response.body()).a().d(), ServicesDashboardActivity.this.A);
                    ClientSharepreferenceHandler.k(((LoginWHMCSModelClass) response.body()).a().e(), ServicesDashboardActivity.this.A);
                    ServicesDashboardActivity.x1(ServicesDashboardActivity.this);
                    return;
                }
                makeText = Toast.makeText(ServicesDashboardActivity.this.A, "" + ((LoginWHMCSModelClass) response.body()).b(), 0);
            }
            makeText.show();
        }
    }

    public class 2 implements Runnable {
        public 2() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ServicesDashboardActivity.this.A);
                String A = w.A(date);
                TextView textView = ServicesDashboardActivity.this.e;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ServicesDashboardActivity.this.d;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class 3 implements Callback {
        public 3() {
        }

        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
            Context context;
            String str;
            if (!response.isSuccessful() || response.body() == null) {
                context = ServicesDashboardActivity.this.A;
                str = "" + response.code() + " | Error";
            } else {
                if (((ServicesIncoiveTicketCoutModelClass) response.body()).b().equalsIgnoreCase("success")) {
                    if (((ServicesIncoiveTicketCoutModelClass) response.body()).a().b() == null || ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a() == null || ((ServicesIncoiveTicketCoutModelClass) response.body()).a().c() == null) {
                        return;
                    }
                    int intValue = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().b().a().intValue();
                    int intValue2 = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().a().d().intValue();
                    String a = ((ServicesIncoiveTicketCoutModelClass) response.body()).a().c().a();
                    ServicesDashboardActivity.this.i.setText(String.valueOf(intValue));
                    ServicesDashboardActivity.this.f.f();
                    ServicesDashboardActivity.this.i.setVisibility(0);
                    ServicesDashboardActivity.this.j.setText(String.valueOf(intValue2));
                    ServicesDashboardActivity.this.g.f();
                    ServicesDashboardActivity.this.j.setVisibility(0);
                    ServicesDashboardActivity.this.k.setText(a);
                    ServicesDashboardActivity.this.h.f();
                    ServicesDashboardActivity.this.k.setVisibility(0);
                    return;
                }
                context = ServicesDashboardActivity.this.A;
                str = "Failed";
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    public class 4 implements Callback {
        public final /* synthetic */ String a;

        public 4(String str) {
            this.a = str;
        }

        public void onFailure(Call call, Throwable th) {
            ServicesDashboardActivity.this.u.setVisibility(8);
        }

        public void onResponse(Call call, Response response) {
            TextView textView;
            w.X();
            if (!response.isSuccessful() || response.body() == null || ((BuyNowModelClass) response.body()).a() == null) {
                textView = ServicesDashboardActivity.this.u;
            } else if (((BuyNowModelClass) response.body()).a().equalsIgnoreCase("yes")) {
                ServicesDashboardActivity.this.u.setVisibility(0);
                if (this.a.equals("1")) {
                    ServicesDashboardActivity servicesDashboardActivity = ServicesDashboardActivity.this;
                    servicesDashboardActivity.B1(ClientSharepreferenceHandler.b(servicesDashboardActivity.A), ServicesDashboardActivity.this.v);
                    return;
                } else {
                    ServicesDashboardActivity.this.w.setVisibility(8);
                    textView = ServicesDashboardActivity.this.v;
                }
            } else {
                if (this.a.equals("1")) {
                    ServicesDashboardActivity servicesDashboardActivity2 = ServicesDashboardActivity.this;
                    servicesDashboardActivity2.B1(ClientSharepreferenceHandler.b(servicesDashboardActivity2.A), ServicesDashboardActivity.this.v);
                } else {
                    ServicesDashboardActivity.this.w.setVisibility(8);
                    ServicesDashboardActivity.this.v.setVisibility(8);
                }
                ClientSharepreferenceHandler.h("free trail", ServicesDashboardActivity.this.A);
                textView = ServicesDashboardActivity.this.u;
            }
            textView.setVisibility(8);
        }
    }

    public class 5 implements View.OnClickListener {
        public 5() {
        }

        public void onClick(View view) {
            ServicesDashboardActivity.y1().dismiss();
        }
    }

    public class 6 implements View.OnClickListener {
        public 6() {
        }

        public void onClick(View view) {
            ServicesDashboardActivity.this.finish();
            w.n0(ServicesDashboardActivity.this.A);
            ServicesDashboardActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public class 7 extends CountDownTimer {
        public final /* synthetic */ TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 7(long j, long j2, TextView textView) {
            super(j, j2);
            this.a = textView;
        }

        public void onFinish() {
            this.a.setText(j.l1);
            ServicesDashboardActivity.this.w.setText(j.u);
            ServicesDashboardActivity.this.w.setTextColor(-65536);
            ServicesDashboardActivity.this.v.setTextColor(-65536);
        }

        public void onTick(long j) {
            int i = (int) (j / 1000);
            int i2 = i / 3600;
            int i3 = i - (i2 * 3600);
            int i4 = i3 / 60;
            this.a.setText(" " + String.format("%02d", new Object[]{Integer.valueOf(i2)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i4)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i3 - (i4 * 60))}) + " Hrs");
            if (i2 <= 3) {
                ServicesDashboardActivity.this.w.setTextColor(-65536);
                ServicesDashboardActivity.this.v.setTextColor(-65536);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(1000L);
                alphaAnimation.setStartOffset(20L);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                ServicesDashboardActivity.this.w.startAnimation(alphaAnimation);
                ServicesDashboardActivity.this.v.startAnimation(alphaAnimation);
            }
        }
    }

    public class CountDownRunner implements Runnable {
        public CountDownRunner() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ServicesDashboardActivity.this.z1();
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

        /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00a3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 556
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.ServicesDashboardActivity.OnFocusChangeAccountListener.onFocusChange(android.view.View, boolean):void");
        }
    }

    public static /* synthetic */ void x1(ServicesDashboardActivity servicesDashboardActivity) {
        servicesDashboardActivity.v1();
    }

    public static /* synthetic */ PopupWindow y1() {
        return J;
    }

    public void A1() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).h("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "sitcount", "yes", ClientSharepreferenceHandler.a(this.A)).enqueue(new 3());
    }

    public void B1(int i, TextView textView) {
        this.H = new 7((i * 1000) + 1000, 1000L, textView).start();
    }

    public void C1() {
        if (this.A != null) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(g.r2, findViewById(f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            J = popupWindow;
            popupWindow.setContentView(inflate);
            J.setWidth(-1);
            J.setHeight(-1);
            J.setFocusable(true);
            J.showAtLocation(inflate, 17, 0, 0);
            this.B = inflate.findViewById(f.Ik);
            this.C = inflate.findViewById(f.Ai);
            this.D = inflate.findViewById(f.L0);
            this.E = inflate.findViewById(f.o0);
            TextView textView = this.B;
            if (textView != null) {
                textView.setText(getResources().getString(j.f3));
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                textView2.setText(getResources().getString(j.e3));
            }
            Button button = this.D;
            if (button != null) {
                button.setOnFocusChangeListener(new w.k((View) button, (Activity) this));
            }
            Button button2 = this.E;
            if (button2 != null) {
                button2.setOnFocusChangeListener(new w.k((View) button2, (Activity) this));
            }
            this.E.setOnClickListener(new 5());
            Button button3 = this.D;
            if (button3 != null) {
                button3.setOnClickListener(new 6());
            }
        }
    }

    public void W(ArrayList arrayList) {
        w.X();
        if (arrayList == null || arrayList.size() <= 0 || arrayList.get(0) == null) {
            return;
        }
        this.G = ((ActiveServiceModelClass) arrayList.get(0)).c();
        try {
            Intent intent = new Intent(this, BuyNowActivity.class);
            intent.putExtra("service_id", this.G);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id != f.F5) {
            if (id == f.c) {
                startActivity(new Intent(this, NewDashboardActivity.class));
                finish();
            } else if (id == f.Og) {
                if ((!a.s.booleanValue() || !SharepreferenceDBHandler.getCurrentAPPType(this.A).equals("api")) && (!a.u.booleanValue() || !SharepreferenceDBHandler.getCurrentAPPType(this.A).equals("m3u"))) {
                    C1();
                    return;
                } else {
                    finish();
                    a.b0 = Boolean.TRUE;
                    w.n0(this.A);
                }
            } else if (id == f.Y9) {
                intent = new Intent(this, MySerivcesActiviy.class);
            } else if (id == f.z8) {
                intent = new Intent(this, MyInvoiceActivity.class);
            } else if (id == f.ua) {
                intent = new Intent(this, MyTicketActivity.class);
            } else {
                if (id != f.b6) {
                    if (id == f.T0) {
                        w1();
                        return;
                    }
                    return;
                }
                intent = new Intent(this, SettingsActivity.class);
            }
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        intent = new Intent(this, AnnouncementsActivity.class);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.R0);
        this.d = findViewById(f.E2);
        this.e = findViewById(f.gh);
        this.f = findViewById(f.kc);
        this.g = findViewById(f.ic);
        this.h = findViewById(f.nc);
        this.i = findViewById(f.Hl);
        this.j = findViewById(f.Ej);
        this.k = findViewById(f.dm);
        this.l = findViewById(f.b6);
        this.m = findViewById(f.Og);
        this.n = findViewById(f.F5);
        this.o = findViewById(f.Dk);
        this.p = findViewById(f.c);
        this.q = findViewById(f.rh);
        this.r = findViewById(f.Y9);
        this.s = findViewById(f.z8);
        this.t = findViewById(f.ua);
        this.u = findViewById(f.m7);
        this.v = findViewById(f.xj);
        this.w = findViewById(f.wj);
        this.x = findViewById(f.T0);
        this.y = findViewById(f.Yl);
        this.z = findViewById(f.Kl);
        this.A = this;
        Thread thread = this.I;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.I = thread2;
            thread2.start();
        }
        Button button = this.x;
        button.setOnFocusChangeListener(new OnFocusChangeAccountListener(button));
        ImageView imageView = this.p;
        imageView.setOnFocusChangeListener(new OnFocusChangeAccountListener(imageView));
        ImageView imageView2 = this.l;
        imageView2.setOnFocusChangeListener(new OnFocusChangeAccountListener(imageView2));
        ImageView imageView3 = this.m;
        imageView3.setOnFocusChangeListener(new OnFocusChangeAccountListener(imageView3));
        LinearLayout linearLayout = this.t;
        linearLayout.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout));
        ImageView imageView4 = this.n;
        imageView4.setOnFocusChangeListener(new OnFocusChangeAccountListener(imageView4));
        LinearLayout linearLayout2 = this.s;
        linearLayout2.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout2));
        LinearLayout linearLayout3 = this.r;
        linearLayout3.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout3));
        this.r.requestFocus();
        if (a.s.booleanValue()) {
            return;
        }
        this.m.setImageResource(e.l1);
        this.y.setText(getResources().getString(j.n3));
    }

    public void onPause() {
        super.onPause();
        try {
            CountDownTimer countDownTimer = this.H;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.I;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.I.interrupt();
        } catch (Exception unused2) {
        }
    }

    public void onResume() {
        super.onResume();
        A1();
        this.F = getIntent().getAction();
        Thread thread = this.I;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.I = thread2;
            thread2.start();
        }
        u1();
    }

    public void r(String str) {
        try {
            w.X();
        } catch (Exception unused) {
            w.P0(this.A, str);
        }
    }

    public final void u1() {
        w.M0(this);
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).f("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "validateCustomLogin", "yes", SharepreferenceDBHandler.getUserName(this.A), SharepreferenceDBHandler.getUserPassword(this.A)).enqueue(new 1());
    }

    public final void v1() {
        int a = ClientSharepreferenceHandler.a(this.A);
        String userName = SharepreferenceDBHandler.getUserName(this.A);
        String userPassword = SharepreferenceDBHandler.getUserPassword(this.A);
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).g("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", userName, userPassword, "buyNowButton", "yes", a).enqueue(new 4(SharepreferenceDBHandler.getTrial(this.A)));
    }

    public final void w1() {
        w.M0(this);
        new CommanApiHitClass(this, this.A, "Active").a();
    }

    public void z1() {
        runOnUiThread(new 2());
    }
}
