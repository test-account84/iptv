package com.nst.iptvsmarterstvbox.view.activity;

import Y6.s;
import Y6.t;
import Y6.u;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.chaos.view.PinView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.MobileCodeActiveCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeGenerateCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeVerifyCallBack;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import d.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ActivateOnTVActivity extends androidx.appcompat.app.b implements View.OnClickListener, FirebasePresenter.OnTvCodeProcessListener {
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public EditText j;
    public PinView k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public Context o;
    public SharedPreferences p;
    public u7.a q;
    public FirebasePresenter s;
    public int t;
    public ProgressDialog u;
    public Thread r = null;
    public String v = "";
    public final androidx.activity.result.c w = registerForActivityResult(new s(), new p7.a(this));

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            Log.e("TAG", editable.toString());
            ActivateOnTVActivity.this.v = editable.toString();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d("TAG", "onTextChanged() called with: s = [" + charSequence + "], start = [" + i + "], before = [" + i2 + "], count = [" + i3 + "]");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ActivateOnTVActivity.w1(ActivateOnTVActivity.this));
                String A = w.A(date);
                TextView textView = ActivateOnTVActivity.this.h;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ActivateOnTVActivity.this.g;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            w.j(ActivateOnTVActivity.w1(ActivateOnTVActivity.this));
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(ActivateOnTVActivity.w1(ActivateOnTVActivity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(ActivateOnTVActivity.w1(ActivateOnTVActivity.this));
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ActivateOnTVActivity.this.y1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final View a;

        public k(View view) {
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
            View view3;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                View view4 = this.a;
                if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                    View view5 = this.a;
                    if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                        View view6 = this.a;
                        if (view6 == null || view6.getTag() == null) {
                            return;
                        }
                        this.a.setBackground(ActivateOnTVActivity.this.getResources().getDrawable(a7.e.K1));
                        return;
                    }
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.k1;
                } else {
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.h;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                View view7 = this.a;
                if ((view7 == null || view7.getTag() == null || !this.a.getTag().equals("1")) && ((view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("2"))) {
                    return;
                }
                view3 = this.a;
                i = a7.e.o;
            }
            view3.setBackgroundResource(i);
        }
    }

    private void F1() {
        try {
            ProgressDialog progressDialog = this.u;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            Log.e("honey", "hideProgressDialog");
            this.u.dismiss();
        } catch (Exception unused) {
        }
    }

    private void G1() {
        this.o = this;
    }

    public static /* synthetic */ void u1(ActivateOnTVActivity activateOnTVActivity, t tVar) {
        activateOnTVActivity.H1(tVar);
    }

    public static /* synthetic */ Context w1(ActivateOnTVActivity activateOnTVActivity) {
        return activateOnTVActivity.o;
    }

    private void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void z1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new k(button));
            this.f.requestFocus();
            this.f.requestFocusFromTouch();
        }
    }

    public String A1() {
        return (this.o == null || !m7.a.s.booleanValue()) ? "" : this.o.getSharedPreferences("loginprefsmultiuser", 0).getString("name", "");
    }

    public final String B1() {
        Context context = this.o;
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        return sharedPreferences.getString("serverM3UUrl", "");
    }

    public String C1() {
        Context context = this.o;
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefsserverurl", 0);
        this.p = sharedPreferences;
        return sharedPreferences.getString(m7.a.L, "");
    }

    public String D1() {
        Context context = this.o;
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        return sharedPreferences.getString("username", "");
    }

    public String E1() {
        Context context = this.o;
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        return sharedPreferences.getString("password", "");
    }

    public final /* synthetic */ void H1(t tVar) {
        String str;
        if (tVar.a() != null) {
            String a2 = tVar.a();
            this.v = a2;
            this.k.setText(a2);
            this.f.performClick();
            return;
        }
        Intent b2 = tVar.b();
        if (b2 == null) {
            str = "Cancelled";
        } else if (!b2.hasExtra("MISSING_CAMERA_PERMISSION")) {
            return;
        } else {
            str = "Cancelled due to missing camera permission";
        }
        Toast.makeText(this, str, 1).show();
    }

    public final void I1() {
        try {
            ProgressDialog progressDialog = new ProgressDialog(this.o);
            this.u = progressDialog;
            progressDialog.setCanceledOnTouchOutside(false);
            this.u.setMessage(this.o.getResources().getString(a7.j.t5));
            this.u.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O0(TVCodeVerifyCallBack tVCodeVerifyCallBack) {
    }

    public void S0(MobileCodeActiveCallBack mobileCodeActiveCallBack) {
        try {
            F1();
            if (mobileCodeActiveCallBack == null || mobileCodeActiveCallBack.getResult() == null || mobileCodeActiveCallBack.getSc() == null) {
                return;
            }
            if (!mobileCodeActiveCallBack.getResult().equals("success")) {
                if (mobileCodeActiveCallBack.getResult().equals("error")) {
                    ((mobileCodeActiveCallBack.getMessage() == null || mobileCodeActiveCallBack.getMessage().length() <= 0) ? Toast.makeText(this, getResources().getString(a7.j.e7), 0) : Toast.makeText(this, mobileCodeActiveCallBack.getMessage(), 1)).show();
                    return;
                }
                return;
            }
            if (mobileCodeActiveCallBack.getSc().equalsIgnoreCase(w.o0(m7.a.S0 + "*JNHGHG34534543HSDHSHSSH*&^klih*" + b7.b.b + "*" + new SimpleDateFormat("yyyy-MM").format(new Date())))) {
                Toast.makeText(this, getResources().getString(a7.j.b3), 1).show();
                finish();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void W0() {
    }

    public void n0() {
        try {
            F1();
            Toast.makeText(this, getResources().getString(a7.j.B2), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        J6.b b2 = J6.a.b(i2, i3, intent);
        if (b2 == null) {
            super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        } else {
            if (b2.a() == null) {
                return;
            }
            String a2 = b2.a();
            this.v = a2;
            this.k.setText(a2);
            this.f.performClick();
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (id != a7.f.O0) {
            if (id == a7.f.k2 || id == a7.f.N0) {
                this.w.a(new u().f(ToolbarCaptureActivity.class));
                return;
            }
            return;
        }
        try {
            String str = this.v;
            if (str != null) {
                if (str.length() == 6) {
                    String format = new SimpleDateFormat("yyyy-MM").format(new Date());
                    v1();
                    String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
                    I1();
                    this.s.k(m7.a.S0, m7.a.T0, format, o0, str, D1(), E1(), A1(), C1(), SharepreferenceDBHandler.getCurrentAPPType(this.o), B1(), 0, "", "");
                } else {
                    Toast.makeText(getApplicationContext(), "Please input code that is displaying on your TV.", 1).show();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        ArrayList userDetails;
        this.o = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.q = new u7.a(this.o);
        this.s = new FirebasePresenter(this.o, this);
        this.q.A();
        setContentView(a7.g.c);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.O0);
        this.g = findViewById(a7.f.E2);
        this.h = findViewById(a7.f.gh);
        this.i = findViewById(a7.f.Xa);
        this.j = findViewById(a7.f.a3);
        this.k = findViewById(a7.f.L3);
        this.l = findViewById(a7.f.R2);
        this.m = findViewById(a7.f.k2);
        this.n = findViewById(a7.f.N0);
        this.f.setOnClickListener(this);
        this.m.setOnClickListener(this);
        z1();
        x1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        G1();
        Thread thread = this.r;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.r = thread2;
            thread2.start();
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.o) != null && SharepreferenceDBHandler.getCurrentAPPType(this.o).equalsIgnoreCase("m3u") && (userDetails = new MultiUserDBHandler(this.o).getUserDetails(SharepreferenceDBHandler.getUserID(this.o))) != null && userDetails.size() > 0 && ((MultiUserDBModel) userDetails.get(0)).getM3uType().equalsIgnoreCase("file")) {
            this.l.setText(a7.j.p0);
            this.k.setVisibility(8);
            this.f.setVisibility(8);
        }
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
        this.k.addTextChangedListener(new a());
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
        if (itemId == a7.f.e && (context = this.o) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new e()).g(getResources().getString(a7.j.d4), new d()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar.f(this.o.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.o.getResources().getString(a7.j.S8), new f());
            aVar.g(this.o.getResources().getString(a7.j.d4), new g());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar2.f(this.o.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.o.getResources().getString(a7.j.S8), new h());
            aVar2.g(this.o.getResources().getString(a7.j.d4), new i());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.r;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.r.interrupt();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.r;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.r = thread2;
            thread2.start();
        }
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.p.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void t0() {
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.t = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void x(TVCodeGenerateCallBack tVCodeGenerateCallBack) {
    }

    public void y1() {
        runOnUiThread(new b());
        this.i.setOnClickListener(new c());
    }
}
