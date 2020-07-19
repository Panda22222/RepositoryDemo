import pojo.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        String sql = "select * from tbl_dept";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet resultSet = prepareStatement.executeQuery();
        List<Dept> list = new ArrayList<>();
        while (resultSet.next()) {
            Dept dept = new Dept();
            dept.setId(resultSet.getInt("dept_id"));
            dept.setName(resultSet.getString("dept_name"));
            list.add(dept);
        }
        list.forEach(s->System.out.println(s));
        DBUtils.close(connection);
    }
}
