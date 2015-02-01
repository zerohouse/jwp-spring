package next.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import next.model.user.User;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import core.jdbc.AbstractJdbcDaoSupport;

@Repository("userDao")
public class UserDao extends AbstractJdbcDaoSupport {
	public void insert(User user) {
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		getJdbcTemplate().update(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
	}

	public void update(User user) {
		String sql = "UPDATE USERS SET name=?, email=? WHERE userId=?";
		getJdbcTemplate().update(sql, user.getName(), user.getEmail(), user.getUserId());
	}

	public User findByUserId(String userId) {
		String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
		RowMapper<User> rowMapper = new RowMapper<User> () {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(
						rs.getString("userId"), 
						rs.getString("password"), 
						rs.getString("name"),
						rs.getString("email"));
			}
			
		};
		return DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper, userId));
	}
}
