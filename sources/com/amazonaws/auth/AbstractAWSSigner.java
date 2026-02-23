package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractAWSSigner implements Signer {
    private static final int BUFFER_SIZE_MULTIPLIER = 5;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int TIME_MILLISEC = 1000;
    private static final ThreadLocal SHA256_MESSAGE_DIGEST = new 1();
    public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.toHex(doHash(""));

    public static class 1 extends ThreadLocal {
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e.getMessage(), e);
            }
        }
    }

    private static byte[] doHash(String str) {
        try {
            MessageDigest messageDigestInstance = getMessageDigestInstance();
            messageDigestInstance.update(str.getBytes(StringUtils.UTF8));
            return messageDigestInstance.digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    private static MessageDigest getMessageDigestInstance() {
        MessageDigest messageDigest = (MessageDigest) SHA256_MESSAGE_DIGEST.get();
        messageDigest.reset();
        return messageDigest;
    }

    public abstract void addSessionCredentials(Request request, AWSSessionCredentials aWSSessionCredentials);

    public byte[] getBinaryRequestPayload(Request request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        return encodeParameters == null ? new byte[0] : encodeParameters.getBytes(StringUtils.UTF8);
    }

    public InputStream getBinaryRequestPayloadStream(Request request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadStreamWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        return encodeParameters == null ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(encodeParameters.getBytes(StringUtils.UTF8));
    }

    public InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content instanceof StringInputStream) {
                return content;
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    public byte[] getBinaryRequestPayloadWithoutQueryParams(Request request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    public String getCanonicalizedEndpoint(URI uri) {
        String lowerCase = StringUtils.lowerCase(uri.getHost());
        if (!HttpUtils.isUsingNonDefaultPort(uri)) {
            return lowerCase;
        }
        return lowerCase + ":" + uri.getPort();
    }

    public String getCanonicalizedQueryString(Request request) {
        return HttpUtils.usePayloadForQueryParameters(request) ? "" : getCanonicalizedQueryString(request.getParameters());
    }

    public String getCanonicalizedResourcePath(String str) {
        return getCanonicalizedResourcePath(str, true);
    }

    public String getRequestPayload(Request request) {
        return newString(getBinaryRequestPayload(request));
    }

    public String getRequestPayloadWithoutQueryParams(Request request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    public Date getSignatureDate(long j) {
        Date date = new Date();
        return j != 0 ? new Date(date.getTime() - (j * 1000)) : date;
    }

    public long getTimeOffset(Request request) {
        return SDKGlobalConfiguration.getGlobalTimeOffset() != 0 ? SDKGlobalConfiguration.getGlobalTimeOffset() : request.getTimeOffset();
    }

    public byte[] hash(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, getMessageDigestInstance());
            while (sdkDigestInputStream.read(new byte[1024]) > -1) {
            }
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    public String newString(byte[] bArr) {
        return new String(bArr, StringUtils.UTF8);
    }

    public AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String aWSAccessKeyId;
        String aWSSecretKey;
        String sessionToken;
        synchronized (aWSCredentials) {
            try {
                aWSAccessKeyId = aWSCredentials.getAWSAccessKeyId();
                aWSSecretKey = aWSCredentials.getAWSSecretKey();
                sessionToken = aWSCredentials instanceof AWSSessionCredentials ? ((AWSSessionCredentials) aWSCredentials).getSessionToken() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aWSSecretKey != null) {
            aWSSecretKey = aWSSecretKey.trim();
        }
        if (aWSAccessKeyId != null) {
            aWSAccessKeyId = aWSAccessKeyId.trim();
        }
        if (sessionToken != null) {
            sessionToken = sessionToken.trim();
        }
        return aWSCredentials instanceof AWSSessionCredentials ? new BasicSessionCredentials(aWSAccessKeyId, aWSSecretKey, sessionToken) : new BasicAWSCredentials(aWSAccessKeyId, aWSSecretKey);
    }

    public byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return sign(str.getBytes(StringUtils.UTF8), bArr, signingAlgorithm);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    public String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return signAndBase64Encode(str.getBytes(StringUtils.UTF8), str2, signingAlgorithm);
    }

    public String getCanonicalizedQueryString(Map map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            treeMap.put(HttpUtils.urlEncode((String) entry.getKey(), false), HttpUtils.urlEncode((String) entry.getValue(), false));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append((String) entry2.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public String getCanonicalizedResourcePath(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (z) {
            str = HttpUtils.urlEncode(str, true);
        }
        return str.startsWith("/") ? str : "/".concat(str);
    }

    public byte[] hash(String str) {
        return doHash(str);
    }

    public byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac mac = Mac.getInstance(signingAlgorithm.toString());
            mac.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return mac.doFinal(bArr);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    public String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.encodeAsString(sign(bArr, str.getBytes(StringUtils.UTF8), signingAlgorithm));
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    public byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }
}
