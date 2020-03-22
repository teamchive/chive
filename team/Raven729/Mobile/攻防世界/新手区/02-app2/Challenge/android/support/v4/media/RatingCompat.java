package android.support.v4.media;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    final class android.support.v4.media.RatingCompat$1 implements Parcelable$Creator {
        android.support.v4.media.RatingCompat$1() {
            super();
        }

        public RatingCompat createFromParcel(Parcel arg4) {
            return new RatingCompat(arg4.readInt(), arg4.readFloat());
        }

        public Object createFromParcel(Parcel arg2) {
            return this.createFromParcel(arg2);
        }

        public RatingCompat[] newArray(int arg2) {
            return new RatingCompat[arg2];
        }

        public Object[] newArray(int arg2) {
            return this.newArray(arg2);
        }
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface StarStyle {
    }

    @RestrictTo(value={Scope.LIBRARY_GROUP}) @Retention(value=RetentionPolicy.SOURCE) @public interface Style {
    }

    public static final Parcelable$Creator CREATOR = null;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    static {
        RatingCompat.CREATOR = new android.support.v4.media.RatingCompat$1();
    }

    RatingCompat(int arg1, float arg2) {
        super();
        this.mRatingStyle = arg1;
        this.mRatingValue = arg2;
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public static RatingCompat fromRating(Object arg3) {
        RatingCompat v0 = null;
        if(arg3 != null && Build$VERSION.SDK_INT >= 19) {
            int v1 = RatingCompatKitkat.getRatingStyle(arg3);
            if(RatingCompatKitkat.isRated(arg3)) {
                switch(v1) {
                    case 1: {
                        goto label_11;
                    }
                    case 2: {
                        goto label_15;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        goto label_18;
                    }
                    case 6: {
                        goto label_21;
                    }
                }

                return v0;
            label_18:
                v0 = RatingCompat.newStarRating(v1, RatingCompatKitkat.getStarRating(arg3));
                goto label_13;
            label_21:
                v0 = RatingCompat.newPercentageRating(RatingCompatKitkat.getPercentRating(arg3));
                goto label_13;
            label_11:
                v0 = RatingCompat.newHeartRating(RatingCompatKitkat.hasHeart(arg3));
                goto label_13;
            label_15:
                v0 = RatingCompat.newThumbRating(RatingCompatKitkat.isThumbUp(arg3));
            }
            else {
                v0 = RatingCompat.newUnratedRating(v1);
            }

        label_13:
            v0.mRatingObj = arg3;
        }

        return v0;
    }

    public float getPercentRating() {
        float v0 = this.mRatingStyle != 6 || !this.isRated() ? -1f : this.mRatingValue;
        return v0;
    }

    public Object getRating() {
        Object v0;
        if(this.mRatingObj != null || Build$VERSION.SDK_INT < 19) {
            v0 = this.mRatingObj;
        }
        else {
            if(this.isRated()) {
                switch(this.mRatingStyle) {
                    case 1: {
                        goto label_13;
                    }
                    case 2: {
                        goto label_18;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        goto label_22;
                    }
                    case 6: {
                        goto label_27;
                    }
                }

                goto label_11;
            label_18:
                this.mRatingObj = RatingCompatKitkat.newThumbRating(this.isThumbUp());
                goto label_16;
            label_22:
                this.mRatingObj = RatingCompatKitkat.newStarRating(this.mRatingStyle, this.getStarRating());
                goto label_16;
            label_27:
                this.mRatingObj = RatingCompatKitkat.newPercentageRating(this.getPercentRating());
            label_11:
                v0 = null;
                return v0;
            label_13:
                this.mRatingObj = RatingCompatKitkat.newHeartRating(this.hasHeart());
            }
            else {
                this.mRatingObj = RatingCompatKitkat.newUnratedRating(this.mRatingStyle);
            }

        label_16:
            v0 = this.mRatingObj;
        }

        return v0;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        float v0;
        switch(this.mRatingStyle) {
            case 3: 
            case 4: 
            case 5: {
                if(this.isRated()) {
                    v0 = this.mRatingValue;
                }
                else {
                    goto label_2;
                }

                break;
            }
            default: {
            label_2:
                v0 = -1f;
                break;
            }
        }

        return v0;
    }

    public boolean hasHeart() {
        boolean v0 = true;
        boolean v1 = false;
        if(this.mRatingStyle == 1) {
            if(this.mRatingValue != 1f) {
                v0 = false;
            }

            v1 = v0;
        }

        return v1;
    }

    public boolean isRated() {
        boolean v0 = this.mRatingValue >= 0f ? true : false;
        return v0;
    }

    public boolean isThumbUp() {
        boolean v0 = false;
        if(this.mRatingStyle == 2 && this.mRatingValue == 1f) {
            v0 = true;
        }

        return v0;
    }

    public static RatingCompat newHeartRating(boolean arg3) {
        float v0 = arg3 ? 1f : 0f;
        return new RatingCompat(1, v0);
    }

    public static RatingCompat newPercentageRating(float arg2) {
        RatingCompat v0;
        if(arg2 < 0f || arg2 > 100f) {
            Log.e("Rating", "Invalid percentage-based rating value");
            v0 = null;
        }
        else {
            v0 = new RatingCompat(6, arg2);
        }

        return v0;
    }

    public static RatingCompat newStarRating(int arg4, float arg5) {
        RatingCompat v0 = null;
        switch(arg4) {
            case 3: {
                goto label_13;
            }
            case 4: {
                goto label_21;
            }
            case 5: {
                goto label_23;
            }
        }

        Log.e("Rating", "Invalid rating style (" + arg4 + ") for a star rating");
        return v0;
    label_21:
        float v1 = 4f;
        goto label_14;
    label_23:
        v1 = 5f;
        goto label_14;
    label_13:
        v1 = 3f;
    label_14:
        if(arg5 >= 0f && arg5 <= v1) {
            v0 = new RatingCompat(arg4, arg5);
        }
        else {
            Log.e("Rating", "Trying to set out of range star-based rating");
        }

        return v0;
    }

    public static RatingCompat newThumbRating(boolean arg3) {
        int v2 = 2;
        float v0 = arg3 ? 1f : 0f;
        return new RatingCompat(v2, v0);
    }

    public static RatingCompat newUnratedRating(int arg2) {
        RatingCompat v0;
        switch(arg2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                v0 = new RatingCompat(arg2, -1f);
                break;
            }
            default: {
                v0 = null;
                break;
            }
        }

        return v0;
    }

    public String toString() {
        StringBuilder v1 = new StringBuilder().append("Rating:style=").append(this.mRatingStyle).append(" rating=");
        String v0 = this.mRatingValue < 0f ? "unrated" : String.valueOf(this.mRatingValue);
        return v1.append(v0).toString();
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeInt(this.mRatingStyle);
        arg2.writeFloat(this.mRatingValue);
    }
}

