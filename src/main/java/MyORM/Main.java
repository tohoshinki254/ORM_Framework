package MyORM;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import MyORM.Common.Connection;
import MyORM.Demo.DoUong;
import MyORM.Demo.HoaDon;
import MyORM.Demo.LoaiDoUong;
import MyORM.MySQL.MySQLConnection;
import MyORM.MySQL.MySQLMapper;

public class Main {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/trasua?user=root&password=12345678";

    public static void main(String[] args) throws Exception {
        System.out.println("abc");

        // System.out.println("Hello, World!");
        Connection connection = new MySQLConnection(CONNECTION_STRING);
        connection.open();

        // // * Câu lệnh select
        // List<DoUong> listDoUong = connection.select(DoUong.class).where("(DonGia >= 40000 and DonGia < 50000) or DonGia = 10000").run(DoUong.class);

        // for (DoUong doUong : listDoUong) {
        //     System.out.println(doUong);
        // }

        // // ! Câu lệnh insert
        // HoaDon newHoaDon = new HoaDon("12347", Timestamp.valueOf(LocalDateTime.now()));
        // Integer insertResult1 = connection.insert(newHoaDon, HoaDon.class);
        // System.out.println(insertResult1 + "row affected");


        // // * Ta sẽ thêm vào một đồ uống có mã đồ uống = 01
        List<LoaiDoUong> listLoaiDoUong = connection.select(LoaiDoUong.class).where("IdLoai = '01'").run(LoaiDoUong.class);
        for (LoaiDoUong loaiDoUong : listLoaiDoUong) {
            System.out.println(loaiDoUong);
        }
        // DoUong newDoUong = new DoUong("01235", "Đồ uống mã 99", listLoaiDoUong.get(0), 50000, null);


        // // ! Câu lệnh insert có áp dụng khóa ngoại
        // Integer insertResult2 = connection.insert(newDoUong, DoUong.class);
        // System.out.println(insertResult2 + " row affected");


        // // ! Câu lệnh update 
        // // * Ta sẽ update đối tượng ta vừa thêm vào bằng cách đổi tên đồ uống thành "Đồ uống đã đổi tên"
        // newDoUong.name = "Đồ uống đã đổi tên";
        // Integer updateResult = connection.update(newDoUong, DoUong.class);
        // System.out.println(updateResult + " row affected");

        
        DoUong prototypeDoUong = new DoUong(null, null, new LoaiDoUong(), null, null);



        MySQLMapper mapper = new MySQLMapper();
        HashMap<String, Object> map = mapper.getColumnValues(prototypeDoUong);
        map.clear();
        // map.put("DonGia", 20000);
        map.put("Loai", listLoaiDoUong.get(0));

        // Integer p = connection.update(map, DoUong.class, "DonGia = 17000");
        // System.out.println(p + " row(s) updated");


        // // ! Câu lệnh delete
        // // * Ta sẽ xóa đồ uống vừa tạo
        Integer deleteResult = connection.delete(DoUong.class, " = 17000");
        System.out.println(deleteResult);


        connection.close();
    }
}
