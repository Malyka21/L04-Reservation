package sg.edu.rp.c346.id20047536.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnReserve, btnReset;
    TextView tvDisplay, tvDisplay2;
    EditText edName, edContact, edPax;
    CheckBox checkSmoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.resButton);
        btnReset = findViewById(R.id.resetButton);
        edName = findViewById(R.id.editName);
        edContact = findViewById(R.id.editContactNo);
        edPax = findViewById(R.id.editPaxNo);
        checkSmoking = findViewById(R.id.checkBox);
        tvDisplay = findViewById(R.id.textDisplay);
        tvDisplay2 = findViewById(R.id.textDisplay2);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resDetails = "Your date of reservation is on " + dp.getDayOfMonth() + "/" +
                        (dp.getMonth()+1)+ "/" + dp.getYear() + " time of reservation is at, " + tp.getCurrentHour() + ":" +
                        String.format("%2d", tp.getCurrentMinute());
                tvDisplay.setText(resDetails);
            }
        });

        checkSmoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSmoking.isChecked()){
                    tvDisplay2.setText("Smoking table requested");
                    }
                else{
                    tvDisplay2.setText("Non - smoking table requested");
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5,1);
                edName.setText("");
                edContact.setText("");
                edPax.setText("");
                tvDisplay.setText("");

            }
        });

    }
}