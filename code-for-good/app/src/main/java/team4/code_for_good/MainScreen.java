package team4.code_for_good;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    public Button button2, button3, button4;

    public void button2() {
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainScreen.this, Donate.class);
                startActivity(toy);
            }
        });
    }

    public void button3() {
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy2 = new Intent(MainScreen.this, Volunteering.class);
                startActivity(toy2);
            }
        });
    }

    public void button4() {
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy3 = new Intent(MainScreen.this, Aboutus.class);
                startActivity(toy3);
            }
        });
    }

    public void redeemCode(){
        Button redeemButton = (Button) findViewById(R.id.button7);
        redeemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CodeManager.redeemCode("5XG35");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        button2();
        button3();
        button4();
    }
}
