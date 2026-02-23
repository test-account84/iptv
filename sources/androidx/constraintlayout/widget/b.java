package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import x.e;
import x.h;
import z.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b extends View {
    public int[] a;
    public int c;
    public Context d;
    public h e;
    public boolean f;
    public String g;
    public View[] h;
    public HashMap i;

    public b(Context context) {
        super(context);
        this.a = new int[32];
        this.f = false;
        this.h = null;
        this.i = new HashMap();
        this.d = context;
        e(null);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.d == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            getParent();
        }
        int d = d(trim);
        if (d != 0) {
            this.i.put(Integer.valueOf(d), trim);
            b(d);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.c + 1;
        int[] iArr = this.a;
        if (i2 > iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.a;
        int i3 = this.c;
        iArr2[i3] = i;
        this.c = i3 + 1;
    }

    public final int c(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int d(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object f = constraintLayout.f(0, str);
            if (f instanceof Integer) {
                i = ((Integer) f).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = c(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = z.c.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.d.getResources().getIdentifier(str, "id", this.d.getPackageName()) : i;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == d.k1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.g = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(e eVar, boolean z);

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.c);
    }

    public void h(ConstraintLayout constraintLayout) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
        String str;
        int c;
        if (isInEditMode()) {
            setIds(this.g);
        }
        h hVar = this.e;
        if (hVar == null) {
            return;
        }
        hVar.c();
        for (int i = 0; i < this.c; i++) {
            int i2 = this.a[i];
            View h = constraintLayout.h(i2);
            if (h == null && (c = c(constraintLayout, (str = (String) this.i.get(Integer.valueOf(i2))))) != 0) {
                this.a[i] = c;
                this.i.put(Integer.valueOf(c), str);
                h = constraintLayout.h(c);
            }
            if (h != null) {
                this.e.b(constraintLayout.i(h));
            }
        }
        this.e.a(constraintLayout.d);
    }

    public void k() {
        if (this.e == null) {
            return;
        }
        ConstraintLayout.b layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            layoutParams.n0 = (e) this.e;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.g;
        if (str != null) {
            setIds(str);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i, int i2) {
        if (this.f) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.g = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.c = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.g = null;
        this.c = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new int[32];
        this.f = false;
        this.h = null;
        this.i = new HashMap();
        this.d = context;
        e(attributeSet);
    }
}
