package MyORM;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import MyORM.Common.Connection;
import MyORM.Common.Query.WhereComponentQuery.MySQLWhereComponent;
import MyORM.Common.Query.WhereComponentQuery.MySQLWhereOperation;
import MyORM.Demo.DoUong;
import MyORM.Demo.HoaDon;
import MyORM.Demo.LoaiDoUong;
import MyORM.Factory.ConnectionFactory;
import MyORM.Factory.DatabaseType;
import MyORM.MySQL.MySQLConnection;
import MyORM.MySQL.MySQLMapper;

public class Main {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/trasua?user=root&password=12345678";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionFactory.createConnection(DatabaseType.MYSQL, CONNECTION_STRING);
        connection.open();


        MySQLWhereOperation operation = new MySQLWhereOperation();
        String whereQuery = operation.and(operation.lessThan("DonGia", 30000), operation.moreThan("DonGia", 20000)).getComponentString();
        // ! Câu lệnh select
        // List<DoUong> listDoUong = connection.select(DoUong.class)
        //         .where("(DonGia >= 20000 and DonGia < 30000) or DonGia = 17000").run(DoUong.class);

        List<DoUong> listDoUong = connection.select(DoUong.class)
        .where(whereQuery).run(DoUong.class);


        for (DoUong doUong : listDoUong) {
            System.out.println(doUong);
        }

        System.out.println();

        // // ! Câu lệnh insert
        // System.out.println("Câu lệnh insert");

        // HoaDon newHoaDon = new HoaDon("hd001", Timestamp.valueOf(LocalDateTime.now()));
        // Integer insertResult1 = connection.insert(newHoaDon, HoaDon.class);
        // System.out.println(insertResult1 + " row affected\n");

        // System.out.println();

        // // ! Câu lệnh insert có áp dụng khóa ngoại
        // System.out.println("Câu lệnh insert có áp dụng khóa ngoại");

        // // * Ta sẽ thêm vào một đồ uống có mã đồ uống = 01
        // List<LoaiDoUong> listLoaiDoUong = connection.select(LoaiDoUong.class).all().run(LoaiDoUong.class);
        // DoUong newDoUong = new DoUong("23456", "Đồ uống mã 23456", listLoaiDoUong.get(0), 50000, null);
        // Integer insertResult2 = connection.insert(newDoUong, DoUong.class);
        // System.out.println(insertResult2 + " row affected\n");


        // // ! Câu lệnh update 
        // System.out.println("Câu lệnh update");
        // // * Ta sẽ update đối tượng có loại = '01' sẽ có đơn giá = 20000
        // DoUong prototypeDoUong = new DoUong(null, null, new LoaiDoUong(), null, null);

        // MySQLMapper mapper = new MySQLMapper();
        // HashMap<String, Object> map = mapper.getColumnValues(prototypeDoUong);
        // map.clear();
        // map.put("DonGia", 20000);

        // Integer p = connection.update(map, DoUong.class, "Loai = '01'");
        // System.out.println(p + " row(s) updated");

        // System.out.println();

        // // ! Câu lệnh delete
        // System.out.println("Câu lệnh delete");

        // // * Ta sẽ xóa đồ uống có giá tiền = 20000
        // Integer deleteResult = connection.delete(DoUong.class, "DonGia = 20000");
        // System.out.println(deleteResult + "row(s) affected");

        connection.close();
    }
}
