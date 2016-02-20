package com.example.huang.rockpaperscissors;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    static final String TAG = "Rock-Paper-Scissors";
    private int won = 0;
    private int lose = 0;
    private int tight = 0;
    private double status = 0;


    ProgressBar statusProgressBar;
    ImageButton rockImageButton;
    ImageButton paperImageButton;
    ImageButton scissorImageButton;
    ImageView imageView1;
    ImageView imageView2;
    TextView result_tv;
    TextView count_tv;
    Button aboutButton;
    RelativeLayout gameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.computer_imageview);
        imageView2 = (ImageView) findViewById(R.id.human_imageview);
        result_tv = (TextView) findViewById(R.id.result);
        count_tv = (TextView) findViewById(R.id.count);
        gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
        aboutButton = (Button) findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        rockImageButton = (ImageButton) findViewById(R.id.rock_imagebutton);
        rockImageButton.setOnClickListener(this);
        paperImageButton = (ImageButton) findViewById(R.id.paper_imagebutton);
        paperImageButton.setOnClickListener(this);
        scissorImageButton = (ImageButton) findViewById(R.id.scissor_imagebutton);
        scissorImageButton.setOnClickListener(this);
        statusProgressBar = (ProgressBar) findViewById(R.id.status_progressBar);
        statusProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);

    }

    @Override
    protected void onResume(){
        super.onResume();
        Music.play(this,R.raw.main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
        Music.stop(this);
    }

    @Override
    public void onClick(View v) {
        final String countText = "W: "+won+
                " | L: "+lose+
                " | T: "+tight+
                " | "+String.format("Pct. %.2f", status)+"%";
        switch(v.getId()){
            case R.id.about_button:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;

            case R.id.rock_imagebutton:
                imageView2.setImageResource(R.drawable.rock);
                getRandomPic();
                showResult1();
                count_tv.setText(countText);
                changeBackgroundColor();
                break;

            case R.id.paper_imagebutton:
                imageView2.setImageResource(R.drawable.paper);
                getRandomPic();
                showResult2();
                count_tv.setText(countText);
                changeBackgroundColor();
                break;

            case R.id.scissor_imagebutton:
                imageView2.setImageResource(R.drawable.scissor);
                getRandomPic();
                showResult3();
                count_tv.setText(countText);
                changeBackgroundColor();
                break;

        }
    }


    // Put image into Array
    static final int[] photos = {R.drawable.rock,R.drawable.paper,R.drawable.scissor};

    public void getRandomPic(){
        // Random Image generated
        Random ran = new Random(System.currentTimeMillis());
        int i = ran.nextInt(photos.length);
        Log.d(TAG, "Randomly Pick Up Picture No. " + i);
        // Set image for image Resource - Create Image in View
        // Set image for image Tag - Create image_id for each picture
        imageView1.setImageResource(photos[i]);
        imageView1.setTag(photos[i]);
    }

    // Setting Item
    // Intent in Prefs.Class

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
        }
        return false;
    }

    static final String wText = "Hey I Won, Play It Again";
    static final String lText = "Loser Loser, Try It Again";
    static final String tText = "Umm Tight, Do It Again";

    public void showResult1(){
        if ((Integer)imageView1.getTag() == R.drawable.scissor){
            result_tv.setText(wText);
            won++;
        } else if ((Integer)imageView1.getTag() == R.drawable.paper){
            result_tv.setText(lText);
            lose++;
        } else {
            result_tv.setText(tText);
            tight++;
        }
        status = ((double)won/(double)(won+lose+tight))*100;
        showStatusProgressBar();
    }

    public void showResult2(){
        if ((Integer)imageView1.getTag() == R.drawable.rock){
            result_tv.setText(wText);
            won++;
        } else if ((Integer)imageView1.getTag() == R.drawable.scissor){
            result_tv.setText(lText);
            lose++;
        } else {
            result_tv.setText(tText);
            tight++;
        }
        status = ((double)won/(double)(won+lose+tight))*100;
        showStatusProgressBar();
    }

    public void showResult3(){
        if ((Integer)imageView1.getTag() == R.drawable.paper){
            result_tv.setText(wText);
            won++;
        } else if ((Integer)imageView1.getTag() == R.drawable.rock){
            result_tv.setText(lText);
            lose++;
        } else {
            result_tv.setText(tText);
            tight++;
        }
        status = ((double)won/(double)(won+lose+tight))*100;
        showStatusProgressBar();
    }

    public void showStatusProgressBar(){
        statusProgressBar.setPadding(20, 10, 10, 10);
        statusProgressBar.setVisibility(View.INVISIBLE);
        statusProgressBar.getIndeterminateDrawable();
        statusProgressBar.setIndeterminate(false);
        statusProgressBar.setMax(100);
        statusProgressBar.setProgress((int)status);
        statusProgressBar.bringToFront();
    }

    public void changeBackgroundColor(){
        if(status < 10){
            gameLayout.setBackgroundColor(Color.BLACK);
        } else if (status > 20 && status < 30){
            gameLayout.setBackgroundColor(Color.GREEN);
        } else if (status > 30 && status < 40){
            gameLayout.setBackgroundColor(Color.RED);
        } else if (status > 40 && status < 50){
            gameLayout.setBackgroundColor(Color.BLUE);
        } else if (status > 50 && status < 60){
            gameLayout.setBackgroundColor(Color.YELLOW);
        } else if (status > 60 && status < 70){
            gameLayout.setBackgroundColor(Color.MAGENTA);
        } else if (status > 70){
            gameLayout.setBackgroundColor(Color.CYAN);
        }
    }
}
