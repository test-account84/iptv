package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class HtmlTreeBuilderState {
    private static final /* synthetic */ HtmlTreeBuilderState[] $VALUES;
    public static final HtmlTreeBuilderState AfterAfterBody;
    public static final HtmlTreeBuilderState AfterAfterFrameset;
    public static final HtmlTreeBuilderState AfterBody;
    public static final HtmlTreeBuilderState AfterFrameset;
    public static final HtmlTreeBuilderState AfterHead;
    public static final HtmlTreeBuilderState BeforeHead;
    public static final HtmlTreeBuilderState BeforeHtml;
    public static final HtmlTreeBuilderState ForeignContent;
    public static final HtmlTreeBuilderState InBody;
    public static final HtmlTreeBuilderState InCaption;
    public static final HtmlTreeBuilderState InCell;
    public static final HtmlTreeBuilderState InColumnGroup;
    public static final HtmlTreeBuilderState InFrameset;
    public static final HtmlTreeBuilderState InHead;
    public static final HtmlTreeBuilderState InHeadNoscript;
    public static final HtmlTreeBuilderState InRow;
    public static final HtmlTreeBuilderState InSelect;
    public static final HtmlTreeBuilderState InSelectInTable;
    public static final HtmlTreeBuilderState InTable;
    public static final HtmlTreeBuilderState InTableBody;
    public static final HtmlTreeBuilderState InTableText;
    public static final HtmlTreeBuilderState Initial;
    public static final HtmlTreeBuilderState Text;
    private static String nullString;

    public enum 1 extends HtmlTreeBuilderState {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.access$100(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (!token.isDoctype()) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
                    return htmlTreeBuilder.process(token);
                }
                Token.Doctype asDoctype = token.asDoctype();
                htmlTreeBuilder.getDocument().appendChild(new DocumentType(asDoctype.getName(), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier(), htmlTreeBuilder.getBaseUri()));
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
            }
            return true;
        }
    }

    public enum 10 extends HtmlTreeBuilderState {
        public 10(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()] == 5) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.access$400())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (HtmlTreeBuilderState.access$2200(str)) {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    } else {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                        }
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    }

    public enum 11 extends HtmlTreeBuilderState {
        public 11(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().name().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().nodeName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                return true;
            }
            if ((token.isStartTag() && StringUtil.in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.isEndTag() && token.asEndTag().name().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            }
            if (!token.isEndTag() || !StringUtil.in(token.asEndTag().name(), "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    }

    public enum 12 extends HtmlTreeBuilderState {
        public 12(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.access$100(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = 24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                if (!name.equals("col")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insertEmpty(asStartTag);
            } else {
                if (i != 4) {
                    if (i == 6 && htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        return true;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (!token.asEndTag().name().equals("colgroup")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    }

    public enum 13 extends HtmlTreeBuilderState {
        public 13(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().nodeName());
            return htmlTreeBuilder.process(token);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            int i = 24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (!name.equals("tr")) {
                    if (!StringUtil.in(name, "th", "td")) {
                        return StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? exitTableBody(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(asStartTag);
                }
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
            } else {
                if (i != 4) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                String name2 = token.asEndTag().name();
                if (!StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                    if (name2.equals("table")) {
                        return exitTableBody(token, htmlTreeBuilder);
                    }
                    if (!StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (!htmlTreeBuilder.inTableScope(name2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.pop();
                htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
            }
            htmlTreeBuilder.transition(htmlTreeBuilderState);
            return true;
        }
    }

    public enum 14 extends HtmlTreeBuilderState {
        public 14(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (!StringUtil.in(name, "th", "td")) {
                    return StringUtil.in(name, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? handleMissingTr(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.clearStackToTableRowContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InCell);
                htmlTreeBuilder.insertMarkerToFormattingElements();
                return true;
            }
            if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            }
            String name2 = token.asEndTag().name();
            if (name2.equals("tr")) {
                if (!htmlTreeBuilder.inTableScope(name2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.clearStackToTableRowContext();
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                return true;
            }
            if (name2.equals("table")) {
                return handleMissingTr(token, htmlTreeBuilder);
            }
            if (!StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                if (!StringUtil.in(name2, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            if (htmlTreeBuilder.inTableScope(name2)) {
                htmlTreeBuilder.processEndTag("tr");
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    }

    public enum 15 extends HtmlTreeBuilderState {
        public 15(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.inTableScope("td") ? "td" : "th");
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String name = token.asEndTag().name();
                if (StringUtil.in(name, "td", "th")) {
                    if (!htmlTreeBuilder.inTableScope(name)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(name)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                    return true;
                }
                if (StringUtil.in(name, "body", "caption", "col", "colgroup", "html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (!StringUtil.in(name, "table", "tbody", "tfoot", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.inTableScope(name)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else {
                if (!token.isStartTag() || !StringUtil.in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            closeCell(htmlTreeBuilder);
            return htmlTreeBuilder.process(token);
        }
    }

    public enum 16 extends HtmlTreeBuilderState {
        public 16(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
        
            if (r9.currentElement().nodeName().equals("optgroup") != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
        
            r9.pop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        
            if (r9.currentElement().nodeName().equals("option") != false) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(org.jsoup.parser.Token r8, org.jsoup.parser.HtmlTreeBuilder r9) {
            /*
                Method dump skipped, instructions count: 372
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.16.process(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    }

    public enum 17 extends HtmlTreeBuilderState {
        public 17(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag() || !StringUtil.in(token.asEndTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InSelect);
            }
            htmlTreeBuilder.error(this);
            if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                return false;
            }
            htmlTreeBuilder.processEndTag("select");
            return htmlTreeBuilder.process(token);
        }
    }

    public enum 18 extends HtmlTreeBuilderState {
        public 18(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.access$100(token)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterBody);
                return true;
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
            return htmlTreeBuilder.process(token);
        }
    }

    public enum 19 extends HtmlTreeBuilderState {
        public 19(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.access$100(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag()) {
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                    } else if (name.equals("frameset")) {
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (name.equals("frame")) {
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else {
                        if (!name.equals("noframes")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
                    }
                    return htmlTreeBuilder.process(asStartTag, htmlTreeBuilderState);
                }
                if (token.isEndTag() && token.asEndTag().name().equals("frameset")) {
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterFrameset);
                    }
                } else {
                    if (!token.isEOF()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                }
            }
            return true;
        }
    }

    public enum 2 extends HtmlTreeBuilderState {
        public 2(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.process(token);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (HtmlTreeBuilderState.access$100(token)) {
                    return true;
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("html")) {
                    if ((!token.isEndTag() || !StringUtil.in(token.asEndTag().name(), "head", "body", "html", "br")) && token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insert(token.asStartTag());
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            }
            return true;
        }
    }

    public enum 20 extends HtmlTreeBuilderState {
        public 20(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.access$100(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            } else {
                if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterFrameset);
                    return true;
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("noframes")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
            }
            return htmlTreeBuilder.process(token, htmlTreeBuilderState);
        }
    }

    public enum 21 extends HtmlTreeBuilderState {
        public 21(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.access$100(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
            return htmlTreeBuilder.process(token);
        }
    }

    public enum 22 extends HtmlTreeBuilderState {
        public 22(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.access$100(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    }

    public enum 23 extends HtmlTreeBuilderState {
        public 23(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    }

    public static /* synthetic */ class 24 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum 3 extends HtmlTreeBuilderState {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.access$100(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                    return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("head")) {
                    if (token.isEndTag() && StringUtil.in(token.asEndTag().name(), "head", "body", "html", "br")) {
                        htmlTreeBuilder.processStartTag("head");
                        return htmlTreeBuilder.process(token);
                    }
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
            }
            return true;
        }
    }

    public enum 4 extends HtmlTreeBuilderState {
        public 4(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.access$100(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = 24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (i == 3) {
                    Token.StartTag asStartTag = token.asStartTag();
                    String name = asStartTag.name();
                    if (name.equals("html")) {
                        return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                    }
                    if (StringUtil.in(name, "base", "basefont", "bgsound", "command", "link")) {
                        Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                        if (name.equals("base") && insertEmpty.hasAttr("href")) {
                            htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                        }
                    } else if (name.equals("meta")) {
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else if (name.equals("title")) {
                        HtmlTreeBuilderState.access$200(asStartTag, htmlTreeBuilder);
                    } else if (StringUtil.in(name, "noframes", "style")) {
                        HtmlTreeBuilderState.access$300(asStartTag, htmlTreeBuilder);
                    } else if (name.equals("noscript")) {
                        htmlTreeBuilder.insert(asStartTag);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InHeadNoscript;
                    } else {
                        if (!name.equals("script")) {
                            if (!name.equals("head")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                        htmlTreeBuilder.insert(asStartTag);
                    }
                } else {
                    if (i != 4) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    String name2 = token.asEndTag().name();
                    if (!name2.equals("head")) {
                        if (StringUtil.in(name2, "body", "html", "br")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    htmlTreeBuilderState = HtmlTreeBuilderState.AfterHead;
                }
                htmlTreeBuilder.transition(htmlTreeBuilderState);
            }
            return true;
        }
    }

    public enum 5 extends HtmlTreeBuilderState {
        public 5(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("noscript")) {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                return true;
            }
            if (HtmlTreeBuilderState.access$100(token) || token.isComment() || (token.isStartTag() && StringUtil.in(token.asStartTag().name(), "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("br")) {
                return anythingElse(token, htmlTreeBuilder);
            }
            if ((!token.isStartTag() || !StringUtil.in(token.asStartTag().name(), "head", "noscript")) && !token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    }

    public enum 6 extends HtmlTreeBuilderState {
        public 6(String str, int i) {
            super(str, i, null);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.access$100(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String name = asStartTag.name();
                if (name.equals("html")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                if (name.equals("body")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                } else if (name.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                } else {
                    if (StringUtil.in(name, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                        htmlTreeBuilder.error(this);
                        Element headElement = htmlTreeBuilder.getHeadElement();
                        htmlTreeBuilder.push(headElement);
                        htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                        htmlTreeBuilder.removeFromStack(headElement);
                        return true;
                    }
                    if (name.equals("head")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
                htmlTreeBuilder.transition(htmlTreeBuilderState);
                return true;
            }
            if (token.isEndTag() && !StringUtil.in(token.asEndTag().name(), "body", "html")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            anythingElse(token, htmlTreeBuilder);
            return true;
        }
    }

    public enum 7 extends HtmlTreeBuilderState {
        public 7(String str, int i) {
            super(str, i, null);
        }

        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String name = token.asEndTag().name();
            ArrayList stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = (Element) stack.get(size);
                if (element.nodeName().equals(name)) {
                    htmlTreeBuilder.generateImpliedEndTags(name);
                    if (!name.equals(htmlTreeBuilder.currentElement().nodeName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(name);
                } else {
                    if (htmlTreeBuilder.isSpecial(element)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    size--;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:216:0x0381  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(org.jsoup.parser.Token r18, org.jsoup.parser.HtmlTreeBuilder r19) {
            /*
                Method dump skipped, instructions count: 2104
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.7.process(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    }

    public enum 8 extends HtmlTreeBuilderState {
        public 8(String str, int i) {
            super(str, i, null);
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag()) {
                return true;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return true;
        }
    }

    public enum 9 extends HtmlTreeBuilderState {
        public 9(String str, int i) {
            super(str, i, null);
        }

        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (!StringUtil.in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.setFosterInserts(true);
            boolean process = htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return process;
        }

        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder.process(token);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!token.isStartTag()) {
                if (!token.isEndTag()) {
                    if (!token.isEOF()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                    return true;
                }
                String name = token.asEndTag().name();
                if (!name.equals("table")) {
                    if (!StringUtil.in(name, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (!htmlTreeBuilder.inTableScope(name)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.popStackToClose("table");
                htmlTreeBuilder.resetInsertionMode();
                return true;
            }
            Token.StartTag asStartTag = token.asStartTag();
            String name2 = asStartTag.name();
            if (name2.equals("caption")) {
                htmlTreeBuilder.clearStackToTableContext();
                htmlTreeBuilder.insertMarkerToFormattingElements();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
            } else if (name2.equals("colgroup")) {
                htmlTreeBuilder.clearStackToTableContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
            } else {
                if (name2.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                }
                if (!StringUtil.in(name2, "tbody", "tfoot", "thead")) {
                    if (StringUtil.in(name2, "td", "th", "tr")) {
                        htmlTreeBuilder.processStartTag("tbody");
                        return htmlTreeBuilder.process(token);
                    }
                    if (name2.equals("table")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.processEndTag("table")) {
                            return htmlTreeBuilder.process(token);
                        }
                    } else {
                        if (StringUtil.in(name2, "style", "script")) {
                            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                        }
                        if (name2.equals("input")) {
                            if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.insertEmpty(asStartTag);
                        } else {
                            if (!name2.equals("form")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null) {
                                return false;
                            }
                            htmlTreeBuilder.insertForm(asStartTag, false);
                        }
                    }
                    return true;
                }
                htmlTreeBuilder.clearStackToTableContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
            }
            htmlTreeBuilder.transition(htmlTreeBuilderState);
            return true;
        }
    }

    public static final class Constants {
        private static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
        private static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        private static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        private static final String[] InBodyStartPreListing = {"pre", "listing"};
        private static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        private static final String[] DdDt = {"dd", "dt"};
        private static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        private static final String[] InBodyStartEmptyFormatters = {"area", "br", "embed", "img", "keygen", "wbr"};
        private static final String[] InBodyStartMedia = {"param", "source", "track"};
        private static final String[] InBodyStartInputAttribs = {"name", "action", "prompt"};
        private static final String[] InBodyStartOptions = {"optgroup", "option"};
        private static final String[] InBodyStartRuby = {"rp", "rt"};
        private static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        private static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        private static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        private static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};

        private Constants() {
        }

        public static /* synthetic */ String[] access$1000() {
            return InBodyStartPreListing;
        }

        public static /* synthetic */ String[] access$1100() {
            return DdDt;
        }

        public static /* synthetic */ String[] access$1200() {
            return Formatters;
        }

        public static /* synthetic */ String[] access$1300() {
            return InBodyStartApplets;
        }

        public static /* synthetic */ String[] access$1400() {
            return InBodyStartMedia;
        }

        public static /* synthetic */ String[] access$1500() {
            return InBodyStartInputAttribs;
        }

        public static /* synthetic */ String[] access$1600() {
            return InBodyStartOptions;
        }

        public static /* synthetic */ String[] access$1700() {
            return InBodyStartRuby;
        }

        public static /* synthetic */ String[] access$1800() {
            return InBodyStartDrop;
        }

        public static /* synthetic */ String[] access$1900() {
            return InBodyEndAdoptionFormatters;
        }

        public static /* synthetic */ String[] access$2000() {
            return InBodyEndTableFosters;
        }

        public static /* synthetic */ String[] access$2100() {
            return InBodyEndClosers;
        }

        public static /* synthetic */ String[] access$500() {
            return InBodyStartEmptyFormatters;
        }

        public static /* synthetic */ String[] access$600() {
            return InBodyStartPClosers;
        }

        public static /* synthetic */ String[] access$700() {
            return InBodyStartLiBreakers;
        }

        public static /* synthetic */ String[] access$800() {
            return InBodyStartToHead;
        }

        public static /* synthetic */ String[] access$900() {
            return Headings;
        }
    }

    static {
        1 r0 = new 1("Initial", 0);
        Initial = r0;
        2 r1 = new 2("BeforeHtml", 1);
        BeforeHtml = r1;
        3 r3 = new 3("BeforeHead", 2);
        BeforeHead = r3;
        4 r5 = new 4("InHead", 3);
        InHead = r5;
        5 r7 = new 5("InHeadNoscript", 4);
        InHeadNoscript = r7;
        6 r9 = new 6("AfterHead", 5);
        AfterHead = r9;
        7 r11 = new 7("InBody", 6);
        InBody = r11;
        8 r13 = new 8("Text", 7);
        Text = r13;
        9 r15 = new 9("InTable", 8);
        InTable = r15;
        10 r14 = new 10("InTableText", 9);
        InTableText = r14;
        11 r12 = new 11("InCaption", 10);
        InCaption = r12;
        12 r10 = new 12("InColumnGroup", 11);
        InColumnGroup = r10;
        13 r8 = new 13("InTableBody", 12);
        InTableBody = r8;
        14 r6 = new 14("InRow", 13);
        InRow = r6;
        15 r4 = new 15("InCell", 14);
        InCell = r4;
        16 r2 = new 16("InSelect", 15);
        InSelect = r2;
        17 r62 = new 17("InSelectInTable", 16);
        InSelectInTable = r62;
        18 r42 = new 18("AfterBody", 17);
        AfterBody = r42;
        19 r22 = new 19("InFrameset", 18);
        InFrameset = r22;
        20 r63 = new 20("AfterFrameset", 19);
        AfterFrameset = r63;
        21 r43 = new 21("AfterAfterBody", 20);
        AfterAfterBody = r43;
        22 r23 = new 22("AfterAfterFrameset", 21);
        AfterAfterFrameset = r23;
        23 r64 = new 23("ForeignContent", 22);
        ForeignContent = r64;
        $VALUES = new HtmlTreeBuilderState[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r62, r42, r22, r63, r43, r23, r64};
        nullString = String.valueOf((char) 0);
    }

    private HtmlTreeBuilderState(String str, int i) {
    }

    public static /* synthetic */ boolean access$100(Token token) {
        return isWhitespace(token);
    }

    public static /* synthetic */ void access$200(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        handleRcData(startTag, htmlTreeBuilder);
    }

    public static /* synthetic */ boolean access$2200(String str) {
        return isWhitespace(str);
    }

    public static /* synthetic */ void access$300(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        handleRawtext(startTag, htmlTreeBuilder);
    }

    public static /* synthetic */ String access$400() {
        return nullString;
    }

    private static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    private static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    private static boolean isWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static HtmlTreeBuilderState valueOf(String str) {
        return (HtmlTreeBuilderState) Enum.valueOf(HtmlTreeBuilderState.class, str);
    }

    public static HtmlTreeBuilderState[] values() {
        return (HtmlTreeBuilderState[]) $VALUES.clone();
    }

    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    public /* synthetic */ HtmlTreeBuilderState(String str, int i, 1 r3) {
        this(str, i);
    }

    private static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return isWhitespace(token.asCharacter().getData());
        }
        return false;
    }
}
