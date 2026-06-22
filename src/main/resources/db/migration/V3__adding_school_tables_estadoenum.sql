alter table if exists alumno alter column created_date set data type timestamp(6);
alter table if exists alumno alter column last_modified_date set data type timestamp(6);

ALTER TABLE alumno 
    DROP CONSTRAINT alumno_estudio_primario_tutor_check;
ALTER TABLE alumno 
ALTER COLUMN estudio_primario_tutor 
SET DATA TYPE VARCHAR(255) 
USING 
    CASE estudio_primario_tutor
        WHEN 0 THEN 'ESTUDIO_COMPLETO' -- 0 is the ordinal for ESTUDIO_COMPLETO
        WHEN 1 THEN 'ESTUDIO_INCOMPLETO' -- 1 is the ordinal for ESTUDIO_INCOMPLETO
        ELSE NULL -- Handle any unexpected values
    END;
ALTER TABLE alumno 
    ADD CONSTRAINT alumno_estudio_primario_tutor_check 
    CHECK (estudio_primario_tutor IN ('ESTUDIO_COMPLETO', 'ESTUDIO_INCOMPLETO'));    


ALTER TABLE alumno 
    DROP CONSTRAINT alumno_estudio_secundario_tutor_check;
ALTER TABLE alumno 
ALTER COLUMN estudio_secundario_tutor 
SET DATA TYPE VARCHAR(255) 
USING 
    CASE estudio_secundario_tutor
        WHEN 0 THEN 'ESTUDIO_COMPLETO' -- 0 is the ordinal for ESTUDIO_COMPLETO
        WHEN 1 THEN 'ESTUDIO_INCOMPLETO' -- 1 is the ordinal for ESTUDIO_INCOMPLETO
        ELSE NULL -- Handle any unexpected values
    END;
ALTER TABLE alumno 
    ADD CONSTRAINT alumno_estudio_secundario_tutor_check 
    CHECK (estudio_primario_tutor IN ('ESTUDIO_COMPLETO', 'ESTUDIO_INCOMPLETO'));  


ALTER TABLE alumno 
    DROP CONSTRAINT alumno_estudio_ter_univ_tutor_check;
ALTER TABLE alumno 
ALTER COLUMN estudio_ter_univ_tutor 
SET DATA TYPE VARCHAR(255) 
USING 
    CASE estudio_ter_univ_tutor
        WHEN 0 THEN 'ESTUDIO_COMPLETO' -- 0 is the ordinal for ESTUDIO_COMPLETO
        WHEN 1 THEN 'ESTUDIO_INCOMPLETO' -- 1 is the ordinal for ESTUDIO_INCOMPLETO
        ELSE NULL -- Handle any unexpected values
    END;
ALTER TABLE alumno 
    ADD CONSTRAINT alumno_estudio_ter_univ_tutor_check 
    CHECK (estudio_primario_tutor IN ('ESTUDIO_COMPLETO', 'ESTUDIO_INCOMPLETO'));



create table curso (id bigint not null, created_by varchar(255), created_date timestamp(6), deleted boolean not null, last_modified_by varchar(255), last_modified_date timestamp(6), description varchar(255), primary key (id));
alter table if exists departamento alter column created_date set data type timestamp(6);
alter table if exists departamento alter column last_modified_date set data type timestamp(6);
create table division (id bigint not null, created_by varchar(255), created_date timestamp(6), deleted boolean not null, last_modified_by varchar(255), last_modified_date timestamp(6), division varchar(255), primary key (id));
alter table if exists escuela alter column created_date set data type timestamp(6);
alter table if exists escuela alter column last_modified_date set data type timestamp(6);
alter table if exists localidad alter column created_date set data type timestamp(6);
alter table if exists localidad alter column last_modified_date set data type timestamp(6);
alter table if exists menu alter column created_date set data type timestamp(6);
alter table if exists menu alter column last_modified_date set data type timestamp(6);
alter table if exists menu_role alter column created_date set data type timestamp(6);
alter table if exists menu_role alter column last_modified_date set data type timestamp(6);
alter table if exists parentesco_tutor alter column created_date set data type timestamp(6);
alter table if exists parentesco_tutor alter column last_modified_date set data type timestamp(6);
alter table if exists person alter column created_date set data type timestamp(6);
alter table if exists person alter column last_modified_date set data type timestamp(6);
alter table if exists provincia alter column created_date set data type timestamp(6);
alter table if exists provincia alter column last_modified_date set data type timestamp(6);
alter table if exists translation alter column created_date set data type timestamp(6);
alter table if exists translation alter column last_modified_date set data type timestamp(6);
create sequence curso_seq start with 1 increment by 50;
create sequence division_seq start with 1 increment by 50;
