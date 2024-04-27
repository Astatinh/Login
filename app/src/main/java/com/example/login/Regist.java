package com.example.login;

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

public class Regist extends AppCompatActivity{
    private Button regist1;
    private String UserName,PassWord,CheckPW;
    private EditText account,passwd,Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.regist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.newnew), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        regist1=findViewById(R.id.regist);
        account=findViewById(R.id.account);
        passwd=findViewById(R.id.passwd);
        Check=findViewById(R.id.passwd1);
        regist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName=account.getText().toString().trim();
                PassWord=passwd.getText().toString().trim();
                CheckPW=Check.getText().toString().trim();
                if(UserName.isEmpty()||PassWord.isEmpty()||CheckPW.isEmpty()){
                    Toast.makeText(Regist.this,"账号或密码为空",Toast.LENGTH_LONG).show();
                }
                else if(!PassWord.equals(CheckPW)){
                    Toast.makeText(Regist.this,"密码不一致",Toast.LENGTH_LONG).show();
                }
                else{
                    setContentView(R.layout.welcom);
                }
            }
        });
    }

}
