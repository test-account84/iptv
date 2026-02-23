package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonUtils {
    private static final AwsJsonFactory FACTORY = new GsonFactory();

    @Deprecated
    public enum JsonEngine {
        Gson,
        Jackson
    }

    public static AwsJsonReader getJsonReader(Reader reader) {
        return FACTORY.getJsonReader(reader);
    }

    public static AwsJsonWriter getJsonWriter(Writer writer) {
        return FACTORY.getJsonWriter(writer);
    }

    private static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Map jsonToMap(Reader reader) {
        AwsJsonReader jsonReader = getJsonReader(reader);
        try {
            if (jsonReader.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.isContainer()) {
                    jsonReader.skipValue();
                } else {
                    hashMap.put(nextName, jsonReader.nextString());
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            return Collections.unmodifiableMap(hashMap);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse JSON String.", e);
        }
    }

    public static Map jsonToStringMapWithList(Reader reader) {
        String nextString;
        AwsJsonReader jsonReader = getJsonReader(reader);
        try {
            if (jsonReader.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (!jsonReader.isContainer()) {
                    nextString = jsonReader.nextString();
                } else if (AwsJsonToken.BEGIN_ARRAY.equals(jsonReader.peek())) {
                    StringWriter stringWriter = new StringWriter();
                    AwsJsonWriter jsonWriter = getJsonWriter(stringWriter);
                    jsonReader.beginArray();
                    jsonWriter.beginArray();
                    while (true) {
                        try {
                            AwsJsonToken awsJsonToken = AwsJsonToken.END_ARRAY;
                            if (awsJsonToken.equals(jsonReader.peek())) {
                                break;
                            }
                            AwsJsonToken peek = jsonReader.peek();
                            if (AwsJsonToken.BEGIN_OBJECT.equals(peek)) {
                                jsonReader.beginObject();
                                jsonWriter.beginObject();
                            } else if (AwsJsonToken.FIELD_NAME.equals(peek)) {
                                String nextName2 = jsonReader.nextName();
                                if (!AwsJsonToken.BEGIN_ARRAY.equals(jsonReader.peek())) {
                                    jsonWriter.name(nextName2);
                                }
                            } else if (AwsJsonToken.END_OBJECT.equals(peek)) {
                                jsonReader.endObject();
                                jsonWriter.endObject();
                            } else if (awsJsonToken.equals(peek)) {
                                jsonReader.endArray();
                                jsonWriter.endArray();
                            } else if (AwsJsonToken.VALUE_STRING.equals(peek) || AwsJsonToken.VALUE_NUMBER.equals(peek) || AwsJsonToken.VALUE_NULL.equals(peek) || AwsJsonToken.VALUE_BOOLEAN.equals(peek)) {
                                jsonWriter.value(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    jsonReader.endArray();
                    jsonWriter.endArray();
                    jsonWriter.flush();
                    jsonWriter.close();
                    nextString = stringWriter.toString();
                } else {
                    jsonReader.skipValue();
                }
                hashMap.put(nextName, nextString);
            }
            jsonReader.endObject();
            jsonReader.close();
            return Collections.unmodifiableMap(hashMap);
        } catch (IOException e2) {
            throw new AmazonClientException("Unable to parse JSON String.", e2);
        }
    }

    public static String mapToString(Map map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                jsonWriter.name((String) entry.getKey()).value((String) entry.getValue());
            }
            jsonWriter.endObject();
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e);
        }
    }

    @Deprecated
    public static void setJsonEngine(AwsJsonFactory awsJsonFactory) {
    }

    public static Map jsonToMap(String str) {
        return (str == null || str.isEmpty()) ? Collections.EMPTY_MAP : jsonToMap((Reader) new StringReader(str));
    }

    @Deprecated
    public static void setJsonEngine(JsonEngine jsonEngine) {
    }
}
