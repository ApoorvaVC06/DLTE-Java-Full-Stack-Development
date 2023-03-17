package org.example;

import java.io.IOException;
import java.sql.SQLException;

public interface StudentRemote {
    public void InsertDetails() throws IOException, SQLException;
    public void InsertDB(Student student) throws SQLException;
    public void GetDetails() throws SQLException;

}
