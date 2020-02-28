package fr.dut.tp2.andrawid.export;

import android.graphics.Bitmap;
import android.view.Display;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import fr.dut.tp2.andrawid.DrawableShape;
import fr.dut.tp2.andrawid.Place;
import fr.dut.tp2.andrawid.ShapeContainer;

public class DrawingBitmapExporter implements DrawingIO{

    @Override
    public void save(ShapeContainer container, OutputStream output) {
        int offsetx = 0;
        int offsety = 0;
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
