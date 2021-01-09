package MyORM.Sample;

import java.util.Date;
import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.OneToMany;
import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

@Table(name = "orders")
public class Order {
    @PrimaryKey(name = "id", autoId = true)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "total")
    private int total;

    @Column(name = "status")
    private String status;

    @OneToMany(tableName = "products", joinColumn = "order_id")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order [createdAt=" + createdAt + ", id=" + id + ", products=" + products + ", status=" + status
                + ", total=" + total + "]";
    }

}
