package com.raspi.util;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class WebcamUtil {

    public static BufferedImage getImage(int width, int height) {
        // Load the native library.
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture();
        camera.open(0);
        camera.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, width);
        camera.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, height);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!camera.isOpened()) {
            System.out.println("Camera Error");
        } else {
            System.out.println("Camera OK?");
        }
        Mat frame = new Mat();
        camera.read(frame);
//        Highgui.imwrite("capture2.png", frame);
        return mat2BufferedImage(frame);
    }

    private static BufferedImage mat2BufferedImage(Mat m){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if ( m.channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte [] b = new byte[bufferSize];
        m.get(0,0,b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);
        return image;
    }
}
