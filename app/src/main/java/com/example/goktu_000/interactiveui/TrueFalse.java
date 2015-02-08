package com.example.goktu_000.interactiveui;

/**
 * Created by goktu_000 on 18/01/2015.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mQuestionBanks;

    public TrueFalse(int mQuestion, boolean mTrueQuestion) {
        this.mQuestion = mQuestion;
        this.mTrueQuestion = mTrueQuestion;
    }

    public TrueFalse[] getmQuestionBanks() {
       return new TrueFalse[]{
                new TrueFalse(R.string.question_oceans, true),
                new TrueFalse(R.string.question_mideast, false),
                new TrueFalse(R.string.question_africa, false),
                new TrueFalse(R.string.question_americas, true),
                new TrueFalse(R.string.question_asia, true)
        };
}

    public TrueFalse() {

    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public boolean ismQuestionBanks() {
        return mQuestionBanks;
    }

    public void setmQuestionBanks(boolean mQuestionBanks) {
        this.mQuestionBanks = mQuestionBanks;
    }
}
