package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.a;
import androidx.appcompat.app.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AppSettingsDialogHolderActivity extends b implements DialogInterface.OnClickListener {
    public a d;
    public int e;

    public static Intent u1(Context context, Q8.b bVar) {
        Intent intent = new Intent(context, AppSettingsDialogHolderActivity.class);
        intent.putExtra("extra_app_settings", bVar);
        return intent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Intent data = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), (String) null));
            data.addFlags(this.e);
            startActivityForResult(data, 7534);
        } else if (i == -2) {
            setResult(0);
            finish();
        } else {
            throw new IllegalStateException("Unknown button type: " + i);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        Q8.b a = Q8.b.a(getIntent(), this);
        this.e = a.c();
        this.d = a.f(this, this);
    }

    public void onDestroy() {
        super.onDestroy();
        a aVar = this.d;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.d.dismiss();
    }
}
