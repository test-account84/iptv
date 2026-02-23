package H5;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.firebase-auth-api.zzacj;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.List;
import p.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class u implements OnCompleteListener {
    public /* synthetic */ GenericIdpActivity a;
    public /* synthetic */ String b;

    public /* synthetic */ u(GenericIdpActivity genericIdpActivity, String str) {
        this.a = genericIdpActivity;
        this.b = str;
    }

    public final void onComplete(Task task) {
        GenericIdpActivity genericIdpActivity = this.a;
        String str = this.b;
        if (genericIdpActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
            zzacj.zzb(genericIdpActivity, str);
            return;
        }
        List queryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            p.d a = new d.a().a();
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
            a.a(genericIdpActivity, (Uri) task.getResult());
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
            intent.putExtra("com.android.browser.application_id", str);
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            genericIdpActivity.startActivity(intent);
        }
    }
}
