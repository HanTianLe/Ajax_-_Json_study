package com.hantianle.web.dao.Impl;

import com.hantianle.web.dao.FindUserDao;
import com.hantianle.web.domain.Student;
import com.hantianle.web.utils.JDBCTools;

import java.sql.SQLException;

public class FindUserDaoImpl extends JDBCTools implements FindUserDao {
    /**
     * 查找学生信息
     * @param username
     * @return
     */
    @Override
    public Student FindUserByUsername(String username) {
        //获得连接对象
        getConnection();
        String sql = "select * from student where name = ?";
        //创建学生对象
        Student student = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                student = new Student(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDate(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            close();
        }
        return student;
    }
}

