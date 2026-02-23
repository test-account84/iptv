package org.simpleframework.xml.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HyphenBuilder implements Style {

    public class Parser extends Splitter {
        private Parser(String str) {
            super(str);
        }

        public void commit(char[] cArr, int i, int i2) {
            this.builder.append(cArr, i, i2);
            if (i + i2 < this.count) {
                this.builder.append('-');
            }
        }

        public void parse(char[] cArr, int i, int i2) {
            cArr[i] = toLower(cArr[i]);
        }

        public /* synthetic */ Parser(HyphenBuilder hyphenBuilder, String str, 1 r3) {
            this(str);
        }
    }

    public String getAttribute(String str) {
        if (str != null) {
            return new Parser(this, str, null).process();
        }
        return null;
    }

    public String getElement(String str) {
        if (str != null) {
            return new Parser(this, str, null).process();
        }
        return null;
    }
}
