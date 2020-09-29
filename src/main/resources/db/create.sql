SET MODE PostgreSQL;

CREATE DATABASE organisational_news_portal;
\c organisational_news_portal;

CREATE TABLE IF NOT EXISTS departments (
  departmentId  SERIAL PRIMARY KEY,
  departmentName VARCHAR,
  departmentDescription VARCHAR
);


CREATE TABLE IF NOT EXISTS users (
  UserId  SERIAL PRIMARY KEY,
  userName VARCHAR,
  userPosition VARCHAR,
  userRole VARCHAR,
  userDepartment VARCHAR
);

CREATE DATABASE organisational_news_portal_test WITH TEMPLATE organisational_news_portal;

