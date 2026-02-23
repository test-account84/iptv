package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class CombiningEvaluator extends Evaluator {
    final ArrayList evaluators;
    int num;

    public static final class And extends CombiningEvaluator {
        public And(Collection collection) {
            super(collection);
        }

        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (!((Evaluator) this.evaluators.get(i)).matches(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.join((Collection) this.evaluators, " ");
        }

        public And(Evaluator... evaluatorArr) {
            this((Collection) Arrays.asList(evaluatorArr));
        }
    }

    public static final class Or extends CombiningEvaluator {
        public Or() {
        }

        public void add(Evaluator evaluator) {
            this.evaluators.add(evaluator);
            updateNumEvaluators();
        }

        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.num; i++) {
                if (((Evaluator) this.evaluators.get(i)).matches(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":or%s", new Object[]{this.evaluators});
        }

        public Or(Collection collection) {
            if (this.num > 1) {
                this.evaluators.add(new And(collection));
            } else {
                this.evaluators.addAll(collection);
            }
            updateNumEvaluators();
        }
    }

    public CombiningEvaluator() {
        this.num = 0;
        this.evaluators = new ArrayList();
    }

    public void replaceRightMostEvaluator(Evaluator evaluator) {
        this.evaluators.set(this.num - 1, evaluator);
    }

    public Evaluator rightMostEvaluator() {
        int i = this.num;
        if (i > 0) {
            return (Evaluator) this.evaluators.get(i - 1);
        }
        return null;
    }

    public void updateNumEvaluators() {
        this.num = this.evaluators.size();
    }

    public CombiningEvaluator(Collection collection) {
        this();
        this.evaluators.addAll(collection);
        updateNumEvaluators();
    }
}
