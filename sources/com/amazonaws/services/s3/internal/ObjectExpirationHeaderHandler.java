package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ObjectExpirationHeaderHandler implements HeaderHandler {
    private static final Pattern DATE_PATTERN = Pattern.compile("expiry-date=\"(.*?)\"");
    private static final Pattern RULE_PATTERN = Pattern.compile("rule-id=\"(.*?)\"");
    private static final Log log = LogFactory.getLog(ObjectExpirationHeaderHandler.class);

    private Date parseDate(String str) {
        Matcher matcher = DATE_PATTERN.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.parseRfc822Date(matcher.group(1));
        } catch (Exception e) {
            log.warn("Error parsing expiry-date from x-amz-expiration header.", e);
            return null;
        }
    }

    private String parseRuleId(String str) {
        Matcher matcher = RULE_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public void handle(ObjectExpirationResult objectExpirationResult, HttpResponse httpResponse) {
        String str = (String) httpResponse.getHeaders().get("x-amz-expiration");
        if (str != null) {
            objectExpirationResult.setExpirationTime(parseDate(str));
            objectExpirationResult.setExpirationTimeRuleId(parseRuleId(str));
        }
    }
}
