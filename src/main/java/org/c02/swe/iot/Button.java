package org.c02.swe.iot;

import java.awt.Color;
import java.util.List;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {
    private IParticleApi api;

    public Button(IParticleApi wrapperInstance) {
        this.api = wrapperInstance;
    }


    public void setLed(int position, Color color) throws ParticleException {
        if(position < 1) throw new IllegalArgumentException();

        String parameter = formatColor(color.getRed()) + formatColor(color.getGreen())
                + formatColor(color.getBlue());
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

    public void setLed(LedStatus status) throws ParticleException {
        String pos = getPosition(status.getPosition());
        String r = this.formatColor(status.getColor().getRed());
        String g = this.formatColor(status.getColor().getGreen());
        String b = this.formatColor(status.getColor().getBlue());
        String parameter = String.format("%s%s%s%s", pos,
                r, g, b);

        api.callMethod("led", parameter);
    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {
        for (LedStatus status: statuses ) {
            this.setLed(status);
        }
    }

    private String formatColor(int color) {
        int length = String.valueOf(color).length();

        if(length == 1) return "00" + color;
        if(length == 2) return "0" + color;

        return String.valueOf(color);
    }

    private String getPosition(int pos) {
        String parameter = "";
        int length = String.valueOf(pos).length();

        if (length == 1){
            parameter = "0" + pos;
        } else {
            parameter = String.valueOf(pos);
        }

        return parameter;
    }
}