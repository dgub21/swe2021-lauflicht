package org.c02.swe.iot.examples;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLedEffect;

import java.awt.*;

public class SpinningLedDemo1 {
    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws ParticleException {
        IButton button = new Button(api);

        SpinningLedEffect effect = new SpinningLedEffect(button, 2, Color.green);

        while(effect.next());
        effect.reset();
    }
}
