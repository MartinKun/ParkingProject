package sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.enums.Privileges;

public class CreateData {

	// Declaring spots number
	private final int SPOTS_NUMBER = 16;

	// Declaring usernames:
	private static final String ADMIN = "Admin";
	private static final String USER = "user";

	// Declaring encoded passwords:
	private static final String ADMIN_PASS = "firns";
	private static final String USER_PASS = "678";

	// Declaring privileges:
	private static final String ADMIN_PRIVILEGE = Privileges.ADMINISTRATOR.toString().toLowerCase();
	private static final String USER_PRIVILEGE = Privileges.USER.toString().toLowerCase();

	// Declaring connection and statement variables:
	private Connection conn = null;
	private Statement st = null;

	// Declaring querys:
	private final String SQL_CREATE_TABLE_USER = "CREATE TABLE user (ID INTEGER PRIMARY KEY, username TEXT NOT NULL, password TEXT NOT NULL, "
			+ "privilege TEXT NOT NULL)";

	private final String SQL_CREATE_TABLE_PRICE = "CREATE TABLE price (ID INTEGER PRIMARY KEY, by_hour REAL NOT NULL)";

	private final String SQL_CREATE_TABLE_PARKING_LOT = "CREATE TABLE parking_lot (ID INTEGER PRIMARY KEY, spot INTEGER NOT NULL, id_vehicle INTEGER, FOREIGN KEY(id_vehicle) REFERENCES vehicle(ID))";

	private final String SQL_CREATE_TABLE_VEHICLE = "CREATE TABLE vehicle (ID INTEGER PRIMARY KEY, "
			+ "type TEXT, plate TEXT, id_detail INTEGER, FOREIGN KEY(id_detail) REFERENCES detail(ID))";

	private final String SQL_CREATE_TABLE_DETAIL = "CREATE TABLE detail (ID INTEGER PRIMARY KEY, entry_date DATE NOT NULL, departure_date DATE)";

	private final String SQL_CREATE_TABLE_CASH_REGISTER = "CREATE TABLE cash_register (ID INTEGER PRIMARY KEY, create_date DATE, id_vehicle INTEGER, id_payment_information INTEGER, "
			+ "FOREIGN KEY(id_vehicle) REFERENCES vehicle(ID), FOREIGN KEY(id_payment_information) REFERENCES payment_information(ID))";

	private final String SQL_CREATE_TABLE_PAYMENT_INFORMATION = "CREATE TABLE payment_information (ID INTEGER PRIMARY KEY, partial REAL, discount REAL, total REAL)";

	// Constructor
	public CreateData() {
		conn = Connect.getConnection();
	}

	public void createTables() throws SQLException {

		st = conn.createStatement();

		st.execute(SQL_CREATE_TABLE_USER);
		st.execute(SQL_CREATE_TABLE_PRICE);
		st.execute(SQL_CREATE_TABLE_PARKING_LOT);
		st.execute(SQL_CREATE_TABLE_VEHICLE);
		st.execute(SQL_CREATE_TABLE_DETAIL);
		st.execute(SQL_CREATE_TABLE_PAYMENT_INFORMATION);
		st.execute(SQL_CREATE_TABLE_CASH_REGISTER);

		st.close();
	}

	public void insertData() {

		double priceByHour = 100.00;
		try {

			st = conn.createStatement();

			// insert user data.
			st.execute("INSERT INTO user (username, password, privilege) VALUES('" + ADMIN + "','" + ADMIN_PASS + "','"
					+ ADMIN_PRIVILEGE + "');");
			st.execute("INSERT INTO user (username, password, privilege) VALUES('" + USER + "', '" + USER_PASS + "', '"
					+ USER_PRIVILEGE + "');");

			// insert spot data.
			for (int spot = 1; spot <= SPOTS_NUMBER; spot++) {
				st.execute("INSERT INTO parking_lot (spot) VALUES(" + spot + ");");
			}

			// insert price data.
			st.execute("INSERT INTO price (by_hour) VALUES(" + priceByHour + ");");

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
	}

}