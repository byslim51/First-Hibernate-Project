create table if not exists car
(
id serial primary key,
car_model_id integer not null,
color_id integer not null
);