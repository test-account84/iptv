package d;

import P.L;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k.a0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class w {
    public static final Class[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {16843375};
    public static final int[] d = {16844160};
    public static final int[] e = {16844156};
    public static final int[] f = {16844148};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};
    public static final s.i h = new s.i();
    public final Object[] a = new Object[2];

    public static class a implements View.OnClickListener {
        public final View a;
        public final String c;
        public Method d;
        public Context e;

        public a(View view, String str) {
            this.a = view;
            this.c = str;
        }

        public final void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.c, new Class[]{View.class})) != null) {
                        this.d = method;
                        this.e = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str);
        }

        public void onClick(View view) {
            if (this.d == null) {
                a(this.a.getContext());
            }
            try {
                this.d.invoke(this.e, new Object[]{view});
            } catch (InvocationTargetException e) {
                throw new IllegalStateException("Could not execute method for android:onClick", e);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            }
        }
    }

    public static Context u(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.R3, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(c.j.S3, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(c.j.T3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof i.d) && ((i.d) context).c() == resourceId) ? context : new i.d(context, resourceId) : context;
    }

    public final void a(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d);
        if (obtainStyledAttributes.hasValue(0)) {
            L.t0(view, obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e);
        if (obtainStyledAttributes2.hasValue(0)) {
            L.v0(view, obtainStyledAttributes2.getString(0));
        }
        obtainStyledAttributes2.recycle();
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f);
        if (obtainStyledAttributes3.hasValue(0)) {
            L.H0(view, obtainStyledAttributes3.getBoolean(0, false));
        }
        obtainStyledAttributes3.recycle();
    }

    public final void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && L.R(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public k.c c(Context context, AttributeSet attributeSet) {
        return new k.c(context, attributeSet);
    }

    public k.e d(Context context, AttributeSet attributeSet) {
        return new k.e(context, attributeSet);
    }

    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    public k.f f(Context context, AttributeSet attributeSet) {
        return new k.f(context, attributeSet);
    }

    public k.j g(Context context, AttributeSet attributeSet) {
        return new k.j(context, attributeSet);
    }

    public k.n h(Context context, AttributeSet attributeSet) {
        return new k.n(context, attributeSet);
    }

    public AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    public k.p j(Context context, AttributeSet attributeSet) {
        return new k.p(context, attributeSet);
    }

    public AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    public k.s l(Context context, AttributeSet attributeSet) {
        return new k.s(context, attributeSet);
    }

    public k.u m(Context context, AttributeSet attributeSet) {
        return new k.u(context, attributeSet);
    }

    public k.w n(Context context, AttributeSet attributeSet) {
        return new k.w(context, attributeSet);
    }

    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public k.F p(Context context, AttributeSet attributeSet) {
        return new k.F(context, attributeSet);
    }

    public View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View l;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = u(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = a0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                l = l(context2, attributeSet);
                v(l, str);
                break;
            case "CheckedTextView":
                l = f(context2, attributeSet);
                v(l, str);
                break;
            case "MultiAutoCompleteTextView":
                l = j(context2, attributeSet);
                v(l, str);
                break;
            case "TextView":
                l = o(context2, attributeSet);
                v(l, str);
                break;
            case "ImageButton":
                l = h(context2, attributeSet);
                v(l, str);
                break;
            case "SeekBar":
                l = m(context2, attributeSet);
                v(l, str);
                break;
            case "Spinner":
                l = n(context2, attributeSet);
                v(l, str);
                break;
            case "RadioButton":
                l = k(context2, attributeSet);
                v(l, str);
                break;
            case "ToggleButton":
                l = p(context2, attributeSet);
                v(l, str);
                break;
            case "ImageView":
                l = i(context2, attributeSet);
                v(l, str);
                break;
            case "AutoCompleteTextView":
                l = c(context2, attributeSet);
                v(l, str);
                break;
            case "CheckBox":
                l = e(context2, attributeSet);
                v(l, str);
                break;
            case "EditText":
                l = g(context2, attributeSet);
                v(l, str);
                break;
            case "Button":
                l = d(context2, attributeSet);
                v(l, str);
                break;
            default:
                l = q(context2, str, attributeSet);
                break;
        }
        if (l == null && context != context2) {
            l = t(context2, str, attributeSet);
        }
        if (l != null) {
            b(l, attributeSet);
            a(context2, l, attributeSet);
        }
        return l;
    }

    public final View s(Context context, String str, String str2) {
        String str3;
        s.i iVar = h;
        Constructor constructor = (Constructor) iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.a);
    }

    public final View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            Object[] objArr = this.a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = g;
                if (i >= strArr.length) {
                    return null;
                }
                View s = s(context, str, strArr[i]);
                if (s != null) {
                    return s;
                }
                i++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}
