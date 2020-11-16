package com.it.yb.andtipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText et1;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=findViewById(R.id.button1);
        btn1.setOnClickListener(btn1Listener);

        et1=findViewById(R.id.editTextText1);
        et1.addTextChangedListener(et1Listener);


        Intent i =new Intent(this,Main2Activity.class);
        startActivity(i);

    }

    private View.OnClickListener btn1Listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Main2Activity.this, "button was clicked", Toast.LENGTH_SHORT).show();

        }
    };

    private TextWatcher et1Listener=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            Toast.makeText(Main2Activity.this, s.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
