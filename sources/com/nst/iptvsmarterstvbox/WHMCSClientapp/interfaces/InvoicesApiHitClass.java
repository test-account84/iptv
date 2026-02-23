package com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces;

import a7.j;
import android.content.Context;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.CallBacks.InvoiceData;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.InvoicesModelClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvoicesApiHitClass {
    public InvoiceData a;
    public Context b;
    public String c;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            InvoicesApiHitClass.b(InvoicesApiHitClass.this).j0(InvoicesApiHitClass.c(InvoicesApiHitClass.this).getResources().getString(j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                InvoicesApiHitClass.b(InvoicesApiHitClass.this).j0(InvoicesApiHitClass.c(InvoicesApiHitClass.this).getResources().getString(j.e7));
            } else {
                InvoicesApiHitClass.b(InvoicesApiHitClass.this).w(((InvoicesModelClass) response.body()).a().a());
            }
        }
    }

    public InvoicesApiHitClass(InvoiceData invoiceData, Context context, String str) {
        this.b = context;
        this.c = str;
        this.a = invoiceData;
    }

    public static /* synthetic */ InvoiceData b(InvoicesApiHitClass invoicesApiHitClass) {
        return invoicesApiHitClass.a;
    }

    public static /* synthetic */ Context c(InvoicesApiHitClass invoicesApiHitClass) {
        return invoicesApiHitClass.b;
    }

    public void a() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).j("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "GetInvoices", "no", ClientSharepreferenceHandler.a(this.b), this.c).enqueue(new 1());
    }
}
