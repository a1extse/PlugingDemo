package com.example.library;

import android.app.Activity;
import android.os.Bundle;

public interface PluginLifeCycleCallback {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attach(Activity activity);
}
