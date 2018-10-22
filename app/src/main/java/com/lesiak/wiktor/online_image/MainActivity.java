package com.lesiak.wiktor.online_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity {
    Button btn;
    private EditText et;
    private ImageView imageView;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);


    }

    public void buttonClickMe(View view) {
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    URL url = new URL(et.getText().toString());
                    //URL url = new URL("http://farm7.static.flickr.com/6138/5935946400_934994190e_s_d.jpg");
                    new MyDownloadTask().execute(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
class MyDownloadTask extends AsyncTask<URL, Integer, Bitmap> {
    @Override
    protected Bitmap doInBackground(URL... params) {
        URL url = params[0];
        Bitmap bitmap = null;
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();
            //is.close(); THIS IS THE BROKEN LINE
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return bitmap;
    }
}

    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            ImageView myImage = (ImageView)findViewById(R.id.imageView);
            myImage.setImageBitmap(bitmap);
        } else {
            System.out.print("error");
        }
    }
}

