package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import java.util.List;
public interface EmploymentHistoryDaoInter {
   
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    public EmploymentHistory getEmploymentHistoryById(int id);
    public boolean addEmploymentHistory(EmploymentHistory eh);
    public boolean updateEmploymentHistory(EmploymentHistory eh);
    public boolean removeEmploymentHistory(int id);

}
