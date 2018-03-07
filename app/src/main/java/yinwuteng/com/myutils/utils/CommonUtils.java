package yinwuteng.com.myutils.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by yinwuteng on 2018/3/7.
 * 公共工具类
 */

public class CommonUtils {

    /**
     * 读/写权限
     *
     * @return 返回读写权限是否能够操作结果
     */
    public static boolean isExternalStorageWritable() {
        //获得外部存储状态
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /**
     * 只读权限
     *
     * @return 返回只读权限结果
     */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    /**
     * 图片压缩
     *
     * @param res       资源
     * @param resId     图片资源id号
     * @param reqWidth  需要的宽度
     * @param reqHeight 需要的高度
     * @return
     */
    public static Bitmap decodeSampledBitmapForomResource(Resources res, int resId, int reqWidth, int reqHeight) {
        //首先通过inJusDecodebounds=true来获得图片的尺寸
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        //根据图片分辨率以及我们实际需要展示的大小，计算压缩率
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        //设置压缩率并解码
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * 计算压缩率
     *
     * @param options   options
     * @param reqWidth  需要的宽度
     * @param reqHeight 需要的高度
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        //等比压缩
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int haldWeight = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (haldWeight / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    /**
     * 获取屏幕宽度
     * @param context 上下文
     * @return 返回宽度
     */
    public static int getScreenWidth(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics=new DisplayMetrics();
        assert wm != null;
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context 上下文
     * @return 返回高度
     */
    public static int getScreenHeight(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics=new DisplayMetrics();
        assert  wm!=null;
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return  outMetrics.heightPixels;
    }
}
