import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory(){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("root");
		
		cpds.setMaxPoolSize(20);
		
		this.dataSource = cpds;
	}
	
	public Connection criaConexao() throws SQLException {		
		return this.dataSource.getConnection();
	}
	
}
