package k;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class s extends RatingBar {
    public final r a;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.J);
    }

    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap b = this.a.b();
        if (b != null) {
            setMeasuredDimension(View.resolveSizeAndState(b.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Z.a(this, getContext());
        r rVar = new r(this);
        this.a = rVar;
        rVar.c(attributeSet, i);
    }
}
