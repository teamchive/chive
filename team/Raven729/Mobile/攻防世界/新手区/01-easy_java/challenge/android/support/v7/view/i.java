package android.support.v7.view;

import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i implements Window$Callback {
    final Window$Callback e;

    public i(Window$Callback arg3) {
        super();
        if(arg3 == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }

        this.e = arg3;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent arg2) {
        return this.e.dispatchGenericMotionEvent(arg2);
    }

    public boolean dispatchKeyEvent(KeyEvent arg2) {
        return this.e.dispatchKeyEvent(arg2);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent arg2) {
        return this.e.dispatchKeyShortcutEvent(arg2);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg2) {
        return this.e.dispatchPopulateAccessibilityEvent(arg2);
    }

    public boolean dispatchTouchEvent(MotionEvent arg2) {
        return this.e.dispatchTouchEvent(arg2);
    }

    public boolean dispatchTrackballEvent(MotionEvent arg2) {
        return this.e.dispatchTrackballEvent(arg2);
    }

    public void onActionModeFinished(ActionMode arg2) {
        this.e.onActionModeFinished(arg2);
    }

    public void onActionModeStarted(ActionMode arg2) {
        this.e.onActionModeStarted(arg2);
    }

    public void onAttachedToWindow() {
        this.e.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.e.onContentChanged();
    }

    public boolean onCreatePanelMenu(int arg2, Menu arg3) {
        return this.e.onCreatePanelMenu(arg2, arg3);
    }

    public View onCreatePanelView(int arg2) {
        return this.e.onCreatePanelView(arg2);
    }

    public void onDetachedFromWindow() {
        this.e.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        return this.e.onMenuItemSelected(arg2, arg3);
    }

    public boolean onMenuOpened(int arg2, Menu arg3) {
        return this.e.onMenuOpened(arg2, arg3);
    }

    public void onPanelClosed(int arg2, Menu arg3) {
        this.e.onPanelClosed(arg2, arg3);
    }

    public void onPointerCaptureChanged(boolean arg2) {
        this.e.onPointerCaptureChanged(arg2);
    }

    public boolean onPreparePanel(int arg2, View arg3, Menu arg4) {
        return this.e.onPreparePanel(arg2, arg3, arg4);
    }

    public void onProvideKeyboardShortcuts(List arg2, Menu arg3, int arg4) {
        this.e.onProvideKeyboardShortcuts(arg2, arg3, arg4);
    }

    public boolean onSearchRequested() {
        return this.e.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent arg2) {
        return this.e.onSearchRequested(arg2);
    }

    public void onWindowAttributesChanged(WindowManager$LayoutParams arg2) {
        this.e.onWindowAttributesChanged(arg2);
    }

    public void onWindowFocusChanged(boolean arg2) {
        this.e.onWindowFocusChanged(arg2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode$Callback arg2) {
        return this.e.onWindowStartingActionMode(arg2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode$Callback arg2, int arg3) {
        return this.e.onWindowStartingActionMode(arg2, arg3);
    }
}

