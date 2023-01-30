--CREATE USER postgres;
--
--CREATE SCHEMA IF NOT EXISTS polyclinic AUTHORIZATION postgres;
--CREATE DATABASE polyclinic;
--SET SCHEMA polyclinic;
--GRANT ALL PRIVILEGES ON DATABASE polyclinic TO postgres;

CREATE SCHEMA polyclinic;
CREATE DATABASE polyclinic;
\connect polyclinic;
SET SCHEMA polyclinic;
