package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class QueryParser {
    private List evals = new ArrayList();
    private String query;
    private TokenQueue tq;
    private static final String[] combinators = {",", ">", "+", "~", " "};
    private static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("(\\+|-)?(\\d+)");

    private QueryParser(String str) {
        this.query = str;
        this.tq = new TokenQueue(str);
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void byAttribute() {
        List list;
        Object attributeWithValueMatching;
        TokenQueue tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                this.evals.add(new Evaluator.AttributeStarting(consumeToAny.substring(1)));
                return;
            } else {
                this.evals.add(new Evaluator.Attribute(consumeToAny));
                return;
            }
        }
        if (tokenQueue.matchChomp("=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("!=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("^=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("$=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder());
        } else if (tokenQueue.matchChomp("*=")) {
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder());
        } else {
            if (!tokenQueue.matchChomp("~=")) {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
            }
            list = this.evals;
            attributeWithValueMatching = new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder()));
        }
        list.add(attributeWithValueMatching);
    }

    private void byClass() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Class(consumeCssIdentifier.trim().toLowerCase()));
    }

    private void byId() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Id(consumeCssIdentifier));
    }

    private void byTag() {
        String consumeElementSelector = this.tq.consumeElementSelector();
        Validate.notEmpty(consumeElementSelector);
        if (consumeElementSelector.contains("|")) {
            consumeElementSelector = consumeElementSelector.replace("|", ":");
        }
        this.evals.add(new Evaluator.Tag(consumeElementSelector.trim().toLowerCase()));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combinator(char r11) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.combinator(char):void");
    }

    private int consumeIndex() {
        String trim = this.tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String consumeSubQuery() {
        String str;
        StringBuilder sb = new StringBuilder();
        while (!this.tq.isEmpty()) {
            if (this.tq.matches("(")) {
                sb.append("(");
                sb.append(this.tq.chompBalanced('(', ')'));
                str = ")";
            } else if (this.tq.matches("[")) {
                sb.append("[");
                sb.append(this.tq.chompBalanced('[', ']'));
                str = "]";
            } else {
                if (this.tq.matchesAny(combinators)) {
                    break;
                }
                sb.append(this.tq.consume());
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private void contains(boolean z) {
        List list;
        Object containsText;
        this.tq.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            list = this.evals;
            containsText = new Evaluator.ContainsOwnText(unescape);
        } else {
            list = this.evals;
            containsText = new Evaluator.ContainsText(unescape);
        }
        list.add(containsText);
    }

    private void cssNthChild(boolean z, boolean z2) {
        int parseInt;
        List list;
        Object isNthChild;
        String lowerCase = this.tq.chompTo(")").trim().toLowerCase();
        Matcher matcher = NTH_AB.matcher(lowerCase);
        Matcher matcher2 = NTH_B.matcher(lowerCase);
        if ("odd".equals(lowerCase)) {
            r0 = 2;
            parseInt = 1;
        } else if ("even".equals(lowerCase)) {
            r0 = 2;
            parseInt = 0;
        } else if (matcher.matches()) {
            int parseInt2 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
            parseInt = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
            r0 = parseInt2;
        } else {
            if (!matcher2.matches()) {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", lowerCase);
            }
            parseInt = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
        }
        if (z2) {
            if (z) {
                list = this.evals;
                isNthChild = new Evaluator.IsNthLastOfType(r0, parseInt);
            } else {
                list = this.evals;
                isNthChild = new Evaluator.IsNthOfType(r0, parseInt);
            }
        } else if (z) {
            list = this.evals;
            isNthChild = new Evaluator.IsNthLastChild(r0, parseInt);
        } else {
            list = this.evals;
            isNthChild = new Evaluator.IsNthChild(r0, parseInt);
        }
        list.add(isNthChild);
    }

    private void findElements() {
        List list;
        Object isRoot;
        if (this.tq.matchChomp("#")) {
            byId();
            return;
        }
        if (this.tq.matchChomp(".")) {
            byClass();
            return;
        }
        if (this.tq.matchesWord()) {
            byTag();
            return;
        }
        if (this.tq.matches("[")) {
            byAttribute();
            return;
        }
        if (this.tq.matchChomp("*")) {
            allElements();
            return;
        }
        if (this.tq.matchChomp(":lt(")) {
            indexLessThan();
            return;
        }
        if (this.tq.matchChomp(":gt(")) {
            indexGreaterThan();
            return;
        }
        if (this.tq.matchChomp(":eq(")) {
            indexEquals();
            return;
        }
        if (this.tq.matches(":has(")) {
            has();
            return;
        }
        if (this.tq.matches(":contains(")) {
            contains(false);
            return;
        }
        if (this.tq.matches(":containsOwn(")) {
            contains(true);
            return;
        }
        if (this.tq.matches(":matches(")) {
            matches(false);
            return;
        }
        if (this.tq.matches(":matchesOwn(")) {
            matches(true);
            return;
        }
        if (this.tq.matches(":not(")) {
            not();
            return;
        }
        if (this.tq.matchChomp(":nth-child(")) {
            cssNthChild(false, false);
            return;
        }
        if (this.tq.matchChomp(":nth-last-child(")) {
            cssNthChild(true, false);
            return;
        }
        if (this.tq.matchChomp(":nth-of-type(")) {
            cssNthChild(false, true);
            return;
        }
        if (this.tq.matchChomp(":nth-last-of-type(")) {
            cssNthChild(true, true);
            return;
        }
        if (this.tq.matchChomp(":first-child")) {
            list = this.evals;
            isRoot = new Evaluator.IsFirstChild();
        } else if (this.tq.matchChomp(":last-child")) {
            list = this.evals;
            isRoot = new Evaluator.IsLastChild();
        } else if (this.tq.matchChomp(":first-of-type")) {
            list = this.evals;
            isRoot = new Evaluator.IsFirstOfType();
        } else if (this.tq.matchChomp(":last-of-type")) {
            list = this.evals;
            isRoot = new Evaluator.IsLastOfType();
        } else if (this.tq.matchChomp(":only-child")) {
            list = this.evals;
            isRoot = new Evaluator.IsOnlyChild();
        } else if (this.tq.matchChomp(":only-of-type")) {
            list = this.evals;
            isRoot = new Evaluator.IsOnlyOfType();
        } else if (this.tq.matchChomp(":empty")) {
            list = this.evals;
            isRoot = new Evaluator.IsEmpty();
        } else {
            if (!this.tq.matchChomp(":root")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.tq.remainder());
            }
            list = this.evals;
            isRoot = new Evaluator.IsRoot();
        }
        list.add(isRoot);
    }

    private void has() {
        this.tq.consume(":has");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":has(el) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(chompBalanced)));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void matches(boolean z) {
        List list;
        Object matches;
        this.tq.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            list = this.evals;
            matches = new Evaluator.MatchesOwn(Pattern.compile(chompBalanced));
        } else {
            list = this.evals;
            matches = new Evaluator.Matches(Pattern.compile(chompBalanced));
        }
        list.add(matches);
    }

    private void not() {
        this.tq.consume(":not");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(chompBalanced)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0026, code lost:
    
        findElements();
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0041 -> B:5:0x001f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003c -> B:4:0x0019). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jsoup.select.Evaluator parse() {
        /*
            r3 = this;
            org.jsoup.parser.TokenQueue r0 = r3.tq
            r0.consumeWhitespace()
            org.jsoup.parser.TokenQueue r0 = r3.tq
            java.lang.String[] r1 = org.jsoup.select.QueryParser.combinators
            boolean r0 = r0.matchesAny(r1)
            if (r0 == 0) goto L23
            java.util.List r0 = r3.evals
            org.jsoup.select.StructuralEvaluator$Root r1 = new org.jsoup.select.StructuralEvaluator$Root
            r1.<init>()
            r0.add(r1)
        L19:
            org.jsoup.parser.TokenQueue r0 = r3.tq
            char r0 = r0.consume()
        L1f:
            r3.combinator(r0)
            goto L26
        L23:
            r3.findElements()
        L26:
            org.jsoup.parser.TokenQueue r0 = r3.tq
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L44
            org.jsoup.parser.TokenQueue r0 = r3.tq
            boolean r0 = r0.consumeWhitespace()
            org.jsoup.parser.TokenQueue r1 = r3.tq
            java.lang.String[] r2 = org.jsoup.select.QueryParser.combinators
            boolean r1 = r1.matchesAny(r2)
            if (r1 == 0) goto L3f
            goto L19
        L3f:
            if (r0 == 0) goto L23
            r0 = 32
            goto L1f
        L44:
            java.util.List r0 = r3.evals
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L57
            java.util.List r0 = r3.evals
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            org.jsoup.select.Evaluator r0 = (org.jsoup.select.Evaluator) r0
            return r0
        L57:
            org.jsoup.select.CombiningEvaluator$And r0 = new org.jsoup.select.CombiningEvaluator$And
            java.util.List r1 = r3.evals
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.parse():org.jsoup.select.Evaluator");
    }

    public static Evaluator parse(String str) {
        return new QueryParser(str).parse();
    }
}
