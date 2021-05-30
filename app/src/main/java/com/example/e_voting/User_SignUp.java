package com.example.e_voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class User_SignUp extends AppCompatActivity {

    TextInputEditText aadhar_num_data;
    TextInputEditText location_data;
    TextInputEditText age_data;
    TextInputEditText phone_num_data;
    TextInputEditText used_id_data;
    TextInputEditText password_data;
    TextInputEditText txt_path1;
    TextInputEditText txt_path2;

    int Image_Request_Code1 = 1;
    int Image_Request_Code2 = 2;

    Uri FilePathUri1;
    Uri FilePathUri2;

    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth fAuth;
    ProgressDialog progressDialog ;

    ImageView AttachBtn1;
    ImageView AttachBtn2;

    Button btnupload;
    Button login_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_user__sign_up);


        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");
        fAuth = FirebaseAuth.getInstance();

        aadhar_num_data = (TextInputEditText)findViewById(R.id.aadhar_num);
        location_data = (TextInputEditText)findViewById(R.id.location);
        age_data = (TextInputEditText)findViewById(R.id.age);
        phone_num_data = (TextInputEditText)findViewById(R.id.phone_no);
        used_id_data = (TextInputEditText)findViewById(R.id.User_Id);
        password_data = (TextInputEditText)findViewById(R.id.password);
        txt_path1 = (TextInputEditText)findViewById(R.id.txt_path1);
        txt_path2 = (TextInputEditText)findViewById(R.id.txt_path2);

        AttachBtn1 = findViewById(R.id.aadhar_filePicker);
        AttachBtn2 = findViewById(R.id.DOB_filePicker);

        btnupload = (Button) findViewById(R.id.register);
        login_btn = (Button) findViewById(R.id.have_account);

        progressDialog = new ProgressDialog(User_SignUp.this);// context name as per your project name


        //  opening file manager to get aadhar card image
        AttachBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code1);

            }
        });

        //  opening file manager to get DOB certificate/ class 10th Marksheet image
        AttachBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code2);

            }
        });


        // register button to upload all user data
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUp();

                UploadImage();

            }
        });

        // if user is already registered then go to login screen
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_SignUp.this, UserLogin.class);
                startActivity(intent);
            }
        });

    }

    private void SignUp() {

        String email = used_id_data.getText().toString().trim();
        String password = password_data.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            used_id_data.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            password_data.setError("Email is required");
            return;
        }

        if(password.length() < 6){
            password_data.setError("Password is too short");
            return;
        }

        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(User_SignUp.this, "Account created", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(User_SignUp.this, "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    // getting FilePathUri and file path for bothimages
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // getting FilePathUri and file path for aadhar card
        if (requestCode == Image_Request_Code1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri1 = data.getData();

            String path1 = data.getData().getPath();
            txt_path1.setText(path1);

        }


        // getting FilePathUri and file path for DOB certificate/ 10th Marksheet
        if (requestCode == Image_Request_Code2 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri2 = data.getData();

            String path2 = data.getData().getPath();
            txt_path2.setText(path2);

        }

    }


    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }

    public void UploadImage() {

        // chaek both aadhar card and DOB certificate is selected or not
        if (FilePathUri1 != null && FilePathUri2 != null) {

            progressDialog.setTitle("Image is Uploading...");
            progressDialog.show();

            // uploading aadhar card and storing its URL in url1[0]
            final String[] url1 = new String[2];
            StorageReference storageReference1 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri1));
            storageReference1.putFile(FilePathUri1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot1) {
                    url1[0] = taskSnapshot1.getUploadSessionUri().toString();
                }
            });

            // uploading DOB certificate/ 10th Marksheet
            StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri2));
            storageReference2.putFile(FilePathUri2)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot2) {

                            // if both images are succesfully uploaded then
                            // upload all data entered by user entered while registering and URL of both images
                            String aadharNumData = aadhar_num_data.getText().toString().trim();
                            String locationData = location_data.getText().toString().trim();
                            String ageData = age_data.getText().toString().trim();
                            String phoneNumData = phone_num_data.getText().toString().trim();
                            String userIdData = used_id_data.getText().toString().trim();
                            String passwordData = password_data.getText().toString().trim();

                            @SuppressWarnings("VisibleForTests")
                            uploadinfo imageUploadInfo = new uploadinfo(aadharNumData, locationData, ageData, phoneNumData, userIdData, passwordData, url1[0],taskSnapshot2.getUploadSessionUri().toString());
                            String ImageUploadId = databaseReference.push().getKey();
                            databaseReference.child(ImageUploadId).setValue(imageUploadInfo);

                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();

                            // if all data uploaded then move to OTP screen(with phone no. entered by user) where user have to enter OTP
                            Intent intent = new Intent(User_SignUp.this, UserOTP.class);

                            intent.putExtra("mobile", "+91"+phoneNumData.replace(" ", ""));
                            startActivity(intent);
                        }
                    });
        }
        else {

            // if both images are not selected by user
            Toast.makeText(User_SignUp.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }


    }

}