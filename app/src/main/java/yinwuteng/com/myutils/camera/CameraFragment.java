package yinwuteng.com.myutils.camera;


import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import yinwuteng.com.myutils.R;

/**
 * Create By ywt
 * 2019/2/22.
 */
public class CameraFragment extends Fragment implements SurfaceHolder.Callback {
    private SurfaceView mSurficeView;
    private SurfaceHolder mHolder;
    private Camera camera;
    private boolean mIsSurfaceCreated = false;
    private static final int CAMERA_ID = 0; //选择后置摄像头


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        intiView(view);
        return view;
    }

    private void intiView(View view) {
        mSurficeView = view.findViewById(R.id.surface_view);
        mHolder = mSurficeView.getHolder();
        mHolder.addCallback(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        stopPreview();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsSurfaceCreated = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsSurfaceCreated = false;
    }

    private void startPreview() {
        if (camera != null || !mIsSurfaceCreated) {
            return;
        }

        camera = Camera.open(CAMERA_ID);
        Camera.Parameters parameters = camera.getParameters();
        //设置连续对焦
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        //获取手机支持的相片大小组合
        List<Camera.Size> picSize = camera.getParameters().getSupportedPictureSizes();

        int picLength = picSize.size();

        for (int i = 0; i < picLength; i++) {
            Camera.Size pSize = picSize.get(i);
            Log.v("MainActivity", "picWidth" + pSize.width + "pciHeight" + pSize.height);
        }
        int w = picSize.get(picSize.size() - 1).width;
        Log.d("test", String.valueOf(w));
        parameters.setPictureSize(picSize.get(picSize.size() - 1).width,
                picSize.get(picSize.size() - 1).height);
        // parameters.setPictureSize(320, 180);
        //  设置相机预览方向
        camera.setDisplayOrientation(0);
        //获取相机上面可以设置的图片大小
        //获取支持的图片预览大小
        List<Camera.Size> preSize = camera.getParameters().getSupportedPreviewSizes();
        for (int j = 0; j < preSize.size(); j++) {
            Camera.Size prSize = preSize.get(j);
            Log.v("MainActivity", "preWidth" + prSize.width + "preHeight" + prSize.height);
        }
        //        int pw = preSize.get(preSize.size()-1).width;
        //        Log.d("test", String.valueOf(pw));
        //        parameters.setPreviewSize(preSize.get(preSize.size()-1).width, preSize.get
        // (preSize.size()-1).height);
        camera.setParameters(parameters);
        try {
            camera.setPreviewDisplay(mHolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        camera.startPreview();
    }

    private void stopPreview() {
        //释放camera
        if (camera != null) {
            try {
                camera.setPreviewDisplay(null);
                camera.stopPreview();
                camera.release();
                camera = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        camera = null;
    }
}
