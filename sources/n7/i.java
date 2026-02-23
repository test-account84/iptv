package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.callback.SearchTMDBTVShowsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTVShowsInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public z7.l a;
    public Context b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            i.a(i.this).b();
            i.a(i.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            i.a(i.this).b();
            if (response.isSuccessful()) {
                i.a(i.this).u0((SearchTMDBTVShowsCallback) response.body());
            } else if (response.body() == null) {
                i.a(i.this).d("Invalid Request");
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            i.a(i.this).b();
            i.a(i.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            i.a(i.this).b();
            if (response.isSuccessful()) {
                i.a(i.this).C0((TMDBTVShowsInfoCallback) response.body());
            } else if (response.body() == null) {
                i.a(i.this).d("Invalid Request");
            }
        }
    }

    public class c implements Callback {
        public c() {
        }

        public void onFailure(Call call, Throwable th) {
            i.a(i.this).b();
            i.a(i.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            i.a(i.this).b();
            if (response.isSuccessful()) {
                i.a(i.this).H0((TMDBTrailerCallback) response.body());
            } else if (response.body() == null) {
                i.a(i.this).d("Invalid Request");
            }
        }
    }

    public class d implements Callback {
        public d() {
        }

        public void onFailure(Call call, Throwable th) {
            i.a(i.this).b();
            i.a(i.this).d(th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            i.a(i.this).b();
            if (response.isSuccessful()) {
                i.a(i.this).Q((TMDBCastsCallback) response.body());
            } else if (response.body() == null) {
                i.a(i.this).d("Invalid Request");
            }
        }
    }

    public i(z7.l lVar, Context context) {
        this.a = lVar;
        this.b = context;
    }

    public static /* synthetic */ z7.l a(i iVar) {
        return iVar.a;
    }

    public void b(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getTVShowCasts(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new d());
        }
    }

    public void c(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getTVShowsGenreAndDirector(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new b());
        }
    }

    public void d(String str) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            try {
                ((RetrofitPost) H0.create(RetrofitPost.class)).getTVShowsInfo("f584f73e8848d9ace559deee1e5a849f", str).enqueue(new a());
            } catch (Exception unused) {
            }
        }
    }

    public void e(int i) {
        this.a.a();
        Retrofit H0 = w.H0(this.b);
        if (H0 != null) {
            ((RetrofitPost) H0.create(RetrofitPost.class)).getTrailerTVShows(i, "f584f73e8848d9ace559deee1e5a849f").enqueue(new c());
        }
    }
}
