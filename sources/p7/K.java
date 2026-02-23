package p7;

import Q8.b;
import Q8.c;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k extends androidx.appcompat.app.b implements c.a {
    public static final String f = "p7.k";
    public a7.a d;
    public boolean e;

    @Q8.a(123)
    private void readExternalStorage() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (E.b.checkSelfPermission(this, "android.permission.READ_MEDIA_VIDEO") != 0) {
                Q8.c.f(this, getString(a7.j.J8), 123, "android.permission.READ_MEDIA_VIDEO");
                return;
            } else if (E.b.checkSelfPermission(this, "android.permission.READ_MEDIA_AUDIO") != 0) {
                Q8.c.f(this, getString(a7.j.J8), 123, "android.permission.READ_MEDIA_AUDIO");
                return;
            }
        } else if (!Q8.c.a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            Q8.c.f(this, getString(a7.j.J8), 123, "android.permission.READ_EXTERNAL_STORAGE");
            return;
        }
        u1();
    }

    public void F0(int i, List list) {
        Log.d(f, "onPermissionsGranted:" + i + ":" + list.size());
        u1();
    }

    public void k(int i, List list) {
        Log.d(f, "onPermissionsDenied:" + i + ":" + list.size());
        if (Q8.c.h(this, list)) {
            new b.b(this).a().e();
        } else {
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        if (i == 16061) {
            if (Q8.c.a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                u1();
            } else {
                finish();
            }
        }
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("isNeedFolderList", false);
        this.e = booleanExtra;
        if (booleanExtra) {
            a7.a aVar = new a7.a();
            this.d = aVar;
            aVar.b(this);
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        readExternalStorage();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i, strArr, iArr);
        Q8.c.d(i, strArr, iArr, this);
    }

    public abstract void u1();
}
