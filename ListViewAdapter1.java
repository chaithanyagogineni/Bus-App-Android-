package user1.myproject.com.test1;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter1 extends ArrayAdapter<Ininfo> {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    List<Ininfo> ininfolist;
    //List<Outinfo>outinfolist;

    private SparseBooleanArray mSelectedItemsIds;

    public ListViewAdapter1(Context context, int resourceId,
                            List<Ininfo> ininfolist) {
        super(context, resourceId, ininfolist);
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.ininfolist = ininfolist;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView bus_id;
        TextView bus_type;
        TextView date;

    }

    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
                         // Locate the TextViews in listview_item.xml
            view = inflater.inflate(R.layout.activity_listview_layout, null);


            holder.bus_id = (TextView) view.findViewById(R.id.busid);
            holder.bus_type = (TextView) view.findViewById(R.id.bustype);
            holder.date = (TextView) view.findViewById(R.id.date);
            // Locate the ImageView in listview_item.xml
            //holder.img = (ImageView) view.findViewById(R.id.img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Capture position and set to the TextViews
        holder.bus_id.setText(ininfolist.get(position).getId());
        holder.bus_type.setText("Bus Type    : "+ininfolist.get(position).getType());
        holder.date.setText( "Date&Time : "+ininfolist.get(position).getDate());

        // Capture position and set to the ImageView
        //Bitmap bitmap = BitmapFactory.decodeFile(productsList.get(position).getImg_path());
        //holder.img.setImageBitmap(bitmap);
        return view;
    }

    @Override
    public void remove(Ininfo object) {
        ininfolist.remove(object);
        notifyDataSetChanged();
    }

    public List<Ininfo> getIninfolist() {

        return ininfolist;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {

        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {

        return mSelectedItemsIds;
    }
}

