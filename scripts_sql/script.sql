CREATE TABLE IF NOT EXISTS user_tb (
	email VARCHAR(50) PRIMARY KEY,
	name VARCHAR(200) NOT NULL,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS link_tb (
	short_link VARCHAR(20) PRIMARY KEY,
	full_link VARCHAR(300) NOT NULL,
	user_email VARCHAR(50),
	type ENUM('RANDOM', 'CUSTOM') NOT NULL,
	FOREIGN KEY (user_email) REFERENCES user_tb(email) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS access_tb (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	ip VARCHAR(50) NOT NULL,
	short_link VARCHAR(50) NOT NULL,
	FOREIGN KEY (short_link) REFERENCES link_tb(short_link) ON UPDATE CASCADE ON DELETE CASCADE
);