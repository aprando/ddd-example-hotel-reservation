package br.com.thoughtworks.hotelreservation.infrastructure.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class AbstractDAO {

	//TODO: Could use annotation here!
	//@Resource(mappedName = "jdbc/HotelReservationDS")
	private DataSource ds;

	private Connection connection;

	public AbstractDAO() {
	}

	public void setDataSource(final DataSource ds) {
		this.ds = ds;
	}

	protected final void connect() throws SQLException {
		try {
			if (this.ds != null) {
				this.connection = this.ds.getConnection();
			} else {
				throw new SQLException("DataSource null");
			}
		} catch (final SQLException sqle) {
			throw sqle;
		}
	}

	protected final Connection getConnection() {
		return this.connection;
	}

	protected final void releaseConnection() {
		try {
			if (this.connection != null) {
				try {
					this.connection.commit();
				} catch (final Exception e) {
				}
				this.connection.close();
			}
		} catch (final SQLException e) {
		}

	}

	protected final void close(final PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (final SQLException e) {
		}
		this.releaseConnection();
	}
	
	protected final void close(final ResultSet rs, final PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (final SQLException e) {
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (final SQLException e) {
		}

		this.releaseConnection();
	}
}
