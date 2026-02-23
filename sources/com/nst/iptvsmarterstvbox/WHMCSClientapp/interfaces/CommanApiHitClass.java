package com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces;

import a7.j;
import android.content.Context;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.CallBacks.AllServiceApiCallBack;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CommanApiHitClass {
    public AllServiceApiCallBack a;
    public Context b;
    public String c;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            CommanApiHitClass.b(CommanApiHitClass.this).r(CommanApiHitClass.c(CommanApiHitClass.this).getResources().getString(j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful() || response.body() == null) {
                CommanApiHitClass.b(CommanApiHitClass.this).r("Network Error");
            } else {
                CommanApiHitClass.b(CommanApiHitClass.this).W((ArrayList) response.body());
            }
        }
    }

    class 2 implements Callback {
        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
            response.isSuccessful();
        }
    }

    public CommanApiHitClass() {
    }

    public static /* synthetic */ AllServiceApiCallBack b(CommanApiHitClass commanApiHitClass) {
        return commanApiHitClass.a;
    }

    public static /* synthetic */ Context c(CommanApiHitClass commanApiHitClass) {
        return commanApiHitClass.b;
    }

    public void a() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).d("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "GetClientproductwithStatus", "yes", ClientSharepreferenceHandler.a(this.b), this.c).enqueue(new 1());
    }

    public CommanApiHitClass(AllServiceApiCallBack allServiceApiCallBack, Context context, String str) {
        this.a = allServiceApiCallBack;
        this.b = context;
        this.c = str;
    }
}
