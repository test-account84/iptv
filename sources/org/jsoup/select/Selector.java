package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Selector {
    private final Evaluator evaluator;
    private final Element root;

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector(String str, Element element) {
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        Validate.notNull(element);
        this.evaluator = QueryParser.parse(trim);
        this.root = element;
    }

    public static Elements filterOut(Collection collection, Collection collection2) {
        Elements elements = new Elements();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            Iterator it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    elements.add(element);
                    break;
                }
                if (element.equals((Element) it2.next())) {
                    break;
                }
            }
        }
        return elements;
    }

    private Elements select() {
        return Collector.collect(this.evaluator, this.root);
    }

    private Selector(Evaluator evaluator, Element element) {
        Validate.notNull(evaluator);
        Validate.notNull(element);
        this.evaluator = evaluator;
        this.root = element;
    }

    public static Elements select(String str, Iterable iterable) {
        Validate.notEmpty(str);
        Validate.notNull(iterable);
        Evaluator parse = QueryParser.parse(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(select(parse, (Element) it.next()));
        }
        return new Elements((Collection) linkedHashSet);
    }

    public static Elements select(String str, Element element) {
        return new Selector(str, element).select();
    }

    public static Elements select(Evaluator evaluator, Element element) {
        return new Selector(evaluator, element).select();
    }
}
