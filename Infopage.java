package user1.myproject.com.test1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Infopage extends ActionBarActivity {

    public static MyDatabase obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);

        obj = new MyDatabase(this);

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivityForResult(intent, 0);
            }
        });

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivityForResult(intent, 0);
            }
        });
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Busespage.class);
                startActivityForResult(intent, 0);
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Outpage.class);
                startActivityForResult(intent, 0);

            }
        });
        Button report = (Button) findViewById(R.id.report);
        report.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), userpage.class);

                startActivityForResult(intent, 0);
            }
        });

    }

    public static MyDatabase getObject() {
        return obj;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infopage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)





  {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private abstract class onClickListener implements View.OnClickListener {
    }
}