package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import java.util.ArrayList;
import java.util.Calendar;
import m7.w;
import q7.H;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NewEPGActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public ProgressBar d;
    public TabLayout e;
    public ViewPager f;
    public TextView g;
    public Toolbar h;
    public AppBarLayout i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public Context o;
    public SharedPreferences p;
    public ImageView q;
    public ArrayList s;
    public u7.a w;
    public ArrayList r = new ArrayList();
    public String t = "";
    public String u = "";
    public boolean v = false;
    public Thread x = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(NewEPGActivity.u1(NewEPGActivity.this));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            NewEPGActivity.this.onBackPressed();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(NewEPGActivity.u1(NewEPGActivity.this));
                String A = w.A(date);
                TextView textView = NewEPGActivity.this.m;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = NewEPGActivity.this.l;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    NewEPGActivity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static /* synthetic */ Context u1(NewEPGActivity newEPGActivity) {
        return newEPGActivity.o;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public void b() {
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        if (r4.v == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            int r1 = r5.getKeyCode()
            r2 = 1
            switch(r1) {
                case 20: goto Ld;
                case 21: goto L35;
                case 22: goto L3a;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            boolean r1 = r4.v
            if (r1 != 0) goto L26
        L11:
            android.widget.LinearLayout r5 = r4.k
            r5.requestFocus()
            android.widget.LinearLayout r5 = r4.k
            android.content.Context r0 = r4.o
            int r1 = a7.c.l
            android.graphics.drawable.Drawable r0 = E.b.getDrawable(r0, r1)
            r5.setBackground(r0)
            r4.v = r2
            return r2
        L26:
            if (r0 != 0) goto L35
            android.widget.LinearLayout r0 = r4.k
            android.content.Context r1 = r4.o
            int r3 = a7.e.I2
            android.graphics.drawable.Drawable r1 = E.b.getDrawable(r1, r3)
            r0.setBackground(r1)
        L35:
            boolean r0 = r4.v
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r4.v
            if (r0 != 0) goto L3f
            goto L11
        L3f:
            boolean r5 = super.dispatchKeyEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewEPGActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        x1();
        setContentView(g.f0);
        this.q = findViewById(f.Xa);
        this.d = findViewById(f.ec);
        this.e = findViewById(f.ig);
        this.f = findViewById(f.Om);
        this.g = findViewById(f.Bj);
        this.h = findViewById(f.kh);
        this.i = findViewById(f.W);
        this.j = findViewById(f.Zh);
        this.k = findViewById(f.v8);
        this.l = findViewById(f.E2);
        this.m = findViewById(f.gh);
        this.n = findViewById(f.F4);
        overridePendingTransition(a7.b.f, a7.b.d);
        v1();
        r1(findViewById(f.kh));
        Intent intent = getIntent();
        if (intent != null) {
            this.t = intent.getStringExtra("category_id");
            String stringExtra = intent.getStringExtra("category_name");
            this.u = stringExtra;
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(stringExtra);
            }
        }
        this.o = this;
        u7.a aVar = new u7.a(this);
        this.w = aVar;
        try {
            if (aVar.x() != 3) {
                IjkMediaPlayer.loadLibrariesOnce(null);
                IjkMediaPlayer.native_profileBegin("libijkplayer.so");
            }
        } catch (UnsatisfiedLinkError | Exception unused) {
        }
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new d());
            this.x = thread2;
            thread2.start();
        }
        y1();
        this.g.setOnClickListener(this);
        this.g.sendAccessibilityEvent(8);
        this.q.setOnClickListener(new a());
        this.n.setOnClickListener(new b());
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
        x1();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.x;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new d());
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
        } else if (this.o != null) {
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        x1();
    }

    public void w1() {
        runOnUiThread(new c());
    }

    public void x1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public final void y1() {
        ViewPager viewPager;
        if (this.o != null) {
            this.s = new ArrayList();
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
            liveStreamCategoryIdDBModel.setLiveStreamCategoryID(this.t);
            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(this.u);
            this.s.add(liveStreamCategoryIdDBModel);
            ArrayList arrayList = this.s;
            if (arrayList == null || (viewPager = this.f) == null || this.e == null) {
                return;
            }
            viewPager.setAdapter(new H(arrayList, getSupportFragmentManager(), this));
        }
    }
}
