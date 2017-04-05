package com.bluesoul.soulpower;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.CalendarContract;

import java.util.Calendar;

import static android.provider.CalendarContract.*;

/**
 * Created by chenjianhua on 2016/12/9.
 */

public class PublicIntent {
    private static PublicIntent pbIntentManager;
    public static PublicIntent getInstance(){
        if(pbIntentManager==null){
            pbIntentManager = new PublicIntent();
        }
        return  pbIntentManager;
    }

    /*创建闹钟*/
    public static void createAlarm(Context context,String message, int hour, int minutes){
        if (context==null){
            return;
        }
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,message)
                .putExtra(AlarmClock.EXTRA_HOUR,hour)
                .putExtra(AlarmClock.EXTRA_MINUTES,minutes);
        if (intent.resolveActivity(context.getPackageManager())!=null){
            context.startActivity(intent);
        }
    }

    /*创建定时器*/
    public static void startTimer(Context context,String message,int seconds){
        if (context==null){
            return;
        }
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE,message)
                .putExtra(AlarmClock.EXTRA_LENGTH,seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI,false);
        if (intent.resolveActivity(context.getPackageManager())!=null){
            context.startActivity(intent);
        }
    }

    /**/
    public static void showAlarms(Context context){
        if (context==null){
            return;
        }
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(context.getPackageManager())!=null){
            context.startActivity(intent);
        }
    }

    public static void addCalendarEvent(Context context, String title, String location, Calendar begin,Calendar end){
        if (context==null){
            return;
        }
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(Events.CONTENT_URI)
                .putExtra(Events.TITLE,title)
                .putExtra(Events.EVENT_LOCATION,location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,end);
        if (intent.resolveActivity(context.getPackageManager())!=null){
            context.startActivity(intent);
        }
    }

}
