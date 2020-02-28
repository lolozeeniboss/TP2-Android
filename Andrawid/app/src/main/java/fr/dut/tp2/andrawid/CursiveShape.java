package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class CursiveShape implements DrawableShape {
    private final Path path;

    public CursiveShape(Path path) {
        this.path = path;
    }

    public CursiveShape(float[] coords) {
        //WIP
        path = new Path();
    }

    @Override
    public void drawShape(float startX, float startY, float stopX, float stopY, Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.rgb(112, 14, 27));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
    }

    @Override
    public ShapeKind getType() {
        return ShapeKind.CURSIVE;
    }
}
