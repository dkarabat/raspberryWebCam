package com.test.util;

import com.pi4j.io.gpio.*;

/**
 * Created by user on 03.03.16.
 */
public class GpioUtil {

    // create gpio controller
    final static GpioController gpio = GpioFactory.getInstance();

    // provision gpio pin #01 as an output pin and turn on
    final static GpioPinDigitalOutput pinDigitalOutput1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
    // provision gpio pin #02 as an output pin and turn on
    final static GpioPinDigitalOutput pinDigitalOutput2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
    // provision gpio pin #03 as an input pin and turn on

    final static GpioPinDigitalOutput pinDigitalOutput3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);

    final static GpioPinDigitalOutput pinDigitalOutput4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);


    final static GpioPinDigitalInput pinDigitalInput15 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15);
    // provision gpio pin #04 as an input pin and turn on
    final static GpioPinDigitalInput pinDigitalInput16 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16);

    public static void setGPIO(int i, boolean pinState) {
        switch (i) {
            case 1:
                pinDigitalOutput1.setState(pinState);
                break;
            case 2:
                pinDigitalOutput2.setState(pinState);
                break;
            case 3:
                pinDigitalOutput3.setState(pinState);
                break;
            case 4:
                pinDigitalOutput4.setState(pinState);
                break;
        }
    }

    public static int getGPIO(int i) {
        switch (i) {
            case 15:
                return pinDigitalInput15.getState().getValue();
            case 16:
                return pinDigitalInput16.getState().getValue();
        }
        return 0;
    }
}
