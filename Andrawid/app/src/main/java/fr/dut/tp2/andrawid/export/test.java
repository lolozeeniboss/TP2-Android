package fr.dut.tp2.andrawid.export;


import android.graphics.Path;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import fr.dut.tp2.andrawid.ShapeContainer;



public class test {
    public static void export (ShapeContainer container) {

        File docPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File appPath = new File(docPath, "andrawid");
        appPath.mkdir();
        System.out.println("appPath Exist: "+appPath.exists());
        File fichier=null;
        try {
            fichier = new File(appPath,System.currentTimeMillis()+".json");
            System.out.println(fichier.getCanonicalFile().toString());
            fichier.createNewFile();
            System.out.println("fichierPath Exist: "+fichier.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream output = null;
        try {
             output = new FileOutputStream(fichier.getCanonicalPath().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ExportJson export = new ExportJson();
        //OutputStream output =
            export.save(container, output);




        DrawingBitmapExporter bitmapExporter = new DrawingBitmapExporter();

        try {
            fichier = new File(appPath,System.currentTimeMillis()+".jpeg");
            System.out.println(fichier.getCanonicalFile().toString());
            fichier.createNewFile();
            System.out.println("fichierPath Exist: "+fichier.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output = new FileOutputStream(fichier.getCanonicalPath().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmapExporter.save(container,output);












    }
}
