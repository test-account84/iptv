package androidx.leanback.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.leanback.widget.picker.a;
import g0.l;
import j0.b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DatePicker extends j0.a {
    public static final int[] H = {5, 2, 1};
    public int A;
    public final DateFormat B;
    public a.a C;
    public Calendar D;
    public Calendar E;
    public Calendar F;
    public Calendar G;
    public String u;
    public b v;
    public b w;
    public b x;
    public int y;
    public int z;

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        public void run() {
            DatePicker.this.u(this.a);
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean n(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static boolean r(b bVar, int i) {
        if (i == bVar.d()) {
            return false;
        }
        bVar.h(i);
        return true;
    }

    public static boolean s(b bVar, int i) {
        if (i == bVar.e()) {
            return false;
        }
        bVar.i(i);
        return true;
    }

    public final void c(int i, int i2) {
        this.G.setTimeInMillis(this.F.getTimeInMillis());
        int b = a(i).b();
        if (i == this.z) {
            this.G.add(5, i2 - b);
        } else if (i == this.y) {
            this.G.add(2, i2 - b);
        } else {
            if (i != this.A) {
                throw new IllegalArgumentException();
            }
            this.G.add(1, i2 - b);
        }
        p(this.G.get(1), this.G.get(2), this.G.get(5));
        t(false);
    }

    public long getDate() {
        return this.F.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.u;
    }

    public long getMaxDate() {
        return this.E.getTimeInMillis();
    }

    public long getMinDate() {
        return this.D.getTimeInMillis();
    }

    public List l() {
        String m = m(this.u);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z = false;
        char c = 0;
        for (int i = 0; i < m.length(); i++) {
            char charAt = m.charAt(i);
            if (charAt != ' ') {
                if (charAt != '\'') {
                    if (z || !n(charAt, cArr)) {
                        sb.append(charAt);
                    } else if (charAt != c) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c = charAt;
                } else if (z) {
                    z = false;
                } else {
                    sb.setLength(0);
                    z = true;
                }
            }
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    public String m(String str) {
        String localizedPattern;
        if (androidx.leanback.widget.picker.a.a) {
            localizedPattern = android.text.format.DateFormat.getBestDateTimePattern(this.C.a, str);
        } else {
            SimpleDateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
            localizedPattern = dateFormat instanceof SimpleDateFormat ? dateFormat.toLocalizedPattern() : "MM/dd/yyyy";
        }
        return TextUtils.isEmpty(localizedPattern) ? "MM/dd/yyyy" : localizedPattern;
    }

    public final boolean o(String str, Calendar calendar) {
        try {
            calendar.setTime(this.B.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w("DatePicker", "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    public final void p(int i, int i2, int i3) {
        Calendar calendar;
        Calendar calendar2;
        this.F.set(i, i2, i3);
        if (this.F.before(this.D)) {
            calendar = this.F;
            calendar2 = this.D;
        } else {
            if (!this.F.after(this.E)) {
                return;
            }
            calendar = this.F;
            calendar2 = this.E;
        }
        calendar.setTimeInMillis(calendar2.getTimeInMillis());
    }

    public final void q() {
        a.a c = androidx.leanback.widget.picker.a.c(Locale.getDefault(), getContext().getResources());
        this.C = c;
        this.G = androidx.leanback.widget.picker.a.b(this.G, c.a);
        this.D = androidx.leanback.widget.picker.a.b(this.D, this.C.a);
        this.E = androidx.leanback.widget.picker.a.b(this.E, this.C.a);
        this.F = androidx.leanback.widget.picker.a.b(this.F, this.C.a);
        b bVar = this.v;
        if (bVar != null) {
            bVar.j(this.C.b);
            d(this.y, this.v);
        }
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        if (TextUtils.equals(this.u, str)) {
            return;
        }
        this.u = str;
        List l = l();
        if (l.size() != str.length() + 1) {
            throw new IllegalStateException("Separators size: " + l.size() + " must equal the size of datePickerFormat: " + str.length() + " + 1");
        }
        setSeparators(l);
        this.w = null;
        this.v = null;
        this.x = null;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        String upperCase = str.toUpperCase();
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < upperCase.length(); i++) {
            char charAt = upperCase.charAt(i);
            if (charAt == 'D') {
                if (this.w != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                b bVar = new b();
                this.w = bVar;
                arrayList.add(bVar);
                this.w.g("%02d");
                this.z = i;
            } else if (charAt != 'M') {
                if (charAt != 'Y') {
                    throw new IllegalArgumentException("datePicker format error");
                }
                if (this.x != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                b bVar2 = new b();
                this.x = bVar2;
                arrayList.add(bVar2);
                this.A = i;
                this.x.g("%d");
            } else {
                if (this.v != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                b bVar3 = new b();
                this.v = bVar3;
                arrayList.add(bVar3);
                this.v.j(this.C.b);
                this.y = i;
            }
        }
        setColumns(arrayList);
        t(false);
    }

    public void setMaxDate(long j) {
        this.G.setTimeInMillis(j);
        if (this.G.get(1) != this.E.get(1) || this.G.get(6) == this.E.get(6)) {
            this.E.setTimeInMillis(j);
            if (this.F.after(this.E)) {
                this.F.setTimeInMillis(this.E.getTimeInMillis());
            }
            t(false);
        }
    }

    public void setMinDate(long j) {
        this.G.setTimeInMillis(j);
        if (this.G.get(1) != this.D.get(1) || this.G.get(6) == this.D.get(6)) {
            this.D.setTimeInMillis(j);
            if (this.F.before(this.D)) {
                this.F.setTimeInMillis(this.D.getTimeInMillis());
            }
            t(false);
        }
    }

    public final void t(boolean z) {
        post(new a(z));
    }

    public void u(boolean z) {
        int[] iArr = {this.z, this.y, this.A};
        boolean z2 = true;
        boolean z3 = true;
        for (int length = H.length - 1; length >= 0; length--) {
            int i = iArr[length];
            if (i >= 0) {
                int i2 = H[length];
                b a2 = a(i);
                boolean s = s(a2, z2 ? this.D.get(i2) : this.F.getActualMinimum(i2)) | r(a2, z3 ? this.E.get(i2) : this.F.getActualMaximum(i2));
                z2 &= this.F.get(i2) == this.D.get(i2);
                z3 &= this.F.get(i2) == this.E.get(i2);
                if (s) {
                    d(iArr[length], a2);
                }
                e(iArr[length], this.F.get(i2), z);
            }
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = new SimpleDateFormat("MM/dd/yyyy");
        q();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.K);
        String string = obtainStyledAttributes.getString(l.L);
        String string2 = obtainStyledAttributes.getString(l.M);
        this.G.clear();
        if (TextUtils.isEmpty(string) || !o(string, this.G)) {
            this.G.set(1900, 0, 1);
        }
        this.D.setTimeInMillis(this.G.getTimeInMillis());
        this.G.clear();
        if (TextUtils.isEmpty(string2) || !o(string2, this.G)) {
            this.G.set(2100, 0, 1);
        }
        this.E.setTimeInMillis(this.G.getTimeInMillis());
        String string3 = obtainStyledAttributes.getString(l.N);
        setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(android.text.format.DateFormat.getDateFormatOrder(context)) : string3);
    }
}
