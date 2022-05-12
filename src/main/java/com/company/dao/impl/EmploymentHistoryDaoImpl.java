package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        String header = rs.getString("header");
        String job_description = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, job_description, new User(userId));
        return emp;


    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory emp = getEmploymentHistory(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(int id) {
        EmploymentHistory result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from employment_history where id =" + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getEmploymentHistory(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into country (header,begin_date,end_date,job_description) values(?,?,?,?)");
            stmt.setString(1, eh.getHeader());
            stmt.setDate(2, eh.getBeginDate());
            stmt.setDate(3, eh.getEndDate());
            stmt.setString(4, eh.getJob_description());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }




    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set header=?,begin_date=?,end_date=?,job_description=? where id=?");
            stmt.setString(1, eh.getHeader());
            stmt.setDate(2, eh.getBeginDate());
            stmt.setDate(3, eh.getEndDate());
            stmt.setString(4, eh.getJob_description());
            stmt.setInt(5, eh.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        try(Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from employment_history where id = "+id);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

    }
}

