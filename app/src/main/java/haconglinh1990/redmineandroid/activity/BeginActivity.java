package haconglinh1990.redmineandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import haconglinh1990.redmineandroid.API.APIClient;
import haconglinh1990.redmineandroid.R;

public class BeginActivity extends AppCompatActivity {
    private static final String MY_TAG = "message_from_meomeo";
    String address, userName, passWord;
    EditText etAddress,etUserName, etPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        etAddress = (EditText) findViewById(R.id.address);
        etUserName = (EditText) findViewById(R.id.username);
        etPassWord = (EditText) findViewById(R.id.password);


    }

    public void clickButtonLogin(View v){

        userName = "linhhc";
        passWord = "linh@123";
        address = "http://192.168.1.51/users/current.json";
        //userName = etUserName.getText().toString();
        //passWord = etPassWord.getText().toString();
        //address = "http://" + etAddress.getText().toString() + "/users/current.json";

        new APIClient(BeginActivity.this).logInUseAPI(address, userName, passWord);

    }
    public void clickButtonRegister(View v){
        startActivity(new Intent(BeginActivity.this, RegisterActivity.class));

    }

    public void clickButtonForgotPassWord(View v) {
        startActivity(new Intent(BeginActivity.this, ForgotPassWordActivity.class));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}