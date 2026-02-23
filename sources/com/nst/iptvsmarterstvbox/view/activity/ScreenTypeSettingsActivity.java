package com.nst.iptvsmarterstvbox.view.activity;

import a7.e;
import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ScreenTypeSettingsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public RadioGroup k;
    public RadioButton l;
    public RadioButton m;
    public Context n;
    public u7.a o;
    public Thread p = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(ScreenTypeSettingsActivity.u1(ScreenTypeSettingsActivity.this));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ScreenTypeSettingsActivity.u1(ScreenTypeSettingsActivity.this));
                String A = w.A(date);
                TextView textView = ScreenTypeSettingsActivity.this.i;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ScreenTypeSettingsActivity.this.h;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ScreenTypeSettingsActivity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public final View a;

        public d(View view) {
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
                        this.a.setBackground(ScreenTypeSettingsActivity.this.getResources().getDrawable(e.K1));
                        return;
                    }
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = e.k1;
                } else {
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = e.h;
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
                i = e.o;
            }
            view3.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ Context u1(ScreenTypeSettingsActivity screenTypeSettingsActivity) {
        return screenTypeSettingsActivity.n;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void x1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new d(button));
            this.f.requestFocus();
            this.f.requestFocusFromTouch();
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new d(button2));
        }
        RadioButton radioButton = this.l;
        if (radioButton != null) {
            radioButton.setOnFocusChangeListener(new d(radioButton));
        }
        RadioButton radioButton2 = this.m;
        if (radioButton2 != null) {
            radioButton2.setOnFocusChangeListener(new d(radioButton2));
        }
    }

    private void y1() {
        RadioButton radioButton;
        u7.a aVar;
        String str;
        if (this.o.A().equals("")) {
            if ((this.n.getResources().getConfiguration().screenLayout & 15) == 3) {
                aVar = this.o;
                str = m7.a.K0;
            } else {
                aVar = this.o;
                str = m7.a.L0;
            }
            aVar.X(str);
        }
        String A = this.o.A();
        if (A.equals(m7.a.L0)) {
            radioButton = this.l;
        } else if (!A.equals(m7.a.K0)) {
            return;
        } else {
            radioButton = this.m;
        }
        radioButton.setChecked(true);
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        u7.a aVar;
        String str;
        int id = view.getId();
        if (id != f.D0) {
            if (id == f.S0) {
                finish();
                return;
            } else {
                if (id == f.Bj) {
                    startActivity(new Intent(this, NewDashboardActivity.class));
                    overridePendingTransition(a7.b.f, a7.b.d);
                    return;
                }
                return;
            }
        }
        RadioButton findViewById = findViewById(this.k.getCheckedRadioButtonId());
        if (!findViewById.getTag().toString().equals("Mobile")) {
            if (findViewById.getTag().toString().equals("TV")) {
                aVar = this.o;
                str = m7.a.K0;
            }
            Toast.makeText(this, getResources().getString(j.k5), 0).show();
        }
        aVar = this.o;
        str = m7.a.L0;
        aVar.X(str);
        Toast.makeText(this, getResources().getString(j.k5), 0).show();
    }

    public void onCreate(Bundle bundle) {
        this.n = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.n);
        this.o = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.E0 : g.D0);
        w.Y(this);
        this.d = findViewById(f.kh);
        this.e = findViewById(f.W);
        this.f = findViewById(f.D0);
        this.g = findViewById(f.S0);
        this.h = findViewById(f.E2);
        this.i = findViewById(f.gh);
        this.j = findViewById(f.Xa);
        this.k = findViewById(f.Jd);
        this.l = findViewById(f.pd);
        this.m = findViewById(f.vd);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        x1();
        v1();
        r1(findViewById(f.kh));
        getWindow().setFlags(1024, 1024);
        y1();
        Thread thread = this.p;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.p = thread2;
            thread2.start();
        }
        this.j.setOnClickListener(new a());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.p;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.p.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.p;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new c());
            this.p = thread2;
            thread2.start();
        }
        w.m(this.n);
        w.z0(this.n);
    }

    public void w1() {
        runOnUiThread(new b());
    }
}
