package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;
    public SparseArray d = new SparseArray();
    public SparseArray e = new SparseArray();

    public static class a {
        public int a;
        public ArrayList b = new ArrayList();
        public int c;
        public androidx.constraintlayout.widget.c d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.q4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == d.r4) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == d.s4) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.d = cVar;
                        cVar.f(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }
    }

    public static class b {
        public float a;
        public float b;
        public float c;
        public float d;
        public int e;
        public androidx.constraintlayout.widget.c f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.M4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == d.N4) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f = cVar;
                        cVar.f(context, this.e);
                    }
                } else if (index == d.O4) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == d.P4) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == d.Q4) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == d.R4) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i) {
        this.a = constraintLayout;
        a(context, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto Lab
            if (r0 == 0) goto L9b
            r3 = 2
            if (r0 == r3) goto L17
            goto L9e
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L53;
                case 80204913: goto L49;
                case 1382829617: goto L3f;
                case 1657696882: goto L35;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
        L24:
            goto L5d
        L25:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 3
            goto L5e
        L2f:
            r8 = move-exception
            goto La4
        L32:
            r8 = move-exception
            goto La8
        L35:
            java.lang.String r4 = "layoutDescription"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 0
            goto L5e
        L3f:
            java.lang.String r4 = "StateSet"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 1
            goto L5e
        L49:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 2
            goto L5e
        L53:
            java.lang.String r4 = "ConstraintSet"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 4
            goto L5e
        L5d:
            r4 = -1
        L5e:
            if (r4 == 0) goto L9e
            if (r4 == r2) goto L9e
            if (r4 == r3) goto L8e
            if (r4 == r6) goto L83
            if (r4 == r5) goto L7f
            java.lang.String r2 = "ConstraintLayoutStates"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r3.<init>()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            java.lang.String r4 = "unknown tag "
            r3.append(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r3.append(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            android.util.Log.v(r2, r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L7f:
            r7.b(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L83:
            z.a$b r0 = new z.a$b     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r1 == 0) goto L9e
            r1.a(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L8e:
            z.a$a r1 = new z.a$a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            android.util.SparseArray r0 = r7.d     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            int r2 = r1.a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r0.put(r2, r1)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L9b:
            r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
        L9e:
            int r0 = r9.next()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto Ld
        La4:
            r8.printStackTrace()
            goto Lab
        La8:
            r8.printStackTrace()
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.m(context, xmlPullParser);
                this.e.put(identifier, cVar);
                return;
            }
        }
    }

    public void c(z.b bVar) {
    }
}
