package com.example.wallpaper;
import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn;
    boolean running;
    int[] ia=new int[]{R.drawable.imag1,R.drawable.imag2,R.drawable.imag3,R.drawable.imag4,R.drawable.imag5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_wall);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (!running) {
            new Timer().schedule(new Mytimer(), 0, 3000);
            running=true;
        }
    }
    private class Mytimer extends TimerTask {
        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            } catch (IOException e) { }
        }
    }
}
