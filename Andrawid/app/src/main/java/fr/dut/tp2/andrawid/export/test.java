package fr.dut.tp2.andrawid.export;


import android.graphics.Path;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import fr.dut.tp2.andrawid.ShapeContainer;



public class test {
    public static void export (ShapeContainer container) {
        ExportJson export = new ExportJson();

            export.save(container, null);


    }
}
