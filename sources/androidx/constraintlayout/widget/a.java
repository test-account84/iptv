package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import z.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public String a;
    public b b;
    public int c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.COLOR_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.INT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.FLOAT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public a(a aVar, Object obj) {
        this.a = aVar.a;
        this.b = aVar.b;
        d(obj);
    }

    public static HashMap a(HashMap hashMap, View view) {
        HashMap hashMap2 = new HashMap();
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            try {
                hashMap2.put(str, str.equals("BackgroundColor") ? new a(aVar, Integer.valueOf(view.getBackground().getColor())) : new a(aVar, cls.getMethod("getMap" + str, (Class[]) null).invoke(view, (Object[]) null)));
            } catch (NoSuchMethodException e) {
                e = e;
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e = e2;
                e.printStackTrace();
            } catch (InvocationTargetException e3) {
                e = e3;
                e.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void b(Context context, XmlPullParser xmlPullParser, HashMap hashMap) {
        b bVar;
        Boolean string;
        int integer;
        float f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.n2);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Boolean bool = null;
        b bVar2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == d.o2) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == d.p2) {
                bool = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == d.r2) {
                    bVar = b.COLOR_TYPE;
                } else if (index == d.q2) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == d.v2) {
                        bVar = b.DIMENSION_TYPE;
                        f = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == d.s2) {
                        bVar = b.DIMENSION_TYPE;
                        f = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == d.t2) {
                        bVar = b.FLOAT_TYPE;
                        f = obtainStyledAttributes.getFloat(index, Float.NaN);
                    } else if (index == d.u2) {
                        bVar = b.INT_TYPE;
                        integer = obtainStyledAttributes.getInteger(index, -1);
                        string = Integer.valueOf(integer);
                        Boolean bool2 = string;
                        bVar2 = bVar;
                        bool = bool2;
                    } else if (index == d.w2) {
                        bVar = b.STRING_TYPE;
                        string = obtainStyledAttributes.getString(index);
                        Boolean bool22 = string;
                        bVar2 = bVar;
                        bool = bool22;
                    }
                    string = Float.valueOf(f);
                    Boolean bool222 = string;
                    bVar2 = bVar;
                    bool = bool222;
                }
                integer = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(integer);
                Boolean bool2222 = string;
                bVar2 = bVar;
                bool = bool2222;
            }
        }
        if (str != null && bool != null) {
            hashMap.put(str, new a(str, bVar2, bool));
        }
        obtainStyledAttributes.recycle();
    }

    public static void c(View view, HashMap hashMap) {
        StringBuilder sb;
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            String str2 = "set" + str;
            try {
                switch (a.a[aVar.b.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.g)});
                        break;
                    case 2:
                        Method method = cls.getMethod(str2, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.g);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 3:
                        cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.c)});
                        break;
                    case 4:
                        cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.d)});
                        break;
                    case 5:
                        cls.getMethod(str2, new Class[]{CharSequence.class}).invoke(view, new Object[]{aVar.e});
                        break;
                    case 6:
                        cls.getMethod(str2, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(aVar.f)});
                        break;
                    case 7:
                        cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.d)});
                        break;
                }
            } catch (InvocationTargetException e) {
                e = e;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Log.e("TransitionLayout", e3.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str2);
                Log.e("TransitionLayout", sb2.toString());
            }
        }
    }

    public void d(Object obj) {
        switch (a.a[this.b.ordinal()]) {
            case 1:
            case 2:
                this.g = ((Integer) obj).intValue();
                break;
            case 3:
                this.c = ((Integer) obj).intValue();
                break;
            case 4:
            case 7:
                this.d = ((Float) obj).floatValue();
                break;
            case 5:
                this.e = (String) obj;
                break;
            case 6:
                this.f = ((Boolean) obj).booleanValue();
                break;
        }
    }

    public a(String str, b bVar, Object obj) {
        this.a = str;
        this.b = bVar;
        d(obj);
    }
}
