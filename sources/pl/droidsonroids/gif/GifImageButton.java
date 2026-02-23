package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import pl.droidsonroids.gif.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GifImageButton extends ImageButton {
    public boolean a;

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(e.c(this, attributeSet, 0, 0));
    }

    public final void a(e.a aVar) {
        this.a = aVar.a;
        int i = aVar.c;
        if (i > 0) {
            super.setImageResource(i);
        }
        int i2 = aVar.d;
        if (i2 > 0) {
            super.setBackgroundResource(i2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        dVar.a(getDrawable(), 0);
        dVar.a(getBackground(), 1);
    }

    public Parcelable onSaveInstanceState() {
        return new d(super.onSaveInstanceState(), this.a ? getDrawable() : null, this.a ? getBackground() : null);
    }

    public void setBackgroundResource(int i) {
        if (e.e(this, false, i)) {
            return;
        }
        super.setBackgroundResource(i);
    }

    public void setFreezesAnimation(boolean z) {
        this.a = z;
    }

    public void setImageResource(int i) {
        if (e.e(this, true, i)) {
            return;
        }
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        if (e.d(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }
}
