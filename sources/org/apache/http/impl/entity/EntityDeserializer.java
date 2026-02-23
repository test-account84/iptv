package org.apache.http.impl.entity;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class EntityDeserializer {
    private final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpMessage, "HTTP message");
        return doDeserialize(sessionInputBuffer, httpMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.http.entity.BasicHttpEntity doDeserialize(org.apache.http.io.SessionInputBuffer r9, org.apache.http.HttpMessage r10) throws org.apache.http.HttpException, java.io.IOException {
        /*
            r8 = this;
            org.apache.http.entity.BasicHttpEntity r0 = new org.apache.http.entity.BasicHttpEntity
            r0.<init>()
            org.apache.http.entity.ContentLengthStrategy r1 = r8.lenStrategy
            long r1 = r1.determineLength(r10)
            r3 = -2
            r5 = -1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L23
            r1 = 1
            r0.setChunked(r1)
            r0.setContentLength(r5)
            org.apache.http.impl.io.ChunkedInputStream r1 = new org.apache.http.impl.io.ChunkedInputStream
            r1.<init>(r9)
        L1f:
            r0.setContent(r1)
            goto L3f
        L23:
            r3 = 0
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            r0.setChunked(r3)
            if (r4 != 0) goto L34
            r0.setContentLength(r5)
            org.apache.http.impl.io.IdentityInputStream r1 = new org.apache.http.impl.io.IdentityInputStream
            r1.<init>(r9)
            goto L1f
        L34:
            r0.setContentLength(r1)
            org.apache.http.impl.io.ContentLengthInputStream r3 = new org.apache.http.impl.io.ContentLengthInputStream
            r3.<init>(r9, r1)
            r0.setContent(r3)
        L3f:
            java.lang.String r9 = "Content-Type"
            org.apache.http.Header r9 = r10.getFirstHeader(r9)
            if (r9 == 0) goto L4a
            r0.setContentType(r9)
        L4a:
            java.lang.String r9 = "Content-Encoding"
            org.apache.http.Header r9 = r10.getFirstHeader(r9)
            if (r9 == 0) goto L55
            r0.setContentEncoding(r9)
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.entity.EntityDeserializer.doDeserialize(org.apache.http.io.SessionInputBuffer, org.apache.http.HttpMessage):org.apache.http.entity.BasicHttpEntity");
    }
}
