package fr.dut.tp2.andrawid;

import android.util.Pair;

public class ShapeBuilder {
    private ShapeKind shapeKind = ShapeKind.SEGMENT;

    /**
     * to set the current kind of shape to create
     */
    public void setShapeKind(ShapeKind shapeKind) {
        this.shapeKind = shapeKind;
    }

    /**
     * to build a shape
     * * @param coords coordinates of the shape:
     * coords[0] and coords[1] are the x and y of the start of the shape
     * coords[coords.length-2] and coords[coords.length-1] are the x and y of the end of the shape
     * some shape kinds (like CURSIVE) may admit intermediate points in the array
     */
    public Pair<DrawableShape, Place> build(float[] coords) {
        float startX, startY, stopX, stopY;
        startX = coords[0];
        startY = coords[1];
        stopX = coords[coords.length - 2];
        stopY = coords[coords.length - 1];
        Place place = new Place(startX, startY, stopX, stopY);
        DrawableShape shape;
        if (shapeKind == ShapeKind.CURSIVE) {
            shape = new CursiveShape(coords);
        } else if (shapeKind == ShapeKind.RECTANGLE) {
            shape = new RectangleShape();
        } else {
            shape = new LineShape();
        }
        return new Pair<>(shape, place);
    }

}
