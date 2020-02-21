package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Paint;

public class LineShape implements DrawableShape {
    private final float startX;
    private final float startY;
    private final float stopX;
    private final float stopY;

    public LineShape(float startX, float startY, float stopX, float stopY) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
    }

    @Override
    public void drawShape(float left, float top, float right, float bottom, Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, new Paint());
    }
}
