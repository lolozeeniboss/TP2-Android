package fr.dut.tp2.andrawid.export;

import fr.dut.tp2.andrawid.ShapeContainer;

import java.io.InputStream;
import java.io.OutputStream;

public interface DrawingIO{
    public void save(ShapeContainer container, OutputStream output);
    public ShapeContainer load(InputStream input);
}