package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.ArrayList;

public class LedButtonApiDemo3 {
    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws ParticleException, InterruptedException {
        IButton button = new Button(api);
        ArrayList<LedStatus> statuses = new ArrayList<>();

        button.allLedsOff();

        for (int i = 1; i <= 12; i++) {
            statuses.add(new LedStatus(i, Color.red));
        }

        button.setLeds(statuses);
    }
}
