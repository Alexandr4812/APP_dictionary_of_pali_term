package com.example.dictionary_of_pali_term;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.os.Handler;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

public class RulesBhikkhuPatimokhaParajikaActivity extends AppCompatActivity {

    private TextView textMaxTimeParajika;
    private TextView textCurrentPositionParajika;

    private Button buttonStartParajika;
    private Button buttonStopParajika;
    private Button buttonRewindParajika;
    private Button buttonFastForwardParajika;
    private Button buttonHomeParajika;
    private Button buttonBackParajika;
    private Button buttonPauseParajika;

    private SeekBar seekBarParajika;
    private MediaPlayer mediaPlayer;
    private Handler threadHandler = new Handler();

    private ScrollView scrollTextParajika1;
    private ScrollView scrollTextParajika2;
    private ScrollView scrollTextParajika3;
    private ScrollView scrollTextParajika4;

    private int flagParajika1;
    private int flagParajika2;
    private int flagParajika3;
    private int flagParajika4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_parajika);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.textMaxTimeParajika = (TextView) findViewById(R.id.textMaxTimeParajika);
        this.textCurrentPositionParajika = (TextView) findViewById(R.id.textCurrentPositionParajika);

        this.buttonStartParajika = (Button) findViewById(R.id.buttonPlayParajika);
        this.buttonStopParajika = (Button) findViewById(R.id.buttonStopParajika);
        this.buttonPauseParajika = (Button) findViewById(R.id.buttonPauseParajika);
        this.buttonRewindParajika = (Button) findViewById(R.id.buttonRewindParajika);
        this.buttonFastForwardParajika = (Button) findViewById(R.id.buttonFastForwardParajika);

        this.scrollTextParajika1 = findViewById(R.id.viewScrollPatimokhaParajika1);
        this.scrollTextParajika2 = findViewById(R.id.viewScrollPatimokhaParajika2);
        this.scrollTextParajika3 = findViewById(R.id.viewScrollPatimokhaParajika3);
        this.scrollTextParajika4 = findViewById(R.id.viewScrollPatimokhaParajika4);

        this.seekBarParajika = findViewById(R.id.seekBarParajika);

        this.buttonStartParajika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()) {
                    return;
                }

                int duration = mediaPlayer.getDuration();
                int currentPosition = mediaPlayer.getCurrentPosition();

                if(currentPosition== 0)  {
                    seekBarParajika.setMax(duration);
                    String maxTimeString = millisecondsToString(duration);
                    textMaxTimeParajika.setText(maxTimeString);
                } else if(currentPosition== duration)  {
                    mediaPlayer.reset();
                }

                UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
                threadHandler.postDelayed(updateSeekBarThread,100);

                mediaPlayer.start();
                seekBarParajika.setVisibility(View.VISIBLE);
                textMaxTimeParajika.setVisibility(View.VISIBLE);
                textCurrentPositionParajika.setVisibility(View.VISIBLE);
                buttonStopParajika.setVisibility(View.VISIBLE);
                buttonRewindParajika.setVisibility(View.VISIBLE);
                buttonFastForwardParajika.setVisibility(View.VISIBLE);
                buttonPauseParajika.setVisibility(View.VISIBLE);
                buttonStartParajika.setVisibility(View.INVISIBLE);
            }
        });

        this.buttonStopParajika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                seekBarParajika.setVisibility(View.INVISIBLE);
                textMaxTimeParajika.setVisibility(View.INVISIBLE);
                textCurrentPositionParajika.setVisibility(View.INVISIBLE);
                buttonStopParajika.setVisibility(View.INVISIBLE);
                buttonRewindParajika.setVisibility(View.INVISIBLE);
                buttonFastForwardParajika.setVisibility(View.INVISIBLE);
                buttonPauseParajika.setVisibility(View.INVISIBLE);
                buttonStartParajika.setVisibility(View.VISIBLE);
            }
        });

        this.buttonPauseParajika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                buttonStopParajika.setVisibility(View.INVISIBLE);
                buttonStartParajika.setVisibility(View.VISIBLE);
            }
        });

        this.buttonRewindParajika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRewind( );
            }
        });
        this.buttonFastForwardParajika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doFastForward( );
            }
        });
    }

    public void toBhikhuPatimokhaParajika1(View view) {
        this.flagParajika1 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika1.setVisibility(View.VISIBLE);

        this.buttonBackParajika = (Button) findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = (Button) findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = (Button) findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika2(View view) {
        this.flagParajika2 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika2.setVisibility(View.VISIBLE);

        this.buttonBackParajika = (Button) findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = (Button) findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = (Button) findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika3(View view) {
        this.flagParajika3 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika3.setVisibility(View.VISIBLE);

        this.buttonBackParajika = (Button) findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = (Button) findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = (Button) findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika4(View view) {
        this.flagParajika4 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika4.setVisibility(View.VISIBLE);

        this.buttonBackParajika = (Button) findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = (Button) findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = (Button) findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void tobackParajikaAct(View view) {
        this.flagParajika1 = 0;
        this.flagParajika2 = 0;
        this.flagParajika3 = 0;
        this.flagParajika4 = 0;

        this.scrollTextParajika1.setVisibility(View.INVISIBLE);
        this.scrollTextParajika2.setVisibility(View.INVISIBLE);
        this.scrollTextParajika3.setVisibility(View.INVISIBLE);
        this.scrollTextParajika4.setVisibility(View.INVISIBLE);

        this.buttonBackParajika.setVisibility(View.INVISIBLE);
        this.buttonHomeParajika.setVisibility(View.INVISIBLE);
        this.buttonStartParajika.setVisibility(View.INVISIBLE);
        this.buttonStopParajika.setVisibility(View.INVISIBLE);
        this.buttonPauseParajika.setVisibility(View.INVISIBLE);
        this.buttonRewindParajika.setVisibility(View.INVISIBLE);
        this.buttonFastForwardParajika.setVisibility(View.INVISIBLE);
        this.seekBarParajika.setVisibility(View.INVISIBLE);
        this.textMaxTimeParajika.setVisibility(View.INVISIBLE);
        this.textCurrentPositionParajika.setVisibility(View.INVISIBLE);

        this.mediaPlayer.pause();
    }

    private MediaPlayer changeSong () {
        MediaPlayer result = new MediaPlayer();
        if (this.flagParajika1 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_1);
        }
        else if (this.flagParajika2 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_2);
        }
        else if (this.flagParajika3 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_3);
        }
        else if (this.flagParajika4 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_4);
        }
        return result;
    }

    private String millisecondsToString(int milliseconds)  {
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return seconds + " sec";
    }

    private void doRewind( )  {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        int SUBTRACT_TIME = 5000;

        if(currentPosition - SUBTRACT_TIME > 0 )  {
            this.mediaPlayer.seekTo(currentPosition - SUBTRACT_TIME);
        }
    }

    private void doFastForward( )  {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        int ADD_TIME = 5000;

        if(currentPosition + ADD_TIME < duration)  {
            this.mediaPlayer.seekTo(currentPosition + ADD_TIME);
        }
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaActivity.class);
        startActivity(intent);
        finish();
        this.mediaPlayer.pause();
    }

    public void toRulesPatimokhaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaActivity.class);
        startActivity(intent);
        finish();
    }

    class UpdateSeekBarThread implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            textCurrentPositionParajika.setText(currentPositionStr);

            seekBarParajika.setProgress(currentPosition);

            threadHandler.postDelayed(this, 50);
        }
    }
}