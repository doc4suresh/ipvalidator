CREATE TABLE firewall_request(
	request_id serial PRIMARY KEY,
	request_by VARCHAR(255),
	approved_by VARCHAR(255)
);

CREATE TABLE firewall_rule(
	serial_no serial PRIMARY KEY,
	request_id INT,
	action VARCHAR(255),
	source_hostname VARCHAR(255),
	source_ip VARCHAR(255),
	source_nat_ip VARCHAR(255),
	des_hostname VARCHAR(255),
	des_ip VARCHAR(255),
	des_port VARCHAR(255),
	des_protocol VARCHAR ( 100 ),
	rule_action VARCHAR ( 100 ),
	description VARCHAR ( 1000 ),
	validity VARCHAR ( 100 ),
	till_date Date( 100 ),
	created_date TIMESTAMP,
	CONSTRAINT fk_request
      FOREIGN KEY(request_id) 
	  REFERENCES firewall_request(request_id)
);