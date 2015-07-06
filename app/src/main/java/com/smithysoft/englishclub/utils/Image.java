package com.smithysoft.englishclub.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.smithysoft.englishclub.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 06.07.2015.
 */
public class Image {

    private Image() {
    }

    public static void fetchImage(final String iUrl, final ImageView iView) {
        if (iUrl == null || iView == null)
            return;

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                final Bitmap image = (Bitmap) message.obj;
                iView.setImageBitmap(image);
            }
        };

        final Thread thread = new Thread() {
            @Override
            public void run() {
                final Bitmap image = downloadImage(iUrl);
                if (image != null) {
                    final Message message = handler.obtainMessage(1, image);
                    handler.sendMessage(message);
                }
            }
        };
        iView.setImageResource(R.mipmap.ic_launcher);
        thread.setPriority(3);
        thread.start();
    }

    public static Bitmap downloadImage(String iUrl) {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        BufferedInputStream buf_stream = null;
        try {
            conn = (HttpURLConnection) new URL(iUrl).openConnection();
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            buf_stream = new BufferedInputStream(conn.getInputStream(), 8192);
            bitmap = BitmapFactory.decodeStream(buf_stream);
            buf_stream.close();
            conn.disconnect();
            buf_stream = null;
            conn = null;
        } catch (IOException ex) {
        } catch (OutOfMemoryError e) {
            return null;
        } finally {
            if (buf_stream != null)
                try {
                    buf_stream.close();
                } catch (IOException ex) {
                }
            if (conn != null)
                conn.disconnect();
        }
        return bitmap;
    }

}
