create table if not exists car_model
(
id serial primary key,
name varchar not null,
car_body_type_id integer not null,
brand_id integer not null,
car_engine_id integer not null
);