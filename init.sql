--CREATE USER postgres;

--CREATE SCHEMA IF NOT EXISTS polyclinic AUTHORIZATION postgres;
--SET SCHEMA polyclinic;
--CREATE DATABASE polyclinic;
--GRANT ALL PRIVILEGES ON DATABASE polyclinic TO postgres;

CREATE DATABASE polyclinic;
\connect polyclinic;
CREATE SCHEMA polyclinic;
