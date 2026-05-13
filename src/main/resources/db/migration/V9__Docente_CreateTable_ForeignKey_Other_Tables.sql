alter table examenes_escolares drop constraint FKrnvpo3d7klaxbst8du1m7vaey;
alter table materia drop constraint FKpr0074uj62ehkdpawx6ox551i;

CREATE TABLE docente (
    id BIGINT NOT NULL,
    deleted BIT NOT NULL DEFAULT 0,
    created_date DATETIME,
    last_modified_date DATETIME,
    created_by VARCHAR(255),
    last_modified_by VARCHAR(255),
    
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    dni INT NOT NULL,
    birth_date DATE,
    address VARCHAR(255),
    
    user_name VARCHAR(255),
    
    PRIMARY KEY (id)
);

alter table examenes_escolares add constraint fk_docente_id foreign key (id_docente) references docente(id);
alter table materia add constraint fk_docente_id foreign key (id_docente) references docente(id);
