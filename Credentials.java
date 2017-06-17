package user1.myproject.com.test1;
import android.*;
import android.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Credentials extends ActionBarActivity {
    // SQLiteOpenHelper dbhelper;
     // SQLiteDatabase database;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
        //dbhelper = new DataBase1(this);
        //database=dbhelper.getWritableDatabase();
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("password"))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "successful.have a nice day";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Intent intent = new Intent(v.getContext(), Infopage.class);
                    startActivityForResult(intent, 0);
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid credentials!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(v.getContext(), Credentials.class);
                    startActivityForResult(intent, 0);
                }


            }

        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_credentials, menu);
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
