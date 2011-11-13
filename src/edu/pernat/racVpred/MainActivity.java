package edu.pernat.racVpred;

import com.badlogic.gdx.backends.android.AndroidApplication;


import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new MyFirstTriangle(), false);   
    }
}