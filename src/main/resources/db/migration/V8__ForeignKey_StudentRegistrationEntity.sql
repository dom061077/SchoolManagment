DELETE FROM inscripcion_alumno 
WHERE alumno_id IS NULL 
   OR periodo_lectivo_id IS NULL 
   OR nivel_grado_id IS NULL 
   OR turno_id IS NULL 
   OR division_id IS NULL;

ALTER TABLE if exists inscripcion_alumno ALTER COLUMN alumno_id SET NOT NULL;
ALTER TABLE if exists inscripcion_alumno ALTER COLUMN periodo_lectivo_id SET NOT NULL;
ALTER TABLE if exists inscripcion_alumno ALTER COLUMN nivel_grado_id SET NOT NULL;
ALTER TABLE if exists inscripcion_alumno ALTER COLUMN turno_id SET NOT NULL;
ALTER TABLE if exists inscripcion_alumno ALTER COLUMN division_id SET NOT NULL;
