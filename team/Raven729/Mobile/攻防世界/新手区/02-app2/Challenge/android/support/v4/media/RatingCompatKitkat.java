package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.Rating;
import android.support.annotation.RequiresApi;

@TargetApi(value=19) @RequiresApi(value=19) class RatingCompatKitkat {
    RatingCompatKitkat() {
        super();
    }

    public static float getPercentRating(Object arg1) {
        return ((Rating)arg1).getPercentRating();
    }

    public static int getRatingStyle(Object arg1) {
        return ((Rating)arg1).getRatingStyle();
    }

    public static float getStarRating(Object arg1) {
        return ((Rating)arg1).getStarRating();
    }

    public static boolean hasHeart(Object arg1) {
        return ((Rating)arg1).hasHeart();
    }

    public static boolean isRated(Object arg1) {
        return ((Rating)arg1).isRated();
    }

    public static boolean isThumbUp(Object arg1) {
        return ((Rating)arg1).isThumbUp();
    }

    public static Object newHeartRating(boolean arg1) {
        return Rating.newHeartRating(arg1);
    }

    public static Object newPercentageRating(float arg1) {
        return Rating.newPercentageRating(arg1);
    }

    public static Object newStarRating(int arg1, float arg2) {
        return Rating.newStarRating(arg1, arg2);
    }

    public static Object newThumbRating(boolean arg1) {
        return Rating.newThumbRating(arg1);
    }

    public static Object newUnratedRating(int arg1) {
        return Rating.newUnratedRating(arg1);
    }
}

