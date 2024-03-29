package com.home.currency;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edNTD;
    private TextView edUSD;
    private Button btnGO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNTD = findViewById(R.id.ed_NTD);
        edUSD = findViewById(R.id.text_USD);
        btnGO = findViewById(R.id.btn_GO);
    }

    public void go(View view){
        String strNTD = edNTD.getText().toString();
        float NTD,USD;
        try {
            NTD = Float.parseFloat(strNTD);
            DecimalFormat df = new DecimalFormat("###.####");
            USD = NTD / 30.9f;
            String message = getString(R.string.usd_is)+ df.format(USD);
            new AlertDialog.Builder(this).setTitle(R.string.result)
                    .setMessage(message)
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edUSD.setText(message);
                        }
                    })
                    .show();

        } catch (NumberFormatException e) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_you_ntd_amount)
                    .setPositiveButton(getString(R.string.ok),null)
                    .show();
        }


    }
}