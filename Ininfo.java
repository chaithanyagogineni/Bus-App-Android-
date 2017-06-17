package user1.myproject.com.test1;

/**
 * Created by User1 on 3/17/2015.
 */
public class Ininfo {
    //private int id;
    private String inbus_id;
    private String inbus_type;
    private String inbus_date;
    public Ininfo() {
    }
    public Ininfo(String inbus_id,String inbus_type,String inbus_date){
        this.inbus_id=inbus_id;
        this.inbus_type=inbus_type;
        this.inbus_date=inbus_date;
     }
    public void setId(String id)
    {
        this.inbus_id=id;
    }
    public String getId()
    {
        return this.inbus_id;
    }
    public void setType(String type)
    {
        this.inbus_type=type;
    }
    public String getType()
    {
        return this.inbus_type;
    }
    public void setDate(String date)
    {this.inbus_date=date;}
    public String getDate(){ return this.inbus_date;}
}
