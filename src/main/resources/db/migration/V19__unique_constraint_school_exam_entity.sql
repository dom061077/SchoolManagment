alter table examenes_escolares add constraint unique_materia_periodo_tipo unique (id_materia, id_periodo_lectivo, id_tipo_examen);
alter table examenes_escolares alter column id_materia set not null;
alter table examenes_escolares alter column id_periodo_lectivo set not null;
alter table examenes_escolares alter column id_tipo_examen set not null;
alter table detalle_examenes_escolares drop constraint fkkfke7ux4ci01pqpkp4h3l10vq;
alter table detalle_examenes_escolares drop column id_periodo_lectivo;
