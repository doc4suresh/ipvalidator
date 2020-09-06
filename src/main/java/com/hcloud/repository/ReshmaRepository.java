package com.hcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hcloud.model.Reshma;

public interface ReshmaRepository extends JpaRepository<Reshma, Long>{

	
	
	
	/*
	--both ranges
	select * from reshma f 
where 1=1
and (
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)
OR
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)
)
AND
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)
OR
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)
)
)
and ip_range like '%[%-%]%'
and :ipAddress like '%[%-%]%'
	union
	-- db range passing single
	select * from reshma f 
where 1=1
and (
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)
AND
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)
)
)
and ip_range like '%[%-%]%'
and :ipAddress  not like '%[%-%]%'
	union
	--passing single db range
	select * from reshma f 
where 1=1
and (
(
CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)
AND
CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)
)
)
and :ipAddress like '%[%-%]%'
and ip_range  not like '%[%-%]%'
	union
	--both single
	select * from reshma f 
where 1=1
and CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER) = CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)
and :ipAddress not like '%[%-%]%'
and ip_range  not like '%[%-%]%';
	
	
	**/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Query(value = "select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and ip_range like '%[%-%]%'\r\n" + 
			"and :ipAddress like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)\r\n" + 
			"OR\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)\r\n" + 
			")\r\n" + 
			"AND\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)\r\n" + 
			"OR\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"\r\n" + 
			"union\r\n" + 
			"select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and ip_range like '%[%-%]%'\r\n" + 
			"and :ipAddress  not like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			"AND\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"union\r\n" + 
			"\r\n" + 
			"select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and :ipAddress like '%[%-%]%'\r\n" + 
			"and ip_range  not like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			"AND\r\n" + 
			"CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"union\r\n" + 
			"\r\n" + 
			"select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and :ipAddress not like '%[%-%]%'\r\n" + 
			"and ip_range  not like '%[%-%]%'\r\n" + 
			"and CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER) = CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			";",
            nativeQuery = true)
	List<Reshma> getReshma(@Param("ipAddress") String ipAddress);
	
	
}
