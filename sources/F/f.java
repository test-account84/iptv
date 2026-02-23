package F;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {

    public static final class a {
        public final int[] a;
        public final float[] b;

        public a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        public a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        public a(List list, List list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = ((Integer) list.get(i)).intValue();
                this.b[i] = ((Float) list2.get(i)).floatValue();
            }
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    public static F.f.a a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r0v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray s = k.s(resources, theme, attributeSet, C.d.A);
        float j = k.j(s, xmlPullParser, "startX", C.d.J, 0.0f);
        float j2 = k.j(s, xmlPullParser, "startY", C.d.K, 0.0f);
        float j3 = k.j(s, xmlPullParser, "endX", C.d.L, 0.0f);
        float j4 = k.j(s, xmlPullParser, "endY", C.d.M, 0.0f);
        float j5 = k.j(s, xmlPullParser, "centerX", C.d.E, 0.0f);
        float j6 = k.j(s, xmlPullParser, "centerY", C.d.F, 0.0f);
        int k = k.k(s, xmlPullParser, "type", C.d.D, 0);
        int f = k.f(s, xmlPullParser, "startColor", C.d.B, 0);
        boolean r = k.r(xmlPullParser, "centerColor");
        int f2 = k.f(s, xmlPullParser, "centerColor", C.d.I, 0);
        int f3 = k.f(s, xmlPullParser, "endColor", C.d.C, 0);
        int k2 = k.k(s, xmlPullParser, "tileMode", C.d.H, 0);
        float j7 = k.j(s, xmlPullParser, "gradientRadius", C.d.G, 0.0f);
        s.recycle();
        a a2 = a(c(resources, xmlPullParser, attributeSet, theme), f, f3, r, f2);
        if (k != 1) {
            return k != 2 ? new LinearGradient(j, j2, j3, j4, a2.a, a2.b, d(k2)) : new SweepGradient(j5, j6, a2.a, a2.b);
        }
        if (j7 > 0.0f) {
            return new RadialGradient(j5, j6, j7, a2.a, a2.b, d(k2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static F.f.a c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = C.d.N
            android.content.res.TypedArray r3 = F.k.s(r8, r11, r10, r3)
            int r5 = C.d.O
            boolean r5 = r3.hasValue(r5)
            int r6 = C.d.P
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = C.d.O
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = C.d.P
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            F.f$a r8 = new F.f$a
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: F.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):F.f$a");
    }

    public static Shader.TileMode d(int i) {
        return i != 1 ? i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
