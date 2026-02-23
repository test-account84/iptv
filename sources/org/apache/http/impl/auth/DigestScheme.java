package org.apache.http.impl.auth;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme() {
        this(Consts.ASCII);
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        String str2;
        char c;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        char c2;
        String str8;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String str9 = "MD5";
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            str2 = "algorithm";
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            c = ((httpRequest instanceof HttpEntityEnclosingRequest) && hashSet.contains("auth-int")) ? (char) 1 : hashSet.contains("auth") ? (char) 2 : (char) 65535;
        } else {
            str = "qop";
            str2 = "algorithm";
            c = 0;
        }
        if (c == 65535) {
            throw new AuthenticationException("None of the qop methods is supported: " + parameter7);
        }
        String parameter8 = getParameter("charset");
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        if (parameter6.equalsIgnoreCase("MD5-sess")) {
            str3 = "auth-int";
        } else {
            str3 = "auth-int";
            str9 = parameter6;
        }
        try {
            MessageDigest createMessageDigest = createMessageDigest(str9);
            String name = credentials.getUserPrincipal().getName();
            String password = credentials.getPassword();
            if (parameter3.equals(this.lastNonce)) {
                str4 = parameter;
                this.nounceCount++;
            } else {
                str4 = parameter;
                this.nounceCount = 1L;
                this.cnonce = null;
                this.lastNonce = parameter3;
            }
            StringBuilder sb = new StringBuilder(256);
            Formatter formatter = new Formatter(sb, Locale.US);
            formatter.format("%08x", new Object[]{Long.valueOf(this.nounceCount)});
            formatter.close();
            String sb2 = sb.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.a1 = null;
            this.a2 = null;
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                sb.setLength(0);
                sb.append(name);
                sb.append(':');
                sb.append(parameter2);
                sb.append(':');
                sb.append(password);
                String encode = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb.toString(), parameter8)));
                sb.setLength(0);
                sb.append(encode);
                sb.append(':');
                sb.append(parameter3);
                sb.append(':');
                password = this.cnonce;
            } else {
                sb.setLength(0);
                sb.append(name);
                sb.append(':');
                sb.append(parameter2);
                sb.append(':');
            }
            sb.append(password);
            this.a1 = sb.toString();
            String encode2 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.a1, parameter8)));
            if (c == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(parameter5);
                sb3.append(':');
                str5 = str4;
                sb3.append(str5);
                this.a2 = sb3.toString();
                str6 = "auth";
            } else {
                str5 = str4;
                if (c == 1) {
                    HttpEntity entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest).getEntity() : null;
                    if (entity == null || entity.isRepeatable()) {
                        str6 = "auth";
                        HttpEntityDigester httpEntityDigester = new HttpEntityDigester(createMessageDigest);
                        if (entity != null) {
                            try {
                                entity.writeTo(httpEntityDigester);
                            } catch (IOException e) {
                                throw new AuthenticationException("I/O error reading entity content", e);
                            }
                        }
                        httpEntityDigester.close();
                        str7 = parameter5 + ':' + str5 + ':' + encode(httpEntityDigester.getDigest());
                    } else {
                        str6 = "auth";
                        if (!hashSet.contains(str6)) {
                            throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                        }
                        this.a2 = parameter5 + ':' + str5;
                        c = 2;
                    }
                } else {
                    str6 = "auth";
                    str7 = parameter5 + ':' + str5;
                }
                this.a2 = str7;
            }
            String encode3 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.a2, parameter8)));
            if (c == 0) {
                sb.setLength(0);
                sb.append(encode2);
                c2 = ':';
                sb.append(':');
                sb.append(parameter3);
            } else {
                c2 = ':';
                sb.setLength(0);
                sb.append(encode2);
                sb.append(':');
                sb.append(parameter3);
                sb.append(':');
                sb.append(sb2);
                sb.append(':');
                sb.append(this.cnonce);
                sb.append(':');
                sb.append(c == 1 ? str3 : str6);
            }
            sb.append(c2);
            sb.append(encode3);
            String encode4 = encode(createMessageDigest.digest(EncodingUtils.getAsciiBytes(sb.toString())));
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
            charArrayBuffer.append(isProxy() ? "Proxy-Authorization" : "Authorization");
            charArrayBuffer.append(": Digest ");
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(new BasicNameValuePair("username", name));
            arrayList.add(new BasicNameValuePair("realm", parameter2));
            arrayList.add(new BasicNameValuePair("nonce", parameter3));
            arrayList.add(new BasicNameValuePair("uri", str5));
            arrayList.add(new BasicNameValuePair("response", encode4));
            if (c != 0) {
                String str10 = c == 1 ? str3 : str6;
                str8 = str;
                arrayList.add(new BasicNameValuePair(str8, str10));
                arrayList.add(new BasicNameValuePair("nc", sb2));
                arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
            } else {
                str8 = str;
            }
            String str11 = str2;
            arrayList.add(new BasicNameValuePair(str11, parameter6));
            if (parameter4 != null) {
                arrayList.add(new BasicNameValuePair("opaque", parameter4));
            }
            for (int i = 0; i < arrayList.size(); i++) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
                if (i > 0) {
                    charArrayBuffer.append(", ");
                }
                String name2 = basicNameValuePair.getName();
                BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, basicNameValuePair, !("nc".equals(name2) || str8.equals(name2) || str11.equals(name2)));
            }
            return new BufferedHeader(charArrayBuffer);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: " + str9);
        }
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i2] = cArr2[(b & 240) >> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public String getA1() {
        return this.a1;
    }

    public String getA2() {
        return this.a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    public String getSchemeName() {
        return "digest";
    }

    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
        if (getParameters().isEmpty()) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        }
        if (getParameter("nonce") == null) {
            throw new AuthenticationException("missing nonce in challenge");
        }
        getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
        getParameters().put("uri", httpRequest.getRequestLine().getUri());
        if (getParameter("charset") == null) {
            getParameters().put("charset", getCredentialsCharset(httpRequest));
        }
        return createDigestHeader(credentials, httpRequest);
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }
}
