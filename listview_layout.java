package user1.myproject.com.test1;

import android.content.Context;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class listview_layout extends ActionBarActivity {

    public static List<Ininfo> ininfolist = new ArrayList<Ininfo>();

    public static ListView list;

    public Context context ;
    public static ListViewAdapter1 listViewAdapter1;




    public static View view;



    public static MyDatabase obj;

    public static String[][] table;
    // public static int[] id = new int[30];
    public static String[] busid = new String[30];
    public static String[] bustype = new String[30];
    public static String[] date = new String[30];
    //public static String[] cur_price = new String[30];

   // public static Drawable d[];

    //public static String img_path[];

    public static int len, i;


    //private OnFragmentInteractionListener mListener;

    public listview_layout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getData();
    }





   /* public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.activity_listview_layout, container, false);

        return view;
    }*/

    public void getData() {
        context = this;

        ininfolist.clear();

        obj = Infopage.getObject();

        obj.open();
        obj.readin();

        table = obj.getInTable();

        len = obj.getInLength();
        for (i = 0; i < len; i++) {
            busid[i] = table[i][0];
            bustype[i] = table[i][1];
            date[i] = table[i][2];
        }

        for (int i = 0; i < len; i++) {
            Ininfo ininfoobj = new Ininfo(busid[i], bustype[i], date[i]);
            ininfolist.add(ininfoobj);
        }


        // Locate the ListView in listview_layout.xml
        list = (ListView) findViewById(R.id.listitems);

        // Pass results to ListViewAdapter Class


        // Binds the Adapter to the ListView

        listViewAdapter1 = new ListViewAdapter1(context, R.layout.activity_listview_layout,
                ininfolist);
        list.setAdapter(listViewAdapter1);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        // Capture ListView item click
        list.setMultiChoiceModeListener(new MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode,
                                                  int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = list.getCheckedItemCount();
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class
                listViewAdapter1.toggleSelection(position);
            }


            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // Calls getSelectedIds method from ListViewAdapter Class
                        SparseBooleanArray selected = listViewAdapter1
                                .getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Ininfo selectedItem = listViewAdapter1
                                        .getItem(selected.keyAt(i));
                                // Remove selected items following the ids
                                listViewAdapter1.remove(selectedItem);

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
                listViewAdapter1.removeSelection();
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }


    public ListViewAdapter1 getAdapter() {
        return listViewAdapter1;
    }

//

    //@Override

    //public void onAttach(Activity activity) {

    //super.onAttach(activity);

    //

    //try {

    //mListener = (OnFragmentInteractionListener) activity;

    //} catch (ClassCastException e) {

    //throw new ClassCastException(activity.toString()

    //+ " must implement OnFragmentInteractionListener");

    //}

    //}

    //

    //@Override

    //public void onDetach() {

    //super.onDetach();

    //mListener = null;

    //}

    //

    //

    //* This interface must be implemented by activities that contain this

    //* fragment to allow an interaction in this fragment to be communicated

    //* to the activity and potentially other fragments contained in that

    //* activity.

    //* <p/>

    //* See the Android Training lesson <a href=

    //* "http://developer.android.com/training/basics/fragments/communicating.html"

    //* >Communicating with Other Fragments</a> for more information.

    //

    //public interface OnFragmentInteractionListener {

    //// TODO: Update argument type and name

    //public void onFragmentInteraction(Uri uri);

    //}

    //

}

