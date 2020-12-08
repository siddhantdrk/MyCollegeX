package com.example.mycollegex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactSellerActivity extends AppCompatActivity {

    private ImageView whatsAppImageView;
    private TextView whatsAppTextView;
    private ImageView mPhoneImage;
    private TextView mPhoneNumber,productCost;
    private static final int REQUEST_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_seller);
        initViews();


        mPhoneImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(ContactSellerActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ContactSellerActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String dial = "tel:" + "6204082073";
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });

        whatsAppImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:" + "6204082073");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        whatsAppImageView =(ImageView)findViewById(R.id.whatsApp_image);
        whatsAppTextView = (TextView)findViewById(R.id.whatsApp_message);
        mPhoneNumber = (TextView)findViewById(R.id.phone_number);
        mPhoneImage = (ImageView) findViewById(R.id.phone_image);
        productCost = (TextView)findViewById(R.id.cost_product);
    }

}