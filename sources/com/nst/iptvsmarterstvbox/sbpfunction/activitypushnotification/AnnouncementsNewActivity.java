package com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification;

import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b7.c;
import com.google.gson.Gson;
import com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification.AnnouncementsAdapterNew;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import m7.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnnouncementsNewActivity extends b implements c {
    public int d;
    public String e;
    public RecyclerView f;
    public ProgressBar g;
    public TextView h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public RecyclerView.o l;
    public RecyclerView.g m;
    public Context n;
    public Thread o = null;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            w.j(AnnouncementsNewActivity.this.n);
        }
    }

    public class 2 extends x5.b {
        public 2() {
        }
    }

    public class 3 implements Runnable {
        public 3() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(AnnouncementsNewActivity.this.n);
                String A = w.A(date);
                if (AnnouncementsNewActivity.v1(AnnouncementsNewActivity.this) != null) {
                    AnnouncementsNewActivity.v1(AnnouncementsNewActivity.this).setText(R);
                }
                if (AnnouncementsNewActivity.w1(AnnouncementsNewActivity.this) != null) {
                    AnnouncementsNewActivity.w1(AnnouncementsNewActivity.this).setText(A);
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
                    AnnouncementsNewActivity.this.x1();
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
            if (z) {
                f = z ? 1.23f : 1.0f;
                b(f);
                c(f);
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
            }
        }
    }

    public static /* synthetic */ TextView v1(AnnouncementsNewActivity announcementsNewActivity) {
        return announcementsNewActivity.j;
    }

    public static /* synthetic */ TextView w1(AnnouncementsNewActivity announcementsNewActivity) {
        return announcementsNewActivity.i;
    }

    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void K0(String str, int i, boolean z) {
        String string;
        if (z) {
            if (i != 1) {
                return;
            }
            try {
                if (str.isEmpty() && str.equalsIgnoreCase("")) {
                    string = getResources().getString(j.x4);
                } else {
                    b7.b.a = new JSONObject(str);
                    Gson gson = new Gson();
                    if (!b7.b.a.getBoolean("status")) {
                        return;
                    }
                    JSONArray jSONArray = b7.b.a.getJSONArray("response");
                    this.f.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    this.l = linearLayoutManager;
                    this.f.setLayoutManager(linearLayoutManager);
                    List list = (List) gson.fromJson(jSONArray.toString(), new 2().b());
                    if (!list.isEmpty()) {
                        AnnouncementsAdapterNew announcementsAdapterNew = new AnnouncementsAdapterNew(list, this);
                        this.m = announcementsAdapterNew;
                        this.f.setAdapter(announcementsAdapterNew);
                        ProgressBar progressBar = this.g;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        this.h.setVisibility(8);
                        return;
                    }
                    string = getResources().getString(j.x4);
                }
                z1(string);
                return;
            } catch (Exception e) {
                Log.e("Get Announcements", e.getMessage());
            }
        }
        z1(getResources().getString(j.x4));
    }

    public void b0(int i) {
        z1(getResources().getString(j.A2));
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.h);
        b7.g.c = new b7.g(this);
        this.n = this;
        this.f = findViewById(f.ub);
        this.g = findViewById(f.oc);
        this.h = findViewById(f.Qb);
        this.i = findViewById(f.E2);
        this.j = findViewById(f.gh);
        this.k = findViewById(f.Xa);
        u1();
        y1();
        Thread thread = this.o;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.o = thread2;
            thread2.start();
        }
        this.k.setOnClickListener(new 1());
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.o;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.o.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.o;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.o = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void u1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.d = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void x1() {
        runOnUiThread(new 3());
    }

    public void y1() {
        this.e = LoginActivity.S1(b7.f.b(this) + "*" + b7.f.d(this) + "-" + b7.b.b);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("action", "getAnnouncement"));
        b7.g.b.add(b7.g.a("sc", this.e));
        b7.g.b.add(b7.g.a("apikey", b7.f.b(this)));
        b7.g.b.add(b7.g.a("rand_num", b7.b.b));
        b7.g.c.c(this);
    }

    public void z1(String str) {
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.h.setText(str);
        this.h.setVisibility(0);
        this.f.setVisibility(8);
    }
}
