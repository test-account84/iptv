package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class e {
    public static final List a = Arrays.asList(new String[]{"raw", "drawable", "mipmap"});

    public static class a extends b {
        public final int c;
        public final int d;

        public a() {
            this.c = 0;
            this.d = 0;
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (e.a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !e.e(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        public a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.c = a(imageView, attributeSet, true);
            this.d = a(imageView, attributeSet, false);
        }
    }

    public static class b {
        public boolean a;
        public final int b;

        public b() {
            this.a = false;
            this.b = -1;
        }

        public b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, h.b, i, i2);
            this.a = obtainStyledAttributes.getBoolean(h.c, false);
            this.b = obtainStyledAttributes.getInt(h.d, -1);
            obtainStyledAttributes.recycle();
        }
    }

    public static void a(int i, Drawable drawable) {
        if (drawable instanceof pl.droidsonroids.gif.a) {
            ((pl.droidsonroids.gif.a) drawable).h(i);
        }
    }

    public static float b(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    public static a c(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i, i2);
        int i3 = aVar.b;
        if (i3 >= 0) {
            a(i3, imageView.getDrawable());
            a(i3, imageView.getBackground());
        }
        return aVar;
    }

    public static boolean d(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new pl.droidsonroids.gif.a(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean e(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!a.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(resources, i);
                if (z) {
                    imageView.setImageDrawable(aVar);
                    return true;
                }
                imageView.setBackground(aVar);
                return true;
            } catch (IOException | Resources.NotFoundException unused) {
            }
        }
        return false;
    }
}
