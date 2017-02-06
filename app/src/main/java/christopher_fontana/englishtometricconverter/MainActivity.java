package christopher_fontana.englishtometricconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double feetToMeter = .3048;
    double inchToCentimeter = 2.54;
    double mileToKilometer = 1.609;
    double numberToConvert;
    double finalConversion;
    String convertType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this takes the info typed into the txtTickets field stores them in varible tickets
        final EditText numbers = (EditText)findViewById(R.id.txtNumber);

        // this assigns selection made from the spinner control and assigns it to varible named group
        final Spinner group = (Spinner)findViewById(R.id.txtConvertList);

        // this finds the spinner choice converts it to a string
        //final String spinnerText = group.getSelectedItem().toString();

        // initialize the button control
        Button conversion = (Button)findViewById(R.id.btnConvert);

       conversion.setOnClickListener(new View.OnClickListener() {
           final TextView result = ((TextView)findViewById(R.id.txtResult));
           @Override
           public void onClick(View v) {

               numberToConvert = Integer.parseInt(numbers.getText().toString());

               // converts the spinner fields to a string
               String spinnerText = group.getSelectedItem().toString();

               // this determines what was selected and does the proper conversion
               if(spinnerText.equals("Feet to Meters")){
                   finalConversion = numberToConvert *feetToMeter;
               }
               if(spinnerText.equals("Inches to Centimeters")){
                   finalConversion = numberToConvert * inchToCentimeter;
               }
               if(spinnerText.equals("Miles to Kilometers")){
                   finalConversion = numberToConvert * mileToKilometer;
               }


               //DecimalFormat
             // convertType = group.getSelectedItem().toString();

               // output text in the field below the button
               result.setText(numberToConvert+" "+ spinnerText+ " is: " +finalConversion);

           }
       });
    }
}

