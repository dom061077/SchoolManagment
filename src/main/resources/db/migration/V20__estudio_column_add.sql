alter table alumno
add column estudio varchar(255) check (estudio_primario_tutor in ('ESTUDIO_COMPLETO','ESTUDIO_INCOMPLETO'));