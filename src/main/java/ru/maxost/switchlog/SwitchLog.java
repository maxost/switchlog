package ru.maxost.switchlog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Ostrovidov on 24.11.16.
 */
public class SwitchLog {

    public static final int STATE_OFF = 1;
    public static final int STATE_ANDROID = 2;
    public static final int STATE_PURE_JAVA = 3;

    private static int state;

    public static void init(int state) {
        SwitchLog.state = state;
    }

    public static void log() {
        displayMessage("");
    }

    public static void log(String message) {
        displayMessage(message);
    }

    public static void scream(String message) {
        displayMessage("!!!!!!!!!!!!!!!!!!!!!!!!! " + message);
    }

    //inspired by Jake Wharton's Timber lib
    private static String generateTag() {

        int CALL_STACK_INDEX = 3;

        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String className = stackTrace[CALL_STACK_INDEX].getClassName();
        Matcher m = Pattern.compile("(\\$\\d+)+$").matcher(className);
        if (m.find()) className = m.replaceAll("");
        return new StringBuilder()
                .append("------------------------- ")
                .append(className.substring(className.lastIndexOf('.') + 1))
                .append(" :: ")
                .append(stackTrace[CALL_STACK_INDEX].getMethodName())
                .toString();
    }

    private static void displayMessage(String message) {
        switch (state) {
            case STATE_OFF : {
                break;
            }
            case STATE_ANDROID : {
                android.util.Log.d(generateTag(), message);
                break;
            }
            case STATE_PURE_JAVA: {
                System.out.println(generateTag() + ": " + message);
                break;
            }
        }
    }
}