package com.extensions.gradient; 

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

@DesignerComponent(version = 1,
                   category = ComponentCategory.EXTENSION,
                   description = "",
                   nonVisible = true,
                   iconName = "")

@SimpleObject(external = true)

public class Gradient extends AndroidNonvisibleComponent {
    
    public Gradient(ComponentContainer container) {
        super(container.$form());
    }
    
    @SimpleFunction(description = "")
    public void SetGradientBackground(AndroidViewComponent component, Object orientation, int color1, int color2) {
        try {
            View view = component.getView();
            GradientDrawable gradientDrawable = new GradientDrawable(
                (GradientDrawable.Orientation) orientation,
                new int[] {color1, color2}
            );
    
            view.setBackground(gradientDrawable);
        } 
        catch(Exception e) {
            ErrorOccured(e.getMessage());
        }        
    }

    @SimpleEvent(description = "")
    public void ErrorOccured(String error) {
        EventDispatcher.dispatchEvent(this, "ErrorOccured", error);
    }
    
    @SimpleProperty(description = "")
    public Object TopToBottom() {
        return GradientDrawable.Orientation.TOP_BOTTOM;
    }

    @SimpleProperty(description = "")
    public Object LeftToRight() {
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    @SimpleProperty(description = "")
    public Object BottomToTop() {
        return GradientDrawable.Orientation.BOTTOM_TOP;
    }

    @SimpleProperty(description = "")
    public Object RightToLeft() {
        return GradientDrawable.Orientation.RIGHT_LEFT;
    }

    @SimpleProperty(description = "")
    public Object BottomLeftToTopRight() {
        return GradientDrawable.Orientation.BL_TR;
    }

    @SimpleProperty(description = "")
    public Object TopLeftToBottomRight() {
        return GradientDrawable.Orientation.TL_BR;
    }

    @SimpleProperty(description = "")
    public Object TopRightToBottomLeft() {
        return GradientDrawable.Orientation.TR_BL;
    }

    @SimpleProperty(description = "")
    public Object BottomRightToTopLeft() {
        return GradientDrawable.Orientation.BR_TL;
    }

    @SimpleFunction(description = "")
    public int ParseColor(String color) {
        return Color.parseColor(color);
    }
}