package fr.dut.tp2.andrawid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import fr.dut.tp2.andrawid.path.Path;
import fr.dut.tp2.andrawid.path.Point;

public class CursiveShape implements DrawableShape {
    private final Path path;

    public CursiveShape(Path path) {
        this.path = path;
    }

    public CursiveShape(float[] coords) {
        path = Path.fromCoords(coords);
    }

    @Override
    public void drawShape(float startX, float startY, float stopX, float stopY, Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.rgb(112, 14, 27));
        paint.setStyle(Paint.Style.STROKE);
        Point[] p = path.getArray().toArray(new Point[0]);
        for (int i = 1; i < p.length; i++)
            canvas.drawLine(p[i - 1].getX(), p[i - 1].getY(), p[i].getX(), p[i].getY(), paint);
    }

    @Override
    public ShapeKind getType() {
        return ShapeKind.CURSIVE;
    }

    public Path getPath(){
        return path;
    }
}
