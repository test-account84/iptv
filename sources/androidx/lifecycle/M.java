package androidx.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m {
    public static AtomicBoolean a = new AtomicBoolean(false);

    public static class a extends e {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            z.g(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Context context) {
        if (a.getAndSet(true)) {
            return;
        }
        context.getApplicationContext().registerActivityLifecycleCallbacks(new a());
    }
}
