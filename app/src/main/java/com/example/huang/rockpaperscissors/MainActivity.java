package com.example.huang.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    protected static final String TAG = "Rock-Paper-Scissors";

    ImageButton rockImageButton;
    ImageButton paperImageButton;
    ImageButton scissorImageButton;
    ImageView imageView1;
    ImageView imageView2;
    TextView textView;
    Button aboutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.computer_imageview);
        imageView2 = (ImageView) findViewById(R.id.human_imageview);
        aboutButton = (Button) findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        rockImageButton = (ImageButton) findViewById(R.id.rock_imagebutton);
        rockImageButton.setOnClickListener(this);
        paperImageButton = (ImageButton) findViewById(R.id.paper_imagebutton);
        paperImageButton.setOnClickListener(this);
        scissorImageButton = (ImageButton) findViewById(R.id.scissor_imagebutton);
        scissorImageButton.setOnClickListener(this);
        textView = (TextView)findViewById(R.id.result);
        textView.setText(R.string.result);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.about_button:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;

            case R.id.rock_imagebutton:
                imageView2.setImageResource(R.drawable.rock);
                getRandomPic();
                showResult1();
                break;

            case R.id.paper_imagebutton:
                imageView2.setImageResource(R.drawable.paper);
                getRandomPic();
                showResult2();
                break;

            case R.id.scissor_imagebutton:
                imageView2.setImageResource(R.drawable.scissor);
                getRandomPic();
                showResult3();
                break;

        }
    }


    int[] photos = {R.drawable.rock,R.drawable.paper,R.drawable.scissor};
    public void getRandomPic(){
        Random ran = new Random(System.currentTimeMillis());
        int i = ran.nextInt(photos.length);
        Log.d(TAG, "Randomly Pick Up Picture No. " + i);
        imageView1.setImageResource(photos[i]);
        imageView1.setTag(photos[i]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Setting Item
    // Intent in Prefs.Class

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
        }
        return false;
    }

    public void showResult1(){
        if ((Integer)imageView1.getTag() == R.drawable.scissor){
            String wText = "You Won, Play It Again";
            textView.setText(wText);
        } else if ((Integer)imageView1.getTag() == R.drawable.paper){
            String lText = "You Lose, Try It Again";
            textView.setText(lText);
        } else {
            String tText = "You Tight, Do It Again";
            textView.setText(tText);
        }
    }

    public void showResult2(){
        if ((Integer)imageView1.getTag() == R.drawable.rock){
            String wText = "You Won, Play It Again";
            textView.setText(wText);
        } else if ((Integer)imageView1.getTag() == R.drawable.scissor){
            String lText = "You Lose, Try It Again";
            textView.setText(lText);
        } else {
            String tText = "You Tight, Do It Again";
            textView.setText(tText);
        }
    }

    public void showResult3(){
        if ((Integer)imageView1.getTag() == R.drawable.paper){
            String wText = "You Won, Play It Again";
            textView.setText(wText);
        } else if ((Integer)imageView1.getTag() == R.drawable.rock){
            String lText = "You Lose, Try It Again";
            textView.setText(lText);
        } else {
            String tText = "You Tight, Do It Again";
            textView.setText(tText);
        }
    }
}
