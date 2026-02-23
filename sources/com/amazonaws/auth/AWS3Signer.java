package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AWS3Signer extends AbstractAWSSigner {
    private static final String AUTHORIZATION_HEADER = "X-Amzn-Authorization";
    private static final String HTTPS_SCHEME = "AWS3-HTTPS";
    private static final String HTTP_SCHEME = "AWS3";
    private static final String NONCE_HEADER = "x-amz-nonce";
    private static final Log log = LogFactory.getLog(AWS3Signer.class);
    private String overriddenDate;

    private String getSignedHeadersComponent(Request request) {
        StringBuilder sb = new StringBuilder();
        sb.append("SignedHeaders=");
        boolean z = true;
        for (String str : getHeadersForStringToSign(request)) {
            if (!z) {
                sb.append(";");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    public void addSessionCredentials(Request request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public String getCanonicalizedHeadersForStringToSign(Request request) {
        List headersForStringToSign = getHeadersForStringToSign(request);
        for (int i = 0; i < headersForStringToSign.size(); i++) {
            headersForStringToSign.set(i, StringUtils.lowerCase((String) headersForStringToSign.get(i)));
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : request.getHeaders().entrySet()) {
            if (headersForStringToSign.contains(StringUtils.lowerCase((String) entry.getKey()))) {
                treeMap.put(StringUtils.lowerCase((String) entry.getKey()), entry.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append(StringUtils.lowerCase((String) entry2.getKey()));
            sb.append(":");
            sb.append((String) entry2.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List getHeadersForStringToSign(Request request) {
        ArrayList arrayList = new ArrayList();
        Iterator it = request.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            String lowerCase = StringUtils.lowerCase(str);
            if (lowerCase.startsWith("x-amz") || "host".equals(lowerCase)) {
                arrayList.add(str);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public void overrideDate(String str) {
        this.overriddenDate = str;
    }

    public boolean shouldUseHttpsScheme(Request request) {
        try {
            String lowerCase = StringUtils.lowerCase(request.getEndpoint().toURL().getProtocol());
            if ("http".equals(lowerCase)) {
                return false;
            }
            if ("https".equals(lowerCase)) {
                return true;
            }
            throw new AmazonClientException("Unknown request endpoint protocol encountered while signing request: " + lowerCase);
        } catch (MalformedURLException e) {
            throw new AmazonClientException("Unable to parse request endpoint during signing", e);
        }
    }

    public void sign(Request request, AWSCredentials aWSCredentials) {
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        UUID.randomUUID().toString();
        String formatRFC822Date = DateUtils.formatRFC822Date(getSignatureDate(getTimeOffset(request)));
        String str = this.overriddenDate;
        if (str != null) {
            formatRFC822Date = str;
        }
        request.addHeader("Date", formatRFC822Date);
        request.addHeader("X-Amz-Date", formatRFC822Date);
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            host = host + ":" + request.getEndpoint().getPort();
        }
        request.addHeader("Host", host);
        if (sanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
        }
        String str2 = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath())) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
        byte[] hash = hash(str2);
        log.debug("Calculated StringToSign: " + str2);
        String signAndBase64Encode = signAndBase64Encode(hash, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm);
        StringBuilder sb = new StringBuilder();
        sb.append("AWS3");
        sb.append(" ");
        sb.append("AWSAccessKeyId=" + sanitizeCredentials.getAWSAccessKeyId() + ",");
        sb.append("Algorithm=" + signingAlgorithm.toString() + ",");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getSignedHeadersComponent(request));
        sb2.append(",");
        sb.append(sb2.toString());
        sb.append("Signature=" + signAndBase64Encode);
        request.addHeader("X-Amzn-Authorization", sb.toString());
    }
}
