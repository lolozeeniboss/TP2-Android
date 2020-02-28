package fr.dut.tp2.andrawid.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
    private ArrayList<Point> myPoints;

    public Path() {
        this.myPoints = new ArrayList<>();
    }

    private Path(ArrayList<Point> points) {
        this.myPoints = points;
    }

    public static Path fromCoords(float[] coords) {
        ArrayList<Point> p = new ArrayList<>();
        for (int i = 0; i < coords.length; i += 2) p.add(new Point(coords[i], coords[i + 1]));
        return new Path(p);
    }

    public void moveTo(Point point) {
        myPoints.add(0, point);
    }

    public void lineTo(Point point) {
        myPoints.add(point);
    }


    // j'ajoute des commentaire
    public List<Point> getArray() {
        return Collections.unmodifiableList(myPoints);
    }

    public float[] getFArray() {
        float[] coords = new float[0];
        for (Point p :
                myPoints) {
            float[] combo = {p.getX(), p.getY()};
            coords = concat(coords, combo);
        }
        return coords;
    }

    private float[] concat(float[] A, float[] B) {
        int aLen = A.length;
        int bLen = B.length;
        float[] C = new float[aLen + bLen];
        System.arraycopy(A, 0, C, 0, aLen);
        System.arraycopy(B, 0, C, aLen, bLen);
        return C;
    }

    @Override
    public String toString() {
        return "Path{" +
                "myPoints=" + myPoints +
                '}';
    }
}
