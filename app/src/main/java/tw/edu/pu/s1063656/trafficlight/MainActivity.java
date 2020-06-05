package tw.edu.pu.s1063656.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public EditText gLight;
    public EditText yLight;
    public EditText rLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        setContentView(R.layout.activity_main);
    }

    public void StartGame(View v) {
        Intent it = new Intent(this,GameActivity.class);
        gLight = (EditText) findViewById(R.id.gLight);
        yLight = (EditText) findViewById(R.id.yellowLight);
        rLight = (EditText) findViewById(R.id.redLight);

        if(gLight.getText().toString().equals("")||yLight.getText().toString().equals("")||rLight.getText().toString().equals("")) {

            Toast.makeText(this,"燈號的秒數不能為0",Toast.LENGTH_SHORT).show();
        }else {
            it.putExtra("gLightTime", Integer.parseInt(gLight.getText().toString()));
            it.putExtra("yLightTime", Integer.parseInt(yLight.getText().toString()));
            it.putExtra("rLightTime", Integer.parseInt(rLight.getText().toString()));
            startActivity(it);
            finish();
        }
}

    public void EndApp(View v){
        finish();
    }

}
