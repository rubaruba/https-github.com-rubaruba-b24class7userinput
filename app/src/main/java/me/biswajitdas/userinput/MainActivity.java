package me.biswajitdas.userinput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValueA;
    private EditText editTextValueB;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValueA = findViewById(R.id.editText_valueA);
        editTextValueB = findViewById(R.id.editText_valueB);
        textViewResult = findViewById(R.id.textView_result);
    }

    public void calculate(View view) {

        String strValueA = editTextValueA.getText().toString();
        String strValueB = editTextValueB.getText().toString();

        if (TextUtils.isEmpty(strValueA) && TextUtils.isEmpty(strValueB)) {
            Toast.makeText(this, "Enter both value", Toast.LENGTH_SHORT).show();
        } else {
            int valueA = Integer.parseInt(strValueA);
            int valueB = Integer.parseInt(strValueB);
            int result = 0;

            switch (view.getId()) {
                case R.id.button_add:
                    result = valueA + valueB;
                    break;
                case R.id.button_sub:
                    result = valueA - valueB;
                    break;
                case R.id.button_mul:
                    result = valueA * valueB;
                    break;
                case R.id.button_div:
                    result = valueA / valueB;
                    break;
            }


            textViewResult.setText("Result : " + convertToBangla(String.valueOf(result)));

            textViewResult.setText("Result : " + convertToBangla(String.valueOf(result)));
        }


    }

    public String convertToBangla(String string) {
        Character bangla_number[] = {'০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯'};
        Character eng_number[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String values = "";
        char[] character = string.toCharArray();
        for (int i = 0; i < character.length; i++) {
            Character c = ' ';
            for (int j = 0; j < eng_number.length; j++) {
                if (character[i] == eng_number[j]) {
                    c = bangla_number[j];
                    break;
                } else {
                    c = character[i];
                }
            }
            values = values + c;
        }
        return values;
    }

/*    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Executed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Executed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Executed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Executed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart Executed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Executed",Toast.LENGTH_SHORT).show();
    }*/


}
