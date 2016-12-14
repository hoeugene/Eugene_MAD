// IR Remote frequency from http://www.remotecentral.com/cgi-bin/codes/samsung/tv_functions/
// IR Remote implementation from http://stackoverflow.com/questions/20244337/consumerirmanager-api-19

package com.example.eugene.proj3milestone2;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.ConsumerIrManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    //a TextView
    private TextView tv;
    //the Sensor Manager
    private SensorManager sManager;


    private static final int SAMSUNG_FREQ = 38028;

    private static final int[] SAMSUNG_POWER_TOGGLE_DURATION = {4495, 4368, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1664, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 46644, 4394, 4368, 546, 546, 546, 96044};
    private static final int[] SAMSUNG_VOL_UP = {4495, 4368, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1664, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 46644, 4394, 4368, 546, 546, 546, 96044};
    private static final int[] SAMSUNG_VOL_DOWN = {4495, 4368, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1638, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 546, 1664, 546, 546, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 1638, 546, 46644, 4394, 4368, 546, 546, 546, 96044};

    private static final String TAG = "MainActivity";

    private ConsumerIrManager mCIR;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCIR = (ConsumerIrManager) this.getSystemService(Context.CONSUMER_IR_SERVICE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        tv = (TextView) findViewById(R.id.test);
        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sManager.registerListener(this, sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        sManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv.setText("X Axis Accel :" + Float.toString(event.values[2]) + "\n" +
                "Y Axis Accel :" + Float.toString(event.values[1]) + "\n" +
                "Z Axis Accel :" + Float.toString(event.values[0]));

        ImageView power = (ImageView) findViewById(R.id.power_button);
        ImageView volume_up = (ImageView) findViewById(R.id.volume_up);
        ImageView volume_down = (ImageView) findViewById(R.id.volume_down);
        power.setImageAlpha(127);
        volume_up.setImageAlpha(127);
        volume_down.setImageAlpha(127);

        if (event.values[1] > 8) {
            power.setImageAlpha(255);
//            transmit("power");
        } else if (event.values[0] < -8) {
            volume_up.setImageAlpha(255);
//            transmit("vol_up");
        } else if (event.values[0] > 8) {
            volume_down.setImageAlpha(255);
//            transmit("vol_down");
        }

    }

    // Code below is taken online and modified
    public String count2duration(String countPattern) {
        List<String> list = new ArrayList<String>(Arrays.asList(countPattern.split(",")));
        int frequency = Integer.parseInt(list.get(0));
        int pulses = 1000000 / frequency;
        int count;
        int duration;

        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            count = Integer.parseInt(list.get(i));
            duration = count * pulses;
            list.set(i, Integer.toString(duration));
        }

        String durationPattern = "";
        for (String s : list) {
            durationPattern += s + ",";
        }

        Log.d(TAG, "Frequency: " + frequency);
        Log.d(TAG, "Duration Pattern: " + durationPattern);

        return durationPattern;
    }

    public void transmit(String mode) {
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            return;
        }

        switch (mode) {
            case "power":
                    mCIR.transmit(SAMSUNG_FREQ, SAMSUNG_POWER_TOGGLE_DURATION);
                break;
            case "vol_up":
                    mCIR.transmit(SAMSUNG_FREQ, SAMSUNG_VOL_UP);
                break;
            case "vol_down":
                    mCIR.transmit(SAMSUNG_FREQ, SAMSUNG_VOL_DOWN);
                break;
            default:
                break;
        }

    }
}