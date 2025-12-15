package com.example.showcaseportfolio.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.showcaseportfolio.R;

public class MadLibFragment extends Fragment {

    private EditText userInput1, userInput2, userInput3, userInput4, userInput5,
            userInput6, userInput7, userInput8, userInput9, userInput10;
    private TextView outputView;

    public MadLibFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate your fragment layout (replace with your XML name)
        View view = inflater.inflate(R.layout.fragment_madlib, container, false);

        // Link views using view.findViewById(...)
        userInput1 = view.findViewById(R.id.editadj1);
        userInput2 = view.findViewById(R.id.editobj2);
        userInput3 = view.findViewById(R.id.editplace3);
        userInput4 = view.findViewById(R.id.editanimal4);
        userInput5 = view.findViewById(R.id.editcloth5);
        userInput6 = view.findViewById(R.id.editverb6);
        userInput7 = view.findViewById(R.id.editpn7);
        userInput8 = view.findViewById(R.id.editverb8);
        userInput9 = view.findViewById(R.id.editadj9);
        userInput10 = view.findViewById(R.id.editfood10);
        outputView = view.findViewById(R.id.output);

        // Button
        Button generateBtn = view.findViewById(R.id.generateBTN);
        generateBtn.setOnClickListener(v -> generateMadLib());

        return view;
    }

    private void generateMadLib() {
        String one = userInput1.getText().toString();
        String two = userInput2.getText().toString();
        String three = userInput3.getText().toString();
        String four = userInput4.getText().toString();
        String five = userInput5.getText().toString();
        String six = userInput6.getText().toString();
        String seven = userInput7.getText().toString();
        String eight = userInput8.getText().toString();
        String nine = userInput9.getText().toString();
        String ten = userInput10.getText().toString();

        String story = "Today, I woke up feeling incredibly " + one +
                ", so I decided to grab my " + two +
                " and head to " + three +
                ". When I got there, I was shocked to see a " + four +
                " wearing a " + five +
                " and trying to " + six +
                " in front of everyone. A crowd of " + seven +
                " gathered around and started " + eight +
                ", which only made the situation feel even more " + nine +
                ". In the end, I just laughed, ate my " + ten +
                ", and went home like nothing unusual had happened.";

        outputView.setText(story);
    }
}
