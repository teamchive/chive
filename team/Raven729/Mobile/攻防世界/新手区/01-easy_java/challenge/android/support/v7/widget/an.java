package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class an extends Resources {
    private final Resources a;

    public an(Resources arg4) {
        super(arg4.getAssets(), arg4.getDisplayMetrics(), arg4.getConfiguration());
        this.a = arg4;
    }

    public XmlResourceParser getAnimation(int arg2) {
        return this.a.getAnimation(arg2);
    }

    public boolean getBoolean(int arg2) {
        return this.a.getBoolean(arg2);
    }

    public int getColor(int arg2) {
        return this.a.getColor(arg2);
    }

    public ColorStateList getColorStateList(int arg2) {
        return this.a.getColorStateList(arg2);
    }

    public Configuration getConfiguration() {
        return this.a.getConfiguration();
    }

    public float getDimension(int arg2) {
        return this.a.getDimension(arg2);
    }

    public int getDimensionPixelOffset(int arg2) {
        return this.a.getDimensionPixelOffset(arg2);
    }

    public int getDimensionPixelSize(int arg2) {
        return this.a.getDimensionPixelSize(arg2);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.a.getDisplayMetrics();
    }

    public Drawable getDrawable(int arg2) {
        return this.a.getDrawable(arg2);
    }

    public Drawable getDrawable(int arg2, Resources$Theme arg3) {
        return this.a.getDrawable(arg2, arg3);
    }

    public Drawable getDrawableForDensity(int arg2, int arg3) {
        return this.a.getDrawableForDensity(arg2, arg3);
    }

    public Drawable getDrawableForDensity(int arg2, int arg3, Resources$Theme arg4) {
        return this.a.getDrawableForDensity(arg2, arg3, arg4);
    }

    public float getFraction(int arg2, int arg3, int arg4) {
        return this.a.getFraction(arg2, arg3, arg4);
    }

    public int getIdentifier(String arg2, String arg3, String arg4) {
        return this.a.getIdentifier(arg2, arg3, arg4);
    }

    public int[] getIntArray(int arg2) {
        return this.a.getIntArray(arg2);
    }

    public int getInteger(int arg2) {
        return this.a.getInteger(arg2);
    }

    public XmlResourceParser getLayout(int arg2) {
        return this.a.getLayout(arg2);
    }

    public Movie getMovie(int arg2) {
        return this.a.getMovie(arg2);
    }

    public String getQuantityString(int arg2, int arg3) {
        return this.a.getQuantityString(arg2, arg3);
    }

    public String getQuantityString(int arg2, int arg3, Object[] arg4) {
        return this.a.getQuantityString(arg2, arg3, arg4);
    }

    public CharSequence getQuantityText(int arg2, int arg3) {
        return this.a.getQuantityText(arg2, arg3);
    }

    public String getResourceEntryName(int arg2) {
        return this.a.getResourceEntryName(arg2);
    }

    public String getResourceName(int arg2) {
        return this.a.getResourceName(arg2);
    }

    public String getResourcePackageName(int arg2) {
        return this.a.getResourcePackageName(arg2);
    }

    public String getResourceTypeName(int arg2) {
        return this.a.getResourceTypeName(arg2);
    }

    public String getString(int arg2) {
        return this.a.getString(arg2);
    }

    public String getString(int arg2, Object[] arg3) {
        return this.a.getString(arg2, arg3);
    }

    public String[] getStringArray(int arg2) {
        return this.a.getStringArray(arg2);
    }

    public CharSequence getText(int arg2) {
        return this.a.getText(arg2);
    }

    public CharSequence getText(int arg2, CharSequence arg3) {
        return this.a.getText(arg2, arg3);
    }

    public CharSequence[] getTextArray(int arg2) {
        return this.a.getTextArray(arg2);
    }

    public void getValue(int arg2, TypedValue arg3, boolean arg4) {
        this.a.getValue(arg2, arg3, arg4);
    }

    public void getValue(String arg2, TypedValue arg3, boolean arg4) {
        this.a.getValue(arg2, arg3, arg4);
    }

    public void getValueForDensity(int arg2, int arg3, TypedValue arg4, boolean arg5) {
        this.a.getValueForDensity(arg2, arg3, arg4, arg5);
    }

    public XmlResourceParser getXml(int arg2) {
        return this.a.getXml(arg2);
    }

    public TypedArray obtainAttributes(AttributeSet arg2, int[] arg3) {
        return this.a.obtainAttributes(arg2, arg3);
    }

    public TypedArray obtainTypedArray(int arg2) {
        return this.a.obtainTypedArray(arg2);
    }

    public InputStream openRawResource(int arg2) {
        return this.a.openRawResource(arg2);
    }

    public InputStream openRawResource(int arg2, TypedValue arg3) {
        return this.a.openRawResource(arg2, arg3);
    }

    public AssetFileDescriptor openRawResourceFd(int arg2) {
        return this.a.openRawResourceFd(arg2);
    }

    public void parseBundleExtra(String arg2, AttributeSet arg3, Bundle arg4) {
        this.a.parseBundleExtra(arg2, arg3, arg4);
    }

    public void parseBundleExtras(XmlResourceParser arg2, Bundle arg3) {
        this.a.parseBundleExtras(arg2, arg3);
    }

    public void updateConfiguration(Configuration arg2, DisplayMetrics arg3) {
        super.updateConfiguration(arg2, arg3);
        if(this.a != null) {
            this.a.updateConfiguration(arg2, arg3);
        }
    }
}

