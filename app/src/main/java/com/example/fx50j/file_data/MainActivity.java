package com.example.fx50j.file_data;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private Button btn;
    private CheckBox checkBox;

    private SharedPreferences sharepref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.edit_name);
        et2 = (EditText) findViewById(R.id.edit_key);
        btn = (Button) findViewById(R.id.btn);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        //用SharedPreferences存储数据
        //实例化sharedPreferences
        sharepref = getSharedPreferences("data",MODE_PRIVATE);

        editor = sharepref.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String key = et2.getText().toString();

                if (checkBox.isChecked()){
                    editor.putString("name",name);
                    editor.putString("key",key);

                }else {
                    editor.clear();
                }
                editor.commit();
                finish();
            }
        });


        //把这个动作直接写在onCreate中，即可实现记住密码再次登录的信息。
        Button read = (Button) findViewById(R.id.btn_read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharepref.getString("name","");
                String key = sharepref.getString("key","");
                et1.setText(name);
                et2.setText(key);
            }
        });
    }
}
