--Añadir PRAGMA foreig_key on V
PRAGMA foreig_key = on;
--Telefono PRIMARY KEY V
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE USUARIO (
    Telefono NUMBER NOT NULL PRIMARY KEY,
    Email VARCHAR2(50) NOT NULL,
    Contrasenna VARCHAR2(50) NOT NULL,
    NOMBRE_COMPLETO VARCHAR2(50) NOT NULL,
    Direccion VARCHAR2(60)
);
--falta not null V
--id alojamiento autoincrementable V
--dejar el enum en minuscula V
--id alojamiento autoincremetable V
DROP TABLE IF EXISTS ALOJAMIENTOS;
CREATE TABLE ALOJAMIENTOS (
   Id_Alojamiento NUMBER NOT NULL PRIMARY KEY,
   Nombre VARCHAR2(30) NOT NULL,
   Direccion VARCHAR2(60),
   Numero_Huespedes NUMBER,
   Tipo_Alojamiento VARCHAR2(20) NOT NULL,
   CONSTRAINT CK_1 CHECK (Tipo_Alojamiento IN ('hotel', 'apartamento turistico'))
);
--crear indice
--Nombre de alojamiento
DROP INDEX IF EXISTS nombaloj;
CREATE INDEX nombaloj ON ALOJAMIENTOS(Nombre);
--clave primaria sobra telefono y fechasalida V
--falta not null V
-- cambiar date a datetime V
--id alojamiento autoincremetable V
DROP TABLE IF EXISTS RESERVA;
CREATE TABLE RESERVA (
    Id_Alojamiento NUMBER,
    Email VARCHAR2(50),
    Telefono NUMBER,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME NOT NULL,
    CONSTRAINT PK_2 PRIMARY KEY (Telefono, Id_Alojamiento, Fecha_Entrada),
    CONSTRAINT FK_1 FOREIGN KEY (Email, Telefono) REFERENCES USUARIO(Email, Telefono)ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_2 FOREIGN KEY (Id_Alojamiento) REFERENCES ALOJAMIENTOS(Id_Alojamiento)ON DELETE CASCADE ON UPDATE CASCADE
);
--falta not null V
--añade nombre hotel V
--añade check para que el nuimero de estrella sea maximo 5 minimo 1 V
--id alojamiento autoincremetable V
DROP TABLE IF EXISTS HOTELES;
CREATE TABLE HOTELES (
    Id_Alojamiento NUMBER NOT NULL PRIMARY KEY,
    Tipo_habitacion VARCHAR2(20) NOT NULL,
    Nombre VARCHAR2(30) NOT NULL,
    Numero_Estrellas NUMBER(1),
    CONSTRAINT CK_2 CHECK (Numero_Estrellas IN (1, 2, 3, 4, 5)),
    CONSTRAINT CK_3 CHECK (Tipo_habitacion IN ('Unica', 'Doble', 'Triple', 'Cuadruple')),
    CONSTRAINT FK_3 FOREIGN KEY (Id_Alojamiento) REFERENCES ALOJAMIENTOS(Id_Alojamiento) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_4 FOREIGN KEY (Nombre) REFERENCES ALOJAMIENTOS(Nombre) ON DELETE CASCADE ON UPDATE CASCADE

);
--falta not null V
--nombre de apartamento turistico V
DROP TABLE IF EXISTS AP_TURISTICOS;
CREATE TABLE AP_TURISTICOS (
    Id_Alojamiento NUMBER NOT NULL PRIMARY KEY,
    Nombre VARCHAR2(30) NOT NULL,
    Distancia_Centro_Km NUMBER,
    CONSTRAINT FK_5 FOREIGN KEY (Id_Alojamiento) REFERENCES ALOJAMIENTOS(Id_Alojamiento) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_6 FOREIGN KEY (Nombre) REFERENCES ALOJAMIENTOS(Nombre) ON DELETE CASCADE ON UPDATE CASCADE
);
--crear vista con
-- -nombre.usuario
-- -telefono
-- -id_alojamiento
-- -nombre
-- -fecha.entrada
-- -fecha.salida

CREATE VIEW vista (NOMBRE_USUARIO, TELEFONO, ID_ALOJAMIENTO, NOMBRE, FECHA_ENTRADA, FECHA_SALIDA) AS SELECT NOMBRE_COMPLETO, Telefono, Id_Alojamiento, Nombre, Fecha_Entrada, Fecha_Salida
FROM USUARIO U, ALOJAMIENTOS A, RESERVA R
WHERE U.Telefono = R.Telefono AND A.Id_Alojamiento = R.Id_Alojamiento;

DROP TABLE IF EXISTS HISTORIAL;
CREATE TABLE HISTORIAL(
    Id_Alojamiento NUMBER NOT NULL PRIMARY KEY,
    Email VARCHAR2(50) NOT NULL,
    Telefono NUMBER,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME NOT NULL
);
--crear triggers de anulaciónV
-- -anulacion reservaV
-- -id.alojamientoV
-- -fecha.entradaV
-- -fecha.anulacionV
DROP TRIGGER IF EXISTS anulacion;
CREATE TRIGGER anulacion BEFORE DELETE
ON RESERVA
BEGIN
    INSERT INTO historial (Id_alojamiento, Email) VALUES (old.Id_Alojamiento, old.Email);
END;

DROP TABLE IF EXISTS updateEmail;
CREATE TABLE updateEmail (
id_SE INTEGER PRIMARY KEY AUTOINCREMENT,
Telefono NUMBER(9) NOT NULL,
old_email VARCHAR2(50) NOT NULL,
new_email VARCHAR2(50) NOT NULL,
update_date DATETIME NOT NULL DEFAULT (datetime(CURRENT_TIMESTAMP, 'localtime'))
);

--trigger de actualizacion emailV
DROP TRIGGER IF EXISTS saveEmail;
CREATE TRIGGER saveEmail AFTER UPDATE
ON usuario
BEGIN
    INSERT INTO updateEmail (Telefono, old_email, new_email) VALUES(old.Telefono, old.old_email, new.new_email);
END;

--trigger guardar nombre y tipo alojamiento
DROP TABLE IF EXISTS saveName;
CREATE TABLE saveName(
    id_SN INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre VARCHAR2(30) NOT NULL,
    Tipo_Alojamiento VARCHAR2(20) NOT NULL
);

DROP TRIGGER IF EXISTS guardarNombre;
CREATE TRIGGER guardarNombre AFTER UPDATE
ON ALOJAMIENTOS
BEGIN
    INSERT INTO saveName(Nombre, Tipo_Alojamiento) VALUES (new.Nombre, new.Tipo_Alojamiento);
END;