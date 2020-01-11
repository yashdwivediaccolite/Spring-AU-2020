create database assignment;
use assignment;

create table employee(
	emp_id int primary key,
    emp_name varchar(20),
    job_name varchar(20),
    salary int
);

create table employee_audit(
	employee_id int,
    deleted_date date,
    deleted_by varchar(50)
);

create table update_log(
	employee_id int,
    updated_date date,
    updated_by varchar(50)
);

insert into employee values(1,"Yash","Web Developer",40000);
insert into employee values(2,"Ash","Accountant",30000);
insert into employee values(3,"Rahul","Accountant",30000);
insert into employee values(4,"Pragya","Web Developer",40000);
insert into employee values(5,"Abhigyan","Web Developer",40000);
insert into employee values(6,"Mona","Testor",20000);
insert into employee values(7,"Lola","Web Developer",40000);
insert into employee values(8,"Vivan","Testor",20000);
insert into employee values(9,"Ajay","Web Developer",40000);
insert into employee values(10,"Budo","Testor",20000);
insert into employee values(11,"Sajal","Accountant",20000);
insert into employee values(13,"SOM",NULL,30000);

call paginate(2,4);

DELIMITER $$

select * from employee;

CREATE TRIGGER employeeInsertTrigger BEFORE INSERT ON employee
FOR EACH ROW BEGIN
   IF (NEW.job_name IS NULL) THEN
        SET NEW.job_name="N/A";
   END IF;
END$$

DELIMITER ;

insert into employee values(14,"Pragya",NULL,20000);

DELIMITER $$

CREATE TRIGGER employeeDeleteTrigger BEFORE DELETE ON employee
FOR EACH ROW BEGIN
	DECLARE vUser varchar(50);
    SELECT USER() INTO vUser;
    INSERT INTO employee_audit
   ( employee_id,
     deleted_date,
     deleted_by)
   VALUES
   ( OLD.emp_id,
     SYSDATE(),
     vUser );

END$$

DELIMITER ;

delete from employee where emp_id=2;
select * from employee_audit;

DELIMITER $$

CREATE TRIGGER employeeUpdateTrigger BEFORE UPDATE ON employee
FOR EACH ROW BEGIN
	DECLARE vUser varchar(50);
    SELECT User() INTO vUser;
    INSERT INTO update_log
    (employee_id,
    updated_date,
    updated_by)
    VALUES
    (OLD.emp_id,
    SYSDATE(),
    vUser);

END$$

DELIMITER ;    

update employee set emp_name="Kshitij" where emp_id=11;
select * from update_log;








