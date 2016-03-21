DELETE FROM `position`;
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('277cc5ae-ef2f-11e5-9ce9-5e5517507c66','System Engineer','-');
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('318e99aa-ef2f-11e5-9ce9-5e5517507c66','System Analyst','-');
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('35910510-ef2f-11e5-9ce9-5e5517507c66','Programmer','-');
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('3a5624b8-ef2f-11e5-9ce9-5e5517507c66','Business Intelligence','-');
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('40f23faa-ef2f-11e5-9ce9-5e5517507c66','Project Mnager','-');
INSERT INTO `position` (`id`,`position_name`,`description`) VALUES ('40f55faa-ef2f-11e5-9ce9-5e5517507c66','demo','-');

DELETE FROM `jobseeker`;
INSERT INTO `jobseeker` (`id`,`first_name`,`last_name`,`gender`, `pob`, `dob`, `position_id`) VALUES('a20f5e38-ef22-11e5-9ce9-5e5517507c66', 'John', 'Doe', 'M', 'Michigan', '1987-06-20', '277cc5ae-ef2f-11e5-9ce9-5e5517507c66');
INSERT INTO `jobseeker` (`id`,`first_name`,`last_name`,`gender`, `pob`, `dob`, `position_id`) VALUES('ae5d48a8-ef22-11e5-9ce9-5e5517507c66', 'Michael', 'Jordan', 'M', 'Los Angeles', '1989-10-11', '40f23faa-ef2f-11e5-9ce9-5e5517507c66');
INSERT INTO `jobseeker` (`id`,`first_name`,`last_name`,`gender`, `pob`, `dob`, `position_id`) VALUES('b4f59076-ef22-11e5-9ce9-5e5517507c66', 'Erika', 'Bella', 'F', 'New York', '1990-02-15', '277cc5ae-ef2f-11e5-9ce9-5e5517507c66');
INSERT INTO `jobseeker` (`id`,`first_name`,`last_name`,`gender`, `pob`, `dob`, `position_id`) VALUES('b7664184-ef22-11e5-9ce9-5e5517507c66', 'Anthony', 'K.', 'M', 'London', '1992-12-25', '3a5624b8-ef2f-11e5-9ce9-5e5517507c66');
INSERT INTO `jobseeker` (`id`,`first_name`,`last_name`,`gender`, `pob`, `dob`, `position_id`) VALUES('ba09ebca-ef22-11e5-9ce9-5e5517507c66', 'William', 'Bucket', 'M', 'Las Vegas', '1985-11-30', '35910510-ef2f-11e5-9ce9-5e5517507c66');