package david.gero.adattar;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    EditText Nevtxt, Emailtxt, Telefonszamtxt, Lakcimtxt;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nevtxt =(EditText) findViewById(R.id.txtNev);
        Emailtxt= (EditText) findViewById(R.id.txtEmail);
        Telefonszamtxt=(EditText) findViewById(R.id.txtTelefonszam);
        Lakcimtxt= (EditText) findViewById(R.id.txtLakcim);
        final Button addBtn=(Button) findViewById(R.id.btnAdd);

        Nevtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            addBtn.setEnabled(!Nevtxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

}


