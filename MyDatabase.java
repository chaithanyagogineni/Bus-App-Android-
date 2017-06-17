package user1.myproject.com.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by User1 on 3/14/2015.
 */
public class MyDatabase extends SQLiteOpenHelper {


    Context context;
    SQLiteDatabase db;
    String inbus_id;
    String inbus_type;
    String outbus_id;
    String outbus_type;
    String in_date;
    String out_date;
    String[][] intable = new String[50][3];
    String[][] outtable = new String[50][3];
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "mydataDB.db";
    private static  String TABLE_NAME1 = "indata";
    private static  String TABLE_NAME2 = "outdata";
    private static final String KEY_INBID = "inbus_id";
    private static final String KEY_OUTBID = "outbus_id";
    private static final String KEY_INDATE = "in_date";
    private static final String KEY_INTYPE = "inbus_type";
    private static final String KEY_OUTTYPE = "outbus_type";
    private static final String KEY_OUTDATE = "out_date";
    private static final String[] COLUMNS1 = {KEY_INBID, KEY_INTYPE,KEY_INDATE};
     int len1,len2;
    private static final String[] COLUMNS2 = {KEY_OUTBID, KEY_OUTTYPE,KEY_OUTDATE};
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       this.db = db;

        String CREATE__INDATA_TABLE = "CREATE TABLE " + TABLE_NAME1 + " ( " + "inbus_id TEXT, " +"inbus_type TEXT ,"+"in_date TEXT "+" );";
        String CREATE_OUTDATA_TABLE = "CREATE TABLE " + TABLE_NAME2 + " ( " + "outbus_id TEXT, " +"outbus_type TEXT, "+"out_date TEXT"+" );";
        db.execSQL(CREATE__INDATA_TABLE);
        db.execSQL(CREATE_OUTDATA_TABLE);
     }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }
   public void open() throws SQLException {
      db = getWritableDatabase();
    }
    public void close() {
         if(db!=null)
        db.close();
    }
    public void  addin(Ininfo obj) {
         db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_INBID, obj.getId());
        values.put(KEY_INTYPE, obj.getType());
        values.put(KEY_INDATE, obj.getDate());
        db.insert(TABLE_NAME1, null, values);
        db.close();
     }
    public void  addout(Outinfo obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_OUTBID, obj.getId());
        values.put(KEY_OUTTYPE, obj.getType());
        values.put(KEY_OUTDATE, obj.getDate());
         db.insert(TABLE_NAME2, null, values);
        db.close();
      }
        public void readin() {
        int i = 0;
        String query = "SELECT  * FROM " + TABLE_NAME1;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                intable[i][0] = cursor.getString(0);
                intable[i][1] = cursor.getString(1);
                intable[i][2] = cursor.getString(2);
                i++;
            } while (cursor.moveToNext());
        }


    }

    public void readout() {
        int i = 0;
        String query = "SELECT  * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {


                outtable[i][0] = cursor.getString(0);
                outtable[i][1] = cursor.getString(1);
                outtable[i][2] = cursor.getString(2);
                i++;
            } while (cursor.moveToNext());
        }


    }
    String[][] getInTable() {
        return intable;
    }
    String[][] getOutTable() {
        return outtable;
    }

    public int getInLength()
    {
        String query = "SELECT  * FROM " + TABLE_NAME1;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                len1++;
            } while (cursor.moveToNext());
        }

        return len1;
    }

    int delete(String id)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        if(db.delete(TABLE_NAME1, inbus_id + "=" + id, null)>0) {
            return 1;
        }
        else {
            return 0;
        }

    }

    public int getOutLength()
    {
        String query = "SELECT  * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                len2++;
            } while (cursor.moveToNext());
        }

        return len2;
    }

}