package com.example.mac.plugingdemo;

import android.content.res.Resources;

import dalvik.system.DexClassLoader;

public class PluginManager {
    private static final PluginManager ourInstance = new PluginManager();
    private DexClassLoader dexClassLoader;
    private Resources resources;

    public static PluginManager getInstance() {
        return ourInstance;
    }

    private PluginManager() {
    }

    public void loadPath(String path) {
//        dexClassLoader = new DexClassLoader(path)

    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }
}
