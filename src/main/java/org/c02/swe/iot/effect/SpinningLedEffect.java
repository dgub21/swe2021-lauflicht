package org.c02.swe.iot.effect;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

public class SpinningLedEffect extends AbstractEffect {
    public SpinningLedEffect(IButton button) {
        super(button);
    }

    @Override
    public boolean next() throws ParticleException {
        return false;
    }

    @Override
    public void reset() throws ParticleException {

    }
}
