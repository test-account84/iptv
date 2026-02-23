package com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter;

import android.content.Context;
import android.util.Log;
import b7.b;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.MobileCodeActiveCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeGenerateCallBack;
import com.nst.iptvsmarterstvbox.model.callback.tvcode.TVCodeVerifyCallBack;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AddDeviceFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.FirebaseInterface;
import m7.a;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FirebasePresenter {
    public Context a;
    public FirebaseInterface b;
    public OnAnnouncementReceived c;
    public OnFirebaseTokenListener d;
    public OnTvCodeProcessListener e;
    public OnCombinedListener f;

    public class 1 implements Callback {
        public final /* synthetic */ String a;

        public 1(String str) {
            this.a = str;
        }

        public void onFailure(Call call, Throwable th) {
            if (th == null || th.getMessage() == null) {
                return;
            }
            Log.e("jaskirat", "onFailure token not added" + th.getMessage());
        }

        public void onResponse(Call call, Response response) {
            Log.e("honey", "onSuccess token added: ");
            if (response.body() == null || !response.isSuccessful()) {
                return;
            }
            SharepreferenceDBHandler.setFirebaseToken(this.a, FirebasePresenter.a(FirebasePresenter.this));
            if (FirebasePresenter.b(FirebasePresenter.this) != null) {
                FirebasePresenter.b(FirebasePresenter.this).a((AddDeviceFirebaseCallback) response.body());
            }
        }
    }

    class 10 implements Callback {
        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
        }
    }

    public class 11 implements Callback {
        public 11() {
        }

        public void onFailure(Call call, Throwable th) {
            if (th != null && th.getMessage() != null) {
                Log.e("jaskirat", "panelLastPublishApi failed 1" + th.getMessage());
                Log.e("jaskirat", "panelLastPublishApi failed 2 " + th.getLocalizedMessage());
                Log.e("jaskirat", "panelLastPublishApi failed 3 " + th.toString());
            }
            if (FirebasePresenter.f(FirebasePresenter.this) != null) {
                FirebasePresenter.f(FirebasePresenter.this).a();
            }
        }

        public void onResponse(Call call, Response response) {
            Log.e("jaskirat", "panelLastPublishApi success");
            if (!response.isSuccessful() || FirebasePresenter.f(FirebasePresenter.this) == null) {
                return;
            }
            FirebasePresenter.f(FirebasePresenter.this).b(response);
        }
    }

    public class 2 implements Callback {
        public 2() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("TAG", "onFailure");
            if (FirebasePresenter.d(FirebasePresenter.this) != null) {
                FirebasePresenter.d(FirebasePresenter.this).b();
            }
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                return;
            }
            if (FirebasePresenter.c(FirebasePresenter.this) != null) {
                FirebasePresenter.c(FirebasePresenter.this).Q0((getAnnouncementsFirebaseCallback) response.body());
            }
            if (FirebasePresenter.d(FirebasePresenter.this) != null) {
                FirebasePresenter.d(FirebasePresenter.this).a((getAnnouncementsFirebaseCallback) response.body());
            }
        }
    }

    public class 3 implements Callback {
        public 3() {
        }

        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                return;
            }
            FirebasePresenter.c(FirebasePresenter.this).k0((readAnnouncementFirebaseCallback) response.body());
        }
    }

    public class 4 implements Callback {
        public 4() {
        }

        public void onFailure(Call call, Throwable th) {
            w.X();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful()) {
                FirebasePresenter.c(FirebasePresenter.this).z((JsonElement) response.body());
            }
            w.X();
        }
    }

    class 5 implements Callback {
        public final /* synthetic */ FirebasePresenter a;

        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                FirebasePresenter.c(this.a).h((AdsLastUpdateResponseCallback) response.body());
            }
        }
    }

    public class 6 implements Callback {
        public 6() {
        }

        public void onFailure(Call call, Throwable th) {
            if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).t0();
            }
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                    FirebasePresenter.e(FirebasePresenter.this).t0();
                }
            } else if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).x((TVCodeGenerateCallBack) response.body());
            }
        }
    }

    public class 7 implements Callback {
        public 7() {
        }

        public void onFailure(Call call, Throwable th) {
            if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).n0();
            }
        }

        public void onResponse(Call call, Response response) {
            if (response.body() == null || !response.isSuccessful()) {
                if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                    FirebasePresenter.e(FirebasePresenter.this).n0();
                }
            } else if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).S0((MobileCodeActiveCallBack) response.body());
            }
        }
    }

    public class 8 implements Callback {
        public 8() {
        }

        public void onFailure(Call call, Throwable th) {
            a.o1 = true;
            if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).W0();
            }
        }

        public void onResponse(Call call, Response response) {
            a.o1 = true;
            if (response.body() == null || !response.isSuccessful()) {
                if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                    FirebasePresenter.e(FirebasePresenter.this).W0();
                }
            } else if (FirebasePresenter.e(FirebasePresenter.this) != null) {
                FirebasePresenter.e(FirebasePresenter.this).O0((TVCodeVerifyCallBack) response.body());
            }
        }
    }

    class 9 implements Callback {
        public final /* synthetic */ Context a;

        public void onFailure(Call call, Throwable th) {
        }

        public void onResponse(Call call, Response response) {
            if (response == null || !response.isSuccessful()) {
                return;
            }
            SharepreferenceDBHandler.setStorageAccessToServer(this.a, true);
        }
    }

    public interface OnAnnouncementReceived {
        void a(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback);

        void b();
    }

    public interface OnCombinedListener {
        void a();

        void b(Response response);
    }

    public interface OnFirebaseTokenListener {
        void a(AddDeviceFirebaseCallback addDeviceFirebaseCallback);
    }

    public interface OnTvCodeProcessListener {
        void O0(TVCodeVerifyCallBack tVCodeVerifyCallBack);

        void S0(MobileCodeActiveCallBack mobileCodeActiveCallBack);

        void W0();

        void n0();

        void t0();

        void x(TVCodeGenerateCallBack tVCodeGenerateCallBack);
    }

    public FirebasePresenter(Context context, FirebaseInterface firebaseInterface) {
        this.a = context;
        this.b = firebaseInterface;
    }

    public static /* synthetic */ Context a(FirebasePresenter firebasePresenter) {
        return firebasePresenter.a;
    }

    public static /* synthetic */ OnFirebaseTokenListener b(FirebasePresenter firebasePresenter) {
        return firebasePresenter.d;
    }

    public static /* synthetic */ FirebaseInterface c(FirebasePresenter firebasePresenter) {
        return firebasePresenter.b;
    }

    public static /* synthetic */ OnAnnouncementReceived d(FirebasePresenter firebasePresenter) {
        return firebasePresenter.c;
    }

    public static /* synthetic */ OnTvCodeProcessListener e(FirebasePresenter firebasePresenter) {
        return firebasePresenter.e;
    }

    public static /* synthetic */ OnCombinedListener f(FirebasePresenter firebasePresenter) {
        return firebasePresenter.f;
    }

    public void g(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", z ? "add-device" : "remove-device");
            jsonObject.addProperty("deviceid", str5);
            jsonObject.addProperty("deviceusername", str6);
            retrofitPost.addDeviceFirebase(jsonObject).enqueue(new 1(str5));
        }
    }

    public void h(String str, String str2, String str3, String str4, String str5, String str6) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "read-announcement");
            jsonObject.addProperty("deviceid", str5);
            jsonObject.addProperty("announcement_id", str6);
            retrofitPost.readAnnouncementFirebase(jsonObject).enqueue(new 3());
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "get-announcements");
            jsonObject.addProperty("deviceid", str5);
            retrofitPost.getAnnouncementsFirebase(jsonObject).enqueue(new 2());
        }
    }

    public void j(String str, String str2, String str3, String str4) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "get-ovpnzip");
            retrofitPost.getFirebaseVPNUrl(jsonObject).enqueue(new 4());
        }
    }

    public void k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, String str13) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "activatecodemobile");
            jsonObject.addProperty("code", str5);
            jsonObject.addProperty("username", w.d0(str6));
            jsonObject.addProperty("password", w.d0(str7));
            jsonObject.addProperty("anyname", w.d0(str8));
            jsonObject.addProperty("dns", w.d0(str9));
            jsonObject.addProperty("type", str10);
            jsonObject.addProperty("m3ulink", w.d0(str11));
            jsonObject.addProperty("billingId", w.d0(String.valueOf(i)));
            jsonObject.addProperty("billingUser", w.d0(str12));
            jsonObject.addProperty("billingPass", w.d0(str13));
            retrofitPost.mobileCodeActivate(jsonObject).enqueue(new 7());
        }
    }

    public void l(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", str3);
            jsonObject.addProperty("d", str4);
            jsonObject.addProperty("sc", str5);
            jsonObject.addProperty("action", "get-publisheddata");
            jsonObject.addProperty("deviceid", str7);
            ((RetrofitPost) F0.create(RetrofitPost.class)).SbpCombinedRequest(jsonObject).enqueue(new 11());
        }
    }

    public void m(String str, String str2, String str3, String str4, String str5, String str6) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", b.b);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "registercodetv");
            jsonObject.addProperty("device_id", str5);
            jsonObject.addProperty("code", str6);
            retrofitPost.tvCodeGenerate(jsonObject).enqueue(new 6());
        }
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Retrofit F0 = w.F0(this.a);
        if (F0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) F0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", str);
            jsonObject.addProperty("s", str2);
            jsonObject.addProperty("r", str7);
            jsonObject.addProperty("d", str3);
            jsonObject.addProperty("sc", str4);
            jsonObject.addProperty("action", "verifycodetv");
            jsonObject.addProperty("code", str6);
            jsonObject.addProperty("device_id", str5);
            retrofitPost.tvCodeVerify(jsonObject).enqueue(new 8());
        }
    }

    public FirebasePresenter(Context context, OnAnnouncementReceived onAnnouncementReceived) {
        this.a = context;
        this.c = onAnnouncementReceived;
    }

    public FirebasePresenter(Context context, OnCombinedListener onCombinedListener) {
        this.f = onCombinedListener;
        this.a = context;
    }

    public FirebasePresenter(Context context, OnFirebaseTokenListener onFirebaseTokenListener) {
        this.d = onFirebaseTokenListener;
        this.a = context;
    }

    public FirebasePresenter(Context context, OnTvCodeProcessListener onTvCodeProcessListener) {
        this.e = onTvCodeProcessListener;
        this.a = context;
    }
}
