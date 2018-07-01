package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton question1Answer, question4Answer, question5Answer, question6Answer;
    private CheckBox question2Answer1, question2Answer2, question2Answer3, question2Answer4, question7Answer1, question7Answer2, question7Answer3, question7Answer4;
    private EditText question3Answer, question8Answer;
    private RadioGroup question1, question4, question5, question6;
    private ViewGroup question3, question8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    public void submitScore(View view) {
        //declare and initialize variables to be used in the method

        double question8CorrectAnswer = 0;
        double question7CorrectAnswer = 0;
        double question6CorrectAnswer = 0;
        double question5CorrectAnswer = 0;
        double question4CorrectAnswer = 0;
        double question3CorrectAnswer = 0;
        double question2CorrectAnswer = 0;
        double question1CorrectAnswer = 0;
        double score;
        //gives score for question one
        Boolean question1;
        question1Answer = (RadioButton) this.findViewById(R.id.question1_choice2);
        question1 = question1Answer.isChecked();
        if (question1) {
            question1CorrectAnswer = 1;

        }
        //gives score for question 2
        Boolean question2Choice1, question2Choice2, question2Choice3, question2Choice4;
        question2Answer1 = (CheckBox) this.findViewById(R.id.question2_choice1);
        question2Answer2 = (CheckBox) this.findViewById(R.id.question2_choice2);
        question2Answer3 = (CheckBox) this.findViewById(R.id.question2_choice3);
        question2Answer4 = (CheckBox) this.findViewById(R.id.question2_choice4);
        question2Choice1 = question2Answer1.isChecked();
        question2Choice2 = question2Answer2.isChecked();
        question2Choice3 = question2Answer3.isChecked();
        question2Choice4 = question2Answer4.isChecked();
        if ((question2Choice3 && question2Choice4) && (!question2Choice1 && !question2Choice2)) {

            question2CorrectAnswer = 1;
        } else if ((question2Choice3 || question2Choice4) && (!question2Choice1 && !question2Choice2)) {
            question2CorrectAnswer = 0.5;
        }
        //gives score for question 3
        question3Answer = (EditText) this.findViewById(R.id.question3_answer);
        String question3Correct = question3Answer.getText().toString();
        if (question3Correct.equals("Common Market For Eastern And Southern Africa")) {
            question3CorrectAnswer = 1;
        }
        //gives score for question 4
        Boolean question4;
        question4Answer = (RadioButton) this.findViewById(R.id.question4_choice3);
        question4 = question4Answer.isChecked();
        if (question4) {
            question4CorrectAnswer = 1;
        }
        //gives score for question 5
        Boolean question5;
        question5Answer = (RadioButton) this.findViewById(R.id.question5_choice2);
        question5 = question5Answer.isChecked();
        if (question5) {
            question5CorrectAnswer = 1;
        }
        //gives score for question 6
        Boolean question6;
        question6Answer = (RadioButton) this.findViewById(R.id.question6_choice3);
        question6 = question6Answer.isChecked();
        if (question6) {
            question6CorrectAnswer = 1;
        }

        //gives score for question 7
        Boolean question7Choice1, question7Choice2, question7Choice3, question7Choice4;
        question7Answer1 = (CheckBox) this.findViewById(R.id.question7_choice1);
        question7Answer2 = (CheckBox) this.findViewById(R.id.question7_choice2);
        question7Answer3 = (CheckBox) this.findViewById(R.id.question7_choice3);
        question7Answer4 = (CheckBox) this.findViewById(R.id.question7_choice4);
        question7Choice1 = question7Answer1.isChecked();
        question7Choice2 = question7Answer2.isChecked();
        question7Choice3 = question7Answer3.isChecked();
        question7Choice4 = question7Answer4.isChecked();
        if ((question7Choice1 && question7Choice4) && (!question7Choice2 && !question7Choice3)) {

            question7CorrectAnswer = 1;
        } else if ((question7Choice1 || question7Choice4) && (!question7Choice2 && !question7Choice3)) {
            question7CorrectAnswer = 0.5;
        }

        //gives score for question 8
        question8Answer = (EditText) this.findViewById(R.id.question8_answer);
        String question8Correct = question8Answer.getText().toString();
        if (question8Correct.equals("River Nile")) {
            question8CorrectAnswer = 1;
        }

        //calculates the correct score and passes it to showScore method
        score = question1CorrectAnswer + question2CorrectAnswer + question3CorrectAnswer + question4CorrectAnswer + question5CorrectAnswer + question6CorrectAnswer + question7CorrectAnswer + question8CorrectAnswer;
        showScore(score);
    }

    //
    private void showScore(double result) {
        String showResult;
        if (result == 8) {
            showResult = "You got 8.With Google Hakuna Matata :)";
        } else {
            showResult = "You got " + result + " out of 8 :( .Try again";
        }
        Toast.makeText(this, showResult, Toast.LENGTH_LONG).show();
        return;
    }

    // Resets all buttons and typed texts when checked
    public void startAgain(View v) {
        // clears for all radio buttons checked
        question1 = (RadioGroup) findViewById(R.id.radiogroup1);
        question1.clearCheck();
        question4 = (RadioGroup) findViewById(R.id.radiogroup4);
        question4.clearCheck();
        question5 = (RadioGroup) findViewById(R.id.radiogroup5);
        question5.clearCheck();
        question6 = (RadioGroup) findViewById(R.id.radiogroup6);
        question6.clearCheck();
        /* clears all checked  boxes in question2 */
        if (question2Answer1.isChecked()) {
            question2Answer1.setChecked(false);
        }
        if (question2Answer2.isChecked()) {
            question2Answer2.setChecked(false);
        }
        if (question2Answer3.isChecked()) {
            question2Answer3.setChecked(false);
        }
        if (question2Answer4.isChecked()) {
            question2Answer4.setChecked(false);
        }
        /* clears all checked boxes in question7 */
        if (question7Answer1.isChecked()) {
            question7Answer1.setChecked(false);
        }
        if (question7Answer2.isChecked()) {
            question7Answer2.setChecked(false);
        }
        if (question7Answer3.isChecked()) {
            question7Answer3.setChecked(false);
        }
        if (question7Answer4.isChecked()) {
            question7Answer4.setChecked(false);
        }
        //clears all edited text IN QUESTION 3
        question3 = (ViewGroup) findViewById(R.id.linear_view_question3);
        for (int i = 0, count = question3.getChildCount(); i < count; ++i) {
            View view = question3.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
        }
        //clears all edited text IN QUESTION 8
        question8 = (ViewGroup) findViewById(R.id.linear_view_question8);
        for (int i = 0, count = question8.getChildCount(); i < count; ++i) {
            View view = question8.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }
        }
    }
}