package org.c02.swe.iot.effect;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLedEffect extends AbstractEffect {
    public int cycles;
    public Color color;

    public int currentCycle = 1;
    public int currentPos = 1;

    public SpinningLedEffect(IButton button, int cycles, Color color) throws ParticleException {
        super(button);
        this.cycles = cycles;
        this.color = color;
        this.reset();
    }

    @Override
    public boolean next()  {
    }

    @Override
    public void reset() {
    }
}
