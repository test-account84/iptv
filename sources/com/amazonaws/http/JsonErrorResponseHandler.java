package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonErrorResponseHandler implements HttpResponseHandler {
    private static final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;
    private static final String X_AMZN_ERROR_TYPE = "x-amzn-ErrorType";
    private final List unmarshallerList;

    public static final class JsonErrorResponse {
        private final String errorCode;
        private final Map map;
        private final String message = get("message");
        private final int statusCode;

        private JsonErrorResponse(int i, String str, Map map) {
            this.statusCode = i;
            this.errorCode = str;
            this.map = map;
        }

        public static JsonErrorResponse fromResponse(HttpResponse httpResponse) throws IOException {
            int statusCode = httpResponse.getStatusCode();
            Map jsonToStringMapWithList = JsonUtils.jsonToStringMapWithList(new BufferedReader(new InputStreamReader(httpResponse.getContent(), StringUtils.UTF8)));
            String str = (String) httpResponse.getHeaders().get("x-amzn-ErrorType");
            if (str != null) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
            } else if (jsonToStringMapWithList.containsKey("__type")) {
                String str2 = (String) jsonToStringMapWithList.get("__type");
                str = str2.substring(str2.lastIndexOf("#") + 1);
            }
            return new JsonErrorResponse(statusCode, str, jsonToStringMapWithList);
        }

        public String get(String str) {
            Object obj;
            if (str == null || str.length() == 0) {
                return null;
            }
            String str2 = StringUtils.lowerCase(str.substring(0, 1)) + str.substring(1);
            String str3 = StringUtils.upperCase(str.substring(0, 1)) + str.substring(1);
            if (this.map.containsKey(str3)) {
                obj = this.map.get(str3);
            } else {
                if (!this.map.containsKey(str2)) {
                    return "";
                }
                obj = this.map.get(str2);
            }
            return (String) obj;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getMessage() {
            return this.message;
        }

        public int getStatusCode() {
            return this.statusCode;
        }
    }

    public JsonErrorResponseHandler(List list) {
        this.unmarshallerList = list;
    }

    private AmazonServiceException runErrorUnmarshallers(JsonErrorResponse jsonErrorResponse) throws Exception {
        for (JsonErrorUnmarshaller jsonErrorUnmarshaller : this.unmarshallerList) {
            if (jsonErrorUnmarshaller.match(jsonErrorResponse)) {
                return jsonErrorUnmarshaller.unmarshall(jsonErrorResponse);
            }
        }
        return null;
    }

    public AmazonServiceException handle(HttpResponse httpResponse) throws Exception {
        try {
            JsonErrorResponse fromResponse = JsonErrorResponse.fromResponse(httpResponse);
            AmazonServiceException runErrorUnmarshallers = runErrorUnmarshallers(fromResponse);
            if (runErrorUnmarshallers == null) {
                return null;
            }
            runErrorUnmarshallers.setStatusCode(httpResponse.getStatusCode());
            runErrorUnmarshallers.setErrorType(httpResponse.getStatusCode() < 500 ? AmazonServiceException.ErrorType.Client : AmazonServiceException.ErrorType.Service);
            runErrorUnmarshallers.setErrorCode(fromResponse.getErrorCode());
            for (Map.Entry entry : httpResponse.getHeaders().entrySet()) {
                if ("X-Amzn-RequestId".equalsIgnoreCase((String) entry.getKey())) {
                    runErrorUnmarshallers.setRequestId((String) entry.getValue());
                }
            }
            return runErrorUnmarshallers;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse error response", e);
        }
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }
}
