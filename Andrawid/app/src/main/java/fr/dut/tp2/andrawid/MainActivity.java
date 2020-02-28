package fr.dut.tp2.andrawid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import fr.dut.tp2.andrawid.export.test;
import fr.dut.tp2.andrawid.path.Path;
import fr.dut.tp2.andrawid.path.Point;

public class MainActivity extends AppCompatActivity {
    private ShapeKind selectedShapeKind;
    private final ShapeBuilder shapeBuilder = new ShapeBuilder();
    private float startX;
    private float startY;
    private Path cursivePath;
    private boolean flag = true;
    private ShapeContainer container;
    private ShapeKind selectedShapekind = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShapeDisplayer view = findViewById(R.id.ShapeDisplayer);
        container = new ShapeContainer();
        view.setModel(container);

        GridView gv = (GridView) findViewById(R.id.shapePalette2);
        ArrayAdapter<ShapeKind> arrayAdapter = new ArrayAdapter<ShapeKind>(this, android.R.layout.simple_list_item_1, ShapeKind.values()) {
            public View getView(int position, android.view.View recycledView, ViewGroup parent)
            {
                android.view.View v = recycledView;
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (v == null) {
                    v = inflater.inflate(R.layout.item_view, null);
                }
                TextView textView = (TextView) v.findViewById(R.id.labelView);
                ImageView imageView = (ImageView) v.findViewById(R.id.imgView);
                imageView.setColorFilter(17170444);
                ShapeKind usedShapedKind = ShapeKind.values()[position];
                textView.setText(usedShapedKind.toString());
                imageView.setImageResource(usedShapedKind.getImage());
                return v;
            }
        };
        gv.setAdapter(arrayAdapter);
        gv.setOnItemClickListener( (adapterView, normalView, i, l) -> {
            selectedShapeKind = (ShapeKind) adapterView.getItemAtPosition(i);
            shapeBuilder.setShapeKind(selectedShapeKind);
        });

        //OnTouchListener
        view.setOnTouchListener((v, event) -> {
            int e = event.getActionMasked();
            if (MotionEvent.ACTION_DOWN == e) {
                cursivePath =  new Path();
                startX = event.getX();
                startY = event.getY();
                return true;
            } else if (MotionEvent.ACTION_UP == e) {
                flag = true;
                float[] coords = new float[4];
                ShapeBuilder shapeBuilder = new ShapeBuilder();
                coords[0] = startX;
                coords[1] = startY;
                coords[coords.length - 1] = event.getX();
                coords[coords.length - 2] = event.getY();
                Pair<DrawableShape, Place> res = shapeBuilder.build(coords, cursivePath);
                System.out.println(cursivePath);

                //DrawableShape shape = new CursiveShape(cursivePath);
                //cursivePath.close();
                //Place place = new Place(startX, startY, event.getX(), event.getY());

                /*System.out.println("startX: " + startX);
                System.out.println("startY: " + startY);
                System.out.println("stopX: " + event.getX());
                System.out.println("stopY: " + event.getX());*/
                container.add(res.first, res.second);
                return true;
            } else if (MotionEvent.ACTION_MOVE == e) {
                //if du selecteur de formes pour executer le code qui suit que pour la forme cursive
                if (flag) {
                    cursivePath.moveTo(new Point(event.getX(), event.getY()));
                    System.out.println("start =" + new Point(event.getX(), event.getY()));
                    flag = false;
                } else {
                    cursivePath.lineTo(new Point(event.getX(), event.getY()));
                    System.out.println("new =" + new Point(event.getX(), event.getY()));
                }
                return true;
            }
            return false;
        });
    }


    public void onSaveButtonClicked(View v) {
        test.export(container);
    }

}
