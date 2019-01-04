package com.skaggsm.memory;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by Mitchell Skaggs on 1/3/2019.
 */
public interface NativeLib extends Library {
    NativeLib INSTANCE = Native.load("native-lib", NativeLib.class);

    void printIt();

    String getHelloWorld();
}
