package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Colocviu1_2MainActivity extends AppCompatActivity {
    private EditText nextTermEditText;
    private TextView allTermsTextView;
    private Button addButton;
    private Button computeButton;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        nextTermEditText = findViewById(R.id.next_term);
        allTermsTextView = findViewById(R.id.all_terms);

        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(addButtonListener);

        computeButton = findViewById(R.id.compute_button);
    }
}