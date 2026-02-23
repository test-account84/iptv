package org.apache.http.cookie;

import java.util.Date;
import org.apache.http.annotation.Obsolete;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface SetCookie extends Cookie {
    @Obsolete
    void setComment(String str);

    void setDomain(String str);

    void setExpiryDate(Date date);

    void setPath(String str);

    void setSecure(boolean z);

    void setValue(String str);

    @Obsolete
    void setVersion(int i);
}
