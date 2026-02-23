package q6;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class t implements SuccessContinuation {
    public /* synthetic */ FirebaseMessaging a;
    public /* synthetic */ String b;
    public /* synthetic */ b.a c;

    public /* synthetic */ t(FirebaseMessaging firebaseMessaging, String str, b.a aVar) {
        this.a = firebaseMessaging;
        this.b = str;
        this.c = aVar;
    }

    public final Task then(Object obj) {
        return this.a.o(this.b, this.c, (String) obj);
    }
}
