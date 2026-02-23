package a4;

import D.l;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i {
    public final l.e a;

    public i(Context context, String str) {
        this.a = new l.e(context.getApplicationContext(), str);
    }

    public Notification a(Context context, int i, PendingIntent pendingIntent, String str) {
        return c(context, i, pendingIntent, str, S2.a.a);
    }

    public Notification b(Context context, int i, PendingIntent pendingIntent, String str) {
        return c(context, i, pendingIntent, str, S2.a.d);
    }

    public final Notification c(Context context, int i, PendingIntent pendingIntent, String str, int i2) {
        return d(context, i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    public final Notification d(Context context, int i, PendingIntent pendingIntent, String str, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a.D(i);
        String str2 = null;
        this.a.n(i2 == 0 ? null : context.getResources().getString(i2));
        this.a.l(pendingIntent);
        this.a.F(str == null ? null : new l.c().h(str));
        this.a.B(i3, i4, z);
        this.a.y(z2);
        this.a.C(z3);
        l.e eVar = this.a;
        if (i4 == 0) {
            if (i2 != 0) {
                str2 = context.getResources().getString(i2);
            }
        } else if (i2 != 0) {
            str2 = context.getResources().getString(i2) + "... " + i4 + "%";
        }
        eVar.n(str2);
        return this.a.c();
    }

    public Notification e(Context context, int i, PendingIntent pendingIntent, String str, List list) {
        return f(context, i, pendingIntent, str, list, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Notification f(android.content.Context r22, int r23, android.app.PendingIntent r24, java.lang.String r25, java.util.List r26, int r27) {
        /*
            r21 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
        La:
            int r10 = r26.size()
            if (r3 >= r10) goto L4a
            r10 = r26
            java.lang.Object r11 = r10.get(r3)
            z3.c r11 = (z3.c) r11
            int r12 = r11.b
            if (r12 == 0) goto L46
            r13 = 2
            if (r12 == r13) goto L28
            r13 = 5
            if (r12 == r13) goto L26
            r13 = 7
            if (r12 == r13) goto L28
            goto L47
        L26:
            r7 = 1
            goto L47
        L28:
            float r4 = r11.b()
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 == 0) goto L34
            float r0 = r0 + r4
            r9 = 0
        L34:
            long r11 = r11.a()
            r13 = 0
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 <= 0) goto L40
            r4 = 1
            goto L41
        L40:
            r4 = 0
        L41:
            r6 = r6 | r4
            int r8 = r8 + 1
            r4 = 1
            goto L47
        L46:
            r5 = 1
        L47:
            int r3 = r3 + 1
            goto La
        L4a:
            if (r4 == 0) goto L51
            int r3 = S2.a.c
        L4e:
            r15 = r3
            r3 = 1
            goto L6f
        L51:
            if (r5 == 0) goto L68
            if (r27 == 0) goto L68
            r3 = r27 & 2
            if (r3 == 0) goto L5e
            int r3 = S2.a.g
        L5b:
            r15 = r3
            r3 = 0
            goto L6f
        L5e:
            r3 = r27 & 1
            if (r3 == 0) goto L65
            int r3 = S2.a.f
            goto L5b
        L65:
            int r3 = S2.a.e
            goto L5b
        L68:
            if (r7 == 0) goto L6d
            int r3 = S2.a.h
            goto L4e
        L6d:
            r3 = 1
            r15 = 0
        L6f:
            if (r3 == 0) goto L8b
            r3 = 100
            if (r4 == 0) goto L84
            float r4 = (float) r8
            float r0 = r0 / r4
            int r0 = (int) r0
            if (r9 == 0) goto L7d
            if (r6 == 0) goto L7d
            r1 = 1
        L7d:
            r17 = r0
            r18 = r1
            r16 = 100
            goto L91
        L84:
            r16 = 100
            r17 = 0
            r18 = 1
            goto L91
        L8b:
            r16 = 0
            r17 = 0
            r18 = 0
        L91:
            r19 = 1
            r20 = 0
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            android.app.Notification r0 = r10.d(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.i.f(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List, int):android.app.Notification");
    }
}
