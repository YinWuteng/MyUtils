package yinwuteng.com.myutils.map;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;



public class StgOrienationListener implements SensorEventListener {
    private Context context;
    private SensorManager sensorManager;
    private Sensor sensor;
    private float lastX;

    private OnOrientationListener orientationListener;
    public StgOrienationListener(Context context){
        this.context=context;
    }
    //开始
    public void onStart(){
        sensorManager=(SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager !=null){
            //获得方向传感器
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }
        //注册
        if (sensor !=null){
            assert sensorManager != null;
            sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_UI);
        }
    }
    //停止检测
    public void onStop(){
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
     //接收方向传感器类型
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ORIENTATION){
            float x=sensorEvent.values[SensorManager.DATA_X];
            if (Math.abs(x-lastX)>1.0){
                orientationListener.onOrientationChanged(x);
            }
            lastX=x;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    public void setOnOrientationListener(OnOrientationListener orientationListener){
        this.orientationListener=orientationListener;
    }
    public interface OnOrientationListener {
        void onOrientationChanged(float x);
    }

}
