package MyORM.Demo;

import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.OneToMany;
import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

@Table(name = "loaidouong")
public class LoaiDoUong {

    @PrimaryKey(name = "IdLoai", autoId = false)
    public String id;

    @Column(name="TenLoai")
    public String name;

    public LoaiDoUong(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(tableName = "douong", joinColumn = "Loai")
    public List<DoUong> doUongList;

    @Override
    public String toString() {
        return "LoaiDoUong [id=" + id + ", name=" + name + "]";
    }


    public LoaiDoUong() {
        
    }
    
}
