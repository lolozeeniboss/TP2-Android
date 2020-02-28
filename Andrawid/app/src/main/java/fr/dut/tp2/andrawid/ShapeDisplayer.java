package fr.dut.tp2.andrawid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import fr.dut.tp2.andrawid.export.DrawingBitmapExporter;

public class ShapeDisplayer extends View {

    private ShapeContainer model;
    private Canvas v;

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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        DrawingBitmapExporter.img = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        v = new Canvas(DrawingBitmapExporter.img);
        Paint paint2 = new Paint(); paint2.setColor(Color.WHITE);
        paint2.setStyle(Paint.Style.FILL);
        v.drawPaint(paint2);


    }

    @Override
    public void onDraw (Canvas canvas){

        if(model != null){
            model.draw(v);
            model.draw(canvas);
        }
    }

}
