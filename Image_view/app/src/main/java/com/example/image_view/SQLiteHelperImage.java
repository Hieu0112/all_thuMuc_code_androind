package com.example.image_view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class SQLiteHelperImage extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final String TABLE_NAME = "images_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_IMAGE = "image";
    private static final int DATABASE_VERSION=1;
    public SQLiteHelperImage(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //name category author price date
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "url TEXT,"+ COLUMN_IMAGE + " BLOB)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    //get all order by date descending
    public void addImage(Image image) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("url",image.getUrl());
            values.put("image", getBytes(image.getBitmap()));
            db.insert("images_table", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public Image getImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"url", "image"};
        String selection = "id" + "=?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int urlColumnIndex = cursor.getColumnIndex("url");
            int imageColumnIndex = cursor.getColumnIndex("image");
            if (urlColumnIndex >= 0 && imageColumnIndex >= 0) {
                String url = cursor.getString(urlColumnIndex);
                byte[] bytes = cursor.getBlob(imageColumnIndex);
                cursor.close();
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                return new Image(url, bitmap);
            }
        }
        return null;
    }
}