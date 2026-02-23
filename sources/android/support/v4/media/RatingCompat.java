package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR = new 1();
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    public class 1 implements Parcelable.Creator {
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static float getPercentRating(Rating rating) {
            return rating.getPercentRating();
        }

        public static int getRatingStyle(Rating rating) {
            return rating.getRatingStyle();
        }

        public static float getStarRating(Rating rating) {
            return rating.getStarRating();
        }

        public static boolean hasHeart(Rating rating) {
            return rating.hasHeart();
        }

        public static boolean isRated(Rating rating) {
            return rating.isRated();
        }

        public static boolean isThumbUp(Rating rating) {
            return rating.isThumbUp();
        }

        public static Rating newHeartRating(boolean z) {
            return Rating.newHeartRating(z);
        }

        public static Rating newPercentageRating(float f) {
            return Rating.newPercentageRating(f);
        }

        public static Rating newStarRating(int i, float f) {
            return Rating.newStarRating(i, f);
        }

        public static Rating newThumbRating(boolean z) {
            return Rating.newThumbRating(z);
        }

        public static Rating newUnratedRating(int i) {
            return Rating.newUnratedRating(i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = Api19Impl.getRatingStyle(rating);
            if (Api19Impl.isRated(rating)) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = newHeartRating(Api19Impl.hasHeart(rating));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(Api19Impl.isThumbUp(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(ratingStyle, Api19Impl.getStarRating(rating));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(Api19Impl.getPercentRating(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(ratingStyle);
            }
            ratingCompat.mRatingObj = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        String str;
        if (i == 3) {
            f2 = 3.0f;
        } else if (i == 4) {
            f2 = 4.0f;
        } else {
            if (i != 5) {
                str = "Invalid rating style (" + i + ") for a star rating";
                Log.e("Rating", str);
                return null;
            }
            f2 = 5.0f;
        }
        if (f >= 0.0f && f <= f2) {
            return new RatingCompat(i, f);
        }
        str = "Trying to set out of range star-based rating";
        Log.e("Rating", str);
        return null;
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6 && isRated()) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    public Object getRating() {
        Rating newUnratedRating;
        if (this.mRatingObj == null) {
            if (isRated()) {
                int i = this.mRatingStyle;
                switch (i) {
                    case 1:
                        newUnratedRating = Api19Impl.newHeartRating(hasHeart());
                        break;
                    case 2:
                        newUnratedRating = Api19Impl.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        newUnratedRating = Api19Impl.newStarRating(i, getStarRating());
                        break;
                    case 6:
                        newUnratedRating = Api19Impl.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                newUnratedRating = Api19Impl.newUnratedRating(this.mRatingStyle);
            }
            this.mRatingObj = newUnratedRating;
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int i = this.mRatingStyle;
        if ((i == 3 || i == 4 || i == 5) && isRated()) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        float f = this.mRatingValue;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
