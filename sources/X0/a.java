package x0;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.k;
import d.D;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a implements NavController.b {
    public final Context a;
    public final Set b;
    public final WeakReference c;
    public f.d d;
    public ValueAnimator e;

    public a(Context context, b bVar) {
        this.a = context;
        this.b = bVar.c();
        bVar.b();
        this.c = null;
    }

    public void a(NavController navController, k kVar, Bundle bundle) {
        if (kVar instanceof androidx.navigation.b) {
            return;
        }
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            D.a(weakReference.get());
        }
        if (this.c != null) {
            navController.x(this);
            return;
        }
        CharSequence j = kVar.j();
        if (j != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(j);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (bundle == null || !bundle.containsKey(group)) {
                    throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + j);
                }
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.append(bundle.get(group).toString());
            }
            matcher.appendTail(stringBuffer);
            d(stringBuffer);
        }
        if (c.b(kVar, this.b)) {
            c(null, 0);
        } else {
            b(false);
        }
    }

    public final void b(boolean z) {
        boolean z2;
        if (this.d == null) {
            this.d = new f.d(this.a);
            z2 = false;
        } else {
            z2 = true;
        }
        c(this.d, z ? d.b : d.a);
        float f = z ? 0.0f : 1.0f;
        if (!z2) {
            this.d.setProgress(f);
            return;
        }
        float a = this.d.a();
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "progress", new float[]{a, f});
        this.e = ofFloat;
        ofFloat.start();
    }

    public abstract void c(Drawable drawable, int i);

    public abstract void d(CharSequence charSequence);
}
