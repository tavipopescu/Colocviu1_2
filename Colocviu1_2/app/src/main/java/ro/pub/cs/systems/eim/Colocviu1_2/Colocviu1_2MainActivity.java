package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Colocviu1_2MainActivity extends AppCompatActivity {
    private EditText nextTermEditText;
    private TextView allTermsTextView;
    private Button addButton;
    private Button computeButton;

    private int result = 0;
    private String lastCallAllTermsString = "";

    private class AddButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String allTermsString = allTermsTextView.getText().toString();
            String nextTermString = nextTermEditText.getText().toString();

            if (!nextTermString.isEmpty()) {
                try {
                    int nextTermValue = Integer.valueOf(nextTermString);
                    if (allTermsString.isEmpty()) {
                        allTermsTextView.setText(nextTermString);
                    } else {
                        allTermsTextView.setText(allTermsTextView.getText().toString() + " + " + nextTermString);
                    }
                } catch (NumberFormatException e) {

                }
            }


        }
    }

    private AddButtonListener addButtonListener = new AddButtonListener();

    private class ComputeButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String allTermsString = allTermsTextView.getText().toString();

            if (lastCallAllTermsString.isEmpty() || !lastCallAllTermsString.equals(allTermsString)) {
                lastCallAllTermsString = allTermsString;

                Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
                intent.putExtra(Constants.ALL_TERMS, allTermsString);
                startActivityForResult(intent, Constants.REQUEST_CODE);
            } else {
                Toast.makeText(getApplicationContext(), "Computed value stored in activity is: " + result, Toast.LENGTH_LONG).show();
            }
        }
    }

    private ComputeButtonListener computeButtonListener = new ComputeButtonListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        nextTermEditText = findViewById(R.id.next_term);
        allTermsTextView = findViewById(R.id.all_terms);

        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(addButtonListener);

        computeButton = findViewById(R.id.compute_button);
        computeButton.setOnClickListener(computeButtonListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.SAVED_RESULT)) {
                result = savedInstanceState.getInt(Constants.SAVED_RESULT);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE) {
            Toast.makeText(this, "Computed value by secondary activity is: " + resultCode, Toast.LENGTH_LONG).show();
            result = resultCode;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Constants.SAVED_RESULT, result);
    }
}