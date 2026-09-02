-- Ensure sequence for turno exists
CREATE SEQUENCE IF NOT EXISTS turno_seq START WITH 1 INCREMENT BY 50;

-- Ensure join table curso_division exists
CREATE TABLE IF NOT EXISTS curso_division (
    curso_id BIGINT NOT NULL,
    division_id BIGINT NOT NULL,
    PRIMARY KEY (curso_id, division_id),
    CONSTRAINT fk_curso_division_curso FOREIGN KEY (curso_id) REFERENCES nivel_grado(id),
    CONSTRAINT fk_curso_division_division FOREIGN KEY (division_id) REFERENCES division(id)
);

-- 1. Insert Escuelas (SchoolEntity)
INSERT INTO escuela (id, name, cue, deleted, created_date, last_modified_date, created_by, last_modified_by)
VALUES
    (nextval('escuela_seq'), 'Escuela Primaria N° 8 Bartolomé Mitre', '900063200', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela de Educación Secundaria N° 19 Dr. Javier F. Frías', '900014500', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela Primaria N° 25 Domingo Faustino Sarmiento', '900096900', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela N° 28 Tafí del Valle', '900094300', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela de Educación Secundaria Técnica N° 1 El Mollar', '900172900', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela N° 1 Bernardino Rivadavia', '900037900', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela N° 41 Roque Raúl Aragón', '900097200', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Colegio Nacional de Buenos Aires', '020000100', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela Superior de Comercio Carlos Pellegrini', '020000200', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela Normal Superior N° 1 Presidente Roque Sáenz Peña', '020000300', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Instituto San Martín', '060154200', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('escuela_seq'), 'Escuela de Educación Secundaria Técnica N° 2 Paula Albarracín', '060281400', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM');

-- 2. Insert Turnos (ShiftEntity)
INSERT INTO turno (id, name)
VALUES
    (nextval('turno_seq'), 'Mañana'),
    (nextval('turno_seq'), 'Tarde'),
    (nextval('turno_seq'), 'Noche'),
    (nextval('turno_seq'), 'Vespertino'),
    (nextval('turno_seq'), 'Jornada Completa'),
    (nextval('turno_seq'), 'Jornada Extendida');

-- 3. Insert Divisiones (SectionEntity)
INSERT INTO division (id, division, deleted, created_date, last_modified_date, created_by, last_modified_by)
VALUES
    (nextval('division_seq'), '1ra', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), '2da', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), '3ra', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), '4ta', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), '5ta', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), '6ta', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'A', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'B', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'C', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'D', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'E', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'F', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
    (nextval('division_seq'), 'Única', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM');

-- 4. Insert Grados/Cursos (GradeLevelEntity)
INSERT INTO nivel_grado (id, grade_number)
VALUES
    (nextval('nivel_grado_seq'), 1),
    (nextval('nivel_grado_seq'), 2),
    (nextval('nivel_grado_seq'), 3),
    (nextval('nivel_grado_seq'), 4),
    (nextval('nivel_grado_seq'), 5),
    (nextval('nivel_grado_seq'), 6),
    (nextval('nivel_grado_seq'), 7);

-- 5. Associate GradeLevels with Sections (curso_division)
INSERT INTO curso_division (curso_id, division_id)
SELECT ng.id, d.id
FROM nivel_grado ng
CROSS JOIN division d
WHERE d.division IN ('1ra', '2da', '3ra', 'A', 'B', 'C', 'Única')
ON CONFLICT (curso_id, division_id) DO NOTHING;

-- 6. Associate GradeLevels with Shifts (curso_turno)
INSERT INTO curso_turno (curso_id, turno_id)
SELECT ng.id, t.id
FROM nivel_grado ng
CROSS JOIN turno t
WHERE t.name IN ('Mañana', 'Tarde', 'Jornada Completa')
ON CONFLICT (curso_id, turno_id) DO NOTHING;
