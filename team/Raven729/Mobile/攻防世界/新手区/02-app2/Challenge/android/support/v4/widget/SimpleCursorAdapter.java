package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.RestrictTo$Scope;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor arg1);
    }

    public interface ViewBinder {
        boolean setViewValue(View arg1, Cursor arg2, int arg3);
    }

    private CursorToStringConverter mCursorToStringConverter;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    @RestrictTo(value={Scope.LIBRARY_GROUP}) protected int[] mTo;
    private ViewBinder mViewBinder;

    @Deprecated public SimpleCursorAdapter(Context arg2, int arg3, Cursor arg4, String[] arg5, int[] arg6) {
        super(arg2, arg3, arg4);
        this.mStringConversionColumn = -1;
        this.mTo = arg6;
        this.mOriginalFrom = arg5;
        this.findColumns(arg4, arg5);
    }

    public SimpleCursorAdapter(Context arg2, int arg3, Cursor arg4, String[] arg5, int[] arg6, int arg7) {
        super(arg2, arg3, arg4, arg7);
        this.mStringConversionColumn = -1;
        this.mTo = arg6;
        this.mOriginalFrom = arg5;
        this.findColumns(arg4, arg5);
    }

    public void bindView(View arg10, Context arg11, Cursor arg12) {
        ViewBinder v4 = this.mViewBinder;
        int v5 = this.mTo.length;
        int[] v6 = this.mFrom;
        int[] v7 = this.mTo;
        int v3;
        for(v3 = 0; v3 < v5; ++v3) {
            View v0 = arg10.findViewById(v7[v3]);
            if(v0 != null) {
                boolean v1 = v4 != null ? v4.setViewValue(v0, arg12, v6[v3]) : false;
                if(v1) {
                    goto label_22;
                }

                String v1_1 = arg12.getString(v6[v3]);
                if(v1_1 == null) {
                    v1_1 = "";
                }

                if((v0 instanceof TextView)) {
                    this.setViewText(((TextView)v0), v1_1);
                    goto label_22;
                }

                if((v0 instanceof ImageView)) {
                    this.setViewImage(((ImageView)v0), v1_1);
                    goto label_22;
                }

                throw new IllegalStateException(v0.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
            }

        label_22:
        }
    }

    public void changeCursorAndColumns(Cursor arg2, String[] arg3, int[] arg4) {
        this.mOriginalFrom = arg3;
        this.mTo = arg4;
        this.findColumns(arg2, this.mOriginalFrom);
        super.changeCursor(arg2);
    }

    public CharSequence convertToString(Cursor arg3) {
        CharSequence v0;
        if(this.mCursorToStringConverter != null) {
            v0 = this.mCursorToStringConverter.convertToString(arg3);
        }
        else if(this.mStringConversionColumn > -1) {
            String v0_1 = arg3.getString(this.mStringConversionColumn);
        }
        else {
            v0 = super.convertToString(arg3);
        }

        return v0;
    }

    private void findColumns(Cursor arg5, String[] arg6) {
        if(arg5 != null) {
            int v1 = arg6.length;
            if(this.mFrom == null || this.mFrom.length != v1) {
                this.mFrom = new int[v1];
            }

            int v0;
            for(v0 = 0; v0 < v1; ++v0) {
                this.mFrom[v0] = arg5.getColumnIndexOrThrow(arg6[v0]);
            }
        }
        else {
            this.mFrom = null;
        }
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter arg1) {
        this.mCursorToStringConverter = arg1;
    }

    public void setStringConversionColumn(int arg1) {
        this.mStringConversionColumn = arg1;
    }

    public void setViewBinder(ViewBinder arg1) {
        this.mViewBinder = arg1;
    }

    public void setViewImage(ImageView arg2, String arg3) {
        try {
            arg2.setImageResource(Integer.parseInt(arg3));
        }
        catch(NumberFormatException v0) {
            arg2.setImageURI(Uri.parse(arg3));
        }
    }

    public void setViewText(TextView arg1, String arg2) {
        arg1.setText(((CharSequence)arg2));
    }

    public Cursor swapCursor(Cursor arg2) {
        this.findColumns(arg2, this.mOriginalFrom);
        return super.swapCursor(arg2);
    }
}

