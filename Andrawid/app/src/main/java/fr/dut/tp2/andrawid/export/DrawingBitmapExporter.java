package fr.dut.tp2.andrawid.export;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import fr.dut.tp2.andrawid.DrawableShape;
import fr.dut.tp2.andrawid.Place;
import fr.dut.tp2.andrawid.R;
import fr.dut.tp2.andrawid.ShapeContainer;
import fr.dut.tp2.andrawid.ShapeDisplayer;

public class DrawingBitmapExporter implements DrawingIO{

    public static Bitmap img;

    @Override
    public void save(ShapeContainer container, OutputStream output) {

        img.compress(Bitmap.CompressFormat.JPEG,100,output);




    }

    @Override
    public ShapeContainer load(InputStream input) {
        try {
            throw new Exception("Cannot load BitmapValue");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
