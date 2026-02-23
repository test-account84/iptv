package O5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class u {
    public final SharedPreferences a;
    public final A5.f b;
    public final Object c;
    public TaskCompletionSource d;
    public boolean e;
    public boolean f;
    public Boolean g;
    public final TaskCompletionSource h;

    public u(A5.f fVar) {
        Object obj = new Object();
        this.c = obj;
        this.d = new TaskCompletionSource();
        this.e = false;
        this.f = false;
        this.h = new TaskCompletionSource();
        Context l = fVar.l();
        this.b = fVar;
        this.a = i.s(l);
        Boolean b = b();
        this.g = b == null ? a(l) : b;
        synchronized (obj) {
            try {
                if (d()) {
                    this.d.trySetResult(null);
                    this.e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e) {
            L5.f.f().e("Could not read data collection permission from manifest", e);
            return null;
        }
    }

    public final Boolean a(Context context) {
        Boolean g = g(context);
        if (g == null) {
            this.f = false;
            return null;
        }
        this.f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(g));
    }

    public final Boolean b() {
        if (!this.a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f = false;
        return Boolean.valueOf(this.a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z) {
        if (!z) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean booleanValue;
        try {
            Boolean bool = this.g;
            booleanValue = bool != null ? bool.booleanValue() : e();
            f(booleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return booleanValue;
    }

    public final boolean e() {
        try {
            return this.b.v();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void f(boolean z) {
        L5.f.f().b(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{z ? "ENABLED" : "DISABLED", this.g == null ? "global Firebase setting" : this.f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"}));
    }

    public Task h() {
        Task task;
        synchronized (this.c) {
            task = this.d.getTask();
        }
        return task;
    }

    public Task i(Executor executor) {
        return W.o(executor, this.h.getTask(), h());
    }
}
