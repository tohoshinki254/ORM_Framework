package MyORM.Sample;

import java.sql.Timestamp;
import java.util.Date;

import MyORM.Annotations.Column;
import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

@Table(name = "hoadon")
public class HoaDon {
    @PrimaryKey(name = "idHoaDon", autoId = false)
    String id;
    
    @Column(name = "NgayLap")
    Timestamp time;

    @Override
    public String toString() {
        return "HoaDon [id=" + id + ", time=" + time + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public HoaDon(String id, Timestamp time) {
        this.id = id;
        this.time = time;
    }

    
}
