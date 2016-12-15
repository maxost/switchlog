# SwitchLog
Simple Android logger with the possibility of replacing log method.
## Installation
Available at JCenter. Add to your `build.gradle` file:

    compile 'ru.maxost:switchlog:1.0.0'
## Usage
Init logger first (e.g. in your `Application` class):

    SwitchLog.init(STATE);

`STATE` here is one of these:

    SwitchLog.STATE_ANDROID   - log() will call android.util.Log.d() (e.g. for debug builds)
    SwitchLog.STATE_PURE_JAVA - log() will call System.out.println() (e.g. for JUnit tests)
    SwitchLog.STATE_OFF       - log() will not be called (e.g. for release builds)
    
Start logging!
