package com.example.prgm6;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnx, btnj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnx=findViewById(R.id.button);
        btnj=findViewById(R.id.button2);


        btnx.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this, ViewActivity.class);
            intent.putExtra("val",1);
            startActivity(intent);
        });


        btnj.setOnClickListener(view -> {

            Intent intent=new Intent(MainActivity.this ,ViewActivity.class);
            intent.putExtra("val",2);
            startActivity(intent);
        });
    }
}
