package com.nst.iptvsmarterstvbox.sbpfunction.sbpmaintenance;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.SBPAdvertisementsMaintanceCallBack;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AdvertisementListSingleton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import t.c;
import y5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class WMClass extends ListenableWorker {
    public c.a g;
    public int h;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "8");
            if (WMClass.u(WMClass.this) != null) {
                WMClass.u(WMClass.this).b(ListenableWorker.a.b());
            }
        }

        public void onResponse(Call call, Response response) {
            Log.e("honey", "4");
            if (WMClass.u(WMClass.this) != null) {
                WMClass.u(WMClass.this).b(ListenableWorker.a.c());
            }
            if (!response.isSuccessful() || response.body() == null || ((SBPAdvertisementsMaintanceCallBack) response.body()).d() == null || ((SBPAdvertisementsMaintanceCallBack) response.body()).e() == null || !((SBPAdvertisementsMaintanceCallBack) response.body()).d().equals("success")) {
                return;
            }
            AdvertisementListSingleton.b().a().clear();
            if (((SBPAdvertisementsMaintanceCallBack) response.body()).b() == null || !((SBPAdvertisementsMaintanceCallBack) response.body()).b().equalsIgnoreCase("on")) {
                Log.e("honey", "7");
                SharepreferenceDBHandler.setMaintanceModeState(false, WMClass.this.a());
                return;
            }
            Log.e("honey", "6");
            SharepreferenceDBHandler.setMaintanceModeState(true, WMClass.this.a());
            String a = ((SBPAdvertisementsMaintanceCallBack) response.body()).a() != null ? ((SBPAdvertisementsMaintanceCallBack) response.body()).a() : "";
            String c = ((SBPAdvertisementsMaintanceCallBack) response.body()).c() != null ? ((SBPAdvertisementsMaintanceCallBack) response.body()).c() : "";
            if (a != null) {
                SharepreferenceDBHandler.setMaintanceModeFooterMessage(a, WMClass.this.a());
            }
            if (c != null) {
                SharepreferenceDBHandler.setMaintanceModeMessage(c, WMClass.this.a());
            }
        }
    }

    public WMClass(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Log.e("honey", "entry");
    }

    public static /* synthetic */ Object r(WMClass wMClass, c.a aVar) {
        return wMClass.v(aVar);
    }

    public static /* synthetic */ c.a u(WMClass wMClass) {
        return wMClass.g;
    }

    public b p() {
        return c.a(new a(this));
    }

    public void s() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.h = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public final void t() {
        Log.e("honey", "1");
        Retrofit P = w.P(a());
        if (P != null) {
            RetrofitPost retrofitPost = (RetrofitPost) P.create(RetrofitPost.class);
            Log.e("honey", "2");
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            s();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", m7.a.c1);
            Log.e("honey", "3");
            retrofitPost.getSBPAdvertisementsMaintance(jsonObject).enqueue(new 1());
        }
    }

    public final /* synthetic */ Object v(c.a aVar) {
        this.g = aVar;
        t();
        return "HitAPIToGetMaintenanceMode";
    }
}
