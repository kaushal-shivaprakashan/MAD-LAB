package com.example.program8;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    EditText Display;
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    Button btn_star,btn_hash,btn_del,btn_call,btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button)findViewById(R.id.btn0);
        btn_0.setOnClickListener(this);
        btn_1=(Button)findViewById(R.id.btn1);
        btn_1.setOnClickListener(this);
        btn_2=(Button)findViewById(R.id.btn2);
        btn_2.setOnClickListener(this);
        btn_3=(Button)findViewById(R.id.btn3);
        btn_3.setOnClickListener(this);
        btn_4=(Button)findViewById(R.id.btn4);
        btn_4.setOnClickListener(this);
        btn_5=(Button)findViewById(R.id.btn5);
        btn_5.setOnClickListener(this);
        btn_6=(Button)findViewById(R.id.btn6);
        btn_6.setOnClickListener(this);
        btn_7=(Button)findViewById(R.id.btn7);
        btn_7.setOnClickListener(this);
        btn_8=(Button)findViewById(R.id.btn8);
        btn_8.setOnClickListener(this);
        btn_9=(Button)findViewById(R.id.btn9);
        btn_9.setOnClickListener(this);
        btn_call=findViewById(R.id.btncall);
        btn_call.setOnClickListener(this);
        btn_save=findViewById(R.id.btnsave);
        btn_save.setOnClickListener(this);
        btn_star=findViewById(R.id.btnstar);
        btn_star.setOnClickListener(this);
        btn_del=findViewById(R.id.btnrem);
        btn_del.setOnClickListener(this);
        btn_hash=findViewById(R.id.btnhash);
        btn_hash.setOnClickListener(this);
        Display=(EditText) findViewById(R.id.display);
        Display.setText("");
    }
    @Override
    public void onClick(View view) {
        if(view.equals(btn_1))
            Display.append("1");
        else if(view.equals(btn_2)) Display.append("2");
        else if(view.equals(btn_3))Display.append("3");
        else if(view.equals(btn_4))Display.append("4");
        else if(view.equals(btn_5))Display.append("5");
        else if(view.equals(btn_6)) Display.append("6");
        else if(view.equals(btn_7))Display.append("7");
        else if(view.equals(btn_8))Display.append("8");
        else if(view.equals(btn_9))Display.append("9");
        else if(view.equals(btn_0))Display.append("0");
        else if(view.equals(btn_star)) Display.append("*");
        else if(view.equals(btn_hash))Display.append("#");
        else if(view.equals(btn_save))
        {
            Intent contactIntent= new
                    Intent(ContactsContract.Intents.Insert.ACTION);

            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");

            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,Display.getText().toString());
            startActivity(contactIntent);
        }
        else if(view.equals(btn_del))
        {
            String data=Display.getText().toString();
            if(data.length()>0)
                Display.setText(data.substring(0,data.length()-1));
            else
                Display.setText("");
        }
        btn_call.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View v) {
                                            String data = Display.getText().toString();Intent
                                                    intent=new Intent(Intent.ACTION_DIAL);
                                            intent.setData(Uri.parse("tel:"+ data));
                                            startActivity(intent);
                                        }
                                    }
        );
    }
}