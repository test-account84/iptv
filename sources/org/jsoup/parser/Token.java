package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class Token {
    TokenType type;

    public static final class Character extends Token {
        private String data;

        public Character() {
            super(null);
            this.type = TokenType.Character;
        }

        public Character data(String str) {
            this.data = str;
            return this;
        }

        public String getData() {
            return this.data;
        }

        public Token reset() {
            this.data = null;
            return this;
        }

        public String toString() {
            return getData();
        }
    }

    public static final class Comment extends Token {
        boolean bogus;
        final StringBuilder data;

        public Comment() {
            super(null);
            this.data = new StringBuilder();
            this.bogus = false;
            this.type = TokenType.Comment;
        }

        public String getData() {
            return this.data.toString();
        }

        public Token reset() {
            Token.reset(this.data);
            this.bogus = false;
            return this;
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    public static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        public Doctype() {
            super(null);
            this.name = new StringBuilder();
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
            this.type = TokenType.Doctype;
        }

        public String getName() {
            return this.name.toString();
        }

        public String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }

        public Token reset() {
            Token.reset(this.name);
            Token.reset(this.publicIdentifier);
            Token.reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }
    }

    public static final class EOF extends Token {
        public EOF() {
            super(null);
            this.type = TokenType.EOF;
        }

        public Token reset() {
            return this;
        }
    }

    public static final class EndTag extends Tag {
        public EndTag() {
            this.type = TokenType.EndTag;
        }

        public String toString() {
            return "</" + name() + ">";
        }
    }

    public static final class StartTag extends Tag {
        public StartTag() {
            this.attributes = new Attributes();
            this.type = TokenType.StartTag;
        }

        public StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            return this;
        }

        public Tag reset() {
            super.reset();
            this.attributes = new Attributes();
            return this;
        }

        public String toString() {
            StringBuilder sb;
            String name;
            Attributes attributes = this.attributes;
            if (attributes == null || attributes.size() <= 0) {
                sb = new StringBuilder();
                sb.append("<");
                name = name();
            } else {
                sb = new StringBuilder();
                sb.append("<");
                sb.append(name());
                sb.append(" ");
                name = this.attributes.toString();
            }
            sb.append(name);
            sb.append(">");
            return sb.toString();
        }
    }

    public static abstract class Tag extends Token {
        Attributes attributes;
        private boolean hasEmptyAttributeValue;
        private boolean hasPendingAttributeValue;
        private String pendingAttributeName;
        private StringBuilder pendingAttributeValue;
        boolean selfClosing;
        protected String tagName;

        public Tag() {
            super(null);
            this.pendingAttributeValue = new StringBuilder();
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
        }

        private void ensureAttributeValue() {
            this.hasPendingAttributeValue = true;
        }

        public final void appendAttributeName(char c) {
            appendAttributeName(String.valueOf(c));
        }

        public final void appendAttributeValue(char c) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(c);
        }

        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        public final void finaliseTag() {
            if (this.pendingAttributeName != null) {
                newAttribute();
            }
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final boolean isSelfClosing() {
            return this.selfClosing;
        }

        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        public final void newAttribute() {
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            if (this.pendingAttributeName != null) {
                this.attributes.put(this.hasPendingAttributeValue ? new Attribute(this.pendingAttributeName, this.pendingAttributeValue.toString()) : this.hasEmptyAttributeValue ? new Attribute(this.pendingAttributeName, "") : new BooleanAttribute(this.pendingAttributeName));
            }
            this.pendingAttributeName = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            Token.reset(this.pendingAttributeValue);
        }

        public Tag reset() {
            this.tagName = null;
            this.pendingAttributeName = null;
            Token.reset(this.pendingAttributeValue);
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        public final void setEmptyAttributeValue() {
            this.hasEmptyAttributeValue = true;
        }

        public final void appendAttributeName(String str) {
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.pendingAttributeName = str;
        }

        public final void appendAttributeValue(String str) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(str);
        }

        public final void appendTagName(String str) {
            String str2 = this.tagName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.tagName = str;
        }

        public final Tag name(String str) {
            this.tagName = str;
            return this;
        }

        public final void appendAttributeValue(char[] cArr) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(cArr);
        }
    }

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    private Token() {
    }

    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final Character asCharacter() {
        return (Character) this;
    }

    public final Comment asComment() {
        return (Comment) this;
    }

    public final Doctype asDoctype() {
        return (Doctype) this;
    }

    public final EndTag asEndTag() {
        return (EndTag) this;
    }

    public final StartTag asStartTag() {
        return (StartTag) this;
    }

    public final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    public final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    public final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    public final boolean isEOF() {
        return this.type == TokenType.EOF;
    }

    public final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    public final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    public abstract Token reset();

    public String tokenType() {
        return getClass().getSimpleName();
    }

    public /* synthetic */ Token(1 r1) {
        this();
    }
}
