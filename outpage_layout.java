package user1.myproject.com.test1;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class outpage_layout extends ActionBarActivity {
    public static List<Outinfo> outinfolist = new ArrayList<Outinfo>();

    public static ListView list;

    public Context context ;
    public static ListViewAdapter2 listViewAdapter2;




    public static View view;



    public static MyDatabase obj;

    public static String[][] table;
    // public static int[] id = new int[30];
    public static String[] busid = new String[30];
    public static String[] bustype = new String[30];
    public static String[] date = new String[30];
    public static int len, i;
    public outpage_layout() {
        // Required empty public constructor
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getData();
    }
    public void getData() {
        context = this;

        outinfolist.clear();

        obj = Infopage.getObject();

        obj.open();
        obj.readout();

        table = obj.getOutTable();

        len = obj.getOutLength();
        for (i = 0; i < len; i++) {
            busid[i] = table[i][0];
            bustype[i] = table[i][1];
            date[i] = table[i][2];
        }

        for (int i = 0; i < len; i++) {
            Outinfo outinfoobj = new Outinfo(busid[i], bustype[i], date[i]);
            outinfolist.add(outinfoobj);
        }


        // Locate the ListView in listview_layout.xml
        list = (ListView) findViewById(R.id.listitems);

        // Pass results to ListViewAdapter Class


        // Binds the Adapter to the ListView

        listViewAdapter2 = new ListViewAdapter2(context, R.layout.activity_outpage_layout,
                outinfolist);
        list.setAdapter(listViewAdapter2);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        // Capture ListView item click
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode,
                                                  int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = list.getCheckedItemCount();
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class
                listViewAdapter2.toggleSelection(position);
            }


            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // Calls getSelectedIds method from ListViewAdapter Class
                        SparseBooleanArray selected = listViewAdapter2
                                .getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Outinfo selectedItem = listViewAdapter2
                                        .getItem(selected.keyAt(i));
                                // Remove selected items following the ids
                                listViewAdapter2.remove(selectedItem);

                                //delete the selected item from database

                                if(obj.delete(selectedItem.getId())==1)
                                {
                                    //Deleted Successfully
                                    Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_LONG).show();
                                } else {
                                    //Cannot delete, try again
                                    Toast.makeText(context, "Cannot delete, try again", Toast.LENGTH_LONG).show();
                                }

                            }
                        }
                        // Close CAB
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.delete_menu, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                listViewAdapter2.removeSelection();
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_outpage_layout, menu);
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
