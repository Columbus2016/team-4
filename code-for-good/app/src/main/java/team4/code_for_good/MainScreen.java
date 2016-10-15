package team4.code_for_good;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    public Button button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        button2();
        button3();
        button4();
        redeemCode();
    }

    public void button2() {
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_aboutus);
            }
        });
    }

    public void button3() {
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_aboutus);
            }
        });
    }

    public void button4() {
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_aboutus);
            }
        });
    }

    public void redeemCode(){
        Button redeemButton = (Button) findViewById(R.id.button7);
        redeemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("Redeem code button was pressed!");
                EditText redeemCodeForm = (EditText) findViewById(R.id.code);
                String codeText = redeemCodeForm.getText().toString();
                //boolean validCode = CodeManager.redeemCode(codeText);
                if(codeText.equals("G5S47")){
                    redeemCodeForm.setText("Success!");
                }
            }
        });
    }
}
