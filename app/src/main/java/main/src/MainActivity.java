package main.src;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin ;
    EditText name ;
    EditText password ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        name = findViewById(R.id.editTextName);
        password = findViewById(R.id.editTextPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length()<1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Name should be exist", Toast.LENGTH_SHORT);
                    toast.show();
                }else if ( password.getText().toString().length()<1 || !password.getText().toString().equals("123456")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Intent phone = new Intent(getApplicationContext(), phone.class);
                    phone.putExtra("name",name.getText().toString());
                    startActivity(phone);
                }
            }
        });
    }
}