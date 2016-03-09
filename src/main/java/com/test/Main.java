package com.test;

import com.test.util.GpioUtil;
import com.test.util.WebcamUtil;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
        GpioUtil.setGPIO(1, true); // set GPIO1 to high
        GpioUtil.setGPIO(2, args[0].equals("1") ? true : false); // set GPIO2 to low
        GpioUtil.setGPIO(3, args[1].equals("1") ? true : false); // set GPIO1 to high
        GpioUtil.setGPIO(4, args[2].equals("1") ? true : false); // set GPIO2 to low

//            System.out.println("GPIO3=" + GpioUtil.getGPIO(3)); // read value of GPIO3
//            System.out.println("GPIO4=" + GpioUtil.getGPIO(4)); // read value of GPIO4
        File f = new File("./image" + 1 + ".png");
        try {
            ImageIO.write(WebcamUtil.getImage(1280, 1024), "png", f); // Save image as PNG file
        } catch (IOException e) {
            e.printStackTrace();
        }

//            GpioUtil.setGPIO(1, false); // set GPIO1 to low
//            GpioUtil.setGPIO(2, true); // set GPIO2 to high

        System.out.println("GPI15=" + GpioUtil.getGPIO(15)); // read value of GPIO3
        System.out.println("GPI16=" + GpioUtil.getGPIO(16)); // read value of GPIO4
//        }
    }

}
