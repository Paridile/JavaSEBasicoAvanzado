package com.paridile.amazonviewer.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.paridile.amazonviewer.db.Database.*;

public interface IDBConnection {
	default Connection connectToDB() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			return connection;
		}
	}
	
}
