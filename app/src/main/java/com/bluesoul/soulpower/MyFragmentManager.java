package com.bluesoul.soulpower;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by chenjianhua on 2016/12/9.
 */

public class MyFragmentManager {
    private static MyFragmentManager myFragmentManager;
    public static MyFragmentManager getInstance(){
        if(myFragmentManager ==null){
            myFragmentManager = new MyFragmentManager();
        }
        return myFragmentManager;
    }

    public static void addFragment(Activity activity, int containerId, Fragment fragment){
        if (activity==null){
            return;
        }
        FragmentManager fm=activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(containerId,fragment);
        ft.commit();

    }

    //添加没有UI的fragment，后台运行
    public static void addFragmentWithoutUI(Activity activity,Fragment fragment,String tag){
        if (activity==null){
            return;
        }
        FragmentManager fm=activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(fragment,tag);
        ft.commit();

    }

    public static Fragment findFragmentById(Activity activity,int id){
        if (activity==null){
            return null;
        }
        FragmentManager fm=activity.getFragmentManager();
        return fm.findFragmentById(id);
    }

    public static Fragment findFragmentByTag(Activity activity,String tag){
        if (activity==null){
            return null;
        }
        FragmentManager fm=activity.getFragmentManager();
        return fm.findFragmentByTag(tag);
    }

}
