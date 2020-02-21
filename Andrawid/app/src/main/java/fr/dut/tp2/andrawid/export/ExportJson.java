package fr.dut.tp2.andrawid.export;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;

public class ExportJson implements DrawingIO {


    @Override
    public void save(ShapeContainer container, OutputStream output) {
        JSONObject object = new JSONObject(container.getMap());
        System.out.println(object);
    }

    @Override
    public ShapeContainer load(InputStream input) {
        return null;
    }
}
