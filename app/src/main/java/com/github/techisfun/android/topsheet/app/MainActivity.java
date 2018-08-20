package com.github.techisfun.android.topsheet.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.github.techisfun.android.topsheet.TopSheetBehavior;
import com.github.techisfun.android.topsheet.TopSheetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTopSheet(View v) {
        View sheet = findViewById(R.id.top_sheet);
        TopSheetBehavior tt = TopSheetBehavior.from(sheet);
        tt.setState(TopSheetBehavior.STATE_EXPANDED);
        tt.setTopSheetCallback(new TopSheetBehavior.TopSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d("TAG", "newState: " + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset, Boolean isOpening) {
                Log.d("TAG", "slideOffset: " + slideOffset);
                Log.d("TAG", "can be nullable isOpening: " + isOpening);
            }
        });
    }

    public void openBottomSheet(View v) {
        View sheet = findViewById(R.id.bottom_sheet);
        BottomSheetBehavior.from(sheet).setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void openTopSheetDialog(View view) {
        TopSheetDialog dialog = new TopSheetDialog(this);
        dialog.setContentView(R.layout.sheet_content);
        dialog.show();
    }

    public void openBottomSheetDialog(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.sheet_content);
        bottomSheetDialog.show();
    }
}
