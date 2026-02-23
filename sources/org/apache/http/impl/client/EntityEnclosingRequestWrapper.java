package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolException;
import org.apache.http.entity.HttpEntityWrapper;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    private boolean consumed;
    private HttpEntity entity;

    public class EntityWrapper extends HttpEntityWrapper {
        public EntityWrapper(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public void consumeContent() throws IOException {
            EntityEnclosingRequestWrapper.access$002(EntityEnclosingRequestWrapper.this, true);
            super.consumeContent();
        }

        public InputStream getContent() throws IOException {
            EntityEnclosingRequestWrapper.access$002(EntityEnclosingRequestWrapper.this, true);
            return super.getContent();
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            EntityEnclosingRequestWrapper.access$002(EntityEnclosingRequestWrapper.this, true);
            super.writeTo(outputStream);
        }
    }

    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws ProtocolException {
        super(httpEntityEnclosingRequest);
        setEntity(httpEntityEnclosingRequest.getEntity());
    }

    public static /* synthetic */ boolean access$002(EntityEnclosingRequestWrapper entityEnclosingRequestWrapper, boolean z) {
        entityEnclosingRequestWrapper.consumed = z;
        return z;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public boolean isRepeatable() {
        HttpEntity httpEntity = this.entity;
        return httpEntity == null || httpEntity.isRepeatable() || !this.consumed;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity != null ? new EntityWrapper(httpEntity) : null;
        this.consumed = false;
    }
}
