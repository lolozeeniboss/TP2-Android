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
        Path p = new Path();
        File docPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File appPath = new File(docPath, "andrawid");
// the directory appPath may not exist yet, we can create it
        appPath.mkdir();
        try {
            export.save(container, new FileOutputStream("./save.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
