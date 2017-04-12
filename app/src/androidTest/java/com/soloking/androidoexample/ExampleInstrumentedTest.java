package com.soloking.androidoexample;

import android.app.Instrumentation;
import android.content.Context;
import android.graphics.Point;
import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Instrumentation instr;
    Context mContext;

    @Before void initial() {
        instr = InstrumentationRegistry.getInstrumentation();
        mContext = InstrumentationRegistry.getContext();
    }

    @Test
    public void useAppContext() throws Exception {
        UiDevice device = UiDevice.getInstance(instr);
        UiObject2 obj = device.findObject(By.text("Bluetooth"));
        Point p  = obj.getVisibleCenter();

    }
}
