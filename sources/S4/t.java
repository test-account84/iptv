package s4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class t {
    public static final t4.b a = new t4.b("WidgetUtil");

    public static Bitmap a(Context context, Bitmap bitmap, float f, float f2) {
        t4.b bVar = a;
        bVar.a("Begin blurring bitmap %s, original width = %d, original height = %d.", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        int round = Math.round(bitmap.getWidth() * 0.25f);
        int round2 = Math.round(bitmap.getHeight() * 0.25f);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, createScaledBitmap.getConfig());
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(7.5f);
        create2.forEach(createTyped);
        createTyped.copyTo(createBitmap);
        create.destroy();
        bVar.a("End blurring bitmap %s, original width = %d, original height = %d.", createScaledBitmap, Integer.valueOf(round), Integer.valueOf(round2));
        return createBitmap;
    }

    public static Drawable b(Context context, int i, int i2) {
        return d(context, i, i2, 0, 17170443);
    }

    public static Drawable c(Context context, int i, int i2) {
        return d(context, i, i2, 16842800, 0);
    }

    public static Drawable d(Context context, int i, int i2, int i3, int i4) {
        int color;
        ColorStateList colorStateList;
        Drawable r = H.a.r(context.getResources().getDrawable(i2).mutate());
        H.a.p(r, PorterDuff.Mode.SRC_IN);
        if (i != 0) {
            colorStateList = E.b.getColorStateList(context, i);
        } else {
            if (i3 != 0) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i3});
                color = obtainStyledAttributes.getColor(0, 0);
                obtainStyledAttributes.recycle();
            } else {
                color = E.b.getColor(context, i4);
            }
            colorStateList = new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{color, G.a.o(color, 128)});
        }
        H.a.o(r, colorStateList);
        return r;
    }
}
