package com.shd.shop.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shd.shop.R;


/**
 * Created by Administrator on 2017/6/23.
 */

public class CountDownView extends LinearLayout implements View.OnClickListener {
    private int msgWhat = 0x456;
    private Context mContext;
    private boolean isStart; //是否已经开始倒计时
    private int totalSecond = 60;//倒计时秒数
    private int currentSecond = 0;
    private TextView tv;


    public CountDownView(Context context) {
        this(context, null, 0);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.count_down_view, this);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                if (!isStart) {
                    tv.setEnabled(false);
                    if (null != listener) {
                        listener.toGetCodeListener();
                    }
                }
                break;
        }
    }


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == msgWhat) {
                currentSecond++;
                if (currentSecond >= totalSecond) {
                    end();
                } else {
                    tv.setText((totalSecond - currentSecond) + "s");
                    handler.sendEmptyMessageDelayed(msgWhat, 1000);
                }
            }
        }
    };


    /**
     * 未开启的时候，进行开启倒计时
     */
    public void start() {
        if (!isStart) {
            isStart = true;
            currentSecond = 0;
            handler.removeMessages(msgWhat);
            switchState(true);
            handler.sendEmptyMessageDelayed(msgWhat, 1000);
        }
    }

    /**
     * 结束倒计时,初始化
     */
    public void end() {
        isStart = false;
        currentSecond = 0;
        handler.removeMessages(msgWhat);
        switchState(false);
    }

    /**
     * 切换状态时候,切换UI
     */
    private void switchState(boolean toStart) {
        if (toStart) {
//            tv.setTextColor(Color.parseColor("#FA7065"));
            tv.setText(totalSecond + "s");
            tv.setEnabled(false);
        } else {
            tv.setText("获取验证码");
            tv.setEnabled(true);
        }
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public int getTotalSecond() {
        return totalSecond;
    }

    public void setTotalSecond(int totalSecond) {
        if (!isStart) {
            this.totalSecond = totalSecond;
        }
    }

    private OnClikcToGetCodeListener listener;

    public void setOnClikcToGetCodeListener(OnClikcToGetCodeListener listener) {
        this.listener = listener;
    }

    public static interface OnClikcToGetCodeListener {
        void toGetCodeListener();
    }

}
