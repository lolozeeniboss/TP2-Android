package fr.dut.tp2.andrawid;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShapeContainer {
    private final Map<DrawableShape, Place> map;
    private ArrayList<ShapeContainerChangeListener> changeListeners = new ArrayList<>();

    public ShapeContainer(Map<DrawableShape, Place> map) {
        this.map = map;
    }

    public ShapeContainer() {
        map = new HashMap<>();
    }

    public Map<DrawableShape, Place> getMap() {
        return map;
    }

    public boolean add(DrawableShape shape, Place place) {
        if (map.containsKey(shape)) {
            return false;
        }
        map.put(shape, place);
        return true;
    }

    public void addChangeListener(ShapeContainerChangeListener listener) {
        this.changeListeners.add(listener);
    }

    public void removeChangeListener(ShapeContainerChangeListener listener) {
        changeListeners = null;
    }

    public void draw(Canvas canvas) {
        for (Map.Entry<DrawableShape, Place> entry : map.entrySet()) {
            DrawableShape key = entry.getKey();
            Place value = entry.getValue();
            key.drawShape(value.getLeft(), value.getTop(), value.getRight(), value.getBottom(), canvas);
        }
    }

    public void fireListeners() {
        for (ShapeContainerChangeListener listener : changeListeners)
            listener.onShapeContainerChange();
    }
}
