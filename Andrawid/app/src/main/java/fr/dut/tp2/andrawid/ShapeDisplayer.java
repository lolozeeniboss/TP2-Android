package fr.dut.tp2.andrawid;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ShapeDisplayer extends View {

    private ShapeContainer model;

    public ShapeDisplayer(Context context) {
        super(context);
    }

    public ShapeDisplayer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShapeDisplayer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShapeDisplayer(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setModel (ShapeContainer shapeContainer){
        this.model = shapeContainer;
        this.invalidate();
        ShapeContainerChangeListener listener = this::invalidate;
        model.addChangeListener(listener);
    }

    @Override
    public void onDraw (Canvas canvas){
        if(model != null){
            model.draw(canvas);
        }
    }

}
