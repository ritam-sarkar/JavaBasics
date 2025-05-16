package com.riversand.structural.bridge;



/**
 * @author ritsarka
 * Example Driver classes like jdbc
 * This design is build in such a way that user cannot predict the implementation change.
 * User only care about the output , means the code for Postgre or Oracle or Mysql are same
 * Driver creates these 3 abstraction layer Connection , Statement , ResultSet over it , so that implementaer does not have any idea what is implemented
 * <p>
 * <p>
 * Bridge pattern work as a bridge between this two
 * We can make another formatter like html formatter and make a bridge with movie printer
 */
public class BridgePatternDemo {

    /**
     * Here we have formatter which does not know the details
     * <p>
     * On other hand  movie printer only knows about movie
     * If we change anything in formatter printer does not care and vice versa
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {

        /*Movie movie = new Movie("Comedy", "Pink panther", 2);
        Formatter printFormatter = new PrintFormatter();
        Printer moviPrinter = new MoviePrinter(movie);
        System.out.println(moviPrinter.print(printFormatter));*/
		// In actual Driver Class.forname is used to register , but classpath is not possible here
		new OracleDriver().register();
		callDB();
		new MySqlDriver().register();
		callDB();

	}

	private static void callDB() {
		Connection connection = DriverManager.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery();
		System.out.println(rs.record());
	}


}

	interface Connection {
      Statement createStatement();
	}

	interface Statement {
       ResultSet executeQuery();
	}

	interface Driver {
       Connection provideConnection();

		default void register(){
			DriverManager.registerDriver(this);
		}
	}


	class MySqlDriver implements Driver {
		public Connection provideConnection() {
			return new MySqlConnection();
		}

	}

	class OracleDriver implements Driver {

		public Connection provideConnection() {
			return new OracleConnection();
		}
	}


	class OracleConnection implements Connection {

		@Override
		public Statement createStatement() {
			return new OracleStatement();
		}
	}
	class MySqlConnection implements Connection {

		@Override
		public Statement createStatement() {
			return new MySqlStatement();
		}
	}
	class DriverManager {
		private static Driver driver;

		static Connection getConnection() {
			return driver.provideConnection();
		}

		public static void registerDriver(Driver driver) {
			DriverManager.driver = driver;
		}
	}
	class OracleStatement implements Statement {

		@Override
		public ResultSet executeQuery() {
			return new ResultSet("Oracle record");
		}
	}
	class MySqlStatement implements Statement {

		@Override
		public ResultSet executeQuery() {
			return new ResultSet("MySql record");
		}
	}
	class ResultSet {
		private String record;

		public ResultSet(String record){
			this.record = record;
		}
		public String record(){
			return record;
		}

	}
