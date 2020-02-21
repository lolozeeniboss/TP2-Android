package fr.dut.tp2.andrawid;

import android.view.Display;

public class Place {
    private final float x1;
    private final float y1;
    private final float x2;
    private final float y2;



    Place(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float getLeft() {
        return x1;
    }

    public float getTop() {
        return y1;
    }

    public float getRight() {
        return x2;
    }

    public float getBottom() {
        return y2;
    }
}
