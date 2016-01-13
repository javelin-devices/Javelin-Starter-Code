package com.javelindevices.javelinstartercode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.javelindevices.javelinsdk.JavelinSensorManager;
import com.javelindevices.javelinsdk.model.ISensor;
import com.javelindevices.javelinsdk.model.ISensorManager;
import com.javelindevices.javelinsdk.model.JavelinSensorEvent;

public class MainActivity extends AppCompatActivity implements ISensorManager.JavelinEventListener {

    private final String TAG = "JavelinRuler";
    public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";
    public static String mDeviceAddress;
    JavelinSensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*** Communication with ScanActivity ***/
        final Intent intent = getIntent();
        mDeviceAddress = intent.getStringExtra(EXTRAS_DEVICE_ADDRESS);

        /*** Sensor Management**/
        mSensorManager =  new JavelinSensorManager(this, mDeviceAddress);
        mSensorManager.setListener(this);
        mSensorManager.enable();

        setContentView(R.layout.activity_main);
    }
    @Override
    public void onResume(){
        super.onResume();
        /*** Register Listener for each Javelin Sensor ***/
        mSensorManager.registerListener(this, ISensor.TYPE_ACCELEROMETER);
//        mSensorManager.registerListener(this,ISensor.TYPE_AUDIO_ENERGY);
//        mSensorManager.registerListener(this,ISensor.TYPE_GYROSCOPE);
//        mSensorManager.registerListener(this,ISensor.TYPE_MAGNETIC_FIELD);
//        mSensorManager.registerListener(this,ISensor.TYPE_TEMPERATURE);
//        mSensorManager.registerListener(this,ISensor.TYPE_BATTERY);
    }

    @Override
    public void onPause(){
        /** Unegister Listener for each Javelin Sensor ***/
        mSensorManager.unregisterListener(this, ISensor.TYPE_ACCELEROMETER);
//        mSensorManager.unregisterListener(this, ISensor.TYPE_AUDIO_ENERGY);
//        mSensorManager.unregisterListener(this, ISensor.TYPE_GYROSCOPE);
//        mSensorManager.unregisterListener(this, ISensor.TYPE_MAGNETIC_FIELD);
//        mSensorManager.unregisterListener(this, ISensor.TYPE_TEMPERATURE);
//        mSensorManager.unregisterListener(this, ISensor.TYPE_BATTERY);
        super.onPause();
    }


    /***** JavelinEventListener Methods *****/
    @Override
    public void onReadRemoteRssi(int rssi) {
    }
    @Override
    public void onSensorManagerConnected(){
        Log.v(TAG, "Successfully connected to Javelin: " + mDeviceAddress);
        mSensorManager.setLedBlinkNumber(5);
        mSensorManager.setLedBlinkRate(75);
        mSensorManager.setLedIntensity(75);
        mSensorManager.ledEnable(true);
    }
    @Override
    public void onSensorManagerDisconnected() {
        Log.d(TAG, "Javelin device disconnected!");
    }
    @Override
    public void onSensorChanged(JavelinSensorEvent event){
        float[] values = event.values;
        Log.v(TAG,"Sensor changed.\nSensor: " + event.sensor + "\nValues: " + values.length + "\nValue: "+values[0]);
        switch(event.sensor){
            case ISensor.TYPE_ACCELEROMETER:
                // Handle accelerometer data here
                break;
//            case ISensor.TYPE_GYROSCOPE:
//                break;
//            case ISensor.TYPE_MAGNETIC_FIELD:
//                break;
//            case ISensor.TYPE_TEMPERATURE:
//                break;
//            case ISensor.TYPE_AUDIO_ENERGY:
//                break;
//            case ISensor.TYPE_BATTERY:
//                break;
        }

    }
}
