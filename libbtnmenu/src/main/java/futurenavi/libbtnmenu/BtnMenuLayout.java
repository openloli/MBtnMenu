package futurenavi.libbtnmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by pf on 17/4/14.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BtnMenuLayout extends LinearLayout {

    private Drawable dLWhite, dLBule, dNWhite, dNWhite2, dNBule, dRWhite, dRBule;
    private Button btn01, btn02, btn03, btn04, btn05;
    private int textColor, numbers, defChecked;//字体颜色默认黑色,按钮个数默认4,默认选择第几个
    private float textSize;//字体大小-->默认12
    private CallBack call;
    private int color1 = 0XFF2d91f5, color2 = 0XFFFFFFFF;

    public BtnMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * 初始化
     * 获取用户设定数据
     * 初始化背景色
     * 创建btn
     */
    private void init(Context context, AttributeSet attrs) {
        this.setOrientation(HORIZONTAL);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BtnMenuLayout);
        textColor = a.getColor(R.styleable.BtnMenuLayout_textColor, color1);
        textSize = a.getDimension(R.styleable.BtnMenuLayout_textSize, 12);
        numbers = a.getInteger(R.styleable.BtnMenuLayout_numbers, 4);
        defChecked = a.getInteger(R.styleable.BtnMenuLayout_defChecked, 3);
        numbers = numbers > 4 ? 4 : numbers;
        defChecked = defChecked > 4 ? 4 : defChecked;
        initDrawable(context);
        createChilds(context, numbers);
        a.recycle();
    }

    /**
     * 初始化背景色
     */
    private void initDrawable(Context context) {
        //最左边 白色，蓝色
        dLWhite = ContextCompat.getDrawable(context, R.drawable.btn_bg_left_white);
        dLBule = ContextCompat.getDrawable(context, R.drawable.btn_bg_left_blue);
        //中间 白色，蓝色
        dNWhite = ContextCompat.getDrawable(context, R.drawable.btn_bg_no_white);
        dNBule = ContextCompat.getDrawable(context, R.drawable.btn_bg_no_blue);
        //最右边 白色，蓝色
        dRWhite = ContextCompat.getDrawable(context, R.drawable.btn_bg_right_white);
        dRBule = ContextCompat.getDrawable(context, R.drawable.btn_bg_right_blue);
    }

    /**
     * 初始化创建btn 支持2-5个
     */
    private void createChilds(Context context, int numbers) {
        //创建
        btn01 = createChild(context);
        btn02 = createChild(context);
        btn03 = createChild(context);
        btn04 = createChild(context);

        //字体大小
        setTextSizes();
        //名称
        setDefNames();
        //点击事件
        setONclicks();
        //不同条目的背景色
        setBackground(numbers);
        //加入
        addChildView();
    }


    /**
     * 创建单个btn
     */
    private Button createChild(Context context) {
        Button btn = new Button(context);
        LayoutParams params = new LayoutParams(0, -1, 1);
        btn.setLayoutParams(params);
        return btn;
    }

    /**
     * 设置btn字体大小-然而么有效果
     */
    private void setTextSizes(Button... btns) {
        for (Button btn : btns) {
            btn.setTextSize(textSize);
        }

        //试试
        btn01.setTextSize(12);
        btn02.setTextSize(12);
        btn03.setTextSize(12);
        btn04.setTextSize(12);
    }


    /**
     * 不同个数的btn背景色、字体颜色、默认选中处理
     */
    private void setBackground(int numbers) {

        //默认背景
        btn01.setBackground(dLWhite);
        btn02.setBackground(dNWhite);
        btn03.setBackground(dNWhite);
        btn04.setBackground(dRWhite);

        //设定字体颜色
        setTextColors();

        //只有两个条目时
        if (numbers == 2) {
            btn02.setVisibility(GONE);
            btn03.setVisibility(GONE);
        }
        //三个个条目时
        if (numbers == 3) {
            btn02.setVisibility(GONE);
        }

        //默认选择处理
        if (defChecked == 2) {
            if (numbers == 4) {
                btn02.setBackground(dNBule);
                btn02.setTextColor(color2);
            }
            if (numbers == 3) {
                btn03.setBackground(dNBule);
                btn03.setTextColor(color2);
            }
            if (numbers == 2) {
                btn04.setBackground(dRBule);
                btn04.setTextColor(color2);
            }
        } else if (defChecked == 3) {
            if (numbers == 3) {
                btn04.setBackground(dRBule);
                btn04.setTextColor(color2);
            } else {
                btn03.setBackground(dNBule);
                btn03.setTextColor(color2);
            }
        } else if (defChecked == 4) {
            btn04.setBackground(dRBule);
            btn04.setTextColor(color2);
        } else {
            btn01.setBackground(dLBule);
            btn01.setTextColor(color2);
        }
    }

    /**
     * 设置btn字体颜色
     */
    private void setTextColors() {
        btn01.setTextColor(textColor);
        btn02.setTextColor(textColor);
        btn03.setTextColor(textColor);
        btn04.setTextColor(textColor);
    }

    private void setTextColors(Button btn) {
        setTextColors();
        btn.setTextColor(color2);
    }

    /**
     * 设置btn默认名称
     */
    private void setDefNames() {
        btn01.setText("人");
        btn02.setText("生");
        btn03.setText("如");
        btn04.setText("戏");
    }


    /**
     * 创建单个btn
     */
    private void addChildView() {
        if (btn01 != null) {
            addView(btn01);
        }
        if (btn02 != null) {
            addView(btn02);
        }
        if (btn03 != null) {
            addView(btn03);
        }
        if (btn04 != null) {
            addView(btn04);
        }
    }


    /**
     * btn点击事件
     * 变更背景色
     * 启动回调
     */
    private void setONclicks() {
        btn01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                call.onClicks(btn01);
                editBtnBG(dLBule, dNWhite, dNWhite, dRWhite);
                setTextColors(btn01);
            }
        });
        btn02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                call.onClicks(btn02);
                editBtnBG(dLWhite, dNBule, dNWhite, dRWhite);
                setTextColors(btn02);
            }
        });
        btn03.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                call.onClicks(btn03);
                editBtnBG(dLWhite, dNWhite, dNBule, dRWhite);
                setTextColors(btn03);
            }
        });
        btn04.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                call.onClicks(btn04);
                editBtnBG(dLWhite, dNWhite, dNWhite, dRBule);
                setTextColors(btn04);
            }
        });

    }

    /**
     * 变更背景色
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void editBtnBG(Drawable d1, Drawable d2, Drawable d3, Drawable d4) {
        btn01.setBackground(d1);
        btn02.setBackground(d2);
        btn03.setBackground(d3);
        btn04.setBackground(d4);
    }


    /**
     * 链式方法-对外方法
     * 设置btn名称
     */
    public BtnMenuLayout addBtnNames(String name1, String name2, String name3, String name4) {
        btn01.setText(name1);
        btn02.setText(name2);
        btn03.setText(name3);
        btn04.setText(name4);
        return BtnMenuLayout.this;
    }

    /**
     * 回掉方法
     */
    public void menuClicks(CallBack call) {
        this.call = call;
    }

    /**
     * 回掉接口
     */
    public interface CallBack {
        void onClicks(Button btns);
    }


}
