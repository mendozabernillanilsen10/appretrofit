package com.example.myapplication.db;



/**
 * Created by Asus on 02/02/2018.
 */

public class QueryTareo {


    public static String asistenciamov = "SELECT\n" +
            "  fecha,\n" +
            "  estatus,\n" +
            "  count(DISTINCT placa) cantidad\n" +
            "FROM asistenciavehiculo\n" +
            "WHERE fecha = '@fecha' and activo=1 \n" +
            "GROUP BY fecha, estatus;";

    public static String asistencia =
            "SELECT ifnull( asi.fecha , ?3 )                                                                                                               fecha,\n" +
                    "       strftime( '%W' , asi.fecha )                                                                                                           semana,\n" +
                    "       (SELECT count( 1 ) FROM asistencia WHERE fecha = asi.fecha AND ing_motivo = 'ACTIVO' AND activo = 1 and tipo=asi.tipo)         ing,\n" +
                    "       (SELECT count( 1 ) FROM asistencia WHERE fecha = asi.fecha AND ing_motivo = 'NUEVO' AND activo = 1 and tipo=asi.tipo)          nuevo,\n" +
                    "       (SELECT count( 1 ) FROM asistencia WHERE fecha = asi.fecha AND length( susp_motivo ) > 1 AND activo = 1 and tipo=asi.tipo) incidentes,\n" +
                    "       count( asi.idtrabajador )                                                                                                              total,\n" +
                    "       ifnull( asi.activo , 0 )                                                                                                               estado,\n" +
                    "       asi.tipo estatus\n" +
                    //"       asi.estatus\n" +
                    "FROM asistencia asi\n" +
                    "WHERE asi.iddatabase = ?1\n" +
                    "  AND asi.idempresa = ?2\n" +
                    "  AND asi.fecha = ?3\n" +
                    "  AND asi.idusuario = ?4\n" +
                    "  AND asi.activo = 1\n" +
                    "GROUP BY ifnull( asi.fecha , ?3 ), strftime( '%W' , asi.fecha ), ifnull( asi.activo , 0 ), asi.tipo";
                    //"GROUP BY ifnull( asi.fecha , ?3 ), strftime( '%W' , asi.fecha ), estatus, ifnull( asi.activo , 0 ), asi.estatus;";


    public static String asistenciabyjournal =
            "select ifnull(fecha, current_date) fecha,\n" +
                    "       strftime('%W', PRI.fecha)   semana,\n" +
                    "       (select count(1)\n" +
                    "        from asistenciabyjornal\n" +
                    "        where estatus = 'ING'\n" +
                    "          and fecha = PRI.fecha\n" +
                    "          and motivo = 'ACTIVO'\n" +
                    "          and activo = 1)          ing,\n" +
                    "       (select count(1)\n" +
                    "        from asistenciabyjornal\n" +
                    "        where motivo = 'NUEVO'\n" +
                    "          and estatus = 'ING'\n" +
                    "          and fecha = PRI.fecha\n" +
                    "          and activo = 1)          nuevo,\n" +
                    "       (select count(1)\n" +
                    "        from asistenciabyjornal\n" +
                    "        where estatus = 'DET'\n" +
                    "          and fecha = PRI.fecha\n" +
                    "          and activo = 1)          incidentes,\n" +
                    "       count(1)                    total,\n" +
                    "       activo\n" +
                    "from asistenciabyjornal PRI\n" +
                    "where PRI.fecha = ?1\n" +
                    "  and PRI.activo = 1;";

    public static String asistenciaprov = "select ifnull(fecha, ?5)                                                                                                      fecha,\n" +
            "       strftime('%W', current_date)                                                                                                     semana,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where estatus = 'ING' and iddatabase=?1 and idempresa=?2 and idtransportista=?3 and placa=?4  and fecha = ?5  and activo = 1)                        ingresos,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where idplanilla = 'NEW' and estatus = 'DET' and iddatabase=?1 and idempresa=?2 and idtransportista=?3 and placa=?4  and fecha = ?5 and activo = 1) nuevo,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where estatus = 'DET'    and iddatabase=?1 and idempresa=?2 and idtransportista=?3 and placa=?4  and fecha = ?5 and activo = 1  and idplanilla <> 'NEW')                        incidentes,\n" +
            "       count(distinct idtrabajador)                                                                                                                         total,\n" +
            "       activo\n" +
            "from asistenciatransporte\n" +
            "where iddatabase = ?1\n" +
            "  and idempresa = ?2\n" +
            "  and idtransportista = ?3\n" +
            "  and placa = ?4\n" +
            "  and fecha = ?5\n" +
            "  and activo = 1";

    public static String asistenciaAllWeekProv = "SELECT ifnull( at.fecha , ?5)                              fecha,\n" +
            "     ifnull(vi.numero,'') viaje,    " +
            "     at.idprocedencia                                                                          procedencia,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and estatus = 'ING' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 and idprocedencia=at.idprocedencia)                         ingresos,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and idplanilla = 'NEW' AND estatus = 'DET' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 and idprocedencia=at.idprocedencia)  nuevo,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and estatus = 'DET' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 AND idplanilla <> 'NEW' and idprocedencia=at.idprocedencia) incidentes,\n" +
            "       count( distinct idtrabajador)                                                                                                                                                                                                                                                 total\n" +
            " FROM asistenciatransporte at" +
            " left join viaje vi on vi.idviaje=at.idviaje\n" +
            " WHERE at.iddatabase = ?1\n" +
            "  AND at.idempresa = ?2\n" +
            "  AND at.idtransportista = ?3\n" +
            "  AND at.placa = ?4\n" +
            "  AND strftime( '%W' , at.fecha ) = strftime( '%W' , ?5 )\n" +
            "  AND at.activo >= 2\n" +
            "GROUP BY ifnull( at.fecha , ?5),vi.numero, at.idprocedencia;";


    public static String asistenciaByDay = "SELECT ifnull( at.fecha , ?5)                              fecha,\n" +
            "     ifnull(vi.numero,'') viaje,    " +
            "     at.idprocedencia                                                                          procedencia,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and estatus = 'ING' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 and idprocedencia=at.idprocedencia)                         ingresos,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and idplanilla = 'NEW' AND estatus = 'DET' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 and idprocedencia=at.idprocedencia)  nuevo,\n" +
            "       (SELECT count( distinct idtrabajador ) FROM asistenciatransporte WHERE idviaje=at.idviaje and estatus = 'DET' AND iddatabase = at.iddatabase AND idempresa = at.idempresa AND idtransportista = at.idtransportista AND placa = at.placa AND fecha = at.fecha AND activo >= 2 AND idplanilla <> 'NEW' and idprocedencia=at.idprocedencia) incidentes,\n" +
            "       count( distinct idtrabajador)                                                                                                                                                                                                                                                 total\n" +
            " FROM asistenciatransporte at" +
            " left join viaje vi on vi.idviaje=at.idviaje\n" +
            " WHERE at.iddatabase = ?1\n" +
            "  AND at.idempresa = ?2\n" +
            "  AND at.idtransportista = ?3\n" +
            "  AND at.placa = ?4\n" +
            "  AND at.fecha = ?5\n" +
            "  AND at.activo >= 2 " +
            "  and at.idasistencia like ?6 " +
            "  and at.estatus2=?7 " +
            "GROUP BY ifnull( at.fecha , ?5),vi.numero, at.idprocedencia;";

    public static String viajes_allWeek = "select idviaje,\n" +
            "       numero,\n" +
            "       procedencia,\n" +
            "       idvehiculo,\n" +
            "       idestado,\n" +
            "       qr,\n" +
            "       qr2," +
            "       fechacreacion\n" +
            " from viaje\n" +
            " where iddatabase = ?1\n" +
            "  and idempresa = ?2\n" +
            "  and fecha = ?3\n" +
            "  and idvehiculo = ?4\n" +
            "  and idconductor = ?5;";

    public static String asistenciaAllWeek = "select ifnull(a.fecha, current_date)  fecha,\n" +
            "       strftime('%W', a.fecha)        semana,\n" +
            "       (select count(1)\n" +
            "        from asistencia\n" +
            "        where estatus = 'ING'\n" +
            "          and fecha = a.fecha \n" +
            "          and ing_motivo = 'ACTIVO'\n" +
            "          and activo = 1)           ing,\n" +
            "       (select count(distinct a1.idtrabajador)\n" +
            "        from asistencia a1\n" +
            "        where a1.ing_motivo = 'NUEVO'\n" +
            "          and a1.estatus = 'ING'\n" +
            "          and a1.fecha = a.fecha\n" +
            "          and a1.activo = a.activo)   nuevo,\n" +
            "       (select count(distinct a1.idtrabajador)\n" +
            "        from asistencia a1\n" +
            "        where a1.estatus = 'DET'\n" +
            "          and a1.fecha = a.fecha\n" +
            "          and a1.activo = a.activo)   incidentes,\n" +
            "       count(distinct a.idtrabajador) total,\n" +
            "       a.activo\n" +
            "from asistencia a\n" +
            "where strftime('%W', a.fecha) = strftime('%W', current_date)\n" +
            "group by a.fecha, a.activo;\n";


    public static String cisprov_reporetesemanal = "select fecha,\n" +
            "       placa,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where fecha=at.fecha and estatus = 'ING' and activo >= 1) ING,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where fecha=at.fecha and estatus = 'DET' and activo >= 1) DET,\n" +
            "       count(distinct idtrabajador)                                                                                                   total\n" +
            "from asistenciatransporte at\n" +
            "where at.activo >= 1\n" +
            "  and strftime('%W', at.fecha) = strftime('%W', ?1)" +
            "  and idtransportista=?2 and idempresa=?3 and placa=?4\n" +
            "group by at.fecha, at.placa;";

    public static String cisprov_reporetesemanalnew = "select fecha,\n" +
            "       placa,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where fecha=at.fecha and estatus = 'ING' and activo >= 1) ING,\n" +
            "       (select count(distinct idtrabajador) from asistenciatransporte where fecha=at.fecha and estatus = 'DET' and activo >= 1) DET,\n" +
            "       count(distinct idtrabajador)                                                                                                   total\n" +
            "from asistenciatransporte at\n" +
            "where at.activo >= 1\n" +
            "  and strftime('%W', at.fecha) = strftime('%W', ?1)" +
            "  and idtransportista=?2 and idempresa=?3 and placa=?4\n" +
            "group by at.fecha, at.placa;";

    public static String nuevaDistribucion_listaTrabajadores = "";

    public static String DialogDTareo_Report = "" +
            "SELECT\n" +
            "  T3.item,\n" +
            "  T3.idtrabajador,\n" +
            "  ifnull(trab.nombresall, 'Trabajador no Encontrado') nombres,\n" +
            "  T3.jornal,\n" +
            "  T3.agregado1                                           jornalnocturno,\n" +
            "  T3.jornalextra,\n" +
            "  T3.jornalextra + T3.jornal + T3.agregado1           totalhoras,\n" +
            "  T3.avance,\n" +
            "  T3.rendimiento,\n" +
            "  T3.inicio,\n" +
            "  T3.fin\n" +
            "FROM ddtareo T3\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T3.idtareo\n" +
            "  LEFT JOIN trabajador trab ON trab.idtrabajador = T3.idtrabajador AND trab.iddatabase = T3.iddatabase AND tar.idplanilla = trab.idplanilla and trab.idempresa=t3.idempresa\n" +
            "WHERE T3.idtareo = '@idtareo' AND itemid = '@item' AND T3.iddatabase = '@iddatabase'\n" +
            "ORDER BY nombres desc;";

    //<editor-fold defaultstate="collapsed" desc="TareoConsolidado">
    public static String Consolidado_Trabajadores = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "  SUM(T1.jornal + T1.agregado1 + T1.jornalextra)      HORAS,\n" +
            "  SUM(T1.avance)                                      AVANCE,\n" +
            "  SUM(T1.rendimiento)                                 REND\n" +
            "FROM ddtareo T1\n" +
            "  inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and t2.idempresa=tar.idempresa and t2.iddatabase=tar.iddatabase" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND\n" +
            "                               T1.iddatabase = TRAB.iddatabase AND\n" +
            "                               t1.idempresa = trab.idempresa AND\n" +
            "                               tar.idplanilla = trab.idplanilla\n" +
            " WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP') \n" +
            " GROUP BY T1.idtrabajador\n" +
            " ORDER BY TRAB.nombresall;";
    public static String subtareos_horasxcompensar = "Select DNI, nombres, SUM(HORAS) HORAS, SUM(HORAS_COMPENSAR) HORAS_COMPENSAR, SUM(REND) REND from ( SELECT \n" +
            "  T1.idtrabajador DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "   (T1.jornal + T1.agregado1 + T1.jornalextra)  HORAS,\n" +
            "   (hc.jornal_compens) HORAS_COMPENSAR,\n" +
            "   (T1.rendimiento) REND\n" +
            "FROM ddtareo T1 inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and t2.idempresa=tar.idempresa and t2.iddatabase=tar.iddatabase \n" +
            "  LEFT JOIN ddtareo_hcomp hc ON hc.idtareo = T1.idtareo and T1.itemid=hc.itemid and T1.idempresa=hc.idempresa and T1.iddatabase=hc.iddatabase and t1.idtrabajador = hc.idtrabajador \n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase AND t1.idempresa = trab.idempresa AND tar.idplanilla = trab.idplanilla\n" +
            " WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP') and t2.item = '@item' and T1.t_comp = 0 \n" +
            " UNION \n" +
            " SELECT\n" +
            "  T1.idtrabajador DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado')  nombres,\n" +
            "  0.00 HORAS,\n" +
            "  (T1.jornal + T1.agregado1 + T1.jornalextra) HORAS_COMPENSAR,\n" +
            "  (T1.rendimiento) REND\n" +
            "FROM ddtareo T1 inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and t2.idempresa=tar.idempresa and t2.iddatabase=tar.iddatabase \n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase AND t1.idempresa = trab.idempresa AND tar.idplanilla = trab.idplanilla\n" +
            " WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP') and t2.item = '@item' and T1.t_comp = 1 \n" +
            "  ) as D\n" +
            " GROUP BY D.DNI\n" +
            " ORDER BY D.nombres;";

    public static String tareo_horasxcompensar = "Select DNI, nombres, SUM(HORAS) HORAS, SUM(HORAS_COMPENSAR) HORAS_COMPENSAR, SUM(REND) REND from ( " +
            "SELECT \n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "   CASE t1.t_comp WHEN  1 THEN 0 WHEN  0 THEN (T1.jornal + T1.agregado1 + T1.jornalextra) ELSE 0 END       HORAS,\n" +
            "   CASE t1.t_comp WHEN  1 THEN (T1.jornal + T1.agregado1 + T1.jornalextra) WHEN  0 THEN t1.h_comp ELSE 0 END                              HORAS_COMPENSAR,\n" +
            "   (T1.rendimiento)                                 REND\n" +
            "FROM ddtareo T1\n" +
            "  inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and t2.idempresa=tar.idempresa and t2.iddatabase=tar.iddatabase \n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase AND t1.idempresa = trab.idempresa AND tar.idplanilla = trab.idplanilla\n" +
            " WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP')\n" +
            "  ) as D\n" +
            " GROUP BY D.DNI\n" +
            " ORDER BY D.nombres;";

    public static String tareo_listaregimen5x2 ="  select  t.DNI,t.nombres, t.HORAS,\n" +
            "                      t.HORAS_COMPENSAR,\n" +
            "                     t.REND  from (select t1.idtrabajador DNI, ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres, sum(CASE t1.t_comp WHEN  1 THEN 0 WHEN  0 THEN (T1.jornal + T1.agregado1 + T1.jornalextra) ELSE 0 END )      HORAS,\n" +
            "               sum(CASE t1.t_comp WHEN  1 THEN (T1.jornal + T1.agregado1 + T1.jornalextra) WHEN  0 THEN t1.h_comp ELSE 0 END )                             HORAS_COMPENSAR,\n" +
            "               sum (T1.rendimiento)                                 REND FROM ddtareo T1\n" +
            "        inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
            "        INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and t2.idempresa=tar.idempresa and t2.iddatabase=tar.iddatabase \n" +
            "        LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase AND t1.idempresa = trab.idempresa AND tar.idplanilla = trab.idplanilla\n" +
            "        INNER JOIN programacionMO mo on mo.dni = t1.idtrabajador \n" +
            "        INNER JOIN REGIMENCOMPENSACION rc on rc.idregimen = mo.regimen  and  rc.idempresa = tar.idempresa and rc.iddatabase = tar.iddatabase\n" +
            "          WHERE T1.idtareo = '@idtareo' AND T1.iddatabase = '@iddatabase' AND T1.idempresa = '@idempresa'  AND t2.idestado in ('PE','AP') AND tar.fecha between mo.inicio and mo.fin and mo.regimen='5x2' \n" +
            "          group by t1.idtrabajador\n" +
            "    ORDER BY TRAB.nombres ) AS t where  HORAS_COMPENSAR = 0  \n";

    public static String Consolidado_TrabajadoresGeneral = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "  SUM(T1.jornal + T1.agregado1 + T1.jornalextra)      HORAS,\n" +
            "  SUM(T1.avance)                                      AVANCE,\n" +
            "  SUM(T1.rendimiento)                                 REND " +
            "FROM ddtareo T1\n" +
            "   inner joon dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item " +
            "   INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and tar.iddatabase=t2.iddatabase and tar.idempresa=t2.idempresa \n" +
            "   LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND\n" +
            "                               T1.iddatabase = TRAB.iddatabase AND\n" +
            "                               t1.idempresa = trab.idempresa AND\n" +
            "                               tar.idplanilla = trab.idplanilla\n" +
            " WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP') \n" +
            " GROUP BY T1.idtrabajador\n" +
            " ORDER BY TRAB.nombresall;";

    public static String Resumen_tareo = "select trim(l.descripcion) labor, trim(c.descripcion) consumidor, count(t3.item) total_trab, avg(t3.jornal) prom_jornal\n" +
            "from ddtareo t3\n" +
            "       inner join dtareo t2 on t2.idtareo = t3.idtareo and t2.item = t3.itemid\n" +
            "       left join actividad a on a.idactividad = t2.idactividad and a.idempresa = t2.idempresa\n" +
            "       left join labor l on a.idactividad = l.idactividad and l.idlabor = t2.idlabor and t2.idempresa = l.idempresa\n" +
            "       left join consumidor c on c.idconsumidor = t2.idconsumidor and c.idempresa = t2.idempresa\n" +
            " where t3.idtareo = '@idtareo' and t2.idactividad='@idactividad' and t2.idestado in ('PE','AP') \n" +
            " group by t2.idactividad, a.descripcion, t2.idlabor, l.descripcion, t2.idconsumidor\n" +
            " order by t2.idactividad, t2.idlabor;\n";

    public static String Resumen_ProduccionPackingUva =
            " select ifnull(m.mode,dt.mode) mode,ifnull(m.desclabor,l.descripcion) labor,count(1) t\n" +
                    "     from ddtareopacking dt\n" +
                    "            left join movtrabetiquetapacking m on dt.idempresa = m.idempresa and trim(m.code)=trim(substr(dt.etiqueta,0,7))\n" +
                    "            left join labor l on dt.idactividad=l.idactividad and dt.idlabor=l.idlabor and dt.idempresa=l.idempresa\n" +
                    " where dt.idempresa = ?1\n" +
                    " and dt.idtareo = ?2 and dt.activo in (1,2)\n" +
                    " group by ifnull(m.mode,dt.mode),ifnull(m.desclabor,l.descripcion)\n" +
                    " order by labor;";


    public static String detalleTrabajador=
            "SELECT t1.itemid                      ITEMID,\n" +
                    "                              T1.item                ITEM,\n" +
                    "                              t1.idtrabajador,\n" +
                    "                             ifnull(trab.nombresall,'DESCONOCIDO')   NOMBRE, \n" +
                    "                              t1.inicio,\n" +
                    "                              t1.iniciorefrigerio,\n" +
                    "                              (T1.jornal + t1.jornalextra + t1.agregado1) HORAS,\n" +
                    "                              t1.finrefrigerio,\n" +
                    "                              t1.fin,\n" +
                    "                              t1.h_comp hxc,\n" +
                    "                              TIME(t1.fin, '+'||h_comp||' hours') fin_hxc,\n" +
                    "                              t1.diasiguiente,\n" +
                    "                              t1.jornal            DIU,\n" +
                    "                              t1.agregado1    NOC,\n" +
                    "                              (T1.avance)                                 AVANCE,\n" +
                    "                             (T1.rendimiento)                            REND,\n" +
                    "                             T2.idconsumidor                                IDCONSUMIDOR,\n" +
                    "                              CONS.descripcion                               CONSUMIDOR,\n" +
                    "                             T2.idactividad                                       IDACTIVIDAD,\n" +
                    "                             A.descripcion                                      ACTIVIDAD,\n" +
                    "                             T2.idlabor                                             IDLABOR,\n" +
                    "                             L.descripcion                                       LABOR\n" +

                    "    FROM ddtareo T1\n" +
                    "                             INNER JOIN tareo tar ON tar.idtareo = T1.idtareo\n" +
                    "                             INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase AND t2.idempresa = t1.idempresa\n" +
                    "                             LEFT JOIN TRABAJADOR TRAB on T1.iddatabase = trab.iddatabase and T1.idempresa=trab.idempresa and t1.idtrabajador=TRAB.idtrabajador\n" +
                    "                             LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase AND cons.idempresa = t2.idempresa\n" +
                    "                             LEFT JOIN actividad A on T2.iddatabase = A.iddatabase and T2.idempresa=A.idempresa and t2.idactividad=a.idactividad\n" +
                    "                             LEFT JOIN labor L on T2.iddatabase=L.iddatabase and T2.idempresa=L.idempresa and T2.idactividad=L.idactividad and T2.idlabor=L.idlabor\n" +
                    "                             WHERE T1.idtareo = '@idtareo' AND T1.avance = 0 AND T1.iddatabase LIKE '@iddatabase%'  and t2.idestado in ('PE','AP') \n" +
                    "   ORDER BY T1.idtrabajador asc, T1.diasiguiente asc, T1.inicio asc";


    public static String Consolidado_TrabConsumidor = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "  T2.idconsumidor                                     IDCONSUMIDOR,\n" +
            "  CONS.descripcion                                    CONSUMIDOR,\n" +
            "  SUM(T1.jornal + t1.jornalextra + t1.agregado1)      HORAS,\n" +
            "  SUM(T1.avance)                                      AVANCE,\n" +
            "  SUM(T1.rendimiento)                                 REND " +
            " FROM ddtareo T1\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T1.idtareo\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase AND t2.idempresa = t1.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase AND cons.idempresa = t2.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND t1.idempresa = trab.idempresa AND trab.idplanilla = tar.idplanilla\n" +
            "   WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' and t2.idestado in ('PE','AP') \n" +
            "   GROUP BY nombres,T2.item\n" +
            "   ORDER BY nombres;";


    public static String Consolidado_bonoConsumidor = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "  T2.idconsumidor                                     IDCONSUMIDOR,\n" +
            "  CONS.descripcion                                    CONSUMIDOR,\n" +
            "  co.idconcepto                                       idconcepto,\n" +
            "  ifnull(co.descripcion, 'Concepto no Encontrado')    concepto,\n" +
            "  SUM(T1.bono)                                      BONOS\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T1.idtareo\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t2.idempresa=t1.idempresa\n" +
            "  INNER JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t2.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador and t1.idempresa=trab.idempresa and trab.idplanilla=tar.idplanilla\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T1.conceptobono)) and co.idempresa=t1.idempresa\n" +
            "   WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' AND bono > 0 and t2.idestado in ('PE','AP') \n" +
            "   GROUP BY CONS.idconsumidor, TRAB.idtrabajador, co.idconcepto, co.descripcion\n" +
            "   ORDER BY T1.bono\n" +
            "   DESC, TRAB.nombresall;";


    public static String Consolidado_bonos = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
            "  co.idconcepto                                       idconcepto,\n" +
            "  co.descripcion                                      concepto,\n" +
            "  SUM(T1.bono)                                      BONOS\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T1.idtareo\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t1.idempresa=t2.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador and trab.idempresa=t1.idempresa and trab.idplanilla=tar.idplanilla\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T1.conceptobono)) and co.idempresa=t1.idempresa\n" +
            "WHERE T1.idtareo = '@idtareo' AND T1.iddatabase LIKE '@iddatabase%' AND bono > 0 and t2.idestado in ('PE','AP') \n" +
            "GROUP BY TRAB.idtrabajador, co.idconcepto, co.descripcion\n" +
            "ORDER BY T1.bono\n" +
            "  DESC, TRAB.nombresall;";

    public static String Consolidado_jornalFaltante = "" +
            "SELECT\n" +
            "  T1.itemid                                           SubTareo,\n" +
            "  T1.item                                             Item,\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No Encontrado') nombres,\n" +
            "  T1.jornal                                          HORAS\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t1.idempresa=t2.idempresa\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and tar.idempresa=t2.idempresa and tar.iddatabase=t2.iddatabase \n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase and trab.idempresa=t1.idempresa and trab.idplanilla=tar.idplanilla\n" +
            "WHERE T1.idtareo = '@idtareo' AND T1.jornal = 0 AND T1.iddatabase LIKE '@iddatabase' and t2.idestado in ('PE','AP') \n" +
            "ORDER BY t1.itemid, t1.item, TRAB.nombresall;";

    public static String Consolidado_avanceFaltante = "" +
            "SELECT\n" +
            "  T1.itemid                                           SubTareo,\n" +
            "  T1.item                                             Item,\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador No Encontrado') nombres,\n" +
            "  T1.avance                                          avance\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t1.idempresa=t2.idempresa\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and tar.idempresa=t2.idempresa and tar.iddatabase=t2.iddatabase \n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T1.iddatabase = TRAB.iddatabase and trab.idempresa=t1.idempresa and trab.idplanilla=tar.idplanilla\n" +
            "WHERE T1.idtareo = '@idtareo' AND T1.avance = 0 AND T1.iddatabase LIKE '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "ORDER BY TRAB.nombresall;";

    public static String Consolidado_resumenConsumidores = "" +
            "SELECT\n" +
            "  T2.idconsumidor                                IDCONSUMIDOR,\n" +
            "  CONS.descripcion                               CONSUMIDOR,\n" +
            "  SUM(T1.jornal + t1.jornalextra + t1.agregado1) HORAS,\n" +
            "  SUM(T1.avance)                                 AVANCE,\n" +
            "  SUM(T1.rendimiento)                            REND\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T1.idtareo\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase AND t2.idempresa = t1.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase AND cons.idempresa = t2.idempresa\n" +
            "WHERE T1.idtareo = '@idtareo' AND T1.avance = 0 AND T1.iddatabase LIKE '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "GROUP BY t2.idconsumidor";

    public static String DIalogTrabajadores_ResumenTodoDia = "" +
            "SELECT\n" +
            "t3.itemid as SubTareo,\n" +
            "t2.idactividad idacti,\n" +
            "trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   actividad,\n" +
            "t2.idlabor idlab,\n" +
            "trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       labor,\n" +
            "t2.idconsumidor idcons,\n" +
            "trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) consumidor,\n" +
            "round(sum(rendimiento)/sum(jornal*1.0/8) ,2)           promedio,\n" +
            "round(min(rendimiento),2)             minimo  ,\n" +
            "round(max(rendimiento),2)             maximo,\n" +
            "round(sum(rendimiento),2) plantas,\n" +
            "count(idtrabajador)          total_trabajadores\n" +
            "FROM ddtareo t3\n" +
            "inner join dtareo t2 on t2.idtareo=t3.idtareo and t3.itemid=t2.item\n" +
            "\t\t LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t3.idempresa=act.idempresa\n" +
            "     LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and lab.idempresa=t3.idempresa\n" +
            "     LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t3.idempresa\n" +
            "WHERE t3.idtareo = '@idtareo'  and t2.idestado in ('PE','AP')  \n" +
            "group by t3.itemid;";

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PreTareoDetalle">
    public static String DialogPreTareo_query = "" +
            "SELECT\n" +
            "  T.idtrabajador,\n" +
            "  ifnull(T.nombresall, 'Trabajador Desconocido ***') nombres\n" +
            "FROM dpretareo D\n" +
            "  LEFT JOIN trabajador T ON T.idtrabajador = D.idtrabajador AND T.iddatabase = '@iddatabase'\n" +
            "WHERE D.idpretareo = '@idpretareo' AND iddatabase = '@iddatabase';";

    //</editor-fold>
    public static String Distribucion_constuir = "" +
            "select t3.idtareo,\n" +
            "       t3.iddatabase,\n" +
            "       t3.idempresa,\n" +
            "       t3.itemid,\n" +
            "       t3.item,\n" +
            "       t3.idtrabajador,\n" +
            "       t3.estatus,\n" +
            "       t3.esjornal,\n" +
            "       t3.esrendimiento,\n" +
            "       t3.fecha,\n" +
            "       t3.inicio,\n" +
            "       t3.iniciorefrigerio,\n" +
            "       t3.finrefrigerio,\n" +
            "       t3.fin,\n" +
            "       t3.asistio,\n" +
            "       t3.jornal,\n" +
            "       t3.rendimiento,\n" +
            "       t3.avance,\n" +
            "       t3.jornalextra,\n" +
            "       t3.rendimientoextra,\n" +
            "       t3.conceptobono,\n" +
            "       t3.bono,\n" +
            "       t3.agregado1,\n" +
            "       t3.agregado2,\n" +
            "       t3.idmotivo,\n" +
            "       t3.latitud,\n" +
            "       t3.longitud,\n" +
            "       t3.fechacreacion,\n" +
            "       t3.observaciones,\n" +
            "       ifnull(trab.nombresall, 'Trabajador no Encontrado') nombres,\n" +
            "       ifnull(co.descripcion, '')                          nombreconcepto,\n" +
            "       ifnull(t3.t_comp, 0)                          t_comp,\n" +
            "       CASE t_comp WHEN  1 THEN 0 WHEN  0 THEN t3.h_comp ELSE 0 END                          h_comp, \n" +
            "       ifnull(t3.diasiguiente,0) dia_sgte,  \n" +
            "       t3.idregimen,\n" +
            "       t3.iddprogramacion\n" +
            "FROM ddtareo T3\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T3.idtareo\n" +
            "  LEFT JOIN trabajador trab ON trab.idtrabajador = T3.idtrabajador AND\n" +
            "                               trab.iddatabase = T3.iddatabase AND t3.idempresa = trab.idempresa AND\n" +
            "                               trab.idplanilla = tar.idplanilla\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T3.conceptobono)) AND t3.idempresa = co.idempresa\n" +
            "WHERE T3.idtareo = '@idtareo' AND T3.itemid = '@item' \n" +
            "order by t3.idtrabajador, t3.item asc ;";

    public static String Distribucion_constuir_salida = "" +
            "select t3.idtareo,\n" +
            "       t3.iddatabase,\n" +
            "       t3.idempresa,\n" +
            "       t3.itemid,\n" +
            "       t3.item,\n" +
            "       t3.idtrabajador,\n" +
            "       t3.estatus,\n" +
            "       t3.esjornal,\n" +
            "       t3.esrendimiento,\n" +
            "       t3.fecha,\n" +
            "       t3.inicio,\n" +
            "       t3.iniciorefrigerio,\n" +
            "       t3.finrefrigerio,\n" +
            "       t3.fin,\n" +
            "       t3.asistio,\n" +
            "       t3.jornal,\n" +
            "       t3.rendimiento,\n" +
            "       t3.avance,\n" +
            "       t3.jornalextra,\n" +
            "       t3.rendimientoextra,\n" +
            "       t3.conceptobono,\n" +
            "       t3.bono,\n" +
            "       t3.agregado1,\n" +
            "       t3.agregado2,\n" +
            "       t3.idmotivo,\n" +
            "       t3.latitud,\n" +
            "       t3.longitud,\n" +
            "       t3.fechacreacion,\n" +
            "       t3.observaciones,\n" +
            "       ifnull(trab.nombresall, 'Trabajador no Encontrado') nombres,\n" +
            "       ifnull(co.descripcion, '')                          nombreconcepto,\n" +
            "       ifnull(t3.t_comp, 0)                          t_comp,\n" +
            "       CASE t_comp WHEN  1 THEN 0 WHEN  0 THEN t3.h_comp ELSE 0 END                          h_comp, \n" +
            "       ifnull(t3.diasiguiente,0) dia_sgte,  \n" +
            "       CASE WHEN t3.diasiguiente=1 THEN DATE(tar.fecha, '+1 days') WHEN t3.inicio< tar.inicio THEN DATE(tar.fecha, '+1 days') ELSE tar.fecha END || ' ' || t3.inicio as iniciox,\n" +
            "       CASE WHEN t3.fin<t3.inicio THEN DATE(tar.fecha, '+1 days')  WHEN t3.diasiguiente=1 THEN DATE(tar.fecha, '+1 days') WHEN t3.fin<tar.inicio THEN DATE(tar.fecha, '+1 days')  ELSE tar.fecha END  || ' ' || t3.fin as finx, \n" +
            "       t3.idregimen,\n" +
            "       t3.iddprogramacion\n" +
            "FROM ddtareo T3\n" +
            "  INNER JOIN tareo tar ON tar.idtareo = T3.idtareo\n" +
            "  LEFT JOIN trabajador trab ON trab.idtrabajador = T3.idtrabajador AND\n" +
            "                               trab.iddatabase = T3.iddatabase AND t3.idempresa = trab.idempresa AND\n" +
            "                               trab.idplanilla = tar.idplanilla\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T3.conceptobono)) AND t3.idempresa = co.idempresa\n" +
            "WHERE T3.idtareo = '@idtareo' and t3.idtrabajador = '@idtrabajador' " +
            " order by  t3.diasiguiente desc, t3.inicio desc ;";
    public static String ListRegimenes =  "" +
            "select idregimen, descripcion, editable, vdefecto " +
            "from regimenCompensacion " +
            "where idempresa='@idempresa' and iddatabase='@iddatabase' and activo=1 ;";
    public static String GetRegimenProgramado =  "" +
            "select regimen , pmo.iddprogramacion " +
            "from programacionMO PMO  " +
            "inner join regimenCompensacion RC on PMO.regimen = RC.idregimen  " +
            "where RC.iddatabase='@iddatabase' and RC.idempresa ='@idempresa' and PMO.dni ='@dni' and '@fecha' BETWEEN PMO.inicio and PMO.fin LIMIT 1 ;";
    public static String ExisteRegimenAsignado =  "" +
            "select ddt.idregimen, *\n" +
            "           from ddtareo ddt where ddt.iddatabase='@iddatabase' and ddt.idempresa ='@idempresa' and ddt.idtrabajador ='@dni' and \n" +
            "           ddt.idtareo='@tareo' and ddt.itemid<>'@itemid' and ddt.item<>'@item' and idregimen <> 'null' and idregimen <> '' and idregimen <> ' ' LIMIT 1 ;";
    public static String ListHorariosRef =  "" +
            "select idrefrigerio, iddatabase, idempresa, idtareo, inicioref , finref, diasig, eslocal " +
            "from RefrigerioTareo " +
            "where idempresa='@idempresa' and iddatabase='@iddatabase' and activo=1 and idtareo='@idtareo';";

    public static String Distribucion_constuirHistorial = "" +
            "SELECT *" +
            "FROM dddtareo " +
            "WHERE idtareo = '@idtareo' AND itemid = '@itemid' AND item='@item';";

    public static String ListDnixSubtareo = "" +
            "SELECT idtrabajador" +
            "FROM ddtareo " +
            "WHERE idtareo = '@idtareo' AND iddatabase = '@iddatabase' AND idempresa = '@idempresa'  AND itemid = '@itemid' ;";

    public static String AcopioAdapter_validaralExportar = "select count(1) from dacopio where idacopio='@idacopio';";

    public static String TareoDataAdapter_validarTareoalExportar = "SELECT\n" +
            "  ifnull(count(1), 0) total,\n" +
            "  CASE T2.esrendimiento\n" +
            "  WHEN 'N'\n" +
            "    THEN\n" +
            "      CASE T3.jornal\n" +
            "      WHEN 0\n" +
            "        THEN 'NO'\n" +
            "      ELSE 'SI'\n" +
            "      END\n" +
            "  WHEN 'S'\n" +
            "    THEN\n" +
            "      CASE t3.rendimiento\n" +
            "      WHEN 0\n" +
            "        THEN 'NO'\n" +
            "      ELSE 'SI'\n" +
            "      END\n" +
            "  END                 estado\n" +
            "FROM ddtareo t3\n" +
            "  INNER JOIN dtareo t2 ON t2.idtareo = t3.idtareo AND t3.itemid = t2.item and t3.idempresa=t2.idempresa\n" +
            "WHERE T3.idtareo = '@idtareo' AND estado = 'NO'\n" +
            "GROUP BY estado;\n";

    public static String Tareo_crearSubTareo = "" +
            "SELECT\n" +
            "  T2.idtareo                                                     IDTAREO,\n" +
            "  T2.iddatabase                                                  IDDATABASE,\n" +
            "  T2.idempresa                                                   IDEMPRESA,\n" +
            "  T2.item                                                        ITEM,\n" +
            "  T2.idactividad                                                 IDACTIVIDAD,\n" +
            "  trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   ACTIVIDAD,\n" +
            "  T2.idlabor                                                     IDLABOR,\n" +
            "  trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       LABOR,\n" +
            "  T2.idconsumidor                                                IDCONSUMIDOR,\n" +
            "  trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) CONSUMIDOR,\n" +
            "  T2.esrendimiento,\n" +
            "  T2.totalhoras\n" +
            "FROM dtareo T2\n" +
            "  LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t2.idempresa=act.idempresa\n" +
            "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and t2.idempresa=lab.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and t2.idempresa=cons.idempresa\n" +
            "WHERE T2.idtareo = '@idtareo' AND T2.item = '@item';";
    public static String Tareo_totalTrabxTareo = "SELECT\n" +
            "  ifnull(u.nombres, 'Usuario Desconocido') nombres,\n" +
            "  count(DISTINCT t3.idtrabajador)          total\n" +
            "FROM ddtareo t3\n" +
            "  INNER JOIN tareo t1 ON t1.idtareo = t3.idtareo AND t3.idempresa = t1.idempresa\n" +
            "  LEFT JOIN usuario u ON u.idusuario = t1.idusuario\n" +
            "WHERE t1.idtareo = '@idtareo';\n";

    public static String Tareo_crearExcelNormal = "" +
            "SELECT T1.idtrabajador                                            DNI,\n" +
            "       ifnull(TRAB.nombresall, 'Trabajador Desconocido ***')      NOMBRES,\n" +
            "       T1.itemid,\n" +
            "       T1.item,\n" +
            "       T2.idactividad                                             IDACTIVIDAD,\n" +
            "       ifnull(trim(ACT.descripcion), 'Actividad no Encontrada')   ACTIVIDAD,\n" +
            "       T2.idlabor                                                 IDLABOR,\n" +
            "       ifnull(trim(LAB.descripcion), 'Labor no Encontrada')       LABOR,\n" +
            "       T2.idconsumidor                                            IDCONSUMIDOR,\n" +
            "       ifnull(trim(CONS.descripcion), 'Consumidor no Encontrado') CONSUMIDOR,\n" +
            "       T1.jornal,\n" +
            "       T1.jornalextra,\n" +
            "       T1.agregado1,\n" +
            "       T1.rendimiento,\n" +
            "       T1.avance,\n" +
            "       T1.inicio,\n" +
            "       T1.fin\n" +
            "FROM ddtareo T1\n" +
            "       INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t2.idempresa = t1.idempresa\n" +
            "       inner join tareo tar on tar.idtareo = t2.idtareo and tar.idempresa = t2.idempresa and tar.iddatabase = t2.iddatabase\n" +
            "       LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T2.iddatabase = TRAB.iddatabase AND t1.idempresa = TRAB.idempresa and trab.idplanilla = tar.idplanilla\n" +
            "       LEFT JOIN actividad ACT ON trim(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase AND t2.idempresa = act.idempresa\n" +
            "       LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND TRIM(LAB.idactividad) = trim(ACT.idactividad)\n" +
            "                                AND T2.iddatabase = LAB.iddatabase AND t2.idempresa = lab.idempresa\n" +
            "       LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and t2.idempresa = cons.idempresa\n" +
            "WHERE T2.idtareo = '@idtareo' AND T1.iddatabase = '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "ORDER BY TRAB.nombresall;";

    public static String Tareo_crearExcelResumenLabores = "SELECT\n" +
            "  trim(l.descripcion) labor,\n" +
            "  trim(a.descripcion) actividad,\n" +
            "  count(t3.item)      trabajadores,\n" +
            "  sum(t3.jornal)      horas,\n" +
            "  sum(t3.jornal) / 8  jornales\n" +
            "FROM ddtareo t3\n" +
            "  INNER JOIN dtareo t2 ON t2.idtareo = t3.idtareo AND t2.item = t3.itemid\n" +
            "  LEFT JOIN actividad a ON a.idactividad = t2.idactividad AND a.idempresa = t2.idempresa\n" +
            "  LEFT JOIN labor l ON a.idactividad = l.idactividad AND l.idlabor = t2.idlabor AND t2.idempresa = l.idempresa\n" +
            "WHERE t3.idtareo = '@idtareo'  and t2.idestado in ('PE','AP') \n" +
            "GROUP BY t2.idactividad, a.descripcion, t2.idlabor, l.descripcion\n" +
            "ORDER BY t2.idactividad, t2.idlabor;";

    public static String Tareo_crearExcelExtra = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador Desconocido ***') NOMBRES,\n" +
            "  T1.itemid,\n" +
            "  T1.item,\n" +
            "  T2.idactividad                                      IDACTIVIDAD,\n" +
            "  trim(ACT.descripcion)                               ACTIVIDAD,\n" +
            "  T2.idlabor                                          IDLABOR,\n" +
            "  trim(LAB.descripcion)                               LABOR,\n" +
            "  T2.idconsumidor                                     IDCONSUMIDOR,\n" +
            "  trim(CONS.descripcion)                              CONSUMIDOR,\n" +
            "  T1.jornal,\n" +
            "  T1.rendimiento,\n" +
            "  T1.avance,\n" +
            "  T1.inicio,\n" +
            "  T1.fin,\n" +
            "  T1.jornalextra\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t2.idempresa=t1.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T2.iddatabase = TRAB.iddatabase AND t1.idempresa = TRAB.idempresa\n" +
            "  LEFT JOIN actividad ACT ON ACT.idactividad = T2.idactividad AND T2.iddatabase = ACT.iddatabase AND t2.idempresa = act.idempresa\n" +
            "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad\n" +
            "                         AND T2.iddatabase = LAB.iddatabase AND t2.idempresa = lab.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and t2.idempresa=cons.idempresa\n" +
            "WHERE T2.idtareo = '@idtareo' AND T1.iddatabase = '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "ORDER BY TRAB.nombresall;";

    public static String Tareo_crearExcelBono = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador Desconocido ***') NOMBRES,\n" +
            "  T1.itemid,\n" +
            "  T1.item,\n" +
            "  T2.idactividad                                      IDACTIVIDAD,\n" +
            "  trim(ACT.descripcion)                               ACTIVIDAD,\n" +
            "  T2.idlabor                                          IDLABOR,\n" +
            "  trim(LAB.descripcion)                               LABOR,\n" +
            "  T2.idconsumidor                                     IDCONSUMIDOR,\n" +
            "  trim(CONS.descripcion)                              CONSUMIDOR,\n" +
            "  T1.jornal,\n" +
            "  T1.rendimiento,\n" +
            "  T1.avance,\n" +
            "  T1.inicio,\n" +
            "  T1.fin,\n" +
            "  T1.conceptobono,\n" +
            "  ifnull(co.descripcion, '')                          nombreconcepto,\n" +
            "  T1.bono\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t2.idempresa=t1.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T2.iddatabase = TRAB.iddatabase AND t1.idempresa = TRAB.idempresa\n" +
            "  LEFT JOIN actividad ACT ON ACT.idactividad = T2.idactividad AND T2.iddatabase = ACT.iddatabase AND t2.idempresa = act.idempresa\n" +
            "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad\n" +
            "                         AND T2.iddatabase = LAB.iddatabase AND t2.idempresa = lab.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and t2.idempresa=cons.idempresa\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T1.conceptobono)) and co.iddatabase=t1.iddatabase and co.idempresa=t1.idempresa\n" +
            "WHERE T2.idtareo = '@idtareo' AND T1.iddatabase = '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "ORDER BY TRAB.nombresall;";

    public static String Tareo_crearExcelAll = "" +
            "SELECT\n" +
            "  T1.idtrabajador                                     DNI,\n" +
            "  ifnull(TRAB.nombresall, 'Trabajador Desconocido ***') NOMBRES,\n" +
            "  T1.itemid,\n" +
            "  T1.item,\n" +
            "  T2.idactividad                                      IDACTIVIDAD,\n" +
            "  trim(ACT.descripcion)                               ACTIVIDAD,\n" +
            "  T2.idlabor                                          IDLABOR,\n" +
            "  trim(LAB.descripcion)                               LABOR,\n" +
            "  T2.idconsumidor                                     IDCONSUMIDOR,\n" +
            "  trim(CONS.descripcion)                              CONSUMIDOR,\n" +
            "  T1.jornal,\n" +
            "  T1.rendimiento,\n" +
            "  T1.avance,\n" +
            "  T1.inicio,\n" +
            "  T1.fin,\n" +
            "  T1.jornalextra,\n" +
            "  T1.conceptobono                                       idconcepto,\n" +
            "  ifnull(co.descripcion, '')    concepto,\n" +
            "  T1.bono\n" +
            "FROM ddtareo T1\n" +
            "  INNER JOIN dtareo T2 ON T2.idtareo = T1.idtareo AND T2.item = T1.itemid AND T2.iddatabase = T1.iddatabase and t2.idempresa=t1.idempresa\n" +
            "  LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND T2.iddatabase = TRAB.iddatabase AND t1.idempresa = TRAB.idempresa\n" +
            "  LEFT JOIN actividad ACT ON ACT.idactividad = T2.idactividad AND T2.iddatabase = ACT.iddatabase AND t2.idempresa = act.idempresa\n" +
            "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad\n" +
            "                         AND T2.iddatabase = LAB.iddatabase AND t2.idempresa = lab.idempresa\n" +
            "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and t2.idempresa=cons.idempresa\n" +
            "  LEFT JOIN concepto co ON ltrim(rtrim(co.idconcepto)) = ltrim(rtrim(T1.conceptobono)) and co.idempresa=t1.idempresa and co.iddatabase=t1.idempresa\n" +
            "WHERE T2.idtareo = '@idtareo' AND T1.iddatabase = '@iddatabase'  and t2.idestado in ('PE','AP') \n" +
            "ORDER BY TRAB.nombresall;";

    public static String listartrabajador_nopretareadosdeldia = "" +
            "SELECT\n" +
            "  idtrabajador,\n" +
            "  nombresall,\n" +
            "  ''\n" +
            "   FROM trabajador\n" +
            "   WHERE iddatabase = '@iddatabase' AND idplanilla = '@idplanilla' AND idtrabajador NOT IN (\n" +
            "  SELECT DISTINCT idtrabajador\n" +
            "  FROM dpretareo d\n" +
            "    INNER JOIN pretareo p ON p.idpretareo = d.idpretareo\n" +
            "  WHERE p.fecha = '"  + "'\n" +
            ");";



    public static String pretareos_sinexportar = "" +
            "SELECT\n" +
            "  P.idpretareo,\n" +
            "  P.idestado,\n" +
            "  P.numero || ' • ' || Tu.descripcion                                                                                          title,\n" +
            "  P.fecha                                                                                                                          fecha,\n" +
            "  ifnull(T.idtrabajador || ': ' || ifnull(T.nombresall, 'Trabajador Desconocido ***'), P.idsupervisor || ': ' || 'Supervisor no Registrado') supervisor,\n" +
            "  'Cantidad: ' || count(D.item)                                                                                                            cantidad\n" +
            "   FROM pretareo P\n" +
            "  INNER JOIN dpretareo D ON D.idpretareo = P.idpretareo\n" +
            "  INNER JOIN turno TU ON Tu.idturno = P.idturno\n" +
            "  LEFT JOIN trabajador T ON T.idtrabajador = P.idsupervisor AND T.iddatabase = P.iddatabase\n" +
            "   WHERE P.idestado LIKE '%@idestado%' AND P.fecha = '@fecha' AND P.idsupervisor = '@idsupervisor'\n" +
            "   GROUP BY P.idpretareo, P.idestado, P.fecha, P.idsupervisor;";
    public static String pretareos_sinexportarSemanal = "" +
            "SELECT\n" +
            "  P.idpretareo,\n" +
            "  P.idestado,\n" +
            "  P.numero || ' • ' || Tu.descripcion                                                                                      title,\n" +
            "  P.fecha                                                                                                                          fecha,\n" +
            "  ifnull(T.idtrabajador || ': ' || ifnull(T.nombresall, 'Trabajador Desconocido ***'), P.idsupervisor || ': ' || 'Supervisor no Registrado') supervisor,\n" +
            "  'Cantidad: ' || count(D.item)                                                                                                            cantidad\n" +
            "   FROM pretareo P\n" +
            "  INNER JOIN dpretareo D ON D.idpretareo = P.idpretareo\n" +
            "  INNER JOIN turno TU ON Tu.idturno = P.idturno\n" +
            "  LEFT JOIN trabajador T ON T.idtrabajador = P.idsupervisor AND T.iddatabase = P.iddatabase\n" +
            "   WHERE P.idestado LIKE '%@idestado%' AND strftime('%W', P.fecha) = strftime('%W', '@fecha') AND P.idsupervisor = '@idsupervisor'\n" +
            "   GROUP BY P.idpretareo, P.idestado, P.fecha, P.idsupervisor;";

    //<editor-fold defaultstate="collapsed" desc="DTAREOS">
    public static String listaDTareos(String idtareo) {
        return "SELECT\n" +
                "  T2.idtareo,\n" +
                "  T2.iddatabase,\n" +
                "  T2.idempresa,\n" +
                "  T2.idcultivovariedad,\n" +
                "  T2.item,\n" +
                "  T2.idactividad,\n" +
                "  T2.idlabor,\n" +
                "  T2.idconsumidor,\n" +
                "  T2.fecha,\n" +
                "  T2.horainicio,\n" +
                "  T2.horafin,\n" +
                "  T2.totalhoras,\n" +
                "  T2.idestado,\n" +
                "  T2.esjornal,\n" +
                "  T2.esrendimiento,\n" +
                "  T2.idfundo,\n" +
                "  T2.idfundojefe,\n" +
                "  T2.latitud,\n" +
                "  T2.longitud,\n" +
                "  T2.fechacreacion,\n" +
                "  T2.observaciones,\n" +
                "  trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   actividad,\n" +
                "  trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       labor,\n" +
                "  trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) consumidor,\n" +
                "  (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item)                     total,\n" +
                "   (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item and jornal=0 )                     zerojornal\n" +
                "   FROM dtareo T2\n" +
                "  LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t2.idempresa=act.idempresa\n" +
                "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and lab.idempresa=t2.idempresa\n" +
                "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t2.idempresa\n" +
                "   WHERE T2.idtareo = '" + idtareo + "'  and t2.idestado in ('PE','AP') \n" +
                "   GROUP BY T2.item\n" +
                "   ORDER BY T2.item;";
    }

    public static String listaDTareos(String idtareo, String idacti, String idlab, String idcons) {
        return "SELECT\n" +
                "  T2.idtareo,\n" +
                "  T2.iddatabase,\n" +
                "  T2.idempresa,\n" +
                "  T2.idcultivovariedad,\n" +
                "  T2.item,\n" +
                "  T2.idactividad,\n" +
                "  T2.idlabor,\n" +
                "  T2.idconsumidor,\n" +
                "  T2.fecha,\n" +
                "  T2.horainicio,\n" +
                "  T2.horafin,\n" +
                "  T2.totalhoras,\n" +
                "  T2.idestado,\n" +
                "  T2.esjornal,\n" +
                "  T2.esrendimiento,\n" +
                "  T2.idfundo,\n" +
                "  T2.idfundojefe,\n" +
                "  T2.latitud,\n" +
                "  T2.longitud,\n" +
                "  T2.fechacreacion,\n" +
                "  T2.observaciones,\n" +
                "  trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   actividad,\n" +
                "  trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       labor,\n" +
                "  trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) consumidor,\n" +
                "  (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item)                     total,\n" +
                "   (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item and jornal=0 )                     zerojornal\n" +
                "   FROM dtareo T2\n" +
                "  LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t2.idempresa=act.idempresa\n" +
                "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and lab.idempresa=t2.idempresa\n" +
                "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t2.idempresa\n" +
                "   WHERE T2.idtareo = '" + idtareo + "' and (t2.idactividad like '%" + idacti + "%' and t2.idlabor like  '%" + idlab + "%' and t2.idconsumidor like '%" + idcons + "%') " +
                "    and t2.idestado in ('PE','AP') \n" +
                "   GROUP BY T2.item\n" +
                "   ORDER BY T2.item;";
    }

    public static String listaTrabMarcacione(String idtareo, boolean esTareo) {
        if(esTareo) {
            return "Select d.DNI, d.nombres, d.INICIO, " +
                    "ifnull(asis.salida,'0000-00-00 00:00:00') FIN, " +
                    "d.HORAS, d.AVANCE, d.REND, C.descripcion CONSUMIDOR , a.descripcion ACTIVIDAD ,l.descripcion LABOR, d.idtareo, d.idempresa, d.iddatabase from \n" +
                    "(SELECT T1.idtareo,\n" +
                    "             t1.iddatabase,\n" +
                    "             t1.idempresa,\n" +
                    "            T1.idtrabajador DNI,\n" +
                    "            ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
                    "            MIN(t1.fechacreacion) INICIO,\n" +
                    "            SUM(T1.jornal + T1.agregado1 + T1.jornalextra) HORAS,\n" +
                    "            SUM(T1.avance)  AVANCE,\n" +
                    "            SUM(T1.rendimiento)    REND \n" +
                    "            FROM ddtareo T1\n" +
                    "             inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
                    "             INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and tar.iddatabase=t2.iddatabase and tar.idempresa=t2.idempresa \n" +
                    "             LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND\n" +
                    "                                         T1.iddatabase = TRAB.iddatabase AND\n" +
                    "                                         t1.idempresa = trab.idempresa AND\n" +
                    "                                         tar.idplanilla = trab.idplanilla\n" +
                    "            WHERE T1.idtareo = '" + idtareo + "'  and t2.idestado in ('PE','AP') \n" +
                    "            GROUP BY T1.idtrabajador, t1.idtareo, t1.iddatabase, t1.idempresa\n" +
                    "            ORDER BY TRAB.nombresall\n" +
                    ") d inner join ddtareo t1 on d.iddatabase=t1.iddatabase and d.idempresa=t1.idempresa and d.idtareo=t1.idtareo and d.DNI=t1.idtrabajador and d.INICIO = t1.fechacreacion\n" +
                    "            inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
                    "            left join actividad a on t2.iddatabase=a.iddatabase and t2.idempresa=a.idempresa and t2.idactividad=a.idactividad\n" +
                    "            left join labor l on t2.iddatabase=l.iddatabase and t2.idempresa=l.idempresa and t2.idactividad=l.idactividad and t2.idlabor=l.idlabor\n" +
                    "            left join consumidor c on t2.iddatabase=c.iddatabase and t2.idempresa=c.idempresa and t2.idconsumidor=c.idconsumidor" +
                    "            left join asistenciabytareo asis on d.idtareo=asis.idasistenciabytareo and d.dni= asis.idtrabajador and asis.estatus='PE' and asis.activo = 1" +
                    "";
        } else{
            return "Select d.DNI, d.nombres, d.INICIO, " +
                    "ifnull(asis.salida,'0000-00-00 00:00:00') FIN, " +
                    "d.HORAS, d.AVANCE, d.REND, C.descripcion CONSUMIDOR , a.descripcion ACTIVIDAD ,l.descripcion LABOR, d.idtareo, d.idempresa, d.iddatabase from \n" +
                    "(SELECT T1.idtareo,\n" +
                    "             t1.iddatabase,\n" +
                    "             t1.idempresa,\n" +
                    "            T1.idtrabajador DNI,\n" +
                    "            ifnull(TRAB.nombresall, 'Trabajador No encontrado') nombres,\n" +
                    "            MIN(t1.fechacreacion) INICIO,\n" +
                    "            SUM(T1.jornal + T1.agregado1 + T1.jornalextra) HORAS,\n" +
                    "            SUM(T1.avance)  AVANCE,\n" +
                    "            SUM(T1.rendimiento)    REND \n" +
                    "            FROM ddtareo T1\n" +
                    "             inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
                    "             INNER JOIN tareo tar ON tar.idtareo = T2.idtareo and tar.iddatabase=t2.iddatabase and tar.idempresa=t2.idempresa \n" +
                    "             LEFT JOIN trabajador TRAB ON TRAB.idtrabajador = T1.idtrabajador AND\n" +
                    "                                         T1.iddatabase = TRAB.iddatabase AND\n" +
                    "                                         t1.idempresa = trab.idempresa AND\n" +
                    "                                         tar.idplanilla = trab.idplanilla\n" +
                    "            WHERE T1.idtareo = '" + idtareo + "'  and t2.idestado in ('PE','AP') \n" +
                    "            GROUP BY T1.idtrabajador, t1.idtareo, t1.iddatabase, t1.idempresa\n" +
                    "            ORDER BY TRAB.nombresall\n" +
                    ") d inner join ddtareo t1 on d.iddatabase=t1.iddatabase and d.idempresa=t1.idempresa and d.idtareo=t1.idtareo and d.DNI=t1.idtrabajador and d.INICIO = t1.fechacreacion\n" +
                    "            inner join dtareo t2 on t2.iddatabase=t1.iddatabase and t2.idempresa=t1.idempresa and t2.idtareo=t1.idtareo and t1.itemid=t2.item\n" +
                    "            left join actividad a on t2.iddatabase=a.iddatabase and t2.idempresa=a.idempresa and t2.idactividad=a.idactividad\n" +
                    "            left join labor l on t2.iddatabase=l.iddatabase and t2.idempresa=l.idempresa and t2.idactividad=l.idactividad and t2.idlabor=l.idlabor\n" +
                    "            left join consumidor c on t2.iddatabase=c.iddatabase and t2.idempresa=c.idempresa and t2.idconsumidor=c.idconsumidor" +
                    "            left join asistenciabytareo asis on d.idtareo=asis.idasistenciabytareo and d.dni= asis.idtrabajador and asis.estatus='PE' and asis.activo = 1" +
                    "";
        }
    }

    public static String listaDTareosPacking(String idtareo, String idacti, String idlab, String idcons) {
        return "SELECT\n" +
                "  T2.idtareo,\n" +
                "  T2.iddatabase,\n" +
                "  T2.idempresa,\n" +
                "  T2.idcultivovariedad,\n" +
                "  T2.item,\n" +
                "  T2.idactividad,\n" +
                "  T2.idlabor,\n" +
                "  T2.idconsumidor,\n" +
                "  T2.fecha,\n" +
                "  T2.horainicio,\n" +
                "  T2.horafin,\n" +
                "  T2.totalhoras,\n" +
                "  T2.idestado,\n" +
                "  T2.esjornal,\n" +
                "  T2.esrendimiento,\n" +
                "  T2.idfundo,\n" +
                "  T2.idfundojefe,\n" +
                "  T2.latitud,\n" +
                "  T2.longitud,\n" +
                "  T2.fechacreacion,\n" +
                "  T2.observaciones,\n" +
                "  trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   actividad,\n" +
                "  trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       labor,\n" +
                "  trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) consumidor,\n" +
                "  (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item)                     total,\n" +
                "   (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item and jornal=0 )                     zerojornal\n" +
                "   FROM dtareo T2\n" +
                "  LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t2.idempresa=act.idempresa\n" +
                "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and lab.idempresa=t2.idempresa\n" +
                "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t2.idempresa\n" +
                "   WHERE T2.idtareo = '" + idtareo + "' and (t2.idactividad like '%" + idacti + "%' and t2.idlabor like  '%" + idlab + "%' and t2.idconsumidor like '%" + idcons + "%') " +
                "    and t2.idestado in ('PE','AP','PA') \n" +
                "   GROUP BY T2.item\n" +
                "   ORDER BY T2.item;";
    }

    public static String getDatareo(String idtareo, String item) {
        return "SELECT\n" +
                "  T2.idtareo,\n" +
                "  T2.iddatabase,\n" +
                "  T2.idempresa,\n" +
                "  T2.idcultivovariedad,\n" +
                "  T2.item,\n" +
                "  T2.idactividad,\n" +
                "  T2.idlabor,\n" +
                "  T2.idconsumidor,\n" +
                "  T2.fecha,\n" +
                "  T2.horainicio,\n" +
                "  T2.horafin,\n" +
                "  T2.totalhoras,\n" +
                "  T2.idestado,\n" +
                "  T2.esjornal,\n" +
                "  T2.esrendimiento,\n" +
                "  T2.idfundo,\n" +
                "  T2.idfundojefe,\n" +
                "  T2.latitud,\n" +
                "  T2.longitud,\n" +
                "  T2.fechacreacion,\n" +
                "  T2.observaciones,\n" +
                "  trim(ifnull(ACT.descripcion, 'No se encontro la Actividad'))   actividad,\n" +
                "  trim(ifnull(LAB.descripcion, 'No se encontro la Labor'))       labor,\n" +
                "  trim(ifnull(CONS.descripcion, 'No se encontro el Consumidor')) consumidor,\n" +
                "  (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item)                     total,\n" +
                "   (SELECT count(idtrabajador)\n" +
                "      FROM ddtareo\n" +
                "      WHERE idtareo = '" + idtareo + "' AND itemid = T2.item and jornal=0 )                     zerojornal\n" +
                " FROM dtareo T2\n" +
                "  LEFT JOIN actividad ACT ON TRIM(ACT.idactividad) = trim(T2.idactividad) AND T2.iddatabase = ACT.iddatabase and t2.idempresa=act.idempresa\n" +
                "  LEFT JOIN labor LAB ON TRIM(LAB.idlabor) = TRIM(T2.idlabor) AND LAB.idactividad = ACT.idactividad and lab.idempresa=t2.idempresa\n" +
                "  LEFT JOIN consumidor CONS ON TRIM(CONS.idconsumidor) = TRIM(T2.idconsumidor) AND T2.iddatabase = CONS.iddatabase and cons.idempresa=t2.idempresa\n" +
                " WHERE T2.idtareo = '" + idtareo + "' and T2.item='" + item + "'  and t2.idestado in ('PE','AP') \n" +
                " GROUP BY T2.item\n" +
                " ORDER BY T2.item;";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="TAREOS">
    public static String listaTareosbyFecha(String idusuario, String idestado, String iddatabase, String idempresa, String fecha) {
        return "SELECT idtareo, T.iddatabase, T.idempresa, idcultivo, idusuario, idtrabajador, iddocumento, serie," +
                " idestado, numero, fecha, hora, semana, idplanilla, idturno, periodo, latitud, longitud, escampo, espacking, " +
                " fechacreacion, observaciones, imei," +
                " (SELECT count(DISTINCT T3.idtrabajador) total from ddtareo T3 where T3.idtareo=T.idtareo) total," +
                " ifnull(u.descripcion,'U.Negocio Not Found') cultivo," +
                " ifnull(inicio,'00:00:00')  inicio,idsupervisor,iniciorefdia,finrefdia,iniciorefnoc,finrefnoc \n" +
                " FROM tareo T" +
                " left join unidadnegocio u on u.idempresa=T.idempresa and u.iduninegocio=T.idcultivo \n" +
                " WHERE\n" +
                "  T.idusuario LIKE '%" + idusuario + "%' AND\n" +
                "  T.idestado LIKE '%" + idestado + "%' AND\n" +
                "  T.iddatabase LIKE '%" + iddatabase + "%' AND\n" +
                "  T.idempresa LIKE '%" + idempresa + "%' AND\n" +
                "  T.fecha='" + fecha + "' \n" +
                "  ORDER BY T.fecha, T.hora DESC;";
    }

    public static String listaTareosbySemana(String idusuario, String idestado, String iddatabase, String idempresa, String fecha) {
        return "SELECT idtareo, T.iddatabase, T.idempresa, idcultivo, idusuario, idtrabajador, iddocumento, serie," +
                " idestado, numero, fecha, hora, semana, idplanilla, idturno, periodo, latitud, longitud, escampo, espacking, " +
                "fechacreacion, observaciones, imei," +
                "(SELECT count(DISTINCT T3.idtrabajador) total from ddtareo T3 where T3.idtareo=T.idtareo) total," +
                " ifnull(u.descripcion,'U.Negocio Not Found') cultivo," +
                " ifnull(inicio,'00:00:00')  inicio,idsupervisor,iniciorefdia,finrefdia,iniciorefnoc,finrefnoc \n" +
                " FROM tareo T" +
                " left join unidadnegocio u on u.idempresa=T.idempresa and u.iduninegocio=T.idcultivo \n" +
                " WHERE\n" +
                " T.idusuario LIKE '%" + idusuario + "%' AND\n" +
                " T.idestado LIKE '%" + idestado + "%' AND\n" +
                " T.iddatabase LIKE '%" + iddatabase + "%' AND\n" +
                " T.idempresa LIKE '%" + idempresa + "%' AND\n" +
                " (cast(strftime('%W', T.fecha) AS SMALLINT) = cast(strftime('%W', '" + fecha + "') AS SMALLINT)) AND\n" +
                " (strftime('%Y', T.fecha) = strftime('%Y', '" + fecha + "'))\n" +
                " ORDER BY T.fecha, T.hora\n" +
                " DESC;";
    }

    public static String listaTareosTodo(String idusuario, String idestado, String iddatabase, String idempresa) {
        return "SELECT idtareo, T.iddatabase, T.idempresa, idcultivo, idusuario, idtrabajador, iddocumento, serie," +
                " idestado, numero, fecha, hora, semana, idplanilla, idturno, periodo, latitud, longitud, escampo, espacking, " +
                "fechacreacion, observaciones, imei," +
                "(SELECT count(DISTINCT T3.idtrabajador) total from ddtareo T3 where T3.idtareo=T.idtareo) total," +
                " ifnull(u.descripcion,'U.Negocio Not Found') cultivo," +
                " ifnull(inicio,'00:00:00')  inicio,idsupervisor,iniciorefdia,finrefdia,iniciorefnoc,finrefnoc \n" +
                " FROM tareo T" +
                " left join unidadnegocio u on u.idempresa=T.idempresa and u.iduninegocio=T.idcultivo \n" +
                " WHERE\n" +
                "  T.idusuario LIKE '%" + idusuario + "%' AND\n" +
                "  T.idestado LIKE '%" + idestado + "%' AND\n" +
                "  T.iddatabase LIKE '%" + iddatabase + "%' AND\n" +
                "  T.idempresa LIKE '%" + idempresa + "%'\n" +
                "  ORDER BY T.fecha, T.hora DESC;\n";
    }

//</editor-fold>


}
