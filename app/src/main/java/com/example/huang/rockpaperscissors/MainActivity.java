package com.example.huang.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    ImageView imageView;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button aboutButton = (Button) findViewById(R.id.about);
        aboutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        final int[] photos = {R.drawable.paper,R.drawable.rock,R.drawable.scissor};
        Random ran = new Random();
        final int i = ran.nextInt(photos.length);
        imageView1 = (ImageView) findViewById(R.id.computer_imageview);
        imageButton = (ImageButton) findViewById(R.id.start_imagebutton);
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageResource(photos[i]);
            }
        });

        imageView = (ImageView) findViewById(R.id.human_imageview);
        imageButton = (ImageButton)findViewById(R.id.rock_imagebutton);
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.rock);
            }
        });

        imageButton = (ImageButton)findViewById(R.id.paper_imagebutton);
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.paper);
            }
        });

        imageButton = (ImageButton)findViewById(R.id.scissor_imagebutton);
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.scissor);
            }
        });
    }
}
