package com.adith.CrudApplication.repositories;

import java.util.List;

import com.adith.CrudApplication.entities.Stream;

public interface StreamRepository {
	
	List<Stream> getAllStreams();

	String getStreamById(Integer streamId);

}
