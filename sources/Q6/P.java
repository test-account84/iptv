package q6;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p implements Application.ActivityLifecycleCallbacks {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle extras;
        Intent intent = activity.getIntent();
        if (intent == null || !this.a.add(intent) || (extras = intent.getExtras()) == null) {
            return;
        }
        Bundle bundle2 = extras.getBundle("gcm.n.analytics_data");
        if (H.B(bundle2)) {
            H.u(bundle2);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.a.remove(activity.getIntent());
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
