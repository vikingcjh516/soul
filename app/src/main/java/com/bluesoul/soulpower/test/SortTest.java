package com.bluesoul.soulpower.test;

import com.bluesoul.soulpower.log.LogUtil;
import com.bluesoul.soulpower.util.SortTool;

import java.util.Arrays;

/**
 * Created by chenjianhua on 2017/4/24.
 */

public class SortTest {

    public static void testInsertSort(){
        int a[] ={31,41,59,26,40,58,1,3399,4,52,77,25};
        /*LogUtil.print("init:"+Arrays.toString(a));
        SortTool.insertSortReverse(a);
        LogUtil.print("out:"+Arrays.toString(a));

        LogUtil.print("bubble-sort:"+Arrays.toString(a));
        SortTool.bubbleSort(a);*/

        LogUtil.print("quick-sort:"+Arrays.toString(a));
        SortTool.quickSort(a);
    }
}
