package org.jsoup.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Element contextElement;
    private FormElement formElement;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private HtmlTreeBuilderState state;
    private static final String[] TagsScriptStyle = {"script", "style"};
    public static final String[] TagsSearchInScope = {"applet", "caption", "html", "table", "td", "th", "marquee", "object"};
    private static final String[] TagSearchList = {"ol", "ul"};
    private static final String[] TagSearchButton = {"button"};
    private static final String[] TagSearchTableScope = {"html", "table"};
    private static final String[] TagSearchSelectScope = {"optgroup", "option"};
    private static final String[] TagSearchEndTags = {"dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"};
    private static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    private boolean baseUriSetFromDoc = false;
    private ArrayList formattingElements = new ArrayList();
    private List pendingTableCharacters = new ArrayList();
    private Token.EndTag emptyEnd = new Token.EndTag();
    private boolean framesetOk = true;
    private boolean fosterInserts = false;
    private boolean fragmentParsing = false;
    private String[] specificScopeTarget = {null};

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            if (StringUtil.in(element.nodeName(), strArr) || element.nodeName().equals("html")) {
                return;
            }
            this.stack.remove(size);
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void insertNode(org.jsoup.nodes.Node r2) {
        /*
            r1 = this;
            java.util.ArrayList r0 = r1.stack
            int r0 = r0.size()
            if (r0 != 0) goto Le
            org.jsoup.nodes.Document r0 = r1.doc
        La:
            r0.appendChild(r2)
            goto L1d
        Le:
            boolean r0 = r1.isFosterInserts()
            if (r0 == 0) goto L18
            r1.insertInFosterParent(r2)
            goto L1d
        L18:
            org.jsoup.nodes.Element r0 = r1.currentElement()
            goto La
        L1d:
            boolean r0 = r2 instanceof org.jsoup.nodes.Element
            if (r0 == 0) goto L34
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            org.jsoup.parser.Tag r0 = r2.tag()
            boolean r0 = r0.isFormListed()
            if (r0 == 0) goto L34
            org.jsoup.nodes.FormElement r0 = r1.formElement
            if (r0 == 0) goto L34
            r0.addElement(r2)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.insertNode(org.jsoup.nodes.Node):void");
    }

    private boolean isElementInQueue(ArrayList arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Element) arrayList.get(size)) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.nodeName().equals(element2.nodeName()) && element.attributes().equals(element2.attributes());
    }

    private void replaceInQueue(ArrayList arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (((Element) this.stack.get(size)) == element) {
                return (Element) this.stack.get(size - 1);
            }
        }
        return null;
    }

    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead");
    }

    public void clearStackToTableContext() {
        clearStackToContext("table");
    }

    public void clearStackToTableRowContext() {
        clearStackToContext("tr");
    }

    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = (Element) this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.nodeName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public String getBaseUri() {
        return this.baseUri;
    }

    public Document getDocument() {
        return this.doc;
    }

    public FormElement getFormElement() {
        return this.formElement;
    }

    public Element getFromStack(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            if (element.nodeName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public Element getHeadElement() {
        return this.headElement;
    }

    public List getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    public ArrayList getStack() {
        return this.stack;
    }

    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    public boolean inScope(String str) {
        return inScope(str, null);
    }

    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String nodeName = ((Element) this.stack.get(size)).nodeName();
            if (nodeName.equals(str)) {
                return true;
            }
            if (!StringUtil.in(nodeName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    public Element insert(Token.StartTag startTag) {
        if (!startTag.isSelfClosing()) {
            Element element = new Element(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
            insert(element);
            return element;
        }
        Element insertEmpty = insertEmpty(startTag);
        this.stack.add(insertEmpty);
        this.tokeniser.transition(TokeniserState.Data);
        this.tokeniser.emit(this.emptyEnd.reset().name(insertEmpty.tagName()));
        return insertEmpty;
    }

    public Element insertEmpty(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name());
        Element element = new Element(valueOf, this.baseUri, startTag.attributes);
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (!valueOf.isKnownTag()) {
                valueOf.setSelfClosing();
            } else if (valueOf.isSelfClosing()) {
            }
            this.tokeniser.acknowledgeSelfClosingFlag();
        }
        return element;
    }

    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement = new FormElement(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
        setFormElement(formElement);
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    public void insertInFosterParent(Node node) {
        Element element;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack == null) {
            element = (Element) this.stack.get(0);
        } else if (fromStack.parent() != null) {
            element = fromStack.parent();
            z = true;
        } else {
            element = aboveOnStack(fromStack);
        }
        if (!z) {
            element.appendChild(node);
        } else {
            Validate.notNull(fromStack);
            fromStack.before(node);
        }
    }

    public void insertMarkerToFormattingElements() {
        this.formattingElements.add((Object) null);
    }

    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    public Element insertStartTag(String str) {
        Element element = new Element(Tag.valueOf(str), this.baseUri);
        insert(element);
        return element;
    }

    public boolean isFosterInserts() {
        return this.fosterInserts;
    }

    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    public boolean isSpecial(Element element) {
        return StringUtil.in(element.nodeName(), TagSearchSpecial);
    }

    public Element lastFormattingElement() {
        if (this.formattingElements.size() <= 0) {
            return null;
        }
        return (Element) this.formattingElements.get(r0.size() - 1);
    }

    public void markInsertionMode() {
        this.originalState = this.state;
    }

    public void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String absUrl = element.absUrl("href");
        if (absUrl.length() != 0) {
            this.baseUri = absUrl;
            this.baseUriSetFromDoc = true;
            this.doc.setBaseUri(absUrl);
        }
    }

    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    public Document parse(String str, String str2, ParseErrorList parseErrorList) {
        this.state = HtmlTreeBuilderState.Initial;
        this.baseUriSetFromDoc = false;
        return super.parse(str, str2, parseErrorList);
    }

    public List parseFragment(String str, Element element, String str2, ParseErrorList parseErrorList) {
        Element element2;
        Tokeniser tokeniser;
        TokeniserState tokeniserState;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(str, str2, parseErrorList);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String tagName = element.tagName();
            if (StringUtil.in(tagName, "title", "textarea")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Rcdata;
            } else if (StringUtil.in(tagName, "iframe", "noembed", "noframes", "style", "xmp")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Rawtext;
            } else if (tagName.equals("script")) {
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.ScriptData;
            } else {
                if (!tagName.equals("noscript")) {
                    tagName.equals("plaintext");
                }
                tokeniser = this.tokeniser;
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
            element2 = new Element(Tag.valueOf("html"), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator it = parents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element element3 = (Element) it.next();
                if (element3 instanceof FormElement) {
                    this.formElement = (FormElement) element3;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        return (element == null || element2 == null) ? this.doc.childNodes() : element2.childNodes();
    }

    public Element pop() {
        return (Element) this.stack.remove(this.stack.size() - 1);
    }

    public void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !((Element) this.stack.get(size)).nodeName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    public void popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            this.stack.remove(size);
            if (element.nodeName().equals(str)) {
                return;
            }
        }
    }

    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public void push(Element element) {
        this.stack.add(element);
    }

    public void pushActiveFormattingElements(Element element) {
        int size = this.formattingElements.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = (Element) this.formattingElements.get(size);
                if (element2 == null) {
                    break;
                }
                if (isSameFormattingElement(element, element2)) {
                    i++;
                }
                if (i == 3) {
                    this.formattingElements.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.formattingElements.add(element);
    }

    public void reconstructFormattingElements() {
        Element lastFormattingElement = lastFormattingElement();
        if (lastFormattingElement == null || onStack(lastFormattingElement)) {
            return;
        }
        boolean z = true;
        int size = this.formattingElements.size() - 1;
        int i = size;
        while (i != 0) {
            i--;
            lastFormattingElement = (Element) this.formattingElements.get(i);
            if (lastFormattingElement == null || onStack(lastFormattingElement)) {
                z = false;
                break;
            }
        }
        while (true) {
            if (!z) {
                i++;
                lastFormattingElement = (Element) this.formattingElements.get(i);
            }
            Validate.notNull(lastFormattingElement);
            Element insertStartTag = insertStartTag(lastFormattingElement.nodeName());
            insertStartTag.attributes().addAll(lastFormattingElement.attributes());
            this.formattingElements.set(i, insertStartTag);
            if (i == size) {
                return;
            } else {
                z = false;
            }
        }
    }

    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (((Element) this.formattingElements.get(size)) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (((Element) this.stack.get(size)) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    public Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return (Element) this.formattingElements.remove(size - 1);
        }
        return null;
    }

    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    public void resetInsertionMode() {
        HtmlTreeBuilderState htmlTreeBuilderState;
        boolean z = false;
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            if (size == 0) {
                element = this.contextElement;
                z = true;
            }
            String nodeName = element.nodeName();
            if ("select".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InSelect;
            } else if ("td".equals(nodeName) || ("th".equals(nodeName) && !z)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCell;
            } else if ("tr".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
            } else if ("tbody".equals(nodeName) || "thead".equals(nodeName) || "tfoot".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
            } else if ("caption".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
            } else if ("colgroup".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
            } else if ("table".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
            } else if ("head".equals(nodeName) || "body".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            } else if ("frameset".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
            } else if ("html".equals(nodeName)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.BeforeHead;
            } else if (z) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            }
            transition(htmlTreeBuilderState);
            return;
        }
    }

    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    public void setPendingTableCharacters(List list) {
        this.pendingTableCharacters = list;
    }

    public HtmlTreeBuilderState state() {
        return this.state;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }

    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String nodeName = ((Element) this.stack.get(size)).nodeName();
            if (StringUtil.in(nodeName, strArr)) {
                return true;
            }
            if (StringUtil.in(nodeName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.in(nodeName, strArr3)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean framesetOk() {
        return this.framesetOk;
    }

    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().nodeName().equals(str) && StringUtil.in(currentElement().nodeName(), TagSearchEndTags)) {
            pop();
        }
    }

    public boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    public void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    public void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            this.stack.remove(size);
            if (StringUtil.in(element.nodeName(), strArr)) {
                return;
            }
        }
    }

    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    public void insert(Token.Character character) {
        String tagName = currentElement().tagName();
        currentElement().appendChild((tagName.equals("script") || tagName.equals("style")) ? new DataNode(character.getData(), this.baseUri) : new TextNode(character.getData(), this.baseUri));
    }

    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData(), this.baseUri));
    }
}
