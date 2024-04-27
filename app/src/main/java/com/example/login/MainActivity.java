package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button,regist;
    private String UserName,PassWord;
    private EditText account,passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button=findViewById(R.id.button);
        account=findViewById(R.id.account);
        passwd=findViewById(R.id.passwd);
        regist=findViewById(R.id.regist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName=account.getText().toString().trim();
                PassWord=passwd.getText().toString().trim();
                if(UserName.isEmpty()||PassWord.isEmpty()){
                    Toast.makeText(MainActivity.this,"账号或密码错误！！！",Toast.LENGTH_LONG).show();
                }
                else{
                    if(UserName.equals("admin")&&PassWord.equals("123456")){
                        setContentView(R.layout.welcom);
                    }
                }
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Regist.class);
                startActivity(intent);
            }
        });
    }


}