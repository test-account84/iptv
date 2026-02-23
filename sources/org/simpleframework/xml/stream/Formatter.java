package org.simpleframework.xml.stream;

import java.io.BufferedWriter;
import java.io.Writer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Formatter {
    private OutputBuffer buffer = new OutputBuffer();
    private Indenter indenter;
    private Tag last;
    private String prolog;
    private Writer result;
    private static final char[] NAMESPACE = {'x', 'm', 'l', 'n', 's'};
    private static final char[] LESS = {'&', 'l', 't', ';'};
    private static final char[] GREATER = {'&', 'g', 't', ';'};
    private static final char[] DOUBLE = {'&', 'q', 'u', 'o', 't', ';'};
    private static final char[] SINGLE = {'&', 'a', 'p', 'o', 's', ';'};
    private static final char[] AND = {'&', 'a', 'm', 'p', ';'};
    private static final char[] OPEN = {'<', '!', '-', '-', ' '};
    private static final char[] CLOSE = {' ', '-', '-', '>'};

    public enum Tag {
        COMMENT,
        START,
        TEXT,
        END
    }

    public Formatter(Writer writer, Format format) {
        this.result = new BufferedWriter(writer, 1024);
        this.indenter = new Indenter(format);
        this.prolog = format.getProlog();
    }

    private void append(char c) throws Exception {
        this.buffer.append(c);
    }

    private void data(String str) throws Exception {
        write("<![CDATA[");
        write(str);
        write("]]>");
    }

    private void escape(char c) throws Exception {
        char[] symbol = symbol(c);
        if (symbol != null) {
            write(symbol);
        } else {
            write(c);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private boolean isText(char c) {
        if (c == '\t' || c == '\n' || c == '\r' || c == ' ') {
            return true;
        }
        return c > ' ' && c <= '~' && c != 247;
    }

    private char[] symbol(char c) {
        if (c == '\"') {
            return DOUBLE;
        }
        if (c == '<') {
            return LESS;
        }
        if (c == '>') {
            return GREATER;
        }
        if (c == '&') {
            return AND;
        }
        if (c != '\'') {
            return null;
        }
        return SINGLE;
    }

    private String unicode(char c) {
        return Integer.toString(c);
    }

    private void write(char c) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(c);
    }

    public void flush() throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.flush();
    }

    public void writeAttribute(String str, String str2, String str3) throws Exception {
        if (this.last != Tag.START) {
            throw new NodeException("Start element required");
        }
        write(' ');
        write(str, str3);
        write('=');
        write('\"');
        escape(str2);
        write('\"');
    }

    public void writeComment(String str) throws Exception {
        String pVar = this.indenter.top();
        if (this.last == Tag.START) {
            append('>');
        }
        if (pVar != null) {
            append(pVar);
            append(OPEN);
            append(str);
            append(CLOSE);
        }
        this.last = Tag.COMMENT;
    }

    public void writeEnd(String str, String str2) throws Exception {
        String pop = this.indenter.pop();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag != tag2) {
            if (tag != Tag.TEXT) {
                write(pop);
            }
            if (this.last != tag2) {
                write('<');
                write('/');
                write(str, str2);
            }
            this.last = Tag.END;
        }
        write('/');
        write('>');
        this.last = Tag.END;
    }

    public void writeNamespace(String str, String str2) throws Exception {
        if (this.last != Tag.START) {
            throw new NodeException("Start element required");
        }
        write(' ');
        write(NAMESPACE);
        if (!isEmpty(str2)) {
            write(':');
            write(str2);
        }
        write('=');
        write('\"');
        escape(str);
        write('\"');
    }

    public void writeProlog() throws Exception {
        String str = this.prolog;
        if (str != null) {
            write(str);
            write("\n");
        }
    }

    public void writeStart(String str, String str2) throws Exception {
        String push = this.indenter.push();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag == tag2) {
            append('>');
        }
        flush();
        append(push);
        append('<');
        if (!isEmpty(str2)) {
            append(str2);
            append(':');
        }
        append(str);
        this.last = tag2;
    }

    public void writeText(String str) throws Exception {
        writeText(str, Mode.ESCAPE);
    }

    private void append(String str) throws Exception {
        this.buffer.append(str);
    }

    private void escape(String str) throws Exception {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            escape(str.charAt(i));
        }
    }

    private void write(String str) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(str);
    }

    public void writeText(String str, Mode mode) throws Exception {
        if (this.last == Tag.START) {
            write('>');
        }
        if (mode == Mode.DATA) {
            data(str);
        } else {
            escape(str);
        }
        this.last = Tag.TEXT;
    }

    private void append(char[] cArr) throws Exception {
        this.buffer.append(cArr);
    }

    private void write(String str, String str2) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        if (!isEmpty(str2)) {
            this.result.write(str2);
            this.result.write(58);
        }
        this.result.write(str);
    }

    private void write(char[] cArr) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(cArr);
    }
}
