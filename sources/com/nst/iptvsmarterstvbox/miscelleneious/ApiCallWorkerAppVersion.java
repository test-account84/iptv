package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import y5.b;
import y5.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiCallWorkerAppVersion extends ListenableWorker {
    public Context g;

    public class a implements Callback {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void onFailure(Call call, Throwable th) {
            SharepreferenceDBHandler.setUpdateVersionCode(ApiCallWorkerAppVersion.this.a(), "", "", "");
            this.a.v(ListenableWorker.a.a());
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(retrofit2.Call r5, retrofit2.Response r6) {
            /*
                r4 = this;
                boolean r5 = r6.isSuccessful()
                java.lang.String r0 = ""
                if (r5 == 0) goto La8
                java.lang.Object r5 = r6.body()
                if (r5 == 0) goto L9e
                java.lang.Object r5 = r6.body()
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r5 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r5
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r5 = r5.a()
                if (r5 == 0) goto L9e
                java.lang.Object r5 = r6.body()     // Catch: java.lang.Exception -> L4a
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r5 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r5     // Catch: java.lang.Exception -> L4a
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r5 = r5.a()     // Catch: java.lang.Exception -> L4a
                java.lang.String r5 = r5.c()     // Catch: java.lang.Exception -> L4a
                java.lang.Object r1 = r6.body()     // Catch: java.lang.Exception -> L47
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r1 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r1     // Catch: java.lang.Exception -> L47
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r1 = r1.a()     // Catch: java.lang.Exception -> L47
                java.lang.String r1 = r1.a()     // Catch: java.lang.Exception -> L47
                java.lang.Object r6 = r6.body()     // Catch: java.lang.Exception -> L45
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel r6 = (com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.DownloadResponseModel) r6     // Catch: java.lang.Exception -> L45
                com.nst.iptvsmarterstvbox.sbpfunction.downloadmodel.Data r6 = r6.a()     // Catch: java.lang.Exception -> L45
                java.lang.String r6 = r6.b()     // Catch: java.lang.Exception -> L45
                goto L51
            L45:
                r6 = move-exception
                goto L4d
            L47:
                r6 = move-exception
                r1 = r0
                goto L4d
            L4a:
                r6 = move-exception
                r5 = r0
                r1 = r5
            L4d:
                r6.printStackTrace()
                r6 = r0
            L51:
                if (r5 == 0) goto L9e
                int r2 = r5.length()
                if (r2 <= 0) goto L9e
                java.lang.String r2 = "."
                boolean r2 = r5.contains(r2)
                if (r2 != 0) goto Laf
                int r2 = java.lang.Integer.parseInt(r5)
                r3 = 108(0x6c, float:1.51E-43)
                if (r2 <= r3) goto L8e
                com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion r0 = com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.this
                android.content.Context r0 = r0.a()
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r0, r5, r6, r1)
                android.content.Intent r5 = new android.content.Intent
                java.lang.String r6 = "notification"
                r5.<init>(r6)
                java.lang.String r6 = "app_version"
                java.lang.String r0 = "appversion"
                r5.putExtra(r6, r0)
                com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion r6 = com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.this
                android.content.Context r6 = com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.s(r6)
                p0.a r6 = p0.a.b(r6)
                r6.d(r5)
                goto Laf
            L8e:
                com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion r5 = com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.this
                android.content.Context r5 = r5.a()
                java.lang.String r6 = java.lang.String.valueOf(r3)
                java.lang.String r1 = "5.0"
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r5, r6, r0, r1)
                goto Laf
            L9e:
                com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion r5 = com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.this
                android.content.Context r5 = r5.a()
                com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r5, r0, r0, r0)
                goto Laf
            La8:
                java.lang.Object r5 = r6.body()
                if (r5 != 0) goto Laf
                goto L9e
            Laf:
                y5.e r5 = r4.a
                androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.c()
                r5.v(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.miscelleneious.ApiCallWorkerAppVersion.a.onResponse(retrofit2.Call, retrofit2.Response):void");
        }
    }

    public ApiCallWorkerAppVersion(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = context;
    }

    public static /* synthetic */ Context s(ApiCallWorkerAppVersion apiCallWorkerAppVersion) {
        return apiCallWorkerAppVersion.g;
    }

    public b p() {
        e x = e.x();
        Retrofit D0 = w.D0(a());
        if (D0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) D0.create(RetrofitPost.class);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            r();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", m7.a.d1);
            retrofitPost.getDownloadInfo(jsonObject).enqueue(new a(x));
        }
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }
}
