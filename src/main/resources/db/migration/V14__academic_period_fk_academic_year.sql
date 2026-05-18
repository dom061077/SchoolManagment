alter table if exists periodo_academico add column periodo_lectivo_id bigint;
alter table if exists periodo_academico add constraint FKgen3h3jft3radq9obrmwurpr6 foreign key (periodo_lectivo_id) references periodo_lectivo;
