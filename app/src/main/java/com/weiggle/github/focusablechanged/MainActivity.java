package com.weiggle.github.focusablechanged;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import utils.CommenUtil;

public class MainActivity extends AppCompatActivity {

    private ImageView back, addressIcon, edit;
    private EditText account, phone, name, gender, email, address;
    private TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        addressIcon = (ImageView) findViewById(R.id.address_icon);
        edit = (ImageView) findViewById(R.id.edit);
        account = (EditText) findViewById(R.id.account);
        phone = (EditText) findViewById(R.id.phone);
        name = (EditText) findViewById(R.id.name);
        gender = (EditText) findViewById(R.id.gender);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        submit = (TextView) findViewById(R.id.submit);
    }

    private void initEvent() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canEdit();
                submit.setVisibility(View.VISIBLE);
                addressIcon.setVisibility(View.VISIBLE);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPersonInfo();
            }
        });
    }

    private void getPersonInfo() {
        String accountS = account.getText().toString().trim();
        String phoneS = phone.getText().toString().trim();
        String nameS = name.getText().toString().trim();
        String genderS = gender.getText().toString().trim();
        String emailS = email.getText().toString().trim();
        String addressS = address.getText().toString().trim();

        if (isNull(accountS, phoneS, nameS, genderS, emailS, addressS)) {
            Toast.makeText(this, "请填全信息", Toast.LENGTH_LONG).show();
            return;
        }

        if (!CommenUtil.verify(phoneS, CommenUtil.PHONE_MATCHER)) {
            Toast.makeText(this, "请输入合法的手机号", Toast.LENGTH_LONG).show();
            return;
        }

        if (!CommenUtil.verify(emailS, CommenUtil.EMAIL_MATCHER)) {
            Toast.makeText(this, "请输入合法的邮箱", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, "信息提交成功", Toast.LENGTH_LONG).show();
    }

    private boolean isNull(String... str) {
        for (int i = 0; i < str.length; i++) {
            if (TextUtils.isEmpty(str[i])) {
                return true;
            }
        }

        return false;
    }

    private void canEdit() {
        setEditFocusable(account);
        account.requestFocus();
        setEditFocusable(phone);
        setEditFocusable(name);
        setEditFocusable(gender);
        setEditFocusable(email);
        setEditFocusable(address);
    }

    private void setEditFocusable(EditText edit) {
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
    }
}
