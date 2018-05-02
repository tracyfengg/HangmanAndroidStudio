package com.example.xfeng.hangman;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Hangman hangman;
    String phrase;
    String hiddenPhrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            InputStream stream = getAssets().open("hangPhrases.txt");
            BufferedReader breader = new BufferedReader(new InputStreamReader(stream));

            hangman = new HangmanUser(breader);

            phrase = hangman.randomPhrase();
            hiddenPhrase = hangman.generateHiddenPhrase(phrase);
            TextView tView = (TextView) findViewById(R.id.textview1);
            tView.setText(hiddenPhrase);
        } catch (IOException e) {

        }
    }
//
//    public void initGame() {
//
//
//        public void sendMessage (View view){
//            Button b = (Button) view;
//            b.setText("Click Here");
//            EditText editText = (EditText) findViewById(R.id.editText);
//            if (editText.getText().length() > 0) {
//                char c = editText.getText().charAt(0);
//                Boolean match = hangman.processGuess(c, phrase, hiddenPhrase);
//                TextView tView = (TextView) findViewById(R.id.textView4);
//                tView.setText(hiddenPhrase);
//            }
//        }
//
//            ImageView imageView = (ImageView) findViewById(R.id.imageView2);
//            imageView.setImageResource(R.drawable.hangman2);
//        }
//    }
}

