package yinwuteng.com.myutils.map;




public class StgLocationClient {
//    private TextureMapView mapView;
//    private BaiduMap mBaiduMap;
//
//    /**
//     * 百度定位所需要的初始化参数
//     */
//    private LocationClient mLocationClient;
//
//    private StgLocationListener mLocationListener;
//
//    /**
//     * 国测局加密经纬度坐标,百度加密经纬度坐标,百度加墨墨卡托坐标
//     */
//    private final String[] tempcoors = new String[]{"gcj02", "bd09ll", "bd09"};
//
//    /**
//     * 定时定位时间间隔
//     */
//    private int span = 1000;
//
//    /**
//     * 是否进行反编码
//     */
//    private boolean isNeedAddr = true;
//    private MyLocationConfiguration.LocationMode mCurrentMode =
//            MyLocationConfiguration.LocationMode.NORMAL;
//    private Context context;
//
//    public StgLocationClient(TextureMapView mapView, Context context) {
//        this.mapView = mapView;
//        this.mBaiduMap = mapView.getMap();
//        this.context = context;
//        if (mBaiduMap == null) {
//            return;
//        }
//
//        // 开启定位图层
//        mBaiduMap.setMyLocationEnabled(true);
//        mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(mCurrentMode, true, null));
//
//        mLocationClient = new LocationClient(ZxkjApplication.getInstance());
//
//        mLocationListener = new StgLocationListener(mapView);
//        mLocationClient.registerLocationListener(mLocationListener);
//
//    }
//
//
//    /**
//     * 获取当前位置信息
//     */
//    public BDLocation getLocation() {
//        if (mLocationListener != null) {
//            return mLocationListener.getLocation();
//        }
//        return null;
//    }
//
//    public void startLocation() {
//        if (mapView != null && mBaiduMap != null) {
//            InitLocation();
//            mLocationClient.start();
//        }
//    }
//
//    public void stopLocation() {
//        if (mLocationClient != null) {
//            mLocationClient.stop();
//        }
//    }
//
//    private void InitLocation() {
//
//        LocationClientOption option = new LocationClientOption();
//        ConnectivityManager cManager =
//                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo info = cManager.getActiveNetworkInfo();
//        if (info != null && info.isAvailable()) {
//            //设置高精度定位模式(支持网络定位和GPS同时定位)
//            option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//            option.setCoorType(tempcoors[1]);// 返回的定位结果是百度经纬度
//            option.setScanSpan(span);// 设置发起定位请求的间隔时间为1000ms
//            option.setIsNeedAddress(isNeedAddr); //设置需要地址信息
//            option.setNeedDeviceDirect(true); //设置需要设备方向
//        } else {
//            // 网络未连接则开启GPS定位
//            option.setOpenGps(true);
//            option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors); //开启GPS定位
//            option.setCoorType(tempcoors[1]);// 返回的定位结果是百度经纬度，
//            option.setScanSpan(span);// 设置发起定位请求的间隔时间为1000ms
//            option.setIsNeedAddress(isNeedAddr);
//            option.setNeedDeviceDirect(true);
//            Toast.makeText(context, "开启GPS定位可能会消耗较长时间", Toast.LENGTH_SHORT).show();
//        }
//        mLocationClient.setLocOption(option);
//    }
//
//
//    /**
//     * 获取经纬时间间隔
//     *
//     * @param span 时间间隔,单位毫秒
//     */
//    public void setSpan(int span) {
//        this.span = span;
//    }
//
//    public void setNeedAddr(boolean isNeedAddr) {
//        this.isNeedAddr = isNeedAddr;
//    }
//
//    public void setOrientationListener(StgOrienationListener orientationListener) {
//        if (mLocationListener != null && orientationListener != null) {
//            mLocationListener.setOrientationListener(orientationListener);
//        }
//    }
}
