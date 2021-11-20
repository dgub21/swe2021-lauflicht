package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLedEffect;
import org.c02.swe.iot.effect.WhiteLedRunning;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

public class SpinningLedEffectTest {
    @Test
    public void testOneTick() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        SpinningLedEffect poc = new SpinningLedEffect(buttonInstance, 1, Color.red);

        Assert.assertTrue(poc.next());

        Mockito.verify(buttonInstance).setLed(1, Color.white);
        Mockito.verifyNoMoreInteractions(buttonInstance);
    }

}
