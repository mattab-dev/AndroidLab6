package pl.edu.pwr.wiz.wzorlaboratorium6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Funkcja do obsługi przycisku oblicz */
    public void calculate(View view){
        ArrayCalculator ac;
        Float result;

        TextView valuesTV = (TextView) findViewById(R.id.values);
        String values = valuesTV.getText().toString();

        /* Tworzymy nasz kalkulator */
        try {
            ac = new ArrayCalculator(values);
        } catch (NumberFormatException nfe) {
            /* W razie podania błędnych danych wyświetlimy odpowiedni komunikat */
            Toast.makeText(this, getString(R.string.wrong_data), Toast.LENGTH_LONG).show();
            return;
        }

        Spinner opsSpin = (Spinner) findViewById(R.id.operation);
        switch (opsSpin.getSelectedItemPosition()) {
            case    1       :       result = ac.getSum();
                                    break;
            case    2       :       result = ac.getMultiplied();
                                    break;
            /* TODO - dodać brakujące operacje */
            default         :
            case    0       :       Toast.makeText(this, getString(R.string.select_op), Toast.LENGTH_LONG).show();
                                    return;
        }

        TextView resultTV = (TextView) findViewById(R.id.result);
        resultTV.setText(getString(R.string.result) + " " + result.toString());
        resultTV.setVisibility(View.VISIBLE);
    }
}
