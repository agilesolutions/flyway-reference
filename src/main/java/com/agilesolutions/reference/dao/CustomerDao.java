package com.agilesolutions.reference.dao;

import com.agilesolutions.reference.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@AllArgsConstructor
public class CustomerDao {

    NamedParameterJdbcTemplate template;

    private static final String SELECT_CUSTOMER = "select * from customer where name = :name";

    private static final String SELECT_CUSTOMERS = "select * from customer";


    public RowMapper<Customer> getRowMapper() {
        return (rs, i) -> {

            return Customer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
            .build();

        };
    }

    public List<Customer> getCustomerByName(String name) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return template.queryForList(SELECT_CUSTOMER, params, Customer.class);

    }

    public List<Customer> getCustomers() {

        return template.query(SELECT_CUSTOMERS, Collections.emptyMap(),
                (rs, rowNum) -> Customer.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .system_time(rs.getTimestamp("system_time"))
                            .build());

    }

}
