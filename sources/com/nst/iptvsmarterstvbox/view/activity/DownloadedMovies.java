package com.nst.iptvsmarterstvbox.view.activity;

import a7.c;
import a7.f;
import a7.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DownloadedMovies extends androidx.appcompat.app.b {
    public DownloadedDBHandler d;
    public ArrayList e;
    public ArrayList f;
    public ArrayList g;
    public q7.a h;
    public RecyclerView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public Context q;
    public GridLayoutManager r;
    public u7.a t;
    public ArrayList n = new ArrayList();
    public String o = "";
    public Thread p = null;
    public String s = "";
    public BroadcastReceiver u = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            DownloadedMovies.this.onBackPressed();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            DownloadedMovies downloadedMovies;
            q7.a aVar;
            try {
                String stringExtra = intent.getStringExtra("status");
                int i = 0;
                if (stringExtra.equals("completed")) {
                    int intExtra = intent.getIntExtra("percent", 0);
                    String stringExtra2 = intent.getStringExtra("url");
                    Log.i("getPercent", "percent:" + intExtra);
                    DownloadedMovies downloadedMovies2 = DownloadedMovies.this;
                    downloadedMovies2.e = DownloadedMovies.v1(downloadedMovies2).getDownloadedData();
                    while (i < DownloadedMovies.this.e.size()) {
                        if (((DownloadedDataModel) DownloadedMovies.this.e.get(i)).getMovieURL().equals(stringExtra2)) {
                            ((DownloadedDataModel) DownloadedMovies.this.e.get(i)).setMovieState("Completed");
                            ((DownloadedDataModel) DownloadedMovies.this.e.get(i)).setMoviePercentage(intExtra);
                            downloadedMovies = DownloadedMovies.this;
                            aVar = downloadedMovies.h;
                            if (aVar == null) {
                                return;
                            }
                        } else {
                            i++;
                        }
                    }
                    return;
                }
                if (stringExtra.equals("downloading")) {
                    int intExtra2 = intent.getIntExtra("percent", 0);
                    String stringExtra3 = intent.getStringExtra("url");
                    Log.i("getPercent", "percent:" + intExtra2);
                    DownloadedMovies downloadedMovies3 = DownloadedMovies.this;
                    downloadedMovies3.e = DownloadedMovies.v1(downloadedMovies3).getDownloadedData();
                    while (i < DownloadedMovies.this.e.size()) {
                        if (!((DownloadedDataModel) DownloadedMovies.this.e.get(i)).getMovieURL().equals(stringExtra3)) {
                            i++;
                        } else {
                            if (intExtra2 == 0) {
                                return;
                            }
                            ((DownloadedDataModel) DownloadedMovies.this.e.get(i)).setMoviePercentage(intExtra2);
                            downloadedMovies = DownloadedMovies.this;
                            aVar = downloadedMovies.h;
                            if (aVar == null) {
                                return;
                            }
                        }
                    }
                    return;
                }
                if (stringExtra.equals("failed")) {
                    int intExtra3 = intent.getIntExtra("percent", 0);
                    String stringExtra4 = intent.getStringExtra("url");
                    Log.i("getPercent", "percent:" + intExtra3);
                    DownloadedMovies downloadedMovies4 = DownloadedMovies.this;
                    downloadedMovies4.e = DownloadedMovies.v1(downloadedMovies4).getDownloadedData();
                    while (i < DownloadedMovies.this.e.size()) {
                        if (((DownloadedDataModel) DownloadedMovies.this.e.get(i)).getMovieURL().equals(stringExtra4)) {
                            ((DownloadedDataModel) DownloadedMovies.this.e.get(i)).setMovieState("Failed");
                            ((DownloadedDataModel) DownloadedMovies.this.e.get(i)).setMoviePercentage(intExtra3);
                            downloadedMovies = DownloadedMovies.this;
                            aVar = downloadedMovies.h;
                            if (aVar == null) {
                                return;
                            }
                        } else {
                            i++;
                        }
                    }
                    return;
                }
                return;
                aVar.F0(downloadedMovies.e);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ DownloadedDBHandler v1(DownloadedMovies downloadedMovies) {
        return downloadedMovies.d;
    }

    private void w1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    public void onCreate(Bundle bundle) {
        this.q = this;
        x1();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.q);
        this.t = aVar;
        if (aVar.A().equals(m7.a.K0)) {
            this.s = "tv";
        } else {
            this.s = "mobile";
        }
        setContentView(this.s.equals("mobile") ? g.t : g.u);
        this.i = findViewById(f.Dd);
        this.j = findViewById(f.E2);
        this.k = findViewById(f.gh);
        this.l = findViewById(f.F4);
        this.m = findViewById(f.vk);
        getWindow().setFlags(1024, 1024);
        w1();
        u1();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Log.i("methodCalled", "onResume");
        y1();
        w.z0(this.q);
    }

    public final void u1() {
        this.l.setOnClickListener(new a());
    }

    public void x1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public final void y1() {
        StringBuilder sb;
        try {
            this.d = new DownloadedDBHandler(this.q);
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.g = new ArrayList();
            ArrayList downloadedData = this.d.getDownloadedData();
            this.e = downloadedData;
            if (downloadedData.size() <= 0) {
                this.m.setVisibility(0);
                return;
            }
            int i = 0;
            while (i < this.e.size()) {
                if (((DownloadedDataModel) this.e.get(i)).getMovieType().equals("TYPE_API")) {
                    this.f.add((DownloadedDataModel) this.e.get(i));
                    sb = new StringBuilder();
                    sb.append("type:");
                    sb.append(i);
                } else {
                    this.g.add((DownloadedDataModel) this.e.get(i));
                    sb = new StringBuilder();
                    sb.append("single:");
                    sb.append(i);
                }
                Log.i("filterDataIS", sb.toString());
                i++;
                if (i == this.e.size()) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("api")) {
                        try {
                            if (this.f.size() > 0) {
                                this.h = new q7.a(this.q, this.f, this.i, this.m);
                            } else {
                                this.m.setVisibility(0);
                            }
                        } catch (Exception unused) {
                            this.m.setVisibility(0);
                        }
                    } else if (this.g.size() > 0) {
                        this.h = new q7.a(this.q, this.g, this.i, this.m);
                    } else {
                        this.m.setVisibility(0);
                    }
                    this.i.setAdapter(this.h);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.q, 7);
                    this.r = gridLayoutManager;
                    this.i.setLayoutManager(gridLayoutManager);
                    this.i.requestFocus();
                }
            }
        } catch (Exception unused2) {
            this.m.setVisibility(0);
        }
    }
}
