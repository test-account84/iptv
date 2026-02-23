package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ObjectRestoreHeaderHandler implements HeaderHandler {
    private static final Pattern DATE_PATTERN = Pattern.compile("expiry-date=\"(.*?)\"");
    private static final Pattern ONGOING_PATTERN = Pattern.compile("ongoing-request=\"(.*?)\"");
    private static final Log log = LogFactory.getLog(ObjectRestoreHeaderHandler.class);

    private Boolean parseBoolean(String str) {
        Matcher matcher = ONGOING_PATTERN.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }

    private Date parseDate(String str) {
        Matcher matcher = DATE_PATTERN.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.parseRfc822Date(matcher.group(1));
        } catch (Exception e) {
            log.warn("Error parsing expiry-date from x-amz-restore header.", e);
            return null;
        }
    }

    public void handle(ObjectRestoreResult objectRestoreResult, HttpResponse httpResponse) {
        String str = (String) httpResponse.getHeaders().get("x-amz-restore");
        if (str != null) {
            objectRestoreResult.setRestoreExpirationTime(parseDate(str));
            Boolean parseBoolean = parseBoolean(str);
            if (parseBoolean != null) {
                objectRestoreResult.setOngoingRestore(parseBoolean.booleanValue());
            }
        }
    }
}
