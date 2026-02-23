package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.callback.storage.GetStorageAccessCallback;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import y5.b;
import y5.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiCallWorkerDbStorage extends ListenableWorker {
    public Context g;

    public class a implements Callback {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void onFailure(Call call, Throwable th) {
            SharepreferenceDBHandler.setLocalDb(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this), true);
            this.a.v(ListenableWorker.a.a());
        }

        public void onResponse(Call call, Response response) {
            if (response == null || !response.isSuccessful() || response.body() == null || ((GetStorageAccessCallback) response.body()).getData() == null) {
                SharepreferenceDBHandler.setLocalDb(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this), true);
            } else {
                if (((GetStorageAccessCallback) response.body()).getData().getMode().equalsIgnoreCase("1")) {
                    if (SharepreferenceDBHandler.isLocalDb(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this))) {
                        p0.a.b(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this)).d(new Intent("notification_popup"));
                    }
                    SharepreferenceDBHandler.setLocalDb(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this), false);
                } else {
                    SharepreferenceDBHandler.setLocalDb(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this), true);
                }
                Intent intent = new Intent("notification");
                intent.putExtra("local_fav_storage", "local_storage");
                p0.a.b(ApiCallWorkerDbStorage.s(ApiCallWorkerDbStorage.this)).d(intent);
            }
            this.a.v(ListenableWorker.a.c());
        }
    }

    public ApiCallWorkerDbStorage(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = context;
    }

    public static /* synthetic */ Context s(ApiCallWorkerDbStorage apiCallWorkerDbStorage) {
        return apiCallWorkerDbStorage.g;
    }

    public b p() {
        e x = e.x();
        Retrofit F0 = w.F0(this.g);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            r();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", "get-app-storage-prefences");
            retrofitPost.getAppStorageAccess(jsonObject).enqueue(new a(x));
        }
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }
}
