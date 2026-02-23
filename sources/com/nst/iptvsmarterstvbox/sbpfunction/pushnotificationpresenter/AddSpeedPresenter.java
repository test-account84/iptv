package com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter;

import android.content.Context;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.adsdatacallback.AdsDataResponse;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.AdsInterface;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AddSpeedPresenter {
    public Context a;
    public AdsInterface b;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            if (AddSpeedPresenter.a(AddSpeedPresenter.this) != null) {
                AddSpeedPresenter.a(AddSpeedPresenter.this).b("Something went Wrong !");
            }
        }

        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful() || AddSpeedPresenter.a(AddSpeedPresenter.this) == null) {
                return;
            }
            AddSpeedPresenter.a(AddSpeedPresenter.this).a((AdsDataResponse) response.body());
        }
    }

    public AddSpeedPresenter(Context context, AdsInterface adsInterface) {
        this.a = context;
        this.b = adsInterface;
    }

    public static /* synthetic */ AdsInterface a(AddSpeedPresenter addSpeedPresenter) {
        return addSpeedPresenter.b;
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        Retrofit Q = w.Q(this.a);
        if (Q != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", str3);
            jsonObject.addProperty("d", str4);
            jsonObject.addProperty("sc", str5);
            jsonObject.addProperty("action", str6);
            ((RetrofitPost) Q.create(RetrofitPost.class)).getAdsDataFromPanelApi(jsonObject).enqueue(new 1());
        }
    }
}
