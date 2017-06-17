package user1.myproject.com.test1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class userpage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);
        ImageButton in1 = (ImageButton) findViewById(R.id.in1);
        in1.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), listview_layout.class);
                startActivityForResult(intent, 0);
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return false;
            }
        });
        ImageButton out1 = (ImageButton) findViewById(R.id.out1);
        out1.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), outpage_layout.class);
                startActivityForResult(intent, 0);

            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return false;
            }
        });
    }


   // @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_userpage, menu);
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
