package com.dhammamobile.dictionary_of_pali_term.Teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class TeacherActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_teacher);


        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView im1 =findViewById(R.id.img_1);
        Button button1 = findViewById(R.id.button_teacher_about);
        ImageView im2 =findViewById(R.id.img_2);
        Button button2 = findViewById(R.id.button_lecture1);
        Button button3 = findViewById(R.id.button_lecture2);
        Button button4 = findViewById(R.id.button_lecture3);
        Button button5 = findViewById(R.id.button_lecture4);
        Button button6 = findViewById(R.id.button_lecture5);
        Button button7 = findViewById(R.id.button_lecture6);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        im1.startAnimation(slideDown);
        button1.startAnimation(slideFromLeftAnimation);
        im2.startAnimation(slideFromRightAnimation);
        button2.startAnimation(slideFromLeftAnimation);
        button3.startAnimation(slideFromRightAnimation);
        button4.startAnimation(slideFromLeftAnimation);
        button5.startAnimation(slideFromRightAnimation);
        button6.startAnimation(slideFromLeftAnimation);
        button7.startAnimation(slideFromRightAnimation);


    }

    protected void onResume() {
        super.onResume();
    }

    public void toTeacherAboutAct(View view){
        startIntentActivityAndFinish(TeacherAboutActivity.class);
    }

    public void toTeacherLec1Act(View view) {
        startIntentActivityAndFinish(TeacherLec1Activity.class);
    }
    public void toTeacherLec2Act(View view) {
        startIntentActivityAndFinish(TeacherLec2Activity.class);
    }
    public void toTeacherLec3Act(View view) {
        startIntentActivityAndFinish(TeacherLec3Activity.class);
    }

    public void toTeacherLec4Act(View view) {
        startIntentActivityAndFinish(TeacherLec4Activity.class);
    }

    public void toTeacherLec5Act(View view) {
        startIntentActivityAndFinish(TeacherLec5Activity.class);
    }

    public void toTeacherLec6Act(View view) {
        startIntentActivityAndFinish(TeacherLec6Activity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }
}