package com.zky.basics.api.splash;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Created by lk
 * Date 2019-11-06
 * Time 17:47
 * Detail:
 */
public class ImageUrl {
    private Bitmap bitmap;
    private String token;
    private String image;

    public ImageUrl() {
    }

    public ImageUrl(Bitmap bitmap, String token, String image) {
        this.bitmap = bitmap;
        this.token = token;
        this.image = image;
    }

    public Object getImageUrl() {
        return image;
    }

    public void setImageUrl(String imageUrl) {
        this.image = imageUrl;
    }

    public Bitmap getBitmap() {
        if (getImageUrl() == null || getImageUrl().toString().equals("")) {
            return null;
        }
        String s = getImageUrl().toString().replaceAll("data:image/png;base64,", "");
        byte[] bitmapByte = Base64.decode(s, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapByte, 0, bitmapByte.length);
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
