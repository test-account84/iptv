package n7;

import android.content.Context;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import z7.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j {
    public Context a;
    public m b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            j.a(j.this).b();
            j.a(j.this).d(th.getMessage());
            j.a(j.this).a0(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null) {
                j.a(j.this).R((JsonElement) response.body());
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            j.a(j.this).b();
            j.a(j.this).d(th.getMessage());
            j.a(j.this).a0(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null) {
                j.a(j.this).I0((JsonElement) response.body());
            }
        }
    }

    public j(Context context, m mVar) {
        this.a = context;
        this.b = mVar;
    }

    public static /* synthetic */ m a(j jVar) {
        return jVar.b;
    }

    public void b(String str, String str2, String str3) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).seasonsEpisode("application/x-www-form-urlencoded", str, str2, "get_series_info", str3).enqueue(new b());
        }
    }

    public void c(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).seasonsEpisodeOneStream("application/x-www-form-urlencoded", str, str2).enqueue(new a());
        }
    }
}
