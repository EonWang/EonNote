package com.example.Eric_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立paintview，所有繪圖行為都在上面執行
        paintView = findViewById(R.id.PaintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
    }

    //建立選單
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //建立選單選擇事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        int id = item.getItemId();

        if (res_id == R.id.action_dot) {
            Toast.makeText(getApplicationContext(), "You select dot", Toast.LENGTH_LONG).show();
            paintView.drawDot();
        }
        switch (id){
            case R.id.action_element1:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_element2:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_element3:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        switch (item.getItemId()) {
            case R.id.Array:
                Intent intent = new Intent(this, ArrayOutput.class);
                intent.putExtra("points", paintView.points());
                startActivity(intent);
                return true;
            case R.id.clear:
                paintView.clear();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
