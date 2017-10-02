package Q3.TireMonitor;
import Q3.TireMonitor.MySensor;

public class Alarm
{
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;
    private MySensor _sensor;
    
    public Alarm(MySensor sensor, double LPT, double HPT){
    	_sensor = sensor;
    	LowPressureThreshold = LPT;
    	HighPressureThreshold = HPT;
    	
    }
  
    public boolean isAlarmOn()
    {     
    	double psiPressureValue = _sensor.readPressure();
        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            return true;
        }
        else return false;
    }
}