# SwitchLog
Simple Android logger with the possibility of replacing logging method. Also detects and prints class::method that calls the logging method.
## Installation
Available at JCenter. Add to your project dependencies:

    compile 'ru.maxost:switchlog:2.0.1'
## Usage
Set logger method first (e.g. in your `Application` class):

    SwitchLog.setMethod(METHOD);

`METHOD` here is one of these:

    SwitchLog.METHOD_OFF         - default / log() will not be called (e.g. for release builds)
    SwitchLog.METHOD_ANDROID_LOG - log() will call android.util.Log.d() (e.g. for debug builds)
    SwitchLog.METHOD_JAVA_PRINT  - log() will call System.out.println() (e.g. for JUnit tests)
    
Start logging!
    
    SwitchLog.log()
    sample output: MainActivity :: onCreate
    
    SwitchLog.log("hello")
    sample output: MainActivity :: onCreate: hello
    
    SwitchLog.scream()
    sample output: MainActivity :: onCreate: !!!!!!!!!!!!!!!!!!!!!!!!!
    
    SwitchLog.scream("hello")
    sample output: MainActivity :: onCreate: !!!!!!!!!!!!!!!!!!!!!!!!! hello
