package fr.dut.tp2.andrawid.export;

import java.io.IOException;
import java.io.OutputStream;

public class test {
    public static void main (String[] args) {
        ShapeContainer container = new ShapeContainer();
        container.add(new DrawableShape("Forme1"), new Place(1,1,));
        container.add(new DrawableShape("Forme2"), new Place(2,2,));
        container.add(new DrawableShape("Forme3"), new Place(3,3,));
        container.add(new DrawableShape("Forme4"), new Place(4,4,));
        container.add(new DrawableShape("Forme5"), new Place(5,5,));
        ExportJson export = new ExportJson();
        export.save(container, new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });

    }
}
