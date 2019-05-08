package com.techdevcol.uhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techdevcol.uhelper.R;

public class RecordatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorio);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle(getString(R.string.txt_recordatorios));

    }
}
