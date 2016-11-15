package com.discretegames.dave.scribble;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    int id = 0;

    DrawView drawView;
    DollarRecognizer dollarRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        //setSupportActionBar(toolbar);

        button  = (Button) findViewById(R.id.button1);

        button2  = (Button) findViewById(R.id.button2);

        button3  = (Button) findViewById(R.id.button3);

       // drawView = new DrawView(this);
        drawView = (DrawView) findViewById(R.id.drawView1);
        drawView.setBackgroundColor(Color.WHITE);
        //setContentView(drawView);
        drawView.requestFocus();


        dollarRecognizer = new DollarRecognizer();

    }
    public void button1_click(View view)
    {
        ArrayList points = drawView.GetArrayList();
        if(points.isEmpty())
            return;

        RecognizerResults results = dollarRecognizer.Recognize(drawView.GetArrayList());

        Context context = getApplicationContext();
        CharSequence text =  results.mName + "  " + results.mScore + "   " + results.mOtherInfo;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void button2_click(View view)
    {
     drawView.Clear();
    }

    public void button3_click(View view)
    {
        ArrayList points = drawView.GetArrayList();
        if(points.isEmpty())
            return;

        String name = "new_gesture_" + id;
        id++;

        dollarRecognizer.addGesture(name,drawView.GetArrayList());
        drawView.Clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
