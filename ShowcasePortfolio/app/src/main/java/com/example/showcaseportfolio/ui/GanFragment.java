package com.example.showcaseportfolio.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.showcaseportfolio.R;

import java.util.Random;

public class GanFragment extends Fragment {

    private int secretNumber;
    private int strikes = 10;
    private int score = 0;

    private EditText guessInput;
    private Button guessButton, newGameButton;
    private TextView feedbackText, strikesText, scoreText;
    private ImageView gameImage;

    Random random = new Random();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gan, container, false);

        guessInput = root.findViewById(R.id.guessInput);
        guessButton = root.findViewById(R.id.guessButton);
        newGameButton = root.findViewById(R.id.newGameButton);
        feedbackText = root.findViewById(R.id.feedbackText);
        strikesText = root.findViewById(R.id.strikesText);
        scoreText = root.findViewById(R.id.scoreText);
        gameImage = root.findViewById(R.id.gameImage);

        startNewGame();

        guessButton.setOnClickListener(v -> handleGuess());
        newGameButton.setOnClickListener(v -> startNewGame());

        return root;
    }

    private void startNewGame() {
        secretNumber = random.nextInt(100) + 1;
        strikes = 10;

        feedbackText.setText("New Game Started! Enter a guess.");
        strikesText.setText("Strikes: " + strikes);
        scoreText.setText("Score: " + score);

        guessButton.setEnabled(true);
        guessInput.setText("");


        gameImage.setImageResource(0);
    }

    private void handleGuess() {
        String input = guessInput.getText().toString();

        if (TextUtils.isEmpty(input)) {
            feedbackText.setText("Enter a number first!");
            return;
        }

        int guess = Integer.parseInt(input);

        if (guess < 1 || guess > 100) {
            feedbackText.setText("Guess must be between 1 and 100.");
            return;
        }

        if (guess == secretNumber) {
            int roundScore = 50 + (strikes * 5);
            score += roundScore;

            feedbackText.setText("You got it! Score +" + roundScore);
            scoreText.setText("Score: " + score);


            gameImage.setImageResource(R.drawable.win);

            startNewGame();
            return;
        }


        strikes--; //no idea what this does chatgpt
        strikesText.setText("Strikes: " + strikes);

        if (guess > secretNumber) {
            feedbackText.setText("Too high!");
        } else {
            feedbackText.setText("Too low!");
        }

        if (strikes <= 0) {
            feedbackText.setText("Game Over! The number was " + secretNumber);


            gameImage.setImageResource(R.drawable.lose);

            guessButton.setEnabled(false);
        }
    }
}

