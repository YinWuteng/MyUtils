package yinwuteng.com.myutils.mqtt;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.greenrobot.eventbus.EventBus;

/**
 * Create By ywt
 * 2019/1/22.
 */
public class MQTTService extends Service {

    private static final String TAG = "MQTTService";
    private static MqttAndroidClient client;
    private MqttConnectOptions conOption;
    private static final String host = "tcp://192.168.0.111:1883";
    private static final String IauTopic = "iau/tohmi"; //hmi端接收iau端主题
    private static final String HmiTopic = "iau/toiau"; //hmi端发送消息到iau端主题
    private String clientId = "Client_"+ (int) ((Math.random() * 9 + 1) * 100000);

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //初始化mqtt
        init();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void init() {
        //初始化client
        client = new MqttAndroidClient(this, host, clientId);
        conOption = new MqttConnectOptions();
        //断开后，是否自动连接
        conOption.setAutomaticReconnect(true);
        //清除缓存
        conOption.setCleanSession(true);
        //设置超时时间
        conOption.setConnectionTimeout(5);
        //心跳包发送间隔
        conOption.setKeepAliveInterval(10);
        //设置MQTT监听并接收消息
        client.setCallback(mqttCallback);
        doClientConnection();
    }


    @Override
    public void onDestroy() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    private void doClientConnection() {
        if (!client.isConnected() && isConnectIsNormal()) {
            try {
                client.connect(conOption, null, iMqttActionListener);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息
     *
     * @param msg 消息内容
     */
    public static void publish(String msg) {
        int qos = 2;

        try {
            if (client != null) {
                client.publish(HmiTopic, msg.getBytes(), qos, false);
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    //MQTT是否连接成功
    private IMqttActionListener iMqttActionListener = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            Log.d(TAG, "连接成功");
            try {
                //订阅myTopic话题
                client.subscribe(IauTopic, 1);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            //连接失败，重新连接
            doClientConnection();

        }
    };

    //MQTT监听并接收消息
    private MqttCallback mqttCallback = new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {
            //重新连接
            doClientConnection();
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {

            String str1 = new String(message.getPayload());
            MQTTMessage msg = new MQTTMessage();
            msg.setMessage(str1);
            EventBus.getDefault().post(msg);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {

        }
    };

    /***
     * 判断网络是否连接
     */
    private boolean isConnectIsNormal() {
        ConnectivityManager manager =
                (ConnectivityManager) this.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            String name = info.getTypeName();
            Log.d(TAG, "MQTT当前网络名称" + name);
            return true;
        } else {
            Log.d(TAG, "MQTT没有可用网络");
            return false;
        }
    }
}
