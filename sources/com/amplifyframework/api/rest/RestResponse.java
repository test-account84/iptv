package com.amplifyframework.api.rest;

import O.c;
import com.amplifyframework.util.Immutable;
import com.amplifyframework.util.Range;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RestResponse {
    private final Code code;
    private final Data data;
    private final Map headers;

    public static final class Code {
        private final int statusCode;
        private static final Range ALL_VALID_CODES = new Range(100, 599);
        private static final Range SERVICE_FAILURE_CODES = new Range(500, 599);
        private static final Range CLIENT_ERROR_CODES = new Range(400, 499);
        private static final Range SUCCESS_CODES = new Range(200, 299);

        public Code(int i) {
            this.statusCode = validateValue(i);
        }

        private int validateValue(int i) {
            if (ALL_VALID_CODES.contains(Integer.valueOf(i))) {
                return i;
            }
            return -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && Code.class == obj.getClass() && this.statusCode == ((Code) obj).statusCode;
        }

        public int hashCode() {
            return this.statusCode;
        }

        public boolean isClientError() {
            return CLIENT_ERROR_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public boolean isServiceFailure() {
            return SERVICE_FAILURE_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public boolean isSuccessful() {
            return SUCCESS_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public String toString() {
            return "Code{statusCode=" + this.statusCode + '}';
        }
    }

    public static final class Data {
        private final byte[] rawBytes;

        public Data(byte[] bArr) {
            this.rawBytes = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        }

        public JSONObject asJSONObject() throws JSONException {
            return new JSONObject(asString());
        }

        public String asString() {
            return new String(this.rawBytes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Data.class != obj.getClass()) {
                return false;
            }
            return c.a(getRawBytes(), ((Data) obj).getRawBytes());
        }

        public byte[] getRawBytes() {
            return this.rawBytes;
        }

        public int hashCode() {
            return Arrays.hashCode(getRawBytes());
        }

        public String toString() {
            return "Data{rawBytes=" + Arrays.toString(this.rawBytes) + '}';
        }
    }

    public RestResponse(int i, Map map) {
        this(i, map, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestResponse.class != obj.getClass()) {
            return false;
        }
        RestResponse restResponse = (RestResponse) obj;
        if (c.a(getData(), restResponse.getData())) {
            return c.a(getCode(), restResponse.getCode());
        }
        return false;
    }

    public Code getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public Map getHeaders() {
        return Immutable.of(this.headers);
    }

    public int hashCode() {
        return ((getData() != null ? getData().hashCode() : 0) * 31) + (getCode() != null ? getCode().hashCode() : 0);
    }

    public String toString() {
        return "RestResponse{data=" + this.data + ", code=" + this.code + '}';
    }

    public RestResponse(int i, Map map, byte[] bArr) {
        this.data = new Data(bArr);
        this.headers = map;
        this.code = new Code(i);
    }
}
