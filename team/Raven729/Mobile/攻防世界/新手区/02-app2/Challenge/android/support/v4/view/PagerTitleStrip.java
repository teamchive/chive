package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils$TruncateAt;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@DecorView public class PagerTitleStrip extends ViewGroup {
    class PageListener extends DataSetObserver implements OnAdapterChangeListener, OnPageChangeListener {
        private int mScrollState;

        PageListener(PagerTitleStrip arg1) {
            PagerTitleStrip.this = arg1;
            super();
        }

        public void onAdapterChanged(ViewPager arg2, PagerAdapter arg3, PagerAdapter arg4) {
            PagerTitleStrip.this.updateAdapter(arg3, arg4);
        }

        public void onChanged() {
            float v0 = 0f;
            PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            if(PagerTitleStrip.this.mLastKnownPositionOffset >= 0f) {
                v0 = PagerTitleStrip.this.mLastKnownPositionOffset;
            }

            PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), v0, true);
        }

        public void onPageScrollStateChanged(int arg1) {
            this.mScrollState = arg1;
        }

        public void onPageScrolled(int arg3, float arg4, int arg5) {
            if(arg4 > 0.5f) {
                ++arg3;
            }

            PagerTitleStrip.this.updateTextPositions(arg3, arg4, false);
        }

        public void onPageSelected(int arg5) {
            float v0 = 0f;
            if(this.mScrollState == 0) {
                PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                if(PagerTitleStrip.this.mLastKnownPositionOffset >= 0f) {
                    v0 = PagerTitleStrip.this.mLastKnownPositionOffset;
                }

                PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), v0, true);
            }
        }
    }

    interface PagerTitleStripImpl {
        void setSingleLineAllCaps(TextView arg1);
    }

    class PagerTitleStripImplBase implements PagerTitleStripImpl {
        PagerTitleStripImplBase() {
            super();
        }

        public void setSingleLineAllCaps(TextView arg1) {
            arg1.setSingleLine();
        }
    }

    class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        PagerTitleStripImplIcs() {
            super();
        }

        public void setSingleLineAllCaps(TextView arg1) {
            PagerTitleStripIcs.setSingleLineAllCaps(arg1);
        }
    }

    private static final int[] ATTRS = null;
    private static final PagerTitleStripImpl IMPL = null;
    private static final float SIDE_ALPHA = 0.6f;
    private static final String TAG = "PagerTitleStrip";
    private static final int[] TEXT_ATTRS = null;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference mWatchingAdapter;

    static {
        PagerTitleStrip.ATTRS = new int[]{0x1010034, 0x1010095, 0x1010098, 0x10100AF};
        PagerTitleStrip.TEXT_ATTRS = new int[]{0x101038C};
        PagerTitleStrip.IMPL = Build$VERSION.SDK_INT >= 14 ? new PagerTitleStripImplIcs() : new PagerTitleStripImplBase();
    }

    public PagerTitleStrip(Context arg2) {
        this(arg2, null);
    }

    public PagerTitleStrip(Context arg6, AttributeSet arg7) {
        int v4 = 2;
        boolean v0 = false;
        super(arg6, arg7);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1f;
        this.mPageListener = new PageListener(this);
        TextView v1 = new TextView(arg6);
        this.mPrevText = v1;
        this.addView(((View)v1));
        v1 = new TextView(arg6);
        this.mCurrText = v1;
        this.addView(((View)v1));
        v1 = new TextView(arg6);
        this.mNextText = v1;
        this.addView(((View)v1));
        TypedArray v1_1 = arg6.obtainStyledAttributes(arg7, PagerTitleStrip.ATTRS);
        int v2 = v1_1.getResourceId(0, 0);
        if(v2 != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, v2);
            TextViewCompat.setTextAppearance(this.mCurrText, v2);
            TextViewCompat.setTextAppearance(this.mNextText, v2);
        }

        int v3 = v1_1.getDimensionPixelSize(1, 0);
        if(v3 != 0) {
            this.setTextSize(0, ((float)v3));
        }

        if(v1_1.hasValue(v4)) {
            v3 = v1_1.getColor(v4, 0);
            this.mPrevText.setTextColor(v3);
            this.mCurrText.setTextColor(v3);
            this.mNextText.setTextColor(v3);
        }

        this.mGravity = v1_1.getInteger(3, 80);
        v1_1.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        this.setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils$TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils$TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils$TruncateAt.END);
        if(v2 != 0) {
            v1_1 = arg6.obtainStyledAttributes(v2, PagerTitleStrip.TEXT_ATTRS);
            v0 = v1_1.getBoolean(0, false);
            v1_1.recycle();
        }

        if(v0) {
            PagerTitleStrip.setSingleLineAllCaps(this.mPrevText);
            PagerTitleStrip.setSingleLineAllCaps(this.mCurrText);
            PagerTitleStrip.setSingleLineAllCaps(this.mNextText);
        }
        else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }

        this.mScaledTextSpacing = ((int)(arg6.getResources().getDisplayMetrics().density * 16f));
    }

    int getMinHeight() {
        int v0 = 0;
        Drawable v1 = this.getBackground();
        if(v1 != null) {
            v0 = v1.getIntrinsicHeight();
        }

        return v0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    protected void onAttachedToWindow() {
        Object v0_1;
        super.onAttachedToWindow();
        ViewParent v0 = this.getParent();
        if(!(v0 instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }

        PagerAdapter v1 = ((ViewPager)v0).getAdapter();
        ((ViewPager)v0).setInternalPageChangeListener(this.mPageListener);
        ((ViewPager)v0).addOnAdapterChangeListener(this.mPageListener);
        this.mPager = ((ViewPager)v0);
        if(this.mWatchingAdapter != null) {
            v0_1 = this.mWatchingAdapter.get();
        }
        else {
            PagerAdapter v0_2 = null;
        }

        this.updateAdapter(((PagerAdapter)v0_1), v1);
    }

    protected void onDetachedFromWindow() {
        PagerAdapter v2 = null;
        super.onDetachedFromWindow();
        if(this.mPager != null) {
            this.updateAdapter(this.mPager.getAdapter(), v2);
            this.mPager.setInternalPageChangeListener(((OnPageChangeListener)v2));
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = ((ViewPager)v2);
        }
    }

    protected void onLayout(boolean arg4, int arg5, int arg6, int arg7, int arg8) {
        float v0 = 0f;
        if(this.mPager != null) {
            if(this.mLastKnownPositionOffset >= 0f) {
                v0 = this.mLastKnownPositionOffset;
            }

            this.updateTextPositions(this.mLastKnownCurrentPage, v0, true);
        }
    }

    protected void onMeasure(int arg8, int arg9) {
        int v6 = 0x40000000;
        int v5 = -2;
        if(View$MeasureSpec.getMode(arg8) != v6) {
            throw new IllegalStateException("Must measure with an exact width");
        }

        int v0 = this.getPaddingTop() + this.getPaddingBottom();
        int v1 = PagerTitleStrip.getChildMeasureSpec(arg9, v0, v5);
        int v2 = View$MeasureSpec.getSize(arg8);
        int v3 = PagerTitleStrip.getChildMeasureSpec(arg8, ((int)((((float)v2)) * 0.2f)), v5);
        this.mPrevText.measure(v3, v1);
        this.mCurrText.measure(v3, v1);
        this.mNextText.measure(v3, v1);
        v0 = View$MeasureSpec.getMode(arg9) == v6 ? View$MeasureSpec.getSize(arg9) : Math.max(this.getMinHeight(), v0 + this.mCurrText.getMeasuredHeight());
        this.setMeasuredDimension(v2, ViewCompat.resolveSizeAndState(v0, arg9, ViewCompat.getMeasuredState(this.mCurrText) << 16));
    }

    public void requestLayout() {
        if(!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int arg1) {
        this.mGravity = arg1;
        this.requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from=0, to=1) float arg4) {
        this.mNonPrimaryAlpha = (((int)(255f * arg4))) & 0xFF;
        int v0 = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(v0);
        this.mNextText.setTextColor(v0);
    }

    private static void setSingleLineAllCaps(TextView arg1) {
        PagerTitleStrip.IMPL.setSingleLineAllCaps(arg1);
    }

    public void setTextColor(@ColorInt int arg4) {
        this.mTextColor = arg4;
        this.mCurrText.setTextColor(arg4);
        int v0 = this.mNonPrimaryAlpha << 24 | this.mTextColor & 0xFFFFFF;
        this.mPrevText.setTextColor(v0);
        this.mNextText.setTextColor(v0);
    }

    public void setTextSize(int arg2, float arg3) {
        this.mPrevText.setTextSize(arg2, arg3);
        this.mCurrText.setTextSize(arg2, arg3);
        this.mNextText.setTextSize(arg2, arg3);
    }

    public void setTextSpacing(int arg1) {
        this.mScaledTextSpacing = arg1;
        this.requestLayout();
    }

    void updateAdapter(PagerAdapter arg2, PagerAdapter arg3) {
        if(arg2 != null) {
            arg2.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }

        if(arg3 != null) {
            arg3.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference(arg3);
        }

        if(this.mPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1f;
            this.updateText(this.mPager.getCurrentItem(), arg3);
            this.requestLayout();
        }
    }

    void updateText(int arg7, PagerAdapter arg8) {
        int v5 = 0x80000000;
        CharSequence v3 = null;
        int v0 = arg8 != null ? arg8.getCount() : 0;
        this.mUpdatingText = true;
        CharSequence v2 = arg7 < 1 || arg8 == null ? v3 : arg8.getPageTitle(arg7 - 1);
        this.mPrevText.setText(v2);
        TextView v4 = this.mCurrText;
        v2 = arg8 == null || arg7 >= v0 ? v3 : arg8.getPageTitle(arg7);
        v4.setText(v2);
        if(arg7 + 1 < v0 && arg8 != null) {
            v3 = arg8.getPageTitle(arg7 + 1);
        }

        this.mNextText.setText(v3);
        v0 = View$MeasureSpec.makeMeasureSpec(Math.max(0, ((int)((((float)(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()))) * 0.8f))), v5);
        int v2_1 = View$MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), v5);
        this.mPrevText.measure(v0, v2_1);
        this.mCurrText.measure(v0, v2_1);
        this.mNextText.measure(v0, v2_1);
        this.mLastKnownCurrentPage = arg7;
        if(!this.mUpdatingPositions) {
            this.updateTextPositions(arg7, this.mLastKnownPositionOffset, false);
        }

        this.mUpdatingText = false;
    }

    void updateTextPositions(int arg19, float arg20, boolean arg21) {
        if(arg19 != this.mLastKnownCurrentPage) {
            this.updateText(arg19, this.mPager.getAdapter());
            goto label_10;
        }
        else if(arg21) {
        label_10:
            this.mUpdatingPositions = true;
            int v5 = this.mPrevText.getMeasuredWidth();
            int v3 = this.mCurrText.getMeasuredWidth();
            int v6 = this.mNextText.getMeasuredWidth();
            int v2 = v3 / 2;
            int v7 = this.getWidth();
            int v4 = this.getHeight();
            int v8 = this.getPaddingLeft();
            int v9 = this.getPaddingRight();
            int v10 = this.getPaddingTop();
            int v11 = this.getPaddingBottom();
            int v13 = v9 + v2;
            int v12 = v7 - (v8 + v2) - v13;
            float v2_1 = 0.5f + arg20;
            if(v2_1 > 1f) {
                --v2_1;
            }

            v12 = v7 - v13 - (((int)(v2_1 * (((float)v12))))) - v3 / 2;
            v13 = v12 + v3;
            v2 = this.mPrevText.getBaseline();
            v3 = this.mCurrText.getBaseline();
            int v14 = this.mNextText.getBaseline();
            int v15 = Math.max(Math.max(v2, v3), v14);
            v2 = v15 - v2;
            v3 = v15 - v3;
            v14 = v15 - v14;
            v15 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + v2, this.mCurrText.getMeasuredHeight() + v3), this.mNextText.getMeasuredHeight() + v14);
            switch(this.mGravity & 0x70) {
                case 16: {
                    v10 = (v4 - v10 - v11 - v15) / 2;
                    v4 = v10 + v2;
                    v3 += v10;
                    v2 = v10 + v14;
                    break;
                }
                case 80: {
                    v10 = v4 - v11 - v15;
                    v4 = v10 + v2;
                    v3 += v10;
                    v2 = v10 + v14;
                    break;
                }
                default: {
                    v4 = v10 + v2;
                    v3 += v10;
                    v2 = v10 + v14;
                    break;
                }
            }

            this.mCurrText.layout(v12, v3, v13, this.mCurrText.getMeasuredHeight() + v3);
            v3 = Math.min(v8, v12 - this.mScaledTextSpacing - v5);
            this.mPrevText.layout(v3, v4, v5 + v3, this.mPrevText.getMeasuredHeight() + v4);
            v3 = Math.max(v7 - v9 - v6, this.mScaledTextSpacing + v13);
            this.mNextText.layout(v3, v2, v3 + v6, this.mNextText.getMeasuredHeight() + v2);
            this.mLastKnownPositionOffset = arg20;
            this.mUpdatingPositions = false;
        }
        else if(arg20 == this.mLastKnownPositionOffset) {
        }
        else {
            goto label_10;
        }
    }
}

