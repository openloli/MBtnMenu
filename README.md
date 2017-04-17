# MBtnMenu

一款简单使用的自定义菜单，具体如图：

<!-- ![IOS分分种搞定的效果](http://okbrselg1.bkt.clouddn.com/iamge/ios_menu.png =200x) -->
![Android自定义的效果](http://okbrselg1.bkt.clouddn.com/image/android_menu.png )

### 使用步骤：
## Step 1. 在Project build.gradle 文件中添加以下代码
``` java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
		}
	}

```

## Step 2. 在APP build.gradle 文件中添加以下代码
 
``` java
    dependencies {
	       compile 'com.github.android-pf:MBtnMenu:v2.0'
	}
```

## Step 3. 在具体使用的xml中,
其中顶层布局中需要写 ： xmlns:menu="http://schemas.android.com/apk/res-auto"
defChecked 表示默认选中 numbers 表示几个按钮 目前 支持2-4个按钮 另外还有字体颜色，字体大小等属性
``` java
  //切记顶层布局中需要该代码
  <LinearLayout
      xmlns:menu="http://schemas.android.com/apk/res-auto"
      ...>
  
   <futurenavi.libbtnmenu.BtnMenuLayout
        android:id="@+id/btnMenu"
        android:layout_width="match_parent"
        android:layout_height="32dp"
        menu:defChecked="2"
        menu:numbers="4"
        menu:textSize="12sp"/>
```

## Step 4. 在代码中使用
 
``` java
        btnMenu = (BtnMenuLayout) findViewById(R.id.btnMenu);
 
      
        btnMenu.addBtnNames("全部", "未开始", "进行中", "已结束").menuClicks(new  BtnMenuLayout.CallBack(){
            @Override
            public void onClicks(Button btns) {
                //具体的处理方案
            }
        });
        //需要具体个数时，可再次调用addBtnNames方法
         btnMenu.addBtnNames("全部(21)", "未开始(10)", "进行中(10)", "已结束(1)").menuClicks(call);
```


### 实现思路 
由于时间关系，具体的实现大家可以看**源码**，
其实非常的简单，有时间在回来书写思路。
PS：美工设计这个菜单后，IOS分分钟搞定，Android还要自定义....现在好了，也能分分钟搞定了
（也可能是我造轮子了，不过我确实木有发现有）。
有不足的地方还请多多指教。
 

  <!-- [1]: http://oddbiem8l.bkt.clouddn.com/mvp.png -->
  <!-- [2]: http://oddbiem8l.bkt.clouddn.com/project.png -->
  <!-- [3]: http://oddbiem8l.bkt.clouddn.com/mvp%E4%B8%80%E4%B8%AA%E8%AF%B7%E6%B1%82%E7%9A%84%E8%BF%87%E7%A8%8B.png -->
  <!-- [4]: http://www.jianshu.com/u/aa53f5d59037 -->
  <!-- [5]: http://www.jianshu.com/p/a7635e39c5ac -->
  <!-- [6]: http://www.jianshu.com/p/cc7ae2f96b64 -->
  <!-- [7]: http://www.jianshu.com/p/92ae9fb83e74 -->
