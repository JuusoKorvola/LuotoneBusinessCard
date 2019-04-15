package org.luotonebc.luotonecard;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainScreen extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1;
    private Toast toast;
    ImageView card_image;
    Button edit;
    TextView fullName;
    TextView address;
    TextView emailAddress;
    TextView phoneNumber;
    TextView nameOfCompany;
    Button uploadCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //Toolbar for main screen defined
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting a support Actionbar corresponding to toolbar
        ActionBar ab = getSupportActionBar();

        //To hide the title text on app bar
        ab.setDisplayShowTitleEnabled(false);

        // Enable the back button
        ab.setDisplayHomeAsUpEnabled(true);


        //To take image from camera
        Button cameraButton = (Button) findViewById(R.id.camera);
        card_image = findViewById(R.id.card_image);


        //OnClickListener for camera_button
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
            }
        });

        //To upload card
        uploadCard = (Button) findViewById(R.id.uploadCard);

        //OnClickListener for upload_button
        uploadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
                startActivityForResult(intent, 1);
            }


            /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == 1 && resultCode == RESULT_OK) {
                    Uri fullPhotoUri = data.getData();
                }
            }*/

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                    Uri fullPhotoUri = data.getData();
                    // Do work with full size photo saved at fullPhotoUri
           }
            }

            private Bitmap getBitmapFromUri(Uri uri) throws IOException {
                ParcelFileDescriptor parcelFileDescriptor =
                        getContentResolver().openFileDescriptor(uri, "r");
                FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                parcelFileDescriptor.close();
                return image;
            }

        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        card_image.setImageBitmap(bitmap);
        fullName = (TextView) findViewById(R.id.fullName);
        fullName.setText("Name : Dummy Name");
        address = (TextView) findViewById(R.id.address);
        address.setText("Address : Dummy Address");
        emailAddress = (TextView) findViewById(R.id.emailAddress);
        emailAddress.setText("Email : Dummy Email address");
        phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        phoneNumber.setText("Phone : Dummy phonenumber");
        nameOfCompany = (TextView) findViewById(R.id.nameOfCompany);
        nameOfCompany.setText("Company : Dummy company name");
    }

    //Menu item added in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuForMenuScreen = getMenuInflater();
        menuForMenuScreen.inflate(R.menu.profile_menu_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.profileMenu:
                Toast.makeText(this, "Profile Menu was selected", Toast.LENGTH_SHORT).show();
                Intent toProfileScreen = new Intent (this, LoginScreen.class);
                startActivity(toProfileScreen);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
