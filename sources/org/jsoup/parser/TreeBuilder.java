package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class TreeBuilder {
    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    protected ParseErrorList errors;
    CharacterReader reader;
    protected ArrayList stack;
    Tokeniser tokeniser;
    private Token.StartTag start = new Token.StartTag();
    private Token.EndTag end = new Token.EndTag();

    public Element currentElement() {
        int size = this.stack.size();
        if (size > 0) {
            return (Element) this.stack.get(size - 1);
        }
        return null;
    }

    public void initialiseParse(String str, String str2, ParseErrorList parseErrorList) {
        Validate.notNull(str, "String input must not be null");
        Validate.notNull(str2, "BaseURI must not be null");
        this.doc = new Document(str2);
        this.reader = new CharacterReader(str);
        this.errors = parseErrorList;
        this.tokeniser = new Tokeniser(this.reader, parseErrorList);
        this.stack = new ArrayList(32);
        this.baseUri = str2;
    }

    public Document parse(String str, String str2) {
        return parse(str, str2, ParseErrorList.noTracking());
    }

    public abstract boolean process(Token token);

    public boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.EndTag endTag = this.end;
        return process((token == endTag ? new Token.EndTag() : endTag.reset()).name(str));
    }

    public boolean processStartTag(String str) {
        Token token = this.currentToken;
        Token.StartTag startTag = this.start;
        return process((token == startTag ? new Token.StartTag() : startTag.reset()).name(str));
    }

    public void runParser() {
        Token read;
        do {
            read = this.tokeniser.read();
            process(read);
            read.reset();
        } while (read.type != Token.TokenType.EOF);
    }

    public Document parse(String str, String str2, ParseErrorList parseErrorList) {
        initialiseParse(str, str2, parseErrorList);
        runParser();
        return this.doc;
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token.StartTag startTag;
        Token token = this.currentToken;
        Token.StartTag startTag2 = this.start;
        if (token == startTag2) {
            startTag = new Token.StartTag().nameAttr(str, attributes);
        } else {
            startTag2.reset();
            this.start.nameAttr(str, attributes);
            startTag = this.start;
        }
        return process(startTag);
    }
}
