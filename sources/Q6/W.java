package q6;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.a;
import com.google.firebase.messaging.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class w implements a.a {
    public /* synthetic */ FirebaseMessaging a;
    public /* synthetic */ String b;
    public /* synthetic */ b.a c;

    public /* synthetic */ w(FirebaseMessaging firebaseMessaging, String str, b.a aVar) {
        this.a = firebaseMessaging;
        this.b = str;
        this.c = aVar;
    }

    public final Task start() {
        return this.a.p(this.b, this.c);
    }
}
