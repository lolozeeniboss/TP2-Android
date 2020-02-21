package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class RectangleShape implements DrawableShape {


    @Override
    public void drawShape(float left, float top, float right, float bottom, Canvas canvas) {
        Rect r = new Rect(((int)left), ((int)top), ((int)right), ((int)bottom));
        canvas.drawRect(r, new Paint());
    }
}
