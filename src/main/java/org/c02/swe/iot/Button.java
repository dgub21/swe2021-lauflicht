package org.c02.swe.iot;

import java.awt.Color;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {


    private int position;
    private Color color;

    private IParticleApi api;

    public Button(IParticleApi wrapperInstance) {
        this.api = wrapperInstance;
    }


    public void setLed(int position, Color color) throws ParticleException {

        String parameter = color.getRed() + "" + color.getGreen() + "" + color.getBlue();
        int length = String.valueOf(position).length();

        if (length == 1){
            parameter = "0" + position + parameter;
        } else {
            parameter = position + parameter;
        }

        api.callMethod("led", parameter);

    }

    public void allLedsOff() throws ParticleException {
        api.callMethod("ledsOff", null);
    }

    public void setLed(LedStatus status) {

    }

    public void setLeds(List<LedStatus> statuses) {

    }
}