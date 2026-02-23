package f5;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v {
    public static final Comparator a = new a();

    public class a implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    public static ImageView a(Toolbar toolbar, Drawable drawable) {
        ImageView imageView;
        Drawable drawable2;
        if (drawable == null) {
            return null;
        }
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            ImageView childAt = toolbar.getChildAt(i);
            if ((childAt instanceof ImageView) && (drawable2 = (imageView = childAt).getDrawable()) != null && drawable2.getConstantState() != null && drawable2.getConstantState().equals(drawable.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    public static ImageView b(Toolbar toolbar) {
        return a(toolbar, toolbar.getLogo());
    }

    public static TextView c(Toolbar toolbar) {
        List d = d(toolbar, toolbar.getSubtitle());
        if (d.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(d, a);
    }

    public static List d(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            TextView childAt = toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static TextView e(Toolbar toolbar) {
        List d = d(toolbar, toolbar.getTitle());
        if (d.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(d, a);
    }
}
