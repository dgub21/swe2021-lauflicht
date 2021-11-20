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
        this.button.allLedsOff();
    }

    @Override
    public boolean next() throws ParticleException {
        if(currentCycle > this.cycles) return false;
        if(currentPos > 12) return false;

        this.button.allLedsOff();
        this.button.setLed(currentPos, this.color);

        if(currentPos == 12) {
            currentCycle++;
            currentPos = 1;
        }
        currentPos++;

        return true;
    }

    @Override
    public void reset() throws ParticleException {
        this.button.allLedsOff();
        this.currentCycle = 1;
        this.currentPos = 1;
    }
}
