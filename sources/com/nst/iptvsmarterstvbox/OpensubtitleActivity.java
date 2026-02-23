package com.nst.iptvsmarterstvbox;

import a7.k;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class OpensubtitleActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public RadioGroup h;
    public RadioButton i;
    public RadioButton j;
    public RadioButton k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public Context o;
    public SharedPreferences p;
    public SharedPreferences.Editor q;
    public LiveStreamDBHandler r;
    public u7.a w;
    public DatabaseUpdatedStatusDBModel s = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel t = new DatabaseUpdatedStatusDBModel();
    public String u = "";
    public String v = "";
    public Thread x = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(OpensubtitleActivity.u1(OpensubtitleActivity.this));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(OpensubtitleActivity.u1(OpensubtitleActivity.this));
                String A = w.A(date);
                if (OpensubtitleActivity.v1(OpensubtitleActivity.this) != null) {
                    OpensubtitleActivity.v1(OpensubtitleActivity.this).setText(R);
                }
                if (OpensubtitleActivity.w1(OpensubtitleActivity.this) != null) {
                    OpensubtitleActivity.w1(OpensubtitleActivity.this).setText(A);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(OpensubtitleActivity.u1(OpensubtitleActivity.this));
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(OpensubtitleActivity.u1(OpensubtitleActivity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    OpensubtitleActivity.this.y1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
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
                        this.a.setBackground(OpensubtitleActivity.this.getResources().getDrawable(a7.e.K1));
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

    private void A1() {
        RadioButton radioButton;
        this.o = this;
        this.r = new LiveStreamDBHandler(this.o);
        SharedPreferences sharedPreferences = getSharedPreferences("allowedFormatsubtitle", 0);
        this.p = sharedPreferences;
        String string = sharedPreferences.getString("allowedFormatsubtitle", "default");
        if (string.equals("disable")) {
            this.k.setChecked(true);
            radioButton = this.k;
        } else if (!string.equals("default") && string.equals("vip")) {
            this.i.setChecked(true);
            radioButton = this.i;
        } else {
            this.j.setChecked(true);
            radioButton = this.j;
        }
        radioButton.requestFocus();
    }

    public static /* synthetic */ Context u1(OpensubtitleActivity opensubtitleActivity) {
        return opensubtitleActivity.o;
    }

    public static /* synthetic */ TextView v1(OpensubtitleActivity opensubtitleActivity) {
        return opensubtitleActivity.m;
    }

    public static /* synthetic */ TextView w1(OpensubtitleActivity opensubtitleActivity) {
        return opensubtitleActivity.l;
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        SharedPreferences.Editor editor;
        String str;
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (id == a7.f.E0) {
            RadioButton findViewById = findViewById(this.h.getCheckedRadioButtonId());
            SharedPreferences sharedPreferences = getSharedPreferences("allowedFormatsubtitle", 0);
            this.p = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.q = edit;
            if (edit == null) {
                Toast.makeText(this, getResources().getString(a7.j.j5), 0).show();
                return;
            }
            if (findViewById.getText().toString().equals(getResources().getString(a7.j.j))) {
                SharepreferenceDBHandler.setOpenSubtitle(this.o, true);
                editor = this.q;
                str = "vip";
            } else if (findViewById.getText().toString().equals(getResources().getString(a7.j.H0))) {
                SharepreferenceDBHandler.setOpenSubtitle(this.o, true);
                editor = this.q;
                str = "default";
            } else {
                SharepreferenceDBHandler.setOpenSubtitle(this.o, false);
                editor = this.q;
                str = "disable";
            }
            editor.putString("allowedFormatsubtitle", str);
            this.q.commit();
            Toast.makeText(this, getResources().getString(a7.j.k5), 0).show();
        } else if (id != a7.f.S0) {
            return;
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.o = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.o);
        this.w = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.j0 : a7.g.i0);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.E0);
        this.g = findViewById(a7.f.S0);
        this.h = findViewById(a7.f.Kd);
        this.i = findViewById(a7.f.xd);
        this.j = findViewById(a7.f.id);
        this.k = findViewById(a7.f.jd);
        this.l = findViewById(a7.f.E2);
        this.m = findViewById(a7.f.gh);
        this.n = findViewById(a7.f.Xa);
        z1();
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        x1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        A1();
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.x = thread2;
            thread2.start();
        }
        this.n.setOnClickListener(new a());
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
            new a.a(context, k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new d()).g(getResources().getString(a7.j.d4), new c()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar.f(this.o.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.o.getResources().getString(a7.j.S8), new e());
            aVar.g(this.o.getResources().getString(a7.j.d4), new f());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.o.getResources().getString(a7.j.u0));
            aVar2.f(this.o.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.o.getResources().getString(a7.j.S8), new g());
            aVar2.g(this.o.getResources().getString(a7.j.d4), new h());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.x;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.x.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.x = thread2;
            thread2.start();
        }
        w.m(this.o);
        w.z0(this.o);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.p = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.p.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public final void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public void y1() {
        runOnUiThread(new b());
    }

    public final void z1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new j(button));
            this.f.requestFocus();
            this.f.requestFocusFromTouch();
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new j(button2));
        }
        RadioButton radioButton = this.i;
        if (radioButton != null) {
            radioButton.setOnFocusChangeListener(new j(radioButton));
        }
        RadioButton radioButton2 = this.j;
        if (radioButton2 != null) {
            radioButton2.setOnFocusChangeListener(new j(radioButton2));
        }
        RadioButton radioButton3 = this.k;
        if (radioButton3 != null) {
            radioButton3.setOnFocusChangeListener(new j(radioButton3));
        }
    }
}
