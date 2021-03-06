package edu.wpi.first.wpilibj.hal;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class AnalogJNI extends JNIWrapper {
    /**
     * <i>declaration : AthenaJava\target\native\include\HAL\Analog.h:58</i><br> enum values
     */
    public interface AnalogTriggerType {
        /**
         * <i>declaration : AthenaJava\target\native\include\HAL\Analog.h:54</i>
         */
        int kInWindow = 0;
        /**
         * <i>declaration : AthenaJava\target\native\include\HAL\Analog.h:55</i>
         */
        int kState = 1;
        /**
         * <i>declaration : AthenaJava\target\native\include\HAL\Analog.h:56</i>
         */
        int kRisingPulse = 2;
        /**
         * <i>declaration : AthenaJava\target\native\include\HAL\Analog.h:57</i>
         */
        int kFallingPulse = 3;
    }

    public static int initializeAnalogInputPort(int halPortHandle) {
		return 0;
	}

    public static void freeAnalogInputPort(int portHandle) {
	}

    public static int initializeAnalogOutputPort(int halPortHandle) {
		return 0;
	}

    public static void freeAnalogOutputPort(int portHandle) {
	}

    public static boolean checkAnalogModule(byte module) {
		return false;
	}

    public static boolean checkAnalogInputChannel(int channel) {
    	return 0 <= channel && channel < PortsJNI.getNumAnalogInputs();
	}

    public static boolean checkAnalogOutputChannel(int channel) {
		return 0 <= channel && channel < PortsJNI.getNumAnalogOutputs();
	}

    public static void setAnalogOutput(int portHandle, double voltage) {
	}

    public static double getAnalogOutput(int portHandle) {
		return 0;
	}

    public static void setAnalogSampleRate(double samplesPerSecond) {
	}

    public static double getAnalogSampleRate() {
		return 0;
	}

    public static void setAnalogAverageBits(int analogPortHandle, int bits) {
	}

    public static int getAnalogAverageBits(int analogPortHandle) {
		return 0;
	}

    public static void setAnalogOversampleBits(int analogPortHandle, int bits) {
	}

    public static int getAnalogOversampleBits(int analogPortHandle) {
		return 0;
	}

    public static short getAnalogValue(int analogPortHandle) {
		return 0;
	}

    public static int getAnalogAverageValue(int analogPortHandle) {
		return 0;
	}

    public static int getAnalogVoltsToValue(int analogPortHandle, double voltage) {
		return 0;
	}

    public static double getAnalogVoltage(int analogPortHandle) {
		return 0;
	}

    public static double getAnalogAverageVoltage(int analogPortHandle) {
		return 0;
	}

    public static int getAnalogLSBWeight(int analogPortHandle) {
		return 0;
	}

    public static int getAnalogOffset(int analogPortHandle) {
		return 0;
	}

    public static boolean isAccumulatorChannel(int analogPortHandle) {
		return false;
	}

    public static void initAccumulator(int analogPortHandle) {
	}

    public static void resetAccumulator(int analogPortHandle) {
	}

    public static void setAccumulatorCenter(int analogPortHandle, int center) {
	}

    public static void setAccumulatorDeadband(int analogPortHandle, int deadband) {
	}

    public static long getAccumulatorValue(int analogPortHandle) {
		return 0;
	}

    public static int getAccumulatorCount(int analogPortHandle) {
		return 0;
	}

    public static void getAccumulatorOutput(int analogPortHandle, LongBuffer value, LongBuffer count) {
	}

    public static int initializeAnalogTrigger(int analogInputHandle, IntBuffer index) {
		return 0;
	}

    public static void cleanAnalogTrigger(int analogTriggerHandle) {
	}

    public static void setAnalogTriggerLimitsRaw(int analogTriggerHandle, int lower, int upper) {
	}

    public static void setAnalogTriggerLimitsVoltage(int analogTriggerHandle, double lower, double upper) {
	}

    public static void setAnalogTriggerAveraged(int analogTriggerHandle, boolean useAveragedValue) {
	}

    public static void setAnalogTriggerFiltered(int analogTriggerHandle, boolean useFilteredValue) {
	}

    public static boolean getAnalogTriggerInWindow(int analogTriggerHandle) {
		return false;
	}

    public static boolean getAnalogTriggerTriggerState(int analogTriggerHandle) {
		return false;
	}

    public static boolean getAnalogTriggerOutput(int analogTriggerHandle, int type) {
		return false;
	}
}
