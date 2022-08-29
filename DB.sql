use mydb;

create table Ticket(id int AUTO_INCREMENT PRIMARY KEY, ticket_count int, total_cost int);

create table Price(id int AUTO_INCREMENT PRIMARY KEY, ticket_type varchar(10), price int)