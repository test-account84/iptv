package com.onesignal;

import com.onesignal.F1;
import com.onesignal.s0;
import com.onesignal.w1;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class x1 {
    public s0 a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w1.b.values().length];
            a = iArr;
            try {
                iArr[w1.b.EQUAL_TO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[w1.b.NOT_EQUAL_TO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[w1.b.EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[w1.b.CONTAINS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[w1.b.NOT_EXISTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[w1.b.LESS_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[w1.b.GREATER_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[w1.b.LESS_THAN_OR_EQUAL_TO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[w1.b.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public x1(s0.c cVar) {
        this.a = new s0(cVar);
    }

    public final boolean a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!c((w1) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean b(D0 d0) {
        if (d0.c.size() == 0) {
            return true;
        }
        Iterator it = d0.c.iterator();
        while (it.hasNext()) {
            if (a((ArrayList) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(w1 w1Var) {
        w1.a aVar = w1Var.b;
        if (aVar == w1.a.UNKNOWN) {
            return false;
        }
        if (aVar != w1.a.CUSTOM) {
            return this.a.c(w1Var);
        }
        w1.b bVar = w1Var.d;
        Object obj = this.b.get(w1Var.c);
        if (obj == null) {
            if (bVar == w1.b.NOT_EXISTS) {
                return true;
            }
            return bVar == w1.b.NOT_EQUAL_TO && w1Var.e != null;
        }
        if (bVar == w1.b.EXISTS) {
            return true;
        }
        if (bVar == w1.b.NOT_EXISTS) {
            return false;
        }
        if (bVar == w1.b.CONTAINS) {
            return (obj instanceof Collection) && ((Collection) obj).contains(w1Var.e);
        }
        if (obj instanceof String) {
            Object obj2 = w1Var.e;
            if ((obj2 instanceof String) && i((String) obj2, (String) obj, bVar)) {
                return true;
            }
        }
        Object obj3 = w1Var.e;
        return ((obj3 instanceof Number) && (obj instanceof Number) && g((Number) obj3, (Number) obj, bVar)) || f(w1Var.e, obj, bVar);
    }

    public boolean d(D0 d0, Collection collection) {
        if (d0.c == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = d0.c.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((ArrayList) it2.next()).iterator();
                while (it3.hasNext()) {
                    w1 w1Var = (w1) it3.next();
                    if (str.equals(w1Var.c) || str.equals(w1Var.a)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean e(D0 d0) {
        ArrayList arrayList = d0.c;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator it = d0.c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                w1.a aVar = ((w1) it2.next()).b;
                if (aVar == w1.a.CUSTOM || aVar == w1.a.UNKNOWN) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean f(Object obj, Object obj2, w1.b bVar) {
        if (obj == null) {
            return false;
        }
        if (!bVar.checksEquality()) {
            if ((obj2 instanceof String) && (obj instanceof Number)) {
                return h((Number) obj, (String) obj2, bVar);
            }
            return false;
        }
        String obj3 = obj.toString();
        String obj4 = obj2.toString();
        if (obj2 instanceof Number) {
            obj4 = new DecimalFormat("0.#").format(obj2);
        }
        return i(obj3, obj4, bVar);
    }

    public final boolean g(Number number, Number number2, w1.b bVar) {
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        switch (a.a[bVar.ordinal()]) {
            case 1:
                if (doubleValue2 == doubleValue) {
                }
                break;
            case 2:
                if (doubleValue2 != doubleValue) {
                }
                break;
            case 3:
            case 4:
            case 5:
                F1.c1(F1.v.ERROR, "Attempted to use an invalid operator with a numeric value: " + bVar.toString());
                break;
            case 6:
                if (doubleValue2 < doubleValue) {
                }
                break;
            case 7:
                if (doubleValue2 > doubleValue) {
                }
                break;
            case 8:
                if (doubleValue2 < doubleValue || doubleValue2 == doubleValue) {
                }
                break;
            case 9:
                if (doubleValue2 > doubleValue || doubleValue2 == doubleValue) {
                }
                break;
        }
        return false;
    }

    public final boolean h(Number number, String str, w1.b bVar) {
        try {
            return g(Double.valueOf(number.doubleValue()), Double.valueOf(Double.parseDouble(str)), bVar);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean i(String str, String str2, w1.b bVar) {
        int i = a.a[bVar.ordinal()];
        if (i == 1) {
            return str.equals(str2);
        }
        if (i == 2) {
            return !str.equals(str2);
        }
        F1.c1(F1.v.ERROR, "Attempted to use an invalid operator for a string trigger comparison: " + bVar.toString());
        return false;
    }
}
