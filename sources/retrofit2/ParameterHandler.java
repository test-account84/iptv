package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class ParameterHandler {

    public class 1 extends ParameterHandler {
        public 1() {
        }

        public void apply(RequestBuilder requestBuilder, Iterable iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                ParameterHandler.this.apply(requestBuilder, it.next());
            }
        }
    }

    public class 2 extends ParameterHandler {
        public 2() {
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
            }
        }
    }

    public static final class Body extends ParameterHandler {
        private final Converter converter;

        public Body(Converter converter) {
            this.converter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                requestBuilder.setBody((RequestBody) this.converter.convert(obj));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + obj + " to RequestBody", e);
            }
        }
    }

    public static final class Field extends ParameterHandler {
        private final boolean encoded;
        private final String name;
        private final Converter valueConverter;

        public Field(String str, Converter converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, str, this.encoded);
        }
    }

    public static final class FieldMap extends ParameterHandler {
        private final boolean encoded;
        private final Converter valueConverter;

        public FieldMap(Converter converter, boolean z) {
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Map map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + str + "'.");
                }
                String str2 = (String) this.valueConverter.convert(value);
                if (str2 == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.");
                }
                requestBuilder.addFormField(str, str2, this.encoded);
            }
        }
    }

    public static final class Header extends ParameterHandler {
        private final String name;
        private final Converter valueConverter;

        public Header(String str, Converter converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, str);
        }
    }

    public static final class HeaderMap extends ParameterHandler {
        private final Converter valueConverter;

        public HeaderMap(Converter converter) {
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Map map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
                }
                requestBuilder.addHeader(str, (String) this.valueConverter.convert(value));
            }
        }
    }

    public static final class Part extends ParameterHandler {
        private final Converter converter;
        private final Headers headers;

        public Part(Headers headers, Converter converter) {
            this.headers = headers;
            this.converter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, (RequestBody) this.converter.convert(obj));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + obj + " to RequestBody", e);
            }
        }
    }

    public static final class PartMap extends ParameterHandler {
        private final String transferEncoding;
        private final Converter valueConverter;

        public PartMap(Converter converter, String str) {
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        public void apply(RequestBuilder requestBuilder, Map map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
                }
                requestBuilder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.transferEncoding), (RequestBody) this.valueConverter.convert(value));
            }
        }
    }

    public static final class Path extends ParameterHandler {
        private final boolean encoded;
        private final String name;
        private final Converter valueConverter;

        public Path(String str, Converter converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            if (obj != null) {
                requestBuilder.addPathParam(this.name, (String) this.valueConverter.convert(obj), this.encoded);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.name + "\" value must not be null.");
        }
    }

    public static final class Query extends ParameterHandler {
        private final boolean encoded;
        private final String name;
        private final Converter valueConverter;

        public Query(String str, Converter converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, str, this.encoded);
        }
    }

    public static final class QueryMap extends ParameterHandler {
        private final boolean encoded;
        private final Converter valueConverter;

        public QueryMap(Converter converter, boolean z) {
            this.valueConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Map map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + str + "'.");
                }
                String str2 = (String) this.valueConverter.convert(value);
                if (str2 == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.");
                }
                requestBuilder.addQueryParam(str, str2, this.encoded);
            }
        }
    }

    public static final class QueryName extends ParameterHandler {
        private final boolean encoded;
        private final Converter nameConverter;

        public QueryName(Converter converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            requestBuilder.addQueryParam((String) this.nameConverter.convert(obj), null, this.encoded);
        }
    }

    public static final class RawPart extends ParameterHandler {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler {
        public void apply(RequestBuilder requestBuilder, Object obj) {
            Utils.checkNotNull(obj, "@Url parameter is null.");
            requestBuilder.setRelativeUrl(obj);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, Object obj) throws IOException;

    public final ParameterHandler array() {
        return new 2();
    }

    public final ParameterHandler iterable() {
        return new 1();
    }
}
