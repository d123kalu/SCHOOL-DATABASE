import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Driver {
	static DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	
	public static Time getTime(String time) throws ParseException {
		long date = sdf.parse(time).getTime();
		Time t = new Time(date);
		return t;
	}
	
	//For queries that return 2 columns
	public static void printResult(ResultSet rs) throws SQLException {
		System.out.println("Query Returned returned: ");
		while (rs.next())
		{
		    System.out.print(rs.getString(1) + " ");
		    System.out.print(rs.getString(2));
		    System.out.println("\n");
		    
		}
		rs.close();
		System.out.println("\n");
	}
	
	//For queries that return 1 columns
	public static void printResult1(ResultSet rs) throws SQLException {
		System.out.println("Query Returned returned: ");
		while (rs.next())
		{
		    System.out.print(rs.getString(1)); 
		}
		rs.close();
		System.out.println("\n");
	}

	public static void main(String[] args) {
		PreparedStatement p = null;
		String sql = null;
		Statement stmt = null;
		Connection myConn;
		ResultSet rs = null;
		try {
			//Get connection with DB
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/lab5";
			
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "admin"); 
			 
			myConn = DriverManager.getConnection(url, props);
			stmt = myConn.createStatement();
			
			/*
			sql = "INSERT INTO director " +
	                   "VALUES (11, 'Arshan', 'Alam', 1995, 'Pakistan')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO \"director\" VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 14);
			p.setString(2, "Habibi");
			p.setString(3, "Dal");
			p.setInt(4, 1980);
			p.setString(5, "Suadi Arabia");
			p.executeUpdate();
			
			
			sql = "INSERT INTO actor " +
	                   "VALUES (11, 'Ars', 'Kalam', 'India', 'brown')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO actor VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setString(2, "Horan");
			p.setString(3, "Abdul");
			p.setString(4, "Saudi Arabia");
			p.setString(5, "green");
			p.executeUpdate();
			
			
			
			sql = "INSERT INTO movie " +
	                   "VALUES (11, 2, 3, 'The Horror of Stoville', 2017, '01:54:23')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie VALUES "
					+ "(?, ?, ?, ?, ?,?)");
			p.setInt(1, 12);
			p.setInt(2, 4);
			p.setInt(3, 6);
			p.setString(4, "Chucky 6");
			p.setInt(5, 2017);
			p.setTime(6, getTime("15:30:18"));
			p.executeUpdate();
			
			
			sql = "INSERT INTO extra " +
	                   "VALUES (11, 'Ali', 'Abdul')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO extra VALUES "
					+ "(?, ?, ?)");
			p.setInt(1, 12);
			p.setString(2, "Oprah");
			p.setString(3, "Winfrey");
			p.executeUpdate();
			
			
			sql = "INSERT INTO soundtrack " +
	                   "VALUES (11, 11, 'That Mujic', '00:45:22', 'Hans Zimmer')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO soundtrack VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setInt(2, 12);
			p.setString(3, "Beastbrook");
			p.setTime(4, getTime("00:54:37"));
			p.setString(5, "Kobe");
			p.executeUpdate();
			
			
			sql = "INSERT INTO production_company " +
	                   "VALUES (11, '647-989-3332', 'Product Company Inc.', 'Toronto, Canada', '111 Oaks St')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO production_company VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setString(2, "576-454-2221");
			p.setString(3, "Best Movie Company");
			p.setString(4, "Chicago");
			p.setString(5, "45 Addy St.");
			p.executeUpdate();
			
			
			sql = "INSERT INTO theatre " +
	                   "VALUES (11, '16:10:00', 'Company', 'Toronto, Canada', '11.00')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO theatre VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setTime(2, getTime("20:10:00"));
			p.setString(3, "Movie Company Theatre");
			p.setString(4, "Chicago");
			p.setString(5, "14");
			p.executeUpdate();
			
			sql = "INSERT INTO quote " +
	                   "VALUES (11, 'I am shakespeare in the flesh.')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO quote VALUES "
					+ "(?, ?)");
			p.setInt(1, 12);
			p.setString(2, "I want that, Amigo");
			p.executeUpdate();
			
			sql = "INSERT INTO producer " +
	                   "VALUES (11, 'Alex', 'King', 1980, 'Canada')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO producer VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setString(2, "Don");
			p.setString(3, "Cheetoh");
			p.setInt(4, 1862);
			p.setString(5, "Mexico");
			p.executeUpdate();
			
			sql = "INSERT INTO writer " +
	                   "VALUES (11, 'Alexo', 'Kingo', 1980, 'Canada')";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO writer VALUES "
					+ "(?, ?, ?, ?, ?)");
			p.setInt(1, 12);
			p.setString(2, "Dono");
			p.setString(3, "Keithnoloamigo");
			p.setInt(4, 1862);
			p.setString(5, "Peru");
			p.executeUpdate();
			
			sql = "INSERT INTO movie_director " +
	                   "VALUES (11, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie_director VALUES "
					+ "(?, ?)");
			p.setInt(1, 12);
			p.setInt(2, 4);
			p.executeUpdate();
			
			sql = "INSERT INTO movie_actor " +
	                   "VALUES (11, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie_actor VALUES "
					+ "(?, ?)");
			p.setInt(1, 12);
			p.setInt(2, 4);
			p.executeUpdate();
			
			
			sql = "INSERT INTO movie_extra " +
	                   "VALUES (1, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie_extra VALUES "
					+ "(?, ?)");
			p.setInt(1, 2);
			p.setInt(2, 4);
			p.executeUpdate();
			
			sql = "INSERT INTO movie_theatre " +
	                   "VALUES (1, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie_theatre VALUES "
					+ "(?, ?)");
			p.setInt(1, 2);
			p.setInt(2, 4);
			p.executeUpdate();
			
			sql = "INSERT INTO movie_producer " +
	                   "VALUES (1, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO movie_producer VALUES "
					+ "(?, ?)");
			p.setInt(1, 2);
			p.setInt(2, 4);
			p.executeUpdate();
			
			sql = "INSERT INTO \"Movie_Writer\" " +
	                   "VALUES (1, 6)";
			stmt.executeUpdate(sql);
			
			
			p = myConn.prepareStatement("INSERT INTO \"Movie_Writer\" VALUES "
					+ "(?, ?)");
			p.setInt(1, 2);
			p.setInt(2, 4);
			p.executeUpdate();
			*/
			sql = "SELECT first_name, surname FROM director "
					+"WHERE birth_location = 'United States'";
			rs = stmt.executeQuery(sql);
			//printResult(rs);
			
			
			p = myConn.prepareStatement("SELECT first_name, surname FROM director "
					+"WHERE birth_location = ?");
			p.setString(1, "United States");
			rs = p.executeQuery();
			//printResult(rs);
			
			sql = "SELECT first_name, surname FROM director "
					+ "WHERE surname LIKE 'D%' OR surname LIKE 'N%'";

			rs = stmt.executeQuery(sql);
			//printResult(rs);
			
			
			p = myConn.prepareStatement("SELECT first_name, surname FROM director "
					+ "WHERE surname LIKE ? OR surname LIKE ?");
			p.setString(1, "D%");
			p.setString(2, "N%");
			rs = p.executeQuery();
			//printResult(rs);
			
			sql = "SELECT avg(age) FROM actor";

			rs = stmt.executeQuery(sql);
			printResult1(rs);
			
			//How to pass variables for this??????????????????????
			p = myConn.prepareStatement("SELECT avg(age) FROM actor");
			//p.setString(1, "actor");
			rs = p.executeQuery();
			printResult1(rs);
			
			sql = "SELECT COUNT(eye_colour) FROM actor WHERE eye_colour = 'green'";

			rs = stmt.executeQuery(sql);
			printResult1(rs);
			
			
			p = myConn.prepareStatement("SELECT COUNT(eye_colour) FROM actor WHERE eye_colour = ?");
			p.setString(1, "green");
			rs = p.executeQuery();
			printResult1(rs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
