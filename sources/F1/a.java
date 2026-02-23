package f1;

import android.content.Context;
import com.amazonaws.regions.Region;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.service.StorageService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements StorageService.Factory {
    public final /* synthetic */ CognitoAuthProvider a;

    public /* synthetic */ a(CognitoAuthProvider cognitoAuthProvider) {
        this.a = cognitoAuthProvider;
    }

    public final StorageService create(Context context, Region region, String str) {
        return AWSS3StoragePlugin.b(this.a, context, region, str);
    }
}
