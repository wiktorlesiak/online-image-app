package com.lesiak.wiktor.online_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    ImageView imageView;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


    }


    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public void buttonClickMe(View view) {
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //url = https://i.imgur.com/f90pbLq.jpg
            LoadImageFromWebOperations(editText.getText().toString());
        }
    });
    }
}
