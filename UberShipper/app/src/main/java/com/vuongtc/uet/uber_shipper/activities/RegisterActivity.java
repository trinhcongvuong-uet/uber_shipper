package com.vuongtc.uet.uber_shipper.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vuongtc.uet.uber_shipper.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_Register;
    private EditText edt_email;
    private EditText edt_name;
    private EditText edt_pass;
    private EditText edt_phone;
    private EditText edt_reTypePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        toolbar.setTitle(R.string.register_button);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.back_register);
        upArrow.setColorFilter(getResources().getColor(R.color.WhiteColor), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btn_Register = (Button)findViewById(R.id.btnRegister);
        edt_email = (EditText)findViewById(R.id.edtRegisterEmail);
        edt_name = (EditText)findViewById(R.id.edtRegisterName);
        edt_pass = (EditText)findViewById(R.id.edtRegisterPassword);
        edt_reTypePass = (EditText)findViewById(R.id.edtRegisterRetypePass);
        edt_phone = (EditText)findViewById(R.id.edtRegisterPhone);

        btn_Register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister: {
                String email = edt_email.getText().toString();
                String name = edt_name.getText().toString();
                String password = edt_pass.getText().toString();
                String retypePassword = edt_reTypePass.getText().toString();
                String phone = edt_phone.getText().toString();

                if (!email.isEmpty() && !isValidEmail(email)) {
                    Toast.makeText(this, R.string.notify_validate_email, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!phone.isEmpty()) {
                    if (!phone.startsWith("0")) {
                        Toast.makeText(this, R.string.error_prefix_content, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!(phone.length() == 10 || phone.length() == 11)) {
                        Toast.makeText(this, R.string.error_phone_content, Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

                if (email.isEmpty() || phone.isEmpty() || name.isEmpty() || password.isEmpty() || retypePassword.isEmpty()) {
                    Toast.makeText(this, R.string.notify_empty_input_register_user, Toast.LENGTH_SHORT).show();

                } else {

                    if (!password.equals(retypePassword)) {
                        Toast.makeText(this, R.string.error_confirm_register_password, Toast.LENGTH_SHORT).show();
                        edt_pass.setText("");
                        edt_reTypePass.setText("");
                        return;
                    }

                    if (password.length() < 8) {
                        Toast.makeText(this, R.string.notify_validate_password_lenght, Toast.LENGTH_SHORT).show();
                        edt_pass.setText("");
                        edt_reTypePass.setText("");
                        return;
                    } else {
//                        insert database
                    }
                    break;
                }
            }
            default:
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return false;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.translate_right_in,R.anim.translate_right_out);
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


}
