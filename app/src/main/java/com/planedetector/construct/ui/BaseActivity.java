package com.planedetector.construct.ui;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zone.planedetector.R;


public class BaseActivity extends AppCompatActivity {

    private Toolbar actionBarToolbar;

    public Toolbar getActionBarToolbar() {
        if (actionBarToolbar == null) {
            //actionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (actionBarToolbar != null) {
                setSupportActionBar(actionBarToolbar);
            }
        }
        return actionBarToolbar;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }
}