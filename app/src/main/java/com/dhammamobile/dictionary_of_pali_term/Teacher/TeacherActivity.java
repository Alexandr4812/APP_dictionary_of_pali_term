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
        Button button1_12 = findViewById(R.id.button_lecture1_12);
        Button button8 = findViewById(R.id.button_lecture7);
        Button button9 = findViewById(R.id.button_lecture8);
        Button button10 = findViewById(R.id.button_lecture9);
        Button button11 = findViewById(R.id.button_lecture10);
        Button button2 = findViewById(R.id.button_lecture1);
        Button button3 = findViewById(R.id.button_lecture2);
        Button button4 = findViewById(R.id.button_lecture3);
        Button button5 = findViewById(R.id.button_lecture4);
        Button button6 = findViewById(R.id.button_lecture5);
        Button button7 = findViewById(R.id.button_lecture6);
        Button button12 = findViewById(R.id.button_lecture11);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        im1.startAnimation(slideDown);
        button1.startAnimation(slideFromLeftAnimation);
        im2.startAnimation(slideFromRightAnimation);
        button1_12.startAnimation(slideFromLeftAnimation);
        button8.startAnimation(slideFromRightAnimation);
        button9.startAnimation(slideFromLeftAnimation);
        button10.startAnimation(slideFromRightAnimation);
        button11.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        button5.startAnimation(slideFromLeftAnimation);
        button6.startAnimation(slideFromRightAnimation);
        button7.startAnimation(slideFromLeftAnimation);
        button12.startAnimation(slideFromRightAnimation);
    }

    protected void onResume() {
        super.onResume();
    }

    public void toTeacherAboutAct(View view){
        startIntentActivityAndFinish(TeacherAboutActivity.class);
    }

    public void toTeacherLec112Act(View view) {
        startIntentActivityAndFinish(TeacherLec112Activity.class);
    }

    public void toTeacherLec212Act(View view) {
        startIntentActivityAndFinish(TeacherLec212Activity.class);
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

    public void toTeacherLec7Act(View view) {
        startIntentActivityAndFinish(TeacherLec7Activity.class);
    }

    public void toTeacherLec8Act(View view) {
        startIntentActivityAndFinish(TeacherLec8Activity.class);
    }

    public void toTeacherLec9Act(View view) {
        startIntentActivityAndFinish(TeacherLec9Activity.class);
    }

    public void toTeacherLec10Act(View view) {
        startIntentActivityAndFinish(TeacherLec10Activity.class);
    }

    public void toTeacherLec11Act(View view) {
        startIntentActivityAndFinish(TeacherLec11Activity.class);
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