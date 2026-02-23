package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.d;
import androidx.navigation.h;
import androidx.navigation.p;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class o {
    public static final ThreadLocal c = new ThreadLocal();
    public Context a;
    public t b;

    public o(Context context, t tVar) {
        this.a = context;
        this.b = tVar;
    }

    public static q a(TypedValue typedValue, q qVar, q qVar2, String str, String str2) {
        if (qVar == null || qVar == qVar2) {
            return qVar != null ? qVar : qVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    public final k b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) {
        int depth;
        k a = this.b.e(xmlResourceParser.getName()).a();
        a.p(this.a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    g(resources, a, attributeSet, i);
                } else if ("deepLink".equals(name)) {
                    h(resources, a, attributeSet);
                } else if ("action".equals(name)) {
                    d(resources, a, attributeSet, xmlResourceParser, i);
                } else if ("include".equals(name) && (a instanceof l)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, v.r);
                    ((l) a).z(c(obtainAttributes.getResourceId(v.s, 0)));
                    obtainAttributes.recycle();
                } else if (a instanceof l) {
                    ((l) a).z(b(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return a;
    }

    public l c(int i) {
        int next;
        Resources resources = this.a.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        k b = b(resources, xml, asAttributeSet, i);
        if (b instanceof l) {
            return (l) b;
        }
        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
    }

    public final void d(Resources resources, k kVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, w0.a.f);
        int resourceId = obtainAttributes.getResourceId(w0.a.g, 0);
        c cVar = new c(obtainAttributes.getResourceId(w0.a.h, 0));
        p.a aVar = new p.a();
        aVar.d(obtainAttributes.getBoolean(w0.a.k, false));
        aVar.g(obtainAttributes.getResourceId(w0.a.n, -1), obtainAttributes.getBoolean(w0.a.o, false));
        aVar.b(obtainAttributes.getResourceId(w0.a.i, -1));
        aVar.c(obtainAttributes.getResourceId(w0.a.j, -1));
        aVar.e(obtainAttributes.getResourceId(w0.a.l, -1));
        aVar.f(obtainAttributes.getResourceId(w0.a.m, -1));
        cVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                f(resources, bundle, attributeSet, i);
            }
        }
        if (!bundle.isEmpty()) {
            cVar.d(bundle);
        }
        kVar.q(resourceId, cVar);
        obtainAttributes.recycle();
    }

    public final d e(TypedArray typedArray, Resources resources, int i) {
        float f;
        int dimension;
        d.a aVar = new d.a();
        aVar.c(typedArray.getBoolean(w0.a.t, false));
        ThreadLocal threadLocal = c;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(w0.a.s);
        Object obj = null;
        q a = string != null ? q.a(string, resources.getResourcePackageName(i)) : null;
        if (typedArray.getValue(w0.a.r, typedValue)) {
            q qVar = q.c;
            if (a == qVar) {
                dimension = typedValue.resourceId;
                if (dimension != 0) {
                    obj = Integer.valueOf(dimension);
                } else {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a.c() + ". Must be a reference to a resource.");
                    }
                    obj = 0;
                }
            } else {
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    if (a != null) {
                        throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a.c() + ". You must use a \"" + qVar.c() + "\" type to reference other resources.");
                    }
                    a = qVar;
                    obj = Integer.valueOf(i2);
                } else if (a == q.k) {
                    obj = typedArray.getString(w0.a.r);
                } else {
                    int i3 = typedValue.type;
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                a = a(typedValue, a, q.b, string, "dimension");
                                dimension = (int) typedValue.getDimension(resources.getDisplayMetrics());
                            } else if (i3 == 18) {
                                a = a(typedValue, a, q.i, string, "boolean");
                                obj = Boolean.valueOf(typedValue.data != 0);
                            } else {
                                if (i3 < 16 || i3 > 31) {
                                    throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                                }
                                q qVar2 = q.g;
                                if (a == qVar2) {
                                    a = a(typedValue, a, qVar2, string, "float");
                                    f = typedValue.data;
                                } else {
                                    a = a(typedValue, a, q.b, string, "integer");
                                    dimension = typedValue.data;
                                }
                            }
                            obj = Integer.valueOf(dimension);
                        } else {
                            a = a(typedValue, a, q.g, string, "float");
                            f = typedValue.getFloat();
                        }
                        obj = Float.valueOf(f);
                    } else {
                        String charSequence = typedValue.string.toString();
                        if (a == null) {
                            a = q.d(charSequence);
                        }
                        obj = a.h(charSequence);
                    }
                }
            }
        }
        if (obj != null) {
            aVar.b(obj);
        }
        if (a != null) {
            aVar.d(a);
        }
        return aVar.a();
    }

    public final void f(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, w0.a.p);
        String string = obtainAttributes.getString(w0.a.q);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        d e = e(obtainAttributes, resources, i);
        if (e.b()) {
            e.c(string, bundle);
        }
        obtainAttributes.recycle();
    }

    public final void g(Resources resources, k kVar, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, w0.a.p);
        String string = obtainAttributes.getString(w0.a.q);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        kVar.a(string, e(obtainAttributes, resources, i));
        obtainAttributes.recycle();
    }

    public final void h(Resources resources, k kVar, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, w0.a.u);
        String string = obtainAttributes.getString(w0.a.x);
        String string2 = obtainAttributes.getString(w0.a.v);
        String string3 = obtainAttributes.getString(w0.a.w);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        h.a aVar = new h.a();
        if (string != null) {
            aVar.d(string.replace("${applicationId}", this.a.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.b(string2.replace("${applicationId}", this.a.getPackageName()));
        }
        if (string3 != null) {
            aVar.c(string3.replace("${applicationId}", this.a.getPackageName()));
        }
        kVar.b(aVar.a());
        obtainAttributes.recycle();
    }
}
