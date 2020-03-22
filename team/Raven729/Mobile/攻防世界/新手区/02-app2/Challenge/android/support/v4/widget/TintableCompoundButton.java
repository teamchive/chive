package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;

public interface TintableCompoundButton {
    @Nullable ColorStateList getSupportButtonTintList();

    @Nullable PorterDuff$Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@Nullable ColorStateList arg1);

    void setSupportButtonTintMode(@Nullable PorterDuff$Mode arg1);
}

