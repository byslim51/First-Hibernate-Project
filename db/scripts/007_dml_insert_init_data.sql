INSERT INTO car_body_type(id, type) values(1, 'Hatchback');

INSERT INTO car_color(id, name) values(1, 'Purple');

INSERT INTO car_brand(id, name) values(1, 'Ford');

INSERT INTO car_engine(id, model) values(1, 'engine_v15');

INSERT INTO car_model(id, name, brand_id, car_body_type_id, car_engine_id) values(1, 'Focus', 1, 1, 1);

INSERT INTO car(id, car_model_id, color_id) values(1, 1, 1);

