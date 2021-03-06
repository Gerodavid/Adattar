package david.gero.adattar;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Nevtxt, Emailtxt, Telefonszamtxt, Lakcimtxt;
    List<Adatkiir> Adatkiiras = new ArrayList<Adatkiir>();
    ListView AdattovabittasListView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nevtxt =(EditText) findViewById(R.id.txtNev);
        Emailtxt= (EditText) findViewById(R.id.txtEmail);
        Telefonszamtxt=(EditText) findViewById(R.id.txtTelefonszam);
        Lakcimtxt= (EditText) findViewById(R.id.txtLakcim);
        AdattovabittasListView = (ListView) findViewById(R.id.listView);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("adatbekero");
        tabSpec.setContent(R.id.tabAdat);
        tabSpec.setIndicator("Adatbekérő");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("adatkiiro");
        tabSpec.setContent(R.id.tabKiir);
        tabSpec.setIndicator("Adatkiírás");
        tabHost.addTab(tabSpec);

        final Button addBtn=(Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adattovabbitas(Nevtxt.getText().toString(), Emailtxt.getText().toString(), Telefonszamtxt.getText().toString(), Lakcimtxt.getText().toString());
                Kilistazas();
                Toast.makeText(getApplicationContext(), Nevtxt.getText().toString() + " személy adatait felvettük", Toast.LENGTH_SHORT).show();
            }
        });

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
    private void Kilistazas(){
        ArrayAdapter<Adatkiir> adapter = new ContactListAdapter();
        AdattovabittasListView.setAdapter(adapter);
    }


    private void Adattovabbitas(String Nev, String Email, String Telefonszam, String Lakcim){
        Adatkiiras.add(new Adatkiir(Nev, Email, Telefonszam, Lakcim));
    }

    private class ContactListAdapter extends ArrayAdapter<Adatkiir>{

        public ContactListAdapter(){
            super(MainActivity.this,R.layout.adatkiir_lista, Adatkiiras);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            if(view == null)
                view =getLayoutInflater().inflate(R.layout.adatkiir_lista, parent, false);

            Adatkiir jelenlegiAdatkiir =Adatkiiras.get(position);

            TextView Nev = (TextView) view.findViewById(R.id.dolgozoNev);
            Nev.setText(jelenlegiAdatkiir.get_Nev());
            TextView Email = (TextView) view.findViewById(R.id.EmailAdat);
            Email.setText(jelenlegiAdatkiir.get_Email());
            TextView Telefonszam = (TextView) view.findViewById(R.id.TelefonSzam);
            Telefonszam.setText(jelenlegiAdatkiir.get_Telefonszam());
            TextView Lakcim = (TextView) view.findViewById(R.id.Lakcim);
            Lakcim.setText(jelenlegiAdatkiir.get_Lakcim());

            return view;
        }
    }
}


