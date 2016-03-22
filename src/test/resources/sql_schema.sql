use `spring_jobseek`;

drop table IF EXISTS `jobseeker`, `position`;
create table `jobseeker` (
	`id` varchar(150) not null primary key,
	`first_name` varchar(100) not null,
	`last_name` varchar(100),
	`gender` enum('M', 'F') not null default 'M',
	`pob` varchar(100) not null,
	`dob` date not null,
	`position_id` varchar(150) not null,
	`status` enum('pending', 'process', 'finish') not null default 'pending',
	`created_at` timestamp not null,
	`updated_at` timestamp null
);

create table `position` (
	`id` varchar(150) not null primary key,
	`position_name` varchar(150) not null,
	`description` text
);