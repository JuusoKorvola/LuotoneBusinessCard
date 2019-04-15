package org.luotonebc.luotonecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginScreen extends AppCompatActivity {
    //Declaring button for logging user
    private ImageButton back_button;
    private Button login_user;
    private Button reset_button_for_forgotten_password;
    private Button redirect_to_signup_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //This locates the button to login from Resources and saves it in a variable called login_user
        //and calls the openMainScreen() method to open MainScreen
        login_user = (Button) findViewById(R.id.login_user);
        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainScreen();
            }
        });

        //This locates the back button of login screen from Resources and saves it in a variable called back_button
        //and calls the back_to_home_screen() method to go back to Homescreen
        back_button = (ImageButton) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_to_home_screen();
            }
        });


        reset_button_for_forgotten_password = (Button) findViewById(R.id.reset_button_for_forgotten_password);
        reset_button_for_forgotten_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainScreen();
            }
        });

        redirect_to_signup_screen = (Button) findViewById(R.id.redirect_to_signup_screen);
        redirect_to_signup_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainScreen();
            }
        });
    }

    //This method creates a new intent for opening MainScreen Activity
    public void openMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    //This method creates a new intent to redirect back to HomeScreen
    public void back_to_home_screen(){
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}