package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey(Constants.ALL_TERMS)) {
            String termsString = intent.getStringExtra(Constants.ALL_TERMS);

            String[] terms = termsString.split(" ");
            int result = 0;

            for (int i = 0; i < terms.length; i++) {
                String term = terms[i];

                if (!term.equals("+")) {
                    result += Integer.valueOf(term);
                }
            }

            setResult(result);
        }

        finish();
    }
}