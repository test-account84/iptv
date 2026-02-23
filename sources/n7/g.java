package n7;

import android.content.Context;
import android.view.View;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public z7.j a;
    public Context b;
    public Call c;

    public class a implements Callback {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public a(View view, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8) {
            this.a = view;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = i3;
            this.k = str7;
            this.l = str8;
        }

        public void onFailure(Call call, Throwable th) {
            g.a(g.this).M0(g.b(g.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                g.a(g.this).u((StalkerCreatePlayerLinkCallback) response.body(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            } else {
                g.a(g.this).M0(g.b(g.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            g.a(g.this).D0(g.b(g.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                g.a(g.this).T0((StalkerDeletePlayerLinkCallback) response.body());
            } else {
                g.a(g.this).D0(g.b(g.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public class c implements Callback {
        public c() {
        }

        public void onFailure(Call call, Throwable th) {
            g.a(g.this).P(g.b(g.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                g.a(g.this).X((StalkerShortEPGCallback) response.body());
            } else {
                g.a(g.this).P(g.b(g.this).getResources().getString(a7.j.G2));
            }
        }
    }

    public g(z7.j jVar, Context context) {
        this.a = jVar;
        this.b = context;
    }

    public static /* synthetic */ z7.j a(g gVar) {
        return gVar.a;
    }

    public static /* synthetic */ Context b(g gVar) {
        return gVar.b;
    }

    public void c(String str, String str2, String str3, String str4, View view, String str5, int i, int i2, String str6, String str7, String str8, String str9, String str10, String str11, int i3, String str12, String str13) {
        Retrofit G0 = w.G0(this.b);
        if (G0 != null) {
            ((RetrofitPost) G0.create(RetrofitPost.class)).createPlayerLinkStalker("mac=" + str, "Bearer " + str2, str5, str3, "create_link", str4).enqueue(new a(view, i, i2, str6, str7, str8, str9, str10, str11, i3, str12, str13));
        } else if (G0 == null) {
            Context context = this.b;
            if (context != null) {
                this.a.M0(context.getResources().getString(a7.j.p8));
            }
        }
    }

    public void d(String str, String str2, String str3) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.D0(context.getResources().getString(a7.j.p8));
            return;
        }
        ((RetrofitPost) G0.create(RetrofitPost.class)).deletePlayerLink("mac=" + str, "Bearer " + str2, "vod", str3, "del_link").enqueue(new b());
    }

    public void e(String str, String str2, String str3) {
        Context context;
        Retrofit G0 = w.G0(this.b);
        if (G0 == null) {
            if (G0 != null || (context = this.b) == null) {
                return;
            }
            this.a.P(context.getResources().getString(a7.j.p8));
            return;
        }
        RetrofitPost retrofitPost = (RetrofitPost) G0.create(RetrofitPost.class);
        Call call = this.c;
        if (call != null) {
            call.cancel();
        }
        Call shortEPGStalker = retrofitPost.getShortEPGStalker("mac=" + str, "Bearer " + str2, "itv", str3, "get_short_epg");
        this.c = shortEPGStalker;
        shortEPGStalker.enqueue(new c());
    }
}
