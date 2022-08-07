package com.source.yume.repository;

import com.source.yume.modele.Groups;
import com.source.yume.modele.Students;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    private String url = "jdbc:postgresql://localhost:5432/hei";
    private String user = "postgres";
    private String password = "andrianina";
    @Override
    public List<Students> findAll() {
        List list = new ArrayList<Students>();
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT s.id, s.name, g.id, g.name, g.creation_date FROM students s INNER JOIN groups g ON g.id = s.group_id;");
            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString(2);
                int group_id = res.getInt(3);
                String group_name = res.getString(4);
                Date creation_date = res.getDate(5);
                list.add(new Students(id, name, new Groups(group_id, group_name, creation_date)));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Students save(Students s) {
        List list = new ArrayList<Students>();
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            Statement stm = con.createStatement();
            stm.executeUpdate("INSERT INTO hei VALUES ('" + s.getId() + "', '" + s.getName() + "', " +s.getGroup()+ ")");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    @Override
    public void deleteById(int Id) {
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            Statement stm = con.createStatement();
            stm.executeUpdate("DELETE FROM students WHERE id='" +Id+ "'");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Students> findWhereNameLike(String query) {
        List list = new ArrayList<Students>();
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT s.id, s.name, g.id, g.name, g.creation_date FROM students s INNER JOIN groups g ON g.id = s.group_id WHERE s.name LIKE '%"+query+"%';");
            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString(2);
                int group_id = res.getInt(3);
                String group_name = res.getString(4);
                Date creation_date = res.getDate(5);
                list.add(new Students(id, name, new Groups(group_id, group_name, creation_date)));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
