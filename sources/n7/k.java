package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.callback.LiveStreamsEpgCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k {
    public z7.e a;
    public Context b;

    public class a implements Callback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
        }

        public void onFailure(Call call, Throwable th) {
            k.a(k.this).b();
            k.a(k.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            k.a(k.this).b();
            if (response.isSuccessful()) {
                k.a(k.this).N((LiveStreamsEpgCallback) response.body(), this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            } else if (response.body() == null) {
                k.a(k.this).d("Invalid Request");
            }
        }
    }

    public k(z7.e eVar, Context context) {
        this.a = eVar;
        this.b = context;
    }

    public static /* synthetic */ z7.e a(k kVar) {
        return kVar.a;
    }

    public void b(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.a.a();
        Retrofit B0 = w.B0(this.b);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).getTVArchive("application/x-www-form-urlencoded", str, str2, "get_simple_data_table", i).enqueue(new a(str3, str4, str5, str6, str7, str8, str9));
        }
    }
}
