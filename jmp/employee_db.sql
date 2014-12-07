SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- DB: employee_db
--
CREATE DATABASE employee_db DEFAULT CHARSET=utf8;
USE employee_db;
-- -------------------------------------------------------

--
-- employee table
--

DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(25) NOT NULL,
  last_name varchar(25) NOT NULL,
  country varchar(25) NOT NULL,
  city varchar(25) NOT NULL,
  street varchar(25) NOT NULL,
  status int(4),
  unit_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Filling employee table
--

INSERT INTO employee (id, first_name, last_name, country, city, street, status, unit_id)
    VALUES(1, 'Ivan', 'Ivanov', 'Belarus', 'Minsk', 'K1', 0, 1);
INSERT INTO employee (id, first_name, last_name, country, city, street, status, unit_id)
    VALUES(2, 'Petr', 'Petrov', 'Belarus', 'Minsk', 'N58', 1, 1);
INSERT INTO employee (id, first_name, last_name, country, city, street, status, unit_id)
    VALUES(3, 'Sergey', 'Sergeev', 'Belarus', 'Minsk', 'K10', 2, 2);

-- --------------------------------------------------------

--
-- employee_personal_info table
--

DROP TABLE IF EXISTS employee_personal_info;
CREATE TABLE IF NOT EXISTS employee_personal_info (
  employee_id bigint(20) NOT NULL,
  phone_number varchar(25) NOT NULL,
  driver_license varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Filling employee_personal_info table
--

INSERT INTO employee_personal_info (employee_id, phone_number, driver_license) VALUES(1, 'PN346436', 'DLg345ggv534');
INSERT INTO employee_personal_info (employee_id, phone_number, driver_license) VALUES(2, 'PN765536', 'DLtytryur674');
INSERT INTO employee_personal_info (employee_id, phone_number, driver_license) VALUES(3, 'PN999436', 'DLnmmdg22534');

-- --------------------------------------------------------

--
-- project table
--

DROP TABLE IF EXISTS project;
CREATE TABLE IF NOT EXISTS project (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Filling project table
--

INSERT INTO project (id, name) VALUES(1, 'DKGJ');
INSERT INTO project (id, name) VALUES(2, 'JLHJ');
INSERT INTO project (id, name) VALUES(3, 'RAAA');

-- --------------------------------------------------------

--
-- unit table
--

DROP TABLE IF EXISTS unit;
CREATE TABLE IF NOT EXISTS unit (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Filling unit table
--

INSERT INTO unit (id, name) VALUES(1, 'U111111');
INSERT INTO unit (id, name) VALUES(2, 'U222222');
INSERT INTO unit (id, name) VALUES(3, 'U333333');

-- --------------------------------------------------------

--
-- employee_project table
--

DROP TABLE IF EXISTS employee_project;
CREATE TABLE IF NOT EXISTS employee_project (
  employee_id bigint(20) NOT NULL,
  project_id bigint(20) NOT NULL,
  PRIMARY KEY (employee_id, project_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Filling employee_project table
--

INSERT INTO employee_project (employee_id, project_id) VALUES(1, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES(1, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES(1, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES(2, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES(3, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES(3, 3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;