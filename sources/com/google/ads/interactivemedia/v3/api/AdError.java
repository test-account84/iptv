package com.google.ads.interactivemedia.v3.api;

import com.google.android.gms.common.internal.Hide;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class AdError extends Exception {
    private final AdErrorCode a;
    private final AdErrorType b;

    public enum AdErrorCode {
        INTERNAL_ERROR(-1),
        VAST_MALFORMED_RESPONSE(100),
        UNKNOWN_AD_RESPONSE(1010),
        VAST_TRAFFICKING_ERROR(200),
        VAST_LOAD_TIMEOUT(301),
        VAST_TOO_MANY_REDIRECTS(302),
        VIDEO_PLAY_ERROR(400),
        VAST_MEDIA_LOAD_TIMEOUT(402),
        VAST_LINEAR_ASSET_MISMATCH(403),
        OVERLAY_AD_PLAYING_FAILED(500),
        OVERLAY_AD_LOADING_FAILED(502),
        VAST_NONLINEAR_ASSET_MISMATCH(503),
        COMPANION_AD_LOADING_FAILED(603),
        UNKNOWN_ERROR(900),
        VAST_EMPTY_RESPONSE(1009),
        FAILED_TO_REQUEST_ADS(1005),
        VAST_ASSET_NOT_FOUND(1007),
        ADS_REQUEST_NETWORK_ERROR(1012),
        INVALID_ARGUMENTS(1101),
        PLAYLIST_NO_CONTENT_TRACKING(1205),
        UNEXPECTED_ADS_LOADED_EVENT(1206);

        private final int b;

        AdErrorCode(int i) {
            this.b = i;
        }

        public int getErrorNumber() {
            return this.b;
        }

        public String toString() {
            return "AdErrorCode [name: " + name() + ", number: " + this.b + "]";
        }
    }

    public enum AdErrorType {
        LOAD,
        PLAY
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdError(AdErrorType adErrorType, int i, String str) {
        AdErrorCode adErrorCode;
        AdErrorCode[] values = AdErrorCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                adErrorCode = values[i2];
                if (adErrorCode.getErrorNumber() == i) {
                    break;
                } else {
                    i2++;
                }
            } else {
                adErrorCode = i == 1204 ? AdErrorCode.INTERNAL_ERROR : AdErrorCode.UNKNOWN_ERROR;
            }
        }
        this(adErrorType, adErrorCode, str);
    }

    public AdErrorCode getErrorCode() {
        return this.a;
    }

    public int getErrorCodeNumber() {
        return this.a.getErrorNumber();
    }

    public AdErrorType getErrorType() {
        return this.b;
    }

    public String getMessage() {
        return super.getMessage();
    }

    @Hide
    public String toString() {
        return "AdError [errorType: " + String.valueOf(this.b) + ", errorCode: " + String.valueOf(this.a) + ", message: " + getMessage() + "]";
    }

    public AdError(AdErrorType adErrorType, AdErrorCode adErrorCode, String str) {
        super(str);
        this.b = adErrorType;
        this.a = adErrorCode;
    }
}
