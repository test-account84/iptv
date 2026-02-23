package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    public Elements elements() {
        return this.elements;
    }

    public List formData() {
        String val;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.elements.iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.tag().isFormSubmittable() && !element.hasAttr("disabled")) {
                String attr = element.attr("name");
                if (attr.length() != 0) {
                    String attr2 = element.attr("type");
                    if ("select".equals(element.tagName())) {
                        Iterator it2 = element.select("option[selected]").iterator();
                        boolean z = false;
                        while (it2.hasNext()) {
                            arrayList.add(HttpConnection.KeyVal.create(attr, ((Element) it2.next()).val()));
                            z = true;
                        }
                        val = (z || (element = element.select("option").first()) == null) ? "on" : element.val();
                    } else {
                        if ("checkbox".equalsIgnoreCase(attr2) || "radio".equalsIgnoreCase(attr2)) {
                            if (element.hasAttr("checked")) {
                                if (element.val().length() > 0) {
                                }
                            }
                        }
                    }
                    arrayList.add(HttpConnection.KeyVal.create(attr, val));
                }
            }
        }
        return arrayList;
    }

    public Connection submit() {
        String absUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(absUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(absUrl).data((Collection) formData()).method(attr("method").toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }
}
