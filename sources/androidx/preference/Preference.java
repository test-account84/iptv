package androidx.preference;

import F.k;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import z0.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Preference implements Comparable {
    public int A;
    public List B;
    public b C;
    public final View.OnClickListener D;
    public final Context a;
    public int c;
    public int d;
    public CharSequence e;
    public CharSequence f;
    public int g;
    public String h;
    public Intent i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public Object o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Preference.this.F(view);
        }
    }

    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.g, 16842894));
    }

    public void A() {
    }

    public void B(Preference preference, boolean z) {
        if (this.p == z) {
            this.p = !z;
            z(K());
            y();
        }
    }

    public Object C(TypedArray typedArray, int i) {
        return null;
    }

    public void D(Preference preference, boolean z) {
        if (this.q == z) {
            this.q = !z;
            z(K());
            y();
        }
    }

    public void E() {
        if (w() && x()) {
            A();
            r();
            if (this.i != null) {
                h().startActivity(this.i);
            }
        }
    }

    public void F(View view) {
        E();
    }

    public boolean G(boolean z) {
        if (!L()) {
            return false;
        }
        if (z == n(!z)) {
            return true;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean H(int i) {
        if (!L()) {
            return false;
        }
        if (i == o(~i)) {
            return true;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean I(String str) {
        if (!L()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, p(null))) {
            return true;
        }
        q();
        obj.getClass();
        throw null;
    }

    public final void J(b bVar) {
        this.C = bVar;
        y();
    }

    public boolean K() {
        return !w();
    }

    public boolean L() {
        return false;
    }

    public boolean a(Object obj) {
        return true;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i = this.c;
        int i2 = preference.c;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.e;
        CharSequence charSequence2 = preference.e;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.e.toString());
    }

    public Context h() {
        return this.a;
    }

    public StringBuilder i() {
        StringBuilder sb = new StringBuilder();
        CharSequence u = u();
        if (!TextUtils.isEmpty(u)) {
            sb.append(u);
            sb.append(' ');
        }
        CharSequence s = s();
        if (!TextUtils.isEmpty(s)) {
            sb.append(s);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String j() {
        return this.j;
    }

    public Intent l() {
        return this.i;
    }

    public boolean n(boolean z) {
        if (!L()) {
            return z;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public int o(int i) {
        if (!L()) {
            return i;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String p(String str) {
        if (!L()) {
            return str;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public z0.a q() {
        return null;
    }

    public z0.b r() {
        return null;
    }

    public CharSequence s() {
        return t() != null ? t().a(this) : this.f;
    }

    public final b t() {
        return this.C;
    }

    public String toString() {
        return i().toString();
    }

    public CharSequence u() {
        return this.e;
    }

    public boolean v() {
        return !TextUtils.isEmpty(this.h);
    }

    public boolean w() {
        return this.k && this.p && this.q;
    }

    public boolean x() {
        return this.l;
    }

    public void y() {
    }

    public void z(boolean z) {
        List list = this.B;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).B(this, z);
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Preference(android.content.Context r5, android.util.AttributeSet r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
