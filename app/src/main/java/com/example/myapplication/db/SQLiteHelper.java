package com.example.myapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.database.JSQLiteHelper;
import com.example.library.jother.jdir;
import com.example.myapplication.utils.others.files;
import com.example.myapplication.utils.others.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SQLiteHelper extends JSQLiteHelper {
    public static int versionDB = 206;


    private Context context;
    public List<String> TABLAS;
    public SQLiteHelper(Context context) {
        super(context, jdir.pathPrincipal((AppCompatActivity) context) + files.DIR_DB_FINAL, versionDB);
        //jmethods.imprimir("SQLiteHelper: " + jdir.pathPrincipal((AppCompatActivity) context) + files.DIR_DB_FINAL);
        this.context = context;
    }

    public int getTableCount() {
        int tableCount = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (cursor != null) {
            tableCount = cursor.getCount();
            cursor.close();
        }
        return tableCount;
    }


    public String getTableNames() {
        StringBuilder tableNamesBuilder = new StringBuilder();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        // Retrieve table name from the cursor
                        String tableName = cursor.getString(0);

                        // Append the table name to the StringBuilder
                        tableNamesBuilder.append(tableName).append(", ");
                    } while (cursor.moveToNext());
                }
            } finally {
                // Close the cursor to avoid resource leaks
                cursor.close();
            }
        }

        // Remove the trailing comma and space
        int length = tableNamesBuilder.length();
        if (length > 2) {
            tableNamesBuilder.setLength(length - 2);
        }

        return tableNamesBuilder.toString();
    }


    public void reQuery(SQLiteDatabase db) {
        TABLAS = new ArrayList<>();
        TABLAS.addAll(Arrays.asList(sql.tablas));
        TABLAS.addAll(Arrays.asList(sql.tablas2));
        //jmethods.imprimir("TAM TABLAS = " + TABLAS.size());
        try {
            for (int i = 0; i < TABLAS.size(); i++) {
              //  jmethods.imprimir(TABLAS.get(i));
                db.execSQL(TABLAS.get(i));
            }
        } catch (Exception e) {
            //jmethods.imprimir(Arrays.toString(e.getStackTrace()).replace(",", "\n"));
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        reQuery(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //jmethods.imprimir("=======> UPGRADE BD: " + versionAnterior + " VS " + versionNueva);
        if (versionAnterior < versionNueva) {
            db.beginTransaction();
            try {
                if (versionAnterior < 111) {
                    db.execSQL("ALTER TABLE destinoreclutamiento ADD COLUMN departamento varchar(100) default '' not null;");
                    db.execSQL("ALTER TABLE destinoreclutamiento ADD COLUMN provincia varchar(100) default '' not null;");
                    db.execSQL("ALTER TABLE destinoreclutamiento ADD COLUMN distrito varchar(100) default '' not null;");
                }
                if (versionAnterior < 115)
                    db.execSQL("ALTER TABLE viaje ADD COLUMN qr2 TEXT default '' not null;");
                if (versionAnterior < 117) db.execSQL("drop table conductor;");
                if (versionAnterior < 131)
                    db.execSQL("ALTER TABLE ddcosecha ADD COLUMN historialgps text default '' not null;");
                if (versionAnterior < 137) {
                    db.execSQL("ALTER TABLE tareo ADD COLUMN iniciorefdia time default '00:00:00';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN finrefdia time default '00:00:00';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN iniciorefnoc time default '00:00:00';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN finrefnoc time default '00:00:00';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN datareclamos text default '';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN idsupervisor varchar(10) default '' ;");
                    db.execSQL("ALTER TABLE dtareo ADD COLUMN idsupervisor varchar(10) default '';");
                }
                if (versionAnterior < 138) {
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN modocp varchar(10) default '';");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN direccion varchar(200) default '';");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN tallacasaca tinyint default 0;");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN tallabota tinyint default 0;");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN experiencia tinyint default 0;");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN idareareclutamiento varchar(10) default '';");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN idactilabor varchar(30) default '';");
                }
                if (versionAnterior < 139) db.execSQL("drop table trabajador;");
                if (versionAnterior < 143) db.execSQL("drop table responsable;");
                if (versionAnterior < 147) {
                    db.execSQL("drop table asistenciareclutamiento;");
                    db.execSQL("ALTER TABLE asistenciatransporte ADD COLUMN estatus2 varchar(3) default 'SUB';");
                    db.execSQL("ALTER TABLE asistenciatransporte ADD COLUMN idparadero varchar(30) default '';");
                    db.execSQL("ALTER TABLE asistenciatransporte ADD COLUMN tipo varchar(5);");
                }
                if (versionAnterior < 149) {
                    db.execSQL("ALTER TABLE personal_observado ADD COLUMN tipo varchar(5);");
                }
                if (versionAnterior < 151) {
                    db.execSQL("ALTER TABLE asistencia ADD COLUMN TIPO varchar(10);");
                }
                if (versionAnterior < 158) {
                    db.execSQL("ALTER TABLE ddcosecha ADD COLUMN linea DECIMAL(15, 2);");
                }
                if (versionAnterior < 175) {
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN idfrecuencia varchar(10) default '';");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN idmotivo varchar(10) default '';");
                    db.execSQL("ALTER TABLE asistenciareclutamiento ADD COLUMN motivodetalle varchar(250) default '';");
                }
                if (versionAnterior < 182) {
                    db.execSQL("ALTER TABLE asistenciacheckcas ADD COLUMN isfinbus SMALLINT default 0 ;");
                }
                if (versionAnterior < 191) {
                    db.execSQL("ALTER TABLE cosechalabor ADD COLUMN idunidadavancepadre varchar(50) default '' ;");
                    db.execSQL("ALTER TABLE cosechalabor ADD COLUMN idunidadavancehijo varchar(50) default '' ;");
                    db.execSQL("ALTER TABLE cosechalabor ADD COLUMN cantidad decimal(10,2) default 0.0 ;");
                    db.execSQL("ALTER TABLE empaque ADD COLUMN idunidadavance varchar(50) default '' ;");
                }
                if (versionAnterior < 191) {
                    db.execSQL("ALTER TABLE tareo ADD COLUMN fin TIME default '';");
                }
                if (versionAnterior < 185) {
                    db.execSQL("ALTER TABLE refrigeriotareo ADD COLUMN activo SMALLINT default 0;");
                }
                if (versionAnterior < 192) {
                    db.execSQL("ALTER TABLE tareo ADD COLUMN iniciox TIME default '';");
                    db.execSQL("ALTER TABLE tareo ADD COLUMN finx TIME default '';");
                }
                if (versionAnterior < 195) {
                    db.execSQL("ALTER TABLE ddtareo ADD COLUMN idregimen VARCHAR(25) default '' not null;");
                    db.execSQL("ALTER TABLE ddtareo ADD COLUMN iddprogramacion VARCHAR(25) default '' not null;");
                }
                if (versionAnterior < 205) {
                    db.execSQL("ALTER TABLE ddtareo RENAME TO ddtareox;");
                    db.execSQL("CREATE TABLE IF NOT EXISTS ddtareo (\n" +
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
                            "  idregimen       VARCHAR(25) default '',\n" +
                            "  iddprogramacion       VARCHAR(25) default ''\n" +
                            ");");
                    db.execSQL("INSERT INTO ddtareo (idtareo, iddatabase, idempresa, linea, mesa, itemid, item, idtrabajador, estatus, esjornal, esrendimiento, fecha, inicio, iniciorefrigerio, finrefrigerio, fin, asistio, jornal, rendimiento, avance, jornalextra, rendimientoextra, conceptobono, bono, agregado1, agregado2, idmotivo, latitud, longitud, fechacreacion, observaciones, diasiguiente, t_comp, h_comp, idregimen, iddprogramacion)\n"+
                    "SELECT idtareo, iddatabase, idempresa, linea, mesa, itemid, item, idtrabajador, estatus, esjornal, esrendimiento, fecha, inicio, iniciorefrigerio, finrefrigerio, fin, asistio, jornal, rendimiento, avance, jornalextra, rendimientoextra, conceptobono, bono, agregado1, agregado2, idmotivo, latitud, longitud, fechacreacion, observaciones, diasiguiente, t_comp, h_comp, idregimen, iddprogramacion \n"+
                    "FROM ddtareox;");
                    db.execSQL("DROP TABLE ddtareox;");
                }
                if (versionAnterior < 206) {
                    db.execSQL("ALTER TABLE cosechalabor RENAME TO cosechalaborx;");
                    db.execSQL("CREATE TABLE IF NOT EXISTS cosechalabor (\n" +
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
                            ");");
                    db.execSQL("INSERT INTO cosechalabor (iddatabase, idempresa, idcosechalabor, descripcion, descripcion_corta, idcultivo, idactividad, idlabor, idunidadavancepadre, idunidadavancehijo, cantidad, esrendimiento, meta, costo, observaciones, activo, fechacreacion)\n"+
                            "SELECT iddatabase, idempresa, idcosechalabor, descripcion, descripcion_corta, idcultivo, idactividad, idlabor, idunidadavancepadre, idunidadavancehijo, cantidad, esrendimiento, meta, costo, observaciones, activo, fechacreacion \n"+
                            "FROM cosechalaborx;");
                    db.execSQL("DROP TABLE cosechalaborx;");
                }
            } catch (Exception ex) {
            }
            reQuery(db);
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        super.onUpgrade(db, versionAnterior, versionNueva);
    }

}




