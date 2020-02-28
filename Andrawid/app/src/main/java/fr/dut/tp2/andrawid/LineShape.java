package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineShape implements DrawableShape {

    @Override
    public void drawShape(float startX, float startY, float stopX, float stopY, Canvas canvas) {
        System.out.println("startX: " + startX);
        System.out.println("startY: " + startY);
        System.out.println("stopX: " + stopX);
        System.out.println("stopY: " + stopY);
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.rgb(255, 192, 203));
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    @Override
    public ShapeKind getType() {
        return ShapeKind.SEGMENT;
    }
}
