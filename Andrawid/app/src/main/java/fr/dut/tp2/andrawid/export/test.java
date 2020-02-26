package fr.dut.tp2.andrawid.export;

import fr.dut.tp2.andrawid.DrawableShape;
import fr.dut.tp2.andrawid.LineShape;
import fr.dut.tp2.andrawid.Place;
import fr.dut.tp2.andrawid.ShapeContainer;

import java.io.IOException;
import java.io.OutputStream;

public class test {
    public static void export (ShapeContainer container) {
        ExportJson export = new ExportJson();
        export.save(container, null);

    }
}
