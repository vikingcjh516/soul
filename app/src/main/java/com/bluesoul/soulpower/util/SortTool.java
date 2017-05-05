package com.bluesoul.soulpower.util;


import android.util.Log;

import com.bluesoul.soulpower.log.LogUtil;

import java.util.Arrays;

/**
 * Created by chenjianhua on 2017/4/24.
 */

public class SortTool {

    //插入排序，升序
    public static void insertSort(int[] a){
        int i=0,j=0;
        int key = 0;
        for (j=1;j<a.length;j++){
            key = a[j];
            i = j-1;
            while (i>=0 && a[i]>key){
                a[i+1]=a[i];
                i=i-1;
                a[i+1]=key;

                LogUtil.print(Arrays.toString(a));
            }
        }

    }

    //插入排序，降序
    public static void insertSortReverse(int[] a){
        int i=0,j=0;
        int key = 0;
        for (j=1;j<a.length;j++){
            key = a[j];
            i = j-1;
            while (i>=0 && a[i]<key){
                a[i+1]=a[i];
                i=i-1;
                a[i+1]=key;

                LogUtil.print(Arrays.toString(a));
            }
        }
    }
    
    //冒泡排序
    public static void bubbleSort(int a[]){
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j]>a[j+1]){
                    temp = a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
                LogUtil.print(Arrays.toString(a));
            }
        }
    }


    //快速排序
    public static void quickSort(int a[]){
        dQuickSort(a,0,a.length-1);
    }
    public static void dQuickSort(int a[],int low,int high){
        if (low<high){
            int middle = getMiddle(a,low,high);
            LogUtil.print("low="+low);
            dQuickSort(a,low,middle-1);
            dQuickSort(a,middle+1,high);
        }
    }
    public static int getMiddle(int a[],int low,int high){
        int temp = a[low];
        while (low<high){
            while (low<high && a[high]>=temp){
                high--;
            }
            a[low]=a[high];
            while(low<high && a[low]<=temp){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=temp;

        LogUtil.print(Arrays.toString(a));

        return low;
    }
}
