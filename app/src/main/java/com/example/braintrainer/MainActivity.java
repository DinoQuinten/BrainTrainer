package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public Button playAgain;
    public TextView timer;
    public TextView scoreView;
    public TextView question;
    public TextView answer;
    Random random = new Random();
    int postionOfCorrentAns;
    int score = 0;
    int noOfQuestions=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mainLayout=findViewById(R.id.mainLay);
        View goLayout=findViewById(R.id.goLay);
        button = findViewById(R.id.button);
        playAgain =findViewById(R.id.button6);
        playAgain.setVisibility(View.GONE);
        newQuestion();
        button.setOnClickListener(view -> button.setVisibility(View.GONE));
        CountDownTimer countDownTimer=new CountDownTimer(30000 + 500, 1000) {

            @Override
            public void onTick(long l) {
//                Log.i("Timer", String.valueOf(l/1000));
                timer.setText(String.valueOf((int) (l / 1000)) + "s");
            }

            @Override
            public void onFinish() {
            playAgain.setVisibility(View.VISIBLE);
            }
        }.start();

        playAgain.setOnClickListener(view -> {
            score=0;
            noOfQuestions=0;
            countDownTimer.start();
            scoreView.setText(score+"");
            newQuestion();
            playAgain.setVisibility(View.INVISIBLE);
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        scoreView.setText("hello");
    }
    public void newQuestion(){
        int[] ans = new int[4];

        timer = findViewById(R.id.timer);
        scoreView = findViewById(R.id.score);
        question = findViewById(R.id.question);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        answer = findViewById(R.id.answer);

        int a = random.nextInt(50);
        int b = random.nextInt(50);
        int correctAns = a + b;
        question.setText(a + " + " + b);
        postionOfCorrentAns = random.nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == postionOfCorrentAns)
                ans[i] = correctAns;
            else {
                int randomAns = random.nextInt(100);
                while (randomAns == correctAns) {
                    randomAns = random.nextInt(100);
                }
                ans[i] = randomAns;
            }
        }

        button0.setText(ans[0] + "");
        button1.setText(ans[1] + "");
        button2.setText(ans[2] + "");
        button3.setText(ans[3] + "");
    }

    public void chooseAns(View view) {
        view.getTag();
        noOfQuestions++;
        if (postionOfCorrentAns == Integer.parseInt(String.valueOf(view.getTag()))) {
            answer.setText("CORRECT ANSWER");
            score++;
        } else
        {answer.setText("WRONG ANSWER: ");}
        newQuestion();
        scoreView.setText(score+"/"+noOfQuestions);

    }
}