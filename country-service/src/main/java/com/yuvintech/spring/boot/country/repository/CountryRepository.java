package com.yuvintech.spring.boot.country.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuvintech.spring.boot.country.data.City;
import com.yuvintech.spring.boot.country.data.Country;


@Repository
public class CountryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Country> getAllCountries() {
		return jdbcTemplate.query("select code , name, region, population from country", new RowMapperImpl());
	}
	
	public Country getCountryInfoByCode(String countryCode) {
		return jdbcTemplate.queryForObject(
				"select code , name, region, population from country where code = ?",
				new Object[] {countryCode}, 
				new RowMapperImpl()
				);
	}
	
	
	public City getCityByName(String cityName) {
		return jdbcTemplate.queryForObject(
				"select * from city where name = ?",
				new Object[] {cityName},
				new CityRowMapper());
	}
	
	static class RowMapperImpl implements RowMapper<Country>{

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Country
					.builder()
					 .code(rs.getString("code"))
					 .name(rs.getString("name"))
					 .description(rs.getString("name"))
					 .region(rs.getString("region"))
					 .population(rs.getLong("population"))
					 .build();
		}
		
	}

	
	static class CityRowMapper implements RowMapper<City>{

		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return City
					.builder()
					.id(rs.getInt("id"))
					.name(rs.getString("name"))
					.build();
		}
		
	}
	
	

	


	

}
