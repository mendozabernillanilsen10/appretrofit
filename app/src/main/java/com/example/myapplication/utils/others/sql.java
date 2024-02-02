package com.example.myapplication.utils.others;

/**
 * Created by Kevin Vilcherrez on 12/10/2015.
 */
public class sql {
    public static String[] tablas = (

            "CREATE TABLE IF NOT EXISTS tabla_api4_01 (\n" +
                    "    iddatabase        VARCHAR(25)    DEFAULT '',\n" +
                    "    idempresa         VARCHAR(5)     DEFAULT '',\n" +
                    "    idcosechalabor    VARCHAR(36) PRIMARY KEY NOT NULL,\n" +
                    "    descripcion       VARCHAR(200)   DEFAULT '',\n" +
                    "    descripcion_corta VARCHAR(200)   DEFAULT '',\n" +
                    "    idcultivo         VARCHAR(10)    NOT NULL,\n" +
                    "    idactividad       VARCHAR(25)    DEFAULT '',\n" +
                    "    idlabor           VARCHAR(25)    DEFAULT '',\n" +
                    "    esrendimiento     SMALLINT       DEFAULT 0,\n" +
                    "    meta              DECIMAL(10, 2) DEFAULT 0.0,\n" +
                    "    costo             DECIMAL(10, 2) DEFAULT 0.0,\n" +
                    "    observaciones     TEXT           DEFAULT '...' NOT NULL,\n" +
                    "    activo            SMALLINT       DEFAULT 1 NOT NULL,\n" +
                    "    fechacreacion     DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS tabla_api4_02 (\n" +
                    "  idempresa    VARCHAR(25) NOT NULL,\n" +
                    "  idtrabajador VARCHAR(25)   NOT NULL,\n" +
                    "  nombresall   VARCHAR(300) NOT NULL,\n" +
                    "  habilitado      char(1)     NOT NULL,\n" +
                    "  cnrodocumento   varchar(12)     NOT NULL,\n" +
                    "  idplanilla      VARCHAR(15) NOT NULL,\n" +
                    "  listanegra      char(2)   default 'NO'  NOT NULL,\n" +
                    "  liquidado       INT     default 0    NOT NULL,\n" +
                    "  fecha_ingreso   DATETIME    NULL,\n" +
                    "  fecha_cese      DATETIME    NULL,\n" +
                    "  fecha_liquidado DATETIME    NULL\n" +
                    ");\n" +

            "CREATE TABLE IF NOT EXISTS cliente (\n" +
            "  idcliente     VARCHAR(11) PRIMARY KEY,\n" +
            "  ruc           CHAR(11)     NOT NULL,\n" +
            "  razon_social  VARCHAR(50)  NOT NULL,\n" +
            "  direccion     VARCHAR(120) NOT NULL,\n" +
            "  representante VARCHAR(120) DEFAULT '',\n" +
            "  telef1        VARCHAR(25)  DEFAULT '',\n" +
            "  telef2        VARCHAR(25)  DEFAULT '',\n" +
            "  telef3        VARCHAR(25)  DEFAULT '',\n" +
            "  email         VARCHAR(120) DEFAULT '',\n" +
            "  departamento  VARCHAR(50)  DEFAULT '',\n" +
            "  distrito      VARCHAR(50)  DEFAULT '',\n" +
            "  nrocuenta     VARCHAR(25)  DEFAULT '',\n" +
            "  idrubro       CHAR(3)      DEFAULT '000',\n" +
            "  password      VARCHAR(25)  NOT NULL,\n" +
            "  activo        SMALLINT     DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS servidor (\n" +
            "  idservidor    VARCHAR(25) PRIMARY KEY,\n" +
            "  descripcion   VARCHAR(50) NOT NULL,\n" +
            "  urilocal      VARCHAR(16) NOT NULL,\n" +
            "  uripublic     VARCHAR(16) NOT NULL,\n" +
            "  esdesktop     SMALLINT DEFAULT 0,\n" +
            "  esmovil       SMALLINT DEFAULT 0,\n" +
            "  activo        SMALLINT DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS basedatos (\n" +
            "  idservidor     VARCHAR(25) REFERENCES servidor,\n" +
            "  iddatabase     VARCHAR(25) PRIMARY KEY,\n" +
            "  descripcion    VARCHAR(30) NOT NULL,\n" +
            "  idadmin        VARCHAR(25) DEFAULT '',\n" +
            "  idconexion     TEXT        DEFAULT '',\n" +
            "  questpermision SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  esdesktop      SMALLINT    DEFAULT 0,\n" +
            "  esmovil        SMALLINT    DEFAULT 0,\n" +
            "  activo         SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion  DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS empresa (\n" +
            "  iddatabase    VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "  idempresa     CHAR(3)      NOT NULL,\n" +
            "  razon_social  VARCHAR(50)  NOT NULL,\n" +
            "  ruc           CHAR(11)     NOT NULL,\n" +
            "  direccion     VARCHAR(100) NOT NULL,\n" +
            "  representante VARCHAR(80) DEFAULT '',\n" +
            "  activo        SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS concepto (\n" +
            "  iddatabase       VARCHAR(25) NOT NULL,\n" +
            "  idempresa        CHAR(3)     NOT NULL,\n" +
            "  idconcepto       VARCHAR(15) NOT NULL,\n" +
            "  descripcion      TEXT        DEFAULT '',\n" +
            "  descripcioncorta VARCHAR(50) DEFAULT '',\n" +
            "  esjornal         SMALLINT    DEFAULT 1,\n" +
            "  esrendimiento    SMALLINT    DEFAULT 0,\n" +
            "  activo           SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion    DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS tipousuario (\n" +
            "  idtipousuario  VARCHAR(25) PRIMARY KEY,\n" +
            "  descripcion    VARCHAR(100) NOT NULL,\n" +
            "  esdigitador1   SMALLINT DEFAULT 0,\n" +
            "  esdigitador2   SMALLINT DEFAULT 0,\n" +
            "  edita          SMALLINT DEFAULT 0,\n" +
            "  elimina        SMALLINT DEFAULT 0,\n" +
            "  aprueba        SMALLINT DEFAULT 0,\n" +
            "  rechaza        SMALLINT DEFAULT 0,\n" +
            "  consulta       SMALLINT DEFAULT 0,\n" +
            "  essupervisor   SMALLINT DEFAULT 0,\n" +
            "  esjefe         SMALLINT DEFAULT 0,\n" +
            "  vereportes     SMALLINT DEFAULT 0,\n" +
            "  modpreferences SMALLINT DEFAULT 0,\n" +
            "  recibenotify   SMALLINT DEFAULT 0,\n" +
            "  exportadatos   SMALLINT DEFAULT 0,\n" +
            "  activo         SMALLINT DEFAULT 1,\n" +
            "  fechacreacion  DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS usuario (\n" +
            "  iddatabase      VARCHAR(25) NOT NULL,\n" +
            "  idusuario       VARCHAR(25) PRIMARY KEY,\n" +
            "  password        TEXT        NOT NULL,\n" +
            "  nombres         VARCHAR(60) DEFAULT '' NOT NULL,\n" +
            "  email           VARCHAR(100),\n" +
            "  idtrabajador    CHAR(8),\n" +
            "  esusuarionisira SMALLINT    DEFAULT 0 NOT NULL,\n" +
            "  escaporal       SMALLINT    DEFAULT 0 NOT NULL,\n" +
            "  essupervisor    SMALLINT    DEFAULT 0 NOT NULL,\n" +
            "  esusuarionormal SMALLINT    DEFAULT 0 NOT NULL,\n" +
            "  idtipousuario   VARCHAR(25) NOT NULL,\n" +
            "  firma           TEXT        NOT NULL,\n" +
            "  idusuarionisira VARCHAR(25) DEFAULT '',\n" +
            "  idresponsable   VARCHAR(15) DEFAULT '',\n" +
            "  mailto_tareo    TEXT        DEFAULT '',\n" +
            "  activo          SMALLINT    DEFAULT 1,\n" +
            "  fechacreacion   DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS turno (\n" +
            "  iddatabase       VARCHAR(25) NOT NULL,\n" +
            "  idempresa        CHAR(3)      DEFAULT '001' NOT NULL,\n" +
            "  idturno          CHAR(2)      DEFAULT '01',\n" +
            "  descripcion      VARCHAR(100) DEFAULT '',\n" +
            "  inicio           TIME         DEFAULT '00:00:00',\n" +
            "  iniciorefrigerio TIME         DEFAULT '12:00:00',\n" +
            "  finrefrigerio    TIME         DEFAULT '13:00:00',\n" +
            "  fin              TIME         DEFAULT '00:00:00',\n" +
            "  activo           SMALLINT     DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion    DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS planilla (\n" +
            "  iddatabase       VARCHAR(25)  NOT NULL,\n" +
            "  idempresa        CHAR(3)        DEFAULT '001' NOT NULL,\n" +
            "  idplanilla       VARCHAR(10)  NOT NULL,\n" +
            "  descripcion      VARCHAR(100) NOT NULL,\n" +
            "  periodo          VARCHAR(6)   NOT NULL,\n" +
            "  tipoplanilla     CHAR(1)      NOT NULL,\n" +
            "  sueldominimo     NUMERIC(13, 2) DEFAULT 750.00,\n" +
            "  nrosueldos       SMALLINT       DEFAULT 0.0,\n" +
            "  esplanillanisira SMALLINT       DEFAULT 0,\n" +
            "  activo           SMALLINT       DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion    DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS tipopuntoentrada (\n" +
            "  idtipopuntoentrada CHAR(3) PRIMARY KEY,\n" +
            "  descripcion        VARCHAR(25) NOT NULL,\n" +
            "  esobligaasistencia SMALLINT DEFAULT 0,\n" +
            "  esenviaalerta      SMALLINT DEFAULT 0,\n" +
            "  esgarita           SMALLINT DEFAULT 0,\n" +
            "  espretareador      SMALLINT DEFAULT 0,\n" +
            "  esbus              SMALLINT DEFAULT 0,\n" +
            "  activo             SMALLINT DEFAULT 1,\n" +
            "  fechacreacion      DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS puntoentrada (\n" +
            "  iddatabase     VARCHAR(25) NOT NULL,\n" +
            "  idempresa      CHAR(3)     NOT NULL,\n" +
            "  idpuntoentrada VARCHAR(10) NOT NULL,\n" +
            "  descripcion    VARCHAR(50) NOT NULL,\n" +
            "  idtipoentrada  CHAR(3) REFERENCES tipopuntoentrada,\n" +
            "  activo         SMALLINT DEFAULT 1,\n" +
            "  fechacreacion  DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS pretareo (\n" +
            "  idpretareo     VARCHAR(15) PRIMARY KEY,\n" +
            "  iddatabase     VARCHAR(25) NOT NULL,\n" +
            "  idempresa      CHAR(3)     NOT NULL,\n" +
            "  idusuario      VARCHAR(25) NOT NULL    REFERENCES usuario,\n" +
            "  idpuntoentrada VARCHAR(10) NOT NULL,\n" +
            "  idsupervisor   VARCHAR(25) NOT NULL,\n" +
            "  numero         CHAR(7)     NOT NULL,\n" +
            "  idestado       CHAR(2)     NOT NULL,\n" +
            "  idturno        VARCHAR(2)  NOT NULL,\n" +
            "  fecha          DATE     DEFAULT (date(current_date, 'localtime')),\n" +
            "  latitud        NUMERIC(13, 10),\n" +
            "  longitud       NUMERIC(13, 10),\n" +
            "  imei           VARCHAR(25),\n" +
            "  activo         SMALLINT DEFAULT 1,\n" +
            "  fechacreacion  DATETIME DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones  TEXT\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dpretareo (\n" +
            "  idpretareo    VARCHAR(15) REFERENCES pretareo,\n" +
            "  item          CHAR(4) NOT NULL,\n" +
            "  idtrabajador  CHAR(8) NOT NULL,\n" +
            "  hora          TIME    NOT NULL,\n" +
            "  idorigen      VARCHAR(15) DEFAULT '',\n" +
            "  activo        SMALLINT    DEFAULT 1,\n" +
            "  fechacreacion DATETIME    DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones TEXT        DEFAULT ''\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS logestado (\n" +
            "  iddatabase      VARCHAR(25) NOT NULL,\n" +
            "  idempresa       CHAR(3)     NOT NULL,\n" +
            "  idreferencia    VARCHAR(25) NOT NULL,\n" +
            "  tablareferencia VARCHAR(50) NOT NULL,\n" +
            "  valor_anterior  VARCHAR(25) NOT NULL,\n" +
            "  valor_nuevo     VARCHAR(25) NOT NULL,\n" +
            "  idusuario       VARCHAR(25) NOT NULL,\n" +
            "  observaciones   TEXT,\n" +
            "  fechacreacion   DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS tareo (\n" +
            "  idtareo       VARCHAR(15) PRIMARY KEY,\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     CHAR(3)     NOT NULL,\n" +
            "  idcultivo     VARCHAR(15)     DEFAULT '',\n" +
            "  idusuario     VARCHAR(25) NOT NULL REFERENCES usuario,\n" +
            "  idtrabajador  VARCHAR(15)     DEFAULT '',\n" +
            "  iddocumento   VARCHAR(3)      DEFAULT 'TAR',\n" +
            "  serie         VARCHAR(3)      DEFAULT '001',\n" +
            "  idestado      VARCHAR(2)      DEFAULT 'PE',\n" +
            "  numero        CHAR(7)     NOT NULL,\n" +
            "  fecha         DATE        NOT NULL,\n" +
            "  hora          TIME        NOT NULL,\n" +
            "  inicio          TIME        NULL,\n" +
            "  semana        VARCHAR(2)  NOT NULL,\n" +
            "  idplanilla    VARCHAR(10) NOT NULL,\n" +
            "  idturno       VARCHAR(3)  NOT NULL,\n" +
            "  periodo       VARCHAR(8)  NOT NULL,\n" +
            "  latitud       NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud      NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  escampo       SMALLINT        DEFAULT 1,\n" +
            "  espacking     SMALLINT        DEFAULT 0,\n" +
            "  fechacreacion DATETIME        DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones TEXT            DEFAULT '...',\n" +
            "  imei          VARCHAR(25)     DEFAULT '',\n" +
            "  idsupervisor  VARCHAR(10)     DEFAULT '',\n" +
            "  iniciorefdia        TIME            DEFAULT '00:00:00',\n" +
            "  finrefdia           TIME            DEFAULT '00:00:00',\n" +
            "  iniciorefnoc        TIME            DEFAULT '00:00:00',\n" +
            "  finrefnoc           TIME            DEFAULT '00:00:00',\n" +
            "  datareclamos           TIME            DEFAULT '',\n" +
            "  fin          TIME        NULL,\n" +
            "  iniciox          TIME        NULL,\n" +
            "  finx          TIME        NULL\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dtareo (\n" +
            "  idtareo           VARCHAR(15) NOT NULL    REFERENCES tareo,\n" +
            "  iddatabase        VARCHAR(25) NOT NULL,\n" +
            "  idempresa         CHAR(3)     NOT NULL,\n" +
            "  linea         tinyiny     default 1,\n" +
            "  grupo         tinyiny     default 1,\n" +
            "  idcultivovariedad VARCHAR(25)     DEFAULT '',\n" +
            "  item              VARCHAR(4)  NOT NULL,\n" +
            "  idactividad       VARCHAR(25) NOT NULL,\n" +
            "  idlabor           VARCHAR(25) NOT NULL,\n" +
            "  idconsumidor      VARCHAR(25) NOT NULL,\n" +
            "  fecha             DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            "  horainicio        TIME            DEFAULT '00:00:00',\n" +
            "  horafin           TIME            DEFAULT '00:00:00',\n" +
            "  totalhoras        DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  idestado          VARCHAR(2)      DEFAULT 'PE',\n" +
            "  esjornal          SMALLINT        DEFAULT 1,\n" +
            "  esrendimiento     SMALLINT        DEFAULT 0,\n" +
            "  idfundo           VARCHAR(25)     DEFAULT '',\n" +
            "  idfundojefe       VARCHAR(25)     DEFAULT '',\n" +
            "  latitud           NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud          NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  fechacreacion     DATETIME        DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones     TEXT            DEFAULT '...',\n" +
            "  idsupervisor     varchar(10)      DEFAULT ''\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS ddtareo (\n" +
            "  idtareo          VARCHAR(15) REFERENCES tareo,\n" +
            "  iddatabase       VARCHAR(25) NOT NULL,\n" +
            "  idempresa        CHAR(3)     NOT NULL,\n" +
            "  linea            tinyint     default 1,\n" +
            "  mesa             tinyint     default 1,\n" +
            "  itemid           VARCHAR(4)  NOT NULL,\n" +
            "  item             VARCHAR(4)  NOT NULL,\n" +
            "  idtrabajador     VARCHAR(8)  NOT NULL,\n" +
            "  estatus          VARCHAR(5)      DEFAULT 'N' NOT NULL,\n" +
            "  esjornal         SMALLINT        DEFAULT 1,\n" +
            "  esrendimiento    SMALLINT        DEFAULT 0,\n" +
            "  fecha            DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            "  inicio           TIME            DEFAULT '00:00:00',\n" +
            "  iniciorefrigerio TIME            DEFAULT '12:00:00',\n" +
            "  finrefrigerio    TIME            DEFAULT '13:00:00',\n" +
            "  fin              TIME            DEFAULT '00:00:00',\n" +
            "  asistio          INT             DEFAULT 0,\n" +
            "  jornal           DECIMAL(15, 2)  DEFAULT 0.0,\n" +
            "  rendimiento      DECIMAL(15, 2)  DEFAULT 0.0,\n" +
            "  avance           DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  jornalextra      DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  rendimientoextra DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  conceptobono     VARCHAR(35)     DEFAULT 0.0,\n" +
            "  bono             DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  agregado1        DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  agregado2        DECIMAL(5, 2)   DEFAULT 0.0,\n" +
            "  idmotivo         VARCHAR(10)     DEFAULT '' NOT NULL,\n" +
            "  latitud          NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  fechacreacion    DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime')),\n" +
            "  observaciones    TEXT            DEFAULT '...',\n" +
            "  diasiguiente     tinyint          default 0, \n" +
            "  t_comp           tinyint          default 0, \n" +
            "  h_comp           DECIMAL(15, 2)  DEFAULT 0.0,  \n" +
            "  idregimen       VARCHAR(25) DEFAULT '',\n" +
            "  iddprogramacion       VARCHAR(25) DEFAULT ''\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS asistenciabytareo (\n" +
            "  iddatabase           VARCHAR(25) NOT NULL,\n" +
            "  idempresa            CHAR(3)     NOT NULL,\n" +
            "  idasistenciabytareo  VARCHAR(50) NULL,\n" +
            "  keyreferencia_ing    VARCHAR(50) NULL,\n" +
            "  keyreferencia_sal    VARCHAR(50) NULL,\n" +
            "  idusuario            VARCHAR(25) NULL,\n" +
            "  fecha                DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            "  idtrabajador         VARCHAR(12)  NOT NULL,\n" +
            "  estatus              VARCHAR(5)      DEFAULT 'PE' NOT NULL,\n" +
            "  motivo_obs           VARCHAR(100)    ,\n" +
            "  detalle              VARCHAR(100)    ,\n" +
            "  ingreso              DATETIME        ,\n" +
            "  salida               DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime')),\n" +
            "  iddevice             VARCHAR(30)    ,\n" +
            "  type                 VARCHAR(10)    ,\n" +
            "  latitud_ing          NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud_ing         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  latitud_sal         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud_sal         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  activo               SMALLINT    DEFAULT 1,\n" +
            "  observaciones        TEXT   ,\n" +
            "  fechacreacion        DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime')),\n" +
            "  fechaalter           DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS ddtareo_hcomp (\n" +
            "  idtareo          VARCHAR(15) REFERENCES tareo,\n" +
            "  iddatabase       VARCHAR(25) NOT NULL,\n" +
            "  idempresa        CHAR(3)     NOT NULL,\n" +
            "  itemid           VARCHAR(4)  NOT NULL,\n" +
            "  idtrabajador     VARCHAR(8)  NOT NULL,\n" +
            "  estatus          VARCHAR(5)      DEFAULT 'N' NOT NULL,\n" +
            "  esjornal         SMALLINT        DEFAULT 1,\n" +
            "  esrendimiento    SMALLINT        DEFAULT 0,\n" +
            "  fecha            DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            "  jornal_compens   DECIMAL(15, 2)  DEFAULT 0.0,\n" +
            "  idmotivo         VARCHAR(10)     DEFAULT '' NOT NULL,\n" +
            "  latitud          NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  longitud         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "  fechacreacion    DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime')),\n" +
            "  observaciones    TEXT            DEFAULT '...'\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dddtareo (\n" +
            "  idtareo           VARCHAR(15) REFERENCES tareo,\n" +
            "  idcultivovariedad VARCHAR(25)   DEFAULT '',\n" +
            "  itemid            VARCHAR(4) NOT NULL,\n" +
            "  item              VARCHAR(4) NOT NULL,\n" +
            "  idtrabajador      VARCHAR(8) NOT NULL,\n" +
            "  idunidad          VARCHAR(15)   DEFAULT '',\n" +
            "  valor             DECIMAL(5, 2) DEFAULT 0.0,\n" +
            "  esjornal          SMALLINT      DEFAULT 1,\n" +
            "  esrendimiento     SMALLINT      DEFAULT 0,\n" +
            "  hora              TIME          DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "  activo            SMALLINT      DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion     DATETIME      DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones     TEXT          DEFAULT '...'\n" +
            ");\n" +
            "create table IF NOT EXISTS ddtareotrazabilidad\n" +
            "(\n" +
            "    idtareo        VARCHAR(15) not null,\n" +
            "    iddatabase     VARCHAR(25) NOT NULL,\n" +
            "    idempresa      CHAR(3)     NOT NULL,\n" +
            "    fecha          date         default (date(current_date, 'localtime')),\n" +
            "    hora           TIME(0)      DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "    linea          tinyint      default 1,\n" +
            "    idmovcode      varchar(6)   default '',\n" +
            "    idtrabajador   varchar(8)  null,\n" +
            "    etiqueta       varchar(7)   default 'XYZ0000',\n" +
            "    codeadd        varchar(5)   default '',\n" +
            "    trazabilidad   TEXT         default '',\n" +
            "    idproducto     varchar(200) default '',\n" +
            "    idpresentacion varchar(200) default '',\n" +
            "    host           varchar(100) default '',\n" +
            "    pack_trab      varchar(4)   default '',\n" +
            "    pack_empaque   varchar(5)   default '',\n" +
            "    pack_estado    varchar(2)   default '',\n" +
            "    pack_completo  tinyint      default 1,\n" +
            "    activo         tinyint      DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion  DATETIME     DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "    observaciones  TEXT         DEFAULT '...'\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS actividad (\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     char(3)     NOT NULL,\n" +
            "  idactividad   VARCHAR(25) NOT NULL,\n" +
            "  descripcion   VARCHAR(80) DEFAULT '',\n" +
            "  nombrecorto   VARCHAR(30) DEFAULT '',\n" +
            "  tipo          char(1)     DEFAULT '',\n" +
            "  esrendimiento SMALLINT    NOT NULL,\n" +
            "  activo        SMALLINT    NOT NULL,\n" +
            "  fechacreacion DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS labor (\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     char(3)     NOT NULL,\n" +
            "  idactividad   VARCHAR(25) NOT NULL,\n" +
            "  idlabor       VARCHAR(25) NOT NULL,\n" +
            "  descripcion   VARCHAR(80) DEFAULT '',\n" +
            "  nombrecorto   VARCHAR(30) DEFAULT '',\n" +
            "  activo        SMALLINT    DEFAULT 1,\n" +
            "  fechacreacion DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS consumidor (\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     char(3)     NOT NULL,\n" +
            "  idconsumidor  VARCHAR(25) NOT NULL,\n" +
            "  tipo          VARCHAR(5)    DEFAULT '',\n" +
            "  jerarquia     VARCHAR(100)  DEFAULT '',\n" +
            "  descripcion   VARCHAR(200)  DEFAULT '',\n" +
            "  area          DECIMAL(5, 2) DEFAULT 0.0,\n" +
            "  idsucursal    char(3)       DEFAULT '',\n" +
            "  fechabaja     DATETIME      DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  activo        SMALLINT      DEFAULT 1,\n" +
            "  fechacreacion DATETIME      DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dconsumidorsiembra (\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     char(3)     NOT NULL,\n" +
            "  idconsumidor  VARCHAR(25) NOT NULL,\n" +
            "  idsiembra     VARCHAR(25) NOT NULL,\n" +
            "  idcultivo     VARCHAR(4)    DEFAULT '',\n" +
            "  idvariedad    VARCHAR(3)    DEFAULT '',\n" +
            "  area          DECIMAL(5, 2) DEFAULT 0.0,\n" +
            "  nroplantas    DECIMAL(5, 2) DEFAULT 0.0,\n" +
            "  camas         DECIMAL(5, 2) DEFAULT 0.0,\n" +
            "  semana        VARCHAR(10)   DEFAULT '',\n" +
            "  sistema       VARCHAR(25)   DEFAULT '',\n" +
            "  fecha_cosecha c\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS trabajador (\n" +
            "  iddatabase      VARCHAR(25) NOT NULL,\n" +
            "  idempresa       char(3)     NOT NULL,\n" +
            "  idtrabajador    char(8)     NOT NULL,\n" +
            "  appaterno       VARCHAR(50) default '' NOT NULL,\n" +
            "  apmaterno       VARCHAR(50) default '' NOT NULL,\n" +
            "  nombres         VARCHAR(50) default '' NOT NULL,\n" +
            "  nombresall      TEXT      default ''  NOT NULL,\n" +
            "  habilitado      char(1)     NOT NULL,\n" +
            "  cnrodocumento   varchar(12)     NOT NULL,\n" +
            "  vienedenisira   char(1)   default '0'  NOT NULL,\n" +
            "  idplanilla      VARCHAR(15) NOT NULL,\n" +
            "  listanegra      char(2)   default 'NO'  NOT NULL,\n" +
            "  liquidado       INT     default 0    NOT NULL,\n" +
            "  fecha_ingreso   DATETIME    NULL,\n" +
            "  fecha_cese      DATETIME    NULL,\n" +
            "  fecha_liquidado DATETIME    NULL\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dashConsumidor (\n" +
            "  consumidor        VARCHAR,\n" +
            "  descr_consum      VARCHAR,\n" +
            "  tipo_hora         VARCHAR,\n" +
            "  horas             NUMERIC,\n" +
            "  rendimiento       NUMERIC,\n" +
            "  costo_soles       NUMERIC,\n" +
            "  costo_dolares     NUMERIC,\n" +
            "  personas          INT,\n" +
            "  ccosto            VARCHAR,\n" +
            "  descr_ccosto      VARCHAR,\n" +
            "  referencia        VARCHAR,\n" +
            "  avance            NUMERIC,\n" +
            "  avanceesperado    NUMERIC,\n" +
            "  porcentaje_avance NUMERIC,\n" +
            "  dsc_clscosto      VARCHAR\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dashActividad (\n" +
            "  actividad         VARCHAR,\n" +
            "  descr_activ       VARCHAR,\n" +
            "  tipo_hora         VARCHAR,\n" +
            "  horas             NUMERIC,\n" +
            "  rendimiento       NUMERIC,\n" +
            "  costo_soles       NUMERIC,\n" +
            "  costo_dolares     NUMERIC,\n" +
            "  personas          INT,\n" +
            "  ccosto            VARCHAR,\n" +
            "  descr_ccosto      VARCHAR,\n" +
            "  referencia        VARCHAR,\n" +
            "  avance            NUMERIC,\n" +
            "  avanceesperado    NUMERIC,\n" +
            "  porcentaje_avance NUMERIC\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS cultivovariedad (\n" +
            "  iddatabase        VARCHAR(25) DEFAULT '',\n" +
            "  idempresa         VARCHAR(3)  DEFAULT '',\n" +
            "  idcultivo         VARCHAR(10) DEFAULT '',\n" +
            "  cultivo           VARCHAR(30) DEFAULT '',\n" +
            "  idvariedad        VARCHAR(25) DEFAULT '',\n" +
            "  variedad          VARCHAR(60) DEFAULT '',\n" +
            "  idcultivovariedad VARCHAR(30) DEFAULT '',\n" +
            "  cultivovariedad   VARCHAR(80) DEFAULT ''\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS motivo (\n" +
            "    idmotivo        VARCHAR(10) PRIMARY KEY NOT NULL ,\n" +
            "    descripcion     VARCHAR(100) DEFAULT '' ,\n" +
            "    nombrecorto     VARCHAR(15)  DEFAULT '' ,\n" +
            "    tareo           TINYINT      DEFAULT 1 NOT NULL ,\n" +
            "    pretareo        TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    cosecha         TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    programacionmo  TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    asispersonal    TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    packing         TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    recepcion       TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    despacho        TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    riego           TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    fitosanidad     TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    controlprocesos TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    maquinaria      TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    costos          TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    controlestados  TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    asistransporte  TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    generaaviso     TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    enviaalerta     TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    impresionboleta TINYINT      DEFAULT 0 NOT NULL ,\n" +
            "    activo          TINYINT      DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion   DATETIME     DEFAULT ( datetime( current_timestamp , 'localtime' ) ) ,\n" +
            "    observaciones   TEXT         DEFAULT '...' NOT NULL\n" +
            "                                  );\n" +
            "CREATE TABLE IF NOT EXISTS movresponsablefundo (\n" +
            "  idjefefundo VARCHAR(8)   NOT NULL,\n" +
            "  nombrejefe  VARCHAR(200) NOT NULL,\n" +
            "  idfundo     VARCHAR(25) DEFAULT '' NOT NULL\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS movsubtareoconfig\n" +
            "(\n" +
            "    iddatabase          VARCHAR(25) NOT NULL,\n" +
            "    idempresa           CHAR(3)     NOT NULL,\n" +
            "    idmovsubtareoconfig VARCHAR(25) PRIMARY KEY,\n" +
            "    idmovcode           varchar(6)   default '',\n" +
            "    descripcion         varchar(200) default '',\n" +
            "    descripcion_corta   varchar(15)  default '',\n" +
            "    idusuario           VARCHAR(15)  DEFAULT '',\n" +
            "    idcultivo           VARCHAR(15)    NOT NULL,\n" +
            "    idvariedad          VARCHAR(15) NOT NULL,\n" +
            "    idlabor             VARCHAR(25) NOT NULL,\n" +
            "    idactividad         VARCHAR(25) NOT NULL,\n" +
            "    idconsumidor        VARCHAR(25) NOT NULL,\n" +
            "    cantidadtrab        smallint     default 1,\n" +
            "    destinotrab         varchar(5)   default 'CAMP',\n" +
            "    linea               tinyint      default 1,\n" +
            "    grupo               tinyint      default 1,\n" +
            "    activo              SMALLINT     DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion       DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS fundoxconsumidor (\n" +
            "  vinedo     VARCHAR(25),\n" +
            "  fundo      char(3),\n" +
            "  modulo     VARCHAR,\n" +
            "  idlote     VARCHAR,\n" +
            "  descrlote  VARCHAR,\n" +
            "  area       DECIMAL,\n" +
            "  nroplts    DECIMAL,\n" +
            "  idcultivo  VARCHAR,\n" +
            "  cultivo    VARCHAR,\n" +
            "  idvariedad VARCHAR,\n" +
            "  variedad   VARCHAR\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS unimedida (\n" +
            "  iddatabase    VARCHAR(25) NOT NULL,\n" +
            "  idempresa     VARCHAR(3)  NOT NULL,\n" +
            "  idmedida      VARCHAR(25)  DEFAULT '' NOT NULL,\n" +
            "  descripcion   VARCHAR(200) DEFAULT '' NOT NULL,\n" +
            "  nombrecorto   VARCHAR(50)  DEFAULT '' NOT NULL,\n" +
            "  activo        SMALLINT     DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "create table IF NOT EXISTS unidadnegocio\n" +
            "(\n" +
            "    iddatabase   varchar(25)  not null,\n" +
            "    idempresa    varchar(3)   not null,\n" +
            "    iduninegocio varchar(25)  not null,\n" +
            "    grupo        varchar(30)  not null,\n" +
            "    descripcion  varchar(250) not null\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS cosechalabor\n" +
            "(\n" +
            "    iddatabase        VARCHAR(25)    DEFAULT '',\n" +
            "    idempresa         VARCHAR(5)     DEFAULT '',\n" +
            "    idcosechalabor    VARCHAR(36) PRIMARY KEY NOT NULL,\n" +
            "    descripcion       VARCHAR(200)   DEFAULT '',\n" +
            "    descripcion_corta VARCHAR(200)   DEFAULT '',\n" +
            "    idcultivo         VARCHAR(10)             NOT NULL,\n" +
            "    idactividad       VARCHAR(25)    DEFAULT '',\n" +
            "    idlabor           VARCHAR(25)    DEFAULT '',\n" +
            "    idunidadavancepadre           VARCHAR(25)    DEFAULT '',\n" +
            "    idunidadavancehijo           VARCHAR(25)    DEFAULT '',\n" +
            "    cantidad              DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "    esrendimiento     SMALLINT       DEFAULT 0,\n" +
            "    meta              DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "    costo             DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "    observaciones     TEXT           DEFAULT '...' NOT NULL,\n" +
            "    activo            SMALLINT       DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion     DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS cultivovariedad (\n" +
            "  iddatabase        VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "  idempresa         CHAR(3) REFERENCES empresa (idempresa),\n" +
            "  idcultivo         VARCHAR(25),\n" +
            "  cultivo           VARCHAR(100),\n" +
            "  idvariedad        VARCHAR(25),\n" +
            "  variedad          VARCHAR(100),\n" +
            "  idcultivovariedad VARCHAR(60),\n" +
            "  cultivovariedad   VARCHAR(200),\n" +
            "  activo            SMALLINT DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion     DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS responsable (\n" +
            "  iddatabase      VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "  idempresa       CHAR(3) REFERENCES empresa (idempresa),\n" +
            "  idtrabajador    VARCHAR(8)   NOT NULL,\n" +
            "  nombres         VARCHAR(200) NOT NULL,\n" +
            "  esTareo         SMALLINT DEFAULT 1,\n" +
            "  esControlPuerta SMALLINT DEFAULT 0,\n" +
            "  esCampo         SMALLINT DEFAULT 0,\n" +
            "  esCosecha       SMALLINT DEFAULT 0,\n" +
            "  esProgramacion  SMALLINT DEFAULT 0,\n" +
            "  esGestionHumana SMALLINT DEFAULT 0,\n" +
            "  esPlanificacion SMALLINT DEFAULT 0,\n" +
            "  esGerente       SMALLINT DEFAULT 0,\n" +
            "  esSubGerente    SMALLINT DEFAULT 0,\n" +
            "  esJefe          SMALLINT DEFAULT 0,\n" +
            "  esSupervisor    SMALLINT DEFAULT 0,\n" +
            "  firma           TEXT     DEFAULT '...',\n" +
            "  observaciones   TEXT     DEFAULT '...' NOT NULL,\n" +
            "  passwordmobile   TEXT     DEFAULT '...' NOT NULL,\n" +
            "  activo          SMALLINT DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion   DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS consumidorcultivovar (\n" +
            "  idempresa    CHAR(3) REFERENCES empresa (idempresa),\n" +
            "  idconsumidor VARCHAR(15),\n" +
            "  etapa        VARCHAR(25),\n" +
            "  campo        VARCHAR(25),\n" +
            "  turno        VARCHAR(25),\n" +
            "  descripcion  VARCHAR(300),\n" +
            "  idcultivo    VARCHAR(10),\n" +
            "  cultivo      VARCHAR(50),\n" +
            "  idvariedad   VARCHAR(15),\n" +
            "  variedad     VARCHAR(50)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS cosecha (\n" +
            "  idcosecha     VARCHAR(15) PRIMARY KEY NOT NULL,\n" +
            "  iddatabase    VARCHAR(25)             NOT NULL,\n" +
            "  idempresa     VARCHAR(3)              NOT NULL,\n" +
            "  idplanilla    VARCHAR(10)             NOT NULL,\n" +
            "  idusuario     VARCHAR(25) DEFAULT '' NOT NULL,\n" +
            "  idsupervisor  VARCHAR(8)  DEFAULT '' NOT NULL,\n" +
            "  idapuntador   VARCHAR(8)  DEFAULT '' NOT NULL,\n" +
            "  idestado      VARCHAR(2)  DEFAULT 'PE',\n" +
            "  periodo       VARCHAR(10)             NOT NULL,\n" +
            "  fecha         DATE        DEFAULT (DATE(current_date, 'localtime')),\n" +
            "  hora          TIME        DEFAULT '00:00:00',\n" +
            "  idempaque     VARCHAR(15) DEFAULT '',\n" +
            "  numcuadrilla  TINYINT     DEFAULT 1,\n" +
            "  idcultivo     VARCHAR(25) DEFAULT '',\n" +
            "  idvariedad    VARCHAR(25) DEFAULT '',\n" +
            "  observaciones TEXT        DEFAULT '',\n" +
            "  activo        SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS dcosecha\n" +
            "(\n" +
            "    idcosecha      VARCHAR(15) NOT NULL,\n" +
            "    iddatabase     VARCHAR(25) NOT NULL,\n" +
            "    idempresa      VARCHAR(3)  NOT NULL,\n" +
            "    item           VARCHAR(3)  NOT NULL,\n" +
            "    idconsumidor   VARCHAR(25) NOT NULL,\n" +
            "    idapuntador    VARCHAR(60) default ''  NOT NULL,\n" +
            "    idsupervisor   VARCHAR(60)  default '' NOT NULL,\n" +
            "    idjaberos      VARCHAR(80)  default '' NOT NULL,\n" +
            "    idpesadores    VARCHAR(80)  default '' not null,\n" +
            "    fecha          DATE        DEFAULT (DATE(current_date, 'localtime')),\n" +
            "    idestado       VARCHAR(2)  DEFAULT 'PE',\n" +
            "    horaini        time        DEFAULT '00:00:00',\n" +
            "    horafin        time        DEFAULT '00:00:00',\n" +
            "    idcosechalabor VARCHAR(25) DEFAULT '',\n" +
            "    idmotivo       varchar(10) default '',\n" +
            "    observaciones  TEXT        default '',\n" +
            "    activo         SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion  DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS trabcosecha (\n" +
            "    idcosecha      VARCHAR(15) REFERENCES cosecha ( idcosecha ) ,\n" +
            "    iddatabase     VARCHAR(25)  NOT NULL ,\n" +
            "    idempresa      VARCHAR(3)   NOT NULL ,\n" +
            "    item           VARCHAR(3)   NOT NULL ,\n" +
            "    idtrabajador   VARCHAR(8)   NOT NULL ,\n" +
            "    idsupervisor   VARCHAR(8)      DEFAULT '' NOT NULL ,\n" +
            "    idapuntador    VARCHAR(8)      DEFAULT '' NOT NULL ,\n" +
            "    idjabero       VARCHAR(8)      DEFAULT '' NOT NULL ,\n" +
            "    idpesador      VARCHAR(8)      DEFAULT '' NOT NULL ,\n" +
            "    tipo           char(3)         DEFAULT 'COS' NOT NULL ,\n" +
            "    total          DECIMAL(10 , 2) DEFAULT 0.0 ,\n" +
            "    fechacreaciono datetime2(0) NULL ,\n" +
            "    estraslado     TINYINT         DEFAULT 0 ,\n" +
            "    activo         SMALLINT        DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion  DATETIME2(0)    DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            "  );\n" +
            "create table if not exists logcosecha(\n" +
            "    idcosecha     VARCHAR(15) NOT NULL,\n" +
            "    itemid        VARCHAR(3)  NOT NULL,\n" +
            "    item          VARCHAR(3)  NOT NULL,\n" +
            "    idtrabajador  VARCHAR(8)     default '',\n" +
            "    valoranterior decimal(10, 2) default 0.0,\n" +
            "    valornuevo    decimal(10, 2) default 0.0,\n" +
            "    observaciones TEXT           DEFAULT '',\n" +
            "    fechacreacion DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE if not exists ddcosecha(\n" +
            "    idcosecha        VARCHAR(15) NOT NULL,\n" +
            "    itemid           VARCHAR(3)  NOT NULL,\n" +
            "    item             VARCHAR(3)  NOT NULL,\n" +
            "    idtrabajador     VARCHAR(8)  NOT NULL,\n" +
            "    horas            DECIMAL(5, 2)  DEFAULT 0.0,\n" +
            "    cantidad         decimal(10, 2) DEFAULT 0.0,\n" +
            "    escosechador     tinyint        default 1,\n" +
            "    idsupervisorori  varchar(50)    default '',\n" +
            "    idconsumidorori  varchar(50)    default '',\n" +
            "    estraslado       tinyint        default 0,\n" +
            "    idmotivotraslado varchar(200)   default '',\n" +
            "    observaciones    TEXT           DEFAULT '',\n" +
            "    historialgps    TEXT           DEFAULT '',\n" +
            "    activo           SMALLINT       DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion    DATETIME       DEFAULT (datetime(current_timestamp, 'localtime')) ,\n" +
            "    linea DECIMAL(15, 2) default 0.00 \n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS empaque (\n" +
            "  iddatabase  VARCHAR(25) NOT NULL,\n" +
            "  idempresa   VARCHAR(3)  NOT NULL,\n" +
            "  idempaque   VARCHAR(3)  NOT NULL,\n" +
            "  descripcion VARCHAR,\n" +
            "  tara        DECIMAL(15, 2) DEFAULT 0.0,\n" +
            "  peso        DECIMAL(15, 2) DEFAULT 0.0,\n" +
            "  activo      TINYINT        DEFAULT 1,\n" +
            "  idunidadavance      varchar(25)        DEFAULT ''\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS tareofirma (\n" +
            "  idtareo       VARCHAR(15) REFERENCES tareo,\n" +
            "  idtrabajador  VARCHAR(8)   NOT NULL,\n" +
            "  fecha         DATE         NOT NULL,\n" +
            "  hora          TIME         NOT NULL,\n" +
            "  jornal        DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "  rendimiento   DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "  avance        DECIMAL(10, 2) DEFAULT 0.0,\n" +
            "  path          TEXT           DEFAULT '' NOT NULL,\n" +
            "  image         TEXT         NOT NULL,\n" +
            "  fileimage     BLOB           DEFAULT NULL,\n" +
            "  urlpublic     VARCHAR(200) NULL,\n" +
            "  estrabajador  SMALLINT       DEFAULT 1,\n" +
            "  essupervisor  SMALLINT       DEFAULT 0,\n" +
            "  activo        INT            DEFAULT 1,\n" +
            "  fechacreacion DATETIME       DEFAULT (DATETIME(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS signaturadataexists (\n" +
            "  idempresa    char(3) NOT NULL,\n" +
            "  fecha        DATE DEFAULT (date(current_date, 'localtime')),\n" +
            "  idtrabajador char(8) NOT NULL\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS transportista (\n" +
            "  iddatabase      VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "  idempresa       CHAR(3) REFERENCES empresa (idempresa),\n" +
            "  idtransportista VARCHAR(14) PRIMARY KEY  NOT NULL,\n" +
            "  ruc             VARCHAR(11)  DEFAULT '-',\n" +
            "  razonsocial     VARCHAR(300) DEFAULT '...',\n" +
            "  dni             VARCHAR(8)   DEFAULT '',\n" +
            "  nombres         VARCHAR(300) DEFAULT '',\n" +
            "  inicioContrato  DATE         DEFAULT (date(current_date, 'localtime')),\n" +
            "  finContrato     DATE         DEFAULT (date(current_date, 'localtime')),\n" +
            "  contacto        VARCHAR(300) DEFAULT '',\n" +
            "  telefono1       VARCHAR(50)  DEFAULT '',\n" +
            "  telefono2       VARCHAR(50)  DEFAULT '',\n" +
            "  mail            VARCHAR(50)  DEFAULT '',\n" +
            "  propio          SMALLINT     DEFAULT 0,\n" +
            "  observaciones   TEXT         DEFAULT '...',\n" +
            "  activo          SMALLINT     DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion   DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS conductor (\n" +
            "  iddatabase  VARCHAR(25) NOT NULL,\n" +
            "  idempresa   VARCHAR(3)  NOT NULL,\n" +
            "    idconductor         VARCHAR(8)  NOT NULL ,\n" +
            "    idestado            VARCHAR(2)   DEFAULT 'AC' ,\n" +
            "    nombres             VARCHAR(300) DEFAULT '' ,\n" +
            "    categoria           VARCHAR(30)  DEFAULT '-' ,\n" +
            "    idclasecategoria    VARCHAR(15)  DEFAULT '-' ,\n" +
            "    licencia            VARCHAR(50)  DEFAULT '...' ,\n" +
            "    fechacaducelicencia DATE         DEFAULT current_date ,\n" +
            "    sctr                VARCHAR(50)  DEFAULT '' ,\n" +
            "    fechacaducesctr     DATE         DEFAULT current_date  ,\n" +
            "    telefonos           VARCHAR(50)  DEFAULT '' ,\n" +
            "    email               VARCHAR(100) DEFAULT '' ,\n" +
            "    trabajadomingos     TINYINT      DEFAULT 0 ,\n" +
            "    estercero           TINYINT      DEFAULT 1 ,\n" +
            "    conincidentes       TINYINT      DEFAULT 0 ,\n" +
            "    foto                TEXT         DEFAULT '...' ,\n" +
            "    observaciones       TEXT         DEFAULT '...' ,\n" +
            "    activo              TINYINT      DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion       DATETIME     DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            "   );\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS vehiculo (\n" +
            "    idtransportista  VARCHAR(14) NOT NULL ,\n" +
            "    idvehiculo       VARCHAR(7)  NOT NULL ,\n" +
            "    idtipovehiculo   VARCHAR(25) NOT NULL ,\n" +
            "    estado           VARCHAR(2)      DEFAULT 'AC' ,\n" +
            "    unidad           VARCHAR(5)      DEFAULT '' ,\n" +
            "    placa            VARCHAR(30) NOT NULL ,\n" +
            "    costo            DECIMAL(10 , 4) DEFAULT 0.0 ,\n" +
            "    capacidadmax     SMALLINT        DEFAULT 1 ,\n" +
            "    capacidadmin     SMALLINT        DEFAULT 10 ,\n" +
            "    marca            VARCHAR(30)     DEFAULT '-' ,\n" +
            "    modelo           VARCHAR(30)     DEFAULT '...' ,\n" +
            "    color            VARCHAR(30)     DEFAULT '-' ,\n" +
            "    aniofab          SMALLINT        DEFAULT 1995 ,\n" +
            "    fechacaducesoat  DATE            DEFAULT current_date ,\n" +
            "    fecharevtecnica  DATE            DEFAULT current_date ,\n" +
            "    fechasegurocivil DATE            DEFAULT current_date ,\n" +
            "    trabajadomingos  SMALLINT        DEFAULT 0 ,\n" +
            "    procedencia      VARCHAR(300)    DEFAULT '...' ,\n" +
            "    foto             TEXT            DEFAULT '...' ,\n" +
            "    observaciones    TEXT            DEFAULT '...' ,\n" +
            "    activo           SMALLINT        DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion    DATETIME        DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            "                                    );\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS viaje (\n" +
            "    iddatabase      VARCHAR(25) DEFAULT '' ,\n" +
            "    idempresa       VARCHAR(5)  DEFAULT '' ,\n" +
            "    idviaje         VARCHAR(15) NOT NULL ,\n" +
            "    idtransportista VARCHAR(14) NOT NULL ,\n" +
            "    idconductor     VARCHAR(8)  NOT NULL ,\n" +
            "    idvehiculo      VARCHAR(7)  NOT NULL ,\n" +
            "    idpuntocontrol  VARCHAR(30) ,\n" +
            "    procedencia     VARCHAR(50) ,\n" +
            "    fecha           DATE        DEFAULT current_date ,\n" +
            "    numero          VARCHAR(2)  DEFAULT '01' ,\n" +
            "    idestado        VARCHAR(2)  DEFAULT 'PE' ,\n" +
            "    inicio          TIME        NOT NULL ,\n" +
            "    fin             TIME        NOT NULL ,\n" +
            "    qr              TEXT ,\n" +
            "    qr2              TEXT ,\n" +
            "    activo          SMALLINT    DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion   DATETIME    DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            " );\n" +
            "CREATE TABLE IF NOT EXISTS tipovehiculo (\n" +
            "    idtipovehiculo   VARCHAR(25)  NOT NULL PRIMARY KEY ,\n" +
            "    descripcion      VARCHAR(300) DEFAULT '' ,\n" +
            "    idclasecategoria VARCHAR(100) NOT NULL ,\n" +
            "    idclasificacion  VARCHAR(100) DEFAULT '' ,\n" +
            "    pasajmin         SMALLINT     DEFAULT 1 ,\n" +
            "    pasajmax         SMALLINT     DEFAULT 1 ,\n" +
            "    mercancia        SMALLINT     DEFAULT 0 ,\n" +
            "    transporte       SMALLINT     DEFAULT 0 ,\n" +
            "    ruedas           SMALLINT     DEFAULT 4 ,\n" +
            "    activo           SMALLINT     DEFAULT 1 NOT NULL ,\n" +
            "    fechacreacion    DATETIME     DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            "                                        );\n" +
            "CREATE TABLE IF NOT EXISTS asistenciavehiculo\n" +
            "(\n" +
            "    iddatabase         VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "    idempresa          CHAR(3) REFERENCES empresa (idempresa),\n" +
            "    idasistencia       VARCHAR(10) NOT NULL,\n" +
            "    idtransportista    VARCHAR(10) NOT NULL,\n" +
            "    idusuario          VARCHAR(25) REFERENCES usuario (idusuario),\n" +
            "    idpuntoentrada     VARCHAR(10) NOT NULL,\n" +
            "    unidad             VARCHAR(10) NOT NULL,\n" +
            "    estatus            VARCHAR(3)      DEFAULT 'ING',\n" +
            "    fecha              DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            "    hora               TIME            DEFAULT (date(current_date, 'localtime')),\n" +
            "    placa              VARCHAR(30) NOT NULL,\n" +
            "    dniconductor       VARCHAR(8)      DEFAULT '',\n" +
            "    procedenciadestino VARCHAR(300)    DEFAULT '',\n" +
            "    idmotivo           VARCHAR(15)     DEFAULT '',\n" +
            "    esIncidente        TINYINT         DEFAULT 0,\n" +
            "    licenciaIncidente  VARCHAR(30)     DEFAULT '',\n" +
            "    latitud            NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "    longitud           NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            "    device             VARCHAR(30)     DEFAULT '',\n" +
            "    foto               TEXT            DEFAULT '...',\n" +
            "    ingreso            SMALLINT        DEFAULT 0 NOT NULL,\n" +
            "    comentarios        TEXT            DEFAULT '...',\n" +
            "    observaciones      TEXT            DEFAULT '...',\n" +
            "    activo             SMALLINT        DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion      DATETIME        DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS personal_observado (\n" +
            "  IDCODIGOGENERAL VARCHAR(8),\n" +
            "  IDPLANILLA      VARCHAR(3),\n" +
            "  DESCRIPCION     VARCHAR(25),\n" +
            "  FECHA_INICIO    VARCHAR(10),\n" +
            "  A_PATERNO       VARCHAR(50),\n" +
            "  A_MATERNO       VARCHAR(50),\n" +
            "  NOMBRES         VARCHAR(50),\n" +
            "  VACACIONES      VARCHAR(2),\n" +
            "  FECHA_INI_VAC   VARCHAR(10),\n" +
            "  FECHA_FIN_VAC   VARCHAR(10),\n" +
            "  DESCANSO        VARCHAR(2),\n" +
            "  CONCEPTO        TEXT,\n" +
            "  FECHA_INI_DES   VARCHAR(10),\n" +
            "  FECHA_FIN_DES   VARCHAR(10),\n" +
            "  SUSPENSION      VARCHAR(2),\n" +
            "  MOTIVO          TEXT,\n" +
            "  FECHA_INI_SUS   VARCHAR(10),\n" +
            "  FECHA_FIN_SUS   VARCHAR(10),\n" +
            "  TIPO   VARCHAR(10)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS trabajadorpic (\n" +
            "  iddatabase      VARCHAR(25) NOT NULL,\n" +
            "  idempresa       CHAR(3)     NOT NULL,\n" +
            "  idplanilla      VARCHAR(15) NOT NULL,\n" +
            "  idtrabajadorpic VARCHAR(15) NOT NULL,\n" +
            "  fecharegistro   DATE        DEFAULT (date(current_date, 'localtime')),\n" +
            "  idtrabajador    CHAR(8)     NOT NULL,\n" +
            "  appaterno       VARCHAR(50) NOT NULL,\n" +
            "  apmaterno       VARCHAR(50) NOT NULL,\n" +
            "  nombres         VARCHAR(50) NOT NULL,\n" +
            "  nombresall      TEXT        NOT NULL,\n" +
            "  fechanacimiento DATETIME    NOT NULL,\n" +
            "  cargo         VARCHAR(50) NOT NULL,\n" +
            "  idpic           TEXT        NOT NULL,\n" +
            "  observaciones   TEXT        DEFAULT '...',\n" +
            "  iddevice        VARCHAR(25) DEFAULT '...',\n" +
            "  activo          SMALLINT    DEFAULT 1 NOT NULL,\n" +
            "  fechacreacion   DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS asistencia (\n" +
            "  iddatabase     VARCHAR(15)             NOT NULL,\n" +
            "  idempresa      VARCHAR(3)              NOT NULL,\n" +
            "  idasistencia   VARCHAR(16) PRIMARY KEY NOT NULL,\n" +
            "  idusuario     VARCHAR(25)   DEFAULT '',\n" +
            "  fecha          DATE         DEFAULT (date(current_timestamp, 'localtime')),\n" +
            "  semana         TINYINT      DEFAULT (strftime('%W', 'now')),\n" +
            "  idplanilla     VARCHAR(3)   DEFAULT 'OBR',\n" +
            "  idtrabajador   VARCHAR(8)   DEFAULT '',\n" +
            "  nombres        VARCHAR(120) DEFAULT '',\n" +
            "  horaingreso1   DATETIME     DEFAULT '00:00:00',\n" +
            "  horasalida1    DATETIME     DEFAULT '00:00:00',\n" +
            "  horaingreso2   DATETIME     DEFAULT '00:00:00',\n" +
            "  horasalida2    DATETIME     DEFAULT '00:00:00',\n" +
            "  horaingreso3   DATETIME     DEFAULT '00:00:00',\n" +
            "  horasalida3    DATETIME     DEFAULT '00:00:00',\n" +
            "  estatus        VARCHAR(3)   DEFAULT 'ING',\n" +
            "  ing_usuario    VARCHAR(25)  DEFAULT '',\n" +
            "  ing_motivo     VARCHAR(25)  DEFAULT '',\n" +
            "  sal_usuario    VARCHAR(25)  DEFAULT '',\n" +
            "  sal_motivo     VARCHAR(25)  DEFAULT '',\n" +
            "  susp_usuario   VARCHAR(25)  DEFAULT '',\n" +
            "  susp_motivo    VARCHAR(25)  DEFAULT '',\n" +
            "  idpuntoentrada VARCHAR(25)  DEFAULT '',\n" +
            "  iddevice       VARCHAR(25)  DEFAULT '',\n" +
            "  cantintento    TINYINT      DEFAULT 1,\n" +
            "  urlphoto       TEXT         DEFAULT '',\n" +
            "  activo         TINYINT      DEFAULT 1,\n" +
            "  fechacreacion  DATETIME     DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones  TEXT         DEFAULT '...',\n" +
            "  host           VARCHAR(250) DEFAULT '',\n" +
            "  idreclutador   VARCHAR(10) DEFAULT '',\n" +
            "  tipo           VARCHAR(10) DEFAULT ''\n" +
            ");\n" +
            "create table IF NOT EXISTS signaturedocument\n" +
            "(\n" +
            "    iddatabase     VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "    idempresa      CHAR(3) REFERENCES empresa (idempresa),\n" +
            "    idplanilla      VARCHAR(3) default 'ORA',\n" +
            "    idtrabajador   varchar(8)  not null,\n" +
            "    fecha          DATE           DEFAULT (date(current_date, 'localtime')),\n" +
            "    iddocumento    varchar(15)    default 'BOL',\n" +
            "    isfirma        tinyint        default 0,\n" +
            "    ishuella       tinyint        default 0,\n" +
            "    idmotivo       varchar(25) not null,\n" +
            "    observaciones  TEXT           default '',\n" +
            "    firma          TEXT           default '',\n" +
            "    fechaimpresion varchar(10)    default '',\n" +
            "    mes            varchar(25)    default '',\n" +
            "    semana1        tinyint        default 0,\n" +
            "    semana2        tinyint        default 0,\n" +
            "    pago           decimal(10, 2) default 0.0,\n" +
            "    activo         SMALLINT       DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion  DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS horario (\n" +
            "  idhorario       VARCHAR(15) PRIMARY KEY  NOT NULL,\n" +
            "  descripcion     VARCHAR(250) DEFAULT '',\n" +
            "  idplanilla      VARCHAR(15)  DEFAULT '',\n" +
            "  horainicio      TIME         DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "  horainiciorefri TIME         DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "  horafinrefri    TIME         DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "  horafin         TIME         DEFAULT (time(current_timestamp, 'localtime')),\n" +
            "  diainicio       TINYINT      DEFAULT 1,\n" +
            "  diafin          TINYINT      DEFAULT 6,\n" +
            "  activo          TINYINT      DEFAULT 1,\n" +
            "  fechacreacion   DATETIME     DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            "  observaciones   TEXT         DEFAULT '...'\n" +
            ");\n" +
            "create table if not exists entregadispositivo (\n" +
            "    iddatabase      VARCHAR(25) REFERENCES basedatos (iddatabase),\n" +
            "    idempresa       CHAR(3) REFERENCES empresa (idempresa),\n" +
            "    identrega       varchar(15) primary key not null,\n" +
            "    idestado        varchar(2)   default 'PE',\n" +
            "    fecha           date         DEFAULT (date(current_date, 'localtime')),\n" +
            "    idtrabajador    varchar(10)  default '',\n" +
            "    idtrabajador2   varchar(10)  default '',\n" +
            "    nombres         varchar(100) default '',\n" +
            "    identificador   varchar(10)  default '',\n" +
            "    etapa           varchar(25)  default '',\n" +
            "    campo           varchar(25)  default '',\n" +
            "    cargo           varchar(35)  default '',\n" +
            "    lugar           varchar(50)  default '',\n" +
            "    horaentrega     TIME         DEFAULT (date(current_date, 'localtime')),\n" +
            "    firmaentrega    TEXT         default '',\n" +
            "    horadevolucion  TIME         DEFAULT (date(current_date, 'localtime')),\n" +
            "    firmadevolucion TEXT         default '',\n" +
            "    otro            tinyint      default 0,\n" +
            "    observaciones   TEXT         default '',\n" +
            "    activo          tinyint      DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion   DATETIME     DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE if not exists asistenciatransporte\n" +
            "(iddatabase      VARCHAR(15)             NOT NULL,\n" +
            " idempresa       VARCHAR(3)              NOT NULL,\n" +
            " idasistencia    VARCHAR(16) PRIMARY KEY NOT NULL,\n" +
            " idtransportista varchar(25)     default '',\n" +
            " idreemplazante varchar(25)     default '',\n" +
            " unidad          varchar(25)     default '',\n" +
            " placa           varchar(25)     default '',\n" +
            " idchofer        varchar(15)     default '',\n" +
            " fecha           DATE            DEFAULT (date(current_date, 'localtime')),\n" +
            " semana          TINYINT         DEFAULT 0,\n" +
            " idplanilla      VARCHAR(3)      DEFAULT 'OBR',\n" +
            " idtrabajador    VARCHAR(8)              NOT NULL,\n" +
            " horaingreso1    TIME(0)         DEFAULT '00:00:00',\n" +
            " horasalida1     TIME(0)         DEFAULT '00:00:00',\n" +
            " estatus         VARCHAR(3)      DEFAULT 'ING',\n" +
            " estatus2         VARCHAR(3)      DEFAULT 'SUB',\n" +
            " idpuntoingreso  VARCHAR(25)     DEFAULT '',\n" +
            " idpuntosalida   VARCHAR(25)     DEFAULT '',\n" +
            " idparadero      VARCHAR(30)     DEFAULT '',\n" +
            " latitud         NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            " longitud        NUMERIC(13, 10) DEFAULT 0.000000000,\n" +
            " iddevice        VARCHAR(50)     DEFAULT '',\n" +
            " host            VARCHAR(250)    DEFAULT '',\n" +
            " observaciones   TEXT   DEFAULT '',\n" +
            " activo          TINYINT         DEFAULT 1,\n" +
            " fechacreacion   DATETIME DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
            " idreclutador    varchar(25)     DEFAULT '' not null,\n" +
            " idmotivo        VARCHAR(25)      DEFAULT '' NOT NULL ,\n" +
            " idprocedencia   VARCHAR(25)      DEFAULT '' NOT NULL ,\n" +
            " idviaje         VARCHAR(25)      DEFAULT '' NOT NULL \n" +
            ");\n" +
            "CREATE TABLE if not exists cosecha_resumen(\n" +
            "    fecha        date,\n" +
            "    idconsumidor varchar(25)    default '',\n" +
            "    cultivo      varchar(25)    default '',\n" +
            "    variedad     varchar(25)    default '',\n" +
            "    etapa        varchar(25)    default '',\n" +
            "    campo        varchar(25)    default '',\n" +
            "    turno        varchar(25)    default '',\n" +
            "    tipocosecha  varchar(25)    default '',\n" +
            "    trabajadores int            default 0,\n" +
            "    jabas        decimal(10, 2) default 0.0,\n" +
            "    prom         decimal(10, 2) default 0.0\n" +
            ");\n" +
            "create table if not exists notadespacho\n" +
            "(\n" +
            "    iddatabase        varchar(25)        not null,\n" +
            "    idempresa         char(3)            not null,\n" +
            "    idnotadespacho    varchar(10)        not null,\n" +
            "    idcosecha         varchar(25)        not null,\n" +
            "    item              varchar(25)        not null,\n" +
            "    fecha             date     DEFAULT CURRENT_DATE,\n" +
            "    idetapa           varchar(25)        not null,\n" +
            "    idcampo           varchar(25)        not null,\n" +
            "    idturno           varchar(25)        not null,\n" +
            "    idcosechalabor    varchar(50)        not null,\n" +
            "    tipoempaque       char(1)            not null,\n" +
            "    idtipocultivo     varchar(50)        not null,\n" +
            "    idproductor       varchar(50)        not null,\n" +
            "    destino           char(1)            not null,\n" +
            "    idetiqueta        varchar(50)        not null,\n" +
            "    idacopio          varchar(50)        not null,\n" +
            "    numero            varchar(25)        not null,\n" +
            "    placa             varchar(25)        not null,\n" +
            "    tipojaba          varchar(25)        not null,\n" +
            "    stock             smallint default 0 not null,\n" +
            "    observaciones     text               not null,\n" +
            "    activo            tinyint  default 1 not null,\n" +
            "    fechacreacion     datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "    fechaeliminacion  datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "    fechamodificacion datetime DEFAULT CURRENT_TIMESTAMP,\n" +
            "    fechaaprobacion   datetime DEFAULT CURRENT_TIMESTAMP\n" +
            ");\n" +
            "create table if not exists parammateriaprima\n" +
            "(\n" +
            "    iddatabase       varchar(25)  not null,\n" +
            "    idempresa        char(3)      not null,\n" +
            "    idparametro      varchar(50)  not null,\n" +
            "    tabla            varchar(50)  not null,\n" +
            "    descripcion      varchar(100) not null,\n" +
            "    descripcioncorta varchar(30)  not null,\n" +
            "    activo           tinyint      not null,\n" +
            "    fechacreacion    datetime DEFAULT CURRENT_TIMESTAMP\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS presentacionproducto\n" +
            "(\n" +
            "    iddatabase      VARCHAR(25),\n" +
            "    idempresa       CHAR(3),\n" +
            "    idcultivo       varchar(15)    default '',\n" +
            "    idvariedad      varchar(15)    default '',\n" +
            "    idpresentacion  varchar(25) not null,\n" +
            "    descripcion     varchar(80)    default '',\n" +
            "    descripcion2    varchar(30)    default '',\n" +
            "    idviatransporte varchar(15),\n" +
            "    precio1         decimal(10, 2) default 0.0,\n" +
            "    precio2         decimal(10, 2) default 0.0,\n" +
            "    precio3         decimal(10, 2) default 0.0,\n" +
            "    iddestino       varchar(5)     default 'CAMPO',\n" +
            "    activo          SMALLINT       DEFAULT 1 NOT NULL,\n" +
            "    fechacreacion   DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS ddtareopresentacion\n" +
            "(\n" +
            "    idtareo        VARCHAR(15) references tareo,\n" +
            "    itemid         varchar(4)     default '',\n" +
            "    iddocumento    varchar(2)     default 'PRE',\n" +
            "    nrodocumento   varchar(25)    default '',\n" +
            "    idactividad    varchar(25)    default '',\n" +
            "    idlabor        varchar(25)    default '',\n" +
            "    idconsumidor   varchar(25)    default '',\n" +
            "    idpresentacion varchar(25)    default '',\n" +
            "    idtrabajador   varchar(10)    default '',\n" +
            "    cantidad       decimal(10, 2) default 0.0,\n" +
            "    activo         SMALLINT       DEFAULT 1,\n" +
            "    fechacreacion  DATETIME       DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "CREATE TABLE if not exists asistenciabyjornal\n" +
            "(\n" +
            "    iddatabase     VARCHAR(15)             NOT NULL,\n" +
            "    idempresa      VARCHAR(3)              NOT NULL,\n" +
            "    idasistencia   VARCHAR(38) PRIMARY KEY NOT NULL,\n" +
            "    idusuario      varchar(25) default '',\n" +
            "    fecha          DATE        DEFAULT (date(current_date, 'localtime')),\n" +
            "    idtrabajador   VARCHAR(8)              NOT NULL,\n" +
            "    estatus        VARCHAR(3)  DEFAULT 'ING',\n" +
            "    motivo         VARCHAR(25) DEFAULT '-',\n" +
            "    hora           TIME(0)     DEFAULT '00:00:00',\n" +
            "    idpuntoentrada VARCHAR(25) DEFAULT '-',\n" +
            "    iddevice       VARCHAR(25) DEFAULT '-',\n" +
            "    activo         TINYINT     DEFAULT 1,\n" +
            "    fechacreacion  DATETIME    DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "create table if not exists destinoreclutamiento\n" +
            "(\n" +
            "    iddatabase             varchar(25) not null,\n" +
            "    idempresa              varchar(3)  not null,\n" +
            "    iddestinoreclutamiento varchar(10) not null primary key,\n" +
            "    departamento           varchar(100) default '' not null,\n" +
            "    provincia              varchar(100) default '' not null,\n" +
            "    distrito               varchar(100) default '' not null,\n" +
            "    lugar                  varchar(100) not null,\n" +
            "    latitud                decimal(10, 2),\n" +
            "    longitud               decimal(10, 2),\n" +
            "    activo                 TINYINT  DEFAULT 1,\n" +
            "    fechacreacion          DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "create table if not exists zonificacion\n" +
            "(\n" +
            "    iddatabase varchar(25) not null,\n" +
            "    idempresa varchar(3) not null,\n" +
            "    idzonificacion varchar(50) not null,\n" +
            "    preferencia varchar(50) not null,\n" +
            "    idzona varchar(50) not null,\n" +
            "    zona varchar(200),\n" +
            "    idsub_zona varchar(50) not null,\n" +
            "    subzona varchar(200),\n" +
            "    iddepartamento varchar(50) not null,\n" +
            "    departamento varchar(200),\n" +
            "    idprovincia varchar(50) not null,\n" +
            "    provincia varchar(200),\n" +
            "    iddistrito varchar(50) not null,\n" +
            "    distrito varchar(200),\n" +
            "    idcentropoblado varchar(50) not null,\n" +
            "    centropoblado varchar(200),\n" +
            "    idparadero varchar(50),\n" +
            "    paradero varchar(200),\n" +
            "    idreclutador varchar(50),\n" +
            "    reclutador varchar(200),\n" +
            "    idsupervisor varchar(50),\n" +
            "    supervisor varchar(200),\n" +
            "    activo                 TINYINT  DEFAULT 1,\n" +
            "    fechacreacion          DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +
            "create table if not exists trabajadores_global\n" +
            "(\n" +
            "    iddatabase  VARCHAR(25) ,\n" +
            "    idempresa  VARCHAR(4) ,\n" +
            "    idtrabajador VARCHAR(12) ,\n" +
            "    detalle      VARCHAR(150),\n" +
            "    nombres      VARCHAR(500)\n" +
            ");\n" +
            "create table if not exists estado_civil\n" +
            "(\n" +
            "    iddatabase  VARCHAR(25) ,\n" +
            "    idestadocivil  VARCHAR(25) ,\n" +
            "    descripcion2  VARCHAR(4) ,\n" +
            "    activo                 TINYINT  DEFAULT 1,\n" +
            "    fechacreacion          DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
            ");\n" +

            "create table if not exists parammateriaprima\n" +
            "(\n" +
            "    iddatabase       varchar(25)  not null,\n" +
            "    idempresa        char(3)      not null,\n" +
            "    idtipoformato    varchar(10)  not null,\n" +
            "    idformato        varchar(10)  not null,\n" +
            "    idtipoetiqueta   varchar(10)  not null,\n" +
            "    idtipoempaque    varchar(10)  not null,\n" +
            "    descripcion      varchar(300) not null,\n" +
            "    descripcioncorta varchar(30)  not null,\n" +
            "    activo           tinyint      not null,\n" +
            "    fechacreacion    datetime DEFAULT CURRENT_TIMESTAMP\n" +
            ");\n" +

            "CREATE TABLE if not exists reclutador (\n" +
            "    iddatabase    VARCHAR(25)  NOT NULL ,\n" +
            "    idempresa     VARCHAR(3)   NOT NULL ,\n" +
            "    idreclutador  VARCHAR(10) PRIMARY KEY ,\n" +
            "    nombres       VARCHAR(150) NOT NULL ,\n" +
            "    dni           VARCHAR(10)  NOT NULL ,\n" +
            "    tipo          char         NOT NULL ,\n" +
            "    tipolider     VARCHAR(5)         NOT NULL ,\n" +
            "    idzona        VARCHAR(50)  NOT NULL ,\n" +
            "    activo        TINYINT  DEFAULT 1 ,\n" +
            "    fechacreacion DATETIME DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
            "  );").split(";");

    public static String[] tablas2 = (
            "CREATE TABLE IF NOT EXISTS asistenciareclutamiento (\n" +
                    "    iddatabase             VARCHAR(25)             NOT NULL ,\n" +
                    "    idempresa              VARCHAR(3)              NOT NULL ,\n" +
                    "    idasistencia           VARCHAR(10) PRIMARY KEY NOT NULL ,\n" +
                    "    fecha                  DATE             DEFAULT ( date( current_date , 'localtime' ) ) ,\n" +
                    "    iddestinoreclutamiento VARCHAR(25)      DEFAULT '' ,\n" +
                    "    idreclutador           VARCHAR(10)      DEFAULT '' ,\n" +
                    "    idtrabajador           VARCHAR(10)      DEFAULT '' ,\n" +
                    "    nombres                VARCHAR(50)      DEFAULT '' ,\n" +
                    "    appaterno              VARCHAR(30)      DEFAULT '' ,\n" +
                    "    apmaterno              VARCHAR(30)      DEFAULT '' ,\n" +
                    "    fechanacimiento        DATE             DEFAULT '1901-01-01' ,\n" +
                    "    idestadocivil          VARCHAR(5)          ,\n" +
                    "    email                  VARCHAR(100)     DEFAULT '' ,\n" +
                    "    telefono               VARCHAR(100)     DEFAULT '' ,\n" +
                    "    cnthijos          int,\n" +
                    "    sexo                   char(1)          DEFAULT 'M' NOT NULL ,\n" +
                    "    url                    VARCHAR(250)     DEFAULT '' ,\n" +
                    "    latitud                NUMERIC(13 , 10) DEFAULT 0.000000000 ,\n" +
                    "    longitud               NUMERIC(13 , 10) DEFAULT 0.000000000 ,\n" +
                    "    host                   VARCHAR(250)     DEFAULT '' ,\n" +
                    "    idliderzona            VARCHAR(10)      DEFAULT '' ,\n" +
                    "    idliderunidad            VARCHAR(10)      DEFAULT '' ,\n" +
                    "    idmodoregistro         VARCHAR(20)      DEFAULT '' ,\n" +
                    "    experiencia                            VARCHAR(2)      DEFAULT '' ,\n" +
                    "    idareareclutamiento                    VARCHAR(40)      DEFAULT '' ,\n" +
                    "    idareareclutamientoactivitylabor    VARCHAR(40)      DEFAULT '' ,\n" +
                    "    cntcampanaexp          int,\n" +
                    "    tallabota                              VARCHAR(10)      DEFAULT '' ,\n" +
                    "    tallacasaca                            VARCHAR(10)      DEFAULT '' ,\n" +
                    "    direccion                              VARCHAR(200)      DEFAULT '' ,\n" +
                    "    modocp                                 VARCHAR(10)      DEFAULT '' ,\n" +
                    "    idfrecuencia            VARCHAR(10)      DEFAULT '' ,\n" +
                    "    idmotivo            VARCHAR(10)      DEFAULT '' ,\n" +
                    "    motivodetalle            VARCHAR(250)      DEFAULT '' ,\n" +
                    "    activo                 TINYINT          DEFAULT 1 ,\n" +
                    "    fechacreacion          DATETIME         DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
                    " );\n" +
                    "create table if not exists vehiculoestatus\n" +
                    "(\n" +
                    "    iddatabase        VARCHAR(25)             NOT NULL,\n" +
                    "    idempresa         VARCHAR(3)              NOT NULL,\n" +
                    "    idtransporista    VARCHAR(14)             NOT NULL,\n" +
                    "    idvehiculoestatus VARCHAR(10) PRIMARY KEY NOT NULL,\n" +
                    "    fecha             date            default (date(current_date, 'localtime')) not null,\n" +
                    "    horainicio        time(0)         default (date(current_date, 'localtime')) not null,\n" +
                    "    horafin           time(0)         default (date(current_date, 'localtime')) not null,\n" +
                    "    idpuntoentrada    varchar(10)     default '',\n" +
                    "    placa             varchar(10)     default '' not null,\n" +
                    "    idconductor       varchar(10)     default '' not null,\n" +
                    "    totaltrab         TINYINT         DEFAULT 1,\n" +
                    "    latitudi          decimal(13, 10) DEFAULT 0.000000000 not null,\n" +
                    "    longitudi         decimal(13, 10) DEFAULT 0.000000000 not null,\n" +
                    "    latitudf          decimal(13, 10) DEFAULT 0.000000000 not null,\n" +
                    "    longitudf         decimal(13, 10) DEFAULT 0.000000000 not null,\n" +
                    "    host              VARCHAR(100)    DEFAULT '',\n" +
                    "    activo            TINYINT         DEFAULT 1 not null,\n" +
                    "    fechacreacion     DATETIME        DEFAULT (datetime(current_timestamp, 'localtime')) not null\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS tipovehiculo (\n" +
                    "    idtipovehiculo   VARCHAR(25) PRIMARY KEY ,\n" +
                    "    descripcion      VARCHAR(300) DEFAULT '' ,\n" +
                    "    idclasecategoria VARCHAR(100) NOT NULL ,\n" +
                    "    idclasificacion  VARCHAR(100) DEFAULT '' ,\n" +
                    "    pasajmin         SMALLINT     DEFAULT 1 ,\n" +
                    "    pasajmax         SMALLINT     DEFAULT 1 ,\n" +
                    "    mercancia        SMALLINT     DEFAULT 0 ,\n" +
                    "    transporte       SMALLINT     DEFAULT 0 ,\n" +
                    "    ruedas           SMALLINT     DEFAULT 4 ,\n" +
                    "    activo           TINYINT      DEFAULT 1 NOT NULL ,\n" +
                    "    fechacreacion    DATETIME     DEFAULT ( datetime( current_timestamp , 'localtime' ) ) NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS movreclutado (\n" +
                    "    iddatabase     VARCHAR(25) DEFAULT 'AGROVISIONCORP' NOT NULL ,\n" +
                    "    idempresa      char(3)     DEFAULT '001' NOT NULL ,\n" +
                    "    idplanilla     VARCHAR(3) ,\n" +
                    "    idusuario      VARCHAR(25) ,\n" +
                    "    fecha             DATE             DEFAULT ( date( current_date , 'localtime' ) ) NOT NULL ,\n" +
                    "    idmovreclutado VARCHAR(15) DEFAULT '' NOT NULL ,\n" +
                    "    listatrab      TEXT        DEFAULT '' ,\n" +
                    "    activo         TINYINT     DEFAULT 1 NOT NULL ,\n" +
                    "    fechacreacion  DATETIME    DEFAULT ( datetime( current_timestamp , 'localtime' ) ) NOT NULL\n" +
                    "                          );\n" +
                    "CREATE TABLE IF NOT EXISTS reemplazotransporte (\n" +
                    "    iddatabase            VARCHAR(25) REFERENCES basedatos ( iddatabase ) ,\n" +
                    "    idempresa             CHAR(3) REFERENCES empresa ( idempresa ) ,\n" +
                    "    idreemplazotransporte VARCHAR(7) PRIMARY KEY NOT NULL ,\n" +
                    "    idtransportista       VARCHAR(10)            NOT NULL ,\n" +
                    "    idestado              VARCHAR(2)      DEFAULT 'PE' ,\n" +
                    "    idusuarioap           VARCHAR(15)     DEFAULT NULL ,\n" +
                    "    fecha                 DATE            DEFAULT ( date( current_date , 'localtime' ) ) ,\n" +
                    "    idconductor           VARCHAR(8)      DEFAULT '' ,\n" +
                    "    placa                 VARCHAR(10)     DEFAULT '' ,\n" +
                    "    idreemplazo           VARCHAR(8)      DEFAULT '' ,\n" +
                    "    placareemplazo        VARCHAR(10)     DEFAULT '' ,\n" +
                    "    idmotivo              VARCHAR(10)     DEFAULT '' ,\n" +
                    "    capacidad             TINYINT         DEFAULT 1 ,\n" +
                    "    costo                 DECIMAL(10 , 2) DEFAULT 0.0 ,\n" +
                    "    observaciones         TEXT            DEFAULT '...' ,\n" +
                    "    activo                SMALLINT        DEFAULT 1 NOT NULL ,\n" +
                    "    fechacreacion         DATETIME        DEFAULT ( datetime( current_timestamp , 'localtime' ) )\n" +
                    "   );\n" +
                    "   create table if not exists cargo(\n" +
                    "    idempresa varchar(3) not null,\n" +
                    "    cargo varchar(200) not null,\n" +
                    "    total int default 0 \n" +
                    "   );\n" +
                    "CREATE TABLE IF NOT EXISTS  empadronamiento (\n" +
                    "    fecha        DATE ,\n" +
                    "    reclutador  VARCHAR(200) ,\n" +
                    "    idtrabajador VARCHAR(12) ,\n" +
                    "    nombres      VARCHAR(400)\n" +
                    "   );\n" +
                    "create table IF NOT EXISTS ddtareopacking\n" +
                    "(\n" +
                    "    idtareo     varchar(25),\n" +
                    "    idempresa     varchar(3),\n" +
                    "    fecha         date,\n" +
                    "    hora          time,\n" +
                    "    etiqueta      varchar(10),\n" +
                    "    linea         tinyint,\n" +
                    "    numerocaja         int,\n" +
                    "    mode          varchar(25),\n" +
                    "    idtrabajador  varchar(8),\n" +
                    "    idactividad   varchar(25),\n" +
                    "    idlabor       varchar(25),\n" +
                    "    idconsumidor   varchar(50),\n" +
                    "    esgenerica    tinyint default 1,\n" +
                    "    activo        tinyint default 1,\n" +
                    "    fechacreacion DATETIME DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
                    "    fechaalter    DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "create table IF NOT EXISTS movtrabetiquetapacking\n" +
                    "(\n" +
                    "    idempresa     varchar(3),\n" +
                    "    idcultivo     varchar(5),\n" +
                    "    cultivo       varchar(25),\n" +
                    "    code          varchar(6),\n" +
                    "    linea         tinyint,\n" +
                    "    mode          varchar(25),\n" +
                    "    idtrabajador  varchar(8),\n" +
                    "    apellidos     varchar(100),\n" +
                    "    nombres       varchar(100),\n" +
                    "    idactividad   varchar(25),\n" +
                    "    idlabor       varchar(25),\n" +
                    "    desclabor     varchar(50),\n" +
                    "    esrendimiento tinyint,\n" +
                    "    activo        tinyint,\n" +
                    "    fechacreacion DATETIME DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
                    "    fechaalter    DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "create table if NOT EXISTS resumenpackinguva\n" +
                    "(\n" +
                    "    fecha date,\n" +
                    "    linea int,\n" +
                    "    mode  varchar(25),\n" +
                    "    labor varchar(40),\n" +
                    "    total decimal(10, 5)\n" +
                    ");" +
                    "CREATE TABLE IF NOT EXISTS modalidad\n" +
                    "(\n" +
                    "    idempresa        VARCHAR(3)  not null,\n" +
                    "    idmodalidad      VARCHAR(15) not null,\n" +
                    "    descripcion      VARCHAR(30) NOT NULL,\n" +
                    "    descripcioncorta VARCHAR(30) NOT NULL,\n" +
                    "    firmaobligatorio SMALLINT DEFAULT 0,\n" +
                    "    activo           SMALLINT DEFAULT 1 NOT NULL,\n" +
                    "    fechacreacion    DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS areareclut\n" +
                    "(\n" +
                    "    idempresa        VARCHAR(3)  not null,\n" +
                    "    idarea           VARCHAR(25) not null,\n" +
                    "    descripcion      VARCHAR(50) NOT NULL,\n" +
                    "    descripcioncorta VARCHAR(20) NOT NULL,\n" +
                    "    esplanta         SMALLINT DEFAULT 0,\n" +
                    "    escampo          SMALLINT DEFAULT 0,\n" +
                    "    activo           SMALLINT DEFAULT 1 NOT NULL,\n" +
                    "    fechacreacion    DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS areareclutactilabor\n" +
                    "(\n" +
                    "    idempresa           VARCHAR(3)  not null,\n" +
                    "    idarea              VARCHAR(25) not null,\n" +
                    "    idareareclutamiento VARCHAR(25) not null,\n" +
                    "    descripcion         VARCHAR(50) NOT NULL,\n" +
                    "    idactivity          VARCHAR(20) NOT NULL,\n" +
                    "    actividad            VARCHAR(20) NOT NULL,\n" +
                    "    idlabor             VARCHAR(20) NOT NULL,\n" +
                    "    labor               VARCHAR(20) NOT NULL,\n" +
                    "    esplanta            SMALLINT DEFAULT 0,\n" +
                    "    escampo             SMALLINT DEFAULT 0,\n" +
                    "    activo              SMALLINT DEFAULT 1 NOT NULL,\n" +
                    "    fechacreacion       DATETIME DEFAULT (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "create table if not exists dusuariotoken\n" +
                    "(\n" +
                    "    idusuario     varchar(30),\n" +
                    "    token         varchar(5),\n" +
                    "    idconcepto    varchar(25),\n" +
                    "    fechafin      date           default current_date,\n" +
                    "    horafin       datetime       default current_date,\n" +
                    "    latitud       decimal(10, 6) default 0.0,\n" +
                    "    longitud      decimal(10, 6) default 0.0,\n" +
                    "    imei          varchar(30),\n" +
                    "    activo        tinyint        DEFAULT 1,\n" +
                    "    fechacreacion datetime       DEFAULT (datetime(current_timestamp, 'localtime')) NOT NULL\n" +
                    ");\n" +
                    "create table if not exists topworker\n" +
                    "(\n" +
                    "    idtrabajador     varchar(20),\n" +
                    "    nombresall       varchar(200),\n" +
                    "    categoria    varchar(50) \n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS asistenciacheckcas\n" +
                    "(\n" +
                    "    iddatabase      VARCHAR(25) NOT NULL,\n" +
                    "    idempresa       varCHAR(3)  DEFAULT '001' NOT NULL,\n" +
                    "    sede             varchar(100),\n" +
                    "    idpuntoentrada   varchar(100),\n" +
                    "    idtareo         varchar(50) DEFAULT '',\n" +
                    "    idtrabajador    VARCHAR(20) DEFAULT '',\n" +

                    "    iniciocas       TIME        DEFAULT '00:00:00',\n" +
                    "    iniciobus       TIME        DEFAULT '00:00:00',\n" +
                    "    inicioreal      TIME        DEFAULT '00:00:00',\n" +
                    "    iniciomotivo     varchar(100)        DEFAULT '',\n" +

                    "    fincas           TIME        DEFAULT '00:00:00',\n" +
                    "    finbus           TIME        DEFAULT '00:00:00',\n" +
                    "    finreal          TIME        DEFAULT '00:00:00',\n" +
                    "    finmotivo       varchar(100)        DEFAULT '',\n" +

                    "    ajuste         SMALLINT    DEFAULT 0 NOT NULL,\n" +
                    "    activo         SMALLINT    DEFAULT 1 NOT NULL,\n" +
                    "    fechacreacion  DATETIME    DEFAULT (datetime(current_timestamp, 'localtime')), \n" +
                    "    isfinbus         SMALLINT    DEFAULT 0 NULL \n" +
                    ");\n" +
                    "create table if not exists asistenciacas\n" +
                    "(\n" +
                    "    iddatabase      varchar(25) default 'AGROVISIONCORP',\n" +
                    "    idempresa       varchar(5)  default '',\n" +
                    "    idtiporegistro  varchar(100),\n" +
                    "    idtipomarcacion varchar(100),\n" +
                    "    sede            varchar(100),\n" +
                    "    idpuntoentrada  varchar(100),\n" +
                    "    fecha           date,\n" +
                    "    hora            time,\n" +
                    "    idplanilla      varchar(10),\n" +
                    "    idtrabajador    varchar(20),\n" +
                    "    activo          SMALLINT     default 1\n" +
                    ");\n" +
                    "create table if not exists frecuenciamotivotrabajo\n" +
                    "(\n" +
                    "    id varchar(15) primary key,\n" +
                    "    descripcion varchar(200),\n" +
                    "    idtipo varchar(15),\n" +
                    "    activo tinyint default 1,\n" +
                    "    observaciones text,\n" +
                    "    fechacreacion datetime(0) default (datetime(current_timestamp, 'localtime')),\n" +
                    "    fechaalteracion datetime(0) default (datetime(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "create table if not exists unidadavance\n" +
                    "(\n" +
                    "    idunidadavance  VARCHAR(50) default '',\n" +
                    "    descripcionsingular varchar(50) default '',\n" +
                    "    descripcionplural  varchar(50) default '',\n" +
                    "    idpadre          varchar(50) default '',\n" +
                    "    codigo          varchar(50) default ''\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS RefrigerioTareo \n" +
                    "(\n" +
                    "  idrefrigerio           VARCHAR(15) NOT NULL,\n" +
                    "  iddatabase        VARCHAR(25) NOT NULL,\n" +
                    "  idempresa         CHAR(3)     NOT NULL,\n" +
                    "  idtareo           VARCHAR(15) NOT NULL    REFERENCES tareo,\n" +
                    "  inicioref          TIME        NULL,\n" +
                    "  finref          TIME        NULL,\n" +
                    "  diasig              SMALLINT DEFAULT 0,\n" +
                    "  eslocal              SMALLINT DEFAULT 0, \n" +
                    "  activo              SMALLINT DEFAULT 0\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS HorariosRefrigeriosCloud \n" +
                    "(\n" +
                    "  idhorario           VARCHAR(15) NOT NULL,\n" +
                    "  idtipohorario      CHAR(3)     NOT NULL,\n" +
                    "  iddatabase        VARCHAR(25) NOT NULL,\n" +
                    "  idempresa         CHAR(3)     NOT NULL,\n" +
                    "  inicio          TIME        NULL,\n" +
                    "  dsgte              SMALLINT DEFAULT 0,\n" +
                    "  fin          TIME        NULL,\n" +
                    "  idtipoplanilla         CHAR(1)     NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS regimenCompensacion \n" +
                    "(\n" +
                    "  iddatabase        VARCHAR(25) NOT NULL,\n" +
                    "  idempresa         CHAR(3)     NOT NULL,\n" +
                    "  idregimen           VARCHAR(25) NOT NULL,\n" +
                    "  descripcion           VARCHAR(25) NOT NULL,\n" +
                    "  activo               tinyint default 1,\n" +
                    "  editable               tinyint default 0,\n" +
                    "  vdefecto        DECIMAL(15, 2)  DEFAULT 0.0, \n" +
                    "  fechacreacion        DATETIME     DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
                    "  fechaalter           DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime'))\n" +
                    ");\n" +
                    "CREATE TABLE IF NOT EXISTS programacionMO \n" +
                    "(\n" +
                    "  iddprogramacion        VARCHAR(25) NOT NULL,\n" +
                    "  idtipoplanilla         VARCHAR(25)     NOT NULL,\n" +
                    "  regimen           VARCHAR(25) NOT NULL,\n" +
                    "  dni           VARCHAR(10)  NOT NULL,\n" +
                    "  anio               SMALLINT        DEFAULT 1995 ,\n" +
                    "  semana        VARCHAR(2)  NOT NULL,\n" +
                    "  inicio          TIME        NULL,\n" +
                    "  fin          TIME        NULL,\n" +
                    "  fechacreacion        DATETIME     DEFAULT (datetime(current_timestamp, 'localtime')),\n" +
                    "  fechaalter           DATETIME        DEFAULT (DATETIME(current_timestamp, 'localtime'))\n" +
                    ");"
    ).split(";");

}







