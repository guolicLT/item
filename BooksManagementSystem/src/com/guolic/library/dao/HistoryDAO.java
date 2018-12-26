package com.guolic.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.guolic.library.emtity.History;

public interface HistoryDAO {
    void addOne(History history)throws SQLException;
    List<History> queryAllHistoryByUid(String uid) throws SQLException;
    
    void updateReturnTime(String id,String returnTime) throws SQLException;
}
