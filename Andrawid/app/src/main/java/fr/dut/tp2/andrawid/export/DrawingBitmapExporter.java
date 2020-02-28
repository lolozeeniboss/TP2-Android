package fr.dut.tp2.andrawid.export;

import android.graphics.Bitmap;

import java.io.InputStream;
import java.io.OutputStream;

import fr.dut.tp2.andrawid.ShapeContainer;

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
