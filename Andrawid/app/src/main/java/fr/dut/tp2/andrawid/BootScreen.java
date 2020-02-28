package fr.dut.tp2.andrawid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BootScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_screen);
    }

    public void createClick(View v){
        Intent myIntent = new Intent(BootScreen.this, MainActivity.class);
        BootScreen.this.startActivity(myIntent);
    }

}
