package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;

public interface TintableBackgroundView {
    @Nullable ColorStateList getSupportBackgroundTintList();

    @Nullable PorterDuff$Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@Nullable ColorStateList arg1);

    void setSupportBackgroundTintMode(@Nullable PorterDuff$Mode arg1);
}

