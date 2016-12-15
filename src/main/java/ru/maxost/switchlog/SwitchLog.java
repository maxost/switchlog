package ru.maxost.switchlog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Ostrovidov on 24.11.16.
 */
public class SwitchLog {

    public static final int METHOD_OFF = 1;
    public static final int METHOD_ANDROID_LOG = 2;
    public static final int METHOD_JAVA_PRINT = 3;

    private static int method = 1; //off by default

    public static void setLogMethod(int method) {
        SwitchLog.method = method;
    }

    public static void log() {
        displayMessage("");
    }

    public static void log(String message) {
        displayMessage(message);
    }

    public static void scream() {
        displayMessage("!!!!!!!!!!!!!!!!!!!!!!!!!");
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
                .append(className.substring(className.lastIndexOf('.') + 1))
                .append(" :: ")
                .append(stackTrace[CALL_STACK_INDEX].getMethodName())
                .toString();
    }

    private static void displayMessage(String message) {
        switch (method) {
            case METHOD_OFF : {
                break;
            }
            case METHOD_ANDROID_LOG : {
                android.util.Log.d(generateTag(), message);
                break;
            }
            case METHOD_JAVA_PRINT: {
                System.out.println(generateTag() + ": " + message);
                break;
            }
        }
    }
}