package com.example.hw1_2_20211336;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
    EditText Edit1;
    Button button1,button2;
    RadioGroup radioGroup;
    ImageView img;
    String str,url;

    RadioButton numArray[]=new RadioButton[2];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("좀 그럴듯한 앱");

        Edit1=(EditText)findViewById(R.id.Edit1);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        numArray[0]=(RadioButton)findViewById(R.id.eleven);
        numArray[1]=(RadioButton)findViewById(R.id.twelve);
        img=(ImageView)findViewById(R.id.img);

        final int draw[]={R.drawable.r,R.drawable.s};

        img.setImageResource(R.drawable.s);

        for(int i=0;i<numArray.length;i++){
            final int index=i;
            numArray[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    img.setImageResource(draw[index]);
                }
            });
        }

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                str=Edit1.getText().toString();
                Toast.makeText(getApplicationContext(),str,
                        Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=Edit1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}