alter table examenes_escolares drop constraint FKrnvpo3d7klaxbst8du1m7vaey;
alter table materia drop constraint FKpr0074uj62ehkdpawx6ox551i;
create table docente (birth_date date, deleted boolean not null, dni integer not null, created_date timestamp(6), id bigint not null, last_modified_date timestamp(6), address varchar(255), created_by varchar(255), first_name varchar(255), last_modified_by varchar(255), last_name varchar(255), user_name varchar(255), primary key (id));
alter table examenes_escolares add constraint fk_docente_id foreign key (id_docente) references docente(id);
alter table materia add constraint fk_docente_id foreign key (docente_id) references docente(id);
