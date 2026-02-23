package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.m;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h {
    public final e.i a;
    public final m b;
    public e.d c;
    public final boolean d;
    public final int[] e;

    public static final class a {
        public static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z = true;
                    }
                }
                return i;
            }
        }

        public static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                        i++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    public static final class b {
        public int a = 1;
        public final m.a b;
        public m.a c;
        public m.a d;
        public int e;
        public int f;
        public final boolean g;
        public final int[] h;

        public b(m.a aVar, boolean z, int[] iArr) {
            this.b = aVar;
            this.c = aVar;
            this.g = z;
            this.h = iArr;
        }

        public static boolean d(int i) {
            return i == 65039;
        }

        public static boolean f(int i) {
            return i == 65038;
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int a(int r5) {
            /*
                r4 = this;
                androidx.emoji2.text.m$a r0 = r4.c
                androidx.emoji2.text.m$a r0 = r0.a(r5)
                int r1 = r4.a
                r2 = 1
                r3 = 2
                if (r1 == r3) goto L1a
                if (r0 != 0) goto L13
            Le:
                int r3 = r4.g()
                goto L4c
            L13:
                r4.a = r3
                r4.c = r0
                r4.f = r2
                goto L4c
            L1a:
                if (r0 == 0) goto L24
                r4.c = r0
                int r0 = r4.f
                int r0 = r0 + r2
                r4.f = r0
                goto L4c
            L24:
                boolean r0 = f(r5)
                if (r0 == 0) goto L2b
                goto Le
            L2b:
                boolean r0 = d(r5)
                if (r0 == 0) goto L32
                goto L4c
            L32:
                androidx.emoji2.text.m$a r0 = r4.c
                androidx.emoji2.text.g r0 = r0.b()
                if (r0 == 0) goto Le
                int r0 = r4.f
                r3 = 3
                if (r0 != r2) goto L45
                boolean r0 = r4.h()
                if (r0 == 0) goto Le
            L45:
                androidx.emoji2.text.m$a r0 = r4.c
                r4.d = r0
                r4.g()
            L4c:
                r4.e = r5
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.b.a(int):int");
        }

        public g b() {
            return this.c.b();
        }

        public g c() {
            return this.d.b();
        }

        public boolean e() {
            return this.a == 2 && this.c.b() != null && (this.f > 1 || h());
        }

        public final int g() {
            this.a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.c.b().j() || d(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public h(m mVar, e.i iVar, e.d dVar, boolean z, int[] iArr) {
        this.a = iVar;
        this.b = mVar;
        this.c = dVar;
        this.d = z;
        this.e = iArr;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z) {
        i[] iVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                max = a.a(editable, selectionStart, Math.max(i, 0));
                min = a.b(editable, selectionEnd, Math.max(i2, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i, 0);
                min = Math.min(selectionEnd + i2, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(max, min, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean d(Editable editable, int i, KeyEvent keyEvent) {
        if (!(i != 67 ? i != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean f(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    public static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(Spannable spannable, g gVar, int i, int i2) {
        spannable.setSpan(this.a.a(gVar), i, i2, 33);
    }

    public final boolean e(CharSequence charSequence, int i, int i2, g gVar) {
        if (gVar.d() == 0) {
            gVar.k(this.c.a(charSequence, i, i2, gVar.h()));
        }
        return gVar.d() == 2;
    }

    public CharSequence h(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        r rVar;
        int i4;
        i[] iVarArr;
        boolean z2 = charSequence instanceof n;
        if (z2) {
            ((n) charSequence).a();
        }
        if (!z2) {
            try {
                rVar = charSequence instanceof Spannable ? new r((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i + (-1), i2 + 1, i.class) > i2) ? null : new r(charSequence);
            } finally {
                if (z2) {
                    ((n) charSequence).d();
                }
            }
        }
        if (rVar != null && (iVarArr = (i[]) rVar.getSpans(i, i2, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = rVar.getSpanStart(iVar);
                int spanEnd = rVar.getSpanEnd(iVar);
                if (spanStart != i2) {
                    rVar.removeSpan(iVar);
                }
                i = Math.min(spanStart, i);
                i2 = Math.max(spanEnd, i2);
            }
        }
        if (i != i2 && i < charSequence.length()) {
            if (i3 != Integer.MAX_VALUE && rVar != null) {
                i3 -= ((i[]) rVar.getSpans(0, rVar.length(), i.class)).length;
            }
            b bVar = new b(this.b.f(), this.d, this.e);
            r rVar2 = rVar;
            int codePointAt = Character.codePointAt(charSequence, i);
            int i5 = 0;
            loop1: while (true) {
                i4 = i;
                while (i < i2 && i5 < i3) {
                    int a2 = bVar.a(codePointAt);
                    if (a2 == 1) {
                        i4 += Character.charCount(Character.codePointAt(charSequence, i4));
                        if (i4 < i2) {
                            codePointAt = Character.codePointAt(charSequence, i4);
                        }
                        i = i4;
                    } else if (a2 == 2) {
                        i += Character.charCount(codePointAt);
                        if (i < i2) {
                            codePointAt = Character.codePointAt(charSequence, i);
                        }
                    } else if (a2 == 3) {
                        if (z || !e(charSequence, i4, i, bVar.c())) {
                            if (rVar2 == null) {
                                rVar2 = new r((Spannable) new SpannableString(charSequence));
                            }
                            a(rVar2, bVar.c(), i4, i);
                            i5++;
                        }
                    }
                }
            }
            if (bVar.e() && i5 < i3 && (z || !e(charSequence, i4, i, bVar.b()))) {
                if (rVar2 == null) {
                    rVar2 = new r(charSequence);
                }
                a(rVar2, bVar.b(), i4, i);
            }
            if (rVar2 == null) {
                if (z2) {
                    ((n) charSequence).d();
                }
                return charSequence;
            }
            Spannable b2 = rVar2.b();
            if (z2) {
                ((n) charSequence).d();
            }
            return b2;
        }
        return charSequence;
    }
}
