package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    public String getAttributeName() {
        return "max-age";
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for 'max-age' attribute");
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                setCookie.setExpiryDate(new Date(System.currentTimeMillis() + (parseInt * 1000)));
                return;
            }
            throw new MalformedCookieException("Negative 'max-age' attribute: " + str);
        } catch (NumberFormatException unused) {
            throw new MalformedCookieException("Invalid 'max-age' attribute: " + str);
        }
    }
}
