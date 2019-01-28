package yinwuteng.com.myutils.map;



//public class StgLocationListener implements BDLocationListener {
//    private TextureMapView mapView;
//    private BaiduMap mBaiduMap;
//
//    private BDLocation location;
//
//    private boolean bIsFirstLoc = true;// 是否首次定位
//    private long lLastTime; //监听循环时间
//
//    public StgLocationListener(TextureMapView mapView) {
//        if (mapView == null) {
//            return;
//        }
//
//        this.mapView = mapView;
//        this.mBaiduMap = mapView.getMap();
//    }
//
//    public BDLocation getLocation() {
//        return location;
//    }
//
//    public void onReceiveLocation(BDLocation location) {
//        //mapview销毁后不在处理新接收的位置
//        if (location == null && mapView == null) {
//            return;
//        }
//        this.location = location;
//
//        float degree = mBaiduMap.getLocationData() == null ? 0 : mBaiduMap.getLocationData().direction;
//
//        setLocationData(degree);
//        MyLocationData locData = new MyLocationData.Builder()
//                .accuracy(5) //设置定位光圈距离
//                // 此处设置开发者获取到的方向信息，顺时针0-360
//                .direction(100).latitude(location.getLatitude())
//                .longitude(location.getLongitude()).build();
//        mBaiduMap.setMyLocationData(locData); //设置定位数据
//
//        if (bIsFirstLoc) {
//            bIsFirstLoc = false;
//            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
//            MapStatus.Builder builder = new MapStatus.Builder();
//            builder.target(ll).zoom(18.0f);
//            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
//        }
//
//    }
//
//    public void setOrientationListener(StgOrienationListener orientationListener) {
//        if (orientationListener == null) {
//            return;
//        }
//
//        orientationListener.setOnOrientationListener(new StgOrienationListener.OnOrientationListener() {
//            @Override
//            public void onOrientationChanged(float x) {
//
//                if (location == null) {
//                    return;
//                }
//                setLocationData(x);
//            }
//        });
//
//    }
//
//    private synchronized void setLocationData(float degree) {
//        long time = System.currentTimeMillis();
//        if (time - lLastTime < 300) {
//        return;
//        }
//        //设置开发者获取到的方向信息
//        MyLocationData data = new MyLocationData.Builder().accuracy(location.getRadius())
//                .direction(degree).latitude(location.getLatitude()).longitude(location.getLongitude()).build();
//        mBaiduMap.setMyLocationData(data);
//        lLastTime = time;
//    }
//}
