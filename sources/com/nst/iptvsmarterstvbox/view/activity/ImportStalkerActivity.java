package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.utility.LoadingGearSpinner;
import java.util.ArrayList;
import m7.w;
import n7.e;
import q7.Z;
import q7.m0;
import q7.t;
import z7.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ImportStalkerActivity extends androidx.appcompat.app.b implements g {
    public Context d;
    public TextView e;
    public TextView f;
    public ProgressBar g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public RelativeLayout k;
    public LoadingGearSpinner l;
    public LiveStreamDBHandler m;
    public SharedPreferences n;
    public MultiUserDBHandler p;
    public e s;
    public final A7.a o = new A7.a();
    public String q = "";
    public String r = "";

    public class a extends AsyncTask {
        public final /* synthetic */ StalkerGetGenresCallback a;

        public a(Context context, StalkerGetGenresCallback stalkerGetGenresCallback) {
            this.a = stalkerGetGenresCallback;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            LiveStreamDBHandler liveStreamDBHandler = ImportStalkerActivity.this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.makeEmptyLiveCategoryStalker();
            }
            publishProgress(new Integer[]{0});
            LiveStreamDBHandler liveStreamDBHandler2 = ImportStalkerActivity.this.m;
            return liveStreamDBHandler2 != null ? Boolean.valueOf(liveStreamDBHandler2.addStalkerLiveCategories(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                ImportStalkerActivity importStalkerActivity = ImportStalkerActivity.this;
                if (importStalkerActivity.d != null) {
                    e u1 = ImportStalkerActivity.u1(importStalkerActivity);
                    ImportStalkerActivity importStalkerActivity2 = ImportStalkerActivity.this;
                    u1.g(importStalkerActivity2.q, importStalkerActivity2.r);
                }
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class b extends AsyncTask {
        public final /* synthetic */ StalkerGetAllChannelsCallback a;

        public b(Context context, StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
            this.a = stalkerGetAllChannelsCallback;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            LiveStreamDBHandler liveStreamDBHandler = ImportStalkerActivity.this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.makeEmptyLiveStreamsStalker();
            }
            publishProgress(new Integer[]{0});
            LiveStreamDBHandler liveStreamDBHandler2 = ImportStalkerActivity.this.m;
            if (liveStreamDBHandler2 == null) {
                return Boolean.FALSE;
            }
            try {
                liveStreamDBHandler2.addStalkerAllChannels(this.a.getJs().getData());
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                ImportStalkerActivity importStalkerActivity = ImportStalkerActivity.this;
                if (importStalkerActivity.d != null) {
                    e u1 = ImportStalkerActivity.u1(importStalkerActivity);
                    ImportStalkerActivity importStalkerActivity2 = ImportStalkerActivity.this;
                    u1.p(importStalkerActivity2.q, importStalkerActivity2.r);
                }
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class c extends AsyncTask {
        public final /* synthetic */ StalkerGetVodCategoriesCallback a;

        public c(Context context, StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
            this.a = stalkerGetVodCategoriesCallback;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            LiveStreamDBHandler liveStreamDBHandler = ImportStalkerActivity.this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.makeEmptyMovieCategoryStalker();
            }
            publishProgress(new Integer[]{0});
            LiveStreamDBHandler liveStreamDBHandler2 = ImportStalkerActivity.this.m;
            return liveStreamDBHandler2 != null ? Boolean.valueOf(liveStreamDBHandler2.addStalkerMoviesCategories(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                ImportStalkerActivity importStalkerActivity = ImportStalkerActivity.this;
                if (importStalkerActivity.d != null) {
                    e u1 = ImportStalkerActivity.u1(importStalkerActivity);
                    ImportStalkerActivity importStalkerActivity2 = ImportStalkerActivity.this;
                    u1.l(importStalkerActivity2.q, importStalkerActivity2.r);
                }
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class d extends AsyncTask {
        public final /* synthetic */ StalkerGetSeriesCategoriesCallback a;

        public d(Context context, StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
            this.a = stalkerGetSeriesCategoriesCallback;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            LiveStreamDBHandler liveStreamDBHandler = ImportStalkerActivity.this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.makeEmptySeriesCategoriesStalker();
            }
            publishProgress(new Integer[]{0});
            LiveStreamDBHandler liveStreamDBHandler2 = ImportStalkerActivity.this.m;
            return liveStreamDBHandler2 != null ? Boolean.valueOf(liveStreamDBHandler2.addSeriesCategoriesStalker(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            ImportStalkerActivity.v1(ImportStalkerActivity.this);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public static /* synthetic */ e u1(ImportStalkerActivity importStalkerActivity) {
        return importStalkerActivity.s;
    }

    public static /* synthetic */ void v1(ImportStalkerActivity importStalkerActivity) {
        importStalkerActivity.x1();
    }

    private void w1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void z1() {
        if (this.d != null) {
            this.n = getSharedPreferences("loginPrefs", 0);
            ArrayList userDetailsStalkerAPI = this.p.getUserDetailsStalkerAPI(SharepreferenceDBHandler.getUserID(this.d));
            if (userDetailsStalkerAPI == null || userDetailsStalkerAPI.size() <= 0) {
                Context context = this.d;
                w.P0(context, context.getResources().getString(j.s8));
                startActivity(new Intent(this.d, NewDashboardActivity.class));
                finish();
                return;
            }
            this.q = ((MultiUserDBModel) userDetailsStalkerAPI.get(0)).getMacAddress();
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
            this.r = stalkerToken;
            try {
                this.s.h(this.q, stalkerToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
        try {
            LiveStreamDBHandler liveStreamDBHandler = this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.updateImportStatus("all_stalker", "1");
            }
            if (stalkerGetSeriesCategoriesCallback == null || stalkerGetSeriesCategoriesCallback.getJs() == null || stalkerGetSeriesCategoriesCallback.getJs().size() <= 0) {
                x1();
            } else {
                new d(this.d, stalkerGetSeriesCategoriesCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        } catch (Exception unused) {
            x1();
        }
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i) {
    }

    public void P0(String str) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void c(String str) {
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:2:0x0022 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x0002, B:14:0x0008, B:16:0x0012, B:2:0x0022, B:4:0x0026), top: B:11:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f0(com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L22
            java.util.List r0 = r3.getJs()     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L22
            java.util.List r0 = r3.getJs()     // Catch: java.lang.Exception -> L2f
            int r0 = r0.size()     // Catch: java.lang.Exception -> L2f
            if (r0 <= 0) goto L22
            com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$a r0 = new com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$a     // Catch: java.lang.Exception -> L2f
            android.content.Context r1 = r2.d     // Catch: java.lang.Exception -> L2f
            r0.<init>(r1, r3)     // Catch: java.lang.Exception -> L2f
            java.util.concurrent.Executor r3 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Exception -> L2f
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L2f
            r0.executeOnExecutor(r3, r1)     // Catch: java.lang.Exception -> L2f
            goto L2f
        L22:
            android.content.Context r3 = r2.d     // Catch: java.lang.Exception -> L2f
            if (r3 == 0) goto L2f
            n7.e r3 = r2.s     // Catch: java.lang.Exception -> L2f
            java.lang.String r0 = r2.q     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r2.r     // Catch: java.lang.Exception -> L2f
            r3.g(r0, r1)     // Catch: java.lang.Exception -> L2f
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity.f0(com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:2:0x0030 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:12:0x0002, B:14:0x0008, B:16:0x0012, B:18:0x0020, B:2:0x0030, B:4:0x0034), top: B:11:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L30
            com.nst.iptvsmarterstvbox.model.pojo.StalkerGetAllChannelsPojo r0 = r3.getJs()     // Catch: java.lang.Exception -> L3d
            if (r0 == 0) goto L30
            com.nst.iptvsmarterstvbox.model.pojo.StalkerGetAllChannelsPojo r0 = r3.getJs()     // Catch: java.lang.Exception -> L3d
            java.util.List r0 = r0.getData()     // Catch: java.lang.Exception -> L3d
            if (r0 == 0) goto L30
            com.nst.iptvsmarterstvbox.model.pojo.StalkerGetAllChannelsPojo r0 = r3.getJs()     // Catch: java.lang.Exception -> L3d
            java.util.List r0 = r0.getData()     // Catch: java.lang.Exception -> L3d
            int r0 = r0.size()     // Catch: java.lang.Exception -> L3d
            if (r0 <= 0) goto L30
            com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$b r0 = new com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$b     // Catch: java.lang.Exception -> L3d
            android.content.Context r1 = r2.d     // Catch: java.lang.Exception -> L3d
            r0.<init>(r1, r3)     // Catch: java.lang.Exception -> L3d
            java.util.concurrent.Executor r3 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Exception -> L3d
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L3d
            r0.executeOnExecutor(r3, r1)     // Catch: java.lang.Exception -> L3d
            goto L3d
        L30:
            android.content.Context r3 = r2.d     // Catch: java.lang.Exception -> L3d
            if (r3 == 0) goto L3d
            n7.e r3 = r2.s     // Catch: java.lang.Exception -> L3d
            java.lang.String r0 = r2.q     // Catch: java.lang.Exception -> L3d
            java.lang.String r1 = r2.r     // Catch: java.lang.Exception -> L3d
            r3.p(r0, r1)     // Catch: java.lang.Exception -> L3d
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity.i(com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:2:0x0022 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x0002, B:14:0x0008, B:16:0x0012, B:2:0x0022, B:4:0x0026), top: B:11:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L22
            java.util.List r0 = r3.getJs()     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L22
            java.util.List r0 = r3.getJs()     // Catch: java.lang.Exception -> L2f
            int r0 = r0.size()     // Catch: java.lang.Exception -> L2f
            if (r0 <= 0) goto L22
            com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$c r0 = new com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity$c     // Catch: java.lang.Exception -> L2f
            android.content.Context r1 = r2.d     // Catch: java.lang.Exception -> L2f
            r0.<init>(r1, r3)     // Catch: java.lang.Exception -> L2f
            java.util.concurrent.Executor r3 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Exception -> L2f
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L2f
            r0.executeOnExecutor(r3, r1)     // Catch: java.lang.Exception -> L2f
            goto L2f
        L22:
            android.content.Context r3 = r2.d     // Catch: java.lang.Exception -> L2f
            if (r3 == 0) goto L2f
            n7.e r3 = r2.s     // Catch: java.lang.Exception -> L2f
            java.lang.String r0 = r2.q     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r2.r     // Catch: java.lang.Exception -> L2f
            r3.l(r0, r1)     // Catch: java.lang.Exception -> L2f
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ImportStalkerActivity.j(com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback):void");
    }

    public void o0(String str) {
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.M);
        this.e = findViewById(f.Il);
        this.f = findViewById(f.Dj);
        this.g = findViewById(f.Nc);
        this.h = findViewById(f.Mk);
        this.i = findViewById(f.pi);
        this.j = findViewById(f.ve);
        this.k = findViewById(f.ue);
        this.l = findViewById(f.j5);
        w1();
        getWindow().setFlags(1024, 1024);
        this.d = this;
        this.s = new e(this, this);
        this.m = new LiveStreamDBHandler(this.d);
        this.p = new MultiUserDBHandler(this.d);
        if (this.m.getImportTableCount("stalker_api") == 0) {
            ArrayList arrayList = new ArrayList();
            ImportStatusModel importStatusModel = new ImportStatusModel();
            importStatusModel.setType("all_stalker");
            importStatusModel.setStatus("0");
            importStatusModel.setDate("");
            arrayList.add(0, importStatusModel);
            this.m.importDataStatusArrayList(arrayList, "stalker_api");
        }
        y1();
        z1();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.d);
        w.z0(this.d);
        getWindow().setFlags(1024, 1024);
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void v0(String str) {
    }

    public final void x1() {
        try {
            startActivity(new Intent(this.d, NewDashboardActivity.class));
            finish();
        } catch (Exception unused) {
        }
    }

    public void y0(String str) {
    }

    public void y1() {
    }

    public void I(m0.x xVar, int i) {
    }

    public void O(Z.E e, int i) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e, int i) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
