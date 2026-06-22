alter table alumno
drop constraint alumno_estudio_primario_tutor_check1;
alter table alumno
add constraint estudio_check check (estudio in ('ESTUDIO_COMPLETO','ESTUDIO_INCOMPLETO'));