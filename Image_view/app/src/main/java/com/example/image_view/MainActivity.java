package com.example.image_view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
        Bitmap resizedBitmap = resizeBitmap(originalBitmap, 0.5f); // Giảm kích thước xuống 50%
//        SQLiteHelperImage sqLiteHelperImage=new SQLiteHelperImage(this);
//        sqLiteHelperImage.addImage(resizedBitmap);
        String url="htps://th.bing.com/th/id/R.3ee2622c09ab11dc84438270554fdde4?rik=%2fJxP%2b19F%2bf%2fY0w&pid=ImgRaw&r=0";
        if(url.contains("http")){
            Glide.with(getApplicationContext())
                    .load(url)
                    .into(imageView);
        }
//        else {
//            imageView.setImageBitmap(sqLiteHelperImage.getImage(1));
//        }
    }
    private Bitmap resizeBitmap(Bitmap originalBitmap, float scaleRatio) {
        int width = Math.round(originalBitmap.getWidth() * scaleRatio);
        int height = Math.round(originalBitmap.getHeight() * scaleRatio);
        return Bitmap.createScaledBitmap(originalBitmap, width, height, false);
    }
}