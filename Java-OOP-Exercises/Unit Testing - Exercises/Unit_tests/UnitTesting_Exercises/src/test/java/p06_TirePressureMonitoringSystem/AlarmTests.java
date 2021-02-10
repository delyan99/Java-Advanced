package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTests {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp(){
        sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testConstructorWithChecking(){
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testConstructorWithoutChecking(){
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWhenPressureIsBelowLowBorder(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWhenPressureIsAboveHigherBorder(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(5.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWhenPressureIsInsideBorders(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
