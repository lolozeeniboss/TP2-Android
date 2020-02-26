package fr.dut.tp2.andrawid;

import android.annotation.SuppressLint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.dut.tp2.andrawid.export.test;

public class MainActivity extends AppCompatActivity {
    private ShapeKind selectedShapeKind;
    private float startX;
    private float startY;
    private Path cursivePath;
    private boolean flag = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShapeDisplayer view = findViewById(R.id.ShapeDisplayer);
        ShapeContainer container = new ShapeContainer();
        view.setModel(container);
        view.setOnTouchListener((v, event) -> {
            int e = event.getActionMasked();
            if (MotionEvent.ACTION_DOWN == e) {
                cursivePath =  new Path();
                startX = event.getX();
                startY = event.getY();
                return true;
            } else if (MotionEvent.ACTION_UP == e) {
                flag = true;
                DrawableShape shape = new CursiveShape(cursivePath);
                //cursivePath.close();
                Place place = new Place(startX, startY, event.getX(), event.getY());
                System.out.println("startX: " + startX);
                System.out.println("startY: " + startY);
                System.out.println("stopX: " + event.getX());
                System.out.println("stopY: " + event.getX());
                container.add(shape, place);
                return true;
            } else if (MotionEvent.ACTION_MOVE == e) {
                //if du selecteur de formes pour executer le code qui suit que pour la forme cursive
                if (flag) {
                    cursivePath.moveTo(event.getX(), event.getY());
                    flag = false;
                } else {
                    cursivePath.lineTo(event.getX(), event.getY());
                }


                return true;
            }
            return false;
        });
        test.export();
    }


}
