package fr.dut.tp2.andrawid.export;

import android.util.JsonReader;
import android.util.Log;

import fr.dut.tp2.andrawid.CursiveShape;
import fr.dut.tp2.andrawid.DrawableShape;
import fr.dut.tp2.andrawid.Place;
import fr.dut.tp2.andrawid.ShapeContainer;
import fr.dut.tp2.andrawid.ShapeKind;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class ExportJson implements DrawingIO {


    @Override
    public void save(ShapeContainer container, OutputStream output) {
        JSONObject object = new JSONObject();
        try {
            object.put("type","drawing");
            object.put("formatVersion","1.0");
            object.put("modificationDate",System.currentTimeMillis());
            JSONArray arrayJson = new JSONArray();
            for (Map.Entry<DrawableShape, Place> entry : container.getMap().entrySet()){
                JSONObject j = new JSONObject();
                j.put("shapeKind",entry.getKey().getType());
                JSONArray array2 = new JSONArray();
                array2.put(entry.getValue().getLeft());
                array2.put(entry.getValue().getTop());
                array2.put(entry.getValue().getRight());
                array2.put(entry.getValue().getBottom());
                j.put("place",array2);


                /*
                if(entry.getKey().getType().equals(ShapeKind.CURSIVE)){
                    CursiveShape curse = (CursiveShape)entry.getKey();
                    JSONArray array3 = new JSONArray();
                    for(float f : curse.getPath().approximate()){

                    }
                    array3.put();
                    j.put("intermediatePoints",curse.getPath().approximate());
                }
*/






                arrayJson.put(j);
            }
            object.put("objects",arrayJson);
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
