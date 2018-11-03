package com.lesiak.wiktor.online_image;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
<<<<<<< HEAD
=======
import android.graphics.drawable.Drawable;
>>>>>>> fe63467620222491d56617dcbd17e0458292a0c0
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD
import java.io.IOException;
=======
import android.widget.Toast;

import java.io.BufferedInputStream;
>>>>>>> fe63467620222491d56617dcbd17e0458292a0c0
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


<<<<<<< HEAD
public class MainActivity extends AppCompatActivity  {
    Button button;
    EditText editText;
    ImageView imageView;
=======
public class MainActivity extends AppCompatActivity {
    Button btn;
    private EditText et;
    private ImageView imageView;
>>>>>>> fe63467620222491d56617dcbd17e0458292a0c0
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);

<<<<<<< HEAD

    }
=======
>>>>>>> fe63467620222491d56617dcbd17e0458292a0c0

    }

<<<<<<< HEAD

    public void buttonClickMe(View view) {
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //url = https://i.imgur.com/f90pbLq.jpg
           // LoadImageFromWebOperations(editText.getText().toString());
            new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute(editText.getText().toString());
=======
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
>>>>>>> fe63467620222491d56617dcbd17e0458292a0c0
        }
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

