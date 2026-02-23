package org.apache.http.client.protocol;

import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.entity.DecompressingEntity;
import org.apache.http.client.entity.DeflateInputStreamFactory;
import org.apache.http.client.entity.GZIPInputStreamFactory;
import org.apache.http.client.entity.InputStreamFactory;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";
    private final Lookup decoderRegistry;
    private final boolean ignoreUnknown;

    public ResponseContentEncoding() {
        this((Lookup) null);
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (!HttpClientContext.adapt(httpContext).getRequestConfig().isContentCompressionEnabled() || entity == null || entity.getContentLength() == 0 || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        for (HeaderElement headerElement : contentEncoding.getElements()) {
            String lowerCase = headerElement.getName().toLowerCase(Locale.ROOT);
            InputStreamFactory inputStreamFactory = (InputStreamFactory) this.decoderRegistry.lookup(lowerCase);
            if (inputStreamFactory != null) {
                httpResponse.setEntity(new DecompressingEntity(httpResponse.getEntity(), inputStreamFactory));
                httpResponse.removeHeaders("Content-Length");
                httpResponse.removeHeaders("Content-Encoding");
                httpResponse.removeHeaders("Content-MD5");
            } else if (!"identity".equals(lowerCase) && !this.ignoreUnknown) {
                throw new HttpException("Unsupported Content-Encoding: " + headerElement.getName());
            }
        }
    }

    public ResponseContentEncoding(Lookup lookup) {
        this(lookup, true);
    }

    public ResponseContentEncoding(Lookup lookup, boolean z) {
        this.decoderRegistry = lookup == null ? RegistryBuilder.create().register("gzip", GZIPInputStreamFactory.getInstance()).register("x-gzip", GZIPInputStreamFactory.getInstance()).register("deflate", DeflateInputStreamFactory.getInstance()).build() : lookup;
        this.ignoreUnknown = z;
    }

    public ResponseContentEncoding(boolean z) {
        this(null, z);
    }
}
