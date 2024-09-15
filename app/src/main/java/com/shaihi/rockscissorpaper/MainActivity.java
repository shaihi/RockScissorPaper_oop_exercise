package com.shaihi.rockscissorpaper;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView playerChoice;
    private TextView computerChoice;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerChoice = findViewById(R.id.player_choice);
        computerChoice = findViewById(R.id.computer_choice);
        resultText = findViewById(R.id.result_text);

        Button buttonRock = findViewById(R.id.button_rock);
        Button buttonPaper = findViewById(R.id.button_paper);
        Button buttonScissors = findViewById(R.id.button_scissors);

        buttonRock.setOnClickListener(view -> playGame(new Rock()));
        buttonPaper.setOnClickListener(view -> playGame(new Paper()));
        buttonScissors.setOnClickListener(view -> playGame(new Scissors()));
    }

    private void playGame(GameElement playerElement) {
        playerChoice.setText(getEmoji(playerElement));
        GameElement computerElement = getComputerChoice();
        computerChoice.setText(getEmoji(computerElement));

        String result = playerElement.compareWith(computerElement);
        resultText.setText(result);
        animateResult(result);
    }

    private GameElement getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default:
                return new Scissors();
        }
    }

    private String getEmoji(GameElement element) {
        if (element instanceof Rock) return "✊";
        if (element instanceof Paper) return "✋";
        return "✌️";
    }

    private void animateResult(String result) {
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        animation.setRepeatCount(1);
        animation.setRepeatMode(AlphaAnimation.REVERSE);

        if (result.equals("You Win!")) {
            playerChoice.startAnimation(animation);
        } else if (result.equals("You Lose!")) {
            computerChoice.startAnimation(animation);
        }
    }
}