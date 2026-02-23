package q6;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class r implements Runnable {
    public /* synthetic */ FirebaseMessaging a;
    public /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ r(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.a = firebaseMessaging;
        this.c = taskCompletionSource;
    }

    public final void run() {
        this.a.q(this.c);
    }
}
