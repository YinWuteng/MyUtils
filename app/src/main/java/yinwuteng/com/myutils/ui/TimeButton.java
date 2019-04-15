package yinwuteng.com.myutils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import yinwuteng.com.myutils.R;

/**
 * 自定义倒计时按钮
 */
public class TimeButton extends AppCompatButton {
    /**
     * 总时间
     */
    private int total;
    /**
     * 时间间隔
     */
    private int interval;
    private String text;

    public TimeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性并赋值
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TimeButton);
        //总时间
        total = typedArray.getInteger(R.styleable.TimeButton_tb_totalTime, 60000);
        //间隔时间
        interval = typedArray.getInteger(R.styleable.TimeButton_tb_timeInterval, 1000);
        text = typedArray.getString(R.styleable.TimeButton_tb_after_text);
        setBackgroundResource(R.drawable.bg_timebutton);
        typedArray.recycle();
    }

    /**
     * 开始执行
     */
    public void start(){
        TimeCount timeCount=new TimeCount(total,interval);
        timeCount.start();
    }
    private class TimeCount extends CountDownTimer {
        private long countDownInterval;

        TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval); //参数依次为总时长和计时的时间
            this.countDownInterval = countDownInterval;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //计时过程中显示
            setEnabled(false);
            String result = millisUntilFinished / countDownInterval + "秒";
            setText(result);
        }

        @Override
        public void onFinish() {
            //计时完毕时触发
            setEnabled(true);
            setText(text);
        }
    }
}
