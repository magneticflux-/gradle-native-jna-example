package com.skaggsm.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Mitchell Skaggs on 1/3/2019.
 */
class MainTest {
    @Test
    void loadsNativeLibrary() {
        assertDoesNotThrow(NativeLib.INSTANCE::printIt);
    }

    @Test
    void receivesString() {
        assertEquals("Hello world", NativeLib.INSTANCE.getHelloWorld());
    }
}