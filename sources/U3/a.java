package u3;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q3.e;
import q3.h;
import r5.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends h {
    public static final Pattern c = Pattern.compile("(.+?)='(.*?)';", 32);
    public final CharsetDecoder a = d.c.newDecoder();
    public final CharsetDecoder b = d.b.newDecoder();

    public q3.a b(e eVar, ByteBuffer byteBuffer) {
        String c2 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c2 == null) {
            return new q3.a(new c(bArr, null, null));
        }
        Matcher matcher = c.matcher(c2);
        String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String e = r5.b.e(group);
                e.hashCode();
                if (e.equals("streamurl")) {
                    str2 = group2;
                } else if (e.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new q3.a(new c(bArr, str, str2));
    }

    public final String c(ByteBuffer byteBuffer) {
        String charBuffer;
        CharsetDecoder charsetDecoder;
        try {
            charBuffer = this.a.decode(byteBuffer).toString();
            charsetDecoder = this.a;
        } catch (CharacterCodingException unused) {
            this.a.reset();
            byteBuffer.rewind();
            try {
                charBuffer = this.b.decode(byteBuffer).toString();
                charsetDecoder = this.b;
            } catch (CharacterCodingException unused2) {
                this.b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.a.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return charBuffer;
    }
}
