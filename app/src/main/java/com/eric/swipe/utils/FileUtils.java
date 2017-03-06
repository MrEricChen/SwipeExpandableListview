package com.eric.swipe.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;


public class FileUtils {

    public static String getFileTxt(Context mContext) {
        String result = "";
        try {
            InputStream is = mContext.getAssets().open("json.txt");
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            result = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
        } catch (IOException e) {
            // Should never happen!
            throw new RuntimeException(e);
        }
        return result;
    }
}
