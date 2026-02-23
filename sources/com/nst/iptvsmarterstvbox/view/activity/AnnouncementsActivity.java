package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import m7.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AnnouncementsActivity extends androidx.appcompat.app.b implements b7.c {
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

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(AnnouncementsActivity.this.n);
        }
    }

    public class b extends x5.b {
        public b() {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(AnnouncementsActivity.this.n);
                String A = w.A(date);
                TextView textView = AnnouncementsActivity.this.j;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = AnnouncementsActivity.this.i;
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
                    AnnouncementsActivity.this.v1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void b0(int i) {
        x1(getResources().getString(j.A2));
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
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
        w1();
        Thread thread = this.o;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new d());
            this.o = thread2;
            thread2.start();
        }
        this.k.setOnClickListener(new a());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
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
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.o;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new d());
            this.o = thread2;
            thread2.start();
        }
        w.z0(this.n);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void u1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.d = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public void v1() {
        runOnUiThread(new c());
    }

    public void w1() {
        this.e = LoginActivity.S1(b7.f.b(this) + "*" + b7.f.d(this) + "-" + b7.b.b);
        ArrayList arrayList = new ArrayList();
        b7.g.b = arrayList;
        arrayList.add(b7.g.a("action", "getAnnouncement"));
        b7.g.b.add(b7.g.a("sc", this.e));
        b7.g.b.add(b7.g.a("apikey", b7.f.b(this)));
        b7.g.b.add(b7.g.a("rand_num", b7.b.b));
        b7.g.c.c(this);
    }

    public void x1(String str) {
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.h.setText(str);
        this.h.setVisibility(0);
        this.f.setVisibility(8);
    }

    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
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
                    List list = (List) gson.fromJson(jSONArray.toString(), new b().b());
                    if (!list.isEmpty()) {
                        q7.c cVar = new q7.c(list, this, this);
                        this.m = cVar;
                        this.f.setAdapter(cVar);
                        ProgressBar progressBar = this.g;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        this.h.setVisibility(8);
                        return;
                    }
                    string = getResources().getString(j.x4);
                }
                x1(string);
                return;
            } catch (Exception e) {
                Log.e("Get Announcements", e.getMessage());
            }
        }
        x1(getResources().getString(j.x4));
    }
}
