package com.example.databaseopenhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText name;
    public Button query_button;
    public TextView result_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        query_button=findViewById(R.id.query_button);
        result_menu=findViewById(R.id.result);

        query_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String menu;
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n=name.getText().toString(); //getText()가 에디터블 인터페이스 타입 형태로 호출 되기 때문에 toString을 써서 문자열 타입으로 바꿔줌

                String[] new_n = n.split("\\s+");// 연속으로 값을 입력 받을 때 공백을 기준으로 string을 구별해줌 ex) n=사과 바나나-> n1=사과 n2=바나나
                for(int i=0; i< new_n.length;i++ ) {
                    menu = databaseAccess.getmenu(new_n[i]);
                    result_menu.setText(menu);
                }


                databaseAccess.close();
            }
        });

    }
}
