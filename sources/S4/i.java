package s4;

import android.graphics.Bitmap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements q4.a {
    public final /* synthetic */ a a;

    public i(a aVar) {
        this.a = aVar;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            a aVar = this.a;
            if (a.v1(aVar) != null) {
                a.v1(aVar).setVisibility(8);
            }
            a aVar2 = this.a;
            if (a.u1(aVar2) != null) {
                a.u1(aVar2).setVisibility(0);
                a.u1(this.a).setImageBitmap(bitmap);
            }
        }
    }
}
