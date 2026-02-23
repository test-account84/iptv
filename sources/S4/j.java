package s4;

import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ a a;

    public j(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        p4.i y1;
        if (!a.w1(this.a).isClickable() || (y1 = a.y1(this.a)) == null) {
            return;
        }
        y1.V();
    }
}
