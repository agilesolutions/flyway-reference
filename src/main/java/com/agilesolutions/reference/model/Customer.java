package com.agilesolutions.reference.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Customer {

    private int id;
    private String name;
    Timestamp system_time;


}
