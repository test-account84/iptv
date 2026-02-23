package org.apache.http.cookie;

import java.util.Date;
import org.apache.http.annotation.Obsolete;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Cookie {
    @Obsolete
    String getComment();

    @Obsolete
    String getCommentURL();

    String getDomain();

    Date getExpiryDate();

    String getName();

    String getPath();

    @Obsolete
    int[] getPorts();

    String getValue();

    @Obsolete
    int getVersion();

    boolean isExpired(Date date);

    boolean isPersistent();

    boolean isSecure();
}
