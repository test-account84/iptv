package q6;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class u implements SuccessContinuation {
    public /* synthetic */ String a;

    public /* synthetic */ u(String str) {
        this.a = str;
    }

    public final Task then(Object obj) {
        return FirebaseMessaging.u(this.a, (d0) obj);
    }
}
