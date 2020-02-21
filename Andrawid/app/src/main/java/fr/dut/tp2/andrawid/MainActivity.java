package fr.dut.tp2.andrawid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.dut.tp2.andrawid.export.test;

public class MainActivity extends AppCompatActivity {
    private ShapeKind selectedShapeKind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test.export();
    }
}
