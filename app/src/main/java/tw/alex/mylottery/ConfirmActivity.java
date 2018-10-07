package tw.alex.mylottery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ConfirmActivity extends AppCompatActivity {
    private ImageView imgCom;
    private int[] coms = {
            R.drawable.c2, R.drawable.c3, R.drawable.c1, R.drawable.c1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        imgCom = findViewById(R.id.cupimg);


        int rand = (int)(Math.random()*4);
        imgCom.setImageResource(coms[rand]);

        setResult(rand);
    }
}
