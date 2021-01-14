package MyORM.Demo;

import MyORM.Annotations.*;

@Table(name="douong")
public class DoUong {
    @PrimaryKey(name="idDoUong", autoId = false)
    public String id;

    @Column(name = "TenDoUong")
    public String name;

    @ManyToOne(tableName="loaidouong", refColumn="IdLoai", columnName="Loai")
    public LoaiDoUong type;

    @Column(name = "DonGia")
    public Integer price;

    @Column(name = "Image")
    public String image;

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


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DoUong() {}

    public DoUong(String id, String name, LoaiDoUong type, Integer price, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "DoUong [id=" + id + ", image=" + image + ", name=" + name + ", price=" + price + ", type=" + type + "]";
    }

    public LoaiDoUong getType() {
        return type;
    }

    public void setType(LoaiDoUong type) {
        this.type = type;
    }

    
}
