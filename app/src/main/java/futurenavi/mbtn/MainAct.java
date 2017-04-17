package futurenavi.mbtn;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import futurenavi.libbtnmenu.BtnMenuLayout;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainAct extends AppCompatActivity {
    BtnMenuLayout btnMenu41, btnMenu42, btnMenu43, btnMenu44,
            btnMenu31, btnMenu32, btnMenu33,
            btnMenu21, btnMenu22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        init01();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init01() {
        btnMenu41 = (BtnMenuLayout) findViewById(R.id.btn_menu41);
        btnMenu42 = (BtnMenuLayout) findViewById(R.id.btn_menu42);
        btnMenu43 = (BtnMenuLayout) findViewById(R.id.btn_menu43);
        btnMenu44 = (BtnMenuLayout) findViewById(R.id.btn_menu44);
        btnMenu41.addBtnNames("全部(21)", "未开始(10)", "进行中(10)", "已结束(1)").menuClicks(call);
        btnMenu42.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);
        btnMenu43.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);
        btnMenu44.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);

        btnMenu44.addBtnNames("全部(21)", "未开始(10)", "进行中(10)", "已结束(1)");

        btnMenu31 = (BtnMenuLayout) findViewById(R.id.btn_menu31);
        btnMenu32 = (BtnMenuLayout) findViewById(R.id.btn_menu32);
        btnMenu33 = (BtnMenuLayout) findViewById(R.id.btn_menu33);
        btnMenu31.addBtnNames("全部(21)", "未开始(10)", "进行中(10)", "已结束(1)").menuClicks(call);
        btnMenu32.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);
        btnMenu33.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);

        btnMenu21 = (BtnMenuLayout) findViewById(R.id.btn_menu21);
        btnMenu22 = (BtnMenuLayout) findViewById(R.id.btn_menu22);
        btnMenu21.addBtnNames("全部(21)", "未开始(10)", "进行中(10)", "已结束(1)").menuClicks(call);
        btnMenu22.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(call);
    }

    BtnMenuLayout.CallBack call = new BtnMenuLayout.CallBack() {

        @Override
        public void onClicks(Button btns) {
            Log.e("WZK", "点击的按钮是：" + btns.getText());
        }
    };
}
