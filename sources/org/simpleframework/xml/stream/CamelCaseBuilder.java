package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class CamelCaseBuilder implements Style {
    protected final boolean attribute;
    protected final boolean element;

    public class Attribute extends Splitter {
        private boolean capital;

        private Attribute(String str) {
            super(str);
        }

        public void commit(char[] cArr, int i, int i2) {
            this.builder.append(cArr, i, i2);
        }

        public void parse(char[] cArr, int i, int i2) {
            if (CamelCaseBuilder.this.attribute || this.capital) {
                cArr[i] = toUpper(cArr[i]);
            }
            this.capital = true;
        }

        public /* synthetic */ Attribute(CamelCaseBuilder camelCaseBuilder, String str, 1 r3) {
            this(str);
        }
    }

    public class Element extends Attribute {
        private boolean capital;

        private Element(String str) {
            super(CamelCaseBuilder.this, str, null);
        }

        public void parse(char[] cArr, int i, int i2) {
            if (CamelCaseBuilder.this.element || this.capital) {
                cArr[i] = toUpper(cArr[i]);
            }
            this.capital = true;
        }

        public /* synthetic */ Element(CamelCaseBuilder camelCaseBuilder, String str, 1 r3) {
            this(str);
        }
    }

    public CamelCaseBuilder(boolean z, boolean z2) {
        this.attribute = z2;
        this.element = z;
    }

    public String getAttribute(String str) {
        if (str != null) {
            return new Attribute(this, str, null).process();
        }
        return null;
    }

    public String getElement(String str) {
        if (str != null) {
            return new Element(this, str, null).process();
        }
        return null;
    }
}
