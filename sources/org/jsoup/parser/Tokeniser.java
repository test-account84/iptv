package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    static final char replacementChar = 65533;
    private Token emitPending;
    private ParseErrorList errors;
    private String lastStartTag;
    private CharacterReader reader;
    Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.StartTag startPending = new Token.StartTag();
    Token.EndTag endPending = new Token.EndTag();
    Token.Character charPending = new Token.Character();
    Token.Doctype doctypePending = new Token.Doctype();
    Token.Comment commentPending = new Token.Comment();
    private boolean selfClosingFlagAcknowledged = true;
    private final char[] charRefHolder = new char[1];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    private void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void acknowledgeSelfClosingFlag() {
        this.selfClosingFlagAcknowledged = true;
    }

    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    public String appropriateEndTagName() {
        String str = this.lastStartTag;
        if (str == null) {
            return null;
        }
        return str;
    }

    public char[] consumeCharacterReference(Character ch, boolean z) {
        int i;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        char[] cArr = this.charRefHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (consumeHexSequence.length() != 0) {
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                try {
                    i = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i = -1;
                }
                if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                    characterReferenceError("character outside of valid range");
                    cArr[0] = 65533;
                    return cArr;
                }
                if (i >= 65536) {
                    return Character.toChars(i);
                }
                cArr[0] = (char) i;
                return cArr;
            }
            characterReferenceError("numeric reference with no numerals");
        } else {
            String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean matches = this.reader.matches(';');
            if (!Entities.isBaseNamedEntity(consumeLetterThenDigitSequence) && (!Entities.isNamedEntity(consumeLetterThenDigitSequence) || !matches)) {
                this.reader.rewindToMark();
                if (matches) {
                    characterReferenceError(String.format("invalid named referenece '%s'", new Object[]{consumeLetterThenDigitSequence}));
                }
                return null;
            }
            if (!z || (!this.reader.matchesLetter() && !this.reader.matchesDigit() && !this.reader.matchesAny('=', '-', '_'))) {
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                cArr[0] = Entities.getCharacterByName(consumeLetterThenDigitSequence).charValue();
                return cArr;
            }
        }
        this.reader.rewindToMark();
        return null;
    }

    public void createCommentPending() {
        this.commentPending.reset();
    }

    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    public Token.Tag createTagPending(boolean z) {
        Token.Tag reset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = reset;
        return reset;
    }

    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    public boolean currentNodeInHtmlNS() {
        return true;
    }

    public void emit(char c) {
        emit(String.valueOf(c));
    }

    public void emitCommentPending() {
        emit(this.commentPending);
    }

    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public TokeniserState getState() {
        return this.state;
    }

    public boolean isAppropriateEndTagToken() {
        String str = this.lastStartTag;
        return str != null && this.tagPending.tagName.equals(str);
    }

    public Token read() {
        if (!this.selfClosingFlagAcknowledged) {
            error("Self closing flag not acknowledged");
            this.selfClosingFlagAcknowledged = true;
        }
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        if (this.charsBuilder.length() > 0) {
            String sb = this.charsBuilder.toString();
            StringBuilder sb2 = this.charsBuilder;
            sb2.delete(0, sb2.length());
            this.charsString = null;
            return this.charPending.data(sb);
        }
        String str = this.charsString;
        if (str == null) {
            this.isEmitPending = false;
            return this.emitPending;
        }
        Token.Character data = this.charPending.data(str);
        this.charsString = null;
        return data;
    }

    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    public String unescapeEntities(boolean z) {
        StringBuilder sb = new StringBuilder();
        while (!this.reader.isEmpty()) {
            sb.append(this.reader.consumeTo('&'));
            if (this.reader.matches('&')) {
                this.reader.consume();
                char[] consumeCharacterReference = consumeCharacterReference(null, z);
                if (consumeCharacterReference == null || consumeCharacterReference.length == 0) {
                    sb.append('&');
                } else {
                    sb.append(consumeCharacterReference);
                }
            }
        }
        return sb.toString();
    }

    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType != Token.TokenType.StartTag) {
            if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
                return;
            }
            error("Attributes incorrectly present on end tag");
            return;
        }
        Token.StartTag startTag = (Token.StartTag) token;
        this.lastStartTag = startTag.tagName;
        if (startTag.selfClosing) {
            this.selfClosingFlagAcknowledged = false;
        }
    }

    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }
}
