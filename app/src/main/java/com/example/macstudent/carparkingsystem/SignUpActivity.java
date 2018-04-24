package com.example.macstudent.carparkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macstudent.carparkingsystem.db.DBUser;
import com.example.macstudent.carparkingsystem.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = SignUpActivity.class.getName();
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.edtConfirmPassword)
    EditText edtConfirmPassword;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        Toast.makeText(this, name + age, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onBackPressed() {

    }

@OnClick(R.id.btnSignUp)
    public void onViewClicked() {

        if (validate())
        {
            User user = new User();
            user.setEmail(edtName.getText().toString());
            user.setPassword(edtPassword.getText().toString());

            DBUser dbUser = new DBUser(SignUpActivity.this);
            dbUser.insertUser(user);

            dbUser.getAllUser();
        }
    }

    public boolean validate()
    {
        if(edtPassword.getText().toString().length() != 0)
        {
            if(edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString()))
            {
                return true;
            }
            else
            {
                edtConfirmPassword.setError("Confirm Password not matched");
            }
        }
        else
        {
            edtPassword.setError("Enter Password");
        }

        return false;

    }
}
