package org.luotonebc.luotonecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    private Button button_to_login_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        button_to_login_screen = (Button) findViewById(R.id.button_to_login_screen);
        button_to_login_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginScreen();
            }
        });
    }

    public void openLoginScreen() {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}