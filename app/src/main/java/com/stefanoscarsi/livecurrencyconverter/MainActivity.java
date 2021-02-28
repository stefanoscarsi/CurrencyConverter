package com.stefanoscarsi.livecurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private TextView euroText;
    private TextView usdText;
    private TextView gbpText;
    private EditText amount;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        euroText = findViewById(R.id.euroText);
        usdText = findViewById(R.id.usdText);
        gbpText = findViewById(R.id.gbpText);
        amount = findViewById(R.id.amount);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount.onEditorAction(IME_ACTION_DONE);


                GetValueSpinner();

            }
        });






    }

    private void GetValueSpinner() {

        String selezione = String.valueOf(spinner.getSelectedItem());

        String valueString = amount.getText().toString().trim();

        double valueInt = Integer.parseInt(valueString);




        switch(selezione){
            case "USD":
                String gbp = String.valueOf(valueInt * 0.71803);
                gbpText.setText(gbp);

                String eur = String.valueOf(valueInt * 0.82833);
                euroText.setText(eur);


                usdText.setText(String.valueOf(valueInt));

                Toast.makeText(this, "USD", Toast.LENGTH_SHORT).show();
                break;


            case "EUR":

                String usd2 = String.valueOf(valueInt * 1.2072);
                usdText.setText(usd2);

                String gbp2 = String.valueOf(valueInt * 0.86684);
                gbpText.setText(gbp2);

                euroText.setText(String.valueOf(valueInt));

                Toast.makeText(this, "EUR", Toast.LENGTH_SHORT).show();
                break;

            case "GBP":

                String eur3 = String.valueOf(valueInt * 1.1536);
                euroText.setText(eur3);

                String usd3 = String.valueOf(valueInt * 1.3927);
                usdText.setText(usd3);

                gbpText.setText(String.valueOf(valueInt));


                Toast.makeText(this, "GBP", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}