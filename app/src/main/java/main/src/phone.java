package main.src;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class phone extends AppCompatActivity {

    EditText phoneNumber ;
    EditText rechargeNumber ;
    EditText appelRecharge ;
    EditText appelConsult;
    Button rechargeBtn ;
    Button consultBtn ;

    TextView textLogin ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneNumber = findViewById(R.id.editTextPhone);
        rechargeNumber = findViewById(R.id.editTextRechargeNumber);
        appelRecharge = findViewById(R.id.editTextAppelRecharge);
        appelConsult = findViewById(R.id.editTextConsult);
        rechargeBtn = findViewById(R.id.buttonRecharge);
        consultBtn = findViewById(R.id.buttonConsult);
        textLogin =findViewById(R.id.textLogin);
        Intent i =getIntent();
        String user_name =  i.getStringExtra("name");

        textLogin.setText(user_name);

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable){}
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               Number number = new Number(phoneNumber.getText().toString(),rechargeNumber.getText().toString());
                appelRecharge.setText(number.getRechargeCode());
                appelConsult.setText(number.getConsultCode());
            }
        });

        rechargeNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Number number = new Number(phoneNumber.getText().toString(),rechargeNumber.getText().toString());
                appelRecharge.setText(number.getRechargeCode());
                appelConsult.setText(number.getConsultCode());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        rechargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call  = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+appelRecharge.getText().toString()));
                startActivity(call);
            }
        });

        consultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call  = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+appelConsult.getText().toString()));
                startActivity(call);
            }
        });

    }

}