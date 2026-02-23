package com.nst.iptvsmarterstvbox.view.activity;

import B7.d;
import a7.c;
import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.utility.LoadingGearSpinner;
import java.util.ArrayList;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ImportEPGActivity extends b {
    public Context d;
    public LiveStreamDBHandler e;
    public TextView f;
    public TextView g;
    public ProgressBar h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public RelativeLayout l;
    public LoadingGearSpinner m;
    public SharedPreferences n;
    public ArrayList o;
    public u7.a p;

    public class a extends AsyncTask {
        public d a;

        public class a extends AsyncTask {
            public volatile boolean a = true;
            public Context b;
            public final int c;

            public a(Context context) {
                this.b = null;
                this.c = ImportEPGActivity.u1(ImportEPGActivity.this).size();
                this.b = context;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                publishProgress(new Integer[]{0});
                ImportEPGActivity importEPGActivity = ImportEPGActivity.this;
                LiveStreamDBHandler liveStreamDBHandler = importEPGActivity.e;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.addEPG(ImportEPGActivity.u1(importEPGActivity));
                }
                return Boolean.TRUE;
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                int size = ImportEPGActivity.u1(ImportEPGActivity.this).size();
                ImportEPGActivity importEPGActivity = ImportEPGActivity.this;
                ImportEPGActivity.x1(importEPGActivity, importEPGActivity.getSharedPreferences("loginPrefs", 0));
                ImportEPGActivity.w1(ImportEPGActivity.this).getString("skip", "");
                w.P0(ImportEPGActivity.this.d, ImportEPGActivity.this.getResources().getString(j.F1) + " (" + size + ")");
                ImportEPGActivity.this.e.updateImportStatus("epg", "1");
                if (ImportEPGActivity.this.d != null) {
                    ImportEPGActivity.this.startActivity(new Intent(ImportEPGActivity.this.d, NewDashboardActivity.class));
                    ImportEPGActivity.this.finish();
                }
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onCancelled() {
                this.a = false;
            }

            public void onPreExecute() {
            }
        }

        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            d dVar = new d();
            this.a = dVar;
            dVar.a(ImportEPGActivity.this.d);
            ImportEPGActivity.v1(ImportEPGActivity.this, this.a.b());
            return (ImportEPGActivity.u1(ImportEPGActivity.this) == null || ImportEPGActivity.u1(ImportEPGActivity.this).size() <= 0) ? Boolean.FALSE : Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            Intent intent;
            if (bool.booleanValue()) {
                try {
                    ImportEPGActivity importEPGActivity = ImportEPGActivity.this;
                    TextView textView = importEPGActivity.g;
                    if (textView != null) {
                        textView.setText(importEPGActivity.getResources().getString(j.v2));
                    }
                    new a(ImportEPGActivity.this.d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } catch (Exception unused) {
                    ImportEPGActivity.this.e.updateImportStatus("epg", "1");
                    if (ImportEPGActivity.this.d == null) {
                        return;
                    } else {
                        intent = new Intent(ImportEPGActivity.this.d, NewDashboardActivity.class);
                    }
                }
            } else {
                ImportEPGActivity importEPGActivity2 = ImportEPGActivity.this;
                w.P0(importEPGActivity2.d, importEPGActivity2.getResources().getString(j.h4));
                ImportEPGActivity.this.e.updateImportStatus("epg", "0");
                if (ImportEPGActivity.this.d == null) {
                    return;
                } else {
                    intent = new Intent(ImportEPGActivity.this.d, NewDashboardActivity.class);
                }
            }
            ImportEPGActivity.this.startActivity(intent);
            ImportEPGActivity.this.finish();
        }

        public void onPreExecute() {
        }
    }

    public static /* synthetic */ ArrayList u1(ImportEPGActivity importEPGActivity) {
        return importEPGActivity.o;
    }

    public static /* synthetic */ ArrayList v1(ImportEPGActivity importEPGActivity, ArrayList arrayList) {
        importEPGActivity.o = arrayList;
        return arrayList;
    }

    public static /* synthetic */ SharedPreferences w1(ImportEPGActivity importEPGActivity) {
        return importEPGActivity.n;
    }

    public static /* synthetic */ SharedPreferences x1(ImportEPGActivity importEPGActivity, SharedPreferences sharedPreferences) {
        importEPGActivity.n = sharedPreferences;
        return sharedPreferences;
    }

    private void y1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    private void z1() {
        if (this.d != null) {
            this.n = getSharedPreferences("loginPrefs", 0);
            new a().execute(new Void[0]);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        startActivity(new Intent(this, NewDashboardActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.L);
        this.f = findViewById(f.Il);
        this.g = findViewById(f.Cj);
        this.h = findViewById(f.Nc);
        this.i = findViewById(f.Mk);
        this.j = findViewById(f.pi);
        this.k = findViewById(f.ve);
        this.l = findViewById(f.ue);
        this.m = findViewById(f.j5);
        y1();
        this.d = this;
        this.e = new LiveStreamDBHandler(this.d);
        u7.a aVar = new u7.a(this.d);
        this.p = aVar;
        if (aVar.c()) {
            w.r(this.d);
        }
        z1();
        getWindow().setFlags(1024, 1024);
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.d);
        w.z0(this.d);
        getWindow().setFlags(1024, 1024);
    }
}
