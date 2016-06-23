package su.levenetc.sqlciphernfc;

import android.content.ComponentName;
import android.content.Intent;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.sqlcipher.database.SQLiteDatabase;

import su.levenetc.sqlciphernfc.service.NfcService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_set_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDefaultTapAndPay();
            }
        });

        SQLiteDatabase database = App.getDatabase();
    }

    private void setDefaultTapAndPay() {
        Intent intent = new Intent();
        intent.setAction(CardEmulation.ACTION_CHANGE_DEFAULT);
        intent.putExtra(CardEmulation.EXTRA_SERVICE_COMPONENT, new ComponentName(this, NfcService.class));
        intent.putExtra(CardEmulation.EXTRA_CATEGORY, CardEmulation.CATEGORY_PAYMENT);
        startActivity(intent);
    }
}