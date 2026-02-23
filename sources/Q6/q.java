package q6;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements OnSuccessListener {
    public /* synthetic */ FirebaseMessaging a;

    public /* synthetic */ q(FirebaseMessaging firebaseMessaging) {
        this.a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.a.s((d0) obj);
    }
}
