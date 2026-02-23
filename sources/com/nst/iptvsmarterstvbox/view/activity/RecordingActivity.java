package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import a7.k;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import g7.e;
import j$.util.Objects;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import m7.w;
import p7.i0;
import p7.j0;
import q7.Q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RecordingActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static u7.a A;
    public AppBarLayout d;
    public ProgressBar e;
    public RecyclerView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public Button j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public Context p;
    public SharedPreferences q;
    public Q r;
    public RecyclerView.o t;
    public SharedPreferences.Editor u;
    public SharedPreferences v;
    public String y;
    public androidx.appcompat.app.a z;
    public ArrayList s = new ArrayList();
    public Boolean w = Boolean.FALSE;
    public Thread x = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(RecordingActivity.u1(RecordingActivity.this));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            RecordingActivity.this.onBackPressed();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", RecordingActivity.this.getPackageName(), (String) null));
                RecordingActivity.this.startActivityForResult(intent, 101);
                Toast.makeText(RecordingActivity.u1(RecordingActivity.this), RecordingActivity.u1(RecordingActivity.this).getResources().getString(j.o2), 1).show();
            } catch (Exception unused) {
            }
            RecordingActivity.v1(RecordingActivity.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            RecordingActivity.v1(RecordingActivity.this).dismiss();
            RecordingActivity.this.onBackPressed();
        }
    }

    public class e implements e.j {
        public final /* synthetic */ String[] a;

        public e(String[] strArr) {
            this.a = strArr;
        }

        public void a(String str) {
            this.a[0] = str;
            RecordingActivity recordingActivity = RecordingActivity.this;
            RecordingActivity.x1(recordingActivity, RecordingActivity.y1(recordingActivity).edit());
            RecordingActivity.w1(RecordingActivity.this).putString("recordingDir", str);
            RecordingActivity.w1(RecordingActivity.this).apply();
            RecordingActivity.this.k.setText(RecordingActivity.u1(RecordingActivity.this).getResources().getString(j.b9) + str);
            RecordingActivity.this.D1();
            Toast.makeText(RecordingActivity.u1(RecordingActivity.this), RecordingActivity.u1(RecordingActivity.this).getResources().getString(j.k0) + str, 1).show();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(RecordingActivity.u1(RecordingActivity.this));
                String A = w.A(date);
                TextView textView = RecordingActivity.this.i;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = RecordingActivity.this.h;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    RecordingActivity.this.A1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class h implements View.OnFocusChangeListener {
        public final View a;

        public h(View view) {
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
            int i;
            try {
                if (z) {
                    b(1.0f);
                    c(1.0f);
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("3")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("1")) {
                            View view4 = this.a;
                            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("2")) {
                                view = this.a;
                                if (view == null) {
                                    return;
                                } else {
                                    i = a7.e.o2;
                                }
                            } else {
                                view = this.a;
                                i = a7.e.k1;
                            }
                        } else {
                            view = this.a;
                        }
                    } else {
                        b(1.0f);
                        c(1.0f);
                    }
                    i = a7.e.h;
                } else {
                    if (z) {
                        return;
                    }
                    b(1.0f);
                    c(1.0f);
                    a(z);
                    View view5 = this.a;
                    if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("3")) {
                        View view6 = this.a;
                        if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("1")) {
                            View view7 = this.a;
                            if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("2")) {
                                view = this.a;
                                if (view == null) {
                                    return;
                                } else {
                                    i = a7.c.z;
                                }
                            } else {
                                view = this.a;
                            }
                        } else {
                            view = this.a;
                        }
                    } else {
                        b(1.0f);
                        c(1.0f);
                    }
                    i = a7.e.o;
                }
                view.setBackgroundResource(i);
            } catch (Exception unused) {
            }
        }
    }

    private void B1() {
        Button button = this.j;
        if (button != null) {
            button.setOnFocusChangeListener(new h(button));
            this.j.requestFocus();
            this.j.requestFocusFromTouch();
            this.j.setBackgroundResource(a7.e.h);
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setOnFocusChangeListener(new h(textView));
        }
    }

    public static /* synthetic */ Context u1(RecordingActivity recordingActivity) {
        return recordingActivity.p;
    }

    public static /* synthetic */ androidx.appcompat.app.a v1(RecordingActivity recordingActivity) {
        return recordingActivity.z;
    }

    public static /* synthetic */ SharedPreferences.Editor w1(RecordingActivity recordingActivity) {
        return recordingActivity.u;
    }

    public static /* synthetic */ SharedPreferences.Editor x1(RecordingActivity recordingActivity, SharedPreferences.Editor editor) {
        recordingActivity.u = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences y1(RecordingActivity recordingActivity) {
        return recordingActivity.v;
    }

    private void z1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public void A1() {
        runOnUiThread(new f());
    }

    public void C1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void D1() {
        if (this.p != null) {
            this.m.setVisibility(8);
            this.g.setVisibility(8);
            this.l.setVisibility(0);
            this.v = this.p.getSharedPreferences("recordingDir", 0);
            this.k.setText(getResources().getString(j.c9) + this.v.getString("recordingDir", String.valueOf(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters"))));
            File[] O = w.O(this.p);
            if (O == null || O.length <= 0) {
                this.s.clear();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.p);
                this.t = linearLayoutManager;
                this.f.setLayoutManager(linearLayoutManager);
                this.r = new Q(this, this.s);
                this.f.setItemAnimator(new androidx.recyclerview.widget.c());
                this.f.setAdapter(this.r);
                this.g.setVisibility(0);
                this.g.setText(getResources().getString(j.z4));
                return;
            }
            this.s.clear();
            for (File file : O) {
                if (file.toString().endsWith(".ts")) {
                    this.s.addAll(Arrays.asList(new File[]{file}));
                }
            }
            if (this.s.size() > 0) {
                this.l.setVisibility(0);
                this.g.setVisibility(8);
                this.m.setFocusable(false);
            } else {
                this.g.setVisibility(0);
                this.g.setText(getResources().getString(j.z4));
                this.g.setClickable(false);
                this.l.setVisibility(0);
            }
            this.t = new LinearLayoutManager(this.p);
            Collections.reverse(this.s);
            this.f.setLayoutManager(this.t);
            this.r = new Q(this, this.s);
            this.f.setItemAnimator(new androidx.recyclerview.widget.c());
            this.f.setAdapter(this.r);
        }
    }

    public void E1() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && i < 33) {
                if (j0.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && j0.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    return;
                }
                D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
            }
        } catch (Exception unused) {
        }
    }

    public void F1(File file, RecordingActivity recordingActivity) {
        if (recordingActivity == null || this.r == null || this.s == null || this.g == null) {
            return;
        }
        new w().K0(recordingActivity, file, this.r, this.s, this.g);
    }

    public void b() {
        ProgressBar progressBar = this.e;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        if (i == 101) {
            try {
                E1();
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        try {
            if (id == a7.f.wk) {
                E1();
            } else {
                if (id != a7.f.xk) {
                    if (id == a7.f.Bj) {
                        startActivity(new Intent(this, NewDashboardActivity.class));
                        return;
                    }
                    if (id == a7.f.m0) {
                        g7.e eVar = new g7.e(this.p, new e(new String[]{""}));
                        if (Build.VERSION.SDK_INT >= 30) {
                            eVar.E("");
                            return;
                        } else {
                            eVar.D("");
                            return;
                        }
                    }
                    return;
                }
                Toast.makeText(this, this.p.getResources().getString(j.o2), 1).show();
                this.w = Boolean.TRUE;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
                startActivityForResult(intent, 101);
            }
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        this.p = this;
        C1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.p);
        A = aVar;
        String A2 = aVar.A();
        this.y = A2;
        setContentView(A2.equals(m7.a.K0) ? a7.g.x0 : a7.g.w0);
        this.d = findViewById(a7.f.W);
        this.e = findViewById(a7.f.ec);
        this.f = findViewById(a7.f.ub);
        this.g = findViewById(a7.f.wk);
        this.h = findViewById(a7.f.E2);
        this.i = findViewById(a7.f.gh);
        this.j = findViewById(a7.f.m0);
        this.k = findViewById(a7.f.pl);
        this.l = findViewById(a7.f.ff);
        this.m = findViewById(a7.f.xk);
        this.n = findViewById(a7.f.Xa);
        this.o = findViewById(a7.f.F4);
        this.g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.m.setOnClickListener(this);
        z1();
        B1();
        overridePendingTransition(a7.b.f, a7.b.d);
        AppBarLayout appBarLayout = this.d;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        getWindow().setFlags(1024, 1024);
        E1();
        D1();
        this.n.setOnClickListener(new a());
        this.o.setOnClickListener(new b());
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new g());
            this.x = thread2;
            thread2.start();
        }
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

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
                E1();
            } else if (Build.VERSION.SDK_INT < 23 || i0.a(this, strArr[0])) {
                onBackPressed();
            } else {
                a.a aVar = new a.a(this, k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.requestFocus();
                findViewById.setOnClickListener(new c());
                findViewById2.setOnClickListener(new d());
                aVar.setView(inflate);
                this.z = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.z.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.z.show();
                this.z.getWindow().setAttributes(layoutParams);
                this.z.setCancelable(false);
                this.z.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        C1();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new g());
            this.x = thread2;
            thread2.start();
        }
        w.m(this.p);
        w.z0(this.p);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.q = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.q.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (this.p != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        C1();
    }
}
