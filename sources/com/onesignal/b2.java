package com.onesignal;

import A5.o;
import android.content.Context;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.F1;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b2 extends a2 {
    public A5.f f;
    public final Context g;
    public final a h;

    public static class a {
        public final String a;
        public final String b;
        public final String c;

        public a() {
            this(null, null, null);
        }

        public static /* synthetic */ String a(a aVar) {
            return aVar.a;
        }

        public static /* synthetic */ String b(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ String c(a aVar) {
            return aVar.b;
        }

        public a(String str, String str2, String str3) {
            this.a = str == null ? "onesignal-shared-public" : str;
            this.b = str2 == null ? "1:754795614042:android:c682b8144a8dd52bc1ad63" : str2;
            this.c = str3 == null ? new String(Base64.decode("QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV", 0)) : str3;
        }
    }

    public b2(Context context, a aVar) {
        this.g = context;
        if (aVar == null) {
            this.h = new a();
        } else {
            this.h = aVar;
        }
    }

    public String f() {
        return "FCM";
    }

    public String g(String str) {
        n(str);
        try {
            return m();
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            F1.a(F1.v.INFO, "FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken");
            return l(str);
        }
    }

    public final String l(String str) {
        try {
            Object invoke = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getMethod("getInstance", new Class[]{A5.f.class}).invoke((Object) null, new Object[]{this.f});
            return (String) invoke.getClass().getMethod("getToken", new Class[]{String.class, String.class}).invoke(invoke, new Object[]{str, "FCM"});
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", e);
        }
    }

    public final String m() {
        Task i = ((FirebaseMessaging) this.f.j(FirebaseMessaging.class)).i();
        try {
            return (String) Tasks.await(i);
        } catch (ExecutionException unused) {
            throw i.getException();
        }
    }

    public final void n(String str) {
        if (this.f != null) {
            return;
        }
        this.f = A5.f.u(this.g, new o.b().d(str).c(a.c(this.h)).b(a.b(this.h)).e(a.a(this.h)).a(), "ONESIGNAL_SDK_FCM_APP_NAME");
    }
}
