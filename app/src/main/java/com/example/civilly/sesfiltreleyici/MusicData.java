package com.example.civilly.sesfiltreleyici;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

import org.apache.commons.io.IOUtils;


/**
 * Created by ErdoganCIVIL on 8.12.2016.
 */

public class MusicData {

    static String filename;


    public MusicData(String _filename){
        this.filename = _filename;
    }

    public static short[] getMusicData() throws IOException {

        File file = new File(filename);
        FileInputStream is = new FileInputStream(file);

        byte[] data = new byte[0];

        try {
            data = IOUtils.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }

        ShortBuffer sb = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
        short[] samples = new short[sb.limit()];
        sb.get(samples);
        return samples;
    }



}
