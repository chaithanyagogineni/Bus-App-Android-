package user1.myproject.com.test1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;


public class Outpage extends ActionBarActivity {
    String outbus_id;
    String outbus_type;
    int cb=0;
    int rb=0;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    RadioButton rb5;
    RadioButton rb6;
    RadioButton rb7;
    RadioButton rb8;
    RadioButton rb9;
    RadioButton rb10;
    RadioButton rb11;
    RadioButton rb12;
    RadioButton rb13;
    RadioButton rb14;
    RadioButton rb15;
    RadioButton rb16;
    RadioButton rb17;
    RadioButton rb18;
    RadioButton rb19;
    RadioButton rb20;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    CheckBox cb5;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpage);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        rb4=(RadioButton)findViewById(R.id.rb4);
        rb5=(RadioButton)findViewById(R.id.rb5);
        rb6=(RadioButton)findViewById(R.id.rb6);
        rb7=(RadioButton)findViewById(R.id.rb7);
        rb8=(RadioButton)findViewById(R.id.rb8);
        rb9=(RadioButton)findViewById(R.id.rb9);
        rb10=(RadioButton)findViewById(R.id.rb10);
        rb11=(RadioButton)findViewById(R.id.rb11);
        rb12=(RadioButton)findViewById(R.id.rb12);
        rb13=(RadioButton)findViewById(R.id.rb13);
        rb14=(RadioButton)findViewById(R.id.rb14);
        rb15=(RadioButton)findViewById(R.id.rb15);
        rb16=(RadioButton)findViewById(R.id.rb16);
        rb17=(RadioButton)findViewById(R.id.rb17);
        rb18=(RadioButton)findViewById(R.id.rb18);
        rb19=(RadioButton)findViewById(R.id.rb19);
        rb20=(RadioButton)findViewById(R.id.rb20);
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);
        submit=(Button)findViewById(R.id.submit);
        final MyDatabase dbobj2 = Infopage.getObject();
        final Outinfo obj2=new Outinfo();
        submit.setOnClickListener(new onClickListener() {
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                String str = c.getTime().toString();
                obj2.setDate(str);

                if (rb1.isChecked())

                {
                    rb=rb+1;

                    outbus_id = (String) rb1.getText();

                } else if (rb2.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb2.getText();
                } else if (rb3.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb3.getText();
                } else if (rb4.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb4.getText();
                } else if (rb5.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb5.getText();
                } else if (rb6.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb6.getText();
                } else if (rb7.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb7.getText();
                } else if (rb8.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb8.getText();
                } else if (rb9.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb9.getText();
                } else if (rb10.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb10.getText();
                } else if (rb11.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb11.getText();
                } else if (rb12.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb12.getText();
                } else if (rb13.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb13.getText();
                } else if (rb14.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb14.getText();
                } else if (rb15.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb15.getText();
                } else if (rb16.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb16.getText();
                } else if (rb17.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb17.getText();
                } else if (rb18.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb18.getText();
                } else if (rb19.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb19.getText();
                } else if (rb20.isChecked())

                {
                    rb=rb+1;
                    outbus_id = (String) rb20.getText();
                }

                if (cb1.isChecked())

                {
                    cb=cb+1;
                    outbus_type = ((String) cb1.getText());
                } else if (cb2.isChecked())

                {
                    cb=cb+1;
                    outbus_type = ((String) cb2.getText());
                } else if (cb3.isChecked())

                {
                    cb=cb+1;
                    outbus_type = ((String) cb3.getText());
                } else if (cb4.isChecked())

                {
                    cb=cb+1;
                    outbus_type = ((String) cb4.getText());
                } else if (cb5.isChecked())

                {
                    cb=cb+1;
                    outbus_type = ((String) cb5.getText());
                }

                if ((outbus_type==null)||(outbus_id==null)||(cb!=1)||(rb!=1))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect selection";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(v.getContext(), Infopage.class);
                    startActivityForResult(intent, 0);

                }
                else

                {
                    obj2.setId(outbus_id);
                    obj2.setType(outbus_type);
                    dbobj2.addout(obj2);
                    Context context = getApplicationContext();
                    CharSequence text = "added successfully";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(v.getContext(), Infopage.class);
                    startActivityForResult(intent, 0);

                }


                /*rb1.("");
                rb2.setText("");
                rb3.setText("");
                rb4.setText("");
                rb5.setText("");
                rb6.setText("");
                rb7.setText("");
                rb8.setText("");
                rb9.setText("");
                rb10.setText("");
                rb11.setText("");
                rb12.setText("");
                rb13.setText("");
                rb14.setText("");
                rb15.setText("");
                rb16.setText("");
                rb17.setText("");
                rb18.setText("");
                rb19.setText("");
                rb20.setText("");
                cb1.setText("");
                cb2.setText("");
                cb3.setText("");
                cb4.setText("");
                cb5.setText("");*/


            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return false;
            }
        });

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_outpage, menu);
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
