package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import java.util.List;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public Context a;
    public z7.i b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).A("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).n((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).A("Failed");
                f.a(f.this).b();
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).l("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).l0((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).l("Failed");
                f.a(f.this).b();
            }
        }
    }

    public class c implements Callback {
        public c() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).Y("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).J0((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).Y("Failed");
                f.a(f.this).b();
            }
        }
    }

    public class d implements Callback {
        public d() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).p0("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).L((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).p0("Failed");
                f.a(f.this).b();
            }
        }
    }

    public class e implements Callback {
        public e() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).i0("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).T((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).i0("Failed");
                f.a(f.this).b();
            }
        }
    }

    public class f implements Callback {
        public f() {
        }

        public void onFailure(Call call, Throwable th) {
            f.a(f.this).A0("Failed");
            f.a(f.this).b();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                f.a(f.this).B((List) response.body());
            } else if (response.body() == null) {
                f.a(f.this).A0("Failed");
                f.a(f.this).b();
            }
        }
    }

    public f(Context context, z7.i iVar) {
        this.a = context;
        this.b = iVar;
    }

    public static /* synthetic */ z7.i a(f fVar) {
        return fVar.b;
    }

    public void b(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).liveStreamCategories("application/x-www-form-urlencoded", str, str2, "get_live_categories").enqueue(new a());
        }
    }

    public void c(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).liveStreams("application/x-www-form-urlencoded", str, str2, "get_live_streams").enqueue(new d());
        }
    }

    public void d(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).allSeriesStreams("application/x-www-form-urlencoded", str, str2, "get_series").enqueue(new f());
        }
    }

    public void e(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).seriesCategories("application/x-www-form-urlencoded", str, str2, "get_series_categories").enqueue(new c());
        }
    }

    public void f(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).vodCategories("application/x-www-form-urlencoded", str, str2, "get_vod_categories").enqueue(new b());
        }
    }

    public void g(String str, String str2) {
        Retrofit B0 = w.B0(this.a);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).allVODStreams("application/x-www-form-urlencoded", str, str2, "get_vod_streams").enqueue(new e());
        }
    }
}
