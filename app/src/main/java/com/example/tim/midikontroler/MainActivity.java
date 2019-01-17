package com.example.tim.midikontroler;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public int bpm;
    private Button notation;
    public ArrayList<Boolean> Nhihat = new ArrayList<>();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SoundPool soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        final int shihat = soundPool.load(this, R.raw.hihat, 1);
        final int scymbal = soundPool.load(this, R.raw.cymbal, 1);
        final int stom1 = soundPool.load(this, R.raw.tom1, 1);
        final int stom2 = soundPool.load(this, R.raw.tom2, 1);
        final int sbass = soundPool.load(this, R.raw.bass, 1);
        final int ssnare = soundPool.load(this, R.raw.snare, 1);


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.tick);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.tick);
        final EditText BPM =  (EditText) findViewById(R.id.editText);





        final Handler handler = new Handler();
        final Runnable myRunnable = new Runnable() {
            @Override
            public void run() {

                Log.i("main","Runabl");
                if(mp.isPlaying())
                    mp2.start();
                else
                    mp.start();
                handler.postDelayed(this,bpm);

            }
        };

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked) {
                    Log.i("main","Checked");
                    if(BPM.getText().toString().equals("")) {
                        BPM.setText("100");
                        Log.i("main", String.valueOf((int)((1.0*60 /100)*1000)));

                    }



                    handler.postDelayed(myRunnable,0);






                    bpm=(int)((60.0/Integer.parseInt(BPM.getText().toString()))*1000);
                    Log.i("main",Integer.toString(bpm));
                } else {
                    Log.i("main","NOTChecked");
                    handler.removeCallbacks(myRunnable);

                }
            }
        });


        final Button hihat = findViewById(R.id.button1);
        hihat.setSoundEffectsEnabled(false);
        hihat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(shihat,1, 1, 0, 0, 1);

                return false;
            }

        });





        final Button cymbal = findViewById(R.id.button2);
        cymbal.setSoundEffectsEnabled(false);
        cymbal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(scymbal,1, 1, 0, 0, 1);

                return false;
            }

        });

        final Button tom1 = findViewById(R.id.button3);
        tom1.setSoundEffectsEnabled(false);
        tom1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(stom1,1, 1, 0, 0, 1);

                return false;
            }

        });

        final Button tom2 = findViewById(R.id.button4);
        tom2.setSoundEffectsEnabled(false);
        tom2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(stom2,1, 1, 0, 0, 1);

                return false;
            }

        });

        final Button bass = findViewById(R.id.button5);
        bass.setSoundEffectsEnabled(false);
        bass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(sbass,1, 1, 0, 0, 1);

                return false;
            }

        });

        final Button snare = findViewById(R.id.button6);
        snare.setSoundEffectsEnabled(false);
        snare.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    soundPool.play(ssnare,1, 1, 0, 0, 1);

                return false;
            }

        });


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.track,android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

       notation =(Button) findViewById(R.id.buttonN);
       notation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               OpenActivity2();
           }
       });














    }


   public MediaPlayer bt1 = null;
   public MediaPlayer bt2 = null;
   public MediaPlayer bt3 = null;

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(bt1==null)
            bt1 = MediaPlayer.create(this, R.raw.b1);
        if(bt2==null)
            bt2 = MediaPlayer.create(this, R.raw.b2);
        if(bt3==null) {
            bt3 = MediaPlayer.create(this, R.raw.b3);
            Log.i("main","bt3 create");
        }


        if(position==0){
            Log.i("main","pos 00000000000");
            if(bt1.isPlaying())
                bt1.pause();

            if(bt2.isPlaying())
                bt2.pause();

            if(bt3.isPlaying())
                bt3.pause();
        }
        if(position==1){
            if(bt1.isPlaying())
                bt1.pause();

            if(bt2.isPlaying())
                bt2.pause();

            if(bt3.isPlaying())
                bt3.pause();

            bt1.start();

        }
        if(position == 2){
            if(bt1.isPlaying())
                bt1.pause();

            if(bt2.isPlaying())
                bt2.pause();

            if(bt3.isPlaying())
                bt3.pause();
            bt2.start();
        }

        if(position==3){
            if(bt1.isPlaying())
                bt1.pause();

            if(bt2.isPlaying())
                bt2.pause();

            if(bt3.isPlaying())
                bt3.pause();

            bt3.start();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void OpenActivity2(){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

}
