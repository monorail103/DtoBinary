package io.github.monorail103.android.dtobinary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        // 変換対象の番号
        EditText etNumber = findViewById(R.id.etNumber);
        // N進数
        EditText etBin = findViewById(R.id.etBin);
        // 表示用TextView
        TextView tvView = findViewById(R.id.tvView);
        // intへの変換のため、一旦Stringにする
        String numst = etNumber.getText().toString();
        String binst = etBin.getText().toString();


        try {
            int num = Integer.parseInt(numst);
            int bin = Integer.parseInt(binst);

            if(bin >= 2 && 16 >= bin) {
                String ans = convertToBaseN(num, bin);
                tvView.setText(ans);
            }
            else {
                tvView.setText("基数を2以上16以下にしてください");
            }
        }
        catch (NumberFormatException e) {
            String sterror = "数字を入力してください。";
            // 結果表示のTextViewにエラーを表示
            tvView.setText(sterror);
        }

    }

    public String convertToBaseN(int decimalNumber, int base) {
        StringBuilder result = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            result.insert(0, Integer.toString(remainder, base));
            decimalNumber /= base;
        }
        return result.toString();
    }
}