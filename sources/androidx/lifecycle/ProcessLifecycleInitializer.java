package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ProcessLifecycleInitializer implements I0.b {
    public List a() {
        return Collections.emptyList();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p b(Context context) {
        if (!I0.a.e(context).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        m.a(context);
        x.i(context);
        return x.h();
    }
}
