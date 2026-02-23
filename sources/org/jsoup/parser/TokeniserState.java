package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.parser.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class TokeniserState {
    private static final /* synthetic */ TokeniserState[] $VALUES;
    public static final TokeniserState AfterAttributeName;
    public static final TokeniserState AfterAttributeValue_quoted;
    public static final TokeniserState AfterDoctypeName;
    public static final TokeniserState AfterDoctypePublicIdentifier;
    public static final TokeniserState AfterDoctypePublicKeyword;
    public static final TokeniserState AfterDoctypeSystemIdentifier;
    public static final TokeniserState AfterDoctypeSystemKeyword;
    public static final TokeniserState AttributeName;
    public static final TokeniserState AttributeValue_doubleQuoted;
    public static final TokeniserState AttributeValue_singleQuoted;
    public static final TokeniserState AttributeValue_unquoted;
    public static final TokeniserState BeforeAttributeName;
    public static final TokeniserState BeforeAttributeValue;
    public static final TokeniserState BeforeDoctypeName;
    public static final TokeniserState BeforeDoctypePublicIdentifier;
    public static final TokeniserState BeforeDoctypeSystemIdentifier;
    public static final TokeniserState BetweenDoctypePublicAndSystemIdentifiers;
    public static final TokeniserState BogusComment;
    public static final TokeniserState BogusDoctype;
    public static final TokeniserState CdataSection;
    public static final TokeniserState CharacterReferenceInData;
    public static final TokeniserState CharacterReferenceInRcdata;
    public static final TokeniserState Comment;
    public static final TokeniserState CommentEnd;
    public static final TokeniserState CommentEndBang;
    public static final TokeniserState CommentEndDash;
    public static final TokeniserState CommentStart;
    public static final TokeniserState CommentStartDash;
    public static final TokeniserState Data;
    public static final TokeniserState Doctype;
    public static final TokeniserState DoctypeName;
    public static final TokeniserState DoctypePublicIdentifier_doubleQuoted;
    public static final TokeniserState DoctypePublicIdentifier_singleQuoted;
    public static final TokeniserState DoctypeSystemIdentifier_doubleQuoted;
    public static final TokeniserState DoctypeSystemIdentifier_singleQuoted;
    public static final TokeniserState EndTagOpen;
    public static final TokeniserState MarkupDeclarationOpen;
    public static final TokeniserState PLAINTEXT;
    public static final TokeniserState RCDATAEndTagName;
    public static final TokeniserState RCDATAEndTagOpen;
    public static final TokeniserState Rawtext;
    public static final TokeniserState RawtextEndTagName;
    public static final TokeniserState RawtextEndTagOpen;
    public static final TokeniserState RawtextLessthanSign;
    public static final TokeniserState Rcdata;
    public static final TokeniserState RcdataLessthanSign;
    public static final TokeniserState ScriptData;
    public static final TokeniserState ScriptDataDoubleEscapeEnd;
    public static final TokeniserState ScriptDataDoubleEscapeStart;
    public static final TokeniserState ScriptDataDoubleEscaped;
    public static final TokeniserState ScriptDataDoubleEscapedDash;
    public static final TokeniserState ScriptDataDoubleEscapedDashDash;
    public static final TokeniserState ScriptDataDoubleEscapedLessthanSign;
    public static final TokeniserState ScriptDataEndTagName;
    public static final TokeniserState ScriptDataEndTagOpen;
    public static final TokeniserState ScriptDataEscapeStart;
    public static final TokeniserState ScriptDataEscapeStartDash;
    public static final TokeniserState ScriptDataEscaped;
    public static final TokeniserState ScriptDataEscapedDash;
    public static final TokeniserState ScriptDataEscapedDashDash;
    public static final TokeniserState ScriptDataEscapedEndTagName;
    public static final TokeniserState ScriptDataEscapedEndTagOpen;
    public static final TokeniserState ScriptDataEscapedLessthanSign;
    public static final TokeniserState ScriptDataLessthanSign;
    public static final TokeniserState SelfClosingStartTag;
    public static final TokeniserState TagName;
    public static final TokeniserState TagOpen;
    private static final char[] attributeDoubleValueCharsSorted;
    private static final char[] attributeNameCharsSorted;
    private static final char[] attributeSingleValueCharsSorted;
    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr;

    public enum 1 extends TokeniserState {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
                return;
            }
            if (current == '&') {
                tokeniserState = TokeniserState.CharacterReferenceInData;
            } else {
                if (current != '<') {
                    if (current != 65535) {
                        tokeniser.emit(characterReader.consumeData());
                        return;
                    } else {
                        tokeniser.emit(new Token.EOF());
                        return;
                    }
                }
                tokeniserState = TokeniserState.TagOpen;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 10 extends TokeniserState {
        public 10(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName().toLowerCase());
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.access$100());
                return;
            }
            if (consume == ' ') {
                tokeniserState = TokeniserState.BeforeAttributeName;
            } else if (consume != '/') {
                if (consume == '>') {
                    tokeniser.emitTagPending();
                } else if (consume != 65535) {
                    if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                        return;
                    }
                    tokeniserState = TokeniserState.BeforeAttributeName;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.SelfClosingStartTag;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 11 extends TokeniserState {
        public 11(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void read(org.jsoup.parser.Tokeniser r3, org.jsoup.parser.CharacterReader r4) {
            /*
                r2 = this;
                r0 = 47
                boolean r0 = r4.matches(r0)
                if (r0 == 0) goto L11
                r3.createTempBuffer()
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.RCDATAEndTagOpen
                r3.advanceTransition(r4)
                goto L5b
            L11:
                boolean r0 = r4.matchesLetter()
                if (r0 == 0) goto L53
                java.lang.String r0 = r3.appropriateEndTagName()
                if (r0 == 0) goto L53
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "</"
                r0.append(r1)
                java.lang.String r1 = r3.appropriateEndTagName()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                boolean r0 = r4.containsIgnoreCase(r0)
                if (r0 != 0) goto L53
                r0 = 0
                org.jsoup.parser.Token$Tag r0 = r3.createTagPending(r0)
                java.lang.String r1 = r3.appropriateEndTagName()
                org.jsoup.parser.Token$Tag r0 = r0.name(r1)
                r3.tagPending = r0
                r3.emitTagPending()
                r4.unconsume()
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.Data
            L4f:
                r3.transition(r4)
                goto L5b
            L53:
                java.lang.String r4 = "<"
                r3.emit(r4)
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.Rcdata
                goto L4f
            L5b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokeniserState.11.read(org.jsoup.parser.Tokeniser, org.jsoup.parser.CharacterReader):void");
        }
    }

    public enum 12 extends TokeniserState {
        public 12(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.Rcdata);
            } else {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(Character.toLowerCase(characterReader.current()));
                tokeniser.dataBuffer.append(Character.toLowerCase(characterReader.current()));
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagName);
            }
        }
    }

    public enum 13 extends TokeniserState {
        public 13(String str, int i) {
            super(str, i, null);
        }

        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            characterReader.unconsume();
            tokeniser.transition(TokeniserState.Rcdata);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence.toLowerCase());
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniserState = TokeniserState.BeforeAttributeName;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                anythingElse(tokeniser, characterReader);
            }
            if (consume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniserState = TokeniserState.SelfClosingStartTag;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                anythingElse(tokeniser, characterReader);
            }
            if (consume == '>' && tokeniser.isAppropriateEndTagToken()) {
                tokeniser.emitTagPending();
                tokeniserState = TokeniserState.Data;
                tokeniser.transition(tokeniserState);
                return;
            }
            anythingElse(tokeniser, characterReader);
        }
    }

    public enum 14 extends TokeniserState {
        public 14(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RawtextEndTagOpen);
            } else {
                tokeniser.emit('<');
                tokeniser.transition(TokeniserState.Rawtext);
            }
        }
    }

    public enum 15 extends TokeniserState {
        public 15(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniserState = TokeniserState.RawtextEndTagName;
            } else {
                tokeniser.emit("</");
                tokeniserState = TokeniserState.Rawtext;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 16 extends TokeniserState {
        public 16(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.access$200(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    }

    public enum 17 extends TokeniserState {
        public 17(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '!') {
                tokeniser.emit("<!");
                tokeniserState = TokeniserState.ScriptDataEscapeStart;
            } else if (consume != '/') {
                tokeniser.emit("<");
                characterReader.unconsume();
                tokeniserState = TokeniserState.ScriptData;
            } else {
                tokeniser.createTempBuffer();
                tokeniserState = TokeniserState.ScriptDataEndTagOpen;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 18 extends TokeniserState {
        public 18(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniserState = TokeniserState.ScriptDataEndTagName;
            } else {
                tokeniser.emit("</");
                tokeniserState = TokeniserState.ScriptData;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 19 extends TokeniserState {
        public 19(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.access$200(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    }

    public enum 2 extends TokeniserState {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
            if (consumeCharacterReference == null) {
                tokeniser.emit('&');
            } else {
                tokeniser.emit(consumeCharacterReference);
            }
            tokeniser.transition(TokeniserState.Data);
        }
    }

    public enum 20 extends TokeniserState {
        public 20(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
            } else {
                tokeniser.emit('-');
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapeStartDash);
            }
        }
    }

    public enum 21 extends TokeniserState {
        public 21(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
            } else {
                tokeniser.emit('-');
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDashDash);
            }
        }
    }

    public enum 22 extends TokeniserState {
        public 22(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '-') {
                tokeniser.emit('-');
                tokeniserState = TokeniserState.ScriptDataEscapedDash;
            } else {
                if (current != '<') {
                    tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
                    return;
                }
                tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 23 extends TokeniserState {
        public 23(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataEscapedDashDash;
                } else if (consume == '<') {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 24 extends TokeniserState {
        public 24(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume != '<') {
                    tokeniser.emit(consume);
                    if (consume == '>') {
                        tokeniserState = TokeniserState.ScriptData;
                    }
                } else {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.emit((char) 65533);
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 25 extends TokeniserState {
        public 25(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(Character.toLowerCase(characterReader.current()));
                tokeniser.emit("<" + characterReader.current());
                tokeniserState = TokeniserState.ScriptDataDoubleEscapeStart;
            } else if (!characterReader.matches('/')) {
                tokeniser.emit('<');
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
                return;
            } else {
                tokeniser.createTempBuffer();
                tokeniserState = TokeniserState.ScriptDataEscapedEndTagOpen;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 26 extends TokeniserState {
        public 26(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(Character.toLowerCase(characterReader.current()));
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagName);
            }
        }
    }

    public enum 27 extends TokeniserState {
        public 27(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.access$200(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    }

    public enum 28 extends TokeniserState {
        public 28(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.access$300(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    }

    public enum 29 extends TokeniserState {
        public 29(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '-') {
                tokeniser.emit(current);
                tokeniserState = TokeniserState.ScriptDataDoubleEscapedDash;
            } else {
                if (current != '<') {
                    if (current != 65535) {
                        tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
                        return;
                    } else {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                }
                tokeniser.emit(current);
                tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 3 extends TokeniserState {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '&') {
                tokeniserState = TokeniserState.CharacterReferenceInRcdata;
            } else {
                if (current != '<') {
                    if (current != 65535) {
                        tokeniser.emit(characterReader.consumeToAny('&', '<', 0));
                        return;
                    } else {
                        tokeniser.emit(new Token.EOF());
                        return;
                    }
                }
                tokeniserState = TokeniserState.RcdataLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 30 extends TokeniserState {
        public 30(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedDashDash;
                } else if (consume == '<') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 31 extends TokeniserState {
        public 31(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume == '<') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (consume == '>') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptData;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 32 extends TokeniserState {
        public 32(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('/')) {
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            tokeniser.emit('/');
            tokeniser.createTempBuffer();
            tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    }

    public enum 33 extends TokeniserState {
        public 33(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.access$300(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    }

    public enum 34 extends TokeniserState {
        public 34(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:21:0x002b. Please report as an issue. */
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '\'') {
                        if (consume != '/') {
                            if (consume == 65535) {
                                tokeniser.eofError(this);
                            } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                                switch (consume) {
                                    case '>':
                                        tokeniser.emitTagPending();
                                        break;
                                }
                            } else {
                                return;
                            }
                            tokeniserState = TokeniserState.Data;
                        } else {
                            tokeniserState = TokeniserState.SelfClosingStartTag;
                        }
                        tokeniser.transition(tokeniserState);
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    tokeniser.tagPending.appendAttributeName(consume);
                    tokeniserState = TokeniserState.AttributeName;
                    tokeniser.transition(tokeniserState);
                }
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.newAttribute();
            characterReader.unconsume();
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 35 extends TokeniserState {
        public 35(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void read(org.jsoup.parser.Tokeniser r3, org.jsoup.parser.CharacterReader r4) {
            /*
                r2 = this;
                char[] r0 = org.jsoup.parser.TokeniserState.access$400()
                java.lang.String r0 = r4.consumeToAnySorted(r0)
                org.jsoup.parser.Token$Tag r1 = r3.tagPending
                java.lang.String r0 = r0.toLowerCase()
                r1.appendAttributeName(r0)
                char r4 = r4.consume()
                if (r4 == 0) goto L5f
                r0 = 32
                if (r4 == r0) goto L5c
                r0 = 34
                if (r4 == r0) goto L53
                r0 = 39
                if (r4 == r0) goto L53
                r0 = 47
                if (r4 == r0) goto L50
                r0 = 65535(0xffff, float:9.1834E-41)
                if (r4 == r0) goto L4c
                r0 = 9
                if (r4 == r0) goto L5c
                r0 = 10
                if (r4 == r0) goto L5c
                r0 = 12
                if (r4 == r0) goto L5c
                r0 = 13
                if (r4 == r0) goto L5c
                switch(r4) {
                    case 60: goto L53;
                    case 61: goto L49;
                    case 62: goto L40;
                    default: goto L3f;
                }
            L3f:
                goto L68
            L40:
                r3.emitTagPending()
            L43:
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.Data
            L45:
                r3.transition(r4)
                goto L68
            L49:
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.BeforeAttributeValue
                goto L45
            L4c:
                r3.eofError(r2)
                goto L43
            L50:
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.SelfClosingStartTag
                goto L45
            L53:
                r3.error(r2)
                org.jsoup.parser.Token$Tag r3 = r3.tagPending
            L58:
                r3.appendAttributeName(r4)
                goto L68
            L5c:
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.AfterAttributeName
                goto L45
            L5f:
                r3.error(r2)
                org.jsoup.parser.Token$Tag r3 = r3.tagPending
                r4 = 65533(0xfffd, float:9.1831E-41)
                goto L58
            L68:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokeniserState.35.read(org.jsoup.parser.Tokeniser, org.jsoup.parser.CharacterReader):void");
        }
    }

    public enum 36 extends TokeniserState {
        public 36(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tag = tokeniser.tagPending;
                consume = 65533;
            } else {
                if (consume == ' ') {
                    return;
                }
                if (consume != '\"' && consume != '\'') {
                    if (consume != '/') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            switch (consume) {
                                case '<':
                                    break;
                                case '=':
                                    tokeniserState = TokeniserState.BeforeAttributeValue;
                                    break;
                                case '>':
                                    tokeniser.emitTagPending();
                                    break;
                                default:
                                    tokeniser.tagPending.newAttribute();
                                    characterReader.unconsume();
                                    tokeniserState = TokeniserState.AttributeName;
                                    break;
                            }
                        } else {
                            return;
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.transition(tokeniserState);
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tag = tokeniser.tagPending;
            }
            tag.appendAttributeName(consume);
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 37 extends TokeniserState {
        public 37(String str, int i) {
            super(str, i, null);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:23:0x002f. Please report as an issue. */
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"') {
                        if (consume != '`') {
                            if (consume == 65535) {
                                tokeniser.eofError(this);
                            } else {
                                if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                                    return;
                                }
                                if (consume != '&') {
                                    if (consume != '\'') {
                                        switch (consume) {
                                            case '>':
                                                tokeniser.error(this);
                                                break;
                                        }
                                    } else {
                                        tokeniserState = TokeniserState.AttributeValue_singleQuoted;
                                    }
                                }
                                characterReader.unconsume();
                                tokeniserState = TokeniserState.AttributeValue_unquoted;
                            }
                            tokeniser.emitTagPending();
                            tokeniserState = TokeniserState.Data;
                        }
                        tokeniser.error(this);
                        tag = tokeniser.tagPending;
                    } else {
                        tokeniserState = TokeniserState.AttributeValue_doubleQuoted;
                    }
                    tokeniser.transition(tokeniserState);
                }
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
            tokeniserState = TokeniserState.AttributeValue_unquoted;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 38 extends TokeniserState {
        public 38(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.access$500());
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533);
                return;
            }
            if (consume == '\"') {
                tokeniserState = TokeniserState.AfterAttributeValue_quoted;
            } else {
                if (consume == '&') {
                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
                    Token.Tag tag = tokeniser.tagPending;
                    if (consumeCharacterReference != null) {
                        tag.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tag.appendAttributeValue('&');
                        return;
                    }
                }
                if (consume != 65535) {
                    return;
                }
                tokeniser.eofError(this);
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 39 extends TokeniserState {
        public 39(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.access$600());
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniserState = TokeniserState.Data;
            } else {
                if (consume == '&') {
                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
                    Token.Tag tag = tokeniser.tagPending;
                    if (consumeCharacterReference != null) {
                        tag.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tag.appendAttributeValue('&');
                        return;
                    }
                }
                if (consume != '\'') {
                    return;
                } else {
                    tokeniserState = TokeniserState.AfterAttributeValue_quoted;
                }
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 4 extends TokeniserState {
        public 4(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
            if (consumeCharacterReference == null) {
                tokeniser.emit('&');
            } else {
                tokeniser.emit(consumeCharacterReference);
            }
            tokeniser.transition(TokeniserState.Rcdata);
        }
    }

    public enum 40 extends TokeniserState {
        public 40(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            String consumeToAny = characterReader.consumeToAny('\t', '\n', '\r', '\f', ' ', '&', '>', 0, '\"', '\'', '<', '=', '`');
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == ' ') {
                    tokeniserState = TokeniserState.BeforeAttributeName;
                } else {
                    if (consume != '\"' && consume != '`') {
                        if (consume != 65535) {
                            if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                                if (consume == '&') {
                                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('>', true);
                                    Token.Tag tag2 = tokeniser.tagPending;
                                    if (consumeCharacterReference != null) {
                                        tag2.appendAttributeValue(consumeCharacterReference);
                                        return;
                                    } else {
                                        tag2.appendAttributeValue('&');
                                        return;
                                    }
                                }
                                if (consume != '\'') {
                                    switch (consume) {
                                        case '>':
                                            tokeniser.emitTagPending();
                                            break;
                                    }
                                    return;
                                }
                            }
                            tokeniserState = TokeniserState.BeforeAttributeName;
                        } else {
                            tokeniser.eofError(this);
                        }
                        tokeniserState = TokeniserState.Data;
                    }
                    tokeniser.error(this);
                    tag = tokeniser.tagPending;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
        }
    }

    public enum 41 extends TokeniserState {
        public 41(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeAttributeName;
            } else if (consume != '/') {
                if (consume == '>') {
                    tokeniser.emitTagPending();
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    characterReader.unconsume();
                    tokeniserState = TokeniserState.BeforeAttributeName;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.SelfClosingStartTag;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 42 extends TokeniserState {
        public 42(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
            } else {
                if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniserState = TokeniserState.BeforeAttributeName;
                    tokeniser.transition(tokeniserState);
                }
                tokeniser.eofError(this);
            }
            tokeniserState = TokeniserState.Data;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 43 extends TokeniserState {
        public 43(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            Token.Comment comment = new Token.Comment();
            comment.bogus = true;
            comment.data.append(characterReader.consumeTo('>'));
            tokeniser.emit(comment);
            tokeniser.advanceTransition(TokeniserState.Data);
        }
    }

    public enum 44 extends TokeniserState {
        public 44(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniserState = TokeniserState.CommentStart;
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniserState = TokeniserState.Doctype;
            } else {
                if (!characterReader.matchConsume("[CDATA[")) {
                    tokeniser.error(this);
                    tokeniser.advanceTransition(TokeniserState.BogusComment);
                    return;
                }
                tokeniserState = TokeniserState.CdataSection;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 45 extends TokeniserState {
        public 45(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        tokeniser.commentPending.data.append(consume);
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.data.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 46 extends TokeniserState {
        public 46(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        tokeniser.commentPending.data.append(consume);
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.data.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 47 extends TokeniserState {
        public 47(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.data.append((char) 65533);
            } else if (current == '-') {
                tokeniser.advanceTransition(TokeniserState.CommentEndDash);
            } else {
                if (current != 65535) {
                    tokeniser.commentPending.data.append(characterReader.consumeToAny('-', 0));
                    return;
                }
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    }

    public enum 48 extends TokeniserState {
        public 48(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniserState = TokeniserState.CommentEnd;
                } else if (consume != 65535) {
                    StringBuilder sb = tokeniser.commentPending.data;
                    sb.append('-');
                    sb.append(consume);
                } else {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            StringBuilder sb2 = tokeniser.commentPending.data;
            sb2.append('-');
            sb2.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 49 extends TokeniserState {
        public 49(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '!') {
                    tokeniser.error(this);
                    tokeniserState = TokeniserState.CommentEndBang;
                } else {
                    if (consume == '-') {
                        tokeniser.error(this);
                        tokeniser.commentPending.data.append('-');
                        return;
                    }
                    if (consume != '>') {
                        if (consume != 65535) {
                            tokeniser.error(this);
                            StringBuilder sb = tokeniser.commentPending.data;
                            sb.append("--");
                            sb.append(consume);
                        } else {
                            tokeniser.eofError(this);
                        }
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            StringBuilder sb2 = tokeniser.commentPending.data;
            sb2.append("--");
            sb2.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 5 extends TokeniserState {
        public 5(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current == '<') {
                tokeniser.advanceTransition(TokeniserState.RawtextLessthanSign);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeToAny('<', 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    }

    public enum 50 extends TokeniserState {
        public 50(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume != '>') {
                        if (consume != 65535) {
                            StringBuilder sb = tokeniser.commentPending.data;
                            sb.append("--!");
                            sb.append(consume);
                        } else {
                            tokeniser.eofError(this);
                        }
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.commentPending.data.append("--!");
                    tokeniserState = TokeniserState.CommentEndDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            StringBuilder sb2 = tokeniser.commentPending.data;
            sb2.append("--!");
            sb2.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 51 extends TokeniserState {
        public 51(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypeName;
            } else {
                if (consume != '>') {
                    if (consume != 65535) {
                        tokeniser.error(this);
                        tokeniserState = TokeniserState.BeforeDoctypeName;
                    } else {
                        tokeniser.eofError(this);
                    }
                }
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 52 extends TokeniserState {
        public 52(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(TokeniserState.DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append((char) 65533);
            } else {
                if (consume == ' ') {
                    return;
                }
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.transition(tokeniserState);
                }
                if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                    return;
                }
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(consume);
            }
            tokeniserState = TokeniserState.DoctypeName;
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 53 extends TokeniserState {
        public 53(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence().toLowerCase());
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == ' ') {
                    tokeniserState = TokeniserState.AfterDoctypeName;
                } else {
                    if (consume != '>') {
                        if (consume != 65535) {
                            if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                                sb = tokeniser.doctypePending.name;
                            }
                            tokeniserState = TokeniserState.AfterDoctypeName;
                        } else {
                            tokeniser.eofError(this);
                            tokeniser.doctypePending.forceQuirks = true;
                        }
                    }
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.name;
            consume = 65533;
            sb.append(consume);
        }
    }

    public enum 54 extends TokeniserState {
        public 54(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (characterReader.matchesAny('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
                return;
            }
            if (!characterReader.matches('>')) {
                if (characterReader.matchConsumeIgnoreCase("PUBLIC")) {
                    tokeniserState2 = TokeniserState.AfterDoctypePublicKeyword;
                } else if (characterReader.matchConsumeIgnoreCase("SYSTEM")) {
                    tokeniserState2 = TokeniserState.AfterDoctypeSystemKeyword;
                } else {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                }
                tokeniser.transition(tokeniserState2);
                return;
            }
            tokeniser.emitDoctypePending();
            tokeniserState = TokeniserState.Data;
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 55 extends TokeniserState {
        public 55(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypePublicIdentifier;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 56 extends TokeniserState {
        public 56(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 57 extends TokeniserState {
        public 57(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\"') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.publicIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.publicIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    }

    public enum 58 extends TokeniserState {
        public 58(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\'') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.publicIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.publicIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    }

    public enum 59 extends TokeniserState {
        public 59(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BetweenDoctypePublicAndSystemIdentifiers;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            } else if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniserState = TokeniserState.BogusDoctype;
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 6 extends TokeniserState {
        public 6(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current == '<') {
                tokeniser.advanceTransition(TokeniserState.ScriptDataLessthanSign);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeToAny('<', 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    }

    public enum 60 extends TokeniserState {
        public 60(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            } else if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniserState = TokeniserState.BogusDoctype;
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 61 extends TokeniserState {
        public 61(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypeSystemIdentifier;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else {
                    if (consume != 65535) {
                        tokeniser.error(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniser.emitDoctypePending();
                        return;
                    }
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 62 extends TokeniserState {
        public 62(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 63 extends TokeniserState {
        public 63(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\"') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.systemIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.systemIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    }

    public enum 64 extends TokeniserState {
        public 64(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\'') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.systemIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.systemIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    }

    public enum 65 extends TokeniserState {
        public 65(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniserState = TokeniserState.BogusDoctype;
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    public enum 66 extends TokeniserState {
        public 66(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>' || consume == 65535) {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    }

    public enum 67 extends TokeniserState {
        public 67(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit(characterReader.consumeTo("]]>"));
            characterReader.matchConsume("]]>");
            tokeniser.transition(TokeniserState.Data);
        }
    }

    public enum 7 extends TokeniserState {
        public 7(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeTo((char) 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    }

    public enum 8 extends TokeniserState {
        public 8(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            char current = characterReader.current();
            if (current == '!') {
                tokeniserState = TokeniserState.MarkupDeclarationOpen;
            } else if (current == '/') {
                tokeniserState = TokeniserState.EndTagOpen;
            } else {
                if (current != '?') {
                    if (characterReader.matchesLetter()) {
                        tokeniser.createTagPending(true);
                        tokeniserState2 = TokeniserState.TagName;
                    } else {
                        tokeniser.error(this);
                        tokeniser.emit('<');
                        tokeniserState2 = TokeniserState.Data;
                    }
                    tokeniser.transition(tokeniserState2);
                    return;
                }
                tokeniserState = TokeniserState.BogusComment;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    }

    public enum 9 extends TokeniserState {
        public 9(String str, int i) {
            super(str, i, null);
        }

        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniserState = TokeniserState.Data;
            } else {
                if (!characterReader.matchesLetter()) {
                    boolean matches = characterReader.matches('>');
                    tokeniser.error(this);
                    tokeniser.advanceTransition(matches ? TokeniserState.Data : TokeniserState.BogusComment);
                    return;
                }
                tokeniser.createTagPending(false);
                tokeniserState = TokeniserState.TagName;
            }
            tokeniser.transition(tokeniserState);
        }
    }

    static {
        1 r0 = new 1("Data", 0);
        Data = r0;
        2 r1 = new 2("CharacterReferenceInData", 1);
        CharacterReferenceInData = r1;
        3 r3 = new 3("Rcdata", 2);
        Rcdata = r3;
        4 r5 = new 4("CharacterReferenceInRcdata", 3);
        CharacterReferenceInRcdata = r5;
        5 r7 = new 5("Rawtext", 4);
        Rawtext = r7;
        6 r9 = new 6("ScriptData", 5);
        ScriptData = r9;
        7 r11 = new 7("PLAINTEXT", 6);
        PLAINTEXT = r11;
        8 r13 = new 8("TagOpen", 7);
        TagOpen = r13;
        9 r15 = new 9("EndTagOpen", 8);
        EndTagOpen = r15;
        10 r14 = new 10("TagName", 9);
        TagName = r14;
        11 r12 = new 11("RcdataLessthanSign", 10);
        RcdataLessthanSign = r12;
        12 r10 = new 12("RCDATAEndTagOpen", 11);
        RCDATAEndTagOpen = r10;
        13 r8 = new 13("RCDATAEndTagName", 12);
        RCDATAEndTagName = r8;
        14 r6 = new 14("RawtextLessthanSign", 13);
        RawtextLessthanSign = r6;
        15 r4 = new 15("RawtextEndTagOpen", 14);
        RawtextEndTagOpen = r4;
        16 r2 = new 16("RawtextEndTagName", 15);
        RawtextEndTagName = r2;
        17 r42 = new 17("ScriptDataLessthanSign", 16);
        ScriptDataLessthanSign = r42;
        18 r22 = new 18("ScriptDataEndTagOpen", 17);
        ScriptDataEndTagOpen = r22;
        19 r43 = new 19("ScriptDataEndTagName", 18);
        ScriptDataEndTagName = r43;
        20 r23 = new 20("ScriptDataEscapeStart", 19);
        ScriptDataEscapeStart = r23;
        21 r44 = new 21("ScriptDataEscapeStartDash", 20);
        ScriptDataEscapeStartDash = r44;
        22 r24 = new 22("ScriptDataEscaped", 21);
        ScriptDataEscaped = r24;
        23 r45 = new 23("ScriptDataEscapedDash", 22);
        ScriptDataEscapedDash = r45;
        24 r25 = new 24("ScriptDataEscapedDashDash", 23);
        ScriptDataEscapedDashDash = r25;
        25 r46 = new 25("ScriptDataEscapedLessthanSign", 24);
        ScriptDataEscapedLessthanSign = r46;
        26 r26 = new 26("ScriptDataEscapedEndTagOpen", 25);
        ScriptDataEscapedEndTagOpen = r26;
        27 r47 = new 27("ScriptDataEscapedEndTagName", 26);
        ScriptDataEscapedEndTagName = r47;
        28 r27 = new 28("ScriptDataDoubleEscapeStart", 27);
        ScriptDataDoubleEscapeStart = r27;
        29 r48 = new 29("ScriptDataDoubleEscaped", 28);
        ScriptDataDoubleEscaped = r48;
        30 r28 = new 30("ScriptDataDoubleEscapedDash", 29);
        ScriptDataDoubleEscapedDash = r28;
        31 r49 = new 31("ScriptDataDoubleEscapedDashDash", 30);
        ScriptDataDoubleEscapedDashDash = r49;
        32 r29 = new 32("ScriptDataDoubleEscapedLessthanSign", 31);
        ScriptDataDoubleEscapedLessthanSign = r29;
        33 r410 = new 33("ScriptDataDoubleEscapeEnd", 32);
        ScriptDataDoubleEscapeEnd = r410;
        34 r62 = new 34("BeforeAttributeName", 33);
        BeforeAttributeName = r62;
        35 r210 = new 35("AttributeName", 34);
        AttributeName = r210;
        36 r411 = new 36("AfterAttributeName", 35);
        AfterAttributeName = r411;
        37 r211 = new 37("BeforeAttributeValue", 36);
        BeforeAttributeValue = r211;
        38 r412 = new 38("AttributeValue_doubleQuoted", 37);
        AttributeValue_doubleQuoted = r412;
        39 r212 = new 39("AttributeValue_singleQuoted", 38);
        AttributeValue_singleQuoted = r212;
        40 r413 = new 40("AttributeValue_unquoted", 39);
        AttributeValue_unquoted = r413;
        41 r63 = new 41("AfterAttributeValue_quoted", 40);
        AfterAttributeValue_quoted = r63;
        42 r213 = new 42("SelfClosingStartTag", 41);
        SelfClosingStartTag = r213;
        43 r414 = new 43("BogusComment", 42);
        BogusComment = r414;
        44 r214 = new 44("MarkupDeclarationOpen", 43);
        MarkupDeclarationOpen = r214;
        45 r415 = new 45("CommentStart", 44);
        CommentStart = r415;
        46 r215 = new 46("CommentStartDash", 45);
        CommentStartDash = r215;
        47 r416 = new 47("Comment", 46);
        Comment = r416;
        48 r216 = new 48("CommentEndDash", 47);
        CommentEndDash = r216;
        49 r64 = new 49("CommentEnd", 48);
        CommentEnd = r64;
        50 r217 = new 50("CommentEndBang", 49);
        CommentEndBang = r217;
        51 r417 = new 51("Doctype", 50);
        Doctype = r417;
        52 r218 = new 52("BeforeDoctypeName", 51);
        BeforeDoctypeName = r218;
        53 r418 = new 53("DoctypeName", 52);
        DoctypeName = r418;
        54 r219 = new 54("AfterDoctypeName", 53);
        AfterDoctypeName = r219;
        55 r419 = new 55("AfterDoctypePublicKeyword", 54);
        AfterDoctypePublicKeyword = r419;
        56 r220 = new 56("BeforeDoctypePublicIdentifier", 55);
        BeforeDoctypePublicIdentifier = r220;
        57 r420 = new 57("DoctypePublicIdentifier_doubleQuoted", 56);
        DoctypePublicIdentifier_doubleQuoted = r420;
        58 r221 = new 58("DoctypePublicIdentifier_singleQuoted", 57);
        DoctypePublicIdentifier_singleQuoted = r221;
        59 r421 = new 59("AfterDoctypePublicIdentifier", 58);
        AfterDoctypePublicIdentifier = r421;
        60 r222 = new 60("BetweenDoctypePublicAndSystemIdentifiers", 59);
        BetweenDoctypePublicAndSystemIdentifiers = r222;
        61 r422 = new 61("AfterDoctypeSystemKeyword", 60);
        AfterDoctypeSystemKeyword = r422;
        62 r65 = new 62("BeforeDoctypeSystemIdentifier", 61);
        BeforeDoctypeSystemIdentifier = r65;
        63 r223 = new 63("DoctypeSystemIdentifier_doubleQuoted", 62);
        DoctypeSystemIdentifier_doubleQuoted = r223;
        64 r423 = new 64("DoctypeSystemIdentifier_singleQuoted", 63);
        DoctypeSystemIdentifier_singleQuoted = r423;
        65 r224 = new 65("AfterDoctypeSystemIdentifier", 64);
        AfterDoctypeSystemIdentifier = r224;
        66 r424 = new 66("BogusDoctype", 65);
        BogusDoctype = r424;
        67 r225 = new 67("CdataSection", 66);
        CdataSection = r225;
        $VALUES = new TokeniserState[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r42, r22, r43, r23, r44, r24, r45, r25, r46, r26, r47, r27, r48, r28, r49, r29, r410, r62, r210, r411, r211, r412, r212, r413, r63, r213, r414, r214, r415, r215, r416, r216, r64, r217, r417, r218, r418, r219, r419, r220, r420, r221, r421, r222, r422, r65, r223, r423, r224, r424, r225};
        char[] cArr = {'\'', '&', 0};
        attributeSingleValueCharsSorted = cArr;
        char[] cArr2 = {'\"', '&', 0};
        attributeDoubleValueCharsSorted = cArr2;
        char[] cArr3 = {'\t', '\n', '\r', '\f', ' ', '/', '=', '>', 0, '\"', '\'', '<'};
        attributeNameCharsSorted = cArr3;
        replacementStr = String.valueOf((char) 65533);
        Arrays.sort(cArr);
        Arrays.sort(cArr2);
        Arrays.sort(cArr3);
    }

    private TokeniserState(String str, int i) {
    }

    public static /* synthetic */ String access$100() {
        return replacementStr;
    }

    public static /* synthetic */ void access$200(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        handleDataEndTag(tokeniser, characterReader, tokeniserState);
    }

    public static /* synthetic */ void access$300(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        handleDataDoubleEscapeTag(tokeniser, characterReader, tokeniserState, tokeniserState2);
    }

    public static /* synthetic */ char[] access$400() {
        return attributeNameCharsSorted;
    }

    public static /* synthetic */ char[] access$500() {
        return attributeDoubleValueCharsSorted;
    }

    public static /* synthetic */ char[] access$600() {
        return attributeSingleValueCharsSorted;
    }

    private static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence.toLowerCase());
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ' && consume != '/' && consume != '>') {
            characterReader.unconsume();
            tokeniser.transition(tokeniserState2);
        } else {
            if (tokeniser.dataBuffer.toString().equals("script")) {
                tokeniser.transition(tokeniserState);
            } else {
                tokeniser.transition(tokeniserState2);
            }
            tokeniser.emit(consume);
        }
    }

    private static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        TokeniserState tokeniserState2;
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence.toLowerCase());
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState2 = BeforeAttributeName;
            } else if (consume == '/') {
                tokeniserState2 = SelfClosingStartTag;
            } else if (consume != '>') {
                tokeniser.dataBuffer.append(consume);
            } else {
                tokeniser.emitTagPending();
                tokeniserState2 = Data;
            }
            tokeniser.transition(tokeniserState2);
            return;
        }
        tokeniser.emit("</" + tokeniser.dataBuffer.toString());
        tokeniser.transition(tokeniserState);
    }

    public static TokeniserState valueOf(String str) {
        return (TokeniserState) Enum.valueOf(TokeniserState.class, str);
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) $VALUES.clone();
    }

    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);

    public /* synthetic */ TokeniserState(String str, int i, 1 r3) {
        this(str, i);
    }
}
