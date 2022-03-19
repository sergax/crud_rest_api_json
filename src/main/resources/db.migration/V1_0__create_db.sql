CREATE TABLE IF NOT EXISTS user (
id INT NOT NULL AUTO_INCREMENT UNIQUE,
user_name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS event (
id INT NOT NULL AUTO_INCREMENT UNIQUE,
event_name VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
file_id INT NOT NULL,
PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS file (
id INT NOT NULL AUTO_INCREMENT UNIQUE,
file_name VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);