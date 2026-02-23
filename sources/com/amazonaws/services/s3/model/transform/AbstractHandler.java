package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class AbstractHandler extends DefaultHandler {
    private final StringBuilder text = new StringBuilder();
    private final LinkedList context = new LinkedList();

    public final boolean atTopLevel() {
        return this.context.isEmpty();
    }

    public final void characters(char[] cArr, int i, int i2) {
        this.text.append(cArr, i, i2);
    }

    public abstract void doEndElement(String str, String str2, String str3);

    public abstract void doStartElement(String str, String str2, String str3, Attributes attributes);

    public final void endElement(String str, String str2, String str3) {
        this.context.removeLast();
        doEndElement(str, str2, str3);
    }

    public final String getText() {
        return this.text.toString();
    }

    public final boolean in(String... strArr) {
        if (strArr.length != this.context.size()) {
            return false;
        }
        Iterator it = this.context.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = strArr[i];
            if (!str2.equals("*") && !str2.equals(str)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.text.setLength(0);
        doStartElement(str, str2, str3, attributes);
        this.context.add(str2);
    }
}
