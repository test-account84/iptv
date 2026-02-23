package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import z7.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l {
    public n a;
    public Context b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            l.a(l.this).b();
            l.a(l.this).d(th.getMessage());
            l.a(l.this).E0(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            l.a(l.this).b();
            if (response.isSuccessful()) {
                l.a(l.this).K((VodInfoCallback) response.body());
            } else if (response.body() == null) {
                l.a(l.this).d("Invalid Request");
            }
        }
    }

    public l(n nVar, Context context) {
        this.a = nVar;
        this.b = context;
    }

    public static /* synthetic */ n a(l lVar) {
        return lVar.a;
    }

    public void b(String str, String str2, int i) {
        this.a.a();
        Retrofit B0 = w.B0(this.b);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).vodInfo("application/x-www-form-urlencoded", str, str2, "get_vod_info", i).enqueue(new a());
        }
    }
}
