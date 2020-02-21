package fr.dut.tp2.andrawid.export;

import java.util.HashMap;
import java.util.Map;

class ShapeContainer {
    private final Map<DrawableShape, Place> map;

    public ShapeContainer(Map<DrawableShape, Place> map) {
        this.map = map;
    }
    public ShapeContainer() {
        map = new HashMap<>();
    }

    public Map<DrawableShape, Place> getMap(){
        return map;
    }

    public void add(DrawableShape shape, Place place){
        map.put(shape,place);
    }
}
