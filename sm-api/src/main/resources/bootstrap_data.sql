INSERT INTO public.menu(
	 code, description, path)
	VALUES ('Alumnos', 'Alumnos', 'alumno');
INSERT INTO public.menu(
	 code, description, path)
	VALUES ('Personas', 'Personas', 'persona');
INSERT INTO public.menu(
	 code, description, path)
	VALUES ('Materias', 'Materias', 'materia');

INSERT INTO public.menu_role_entity(
	 menu_id, role)
select id,'ROLE_RESOURCE_bsn_CHURCH' from public.menu where upper(description) like '%PERSONA%'