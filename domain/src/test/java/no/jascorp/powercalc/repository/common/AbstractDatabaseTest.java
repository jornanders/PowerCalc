package no.jascorp.powercalc.repository.common;

import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author Jørn Anders Svendsen
 *
 */
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public abstract class AbstractDatabaseTest extends RepositoryTestContext {

	@Autowired
	private DataSource dataSource;

	
	@BeforeTransaction 
    public void init() throws Exception{  
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());  
    }  
  
    @AfterTransaction
    public void after() throws Exception{  
        DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());  
    }  
  
    private IDatabaseConnection getConnection() throws Exception{  
        Connection con = dataSource.getConnection();  
        IDatabaseConnection connection = new DatabaseConnection(con);  
        DatabaseConfig config = connection.getConfig();  
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());  
        return connection;  
    }  
	
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new ClassPathResource(getDataSetFileName()).getFile());
	}
	
	protected abstract String getDataSetFileName();

}
