package com.example.goktu_000.interactiveui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity{

    private Button trueButton;
    private  Button falseButton;
    private  Button prevButton;
    private  Button nextButton;
    private TextView     Question;

    int mCurrentIndex=0;

    private TrueFalse[] mQuestionBanks = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);
        prevButton = (Button)findViewById(R.id.prev_button);
        nextButton = (Button)findViewById(R.id.next_button);
        Question = (TextView)findViewById(R.id.Question);

        updateQuestion(mCurrentIndex);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBanks.length;
                updateQuestion(mCurrentIndex);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex-1) % mQuestionBanks.length;
                updateQuestion(mCurrentIndex);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_other){
            new Toast(this).makeText(this, "Other Clicked", Toast.LENGTH_LONG);
        }
        if (id== R.id.action_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void updateQuestion(int index){
        TrueFalse trueFalse = mQuestionBanks[index];
        Question.setText(trueFalse.getmQuestion());
    }
    private void checkAnswer(boolean condition){
        if(mQuestionBanks[mCurrentIndex].ismTrueQuestion() == condition){
            Toast.makeText(MainActivity.this,"You're right",Toast.LENGTH_LONG).show();
            nextButton.callOnClick();
        }
        else
            Toast.makeText(MainActivity.this,"Sorry Buddy",Toast.LENGTH_LONG).show();
    }
}
