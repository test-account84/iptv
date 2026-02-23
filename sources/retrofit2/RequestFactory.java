package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class RequestFactory {
    private final HttpUrl baseUrl;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler[] parameterHandlers;
    private final String relativeUrl;

    public static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set relativeUrlParamNames;
        final Retrofit retrofit;
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        public Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
        }

        private static Class boxIfPrimitive(Class cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers parseHeaders(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.contentType = MediaType.get(trim);
                    } catch (IllegalArgumentException e) {
                        throw Utils.methodError(this.method, e, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z) {
            String str3 = this.httpMethod;
            if (str3 != null) {
                throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.httpMethod = str;
            this.hasBody = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (PARAM_URL_REGEX.matcher(substring).find()) {
                    throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.relativeUrl = str2;
            this.relativeUrlParamNames = parsePathParameters(str2);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            String value;
            String str;
            String value2;
            String str2;
            if (annotation instanceof DELETE) {
                value = ((DELETE) annotation).value();
                str = "DELETE";
            } else if (annotation instanceof GET) {
                value = ((GET) annotation).value();
                str = "GET";
            } else {
                if (!(annotation instanceof HEAD)) {
                    if (annotation instanceof PATCH) {
                        value2 = ((PATCH) annotation).value();
                        str2 = "PATCH";
                    } else if (annotation instanceof POST) {
                        value2 = ((POST) annotation).value();
                        str2 = "POST";
                    } else if (annotation instanceof PUT) {
                        value2 = ((PUT) annotation).value();
                        str2 = "PUT";
                    } else {
                        if (!(annotation instanceof OPTIONS)) {
                            if (annotation instanceof HTTP) {
                                HTTP http = (HTTP) annotation;
                                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
                                return;
                            }
                            if (annotation instanceof retrofit2.http.Headers) {
                                String[] value3 = ((retrofit2.http.Headers) annotation).value();
                                if (value3.length == 0) {
                                    throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
                                }
                                this.headers = parseHeaders(value3);
                                return;
                            }
                            if (annotation instanceof Multipart) {
                                if (this.isFormEncoded) {
                                    throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
                                }
                                this.isMultipart = true;
                                return;
                            } else {
                                if (annotation instanceof FormUrlEncoded) {
                                    if (this.isMultipart) {
                                        throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
                                    }
                                    this.isFormEncoded = true;
                                    return;
                                }
                                return;
                            }
                        }
                        value = ((OPTIONS) annotation).value();
                        str = "OPTIONS";
                    }
                    parseHttpMethodAndPath(str2, value2, true);
                    return;
                }
                value = ((HEAD) annotation).value();
                str = "HEAD";
            }
            parseHttpMethodAndPath(str, value, false);
        }

        private ParameterHandler parseParameter(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler parameterHandler = null;
            if (annotationArr != null) {
                for (Annotation annotation : annotationArr) {
                    ParameterHandler parseParameterAnnotation = parseParameterAnnotation(i, type, annotationArr, annotation);
                    if (parseParameterAnnotation != null) {
                        if (parameterHandler != null) {
                            throw Utils.parameterError(this.method, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        parameterHandler = parseParameterAnnotation;
                    }
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw Utils.parameterError(this.method, i, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler parseParameterAnnotation(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                validateResolvableType(i, type);
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.gotPath) {
                    throw Utils.parameterError(this.method, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.relativeUrl != null) {
                    throw Utils.parameterError(this.method, i, "@Url cannot be used with @%s URL", this.httpMethod);
                }
                this.gotUrl = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new ParameterHandler.RelativeUrl();
                }
                throw Utils.parameterError(this.method, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                validateResolvableType(i, type);
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.relativeUrl == null) {
                    throw Utils.parameterError(this.method, i, "@Path can only be used with relative url on @%s", this.httpMethod);
                }
                this.gotPath = true;
                Path path = (Path) annotation;
                String value = path.value();
                validatePathName(i, value);
                return new ParameterHandler.Path(value, this.retrofit.stringConverter(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                validateResolvableType(i, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class rawType = Utils.getRawType(type);
                this.gotQuery = true;
                if (!Iterable.class.isAssignableFrom(rawType)) {
                    return rawType.isArray() ? new ParameterHandler.Query(value2, this.retrofit.stringConverter(boxIfPrimitive(rawType.getComponentType()), annotationArr), encoded).array() : new ParameterHandler.Query(value2, this.retrofit.stringConverter(type, annotationArr), encoded);
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Query(value2, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded).iterable();
                }
                throw Utils.parameterError(this.method, i, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                validateResolvableType(i, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class rawType2 = Utils.getRawType(type);
                this.gotQueryName = true;
                if (!Iterable.class.isAssignableFrom(rawType2)) {
                    return rawType2.isArray() ? new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(rawType2.getComponentType()), annotationArr), encoded2).array() : new ParameterHandler.QueryName(this.retrofit.stringConverter(type, annotationArr), encoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded2).iterable();
                }
                throw Utils.parameterError(this.method, i, rawType2.getSimpleName() + " must include generic type (e.g., " + rawType2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                validateResolvableType(i, type);
                Class rawType3 = Utils.getRawType(type);
                this.gotQueryMap = true;
                if (!Map.class.isAssignableFrom(rawType3)) {
                    throw Utils.parameterError(this.method, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                ParameterizedType supertype = Utils.getSupertype(type, rawType3, Map.class);
                if (!(supertype instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = supertype;
                Type parameterUpperBound = Utils.getParameterUpperBound(0, parameterizedType);
                if (String.class == parameterUpperBound) {
                    return new ParameterHandler.QueryMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw Utils.parameterError(this.method, i, "@QueryMap keys must be of type String: " + parameterUpperBound, new Object[0]);
            }
            if (annotation instanceof Header) {
                validateResolvableType(i, type);
                String value3 = ((Header) annotation).value();
                Class rawType4 = Utils.getRawType(type);
                if (!Iterable.class.isAssignableFrom(rawType4)) {
                    return rawType4.isArray() ? new ParameterHandler.Header(value3, this.retrofit.stringConverter(boxIfPrimitive(rawType4.getComponentType()), annotationArr)).array() : new ParameterHandler.Header(value3, this.retrofit.stringConverter(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Header(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).iterable();
                }
                throw Utils.parameterError(this.method, i, rawType4.getSimpleName() + " must include generic type (e.g., " + rawType4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                validateResolvableType(i, type);
                Class rawType5 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType5)) {
                    throw Utils.parameterError(this.method, i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                ParameterizedType supertype2 = Utils.getSupertype(type, rawType5, Map.class);
                if (!(supertype2 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = supertype2;
                Type parameterUpperBound2 = Utils.getParameterUpperBound(0, parameterizedType2);
                if (String.class == parameterUpperBound2) {
                    return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotationArr));
                }
                throw Utils.parameterError(this.method, i, "@HeaderMap keys must be of type String: " + parameterUpperBound2, new Object[0]);
            }
            if (annotation instanceof Field) {
                validateResolvableType(i, type);
                if (!this.isFormEncoded) {
                    throw Utils.parameterError(this.method, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.gotField = true;
                Class rawType6 = Utils.getRawType(type);
                if (!Iterable.class.isAssignableFrom(rawType6)) {
                    return rawType6.isArray() ? new ParameterHandler.Field(value4, this.retrofit.stringConverter(boxIfPrimitive(rawType6.getComponentType()), annotationArr), encoded3).array() : new ParameterHandler.Field(value4, this.retrofit.stringConverter(type, annotationArr), encoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Field(value4, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded3).iterable();
                }
                throw Utils.parameterError(this.method, i, rawType6.getSimpleName() + " must include generic type (e.g., " + rawType6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                validateResolvableType(i, type);
                if (!this.isFormEncoded) {
                    throw Utils.parameterError(this.method, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class rawType7 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType7)) {
                    throw Utils.parameterError(this.method, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                ParameterizedType supertype3 = Utils.getSupertype(type, rawType7, Map.class);
                if (!(supertype3 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = supertype3;
                Type parameterUpperBound3 = Utils.getParameterUpperBound(0, parameterizedType3);
                if (String.class == parameterUpperBound3) {
                    Converter stringConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotationArr);
                    this.gotField = true;
                    return new ParameterHandler.FieldMap(stringConverter, ((FieldMap) annotation).encoded());
                }
                throw Utils.parameterError(this.method, i, "@FieldMap keys must be of type String: " + parameterUpperBound3, new Object[0]);
            }
            if (!(annotation instanceof Part)) {
                if (!(annotation instanceof PartMap)) {
                    if (!(annotation instanceof Body)) {
                        return null;
                    }
                    validateResolvableType(i, type);
                    if (this.isFormEncoded || this.isMultipart) {
                        throw Utils.parameterError(this.method, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.gotBody) {
                        throw Utils.parameterError(this.method, i, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        Converter requestBodyConverter = this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations);
                        this.gotBody = true;
                        return new ParameterHandler.Body(requestBodyConverter);
                    } catch (RuntimeException e) {
                        throw Utils.parameterError(this.method, e, i, "Unable to create @Body converter for %s", type);
                    }
                }
                validateResolvableType(i, type);
                if (!this.isMultipart) {
                    throw Utils.parameterError(this.method, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.gotPart = true;
                Class rawType8 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType8)) {
                    throw Utils.parameterError(this.method, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                ParameterizedType supertype4 = Utils.getSupertype(type, rawType8, Map.class);
                if (!(supertype4 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = supertype4;
                Type parameterUpperBound4 = Utils.getParameterUpperBound(0, parameterizedType4);
                if (String.class == parameterUpperBound4) {
                    Type parameterUpperBound5 = Utils.getParameterUpperBound(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound5))) {
                        throw Utils.parameterError(this.method, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(parameterUpperBound5, annotationArr, this.methodAnnotations), ((PartMap) annotation).encoding());
                }
                throw Utils.parameterError(this.method, i, "@PartMap keys must be of type String: " + parameterUpperBound4, new Object[0]);
            }
            validateResolvableType(i, type);
            if (!this.isMultipart) {
                throw Utils.parameterError(this.method, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            Part part = (Part) annotation;
            this.gotPart = true;
            String value5 = part.value();
            Class rawType9 = Utils.getRawType(type);
            if (value5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(rawType9)) {
                    if (rawType9.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(rawType9.getComponentType())) {
                            return ParameterHandler.RawPart.INSTANCE.array();
                        }
                        throw Utils.parameterError(this.method, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(rawType9)) {
                        return ParameterHandler.RawPart.INSTANCE;
                    }
                    throw Utils.parameterError(this.method, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                        return ParameterHandler.RawPart.INSTANCE.iterable();
                    }
                    throw Utils.parameterError(this.method, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw Utils.parameterError(this.method, i, rawType9.getSimpleName() + " must include generic type (e.g., " + rawType9.getSimpleName() + "<String>)", new Object[0]);
            }
            Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
            if (!Iterable.class.isAssignableFrom(rawType9)) {
                if (!rawType9.isArray()) {
                    if (MultipartBody.Part.class.isAssignableFrom(rawType9)) {
                        throw Utils.parameterError(this.method, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.Part(of, this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations));
                }
                Type boxIfPrimitive = boxIfPrimitive(rawType9.getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom(boxIfPrimitive)) {
                    throw Utils.parameterError(this.method, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(of, this.retrofit.requestBodyConverter(boxIfPrimitive, annotationArr, this.methodAnnotations)).array();
            }
            if (type instanceof ParameterizedType) {
                Type parameterUpperBound6 = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound6))) {
                    throw Utils.parameterError(this.method, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(of, this.retrofit.requestBodyConverter(parameterUpperBound6, annotationArr, this.methodAnnotations)).iterable();
            }
            throw Utils.parameterError(this.method, i, rawType9.getSimpleName() + " must include generic type (e.g., " + rawType9.getSimpleName() + "<String>)", new Object[0]);
        }

        public static Set parsePathParameters(String str) {
            Matcher matcher = PARAM_URL_REGEX.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void validatePathName(int i, String str) {
            if (!PARAM_NAME_REGEX.matcher(str).matches()) {
                throw Utils.parameterError(this.method, i, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
            }
            if (!this.relativeUrlParamNames.contains(str)) {
                throw Utils.parameterError(this.method, i, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        private void validateResolvableType(int i, Type type) {
            if (Utils.hasUnresolvableType(type)) {
                throw Utils.parameterError(this.method, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        public RequestFactory build() {
            for (Annotation annotation : this.methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            if (this.httpMethod == null) {
                throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.hasBody) {
                if (this.isMultipart) {
                    throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.isFormEncoded) {
                    throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[length];
            for (int i = 0; i < length; i++) {
                this.parameterHandlers[i] = parseParameter(i, this.parameterTypes[i], this.parameterAnnotationsArray[i]);
            }
            if (this.relativeUrl == null && !this.gotUrl) {
                throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
            }
            boolean z = this.isFormEncoded;
            if (!z && !this.isMultipart && !this.hasBody && this.gotBody) {
                throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z && !this.gotField) {
                throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.isMultipart || this.gotPart) {
                return new RequestFactory(this);
            }
            throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    public RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    public static RequestFactory parseAnnotations(Retrofit retrofit, Method method) {
        return new Builder(retrofit, method).build();
    }

    public Request create(Object[] objArr) throws IOException {
        ParameterHandler[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr.length;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
        }
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            parameterHandlerArr[i].apply(requestBuilder, objArr[i]);
        }
        return requestBuilder.get().tag(Invocation.class, new Invocation(this.method, arrayList)).build();
    }
}
