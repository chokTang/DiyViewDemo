package com.diy.mylibrary;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/**
 * 单位转换的工具类
 * Created by Firry on 2017/3/8.
 */
public class TransformUtil {
    /*将dp转化为像素*/
    public static int convertDpToPixel(Context mContext, float dp) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return (int)(dp*displayMetrics.density + 0.5f);
    }

    /*将像素转化为dp*/
    public static int convertPixelToDp(Context mContext, float pixel) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return (int)(pixel/displayMetrics.density + 0.5f);
    }

    /*将sp转化为像素*/
    public static int convertSpToPixel(Context mContext, float sp) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    /*将像素转化为sp*/
    public static int convertPixelToSp(Context mContext, float px) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    /*将字符串转化为数字*/
    public static int convertStrToInt(String str) {
        if(TextUtils.isEmpty(str)) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }
}