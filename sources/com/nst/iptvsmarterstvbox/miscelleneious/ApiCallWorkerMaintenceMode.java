package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.SBPAdvertisementsMaintanceCallBack;
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
public class ApiCallWorkerMaintenceMode extends ListenableWorker {
    public Context g;

    public class a implements Callback {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void onFailure(Call call, Throwable th) {
            this.a.v(ListenableWorker.a.a());
        }

        public void onResponse(Call call, Response response) {
            Log.e("isworkschedule<<<>>>>", "onresponse");
            if (response.isSuccessful() && response.body() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).d() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).e() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).d().equals("success")) {
                if (((SBPAdvertisementsMaintanceCallBack) response.body()).b() == null || !((SBPAdvertisementsMaintanceCallBack) response.body()).b().equalsIgnoreCase("on")) {
                    Log.e("isworkschedule<<<>>>>", "maintenance mode off");
                    SharepreferenceDBHandler.setMaintanceModeState(false, ApiCallWorkerMaintenceMode.this.a());
                } else {
                    Log.e("isworkschedule<<<>>>>", "maintenance mode on");
                    SharepreferenceDBHandler.setMaintanceModeState(true, ApiCallWorkerMaintenceMode.this.a());
                    String a = ((SBPAdvertisementsMaintanceCallBack) response.body()).a() != null ? ((SBPAdvertisementsMaintanceCallBack) response.body()).a() : "";
                    String c = ((SBPAdvertisementsMaintanceCallBack) response.body()).c() != null ? ((SBPAdvertisementsMaintanceCallBack) response.body()).c() : "";
                    if (a != null) {
                        SharepreferenceDBHandler.setMaintanceModeFooterMessage(a, ApiCallWorkerMaintenceMode.this.a());
                    }
                    if (c != null) {
                        SharepreferenceDBHandler.setMaintanceModeMessage(c, ApiCallWorkerMaintenceMode.this.a());
                    }
                }
            }
            this.a.v(ListenableWorker.a.c());
        }
    }

    public ApiCallWorkerMaintenceMode(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = context;
    }

    public b p() {
        e x = e.x();
        Retrofit P = w.P(a());
        if (P != null) {
            RetrofitPost retrofitPost = (RetrofitPost) P.create(RetrofitPost.class);
            Log.e("isworkschedule<<<>>>>", "server base url");
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            r();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", m7.a.c1);
            Log.e("isworkschedule<<<>>>>", "params added");
            retrofitPost.getSBPAdvertisementsMaintance(jsonObject).enqueue(new a(x));
        }
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }
}
