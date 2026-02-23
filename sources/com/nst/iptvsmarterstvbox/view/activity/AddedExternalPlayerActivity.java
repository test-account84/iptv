package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import java.util.ArrayList;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AddedExternalPlayerActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Context d;
    public LinearLayout e;
    public LinearLayout f;
    public RecyclerView g;
    public LinearLayout h;
    public ImageView i;
    public ExternalPlayerDataBase j;
    public ArrayList k;
    public u7.a l;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(AddedExternalPlayerActivity.u1(AddedExternalPlayerActivity.this));
        }
    }

    public class b extends AsyncTask {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Boolean... boolArr) {
            return AddedExternalPlayerActivity.v1(AddedExternalPlayerActivity.this);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            AddedExternalPlayerActivity.this.e.setVisibility(8);
            if (!bool.booleanValue()) {
                AddedExternalPlayerActivity.w1(AddedExternalPlayerActivity.this, Boolean.FALSE);
                return;
            }
            AddedExternalPlayerActivity.w1(AddedExternalPlayerActivity.this, Boolean.TRUE);
            AddedExternalPlayerActivity addedExternalPlayerActivity = AddedExternalPlayerActivity.this;
            addedExternalPlayerActivity.g.setLayoutManager(new LinearLayoutManager(AddedExternalPlayerActivity.u1(addedExternalPlayerActivity), 1, false));
            AddedExternalPlayerActivity.this.g.setAdapter(new q7.b(AddedExternalPlayerActivity.u1(AddedExternalPlayerActivity.this), AddedExternalPlayerActivity.x1(AddedExternalPlayerActivity.this), AddedExternalPlayerActivity.this));
        }

        public void onPreExecute() {
            super.onPreExecute();
            AddedExternalPlayerActivity.this.f.setVisibility(8);
            AddedExternalPlayerActivity.this.g.setVisibility(8);
            AddedExternalPlayerActivity.this.e.setVisibility(0);
        }

        public /* synthetic */ b(AddedExternalPlayerActivity addedExternalPlayerActivity, a aVar) {
            this();
        }
    }

    public static /* synthetic */ Context u1(AddedExternalPlayerActivity addedExternalPlayerActivity) {
        return addedExternalPlayerActivity.d;
    }

    public static /* synthetic */ Boolean v1(AddedExternalPlayerActivity addedExternalPlayerActivity) {
        return addedExternalPlayerActivity.y1();
    }

    public static /* synthetic */ void w1(AddedExternalPlayerActivity addedExternalPlayerActivity, Boolean bool) {
        addedExternalPlayerActivity.z1(bool);
    }

    public static /* synthetic */ ArrayList x1(AddedExternalPlayerActivity addedExternalPlayerActivity) {
        return addedExternalPlayerActivity.k;
    }

    public void A1() {
        new b(this, null).execute(new Boolean[0]);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.Y8 || id == f.wh || id == f.S6 || id == f.w4) {
            startActivity(new Intent(this, ExternalPlayerActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        this.d = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.d);
        this.l = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.f : g.e);
        this.e = findViewById(f.B9);
        this.f = findViewById(f.Y8);
        this.g = findViewById(f.Cd);
        this.h = findViewById(f.S6);
        findViewById(f.w4).setOnClickListener(this);
        findViewById(f.wh).setOnClickListener(this);
        findViewById(f.Y8).setOnClickListener(this);
        Log.e("current:", "add external player");
        this.h.setOnClickListener(this);
        ImageView findViewById = findViewById(f.Xa);
        this.i = findViewById;
        findViewById.setOnClickListener(new a());
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.z0(this.d);
        overridePendingTransition(a7.b.f, a7.b.d);
        A1();
    }

    public final Boolean y1() {
        ExternalPlayerDataBase externalPlayerDataBase = new ExternalPlayerDataBase(this.d);
        this.j = externalPlayerDataBase;
        ArrayList externalPlayer = externalPlayerDataBase.getExternalPlayer();
        this.k = externalPlayer;
        if (externalPlayer != null && externalPlayer.size() > 0) {
            for (int i = 0; i < this.k.size(); i++) {
                String appname = ((ExternalPlayerModelClass) this.k.get(i)).getAppname();
                if (!w.l(((ExternalPlayerModelClass) this.k.get(i)).getPackagename(), this.d)) {
                    this.j.removePlayer(appname);
                }
            }
        }
        this.k = new ArrayList();
        ArrayList externalPlayer2 = this.j.getExternalPlayer();
        this.k = externalPlayer2;
        return (externalPlayer2 == null || externalPlayer2.size() <= 0) ? Boolean.FALSE : Boolean.TRUE;
    }

    public final void z1(Boolean bool) {
        if (bool.booleanValue()) {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(0);
        } else {
            this.f.setVisibility(0);
            this.h.setVisibility(8);
            this.g.setVisibility(8);
        }
    }
}
