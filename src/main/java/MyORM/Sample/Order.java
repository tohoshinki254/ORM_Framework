package MyORM.Sample;

import java.sql.Date;
import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.OneToMany;
import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

@Table(name = "orders")
public class Order {
    @PrimaryKey(name = "id", autoId = true)
    public Long id;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "total")
    public int total;

    @Column(name = "status")
    public String status;

    @OneToMany(tableName = "products", joinColumn = "order_id")
    public List<Product> products;

    public Order(Long i, Date now, int k, String string) {
        id = i;
        createdAt = now;
        total = k;
        status = string;
	}

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
