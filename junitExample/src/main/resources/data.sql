DROP TABLE IF EXISTS employee_details;

CREATE TABLE employee_details(
	 emp_id INT AUTO_INCREMENT PRIMARY KEY,
	 first_name varchar(200) not null,
	 last_name varchar(200) not null,
	 date_of_birth DATE NOT NULL,
	 phone_number varchar(10) NOT NULL,
	 salary int
);

insert into employee_details(
	first_name,
	last_name,
	date_of_birth,
	phone_number,
	salary
)
values
('mrinmoy','podder','1988-11-26','9735682970','23000');
insert into employee_details(
	first_name,
	last_name,
	date_of_birth,
	phone_number,
	salary
)
values('tias','basu','1990-11-26','9002583548','24000');
insert into employee_details(
	first_name,
	last_name,
	date_of_birth,
	phone_number,
	salary
)
values('trinisha','podder','2021-10-01','9735682970','25000');

