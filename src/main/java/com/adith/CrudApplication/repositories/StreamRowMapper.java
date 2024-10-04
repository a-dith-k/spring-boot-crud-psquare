package com.adith.CrudApplication.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.adith.CrudApplication.entities.Stream;

public class StreamRowMapper implements RowMapper<Stream> {

	@Override
	public Stream mapRow(ResultSet rs, int rowNum) throws SQLException {
		Stream s=new Stream(rs.getInt("id"),rs.getString("name"));
		
		return s;
	}

}
