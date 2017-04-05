package com.bluesoul.soulpower;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.annotation.NonNull;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String gTestStr = null;

    private int iTest = 0;

    private int iTest222 = 0;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Button btn_setAlarm = (Button) findViewById(R.id.bt_clock);
        btn_setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicIntent.getInstance().createAlarm(MainActivity.this,"clock set test",13,30);
            }
        });
        Button btn_setTimer = (Button) findViewById(R.id.bt_timer);
        btn_setTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PublicIntent.getInstance().startTimer(MainActivity.this,"set timer test",20);
            }
        });

        Button btn_addEvent = (Button) findViewById(R.id.bt_addCalendarEvent);
        btn_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar begin = Calendar.getInstance();
                begin.set(2016,12,9);
                Calendar end = Calendar.getInstance();
                end.set(2016,12,10);
                PublicIntent.getInstance().addCalendarEvent(MainActivity.this,"event1000","beijing",begin,end);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private @NonNull String testF(@NonNull String teststr){
        String inlineStr;
        inlineStr = teststr;
        return inlineStr;
    }

    private void testInent(){
        // Create the text message with a string
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "test-string");
        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    private void testInent2(){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);

        // Always use string resources for UI text.
// This says something like "Share this photo with"
        String title = "选择器列表";
        // Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendIntent, title);

// Verify the original intent will resolve to at least one activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    @NonNull
    public native String stringFromJNI();
}
