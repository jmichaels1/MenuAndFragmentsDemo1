package iam47662285.escoladeltreball.org.menuandfragmentsdemo1;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private Button btnAdd,btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();


    }

    private void setup() {
        btnAdd = (Button)findViewById(R.id.btn_add_fragment);
        btnRemove = (Button)findViewById(R.id.btn_remove_fragment);

        btnAdd.setOnClickListener(view -> addFragment());
        btnRemove.setOnClickListener(view -> removeFragment());
    }

    private void removeFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStack();
        }
    }




    private void addFragment() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, BlankFragment.newInstance(null,null)).
                addToBackStack(null).
                commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about:
                Toast.makeText(this,"About us ", Toast.LENGTH_LONG).show();
                // Indica que hem consumit l'event
                return true;
            case R.id.item_credits:
                Toast.makeText(this,"Credits",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_rate:
                Toast.makeText(this,"Rate us",Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.item_rate);
        item.setEnabled(!item.isEnabled());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
