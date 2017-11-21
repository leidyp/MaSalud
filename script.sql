CREATE TABLE usuario(
 us_id integer primary key,
 us_nombre varchar(50), 
 us_user varchar(50), 
 us_password varchar(50));

CREATE TABLE rol(
rol_id integer primary key,
rol_nombre varchar(50)
);

CREATE TABLE usuario_rol(
ur_id integer primary key,
rol_id integer,
us_id integer
);
 
ALTER TABLE usuario_rol ADD CONSTRAINT fk_usuarior FOREIGN KEY (rol_id) REFERENCES rol(rol_id);
ALTER TABLE usuario_rol ADD CONSTRAINT fk_usuariou FOREIGN KEY (us_id) REFERENCES usuario(us_id);


CREATE TABLE persona(
per_id integer primary key,
us_id integer,
per_cedula varchar(50),
per_nombres varchar(50),
per_apellidos varchar(50),
per_fechan date,
per_direccion varchar(90),
per_telefono varchar(50),
per_correo varchar(50)
);
ALTER TABLE persona ADD CONSTRAINT fk_personap FOREIGN KEY (us_id) REFERENCES usuario(us_id);



CREATE TABLE paciente(
pac_id integer primary key,
per_id integer,
pac_tipo_sangre varchar(50)
);
ALTER TABLE paciente ADD CONSTRAINT fk_pacientep FOREIGN KEY (per_id) REFERENCES persona(per_id);



CREATE TABLE medico(
med_id integer primary key,
per_id integer,
med_especialidad varchar(50)
);
ALTER TABLE medico ADD CONSTRAINT fk_medicom FOREIGN KEY (per_id) REFERENCES persona(per_id);



CREATE TABLE recepcionista(
rec_id integer primary key,
per_id integer
);
ALTER TABLE recepcionista ADD CONSTRAINT fk_recepcionista FOREIGN KEY (per_id) REFERENCES persona(per_id);


CREATE TABLE cita(
cita_id integer primary key,
med_id integer,
pac_id integer,
rec_id integer,
cita_fecha date,
cita_hora time,
cita_estado varchar(30),
cita_descripcion varchar(90)
);
ALTER TABLE cita ADD CONSTRAINT fk_citam FOREIGN KEY (med_id) REFERENCES medico(med_id);
ALTER TABLE cita ADD CONSTRAINT fk_citap FOREIGN KEY (pac_id) REFERENCES paciente(pac_id);
ALTER TABLE cita ADD CONSTRAINT fk_citar FOREIGN KEY (rec_id) REFERENCES recepcionista(rec_id);



CREATE TABLE procedimiento(
proc_id integer primary key,
proc_nombre varchar(50),
proc_descripcion text
);

CREATE TABLE historia_clinica(
hc_id integer primary key,
pac_id integer,
proc_id integer,
hc_serial varchar(50),
hc_fecha date,
hc_descripcion text
);
ALTER TABLE historia_clinica ADD CONSTRAINT fk_historia_clinicap FOREIGN KEY (pac_id) REFERENCES paciente(pac_id);
ALTER TABLE historia_clinica ADD CONSTRAINT fk_historia_clinicapr FOREIGN KEY (proc_id) REFERENCES procedimiento(proc_id);
