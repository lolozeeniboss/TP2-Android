package fr.dut.tp2.andrawid.export;

import android.util.Log;

import fr.dut.tp2.andrawid.ShapeContainer;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;

public class ExportJson implements DrawingIO {


    @Override
    public void save(ShapeContainer container, OutputStream output) {
        JSONObject object = new JSONObject();
        try {
            object.put("type","drawing");
            object.put("formatVersion","1.0");
            object.put("modificationDate","20180317T141510Z");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        System.out.println(object);
        Log.println(Log.DEBUG,"",object.toString());
    }

    @Override
    public ShapeContainer load(InputStream input) {
        return null;
    }
}
