package com.nst.iptvsmarterstvbox.view.activity;

import T.d;
import a7.c;
import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import m7.w;
import q7.F;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MultiUserActivity extends androidx.appcompat.app.b {
    public d d;
    public Context e;
    public Handler f;
    public MultiUserDBHandler g;
    public ProgressBar h;
    public RecyclerView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public SharedPreferences n;
    public F o;
    public Intent p;
    public boolean q = false;
    public String r = "false";
    public u7.a s;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.iptvsmarters.com/terms-and-conditions/"));
                MultiUserActivity.this.startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(MultiUserActivity.this.getApplicationContext(), "Your Device Not Supported !!", 1).show();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            MultiUserActivity.u1(MultiUserActivity.this, false);
        }
    }

    public static /* synthetic */ boolean u1(MultiUserActivity multiUserActivity, boolean z) {
        multiUserActivity.q = z;
        return z;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    public void onBackPressed() {
        if (this.q) {
            finish();
            finishAffinity();
            return;
        }
        this.q = true;
        try {
            Toast.makeText(this, getResources().getString(j.F5), 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new b(), 2000L);
    }

    public void onCreate(Bundle bundle) {
        this.e = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        u7.a aVar = new u7.a(this.e);
        this.s = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.b0 : g.a0);
        this.h = findViewById(f.ec);
        this.i = findViewById(f.ub);
        this.j = findViewById(f.Rj);
        this.k = findViewById(f.Qj);
        this.l = findViewById(f.sa);
        this.m = findViewById(f.d7);
        if (m7.a.o.booleanValue()) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.d = new d(this);
        Intent intent = getIntent();
        this.p = intent;
        String stringExtra = intent.getStringExtra("from_login");
        this.r = stringExtra;
        if (stringExtra == null) {
            this.r = "false";
        }
        this.r.equals("true");
        getWindow().setFlags(1024, 1024);
        v1();
        this.k.setOnClickListener(new a());
        getSharedPreferences("Accept_clicked", 0).getString("Accept_clicked", "");
        SharedPreferences sharedPreferences = getSharedPreferences("sharedprefremberme", 0);
        this.n = sharedPreferences;
        sharedPreferences.getBoolean("savelogin", false);
        this.g = new MultiUserDBHandler(this.e);
        w1();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.z0(this.e);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void w1() {
        Handler handler = new Handler();
        this.f = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        x1();
        ProgressBar progressBar2 = this.h;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    public void x1() {
        ArrayList allUsersM3U = this.g.getAllUsersM3U();
        MultiUserDBModel multiUserDBModel = (!SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("m3u") || allUsersM3U.size() <= 0) ? null : (MultiUserDBModel) allUsersM3U.get(0);
        ArrayList allUsers = this.g.getAllUsers();
        if ((SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("api") && allUsers.size() > 0) || (SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("onestream_api") && allUsers.size() > 0)) {
            multiUserDBModel = (MultiUserDBModel) allUsers.get(0);
        }
        MultiUserDBModel multiUserDBModel2 = multiUserDBModel;
        allUsersM3U.addAll(allUsers);
        allUsersM3U.add(new MultiUserDBModel("", "", "", "", "add_playlist", "", ""));
        if (allUsersM3U.size() > 0) {
            this.o = new F(this, allUsersM3U, this.e, this.r, multiUserDBModel2, this.m);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.e);
            flexboxLayoutManager.f3(2);
            flexboxLayoutManager.c3(2);
            flexboxLayoutManager.d3(0);
            flexboxLayoutManager.e3(1);
            this.i.setLayoutManager(flexboxLayoutManager);
            this.i.setItemAnimator(new androidx.recyclerview.widget.c());
            this.i.setAdapter(this.o);
        }
        m7.a.d0 = Boolean.FALSE;
    }
}
