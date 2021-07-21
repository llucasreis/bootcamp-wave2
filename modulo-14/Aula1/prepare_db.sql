create database ml_app_consultorio;

create user ml_app_user1 with encrypted password 'ml_app_user1';
grant connect on database ml_app_consultorio to ml_app_user1;
-- psql -U ml_app_user1 -d ml_app_consultorio

create user ml_app_user2 with encrypted password 'ml_app_user2';
grant all privileges on database ml_app_consultorio to ml_app_user2;
-- psql -U ml_app_user2 -d ml_app_consultorio

create user ml_app_user3 with encrypted password 'ml_app_user3';
grant connect on database ml_app_consultorio to ml_app_user3;
grant select on all tables in schema public to ml_app_user3;
-- psql -U ml_app_user3 -d ml_app_consultorio