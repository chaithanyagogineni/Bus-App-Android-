package user1.myproject.com.test1;

/**
 * Created by User1 on 3/20/2015.
 */
public class Outinfo {
    //private int id;
    private String outbus_id;
    private String outbus_type;
    private String outbus_date;
    public Outinfo() {
    }
    public Outinfo(String outbus_id,String outbus_type,String outbus_date){
        this.outbus_id=outbus_id;
        this.outbus_type=outbus_type;
        this.outbus_date=outbus_date;
    }
    public void setId(String id)
    {
        this.outbus_id=id;
    }
    public String getId()
    {
        return this.outbus_id;
    }
    public void setType(String type)
    {
        this.outbus_type=type;
    }
    public String getType()
    {
        return this.outbus_type;
    }
    public void setDate(String date)
    {
        this.outbus_date=date;
    }
    public String getDate()
    {
        return this.outbus_date;
    }

}
