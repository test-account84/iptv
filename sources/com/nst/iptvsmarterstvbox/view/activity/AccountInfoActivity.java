package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.ServicesDashboardActivity;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.LoginWHMCSModelClass;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.Calendar;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AccountInfoActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static u7.a B;
    public Toolbar d;
    public AppBarLayout e;
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
    public Button q;
    public TextView r;
    public ImageView s;
    public ImageView t;
    public Context u;
    public ProgressDialog v;
    public SharedPreferences w;
    public LiveStreamDBHandler x;
    public String y = "";
    public String z = "";
    public Thread A = null;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(AccountInfoActivity.v1(AccountInfoActivity.this));
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            w.j(AccountInfoActivity.v1(AccountInfoActivity.this));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            AccountInfoActivity.this.onBackPressed();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            AccountInfoActivity.this.onBackPressed();
        }
    }

    public class h implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                w.n0(AccountInfoActivity.v1(AccountInfoActivity.this));
            }
        }

        public h() {
        }

        public void onClick(View view) {
            new a.a(AccountInfoActivity.this, a7.k.a).setTitle(AccountInfoActivity.this.getResources().getString(a7.j.f3)).f(AccountInfoActivity.this.getResources().getString(a7.j.e3)).j(AccountInfoActivity.this.getResources().getString(a7.j.S8), new b()).g(AccountInfoActivity.this.getResources().getString(a7.j.d4), new a()).n();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            AccountInfoActivity.w1(AccountInfoActivity.this);
        }
    }

    public class j implements Callback {
        public j() {
        }

        public void onFailure(Call call, Throwable th) {
            w.X();
            Toast.makeText(AccountInfoActivity.v1(AccountInfoActivity.this), "error", 0).show();
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            Context v1;
            String str;
            w.X();
            if (response.isSuccessful()) {
                if (response.body() == null || !((LoginWHMCSModelClass) response.body()).c().equalsIgnoreCase("success")) {
                    v1 = AccountInfoActivity.v1(AccountInfoActivity.this);
                    str = "" + ((LoginWHMCSModelClass) response.body()).b();
                } else {
                    ClientSharepreferenceHandler.f(((LoginWHMCSModelClass) response.body()).a().a().intValue(), AccountInfoActivity.v1(AccountInfoActivity.this));
                    ClientSharepreferenceHandler.i(((LoginWHMCSModelClass) response.body()).a().b(), AccountInfoActivity.v1(AccountInfoActivity.this));
                    ClientSharepreferenceHandler.j(((LoginWHMCSModelClass) response.body()).a().d(), AccountInfoActivity.v1(AccountInfoActivity.this));
                    ClientSharepreferenceHandler.k(((LoginWHMCSModelClass) response.body()).a().e(), AccountInfoActivity.v1(AccountInfoActivity.this));
                    AccountInfoActivity.this.startActivity(new Intent(AccountInfoActivity.this, ServicesDashboardActivity.class));
                    v1 = AccountInfoActivity.v1(AccountInfoActivity.this);
                    str = "successfully Login";
                }
                makeText = Toast.makeText(v1, str, 0);
            } else {
                makeText = Toast.makeText(AccountInfoActivity.v1(AccountInfoActivity.this), "", 0);
            }
            makeText.show();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(AccountInfoActivity.v1(AccountInfoActivity.this));
                String A = w.A(date);
                TextView textView = AccountInfoActivity.this.p;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = AccountInfoActivity.this.o;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(AccountInfoActivity.v1(AccountInfoActivity.this));
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    AccountInfoActivity.this.y1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class o implements View.OnFocusChangeListener {
        public final View a;

        public o(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                a(f);
                b(f);
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag().equals("1")) {
                    view2 = this.a;
                    i = a7.e.h;
                } else {
                    if (!this.a.getTag().equals("2")) {
                        return;
                    }
                    view2 = this.a;
                    i = a7.e.k1;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (!this.a.getTag().equals("1") && !this.a.getTag().equals("2")) {
                    return;
                }
                view2 = this.a;
                i = a7.e.o;
            }
            view2.setBackgroundResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A1() {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.AccountInfoActivity.A1():void");
    }

    private void u1() {
        w.M0(this);
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).f("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "validateCustomLogin", "yes", SharepreferenceDBHandler.getUserName(this.u), SharepreferenceDBHandler.getUserPassword(this.u)).enqueue(new j());
    }

    public static /* synthetic */ Context v1(AccountInfoActivity accountInfoActivity) {
        return accountInfoActivity.u;
    }

    public static /* synthetic */ void w1(AccountInfoActivity accountInfoActivity) {
        accountInfoActivity.u1();
    }

    private void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void z1() {
        Button button = this.m;
        if (button != null) {
            button.setOnFocusChangeListener(new o(button));
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
        Button button2 = this.n;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new o(button2));
        }
    }

    public void b() {
        ProgressDialog progressDialog = this.v;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void onCreate(Bundle bundle) {
        this.u = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.u);
        B = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.b : a7.g.a);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.oj);
        this.g = findViewById(a7.f.Jj);
        this.h = findViewById(a7.f.uh);
        this.i = findViewById(a7.f.qi);
        this.j = findViewById(a7.f.ak);
        this.k = findViewById(a7.f.jm);
        this.l = findViewById(a7.f.Rl);
        this.m = findViewById(a7.f.R0);
        this.n = findViewById(a7.f.Ya);
        this.o = findViewById(a7.f.E2);
        this.p = findViewById(a7.f.gh);
        this.q = findViewById(a7.f.T0);
        this.r = findViewById(a7.f.km);
        this.s = findViewById(a7.f.Xa);
        this.t = findViewById(a7.f.F4);
        x1();
        z1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        A1();
        Thread thread = this.A;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new n());
            this.A = thread2;
            thread2.start();
        }
        this.s.setOnClickListener(new e());
        this.m.setOnClickListener(new f());
        this.t.setOnClickListener(new g());
        this.n.setOnClickListener(new h());
        Button button = this.q;
        button.setOnFocusChangeListener(new w.k(button, this));
        this.q.setOnClickListener(new i());
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
        if (itemId == a7.f.e && (context = this.u) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new m()).g(getResources().getString(a7.j.d4), new l()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.u.getResources().getString(a7.j.u0));
            aVar.f(this.u.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.u.getResources().getString(a7.j.S8), new a());
            aVar.g(this.u.getResources().getString(a7.j.d4), new b());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.u.getResources().getString(a7.j.u0));
            aVar2.f(this.u.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.u.getResources().getString(a7.j.S8), new c());
            aVar2.g(this.u.getResources().getString(a7.j.d4), new d());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.A;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.A.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.A;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new n());
            this.A = thread2;
            thread2.start();
        }
        w.m(this.u);
        w.z0(this.u);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.w = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.w.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else if (this.u != null) {
            b();
        }
    }

    public void y1() {
        runOnUiThread(new k());
    }
}
