package n7;

import android.content.Context;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.callback.BillingAddOrderCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingCheckGPACallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingGetDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingIsPurchasedCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingLoginClientCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingUpdateDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.RegisterClientCallback;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public Context a;
    public z7.d b;

    public class a implements Callback {
        public a() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).B0((RegisterClientCallback) response.body());
            }
        }
    }

    public class b implements Callback {
        public b() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).L0((BillingLoginClientCallback) response.body());
            }
        }
    }

    public class c implements Callback {
        public c() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).J((BillingIsPurchasedCallback) response.body());
            }
        }
    }

    public class d implements Callback {
        public d() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).q0((BillingAddOrderCallback) response.body());
            }
        }
    }

    public class e implements Callback {
        public e() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).m0((BillingCheckGPACallback) response.body());
            }
        }
    }

    public class f implements Callback {
        public f() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).g((BillingGetDevicesCallback) response.body());
            }
        }
    }

    public class g implements Callback {
        public g() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("honey", "onFailure: ");
            b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                b.a(b.this).d(b.b(b.this).getResources().getString(a7.j.e7));
            } else {
                b.a(b.this).N0((BillingUpdateDevicesCallback) response.body());
            }
        }
    }

    public b(Context context, z7.d dVar) {
        this.a = context;
        this.b = dVar;
    }

    public static /* synthetic */ z7.d a(b bVar) {
        return bVar.b;
    }

    public static /* synthetic */ Context b(b bVar) {
        return bVar.a;
    }

    public void c(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).addOrder("Vu6HilnbLo63", str, str5, "T6Vk3rLFQBeu3n6s", b7.b.b, str4, str2, "addorder", str3, i, str6, str7, "").enqueue(new d());
        }
    }

    public void d(String str, String str2) {
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).checkGPA("Vu6HilnbLo63", str2, str, "T6Vk3rLFQBeu3n6s", b7.b.b, "checkgpa").enqueue(new e());
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).isPurchasedCheck("Vu6HilnbLo63", str, str5, "T6Vk3rLFQBeu3n6s", b7.b.b, str4, str2, "checkorder", str3, i, str6, str7).enqueue(new c());
        }
    }

    public void f(String str, String str2, String str3, int i) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).getDevices("Vu6HilnbLo63", str, str3, "T6Vk3rLFQBeu3n6s", b7.b.b, str2, i, "alldevices").enqueue(new f());
        }
    }

    public void g(String str, String str2, String str3, String str4, String str5) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).loginClient("Vu6HilnbLo63", str, str5, "T6Vk3rLFQBeu3n6s", b7.b.b, str4, str2, "login", str3).enqueue(new b());
        }
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).registerClient(str, str5, "Vu6HilnbLo63", b7.b.b, str2, "T6Vk3rLFQBeu3n6s", "register", str3, str4).enqueue(new a());
        }
    }

    public void i(String str, String str2, int i, String str3, String str4, String str5) {
        this.b.a();
        Retrofit C0 = w.C0(this.a);
        if (C0 != null) {
            ((RetrofitPost) C0.create(RetrofitPost.class)).updateDevice("Vu6HilnbLo63", str, str2, "T6Vk3rLFQBeu3n6s", b7.b.b, i, "updatedevice", str3, str4, str5).enqueue(new g());
        }
    }
}
