package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.josejoss.pruebatopicos.R;

import activities.administrar.RegisterAdminstrarActivity;
import activities.musica.RegisterActivity;
import includes.MyToolbar;

public class SelectOptionAuthActivity extends AppCompatActivity {


    Button mButtonGoToLogin;
    Button mButtonGoToRegister;
    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);

        MyToolbar.show(this,"Registro de Usuario",true);

        mButtonGoToLogin = findViewById(R.id.btnGoTologin);
        mButtonGoToRegister = findViewById(R.id.btnGoToRegister);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });
        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });

        mPref = getApplicationContext().getSharedPreferences("typeUser",MODE_PRIVATE);

    }

    private void goToLogin() {
        Intent intent = new Intent(SelectOptionAuthActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void goToRegister() {
        String typeUser= mPref.getString("user","");
        if(typeUser.equals("musica")){
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(SelectOptionAuthActivity.this, RegisterAdminstrarActivity.class);
            startActivity(intent);
        }

    }

}