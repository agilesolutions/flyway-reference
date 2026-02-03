CREATE TABLE if not exists customer (
    id          serial primary key,
    name        varchar                             not null,
    system_time timestamp                           default current_timestamp
);