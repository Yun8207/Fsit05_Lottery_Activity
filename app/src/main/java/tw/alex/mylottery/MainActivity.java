package tw.alex.mylottery;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private TextView tempNum;
    private Button gotoCom;
    private TextView[] nums = new TextView[6];
    private int now = 0;
    private HashSet<Integer> hs = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempNum = findViewById(R.id.num);
        gotoCom = findViewById(R.id.confirm);

        nums[0] = findViewById(R.id.num1);
        nums[1] = findViewById(R.id.num2);
        nums[2] = findViewById(R.id.num3);
        nums[3] = findViewById(R.id.num4);
        nums[4] = findViewById(R.id.num5);
        nums[5] = findViewById(R.id.num6);
    }

    private void reset(){
        now = 0;
        nums[0].setText("-");
        nums[1].setText("-");
        nums[2].setText("-");
        nums[3].setText("-");
        nums[4].setText("-");
        nums[5].setText("-");
        hs.clear();

    }

    public void createNum(View view){
        if(now>=6) reset();

        int rand = -1;
        do {
            rand = (int) (Math.random() * 49 + 1);
        }while(hs.contains(rand));
        hs.add(rand);
        tempNum.setText("" + rand);
        tempNum.setVisibility(view.VISIBLE);
        gotoCom.setVisibility(view.VISIBLE);
    }

    public void gotoCom(View view){
        Intent intent = new Intent(this, ConfirmActivity.class);
        startActivityForResult(intent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode>=2){
            nums[now].setText(tempNum.getText());
            now++;
        }
        tempNum.setVisibility(View.GONE);
        gotoCom.setVisibility(View.GONE);
    }
}
