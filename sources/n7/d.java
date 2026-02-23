package n7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import java.io.IOException;
import java.util.ArrayList;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d {
    public z7.f a;
    public Context b;
    public SharedPreferences.Editor c;
    public SharedPreferences d;

    public class a implements Callback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onFailure(Call call, Throwable th) {
            d.a(d.this).c(d.b(d.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            String str;
            z7.f a;
            Resources resources;
            int i;
            if (response.isSuccessful()) {
                d.a(d.this).m((LoginCallback) response.body(), "validateLogin");
                return;
            }
            if (response.code() == 404) {
                a = d.a(d.this);
                resources = d.b(d.this).getResources();
                i = a7.j.G2;
            } else {
                if (response.code() == 301 || response.code() == 302) {
                    String header = response.raw().header("Location");
                    str = "ERROR Code 301 || 302: Network error occured! Please try again";
                    if (header != null) {
                        String[] split = header.split("/player_api.php");
                        d dVar = d.this;
                        d.d(dVar, d.b(dVar).getSharedPreferences("loginPrefsserverurl", 0));
                        d dVar2 = d.this;
                        d.f(dVar2, d.c(dVar2).edit());
                        d.e(d.this).putString(m7.a.L, split[0]);
                        d.e(d.this).apply();
                        try {
                            d.this.g(this.a, this.b);
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    a = d.a(d.this);
                    a.c(str);
                }
                if (response.body() != null) {
                    return;
                }
                a = d.a(d.this);
                resources = d.b(d.this).getResources();
                i = a7.j.C2;
            }
            str = resources.getString(i);
            a.c(str);
        }
    }

    public class b implements Callback {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(ArrayList arrayList, String str, String str2) {
            this.a = arrayList;
            this.b = str;
            this.c = str2;
        }

        public void onFailure(Call call, Throwable th) {
            d.a(d.this).w0(this.a, d.b(d.this).getResources().getString(a7.j.Y3));
        }

        public void onResponse(Call call, Response response) {
            z7.f a;
            ArrayList arrayList;
            Resources resources;
            int i;
            if (response.isSuccessful()) {
                d.a(d.this).y((LoginCallback) response.body(), "validateLogin", this.a);
                return;
            }
            if (response.code() == 404) {
                a = d.a(d.this);
                arrayList = this.a;
                resources = d.b(d.this).getResources();
                i = a7.j.G2;
            } else {
                if (response.code() == 301 || response.code() == 302) {
                    String header = response.raw().header("Location");
                    if (header != null) {
                        String[] split = header.split("/player_api.php");
                        d dVar = d.this;
                        d.d(dVar, d.b(dVar).getSharedPreferences("loginPrefsserverurl", 0));
                        d dVar2 = d.this;
                        d.f(dVar2, d.c(dVar2).edit());
                        d.e(d.this).putString(m7.a.L, split[0]);
                        d.e(d.this).apply();
                        try {
                            d.this.h(this.b, this.c, this.a);
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    d.a(d.this).w0(this.a, "ERROR Code 301 || 302: Network error occured! Please try again");
                    return;
                }
                if (response.body() != null) {
                    return;
                }
                a = d.a(d.this);
                arrayList = this.a;
                resources = d.b(d.this).getResources();
                i = a7.j.C2;
            }
            a.w0(arrayList, resources.getString(i));
        }
    }

    public d(z7.f fVar, Context context) {
        this.a = fVar;
        this.b = context;
    }

    public static /* synthetic */ z7.f a(d dVar) {
        return dVar.a;
    }

    public static /* synthetic */ Context b(d dVar) {
        return dVar.b;
    }

    public static /* synthetic */ SharedPreferences c(d dVar) {
        return dVar.d;
    }

    public static /* synthetic */ SharedPreferences d(d dVar, SharedPreferences sharedPreferences) {
        dVar.d = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor e(d dVar) {
        return dVar.c;
    }

    public static /* synthetic */ SharedPreferences.Editor f(d dVar, SharedPreferences.Editor editor) {
        dVar.c = editor;
        return editor;
    }

    public void g(String str, String str2) {
        Context context;
        Retrofit B0 = w.B0(this.b);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).validateLogin("application/x-www-form-urlencoded", str, str2).enqueue(new a(str, str2));
        } else {
            if (B0 != null || (context = this.b) == null) {
                return;
            }
            this.a.e(context.getResources().getString(a7.j.p8));
        }
    }

    public void h(String str, String str2, ArrayList arrayList) {
        Context context;
        Retrofit B0 = w.B0(this.b);
        if (B0 != null) {
            ((RetrofitPost) B0.create(RetrofitPost.class)).validateLogin("application/x-www-form-urlencoded", str, str2).enqueue(new b(arrayList, str, str2));
        } else {
            if (B0 != null || (context = this.b) == null) {
                return;
            }
            this.a.h0(arrayList, context.getResources().getString(a7.j.p8));
        }
    }
}
