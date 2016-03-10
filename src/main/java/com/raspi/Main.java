package com.raspi;

import com.pi4j.io.gpio.*;
import com.raspi.util.Webcam;
import org.opencv.highgui.Highgui;

public class Main {

    final static GpioController gpio = GpioFactory.getInstance();

    public static void main(String[] args) {
        // provision gpio pin #08 as an output pin and turn on
        GpioPinDigitalOutput pinDigitalOutput1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
        // provision gpio pin #09 as an output pin and turn on
        GpioPinDigitalOutput pinDigitalOutput2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);

        // provision gpio pin #15 as an input pin and turn on
        GpioPinDigitalInput pinDigitalInput15 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15);
        // provision gpio pin #16 as an input pin and turn on
        GpioPinDigitalInput pinDigitalInput16 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16);

        Webcam webcam = new Webcam(1280, 1024);

        for (int i = 0; i < 20; i++) {
            pinDigitalOutput1.setState(true);// set GPIO1 to high
            pinDigitalOutput2.setState(false); // set GPIO2 to low

            System.out.println("GPIO3=" + pinDigitalInput15.getState().getValue()); // read value of GPIO3
            System.out.println("GPIO4=" + pinDigitalInput16.getState().getValue()); // read value of GPIO4


            Highgui.imwrite("capture" + i + ".png", webcam.getFrame()); // faster alternative
//            File f = new File("./image" + i + ".png");
//            try {
//                ImageIO.write(webcam.getImage(), "png", f); // Save image as PNG file
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            pinDigitalOutput1.setState(false);// set GPIO1 to low
            pinDigitalOutput2.setState(true); // set GPIO2 to high

            System.out.println("GPIO3=" + pinDigitalInput15.getState().getValue()); // read value of GPIO3
            System.out.println("GPIO4=" + pinDigitalInput16.getState().getValue()); // read value of GPIO4
        }
        // required method for release system resources
        webcam.release();
    }

}
