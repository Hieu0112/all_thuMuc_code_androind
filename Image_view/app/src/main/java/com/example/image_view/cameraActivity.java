package com.example.image_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class cameraActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Button openImage,btnOpenGallery,luu;
    EditText url,number;
    Bitmap resizedBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView = findViewById(R.id.imageView);
        btnOpenGallery = findViewById(R.id.btnOpenGallery);
        url=findViewById(R.id.edit);
        openImage=findViewById(R.id.view_image);
        luu=findViewById(R.id.Luu);
        number=findViewById(R.id.image_number);
        btnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        openImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage();
            }
        });
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_image(resizedBitmap,url.getText().toString());
            }
        });
    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            try {
                // Chuyển đổi Uri thành Bitmap
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                // Chuyển đổi Bitmap thành mảng byte (để lưu vào cơ sở dữ liệu)
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                resizedBitmap = resizeBitmap(bitmap, 0.5f); // Giảm kích thước xuống 50%
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void add_image(Bitmap resizedBitmap,String url1){
        url.setText("");
        SQLiteHelperImage sqLiteHelperImage=new SQLiteHelperImage(this);
        Image image=new Image(url1,resizedBitmap);
        sqLiteHelperImage.addImage(image);
        sqLiteHelperImage.close();
    }
    private void setImage() {
        SQLiteHelperImage sqLiteHelperImage=new SQLiteHelperImage(this);
        int id=Integer.parseInt( number.getText().toString());
        Image image=sqLiteHelperImage.getImage(id);
        String url_image=image.getUrl();
        Bitmap bitmaps=image.getBitmap();
        sqLiteHelperImage.close();
        if(url_image.length()>0){
            Glide.with(getApplicationContext())
                    .load(url_image)
                    .into(imageView);
        }
        else {
            imageView.setImageBitmap(bitmaps);
        }
    }

    private Bitmap resizeBitmap(Bitmap originalBitmap, float scaleRatio) {
        int width = Math.round(originalBitmap.getWidth() * scaleRatio);
        int height = Math.round(originalBitmap.getHeight() * scaleRatio);
        return Bitmap.createScaledBitmap(originalBitmap, width, height, false);
    }

}