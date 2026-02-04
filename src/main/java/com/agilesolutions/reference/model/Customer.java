package com.agilesolutions.reference.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
public record Customer(int id, String name, Timestamp system_time) {
}
