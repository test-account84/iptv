package com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification;

import a7.f;
import a7.g;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import m2.d;
import o2.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NotificationPanelActivtiy extends b {
    public String d;
    public String e;
    public String f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public RelativeLayout l;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            NotificationPanelActivtiy.this.onBackPressed();
        }
    }

    public class 2 implements d {
        public 2() {
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean a(Exception exc, String str, j jVar, boolean z) {
            NotificationPanelActivtiy.this.k.setVisibility(8);
            return false;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(e2.b bVar, String str, j jVar, boolean z, boolean z2) {
            NotificationPanelActivtiy.this.k.setVisibility(8);
            NotificationPanelActivtiy.this.g.setVisibility(0);
            return false;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.g0);
        if (i1() != null) {
            i1().l();
        }
        this.g = findViewById(f.o5);
        this.k = findViewById(f.g4);
        this.l = findViewById(f.y8);
        this.h = findViewById(f.fm);
        this.i = findViewById(f.Di);
        ImageView findViewById = findViewById(f.F4);
        this.j = findViewById;
        findViewById.setOnClickListener(new 1());
        u1(getIntent());
    }

    public void onNewIntent(Intent intent) {
        u1(intent);
        super.onNewIntent(intent);
    }

    public final void u1(Intent intent) {
        if (intent.getStringExtra("image") == null || intent.getStringExtra("image").isEmpty()) {
            this.g.setVisibility(8);
            this.l.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.f = intent.getStringExtra("image");
            this.g.setVisibility(0);
            this.l.setVisibility(0);
            O1.g.v(this).q(this.f).C(new 2()).l(this.g);
        }
        if (intent.getStringExtra("title") == null || intent.getStringExtra("title").isEmpty()) {
            this.h.setVisibility(8);
        } else {
            this.d = intent.getStringExtra("title");
            this.h.setVisibility(0);
            this.h.setText(this.d);
        }
        if (intent.getStringExtra("custombody") == null || intent.getStringExtra("custombody").isEmpty()) {
            this.i.setVisibility(8);
            return;
        }
        this.e = intent.getStringExtra("custombody");
        this.i.setVisibility(0);
        this.i.setText(MyApplication.p().o(this.e));
        this.i.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
