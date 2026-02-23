package n7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import q7.Z;
import q7.m0;
import q7.t;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public z7.g a;
    public Context b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class b implements Callback {
        public final /* synthetic */ m0.x a;
        public final /* synthetic */ int b;

        public b(m0.x xVar, int i) {
            this.a = xVar;
            this.b = i;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).o0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).V0((StalkerSetLiveFavCallback) response.body(), this.a, this.b);
            } else {
                e.a(e.this).o0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class c implements Callback {
        public final /* synthetic */ m0.x a;
        public final /* synthetic */ int b;

        public c(m0.x xVar, int i) {
            this.a = xVar;
            this.b = i;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).y0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).I(this.a, this.b);
            } else {
                e.a(e.this).y0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class d implements Callback {
        public d() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class e implements Callback {
        public e() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class f implements Callback {
        public f() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class g implements Callback {
        public final /* synthetic */ Z.E a;
        public final /* synthetic */ int b;

        public g(Z.E e, int i) {
            this.a = e;
            this.b = i;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).o0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).G((StalkerSetLiveFavCallback) response.body(), this.a, this.b);
            } else {
                e.a(e.this).o0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class h implements Callback {
        public final /* synthetic */ Z.E a;
        public final /* synthetic */ int b;

        public h(Z.E e, int i) {
            this.a = e;
            this.b = i;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).y0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).O(this.a, this.b);
            } else {
                e.a(e.this).y0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class i implements Callback {
        public i() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class j implements Callback {
        public j() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class k implements Callback {
        public k() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).G0((StalkerTokenCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class l implements Callback {
        public l() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).q((StalkerGetVODByCatCallback) response.body());
            } else {
                e.a(e.this).e0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class m implements Callback {
        public m() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).V((StalkerProfilesCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class n implements Callback {
        public n() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).f0((StalkerGetGenresCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class o implements Callback {
        public o() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).i((StalkerGetAllChannelsCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class p implements Callback {
        public p() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).j((StalkerGetVodCategoriesCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class q implements Callback {
        public q() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).F((StalkerGetSeriesCategoriesCallback) response.body());
            } else {
                e.a(e.this).c(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class r implements Callback {
        public r() {
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).H(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).U((StalkerLiveFavIdsCallback) response.body());
            } else {
                e.a(e.this).H(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class s implements Callback {
        public final /* synthetic */ t.o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public s(t.o oVar, String str, String str2) {
            this.a = oVar;
            this.b = str;
            this.c = str2;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).P0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).d0((StalkerSetLiveFavCallback) response.body(), this.a, this.b, this.c);
            } else {
                e.a(e.this).P0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class t implements Callback {
        public final /* synthetic */ int a;

        public t(int i) {
            this.a = i;
        }

        public void onFailure(Call call, Throwable th) {
            e.a(e.this).v0(e.b(e.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                e.a(e.this).M((StalkerGetAdCallback) response.body(), this.a);
            } else {
                e.a(e.this).v0(e.b(e.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public e(z7.g gVar, Context context) {
        this.a = gVar;
        this.b = context;
    }

    public static /* synthetic */ z7.g a(e eVar) {
        return eVar.a;
    }

    public static /* synthetic */ Context b(e eVar) {
        return eVar.b;
    }

    public void c(String str, String str2, t.o oVar, String str3, String str4, String str5) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.P0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).addLiveFavStalker("mac=" + str, "Bearer " + str2, "itv", "set_fav", str3).enqueue(new s(oVar, str4, str5));
    }

    public void d(String str, String str2, Z.E e2, String str3, int i2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.o0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).addVODFavStalker("mac=" + str, "Bearer " + str2, "series", "set_fav", str3).enqueue(new g(e2, i2));
    }

    public void e(String str, String str2, m0.x xVar, String str3, int i2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.o0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).addVODFavStalker("mac=" + str, "Bearer " + str2, "vod", "set_fav", str3).enqueue(new b(xVar, i2));
    }

    public void f(String str, String str2, int i2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.v0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getAdStalker("mac=" + str, "Bearer " + str2, "stb", "get_ad").enqueue(new t(i2));
    }

    public void g(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getAllChannelsStalker("mac=" + str, "Bearer " + str2, "itv", "get_all_channels").enqueue(new o());
    }

    public void h(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getGenresStalker("mac=" + str, "Bearer " + str2, "itv", "get_genres").enqueue(new n());
    }

    public void i(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.H(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getLiveFavIdsStalker("mac=" + str, "Bearer " + str2, "itv", "get_fav_ids").enqueue(new r());
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getSeasonsStalker("mac=" + str, "Bearer " + str2, "series", str3, str4, "get_ordered_list", str5).enqueue(new l());
    }

    public void k(String str, String str2, String str3, String str4) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getVODByCatIDStalker("mac=" + str, "Bearer " + str2, "series", str3, str4, "get_ordered_list").enqueue(new f());
    }

    public void l(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getSeriesCategoriesStalker("mac=" + str, "Bearer " + str2, "series", "get_categories").enqueue(new q());
    }

    public void m(String str, String str2, String str3) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getVODFavStalker("mac=" + str, "Bearer " + str2, "series", "get_ordered_list", "1", str3).enqueue(new i());
    }

    public void n(String str, String str2, String str3, String str4) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getVODByCatIDStalker("mac=" + str, "Bearer " + str2, "vod", str3, str4, "get_ordered_list").enqueue(new a());
    }

    public void o(String str, String str2, String str3) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getVODFavStalker("mac=" + str, "Bearer " + str2, "vod", "get_ordered_list", "1", str3).enqueue(new d());
    }

    public void p(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).getVodCategoriesStalker("mac=" + str, "Bearer " + str2, "vod", "get_categories").enqueue(new p());
    }

    public void q(String str, String str2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).validateLoginProfilesStalker("mac=" + str, "Bearer " + str2, "stb", "get_profile").enqueue(new m());
    }

    public void r(String str, String str2, Z.E e2, String str3, int i2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.y0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).removeVODFavStalker("mac=" + str, "Bearer " + str2, "series", "del_fav", str3).enqueue(new h(e2, i2));
    }

    public void s(String str, String str2, m0.x xVar, String str3, int i2) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.y0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).removeVODFavStalker("mac=" + str, "Bearer " + str2, "vod", "del_fav", str3).enqueue(new c(xVar, i2));
    }

    public void t(String str, String str2, String str3, String str4, String str5, String str6) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).searchVODStalker("mac=" + str, "Bearer " + str2, "series", "get_ordered_list", str3, str4, str5, str6).enqueue(new j());
    }

    public void u(String str, String str2, String str3, String str4, String str5, String str6) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).searchVODStalker("mac=" + str, "Bearer " + str2, "vod", "get_ordered_list", str3, str4, str5, str6).enqueue(new e());
    }

    public void v(String str) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).validateLoginAccessTokenStalker("mac=" + str, "stb", "handshake").enqueue(new k());
    }
}
