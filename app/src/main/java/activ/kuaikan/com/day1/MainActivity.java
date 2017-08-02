package activ.kuaikan.com.day1;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        ft.add(R.id.frame, fragment1,"fragment1");
        ft.commit();

        rb1.setChecked(true);

        rg.setOnCheckedChangeListener(this);


    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (checkedId){
            case R.id.rb1:
                //显示第一个Fragment并关闭动画效果
                rb1.setChecked(true);
                if(!fragment1.isAdded()){
                    ft.add(R.id.frame, fragment1,"fragment1");
                }
                ft.show(fragment1);
                ft.hide(fragment2);
                ft.hide(fragment3);
                ft.hide(fragment4);
                ft.commit();
                break;
            case R.id.rb2:
                //显示第一个Fragment并关闭动画效果
                rb2.setChecked(true);
                if(!fragment2.isAdded()){
                    ft.add(R.id.frame, fragment2,"fragment2");
                }
                ft.show(fragment2);
                ft.hide(fragment1);
                ft.hide(fragment3);
                ft.hide(fragment4);
                ft.commit();

//                rb2.setTextColor(Color.YELLOW);
                break;
            case R.id.rb3:
                //显示第一个Fragment并关闭动画效果
                rb3.setChecked(true);
                if(!fragment3.isAdded()){
                    ft.add(R.id.frame, fragment3,"fragment3");
                }
                ft.show(fragment3);
                ft.hide(fragment2);
                ft.hide(fragment1);
                ft.hide(fragment4);
                ft.commit();

//                rb3.setTextColor(Color.YELLOW);
                break;
            case R.id.rb4:
                //显示第一个Fragment并关闭动画效果
                rb4.setChecked(true);
                if(!fragment4.isAdded()){
                    ft.add(R.id.frame, fragment4,"fragment4");
                }
                ft.show(fragment4);
                ft.hide(fragment2);
                ft.hide(fragment3);
                ft.hide(fragment1);
                ft.commit();

//                rb4.setTextColor(Color.YELLOW);
                break;

        }
    }
}
