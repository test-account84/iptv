package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBPersonInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public z7.k a;
    public Context b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).C((SearchTMDBMoviesCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).s((TMDBCastsCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public class c implements Callback {
        public c() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).U0((TMDBCastsCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public class d implements Callback {
        public d() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).g0((TMDBGenreCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public class e implements Callback {
        public e() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).X0((TMDBTrailerCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public class f implements Callback {
        public f() {
        }

        public void onFailure(Call call, Throwable th) {
            h.a(h.this).b();
            h.a(h.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            h.a(h.this).b();
            if (response.isSuccessful()) {
                h.a(h.this).t((TMDBPersonInfoCallback) response.body());
            } else if (response.body() == null) {
                h.a(h.this).d("Invalid Request");
            }
        }
    }

    public h(z7.k kVar, Context context) {
        this.a = kVar;
        this.b = context;
    }

    public static /* synthetic */ z7.k a(h hVar) {
        return hVar.a;
    }

    public void b(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getCasts(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new b());
        }
    }

    public void c(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getCasts(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new c());
        }
    }

    public void d(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getGenre(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new d());
        }
    }

    public void e(String str) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getMoviesInfo("f584f73e8848d9ace559deee1e5a849f", str).enqueue(new a());
        }
    }

    public void f(String str) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getPersonInfo(str, "f584f73e8848d9ace559deee1e5a849f", "images").enqueue(new f());
        }
    }

    public void g(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getTrailer(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new e());
        }
    }
}
