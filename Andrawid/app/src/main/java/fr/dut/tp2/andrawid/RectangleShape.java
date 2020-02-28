package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class RectangleShape implements DrawableShape {


    @Override
    public void drawShape(float startX, float startY, float stopX, float stopY, Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.rgb(0, 0, 128));
        paint.setStyle(Paint.Style.STROKE);
        Rect r = new Rect(((int)startX), ((int) startY), ((int) stopX), ((int) stopY));
        canvas.drawRect(r, paint);
    }

    @Override
    public ShapeKind getType() {
        return ShapeKind.RECTANGLE;
    }
}
