const fs = require('fs');
const path = require('path');

const firstNamesMale = [
  'Juan', 'Pedro', 'Carlos', 'Miguel', 'Luis', 'Jorge', 'Diego', 'Mateo', 'Santiago', 
  'Lucas', 'Mariano', 'Hernán', 'Gustavo', 'Fernando', 'Alejandro', 'Federico', 'Martín', 
  'Gonzalo', 'Facundo', 'Nicolás', 'Bautista', 'Tomás', 'Joaquín', 'Agustín', 'Ezequiel', 
  'Julián', 'Ramiro', 'Matías', 'Gabriel', 'Ignacio'
];

const firstNamesFemale = [
  'María', 'Ana', 'Laura', 'Sofía', 'Valentina', 'Lucía', 'Camila', 'Martina', 'Isabella', 
  'Clara', 'Florencia', 'Carolina', 'Gabriela', 'Cecilia', 'Mariana', 'Patricia', 'Natalia', 
  'Belén', 'Micaela', 'Sol', 'Delfina', 'Juana', 'Catalina', 'Milagros', 'Victoria', 
  'Abril', 'Rocío', 'Julieta', 'Paula', 'Daniela'
];

const lastNames = [
  'González', 'Rodríguez', 'Gómez', 'Fernández', 'López', 'Díaz', 'Martínez', 'Pérez', 
  'Romero', 'Sánchez', 'Álvarez', 'Torres', 'Ruiz', 'Ramírez', 'Flores', 'Acosta', 
  'Benítez', 'Medina', 'Herrera', 'Silva', 'Castro', 'Rojas', 'Guzmán', 'Molina', 
  'Domínguez', 'Gutiérrez', 'Ortega', 'Vargas', 'Romano', 'Giménez'
];

const streets = [
  'Av. Rivadavia', 'Av. Corrientes', 'San Martín', 'Belgrano', 'Mitre', 'Sarmiento', 
  'Urquiza', 'Av. Santa Fe', 'Pueyrredón', 'Av. de Mayo', 'Colón', 'Pellegrini', 
  '9 de Julio', 'Alberdi', 'Moreno', 'Suipacha', 'Esmeralda', 'Lavalle', 'Tucumán', 
  'Maipú', 'Chacabuco', 'Piedras', 'Salta', 'Santiago del Estero', 'Av. Cabildo'
];

const estudios = ['ESTUDIO_COMPLETO', 'ESTUDIO_INCOMPLETO'];

function getRandomElement(arr) {
  return arr[Math.floor(Math.random() * arr.length)];
}

function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function getCuil(dni, isFemale) {
  const type = isFemale ? '27' : '20';
  const digits = (type + dni).split('').map(Number);
  const weights = [5, 4, 3, 2, 7, 6, 5, 4, 3, 2];
  let sum = 0;
  for (let i = 0; i < 10; i++) {
    sum += digits[i] * weights[i];
  }
  const rem = sum % 11;
  let diff = 11 - rem;
  let finalType = type;
  let checksum = diff;
  if (diff === 11) {
    checksum = 0;
  } else if (diff === 10) {
    finalType = '23';
    const newDigits = (finalType + dni).split('').map(Number);
    let newSum = 0;
    for (let i = 0; i < 10; i++) {
      newSum += newDigits[i] * weights[i];
    }
    const newRem = newSum % 11;
    checksum = 11 - newRem;
    if (checksum === 11) checksum = 0;
    if (checksum === 10) checksum = 9;
  }
  return `${finalType}-${dni}-${checksum}`;
}

function generateRandomDate(startYear, endYear) {
  const year = getRandomInt(startYear, endYear);
  const month = String(getRandomInt(1, 12)).padStart(2, '0');
  const day = String(getRandomInt(1, 28)).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

function escapeCsvValue(val) {
  if (val === null || val === undefined) return '';
  const str = String(val);
  if (str.includes(';') || str.includes('"') || str.includes('\n')) {
    return `"${str.replace(/"/g, '""')}"`;
  }
  return str;
}

const headers = [
  'id',
  'deleted',
  'created_date',
  'last_modified_date',
  'created_by',
  'last_modified_by',
  'last_name',
  'first_name',
  'dni',
  'birth_date',
  'address',
  'cuil',
  'plan_social',
  'trabaja',
  'apellido_tutor',
  'nombre_tutor',
  'estudio_primario_tutor',
  'estudio_secundario_tutor',
  'estudio_ter_univ_tutor',
  'dni_tutor',
  'cuil_tutor',
  'telefono1',
  'telefono2',
  'foto_dni',
  'constancia_cuil',
  'constancia6grado',
  'acta_nacimiento',
  'constancia_regular',
  'foto4x4',
  'foto_carnet_vac',
  'ficha_medica',
  'aptitud_fisica',
  'grupo_sanguineo',
  'ficha_inscripcion',
  'libreta6grado',
  'fotocopia_libro_matriz',
  'fotocopia_dni_tutor',
  'constancia_cuil_tutor',
  'localidad_entity_id',
  'parentesco_tutor_entity_id'
];

const csvFilePath = path.join(__dirname, 'alumnos_sample.csv');
const writeStream = fs.createWriteStream(csvFilePath, { encoding: 'utf8' });

writeStream.write(headers.join(';') + '\n');

console.log('Generating 5000 students...');

for (let i = 1; i <= 5000; i++) {
  const isFemale = Math.random() < 0.5;
  const firstName = isFemale ? getRandomElement(firstNamesFemale) : getRandomElement(firstNamesMale);
  const lastName = getRandomElement(lastNames);
  const dni = getRandomInt(45000000, 52000000);
  const cuil = getCuil(dni, isFemale);
  
  const birthDate = generateRandomDate(2008, 2018);
  const address = `${getRandomElement(streets)} ${getRandomInt(10, 4500)}`;
  
  const tutorIsFemale = Math.random() < 0.5;
  const nombreTutor = tutorIsFemale ? getRandomElement(firstNamesFemale) : getRandomElement(firstNamesMale);
  const apellidoTutor = getRandomElement(lastNames);
  const dniTutor = getRandomInt(20000000, 35000000);
  const cuilTutor = getCuil(dniTutor, tutorIsFemale);
  
  const tel1 = `11-${getRandomInt(4000, 5999)}-${getRandomInt(1000, 9999)}`;
  const tel2 = Math.random() < 0.3 ? `11-${getRandomInt(4000, 5999)}-${getRandomInt(1000, 9999)}` : '';
  
  const row = {
    id: i,
    deleted: false,
    created_date: '2026-05-22 10:00:00',
    last_modified_date: '2026-05-22 10:00:00',
    created_by: 'admin',
    last_modified_by: 'admin',
    last_name: lastName,
    first_name: firstName,
    dni: dni,
    birth_date: birthDate,
    address: address,
    cuil: cuil,
    plan_social: Math.random() < 0.15,
    trabaja: Math.random() < 0.05,
    apellido_tutor: apellidoTutor,
    nombre_tutor: nombreTutor,
    estudio_primario_tutor: getRandomElement(estudios),
    estudio_secundario_tutor: getRandomElement(estudios),
    estudio_ter_univ_tutor: getRandomElement(estudios),
    dni_tutor: dniTutor,
    cuil_tutor: cuilTutor,
    telefono1: tel1,
    telefono2: tel2,
    foto_dni: Math.random() < 0.9,
    constancia_cuil: Math.random() < 0.85,
    constancia6grado: Math.random() < 0.8,
    acta_nacimiento: Math.random() < 0.95,
    constancia_regular: Math.random() < 0.9,
    foto4x4: Math.random() < 0.7,
    foto_carnet_vac: Math.random() < 0.8,
    ficha_medica: Math.random() < 0.75,
    aptitud_fisica: Math.random() < 0.75,
    grupo_sanguineo: Math.random() < 0.8,
    ficha_inscripcion: Math.random() < 0.9,
    libreta6grado: Math.random() < 0.85,
    fotocopia_libro_matriz: Math.random() < 0.6,
    fotocopia_dni_tutor: Math.random() < 0.8,
    constancia_cuil_tutor: Math.random() < 0.8,
    localidad_entity_id: '', // Null/empty
    parentesco_tutor_entity_id: '' // Null/empty
  };

  const line = headers.map(h => escapeCsvValue(row[h])).join(';');
  writeStream.write(line + '\n');
}

writeStream.end();
console.log('Successfully generated alumnos_sample.csv!');
