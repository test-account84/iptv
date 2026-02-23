package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Collector {

    public static class Accumulator implements NodeVisitor {
        private final Elements elements;
        private final Evaluator eval;
        private final Element root;

        public Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.root = element;
            this.elements = elements;
            this.eval = evaluator;
        }

        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.eval.matches(this.root, element)) {
                    this.elements.add(element);
                }
            }
        }

        public void tail(Node node, int i) {
        }
    }

    private Collector() {
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        new NodeTraversor(new Accumulator(element, elements, evaluator)).traverse(element);
        return elements;
    }
}
