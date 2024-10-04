package com.adith.CrudApplication.repositories;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adith.CrudApplication.entities.Stream;

@Repository
public class StreamRepositoryImpl implements StreamRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public StreamRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Stream> getAllStreams() {
		return jdbcTemplate.query("select * from stream",BeanPropertyRowMapper.newInstance(Stream.class));
	}

	@Override
	public String getStreamById(Integer streamId) {
		
		Stream s= jdbcTemplate.queryForObject("select * from stream where id = ? ",new StreamRowMapper(), streamId);
	return s.getName();
	}

}
