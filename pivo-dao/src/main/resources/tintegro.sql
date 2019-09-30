--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.20
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-04-07 11:08:14 PET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 66795)
-- Name: asterisk; Type: SCHEMA; Schema: -; Owner: tintegro
--

CREATE SCHEMA asterisk;


ALTER SCHEMA asterisk OWNER TO tintegro;

--
-- TOC entry 5 (class 2615 OID 66796)
-- Name: reportes; Type: SCHEMA; Schema: -; Owner: tintegro
--

CREATE SCHEMA reportes;


ALTER SCHEMA reportes OWNER TO tintegro;

--
-- TOC entry 6 (class 2615 OID 66797)
-- Name: seguridad; Type: SCHEMA; Schema: -; Owner: tintegro
--

CREATE SCHEMA seguridad;


ALTER SCHEMA seguridad OWNER TO tintegro;

--
-- TOC entry 1239 (class 2612 OID 70497)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: tintegro
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO tintegro;

SET search_path = asterisk, pg_catalog;

--
-- TOC entry 1185 (class 1247 OID 106210)
-- Name: consulta_x_usuario_id; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE consulta_x_usuario_id AS (
	id_usuari integer,
	no_apepat character varying(100),
	no_apemat character varying(100),
	no_nombre character varying(100),
	no_puesto character varying(100),
	nu_pin character varying(100),
	ti_llamad integer,
	estado_ti_llamad integer,
	id_empare integer,
	id_area integer,
	id_sip integer,
	il_activo boolean,
	il_fijloca smallint,
	il_fijnaci smallint,
	il_fijinte smallint,
	il_celnaci smallint,
	il_celinte smallint,
	il_celrpm smallint
);


ALTER TYPE consulta_x_usuario_id OWNER TO tintegro;

--
-- TOC entry 1188 (class 1247 OID 105909)
-- Name: consulta_x_usuario_pin; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE consulta_x_usuario_pin AS (
	id_usuari integer,
	nombre character varying(100),
	il_activo boolean,
	il_fijloca smallint,
	il_fijnaci smallint,
	il_fijinte smallint,
	il_celnaci smallint,
	il_celinte smallint,
	il_celrpm smallint
);


ALTER TYPE consulta_x_usuario_pin OWNER TO tintegro;

--
-- TOC entry 1191 (class 1247 OID 111767)
-- Name: listar_centro_costo_por_area; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE listar_centro_costo_por_area AS (
	id_area integer,
	no_area character varying,
	id_empare integer,
	no_centrocosto character varying,
	il_activo boolean
);


ALTER TYPE listar_centro_costo_por_area OWNER TO tintegro;

--
-- TOC entry 768 (class 1247 OID 66803)
-- Name: rutasalientes; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE rutasalientes AS (
	id_troncal integer,
	id_rutdet integer,
	no_rutsal character varying,
	no_regla character varying,
	no_anteponer character varying,
	nu_prefijo character varying,
	no_desc character varying,
	no_descr character varying,
	il_grabar boolean,
	id_clave integer
);


ALTER TYPE rutasalientes OWNER TO tintegro;

--
-- TOC entry 771 (class 1247 OID 66806)
-- Name: tiptelclave; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tiptelclave AS (
	id_codigo integer,
	no_clave character varying,
	no_tiptel character varying
);


ALTER TYPE tiptelclave OWNER TO tintegro;

--
-- TOC entry 1194 (class 1247 OID 70682)
-- Name: tp_busca_anexo_edita; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_busca_anexo_edita AS (
	name character varying,
	secret character varying,
	callerid character varying,
	mailbox character varying,
	email character varying,
	id_marca integer,
	id_modelo integer,
	no_marca character varying,
	no_modelo character varying,
	no_mac character varying,
	no_ip_dominio character varying,
	no_ruta character varying
);


ALTER TYPE tp_busca_anexo_edita OWNER TO tintegro;

--
-- TOC entry 780 (class 1247 OID 66812)
-- Name: tp_list_area_centro_costo; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_list_area_centro_costo AS (
	id_empare integer,
	nombre character varying(100)
);


ALTER TYPE tp_list_area_centro_costo OWNER TO tintegro;

--
-- TOC entry 1197 (class 1247 OID 87191)
-- Name: tp_list_extension; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_list_extension AS (
	id_sip integer,
	name character varying(255),
	callerid character varying(100)
);


ALTER TYPE tp_list_extension OWNER TO tintegro;

--
-- TOC entry 1182 (class 1247 OID 111848)
-- Name: tp_lista_sip_telefono; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_lista_sip_telefono AS (
	name character varying,
	caller_id character varying,
	device character varying,
	email character varying
);


ALTER TYPE tp_lista_sip_telefono OWNER TO tintegro;

--
-- TOC entry 765 (class 1247 OID 66821)
-- Name: tp_lista_todo_marca; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_lista_todo_marca AS (
	id_marca integer,
	no_marca character varying(100)
);


ALTER TYPE tp_lista_todo_marca OWNER TO tintegro;

--
-- TOC entry 774 (class 1247 OID 66824)
-- Name: tp_lista_todo_modelo; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_lista_todo_modelo AS (
	id_modelo integer,
	no_modelo character varying(100),
	id_marca integer
);


ALTER TYPE tp_lista_todo_modelo OWNER TO tintegro;

--
-- TOC entry 777 (class 1247 OID 66827)
-- Name: tp_listar_area_x_centro; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_listar_area_x_centro AS (
	id_empare integer,
	nombre character varying(100)
);


ALTER TYPE tp_listar_area_x_centro OWNER TO tintegro;

--
-- TOC entry 1212 (class 1247 OID 144669)
-- Name: tp_prueba_paginacion; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_prueba_paginacion AS (
	nombre character varying,
	context character varying,
	permit character varying,
	secret character varying,
	host character varying
);


ALTER TYPE tp_prueba_paginacion OWNER TO tintegro;

--
-- TOC entry 1209 (class 1247 OID 119972)
-- Name: tp_resultado; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE tp_resultado AS (
	id_rasult integer,
	mensaje character varying
);


ALTER TYPE tp_resultado OWNER TO tintegro;

--
-- TOC entry 1200 (class 1247 OID 105917)
-- Name: usuario_pin; Type: TYPE; Schema: asterisk; Owner: tintegro
--

CREATE TYPE usuario_pin AS (
	id_usuari integer,
	nombre character varying(100),
	il_activo boolean,
	il_fijloca smallint,
	il_fijnaci smallint,
	il_fijinte smallint,
	il_celnaci smallint,
	il_celinte smallint,
	il_celrpm smallint
);


ALTER TYPE usuario_pin OWNER TO tintegro;

SET search_path = reportes, pg_catalog;

--
-- TOC entry 786 (class 1247 OID 66833)
-- Name: area_llamada_top; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE area_llamada_top AS (
	id_area integer,
	no_area character varying(100),
	ca_llamad integer,
	ca_duraci time(0) without time zone,
	ca_duraprom time(0) without time zone,
	ca_duracmin time(0) without time zone,
	ca_duracmax time(0) without time zone
);


ALTER TYPE area_llamada_top OWNER TO tintegro;

--
-- TOC entry 789 (class 1247 OID 66836)
-- Name: area_llamada_top_detalle; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE area_llamada_top_detalle AS (
	no_area character varying(100),
	fe_llamad date,
	ho_llamad time without time zone,
	src character varying,
	dst character varying,
	ca_duraci time without time zone,
	va_dispos character varying(30)
);


ALTER TYPE area_llamada_top_detalle OWNER TO tintegro;

--
-- TOC entry 792 (class 1247 OID 66839)
-- Name: area_llamada_top_dia; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE area_llamada_top_dia AS (
	id_area integer,
	no_area character varying,
	fe_llamad date,
	ca_llamad integer,
	ca_duraci time without time zone,
	ca_duraprom time without time zone,
	ca_duracmin time without time zone,
	ca_duracmax time without time zone
);


ALTER TYPE area_llamada_top_dia OWNER TO tintegro;

--
-- TOC entry 1221 (class 1247 OID 144686)
-- Name: area_llamada_top_new; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE area_llamada_top_new AS (
	id_area integer,
	no_area character varying(100),
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying
);


ALTER TYPE area_llamada_top_new OWNER TO tintegro;

--
-- TOC entry 1224 (class 1247 OID 144690)
-- Name: area_llamada_top_neww; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE area_llamada_top_neww AS (
	id_area integer,
	no_area character varying(100),
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying
);


ALTER TYPE area_llamada_top_neww OWNER TO tintegro;

--
-- TOC entry 1233 (class 1247 OID 144779)
-- Name: area_llamada_top_report; Type: TYPE; Schema: reportes; Owner: postgres
--

CREATE TYPE area_llamada_top_report AS (
	id_area integer,
	no_area character varying(100),
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying,
	nu_total_reg integer
);


ALTER TYPE area_llamada_top_report OWNER TO postgres;

--
-- TOC entry 1236 (class 1247 OID 144782)
-- Name: area_llamada_top_reporte; Type: TYPE; Schema: reportes; Owner: postgres
--

CREATE TYPE area_llamada_top_reporte AS (
	id_area integer,
	no_area character varying(100),
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying,
	nu_total_reg integer
);


ALTER TYPE area_llamada_top_reporte OWNER TO postgres;

--
-- TOC entry 795 (class 1247 OID 66842)
-- Name: cantidad_llamadas; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE cantidad_llamadas AS (
	va_llamadas integer
);


ALTER TYPE cantidad_llamadas OWNER TO tintegro;

--
-- TOC entry 798 (class 1247 OID 66845)
-- Name: consolidado_llamadas_recibidas; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE consolidado_llamadas_recibidas AS (
	no_queuename character varying,
	no_mes character varying,
	no_dia character varying,
	no_dia_semana character varying,
	nu_cantidad integer
);


ALTER TYPE consolidado_llamadas_recibidas OWNER TO tintegro;

--
-- TOC entry 783 (class 1247 OID 66848)
-- Name: consolidado_llamadas_recibidas_rango; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE consolidado_llamadas_recibidas_rango AS (
	id integer,
	no_queuename character varying,
	no_anio character varying,
	no_mes character varying,
	no_dia character varying,
	no_dia_semana character varying,
	nu_cantidad integer
);


ALTER TYPE consolidado_llamadas_recibidas_rango OWNER TO tintegro;

--
-- TOC entry 801 (class 1247 OID 66851)
-- Name: dia_local; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE dia_local AS (
	nu_dia integer
);


ALTER TYPE dia_local OWNER TO tintegro;

--
-- TOC entry 804 (class 1247 OID 66854)
-- Name: estado_agente; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE estado_agente AS (
	id_estado integer,
	no_estage character varying(20),
	fe_iniest date,
	ho_iniest time without time zone,
	fe_finest date,
	ho_finest time without time zone,
	ti_estmin time without time zone,
	ti_estseg integer
);


ALTER TYPE estado_agente OWNER TO tintegro;

--
-- TOC entry 807 (class 1247 OID 66857)
-- Name: llam_ate_aban_resul; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llam_ate_aban_resul AS (
	mes integer,
	contestadas integer,
	abandonadas integer,
	va_total integer,
	va_porc integer
);


ALTER TYPE llam_ate_aban_resul OWNER TO tintegro;

--
-- TOC entry 810 (class 1247 OID 66860)
-- Name: llamada_abandonas_minutos; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_abandonas_minutos AS (
	nu_llam character varying,
	aba_menor character varying,
	aba_mayor character varying
);


ALTER TYPE llamada_abandonas_minutos OWNER TO tintegro;

--
-- TOC entry 813 (class 1247 OID 66863)
-- Name: llamada_abandonas_minutos_fecha; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_abandonas_minutos_fecha AS (
	id_llamada integer,
	fe_rango date,
	nu_llam character varying,
	aba_menor character varying,
	aba_mayor character varying
);


ALTER TYPE llamada_abandonas_minutos_fecha OWNER TO tintegro;

--
-- TOC entry 816 (class 1247 OID 66866)
-- Name: llamada_agente; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_agente AS (
	fecha_hora character varying,
	id_agente integer,
	no_agente character varying,
	nu_llamate integer,
	nu_llamculcli integer,
	nu_llamculage integer,
	ca_hablad time without time zone,
	ca_prohab time without time zone,
	ca_minhab time without time zone,
	ca_maxhab time without time zone
);


ALTER TYPE llamada_agente OWNER TO tintegro;

--
-- TOC entry 819 (class 1247 OID 66869)
-- Name: llamada_consolidado3; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_consolidado3 AS (
	anexo character varying,
	e_contestada integer,
	e_nocontestada integer,
	e_fallida integer,
	total_entrante integer,
	total_inhablando integer,
	total_inhablando2 character varying,
	s_contestada integer,
	s_nocontestada integer,
	s_fallida integer,
	total_saliente integer,
	total_outhablando integer,
	total_outhablando2 character varying
);


ALTER TYPE llamada_consolidado3 OWNER TO tintegro;

--
-- TOC entry 822 (class 1247 OID 66872)
-- Name: llamada_contestada; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_contestada AS (
	id_lla text,
	fe_ini date,
	ho_ini time(0) without time zone,
	fe_fin date,
	ho_fin time(0) without time zone,
	nu_ani character varying,
	ti_dur character varying,
	no_age character varying,
	no_col character varying
);


ALTER TYPE llamada_contestada OWNER TO tintegro;

--
-- TOC entry 870 (class 1247 OID 66875)
-- Name: llamada_contestada_ac; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_contestada_ac AS (
	id integer,
	no_queue character varying,
	no_agente character varying,
	fe_act date,
	ho_act time(0) without time zone,
	ti_dur character varying,
	nu_act character varying
);


ALTER TYPE llamada_contestada_ac OWNER TO tintegro;

--
-- TOC entry 825 (class 1247 OID 66878)
-- Name: llamada_dia_hora; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_dia_hora AS (
	dia character varying,
	llama00 integer,
	llama01 integer,
	llama02 integer,
	llama03 integer,
	llama04 integer,
	llama05 integer,
	llama06 integer,
	llama07 integer,
	llama08 integer,
	llama09 integer,
	llama10 integer,
	llama11 integer,
	llama12 integer,
	llama13 integer,
	llama14 integer,
	llama15 integer,
	llama16 integer,
	llama17 integer,
	llama18 integer,
	llama19 integer,
	llama20 integer,
	llama21 integer,
	llama22 integer,
	llama23 integer
);


ALTER TYPE llamada_dia_hora OWNER TO tintegro;

--
-- TOC entry 828 (class 1247 OID 66881)
-- Name: llamada_general; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_general AS (
	src character varying,
	dst character varying,
	clid character varying,
	fe_llamad date,
	ho_llamad time without time zone,
	ca_duraci integer,
	ca_bilsec integer,
	ca_duracimin time without time zone,
	ca_bilsecmin time without time zone,
	va_dispos character varying(30)
);


ALTER TYPE llamada_general OWNER TO tintegro;

--
-- TOC entry 831 (class 1247 OID 66884)
-- Name: llamada_general2; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_general2 AS (
	src character varying,
	dst character varying,
	clid character varying,
	fe_llamad date,
	ho_llamad time without time zone,
	ca_duraci integer,
	ca_bilsec integer,
	ca_duracimin character varying,
	ca_bilsecmin time without time zone,
	va_dispos character varying(30)
);


ALTER TYPE llamada_general2 OWNER TO tintegro;

--
-- TOC entry 1203 (class 1247 OID 144678)
-- Name: llamada_general_new; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_general_new AS (
	src character varying,
	dst character varying,
	clid character varying,
	fe_llamad character varying,
	ho_llamad character varying,
	ca_duraci integer,
	ca_bilsec integer,
	ca_duracimin character varying,
	ca_bilsecmin character varying,
	va_dispos character varying(30)
);


ALTER TYPE llamada_general_new OWNER TO tintegro;

--
-- TOC entry 1227 (class 1247 OID 144773)
-- Name: llamada_general_report; Type: TYPE; Schema: reportes; Owner: postgres
--

CREATE TYPE llamada_general_report AS (
	src character varying,
	dst character varying,
	clid character varying,
	fe_llamad character varying,
	ho_llamad character varying,
	ca_duraci integer,
	ca_bilsec integer,
	ca_duracimin character varying,
	ca_bilsecmin character varying,
	va_dispos character varying(30),
	nu_total_reg integer
);


ALTER TYPE llamada_general_report OWNER TO postgres;

--
-- TOC entry 834 (class 1247 OID 66887)
-- Name: llamada_usuario; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario AS (
	no_usuari character varying,
	fe_llamad date,
	ho_llamad time without time zone,
	dst character varying,
	ca_duraci integer,
	ca_duracmin time without time zone,
	va_dispos character varying(30),
	src character varying
);


ALTER TYPE llamada_usuario OWNER TO tintegro;

--
-- TOC entry 1215 (class 1247 OID 144674)
-- Name: llamada_usuario_new; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario_new AS (
	no_usuari character varying,
	fe_llamad character varying,
	ho_llamad character varying,
	dst character varying,
	ca_duraci integer,
	ca_duracmin character varying,
	va_dispos character varying(30),
	src character varying
);


ALTER TYPE llamada_usuario_new OWNER TO tintegro;

--
-- TOC entry 1206 (class 1247 OID 144702)
-- Name: llamada_usuario_report; Type: TYPE; Schema: reportes; Owner: postgres
--

CREATE TYPE llamada_usuario_report AS (
	no_usuari character varying,
	fe_llamad character varying,
	ho_llamad character varying,
	dst character varying,
	ca_duraci integer,
	ca_duracmin character varying,
	va_dispos character varying(30),
	src character varying,
	nu_total_reg integer
);


ALTER TYPE llamada_usuario_report OWNER TO postgres;

--
-- TOC entry 837 (class 1247 OID 66890)
-- Name: llamada_usuario_top; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario_top AS (
	id_usuari integer,
	no_usuari character varying,
	ca_llamad integer,
	ca_duraci time without time zone,
	ca_duraprom time without time zone,
	ca_duracmin time without time zone,
	ca_duracmax time without time zone
);


ALTER TYPE llamada_usuario_top OWNER TO tintegro;

--
-- TOC entry 840 (class 1247 OID 66893)
-- Name: llamada_usuario_top_detalle; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario_top_detalle AS (
	no_usuari character varying(60),
	fe_llamad date,
	ho_llamad time without time zone,
	src character varying,
	dst character varying,
	ca_duraci time without time zone,
	va_dispos character varying(30)
);


ALTER TYPE llamada_usuario_top_detalle OWNER TO tintegro;

--
-- TOC entry 843 (class 1247 OID 66896)
-- Name: llamada_usuario_top_dia; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario_top_dia AS (
	id_usuari integer,
	no_usuari character varying,
	fe_llamad date,
	ca_llamad integer,
	ca_duraci time without time zone,
	ca_duraprom time without time zone,
	ca_duracmin time without time zone,
	ca_duracmax time without time zone
);


ALTER TYPE llamada_usuario_top_dia OWNER TO tintegro;

--
-- TOC entry 1230 (class 1247 OID 144776)
-- Name: llamada_usuario_top_report; Type: TYPE; Schema: reportes; Owner: postgres
--

CREATE TYPE llamada_usuario_top_report AS (
	id_usuari integer,
	no_usuari character varying,
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying,
	nu_total_reg integer
);


ALTER TYPE llamada_usuario_top_report OWNER TO postgres;

--
-- TOC entry 1218 (class 1247 OID 144682)
-- Name: llamada_usuario_topii; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamada_usuario_topii AS (
	id_usuari integer,
	no_usuari character varying,
	ca_llamad integer,
	ca_duraci character varying,
	ca_duraprom character varying,
	ca_duracmin character varying,
	ca_duracmax character varying
);


ALTER TYPE llamada_usuario_topii OWNER TO tintegro;

--
-- TOC entry 846 (class 1247 OID 66899)
-- Name: llamadas_atendida_abandonadas; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamadas_atendida_abandonadas AS (
	id_queuename integer,
	no_queuename character varying,
	mes character varying,
	no_agente character varying,
	data5 character varying,
	contestadas integer
);


ALTER TYPE llamadas_atendida_abandonadas OWNER TO tintegro;

--
-- TOC entry 873 (class 1247 OID 66902)
-- Name: llamadas_atendida_abandonadas_list; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamadas_atendida_abandonadas_list AS (
	id_queuename integer,
	no_queuename character varying,
	no_agente character varying,
	data5 character varying,
	espera character varying,
	conversa character varying,
	contestadas integer
);


ALTER TYPE llamadas_atendida_abandonadas_list OWNER TO tintegro;

--
-- TOC entry 849 (class 1247 OID 66905)
-- Name: llamadas_atendida_abandonadas_rango; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamadas_atendida_abandonadas_rango AS (
	id_queuename integer,
	no_queuename character varying,
	no_agente character varying,
	data5 character varying,
	contestadas integer,
	pr_espera character varying,
	pr_conversa character varying
);


ALTER TYPE llamadas_atendida_abandonadas_rango OWNER TO tintegro;

--
-- TOC entry 855 (class 1247 OID 66908)
-- Name: llamadas_entrantes_xhora; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE llamadas_entrantes_xhora AS (
	id_queuename integer,
	no_queuename character varying,
	mes integer,
	ano integer,
	hora character varying,
	entrante integer,
	atendido integer,
	abandono integer
);


ALTER TYPE llamadas_entrantes_xhora OWNER TO tintegro;

--
-- TOC entry 852 (class 1247 OID 66911)
-- Name: reporte_abandonos_ac; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE reporte_abandonos_ac AS (
	uniqueid text,
	queuename character varying,
	fecha date,
	qtime time(0) without time zone,
	info3 integer,
	numero character varying
);


ALTER TYPE reporte_abandonos_ac OWNER TO tintegro;

--
-- TOC entry 861 (class 1247 OID 66914)
-- Name: respuesta_operador; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE respuesta_operador AS (
	fe_llamad character varying,
	lla_entra integer,
	lla_atendi integer,
	lla_atetab integer,
	lla_abando integer,
	lla_abatab integer,
	lla_disuac integer,
	lla_atens integer,
	ti_procon integer,
	ti_proesp integer,
	ti_ema integer,
	ti_abando integer
);


ALTER TYPE respuesta_operador OWNER TO tintegro;

--
-- TOC entry 858 (class 1247 OID 66917)
-- Name: rpt_comparativo_colas; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE rpt_comparativo_colas AS (
	id_queuename integer,
	nu_tipo integer,
	no_queuename character varying,
	nu_dia integer,
	dia_real character varying,
	nu_cantidad integer
);


ALTER TYPE rpt_comparativo_colas OWNER TO tintegro;

--
-- TOC entry 864 (class 1247 OID 66920)
-- Name: rpt_llamadas_abandonadas; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE rpt_llamadas_abandonadas AS (
	id_queuename integer,
	no_queuename character varying,
	fe_fecha date,
	nu_30 integer,
	nu_45 integer,
	nu_60 integer
);


ALTER TYPE rpt_llamadas_abandonadas OWNER TO tintegro;

--
-- TOC entry 867 (class 1247 OID 66923)
-- Name: rpt_nivel_servicio; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE rpt_nivel_servicio AS (
	fe_actual date,
	no_queuename character varying,
	total integer,
	a10s integer,
	ns10 integer,
	a20s integer,
	ns20 integer,
	a30s integer,
	ns30 integer,
	a40s integer,
	ns40 integer,
	a50s integer,
	ns50 integer,
	a60s integer,
	ns60 integer
);


ALTER TYPE rpt_nivel_servicio OWNER TO tintegro;

--
-- TOC entry 876 (class 1247 OID 66926)
-- Name: tiempo_espera; Type: TYPE; Schema: reportes; Owner: tintegro
--

CREATE TYPE tiempo_espera AS (
	nu_promedio character varying,
	nu_minimo character varying,
	nu_maximo character varying
);


ALTER TYPE tiempo_espera OWNER TO tintegro;

SET search_path = asterisk, pg_catalog;

--
-- TOC entry 334 (class 1255 OID 70501)
-- Name: actualiza_agente(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_agente() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
  if (TG_OP = 'UPDATE') then
  	if (NEW.fullcontact = '' or NEW.fullcontact is NULL) then
      update asterisk.agente set es_usuari = 0
      where es_usuari::varchar = OLD.name;
   	end if;
  end if;
return old;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_agente() OWNER TO tintegro;

--
-- TOC entry 437 (class 1255 OID 70502)
-- Name: actualiza_agente_callcenter(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_agente_callcenter() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
  if (TG_OP = 'INSERT') then
  	PERFORM dblink_exec('host=localhost port=5432 dbname=CallCenter user=tcontacta password=tcontacta', 
      				'insert into call.tbagente
      				(id_agente, nu_agente, no_apepat, no_apemat, no_nombre, co_campana) 
      				values( '|| NEW.id ||',''' || NEW.nu_agente ||''' ,''' || NEW.no_apepat ||''',''' || NEW.no_apemat ||''',''' || NEW.no_nombre ||''',1)');
  end if;
  
  if (TG_OP = 'UPDATE') then
  	PERFORM dblink_exec('host=localhost port=5432 dbname=CallCenter user=tcontacta password=tcontacta', 
      				'update call.tbagente set 
                    no_apepat = ''' || NEW.no_apepat ||''',
                    no_apemat = ''' || NEW.no_apemat ||''',
                    no_nombre = ''' || NEW.no_nombre ||'''
                    where nu_agente = ''' || NEW.nu_agente || ''' ');
                    
  end if;
  
return old;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_agente_callcenter() OWNER TO tintegro;

--
-- TOC entry 335 (class 1255 OID 70503)
-- Name: actualiza_cola_call(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_cola_call() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  if (TG_OP = 'INSERT') then
  	PERFORM dblink_exec('host=localhost port=5432 dbname=CallCenter user=tcontacta password=tcontacta', 
      				'insert into call.tccampan (co_campan, no_campan) values ('||NEW.id ||', '''|| NEW.name||''')'); 
  end if;
return old;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_cola_call() OWNER TO tintegro;

--
-- TOC entry 336 (class 1255 OID 70504)
-- Name: actualiza_cola_callcenter(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_cola_callcenter() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
  if (TG_OP = 'INSERT') then
  	PERFORM dblink_exec('host=localhost port=5432 dbname=CallCenter user=tcontacta password=tcontacta', 
      				'update call.tbagente set co_campana = '||NEW.id_cola ||' where id_agente = '|| NEW.id_agente); 
  end if;
return old;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_cola_callcenter() OWNER TO tintegro;

--
-- TOC entry 337 (class 1255 OID 70505)
-- Name: actualiza_disposition(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_disposition() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
  if (TG_OP = 'UPDATE') then
   --raise exception '%, %', OLD.disposition, OLD.id;
  	update asterisk.ast_cdr set disposition = (case when disposition = 1 then 'FAILED'
        												 when disposition = 4 then 'NO ANSWER'
                                                         when disposition = 8 then 'ANSWERED'
                                                         else disposition 
    												end)
    where id = OLD.id;
    raise EXCEPTION '%, %', OLD.disposition, OLD.id;
  end if;
return old;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_disposition() OWNER TO tintegro;

--
-- TOC entry 423 (class 1255 OID 70506)
-- Name: actualiza_pin(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_pin() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
     raise notice 'entro al trigger';
	--if (TG_OP = 'INSERT') then
	--raise notice 'entro al if';
	--	if(length(NEW.nu_pin) < 10) then
		--	NEW.nu_pin := md5(NEW.nu_pin);
	--	end if;
	--End if;

	if (TG_OP = 'UPDATE') then
	raise notice 'entro a UPDATE';
		if(length(NEW.nu_pin) < 10) then
			NEW.nu_pin := md5(NEW.nu_pin);
		end if;
	end if;

	
  
return new;        
END;
$$;


ALTER FUNCTION asterisk.actualiza_pin() OWNER TO tintegro;

--
-- TOC entry 434 (class 1255 OID 70507)
-- Name: actualiza_queue_members_table(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_queue_members_table() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_id_usuario integer := null;
    v_uniqueid varchar := null;
    v_num_pin varchar := null;
BEGIN
   
    IF (TG_OP = 'INSERT') THEN

	UPDATE asterisk.queue_member_table SET 
	membername = (SELECT  no_apepat ||' '|| no_apemat ||' '||  no_nombre  FROM asterisk.agente WHERE id_agente = NEW.id_agente) where id_agente = NEW.id_agente;
        
      RETURN NEW;
        
    END IF;

    IF (TG_OP = 'UPDATE') THEN
	--raise exception '%', (SELECT  no_apepat ||' '|| no_apemat FROM asterisk.agente a WHERE a.id_agente = OLD.id_agente);
	--UPDATE asterisk.queue_member_table SET 
	NEW.penalty = 2;
	NEW.membername = (SELECT  no_apepat ||' '|| no_apemat FROM asterisk.agente a WHERE a.id_agente = OLD.id_agente) ;
	--where id_agente = OLD.id_agente;
        
      RETURN NEW;
        
    END IF;

    
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_queue_members_table() OWNER TO tintegro;

--
-- TOC entry 341 (class 1255 OID 70508)
-- Name: actualiza_usuario(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_usuario() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE

        
BEGIN

  
    IF (TG_OP = 'UPDATE') THEN

	raise notice 'old.id_usuari %', old.id_usuari;
	raise notice 'new.id_usuari %', new.id_usuari;

	raise notice 'new.il_mostrar %', new.il_mostrar;

	if new.il_mostrar = FALSE and old.il_mostrar <> new.il_mostrar then
	
		delete from asterisk.tb_bolsausuario where id_usuari = old.id_usuari;

		delete from asterisk.tb_pin where id_usupin = old.id_usuari;

		INSERT INTO asterisk.tb_usuario_eliminado(
		id_usuari, no_apepat, no_apemat, no_nombre, no_puesto, nu_pin, 
		ti_llamad, il_activo, il_mostrar, id_empare, il_bolsa)
		VALUES (old.id_usuari, old.no_apepat, old.no_apemat, old.no_nombre, old.no_puesto, old.nu_pin, 
		old.ti_llamad, old.il_activo, new.il_mostrar, old.id_empare, old.il_bolsa);

		delete from asterisk.tb_usuario where id_usuari = old.id_usuari;

		
	end if;
         
        RETURN OLD;
        
    END IF;
    
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_usuario() OWNER TO tintegro;

--
-- TOC entry 342 (class 1255 OID 70509)
-- Name: actualiza_usuario_bolsa(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_usuario_bolsa() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE

    v_bolsa BOOLEAN := FALSE;
    v_cant_per INTEGER := 0;
    v_empare integer := NULL;
    v_id_padre integer := NULL;
    v_minarea integer := NULL;
    v_minemp integer := NULL;
    
    
BEGIN

    
   
    IF (TG_OP = 'INSERT') THEN

	-- Saca el id_empare
	    select id_empare into v_empare from asterisk.tb_usuario where id_usuari = NEW.id_usuari;

	-- Saca el id_padre
	    select id_padre into v_id_padre from asterisk.empresa_area where id_empare = v_empare;

	    update asterisk.tb_usuario 
            set il_bolsa = TRUE 
            where id_usuari = NEW.id_usuari;
            
            update asterisk.tb_bolsausuario 
            set fe_ultmod = NEW.fe_inibol 
            where id_usuari = NEW.id_usuari
            and id_tiptel = NEW.id_tiptel
            and id_clave = NEW.id_clave;

            select sum(ca_minbol) into v_minemp from asterisk.tb_bolsausuario 
	    where id_usuari in (select id_usuari from asterisk.tb_usuario where id_empare = v_empare)
	    and id_tiptel = NEW.id_tiptel
            and id_clave = NEW.id_clave;

            update asterisk.tb_bolsaempresa 
            set ca_conmin = v_minemp,
            ca_resmin = ca_minbol - v_minemp
            where id_empare = v_empare
            and id_tiptel = NEW.id_tiptel
            and id_clave = NEW.id_clave;

            if v_id_padre is not null then

		select sum(ca_minbol) into v_minarea 
		from asterisk.tb_bolsaempresa
		where id_empare in (select id_empare from asterisk.empresa_area  where id_padre = v_id_padre);

		update asterisk.tb_bolsaempresa
		set ca_conmin = v_minarea,
		ca_resmin = ca_minbol - v_minarea
		where id_empare = v_id_padre;
		
            end if;
         
        RETURN NEW;
        
    END IF;
    
    IF (TG_OP = 'UPDATE') THEN

	select id_empare into v_empare from asterisk.tb_usuario where id_usuari = OLD.id_usuari;
	
	select id_padre into v_id_padre from asterisk.empresa_area where id_empare = v_empare;

   	IF OLD.ca_minbol <> NEW.ca_minbol THEN
			
              update asterisk.tb_bolsausuario 
              set ca_conseg = 0,
              ca_segbol = NEW.ca_minbol*60,
              ca_resseg = NEW.ca_minbol*60
              where id_usuari = OLD.id_usuari
              and id_tiptel = OLD.id_tiptel
              and id_clave = OLD.id_clave;

              select sum(ca_minbol) into v_minemp from asterisk.tb_bolsausuario 
	      where id_usuari in (select id_usuari from asterisk.tb_usuario where id_empare = v_empare)
	      and id_tiptel = OLD.id_tiptel
              and id_clave = OLD.id_clave;

              update asterisk.tb_bolsaempresa 
              set ca_conmin = v_minemp,
              ca_resmin = ca_minbol - v_minemp
              where id_empare = v_empare
              and id_tiptel = OLD.id_tiptel
              and id_clave = OLD.id_clave;

            if v_id_padre is not null then

		select sum(ca_minbol) into v_minarea 
		from asterisk.tb_bolsaempresa
		where id_empare in (select id_empare from asterisk.empresa_area where id_padre = v_id_padre);

		update asterisk.tb_bolsaempresa
		set ca_conmin = v_minarea,
		ca_resmin = ca_minbol - v_minarea
		where id_empare = v_id_padre;
		
            end if;            
            
        END IF;            
                       

         
        RETURN NEW;
        
    END IF;
    
    IF (TG_OP = 'DELETE') THEN

	select id_empare into v_empare from asterisk.tb_usuario where id_usuari = OLD.id_usuari;

        select id_padre into v_id_padre from asterisk.empresa_area where id_empare = v_empare;
			
    	select count(*) into v_cant_per from asterisk.tb_bolsausuario where id_usuari = OLD.id_usuari;
    	
		raise notice  'valor %', v_cant_per;
		if v_cant_per = 0 THEN
   			update asterisk.tb_usuario set il_bolsa = FALSE where id_usuari = OLD.id_usuari;
		end if;

         select sum(ca_minbol) into v_minemp from asterisk.tb_bolsausuario 
	 where id_usuari in (select id_usuari from asterisk.tb_usuario where id_empare = v_empare)
	 and id_tiptel = OLD.id_tiptel
         and id_clave = OLD.id_clave;

	raise notice  'v_minemp %', v_minemp;

        update asterisk.tb_bolsaempresa 
        set ca_conmin = ca_conmin - OLD.ca_minbol,
        ca_resmin = ca_resmin + OLD.ca_minbol      
        where id_empare = v_empare
        and id_tiptel = OLD.id_tiptel
        and id_clave = OLD.id_clave;  

        if v_id_padre is not null then

		select sum(ca_minbol) into v_minarea 
		from asterisk.tb_bolsaempresa
		where id_empare in (select id_empare from asterisk.empresa_area  where id_padre = v_id_padre);

		update asterisk.tb_bolsaempresa
		set ca_conmin = v_minarea,
		ca_resmin = ca_minbol - v_minarea
		where id_empare = v_id_padre;
		
        end if;
         
        RETURN OLD;
        
    END IF;
    
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_usuario_bolsa() OWNER TO tintegro;

--
-- TOC entry 338 (class 1255 OID 70510)
-- Name: actualiza_usuario_cdr(); Type: FUNCTION; Schema: asterisk; Owner: postgres
--

CREATE FUNCTION actualiza_usuario_cdr() RETURNS SETOF trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_id_usuario integer := null;
    v_uniqueid varchar := null;
    v_num_pin varchar := null;
    v_area integer := null;
    v_bolsa BOOLEAN := FALSE;
    v_nu_agente varchar := null;
    
BEGIN

          
    IF (TG_OP = 'INSERT') THEN
                  
          select u.id_usuari, u.id_empare into v_id_usuario, v_area
          from asterisk.tb_usuario u
          where u.nu_pin = md5(NEW.accountcode)
          and u.il_activo = true;
          
          select u.il_activo into v_bolsa
          from asterisk.tb_bolsausuario u
          where u.id_usuari = v_id_usuario;
                    
          if v_id_usuario is not NULL then 
            update asterisk.cdr set 
            	id_usuario = v_id_usuario,
                id_area = v_area,
                dst = (case when v_num_pin = substr(dst,1,4) and length(dst::text) > 6 then substr(dst,5) else dst end)
            where uniqueid = NEW.uniqueid;
  			
            if NEW.disposition = 'ANSWERED' and NEW.duration > NEW.billsec then
              if v_bolsa then
              	update asterisk.tb_bolsausuario set
                	ca_conseg = ca_conseg + NEW.billsec,
                    ca_resseg = ca_resseg - NEW.billsec
                where id_usuari = v_id_usuario
                and id_tiptel = substr(NEW.userfield,1,1)::integer
                and id_clave = substr(NEW.userfield,2,1)::integer;
                
              
              end if;
            end if;
            
          end if;
                   
         --Para actualizar el agente 
         --cuando es call-to-agent dst es el agente
	 --cuando es registro-agente src es el agente
	 if NEW.dcontext = 'call-to-agent' then
		select (select nu_agente from asterisk.agente a where a.id_agente = q.id_agente) into v_nu_agente from asterisk.queue_members q where q.interface = 'Local/' || trim(NEW.dst) || '@call-to-agent/n';
		if v_nu_agente is not NULL then
			update asterisk.cdr set 
			dst = v_nu_agente
			where uniqueid = NEW.uniqueid;
		end if;
          end if;

	 if NEW.dcontext = 'registro-agente' then
		select (select nu_agente from asterisk.agente a where a.id_agente = q.id_agente) into v_nu_agente from asterisk.queue_members q where q.interface = 'Local/' || trim(NEW.src) || '@call-to-agent/n';
		if v_nu_agente is not NULL then
			update asterisk.cdr set 
			src = v_nu_agente                
			where uniqueid = NEW.uniqueid;
		end if;
          end if;

        RETURN NEW;
        
    END IF;

   RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_usuario_cdr() OWNER TO postgres;

--
-- TOC entry 343 (class 1255 OID 70511)
-- Name: actualiza_usuario_eliminado(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_usuario_eliminado() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_id_usuario integer := null;
    v_uniqueid varchar := null;
    v_num_pin varchar := null;
BEGIN
   
    IF (TG_OP = 'UPDATE') THEN
    
    if (NEW.es_usuari is NULL) then
    	update asterisk.agente
            set es_usuari = 0
        where id_agente = OLD.id_agente;
    end if;
        	          
    	if (NEW.il_activo = 0 and OLD.il_activo != NEW.il_activo) then
    
    		update asterisk.agente
            	set no_locacion = NULL,
                	nu_accion = NULL,
                    co_estado = 2
            where id = OLD.id;
            
            delete from asterisk.queue_members
            where id_agente = NEW.id_agente;            
           
    	end if;
        
        RETURN NEW;
        
    END IF;
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_usuario_eliminado() OWNER TO tintegro;

--
-- TOC entry 344 (class 1255 OID 70512)
-- Name: actualiza_usuario_errado(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualiza_usuario_errado() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
   
    IF (TG_OP = 'UPDATE') THEN
        	          
    	if (NEW.fullcontact = '' or NEW.fullcontact is NULL) then
    
            delete from asterisk.queue_members
            where split_part(split_part(interface, '@',1), '/', 2) = split_part(split_part(OLD.fullcontact, '@',1), ':', 2);

    		update asterisk.agente
            	set no_locacion = NULL,
                	nu_accion = NULL,
                    co_estado = 2
            where split_part(no_locacion, '/',2) = split_part(split_part(OLD.fullcontact, '@',1), ':', 2);
            
    	end if;
        
        RETURN NEW;
        
    END IF;
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_usuario_errado() OWNER TO tintegro;

--
-- TOC entry 339 (class 1255 OID 70513)
-- Name: actualiza_var_meetme(); Type: FUNCTION; Schema: asterisk; Owner: postgres
--

CREATE FUNCTION actualiza_var_meetme() RETURNS SETOF trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    
BEGIN
   
    IF (TG_OP = 'INSERT') THEN
        	          
          	update asterisk.tb_meetme set 
			no_varadm = replace(NEW.no_varadm, 'm', '')
		where id_meetme = NEW.id_meetme;
          
        RETURN NEW;
        
    END IF;

    IF (TG_OP = 'UPDATE') THEN
        	IF (OLD.no_varadm <> NEW.no_varadm) THEN      
          	update asterisk.tb_meetme set 
			no_varadm = replace(NEW.no_varadm, 'm', '')
		where id_meetme = NEW.id_meetme;

		END IF;
          
        RETURN NEW;
        
    END IF;
    
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.actualiza_var_meetme() OWNER TO postgres;

--
-- TOC entry 470 (class 1255 OID 119981)
-- Name: actualizar_area_centro(integer, character varying, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION actualizar_area_centro(p_id_empare integer, p_nombre character varying, p_id_padre integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return asterisk.tp_resultado%rowtype;
 v_nombre varchar:= trim(upper(p_nombre)); 
 v_id_padre INTEGER:=p_id_padre; 
 v_id_empare integer := p_id_empare;
 
 BEGIN 

if v_id_padre is null then -- Entonces actualizamos ¡rea
	if (select id_empare from asterisk.empresa_area where trim(upper(nombre)) = upper(v_nombre) and tipo = 1) is null then 
		UPDATE asterisk.empresa_area SET nombre = v_nombre where id_empare = v_id_empare;
		for v_va_return in 
				select 1, 'ok'
		loop    
		return next v_va_return;
		end loop; 
	else 
		for v_va_return in 
				select -1, 'El nombre de Area que desea actualizar ya existe.'
		loop    
		return next v_va_return;
		end loop; 
	end if;
else if v_id_padre is not null then -- Entonces actualizamos Centro de costo
	if (select id_empare from asterisk.empresa_area where trim(upper(nombre)) = upper(v_nombre) and id_padre = v_id_padre and tipo = 2 limit 1) is null then 
		UPDATE asterisk.empresa_area SET nombre = v_nombre, id_padre= v_id_padre WHERE id_empare = v_id_empare;
		for v_va_return in 
				select 1, 'ok'
		loop    
		return next v_va_return;
		end loop; 
	else 
		for v_va_return in 
				select -1, 'El nombre del Centro de Costo que desea actualizar ya existe.'
		loop    
		return next v_va_return;
		end loop; 
	end if;	
end if;
end if;

return;
END;
$$;


ALTER FUNCTION asterisk.actualizar_area_centro(p_id_empare integer, p_nombre character varying, p_id_padre integer) OWNER TO tintegro;

--
-- TOC entry 444 (class 1255 OID 70514)
-- Name: cambiar_estado_agente(character varying, character varying, character varying, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION cambiar_estado_agente(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying, p_co_estado integer) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	v_il_respta INTEGER := NULL;
    
	v_nu_agente INTEGER := p_nu_agente::INTEGER;
	v_pin INTEGER := p_pin::INTEGER;
	v_no_locacion VARCHAR := p_no_locacion;
	v_co_estado INTEGER := p_co_estado;
	v_tmp_locacion VARCHAR := NULL;
	v_il_logage BOOLEAN := false;
	v_il_logque BOOLEAN := false;
	v_co_estado_old smallint := NULL;
	v_ti_estado smallint := NULL;
	v_il_datcorrec BOOLEAN := false;
	v_id_agente INTEGER := NULL;
	v_ca_colas INTEGER := NULL;
	v_il_activo smallint := null;
    
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select (case when id_agente is null then false else true end) into v_il_datcorrec 
    from asterisk.agente where nu_agente = v_nu_agente and nu_pin = v_pin;
    
   --Saca el id del agente y verifica si esta logueado, en que estado y que tipo de login es
    select a.id_agente, (case when a.no_locacion is null then false else true end), a.co_estado, e.ti_estado, a.no_locacion, a.il_activo
    into v_id_agente, v_il_logage, v_co_estado_old, v_ti_estado, v_tmp_locacion, v_il_activo
    from asterisk.agente a,
    	asterisk.tc_estado e
    where a.co_estado = e.id_estage
    and a.nu_agente = v_nu_agente
    and a.nu_pin = v_pin
    and a.il_activo = 1;
    
    --Verifica si tiene colas asignadas
    select count(*) into v_ca_colas from asterisk.agente_por_cola where id_agecola = v_id_agente;
    
    --Verifica si esta en queue_members
    if EXISTS (select * from asterisk.queue_members where interface = v_no_locacion) then
	    v_il_logque := TRUE;
    end if;
    
    if v_il_activo = 1 then
    
      if v_ca_colas > 0 then
  	
          if v_no_locacion = v_tmp_locacion or v_tmp_locacion is NULL then 

            if v_il_datcorrec then
        	   
               if (v_il_logque is FALSE) then 
                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = p_co_estado
                    WHERE nu_agente = v_nu_agente
                    AND nu_pin = v_pin
                    and il_activo = 1;

                    insert into asterisk.queue_members (
					  queue_name,
					  interface,
					  penalty,
					  membername,
					  paused
					)
					    select 
						    q.name, 
						    'SIP/' || v_no_locacion,  
						    ac.nu_prorid, 
						    'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || v_no_locacion || '/' || v_id_agente || '@', 
						    (case when p_co_estado in (1, 6) then 0 else 1 end)
					    from asterisk.queues q,
						 asterisk.agente_por_cola ac,
						 asterisk.agente a
					    where q.id_queues = ac.id_cola
					    and ac.id_agecola = a.id_agente
					    and a.nu_agente = v_nu_agente;
                     
               elsif ( v_il_logage is FALSE and v_il_logque) then 
                    --raise notice 'entro en false, true';
                    delete from asterisk.queue_members
                    where interface = v_no_locacion;

                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = p_co_estado
                    WHERE nu_agente = v_nu_agente
                    AND nu_pin = v_pin
                    and il_activo = 1;

			  insert into asterisk.queue_members (
					  queue_name,
					  interface,
					  penalty,
					  membername,
					  paused
					)
					
					    select 
					            q.name, 
						    'SIP/' || v_no_locacion,  
						    ac.nu_prorid, 
						    'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || v_no_locacion || '/' || v_id_agente || '@', 
						    (case when p_co_estado in (1, 6) then 0 else 1 end)
					    from asterisk.queues q,
						  asterisk.agente_por_cola ac,
						  asterisk.agente a
					    where q.id_queues = ac.id_cola
					    and ac.id_agecola = a.id_agente
					    and a.nu_agente = v_nu_agente;
                  
                      
               elsif (v_il_logage and v_il_logque ) then 
                      UPDATE asterisk.agente 
                      SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = p_co_estado
                      WHERE nu_agente = v_nu_agente;
                      
                      UPDATE asterisk.queue_members
                          SET paused = case when p_co_estado in (1, 6) then 0 else 1 end --1
                      WHERE interface = v_no_locacion;                          
                          
               end if;
               --raise notice '%', v_co_estado;
               if v_co_estado_old = p_co_estado then 
                  v_il_respta := 0; --ya se encuentra en el estado escogido.
               else 
                  v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,p_co_estado));
                  v_il_respta := p_co_estado;
               end if;
            
            else
                v_il_respta := -1; --Datos de login incorrectos. num_agente y pin
            end if;
          else
              v_il_respta := -2; --otro ya se encuentra logueado
          end if;
      else 
          v_il_respta := -4; --No tiene colas asignadas
      end if;
    else
--    	v_il_respta := -5; --Usuario inactivo
        v_il_respta := -1; --Usuario inactivo
    end if;
        
	RETURN next v_il_respta;

RETURN;
END;
$$;


ALTER FUNCTION asterisk.cambiar_estado_agente(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying, p_co_estado integer) OWNER TO tintegro;

--
-- TOC entry 340 (class 1255 OID 70515)
-- Name: cambio_clave(character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION cambio_clave(p_pin character varying, p_n_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_pin varchar := p_pin;
  v_n_pin varchar := p_n_pin;
  
BEGIN

  update asterisk.tb_usuario set nu_pin = p_n_pin where nu_pin = p_pin and il_activo = 'true';

 
END;
$$;


ALTER FUNCTION asterisk.cambio_clave(p_pin character varying, p_n_pin character varying) OWNER TO tintegro;

--
-- TOC entry 445 (class 1255 OID 70516)
-- Name: consulta_clave(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION consulta_clave(p_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_pin varchar := p_pin;
  
BEGIN

  select (select nu_pin from asterisk.tb_usuario where nu_pin = v_pin and il_activo='true') into v_va_return;

  if v_va_return is NULL then
      v_va_return := -1;
  else 
      v_va_return := 1;
  end if;
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.consulta_clave(p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 345 (class 1255 OID 70517)
-- Name: consulta_nueva_clave(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION consulta_nueva_clave(p_n_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_n_pin varchar := p_n_pin;
  
BEGIN

  select (select nu_pin from asterisk.tb_usuario where nu_pin = v_n_pin) into v_va_return;

  if v_va_return is NULL then
      v_va_return := -1;
  else 
      v_va_return := 1;
  end if;
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.consulta_nueva_clave(p_n_pin character varying) OWNER TO tintegro;

--
-- TOC entry 346 (class 1255 OID 70518)
-- Name: del_queuemembers(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION del_queuemembers(p_id_queuem integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  salida integer := 0;
BEGIN
DELETE FROM 
  asterisk.queue_members 
WHERE 
 id_queuem = p_id_queuem 
;

salida := 1;
return salida;
END;
$$;


ALTER FUNCTION asterisk.del_queuemembers(p_id_queuem integer) OWNER TO tintegro;

--
-- TOC entry 348 (class 1255 OID 70519)
-- Name: del_rutasaliente(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION del_rutasaliente(p_id_troncal integer, p_id_rutdet integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  salida integer := 0;
BEGIN
DELETE FROM 
  asterisk.tcrutde_tron 
WHERE 
 id_troncal = p_id_troncal and id_rutdet = p_id_rutdet
;

salida := 1;
return salida;
END;
$$;


ALTER FUNCTION asterisk.del_rutasaliente(p_id_troncal integer, p_id_rutdet integer) OWNER TO tintegro;

--
-- TOC entry 446 (class 1255 OID 70520)
-- Name: devolver_black_list(character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devolver_black_list(p_numero character varying, p_tipo character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_numero varchar := p_numero;
  v_tipo varchar := p_tipo;
  v_variable varchar := null;
  
BEGIN

    if(v_tipo = 'OUT') then
    select nu_telefo into v_variable
    from asterisk.tb_lista_negra l
    where nu_telefo = v_numero 
    	and il_activo = true
        and l.co_tipllam in ('Todas', 'OUT');
    end if;

    if(v_tipo = 'IN') then
    select nu_telefo into v_variable
    from asterisk.tb_lista_negra l
    where nu_telefo = v_numero 
    	and il_activo = true
        and l.co_tipllam in ('Todas', 'IN');
    end if;
    
    if v_variable is null then
  		v_va_return := 0;  
    else
		v_va_return := 1;
    end if;
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.devolver_black_list(p_numero character varying, p_tipo character varying) OWNER TO tintegro;

--
-- TOC entry 347 (class 1255 OID 70521)
-- Name: devolver_bolsa_minutos(integer, integer, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devolver_bolsa_minutos(p_tipo_telefo integer, p_tipo_salida integer, p_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_tipo_telefo integer := p_tipo_telefo;
  v_tipo_salida integer := p_tipo_salida;
  v_pin varchar := md5(p_pin);
  v_id_usuario integer := null;
  v_il_activousuario boolean := false;
  v_il_activobolsa boolean := false;
  v_il_actualizasaldo boolean := false;
  v_il_saldoacualizado boolean := false;
  v_ti_cortellamada integer := 0;
  v_ti_bolsaminutos integer := 0;
  v_fe_ultimaasigna varchar := null;
  v_il_bolsa boolean := FALSE;
  
BEGIN

/*
La funcion debe hacer lo siguiente:
- verificar si esta activo como usuario
- verificar si esta activo dentro del rango de fechas
- verificar si ya se actualizo su saldo del mes
- devuelve -1 si no esta activo
- devuelve 0 si no tiene saldo
- devuelve tiempo de corte de llamada
- devuelve tiempo de bolsa si este es menos al de corte de llamada 
*/

	-- busca el id_usario
	select id_usuari, ti_llamad, il_activo, il_bolsa
	into v_id_usuario, v_ti_cortellamada, v_il_activousuario, v_il_bolsa
	from asterisk.tb_usuario 
	where nu_pin = v_pin;

    -- verifica si esta activa la bolsa del usuario
    if v_il_activousuario = true then 

        select (case when (fe_finbol > current_date or fe_finbol is NULL) then true else false end), il_actmes, ca_resseg, fe_ultmod
            into v_il_activobolsa, v_il_actualizasaldo, v_ti_bolsaminutos, v_fe_ultimaasigna
        from asterisk.tb_bolsausuario 
        where id_usuari = v_id_usuario
        and id_tiptel = v_tipo_telefo
        and id_clave = v_tipo_salida;

    else
        v_va_return := -1;

    end if;
    
    -- si es activo se procede a la verificacion de actualizacion de bolsa y ver saldo de minutos
    if v_il_activousuario = true and v_il_activobolsa = true and v_il_bolsa = true then 
	
        --acutaliza saldo de bolsa de minutos si tiene el flag de actualizacion mensual
        if  v_il_actualizasaldo = true then
    
        	if v_fe_ultimaasigna::date + interval '1 month' < CURRENT_DATE then
    
              update asterisk.tb_bolsausuario set 
                ca_conseg = 0,
                ca_resseg = ca_segbol,
                fe_ultmod = cast(substr(cast(fe_inibol as varchar),9,2) ||'/'|| 
							substr(cast(CURRENT_DATE as varchar),6,2) ||'/'|| 
							substr(cast(CURRENT_DATE as varchar),1,4) as date),
                fe_ultasi = substr(cast(CURRENT_DATE as varchar),6,2) || '/'|| substr(cast(CURRENT_DATE as varchar),1,4)
              where id_usuari = v_id_usuario
              and id_tiptel = v_tipo_telefo
              and id_clave = v_tipo_salida;            
              
            end if;
    		
        end if;
        
        select 
                b.ca_resseg into v_ti_bolsaminutos
        from asterisk.tb_usuario u,
        asterisk.tb_bolsausuario b
        where u.nu_pin = v_pin
        and u.il_activo = TRUE
        and u.id_usuari = b.id_usuari
        and b.id_clave = p_tipo_salida
        and (cast(b.fe_finbol as date) >= CURRENT_DATE or b.fe_finbol is NULL)
        and b.il_activo = TRUE;
        
   	
        if v_ti_bolsaminutos > 0 and v_ti_cortellamada > 0 then
            if v_ti_bolsaminutos >= v_ti_cortellamada then 
                v_va_return := v_ti_cortellamada;
            else
                v_va_return := v_ti_bolsaminutos;
            end if;
        elsif  v_ti_bolsaminutos > 0 and v_ti_cortellamada = 0 then
            v_va_return := v_ti_bolsaminutos;
        else
            v_va_return := 0;
        end if;
    		
    else
        v_va_return := -1;

    end if;
    
  if v_ti_bolsaminutos is NULL then
      v_va_return := -2;
  end if;

  if v_il_bolsa is FALSE then
      v_va_return := -3;
  end if;
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.devolver_bolsa_minutos(p_tipo_telefo integer, p_tipo_salida integer, p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 349 (class 1255 OID 70522)
-- Name: devolver_bolsaminutos(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devolver_bolsaminutos(p_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_id_usuario integer := null;
  v_pin varchar := p_pin;
  v_il_activousuario boolean := false;
  v_il_activobolsa boolean := false;
  v_il_actualizasaldo boolean := false;
  v_il_saldoacualizado boolean := false;
  v_ti_cortellamada integer := 0;
  v_ti_bolsaminutos integer := 0;
  
  
BEGIN
/*
La funcion debe hacer lo siguiente:
- verificar si esta activo como usuario
- verificar si esta activo dentro del rango de fechas
- verificar si ya se actualizo su saldo del mes
- devuelve -1 si no esta activo
- devuelve 0 si no tiene saldo
- devuelve tiempo de corte de llamada
- devuelve tiempo de bolsa si este es menos al de corte de llamada 
*/

	-- busca el id_usario
	select id_usuari, ti_llamad, il_activo 
	into v_id_usuario, v_ti_cortellamada, v_il_activousuario
	from asterisk.tb_usuario 
	where nu_pin = v_pin;

	/*verifica si esta activo el usuario
	select (case when co_estado = 1 then true else false end) into v_il_activo 
	from asterisk.tb_usuario 
	where id_usuario = v_id_usuario;
	*/
-- verifica si esta activa la bolsa del usuario
if v_il_activousuario = true then 

	select (case when fe_finbol > current_date then true else false end), il_actmes, ca_resseg 
		into v_il_activobolsa, v_il_actualizasaldo, v_ti_bolsaminutos
	from asterisk.tb_bolsausuario 
	where id_usuari = v_id_usuario;

else
	v_va_return := -1;
end if;


-- si es activo se procede a la verificacion de actualizacion de bolsa y ver saldo de minutos
if v_il_activousuario = true and v_il_activobolsa = true then 

	--acutaliza saldo de bolsa de minutos si tiene el flag de actualizacion mensual, aun falta la restriccion de tiempo
	if  v_il_actualizasaldo = true then
	
		update asterisk.tb_bolsausuario set 
			ca_conseg = 0,
			ca_resseg = ca_segbol,
			fe_ultasi = substr(current_date::varchar, 1,7)::date
		where id_usuari = v_id_usuario
		and fe_finbol > current_date
		and fe_ultasi <> substr(current_date::varchar, 1,7);

		select ca_resseg 
		into v_ti_bolsaminutos
		from asterisk.tb_bolsausuario 
		where id_usuari = v_id_usuario;
		
	end if;
	
	if v_ti_bolsaminutos > 0 and v_ti_cortellamada > 0 then
		if v_ti_bolsaminutos >= v_ti_cortellamada then 
			v_va_return := v_ti_bolsaminutos;
		else
			v_va_return := v_ti_cortellamada;
		end if;
	elsif  v_ti_bolsaminutos > 0 and v_ti_cortellamada = 0 then
		v_va_return := v_ti_bolsaminutos;
	else
		v_va_return := 0;
	end if;
		
else
	v_va_return := -1;
end if;
    
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.devolver_bolsaminutos(p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 350 (class 1255 OID 70523)
-- Name: devolver_bolsaminutos_new(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devolver_bolsaminutos_new(p_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_id_usuario integer := null;
  v_pin varchar := p_pin;
  v_il_activousuario boolean := false;
  v_il_activobolsa boolean := false;
  v_il_actualizasaldo boolean := false;
  v_il_saldoacualizado boolean := false;
  v_ti_cortellamada integer := 0;
  v_ti_bolsaminutos integer := 0;
  
  
BEGIN
/*
La funcion debe hacer lo siguiente:
- verificar si esta activo como usuario
- verificar si esta activo dentro del rango de fechas
- verificar si ya se actualizo su saldo del mes
- devuelve -1 si no esta activo
- devuelve 0 si no tiene saldo
- devuelve tiempo de corte de llamada
- devuelve tiempo de bolsa si este es menos al de corte de llamada 
*/

	-- busca el id_usario
	select id_usuari, ti_llamad, il_activo 
	into v_id_usuario, v_ti_cortellamada, v_il_activousuario
	from asterisk.tb_usuario 
	where nu_pin = v_pin;

	/*verifica si esta activo el usuario
	select (case when co_estado = 1 then true else false end) into v_il_activo 
	from asterisk.tb_usuario 
	where id_usuario = v_id_usuario;
	*/
-- verifica si esta activa la bolsa del usuario
if v_il_activousuario = true then 

	select (case when fe_finbol > current_date then true else false end), il_actmes, ca_resseg 
		into v_il_activobolsa, v_il_actualizasaldo, v_ti_bolsaminutos
	from asterisk.tb_bolsausuario 
	where id_usuari = v_id_usuario;

else
	v_va_return := -1;
end if;


-- si es activo se procede a la verificacion de actualizacion de bolsa y ver saldo de minutos
if v_il_activousuario = true and v_il_activobolsa = true then 

	--acutaliza saldo de bolsa de minutos si tiene el flag de actualizacion mensual, aun falta la restriccion de tiempo
	if  v_il_actualizasaldo = true then
	
		update asterisk.tb_bolsausuario set 
			ca_conseg = 0,
			ca_resseg = ca_segbol,
			fe_ultasi = substr(current_date::varchar, 1,7)::date
		where id_usuari = v_id_usuario
		and fe_finbol > current_date
		and fe_ultasi <> substr(current_date::varchar, 1,7);

		select ca_resseg 
		into v_ti_bolsaminutos
		from asterisk.tb_bolsausuario 
		where id_usuari = v_id_usuario;
		
	end if;
	
	if v_ti_bolsaminutos > 0 and v_ti_cortellamada > 0 then
		if v_ti_bolsaminutos >= v_ti_cortellamada then 
			v_va_return := v_ti_bolsaminutos;
		else
			v_va_return := v_ti_cortellamada;
		end if;
	elsif  v_ti_bolsaminutos > 0 and v_ti_cortellamada = 0 then
		v_va_return := v_ti_bolsaminutos;
	else
		v_va_return := 0;
	end if;
		
else
	v_va_return := -1;
end if;
    
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.devolver_bolsaminutos_new(p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 351 (class 1255 OID 70524)
-- Name: devolver_clave(integer, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devolver_clave(p_tipo_salida integer, p_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return VARCHAR := NULL;
  v_tipo_salida integer := p_tipo_salida;
  v_pin varchar := md5(p_pin);
  
BEGIN


  if (v_tipo_salida = 1) then
      select '1' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 1
      and p.id_clave = 1;
  end if;

  if (v_tipo_salida = 2) then
      select '2' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 1
      and p.id_clave = 2;
  end if;

  if (v_tipo_salida = 3) then
      select '3' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 1
      and p.id_clave = 3;
  end if;

  if (v_tipo_salida = 4) then
      select '4' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 2
      and p.id_clave = 2;
  end if;

  if (v_tipo_salida = 5) then
      select '6' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 2
      and p.id_clave = 3;
  end if;

    if (v_tipo_salida = 6) then
      select '7' into v_va_return
      from asterisk.tb_usuario u,
      asterisk.tb_pin p
      where u.nu_pin = v_pin
      and u.il_activo = true
      and u.id_usuari = p.id_usupin
      and p.id_tiptel = 2
      and p.id_clave = 4;
  end if;
           
  if v_va_return is NULL then
      v_va_return := -1;
  end if;
    
  return next v_va_return;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.devolver_clave(p_tipo_salida integer, p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 354 (class 1255 OID 70525)
-- Name: devuelve_colas(bigint); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devuelve_colas(p_nu_agente bigint) RETURNS SETOF character varying
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
DECLARE
    c_colas refcursor;  
    v_nu_agente bigint := p_nu_agente;
    v_rec record;
    cadena varchar(50);
    temporal varchar(20);
BEGIN

cadena = '';
open c_colas for select q.name as colas
		    from asterisk.queues q,
		    asterisk.agente_por_cola c
		    where q.id_queues = c.id_cola
		    and c.id_agecola = (select id_agente from asterisk.agente where nu_agente = v_nu_agente);
 
loop
--	fetch c_ringroup into v_rec;
	fetch c_colas into temporal;
	if temporal is null then exit; end if;
	cadena := cadena || '^' || temporal;
  
--	return next c_ringroup;
end loop;
close c_colas;
--return next c_ringroup;
return next substr(cadena,2);

return;

END;
$$;


ALTER FUNCTION asterisk.devuelve_colas(p_nu_agente bigint) OWNER TO tintegro;

--
-- TOC entry 353 (class 1255 OID 70526)
-- Name: devuelve_perifoneo(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION devuelve_perifoneo(p_nu_perifo character varying) RETURNS SETOF character varying
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
DECLARE
    c_ringroup refcursor;  
    v_nu_perifo varchar := p_nu_perifo;
    v_rec record;
    cadena varchar(50);
    temporal varchar(20);
BEGIN

cadena = '';
open c_ringroup for select ('SIP/'||s.name) as extension
                  from asterisk.tb_perifoneo p,
                  asterisk.tb_extensionxperifo ep,
                  asterisk.sip_buddies s
                  where p.id_perifo = ep.id_perifo
                  and p.nu_perifo = '*25*'||v_nu_perifo
                  and ep.id_extens = s.id_sip;

loop
--	fetch c_ringroup into v_rec;
	fetch c_ringroup into temporal;
	if temporal is null then exit; end if;
	cadena := cadena ||'&' || temporal;
    
--	return next c_ringroup;
end loop;      
close c_ringroup;
--return next c_ringroup;
return next cadena;

return;

END;
$$;


ALTER FUNCTION asterisk.devuelve_perifoneo(p_nu_perifo character varying) OWNER TO tintegro;

--
-- TOC entry 352 (class 1255 OID 70527)
-- Name: elimina_sip_buddies(); Type: FUNCTION; Schema: asterisk; Owner: postgres
--

CREATE FUNCTION elimina_sip_buddies() RETURNS SETOF trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_name_sip varchar := null;
BEGIN
   
    IF (TG_OP = 'DELETE') THEN
	    	
    	delete from asterisk.extensions_table 
        where exten = OLD.name;
        
    	delete from asterisk.voicemail_users 
        where customer_id::varchar = OLD.name;
        
        delete from asterisk.queue_members
        where split_part(interface,'@',1) = 'Local/'||OLD.name;
                
        update asterisk.agente
            set no_locacion = NULL,
                nu_accion = NULL,
                co_estado = 2
        where no_locacion = 'SIP/'||OLD.name;
        
        RETURN NEW;
       
    END IF;
    
    RETURN NULL; -- result is ignored since this is an AFTER trigger
END;
$$;


ALTER FUNCTION asterisk.elimina_sip_buddies() OWNER TO postgres;

--
-- TOC entry 440 (class 1255 OID 70683)
-- Name: fn_busca_anexo_edita(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_busca_anexo_edita(usuario character varying) RETURNS SETOF tp_busca_anexo_edita
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return asterisk.tp_busca_anexo_edita%rowtype;
 BEGIN
  FOR v_va_return IN
     SELECT 
        s.name,
        s.secret,
        s.callerid,
        s.mailbox,
        v.email,
        st.id_marca,
        st.id_modelo,
        ma.no_marca,
        mo.no_modelo,
        st.no_mac,
        st.no_ip_dominio,
        st.no_ruta
     FROM 
        asterisk.sip_buddies s,
        asterisk.voicemail_users v,
        asterisk.tb_sip_telefono st        
     LEFT JOIN asterisk.tcmarca ma ON st.id_marca = ma.id_marca
     LEFT JOIN asterisk.tcmodelo mo ON st.id_modelo = mo.id_modelo
     WHERE
        s.name = st.name_id_sip
        AND s.name = v.customer_id
        AND st.name_id_sip = v.customer_id
        AND s.name = usuario
  
     --inner join asterisk.voicemail_users v on v.customer_id=s.name
     --inner join asterisk.tb_sip_telefono  st on st.name_id_sip=s.name
     --inner join asterisk.tcmarca ma on ma.id_marca=st.id_marca
     --inner join asterisk.tcmodelo mo on mo.id_modelo=st.id_modelo
  LOOP
   RETURN  NEXT v_va_return;
  END LOOP;
 END;
 $$;


ALTER FUNCTION asterisk.fn_busca_anexo_edita(usuario character varying) OWNER TO tintegro;

--
-- TOC entry 449 (class 1255 OID 70716)
-- Name: fn_editar_anexo(character varying, character varying, character varying, character varying, character varying, integer, integer, character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_editar_anexo(usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return INTEGER := 0; -- variable para que envie resultado
  v_id_sip INTEGER;
   fecha_registro timestamp;
  BEGIN
  
  
  --inserta anexo a la tabla buddies
  UPDATE  asterisk.sip_buddies SET 
				   /*name = usuario,*/
				   context = 'registro-corporativo',
				   deny='0.0.0.0/0.0.0.0',
				   permit=ip_dominio,
				   secret=clave_usuario,
				   md5secret=clave_usuario,
				   callerid=caller_id,
				   mailbox=buzon_box,
				   username=usuario,
				   host=ip_dominio,
				   qualify='yes'
				   
				WHERE name=usuario;
				
  --Obtenemos el el id_sip para actualizar el registro
 --SELECT id_usuario_sip into v_id_sip FROM asterisk.tb_sip_telefono WHERE id_usuario_sip= id_sip_anexo;

  
  --inserta anexo a la tabla tb_sip_telefono
  UPDATE asterisk.tb_sip_telefono SET
				       /*id_usuario_sip =usuario,*/
				       id_marca=marca,
				       id_modelo=modelo,
				       no_mac=mac,
				       no_ip_dominio=ip_dominio,
				       no_ruta=ruta
				      WHERE name_id_sip= usuario;

/*Asignamos la fecha del registro es la fecha del servidor*/
 select LOCALTIMESTAMP into fecha_registro;

  --Actualiza datos a la tabla asterisk.voicemail_users
  UPDATE asterisk.voicemail_users SET
				      /*customer_id= usuario,*/
				      context='registro-corporativo',
				      mailbox=buzon_box,
				      password=buzon_box,
				      fullname=caller_id,
				      email=correo_box,
				      pager= '',
				      attach='yes',
				      saycid='yes',
				      hidefromdir='yes',
				      stamp=fecha_registro
				      WHERE customer_id=usuario;
				      
 v_va_return = 1;

 RETURN v_va_return;
 END;
 $$;


ALTER FUNCTION asterisk.fn_editar_anexo(usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) OWNER TO tintegro;

--
-- TOC entry 447 (class 1255 OID 70529)
-- Name: fn_editar_anexo(integer, character varying, character varying, character varying, character varying, character varying, integer, integer, character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_editar_anexo(id_sip_anexo integer, usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return INTEGER := 0; -- variable para que envie resultado
  v_id_sip INTEGER;
  BEGIN
  
  
  --inserta anexo a la tabla buddies
  UPDATE  asterisk.sip_buddies SET 
				   name = usuario,
				   context = 'registro-corporativo',
				   deny='0.0.0.0/0.0.0.0',
				   permit=ip_dominio,
				   secret=clave_usuario,
				   md5secret=clave_usuario,
				   callerid=caller_id,
				   mailbox=buzon_box,
				   username=usuario,
				   host=ip_dominio,
				   qualify='yes'
				   
				WHERE id_sip=id_sip_anexo;
				
  --Obtenemos el el id_sip para actualizar el registro
 SELECT id_usuario_sip into v_id_sip FROM asterisk.tb_sip_telefono WHERE id_usuario_sip= id_sip_anexo;

  
  --inserta anexo a la tabla tb_sip_telefono
  UPDATE asterisk.tb_sip_telefono SET
				       id_usuario_sip =id_sip_anexo,
				       id_marca=marca,
				       id_modelo=modelo,
				       no_mac=mac,
				       no_ip_dominio=ip_dominio,
				       no_ruta=ruta
				      WHERE id_usuario_sip= id_sip_anexo;

  --Actualiza datos a la tabla asterisk.voicemail_users
  UPDATE asterisk.voicemail_users SET
				      customer_id= usuario,
				      context='registro-corporativo',
				      mailbox=buzon_box,
				      password=buzon_box,
				      fullname=caller_id,
				      email=correo_box,
				      pager= '',
				      attach='yes',
				      saysid='yes',
				      hidefromdir='yes'
				      WHERE customer_id=usuario;
				      
 v_va_return = 1;

 RETURN v_va_return;
 END;
 $$;


ALTER FUNCTION asterisk.fn_editar_anexo(id_sip_anexo integer, usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) OWNER TO tintegro;

--
-- TOC entry 355 (class 1255 OID 70530)
-- Name: fn_eliminar_anexo(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_eliminar_anexo(id_sip_anexo integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return INTEGER := 0; -- variable para que envie resultado
  v_id_sip INTEGER;
  BEGIN
  
  
  --Eliminamos anexo a la tabla buddies
  DELETE FROM
	 asterisk.sip_buddies
  WHERE  id_sip=id_sip_anexo;
				
  --Eliminamos anexo a la tabla tb_sip_telefono
  DELETE FROM
	asterisk.tb_sip_telefono 
  WHERE id_usuario_sip= id_sip_anexo;

  --Eliminamos asterisk.voicemail_users
  DELETE FROM
	asterisk.voicemail_users 
  WHERE customer_id=id_sip_anexo;
				      
 v_va_return = 1;

 RETURN v_va_return;
 END;
 $$;


ALTER FUNCTION asterisk.fn_eliminar_anexo(id_sip_anexo integer) OWNER TO tintegro;

--
-- TOC entry 421 (class 1255 OID 70679)
-- Name: fn_eliminar_anexo(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_eliminar_anexo(usuario character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return INTEGER := 0; -- variable para que envie resultado
  v_id_sip INTEGER;
  BEGIN

  SELECT 
     count( * )
  INTO 
     v_va_return
  FROM 
     asterisk.tb_sip_telefono st,
     asterisk.voicemail_users vu,
     asterisk.sip_buddies sb
  WHERE
     st.name_id_sip = usuario
     AND vu.customer_id= usuario
     AND sb.name = usuario;
  
    --Eliminamos anexo a la tabla tb_sip_telefono
  DELETE FROM
	asterisk.tb_sip_telefono 
  WHERE name_id_sip= usuario;
  
  --Eliminamos asterisk.voicemail_users
  DELETE FROM
	asterisk.voicemail_users 
  WHERE customer_id=usuario;
  
  --Eliminamos anexo a la tabla buddies
  DELETE FROM
	 asterisk.sip_buddies
  WHERE  name=usuario;

 RETURN v_va_return;
 END;
 $$;


ALTER FUNCTION asterisk.fn_eliminar_anexo(usuario character varying) OWNER TO tintegro;

--
-- TOC entry 448 (class 1255 OID 111844)
-- Name: fn_eliminar_area_centro_costo(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_eliminar_area_centro_costo(p_id_empare integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  salida integer := 0;
BEGIN
	DELETE FROM asterisk.empresa_area WHERE id_empare = p_id_empare and il_elimina = true;
	salida := 1;
return salida;
END;
$$;


ALTER FUNCTION asterisk.fn_eliminar_area_centro_costo(p_id_empare integer) OWNER TO tintegro;

--
-- TOC entry 468 (class 1255 OID 119973)
-- Name: fn_eliminar_area_centro_costo_new(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_eliminar_area_centro_costo_new(p_id_empare integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return asterisk.tp_resultado%rowtype; 
  v_opc integer := 0;
  v_opc2 integer := 0;
  v_id_empare integer := p_id_empare;
BEGIN
	select tipo into v_opc from asterisk.empresa_area  where id_empare = v_id_empare;
	if v_opc = 1 then 
		select id_empare into v_opc2 from asterisk.empresa_area  where id_padre = v_id_empare  and tipo = 2 limit 1;
		if v_opc2 is null then 
			DELETE FROM asterisk.empresa_area 
			WHERE id_empare = v_id_empare 
			and il_elimina = true;	
			for v_va_return in 
				select 1, 'ok'
			loop    
			return next v_va_return;
			end loop;		
		else
			for v_va_return in 
				select -1, 'Esta √Årea tiene asignado uno o mas centros de costos, eliminar primero los centros de costo para poder eliminar el √Årea.'
			loop    
			return next v_va_return;
			end loop;
		end if;
	else 
		if (select id_usuari from asterisk.tb_usuario where id_empare = v_id_empare limit 1) is null then 
			DELETE FROM asterisk.empresa_area 
			WHERE id_empare = v_id_empare 
			and il_elimina = true;
			for v_va_return in 
				select 1, 'ok'
			loop    
			return next v_va_return;
			end loop;        
		else 
			for v_va_return in 
				select -1, 'Centro de Costo asignado al menos a un Usuario.'
			loop    
			return next v_va_return;
			end loop; 
		end if;
	end if;      
 return ;
END;
$$;


ALTER FUNCTION asterisk.fn_eliminar_area_centro_costo_new(p_id_empare integer) OWNER TO tintegro;

--
-- TOC entry 450 (class 1255 OID 70531)
-- Name: fn_inserta_anexo(character varying, character varying, character varying, character varying, character varying, integer, integer, character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_inserta_anexo(usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return INTEGER := 0; -- variable para que envie resultado
 -- v_id_sip INTEGER;
  fecha_registro timestamp;
  BEGIN
  
  
  --inserta anexo a la tabla buddies
  INSERT INTO asterisk.sip_buddies(
				   name,
				   context,
				   deny,
				   permit,
				   secret,
				   md5secret,
				   callerid,
				   mailbox,
				   username,
				   host,
				   qualify
				   
				   )VALUES (
				   usuario,
				   'registro-corporativo',
				   '0.0.0.0/0.0.0.0',
				   ip_dominio,
				   clave_usuario,
				   md5(clave_usuario),
				   caller_id,
				   buzon_box,
				   usuario,
				   ip_dominio,
				   'yes'

				   );
  --Obtenemos el ultimo numero del ultimo registro de la tabla sip_buddies

 -- SELECT  id_sip into v_id_sip  FROM asterisk.sip_buddies order by id_sip desc limit 1;
  
  --inserta anexo a la tabla tb_sip_telefono
  INSERT INTO asterisk.tb_sip_telefono(
				       name_id_sip,
				       id_marca,
				       id_modelo,
				       no_mac,
				       no_ip_dominio,
				       no_ruta
				       )
				       VALUES(
				       usuario,
				       marca,
				       modelo,
				       mac,
				       ip_dominio,
				       ruta
				       );
/*Asignamos la fecha del registro es la fecha del servidor*/
 select LOCALTIMESTAMP into fecha_registro;
  --inserta datos a la tabla asterisk.voicemail_users
  INSERT INTO asterisk.voicemail_users(
				      customer_id,
				      context,
				      mailbox,
				      password,
				      fullname,
				      email,
				      pager,
				      attach,
				      saycid,
				      hidefromdir,
				      stamp
				      )
				      VALUES(
				      usuario,
				      'registro-corporativo',
				      usuario,
				      usuario,
				      caller_id,
				      correo_box,
				      '',
				      'yes',
				      'yes',
				      'yes',
				      fecha_registro
				      );
 v_va_return = 1;

 RETURN v_va_return;
 END;
 $$;


ALTER FUNCTION asterisk.fn_inserta_anexo(usuario character varying, clave_usuario character varying, caller_id character varying, buzon_box character varying, correo_box character varying, marca integer, modelo integer, mac character varying, ip_dominio character varying, ruta character varying) OWNER TO tintegro;

--
-- TOC entry 429 (class 1255 OID 111849)
-- Name: fn_lista_sip_telefono(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_lista_sip_telefono() RETURNS SETOF tp_lista_sip_telefono
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return asterisk.tp_lista_sip_telefono%rowtype;
 BEGIN
  FOR v_va_return IN

	--select * from asterisk.tb_sip_telefono st WHERE st.no_mac is NULL or st.id_marca = 0 or st.id_modelo = 0
  
     SELECT 
        s.name,
        s.callerid,
        --CASE st.id_marca = 0 OR st.id_modelo = 0 OR st.no_mac IS NULL WHEN TRUE THEN 'NO-APROV' ELSE ma.no_marca ||'-'|| mo.no_modelo END,
        --CASE st.id_marca = 0 OR st.id_modelo = 0 OR st.no_mac IS NULL WHEN TRUE THEN 'NO-APROV' ELSE ma.no_marca ||'-'|| mo.no_modelo END,
        1,
        v.email
     FROM 
        asterisk.sip_buddies s,
        asterisk.voicemail_users v,
        asterisk.tb_sip_telefono st        
     LEFT JOIN asterisk.tcmarca ma ON st.id_marca = ma.id_marca
     LEFT JOIN asterisk.tcmodelo mo ON st.id_modelo = mo.id_modelo
     WHERE
        s.name = st.name_id_sip
        AND s.name = v.customer_id
        AND st.name_id_sip = v.customer_id
     ORDER BY s.name::integer ASC
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
END;
$$;


ALTER FUNCTION asterisk.fn_lista_sip_telefono() OWNER TO tintegro;

--
-- TOC entry 419 (class 1255 OID 70533)
-- Name: fn_lista_todo_marca(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_lista_todo_marca() RETURNS SETOF tp_lista_todo_marca
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return asterisk.tp_lista_todo_marca%rowtype;
  BEGIN
   FOR v_va_return IN
    SELECT  id_marca,no_marca from asterisk.tcmarca WHERE il_activo = true 
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
 END;
$$;


ALTER FUNCTION asterisk.fn_lista_todo_marca() OWNER TO tintegro;

--
-- TOC entry 420 (class 1255 OID 70534)
-- Name: fn_lista_todo_modelo(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_lista_todo_modelo(id_marc integer) RETURNS SETOF tp_lista_todo_modelo
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return asterisk.tp_lista_todo_modelo%rowtype;
  BEGIN
   FOR v_va_return IN
    SELECT
     id_modelo,
     no_modelo,
     id_marca
    FROM asterisk.tcmodelo
    WHERE 
	id_marca=id_marc
	AND il_activo = true
    
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
 END;
$$;


ALTER FUNCTION asterisk.fn_lista_todo_modelo(id_marc integer) OWNER TO tintegro;

--
-- TOC entry 439 (class 1255 OID 106283)
-- Name: fn_pin_buscar(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_pin_buscar(num_pin character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_result integer;
 BEGIN
 v_result:= 0;
   SELECT 
	count(*)
	into v_result
	from asterisk.tb_usuario
	where nu_pin = md5(num_pin);
  return v_result;
 

 END;
 $$;


ALTER FUNCTION asterisk.fn_pin_buscar(num_pin character varying) OWNER TO tintegro;

--
-- TOC entry 474 (class 1255 OID 144671)
-- Name: fn_probar_paginacion(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_probar_paginacion(p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF tp_prueba_paginacion
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return asterisk.tp_prueba_paginacion%rowtype;
	v_nu_pagina integer := p_nu_pagina; 
	v_nu_mostrar integer := p_nu_mostrar;
	v_nu_mostrarAnte integer := 0;
	v_contador integer := 0;
BEGIN	
v_nu_mostrarAnte = v_nu_mostrar * (v_nu_pagina - 1);
SELECT count(*) into v_contador FROM asterisk.sip_buddies;
	if v_nu_pagina = 1 then
		FOR v_va_return IN 
			SELECT name, context, permit, secret, v_contador  FROM asterisk.sip_buddies order by id_sip limit v_nu_mostrar
		LOOP
		RETURN NEXT v_va_return;
		END LOOP;
	else
		FOR v_va_return IN			
			SELECT name, context, permit, secret, v_contador  FROM asterisk.sip_buddies 
			where id_sip not in (SELECT id_sip  FROM asterisk.sip_buddies order by id_sip limit v_nu_mostrarAnte)
			order by id_sip limit v_nu_mostrar
		LOOP
		RETURN NEXT v_va_return;
		END LOOP;
	end if;
END;
$$;


ALTER FUNCTION asterisk.fn_probar_paginacion(p_nu_pagina integer, p_nu_mostrar integer) OWNER TO tintegro;

--
-- TOC entry 443 (class 1255 OID 111836)
-- Name: fn_validar_nu_pin(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION fn_validar_nu_pin(p_nu_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_nu_pin_resul varchar := null;
  v_nu_ping varchar := p_nu_pin; 
  v_resul integer := 0;
BEGIN
	select nu_pin into v_nu_pin_resul from asterisk.tb_usuario where nu_pin = (select md5(v_nu_ping::varchar));
	if v_nu_pin_resul is null then
		v_resul = 1;
	end if;    
  return next v_resul;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.fn_validar_nu_pin(p_nu_pin character varying) OWNER TO tintegro;

--
-- TOC entry 451 (class 1255 OID 70535)
-- Name: graba_estado_agente(character varying, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION graba_estado_agente(p_co_agente character varying, p_co_estado integer) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $_$
DECLARE 
 v_co_agente VARCHAR:=p_co_agente; -- Codigo del Agente $1
 v_co_estado INTEGER:=p_co_estado; -- Codigo de estado $3
 v_va_return INTEGER:=1; -- variable para que envie resultado
 v_id_estage INTEGER:=NULL; -- id del estado
 v_fe_finest VARCHAR:=NULL; -- fecha de fin de estado
 v_ho_finest VARCHAR:=NULL; -- hora de fin de estado
 v_ti_esthor VARCHAR:=NULL; -- Tiempo de permanecia en estado en formato hora
 v_ti_estseg INTEGER:=NULL; -- Tiempo de permanecia en estado en segundos
 BEGIN 
 
 select max(id_estage) into v_id_estage
 from reportes.tb_estado_agente
 where co_agente = v_co_agente;
 
if(v_id_estage is null) then --Primera vez que ingresa
 	insert into reportes.tb_estado_agente (co_agente,co_campan,co_estado,fe_iniest,ho_iniest)
    values (v_co_agente,1,v_co_estado,CURRENT_DATE, CURRENT_TIME);
    
else -- Primero actualiza el estado, luego ingresa el nuevo estado

	select CURRENT_DATE into v_fe_finest;
 	select CURRENT_TIME into v_ho_finest;

	select (case when fe_iniest = v_fe_finest::date then CURRENT_TIME - ho_iniest else '15:00:00.000111-5' end) into v_ti_esthor
    from reportes.tb_estado_agente
 	WHERE id_estage = v_id_estage; 
	--raise exception 'min %',v_ti_esthor; 

    select (substr(v_ti_esthor,1,2)::integer * 3600 + substr(v_ti_esthor,4,2)::integer * 60 + substr(v_ti_esthor,7,2)::integer) into v_ti_estseg;

	update reportes.tb_estado_agente
 	SET fe_finest = CURRENT_DATE,
 	ho_finest = CURRENT_TIME,
    ti_estmin = split_part(v_ti_esthor,'.',1),
    ti_estseg = v_ti_estseg
 	WHERE id_estage = v_id_estage; 
    
    insert into reportes.tb_estado_agente (co_agente,co_campan,co_estado,fe_iniest,ho_iniest)
    values (v_co_agente,1,v_co_estado,CURRENT_DATE, CURRENT_TIME);
    
end if;
return next v_va_return; 

return;
END;
$_$;


ALTER FUNCTION asterisk.graba_estado_agente(p_co_agente character varying, p_co_estado integer) OWNER TO tintegro;

--
-- TOC entry 469 (class 1255 OID 119977)
-- Name: insert_area_centro(character varying, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION insert_area_centro(p_nombre character varying, p_id_padre integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return asterisk.tp_resultado%rowtype; 
 v_nombre varchar:= upper(trim(p_nombre)); 
 v_id_padre INTEGER:=p_id_padre; 

 BEGIN 
 
if p_nombre is not null and p_nombre <> '' then 
	if v_id_padre is null then -- Entonces es ¡rea
		if (select id_empare from asterisk.empresa_area where upper(nombre) = upper(v_nombre) and tipo = 1 limit 1) is null then 
			INSERT INTO asterisk.empresa_area(nombre, tipo, il_activo) VALUES (v_nombre, 1, true);
			select 1, 'ok' into v_va_return;
			return next v_va_return;		
		else		
			select -1, 'El nombre de Area ya existe.' into v_va_return;
			return next v_va_return;		
		end if;
	else if v_id_padre is not null then -- Entonces es Centro de costo
		if (select id_empare from asterisk.empresa_area where upper(nombre) = upper(v_nombre) and tipo = 2 and id_padre = v_id_padre limit 1) is null then 
			INSERT INTO asterisk.empresa_area(nombre, tipo, id_padre, il_activo) VALUES (v_nombre, 2, v_id_padre,  true);
			select 1, 'ok' into v_va_return;		
			return next v_va_return;		
		else 
			
			select -1, 'El nombre de Centro Costo ya existe.' into v_va_return;		  
			return next v_va_return;
			
		end if;
	end if;
	end if;
else 
	select -1, 'El campo nombre no puedo ir vacio.' into v_va_return;		  
	return next v_va_return;
end if;
return;
END;
$$;


ALTER FUNCTION asterisk.insert_area_centro(p_nombre character varying, p_id_padre integer) OWNER TO tintegro;

--
-- TOC entry 356 (class 1255 OID 70536)
-- Name: insert_troncal(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION insert_troncal(p_id_troncal integer, p_id_rutdet integer) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_id_troncal INTEGER:=p_id_troncal; 
 v_id_rutdet INTEGER:=p_id_rutdet; 
 v_va_return INTEGER:=0; -- variable para que envie resultado
 v_va_result BOOLEAN:=FALSE; -- variable para que envie resultado
 BEGIN 
 
select (case when id_rutdet is null then false else true end ) into v_va_result
from asterisk.tcrutde_tron where id_rutdet = v_id_rutdet and id_troncal = v_id_troncal;

 raise notice 'entre troncal, %', v_id_troncal;
 raise notice 'entre rutdet, %', v_id_rutdet;
  raise notice 'entre result, %', v_va_result;
 
if(v_va_result is null) then

    insert into asterisk.tcrutde_tron (id_rutdet,id_troncal)
    values (p_id_rutdet,p_id_troncal);
    v_va_return := 1;
      raise notice 'entre insert, %', v_va_return;
end if;

return next v_va_return; 

return;
END;
$$;


ALTER FUNCTION asterisk.insert_troncal(p_id_troncal integer, p_id_rutdet integer) OWNER TO tintegro;

--
-- TOC entry 357 (class 1255 OID 70537)
-- Name: lista_perifoneo(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION lista_perifoneo(p_nu_perifo character varying) RETURNS SETOF character varying
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_nu_perifo varchar := p_nu_perifo;
    v_va_return varchar := null;
    v_ca_registros INTEGER := null; 
BEGIN

	select count(*) into v_ca_registros
    from asterisk.tb_perifoneo p,
    asterisk.tb_extensionxperifo ep
    where p.id_perifo = ep.id_perifo
    and p.nu_perifo = '*25*'||v_nu_perifo;

	if v_ca_registros > 0 then 

        select * into v_va_return from asterisk.devuelve_perifoneo(v_nu_perifo);

        select substring(v_va_return,2) into v_va_return;
    	--raise notice 'entre a mayor a 0';
	else 
    	
    	v_va_return = '-1';

    end if;

return next v_va_return;

return;

END;
$$;


ALTER FUNCTION asterisk.lista_perifoneo(p_nu_perifo character varying) OWNER TO tintegro;

--
-- TOC entry 403 (class 1255 OID 128286)
-- Name: listar_centro_costo_por_area(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_centro_costo_por_area(p_tip_opera integer, p_id_empare integer) RETURNS SETOF listar_centro_costo_por_area
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return asterisk.listar_centro_costo_por_area%rowtype;
  v_tip_opera integer := p_tip_opera;
  v_id_empare integer := p_id_empare;
BEGIN
if v_tip_opera = 0 then
    for v_va_return in  
	SELECT 	(case when ac.id_padre is null then id_empare else ac.id_padre end) as id_area,
	(case when(select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then nombre else (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) end) as no_area,
	id_empare, (case when (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then '' else nombre end) as no_centrocosto, il_activo
	FROM asterisk.empresa_area ac
	order by id_empare, ac.id_padre	
    loop 
    return next v_va_return;
    end loop;        
 else if v_tip_opera = 1 then
    for v_va_return in  
	SELECT 	(case when ac.id_padre is null then id_empare else ac.id_padre end) as id_area,
	(case when(select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then nombre else (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) end) as no_area,
	id_empare, (case when (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then '' else nombre end) as no_centrocosto, il_activo
	FROM asterisk.empresa_area ac where tipo = 1
	order by id_empare, ac.id_padre	
    loop 
    return next v_va_return;
    end loop; 
 else if v_tip_opera = 2 and p_id_empare is not null then
     for v_va_return in  
	SELECT 	(case when ac.id_padre is null then id_empare else ac.id_padre end) as id_area,
	(case when(select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then nombre else (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) end) as no_area,
	id_empare, (case when (select nombre from asterisk.empresa_area where id_empare = ac.id_padre limit 1) is null then '' else nombre end) as no_centrocosto, il_activo
	FROM asterisk.empresa_area ac 
	where id_empare = v_id_empare
	order by id_empare, ac.id_padre	
    loop 
    return next v_va_return;
    end loop; 
 end if;
 end if;
 end if;
 return;
END;
$$;


ALTER FUNCTION asterisk.listar_centro_costo_por_area(p_tip_opera integer, p_id_empare integer) OWNER TO tintegro;

--
-- TOC entry 358 (class 1255 OID 70538)
-- Name: listar_rutadetalle(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_rutadetalle(p_id_rutdet integer) RETURNS SETOF rutasalientes
    LANGUAGE plpgsql
    AS $_$
DECLARE
  v_va_return asterisk.rutasalientes%rowtype;
BEGIN
    for v_va_return in  
	SELECT
	rt.id_troncal , 
	rt.id_rutdet, 
	no_rutsal,
	no_regla,
	td.no_anteponer,
	nu_prefijo,
	tt.no_desc , 	
	td.no_anteponer || '${' || no_regla ||':'||nu_prefijo||'}' as no_descr ,
	il_grabar,
	id_tiptel ||''||id_clave  as id_clave
	
	FROM
	asterisk.tbruta_salientes ts,
	asterisk.tcruta_detalle td,
	asterisk.tb_troncal tt,
	asterisk.tcrutde_tron rt
	WHERE
	ts.id_rutsal = td.id_rutsal and
	rt.id_rutdet = td.id_rutdet and
	rt.id_troncal = tt.id_troncal and
	td.id_rutdet = p_id_rutdet 
	ORDER BY td.nu_priori  
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$_$;


ALTER FUNCTION asterisk.listar_rutadetalle(p_id_rutdet integer) OWNER TO tintegro;

--
-- TOC entry 359 (class 1255 OID 70539)
-- Name: listar_rutasalientes(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_rutasalientes(p_id_rutsal integer) RETURNS SETOF rutasalientes
    LANGUAGE plpgsql
    AS $_$
DECLARE
  v_va_return asterisk.rutasalientes%rowtype;
  v_id_rutsal integer := p_id_rutsal;  
BEGIN
    for v_va_return in  
	SELECT
	rt.id_troncal , 
	rt.id_rutdet, 
	no_rutsal,
	no_regla,
	td.no_anteponer,
	nu_prefijo,
	tt.no_desc , 	
	td.no_anteponer || '${' || no_regla ||':'||nu_prefijo||'}' as no_descr ,
	il_grabar,
	id_tiptel ||''||id_clave  as id_clave
	
	FROM
	asterisk.tbruta_salientes ts,
	asterisk.tcruta_detalle td,
	asterisk.tb_troncal tt,
	asterisk.tcrutde_tron rt
	WHERE
	ts.id_rutsal = td.id_rutsal and
	rt.id_rutdet = td.id_rutdet and
	rt.id_troncal = tt.id_troncal and
	td.id_rutsal = v_id_rutsal 
	ORDER BY td.nu_priori  
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$_$;


ALTER FUNCTION asterisk.listar_rutasalientes(p_id_rutsal integer) OWNER TO tintegro;

--
-- TOC entry 360 (class 1255 OID 70540)
-- Name: listar_tiptelclave(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_tiptelclave() RETURNS SETOF tiptelclave
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return asterisk.tiptelclave%rowtype;  
BEGIN
    for v_va_return in  
	SELECT 
	tc.id_tiptel ||''|| tc.id_clave as id_codigo ,
	no_clave ,
	no_tiptel
	FROM
	asterisk.tc_clave c,
	asterisk.tc_tipotelefono  t,
	asterisk.tctiptel_clave  tc
	WHERE 
	tc.id_tiptel = t.id_tiptel and
	tc.id_clave = c.id_clave 
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$$;


ALTER FUNCTION asterisk.listar_tiptelclave() OWNER TO tintegro;

--
-- TOC entry 361 (class 1255 OID 70541)
-- Name: listar_tiptelclaveobj(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_tiptelclaveobj(p_id_tiptel integer, p_id_clave integer) RETURNS SETOF tiptelclave
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return asterisk.tiptelclave%rowtype; 
BEGIN
    for v_va_return in  
	SELECT 
	tc.id_tiptel ||''|| tc.id_clave as id_codigo ,
	no_clave ,
	no_tiptel
	FROM
	asterisk.tc_clave c,
	asterisk.tc_tipotelefono  t,
	asterisk.tctiptel_clave  tc
	WHERE 
	tc.id_tiptel = t.id_tiptel and
	tc.id_clave = c.id_clave and
	tc.id_tiptel = p_id_tiptel and
	tc.id_clave = p_id_clave
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$$;


ALTER FUNCTION asterisk.listar_tiptelclaveobj(p_id_tiptel integer, p_id_clave integer) OWNER TO tintegro;

--
-- TOC entry 452 (class 1255 OID 70542)
-- Name: listar_todasrutasalientes(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_todasrutasalientes() RETURNS SETOF rutasalientes
    LANGUAGE plpgsql
    AS $_$
DECLARE
  v_va_return asterisk.rutasalientes%rowtype;  
BEGIN
    for v_va_return in  
	SELECT
	rt.id_troncal , 
	rt.id_rutdet, 
	no_rutsal,
	no_regla,
	td.no_anteponer,
	nu_prefijo,
	tt.no_desc , 	
	td.no_anteponer || '${' || no_regla ||':'||nu_prefijo||'}' as no_descr ,
	il_grabar,
	id_tiptel ||''||id_clave  as id_clave
	FROM
	asterisk.tbruta_salientes ts,
	asterisk.tcruta_detalle td,
	asterisk.tb_troncal tt,
	asterisk.tcrutde_tron rt
	WHERE
	ts.id_rutsal = td.id_rutsal and
	rt.id_rutdet = td.id_rutdet and
	rt.id_troncal = tt.id_troncal
	ORDER BY ts.id_rutsal ,td.nu_priori   
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$_$;


ALTER FUNCTION asterisk.listar_todasrutasalientes() OWNER TO tintegro;

--
-- TOC entry 363 (class 1255 OID 70543)
-- Name: listar_troncalrutasalientes(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION listar_troncalrutasalientes(p_id_troncal integer, p_id_rutsal integer) RETURNS SETOF rutasalientes
    LANGUAGE plpgsql
    AS $_$
DECLARE
  v_va_return asterisk.rutasalientes%rowtype;
BEGIN
    for v_va_return in  
	SELECT
	rt.id_troncal , 
	rt.id_rutdet, 
	no_rutsal,
	no_regla,
	td.no_anteponer,
	nu_prefijo,
	tt.no_desc , 	
	td.no_anteponer || '${' || no_regla ||':'||nu_prefijo||'}' as no_descr ,
	il_grabar,
	id_tiptel ||''||id_clave  as id_clave
	
	FROM
	asterisk.tbruta_salientes ts,
	asterisk.tcruta_detalle td,
	asterisk.tb_troncal tt,
	asterisk.tcrutde_tron rt
	WHERE
	ts.id_rutsal = td.id_rutsal and
	rt.id_rutdet = td.id_rutdet and
	rt.id_troncal = tt.id_troncal and
	rt.id_troncal = p_id_troncal and
	td.id_rutsal = p_id_rutsal 
	ORDER BY td.nu_priori  
  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$_$;


ALTER FUNCTION asterisk.listar_troncalrutasalientes(p_id_troncal integer, p_id_rutsal integer) OWNER TO tintegro;

--
-- TOC entry 453 (class 1255 OID 70544)
-- Name: logout_agente_queue(character varying, character varying, character varying, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION logout_agente_queue(p_num_agente character varying, p_pin character varying, p_no_locacion character varying, p_co_estado integer) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	v_il_respta INTEGER := NULL; 
	v_num_agente VARCHAR := p_num_agente;
	v_pin VARCHAR := p_pin;
	v_no_locacion VARCHAR := p_no_locacion;
	v_tmp_locacion VARCHAR := NULL;
	v_co_estado_old smallint := NULL;
	v_ti_estado smallint := NULL;
	v_il_datcorrec BOOLEAN := FALSE;
	v_il_logage BOOLEAN := FALSE;
	v_il_logque BOOLEAN := FALSE;
	v_il_activo smallint := null;
BEGIN
    
	--Verifica si la informacion el usuario y password es correcto
    select (case when id_agente is null then false else true end) into v_il_datcorrec 
    from asterisk.agente where nu_agente = v_num_agente and nu_pin = v_pin;

    --Verifica si esta logueado en que estado y que tipo de login es
    select (case when a.no_locacion is null then false else true end), a.co_estado, e.ti_estado, a.no_locacion, a.il_activo
    into v_il_logage, v_co_estado_old, v_ti_estado, v_tmp_locacion, v_il_activo
    from asterisk.agente a,
    	asterisk.tc_estado e
    where a.nu_agente = v_num_agente
    and a.nu_pin = v_pin
    and a.il_activo = 1;
    
    --Verifica si esta en queue_members
    if EXISTS (select * from asterisk.queue_members where split_part(split_part(interface, '@',1), '/'::varchar, 2) = substr(v_no_locacion,5,4)) then
	    v_il_logque := TRUE;
    end if;
   
	if v_il_activo = 1 then
    
      if v_no_locacion = v_tmp_locacion or v_tmp_locacion is NULL then 

        if v_il_datcorrec then
       
            if v_co_estado_old = p_co_estado then
               v_il_respta := 0; --Ya se encuentra fuera de cola
            else
              if v_il_logage then
                delete from asterisk.queue_members
                where split_part(split_part(interface, '@',1), '/'::varchar, 2) = substr(v_no_locacion,5,4);

                UPDATE asterisk.agente 
                SET no_locacion = NULL, 
                    nu_accion = NULL,
                    co_estado = p_co_estado
                WHERE nu_agente = v_num_agente
                AND nu_pin = v_pin
                and il_activo = 1;
            
                v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,7));
                v_il_respta := p_co_estado; --Deslogueo correcto
              else
              	v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,7));
                v_il_respta := -3; --No se encuentra en cola.
              end if;
            end if;
          
        else
            v_il_respta := -1; --Datos de login incorrectos. num_agente y pin
        end if;
     else
          v_il_respta := -2; --otro ya se encuentra logueado
     end if;
    else
--    	v_il_respta := -5; --Usuario inactivo
        v_il_respta := -1; --Usuario inactivo
    end if;
	
	return next v_il_respta;

RETURN;
END;
$$;


ALTER FUNCTION asterisk.logout_agente_queue(p_num_agente character varying, p_pin character varying, p_no_locacion character varying, p_co_estado integer) OWNER TO tintegro;

--
-- TOC entry 362 (class 1255 OID 70545)
-- Name: queue_member_asterisk_cc(); Type: FUNCTION; Schema: asterisk; Owner: postgres
--

CREATE FUNCTION queue_member_asterisk_cc() RETURNS SETOF trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_no_queueu varchar := null;	
    v_nu_agente varchar := null;
    v_nu_paused integer := null;
     
BEGIN
	         
    IF (TG_OP = 'INSERT') THEN

	select 'Agent/'||nu_agente 
	into v_nu_agente 
	from asterisk.agente where id_agente = NEW.id_agente limit 1;

	update asterisk.queue_agent
	set "Name" = NEW.interface, "Status" = 1
	where "Location" = v_nu_agente;
	  
        RETURN NEW;
        
    END IF;

    IF (TG_OP = 'UPDATE') THEN

	select 'Agent/'||nu_agente 
	into v_nu_agente 
	from asterisk.agente where id_agente = NEW.id_agente limit 1;

	if (OLD.paused <> NEW.paused) then
		update asterisk.queue_agent
		set "Paused" = NEW.paused
		where "Location" = v_nu_agente;

	end if;
         RETURN NEW;
        
    END IF;

    IF (TG_OP = 'DELETE') THEN

	select 'Agent/'||nu_agente 
	into v_nu_agente 
	from asterisk.agente where id_agente = OLD.id_agente limit 1;

	update asterisk.queue_agent
	set "Paused" = 0, "Status" = 5
	where "Location" = v_nu_agente;

	RETURN NEW;
        
    END IF;


   RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.queue_member_asterisk_cc() OWNER TO postgres;

--
-- TOC entry 370 (class 1255 OID 70546)
-- Name: sip_buddies_insert(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sip_buddies_insert() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN

  INSERT INTO asterisk.extensions_table(  context, exten, priority, app, appdata )
					   VALUES(  'anexos', NEW.name, 1, 'Macro', 'stdexten');
  	
return NEW;        
END;
$$;


ALTER FUNCTION asterisk.sip_buddies_insert() OWNER TO tintegro;

--
-- TOC entry 364 (class 1255 OID 70547)
-- Name: sp_act_usuario_pin(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_act_usuario_pin(p_id_usuario integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	salida integer := 0; 
    v_id_usuario integer := p_id_usuario;
    
BEGIN

  UPDATE 
    asterisk.tb_usuario  
  SET 
    il_activo = true
  WHERE 
    id_usuari = v_id_usuario;
  
salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_act_usuario_pin(p_id_usuario integer) OWNER TO tintegro;

--
-- TOC entry 436 (class 1255 OID 106211)
-- Name: sp_consulta_x_usuario_id(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_consulta_x_usuario_id(p_id_usuario integer) RETURNS SETOF consulta_x_usuario_id
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.consulta_x_usuario_id;
	v_id_usuario integer := p_id_usuario;
	
BEGIN
  for v_val_return in
  select 
      u.id_usuari,
      u.no_apepat,
      u.no_apemat,
      u.no_nombre,
      u.no_puesto,
      u.nu_pin,
      u.ti_llamad,
      
      
         (case when u.ti_llamad > 0 then 1 else 0 end) as estado_ti_llamad,
         u.id_empare as id_empare,
         (select ea.id_padre from asterisk.empresa_area ea where ea.id_empare=u.id_empare) as id_area,         
	
	u.id_sip,
      u.il_activo,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 1 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijloca,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 2 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 3 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijinte,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 2 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 3 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celinte,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = v_id_usuario and p.id_clave = 4 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celrpm
      
 
  from asterisk.tb_usuario u
  where 
  u.id_usuari=v_id_usuario

  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_consulta_x_usuario_id(p_id_usuario integer) OWNER TO tintegro;

--
-- TOC entry 365 (class 1255 OID 70548)
-- Name: sp_del_tbpin(integer, integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_del_tbpin(p_id_usuario integer, p_id_clave integer, p_tipo_telefono integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
 salida integer := 0; 
    v_id_usuario INTEGER := p_id_usuario;
    v_id_clave INTEGER := p_id_clave;
    v_tipo_telefono INTEGER := p_tipo_telefono;
BEGIN
DELETE FROM
  asterisk.tb_pin 
WHERE
 id_usupin = v_id_usuario
    and id_clave = v_id_clave
    and id_tiptel = v_tipo_telefono ;
    
salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_del_tbpin(p_id_usuario integer, p_id_clave integer, p_tipo_telefono integer) OWNER TO tintegro;

--
-- TOC entry 422 (class 1255 OID 105666)
-- Name: sp_delete_usuario_pin(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_delete_usuario_pin(p_id_usuario integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	salida integer := 0; 
    v_id_usuario integer := p_id_usuario;
	

BEGIN

insert into asterisk.tb_usuario_eliminado
select id_usuari,no_apepat,no_apemat,no_nombre,no_puesto,nu_pin,ti_llamad,il_activo,
il_mostrar,id_empare,il_bolsa from  asterisk.tb_usuario where id_usuari=v_id_usuario;


 
  delete from asterisk.tb_pin
  where id_usupin = v_id_usuario;

  delete from asterisk.tb_usuario
  where id_usuari = v_id_usuario;


	salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_delete_usuario_pin(p_id_usuario integer) OWNER TO tintegro;

--
-- TOC entry 366 (class 1255 OID 70549)
-- Name: sp_desact_usuario_pin(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_desact_usuario_pin(p_id_usuario integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	salida integer := 0; 
    v_id_usuario integer := p_id_usuario;
    
BEGIN

  UPDATE 
    asterisk.tb_usuario  
  SET 
    il_activo = false
  WHERE 
    id_usuari = v_id_usuario;
  
salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_desact_usuario_pin(p_id_usuario integer) OWNER TO tintegro;

--
-- TOC entry 371 (class 1255 OID 70550)
-- Name: sp_ins_cdr_pin(character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_ins_cdr_pin(p_uniqueid character varying, p_pin character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	salida integer := 0;
	v_uniqueid varchar := p_uniqueid;
	v_pin varchar := p_pin;
BEGIN

INSERT INTO asterisk.cdr_pin (
	uniqueid,
	id_pin	
) VALUES (
	v_uniqueid,
	v_pin
);
salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_ins_cdr_pin(p_uniqueid character varying, p_pin character varying) OWNER TO tintegro;

--
-- TOC entry 441 (class 1255 OID 105664)
-- Name: sp_ins_usuario_pin(character varying, character varying, character varying, character varying, character varying, integer, integer, integer, integer, integer, integer, integer, integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_ins_usuario_pin(p_apepat character varying, p_apemat character varying, p_nombre character varying, p_puesto character varying, p_pin character varying, p_ti_llamad integer, p_id_empare integer, p_id_sip integer, p_il_fijloca integer, p_il_fijnaci integer, p_il_fijinte integer, p_il_celnaci integer, p_il_celint integer, p_il_celrpm integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    salida integer := 0; 
    v_id_usuario integer := 0;
    
    v_apepat varchar := p_apepat; 
    v_apemat varchar := p_apemat; 
    v_nombre varchar := p_nombre;
    v_puesto varchar := p_puesto;
    v_pin varchar := p_pin;
    
    v_ti_llamad integer := p_ti_llamad;
    v_id_empare integer := p_id_empare;
    v_id_sip integer := p_id_sip;

    v_il_fijloca integer := p_il_fijloca;
    v_il_fijnaci integer := p_il_fijnaci;
    v_il_fijinte integer := p_il_fijinte;
    v_il_celnaci integer := p_il_celnaci;
    v_il_celint integer := p_il_celInt;
    v_il_celrpm integer := p_il_celRpm;
    v_nu_pin varchar := md5(p_pin);
BEGIN
if (select nu_pin from asterisk.tb_usuario where nu_pin = v_nu_pin) is null then
  INSERT INTO asterisk.tb_usuario (
      no_apepat, 
      no_apemat, 
      no_nombre, 
      no_puesto, 
      nu_pin, 
      ti_llamad,
      il_activo,
      il_mostrar,
      id_empare,
      il_bolsa,
      id_sip
      
  ) VALUES (
      v_apepat, 
     v_apemat,
      v_nombre,
      v_puesto,
      md5(v_pin),
      v_ti_llamad,
      true,
      true,
      v_id_empare,
      false,
      v_id_sip

        ); 

	--raise notice 'grabo usuario';

  select id_usuari into v_id_usuario
  from asterisk.tb_usuario
  where no_apepat = v_apepat
  and no_apemat = v_apemat 
  and no_nombre = v_nombre;
  --and nu_pin = md5(v_pin);

  --raise exception 'id_usuario %', v_id_usuario;
  
  if (v_il_fijloca = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 1, 1);
   end if;
  
  if (v_il_fijnaci = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 2, 1);
  end if;
  
  if (v_il_fijinte = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 3, 1);
  end if;
  
  if (v_il_celnaci = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 2, 2);
  end if;
  
  if (v_il_celint = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 3, 2);
  end if;
  
  if (v_il_celrpm = 1) then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 4, 2);
  end if;
  salida := 1;
  end if;   
	
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_ins_usuario_pin(p_apepat character varying, p_apemat character varying, p_nombre character varying, p_puesto character varying, p_pin character varying, p_ti_llamad integer, p_id_empare integer, p_id_sip integer, p_il_fijloca integer, p_il_fijnaci integer, p_il_fijinte integer, p_il_celnaci integer, p_il_celint integer, p_il_celrpm integer) OWNER TO tintegro;

--
-- TOC entry 367 (class 1255 OID 70551)
-- Name: sp_insertar_tbpin(integer, integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_insertar_tbpin(p_id_usuario integer, p_id_clave integer, p_tipo_telefono integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
   v_id_usuario integer := p_id_usuario;
   v_id_clave integer := p_id_clave;
   v_tipo_telefono integer := p_tipo_telefono;
      
   salida integer := 0; 
BEGIN

INSERT INTO asterisk.tb_pin (
 	id_usupin,
    id_clave,
    id_tiptel
 
) VALUES (
 	v_id_usuario,
    v_id_clave,
    v_tipo_telefono
 
);

salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_insertar_tbpin(p_id_usuario integer, p_id_clave integer, p_tipo_telefono integer) OWNER TO tintegro;

--
-- TOC entry 368 (class 1255 OID 70552)
-- Name: sp_insertar_tiptelclave(integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_insertar_tiptelclave(id_tiptel integer, id_clave integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
   insertado INTEGER := 0;
BEGIN
   INSERT INTO asterisk.tctiptel_clave VALUES( id_tiptel, id_clave );
   insertado = 1;

   RETURN insertado;
END;
$$;


ALTER FUNCTION asterisk.sp_insertar_tiptelclave(id_tiptel integer, id_clave integer) OWNER TO tintegro;

--
-- TOC entry 369 (class 1255 OID 70553)
-- Name: sp_list_area_centro_costo(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_list_area_centro_costo() RETURNS SETOF tp_list_area_centro_costo
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.tp_list_area_centro_costo;
BEGIN
  for v_val_return in

  select id_empare,nombre from asterisk.empresa_area where tipo=1 and il_activo=true

 
  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_list_area_centro_costo() OWNER TO tintegro;

--
-- TOC entry 424 (class 1255 OID 87192)
-- Name: sp_list_extension(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_list_extension() RETURNS SETOF tp_list_extension
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.tp_list_extension;
BEGIN
  for v_val_return in



select b.id_sip,b.name,b.callerid From asterisk.sip_buddies b



 
  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_list_extension() OWNER TO tintegro;

--
-- TOC entry 430 (class 1255 OID 70555)
-- Name: sp_lista_ringroup(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_lista_ringroup(p_nu_grupo integer) RETURNS SETOF character varying
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_nu_grupo integer := p_nu_grupo;
    v_va_return varchar := null;
    v_ca_registros INTEGER := null; 
BEGIN

	select count(*) into v_ca_registros
	from asterisk.tb_grupo g,
	asterisk.tb_extensionxgrupo eg
	where g.id_grupo = eg.id_grupo
	and g.nu_grupo = v_nu_grupo;

	if v_ca_registros > 0 then 

        select * into v_va_return from asterisk.sp_sel_ringroup(v_nu_grupo);

        select substring(v_va_return, 2) into v_va_return;
    	--raise notice 'entre a mayor a 0';
	else 
    	
    	v_va_return = '-1';

    end if;

return next v_va_return;

return;

END;
$$;


ALTER FUNCTION asterisk.sp_lista_ringroup(p_nu_grupo integer) OWNER TO tintegro;

--
-- TOC entry 425 (class 1255 OID 70556)
-- Name: sp_listar_area_x_centro(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_listar_area_x_centro(p_id_area integer) RETURNS SETOF tp_listar_area_x_centro
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.tp_listar_area_x_centro;
	v_id_area integer := p_id_area;
BEGIN
  for v_val_return in


  select * From asterisk.empresa_area where id_padre=v_id_area

  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_listar_area_x_centro(p_id_area integer) OWNER TO tintegro;

--
-- TOC entry 372 (class 1255 OID 70557)
-- Name: sp_login_cola(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_login_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    v_il_respta INTEGER := NULL; 
    v_nu_agente integer := p_nu_agente::integer;
    v_pin integer := p_pin::integer;
    v_no_interface VARCHAR := p_no_interface;
    v_il_login smallint := NULL;
    v_id_agente INTEGER := NULL;
    v_ca_colas smallint := NULL;
    v_va_return INTEGER := NULL;
    v_il_interface smallint := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select id_agente into v_id_agente from asterisk.agente where nu_agente = v_nu_agente and nu_pin = v_pin;
    
    --Verifica si tiene colas asignadas
    select count(*) into v_ca_colas from asterisk.agente_por_cola c where c.id_agecola = v_id_agente;

    --Verifica si esta logueado
    select count(*) into v_il_login from asterisk.queue_member_table where id_agente = v_id_agente;

    --Verifica si estta logueado con la misma interface	
    select count(*) into v_il_interface from asterisk.queue_member_table where id_agente = v_id_agente and interface = v_no_interface;
    
    --raise notice 'locacion%, locacion_tmp%', v_no_locacion, v_tmp_locacion; 

    if v_id_agente > 0 then --credenciales correctas

	if v_ca_colas > 0 then -- tiene al menos una cola asignadas

		if v_il_login > 0 then -- el agente se encuentra logueado

			if v_il_interface > 0 then -- se encuentra logueado con la misma interface SIP
				return next 1;
				return;
				exit;
			else 
				update asterisk.queue_member_table set interface = v_no_interface where id_agente = v_id_agente;
                                 return next 1;
                                 return;
                                 exit;
			end if;

		else
			INSERT INTO asterisk.queue_member_table(membername, queue_name, interface, penalty, paused, id_agente) 
			select (a.no_apepat || ' ' || no_apemat || ' ' || no_nombre), 
			       q.name,
			       v_no_interface,  
			       ac.nu_prorid, 
			       0,
			       v_id_agente
			from asterisk.queues q,
			    asterisk.agente_por_cola ac,
			    asterisk.agente a
			where q.id_queues = ac.id_cola
			and ac.id_agecola = a.id_agente
			and a.id_agente = v_id_agente;

			v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,1));

			return next 1;
			return;
                        exit;

		end if;

	else
		return next -2; -- no tiene colas asignadas
	end if;
    else
	return next -1; -- credenciales erroneas
    end if;
        
    --return next v_il_respta;

RETURN ; 
END;
$$;


ALTER FUNCTION asterisk.sp_login_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) OWNER TO tintegro;

--
-- TOC entry 373 (class 1255 OID 70558)
-- Name: sp_login_queue(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_login_queue(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    v_il_respta INTEGER := NULL; 
    v_nu_agente integer := p_nu_agente::integer;
    v_pin integer := p_pin::integer;
    v_no_locacion VARCHAR := p_no_locacion;
    v_tmp_locacion VARCHAR := NULL;
    v_il_logage BOOLEAN := false;
    v_il_logque BOOLEAN := false;
    v_co_estado smallint := NULL;
    v_ti_estado smallint := NULL;
    v_il_datcorrec BOOLEAN := false;
    v_id_agente INTEGER := NULL;
    v_ca_colas INTEGER := NULL;
    v_va_return INTEGER := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select (case when id_agente is null then false else true end) into v_il_datcorrec 
    from asterisk.agente where nu_agente::integer = v_nu_agente and nu_pin = v_pin;
    
    --Saca el id del agente y verifica si esta logueado, en que estado y que tipo de login es
    select a.id_agente, (case when a.no_locacion is null then false else true end), a.co_estado, e.ti_estado, a.no_locacion, a.il_activo
    into v_id_agente, v_il_logage, v_co_estado, v_ti_estado, v_tmp_locacion, v_il_activo
    from asterisk.agente a,
    	asterisk.tc_estado e
    where a.co_estado = e.id_estage
    and a.nu_agente::integer = v_nu_agente
    and nu_pin = v_pin
    and a.il_activo = 1;
    
    --Verifica si tiene colas asignadas
    select count(*) into v_ca_colas from asterisk.agente_por_cola c where c.id_agecola = v_id_agente;

    --Verifica si esta en queue_members
    if EXISTS (select * from asterisk.queue_members where split_part(split_part(interface, '@',1), '/', 2) = v_no_locacion) then
	    v_il_logque := TRUE;
    end if;
	
    --raise notice 'locacion%, locacion_tmp%', v_no_locacion, v_tmp_locacion; 
    
    if v_il_activo = 1 then
    
      if v_ca_colas > 0 then --Si tiene colas asignadas
      
        if v_no_locacion = v_tmp_locacion or v_tmp_locacion is NULL then --Si es la misma extension o estaba vacio
			
          if v_il_datcorrec then -- Si user y paswd son correctos
      	   
             if (v_il_logage and v_il_logque is FALSE) then 
                  --raise notice 'entro en true, false';
                  UPDATE asterisk.agente 
                  SET no_locacion = v_no_locacion, 
                      nu_accion = 1,
                      co_estado = 1
                  WHERE nu_agente::integer = v_nu_agente
                  AND nu_pin = v_pin
                  and il_activo = 1;

                  INSERT INTO asterisk.queue_members ( queue_name, interface, penalty, membername, paused) 
                                                        select q.name, 
                                                              'Local/' || v_no_locacion || '@call-to-agent/n',  
                                                              ac.nu_prorid, 
                                                              'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || v_no_locacion || '/' || v_id_agente || '@', 
                                                              0
                                                        from asterisk.queues q,
                                                            asterisk.agente_por_cola ac,
                                                            asterisk.agente a
                                                        where q.id_queues = ac.id_cola
                                                        and ac.id_agecola = a.id_agente
                                                        and a.nu_agente::integer = v_nu_agente;
                   v_il_respta := 1;
                   
                elsif ( v_il_logage is FALSE and v_il_logque) then 
                  --raise notice 'entro en false, true';
                  delete from asterisk.queue_members
                  where split_part(split_part(interface, '@',1), '/', 2) = v_no_locacion;

                  UPDATE asterisk.agente 
                  SET no_locacion = v_no_locacion, 
                      nu_accion = 1,
                      co_estado = 1
                  WHERE nu_agente::integer = v_nu_agente
                  AND nu_pin = v_pin
                  and il_activo = 1;

                  INSERT INTO asterisk.queue_members ( queue_name, interface, penalty, membername, paused) 
                                                        select q.name, 
                                                              'Local/' || v_no_locacion || '@call-to-agent/n',  
                                                              ac.nu_prorid, 
                                                              'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || v_no_locacion || '/' || v_id_agente || '@', 
                                                              0
                                                        from asterisk.queues q,
                                                            asterisk.agente_por_cola ac,
                                                            asterisk.agente a
                                                        where q.id_queues = ac.id_cola
                                                        and ac.id_agecola = a.id_agente
                                                        and a.nu_agente::integer = v_nu_agente;

                    v_il_respta := 1;
                    
                elsif (v_il_logage is FALSE and v_il_logque is FALSE) then 
                  --raise notice 'entro en false, false';
                  UPDATE asterisk.agente 
                  SET no_locacion = v_no_locacion, 
                      nu_accion = 1,
                      co_estado = 1
                  WHERE nu_agente::integer = v_nu_agente
                  AND nu_pin = v_pin
                  and il_activo = 1;

                  INSERT INTO asterisk.queue_members ( queue_name, interface, penalty, membername, paused) 
                                                        select q.name, 
                                                              'Local/' || v_no_locacion || '@call-to-agent/n',  
                                                              ac.nu_prorid, 
                                                              'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || v_no_locacion || '/' || v_id_agente || '@', 
                                                              0
                                                        from asterisk.queues q,
                                                            asterisk.agente_por_cola ac,
                                                            asterisk.agente a
                                                        where q.id_queues = ac.id_cola
                                                        and ac.id_agecola = a.id_agente
                                                        and a.nu_agente::integer = v_nu_agente;

                    v_il_respta := 1;
                    
                elsif (v_il_logage and v_il_logque ) then 
                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                      nu_accion = 1,
                      co_estado = 1
                    WHERE nu_agente::integer = v_nu_agente
                    and il_activo = 1;
                    
                    UPDATE asterisk.queue_members
                        SET paused = 0
                    WHERE split_part(split_part(interface, '@',1), '/', 2) = v_no_locacion;
                        
                        
                   v_il_respta := 1;
                end if;
             --raise notice '%', v_co_estado;
            if v_co_estado = 1 then 
                v_il_respta := 0; --ya se encuentra en el estado escogido.
            else 
                v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,1));
                v_il_respta := 1;
            end if;

          
          else
              v_il_respta := -1; --Datos de login incorrectos. nu_agente::integer y nu_nu_pin
          end if;
        else
            v_il_respta := -2; --otro ya se encuentra logueado
        end if;
      else 
          v_il_respta := -4; --No tiene colas asignadas
      end if;
    else
--    	v_il_respta := -5; --Usuario inactivo
        v_il_respta := -1; --Usuario inactivo
    end if;
    
    return next v_il_respta;

RETURN ; 
END;
$$;


ALTER FUNCTION asterisk.sp_login_queue(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying) OWNER TO tintegro;

--
-- TOC entry 431 (class 1255 OID 70560)
-- Name: sp_logout_cola(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_logout_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    v_il_respta INTEGER := NULL; 
    v_nu_agente integer := p_nu_agente::integer;
    v_pin integer := p_pin::integer;
    v_no_interface VARCHAR := p_no_interface;
    v_il_login smallint := NULL;
    v_id_agente INTEGER := NULL;
    v_va_return INTEGER := NULL;
    v_il_interface smallint := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select id_agente into v_id_agente from asterisk.agente where nu_agente = v_nu_agente and nu_pin = v_pin;
    
    --Verifica si esta logueado
    select count(*) into v_il_login from asterisk.queue_member_table where id_agente = v_id_agente;

    --Verifica si estta logueado con la misma interface	
    select count(*) into v_il_interface from asterisk.queue_member_table where id_agente = v_id_agente and interface = v_no_interface;
    
    if v_id_agente > 0 then --credenciales correctas

	if v_il_login > 0 then -- el agente se encuentra logueado

		if v_il_interface > 0 then -- se encuentra logueado con la misma interface SIP

			delete from asterisk.queue_member_table where id_agente = v_id_agente;
			v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,2));
			return next 1;
			return;
			exit;
		else 
			 return next -3; --se encuentra logueado desde otra interface
			 return;
			 exit;
		end if;

	else
		return next -2; --agente no logueado
		return;
		exit;

	end if;
    else
	return next -1; -- credenciales erroneas
    end if;
        
    --return next v_il_respta;

RETURN ; 
END;
$$;


ALTER FUNCTION asterisk.sp_logout_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) OWNER TO tintegro;

--
-- TOC entry 374 (class 1255 OID 70561)
-- Name: sp_logout_queue(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_logout_queue(p_num_agente character varying, p_pin character varying, p_no_locacion character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	v_il_respta INTEGER := NULL; 
    v_num_agente VARCHAR := p_num_agente;
    v_pin VARCHAR := p_pin;
    v_no_locacion VARCHAR := p_no_locacion;
    v_tmp_locacion VARCHAR := NULL;
    v_co_estado smallint := NULL;
    v_ti_estado smallint := NULL;
    v_il_datcorrec BOOLEAN := FALSE;
    v_il_logage BOOLEAN := FALSE;
    v_il_logque BOOLEAN := FALSE;
    v_id_agente varchar := NULL;
    v_il_activo smallint := null;
BEGIN
       
	--Verifica si la informacion el usuario y password es correcto
    select (case when id_agente is null then false else true end) into v_il_datcorrec 
    from asterisk.agente where nu_agente::varchar = v_num_agente and nu_pin::varchar = v_pin;

    --Verifica si esta logueado en que estado y que tipo de login es
    select a.id_agente::varchar, (case when a.no_locacion is null then false else true end), a.co_estado, e.ti_estado, a.no_locacion, a.il_activo
    into v_id_agente, v_il_logage, v_co_estado, v_ti_estado, v_tmp_locacion, v_il_activo
    from asterisk.agente a,
    	asterisk.tc_estado e
    where a.co_estado = e.id_estage
    and a.nu_agente = v_num_agente::INTEGER
    and nu_pin::varchar = v_pin
    and a.il_activo = 1;
    
    --Verifica si esta en queue_members
    if EXISTS (select * from asterisk.queue_members where split_part(split_part(interface, '@',1), '/', 2) = v_no_locacion) then
	    v_il_logque := TRUE;
    end if;
    
    if v_il_activo = 1 then
   
      if v_no_locacion = v_tmp_locacion or v_tmp_locacion is NULL then 

        if v_il_datcorrec then
       
            if v_co_estado = 2 then
               v_il_respta := 0; --Ya se encuentra fuera de cola
            else
              if v_il_logage then
                delete from asterisk.queue_members
                where split_part(split_part(interface, '@',1), '/', 2) = v_no_locacion;

                UPDATE asterisk.agente 
                SET no_locacion = NULL, 
                    nu_accion = NULL,
                    co_estado = 2
                WHERE nu_agente::varchar = v_num_agente
                AND nu_pin::varchar = v_pin
                and il_activo = 1;
            
                v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente,2));
                v_il_respta := 2; --Deslogueo correcto
              else
              	--v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente,2));
                v_il_respta := -3; --No se encuentra en cola.
              end if;
            end if;
          
        else
            v_il_respta := -1; --Datos de login incorrectos. num_agente y pin
        end if;
     else
          v_il_respta := -2; --otro ya se encuentra logueado
     end if;
    else
--    	v_il_respta := -5; --Usuario inactivo
        v_il_respta := -1; --Usuario inactivo
    end if;
	
	return next v_il_respta;

RETURN;
END;
$$;


ALTER FUNCTION asterisk.sp_logout_queue(p_num_agente character varying, p_pin character varying, p_no_locacion character varying) OWNER TO tintegro;

--
-- TOC entry 375 (class 1255 OID 70562)
-- Name: sp_pause_cola(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_pause_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    v_il_respta INTEGER := NULL; 
    v_nu_agente integer := p_nu_agente::integer;
    v_pin integer := p_pin::integer;
    v_no_interface VARCHAR := p_no_interface;
    v_il_login smallint := NULL;
    v_id_agente INTEGER := NULL;
    v_va_return INTEGER := NULL;
    v_il_interface smallint := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select id_agente into v_id_agente from asterisk.agente where nu_agente = v_nu_agente and nu_pin = v_pin;
    
    --Verifica si esta logueado
    select count(*) into v_il_login from asterisk.queue_member_table where id_agente = v_id_agente;

    --Verifica si estta logueado con la misma interface	
    select count(*) into v_il_interface from asterisk.queue_member_table where id_agente = v_id_agente and interface = v_no_interface;
    
    if v_id_agente > 0 then --credenciales correctas

	if v_il_login > 0 then -- el agente se encuentra logueado

		if v_il_interface > 0 then -- se encuentra logueado con la misma interface SIP

			update asterisk.queue_member_table set paused = 1 where id_agente = v_id_agente;
			v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,3));
			return next 1;
			return;
			exit;
		else 
			 return next -3; --se encuentra logueado desde otra interface
			 return;
			 exit;
		end if;

	else
		return next -2; --agente no logueado
		return;
		exit;

	end if;
    else
	return next -1; -- credenciales erroneas
    end if;
        
    --return next v_il_respta;

RETURN ; 
END;
$$;


ALTER FUNCTION asterisk.sp_pause_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) OWNER TO tintegro;

--
-- TOC entry 376 (class 1255 OID 70563)
-- Name: sp_sel_ringroup(integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_sel_ringroup(p_nu_grupo integer) RETURNS SETOF character varying
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
DECLARE
    c_ringroup refcursor;  
    v_nu_grupo integer := p_nu_grupo;
    v_rec record;
    cadena varchar(50);
    temporal varchar(20);
BEGIN

cadena = '';
open c_ringroup for select ('SIP/'||s.name) as extension
                  from asterisk.tb_grupo g,
                  asterisk.tb_extensionxgrupo eg,
                  asterisk.sip_buddies s
                  where g.id_grupo = eg.id_grupo
                  and g.nu_grupo = v_nu_grupo
                  and eg.id_exten = s.id_sip;

loop
--	fetch c_ringroup into v_rec;
	fetch c_ringroup into temporal;
	if temporal is null then exit; end if;
	cadena := cadena ||'&' || temporal;
  
--	return next c_ringroup;
end loop;
close c_ringroup;
--return next c_ringroup;
cadena := substr(cadena,1);
return next cadena;

return;

END;
$$;


ALTER FUNCTION asterisk.sp_sel_ringroup(p_nu_grupo integer) OWNER TO tintegro;

--
-- TOC entry 427 (class 1255 OID 105918)
-- Name: sp_sel_usuario_pin(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_sel_usuario_pin() RETURNS SETOF usuario_pin
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.usuario_pin;
BEGIN
  for v_val_return in
  select u.id_usuari,
      u.no_apepat||' '||u.no_apemat||' '||u.no_nombre as nombre,
     -- u.no_apemat,
     -- u.no_nombre,
     --u.no_puesto,
     --u.nu_pin,
      u.il_activo,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 1 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijloca,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 2 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 3 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijinte,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 2 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celloca,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 3 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 4 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celrpm
  from asterisk.tb_usuario u
  order by u.no_apepat,u.no_apemat, u.no_nombre asc

  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_sel_usuario_pin() OWNER TO tintegro;

--
-- TOC entry 428 (class 1255 OID 105919)
-- Name: sp_sel_x_usuario_pin(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_sel_x_usuario_pin(p_nom_usuario character varying) RETURNS SETOF usuario_pin
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_val_return asterisk.consulta_X_usuario_pin;
	v_nom_usuario varchar := p_nom_usuario;
BEGIN
  for v_val_return in
  select u.id_usuari,
      u.no_apepat||' '||u.no_apemat||' '||u.no_nombre as nombre,
      u.il_activo,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 1 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijloca,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 2 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 3 and p.id_tiptel = 1) = 1 then 1 else 0 end) as il_fijinte,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 2 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celloca,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 3 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celnaci,
      (case when (select 1 from asterisk.tb_pin p where p.id_usupin = u.id_usuari and p.id_clave = 4 and p.id_tiptel = 2) = 1 then 1 else 0 end) as il_celinte
  from asterisk.tb_usuario u
  where 
  (
  lower( u.no_apepat ) like  '%' || lower( v_nom_usuario ) or
  lower(u.no_apemat )like '%' || lower( v_nom_usuario) or
  lower(u.no_nombre) like '%' || lower(v_nom_usuario) )
  --order by u.il_activo desc, u.no_apepat,u.no_apemat, u.no_nombre

  
  Loop
  return next v_val_return;
end loop;
return;
END;
$$;


ALTER FUNCTION asterisk.sp_sel_x_usuario_pin(p_nom_usuario character varying) OWNER TO tintegro;

--
-- TOC entry 377 (class 1255 OID 70566)
-- Name: sp_sin_acd_queue(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_sin_acd_queue(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying) RETURNS integer
    LANGUAGE plpgsql STRICT
    AS $$
DECLARE 
	v_il_respta INTEGER := NULL; 
    v_nu_agente VARCHAR := p_nu_agente;
    v_pin VARCHAR := p_pin;
    v_no_locacion VARCHAR := p_no_locacion;
    v_tmp_locacion VARCHAR := NULL;
    v_il_logage BOOLEAN := false;
    v_il_logque BOOLEAN := false;
    v_co_estado smallint := NULL;
    v_ti_estado smallint := NULL;
    v_il_datcorrec BOOLEAN := false;
    v_id_agente INTEGER := NULL;
    v_ca_colas INTEGER := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select (case when id is null then false else true end) into v_il_datcorrec 
    from asterisk.agente where num_agente = v_nu_agente and pin = v_pin;
    
    --Saca el id del agente y verifica si esta logueado, en que estado y que tipo de login es
    select a.id, (case when a.no_locacion is null then false else true end), a.co_estado, e.ti_estado, a.no_locacion, a.il_activo
    into v_id_agente, v_il_logage, v_co_estado, v_ti_estado, v_tmp_locacion, v_il_activo
    from asterisk.agente a,
    	asterisk.tc_estado e
    where a.num_agente = v_nu_agente
    and pin = v_pin
    and a.il_activo = 1;
    
    --Verifica si tiene colas asignadas
    select count(*) into v_ca_colas from asterisk.agente_por_cola where id_agente = v_id_agente;
    
    --Verifica si esta en queue_members
    if EXISTS (select * from asterisk.queue_members where split_part(split_part(interface, '@',1), '/', 2) = substr(v_no_locacion,5,4)) then
	    v_il_logque := TRUE;
    end if;
    
    if v_il_activo = 1 then
    
      if v_ca_colas > 0 then
  	
          if v_no_locacion = v_tmp_locacion or v_tmp_locacion is NULL then 

            if v_il_datcorrec then

        	   
               if (v_il_logage and v_il_logque is FALSE) then 
                    --raise notice 'entro en true, false';
                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = 5
                    WHERE num_agente = v_nu_agente
                    AND pin = v_pin
                    and il_activo = 1;

                    insert into asterisk.queue_members (
                                                          select nextval('asterisk.queue_members_id_queue_seq'::text),
                                                                q.name, 
                                                                'Local/' || substr(v_no_locacion,5,4) || '@call-to-agent/n',  
                                                                ac.nu_prorid, 
                                                                'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || substr(v_no_locacion,5,4) || '/' || v_nu_agente || '@', 
                                                                1
                                                          from asterisk.queues q,
                                                              asterisk.agente_por_cola ac,
                                                              asterisk.agente a
                                                          where q.id = ac.id_cola
                                                          and ac.id_agecol = a.id
                                                          and a.num_agente = v_nu_agente);
                     v_il_respta := 5;
                     
                  elsif ( v_il_logage is FALSE and v_il_logque) then 
                    --raise notice 'entro en false, true';
                    delete from asterisk.queue_members
                    where split_part(split_part(interface, '@',1), '/', 2) = substr(v_no_locacion,5,4);

                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = 5
                    WHERE num_agente = v_nu_agente
                    AND pin = v_pin
                    and il_activo = 1;

                    insert into asterisk.queue_members (
                                                          select nextval('asterisk.queue_members_id_queue_seq'::text),
                                                                q.name, 
                                                                'Local/' || substr(v_no_locacion,5,4) || '@call-to-agent/n',  
                                                                ac.nu_prorid, 
                                                                'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || substr(v_no_locacion,5,4) || '/' || v_nu_agente || '@', 
                                                                1
                                                          from asterisk.queues q,
                                                              asterisk.agente_por_cola ac,
                                                              asterisk.agente a
                                                          where q.id = ac.id_cola
                                                          and ac.id_agecol = a.id
                                                          and a.num_agente = v_nu_agente);

                      v_il_respta := 5;
                      
                  elsif (v_il_logage is FALSE and v_il_logque is FALSE) then 
                    --raise notice 'entro en false, false';
                    UPDATE asterisk.agente 
                    SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = 5
                    WHERE num_agente = v_nu_agente
                    AND pin = v_pin
                    and il_activo = 1;

                    insert into asterisk.queue_members (
                                                          select nextval('asterisk.queue_members_id_queue_seq'::text),
                                                                q.name, 
                                                                'Local/' || substr(v_no_locacion,5,4) || '@call-to-agent/n', 
                                                                ac.nu_prorid, 
                                                                'Ag-' || a.no_apepat || ' ' || substr(no_apemat,1,1) || '. ' || no_nombre || '/' || substr(v_no_locacion,5,4) || '/' || v_nu_agente || '@', 
                                                                1
                                                          from asterisk.queues q,
                                                              asterisk.agente_por_cola ac,
                                                              asterisk.agente a
                                                          where q.id = ac.id_cola
                                                          and ac.id_agecol = a.id
                                                          and a.num_agente = v_nu_agente);

                      v_il_respta := 5;
                      
                  elsif (v_il_logage and v_il_logque ) then 
                      UPDATE asterisk.agente 
                      SET no_locacion = v_no_locacion, 
                        nu_accion = 1,
                        co_estado = 5
                      WHERE num_agente = v_nu_agente
                      and il_activo = 1;
                      
                      UPDATE asterisk.queue_members
                          SET paused = 1
                      WHERE split_part(split_part(interface, '@',1), '/', 2) = substr(v_no_locacion,5,4);
                          
                          
                     v_il_respta := 5;
                  end if;
               --raise notice '%', v_co_estado;
              if v_co_estado = 5 then 
                  v_il_respta := 0; --ya se encuentra en el estado escogido.
              else 
                  v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,5));
                  v_il_respta := 5;
              end if;

            
            else
                v_il_respta := -1; --Datos de login incorrectos. num_agente y pin
            end if;
          else
              v_il_respta := -2; --otro ya se encuentra logueado
          end if;
      else 
          v_il_respta := -4; --No tiene colas asignadas
      end if;
    else
--    	v_il_respta := -5; --Usuario inactivo
        v_il_respta := -1; --Usuario inactivo
    end if;       
        
RETURN v_il_respta;
END;
$$;


ALTER FUNCTION asterisk.sp_sin_acd_queue(p_nu_agente character varying, p_pin character varying, p_no_locacion character varying) OWNER TO tintegro;

--
-- TOC entry 432 (class 1255 OID 70567)
-- Name: sp_unpause_cola(character varying, character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_unpause_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
    v_il_respta INTEGER := NULL; 
    v_nu_agente integer := p_nu_agente::integer;
    v_pin integer := p_pin::integer;
    v_no_interface VARCHAR := p_no_interface;
    v_il_login smallint := NULL;
    v_id_agente INTEGER := NULL;
    v_va_return INTEGER := NULL;
    v_il_interface smallint := NULL;
    v_il_activo smallint := null;
BEGIN
    
    --Verifica si la informacion el usuario y password es correcto
    select id_agente into v_id_agente from asterisk.agente where nu_agente = v_nu_agente and nu_pin = v_pin;
    
    --Verifica si esta logueado
    select count(*) into v_il_login from asterisk.queue_member_table where id_agente = v_id_agente;

    --Verifica si estta logueado con la misma interface	
    select count(*) into v_il_interface from asterisk.queue_member_table where id_agente = v_id_agente and interface = v_no_interface;
    
    if v_id_agente > 0 then --credenciales correctas

	if v_il_login > 0 then -- el agente se encuentra logueado

		if v_il_interface > 0 then -- se encuentra logueado con la misma interface SIP

			update asterisk.queue_member_table set paused = 0 where id_agente = v_id_agente;
			v_il_respta := (select * from asterisk.graba_estado_agente(v_id_agente::varchar,1));
			return next 1;
			return;
			exit;
		else 
			 return next -3; --se encuentra logueado desde otra interface
			 return;
			 exit;
		end if;

	else
		return next -2; --agente no logueado
		return;
		exit;

	end if;
    else
	return next -1; -- credenciales erroneas
    end if;
        
    --return next v_il_respta;

RETURN ; 
END;
$$;


ALTER FUNCTION asterisk.sp_unpause_cola(p_nu_agente character varying, p_pin character varying, p_no_interface character varying) OWNER TO tintegro;

--
-- TOC entry 426 (class 1255 OID 105665)
-- Name: sp_upd_usuario_pin(integer, character varying, character varying, character varying, character varying, character varying, integer, integer, integer, integer, integer, integer, integer, integer, integer); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION sp_upd_usuario_pin(p_id_usuario integer, p_apepat character varying, p_apemat character varying, p_nombre character varying, p_puesto character varying, p_pin character varying, p_ti_llamad integer, p_id_empare integer, p_id_sip integer, p_il_fijloca integer, p_il_fijnaci integer, p_il_fijinte integer, p_il_celnaci integer, p_il_celinte integer, p_il_celrpm integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	salida integer := 0; 
    v_id_usuario integer := p_id_usuario;
	v_apepat varchar := p_apepat; 
    v_apemat varchar := p_apemat; 
    v_nombre varchar := p_nombre;
    v_puesto varchar := p_puesto;
    v_pin varchar := p_pin;
    --v_co_estado integer := p_co_estado;
    v_ti_llamad integer := p_ti_llamad;
    v_id_empare integer := p_id_empare;
    v_id_sip integer := p_id_sip;
    
    v_il_fijloca INTEGER := p_il_fijloca;
    v_il_fijnaci INTEGER := p_il_fijnaci;
    v_il_fijinte INTEGER := p_il_fijinte;
    v_il_celnaci INTEGER := p_il_celnaci;
    v_il_celinte INTEGER := p_il_celinte;
    v_il_celrpm INTEGER := p_il_celrpm;
    v_nu_pin varchar := md5(p_pin);
BEGIN



if (select nu_pin from asterisk.tb_usuario where nu_pin = v_nu_pin) is null then

	if v_pin is null or v_pin = '' then
		UPDATE asterisk.tb_usuario set
		      no_apepat =v_apepat, 
		      no_apemat =v_apemat, 
		      no_nombre =v_nombre, 
		      no_puesto =v_puesto, 	     
		      ti_llamad=v_ti_llamad,
		      id_empare=v_id_empare,
		      id_sip=v_id_sip
		     -- co_estado = v_co_estado     
		  where id_usuari = v_id_usuario;
	 
	else if v_pin is not null  or v_pin <> '' then 
		UPDATE asterisk.tb_usuario set
		      no_apepat =v_apepat, 
		      no_apemat =v_apemat, 
		      no_nombre =v_nombre, 
		      no_puesto =v_puesto, 
		      nu_pin =  md5(v_pin),
		      ti_llamad=v_ti_llamad,
		      id_empare=v_id_empare,
		      id_sip=v_id_sip
		     -- co_estado = v_co_estado     
		  where id_usuari = v_id_usuario;
	end if;
	end if;



 
  delete from asterisk.tb_pin
  where id_usupin = v_id_usuario;


  if v_il_fijloca = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 1, 1);
   end if;
  
  if v_il_fijnaci = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 2, 1);
  end if;
  
  if v_il_fijinte = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 3, 1);
  end if;
  
  if v_il_celnaci = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 2, 2);
  end if;
  
  if v_il_celinte = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 3, 2);
  end if;
  
  if v_il_celrpm = 1 then
  	insert into asterisk.tb_pin (id_usupin, id_clave, id_tiptel) values (v_id_usuario, 4, 2);
  end if;

	salida := 1;
 end if;
RETURN salida;
END;
$$;


ALTER FUNCTION asterisk.sp_upd_usuario_pin(p_id_usuario integer, p_apepat character varying, p_apemat character varying, p_nombre character varying, p_puesto character varying, p_pin character varying, p_ti_llamad integer, p_id_empare integer, p_id_sip integer, p_il_fijloca integer, p_il_fijnaci integer, p_il_fijinte integer, p_il_celnaci integer, p_il_celinte integer, p_il_celrpm integer) OWNER TO tintegro;

--
-- TOC entry 433 (class 1255 OID 70568)
-- Name: tbusuariopin(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION tbusuariopin(p_nu_pin character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE	
  v_nu_pin varchar := p_nu_pin;
  salida INTEGER := 0; 
BEGIN
   for salida in  
  SELECT 
  a.id_usuari
  FROM 
  asterisk.tb_usuario as a
  where
  a.nu_pin = md5(v_nu_pin)
   loop 
           
  RETURN next salida;
  end loop; 
  return;
END;
$$;


ALTER FUNCTION asterisk.tbusuariopin(p_nu_pin character varying) OWNER TO tintegro;

--
-- TOC entry 379 (class 1255 OID 70569)
-- Name: update_fechaqueues(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION update_fechaqueues() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN   
	UPDATE asterisk.queue_member_table SET fe_creacion = ('now'::text)::timestamp(0) with time zone where uniqueid = NEW.uniqueid;
       
      RETURN NEW;
        
  
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.update_fechaqueues() OWNER TO tintegro;

--
-- TOC entry 380 (class 1255 OID 70570)
-- Name: update_queuemembers(); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION update_queuemembers() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    v_id_usuario integer := null;
    v_uniqueid varchar := null;
    v_num_pin varchar := null;
BEGIN
   
    IF (TG_OP = 'INSERT') THEN

	UPDATE asterisk.queue_members SET id_agente = split_part( split_part(NEW.membername, '/', 3), '@', 1)::integer where id_queuem = NEW.id_queuem;
        
      RETURN NEW;
        
    END IF;
    RETURN NULL; 
END;
$$;


ALTER FUNCTION asterisk.update_queuemembers() OWNER TO tintegro;

--
-- TOC entry 378 (class 1255 OID 70571)
-- Name: usuario_logueado(character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION usuario_logueado(p_no_agente character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE

    v_no_agente varchar := p_no_agente;
    v_il_existe varchar := NULL;
    v_va_return integer := NULL;

BEGIN

    select (case when a.es_usuari = 0 then 0 else 1 end) into v_il_existe
    from asterisk.agente a
    where split_part(a.no_locacion,'/',2) = v_no_agente;

    if v_il_existe is not null then 
       v_va_return := 1;
    else
	 v_va_return := 0;
    end if;

return next v_va_return;

return;

END;
$$;


ALTER FUNCTION asterisk.usuario_logueado(p_no_agente character varying) OWNER TO tintegro;

--
-- TOC entry 442 (class 1255 OID 111832)
-- Name: validar_insertar_area_centrocosto(character varying, character varying); Type: FUNCTION; Schema: asterisk; Owner: tintegro
--

CREATE FUNCTION validar_insertar_area_centrocosto(p_no_area character varying, p_no_centcosto character varying) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_id_area integer := null;
  v_id_centro integer := NULL;
  v_no_area varchar := trim(p_no_area);
  v_no_centcosto varchar := trim(p_no_centcosto);
  
BEGIN

if p_no_area is null then v_no_area := ''; end if;
if p_no_centcosto is null then v_no_centcosto := ''; end if;

	if v_no_area <> '' and v_no_centcosto <> '' then 
		select id_empare into v_id_area from asterisk.empresa_area where upper(nombre) = upper(v_no_area) and tipo = 1;	
		raise notice 'Primeros valores del select id_area:, %', v_id_area;
		raise notice 'Primeros valores del select id_cent:, %', v_id_centro;
		
		if v_id_area is null then 
			INSERT INTO asterisk.empresa_area(nombre, tipo) VALUES (v_no_area, 1);
			select id_empare into v_id_area from asterisk.empresa_area where tipo = 1 order by id_empare desc limit 1;
			INSERT INTO asterisk.empresa_area(nombre, tipo, id_padre) VALUES (v_no_centcosto, 2, v_id_area);
			select id_empare into v_id_centro from asterisk.empresa_area where tipo = 2 order by id_empare desc limit 1;
			raise notice 'Entro al if de area:, %', v_id_area;		
		else  
			select id_empare into v_id_centro from asterisk.empresa_area where upper(nombre) = upper(v_no_centcosto) and tipo = 2 and id_padre = v_id_area;
			if v_id_centro is null then
				INSERT INTO asterisk.empresa_area(nombre, tipo, id_padre) VALUES (v_no_centcosto, 2, v_id_area);
				select id_empare into v_id_centro from asterisk.empresa_area where tipo = 2 order by id_empare desc limit 1;
				raise notice 'Entro al if de centro de costo:, %', v_id_centro;
			end if;	
		end if;
	else if v_no_area <> '' and v_no_centcosto = '' then
		select id_empare into v_id_area from asterisk.empresa_area where nombre = v_no_area and tipo = 1;	
		raise notice 'Primeros valores del select id_area:, %', v_id_area;	
		if v_id_area is null then 
			INSERT INTO asterisk.empresa_area(nombre, tipo) VALUES (v_no_area, 1);
			select id_empare into v_id_area from asterisk.empresa_area where tipo = 1 order by id_empare desc limit 1;
			INSERT INTO asterisk.empresa_area(nombre, tipo, id_padre) VALUES (v_no_area, 2, v_id_area);
			select id_empare into v_id_centro from asterisk.empresa_area where tipo = 2 order by id_empare desc limit 1;
			raise notice 'Entro al if de area:, %', v_id_area;		
		else  
			select id_empare into v_id_centro from asterisk.empresa_area where upper(nombre) = upper(v_no_area) and tipo = 2 and id_padre = v_id_area;
			if v_id_centro is null then
				INSERT INTO asterisk.empresa_area(nombre, tipo, id_padre) VALUES (v_no_area, 2, v_id_area);
				select id_empare into v_id_centro from asterisk.empresa_area where tipo = 2 order by id_empare desc limit 1;
				raise notice 'Entro al if de centro de costo:, %', v_id_centro;
			end if;	
		end if;
	else if v_no_area = '' and v_no_centcosto = '' then
		select id_empare into v_id_centro from asterisk.empresa_area where upper(nombre) = 'GENERAL' and tipo = 2;
	end if;
	end if;
	end if;
	
	raise notice 'Devuelve:, %', v_id_centro;
    
  return next v_id_centro;
          
 return;
END;
$$;


ALTER FUNCTION asterisk.validar_insertar_area_centrocosto(p_no_area character varying, p_no_centcosto character varying) OWNER TO tintegro;

SET search_path = public, pg_catalog;

--
-- TOC entry 438 (class 1255 OID 70572)
-- Name: actualiza_callcenter(); Type: FUNCTION; Schema: public; Owner: tintegro
--

CREATE FUNCTION actualiza_callcenter() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
v_callid varchar := null;
v_data2 varchar := null;
v_agente varchar := null;
v_time timestamp(0) := null;
BEGIN
   
	if( new.event in ('RINGNOANSWER', 'COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')) THEN
	
		select q.data2, q.tiempo into v_callid, v_time  from asterisk.tb_auxcallcenter q where q.callid = NEW.callid;
		select nu_agente into v_agente from asterisk.agente a, asterisk.queue_member_table q where a.id_agente = q.id_agente and membername = NEW.agent limit 1;

		if v_time is not null then
			new."time" := v_time;
		end if;
		new.data4 := v_callid;
		new.data5 := v_agente;
	      
		if( new.event in ('COMPLETEAGENT', 'COMPLETECALLER')) THEN
			if (new.data2::integer > 1000 ) then
				new.data2 = '300';
			end if;

		end if;

		delete from asterisk.tb_auxcallcenter where callid = new.callid;
              
	 end if;

        
   RETURN NEW; 
END;
$$;


ALTER FUNCTION public.actualiza_callcenter() OWNER TO tintegro;

--
-- TOC entry 382 (class 1255 OID 70573)
-- Name: ingresa_auxiliarcallcenter(); Type: FUNCTION; Schema: public; Owner: tintegro
--

CREATE FUNCTION ingresa_auxiliarcallcenter() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
v_callid varchar := null;
v_data2 varchar := null;
v_agente varchar := null;
BEGIN
   
	if (new.event = 'ENTERQUEUE') then
		INSERT INTO asterisk.tb_auxcallcenter(callid, data2, tiempo) VALUES (new.callid, new.data2, new."time");	
	end if;


   RETURN NEW; 
END;
$$;


ALTER FUNCTION public.ingresa_auxiliarcallcenter() OWNER TO tintegro;

SET search_path = reportes, pg_catalog;

--
-- TOC entry 476 (class 1255 OID 144691)
-- Name: area_llamada_top(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION area_llamada_top(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_neww
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_neww%rowtype;
 
 v_id_area integer := p_id_area; 
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;

 BEGIN
    raise notice 'parameters: %, %, %, %, % ', v_id_area, p_fe_ini, p_fe_fin, p_horai, p_horaf;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf = '' then '23:59:59' else v_horaf end;

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	if v_id_area = 0 then
	  for v_va_return in 
		SELECT ea.id_padre as id,
			(select nombre from asterisk.empresa_area where id_empare = ea.id_padre) as area,
			sum(1) as can_llamadas,
			(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
			((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
			(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
			(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c, 
		asterisk.empresa_area ea 
		WHERE c.id_area = ea.id_empare
		and id_area is not null
		and calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY 1, 2
		ORDER BY tiempo_conversado desc, can_llamadas desc
	    loop 
	     return next v_va_return; 
	     end loop; 
	    return; 

	else
	     for v_va_return in 
			SELECT
			    v_id_area as id,
			    (select nombre from asterisk.empresa_area where id_empare =  v_id_area) as area,
			    sum(1) as can_llamadas,
			    (sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
			    ((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
			    (min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
			    (max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
			FROM asterisk.cdr c
			WHERE id_area is not null AND
			id_area in (select id_empare from asterisk.empresa_area where id_padre = v_id_area) AND
			calldate::timestamp between v_fecha_inicio AND v_fecha_fin
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			AND c.lastapp <> 'ResetCDR'
			AND c.lastapp = 'Dial'
			GROUP BY 1, 2
			ORDER BY tiempo_conversado desc, can_llamadas desc
	    loop 
		return next v_va_return; 
	    end loop; 
	    return;

	end if;
END;
$$;


ALTER FUNCTION reportes.area_llamada_top(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 381 (class 1255 OID 70575)
-- Name: area_llamada_top_detalle(integer, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION area_llamada_top_detalle(p_id_area integer, p_fecha date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_detalle
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_detalle%rowtype;
 
 v_id_area integer := p_id_area; 
 v_fecha VARCHAR := p_fecha::varchar; -- Fecha inicio de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_ini timestamp := null;
 v_fecha_fin timestamp := null;

 BEGIN
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	
	select coalesce(v_fecha, current_date::varchar) into v_fecha;

	v_fecha_ini := (v_fecha || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fecha || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT  
			(select nombre from asterisk.empresa_area where id_empare = v_id_area) as area,
			calldate as fecha, 
			calldate::time as tiempo, 
			src as ani,
			dst as dni, 
			billsec::varchar::interval::time, 
			(case when disposition = 'ANSWERED' then 'Contestado'
			when disposition = 'NO ANSWER' then 'No Contestado'
			when disposition = 'FAILED' then 'Fallido'
			when disposition = 'BUSY' then 'Ocupado'
			end) as descripcion
		FROM asterisk.cdr c
		WHERE id_area IN (select id_empare from asterisk.empresa_area where id_padre = v_id_area)
		AND calldate between v_fecha_ini AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		ORDER BY 1,2,4
	loop 
		return next v_va_return; 
	end loop;
return; 
END;
$$;


ALTER FUNCTION reportes.area_llamada_top_detalle(p_id_area integer, p_fecha date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 383 (class 1255 OID 70576)
-- Name: area_llamada_top_dia(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION area_llamada_top_dia(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_dia
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_dia%rowtype;
 
 v_id_area integer := p_id_area;
 v_fe_ini varchar := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin varchar := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;


 BEGIN
	raise notice 'parameters: %, %, %, %, % ', v_id_area, p_fe_ini, p_fe_fin, p_horai, p_horaf;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;
	
	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT v_id_area as id,
			(select nombre from asterisk.empresa_area where id_empare = v_id_area) as area,
			calldate::date as dia,
			sum(1) as can_llamadas,
			sum(c.billsec)::varchar::interval::time as tiempo_conversado,
			(sum(c.billsec)/sum(1))::varchar::interval::time as t_promedio,
			min(c.billsec)::varchar::interval::time as t_minconver,
			max(c.billsec)::varchar::interval::time as t_maxconver
		FROM asterisk.cdr c
		WHERE id_area is not null AND
		id_area IN (select id_empare from asterisk.empresa_area where id_padre = v_id_area)
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY 1, 2, 3
		ORDER BY dia, can_llamadas DESC, tiempo_conversado
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.area_llamada_top_dia(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 472 (class 1255 OID 144788)
-- Name: area_llamada_top_report(integer, date, date, character varying, character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: postgres
--

CREATE FUNCTION area_llamada_top_report(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF area_llamada_top_reporte
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_reporte%rowtype; 
 v_va_conta reportes.area_llamada_top_reporte%rowtype; 
	v_id_area integer := p_id_area; 
	v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
	v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
	v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
	v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
	v_fecha_inicio timestamp := null;
	v_fecha_fin timestamp := null;

	v_total_reg integer := 0;
	v_limit integer := p_nu_mostrar;
	v_nu_pagina integer := p_nu_pagina;
	v_limit_descontar integer := 0; 
 BEGIN
	if v_nu_pagina <> 1 then
		v_limit_descontar = v_limit * (v_nu_pagina - 1);
	else 
		v_limit_descontar = 0;
	end if;
	
	raise notice 'parameters: %, %, %, %, % ', v_id_area, p_fe_ini, p_fe_fin, p_horai, p_horaf;
	v_horai := case when v_horai = '00:00:00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf = '00:00:00' then '23:59:59' else v_horaf end;

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

if v_id_area = 0 then

	for v_va_conta in 
		SELECT ea.id_padre as id,
		(select nombre from asterisk.empresa_area where id_empare = ea.id_padre) as area,
		sum(1) as can_llamadas,
		(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c, 
		asterisk.empresa_area ea 
		WHERE c.id_area = ea.id_empare
		and id_area is not null
		and calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY 1, 2
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop 
		v_total_reg = v_total_reg + 1;
		raise notice 'Cantidad: %', v_total_reg;
	end loop; 
	return;

	for v_va_return in 
		SELECT ea.id_padre as id,
		(select nombre from asterisk.empresa_area where id_empare = ea.id_padre) as area,
		sum(1) as can_llamadas,
		(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver,
		v_total_reg
		FROM asterisk.cdr c, 
		asterisk.empresa_area ea 
		WHERE c.id_area = ea.id_empare
		and id_area is not null
		and calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		and ea.id_padre not in (
			SELECT ea.id_padre
			FROM asterisk.cdr c, 
			asterisk.empresa_area ea 
			WHERE c.id_area = ea.id_empare
			and id_area is not null
			and calldate::timestamp between v_fecha_inicio AND v_fecha_fin
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			AND c.lastapp <> 'ResetCDR'			
			AND c.lastapp = 'Dial' 
			GROUP BY ea.id_padre, (select nombre from asterisk.empresa_area where id_empare = ea.id_padre)
			ORDER BY ((sum(c.billsec)::varchar::interval::time)::varchar) desc
			limit v_limit_descontar)
		GROUP BY 1, 2
		ORDER BY tiempo_conversado desc, can_llamadas desc
		limit v_limit
	loop 
	return next v_va_return; 
	end loop; 
	return;
else
	for v_va_conta in 
		SELECT
		v_id_area as id,
		(select nombre from asterisk.empresa_area where id_empare =  v_id_area) as area,
		sum(1) as can_llamadas,
		(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c
		WHERE id_area is not null AND
		id_area in (select id_empare from asterisk.empresa_area where id_padre = v_id_area) AND
		calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY 1, 2
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop 
		v_total_reg = v_total_reg + 1;
		raise notice 'Cantidad: %', v_total_reg; 
	end loop; 
	return;
	
	for v_va_return in 
		SELECT
		v_id_area as id,
		(select nombre from asterisk.empresa_area where id_empare =  v_id_area) as area,
		sum(1) as can_llamadas,
		(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver,
		v_total_reg
		FROM asterisk.cdr c
		WHERE id_area is not null AND
		id_area in (select id_empare from asterisk.empresa_area where id_padre = v_id_area) AND
		calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		and id_area not in (
			SELECT
			(select id_empare from asterisk.empresa_area where id_padre = v_id_area)
			FROM asterisk.cdr c
			WHERE id_area is not null AND
			id_area in (select id_empare from asterisk.empresa_area where id_padre = v_id_area) AND
			calldate::timestamp between v_fecha_inicio AND v_fecha_fin
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			AND c.lastapp <> 'ResetCDR'
			AND c.lastapp = 'Dial' 
			GROUP BY v_id_area
			ORDER BY ((sum(c.billsec)::varchar::interval::time)::varchar) desc
			limit v_limit_descontar)
		GROUP BY 1, 2
		ORDER BY tiempo_conversado desc, can_llamadas desc
		limit v_limit
	loop 
	return next v_va_return; 
	end loop; 
	return;
end if;
END;
$$;


ALTER FUNCTION reportes.area_llamada_top_report(p_id_area integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) OWNER TO postgres;

--
-- TOC entry 384 (class 1255 OID 70577)
-- Name: cantidad_llamadas(date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION cantidad_llamadas(p_fecha date) RETURNS SETOF cantidad_llamadas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_fecha date := p_fecha;
 v_va_return reportes.cantidad_llamadas%rowtype;
BEGIN
 for v_va_return in
  select  
  count(event) as cantidad
  from asterisk.callcenter
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')  
  AND "time"::date = v_fecha::date
 
 loop
  return next v_va_return;
 end loop;
 
 return;
END;
$$;


ALTER FUNCTION reportes.cantidad_llamadas(p_fecha date) OWNER TO tintegro;

--
-- TOC entry 435 (class 1255 OID 70578)
-- Name: cantidad_llamadas(character varying, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION cantidad_llamadas(p_queuename character varying, p_fecha date) RETURNS SETOF cantidad_llamadas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_fecha date := p_fecha;
 v_queuename varchar:=p_queuename;
 v_va_return reportes.cantidad_llamadas%rowtype;
BEGIN
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;
 for v_va_return in
  select  
  count(event) as cantidad
  from asterisk.callcenter
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')  
  AND queuename like v_queuename
  AND "time"::date = v_fecha::date
 
 loop
  return next v_va_return;
 end loop;
 
 return;
END;
$$;


ALTER FUNCTION reportes.cantidad_llamadas(p_queuename character varying, p_fecha date) OWNER TO tintegro;

--
-- TOC entry 477 (class 1255 OID 144687)
-- Name: cencosto_llamada_top(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION cencosto_llamada_top(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_new
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_new%rowtype;
 
 v_id_cencos varchar := p_id_cencos::varchar; 
 v_fe_ini varchar := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin varchar := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;
 
 BEGIN
	v_id_cencos := case when v_id_cencos = '0' then '%' else v_id_cencos end;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT id_area, 
			(select nombre from asterisk.empresa_area where id_empare = id_area) as area,
			sum(1) as can_llamadas,
			(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
			((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
			(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
			(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c
		WHERE id_area::varchar like v_id_cencos
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY id_area
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop 
		return next v_va_return; 
	end loop; 
	return; 
END;
$$;


ALTER FUNCTION reportes.cencosto_llamada_top(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 385 (class 1255 OID 70580)
-- Name: cencosto_llamada_top_detalle(integer, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION cencosto_llamada_top_detalle(p_id_area integer, p_fecha date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_detalle
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_detalle%rowtype;
 
 v_id_area integer := p_id_area; 
 v_fecha varchar := p_fecha::varchar; -- Fecha inicio de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_ini timestamp := null;
 v_fecha_fin timestamp := null;

 BEGIN
 
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	
	select coalesce(v_fecha, current_date::varchar) into v_fecha;

	v_fecha_ini := (v_fecha || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fecha || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT 
		   (select nombre from asterisk.empresa_area where id_empare = id_area) as area,
		   calldate as fecha, 
		   calldate::time as tiempo, 
		   src as ani,
		   dst as dni, 
		   billsec::varchar::interval::time, 
		   (case when disposition = 'ANSWERED' then 'Contestado'
		    when disposition = 'NO ANSWER' then 'No Contestado'
		    when disposition = 'FAILED' then 'Fallido'
		    when disposition = 'BUSY' then 'Ocupado'
		    end) as descripcion
		FROM asterisk.cdr c
		WHERE id_area = v_id_area
		AND calldate between v_fecha_ini AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		ORDER BY 1,2,4
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.cencosto_llamada_top_detalle(p_id_area integer, p_fecha date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 454 (class 1255 OID 70581)
-- Name: cencosto_llamada_top_dia(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION cencosto_llamada_top_dia(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF area_llamada_top_dia
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_dia%rowtype;
 
 v_id_cencos integer := p_id_cencos;
 v_fe_ini DATE := p_fe_ini; -- Fecha inicio de reporte
 v_fe_fin DATE := p_fe_fin; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;


 BEGIN

	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	
	select coalesce(v_fe_ini, current_date) into v_fe_ini;
	select coalesce(v_fe_fin, current_date) into v_fe_fin;
	
	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT id_area, 
			(select nombre from asterisk.empresa_area where id_empare = id_area) as area,
			calldate::date as dia,
			sum(1) as can_llamadas,
			sum(c.billsec)::varchar::interval::time as tiempo_conversado,
			(sum(c.billsec)/sum(1))::varchar::interval::time as t_promedio,
			min(c.billsec)::varchar::interval::time as t_minconver,
			max(c.billsec)::varchar::interval::time as t_maxconver
		FROM asterisk.cdr c
		WHERE id_area = v_id_cencos
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		GROUP BY 1, 2, calldate::date
		ORDER BY id_area, calldate::date, can_llamadas DESC, tiempo_conversado
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.cencosto_llamada_top_dia(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 471 (class 1255 OID 144787)
-- Name: cencosto_llamada_top_report(integer, date, date, character varying, character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: postgres
--

CREATE FUNCTION cencosto_llamada_top_report(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF area_llamada_top_report
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.area_llamada_top_report%rowtype;
 v_va_conta reportes.area_llamada_top_report%rowtype;
 
	v_id_cencos varchar := p_id_cencos::varchar; 
	v_fe_ini varchar := p_fe_ini::varchar; -- Fecha inicio de reporte
	v_fe_fin varchar := p_fe_fin::varchar; -- Fecha fin de reporte
	v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
	v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
	v_fecha_inicio timestamp := null;
	v_fecha_fin timestamp := null;

	v_total_reg integer := 0;
	v_limit integer := p_nu_mostrar;
	v_nu_pagina integer := p_nu_pagina;
	v_limit_descontar integer := 0;
 
 BEGIN

	if v_nu_pagina <> 1 then
		v_limit_descontar = v_limit * (v_nu_pagina - 1);
	else 
		v_limit_descontar = 0;
	end if;
	
	v_id_cencos := case when v_id_cencos = '0' then '%' else v_id_cencos end;
	v_horai := case when v_horai = '00:00:00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null or v_horaf = '00:00:00' then '23:59:59' else v_horaf end;

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_conta in 
		SELECT id_area, 
			(select nombre from asterisk.empresa_area where id_empare = id_area) as area,
			sum(1) as can_llamadas,
			(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
			((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
			(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
			(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c
		WHERE id_area::varchar like v_id_cencos
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'		
		GROUP BY id_area
		ORDER BY tiempo_conversado desc, can_llamadas desc	
	loop
		v_total_reg = v_total_reg + 1;
		raise notice 'Cantidad: %', v_total_reg;
	end loop; 
	

	for v_va_return in 
		SELECT id_area, 
			(select nombre from asterisk.empresa_area where id_empare = id_area) as area,
			sum(1) as can_llamadas,
			(sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
			((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
			(min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
			(max(c.billsec)::varchar::interval::time)::varchar as t_maxconver,
			v_total_reg
		FROM asterisk.cdr c
		WHERE id_area::varchar like v_id_cencos
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		AND c.lastapp <> 'ResetCDR'
		AND c.lastapp = 'Dial'
		and id_area not in (
			SELECT id_area
			FROM asterisk.cdr c
			WHERE id_area::varchar like v_id_cencos
			AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			AND c.lastapp <> 'ResetCDR'
			AND c.lastapp = 'Dial'
			GROUP BY id_area
			ORDER BY ((sum(c.billsec)::varchar::interval::time)::varchar) desc limit v_limit_descontar)
		GROUP BY id_area
		ORDER BY tiempo_conversado desc, can_llamadas desc
		limit v_limit
		
	loop 
		return next v_va_return; 		
	end loop; 
	return; 
END;
$$;


ALTER FUNCTION reportes.cencosto_llamada_top_report(p_id_cencos integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) OWNER TO postgres;

--
-- TOC entry 455 (class 1255 OID 70582)
-- Name: consolidado_llamadas_recibidas(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION consolidado_llamadas_recibidas(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF consolidado_llamadas_recibidas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.consolidado_llamadas_recibidas%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select  
  queuename,
  extract(month from  "time")::varchar as mes,
  extract(day from  "time")::varchar as dia,
  case when EXTRACT(DOW FROM "time") = 1 then 'Lunes'
  when EXTRACT(DOW FROM "time") = 2 then 'Martes'
  when EXTRACT(DOW FROM "time") = 3 then 'Miercoles'
  when EXTRACT(DOW FROM "time") = 4 then 'Jueves'
  when EXTRACT(DOW FROM "time") = 5 then 'Viernes'
  when EXTRACT(DOW FROM "time") = 6 then 'Sabado'
  else 'Domingo' end as dia_semana,
  count(event) as cantidad
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'RINGNOANSWER') 
  AND queuename like v_queuename
  AND "time" between v_feini AND v_fefin  
  group by queuename, extract(month from  "time"),
  extract(day from  "time"),
  EXTRACT(DOW FROM "time")
  order by 3, 4
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.consolidado_llamadas_recibidas(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 387 (class 1255 OID 70583)
-- Name: consolidado_llamadas_recibidas(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION consolidado_llamadas_recibidas(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF consolidado_llamadas_recibidas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.consolidado_llamadas_recibidas%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select       
  queuename,
  extract(month from  "time")::varchar as mes,
  extract(day from  "time")::varchar as dia,
  case when EXTRACT(DOW FROM "time") = 1 then 'Lunes'
  when EXTRACT(DOW FROM "time") = 2 then 'Martes'
  when EXTRACT(DOW FROM "time") = 3 then 'Miercoles'
  when EXTRACT(DOW FROM "time") = 4 then 'Jueves'
  when EXTRACT(DOW FROM "time") = 5 then 'Viernes'
  when EXTRACT(DOW FROM "time") = 6 then 'Sabado'
  else 'Domingo' end as dia_semana,
  count(event) as cantidad
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'RINGNOANSWER') 
  AND queuename like v_queuename
  AND extract(month from  "time")::integer = v_nu_mes
  AND EXTRACT(year FROM "time")::integer = v_nu_ano 
  group by queuename, extract(month from  "time"),
  extract(day from  "time"),
  EXTRACT(DOW FROM "time"),
         EXTRACT(year FROM "time")
  order by 3, 4
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.consolidado_llamadas_recibidas(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 388 (class 1255 OID 70584)
-- Name: consolidado_llamadas_recibidas_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION consolidado_llamadas_recibidas_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF consolidado_llamadas_recibidas_rango
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.consolidado_llamadas_recibidas_rango%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select  
   row_number() OVER (order by queuename, extract(year from "time") , extract(month from  "time") , extract(day from  "time")) AS id,
  queuename,  
  extract(year from "time")::varchar as anio,
  extract(month from  "time")::varchar as mes,
  extract(day from  "time")::varchar as dia,
  case when EXTRACT(DOW FROM "time") = 1 then 'Lunes'
  when EXTRACT(DOW FROM "time") = 2 then 'Martes'
  when EXTRACT(DOW FROM "time") = 3 then 'Miercoles'
  when EXTRACT(DOW FROM "time") = 4 then 'Jueves'
  when EXTRACT(DOW FROM "time") = 5 then 'Viernes'
  when EXTRACT(DOW FROM "time") = 6 then 'Sabado'
  else 'Domingo' end as dia_semana,
  count(event) as cantidad
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON') 
  AND queuename like v_queuename
  AND "time"::date between v_feini::date AND v_fefin::date  
  group by queuename, 
  extract(year from "time"),
  extract(month from  "time"),
  extract(day from  "time"),
  EXTRACT(DOW FROM "time")
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.consolidado_llamadas_recibidas_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 391 (class 1255 OID 70585)
-- Name: dia_local(date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION dia_local(p_fecha date) RETURNS SETOF dia_local
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_fecha date:= p_fecha;
 v_va_return reportes.dia_local%rowtype;
BEGIN

 for v_va_return in 

  SELECT EXTRACT(DOW FROM v_fecha )::integer
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.dia_local(p_fecha date) OWNER TO tintegro;

--
-- TOC entry 389 (class 1255 OID 70586)
-- Name: estado_agente(integer, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION estado_agente(p_id_agente integer, p_fe_inicon date, p_fe_fincon date) RETURNS SETOF estado_agente
    LANGUAGE plpgsql
    AS $$
DECLARE
v_va_return reportes.estado_agente%rowtype;
v_no_agente VARCHAR:=p_id_agente::varchar; -- Nombre del Agente
v_fe_inicon date:=p_fe_inicon; -- Fecha inicio de reporte
v_fe_fincon date:=p_fe_fincon; -- Fecha fin de reporte

BEGIN
 v_no_agente := v_no_agente;
 v_fe_inicon := case when v_fe_inicon is null then current_date else v_fe_inicon end;
 v_fe_fincon := case when v_fe_fincon is null then current_date else v_fe_fincon end;

	for v_va_return in 

		SELECT 
		     row_number() OVER (ORDER BY ea.fe_iniest , ea.ho_iniest ) AS id_estado,	
		     ee.no_estage,
		     ea.fe_iniest,
		     ea.ho_iniest,
		     ea.fe_finest,
		     ea.ho_finest,
		     ea.ti_estmin,
		     ea.ti_estseg 
		FROM reportes.tb_estado_agente ea inner join
		 asterisk.tc_estado ee on ea.co_estado = ee.id_estage
		WHERE ea.co_agente = v_no_agente
		AND ea.fe_iniest::date between v_fe_inicon AND v_fe_fincon

	loop 
		return next v_va_return; 
	end loop; 
 
	return;
END;
$$;


ALTER FUNCTION reportes.estado_agente(p_id_agente integer, p_fe_inicon date, p_fe_fincon date) OWNER TO tintegro;

--
-- TOC entry 390 (class 1255 OID 70587)
-- Name: formato_tiempo(double precision); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION formato_tiempo(double precision) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$
declare
    total_segundos alias for $1;
    hora_dec float;
    hora int;
    minutos_dec float;
    minutos int;
    segundos_dec float;
    segundos int;
    cero_horas varchar;
    cero_minutos varchar;
    cero_segundos varchar;
    string_hour varchar;
begin
    hora_dec := round(cast(total_segundos/3600.00 as numeric), 5);
    hora := floor(hora_dec);
    hora_dec := hora_dec - hora;

    if length(cast(hora as varchar)) = 1 then
        cero_horas := '0';
    else
        cero_horas := '';
    end if;

    minutos_dec := round(cast(hora_dec * 60.00 as numeric),5);
    minutos := floor(minutos_dec);
    minutos_dec := minutos_dec - minutos;

    if length(cast(minutos as varchar)) = 1 then
        cero_minutos := '0';
    else
        cero_minutos := '';
    end if;
   
    segundos_dec := minutos_dec * 60.00;
    segundos := round(cast(segundos_dec as numeric));

    if length(cast(segundos as varchar)) = 1 then
        cero_segundos := '0';
    else
        cero_segundos := '';
    end if;

   
    select into string_hour cero_horas || cast(hora as varchar) || ':' 
|| cero_minutos || cast(minutos as varchar) || ':' || cero_segundos || 
cast(segundos as varchar);


    return string_hour;
end;
$_$;


ALTER FUNCTION reportes.formato_tiempo(double precision) OWNER TO tintegro;

--
-- TOC entry 456 (class 1255 OID 70588)
-- Name: llamada_abandonas_minutos(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_abandonas_minutos(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llamada_abandonas_minutos
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_nu_mes integer := p_nu_mes;
    v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llamada_abandonas_minutos%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select
         sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end)::integer as nu_llam, 
  sum(case when event = 'ABANDON' and data3::integer <61 then 1 else 0 end)::integer as aba_menor, 
  sum(case when event = 'ABANDON' and data3::integer >60 then 1 else 0 end)::integer as aba_mayor 
  from asterisk.callcenter 
  where event in ('ABANDON', 'COMPLETECALLER', 'COMPLETEAGENT')
  AND queuename like v_queuename
  and extract(month from  "time")::integer = v_nu_mes
  and extract(year from  "time")::integer = v_nu_ano
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamada_abandonas_minutos(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 392 (class 1255 OID 70589)
-- Name: llamada_abandonas_minutos_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_abandonas_minutos_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llamada_abandonas_minutos
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamada_abandonas_minutos%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select
         sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end)::integer as nu_llam, 
  sum(case when event = 'ABANDON' and data3::integer <61 then 1 else 0 end)::integer as aba_menor, 
  sum(case when event = 'ABANDON' and data3::integer >60 then 1 else 0 end)::integer as aba_mayor 
  from asterisk.callcenter 
  where event in ('ABANDON', 'COMPLETECALLER', 'COMPLETEAGENT')
  AND queuename like v_queuename
   and "time"::date between v_feini::date and v_fefin::date
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamada_abandonas_minutos_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 393 (class 1255 OID 70590)
-- Name: llamada_abandonas_minutos_rango_fecha(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_abandonas_minutos_rango_fecha(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llamada_abandonas_minutos_fecha
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamada_abandonas_minutos_fecha%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

    select 
    row_number() OVER (ORDER BY "time"::date ) AS id_llamada,
    "time"::date,
    sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end)::integer as nu_llam, 
    sum(case when event = 'ABANDON' and data3::integer <61 then 1 else 0 end)::integer as aba_menor, 
    sum(case when event = 'ABANDON' and data3::integer >60 then 1 else 0 end)::integer as aba_mayor 
    from asterisk.callcenter 
    where event in ('ABANDON', 'COMPLETECALLER', 'COMPLETEAGENT')
    AND queuename like v_queuename
    and "time"::date between v_feini::date and v_fefin::date
    group by "time"::date
    order by 1 
 
  
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamada_abandonas_minutos_rango_fecha(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 394 (class 1255 OID 70591)
-- Name: llamada_agente(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_agente(p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_agente
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_agente%rowtype;
 v_no_agente varchar:=p_id_agente::varchar; --Id del agente
 v_fe_inicon varchar:=p_fe_inicon::varchar; -- Fecha de inicio de reporte
 v_fe_fincon varchar:=p_fe_fincon::varchar; -- Fecha de fin de reporte
 v_ho_inicon varchar:=p_horai; -- Hora de inicio de reporte
 v_ho_fincon varchar:=p_horaf; -- Hora de fin de reporte

 v_fe_inicio timestamp := null;
 v_fe_final timestamp := null;
 
 BEGIN 

	v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
	v_ho_inicon := case when v_ho_inicon = '00' then '00:00:00' else v_ho_inicon end;
	v_ho_fincon := case when v_ho_fincon is null then '23:59:59' else v_ho_fincon end;
	 
	v_fe_inicio := (v_fe_inicon || ' ' || v_ho_inicon)::timestamp;
	v_fe_final := (v_fe_fincon || ' ' || v_ho_fincon)::timestamp;

	if v_no_agente not in ('0','%') then
		select nu_agente into v_no_agente 
		from asterisk.agente 
		where id_agente = v_no_agente::integer;
	end if;

	for v_va_return in 

		SELECT v_fe_inicon ||'/'|| v_fe_fincon, 
			t.id_agente,
			no_apepat || ' ' || no_nombre as agente,
			sum(nu_llam) as nu_llam, 
			sum(nu_llamculcli) as nu_cli, 
			sum(nu_llamculage) as nu_age, 
			sum(ti_hablado)::varchar::interval::time as t_habla,
			(sum(ti_hablado)/sum(nu_llam))::varchar::interval::time as t_prom, 
			min(ti_minhab)::varchar::interval::time as t_min, 
			max(ti_maxhab)::varchar::interval::time as t_max 
		FROM 
		(
			select
				data5::integer as id_agente, 
				agent as agente, 
				sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end) as nu_llam, 
				sum(case when event = 'COMPLETECALLER' then 1 else 0 end) as nu_llamculcli, 
				sum(case when event = 'COMPLETEAGENT' then 1 else 0 end) as nu_llamculage, 
				sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then data2::INTEGER else 0 end) as ti_hablado, 
				min(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_minhab, 
				max(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_maxhab 
			from asterisk.callcenter 
			where event in ('COMPLETECALLER', 'COMPLETEAGENT') 
			and (time + interval '1 day') between v_fe_inicio AND v_fe_final
			and data5 like v_no_agente
			group by agent, time, data5
			order by time
		) t,
		asterisk.agente 
		where nu_agente = t.id_agente
		GROUP BY agente, t.id_agente, no_apepat, no_nombre
 
	loop 
		return next v_va_return; 
	end loop; 
 

	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_agente(p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 458 (class 1255 OID 70592)
-- Name: llamada_agente_detalle(character varying, integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_agente_detalle(p_ti_report character varying, p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_agente
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_agente%rowtype;
 v_ti_report varchar := p_ti_report; -- Tipo de reporte DIA, HORA
 v_no_agente varchar := p_id_agente; -- Nombre del Agente
 v_fe_inicon varchar := p_fe_inicon::varchar; -- Fecha de inicio de reporte
 v_fe_fincon varchar := p_fe_fincon::varchar; -- Fecha de fin de reporte
 v_ho_inicon varchar := p_horai; -- Hora de inicio de reporte
 v_ho_fincon varchar := p_horaf; -- Hora de fin de reporte
 v_fe_inicio timestamp := null; -- primera fecha del sistema
 v_fe_final timestamp := null; -- Ultima fecha de la tabla
 
 BEGIN 
 
	 v_ti_report := upper(v_ti_report);
	 v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
	 v_ho_inicon := case when v_ho_inicon = '00' then '00:00:00' else v_ho_inicon end;
	 v_ho_fincon := case when v_ho_fincon is null then '23:59:59' else v_ho_fincon end;
	 
	v_fe_inicio := (v_fe_inicon || ' ' || v_ho_inicon)::timestamp;
	v_fe_final := (v_fe_fincon || ' ' || v_ho_fincon)::timestamp;

	/*if v_no_agente not in ('0','%') then
		select nu_agente into v_no_agente 
		from asterisk.agente 
		where id_agente = v_no_agente::integer;
	end if;*/

	
	--raise exception 'v_ti_report %, %, %, %, %, %', p_ti_report , p_id_agente, p_fe_inicon, p_fe_fincon, v_ho_inicon , p_horaf;
	
	raise notice 'v_ti_report %', v_ti_report;
	raise notice 'v_ti_report %', v_ti_report;
	raise notice 'v_ti_report %', v_ti_report;
		
	if (v_ti_report = 'DIA') then
	  raise notice 'entra en dia';
		for v_va_return in 
        
			SELECT 
				dia,
				id_agente,
				(select no_apepat || ' ' || no_nombre from asterisk.agente where nu_agente::varchar = t.id_agente) as agente, 
				sum(nu_llam) as nu_llam, 
				sum(nu_llamculcli) as nu_cli, 
				sum(nu_llamculage) as nu_age, 
				sum(ti_hablado)::varchar::interval::time as t_habla,
				(sum(ti_hablado)/sum(nu_llam))::varchar::interval::time as t_prom, 
				min(ti_minhab)::varchar::interval::time as t_min, 
				max(ti_maxhab)::varchar::interval::time as t_max 
			FROM 
			(
				select substr(time::varchar,1,10) as dia,
					data5 as id_agente,
					split_part(agent, '/',1) as agente,					
					sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end) as nu_llam, 
					sum(case when event = 'COMPLETECALLER' then 1 else 0 end) as nu_llamculcli, 
					sum(case when event = 'COMPLETEAGENT' then 1 else 0 end) as nu_llamculage, 
					sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then data2::INTEGER else 0 end) as ti_hablado, 
					min(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_minhab, 
					max(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_maxhab 
				from asterisk.callcenter 
				where event in ('CONNECT', 'COMPLETECALLER', 'COMPLETEAGENT') 
				and (time) between v_fe_inicio AND v_fe_final
				and data5 like v_no_agente
				group by agent, substr(time::varchar,1,10)  , data5
				order by substr(time::varchar,1,10)
			) t group by dia, agente, id_agente
			ORDER BY dia
     
		loop 
			return next v_va_return; 
		end loop; 
   
  
	elsif(v_ti_report = 'HORA') then

	  
		for v_va_return in          
			SELECT hora, 
				id_agente,
				agente,
				sum(nu_llam) as nu_llam, 
				sum(nu_llamculcli) as nu_cli, 
				sum(nu_llamculage) as nu_age, 
				sum(ti_hablado)::varchar::interval::time  as t_habla, 
				(sum(ti_hablado)/sum(nu_llam))::varchar::interval::time as t_prom, 
				min(ti_minhab)::varchar::interval::time as t_min, 
				max(ti_maxhab)::varchar::interval::time as t_max 
			FROM 
			  (
				select substr(time::varchar,12,2) as hora,
					data5 as id_agente,
					split_part(agent, '/',1) as agente, 
					sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then 1 else 0 end) as nu_llam, 
					sum(case when event = 'COMPLETECALLER' then 1 else 0 end) as nu_llamculcli, 
					sum(case when event = 'COMPLETEAGENT' then 1 else 0 end) as nu_llamculage, 
					sum(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') then data2::INTEGER else 0 end) as ti_hablado, 
					min(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_minhab, 
					max(case when event in ('COMPLETECALLER', 'COMPLETEAGENT') and data2::INTEGER > 0 then data2::INTEGER else 1 end) as ti_maxhab 
				from asterisk.callcenter 
				where event in ('CONNECT', 'COMPLETECALLER', 'COMPLETEAGENT') 
				and (time) between v_fe_inicio AND v_fe_final
				and data5 like v_no_agente
				group by agent, substr(time::varchar,12,2) , data5
				order by substr(time::varchar,12,2)
			  ) t 
			GROUP BY hora, agente, id_agente
			ORDER BY hora::integer  
		loop 
			return next v_va_return; 
		end loop; 
	end if;

return; 
END;
$$;


ALTER FUNCTION reportes.llamada_agente_detalle(p_ti_report character varying, p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 395 (class 1255 OID 70593)
-- Name: llamada_consolidado_new(date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_consolidado_new(p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_consolidado3
    LANGUAGE plpgsql
    AS $$ DECLARE  v_va_return reportes.llamada_consolidado3%rowtype; v_fe_inicon varchar:=p_fe_inicon::varchar; 
-- Fecha de inicio de reporte 
v_fe_fincon varchar:=p_fe_fincon::varchar; 
-- Fecha de fin de reporte 
v_ho_inicon varchar:=p_horai; 
-- Hora de inicio de reporte 
v_ho_fincon varchar:=p_horaf; 
-- Hora de fin de reporte  
v_fe_inicio timestamp := null; 
v_fe_final timestamp := null;  
BEGIN   
v_ho_inicon := case when v_ho_inicon = '00' then '00:00:00' else v_ho_inicon end; 
v_ho_fincon := case when v_ho_fincon is null then '23:59:59' else v_ho_fincon end;  
v_fe_inicio := (v_fe_inicon || ' ' || v_ho_inicon)::timestamp; v_fe_final := (v_fe_fincon || ' ' || v_ho_fincon)::timestamp;   

for v_va_return in  

select anexo, 
e_contestada, 
e_nocontestada, 
e_fallida, 
total_entrante, 
total_inhablando, 
total_inhablando::varchar::interval::time::varchar as total_inhablando, 
s_contestada, 
s_nocontestada, 
s_fallida, 
total_saliente, 
total_outhablando, 
total_outhablando::varchar::interval::time::varchar as total_outhablando from ( select anexo, sum(case when tipo = 1 then 1 else 0 end) as total_entrante, 
sum(case when tipo = 1 and disposition = 'ANSWERED' then 1 else 0 end) as e_contestada, 
sum(case when tipo = 1 and disposition in ('NO ANSWER', 'BUSY') then 1 else 0 end) as e_nocontestada, 
sum(case when tipo = 1 and disposition = 'FAILED' then 1 else 0 end) as e_fallida, 
sum(case when tipo = 1 then billsec else 0 end) as total_inhablando, 
sum(case when tipo = 2 then 1 else 0 end) as total_saliente, 
sum(case when tipo = 2 and disposition = 'ANSWERED' then 1 else 0 end) as s_contestada, 
sum(case when tipo = 2 and disposition in ('NO ANSWER', 'BUSY') then 1 else 0 end) as s_nocontestada, 
sum(case when tipo = 2 and disposition = 'FAILED' then 1 else 0 end) as s_fallida, 
sum(case when tipo = 2 then billsec else 0 end) as total_outhablando 
from ( select 1 as tipo, dst as anexo, calldate, clid, billsec, disposition 
from asterisk.cdr 
where calldate between v_fe_inicio and v_fe_final 
and dcontext = 'call-to-agent' 
and dst <> 'ess_cusco'
and length(dst) < 5 and length(clid) > 5 
union
select 2 as tipo, src as anexo, calldate, dst, billsec, disposition 
from asterisk.cdr 
where calldate between v_fe_inicio and v_fe_final 
and dcontext <> 'call-to-agent' 
and dst <> 'ess_cusco'
and length(src) < 5 and length(dst) > 5
and substr(dst,1,1) not in ('*', 's')) as t 
where anexo <> '' 
group by anexo) as q 
order by 1, 2 desc  

loop  
return next v_va_return;  
end loop;    
return;  
END; 
$$;


ALTER FUNCTION reportes.llamada_consolidado_new(p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 398 (class 1255 OID 70594)
-- Name: llamada_contestada(character varying, integer, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_contestada(p_va_queue character varying, p_id_agent integer, p_fe_ini date, p_fe_fin date) RETURNS SETOF llamada_contestada
    LANGUAGE plpgsql
    AS $$
DECLARE
v_va_return reportes.llamada_contestada%rowtype;
v_fe_ini date:=p_fe_ini; --Nombre de la cola
v_fe_fin date:=p_fe_fin; --Nombre del agente
v_va_queue VARCHAR:=p_va_queue; --Nombre de la cola
v_va_agent VARCHAR:=p_id_agent::varchar; --Nombre del agente
v_va_where VARCHAR:=NULL; --Where
BEGIN
v_va_queue := case when v_va_queue = '' or v_va_queue is null then '%' else v_va_queue end;
v_va_agent := case when v_va_agent = '0' or v_va_agent is null then '%' else v_va_agent end;

raise notice 'entro v_va_queue % v_va_agent %',v_fe_ini ,v_fe_fin ;

if v_va_agent not in ('0','%') then
	select nu_agente into v_va_agent 
from asterisk.agente 
	where id_agente = v_va_agent::integer;
end if;

for v_va_return in 
    select
    distinct tt.callid as id_lla,
    ss.qdate as fe_ini, 
    ss.qtime as ho_ini,
    pp.qdate as fe_fin, 
    pp.qtime as ho_fin, 
    tt.data2 as nu_ani,
    pp.data2 as ti_dur,
    pp.data5 as no_age,
    tt.queuename as no_col 	
    from
    ( 
       select distinct callid, substr(time::varchar,1,10) as qdate, data2, queuename
       from asterisk.callcenter c 
       where  time BETWEEN v_fe_ini::date and v_fe_fin::date + interval '1 day'
       and event = 'ENTERQUEUE'
    ) as tt,
    ( 
      select distinct callid, substr(time::varchar,1,10) as qdate, substr(time::varchar,12,8) as qtime
      from asterisk.callcenter c 
      where  time BETWEEN  v_fe_ini::date and v_fe_fin::date + interval '1 day'
      and event = 'CONNECT' 
    ) as ss,
    (
      select distinct callid, substr(time::varchar,1,10) as qdate, substr(time::varchar,12,8) as qtime, data2, data5
      from asterisk.callcenter c 
      where  
      time BETWEEN v_fe_ini::date and v_fe_fin::date + interval '1 day'
      and (event = 'COMPLETECALLER' or event = 'COMPLETEAGENT')  
      and data2 not in ('1','2')
    ) as pp
    where tt.callid = ss.callid
   -- and tt.uniqueid = pp.uniqueid
    and ss.callid = pp.callid
    and tt.qdate = ss.qdate
    --and tt.qdate = pp.qdate
    and ss.qdate = pp.qdate
    and pp.data5 LIKE v_va_agent 
    and queuename LIKE v_va_queue
    --group by tt.uniqueid, ss.qdate, ss.qtime, pp.qdate, pp.qtime, tt.info2, pp.info2, pp.agent, tt.qname
    order by 2,3

 
 loop 
 return next v_va_return; 
 end loop; 
 return;
END;
$$;


ALTER FUNCTION reportes.llamada_contestada(p_va_queue character varying, p_id_agent integer, p_fe_ini date, p_fe_fin date) OWNER TO tintegro;

--
-- TOC entry 399 (class 1255 OID 70595)
-- Name: llamada_contestada_ac(character varying, integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_contestada_ac(p_va_queue character varying, p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_contestada_ac
    LANGUAGE plpgsql
    AS $$
DECLARE
v_va_return reportes.llamada_contestada_ac%rowtype;
v_va_queue VARCHAR:=p_va_queue; --Nombre de la cola
v_no_agente varchar := p_id_agente; -- Nombre del Agente
v_fe_inicon varchar := p_fe_inicon::varchar; -- Fecha de inicio de reporte
v_fe_fincon varchar := p_fe_fincon::varchar; -- Fecha de fin de reporte
v_ho_inicon varchar := p_horai; -- Hora de inicio de reporte
v_ho_fincon varchar := p_horaf; -- Hora de fin de reporte
v_fe_inicio timestamp := null; -- primera fecha del sistema
v_fe_final timestamp := null; -- Ultima fecha de la tabla 
BEGIN
v_va_queue := case when v_va_queue = '' or v_va_queue is null then '%' else v_va_queue end;
v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
v_ho_inicon := case when v_ho_inicon = '00' then '00:00:00' else v_ho_inicon end;
v_ho_fincon := case when v_ho_fincon is null then '23:59:59' else v_ho_fincon end;

v_fe_inicio := (v_fe_inicon || ' ' || v_ho_inicon);
v_fe_final := (v_fe_fincon || ' ' || v_ho_fincon);

for v_va_return in 

select 
row_number() OVER (order by "time"::date) AS id,
queuename , 
(ag.no_apepat  || ' ' ||  ag.no_apemat   || ' ' ||  ag.no_nombre) as agente,
time::date , 
substr(time::varchar,12,8) as qtime,
data2 ,data4
from 
asterisk.callcenter cc,
asterisk.agente ag
where nu_agente::varchar = data5
AND event in ('COMPLETEAGENT', 'COMPLETECALLER') 
AND queuename like v_va_queue
AND ag.id_agente::varchar like v_no_agente
AND "time" between v_fe_inicio AND v_fe_final

loop 
   return next v_va_return; 
end loop; 

return; 
END;
$$;


ALTER FUNCTION reportes.llamada_contestada_ac(p_va_queue character varying, p_id_agente integer, p_fe_inicon date, p_fe_fincon date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 459 (class 1255 OID 70596)
-- Name: llamada_dia_hora(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_dia_hora(p_no_cola character varying, p_fe_inicon date, p_fe_fincon date) RETURNS SETOF llamada_dia_hora
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_dia_hora%rowtype;
 v_no_cola varchar:=p_no_cola; -- Cola
 v_fe_inicon date:=p_fe_inicon; -- Fecha de inicio de reporte
 v_fe_fincon date:=p_fe_fincon; -- Fecha de fin de reporte
 BEGIN 
 
	v_no_cola := case when v_no_cola = '' or v_no_cola is null then '%' else v_no_cola end;
	v_fe_inicon := case when v_fe_inicon is null then current_date else v_fe_inicon end;
	v_fe_fincon := case when v_fe_fincon is null then current_date else v_fe_fincon end;

	raise notice 'fechas % %', v_fe_inicon, v_fe_fincon;
 
	for v_va_return in
	   select substr(cast(time as varchar(10)),1,10) as dia, 
		    sum(case when substr(time::varchar(14),12,2) = '00' then 1  else 0 end) as llama00, 
		    sum(case when substr(time::varchar(14),12,2) = '01' then 1  else 0 end) as llama01,
		    sum(case when substr(time::varchar(14),12,2) = '02' then 1  else 0 end) as llama02,
		    sum(case when substr(time::varchar(14),12,2) = '03' then 1  else 0 end) as llama03,
		    sum(case when substr(time::varchar(14),12,2) = '04' then 1  else 0 end) as llama04,
		    sum(case when substr(time::varchar(14),12,2) = '05' then 1  else 0 end) as llama05,
		    sum(case when substr(time::varchar(14),12,2) = '06' then 1  else 0 end) as llama06,
		    sum(case when substr(time::varchar(14),12,2) = '07' then 1  else 0 end) as llama07,
		    sum(case when substr(time::varchar(14),12,2) = '08' then 1  else 0 end) as llama08,
		    sum(case when substr(time::varchar(14),12,2) = '09' then 1  else 0 end) as llama09,
		    sum(case when substr(time::varchar(14),12,2) = '10' then 1  else 0 end) as llama10,
		    sum(case when substr(time::varchar(14),12,2) = '11' then 1  else 0 end) as llama11,
		    sum(case when substr(time::varchar(14),12,2) = '12' then 1  else 0 end) as llama12,
		    sum(case when substr(time::varchar(14),12,2) = '13' then 1  else 0 end) as llama13,
		    sum(case when substr(time::varchar(14),12,2) = '14' then 1  else 0 end) as llama14,
		    sum(case when substr(time::varchar(14),12,2) = '15' then 1  else 0 end) as llama15,
		    sum(case when substr(time::varchar(14),12,2) = '16' then 1  else 0 end) as llama16,
		    sum(case when substr(time::varchar(14),12,2) = '17' then 1  else 0 end) as llama17,
		    sum(case when substr(time::varchar(14),12,2) = '18' then 1  else 0 end) as llama18,
		    sum(case when substr(time::varchar(14),12,2) = '19' then 1  else 0 end) as llama19,
		    sum(case when substr(time::varchar(14),12,2) = '20' then 1  else 0 end) as llama20,
		    sum(case when substr(time::varchar(14),12,2) = '21' then 1  else 0 end) as llama21,
		    sum(case when substr(time::varchar(14),12,2) = '22' then 1  else 0 end) as llama22,
		    sum(case when substr(time::varchar(14),12,2) = '23' then 1  else 0 end) as llama23
	  from asterisk.callcenter
	  where time between v_fe_inicon AND v_fe_fincon + interval '1 day'
	  and queuename like v_no_cola
	  and event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
	  and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
	  group by substr(cast(time as varchar(10)),1,10)
	  union 
	  select 'TOTAL'::varchar as dia, 
		    sum(case when substr(time::varchar(14),12,2) = '00' then 1  else 0 end) as llama00, 
		    sum(case when substr(time::varchar(14),12,2) = '01' then 1  else 0 end) as llama01,
		    sum(case when substr(time::varchar(14),12,2) = '02' then 1  else 0 end) as llama02,
		    sum(case when substr(time::varchar(14),12,2) = '03' then 1  else 0 end) as llama03,
		    sum(case when substr(time::varchar(14),12,2) = '04' then 1  else 0 end) as llama04,
		    sum(case when substr(time::varchar(14),12,2) = '05' then 1  else 0 end) as llama05,
		    sum(case when substr(time::varchar(14),12,2) = '06' then 1  else 0 end) as llama06,
		    sum(case when substr(time::varchar(14),12,2) = '07' then 1  else 0 end) as llama07,
		    sum(case when substr(time::varchar(14),12,2) = '08' then 1  else 0 end) as llama08,
		    sum(case when substr(time::varchar(14),12,2) = '09' then 1  else 0 end) as llama09,
		    sum(case when substr(time::varchar(14),12,2) = '10' then 1  else 0 end) as llama10,
		    sum(case when substr(time::varchar(14),12,2) = '11' then 1  else 0 end) as llama11,
		    sum(case when substr(time::varchar(14),12,2) = '12' then 1  else 0 end) as llama12,
		    sum(case when substr(time::varchar(14),12,2) = '13' then 1  else 0 end) as llama13,
		    sum(case when substr(time::varchar(14),12,2) = '14' then 1  else 0 end) as llama14,
		    sum(case when substr(time::varchar(14),12,2) = '15' then 1  else 0 end) as llama15,
		    sum(case when substr(time::varchar(14),12,2) = '16' then 1  else 0 end) as llama16,
		    sum(case when substr(time::varchar(14),12,2) = '17' then 1  else 0 end) as llama17,
		    sum(case when substr(time::varchar(14),12,2) = '18' then 1  else 0 end) as llama18,
		    sum(case when substr(time::varchar(14),12,2) = '19' then 1  else 0 end) as llama19,
		    sum(case when substr(time::varchar(14),12,2) = '20' then 1  else 0 end) as llama20,
		    sum(case when substr(time::varchar(14),12,2) = '21' then 1  else 0 end) as llama21,
		    sum(case when substr(time::varchar(14),12,2) = '22' then 1  else 0 end) as llama22,
		    sum(case when substr(time::varchar(14),12,2) = '23' then 1  else 0 end) as llama23
	  from asterisk.callcenter
	  where time between v_fe_inicon AND v_fe_fincon + interval '1 day'
	  and queuename like v_no_cola
	  and event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
          and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
	loop 
		return next v_va_return; 
	end loop;

	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_dia_hora(p_no_cola character varying, p_fe_inicon date, p_fe_fincon date) OWNER TO tintegro;

--
-- TOC entry 396 (class 1255 OID 70597)
-- Name: llamada_general(character varying, character varying, character varying, date, date, character varying, character varying, integer, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_general(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer) RETURNS SETOF llamada_general2
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_va_return reportes.llamada_general2%rowtype;
 v_no_src VARCHAR:=p_no_src; --Nombre del origen de la llamada
 v_no_dst VARCHAR:=p_no_dst; --Nombre del destino de la llamada
 v_no_dis VARCHAR:=p_no_dis; -- Disposicion de la llamada
 v_fe_ini VARCHAR:=p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR:=p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR:=p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR:=p_horaf; -- Hora de fin de reporte
 v_tip_llamada integer := p_tip_llamada; --tipo de llamada 0 todas, 1 entrantes, 2 salientes, 3 entre anexos
 v_ran_initie integer := p_ran_initie; --duracion de llamada, si es 0 no se filtra
 v_ran_fintie integer := p_ran_fintie; --duracion de llamada, si es 0 no se filtra

 v_fe_inicio timestamp:=null; -- Fecha inicio de reporte
 v_fe_final timestamp:=null; -- Fecha fin de reporte
 
 BEGIN
 
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_no_src := case when v_no_src = '' then '%' else v_no_src end;
	v_no_dst := case when v_no_dst = '' then '%' else v_no_dst end;
	v_no_dis := case when v_no_dis = ''or v_no_dis is null then '%' else v_no_dis end;

	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf = '00' then '23:59:59' else v_horaf end;
	 
	v_fe_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fe_final := (v_fe_fin || ' ' || v_horaf)::timestamp;


if v_tip_llamada = 0 then 
 
  for v_va_return in
    SELECT distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate as fecha,
           calldate::time as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time::varchar as duration_min,
           billsec::varchar::interval::time as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst not in ('error')
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and disposition like v_no_dis
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and lastapp <> 'ResetCDR'

    order by 4,5
loop
 return next v_va_return;
end loop; 
return;
   
elsif v_tip_llamada = 1 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate as fecha,
           calldate::time as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time as duration_min,
           billsec::varchar::interval::time as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    --and dst <> 's'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and disposition like v_no_dis
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) > 5
    and length(dst) < 5
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;

elsif v_tip_llamada = 2 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate as fecha,
           calldate::time as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time as duration_min,
           billsec::varchar::interval::time as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and disposition like v_no_dis
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) < 5
    and length(dst) > 5
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;

elsif v_tip_llamada = 3 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate as fecha,
           calldate::time as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time as duration_min,
           billsec::varchar::interval::time as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    --and dst <> 's'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and disposition like v_no_dis
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) < 5 
    and length(dst) < 5 
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;
end if;

END;
$$;


ALTER FUNCTION reportes.llamada_general(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer) OWNER TO tintegro;

--
-- TOC entry 479 (class 1255 OID 144679)
-- Name: llamada_general_new(character varying, character varying, character varying, timestamp without time zone, timestamp without time zone, character varying, character varying, integer, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_general_new(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer) RETURNS SETOF llamada_general_new
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_va_return reportes.llamada_general_new%rowtype;
 v_no_src VARCHAR:=p_no_src; --Nombre del origen de la llamada
 v_no_dst VARCHAR:=p_no_dst; --Nombre del destino de la llamada
 v_no_dis VARCHAR:=p_no_dis; -- Disposicion de la llamada
 v_fe_ini VARCHAR:=p_fe_ini::date::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR:=p_fe_fin::date::varchar; -- Fecha fin de reporte
 v_horai VARCHAR:=p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR:=p_horaf; -- Hora de fin de reporte
 v_tip_llamada integer := p_tip_llamada; --tipo de llamada 0 todas, 1 entrantes, 2 salientes, 3 entre anexos
 v_ran_initie integer := p_ran_initie; --duracion de llamada, si es 0 no se filtra
 v_ran_fintie integer := p_ran_fintie; --duracion de llamada, si es 0 no se filtra

 v_fe_inicio timestamp:=null; -- Fecha inicio de reporte
 v_fe_final timestamp:=null; -- Fecha fin de reporte
 
 BEGIN
 
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_no_src := case when v_no_src = '' then '%' else v_no_src end;
	v_no_dst := case when v_no_dst = '' then '%' else v_no_dst end;
	v_no_dis := case when v_no_dis = ''or v_no_dis is null then '%' else v_no_dis end;

	v_horai := case when v_horai = '00:00:00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf = '00:00:00' then '23:59:59' else v_horaf end;
	 
	v_fe_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fe_final := (v_fe_fin || ' ' || v_horaf)::timestamp;


if v_tip_llamada = 0 then 
 
  for v_va_return in
    SELECT distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate::date::varchar as fecha,
           (calldate::time)::varchar as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time::varchar as duration_min,
           (billsec::varchar::interval::time)::varchar as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst not in ('error')
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and upper(disposition) like '%'||upper(v_no_dis)||'%'
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and lastapp <> 'ResetCDR'

    order by 4,5
loop
 return next v_va_return;
end loop; 
return;
   
elsif v_tip_llamada = 1 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate::date::varchar as fecha,
           calldate::time::varchar as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time::varchar as duration_min,
           billsec::varchar::interval::time::varchar as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    --and dst <> 's'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and upper(disposition) like '%'||upper(v_no_dis)||'%'
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) > 5
    and length(dst) < 5
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;

elsif v_tip_llamada = 2 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate::date::varchar as fecha,
           calldate::time::varchar as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time::varchar as duration_min,
           billsec::varchar::interval::time::varchar as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and upper(disposition) like '%'||upper(v_no_dis)||'%'
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) < 5
    and length(dst) > 5
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;

elsif v_tip_llamada = 3 then

  for v_va_return in
    select distinct src as ani,
           (case when dst = 's' then dstchannel else dst end) as dni,
           clid as age,
           calldate::date::varchar as fecha,
           calldate::time::varchar as tiempo,
           duration,
           billsec,
           duration::varchar::interval::time::varchar as duration_min,
           billsec::varchar::interval::time::varchar as billsec_min,
           (case when disposition = 'ANSWERED' then 'Contestado'
            when disposition = 'NO ANSWER' then 'No Contestado'
            when disposition = 'FAILED' then 'Fallido'
            when disposition = 'BUSY' then 'Ocupado'
            end) as descripcion
    from asterisk.cdr
    where substr(dst,1,1) <> '*'
    and dst <> 'error'
    --and dst <> 's'
    and duration > 0
    and src like v_no_src
    and dst like v_no_dst
    and upper(disposition) like '%'||upper(v_no_dis)||'%'
    and substr(dst::varchar,1,6) not in ('s-CONG')
    and substr(dstchannel::varchar,1,6) not in ('Local/')
    and lastapp in ('Dial', 'Hangup', 'Queue')
    and calldate between v_fe_inicio AND v_fe_final
    and substr(calldate::varchar, 12,8)::time > v_horai::time
    and substr(calldate::varchar, 12,8)::time < v_horaf::time
    and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
    and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
    and length(src) < 5 
    and length(dst) < 5 
    order by 4,5
loop
 return next v_va_return;
end loop; 
return;
end if;

END;
$$;


ALTER FUNCTION reportes.llamada_general_new(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer) OWNER TO tintegro;

--
-- TOC entry 480 (class 1255 OID 144784)
-- Name: llamada_general_report(character varying, character varying, character varying, timestamp without time zone, timestamp without time zone, character varying, character varying, integer, integer, integer, integer, integer); Type: FUNCTION; Schema: reportes; Owner: postgres
--

CREATE FUNCTION llamada_general_report(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer, p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF llamada_general_report
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return reportes.llamada_general_report%rowtype;
	v_no_src VARCHAR:=p_no_src; --Nombre del origen de la llamada
	v_no_dst VARCHAR:=p_no_dst; --Nombre del destino de la llamada
	v_no_dis VARCHAR:=p_no_dis; -- Disposicion de la llamada
	v_fe_ini VARCHAR:=p_fe_ini::date::varchar; -- Fecha inicio de reporte
	v_fe_fin VARCHAR:=p_fe_fin::date::varchar; -- Fecha fin de reporte
	v_horai VARCHAR:=p_horai; -- Hora de inicio de reporte
	v_horaf VARCHAR:=p_horaf; -- Hora de fin de reporte
	v_tip_llamada integer := p_tip_llamada; --tipo de llamada 0 todas, 1 entrantes, 2 salientes, 3 entre anexos
	v_ran_initie integer := p_ran_initie; --duracion de llamada, si es 0 no se filtra
	v_ran_fintie integer := p_ran_fintie; --duracion de llamada, si es 0 no se filtra

	v_fe_inicio timestamp:=null; -- Fecha inicio de reporte
	v_fe_final timestamp:=null; -- Fecha fin de reporte

	v_total_reg integer := 0;
	v_limit integer := p_nu_mostrar;
	v_nu_pagina integer := p_nu_pagina;
	v_limit_descontar integer := 0; 
 BEGIN
	if v_nu_pagina <> 1 then
		v_limit_descontar = v_limit * (v_nu_pagina - 1);
	else 
		v_limit_descontar = 0;
	end if;

 
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_no_src := case when v_no_src = '' then '%' else v_no_src end;
	v_no_dst := case when v_no_dst = '' then '%' else v_no_dst end;
	v_no_dis := case when v_no_dis = ''or v_no_dis is null then '%' else v_no_dis end;

	v_horai := case when v_horai = '00:00:00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf = '00:00:00' then '23:59:59' else v_horaf end;
	 
	v_fe_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fe_final := (v_fe_fin || ' ' || v_horaf)::timestamp;


if v_tip_llamada = 0 then 
	SELECT count(*) into v_total_reg
	from asterisk.cdr
	where substr(dst,1,1) <> '*'
	and dst not in ('error')
	and duration > 0
	and src like v_no_src
	and dst like v_no_dst
	and substr(dst::varchar,1,6) not in ('s-CONG')
	and substr(dstchannel::varchar,1,6) not in ('Local/')
	and upper(disposition) like '%'||upper(v_no_dis)||'%'
	and lastapp in ('Dial', 'Hangup', 'Queue')
	and calldate between v_fe_inicio AND v_fe_final
	and substr(calldate::varchar, 12,8)::time > v_horai::time
	and substr(calldate::varchar, 12,8)::time < v_horaf::time
	and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
	and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
	and lastapp <> 'ResetCDR';

	for v_va_return in
		SELECT distinct src as ani,
		(case when dst = 's' then dstchannel else dst end) as dni,
		clid as age,
		calldate::date::varchar as fecha,
		(calldate::time)::varchar as tiempo,
		duration,
		billsec,
		duration::varchar::interval::time::varchar as duration_min,
		(billsec::varchar::interval::time)::varchar as billsec_min,
		(case when disposition = 'ANSWERED' then 'Contestado'
		when disposition = 'NO ANSWER' then 'No Contestado'
		when disposition = 'FAILED' then 'Fallido'
		when disposition = 'BUSY' then 'Ocupado'
		end) as descripcion,
		v_total_reg
		from asterisk.cdr
		where substr(dst,1,1) <> '*'
		and dst not in ('error')
		and duration > 0
		and src like v_no_src
		and dst like v_no_dst
		and substr(dst::varchar,1,6) not in ('s-CONG')
		and substr(dstchannel::varchar,1,6) not in ('Local/')
		and upper(disposition) like '%'||upper(v_no_dis)||'%'
		and lastapp in ('Dial', 'Hangup', 'Queue')
		and calldate between v_fe_inicio AND v_fe_final
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
		and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
		and lastapp <> 'ResetCDR'
		and id not in(
			SELECT id
			from asterisk.cdr
			where substr(dst,1,1) <> '*'
			and dst not in ('error')
			and duration > 0
			and src like v_no_src
			and dst like v_no_dst
			and substr(dst::varchar,1,6) not in ('s-CONG')
			and substr(dstchannel::varchar,1,6) not in ('Local/')
			and upper(disposition) like '%'||upper(v_no_dis)||'%'
			and lastapp in ('Dial', 'Hangup', 'Queue')
			and calldate between v_fe_inicio AND v_fe_final
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
			and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
			and lastapp <> 'ResetCDR'
			order by (calldate::date::varchar),(calldate::time::varchar) limit v_limit_descontar)
		order by 4,5
		limit v_limit
	loop
	return next v_va_return;
	end loop; 
	return;

elsif v_tip_llamada = 1 then
	SELECT count(*) into v_total_reg
	from asterisk.cdr
	where substr(dst,1,1) <> '*'
	and dst <> 'error'
	--and dst <> 's'
	and duration > 0
	and src like v_no_src
	and dst like v_no_dst
	and upper(disposition) like '%'||upper(v_no_dis)||'%'
	and substr(dst::varchar,1,6) not in ('s-CONG')
	and substr(dstchannel::varchar,1,6) not in ('Local/')
	and lastapp in ('Dial', 'Hangup', 'Queue')
	and calldate between v_fe_inicio AND v_fe_final
	and substr(calldate::varchar, 12,8)::time > v_horai::time
	and substr(calldate::varchar, 12,8)::time < v_horaf::time
	and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
	and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
	and length(src) > 5
	and length(dst) < 5;
	
	for v_va_return in
		select distinct src as ani,
		(case when dst = 's' then dstchannel else dst end) as dni,
		clid as age,
		calldate::date::varchar as fecha,
		calldate::time::varchar as tiempo,
		duration,
		billsec,
		duration::varchar::interval::time::varchar as duration_min,
		billsec::varchar::interval::time::varchar as billsec_min,
		(case when disposition = 'ANSWERED' then 'Contestado'
		when disposition = 'NO ANSWER' then 'No Contestado'
		when disposition = 'FAILED' then 'Fallido'
		when disposition = 'BUSY' then 'Ocupado'
		end) as descripcion,
		v_total_reg
		from asterisk.cdr
		where substr(dst,1,1) <> '*'
		and dst <> 'error'
		--and dst <> 's'
		and duration > 0
		and src like v_no_src
		and dst like v_no_dst
		and upper(disposition) like '%'||upper(v_no_dis)||'%'
		and substr(dst::varchar,1,6) not in ('s-CONG')
		and substr(dstchannel::varchar,1,6) not in ('Local/')
		and lastapp in ('Dial', 'Hangup', 'Queue')
		and calldate between v_fe_inicio AND v_fe_final
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
		and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
		and length(src) > 5
		and length(dst) < 5
		and id not in(
			select id
			from asterisk.cdr
			where substr(dst,1,1) <> '*'
			and dst <> 'error'
			--and dst <> 's'
			and duration > 0
			and src like v_no_src
			and dst like v_no_dst
			and upper(disposition) like '%'||upper(v_no_dis)||'%'
			and substr(dst::varchar,1,6) not in ('s-CONG')
			and substr(dstchannel::varchar,1,6) not in ('Local/')
			and lastapp in ('Dial', 'Hangup', 'Queue')
			and calldate between v_fe_inicio AND v_fe_final
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
			and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
			and length(src) > 5
			and length(dst) < 5
			order by (calldate::date::varchar),(calldate::time::varchar) limit v_limit_descontar)
		order by 4,5
		limit v_limit
	loop
	return next v_va_return;
	end loop; 
	return;
elsif v_tip_llamada = 2 then
	SELECT count(*) into v_total_reg
	from asterisk.cdr
	where substr(dst,1,1) <> '*'
	and dst <> 'error'
	and duration > 0
	and src like v_no_src
	and dst like v_no_dst
	and upper(disposition) like '%'||upper(v_no_dis)||'%'
	and substr(dst::varchar,1,6) not in ('s-CONG')
	and substr(dstchannel::varchar,1,6) not in ('Local/')
	and lastapp in ('Dial', 'Hangup', 'Queue')
	and calldate between v_fe_inicio AND v_fe_final
	and substr(calldate::varchar, 12,8)::time > v_horai::time
	and substr(calldate::varchar, 12,8)::time < v_horaf::time
	and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
	and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
	and length(src) < 5
	and length(dst) > 5;
	for v_va_return in
		select distinct src as ani,
		(case when dst = 's' then dstchannel else dst end) as dni,
		clid as age,
		calldate::date::varchar as fecha,
		calldate::time::varchar as tiempo,
		duration,
		billsec,
		duration::varchar::interval::time::varchar as duration_min,
		billsec::varchar::interval::time::varchar as billsec_min,
		(case when disposition = 'ANSWERED' then 'Contestado'
		when disposition = 'NO ANSWER' then 'No Contestado'
		when disposition = 'FAILED' then 'Fallido'
		when disposition = 'BUSY' then 'Ocupado'
		end) as descripcion,
		v_total_reg
		from asterisk.cdr
		where substr(dst,1,1) <> '*'
		and dst <> 'error'
		and duration > 0
		and src like v_no_src
		and dst like v_no_dst
		and upper(disposition) like '%'||upper(v_no_dis)||'%'
		and substr(dst::varchar,1,6) not in ('s-CONG')
		and substr(dstchannel::varchar,1,6) not in ('Local/')
		and lastapp in ('Dial', 'Hangup', 'Queue')
		and calldate between v_fe_inicio AND v_fe_final
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
		and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
		and length(src) < 5
		and length(dst) > 5
		and id not in(
			select id
			from asterisk.cdr
			where substr(dst,1,1) <> '*'
			and dst <> 'error'
			and duration > 0
			and src like v_no_src
			and dst like v_no_dst
			and upper(disposition) like '%'||upper(v_no_dis)||'%'
			and substr(dst::varchar,1,6) not in ('s-CONG')
			and substr(dstchannel::varchar,1,6) not in ('Local/')
			and lastapp in ('Dial', 'Hangup', 'Queue')
			and calldate between v_fe_inicio AND v_fe_final
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
			and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
			and length(src) < 5
			and length(dst) > 5 order by (calldate::date::varchar),(calldate::time::varchar) limit v_limit_descontar)
		order by 4,5
		limit v_limit
	loop
	return next v_va_return;
	end loop; 
	return;

elsif v_tip_llamada = 3 then
	SELECT count(*) into v_total_reg
	from asterisk.cdr
	where substr(dst,1,1) <> '*'
	and dst <> 'error'
	--and dst <> 's'
	and duration > 0
	and src like v_no_src
	and dst like v_no_dst
	and upper(disposition) like '%'||upper(v_no_dis)||'%'
	and substr(dst::varchar,1,6) not in ('s-CONG')
	and substr(dstchannel::varchar,1,6) not in ('Local/')
	and lastapp in ('Dial', 'Hangup', 'Queue')
	and calldate between v_fe_inicio AND v_fe_final
	and substr(calldate::varchar, 12,8)::time > v_horai::time
	and substr(calldate::varchar, 12,8)::time < v_horaf::time
	and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
	and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
	and length(src) < 5 
	and length(dst) < 5; 
	
	for v_va_return in
		select distinct src as ani,
		(case when dst = 's' then dstchannel else dst end) as dni,
		clid as age,
		calldate::date::varchar as fecha,
		calldate::time::varchar as tiempo,
		duration,
		billsec,
		duration::varchar::interval::time::varchar as duration_min,
		billsec::varchar::interval::time::varchar as billsec_min,
		(case when disposition = 'ANSWERED' then 'Contestado'
		when disposition = 'NO ANSWER' then 'No Contestado'
		when disposition = 'FAILED' then 'Fallido'
		when disposition = 'BUSY' then 'Ocupado'
		end) as descripcion,
		v_total_reg
		from asterisk.cdr
		where substr(dst,1,1) <> '*'
		and dst <> 'error'
		--and dst <> 's'
		and duration > 0
		and src like v_no_src
		and dst like v_no_dst
		and upper(disposition) like '%'||upper(v_no_dis)||'%'
		and substr(dst::varchar,1,6) not in ('s-CONG')
		and substr(dstchannel::varchar,1,6) not in ('Local/')
		and lastapp in ('Dial', 'Hangup', 'Queue')
		and calldate between v_fe_inicio AND v_fe_final
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
		and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
		and length(src) < 5 
		and length(dst) < 5 
		and id not in(
			select id
			from asterisk.cdr
			where substr(dst,1,1) <> '*'
			and dst <> 'error'
			--and dst <> 's'
			and duration > 0
			and src like v_no_src
			and dst like v_no_dst
			and upper(disposition) like '%'||upper(v_no_dis)||'%'
			and substr(dst::varchar,1,6) not in ('s-CONG')
			and substr(dstchannel::varchar,1,6) not in ('Local/')
			and lastapp in ('Dial', 'Hangup', 'Queue')
			and calldate between v_fe_inicio AND v_fe_final
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			and billsec >= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 0 else v_ran_initie*60 end)
			and billsec <= (case when v_ran_initie = 0 and v_ran_fintie = 0 then 80000 else v_ran_fintie*60 end)
			and length(src) < 5 
			and length(dst) < 5 
			order by (calldate::date::varchar),(calldate::time::varchar) limit v_limit_descontar
		)
		order by 4,5
		limit v_limit
	loop
	return next v_va_return;
	end loop; 
	return;
end if;

END;
$$;


ALTER FUNCTION reportes.llamada_general_report(p_no_src character varying, p_no_dst character varying, p_no_dis character varying, p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_tip_llamada integer, p_ran_initie integer, p_ran_fintie integer, p_nu_pagina integer, p_nu_mostrar integer) OWNER TO postgres;

--
-- TOC entry 397 (class 1255 OID 70598)
-- Name: llamada_usuario(integer, integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario%rowtype;
 
 v_id_usuario varchar := p_id_usuario::varchar; --usuario del pin
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;
 v_id_extension integer := p_id_extension;
 v_no_extension varchar := '';

 BEGIN

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;
	
	v_id_usuario := case when v_id_usuario = '0' then '%' else v_id_usuario end;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	v_no_extension := case when v_id_extension = 0 then '%' else (select name from asterisk.sip_buddies where id_sip = v_id_extension) end;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
	 	SELECT  no_apepat || ' ' || no_apemat || ' ' || no_nombre  as v_nombre,
			calldate as fecha, 
			calldate::time(0) as tiempo, 
			dst as dni, 
			billsec, 
			billsec::varchar::interval::time as billsec_min,
			(case when disposition = 'ANSWERED' then 'Contestado'
			when disposition = 'NO ANSWER' then 'No Contestado'
			when disposition = 'FAILED' then 'Fallido'
			when disposition = 'BUSY' then 'Ocupado'
			end) as descripcion,
			src as ani
		FROM asterisk.cdr c ,	
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario and
		id_usuario::varchar like v_id_usuario
		and lastapp = 'Dial'
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		AND src like v_no_extension

		ORDER BY 1 Desc,2,4
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 473 (class 1255 OID 144675)
-- Name: llamada_usuario_new(integer, integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario_new(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario_new
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_new%rowtype;
 
 v_id_usuario varchar := p_id_usuario::varchar; --usuario del pin
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;
 v_id_extension integer := p_id_extension;
 v_no_extension varchar := '';

 BEGIN

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;
	
	v_id_usuario := case when v_id_usuario = '0' then '%' else v_id_usuario end;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	v_no_extension := case when v_id_extension = 0 then '%' else (select name from asterisk.sip_buddies where id_sip = v_id_extension) end;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
	 	SELECT  no_apepat || ' ' || no_apemat || ' ' || no_nombre  as v_nombre,
			calldate::date::varchar as fecha, 
			(calldate::time(0))::varchar as tiempo, --cambiado a Varchar
			dst as dni, 
			billsec, 
			(billsec::varchar::interval::time)::varchar as billsec_min,  --cambiado a Varchar
			(case when disposition = 'ANSWERED' then 'Contestado'
			when disposition = 'NO ANSWER' then 'No Contestado'
			when disposition = 'FAILED' then 'Fallido'
			when disposition = 'BUSY' then 'Ocupado'
			end) as descripcion,
			src as ani
		FROM asterisk.cdr c ,	
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario and
		id_usuario::varchar like v_id_usuario
		and lastapp = 'Dial'
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		AND src like v_no_extension

		ORDER BY 1 Desc,2,4
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_new(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 478 (class 1255 OID 144783)
-- Name: llamada_usuario_report(integer, integer, date, date, character varying, character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: postgres
--

CREATE FUNCTION llamada_usuario_report(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF llamada_usuario_report
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_report%rowtype;
 
 v_id_usuario varchar := p_id_usuario::varchar; --usuario del pin
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;
 v_id_extension integer := p_id_extension;
 v_no_extension varchar := '';
 v_total_reg integer := 0;
 v_limit integer := p_nu_mostrar;
 v_nu_pagina integer := p_nu_pagina;
 v_limit_descontar integer := p_nu_mostrar * (p_nu_pagina - 1);
 v_ids_exclucion varchar := '';

 BEGIN

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;
	
	v_id_usuario := case when v_id_usuario = '0' then '%' else v_id_usuario end;
	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	v_no_extension := case when v_id_extension = 0 then '%' else (select name from asterisk.sip_buddies where id_sip = v_id_extension) end;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

SELECT count(*) into v_total_reg			
FROM asterisk.cdr c ,	
asterisk.tb_usuario u 
WHERE 
u.id_usuari =  c.id_usuario and
id_usuario::varchar like v_id_usuario
and lastapp = 'Dial'
AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
AND src like v_no_extension;			
		
if v_nu_pagina = 1 then
	for v_va_return in 
	 	SELECT  no_apepat || ' ' || no_apemat || ' ' || no_nombre  as v_nombre,
			calldate::date::varchar as fecha, 
			(calldate::time(0))::varchar as tiempo, --cambiado a Varchar
			dst as dni, 
			billsec, 
			(billsec::varchar::interval::time)::varchar as billsec_min,  --cambiado a Varchar
			(case when disposition = 'ANSWERED' then 'Contestado'
			when disposition = 'NO ANSWER' then 'No Contestado'
			when disposition = 'FAILED' then 'Fallido'
			when disposition = 'BUSY' then 'Ocupado'
			end) as descripcion,
			src as ani,
			v_total_reg		
		FROM asterisk.cdr c ,	
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario and
		id_usuario::varchar like v_id_usuario
		and lastapp = 'Dial'
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		AND src like v_no_extension
		ORDER BY 1 Desc,2,4
		limit v_limit
	loop 
		return next v_va_return; 
	end loop; 
else 
	for v_va_return in 
	 	SELECT  no_apepat || ' ' || no_apemat || ' ' || no_nombre  as v_nombre,
			calldate::date::varchar as fecha, 
			(calldate::time(0))::varchar as tiempo, --cambiado a Varchar
			dst as dni, 
			billsec, 
			(billsec::varchar::interval::time)::varchar as billsec_min,  --cambiado a Varchar
			(case when disposition = 'ANSWERED' then 'Contestado'
			when disposition = 'NO ANSWER' then 'No Contestado'
			when disposition = 'FAILED' then 'Fallido'
			when disposition = 'BUSY' then 'Ocupado'
			end) as descripcion,
			src as ani,
			v_total_reg			
		FROM asterisk.cdr c ,	
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario and
		id_usuario::varchar like v_id_usuario
		and lastapp = 'Dial'
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		AND src like v_no_extension
		and id not in (SELECT  id		
		FROM asterisk.cdr c ,	
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario and
		id_usuario::varchar like v_id_usuario
		and lastapp = 'Dial'
		AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
		AND src like v_no_extension
		ORDER BY (no_apepat || ' ' || no_apemat || ' ' || no_nombre) Desc,(calldate::date::varchar),dst
		limit v_limit_descontar)
		ORDER BY 1 Desc,2,4
		limit v_limit
	loop 
		return next v_va_return; 
	end loop; 
end if;

return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_report(p_id_usuario integer, p_id_extension integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) OWNER TO postgres;

--
-- TOC entry 460 (class 1255 OID 70599)
-- Name: llamada_usuario_top(date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario_top(p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario_top
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_top%rowtype;
 
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;


 BEGIN


	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;
	
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT c.id_usuario, 
			no_apepat || ' ' || no_apemat || ' ' || no_nombre as v_usuario,
		  sum(1) as can_llamadas,
		  sum(c.billsec)::varchar::interval::time as tiempo_conversado,
		  (sum(c.billsec)/sum(1))::varchar::interval::time as t_promedio,
		  min(c.billsec)::varchar::interval::time as t_minconver,
		  max(c.billsec)::varchar::interval::time as t_maxconver
		FROM asterisk.cdr c,
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario
		and c.id_usuario is not null
		AND lastapp = 'Dial'
		AND calldate between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		GROUP BY c.id_usuario, no_apepat, no_apemat, no_nombre
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop 
	return next v_va_return; 
		end loop; 
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_top(p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 400 (class 1255 OID 70600)
-- Name: llamada_usuario_top_detalle(integer, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario_top_detalle(p_id_usuario integer, p_fecha date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario_top_detalle
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_top_detalle%rowtype;
 
 v_id_usuario integer := p_id_usuario; --usuario del pin
 v_fecha VARCHAR := p_fecha::varchar; -- Fecha inicio de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_no_usuario varchar := null;
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;

 BEGIN

	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;

	select coalesce(v_fecha, current_date::varchar) into v_fecha;

	v_fecha_inicio := (v_fecha || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fecha || ' ' || v_horaf)::timestamp;


	for v_va_return in 
		select initcap(no_apepat) || ' ' || initcap(no_apemat) || ' ' || initcap(no_nombre) as v_usuario,
		   calldate as fecha, 
		   calldate::time(0) as tiempo, 
		   src as ani,
		   dst as dni, 
		   billsec::varchar::interval::time, 
		   (case when disposition = 'ANSWERED' then 'Contestado'
		    when disposition = 'NO ANSWER' then 'No Contestado'
		    when disposition = 'FAILED' then 'Fallido'
		    when disposition = 'BUSY' then 'Ocupado'
		    end) as descripcion
		from asterisk.cdr c,
		asterisk.tb_usuario u
		where u.id_usuari =  c.id_usuario
		AND id_usuario = v_id_usuario
		AND lastapp = 'Dial'
		AND calldate between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		order by 1,2,4
	loop 
		return next v_va_return; 
	end loop; 
	
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_top_detalle(p_id_usuario integer, p_fecha date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 401 (class 1255 OID 70601)
-- Name: llamada_usuario_top_dia(integer, date, date, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario_top_dia(p_id_usuario integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario_top_dia
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_top_dia%rowtype;
 
 v_id_usuario integer := p_id_usuario;
 v_fe_ini VARCHAR := p_fe_ini::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR:= p_fe_fin::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;


 BEGIN

	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null then '23:59:59' else v_horaf end;

	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
	select c.id_usuario, 
		no_apepat || ' ' || no_apemat || ' ' || no_nombre as v_usuario,
		calldate::date as dia,
		sum(1) as can_llamadas,
		sum(c.billsec)::varchar::interval::time as tiempo_conversado,
		(sum(c.billsec)/sum(1))::varchar::interval::time as t_promedio,
		min(c.billsec)::varchar::interval::time as t_minconver,
		max(c.billsec)::varchar::interval::time as t_maxconver
	from asterisk.cdr c,
	asterisk.tb_usuario u
	where 
	u.id_usuari =  c.id_usuario
	AND c.id_usuario = v_id_usuario
	AND lastapp = 'Dial'
	AND calldate::timestamp between v_fecha_inicio AND v_fecha_fin
	and substr(calldate::varchar, 12,8)::time > v_horai::time
	and substr(calldate::varchar, 12,8)::time < v_horaf::time
	group by calldate::date, c.id_usuario, no_apepat, no_apemat, no_nombre
	ORDER BY c.id_usuario, calldate::date, can_llamadas DESC, tiempo_conversado
	loop 
	return next v_va_return; 
	end loop; 
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_top_dia(p_id_usuario integer, p_fe_ini date, p_fe_fin date, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 475 (class 1255 OID 144683)
-- Name: llamada_usuario_top_new(timestamp without time zone, timestamp without time zone, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamada_usuario_top_new(p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying) RETURNS SETOF llamada_usuario_topii
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_topII%rowtype;
 
 v_fe_ini VARCHAR := p_fe_ini::date::varchar; -- Fecha inicio de reporte
 v_fe_fin VARCHAR := p_fe_fin::date::varchar; -- Fecha fin de reporte
 v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
 v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
 v_fecha_inicio timestamp := null;
 v_fecha_fin timestamp := null;


 BEGIN


	v_horai := case when v_horai = '00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null or v_horaf = '00' then '23:59:59' else v_horaf end;
	
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;

	for v_va_return in 
		SELECT c.id_usuario, 
			no_apepat || ' ' || no_apemat || ' ' || no_nombre as v_usuario,
		  sum(1) as can_llamadas,
		  (sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		  ((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		  (min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		  (max(c.billsec)::varchar::interval::time)::varchar as t_maxconver
		FROM asterisk.cdr c,
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario
		and c.id_usuario is not null
		AND lastapp = 'Dial'
		AND calldate between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		GROUP BY c.id_usuario, no_apepat, no_apemat, no_nombre
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop 
	return next v_va_return; 
		end loop; 
	return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_top_new(p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying) OWNER TO tintegro;

--
-- TOC entry 481 (class 1255 OID 144786)
-- Name: llamada_usuario_top_report(timestamp without time zone, timestamp without time zone, character varying, character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: postgres
--

CREATE FUNCTION llamada_usuario_top_report(p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) RETURNS SETOF llamada_usuario_top_report
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return reportes.llamada_usuario_top_report%rowtype;
 v_va_conta reportes.llamada_usuario_top_report%rowtype;
 
	v_fe_ini VARCHAR := p_fe_ini::date::varchar; -- Fecha inicio de reporte
	v_fe_fin VARCHAR := p_fe_fin::date::varchar; -- Fecha fin de reporte
	v_horai VARCHAR := p_horai; -- Hora de inicio de reporte
	v_horaf VARCHAR := p_horaf; -- Hora de fin de reporte
	v_fecha_inicio timestamp := null;
	v_fecha_fin timestamp := null;

	v_total_reg integer := 0;
	v_limit integer := p_nu_mostrar;
	v_nu_pagina integer := p_nu_pagina;
	v_limit_descontar integer := 0; 

 BEGIN
	if v_nu_pagina <> 1 then
		v_limit_descontar = v_limit * (v_nu_pagina - 1);
	else 
		v_limit_descontar = 0;
	end if;

	v_horai := case when v_horai = '00:00:00' then '00:00:00' else v_horai end;
	v_horaf := case when v_horaf is null or v_horaf = '00:00:00' then '23:59:59' else v_horaf end;
	
	select coalesce(v_fe_ini, current_date::varchar) into v_fe_ini;
	select coalesce(v_fe_fin, current_date::varchar) into v_fe_fin;

	v_fecha_inicio := (v_fe_ini || ' ' || v_horai)::timestamp;
	v_fecha_fin := (v_fe_fin || ' ' || v_horaf)::timestamp;
	
	for v_va_conta in 
		SELECT c.id_usuario, 
			no_apepat || ' ' || no_apemat || ' ' || no_nombre as v_usuario,
		  sum(1) as can_llamadas,
		  (sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		  ((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		  (min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		  (max(c.billsec)::varchar::interval::time)::varchar as t_maxconver,
		  v_total_reg
		FROM asterisk.cdr c,
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario
		and c.id_usuario is not null
		AND lastapp = 'Dial'
		AND calldate between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		GROUP BY c.id_usuario, no_apepat, no_apemat, no_nombre
		ORDER BY tiempo_conversado desc, can_llamadas desc
	loop
		v_total_reg = v_total_reg + 1;
		raise notice 'Cantidad: %', v_total_reg;
	end loop; 
	
	for v_va_return in 
		SELECT c.id_usuario, 
			no_apepat || ' ' || no_apemat || ' ' || no_nombre as v_usuario,
		  sum(1) as can_llamadas,
		  (sum(c.billsec)::varchar::interval::time)::varchar as tiempo_conversado,
		  ((sum(c.billsec)/sum(1))::varchar::interval::time)::varchar as t_promedio,
		  (min(c.billsec)::varchar::interval::time)::varchar as t_minconver,
		  (max(c.billsec)::varchar::interval::time)::varchar as t_maxconver,
		  v_total_reg
		FROM asterisk.cdr c,
		asterisk.tb_usuario u 
		WHERE 
		u.id_usuari =  c.id_usuario
		and c.id_usuario is not null
		AND lastapp = 'Dial'
		AND calldate between v_fecha_inicio AND v_fecha_fin
		and substr(calldate::varchar, 12,8)::time > v_horai::time
		and substr(calldate::varchar, 12,8)::time < v_horaf::time
		and c.id_usuario not in(
			SELECT c.id_usuario
			FROM asterisk.cdr c,
			asterisk.tb_usuario u 
			WHERE 
			u.id_usuari =  c.id_usuario
			and c.id_usuario is not null
			AND lastapp = 'Dial'
			AND calldate between v_fecha_inicio AND v_fecha_fin
			and substr(calldate::varchar, 12,8)::time > v_horai::time
			and substr(calldate::varchar, 12,8)::time < v_horaf::time
			GROUP BY c.id_usuario, no_apepat, no_apemat, no_nombre
			ORDER BY ((sum(c.billsec)::varchar::interval::time)::varchar) desc limit v_limit_descontar)		
		GROUP BY c.id_usuario, no_apepat, no_apemat, no_nombre
		ORDER BY tiempo_conversado desc, can_llamadas desc
		limit v_limit
	loop 
		return next v_va_return; 			
	end loop; 	
return; 
END;
$$;


ALTER FUNCTION reportes.llamada_usuario_top_report(p_fe_ini timestamp without time zone, p_fe_fin timestamp without time zone, p_horai character varying, p_horaf character varying, p_nu_pagina integer, p_nu_mostrar integer) OWNER TO postgres;

--
-- TOC entry 402 (class 1255 OID 70602)
-- Name: llamadas_atendida_abandonadas(character varying, integer, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) RETURNS SETOF llamadas_atendida_abandonadas_rango
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_no_agente varchar:=p_id_agente::varchar; --Id del agente
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamadas_atendida_abandonadas_rango%rowtype;
BEGIN
 v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  row_number() OVER (ORDER BY queuename ) AS id_queuename,
  queuename,
  agente,
  data5,
  ca_llamadas,
  reportes.formato_tiempo(t_espera/ca_llamadas) as prom_espera,
  reportes.formato_tiempo(t_conversa/ca_llamadas) as prom_conversa
  from (
  select 
  queuename as queuename,
  (a.no_apepat || ' ' || a.no_apemat || ' ' || no_nombre) as agente,
  data5 as data5,
  count(*) as ca_llamadas,
  sum(c.data1::integer) as t_espera,
  sum(c.data2::integer) as t_conversa
  from asterisk.callcenter c ,
  asterisk.agente a
  where event in ('COMPLETECALLER','COMPLETEAGENT')
  and c.data5 = a.nu_agente::varchar  
  AND queuename like v_queuename
  and id_agente::varchar like v_no_agente
  and "time"::date between v_feini::date and v_fefin::date
  group by agente,queuename ,  data5) t
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 461 (class 1255 OID 70603)
-- Name: llamadas_atendida_abandonadas(character varying, integer, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas(p_queuename character varying, p_id_agente integer, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llamadas_atendida_abandonadas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_no_agente varchar:=p_id_agente::varchar; --Id del agente
 v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llamadas_atendida_abandonadas%rowtype;
BEGIN
 v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select
  row_number() OVER (ORDER BY queuename ) AS id_queuename,
  queuename,
  extract(month from  c."time") as mes,
  (a.no_apepat || ' ' || a.no_apemat || ' ' || no_nombre) as no_agente,
  data5,
  count(*) as contestadas
  from asterisk.callcenter c,
  asterisk.agente a
  where event in ('COMPLETEAGENT', 'COMPLETECALLER')
  and data2 not in ('1','2')
  and c.data5 = a.nu_agente::varchar  
  AND queuename like v_queuename
  and id_agente::varchar like v_no_agente
  and extract(month from  "time")::integer = v_nu_mes
         and extract(year from  "time")::integer = v_nu_ano 
  group by extract(month from  "time"),extract(year from  "time"),queuename,
  a.no_apepat, a.no_apemat, no_nombre,
  data5
  order by 2,3,4
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas(p_queuename character varying, p_id_agente integer, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 404 (class 1255 OID 70604)
-- Name: llamadas_atendida_abandonadas_cabina(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_cabina(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  and length(data4)=4
  AND queuename like v_queuename
  and extract(month from  "time")::integer = v_nu_mes
         and extract(year from  "time")::integer = v_nu_ano 
  group by extract(month from  "time") , extract(year from  "time")  ) as t
   
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_cabina(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 462 (class 1255 OID 70605)
-- Name: llamadas_atendida_abandonadas_cabina_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_cabina_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  --and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  and length(data4)=4
  AND queuename like v_queuename
  and "time"::date between v_feini::date and v_fefin::date
  group by extract(month from  "time")  ) as t   
   
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_cabina_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 405 (class 1255 OID 70606)
-- Name: llamadas_atendida_abandonadas_central(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_central(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  AND queuename like v_queuename
  and extract(month from  "time")::integer = v_nu_mes
         and extract(year from  "time")::integer = v_nu_ano 
  group by extract(month from  "time") , extract(year from  "time")  ) as t   
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_central(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 406 (class 1255 OID 70607)
-- Name: llamadas_atendida_abandonadas_central_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_central_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  --and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  AND queuename like v_queuename
  and "time"::date between v_feini::date and v_fefin::date
  group by extract(month from  "time")  ) as t   
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_central_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 457 (class 1255 OID 70608)
-- Name: llamadas_atendida_abandonadas_exterior(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_exterior(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in
  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  and length(data4)>4
  AND queuename like v_queuename
  and extract(month from  "time")::integer = v_nu_mes
         and extract(year from  "time")::integer = v_nu_ano 
  group by extract(month from  "time") , extract(year from  "time")  ) as t   
  loop 
  return next v_va_return; 
 end loop; 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_exterior(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 407 (class 1255 OID 70609)
-- Name: llamadas_atendida_abandonadas_exterior_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_exterior_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llam_ate_aban_resul
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llam_ate_aban_resul%rowtype;
BEGIN 
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in
  select 
  mes,
  contestadas,
  abandonadas, 
  (contestadas + abandonadas) as va_total, 
  (abandonadas * 100)/(contestadas + abandonadas) as va_porc
  from (select
  extract(month from  "time") as mes,
  sum(case when event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1 else 0 end) as contestadas,
  sum(case when event in ('ABANDON') then 1 else 0 end) as abandonadas
  from asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER', 'ABANDON')
  --and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
  and length(data4)>4
  AND queuename like v_queuename
  and "time"::date between v_feini::date and v_fefin::date
  group by extract(month from  "time")  ) as t   
  loop 
  return next v_va_return; 
 end loop; 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_exterior_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 463 (class 1255 OID 70610)
-- Name: llamadas_atendida_abandonadas_rango(character varying, integer, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_rango(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) RETURNS SETOF llamadas_atendida_abandonadas_list
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_no_agente varchar:=p_id_agente::varchar; --Id del agente
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamadas_atendida_abandonadas_list%rowtype;
BEGIN
 v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select 
  id_queuename,
  queuename,
  agente,
  data5,
  (select * from reportes.formato_tiempo(t_espera/ca_llamadas))::varchar as prom_espera,
  (select * from reportes.formato_tiempo(t_conversa/ca_llamadas))::varchar as prom_conversa,
  ca_llamadas 
  from (
  select
  row_number() OVER (ORDER BY queuename ) AS id_queuename, 
  queuename as queuename,
  (a.no_apepat || ' ' || a.no_apemat || ' ' || no_nombre) as agente,
  data5 as data5,
  count(*) as ca_llamadas,
  sum(c.data1::integer) as t_espera,
  sum(c.data2::integer) as t_conversa
  from asterisk.callcenter c ,
  asterisk.agente a
  where event in ('COMPLETECALLER','COMPLETEAGENT')
  and c.data5 = a.nu_agente::varchar  
  AND queuename like v_queuename
  and id_agente::varchar like v_no_agente
  and "time"::date between v_feini::date and v_fefin::date
  group by agente,queuename ,  data5) t
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_rango(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 408 (class 1255 OID 70611)
-- Name: llamadas_atendida_abandonadas_rango_resumen(character varying, integer, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_atendida_abandonadas_rango_resumen(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) RETURNS SETOF llamadas_atendida_abandonadas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_no_agente varchar:=p_id_agente::varchar; --Id del agente
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamadas_atendida_abandonadas%rowtype;
BEGIN
 v_no_agente := case when v_no_agente = '0' then '%' else v_no_agente end;
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  select
  row_number() OVER (ORDER BY queuename ) AS id_queuename,
  queuename,
  extract(month from  c."time") as mes,
  (a.no_apepat || ' ' || a.no_apemat || ' ' || no_nombre) as no_agente,
  data5,
  count(*) as contestadas
  from asterisk.callcenter c,
  asterisk.agente a
  where event in ('COMPLETEAGENT', 'COMPLETECALLER')
  --and data2 not in ('1','2')
  and c.data5 = a.nu_agente::varchar  
  AND queuename like v_queuename
  and id_agente::varchar like v_no_agente
  and "time"::date between v_feini::date and v_fefin::date
  group by extract(month from "time"),queuename,
  a.no_apepat, a.no_apemat, no_nombre,
  data5
  order by 4,3,2
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_atendida_abandonadas_rango_resumen(p_queuename character varying, p_id_agente integer, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 409 (class 1255 OID 70612)
-- Name: llamadas_entrantes_xhora(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_entrantes_xhora(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF llamadas_entrantes_xhora
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_nu_mes integer := p_nu_mes;
  v_nu_ano integer := p_nu_ano;
 v_va_return reportes.llamadas_entrantes_xhora%rowtype;
BEGIN
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 
  
select row_number() OVER (ORDER BY t.hora ) AS id_queuename, * from (
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,    
    '00:00 - 01:00' as hora,
    sum(case when extract(hour from  "time") = '00' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '00' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '00' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '01:00 - 02:00' as hora,
    sum(case when extract(hour from  "time") = '01' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '01' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido,
    sum(case when extract(hour from  "time") = '01' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '02:00 - 03:00' as hora,
    sum(case when extract(hour from  "time") = '02' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '02' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '02' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '03:00 - 04:00' as hora,
    sum(case when extract(hour from  "time") = '03' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '03' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '03' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '04:00 - 05:00' as hora,
    sum(case when extract(hour from  "time") = '04' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '04' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '04' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '05:00 - 06:00' as hora,
    sum(case when extract(hour from  "time") = '05' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '05' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '05' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '06:00 - 07:00' as hora,
    sum(case when extract(hour from  "time") = '06' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '06' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '06' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '07:00 - 08:00' as hora,
    sum(case when extract(hour from  "time") = '07' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '07' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '07' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '08:00 - 09:00' as hora,
    sum(case when extract(hour from  "time") = '08' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '08' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '08' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '09:00 - 10:00' as hora,
    sum(case when extract(hour from  "time") = '09' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '09' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '09' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '10:00 - 11:00' as hora,
    sum(case when extract(hour from  "time") = '10' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '10' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '10' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '11:00 - 12:00' as hora,
    sum(case when extract(hour from  "time") = '11' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '11' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '11' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '12:00 - 13:00' as hora,
    sum(case when extract(hour from  "time") = '12' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '12' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '12' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '13:00 - 14:00' as hora,
    sum(case when extract(hour from  "time") = '13' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '13' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '13' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '14:00 - 15:00' as hora,
    sum(case when extract(hour from  "time") = '14' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '14' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido,
    sum(case when extract(hour from  "time") = '14' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '15:00 - 16:00' as hora,
    sum(case when extract(hour from  "time") = '15' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '15' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '15' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '16:00 - 17:00' as hora,
    sum(case when extract(hour from  "time") = '16' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '16' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '16' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '17:00 - 18:00' as hora,
    sum(case when extract(hour from  "time") = '17' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '17' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '17' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '18:00 - 19:00' as hora,
    sum(case when extract(hour from  "time") = '18' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '18' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '18' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '19:00 - 20:00' as hora,
    sum(case when extract(hour from  "time") = '19' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '19' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido,
    sum(case when extract(hour from  "time") = '19' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '20:00 - 21:00' as hora,
    sum(case when extract(hour from  "time") = '20' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '20' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '20' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '21:00 - 22:00' as hora,
    sum(case when extract(hour from  "time") = '21' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '21' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido,
    sum(case when extract(hour from  "time") = '21' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '22:00 - 23:00' as hora,
    sum(case when extract(hour from  "time") = '22' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '22' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '22' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
UNION
select queuename, extract(month from  "time") as mes ,  extract(year from  "time") as ano,   
    '23:00 - 24:00' as hora,
    sum(case when extract(hour from  "time") = '23' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '23' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as atendido, 
    sum(case when extract(hour from  "time") = '23' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
and ((event IN ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2')) or event = 'ABANDON')
group by extract(month from  "time") ,  extract(year from  "time") , queuename
) as t
where
queuename like v_queuename and
t.mes = v_nu_mes and
t.ano = v_nu_ano
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_entrantes_xhora(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 464 (class 1255 OID 70613)
-- Name: llamadas_entrantes_xhora_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION llamadas_entrantes_xhora_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF llamadas_entrantes_xhora
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.llamadas_entrantes_xhora%rowtype;
BEGIN
 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 
  
select row_number() OVER (ORDER BY  t.hora ) AS id_queuename, queuename, 0, 0, hora ,entrante , atendido , abandono from (
select queuename,   
    '00:00 - 01:00' as hora,
    sum(case when extract(hour from  "time") = '00' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '00' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '00' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '01:00 - 02:00' as hora,
    sum(case when extract(hour from  "time") = '01' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '01' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido,
    sum(case when extract(hour from  "time") = '01' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '02:00 - 03:00' as hora,
    sum(case when extract(hour from  "time") = '02' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '02' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '02' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '03:00 - 04:00' as hora,
    sum(case when extract(hour from  "time") = '03' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '03' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '03' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '04:00 - 05:00' as hora,
    sum(case when extract(hour from  "time") = '04' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '04' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '04' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '05:00 - 06:00' as hora,
    sum(case when extract(hour from  "time") = '05' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '05' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '05' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '06:00 - 07:00' as hora,
    sum(case when extract(hour from  "time") = '06' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '06' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '06' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '07:00 - 08:00' as hora,
    sum(case when extract(hour from  "time") = '07' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '07' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '07' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '08:00 - 09:00' as hora,
    sum(case when extract(hour from  "time") = '08' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '08' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '08' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '09:00 - 10:00' as hora,
    sum(case when extract(hour from  "time") = '09' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '09' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '09' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '10:00 - 11:00' as hora,
    sum(case when extract(hour from  "time") = '10' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '10' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '10' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '11:00 - 12:00' as hora,
    sum(case when extract(hour from  "time") = '11' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '11' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '11' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '12:00 - 13:00' as hora,
    sum(case when extract(hour from  "time") = '12' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '12' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '12' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '13:00 - 14:00' as hora,
    sum(case when extract(hour from  "time") = '13' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '13' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '13' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '14:00 - 15:00' as hora,
    sum(case when extract(hour from  "time") = '14' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '14' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido,
    sum(case when extract(hour from  "time") = '14' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '15:00 - 16:00' as hora,
    sum(case when extract(hour from  "time") = '15' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '15' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '15' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '16:00 - 17:00' as hora,
    sum(case when extract(hour from  "time") = '16' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '16' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '16' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '17:00 - 18:00' as hora,
    sum(case when extract(hour from  "time") = '17' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '17' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '17' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '18:00 - 19:00' as hora,
    sum(case when extract(hour from  "time") = '18' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '18' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '18' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '19:00 - 20:00' as hora,
    sum(case when extract(hour from  "time") = '19' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '19' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido,
    sum(case when extract(hour from  "time") = '19' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '20:00 - 21:00' as hora,
    sum(case when extract(hour from  "time") = '20' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '20' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '20' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '21:00 - 22:00' as hora,
    sum(case when extract(hour from  "time") = '21' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '21' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido,
    sum(case when extract(hour from  "time") = '21' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '22:00 - 23:00' as hora,
    sum(case when extract(hour from  "time") = '22' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '22' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '22' and event in ('ABANDON') then 1  else 0 end) as abandono 
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
UNION
select queuename,  
    '23:00 - 24:00' as hora,
    sum(case when extract(hour from  "time") = '23' then 1  else 0 end) as entrante, 
    sum(case when extract(hour from  "time") = '23' and event in ('COMPLETEAGENT', 'COMPLETECALLER') then 1  else 0 end) as 

atendido, 
    sum(case when extract(hour from  "time") = '23' and event in ('ABANDON') then 1  else 0 end) as abandono
    from asterisk.callcenter
where event IN ('COMPLETECALLER','COMPLETEAGENT','ABANDON')
 and "time"::date between v_feini::date and v_fefin::date
group by queuename
) as t
where queuename like v_queuename 
order by t.hora
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.llamadas_entrantes_xhora_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 410 (class 1255 OID 70614)
-- Name: reporte_abandonos(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION reporte_abandonos(p_noqueue character varying, p_fe_inicon date, p_fe_fincon date) RETURNS SETOF reporte_abandonos_ac
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_noqueue varchar:=p_noqueue; --Nombre de la cola
 v_fe_inicon date := p_fe_inicon;
 v_fe_fincon date := p_fe_fincon;
 v_va_return reportes.reporte_abandonos_ac%rowtype;
BEGIN

 v_noqueue := case when v_noqueue = '' or v_noqueue is null then '%' else v_noqueue end;

 for v_va_return in 

  SELECT callid,   queuename,time::date,
  time, data3::INTEGER ,data4
  FROM asterisk.callcenter 
  WHERE event = 'ABANDON'
  AND "time"::date between v_fe_inicon::date AND v_fe_fincon::date
  AND queuename like v_noqueue
  order by 3,4
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.reporte_abandonos(p_noqueue character varying, p_fe_inicon date, p_fe_fincon date) OWNER TO tintegro;

--
-- TOC entry 465 (class 1255 OID 70615)
-- Name: respuesta_operador(character varying, integer, integer, character varying, character varying); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION respuesta_operador(p_ti_report character varying, p_va_tab integer, p_va_nsv integer, p_fe_report character varying, p_no_queue character varying) RETURNS SETOF respuesta_operador
    LANGUAGE plpgsql
    AS $$
DECLARE 

 v_va_return reportes.respuesta_operador%rowtype;
 v_ti_report varchar:=p_ti_report; --Tipo de Report: Anual, Mensual, Diario, Hora
 v_va_tab integer:=p_va_tab; -- Valor de TAB
 v_va_ns integer:=p_va_nsv; -- Valor de Nivel de servicio
 v_fe_report varchar:=p_fe_report; -- Fecha de reporte
 v_va_cola varchar:=p_no_queue; --Nombre de cola
 
 BEGIN 
 
	v_ti_report := case when v_ti_report is null then '' else upper(v_ti_report) end;
	v_va_tab := case when v_va_tab is null then 10 else v_va_tab end;
	v_va_ns := case when v_va_ns is null then 10 else v_va_ns end;
	v_fe_report := case when v_fe_report is null then current_date::varchar else v_fe_report end;
	v_va_cola := case when v_va_cola = 'TODAS' or v_va_cola is null then '%' else v_va_cola end;
 

	if (v_ti_report = 'ANUAL') then
		for v_va_return in 
			select  substr(time::varchar(10),1,4) as fecha, 
				sum(1) as lla_entra, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atendi, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data1::INTEGER <= v_va_tab and data2 not in ('1','2') THEN 1 ELSE 0 END) as llam_atetab, 
				sum(case when event = 'ABANDON' THEN 1 ELSE 0 END) as lla_abando, 
				sum(case when event = 'ABANDON' and data3::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as lla_abatab, 
				sum(case when event = 'EXITWITHTIMEOUT' THEN 1 ELSE 0 END) as lla_disuac, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data1::INTEGER <= v_va_ns and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atens, 
				sum(case when (event = 'COMPLETECALLER' or event = 'COMPLETEAGENT') and data2 not in ('1','2') then data2::INTEGER else 0 end) / sum(1) as ti_procon, 
				sum(int4(data1))/ sum(1) as ti_proesp, 
				max(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') then data1::INTEGER else 0 end ) as ti_ema,  
				max(case when event = 'ABANDON' then data3::INTEGER else 0 end) as ti_abando  
			from asterisk.callcenter 
			where event in ('COMPLETECALLER','COMPLETEAGENT','ABANDON', 'EXITWITHTIMEOUT') 
			and queuename like v_va_cola
			group by fecha order by fecha

		loop 
			return next v_va_return; 
		end loop; 

	elsif(v_ti_report = 'MES') then
		for v_va_return in 
			select  substr(time::varchar(10),1,7) as fecha, 
				sum(1) as lla_entra, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atendi, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') and data1::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as llam_atetab, 
				sum(case when event = 'ABANDON' THEN 1 ELSE 0 END) as lla_abando, 
				sum(case when event = 'ABANDON' and data3::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as lla_abatab, 
				sum(case when event = 'EXITWITHTIMEOUT' THEN 1 ELSE 0 END) as lla_disuac, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data1::INTEGER <= v_va_ns and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atens, 
				sum(case when (event = 'COMPLETECALLER' or event = 'COMPLETEAGENT') and data2 not in ('1','2') then data2::INTEGER else 0 end) / sum(1) as ti_procon, 
				sum(int4(data1))/ sum(1) as ti_proesp, 
				max(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') then data1::INTEGER else 0 end ) as ti_ema,  
				max(case when event = 'ABANDON' then data3::INTEGER else 0 end) as ti_abando  
			from asterisk.callcenter
			where event in ('COMPLETECALLER','COMPLETEAGENT','ABANDON', 'EXITWITHTIMEOUT') 
			and queuename like v_va_cola
			and substr(time::varchar,1,4) = substr(v_fe_report,1,4)
			group by fecha order by fecha

		loop 
			return next v_va_return; 
		end loop; 

	elsif(v_ti_report = 'DIA') then
		for v_va_return in 
			select  substr(time::varchar(10),1,10) as fecha, 
				sum(1) as lla_entra, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atendi, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') and data1::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as llam_atetab, 
				sum(case when event = 'ABANDON' THEN 1 ELSE 0 END) as lla_abando, 
				sum(case when event = 'ABANDON' and data3::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as lla_abatab, 
				sum(case when event = 'EXITWITHTIMEOUT' THEN 1 ELSE 0 END) as lla_disuac, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') and data1::INTEGER <= v_va_ns THEN 1 ELSE 0 END) as lla_atens, 
				sum(case when (event = 'COMPLETECALLER' or event = 'COMPLETEAGENT') and data2 not in ('1','2') then data2::INTEGER else 0 end) / sum(1) as ti_procon, 
				sum(int4(data1))/ sum(1) as ti_proesp, 
				max(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') then data1::INTEGER else 0 end ) as ti_ema,  
				max(case when event = 'ABANDON' then data3::INTEGER else 0 end) as ti_abando  
			from asterisk.callcenter
			where event in ('COMPLETECALLER','COMPLETEAGENT','ABANDON', 'EXITWITHTIMEOUT') 
			and queuename like v_va_cola
			and substr(time::varchar,1,7) = substr(v_fe_report,1,7)
			group by fecha order by fecha

		loop 
			return next v_va_return; 
		end loop; 

	elsif(v_ti_report = 'HORA') then
		for v_va_return in 
			select  substr(time::varchar(14),12,2) as fecha, 
				sum(1) as lla_entra, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') THEN 1 ELSE 0 END) as lla_atendi, 
				sum(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') and data1::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as llam_atetab, 
				sum(case when event = 'ABANDON' THEN 1 ELSE 0 END) as lla_abando, 
				sum(case when event = 'ABANDON' and data3::INTEGER <= v_va_tab THEN 1 ELSE 0 END) as lla_abatab, 
				sum(case when event = 'EXITWITHTIMEOUT' THEN 1 ELSE 0 END) as lla_disuac, 
				sum(case when event in ('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') and data1::INTEGER <= v_va_ns THEN 1 ELSE 0 END) as lla_atens, 
				sum(case when (event = 'COMPLETECALLER' or event = 'COMPLETEAGENT') and data2 not in ('1','2') then data2::INTEGER else 0 end) / sum(1) as ti_procon, 
				sum(int4(data1))/ sum(1) as ti_proesp, 
				max(case when event in('COMPLETECALLER','COMPLETEAGENT') and data2 not in ('1','2') then data1::INTEGER else 0 end ) as ti_ema,  
				max(case when event = 'ABANDON' then data3::INTEGER else 0 end) as ti_abando  
			from asterisk.callcenter
			where event in ('COMPLETECALLER','COMPLETEAGENT','ABANDON', 'EXITWITHTIMEOUT') 
			and queuename like v_va_cola
			and substr(time::varchar,1,10) = substr(v_fe_report,1,10)
            group by fecha order by fecha

		loop 
			return next v_va_return; 
		end loop; 
 
	end if;

	return; 
END;
$$;


ALTER FUNCTION reportes.respuesta_operador(p_ti_report character varying, p_va_tab integer, p_va_nsv integer, p_fe_report character varying, p_no_queue character varying) OWNER TO tintegro;

--
-- TOC entry 411 (class 1255 OID 70616)
-- Name: rpt_comparativo_abandonos(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION rpt_comparativo_abandonos(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF rpt_comparativo_colas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.rpt_comparativo_colas%rowtype;
 v_nu_dias integer := 0;
 v_intervalo varchar;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 select v_feini::date - v_fefin::date into v_nu_dias ; 

 v_intervalo := v_nu_dias::varchar ;
 
 --RAISE  'Entro(%)', v_intervalo;
	
 for v_va_return in 

select row_number() OVER (order by dia_real) AS id, * from (
select 1 as tipo,queuename,
extract(DAY from "time")::integer as dia,
substr("time"::varchar,1,10)-- || ' / ' || substr(("time" - interval '30 day')::varchar,1,10) 
as dia_real,
count(*)
from asterisk.callcenter 
where "time"::date  between v_feini::date and v_feini::date + integer '7'
and queuename like v_queuename
and event in ('ABANDON')
group by queuename, extract(DAY from "time"), substr("time"::varchar,1,10), substr(("time"::date -  v_nu_dias  )::varchar,1,10)
union
select 2 as tipo,queuename,
extract(day from ("time"::date + v_nu_dias )) as dia,
substr(("time"::date + v_nu_dias )::varchar,1,10)-- || ' / ' ||  substr("time"::varchar,1,10) 
as dia_real,
count(*)
from asterisk.callcenter 
where "time"  between v_fefin::date and v_fefin::date + integer '7' 
and queuename like v_queuename
and event in ('ABANDON')
group by queuename, extract(day from ("time"::date +  v_nu_dias )), substr("time"::varchar,1,10), substr(("time"::date +  v_nu_dias  )::varchar,1,10)
) as t

 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.rpt_comparativo_abandonos(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 466 (class 1255 OID 70617)
-- Name: rpt_comparativo_colas(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION rpt_comparativo_colas(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF rpt_comparativo_colas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.rpt_comparativo_colas%rowtype;
 v_nu_dias integer := 0;
 v_intervalo varchar;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 select v_feini::date - v_fefin::date into v_nu_dias ; 

 v_intervalo := v_nu_dias::varchar ;
 
 --RAISE  'Entro(%)', v_intervalo;
	
 for v_va_return in 

select row_number() OVER (order by dia_real) AS id, * from (
select 1 as tipo,queuename,
extract(DAY from "time")::integer as dia,
substr("time"::varchar,1,10)-- || ' / ' || substr(("time" - interval '30 day')::varchar,1,10) 
as dia_real,
count(*)
from asterisk.callcenter 
where "time"::date  between v_feini::date and v_feini::date + integer '7'
and queuename like v_queuename
and event in ('COMPLETECALLER', 'COMPLETEAGENT')
group by queuename, extract(DAY from "time"), substr("time"::varchar,1,10), substr(("time"::date -  v_nu_dias  )::varchar,1,10)
union
select 2 as tipo,queuename,
extract(day from ("time"::date + v_nu_dias )) as dia,
substr(("time"::date + v_nu_dias )::varchar,1,10)-- || ' / ' ||  substr("time"::varchar,1,10) 
as dia_real,
count(*)
from asterisk.callcenter 
where "time"  between v_fefin::date and v_fefin::date + integer '7' 
and queuename like v_queuename
and event in ('COMPLETECALLER', 'COMPLETEAGENT')
group by queuename, extract(day from ("time"::date +  v_nu_dias )), substr("time"::varchar,1,10), substr(("time"::date +  v_nu_dias  )::varchar,1,10)
) as t

 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.rpt_comparativo_colas(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 386 (class 1255 OID 70618)
-- Name: rpt_llamadas_abandonadas(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION rpt_llamadas_abandonadas(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF rpt_llamadas_abandonadas
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.rpt_llamadas_abandonadas%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

select
row_number() OVER (order by "time"::date) AS id,
queuename ,
"time"::date,
sum(case when data3::integer < 31 then 1 else 0 end) as  "30" ,
sum(case when data3::integer > 29 and data3::integer < 46 then 1 else 0 end) as  "45" ,
sum(case when data3::integer > 44 and data3::integer < 61 then 1 else 0 end) as  "60" 
from asterisk.callcenter
where "time"::date between v_feini::date AND v_fefin::date 
AND queuename like v_queuename
and event = 'ABANDON'
group by queuename ,"time"::date

 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.rpt_llamadas_abandonadas(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 467 (class 1255 OID 70619)
-- Name: rpt_nivel_servicio(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION rpt_nivel_servicio(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF rpt_nivel_servicio
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.rpt_nivel_servicio%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

select fecha,
queuename,
total,
a10s, a10s*100/total as ns10,
a20s, a20s*100/total as ns20,
a30s, a30s*100/total as ns30,
a40s, a40s*100/total as ns40,
a50s, a50s*100/total as ns50,
a60s, a60s*100/total as ns60
from(
select "time"::date as fecha,
queuename,
count(*) as total,
sum(case when data1::integer < 11 then 1 else 0 end) as a10s,
sum(case when data1::integer < 21 then 1 else 0 end) as a20s,
sum(case when data1::integer < 31 then 1 else 0 end) as a30s,
sum(case when data1::integer < 41 then 1 else 0 end) as a40s,
sum(case when data1::integer < 51 then 1 else 0 end) as a50s,
sum(case when data1::integer < 61 then 1 else 0 end) as a60s
from asterisk.callcenter 
where "time"::date between v_feini::date AND v_fefin::date 
AND queuename like v_queuename
and event in ('COMPLETECALLER', 'COMPLETEAGENT')
group by "time"::date ,queuename
order by 1
) as t

 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.rpt_nivel_servicio(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 412 (class 1255 OID 70620)
-- Name: tiempo_promedio_conversacion(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION tiempo_promedio_conversacion(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF tiempo_espera
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_nu_mes integer := p_nu_mes;
 v_nu_ano integer := p_nu_ano;
 v_va_return reportes.tiempo_espera%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  SELECT
  reportes.formato_tiempo(avg(data2::numeric)) ,
  reportes.formato_tiempo(min(data2::numeric)) ,
  reportes.formato_tiempo(max(data2::numeric))
  FROM 
  asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER')
  and data2 not in ('1','2')
  AND queuename like v_queuename
  and extract(month from  "time")::integer = v_nu_mes
  and extract(year from  "time")::integer = v_nu_ano
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.tiempo_promedio_conversacion(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 413 (class 1255 OID 70621)
-- Name: tiempo_promedio_conversacion_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION tiempo_promedio_conversacion_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF tiempo_espera
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.tiempo_espera%rowtype;
BEGIN

 v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

 for v_va_return in 

  SELECT
  reportes.formato_tiempo(avg(data2::numeric)) ,
  reportes.formato_tiempo(min(data2::numeric)) ,
  reportes.formato_tiempo(max(data2::numeric))
  FROM 
  asterisk.callcenter 
  where event in ('COMPLETEAGENT', 'COMPLETECALLER')
  --and data2 not in ('1','2')
  AND queuename like v_queuename
   and "time"::date between v_feini::date and v_fefin::date
 
 loop 
  return next v_va_return; 
 end loop; 
 
 return;
END;
$$;


ALTER FUNCTION reportes.tiempo_promedio_conversacion_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

--
-- TOC entry 414 (class 1255 OID 70622)
-- Name: tiempo_promedio_espera(character varying, integer, integer); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION tiempo_promedio_espera(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) RETURNS SETOF tiempo_espera
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
  v_nu_mes integer := p_nu_mes;
  v_nu_ano integer := p_nu_ano;
 v_va_return reportes.tiempo_espera%rowtype;
BEGIN

v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

for v_va_return in 

SELECT
reportes.formato_tiempo(avg(data1::numeric)) ,
reportes.formato_tiempo(min(data1::numeric)) ,
reportes.formato_tiempo(max(data1::numeric))
FROM 
asterisk.callcenter 
where event in ('COMPLETEAGENT', 'COMPLETECALLER') 
and data2 not in ('1','2')
AND queuename like v_queuename
and extract(month from  "time")::integer = v_nu_mes
and extract(year from  "time")::integer = v_nu_ano
 
loop 
return next v_va_return; 
end loop; 
return;
END;
$$;


ALTER FUNCTION reportes.tiempo_promedio_espera(p_queuename character varying, p_nu_mes integer, p_nu_ano integer) OWNER TO tintegro;

--
-- TOC entry 415 (class 1255 OID 70623)
-- Name: tiempo_promedio_espera_rango(character varying, date, date); Type: FUNCTION; Schema: reportes; Owner: tintegro
--

CREATE FUNCTION tiempo_promedio_espera_rango(p_queuename character varying, p_feini date, p_fefin date) RETURNS SETOF tiempo_espera
    LANGUAGE plpgsql
    AS $$
DECLARE
 v_queuename varchar:=p_queuename; --Nombre de la cola
 v_feini date := p_feini;
 v_fefin date := p_fefin;
 v_va_return reportes.tiempo_espera%rowtype;
BEGIN

v_queuename := case when v_queuename = '' or v_queuename is null then '%' else v_queuename end;

for v_va_return in 

SELECT
case when reportes.formato_tiempo(avg(data1::numeric)) is null then 'ne' else reportes.formato_tiempo(avg(data1::numeric)) end ,
case when reportes.formato_tiempo(min(data1::numeric)) is null then 'ne' else reportes.formato_tiempo(min(data1::numeric)) end ,
case when reportes.formato_tiempo(max(data1::numeric)) is null then 'ne' else reportes.formato_tiempo(max(data1::numeric)) end
FROM 
asterisk.callcenter 
where event in ('COMPLETEAGENT', 'COMPLETECALLER') 
--and data2 not in ('1','2')
AND queuename like v_queuename
  and "time"::date between v_feini::date and v_fefin::date
 
loop 
return next v_va_return; 
end loop; 
return;
END;
$$;


ALTER FUNCTION reportes.tiempo_promedio_espera_rango(p_queuename character varying, p_feini date, p_fefin date) OWNER TO tintegro;

SET search_path = seguridad, pg_catalog;

--
-- TOC entry 418 (class 1255 OID 70624)
-- Name: actualiza_password(); Type: FUNCTION; Schema: seguridad; Owner: tintegro
--

CREATE FUNCTION actualiza_password() RETURNS trigger
    LANGUAGE plpgsql STRICT
    AS $$
BEGIN
     
	if (TG_OP = 'INSERT') then
		NEW.no_passwo := md5(NEW.no_passwo);
		elsif(NEW.no_passwo <> OLD.no_passwo) then
		  NEW.no_passwo := md5(NEW.no_passwo);
	end if;
  
return new;        
END;
$$;


ALTER FUNCTION seguridad.actualiza_password() OWNER TO tintegro;

--
-- TOC entry 181 (class 1259 OID 66927)
-- Name: usuari_id_usuari_seq; Type: SEQUENCE; Schema: seguridad; Owner: tintegro
--

CREATE SEQUENCE usuari_id_usuari_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuari_id_usuari_seq OWNER TO tintegro;

SET default_tablespace = '';

SET default_with_oids = true;

--
-- TOC entry 182 (class 1259 OID 66929)
-- Name: usuari; Type: TABLE; Schema: seguridad; Owner: tintegro
--

CREATE TABLE usuari (
    id_usuari integer DEFAULT nextval('usuari_id_usuari_seq'::regclass) NOT NULL,
    no_login character varying(15) NOT NULL,
    no_passwo character varying(32) NOT NULL,
    no_nombre character varying(20) NOT NULL,
    no_apelli character varying(40) NOT NULL,
    no_email character varying(50) NOT NULL,
    no_profe character varying(50),
    id_rolusu integer NOT NULL,
    il_activo boolean DEFAULT true NOT NULL,
    fe_creaci date DEFAULT ('now'::text)::date
);


ALTER TABLE usuari OWNER TO tintegro;

--
-- TOC entry 416 (class 1255 OID 70625)
-- Name: get_usuari_entity(); Type: FUNCTION; Schema: seguridad; Owner: tintegro
--

CREATE FUNCTION get_usuari_entity() RETURNS SETOF usuari
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return seguridad.usuari%rowtype;

 BEGIN

  for v_va_return in 
  
      SELECT us.* from seguridad.usuari us
      
    loop 
     return next v_va_return; 
     end loop; 
    return;

END;
$$;


ALTER FUNCTION seguridad.get_usuari_entity() OWNER TO tintegro;

--
-- TOC entry 417 (class 1255 OID 70626)
-- Name: get_usuari_entity(character varying, character varying); Type: FUNCTION; Schema: seguridad; Owner: tintegro
--

CREATE FUNCTION get_usuari_entity(p_no_login character varying, p_no_passwo character varying) RETURNS SETOF usuari
    LANGUAGE plpgsql
    AS $$
DECLARE 
 v_va_return seguridad.usuari%rowtype;

 BEGIN

  for v_va_return in 
  
      SELECT us.* from seguridad.usuari us
      WHERE us.no_login = p_no_login
      AND us.no_passwo = p_no_passwo
      
    loop 
     return next v_va_return; 
     end loop; 
    return;

END;
$$;


ALTER FUNCTION seguridad.get_usuari_entity(p_no_login character varying, p_no_passwo character varying) OWNER TO tintegro;

SET search_path = asterisk, pg_catalog;

--
-- TOC entry 183 (class 1259 OID 66935)
-- Name: agente_id_agente_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE agente_id_agente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE agente_id_agente_seq OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 66937)
-- Name: agente; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE agente (
    id_agente integer DEFAULT nextval('agente_id_agente_seq'::regclass) NOT NULL,
    nu_agente bigint NOT NULL,
    no_apepat text,
    no_apemat text,
    no_nombre text,
    no_cid text,
    nu_cid character varying(10),
    nu_pin integer,
    no_context text,
    il_status boolean DEFAULT false,
    no_locacion text,
    nu_accion smallint DEFAULT 1,
    il_desllam boolean DEFAULT false,
    nu_desllam character varying(20),
    il_limtiem boolean DEFAULT false,
    va_tiellam integer,
    il_grallam boolean DEFAULT false,
    co_estado smallint DEFAULT 2 NOT NULL,
    il_usutel boolean DEFAULT false,
    no_usutel character varying(25),
    no_passtel character varying,
    nu_agetel character varying(25),
    il_activo smallint DEFAULT 1 NOT NULL,
    es_usuari integer DEFAULT 0
);


ALTER TABLE agente OWNER TO tintegro;

--
-- TOC entry 185 (class 1259 OID 66953)
-- Name: agente_por_cola; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE agente_por_cola (
    id_agecola integer NOT NULL,
    id_cola integer NOT NULL,
    nu_prorid smallint
);


ALTER TABLE agente_por_cola OWNER TO tintegro;

--
-- TOC entry 186 (class 1259 OID 66956)
-- Name: callcenter; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE callcenter (
    "time" timestamp(0) without time zone,
    callid character varying(50),
    queuename character varying(50),
    agent character varying(50),
    event character varying(20),
    data character varying(50),
    data1 character varying(50),
    data2 character varying(50),
    data3 character varying(50),
    data4 character varying(50),
    data5 character varying(50),
    index character varying(50)
);


ALTER TABLE callcenter OWNER TO tintegro;

--
-- TOC entry 187 (class 1259 OID 66959)
-- Name: callcenter_id_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE callcenter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE callcenter_id_seq OWNER TO tintegro;

--
-- TOC entry 188 (class 1259 OID 66961)
-- Name: callcenter_old; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE callcenter_old (
    qtime time without time zone,
    qdate date,
    qname text,
    agent text,
    action text,
    info1 text,
    info2 text,
    info3 text,
    uniqueid text,
    id integer DEFAULT nextval('callcenter_id_seq'::regclass)
);


ALTER TABLE callcenter_old OWNER TO tintegro;

--
-- TOC entry 189 (class 1259 OID 66968)
-- Name: campana_id_campan_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE campana_id_campan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE campana_id_campan_seq OWNER TO tintegro;

--
-- TOC entry 190 (class 1259 OID 66970)
-- Name: campana; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE campana (
    id_campan integer DEFAULT nextval('campana_id_campan_seq'::regclass) NOT NULL,
    no_campan text,
    ti_campan smallint
);


ALTER TABLE campana OWNER TO tintegro;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 190
-- Name: COLUMN campana.ti_campan; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN campana.ti_campan IS 'tipo de campaÒa';


--
-- TOC entry 191 (class 1259 OID 66977)
-- Name: cdr_id_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE cdr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cdr_id_seq OWNER TO tintegro;

--
-- TOC entry 192 (class 1259 OID 66979)
-- Name: cdr; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE cdr (
    id bigint DEFAULT nextval('cdr_id_seq'::regclass) NOT NULL,
    calldate timestamp with time zone,
    clid character varying(80),
    src character varying(80),
    dst character varying(80),
    dcontext character varying(80),
    channel character varying(80),
    dstchannel character varying(80),
    lastapp character varying(80),
    lastdata character varying(80),
    duration bigint,
    billsec bigint,
    disposition character varying(45),
    amaflags bigint,
    accountcode character varying(20),
    uniqueid character varying(40),
    userfield character varying(255),
    id_usuario integer,
    id_area integer
);


ALTER TABLE cdr OWNER TO tintegro;

--
-- TOC entry 193 (class 1259 OID 66983)
-- Name: cel; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE cel (
    eventtime timestamp without time zone NOT NULL,
    userdeftype character varying(255) NOT NULL,
    cid_name character varying(80) NOT NULL,
    cid_num character varying(80) NOT NULL,
    cid_ani character varying(80) NOT NULL,
    cid_rdnis character varying(80) NOT NULL,
    cid_dnid character varying(80) NOT NULL,
    exten character varying(80) NOT NULL,
    context character varying(80) NOT NULL,
    channame character varying(80) NOT NULL,
    appname character varying(80) NOT NULL,
    appdata character varying(80) NOT NULL,
    accountcode character varying(20) NOT NULL,
    peeraccount character varying(20) NOT NULL,
    uniqueid character varying(150) NOT NULL,
    linkedid character varying(150) NOT NULL,
    amaflags integer NOT NULL,
    userfield character varying(255) NOT NULL,
    peer character varying(80) NOT NULL
);


ALTER TABLE cel OWNER TO tintegro;

--
-- TOC entry 194 (class 1259 OID 66986)
-- Name: empresa_area_id_empare_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE empresa_area_id_empare_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa_area_id_empare_seq OWNER TO tintegro;

--
-- TOC entry 195 (class 1259 OID 66988)
-- Name: empresa_area; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE empresa_area (
    id_empare integer DEFAULT nextval('empresa_area_id_empare_seq'::regclass) NOT NULL,
    nombre character varying(100),
    tipo integer,
    id_padre integer,
    il_activo boolean DEFAULT true NOT NULL,
    il_elimina boolean DEFAULT true
);


ALTER TABLE empresa_area OWNER TO tintegro;

--
-- TOC entry 196 (class 1259 OID 66993)
-- Name: extensions_table_id_extens_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE extensions_table_id_extens_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE extensions_table_id_extens_seq OWNER TO tintegro;

--
-- TOC entry 197 (class 1259 OID 66995)
-- Name: extensions_table; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE extensions_table (
    id_extens integer DEFAULT nextval('extensions_table_id_extens_seq'::regclass) NOT NULL,
    context character varying(255) DEFAULT 'anexos'::character varying NOT NULL,
    exten character varying(255) NOT NULL,
    priority smallint NOT NULL,
    app character varying(255) NOT NULL,
    appdata character varying(128)
);


ALTER TABLE extensions_table OWNER TO tintegro;

--
-- TOC entry 198 (class 1259 OID 67000)
-- Name: file_astersik; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE file_astersik (
    nombre character varying(50) NOT NULL,
    patch character varying(150),
    patch_copy character varying(150),
    descripcion character varying(150),
    fecha character varying(50),
    comando character varying(80)
);


ALTER TABLE file_astersik OWNER TO tintegro;

--
-- TOC entry 199 (class 1259 OID 67003)
-- Name: iax_buddies_id_iaxbud_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_buddies_id_iaxbud_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_buddies_id_iaxbud_seq OWNER TO tintegro;

--
-- TOC entry 200 (class 1259 OID 67005)
-- Name: iax_buddies; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE iax_buddies (
    id_iaxbud integer DEFAULT nextval('iax_buddies_id_iaxbud_seq'::regclass) NOT NULL,
    no_iaxbud character varying NOT NULL,
    ti_iaxbud character varying DEFAULT 'friend'::character varying,
    no_hosts character varying,
    il_qualif character(3) DEFAULT 'yes'::bpchar,
    no_contex character varying DEFAULT 'default'::character varying,
    no_pasiax character varying,
    no_disall character varying DEFAULT 'all'::character varying,
    no_allow character varying DEFAULT 'ulaw;alaw'::character varying,
    il_permit boolean DEFAULT false
);


ALTER TABLE iax_buddies OWNER TO tintegro;

--
-- TOC entry 201 (class 1259 OID 67018)
-- Name: iax_buddies_id_iax_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_buddies_id_iax_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_buddies_id_iax_seq OWNER TO tintegro;

--
-- TOC entry 202 (class 1259 OID 67020)
-- Name: iax_dialplan_id_iaxdia_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_dialplan_id_iaxdia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_dialplan_id_iaxdia_seq OWNER TO tintegro;

--
-- TOC entry 203 (class 1259 OID 67022)
-- Name: iax_dialplan; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE iax_dialplan (
    id_iaxdia integer DEFAULT nextval('iax_dialplan_id_iaxdia_seq'::regclass) NOT NULL,
    id_iaxtru integer,
    no_iaxrut character varying,
    no_iaxdes character varying,
    fe_iaxcre date,
    no_iaxpri integer
);


ALTER TABLE iax_dialplan OWNER TO tintegro;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN iax_dialplan.fe_iaxcre; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_dialplan.fe_iaxcre IS 'fecha de creacion';


--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN iax_dialplan.no_iaxpri; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_dialplan.no_iaxpri IS 'prioridad de plan de marcacion';


--
-- TOC entry 204 (class 1259 OID 67029)
-- Name: iax_ip_id_iaxip_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_ip_id_iaxip_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_ip_id_iaxip_seq OWNER TO tintegro;

--
-- TOC entry 205 (class 1259 OID 67031)
-- Name: iax_ip; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE iax_ip (
    id_iaxip integer DEFAULT nextval('iax_ip_id_iaxip_seq'::regclass) NOT NULL,
    id_iaxbud integer NOT NULL,
    no_iaxip character varying
);


ALTER TABLE iax_ip OWNER TO tintegro;

--
-- TOC entry 206 (class 1259 OID 67038)
-- Name: iax_red_id_iaxred_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_red_id_iaxred_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_red_id_iaxred_seq OWNER TO tintegro;

--
-- TOC entry 207 (class 1259 OID 67040)
-- Name: iax_red; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE iax_red (
    id_iaxred integer DEFAULT nextval('iax_red_id_iaxred_seq'::regclass) NOT NULL,
    id_iaxbud integer NOT NULL,
    no_iaxred character varying
);


ALTER TABLE iax_red OWNER TO tintegro;

--
-- TOC entry 208 (class 1259 OID 67047)
-- Name: iax_trunk_id_iaxtru_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE iax_trunk_id_iaxtru_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE iax_trunk_id_iaxtru_seq OWNER TO tintegro;

--
-- TOC entry 209 (class 1259 OID 67049)
-- Name: iax_trunk; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE iax_trunk (
    id_iaxtru integer DEFAULT nextval('iax_trunk_id_iaxtru_seq'::regclass) NOT NULL,
    no_iaxtru character varying NOT NULL,
    ti_iaxtru character varying NOT NULL,
    no_iaxusu character varying NOT NULL,
    no_iaxpas character varying NOT NULL,
    no_iaxip character varying NOT NULL,
    no_iaxqua character varying NOT NULL,
    ti_usoiax integer DEFAULT 1 NOT NULL
);


ALTER TABLE iax_trunk OWNER TO tintegro;

--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.no_iaxtru; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.no_iaxtru IS 'NOMBRE TRONCAL';


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.ti_iaxtru; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.ti_iaxtru IS 'TIPO TRONCAL: FRIEN, USER o PEER';


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.no_iaxusu; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.no_iaxusu IS 'NOMBRE DE USUARIO';


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.no_iaxpas; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.no_iaxpas IS 'PASSWORD DE TRONCAL';


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.no_iaxip; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.no_iaxip IS 'IP DE TRONCAL';


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 209
-- Name: COLUMN iax_trunk.no_iaxqua; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN iax_trunk.no_iaxqua IS 'QUALIFY: YES o NO';


--
-- TOC entry 210 (class 1259 OID 67057)
-- Name: queue_datos_call; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_datos_call (
    id_datos integer NOT NULL,
    queue_name character varying(128),
    tmp_minimo character varying(20),
    tmp_medio character varying(20),
    tmp_maximo character varying(20),
    no_correo character varying(100),
    nu_anexo character varying(80)
);


ALTER TABLE queue_datos_call OWNER TO tintegro;

--
-- TOC entry 211 (class 1259 OID 67060)
-- Name: queue_datos_call_id_datos_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE queue_datos_call_id_datos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE queue_datos_call_id_datos_seq OWNER TO tintegro;

--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 211
-- Name: queue_datos_call_id_datos_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE queue_datos_call_id_datos_seq OWNED BY queue_datos_call.id_datos;


--
-- TOC entry 212 (class 1259 OID 67062)
-- Name: queue_member_table; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_member_table (
    uniqueid integer NOT NULL,
    membername character varying(40),
    queue_name character varying(128),
    interface character varying(128),
    penalty integer,
    paused integer,
    id_agente integer,
    no_alias character varying,
    fe_creacion timestamp(0) without time zone DEFAULT ('now'::text)::timestamp(0) with time zone
);


ALTER TABLE queue_member_table OWNER TO tintegro;

--
-- TOC entry 213 (class 1259 OID 67069)
-- Name: queue_member_table_uniqueid_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE queue_member_table_uniqueid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE queue_member_table_uniqueid_seq OWNER TO tintegro;

--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 213
-- Name: queue_member_table_uniqueid_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE queue_member_table_uniqueid_seq OWNED BY queue_member_table.uniqueid;


--
-- TOC entry 214 (class 1259 OID 67071)
-- Name: queue_members_id_queuem_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE queue_members_id_queuem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE queue_members_id_queuem_seq OWNER TO tintegro;

--
-- TOC entry 215 (class 1259 OID 67073)
-- Name: queue_members; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_members (
    id_queuem integer DEFAULT nextval('queue_members_id_queuem_seq'::regclass) NOT NULL,
    queue_name character varying(128) NOT NULL,
    interface character varying(128) NOT NULL,
    penalty integer,
    membername character varying(40),
    paused smallint DEFAULT 0,
    id_agente integer
);


ALTER TABLE queue_members OWNER TO tintegro;

--
-- TOC entry 216 (class 1259 OID 67078)
-- Name: queue_por_campana; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_por_campana (
    id_queues integer NOT NULL,
    id_campan integer NOT NULL,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE queue_por_campana OWNER TO tintegro;

--
-- TOC entry 217 (class 1259 OID 67082)
-- Name: queue_strategy; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_strategy (
    no_strategy character varying(50) NOT NULL,
    il_strategy smallint DEFAULT 1 NOT NULL
);


ALTER TABLE queue_strategy OWNER TO tintegro;

--
-- TOC entry 218 (class 1259 OID 67086)
-- Name: queue_table; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queue_table (
    name character varying(128) NOT NULL,
    musiconhold character varying(128),
    announce character varying(128),
    context character varying(128),
    strategy character varying(128),
    servicelevel integer,
    penaltymemberslimit integer,
    timeout integer,
    retry integer,
    timeoutpriority character varying(128) DEFAULT NULL::character varying,
    weight integer,
    wrapuptime integer,
    autofill character varying(128) DEFAULT NULL::character varying,
    autopause character varying(128) DEFAULT NULL::character varying,
    maxlen integer,
    setinterfacevar character varying(3) DEFAULT NULL::character varying,
    setqueueentryvar character varying(3) DEFAULT NULL::character varying,
    setqueuevar character varying(3) DEFAULT NULL::character varying,
    membermacro character varying(128) DEFAULT NULL::character varying,
    "announce-frequency" integer,
    "min-announce-frequency" integer,
    "periodic-announce-frequency" integer,
    "random-periodic-announce" character varying(3) DEFAULT NULL::character varying,
    "relative-periodic-announce" character varying(3) DEFAULT NULL::character varying,
    "announce-holdtime" character varying(4) DEFAULT NULL::character varying,
    "announce-position" character varying(4) DEFAULT NULL::character varying,
    "announce-position-limit" integer,
    "announce-round-seconds" integer,
    "queue-youarenext" character varying(128) DEFAULT NULL::character varying,
    "queue-thereare" character varying(128) DEFAULT NULL::character varying,
    "queue-callswaiting" character varying(128) DEFAULT NULL::character varying,
    "queue-holdtime" character varying(128) DEFAULT NULL::character varying,
    "queue-minute" character varying(128) DEFAULT NULL::character varying,
    "queue-minutes" character varying(128) DEFAULT NULL::character varying,
    "queue-seconds" character varying(128) DEFAULT NULL::character varying,
    "queue-thankyou" character varying(128) DEFAULT NULL::character varying,
    "queue-reporthold" character varying(128) DEFAULT NULL::character varying,
    "periodic-announce" character varying(512) DEFAULT NULL::character varying,
    "monitor-format" character varying(128) DEFAULT NULL::character varying,
    "monitor-type" character varying(128) DEFAULT NULL::character varying,
    joinempty character varying(128) DEFAULT NULL::character varying,
    leavewhenempty character varying(128) DEFAULT NULL::character varying,
    eventwhencalled character varying(128) DEFAULT NULL::character varying,
    eventmemberstatus character varying(128) DEFAULT NULL::character varying,
    reportholdtime character varying(128) DEFAULT NULL::character varying,
    ringinuse character varying(3) DEFAULT NULL::character varying,
    memberdelay integer,
    timeoutrestart character varying(128) DEFAULT NULL::character varying,
    defaultrule character varying(128) DEFAULT NULL::character varying
);


ALTER TABLE queue_table OWNER TO tintegro;

--
-- TOC entry 219 (class 1259 OID 67123)
-- Name: queues_id_queues_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE queues_id_queues_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE queues_id_queues_seq OWNER TO tintegro;

--
-- TOC entry 220 (class 1259 OID 67125)
-- Name: queues; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE queues (
    id_queues integer DEFAULT nextval('queues_id_queues_seq'::regclass) NOT NULL,
    name character varying(128) NOT NULL,
    musiconhold character varying(128),
    announce character varying(128),
    context character varying(128),
    timeout integer,
    "monitor-join" character(3),
    "monitor-format" character varying(128),
    "queue-youarenext" character varying(128),
    "queue-thereare" character varying(128),
    "queue-callswaiting" character varying(128),
    "queue-holdtime" character varying(128),
    "queue-minutes" character varying(128),
    "queue-seconds" character varying(128),
    "queue-lessthan" character varying(128),
    "queue-thankyou" character varying(128),
    "queue-reporthold" character varying(128),
    "announce-frequency" integer,
    "announce-round-seconds" integer,
    "announce-holdtime" character varying(128),
    retry integer,
    wrapuptime integer,
    maxlen integer,
    servicelevel integer,
    strategy character varying(128),
    joinempty character varying(128),
    leavewhenempty character varying(128),
    eventmemberstatus character(3),
    eventwhencalled character(3),
    reportholdtime character(3),
    memberdelay integer,
    weight integer,
    timeoutrestart character(3),
    ringinuse character(3) DEFAULT 'no'::bpchar NOT NULL,
    "announce-periodic" character varying(255)
);


ALTER TABLE queues OWNER TO tintegro;

--
-- TOC entry 221 (class 1259 OID 67133)
-- Name: sip_buddies_id_sip_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE sip_buddies_id_sip_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sip_buddies_id_sip_seq OWNER TO tintegro;

--
-- TOC entry 222 (class 1259 OID 67135)
-- Name: sip_buddies; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE sip_buddies (
    id_sip integer DEFAULT nextval('sip_buddies_id_sip_seq'::regclass) NOT NULL,
    name character varying(80) NOT NULL,
    type character varying(6) DEFAULT 'friend'::character varying NOT NULL,
    fullcontact character varying(128),
    regseconds integer DEFAULT 0,
    ipaddr character varying(15),
    musicclass character varying(80),
    relaxdtmf character(3),
    usereqphone character(3),
    compactheaders character(3),
    callevents character(3),
    ignoreregexpire character(3) DEFAULT 'yes'::bpchar,
    context character varying(80) DEFAULT 'default'::character varying,
    callingpres character varying(25),
    deny character varying(95) DEFAULT '0.0.0.0/0.0.0.0'::character varying,
    permit character varying(95),
    secret character varying(80),
    md5secret character varying(80),
    dtmfmode character varying(20),
    canreinvite character(3),
    nat character varying(20),
    callgroup character varying(10),
    pickupgroup character varying(10),
    language character(2),
    disallow character varying(100) DEFAULT 'all'::character varying,
    allow character varying(100) DEFAULT 'alaw;gsm;g729;ulaw'::character varying,
    insecure character varying(6),
    trustrpid character(3),
    progressinband character varying(5),
    promiscredir character(3),
    useclientcode character(3),
    accountcode character varying(20),
    setvar character varying(100),
    callerid character varying(80),
    amaflags character varying(100),
    "call-limit" character(3),
    restrictcid character(3),
    allowoverlap character(3),
    allowsubscribe character(3),
    subscribecontext character varying(80),
    videosupport character(3),
    maxcallbitrate character varying(4) DEFAULT 384,
    mailbox character varying(100),
    username character varying(80),
    template character varying(80),
    fromdomain character varying(80),
    regexten character varying(80),
    fromuser character varying(80),
    host character varying(31),
    port character varying(5),
    qualify character varying(5),
    defaultip character varying(15),
    rtptimeout character(3),
    rtpholdtimeout character(3),
    sendrpid character(3),
    regserver character varying(100),
    usecallingpres character varying(3),
    uso integer DEFAULT 1,
    lastms character varying(80),
    allow_codec_video character varying(16) DEFAULT 'h264'::character varying,
    no_transport character varying(10),
    no_ecryption character varying(10)
);


ALTER TABLE sip_buddies OWNER TO tintegro;

--
-- TOC entry 223 (class 1259 OID 67152)
-- Name: sip_buddies_aprov; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE sip_buddies_aprov (
    id_aprov integer NOT NULL,
    id_sip integer NOT NULL,
    nu_mac character varying(17),
    nu_serie character varying(50),
    nu_ip character varying(50),
    id_modelo integer,
    no_vlan integer,
    no_passwd character varying(50),
    no_mascara character varying(50),
    no_subnet character varying(50),
    no_broadcast character varying(50),
    no_router character varying(50),
    nu_ipcentral character varying(50),
    nu_ipmedial character varying(50),
    no_dns1 character varying(50),
    no_dns2 character varying(50)
);


ALTER TABLE sip_buddies_aprov OWNER TO tintegro;

--
-- TOC entry 224 (class 1259 OID 67155)
-- Name: sip_buddies_aprov_id_aprov_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE sip_buddies_aprov_id_aprov_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sip_buddies_aprov_id_aprov_seq OWNER TO tintegro;

--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 224
-- Name: sip_buddies_aprov_id_aprov_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE sip_buddies_aprov_id_aprov_seq OWNED BY sip_buddies_aprov.id_aprov;


--
-- TOC entry 225 (class 1259 OID 67157)
-- Name: sip_trunk_id_siptru_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE sip_trunk_id_siptru_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sip_trunk_id_siptru_seq OWNER TO tintegro;

--
-- TOC entry 226 (class 1259 OID 67159)
-- Name: sip_trunk; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE sip_trunk (
    id_siptru integer DEFAULT nextval('sip_trunk_id_siptru_seq'::regclass) NOT NULL,
    no_siptru character varying NOT NULL,
    no_host character varying NOT NULL,
    no_tiptru character varying DEFAULT 'friend'::character varying,
    ti_qualify character varying,
    no_usetru character varying,
    no_pastru character varying,
    no_fromus character varying,
    no_nat character varying,
    ti_grabacion character varying,
    ti_uso integer DEFAULT 1 NOT NULL,
    no_codecs character varying NOT NULL
);


ALTER TABLE sip_trunk OWNER TO tintegro;

--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.no_tiptru; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.no_tiptru IS 'Tipo puede ser FRIEND, USER o PEER';


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.ti_qualify; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.ti_qualify IS 'YES o NO';


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.no_usetru; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.no_usetru IS 'USERNAME DE TRONCAL';


--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.no_pastru; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.no_pastru IS 'PASSWORD TRONCAL';


--
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.no_fromus; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.no_fromus IS 'FROMUSER';


--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.no_nat; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.no_nat IS 'NAT';


--
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN sip_trunk.ti_grabacion; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN sip_trunk.ti_grabacion IS 'TIPO DE GRABACION: NINGUNO, ENTRANTE o SALIENTE';


--
-- TOC entry 227 (class 1259 OID 67168)
-- Name: tb_appivr; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_appivr (
    id_appivr integer NOT NULL,
    no_appivr character varying(100),
    ti_appivr character(3),
    nu_appivr integer,
    ti_uso integer,
    va_descrip text,
    va_dialplan character varying
);


ALTER TABLE tb_appivr OWNER TO tintegro;

--
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN tb_appivr.ti_appivr; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_appivr.ti_appivr IS 'INT:interno, EXT: externo';


--
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN tb_appivr.ti_uso; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_appivr.ti_uso IS '1:Corporativo, 2:Callcenter';


--
-- TOC entry 228 (class 1259 OID 67174)
-- Name: tb_appivr_id_appivr_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_appivr_id_appivr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_appivr_id_appivr_seq OWNER TO tintegro;

--
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 228
-- Name: tb_appivr_id_appivr_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_appivr_id_appivr_seq OWNED BY tb_appivr.id_appivr;


--
-- TOC entry 229 (class 1259 OID 67176)
-- Name: tb_aprovis; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_aprovis (
    id_aprovis integer NOT NULL,
    va_dirmac character varying,
    var_dirip character varying,
    id_modelo integer,
    id_sip integer
);


ALTER TABLE tb_aprovis OWNER TO tintegro;

--
-- TOC entry 230 (class 1259 OID 67182)
-- Name: tb_aprovis_id_aprovis_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_aprovis_id_aprovis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_aprovis_id_aprovis_seq OWNER TO tintegro;

--
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 230
-- Name: tb_aprovis_id_aprovis_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_aprovis_id_aprovis_seq OWNED BY tb_aprovis.id_aprovis;


--
-- TOC entry 231 (class 1259 OID 67184)
-- Name: tb_auxcallcenter; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_auxcallcenter (
    callid character varying NOT NULL,
    data2 character varying,
    tiempo timestamp(0) without time zone
);


ALTER TABLE tb_auxcallcenter OWNER TO tintegro;

--
-- TOC entry 232 (class 1259 OID 67190)
-- Name: tb_bolsaempresa; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_bolsaempresa (
    id_empare integer NOT NULL,
    id_tiptel integer NOT NULL,
    id_clave integer NOT NULL,
    ca_minbol integer DEFAULT 0 NOT NULL,
    ca_conmin integer DEFAULT 0 NOT NULL,
    ca_resmin integer DEFAULT 0 NOT NULL,
    fe_inibol date DEFAULT ('now'::text)::date NOT NULL,
    fe_finbol date DEFAULT ('now'::text)::date NOT NULL,
    fe_ultmod date,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_bolsaempresa OWNER TO tintegro;

--
-- TOC entry 233 (class 1259 OID 67199)
-- Name: tb_bolsausuario; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_bolsausuario (
    id_usuari integer NOT NULL,
    id_tiptel integer NOT NULL,
    id_clave integer NOT NULL,
    ca_minbol integer DEFAULT 0 NOT NULL,
    ca_segbol integer DEFAULT 0 NOT NULL,
    ca_conseg integer DEFAULT 0 NOT NULL,
    ca_resseg integer DEFAULT 0 NOT NULL,
    fe_inibol date DEFAULT (now())::date NOT NULL,
    fe_finbol date,
    fe_ultmod date DEFAULT (now())::date,
    fe_ultasi character varying(7),
    il_actmes boolean DEFAULT false,
    il_activo boolean DEFAULT false NOT NULL
);


ALTER TABLE tb_bolsausuario OWNER TO tintegro;

--
-- TOC entry 3081 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.ca_minbol; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.ca_minbol IS 'Cantidad de minutos asignados por bolsa';


--
-- TOC entry 3082 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.ca_segbol; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.ca_segbol IS 'Cantidad de segundos asignados';


--
-- TOC entry 3083 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.ca_conseg; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.ca_conseg IS 'Cantidad de segundos consumidos de bolsa';


--
-- TOC entry 3084 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.ca_resseg; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.ca_resseg IS 'Cantidad restante de segundos';


--
-- TOC entry 3085 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.fe_inibol; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.fe_inibol IS 'Fecha de inicio de bolsa';


--
-- TOC entry 3086 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.fe_finbol; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.fe_finbol IS 'Fecha fin de la bolsa de minutos';


--
-- TOC entry 3087 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.fe_ultmod; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.fe_ultmod IS 'Fecha de ultima modificacion';


--
-- TOC entry 3088 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.fe_ultasi; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.fe_ultasi IS 'Fecha de ultima asignacion de bolsa de minutos';


--
-- TOC entry 3089 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.il_actmes; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.il_actmes IS 'si esta activo la actualizacion mes a mes';


--
-- TOC entry 3090 (class 0 OID 0)
-- Dependencies: 233
-- Name: COLUMN tb_bolsausuario.il_activo; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_bolsausuario.il_activo IS 'si esta activo la bolsa';


--
-- TOC entry 234 (class 1259 OID 67210)
-- Name: tb_contexto; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_contexto (
    id_contexto integer NOT NULL,
    no_contexto character varying(30),
    il_estado boolean
);


ALTER TABLE tb_contexto OWNER TO tintegro;

--
-- TOC entry 235 (class 1259 OID 67213)
-- Name: tb_contexto_id_contexto_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_contexto_id_contexto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_contexto_id_contexto_seq OWNER TO tintegro;

--
-- TOC entry 3091 (class 0 OID 0)
-- Dependencies: 235
-- Name: tb_contexto_id_contexto_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_contexto_id_contexto_seq OWNED BY tb_contexto.id_contexto;


--
-- TOC entry 236 (class 1259 OID 67215)
-- Name: tb_extensionxgrupo; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_extensionxgrupo (
    id_grupo integer NOT NULL,
    id_exten integer NOT NULL,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_extensionxgrupo OWNER TO tintegro;

--
-- TOC entry 237 (class 1259 OID 67219)
-- Name: tb_extensionxperifo; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_extensionxperifo (
    id_perifo integer NOT NULL,
    id_extens integer NOT NULL,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_extensionxperifo OWNER TO tintegro;

--
-- TOC entry 238 (class 1259 OID 67223)
-- Name: tb_grupo_id_grupo_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_grupo_id_grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_grupo_id_grupo_seq OWNER TO tintegro;

--
-- TOC entry 239 (class 1259 OID 67225)
-- Name: tb_grupo; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_grupo (
    id_grupo integer DEFAULT nextval('tb_grupo_id_grupo_seq'::regclass) NOT NULL,
    no_grupo character varying(50) NOT NULL,
    nu_grupo integer,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_grupo OWNER TO tintegro;

--
-- TOC entry 240 (class 1259 OID 67230)
-- Name: tb_ivrdet; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_ivrdet (
    id_ivrdet integer NOT NULL,
    id_appivr integer,
    id_opcivr integer,
    va_opciones character varying,
    id_parent integer,
    nu_priori integer DEFAULT 1,
    nu_subpriori integer DEFAULT 0
);


ALTER TABLE tb_ivrdet OWNER TO tintegro;

--
-- TOC entry 3092 (class 0 OID 0)
-- Dependencies: 240
-- Name: COLUMN tb_ivrdet.nu_priori; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_ivrdet.nu_priori IS 'Prioridad';


--
-- TOC entry 241 (class 1259 OID 67238)
-- Name: tb_ivrdet_id_ivrdet_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_ivrdet_id_ivrdet_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_ivrdet_id_ivrdet_seq OWNER TO tintegro;

--
-- TOC entry 3093 (class 0 OID 0)
-- Dependencies: 241
-- Name: tb_ivrdet_id_ivrdet_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_ivrdet_id_ivrdet_seq OWNED BY tb_ivrdet.id_ivrdet;


--
-- TOC entry 242 (class 1259 OID 67240)
-- Name: tb_lista_negra; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_lista_negra (
    nu_telefo character varying NOT NULL,
    no_descri character varying,
    il_activo boolean DEFAULT true NOT NULL,
    co_tipllam character varying(10) DEFAULT 'Todas'::character varying
);


ALTER TABLE tb_lista_negra OWNER TO tintegro;

--
-- TOC entry 3094 (class 0 OID 0)
-- Dependencies: 242
-- Name: COLUMN tb_lista_negra.co_tipllam; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_lista_negra.co_tipllam IS 'IN, OUT, Todas';


--
-- TOC entry 243 (class 1259 OID 67248)
-- Name: tb_meetme_id_meetme_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_meetme_id_meetme_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_meetme_id_meetme_seq OWNER TO tintegro;

--
-- TOC entry 244 (class 1259 OID 67250)
-- Name: tb_meetme; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_meetme (
    id_meetme integer DEFAULT nextval('tb_meetme_id_meetme_seq'::regclass) NOT NULL,
    no_meetme character varying NOT NULL,
    nu_meetme character(4) NOT NULL,
    nu_pasadm character(4),
    nu_pasusu character(4),
    no_rutbie character varying,
    nu_maxusu integer,
    no_varadm character varying DEFAULT 'Aa'::character varying,
    no_varusu character varying,
    no_ruthol character varying
);


ALTER TABLE tb_meetme OWNER TO tintegro;

--
-- TOC entry 3095 (class 0 OID 0)
-- Dependencies: 244
-- Name: COLUMN tb_meetme.no_rutbie; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_meetme.no_rutbie IS 'Ruta de bienvenida';


--
-- TOC entry 3096 (class 0 OID 0)
-- Dependencies: 244
-- Name: COLUMN tb_meetme.no_ruthol; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tb_meetme.no_ruthol IS 'Ruta de musica en espera';


--
-- TOC entry 245 (class 1259 OID 67258)
-- Name: tb_mushold_id_mushold_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_mushold_id_mushold_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_mushold_id_mushold_seq OWNER TO tintegro;

--
-- TOC entry 246 (class 1259 OID 67260)
-- Name: tb_mushold; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_mushold (
    id_mushold integer DEFAULT nextval('tb_mushold_id_mushold_seq'::regclass) NOT NULL,
    no_mushold character varying NOT NULL,
    des_mushold character varying NOT NULL,
    fe_creacion timestamp(0) without time zone DEFAULT ('now'::text)::timestamp without time zone NOT NULL
);


ALTER TABLE tb_mushold OWNER TO tintegro;

--
-- TOC entry 247 (class 1259 OID 67268)
-- Name: tb_musica_id_musica_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_musica_id_musica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_musica_id_musica_seq OWNER TO tintegro;

--
-- TOC entry 248 (class 1259 OID 67270)
-- Name: tb_musica; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_musica (
    id_musica integer DEFAULT nextval('tb_musica_id_musica_seq'::regclass) NOT NULL,
    no_musica character varying,
    fe_grabac timestamp(0) without time zone DEFAULT now(),
    no_ruta character varying,
    nu_priori integer DEFAULT 1,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_musica OWNER TO tintegro;

--
-- TOC entry 249 (class 1259 OID 67280)
-- Name: tb_perifoneo_id_perifo_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_perifoneo_id_perifo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_perifoneo_id_perifo_seq OWNER TO tintegro;

--
-- TOC entry 250 (class 1259 OID 67282)
-- Name: tb_perifoneo; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_perifoneo (
    id_perifo integer DEFAULT nextval('tb_perifoneo_id_perifo_seq'::regclass) NOT NULL,
    no_perifo character varying(50) NOT NULL,
    nu_perifo character varying,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_perifoneo OWNER TO tintegro;

SET default_with_oids = true;

--
-- TOC entry 251 (class 1259 OID 67290)
-- Name: tb_pin; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_pin (
    id_usupin integer NOT NULL,
    id_clave integer NOT NULL,
    id_tiptel integer NOT NULL
);


ALTER TABLE tb_pin OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 302 (class 1259 OID 70668)
-- Name: tb_sip_telefono; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_sip_telefono (
    id_sip_telefono integer NOT NULL,
    name_id_sip character varying(80),
    id_marca integer,
    id_modelo integer,
    no_mac character varying(100),
    no_ip_dominio character varying(50),
    no_ruta character varying(200)
);


ALTER TABLE tb_sip_telefono OWNER TO tintegro;

--
-- TOC entry 301 (class 1259 OID 70666)
-- Name: tb_sip_telefono_id_sip_telefono_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_sip_telefono_id_sip_telefono_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_sip_telefono_id_sip_telefono_seq OWNER TO tintegro;

--
-- TOC entry 3097 (class 0 OID 0)
-- Dependencies: 301
-- Name: tb_sip_telefono_id_sip_telefono_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_sip_telefono_id_sip_telefono_seq OWNED BY tb_sip_telefono.id_sip_telefono;


--
-- TOC entry 252 (class 1259 OID 67298)
-- Name: tb_troncal; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_troncal (
    id_troncal integer NOT NULL,
    no_protocol character varying(30),
    no_troncal character varying(30),
    no_desc character varying(100)
);


ALTER TABLE tb_troncal OWNER TO tintegro;

--
-- TOC entry 253 (class 1259 OID 67301)
-- Name: tb_troncal_id_troncal_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_troncal_id_troncal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_troncal_id_troncal_seq OWNER TO tintegro;

--
-- TOC entry 3098 (class 0 OID 0)
-- Dependencies: 253
-- Name: tb_troncal_id_troncal_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_troncal_id_troncal_seq OWNED BY tb_troncal.id_troncal;


--
-- TOC entry 254 (class 1259 OID 67303)
-- Name: tb_usuario_id_usuari_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_usuario_id_usuari_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_usuario_id_usuari_seq OWNER TO tintegro;

--
-- TOC entry 255 (class 1259 OID 67305)
-- Name: tb_usuario; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_usuario (
    id_usuari integer DEFAULT nextval('tb_usuario_id_usuari_seq'::regclass) NOT NULL,
    no_apepat character varying(25) NOT NULL,
    no_apemat character varying(25) NOT NULL,
    no_nombre character varying(25) NOT NULL,
    no_puesto character varying(50),
    nu_pin character varying(32) NOT NULL,
    ti_llamad integer DEFAULT 0,
    il_activo boolean DEFAULT true NOT NULL,
    il_mostrar boolean DEFAULT true,
    id_empare integer,
    il_bolsa boolean DEFAULT false NOT NULL,
    id_sip integer
);


ALTER TABLE tb_usuario OWNER TO tintegro;

--
-- TOC entry 256 (class 1259 OID 67312)
-- Name: tb_usuario_eliminado; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tb_usuario_eliminado (
    id_usuari integer NOT NULL,
    no_apepat character varying(25) NOT NULL,
    no_apemat character varying(25) NOT NULL,
    no_nombre character varying(25) NOT NULL,
    no_puesto character varying(50),
    nu_pin character varying(32) NOT NULL,
    ti_llamad integer,
    il_activo boolean DEFAULT true NOT NULL,
    il_mostrar boolean DEFAULT true,
    id_empare integer,
    il_bolsa boolean DEFAULT false NOT NULL
);


ALTER TABLE tb_usuario_eliminado OWNER TO tintegro;

--
-- TOC entry 257 (class 1259 OID 67318)
-- Name: tb_usuario_eliminado_id_usuari_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tb_usuario_eliminado_id_usuari_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_usuario_eliminado_id_usuari_seq OWNER TO tintegro;

--
-- TOC entry 3099 (class 0 OID 0)
-- Dependencies: 257
-- Name: tb_usuario_eliminado_id_usuari_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tb_usuario_eliminado_id_usuari_seq OWNED BY tb_usuario_eliminado.id_usuari;


--
-- TOC entry 258 (class 1259 OID 67320)
-- Name: tbruta_salientes; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tbruta_salientes (
    id_rutsal integer NOT NULL,
    id_tiptel integer NOT NULL,
    id_clave integer NOT NULL,
    no_rutsal character varying(100),
    no_descrip character varying(100),
    il_grabar boolean,
    no_name character varying
);


ALTER TABLE tbruta_salientes OWNER TO tintegro;

--
-- TOC entry 259 (class 1259 OID 67326)
-- Name: tbruta_salientes_id_rutsal_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tbruta_salientes_id_rutsal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tbruta_salientes_id_rutsal_seq OWNER TO tintegro;

--
-- TOC entry 3100 (class 0 OID 0)
-- Dependencies: 259
-- Name: tbruta_salientes_id_rutsal_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tbruta_salientes_id_rutsal_seq OWNED BY tbruta_salientes.id_rutsal;


SET default_with_oids = true;

--
-- TOC entry 260 (class 1259 OID 67328)
-- Name: tc_accion; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_accion (
    id_accion integer NOT NULL,
    no_accion character varying(50),
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tc_accion OWNER TO tintegro;

--
-- TOC entry 261 (class 1259 OID 67332)
-- Name: tc_clave_id_clave_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tc_clave_id_clave_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_clave_id_clave_seq OWNER TO tintegro;

--
-- TOC entry 262 (class 1259 OID 67334)
-- Name: tc_clave; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_clave (
    id_clave integer DEFAULT nextval('tc_clave_id_clave_seq'::regclass) NOT NULL,
    no_clave character varying(50),
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tc_clave OWNER TO tintegro;

--
-- TOC entry 263 (class 1259 OID 67339)
-- Name: tc_estado_id_estage_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tc_estado_id_estage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_estado_id_estage_seq OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 264 (class 1259 OID 67341)
-- Name: tc_estado; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_estado (
    id_estage integer DEFAULT nextval('tc_estado_id_estage_seq'::regclass) NOT NULL,
    no_estage character varying,
    ti_estado smallint,
    nu_codigo character varying(5),
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tc_estado OWNER TO tintegro;

--
-- TOC entry 265 (class 1259 OID 67349)
-- Name: tc_meetmevar; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_meetmevar (
    id_meetmevar character(1) NOT NULL,
    no_meetmevar character varying,
    va_orden integer
);


ALTER TABLE tc_meetmevar OWNER TO tintegro;

--
-- TOC entry 266 (class 1259 OID 67355)
-- Name: tc_rutasalcontex; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_rutasalcontex (
    id_contexto integer,
    id_rutsal integer
);


ALTER TABLE tc_rutasalcontex OWNER TO tintegro;

SET default_with_oids = true;

--
-- TOC entry 267 (class 1259 OID 67358)
-- Name: tc_tipcampana; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_tipcampana (
    id_tipcam smallint NOT NULL,
    no_campana character varying(50),
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tc_tipcampana OWNER TO tintegro;

--
-- TOC entry 268 (class 1259 OID 67362)
-- Name: tc_tipotelefono; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tc_tipotelefono (
    id_tiptel integer NOT NULL,
    no_tiptel character varying,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tc_tipotelefono OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 269 (class 1259 OID 67369)
-- Name: tcdialopc; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcdialopc (
    id_dialopc integer NOT NULL,
    il_parame character varying(100),
    no_dialopc character varying(100),
    or_dialopc boolean
);


ALTER TABLE tcdialopc OWNER TO tintegro;

--
-- TOC entry 270 (class 1259 OID 67372)
-- Name: tcmarca; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcmarca (
    id_marca integer NOT NULL,
    no_marca character varying(100),
    il_activo boolean DEFAULT true,
    il_formato_mac integer DEFAULT 0
);


ALTER TABLE tcmarca OWNER TO tintegro;

--
-- TOC entry 271 (class 1259 OID 67376)
-- Name: tcmarca_id_marca_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tcmarca_id_marca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcmarca_id_marca_seq OWNER TO tintegro;

--
-- TOC entry 3101 (class 0 OID 0)
-- Dependencies: 271
-- Name: tcmarca_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tcmarca_id_marca_seq OWNED BY tcmarca.id_marca;


--
-- TOC entry 272 (class 1259 OID 67378)
-- Name: tcmodelo; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcmodelo (
    id_modelo integer NOT NULL,
    no_modelo character varying(100),
    id_marca integer,
    il_activo boolean DEFAULT true
);


ALTER TABLE tcmodelo OWNER TO tintegro;

--
-- TOC entry 273 (class 1259 OID 67382)
-- Name: tcmodelo_id_modelo_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tcmodelo_id_modelo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcmodelo_id_modelo_seq OWNER TO tintegro;

--
-- TOC entry 3102 (class 0 OID 0)
-- Dependencies: 273
-- Name: tcmodelo_id_modelo_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tcmodelo_id_modelo_seq OWNED BY tcmodelo.id_modelo;


--
-- TOC entry 274 (class 1259 OID 67384)
-- Name: tcopcivr; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcopcivr (
    id_opcivr integer NOT NULL,
    no_opcivr character varying(100),
    ti_opcion integer,
    va_urlicon character varying(100),
    or_opcion integer DEFAULT 0,
    il_veropc boolean DEFAULT true
);


ALTER TABLE tcopcivr OWNER TO tintegro;

--
-- TOC entry 3103 (class 0 OID 0)
-- Dependencies: 274
-- Name: COLUMN tcopcivr.ti_opcion; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON COLUMN tcopcivr.ti_opcion IS '1:primarias, 2:basicas, 3:avanzadas';


--
-- TOC entry 275 (class 1259 OID 67389)
-- Name: tcopcivr_id_opcivr_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tcopcivr_id_opcivr_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcopcivr_id_opcivr_seq OWNER TO tintegro;

--
-- TOC entry 3104 (class 0 OID 0)
-- Dependencies: 275
-- Name: tcopcivr_id_opcivr_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tcopcivr_id_opcivr_seq OWNED BY tcopcivr.id_opcivr;


--
-- TOC entry 276 (class 1259 OID 67391)
-- Name: tcruta_detalle; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcruta_detalle (
    id_rutdet integer NOT NULL,
    id_rutsal integer NOT NULL,
    no_anteponer character varying(50),
    no_regla character varying(100),
    nu_priori integer DEFAULT 1 NOT NULL,
    nu_prefijo character varying(50)
);


ALTER TABLE tcruta_detalle OWNER TO tintegro;

--
-- TOC entry 277 (class 1259 OID 67395)
-- Name: tcruta_detalle_id_rutdet_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tcruta_detalle_id_rutdet_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcruta_detalle_id_rutdet_seq OWNER TO tintegro;

--
-- TOC entry 3105 (class 0 OID 0)
-- Dependencies: 277
-- Name: tcruta_detalle_id_rutdet_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tcruta_detalle_id_rutdet_seq OWNED BY tcruta_detalle.id_rutdet;


--
-- TOC entry 278 (class 1259 OID 67397)
-- Name: tcrutde_tron; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcrutde_tron (
    id_rutdet integer NOT NULL,
    id_troncal integer NOT NULL
);


ALTER TABLE tcrutde_tron OWNER TO tintegro;

--
-- TOC entry 279 (class 1259 OID 67400)
-- Name: tcservicio; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tcservicio (
    id_servicio integer NOT NULL,
    no_servicio character varying(100) NOT NULL,
    no_nompid character varying(100) NOT NULL,
    no_cominic character varying(200) NOT NULL,
    no_comdete character varying(200) NOT NULL,
    no_comrein character varying(200) NOT NULL,
    va_orden integer DEFAULT 0,
    il_mostrar boolean DEFAULT true
);


ALTER TABLE tcservicio OWNER TO tintegro;

--
-- TOC entry 280 (class 1259 OID 67405)
-- Name: tcservicio_id_servicio_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tcservicio_id_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcservicio_id_servicio_seq OWNER TO tintegro;

--
-- TOC entry 3106 (class 0 OID 0)
-- Dependencies: 280
-- Name: tcservicio_id_servicio_seq; Type: SEQUENCE OWNED BY; Schema: asterisk; Owner: tintegro
--

ALTER SEQUENCE tcservicio_id_servicio_seq OWNED BY tcservicio.id_servicio;


--
-- TOC entry 281 (class 1259 OID 67407)
-- Name: tctipllam_id_tipllam_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE tctipllam_id_tipllam_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tctipllam_id_tipllam_seq OWNER TO tintegro;

--
-- TOC entry 282 (class 1259 OID 67409)
-- Name: tctipllam; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tctipllam (
    id_tipllam integer DEFAULT nextval('tctipllam_id_tipllam_seq'::regclass) NOT NULL,
    no_tipllam character varying(10),
    va_orden integer
);


ALTER TABLE tctipllam OWNER TO tintegro;

--
-- TOC entry 3107 (class 0 OID 0)
-- Dependencies: 282
-- Name: TABLE tctipllam; Type: COMMENT; Schema: asterisk; Owner: tintegro
--

COMMENT ON TABLE tctipllam IS 'Tipos de llamadas: IN, OUT, Todas';


--
-- TOC entry 283 (class 1259 OID 67413)
-- Name: tctiptel_clave; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE tctiptel_clave (
    id_tiptel integer NOT NULL,
    id_clave integer NOT NULL
);


ALTER TABLE tctiptel_clave OWNER TO tintegro;

--
-- TOC entry 284 (class 1259 OID 67416)
-- Name: usuarioxarea; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE usuarioxarea (
    id_usuari integer NOT NULL,
    id_empare integer NOT NULL
);


ALTER TABLE usuarioxarea OWNER TO tintegro;

--
-- TOC entry 285 (class 1259 OID 67419)
-- Name: voicemail_users_uniqueid_seq; Type: SEQUENCE; Schema: asterisk; Owner: tintegro
--

CREATE SEQUENCE voicemail_users_uniqueid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE voicemail_users_uniqueid_seq OWNER TO tintegro;

--
-- TOC entry 286 (class 1259 OID 67421)
-- Name: voicemail_users; Type: TABLE; Schema: asterisk; Owner: tintegro
--

CREATE TABLE voicemail_users (
    uniqueid integer DEFAULT nextval('voicemail_users_uniqueid_seq'::regclass) NOT NULL,
    customer_id character varying(25) NOT NULL,
    context character varying(50),
    mailbox character varying(200) DEFAULT ''::character varying,
    password character varying(5) DEFAULT ''::character varying,
    fullname character varying(50),
    email character varying(50),
    pager character varying(50),
    attach character varying(4),
    saycid character varying(4),
    hidefromdir character varying(4),
    stamp timestamp without time zone
);


ALTER TABLE voicemail_users OWNER TO tintegro;

SET search_path = public, pg_catalog;

--
-- TOC entry 287 (class 1259 OID 67427)
-- Name: nu_agente; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE nu_agente (
    "?column?" bigint
);


ALTER TABLE nu_agente OWNER TO tintegro;

--
-- TOC entry 288 (class 1259 OID 67430)
-- Name: salida; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE salida (
    id_usuari integer
);


ALTER TABLE salida OWNER TO tintegro;

SET default_with_oids = true;

--
-- TOC entry 289 (class 1259 OID 67433)
-- Name: tc_estado; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE tc_estado (
    id_estado integer NOT NULL,
    no_estado character varying
);


ALTER TABLE tc_estado OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 290 (class 1259 OID 67439)
-- Name: temporal; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE temporal (
    data1 character varying,
    data2 character varying,
    data3 character varying,
    data4 character varying
);


ALTER TABLE temporal OWNER TO tintegro;

SET search_path = reportes, pg_catalog;

--
-- TOC entry 291 (class 1259 OID 67445)
-- Name: tb_detalle_llamada_id_llamada_seq; Type: SEQUENCE; Schema: reportes; Owner: tintegro
--

CREATE SEQUENCE tb_detalle_llamada_id_llamada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_detalle_llamada_id_llamada_seq OWNER TO tintegro;

SET default_with_oids = true;

--
-- TOC entry 292 (class 1259 OID 67447)
-- Name: tb_detalle_llamada; Type: TABLE; Schema: reportes; Owner: tintegro
--

CREATE TABLE tb_detalle_llamada (
    id_llamada integer DEFAULT nextval('tb_detalle_llamada_id_llamada_seq'::regclass) NOT NULL,
    fe_inillam date,
    ho_inillam time without time zone,
    fe_finllam date,
    ho_finllam time without time zone,
    ti_llamada integer,
    nu_ani character varying,
    nu_dni character varying,
    no_cola character varying,
    no_agente character varying,
    ti_convers integer
);


ALTER TABLE tb_detalle_llamada OWNER TO tintegro;

--
-- TOC entry 3108 (class 0 OID 0)
-- Dependencies: 292
-- Name: COLUMN tb_detalle_llamada.ti_llamada; Type: COMMENT; Schema: reportes; Owner: tintegro
--

COMMENT ON COLUMN tb_detalle_llamada.ti_llamada IS 'tipo de llamada Inbound, Outbound';


--
-- TOC entry 293 (class 1259 OID 67454)
-- Name: tb_estado_agente_id_estage_seq; Type: SEQUENCE; Schema: reportes; Owner: tintegro
--

CREATE SEQUENCE tb_estado_agente_id_estage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_estado_agente_id_estage_seq OWNER TO tintegro;

--
-- TOC entry 294 (class 1259 OID 67456)
-- Name: tb_estado_agente; Type: TABLE; Schema: reportes; Owner: tintegro
--

CREATE TABLE tb_estado_agente (
    id_estage integer DEFAULT nextval('tb_estado_agente_id_estage_seq'::regclass) NOT NULL,
    co_agente character varying,
    co_campan integer,
    co_estado integer,
    fe_iniest date,
    ho_iniest time without time zone,
    fe_finest date,
    ho_finest time without time zone,
    ti_estmin character varying(8),
    ti_estseg integer
);


ALTER TABLE tb_estado_agente OWNER TO tintegro;

--
-- TOC entry 3109 (class 0 OID 0)
-- Dependencies: 294
-- Name: COLUMN tb_estado_agente.co_agente; Type: COMMENT; Schema: reportes; Owner: tintegro
--

COMMENT ON COLUMN tb_estado_agente.co_agente IS 'Extension del agente';


--
-- TOC entry 3110 (class 0 OID 0)
-- Dependencies: 294
-- Name: COLUMN tb_estado_agente.ti_estmin; Type: COMMENT; Schema: reportes; Owner: tintegro
--

COMMENT ON COLUMN tb_estado_agente.ti_estmin IS 'Tiempo de conexion en minutos';


--
-- TOC entry 3111 (class 0 OID 0)
-- Dependencies: 294
-- Name: COLUMN tb_estado_agente.ti_estseg; Type: COMMENT; Schema: reportes; Owner: tintegro
--

COMMENT ON COLUMN tb_estado_agente.ti_estseg IS 'Tiempo de estado en segundos';


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 295 (class 1259 OID 67463)
-- Name: rolusu_id_rolusu_seq; Type: SEQUENCE; Schema: seguridad; Owner: tintegro
--

CREATE SEQUENCE rolusu_id_rolusu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rolusu_id_rolusu_seq OWNER TO tintegro;

--
-- TOC entry 296 (class 1259 OID 67465)
-- Name: rolusu; Type: TABLE; Schema: seguridad; Owner: tintegro
--

CREATE TABLE rolusu (
    id_rolusu integer DEFAULT nextval('rolusu_id_rolusu_seq'::regclass) NOT NULL,
    no_rolusu character varying(50) NOT NULL,
    no_descri character varying(250) NOT NULL,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE rolusu OWNER TO tintegro;

SET default_with_oids = false;

--
-- TOC entry 297 (class 1259 OID 67470)
-- Name: tbconecion; Type: TABLE; Schema: seguridad; Owner: tintegro
--

CREATE TABLE tbconecion (
    no_ipconex character varying(50) NOT NULL
);


ALTER TABLE tbconecion OWNER TO tintegro;

--
-- TOC entry 298 (class 1259 OID 67473)
-- Name: tcmodulo_id_modulo_seq; Type: SEQUENCE; Schema: seguridad; Owner: tintegro
--

CREATE SEQUENCE tcmodulo_id_modulo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tcmodulo_id_modulo_seq OWNER TO tintegro;

--
-- TOC entry 299 (class 1259 OID 67475)
-- Name: tcmodulo; Type: TABLE; Schema: seguridad; Owner: tintegro
--

CREATE TABLE tcmodulo (
    id_modulo integer DEFAULT nextval('tcmodulo_id_modulo_seq'::regclass) NOT NULL,
    no_modulo character varying(100),
    no_metexp character varying(100),
    id_parent integer,
    il_activo boolean DEFAULT true,
    va_orden integer,
    no_url character varying
);


ALTER TABLE tcmodulo OWNER TO tintegro;

SET default_with_oids = true;

--
-- TOC entry 300 (class 1259 OID 67483)
-- Name: tcmodulo_rolusu; Type: TABLE; Schema: seguridad; Owner: tintegro
--

CREATE TABLE tcmodulo_rolusu (
    id_rolusu integer NOT NULL,
    id_modulo integer NOT NULL
);


ALTER TABLE tcmodulo_rolusu OWNER TO tintegro;

SET search_path = asterisk, pg_catalog;

--
-- TOC entry 2517 (class 2604 OID 70627)
-- Name: id_datos; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_datos_call ALTER COLUMN id_datos SET DEFAULT nextval('queue_datos_call_id_datos_seq'::regclass);


--
-- TOC entry 2519 (class 2604 OID 70628)
-- Name: uniqueid; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_member_table ALTER COLUMN uniqueid SET DEFAULT nextval('queue_member_table_uniqueid_seq'::regclass);


--
-- TOC entry 2568 (class 2604 OID 70629)
-- Name: id_aprov; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_buddies_aprov ALTER COLUMN id_aprov SET DEFAULT nextval('sip_buddies_aprov_id_aprov_seq'::regclass);


--
-- TOC entry 2572 (class 2604 OID 70630)
-- Name: id_appivr; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_appivr ALTER COLUMN id_appivr SET DEFAULT nextval('tb_appivr_id_appivr_seq'::regclass);


--
-- TOC entry 2573 (class 2604 OID 70631)
-- Name: id_aprovis; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_aprovis ALTER COLUMN id_aprovis SET DEFAULT nextval('tb_aprovis_id_aprovis_seq'::regclass);


--
-- TOC entry 2588 (class 2604 OID 70632)
-- Name: id_contexto; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_contexto ALTER COLUMN id_contexto SET DEFAULT nextval('tb_contexto_id_contexto_seq'::regclass);


--
-- TOC entry 2595 (class 2604 OID 70633)
-- Name: id_ivrdet; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_ivrdet ALTER COLUMN id_ivrdet SET DEFAULT nextval('tb_ivrdet_id_ivrdet_seq'::regclass);


--
-- TOC entry 2648 (class 2604 OID 70671)
-- Name: id_sip_telefono; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_sip_telefono ALTER COLUMN id_sip_telefono SET DEFAULT nextval('tb_sip_telefono_id_sip_telefono_seq'::regclass);


--
-- TOC entry 2608 (class 2604 OID 70635)
-- Name: id_troncal; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_troncal ALTER COLUMN id_troncal SET DEFAULT nextval('tb_troncal_id_troncal_seq'::regclass);


--
-- TOC entry 2617 (class 2604 OID 70636)
-- Name: id_rutsal; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tbruta_salientes ALTER COLUMN id_rutsal SET DEFAULT nextval('tbruta_salientes_id_rutsal_seq'::regclass);


--
-- TOC entry 2626 (class 2604 OID 70637)
-- Name: id_marca; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcmarca ALTER COLUMN id_marca SET DEFAULT nextval('tcmarca_id_marca_seq'::regclass);


--
-- TOC entry 2629 (class 2604 OID 70638)
-- Name: id_modelo; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcmodelo ALTER COLUMN id_modelo SET DEFAULT nextval('tcmodelo_id_modelo_seq'::regclass);


--
-- TOC entry 2632 (class 2604 OID 70639)
-- Name: id_opcivr; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcopcivr ALTER COLUMN id_opcivr SET DEFAULT nextval('tcopcivr_id_opcivr_seq'::regclass);


--
-- TOC entry 2634 (class 2604 OID 70640)
-- Name: id_rutdet; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcruta_detalle ALTER COLUMN id_rutdet SET DEFAULT nextval('tcruta_detalle_id_rutdet_seq'::regclass);


--
-- TOC entry 2637 (class 2604 OID 70641)
-- Name: id_servicio; Type: DEFAULT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcservicio ALTER COLUMN id_servicio SET DEFAULT nextval('tcservicio_id_servicio_seq'::regclass);


--
-- TOC entry 2932 (class 0 OID 66937)
-- Dependencies: 184
-- Data for Name: agente; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY agente (id_agente, nu_agente, no_apepat, no_apemat, no_nombre, no_cid, nu_cid, nu_pin, no_context, il_status, no_locacion, nu_accion, il_desllam, nu_desllam, il_limtiem, va_tiellam, il_grallam, co_estado, il_usutel, no_usutel, no_passtel, nu_agetel, il_activo, es_usuari) FROM stdin;
234	168	Ramirez	GarcÌa	Pool	\N	\N	123	\N	t	\N	\N	f	\N	f	\N	f	2	f			\N	1	0
\.


--
-- TOC entry 3112 (class 0 OID 0)
-- Dependencies: 183
-- Name: agente_id_agente_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('agente_id_agente_seq', 234, true);


--
-- TOC entry 2933 (class 0 OID 66953)
-- Dependencies: 185
-- Data for Name: agente_por_cola; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY agente_por_cola (id_agecola, id_cola, nu_prorid) FROM stdin;
\.


--
-- TOC entry 2934 (class 0 OID 66956)
-- Dependencies: 186
-- Data for Name: callcenter; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY callcenter ("time", callid, queuename, agent, event, data, data1, data2, data3, data4, data5, index) FROM stdin;
\.


--
-- TOC entry 3113 (class 0 OID 0)
-- Dependencies: 187
-- Name: callcenter_id_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('callcenter_id_seq', 1, false);


--
-- TOC entry 2936 (class 0 OID 66961)
-- Dependencies: 188
-- Data for Name: callcenter_old; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY callcenter_old (qtime, qdate, qname, agent, action, info1, info2, info3, uniqueid, id) FROM stdin;
\.


--
-- TOC entry 2938 (class 0 OID 66970)
-- Dependencies: 190
-- Data for Name: campana; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY campana (id_campan, no_campan, ti_campan) FROM stdin;
\.


--
-- TOC entry 3114 (class 0 OID 0)
-- Dependencies: 189
-- Name: campana_id_campan_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('campana_id_campan_seq', 1, false);


--
-- TOC entry 2940 (class 0 OID 66979)
-- Dependencies: 192
-- Data for Name: cdr; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY cdr (id, calldate, clid, src, dst, dcontext, channel, dstchannel, lastapp, lastdata, duration, billsec, disposition, amaflags, accountcode, uniqueid, userfield, id_usuario, id_area) FROM stdin;
742066	2016-12-16 22:37:48-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000000	SIP/4444-00000002	Dial	SIP/4444,30,tTwW	17	11	ANSWERED	3	\N	1481945868.0	\N	\N	\N
742067	2016-12-16 22:39:10-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000003	SIP/4444-00000005	Dial	SIP/4444,30,tTwW	0	0	FAILED	3	\N	1481945950.3	\N	\N	\N
742068	2016-12-16 22:39:39-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000006	SIP/4444-00000008	Dial	SIP/4444,30,tTwW	92	87	ANSWERED	3	\N	1481945979.6	\N	\N	\N
742069	2016-12-16 22:41:36-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000009	SIP/4444-0000000b	Dial	SIP/4444,30,tTwW	12	10	ANSWERED	3	\N	1481946096.9	\N	\N	\N
742070	2016-12-16 22:49:40-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-0000000c	SIP/4444-0000000e	Dial	SIP/4444,30,tTwW	236	228	ANSWERED	3	\N	1481946580.12	\N	\N	\N
742071	2016-12-16 22:56:35-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-0000000f	SIP/4444-00000011	Dial	SIP/4444,30,tTwW	22	17	ANSWERED	3	\N	1481946995.15	\N	\N	\N
742072	2016-12-16 23:03:16-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000012	SIP/4444-00000014	Dial	SIP/4444,30,tTwW	44	40	ANSWERED	3	\N	1481947396.18	\N	\N	\N
742073	2016-12-16 23:09:25-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000015	SIP/4444-00000017	Dial	SIP/4444,30,tTwW	80	74	ANSWERED	3	\N	1481947765.21	\N	\N	\N
742074	2016-12-16 23:11:09-05	"4444" <4444>	4444	4444	registro-corporativo	SIP/4444-00000018	SIP/4444-0000001a	Dial	SIP/4444,30,tTwW	5	3	ANSWERED	3	\N	1481947869.24	\N	\N	\N
742075	2016-12-16 23:13:14-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-0000001b	SIP/4444-0000001d	Dial	SIP/4444,30,tTwW	305	301	ANSWERED	3	\N	1481947994.27	\N	\N	\N
742076	2016-12-17 01:22:41-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-0000001e	SIP/4444-00000020	Dial	SIP/4444,30,tTwW	22	18	ANSWERED	3	\N	1481955761.30	\N	\N	\N
742077	2016-12-17 01:24:19-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000021	SIP/4444-00000023	Dial	SIP/4444,30,tTwW	47	45	ANSWERED	3	\N	1481955859.33	\N	\N	\N
742078	2016-12-17 01:26:24-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000024	SIP/4444-00000026	Dial	SIP/4444,30,tTwW	260	259	ANSWERED	3	\N	1481955984.36	\N	\N	\N
742079	2016-12-17 01:31:01-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-00000027	SIP/4444-00000029	Dial	SIP/4444,30,tTwW	24	23	ANSWERED	3	\N	1481956261.39	\N	\N	\N
742080	2016-12-17 01:38:43-05	"100" <2000>	2000	4444	registro-corporativo	SIP/2000-0000002a	SIP/4444-0000002c	Dial	SIP/4444,30,tTwW	231	229	ANSWERED	3	\N	1481956723.42	\N	\N	\N
\.


--
-- TOC entry 3115 (class 0 OID 0)
-- Dependencies: 191
-- Name: cdr_id_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('cdr_id_seq', 742080, true);


--
-- TOC entry 2941 (class 0 OID 66983)
-- Dependencies: 193
-- Data for Name: cel; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY cel (eventtime, userdeftype, cid_name, cid_num, cid_ani, cid_rdnis, cid_dnid, exten, context, channame, appname, appdata, accountcode, peeraccount, uniqueid, linkedid, amaflags, userfield, peer) FROM stdin;
\.


--
-- TOC entry 2943 (class 0 OID 66988)
-- Dependencies: 195
-- Data for Name: empresa_area; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY empresa_area (id_empare, nombre, tipo, id_padre, il_activo, il_elimina) FROM stdin;
174	Finanzas	1	\N	t	t
175	Cobro	2	174	t	t
176	Redes II	2	104	t	t
104	Contabilidad	1	\N	t	t
105	Centro Conta I	2	104	t	t
106	Contabilidad II	1	\N	t	t
107	Centro Conta II	2	106	t	t
108	Area Pueba II	1	\N	t	t
109	Area Pueba II	2	108	t	t
110	Area Contabilidad II	1	\N	t	t
111	Centro Conta II	2	110	t	t
112	Centro Prueba II	2	108	t	t
113	Desarrollo	1	\N	t	t
114	Centro Desarrollo	2	113	t	t
115	Redes	1	\N	t	t
116	Centro Redes	2	115	t	t
117	Redes II	1	\N	t	t
118	Centro Redes	2	117	t	t
119	Cableado	1	\N	t	t
120	Centro Cableado	2	119	t	t
121	Centro Conta	2	104	t	t
2	General	2	1	t	f
190	Almacen	2	190	t	t
184	cca1100	2	102	t	t
185	cca2100	2	102	t	t
186	Area 500	1	\N	t	t
187	cca1500	2	186	t	t
188	Contabilidad	2	104	t	t
189	Almacen	1	\N	t	t
1	GENERALES	1	323	t	f
103	CENTRO REDE	2	102	t	t
102	General	1	\N	t	t
\.


--
-- TOC entry 3116 (class 0 OID 0)
-- Dependencies: 194
-- Name: empresa_area_id_empare_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('empresa_area_id_empare_seq', 406, true);


--
-- TOC entry 2945 (class 0 OID 66995)
-- Dependencies: 197
-- Data for Name: extensions_table; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY extensions_table (id_extens, context, exten, priority, app, appdata) FROM stdin;
802	anexos	321	1	Macro	stdexten
806	anexos	3789	1	Macro	stdexten
807	anexos	233	1	Macro	stdexten
808	anexos	233	1	Macro	stdexten
809	anexos	3789	1	Macro	stdexten
810	anexos	233	1	Macro	stdexten
811	anexos	4344	1	Macro	stdexten
812	anexos	233	1	Macro	stdexten
813	anexos	233	1	Macro	stdexten
814	anexos	434	1	Macro	stdexten
815	anexos	434	1	Macro	stdexten
1446	anexos	107	1	Macro	stdexten
1447	anexos	108	1	Macro	stdexten
1448	anexos	109	1	Macro	stdexten
819	anexos	6754	1	Macro	stdexten
820	anexos	6754	1	Macro	stdexten
826	anexos	6754	1	Macro	stdexten
1457	anexos	677	1	Macro	stdexten
1458	anexos	5325	1	Macro	stdexten
1466	anexos	107	1	Macro	stdexten
1467	anexos	108	1	Macro	stdexten
1468	anexos	109	1	Macro	stdexten
1469	anexos	110	1	Macro	stdexten
1470	anexos	111	1	Macro	stdexten
1471	anexos	112	1	Macro	stdexten
1472	anexos	113	1	Macro	stdexten
1473	anexos	114	1	Macro	stdexten
1474	anexos	115	1	Macro	stdexten
1475	anexos	116	1	Macro	stdexten
1476	anexos	117	1	Macro	stdexten
1477	anexos	118	1	Macro	stdexten
1478	anexos	119	1	Macro	stdexten
1479	anexos	120	1	Macro	stdexten
1480	anexos	121	1	Macro	stdexten
1481	anexos	122	1	Macro	stdexten
1482	anexos	123	1	Macro	stdexten
1483	anexos	124	1	Macro	stdexten
1484	anexos	125	1	Macro	stdexten
1485	anexos	126	1	Macro	stdexten
1486	anexos	127	1	Macro	stdexten
1487	anexos	128	1	Macro	stdexten
1488	anexos	129	1	Macro	stdexten
1489	anexos	130	1	Macro	stdexten
1490	anexos	131	1	Macro	stdexten
1491	anexos	132	1	Macro	stdexten
1492	anexos	133	1	Macro	stdexten
1493	anexos	134	1	Macro	stdexten
1494	anexos	135	1	Macro	stdexten
1495	anexos	136	1	Macro	stdexten
1496	anexos	137	1	Macro	stdexten
1497	anexos	138	1	Macro	stdexten
1498	anexos	139	1	Macro	stdexten
1499	anexos	140	1	Macro	stdexten
1500	anexos	141	1	Macro	stdexten
1501	anexos	142	1	Macro	stdexten
1502	anexos	143	1	Macro	stdexten
1503	anexos	144	1	Macro	stdexten
1504	anexos	145	1	Macro	stdexten
1505	anexos	146	1	Macro	stdexten
1506	anexos	147	1	Macro	stdexten
1507	anexos	148	1	Macro	stdexten
1508	anexos	149	1	Macro	stdexten
1509	anexos	5334	1	Macro	stdexten
1510	anexos	5325	1	Macro	stdexten
1511	anexos	5325	1	Macro	stdexten
1513	anexos	1000	1	Macro	stdexten
1514	anexos	5325	1	Macro	stdexten
1515	anexos	5325	1	Macro	stdexten
1516	anexos	lkl	1	Macro	stdexten
1517	anexos	100	1	Macro	stdexten
1518	anexos	101	1	Macro	stdexten
1519	anexos	102	1	Macro	stdexten
1520	anexos	103	1	Macro	stdexten
1011	anexos	333	1	Macro	stdexten
1521	anexos	104	1	Macro	stdexten
1522	anexos	105	1	Macro	stdexten
\.


--
-- TOC entry 3117 (class 0 OID 0)
-- Dependencies: 196
-- Name: extensions_table_id_extens_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('extensions_table_id_extens_seq', 1522, true);


--
-- TOC entry 2946 (class 0 OID 67000)
-- Dependencies: 198
-- Data for Name: file_astersik; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY file_astersik (nombre, patch, patch_copy, descripcion, fecha, comando) FROM stdin;
\.


--
-- TOC entry 2948 (class 0 OID 67005)
-- Dependencies: 200
-- Data for Name: iax_buddies; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY iax_buddies (id_iaxbud, no_iaxbud, ti_iaxbud, no_hosts, il_qualif, no_contex, no_pasiax, no_disall, no_allow, il_permit) FROM stdin;
6	200	friend	192.168.5.30	yes	iax_reporte	200	all	ulaw;gsm	f
\.


--
-- TOC entry 3118 (class 0 OID 0)
-- Dependencies: 201
-- Name: iax_buddies_id_iax_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_buddies_id_iax_seq', 1, false);


--
-- TOC entry 3119 (class 0 OID 0)
-- Dependencies: 199
-- Name: iax_buddies_id_iaxbud_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_buddies_id_iaxbud_seq', 6, true);


--
-- TOC entry 2951 (class 0 OID 67022)
-- Dependencies: 203
-- Data for Name: iax_dialplan; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY iax_dialplan (id_iaxdia, id_iaxtru, no_iaxrut, no_iaxdes, fe_iaxcre, no_iaxpri) FROM stdin;
\.


--
-- TOC entry 3120 (class 0 OID 0)
-- Dependencies: 202
-- Name: iax_dialplan_id_iaxdia_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_dialplan_id_iaxdia_seq', 1, false);


--
-- TOC entry 2953 (class 0 OID 67031)
-- Dependencies: 205
-- Data for Name: iax_ip; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY iax_ip (id_iaxip, id_iaxbud, no_iaxip) FROM stdin;
7	6	192.168.5.100
\.


--
-- TOC entry 3121 (class 0 OID 0)
-- Dependencies: 204
-- Name: iax_ip_id_iaxip_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_ip_id_iaxip_seq', 7, true);


--
-- TOC entry 2955 (class 0 OID 67040)
-- Dependencies: 207
-- Data for Name: iax_red; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY iax_red (id_iaxred, id_iaxbud, no_iaxred) FROM stdin;
7	6	255.255.0.0
\.


--
-- TOC entry 3122 (class 0 OID 0)
-- Dependencies: 206
-- Name: iax_red_id_iaxred_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_red_id_iaxred_seq', 7, true);


--
-- TOC entry 2957 (class 0 OID 67049)
-- Dependencies: 209
-- Data for Name: iax_trunk; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY iax_trunk (id_iaxtru, no_iaxtru, ti_iaxtru, no_iaxusu, no_iaxpas, no_iaxip, no_iaxqua, ti_usoiax) FROM stdin;
\.


--
-- TOC entry 3123 (class 0 OID 0)
-- Dependencies: 208
-- Name: iax_trunk_id_iaxtru_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('iax_trunk_id_iaxtru_seq', 1, false);


--
-- TOC entry 2958 (class 0 OID 67057)
-- Dependencies: 210
-- Data for Name: queue_datos_call; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_datos_call (id_datos, queue_name, tmp_minimo, tmp_medio, tmp_maximo, no_correo, nu_anexo) FROM stdin;
6	\N	00:02:00	00:04:00	00:14:00	de	23
\.


--
-- TOC entry 3124 (class 0 OID 0)
-- Dependencies: 211
-- Name: queue_datos_call_id_datos_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('queue_datos_call_id_datos_seq', 6, true);


--
-- TOC entry 2960 (class 0 OID 67062)
-- Dependencies: 212
-- Data for Name: queue_member_table; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_member_table (uniqueid, membername, queue_name, interface, penalty, paused, id_agente, no_alias, fe_creacion) FROM stdin;
\.


--
-- TOC entry 3125 (class 0 OID 0)
-- Dependencies: 213
-- Name: queue_member_table_uniqueid_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('queue_member_table_uniqueid_seq', 237, true);


--
-- TOC entry 2963 (class 0 OID 67073)
-- Dependencies: 215
-- Data for Name: queue_members; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_members (id_queuem, queue_name, interface, penalty, membername, paused, id_agente) FROM stdin;
\.


--
-- TOC entry 3126 (class 0 OID 0)
-- Dependencies: 214
-- Name: queue_members_id_queuem_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('queue_members_id_queuem_seq', 1449, true);


--
-- TOC entry 2964 (class 0 OID 67078)
-- Dependencies: 216
-- Data for Name: queue_por_campana; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_por_campana (id_queues, id_campan, il_activo) FROM stdin;
\.


--
-- TOC entry 2965 (class 0 OID 67082)
-- Dependencies: 217
-- Data for Name: queue_strategy; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_strategy (no_strategy, il_strategy) FROM stdin;
\.


--
-- TOC entry 2966 (class 0 OID 67086)
-- Dependencies: 218
-- Data for Name: queue_table; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queue_table (name, musiconhold, announce, context, strategy, servicelevel, penaltymemberslimit, timeout, retry, timeoutpriority, weight, wrapuptime, autofill, autopause, maxlen, setinterfacevar, setqueueentryvar, setqueuevar, membermacro, "announce-frequency", "min-announce-frequency", "periodic-announce-frequency", "random-periodic-announce", "relative-periodic-announce", "announce-holdtime", "announce-position", "announce-position-limit", "announce-round-seconds", "queue-youarenext", "queue-thereare", "queue-callswaiting", "queue-holdtime", "queue-minute", "queue-minutes", "queue-seconds", "queue-thankyou", "queue-reporthold", "periodic-announce", "monitor-format", "monitor-type", joinempty, leavewhenempty, eventwhencalled, eventmemberstatus, reportholdtime, ringinuse, memberdelay, timeoutrestart, defaultrule) FROM stdin;
\.


--
-- TOC entry 2968 (class 0 OID 67125)
-- Dependencies: 220
-- Data for Name: queues; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY queues (id_queues, name, musiconhold, announce, context, timeout, "monitor-join", "monitor-format", "queue-youarenext", "queue-thereare", "queue-callswaiting", "queue-holdtime", "queue-minutes", "queue-seconds", "queue-lessthan", "queue-thankyou", "queue-reporthold", "announce-frequency", "announce-round-seconds", "announce-holdtime", retry, wrapuptime, maxlen, servicelevel, strategy, joinempty, leavewhenempty, eventmemberstatus, eventwhencalled, reportholdtime, memberdelay, weight, timeoutrestart, ringinuse, "announce-periodic") FROM stdin;
\.


--
-- TOC entry 3127 (class 0 OID 0)
-- Dependencies: 219
-- Name: queues_id_queues_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('queues_id_queues_seq', 12, true);


--
-- TOC entry 2970 (class 0 OID 67135)
-- Dependencies: 222
-- Data for Name: sip_buddies; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY sip_buddies (id_sip, name, type, fullcontact, regseconds, ipaddr, musicclass, relaxdtmf, usereqphone, compactheaders, callevents, ignoreregexpire, context, callingpres, deny, permit, secret, md5secret, dtmfmode, canreinvite, nat, callgroup, pickupgroup, language, disallow, allow, insecure, trustrpid, progressinband, promiscredir, useclientcode, accountcode, setvar, callerid, amaflags, "call-limit", restrictcid, allowoverlap, allowsubscribe, subscribecontext, videosupport, maxcallbitrate, mailbox, username, template, fromdomain, regexten, fromuser, host, port, qualify, defaultip, rtptimeout, rtpholdtimeout, sendrpid, regserver, usecallingpres, uso, lastms, allow_codec_video, no_transport, no_ecryption) FROM stdin;
1324	677	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	Q5KE9PJNKhBlW4Lkll9I3GsL1	Q5KE9PJNKhBlW4Lkll9I3GsL1	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	677	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1325	5325	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	127.0.0.1	5325	beb04c41b45927cf7e9f8fd4bb519e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	5325	\N	\N	\N	\N	\N	\N	\N	384	5325	5325	\N	\N	\N	\N	127.0.0.1	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1333	107	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	eyX2NBAsGfU46acvdnNtnrZpk	3c2c6f8da339e92c5f6784b6625239e1	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	107	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1314	108	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	nPBYZJRrtsvLWynyCmFablLIz	2673ff1798490e5841da19d860bed42b	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	108	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1334	108	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	i4hfEX8RRAe8rPVPyFXDjCmHF	c51683a838f7c7748cad4a334f1f0bc8	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	108	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1335	109	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	2Alvd2nXEKVVh-yhTw47uTZVM	190eb6336274ae80f8f3795544338e13	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	109	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1336	110	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	uK2Q05CMtxo5JvuJJLu4b97bh	b3671667f3b78bd72ffc1da613d48f06	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	110	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1337	111	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	-4j1MkvpuVJHk1NXih6SCL26B	c9ebfd5960458696d0902b4d4b118973	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	111	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1338	112	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	5VCYbfICIJxkhtSmH6WMR90VR	4bb2bb099777223260cf597fbc341782	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	112	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1339	113	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	r4DYGcnjD9s7uRxrYdhQjuGNz	90a7c03924dd3ff53ee8070d561241b6	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	113	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1340	114	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	zxs4bAe5h_km-14n78rWzAgnY	f7c6f043b81d32f58233afe004a52b26	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	114	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1341	115	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	zbmUc1-GxG1BiQIrPLR15xBKD	346bb157a1bdca2519864179b01f32e8	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	115	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1342	116	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	lpShR_cUUibXkJEE0vFyZZyLH	95865fb5f17a0dcf82f202d081abd2db	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	116	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1343	117	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	fM9XZ3RjfYf2i6G3BdkDL4cgZ	ef2e649e1f3255e3143006e6257de9ae	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	117	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1344	118	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	mIoWQSZ1U6LP7XJz0u5NmQ5q0	c8bdb9951122a5d4a41766d20f08b2e4	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	118	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1345	119	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	hf5mml5cU3GSSZQpzpSgqt8BQ	4ab39add895fbf89bd05c9e819e96d09	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	119	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1346	120	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	nT-BjH9rlSdQwyOrJ5ctW3bQN	96f16a122d204da741245b3f40f8e7bb	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	120	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1347	121	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	6fVMJqk5uUIw3efFJ72rLJqiO	c132b56fc3f67e967acf7a382d1e3832	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	121	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1348	122	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	P7ZC58GHHO9trH3LJp658D4NU	1a0f2abfbdc73f0e84baa59acc898f87	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	122	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1349	123	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	7TrTWufnypmEUVvpB1uzLKwF8	761e7ce564c1cecdfdb9361914a0333d	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	123	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1350	124	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	aS-HOPXoUecEUPs5gyp5IoOM_	8bc7421dd4c4dd7f21a5b9bf608a9446	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	124	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1351	125	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	1F9yLb03NRA7k03sa39qypTjS	4f4056e0f8dc0239001d6d92967d96b4	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	125	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1352	126	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	I_Rw2IpbJfiKjGeYDq9tn_QiM	0ee691383da31fcff9ab4a1ddbd8e6a4	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	126	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1353	127	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	x31Dl-QKYKI5GewSecgnSL0oi	97c8e033590907554fb7467ed1e669ab	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	127	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1354	128	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	XDhfT9iqAxgFxKjjB5SDjPk8d	7e82966c68f21e17e2c6ab6f557e4cfd	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	128	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1313	107	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	AC2hFx_8o2vbB2bF5vOcoV_XC	46dddc71a252749e46a9d740266399ff	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	107	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1315	109	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	LOF6nzmaZWqJM-0JdzGzsAJp_	e7c6b6793927987d830d4cb227f29003	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	109	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1355	129	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	vr1ppgXmWfploU9X_Izecr4d_	f07af10334e23d479393abe9182e9483	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	129	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1356	130	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	RrJVy24IR9gaCJjaR79cgWQkz	43ee8bde4555bc99f1b055492464acdc	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	130	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1357	131	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	mnOERTJ2JGUMNaUtr2EY2huyg	de2ccd51586d774860463719cb4de7b7	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	131	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1358	132	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	BFHd8odurtlSSvsLMM4JivxVm	d310575f6a2a861a59527bbe7ec89727	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	132	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1359	133	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	_aKdRKO13FetAjzeYUNeia2pp	03558f8485b30ea6b28cb06c2a6dba94	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	133	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1360	134	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	AC_bkl-15hNVsJK3vr6TvjPZ0	7a1722ef895ca7e1b2fb496d93c3b827	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	134	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1361	135	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	DReio4utWU5Ns7WTyBS_YxgYZ	de4c14db380062c5830163a21be10ee1	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	135	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1362	136	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	9C6PhVjNeXR8KgAcERMwLnkNw	3830a34aa544fa5132f92317bdd63065	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	136	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1363	137	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	f9C7Lr3SPfO-g-nuYzuPDAVp0	d8e2bc4a2f6aae761ab05975b9755e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	137	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1364	138	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	SQ6FSrsYL8__OmToe5sPLikIJ	7deebb3ff56703432e27bc4586c70aec	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	138	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1365	139	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	gN4sN5rOb0efw2Pf6l7WavZwO	a037d57d345d4fc50a0ff7f2a6cac256	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	139	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1366	140	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	BcUxaBHRmJKibvR0OLRYNLRqL	090a0e994c7452763d8f64a386f80b1d	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	140	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1367	141	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	WXTVjznSbcBqmyxIrPjZYs7v8	6acca743a290a87823aefbed9c786060	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	141	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1368	142	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	KnV8jX3B_EK95iw6Dn95RF4-A	32501e0b6d2d3e4a736a2146b1fdd4dc	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	142	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1369	143	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	_n56V6irGrL_J1Iyh0ph7dxX4	189d24aad2d502018777234530a66c97	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	143	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1370	144	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	U-_QDc-GFDoPW1tclfNSJ2fNl	130ff4ed96bc2fe2c1184b9ab614e856	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	144	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1371	145	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	5KAEB0mQPxf_O6dH_k0Vz8dVc	b571194c07a00f50dea7cf084ad1734d	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	145	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1372	146	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	nYJ6_RrwCCXuaSpiBFKxyIAF7	57e9fc82be348a27bdf70a482c973f86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	146	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1373	147	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	0bWEP3zRxIv6r_acaLAR0IuJO	b5e1b5411370e40d198ae66b04e4266b	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	147	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1374	148	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	pvFDnPqlmlGOOYGn7UvEprSnR	ff352d9cbb6a7a034a9ea8b03589383e	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	148	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1375	149	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	dzrTVJooud-124UAgCPK42pkk	6885b52c441ad9734a67a8e47dc6e8d3	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	384	\N	149	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1376	5334	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	233	e165421110ba03099a1c0393373c5b43	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	233	\N	\N	\N	\N	\N	\N	\N	384	\N	5334	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1377	5325	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	127.0.0.1	5325	beb04c41b45927cf7e9f8fd4bb519e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	5325	\N	\N	\N	\N	\N	\N	\N	384	5325	5325	\N	\N	\N	\N	127.0.0.1	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1378	5325	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	127.0.0.1	5325	beb04c41b45927cf7e9f8fd4bb519e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	5325	\N	\N	\N	\N	\N	\N	\N	384	5325	5325	\N	\N	\N	\N	127.0.0.1	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1383	1000	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	2mLGC1Jscl7QGb03mRpvpFM7G	b3aa2a5763cec73587e0b63d05704f43	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Anexo1000	\N	\N	\N	\N	\N	\N	\N	384	1000	1000	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1384	5325	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	127.0.0.1	5325	beb04c41b45927cf7e9f8fd4bb519e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	5325	\N	\N	\N	\N	\N	\N	\N	384	5325	5325	\N	\N	\N	\N	127.0.0.1	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1385	5325	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	127.0.0.1	5325	beb04c41b45927cf7e9f8fd4bb519e86	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	5325	\N	\N	\N	\N	\N	\N	\N	384	5325	5325	\N	\N	\N	\N	127.0.0.1	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1386	1111	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	200.48.2.117 	Cqtdl_AAjuxcErWocrtRUH_8T	4e9e899a592616ba4cece8e48991779e	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	lkl	\N	\N	\N	\N	\N	\N	\N	384	\N	lkl	\N	\N	\N	\N	200.48.2.117 	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1387	100	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	92UL60LETSlPUR4fNWUwtFpGs	92UL60LETSlPUR4fNWUwtFpGs	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Desarrollo	\N	\N	\N	\N	\N	\N	\N	384	100	100	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1388	101	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	5wGJRPKV8-sJBSkDEuFKlg_AY	5wGJRPKV8-sJBSkDEuFKlg_AY	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Comunicaciones	\N	\N	\N	\N	\N	\N	\N	384	101	101	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1389	102	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	8fhj1TKrS_byZQO4hoYOnkhyC	8fhj1TKrS_byZQO4hoYOnkhyC	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Redes	\N	\N	\N	\N	\N	\N	\N	384	102	102	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1390	103	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	HT3TYuyZBjdKLpbFGpWXSf3ih	HT3TYuyZBjdKLpbFGpWXSf3ih	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	AdministraciÛn	\N	\N	\N	\N	\N	\N	\N	384	103	103	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1391	104	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	sz1Gbd4iqCP9wWXvKiKBQLjrd	sz1Gbd4iqCP9wWXvKiKBQLjrd	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Contabilidad	\N	\N	\N	\N	\N	\N	\N	384	104	104	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
1392	105	friend	\N	0	\N	\N	\N	\N	\N	\N	yes	registro-corporativo	\N	0.0.0.0/0.0.0.0	\N	BzrHR1YZeCvmeNqGnzhLn7fpE	BzrHR1YZeCvmeNqGnzhLn7fpE	\N	\N	\N	\N	\N	\N	all	alaw;gsm;g729;ulaw	\N	\N	\N	\N	\N	\N	\N	Infraestructura	\N	\N	\N	\N	\N	\N	\N	384	105	105	\N	\N	\N	\N	\N	\N	yes	\N	\N	\N	\N	\N	\N	1	\N	h264	\N	\N
\.


--
-- TOC entry 2971 (class 0 OID 67152)
-- Dependencies: 223
-- Data for Name: sip_buddies_aprov; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY sip_buddies_aprov (id_aprov, id_sip, nu_mac, nu_serie, nu_ip, id_modelo, no_vlan, no_passwd, no_mascara, no_subnet, no_broadcast, no_router, nu_ipcentral, nu_ipmedial, no_dns1, no_dns2) FROM stdin;
\.


--
-- TOC entry 3128 (class 0 OID 0)
-- Dependencies: 224
-- Name: sip_buddies_aprov_id_aprov_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('sip_buddies_aprov_id_aprov_seq', 14, true);


--
-- TOC entry 3129 (class 0 OID 0)
-- Dependencies: 221
-- Name: sip_buddies_id_sip_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('sip_buddies_id_sip_seq', 1392, true);


--
-- TOC entry 2974 (class 0 OID 67159)
-- Dependencies: 226
-- Data for Name: sip_trunk; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY sip_trunk (id_siptru, no_siptru, no_host, no_tiptru, ti_qualify, no_usetru, no_pastru, no_fromus, no_nat, ti_grabacion, ti_uso, no_codecs) FROM stdin;
\.


--
-- TOC entry 3130 (class 0 OID 0)
-- Dependencies: 225
-- Name: sip_trunk_id_siptru_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('sip_trunk_id_siptru_seq', 1, false);


--
-- TOC entry 2975 (class 0 OID 67168)
-- Dependencies: 227
-- Data for Name: tb_appivr; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_appivr (id_appivr, no_appivr, ti_appivr, nu_appivr, ti_uso, va_descrip, va_dialplan) FROM stdin;
37	Noo	INT	233433	1		\N
\.


--
-- TOC entry 3131 (class 0 OID 0)
-- Dependencies: 228
-- Name: tb_appivr_id_appivr_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_appivr_id_appivr_seq', 37, true);


--
-- TOC entry 2977 (class 0 OID 67176)
-- Dependencies: 229
-- Data for Name: tb_aprovis; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_aprovis (id_aprovis, va_dirmac, var_dirip, id_modelo, id_sip) FROM stdin;
\.


--
-- TOC entry 3132 (class 0 OID 0)
-- Dependencies: 230
-- Name: tb_aprovis_id_aprovis_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_aprovis_id_aprovis_seq', 1, false);


--
-- TOC entry 2979 (class 0 OID 67184)
-- Dependencies: 231
-- Data for Name: tb_auxcallcenter; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_auxcallcenter (callid, data2, tiempo) FROM stdin;
\.


--
-- TOC entry 2980 (class 0 OID 67190)
-- Dependencies: 232
-- Data for Name: tb_bolsaempresa; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_bolsaempresa (id_empare, id_tiptel, id_clave, ca_minbol, ca_conmin, ca_resmin, fe_inibol, fe_finbol, fe_ultmod, il_activo) FROM stdin;
\.


--
-- TOC entry 2981 (class 0 OID 67199)
-- Dependencies: 233
-- Data for Name: tb_bolsausuario; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_bolsausuario (id_usuari, id_tiptel, id_clave, ca_minbol, ca_segbol, ca_conseg, ca_resseg, fe_inibol, fe_finbol, fe_ultmod, fe_ultasi, il_actmes, il_activo) FROM stdin;
\.


--
-- TOC entry 2982 (class 0 OID 67210)
-- Dependencies: 234
-- Data for Name: tb_contexto; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_contexto (id_contexto, no_contexto, il_estado) FROM stdin;
2	Plan1	t
\.


--
-- TOC entry 3133 (class 0 OID 0)
-- Dependencies: 235
-- Name: tb_contexto_id_contexto_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_contexto_id_contexto_seq', 2, true);


--
-- TOC entry 2984 (class 0 OID 67215)
-- Dependencies: 236
-- Data for Name: tb_extensionxgrupo; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_extensionxgrupo (id_grupo, id_exten, il_activo) FROM stdin;
\.


--
-- TOC entry 2985 (class 0 OID 67219)
-- Dependencies: 237
-- Data for Name: tb_extensionxperifo; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_extensionxperifo (id_perifo, id_extens, il_activo) FROM stdin;
\.


--
-- TOC entry 2987 (class 0 OID 67225)
-- Dependencies: 239
-- Data for Name: tb_grupo; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_grupo (id_grupo, no_grupo, nu_grupo, il_activo) FROM stdin;
\.


--
-- TOC entry 3134 (class 0 OID 0)
-- Dependencies: 238
-- Name: tb_grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_grupo_id_grupo_seq', 10, true);


--
-- TOC entry 2988 (class 0 OID 67230)
-- Dependencies: 240
-- Data for Name: tb_ivrdet; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_ivrdet (id_ivrdet, id_appivr, id_opcivr, va_opciones, id_parent, nu_priori, nu_subpriori) FROM stdin;
482	37	2	\N	\N	1	0
\.


--
-- TOC entry 3135 (class 0 OID 0)
-- Dependencies: 241
-- Name: tb_ivrdet_id_ivrdet_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_ivrdet_id_ivrdet_seq', 482, true);


--
-- TOC entry 2990 (class 0 OID 67240)
-- Dependencies: 242
-- Data for Name: tb_lista_negra; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_lista_negra (nu_telefo, no_descri, il_activo, co_tipllam) FROM stdin;
9877822780	No contestar	t	IN
\.


--
-- TOC entry 2992 (class 0 OID 67250)
-- Dependencies: 244
-- Data for Name: tb_meetme; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_meetme (id_meetme, no_meetme, nu_meetme, nu_pasadm, nu_pasusu, no_rutbie, nu_maxusu, no_varadm, no_varusu, no_ruthol) FROM stdin;
\.


--
-- TOC entry 3136 (class 0 OID 0)
-- Dependencies: 243
-- Name: tb_meetme_id_meetme_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_meetme_id_meetme_seq', 17, true);


--
-- TOC entry 2994 (class 0 OID 67260)
-- Dependencies: 246
-- Data for Name: tb_mushold; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_mushold (id_mushold, no_mushold, des_mushold, fe_creacion) FROM stdin;
\.


--
-- TOC entry 3137 (class 0 OID 0)
-- Dependencies: 245
-- Name: tb_mushold_id_mushold_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_mushold_id_mushold_seq', 9, true);


--
-- TOC entry 2996 (class 0 OID 67270)
-- Dependencies: 248
-- Data for Name: tb_musica; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_musica (id_musica, no_musica, fe_grabac, no_ruta, nu_priori, il_activo) FROM stdin;
\.


--
-- TOC entry 3138 (class 0 OID 0)
-- Dependencies: 247
-- Name: tb_musica_id_musica_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_musica_id_musica_seq', 47, true);


--
-- TOC entry 2998 (class 0 OID 67282)
-- Dependencies: 250
-- Data for Name: tb_perifoneo; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_perifoneo (id_perifo, no_perifo, nu_perifo, il_activo) FROM stdin;
\.


--
-- TOC entry 3139 (class 0 OID 0)
-- Dependencies: 249
-- Name: tb_perifoneo_id_perifo_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_perifoneo_id_perifo_seq', 1, false);


--
-- TOC entry 2999 (class 0 OID 67290)
-- Dependencies: 251
-- Data for Name: tb_pin; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_pin (id_usupin, id_clave, id_tiptel) FROM stdin;
819	4	2
822	4	2
823	4	2
822	2	1
825	3	1
825	2	2
824	3	2
822	2	2
824	2	2
940	3	1
976	1	1
976	2	1
822	1	1
823	3	1
818	3	2
819	2	1
976	3	1
976	2	2
976	3	2
976	4	2
824	4	2
819	3	2
821	2	1
819	1	1
821	2	2
824	2	1
821	4	2
825	2	1
818	1	1
818	4	2
1020	3	2
1188	1	1
1188	2	2
1190	3	2
\.


--
-- TOC entry 3050 (class 0 OID 70668)
-- Dependencies: 302
-- Data for Name: tb_sip_telefono; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_sip_telefono (id_sip_telefono, name_id_sip, id_marca, id_modelo, no_mac, no_ip_dominio, no_ruta) FROM stdin;
701	lkl	7	13		200.48.2.117 	\N
702	100	7	13	\N	\N	\N
703	101	7	13	\N	\N	\N
704	102	7	13	\N	\N	\N
705	103	7	13	\N	\N	\N
706	104	7	13	\N	\N	\N
631	107	7	13	\N	200.48.2.117 	\N
632	108	7	13	\N	200.48.2.117 	\N
633	109	7	13	\N	200.48.2.117 	\N
707	105	7	13	\N	\N	\N
642	677	7	13	1115654c069e	200.48.2.117 	\N
643	5325	5	4	test	127.0.0.1	c:/ruta/congig
651	107	0	0	\N	200.48.2.117 	\N
652	108	0	0	\N	200.48.2.117 	\N
653	109	0	0	\N	200.48.2.117 	\N
654	110	0	0	\N	200.48.2.117 	\N
655	111	0	0	\N	200.48.2.117 	\N
656	112	0	0	\N	200.48.2.117 	\N
657	113	0	0	\N	200.48.2.117 	\N
658	114	0	0	\N	200.48.2.117 	\N
659	115	0	0	\N	200.48.2.117 	\N
660	116	0	0	\N	200.48.2.117 	\N
661	117	0	0	\N	200.48.2.117 	\N
662	118	0	0	\N	200.48.2.117 	\N
663	119	0	0	\N	200.48.2.117 	\N
664	120	0	0	\N	200.48.2.117 	\N
665	121	0	0	\N	200.48.2.117 	\N
666	122	0	0	\N	200.48.2.117 	\N
667	123	0	0	\N	200.48.2.117 	\N
668	124	0	0	\N	200.48.2.117 	\N
669	125	0	0	\N	200.48.2.117 	\N
670	126	0	0	\N	200.48.2.117 	\N
671	127	0	0	\N	200.48.2.117 	\N
672	128	0	0	\N	200.48.2.117 	\N
673	129	0	0	\N	200.48.2.117 	\N
674	130	0	0	\N	200.48.2.117 	\N
675	131	0	0	\N	200.48.2.117 	\N
676	132	0	0	\N	200.48.2.117 	\N
677	133	0	0	\N	200.48.2.117 	\N
678	134	0	0	\N	200.48.2.117 	\N
679	135	0	0	\N	200.48.2.117 	\N
680	136	0	0	\N	200.48.2.117 	\N
681	137	0	0	\N	200.48.2.117 	\N
682	138	0	0	\N	200.48.2.117 	\N
683	139	0	0	\N	200.48.2.117 	\N
684	140	0	0	\N	200.48.2.117 	\N
685	141	0	0	\N	200.48.2.117 	\N
686	142	0	0	\N	200.48.2.117 	\N
687	143	0	0	\N	200.48.2.117 	\N
688	144	0	0	\N	200.48.2.117 	\N
689	145	0	0	\N	200.48.2.117 	\N
690	146	0	0	\N	200.48.2.117 	\N
691	147	0	0	\N	200.48.2.117 	\N
692	148	0	0	\N	200.48.2.117 	\N
693	149	0	0	\N	200.48.2.117 	\N
694	5334	\N	\N	\N	200.48.2.117 	\N
695	5325	5	4	test	127.0.0.1	c:/ruta/congig
696	5325	5	4	test	127.0.0.1	c:/ruta/congig
698	1000	0	0	\N	200.48.2.117 	\N
699	5325	5	4	test	127.0.0.1	c:/ruta/congig
700	5325	5	4	test	127.0.0.1	c:/ruta/congig
\.


--
-- TOC entry 3140 (class 0 OID 0)
-- Dependencies: 301
-- Name: tb_sip_telefono_id_sip_telefono_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_sip_telefono_id_sip_telefono_seq', 707, true);


--
-- TOC entry 3000 (class 0 OID 67298)
-- Dependencies: 252
-- Data for Name: tb_troncal; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_troncal (id_troncal, no_protocol, no_troncal, no_desc) FROM stdin;
\.


--
-- TOC entry 3141 (class 0 OID 0)
-- Dependencies: 253
-- Name: tb_troncal_id_troncal_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_troncal_id_troncal_seq', 7, true);


--
-- TOC entry 3003 (class 0 OID 67305)
-- Dependencies: 255
-- Data for Name: tb_usuario; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_usuario (id_usuari, no_apepat, no_apemat, no_nombre, no_puesto, nu_pin, ti_llamad, il_activo, il_mostrar, id_empare, il_bolsa, id_sip) FROM stdin;
818	Zegarra	NiÒo	Juan	\N	2d2c8394e31101a261abf1784302bf75	0	f	t	\N	f	\N
825	Plasencia	QuiÒones	Pedro	\N	73c03186765e199c116224b68adc5fa0	0	t	t	\N	f	\N
822	Zavaleta	Justiniano	Betty	\N	c8ba76c279269b1c6bc8a07e38e78fa4	0	f	t	\N	f	\N
819	Valverde	GarcÌa	Porfirio†	\N	7cc532d783a7461f227a5da8ea80bfe1	0	t	t	\N	f	\N
1054	Resta	Villa	Macarena	Programador	f4666b1c34893ee557dccbfe3382e965	120	t	t	114	f	\N
940	Juan	Pere	muda	Contabilidad	dd77279f7d325eec933f05b1672f6a1f	20	t	t	\N	f	\N
1019	Dental	Hilo	Estefani	Redes	298f587406c914fad5373bb689300433	120	t	t	116	f	\N
1020	Chica	Boca	Margo	Redes	4e2ecebbfafe27a7c00e0462fad0873a	120	t	t	118	f	\N
1021	Chupas	Mela	Ami	Programador	1d3d6cb6ad2d65a22f7202ee48687192	120	t	t	112	f	\N
823	V·squez	Gil	Violeta	\N	fbad540b2f3b5638a9be9aa6a4d8e450	0	t	t	\N	f	\N
824	Lezama	Neira	Norma	\N	d4ea5dacfff2d8a35c0952291779290d	0	f	t	\N	f	\N
1024	Hilarion	Barja	Lizbeth	Redes	9bab7341f4429f78ade492da0318aa42	120	t	t	116	f	\N
1035	Marales	Castro	Sandra	Programador	6de59d960d3bb8a6346c058930f3cd28	120	t	t	109	f	\N
1012	Araujo	Orope	Laydi	Contabilidad	7c39a5f991bef4a1e34187677a65871d	120	t	t	107	f	\N
1027	CubA	Marino	Luis	Programador	0ab922ba3e948387b4b2a85fcb83d194	120	t	t	2	f	\N
1031	Lesma	Reina	Carlos	Programador	300ecf93b7224cf439b6de6ee1d6c200	120	t	t	109	f	\N
1040	Cono	Tearrin	Luz	Cableado	56c82ccd658e09e829f16bb99457bcbc	120	t	t	120	f	\N
976	Giron	Maza	Carlos	Sistemas	31a262d6247f3513b19d1149102e116d	3213	t	t	103	f	838
935	Perez	Torres	Juan	\N	ec6a6536ca304edf844d1d248a4f08dc	0	t	t	103	f	\N
821	ArÈvalo	Lozano	Mirian	\N	b59c67bf196a4758191e42f76670ceba	0	t	t	103	f	\N
977	Rivera	Torres	Estanislao	RRHH	2e92962c0b6996add9517e4242ea9bdc	4321	t	t	103	f	845
1044	Rojas	Rojas	Mirian	Programador	acab0116c354964a558e65bdd07ff047	120	t	t	2	f	\N
1047	Reyes	Rojas	Mirian	Contabilidad	7ce30eeb956b8bbdecfdb304b556edba	120	t	t	105	f	\N
1051	Olivera	Carmen	Lucero	Programador	b65f2ecd2900ba6ae49a14d9c4b16fb4	120	t	t	112	f	\N
1061	Mamani	Hurtado	Ester	Contabilidad	e655c7716a4b3ea67f48c6322fc42ed6	120	t	t	121	f	\N
1064	Riquelme	Rioz	Monika	Redes	1415db70fe9ddb119e23e9b2808cde38	120	t	t	103	f	\N
1068	Rojas	Rojas	Omar	Contabilidad	6abba5d8ab1f4f32243e174beb754661	120	t	t	111	f	\N
1070	Orellana	Fuentes	Marta	Redes	07ac7cd13fd0eb1654ccdbd222b81437	120	t	t	103	f	\N
1077	Roto	Cornejo	Pablo	Programador	31ca0ca71184bbdb3de7b20a51e88e90	120	t	t	112	f	\N
1188	Giron	Maza	Car	Sistemas	20d135f0f28185b84a4cf7aa51f29500	100	t	t	175	f	1312
1189	Giron	Maza	Carlos	2	934b535800b1cba8f96a5d72f72f1611	0	t	t	187	f	\N
1190	Giron	Maza	Carlos	\N	e53a0a2978c28872a4505bdb51db06dc	0	t	t	187	f	1337
\.


--
-- TOC entry 3004 (class 0 OID 67312)
-- Dependencies: 256
-- Data for Name: tb_usuario_eliminado; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tb_usuario_eliminado (id_usuari, no_apepat, no_apemat, no_nombre, no_puesto, nu_pin, ti_llamad, il_activo, il_mostrar, id_empare, il_bolsa) FROM stdin;
826	ddd	ddd	dddd	ddada	e3ceb5881a0a1fdaad01296d7554868d	0	t	f	\N	f
826	ddd	ddd	dddd	ddada	e3ceb5881a0a1fdaad01296d7554868d	0	t	f	\N	f
861	juan	manuel	diaz	lalal	82601134b0a4a0385714bc9f06fbd880	123	t	t	19	f
831	Giron	Maza	Carlos	sistemas	81dc9bdb52d04dc20036dbd8313ed055	124	t	t	19	f
844	paterno	materno	daniel	sistemas	f18224a1adfb7b3dbff668c9b655a35a	45323	t	t	21	f
832	Paterno	Materno	Daniel	sistemas	81dc9bdb52d04dc20036dbd8313ed055	1000	t	t	21	f
863	juan2	manuel	diaz	lalal	82601134b0a4a0385714bc9f06fbd880	123	t	t	19	f
845	apepa	ape_mate	nombre	sistemas	b59c67bf196a4758191e42f76670ceba	1111	t	t	19	f
830	giron	maza	carlos	123	e034fb6b66aacc1d48f445ddfb08da98	121	t	t	19	f
833	paterno	Materno	Daniel	sistemas	81dc9bdb52d04dc20036dbd8313ed055	223	t	t	21	f
820	Gonzales	Medina	Mauro	\N	36a773b0b5996caee2eabbb5caa78023	0	f	t	\N	f
865	GirÛn	Maza	Carlos	sistemas	1234	1231	t	t	\N	f
817	Lam	Odicio	Ricardo		4f714c73db5191f3a71a380cba8843ed	0	t	t	\N	f
888	Giron	Maza	carlos	sistemas	81dc9bdb52d04dc20036dbd8313ed055	1234	t	t	19	f
889	Giron	Maza	Carlos	sistemas	81dc9bdb52d04dc20036dbd8313ed055	1234	t	t	21	f
890	Giron	Maza	Carlos	sistemas	9e1e06ec8e02f0a0074f2fcc6b26303b	\N	t	t	19	f
891	Giron	Maza	Carlos	sistemas	21e4ef94f2a6b23597efabaec584b504	3232	t	t	21	f
894	giron	maza	carlos	\N	8dd291cbea8f231982db0fb1716dfc55	\N	t	t	\N	f
896	giron	maza	calos	\N	11c5587af2863955b7c04c59a8732ccc	\N	t	t	\N	f
897	Giron	Maza	Carlos	sistemas	912e79cd13c64069d91da65d62fbb78c	\N	t	t	21	f
898	Giron	Maza	Carlos	sitemas	912e79cd13c64069d91da65d62fbb78c	\N	t	t	\N	f
899	Maza	Hosman	Gion	sistemas	9e1e06ec8e02f0a0074f2fcc6b26303b	\N	t	t	\N	f
900	dada	dasads	afd	carlos	e77dbaf6759253c7c6d0efc5690369c7	\N	t	t	\N	f
901	vsdfvdsvds	vsdfvsfvf	tfevfsfsd	cadcccascaca	14cbd7ab31dba4f0b37818b4286d7549	\N	t	t	21	f
902	csadaacacac	cacacdcdca	frcfvfvs	sssss	2e92962c0b6996add9517e4242ea9bdc	233232	t	t	19	f
905	giron	maza	hosman	sistemas	9e1e06ec8e02f0a0074f2fcc6b26303b	\N	t	t	\N	f
903	giron	maza	car	cacsac	b17187189082540f0f755d80816cde1f	23232	t	t	19	f
904	Giron	Maza	carlos	9876	f42a37d114a480b6b57b60ea9a14a9d2	2332	t	t	19	f
906	giron	maza	carlos	098tfkjhgf	df6d2338b2b8fce1ec2f6dda0a630eb0	\N	t	t	\N	f
907	giron	maza	carlos	ddsdsdsdsddssd	2fc9fd443227117f3e1a2e5fcb6bfe3c	\N	t	t	\N	f
909	Apellido	materno	Nombre	sistemas	e4aed8529014c0251c0834d38a49cd8e	2112	t	t	19	f
908	Giron	Maza	carlos	sistemas	1213	\N	t	t	\N	f
910	paterno	materno	nombre	sistemas	4511dccbea0a3350d8ff72c7648cd678	23232	t	t	19	f
911	giron	maza	hosman	sistemas	c56030557e55275663bd45b48cd0223e	12	t	t	19	f
914	PATERNO	MATERNO	GIRON	SISTEMAS	58b4095fb5335282cc3fde57c643da38	8768	t	t	19	f
915	PATERNO	MATERNO	DANIEL	SISTEMAS	1371bccec2447b5aa6d96d2a540fb401	643	t	t	21	f
866	Paterno	Masterno	Daniel	sistemas	731309c4bb223491a9f67eac5214fb2e	1000	f	t	19	f
913	GIRON	MAZA	CARLOS	SISTEMAS	a4351b79d9ea3d842efa89fae5d02b24	4334	t	t	21	f
912	Giron	Maza	carlos	sistemas	24646475ed957884ca39b0c1d9cc06b2	\N	t	t	\N	f
916	Giron	Maza	Carlos	Sistemas	1111	1000	t	t	19	f
921	Maza	Carlos	Giron	sistemas	fd45ebc1e1d76bc1fe0ba933e60e9957	4332	t	t	24	f
919	Paterno	Materno	Nombre	sistemas	e2a7555f7cabd6e31aef45cb8cda4999	1211	t	t	19	f
917	Maza	Carlos	Giron	\N	b59c67bf196a4758191e42f76670ceba	\N	t	t	\N	f
918	Maza	Carlos	Giron	sistemas	698d51a19d8a121ce581499d7b701668	1111	t	t	\N	f
920	paterno	materno	Prueba nombre	prueba	e2a7555f7cabd6e31aef45cb8cda4999	4322	t	t	21	f
922	Giron	Maza	Carlos	sistemas	2122	2132	t	t	20	f
925	Giro	Maza	Carlos	sistemas	b59c67bf196a4758191e42f76670ceba	1111	t	t	20	f
928	Giron	Maza	Carlo	sistemas	b59c67bf196a4758191e42f76670ceba	111	t	t	20	f
864	raul	manuel	diaz	lalal	82601134b0a4a0385714bc9f06fbd880	123	t	t	19	f
929	giron	maza	carlos	sistema	be8fe4c12c4e43217c06098a2595a950	1111	t	t	20	f
930	carlos	carlos	carlos	sss	b59c67bf196a4758191e42f76670ceba	111	t	t	20	f
932	ewewqweq	ewewqwqe	ewewe	ewqdw	12e086066892a311b752673a28583d3f	232	t	t	20	f
934	ssss	ssss	ssss	2222	934b535800b1cba8f96a5d72f72f1611	\N	t	t	20	f
933	Giron	Mza	Juan	ssss	02b1be0d48924c327124732726097157	1111	t	t	24	f
938	Juan	Pere	muda	Contabilidad	805d94d14046509f82c7bdb1819c64af	20	t	t	\N	f
936	Juan	Perez	muda	Contabilidad	698d51a19d8a121ce581499d7b701668	20	t	t	\N	f
939	Juan	Pere	muda	Contabilidad	dd77279f7d325eec933f05b1672f6a1f	20	t	t	\N	f
937	Juan	Pere	muda	Contabilidad	20d135f0f28185b84a4cf7aa51f29500	20	t	t	\N	f
941	Giron	Maza	carlos	sistemas	81dc9bdb52d04dc20036dbd8313ed055	\N	t	t	20	f
931	Giron	Maza	Carlos	Redes	2e92962c0b6996add9517e4242ea9bdc	\N	f	t	20	f
942	Rivera	Torres	Estanislao	Redes	761c7920f470038d4c8a619c79eddd62	1000	t	t	20	f
943	Giron	Maza	Carlos	redes	2cfd4560539f887a5e420412b370b361	\N	t	t	20	f
979	Peres	Peres	Juan	Redes	12bcd658ef0a540cabc36cdf2b1046fd	5432	t	t	72	f
1032	Rojas	Rojas	Omar	Contabilidad	0738069b244a1c43c83112b735140a16	120	t	t	111	f
1101					6f0442558302a6ededff195daf67f79b	\N	t	t	2	f
1100					df0e09d6f25a15a815563df9827f48fa	\N	t	t	2	f
1142					1d8d70dddf147d2d92a634817f01b239	\N	t	t	2	f
1088					bdd8817990ef209f0fb6b049f2d2ea0c	\N	t	t	2	f
1104					f16ba6f00bce15507c766cd5e8057728	\N	t	t	2	f
1092					cfe8504bda37b575c70ee1a8276f3486	\N	t	t	2	f
1115					90610aa0e24f63ec6d2637e06f9b9af2	\N	t	t	2	f
1114					1f7aa6705d5b742085538c627f6f9c2b	\N	t	t	2	f
1096					c535e3a7f97daf1c4b1eb03cc8e31623	\N	t	t	2	f
1093					86d7c8a08b4aaa1bc7c599473f5dddda	\N	t	t	2	f
1113					531db99cb00833bcd414459069dc7387	\N	t	t	2	f
1112					125b93c9b50703fe9dac43ec231f5f83	\N	t	t	2	f
1125					0e230b1a582d76526b7ad7fc62ae937d	\N	t	t	2	f
1128					236f119f58f5fd102c5a2ca609fdcbd8	\N	t	t	2	f
1085					5fa9e41bfec0725742cc9d15ef594120	\N	t	t	2	f
1084					dfc7defac6624a80f02b02e22b14e8fd	\N	t	t	2	f
1105					f005e17eabbb0d38b06b8a78f3637d85	\N	t	t	2	f
1141					c35bc9eaa4a930e006ab98bf3ef90408	\N	t	t	2	f
1127					ba3c5fe1d6d6708b5bffaeb6942b7e04	\N	t	t	2	f
1126					1f5f5b265100daad35b3a491e1c55351	\N	t	t	2	f
1089					7d0a9bd083154d3d7f429550f7e8fd57	\N	t	t	2	f
1124					4efb80f630ccecb2d3b9b2087b0f9c89	\N	t	t	2	f
1130					e97986091ee430b881ba8fc9755a64a8	\N	t	t	2	f
1129					b1c00bcd4b5183705c134b3365f8c45e	\N	t	t	2	f
1106					69eba34671b3ef1ef38ee85caae6b2a1	\N	t	t	2	f
1108					dd5bfdeb57f7c75d400de61e99d78e2e	\N	t	t	2	f
1146			xxxx		d0b4e54ddd9f0982db522becb8041071	\N	t	t	176	f
1155	herrera	mmmmmmm	misael	\N	27b09e189a405b6cca6ddd7ec869c143	\N	t	t	2	f
1041	Roto	Cornejo	Pablo	Programador	269d837afada308dd4aeab28ca2d57e4	120	t	t	112	f
1059	Roto	Cornejo	Pablo	Programador	055e31fa43e652cb4ab6c0ee845c8d36	120	t	t	112	f
1145	h		misael		815074618f19008da3c78b95a2f5b964	\N	t	t	175	f
1148	h		misaelxx		49265d2447bc3bbfe9e76306ce40a31f	\N	t	t	175	f
1151	h		misaelxx		eba55fca4575e35eec8587f10ba60a43	\N	t	t	175	f
1043	Mamani	Hurtado	Ester	Contabilidad	c54d2118d6a3a2b06f07e9eeb240d741	120	t	t	121	f
1071	Marales	Castro	Sandra	Programador	426bf156ac1bedb84dfe5f44fa510961	120	t	t	109	f
1079	Mamani	Hurtado	Ester	Contabilidad	921c2dc40d0b979c2910298d2f880152	120	t	t	121	f
1025	Mamani	Hurtado	Ester	Contabilidad	b22ed7eafe03b63112ef3ff52f0b99db	120	t	t	121	f
1053	Marales	Castro	Sandra	Programador	6c2fdcf862a752ca2c9e49866a05e1df	120	t	t	109	f
1017	Marales	Castro	Sandra	Programador	9c779f56f336b3c812343434f57b6a0e	120	t	t	109	f
1069	Olivera	Carmen	Lucero	Programador	978d76676f5e7918f81d28e7d092ca0d	120	t	t	112	f
1015	Olivera	Carmen	Lucero	Programador	e2c4a40d50b47094f571e40efead3900	120	t	t	112	f
1033	Olivera	Carmen	Lucero	Programador	b035d6563a2adac9f822940c145263ce	120	t	t	112	f
1034	Orellana	Fuentes	Marta	Redes	94cb02feb750f20bad8a85dfe7e18d11	120	t	t	103	f
1052	Orellana	Fuentes	Marta	Redes	f4dd765c12f2ef67f98f3558c282a9cd	120	t	t	103	f
1016	Orellana	Fuentes	Marta	Redes	38ccdf8d538de2d6a6deb2ed17d1f873	120	t	t	103	f
1018	Resta	Villa	Macarena	Programador	92350dee085a781753d9301fea11d51c	120	t	t	114	f
1036	Resta	Villa	Macarena	Programador	996009f2374006606f4c0b0fda878af1	120	t	t	114	f
1072	Resta	Villa	Macarena	Programador	6a182a16e66268d7ce85fcfe945df787	120	t	t	114	f
1065	Reyes	Rojas	Mirian	Contabilidad	475fbefa9ebfba9233364533aafd02a3	120	t	t	105	f
1010	Riquelme	Rioz	Monika	Redes	e0cd3f16f9e883ca91c2a4c24f47b3d9	120	t	t	103	f
1028	Riquelme	Rioz	Monika	Redes	93da579a65ce84cd1d4c85c2cbb84fc5	120	t	t	103	f
1046	Riquelme	Rioz	Monika	Redes	ac3e2c4e1d4bd07fb973a2ea4d250160	120	t	t	103	f
1062	Rojas	Rojas	Mirian	Programador	39d0a8908fbe6c18039ea8227f827023	120	t	t	2	f
1026	Rojas	Rojas	Mirian	Programador	65fc52ed8f88c81323a418ca94cec2ed	120	t	t	2	f
1008	Rojas	Rojas	Mirian	Programador	0ec04cb3912c4f08874dd03716f80df1	120	t	t	2	f
1014	Rojas	Rojas	Omar	Contabilidad	021f6dd88a11ca489936ae770e4634ad	120	t	t	111	f
1050	Rojas	Rojas	Omar	Contabilidad	9fd98f856d3ca2086168f264a117ed7c	120	t	t	111	f
1023	Roto	Cornejo	Pablo	Programador	da21bae82c02d1e2b8168d57cd3fbab7	120	t	t	112	f
1147			yyyyy		1c303b0eed3133200cf715285011b4e4	\N	t	t	105	f
1153			yyyyyz		74249bfb363306265299ac4ec44d3cb6	\N	t	t	105	f
1152			xxxxyy		fa733611ef13bd333ebfbab7eed14b63	\N	t	t	176	f
1150			yyyyyz		1454ca2270599546dfcd2a3700e4d2f1	\N	t	t	105	f
1149			xxxxyy		f09696910bdd874a99cd74c8f05b5c44	\N	t	t	176	f
1048	Araujo	Orope	Laydi	Contabilidad	d94e18a8adb4cc0f623f7a83b1ac75b4	120	t	t	107	f
1066	Araujo	Orope	Laydi	Contabilidad	c783eed3cfc1c978fe76e15af007e0d0	120	t	t	107	f
1030	Araujo	Orope	Laydi	Contabilidad	e2e5096d574976e8f115a8f1e0ffb52b	120	t	t	107	f
1056	Chica	Boca	Margo	Redes	7d6044e95a16761171b130dcb476a43e	120	t	t	118	f
1038	Chica	Boca	Margo	Redes	3cfbdf468f0a03187f6cee51a25e5e9a	120	t	t	118	f
1074	Chica	Boca	Margo	Redes	cf77e1f8490495e9f8dedceaf372f969	120	t	t	118	f
1075	Chupas	Mela	Ami	Programador	895daa408f494ad58006c47a30f51c1f	120	t	t	112	f
1039	Chupas	Mela	Ami	Programador	048e9aee4ffe42efbf7865f0bd5a2fa4	120	t	t	112	f
1057	Chupas	Mela	Ami	Programador	fc322c6bd467dc6e4a70ece4ce0245f8	120	t	t	112	f
1022	Cono	Tearrin	Luz	Cableado	ff84a9f3c0d335d25413dd8dfc9b2e8f	120	t	t	120	f
1058	Cono	Tearrin	Luz	Cableado	285ab9448d2751ee57ece7f762c39095	120	t	t	120	f
1076	Cono	Tearrin	Luz	Cableado	7eb3c8be3d411e8ebfab08eba5f49632	120	t	t	120	f
1063	CubA	Marino	Luis	Programador	01922cbeae89ad4d79ab769e84e7c5da	120	t	t	2	f
1009	CubA	Marino	Luis	Programador	e93028bdc1aacdfb3687181f2031765d	120	t	t	2	f
1045	CubA	Marino	Luis	Programador	5e2b66750529d8ae895ad2591118466f	120	t	t	2	f
1073	Dental	Hilo	Estefani	Redes	a118806694c9d9b1091fe94039ae462a	120	t	t	116	f
1037	Dental	Hilo	Estefani	Redes	7fd804295ef7f6a2822bf4c61f9dc4a8	120	t	t	116	f
1055	Dental	Hilo	Estefani	Redes	ca851e9f71b25d2d588b7e0d4de3d627	120	t	t	116	f
1042	Hilarion	Barja	Lizbeth	Redes	e148bbf8d64abf4aac7ea4a3c5560aee	120	t	t	116	f
1078	Hilarion	Barja	Lizbeth	Redes	bacadc62d6e67d7897cef027fa2d416c	120	t	t	116	f
1049	Lesma	Reina	Carlos	Programador	75da5036f659fe64b53f3d9b39412967	120	t	t	109	f
1067	Lesma	Reina	Carlos	Programador	751f6b6b02bf39c41025f3bcfd9948ad	120	t	t	109	f
1013	Lesma	Reina	Carlos	Programador	d403137434343677b98efc88cbd5493d	120	t	t	109	f
1011	Reyes	Rojas	Mirian	Contabilidad	c5383525e91474a4e5d7dcfee92c054f	120	t	t	105	f
1029	Reyes	Rojas	Mirian	Contabilidad	fecbfa88f364df34c32702b62f11a7d9	120	t	t	105	f
1060	Hilarion	Barja	Lizbeth	Redes	44d47238d7d3e17aa176019eafac82af	120	t	t	116	f
1158	xxx	rrrtrt	cccc	\N	7c6f8dba4a02404f97b5953d2c4172a7	\N	t	t	2	f
1171	sdsd	ttttt	vvvv		ac34ae1fda29b8fe781ac8d6d32a6bc7	\N	t	t	190	f
1184	sdsd	ttttt	vvvv		d156d4836ea87dd732cfda175b7911cb	\N	t	t	190	f
1161	qwqaadaee	asdadsa	ttttt		785736838d7b51f2cabb00e6b28a8969	\N	t	t	187	f
1160	qwqee	qwqwqwq	cvbgng		3d57fe6de705fec3cecae336ae23a03a	\N	t	t	185	f
1178	www	asadf	ghh	dsds	d042be1b4b72c110d21287b3dad13867	\N	t	t	188	f
1172	www	asadf	ghh	dsds	333ac5d90817d69113471fbb6e531bee	\N	t	t	188	f
1183	www	asadf	ghh	dsds	9c72e0c8882794b79d65f14776a0a974	\N	t	t	188	f
1181	www	asadf	ghh	dsds	c89e6d59f9753e53018cf8de933c1aaa	\N	t	t	188	f
1170	www	asadf	ghh	dsds	8ab7f718012c87aad3887a7d136cdf53	\N	t	t	188	f
1162	www	asadf	ghh	dsds	bf499a12e998d178afd964adf64a60cb	\N	t	t	188	f
1176	www	asadf	ghh	dsds	0dbb3fb9a5cd1d5f8a9075b5bb8070aa	\N	t	t	188	f
1174	www	asadf	ghh	dsds	65f148c815a4ebfaf8eb150460ba94fc	\N	t	t	188	f
1168	www	asadf	ghh	dsds	06a15eb1c3836723b53e4abca8d9b879	\N	t	t	188	f
1164	www	asadf	ghh	dsds	142536b9b535b78e681c11b0195d962f	\N	t	t	188	f
1166	www	asadf	ghh	dsds	99f42c473afe0eb4bd047ae133b851fc	\N	t	t	188	f
1163	sdsd	ttttt	vvvv		15f99f2165aa8c86c9dface16fefd281	\N	t	t	190	f
1156	sdfsf	sfdsfd	jsdjs		80fee67c8a4c4989bf8a580b4bbb0cd2	\N	t	t	184	f
1159	rytyt	uwueuwe	daasas		e894d787e2fd6c133af47140aa156f00	\N	t	t	184	f
1167	sdsd	ttttt	vvvv		624567140fecc40163fed3c45a959a7c	\N	t	t	190	f
1169	sdsd	ttttt	vvvv		588da7a73a2e919a23cb9a419c4c6d44	\N	t	t	190	f
1173	sdsd	ttttt	vvvv		b11b7e3409b27e5c6e332399362105f8	\N	t	t	190	f
1165	sdsd	ttttt	vvvv		e3019767b1b23f82883c9850356b71d6	\N	t	t	190	f
1175	sdsd	ttttt	vvvv		7503cfacd12053d309b6bed5c89de212	\N	t	t	190	f
1177	sdsd	ttttt	vvvv		fa636c3d216834a2e0db24cc157ab5f0	\N	t	t	190	f
1179	sdsd	ttttt	vvvv		c66dd00e5fc44ba8de89d7713fedcd50	\N	t	t	190	f
1182	sdsd	ttttt	vvvv		f39ae9ff3a81f499230c4126e01f421b	\N	t	t	190	f
1157	qwqw	adasd	aaaa		362387494f6be6613daea643a7706a42	0	t	t	188	f
\.


--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 257
-- Name: tb_usuario_eliminado_id_usuari_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_usuario_eliminado_id_usuari_seq', 1, false);


--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 254
-- Name: tb_usuario_id_usuari_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tb_usuario_id_usuari_seq', 1190, true);


--
-- TOC entry 3006 (class 0 OID 67320)
-- Dependencies: 258
-- Data for Name: tbruta_salientes; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tbruta_salientes (id_rutsal, id_tiptel, id_clave, no_rutsal, no_descrip, il_grabar, no_name) FROM stdin;
21	1	1	Ruta1	\N	t	\N
\.


--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 259
-- Name: tbruta_salientes_id_rutsal_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tbruta_salientes_id_rutsal_seq', 21, true);


--
-- TOC entry 3008 (class 0 OID 67328)
-- Dependencies: 260
-- Data for Name: tc_accion; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_accion (id_accion, no_accion, il_activo) FROM stdin;
\.


--
-- TOC entry 3010 (class 0 OID 67334)
-- Dependencies: 262
-- Data for Name: tc_clave; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_clave (id_clave, no_clave, il_activo) FROM stdin;
1	Local	t
2	Nacional	t
3	Internacional	t
4	Rpm	t
\.


--
-- TOC entry 3145 (class 0 OID 0)
-- Dependencies: 261
-- Name: tc_clave_id_clave_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tc_clave_id_clave_seq', 3, true);


--
-- TOC entry 3012 (class 0 OID 67341)
-- Dependencies: 264
-- Data for Name: tc_estado; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_estado (id_estage, no_estage, ti_estado, nu_codigo, il_activo) FROM stdin;
1	Conectado	1	*5641	t
2	Desconectado	0	*5642	t
4	Servicios Higienicos	2	*5644	t
5	Conectado sin ACD	2	*5645	t
6	Entrenamiento	1	*5646	t
7	Retiro a casa	0	*5647	t
8	No disponible	2	*5648	t
3	Pausa	2	*5643	t
\.


--
-- TOC entry 3146 (class 0 OID 0)
-- Dependencies: 263
-- Name: tc_estado_id_estage_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tc_estado_id_estage_seq', 1, false);


--
-- TOC entry 3013 (class 0 OID 67349)
-- Dependencies: 265
-- Data for Name: tc_meetmevar; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_meetmevar (id_meetmevar, no_meetmevar, va_orden) FROM stdin;
m	Solo escuchar administrador	20
q	Modo Silencio	2
c	Anunciar la cantidad de usuarios	3
M	Musica en espera	4
p	Permitir al usuario salir de la conferencia	5
s	Escuchar menu	6
r	Grabar conferencia	7
w	Esperar Administrador	25
\.


--
-- TOC entry 3014 (class 0 OID 67355)
-- Dependencies: 266
-- Data for Name: tc_rutasalcontex; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_rutasalcontex (id_contexto, id_rutsal) FROM stdin;
\.


--
-- TOC entry 3015 (class 0 OID 67358)
-- Dependencies: 267
-- Data for Name: tc_tipcampana; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_tipcampana (id_tipcam, no_campana, il_activo) FROM stdin;
\.


--
-- TOC entry 3016 (class 0 OID 67362)
-- Dependencies: 268
-- Data for Name: tc_tipotelefono; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tc_tipotelefono (id_tiptel, no_tiptel, il_activo) FROM stdin;
1	Fijo	t
2	Celular	t
\.


--
-- TOC entry 3017 (class 0 OID 67369)
-- Dependencies: 269
-- Data for Name: tcdialopc; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcdialopc (id_dialopc, il_parame, no_dialopc, or_dialopc) FROM stdin;
1	t	t	t
2	T	T	t
3	w	w	t
\.


--
-- TOC entry 3018 (class 0 OID 67372)
-- Dependencies: 270
-- Data for Name: tcmarca; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcmarca (id_marca, no_marca, il_activo, il_formato_mac) FROM stdin;
6	SNOM	t	0
7	AKUVOX	t	0
5	YEALINK	t	1
\.


--
-- TOC entry 3147 (class 0 OID 0)
-- Dependencies: 271
-- Name: tcmarca_id_marca_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tcmarca_id_marca_seq', 7, true);


--
-- TOC entry 3020 (class 0 OID 67378)
-- Dependencies: 272
-- Data for Name: tcmodelo; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcmodelo (id_modelo, no_modelo, id_marca, il_activo) FROM stdin;
5	300	6	t
6	370	6	t
2	T21P	5	t
3	T22P	5	t
9	T23G	5	t
10	T42G	5	t
11	T46G	5	t
12	SPR50P	7	t
13	SPR52P	7	t
14	SPR53P	7	t
\.


--
-- TOC entry 3148 (class 0 OID 0)
-- Dependencies: 273
-- Name: tcmodelo_id_modelo_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tcmodelo_id_modelo_seq', 14, true);


--
-- TOC entry 3022 (class 0 OID 67384)
-- Dependencies: 274
-- Data for Name: tcopcivr; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcopcivr (id_opcivr, no_opcivr, ti_opcion, va_urlicon, or_opcion, il_veropc) FROM stdin;
1	Start	1	ivr_icons/start.png	1	f
2	Exten	1	ivr_icons/hashkey.png	2	f
3	Hangup	1	ivr_icons/hang.png	3	f
4	Timeout	1	ivr_icons/timeout.png	4	f
5	Invalid	1	ivr_icons/invalid.png	5	f
6	Answer	2	ivr_icons/answer.png	1	f
7	Background	2	ivr_icons/background.png	2	t
8	Goto	2	ivr_icons/goto.png	3	t
9	GotoIf	2	ivr_icons/gotoif.png	4	t
10	GotoIfTime	2	ivr_icons/gotoiftime.png	5	t
11	Dial	2	ivr_icons/dial.png	6	t
12	Set	2	ivr_icons/set.png	7	t
13	Hangup	2	ivr_icons/hangup.png	8	t
14	WaitExten	2	ivr_icons/waitexten.png	9	t
\.


--
-- TOC entry 3149 (class 0 OID 0)
-- Dependencies: 275
-- Name: tcopcivr_id_opcivr_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tcopcivr_id_opcivr_seq', 14, true);


--
-- TOC entry 3024 (class 0 OID 67391)
-- Dependencies: 276
-- Data for Name: tcruta_detalle; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcruta_detalle (id_rutdet, id_rutsal, no_anteponer, no_regla, nu_priori, nu_prefijo) FROM stdin;
\.


--
-- TOC entry 3150 (class 0 OID 0)
-- Dependencies: 277
-- Name: tcruta_detalle_id_rutdet_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tcruta_detalle_id_rutdet_seq', 22, true);


--
-- TOC entry 3026 (class 0 OID 67397)
-- Dependencies: 278
-- Data for Name: tcrutde_tron; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcrutde_tron (id_rutdet, id_troncal) FROM stdin;
\.


--
-- TOC entry 3027 (class 0 OID 67400)
-- Dependencies: 279
-- Data for Name: tcservicio; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tcservicio (id_servicio, no_servicio, no_nompid, no_cominic, no_comdete, no_comrein, va_orden, il_mostrar) FROM stdin;
2	Postgres	postmaster	service postgresql start	service postgresql stop	service postgresql restart	1	t
3	Apache	httpd	service httpd start	service httpd stop	service httpd restart	2	t
4	Asterisk	asterisk	service asterisk start	service asterisk stop	service asterisk restart	3	t
1	Tiempo	ntpd	service ntpd start	serice ntpd stop	service ntpd restart	4	t
5	Cron	crond	service crond start	service crond stop	service crond restart	5	t
6	Tomcat	/usr/java/jdk1.7.0_09/bin/java	service tomcat60 start	service tomcat60 stop	service tomcat60 start	6	t
\.


--
-- TOC entry 3151 (class 0 OID 0)
-- Dependencies: 280
-- Name: tcservicio_id_servicio_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tcservicio_id_servicio_seq', 4, true);


--
-- TOC entry 3030 (class 0 OID 67409)
-- Dependencies: 282
-- Data for Name: tctipllam; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tctipllam (id_tipllam, no_tipllam, va_orden) FROM stdin;
\.


--
-- TOC entry 3152 (class 0 OID 0)
-- Dependencies: 281
-- Name: tctipllam_id_tipllam_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('tctipllam_id_tipllam_seq', 1, false);


--
-- TOC entry 3031 (class 0 OID 67413)
-- Dependencies: 283
-- Data for Name: tctiptel_clave; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY tctiptel_clave (id_tiptel, id_clave) FROM stdin;
1	1
1	2
1	3
2	2
2	3
2	4
1	4
\.


--
-- TOC entry 3032 (class 0 OID 67416)
-- Dependencies: 284
-- Data for Name: usuarioxarea; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY usuarioxarea (id_usuari, id_empare) FROM stdin;
\.


--
-- TOC entry 3034 (class 0 OID 67421)
-- Dependencies: 286
-- Data for Name: voicemail_users; Type: TABLE DATA; Schema: asterisk; Owner: tintegro
--

COPY voicemail_users (uniqueid, customer_id, context, mailbox, password, fullname, email, pager, attach, saycid, hidefromdir, stamp) FROM stdin;
762	677	registro-corporativo	\N	\N	\N	\N		yes	yes	yes	2017-03-21 18:01:14.55927
763	5325	registro-corporativo	5325	5325	5325	ejemplo@correo.com		yes	yes	yes	2017-03-23 10:21:36.383053
771	107	registro-corporativo	107	107	\N	\N		yes	yes	yes	2017-03-23 10:27:34.088842
772	108	registro-corporativo	108	108	\N	\N		yes	yes	yes	2017-03-23 10:27:35.674442
751	107	registro-corporativo	107	107	\N	\N		yes	yes	yes	2017-03-21 17:39:15.632067
752	108	registro-corporativo	108	108	\N	\N		yes	yes	yes	2017-03-21 17:39:16.019347
773	109	registro-corporativo	109	109	\N	\N		yes	yes	yes	2017-03-23 10:27:42.008584
774	110	registro-corporativo	110	110	\N	\N		yes	yes	yes	2017-03-23 10:27:43.341028
775	111	registro-corporativo	111	111	\N	\N		yes	yes	yes	2017-03-23 10:27:44.770692
753	109	registro-corporativo	109	109	\N	\N		yes	yes	yes	2017-03-21 17:39:16.339018
776	112	registro-corporativo	112	112	\N	\N		yes	yes	yes	2017-03-23 10:27:46.038705
777	113	registro-corporativo	113	113	\N	\N		yes	yes	yes	2017-03-23 10:27:47.386649
778	114	registro-corporativo	114	114	\N	\N		yes	yes	yes	2017-03-23 10:27:49.04688
824	102	registro-corporativo	102	102	Redes	102		yes	yes	yes	2017-04-05 14:31:04.226225
821	lkl	registro-corporativo	lkl	lkl	lkl	fdssfdfdsdfs		yes	yes	yes	2017-03-31 16:19:43.085005
779	115	registro-corporativo	115	115	\N	\N		yes	yes	yes	2017-03-23 10:27:50.713969
780	116	registro-corporativo	116	116	\N	\N		yes	yes	yes	2017-03-23 10:27:52.514386
781	117	registro-corporativo	117	117	\N	\N		yes	yes	yes	2017-03-23 10:27:54.325411
782	118	registro-corporativo	118	118	\N	\N		yes	yes	yes	2017-03-23 10:27:55.900509
783	119	registro-corporativo	119	119	\N	\N		yes	yes	yes	2017-03-23 10:27:57.340364
784	120	registro-corporativo	120	120	\N	\N		yes	yes	yes	2017-03-23 10:28:04.13138
785	121	registro-corporativo	121	121	\N	\N		yes	yes	yes	2017-03-23 10:28:05.502652
786	122	registro-corporativo	122	122	\N	\N		yes	yes	yes	2017-03-23 10:28:06.831084
787	123	registro-corporativo	123	123	\N	\N		yes	yes	yes	2017-03-23 10:28:08.152671
788	124	registro-corporativo	124	124	\N	\N		yes	yes	yes	2017-03-23 10:28:09.614774
789	125	registro-corporativo	125	125	\N	\N		yes	yes	yes	2017-03-23 10:28:11.613275
790	126	registro-corporativo	126	126	\N	\N		yes	yes	yes	2017-03-23 10:28:13.234779
791	127	registro-corporativo	127	127	\N	\N		yes	yes	yes	2017-03-23 10:28:14.885688
792	128	registro-corporativo	128	128	\N	\N		yes	yes	yes	2017-03-23 10:28:16.946265
793	129	registro-corporativo	129	129	\N	\N		yes	yes	yes	2017-03-23 10:28:18.538846
794	130	registro-corporativo	130	130	\N	\N		yes	yes	yes	2017-03-23 10:28:20.599894
795	131	registro-corporativo	131	131	\N	\N		yes	yes	yes	2017-03-23 10:28:24.004956
796	132	registro-corporativo	132	132	\N	\N		yes	yes	yes	2017-03-23 10:28:25.770732
797	133	registro-corporativo	133	133	\N	\N		yes	yes	yes	2017-03-23 10:28:27.17341
798	134	registro-corporativo	134	134	\N	\N		yes	yes	yes	2017-03-23 10:28:28.909765
799	135	registro-corporativo	135	135	\N	\N		yes	yes	yes	2017-03-23 10:28:30.243496
800	136	registro-corporativo	136	136	\N	\N		yes	yes	yes	2017-03-23 10:28:32.054994
801	137	registro-corporativo	137	137	\N	\N		yes	yes	yes	2017-03-23 10:28:33.641432
802	138	registro-corporativo	138	138	\N	\N		yes	yes	yes	2017-03-23 10:28:40.086717
803	139	registro-corporativo	139	139	\N	\N		yes	yes	yes	2017-03-23 10:28:41.644343
804	140	registro-corporativo	140	140	\N	\N		yes	yes	yes	2017-03-23 10:28:43.016807
805	141	registro-corporativo	141	141	\N	\N		yes	yes	yes	2017-03-23 10:28:44.6678
806	142	registro-corporativo	142	142	\N	\N		yes	yes	yes	2017-03-23 10:28:46.550709
807	143	registro-corporativo	143	143	\N	\N		yes	yes	yes	2017-03-23 10:28:48.061903
808	144	registro-corporativo	144	144	\N	\N		yes	yes	yes	2017-03-23 10:28:49.529906
809	145	registro-corporativo	145	145	\N	\N		yes	yes	yes	2017-03-23 10:28:50.857902
810	146	registro-corporativo	146	146	\N	\N		yes	yes	yes	2017-03-23 10:28:52.324923
811	147	registro-corporativo	147	147	\N	\N		yes	yes	yes	2017-03-23 10:28:58.833352
812	148	registro-corporativo	148	148	\N	\N		yes	yes	yes	2017-03-23 10:29:00.540952
813	149	registro-corporativo	149	149	\N	\N		yes	yes	yes	2017-03-23 10:29:02.049237
814	5334	registro-corporativo	5334	5334	233	\N		yes	yes	yes	2017-03-23 10:29:06.489146
815	5325	registro-corporativo	5325	5325	5325	ejemplo@correo.com		yes	yes	yes	2017-03-24 09:33:53.153489
816	5325	registro-corporativo	5325	5325	5325	ejemplo@correo.com		yes	yes	yes	2017-03-24 09:34:39.194889
818	1000	registro-corporativo	1000	1000	Anexo1000	\N		yes	yes	yes	2017-03-29 10:10:28.085605
819	5325	registro-corporativo	5325	5325	5325	ejemplo@correo.com		yes	yes	yes	2017-03-30 09:39:31.091868
820	5325	registro-corporativo	5325	5325	5325	ejemplo@correo.com		yes	yes	yes	2017-03-30 11:16:28.279584
822	100	registro-corporativo	100	100	Desarrollo	100		yes	yes	yes	2017-04-05 14:29:51.929145
823	101	registro-corporativo	101	101	Comunicaciones	101		yes	yes	yes	2017-04-05 14:30:39.377572
825	103	registro-corporativo	103	103	AdministraciÛn	103		yes	yes	yes	2017-04-05 14:31:38.123326
826	104	registro-corporativo	104	104	Contabilidad	104		yes	yes	yes	2017-04-05 14:32:27.480861
827	105	registro-corporativo	105	105	Infraestructura	105		yes	yes	yes	2017-04-05 14:32:54.596305
\.


--
-- TOC entry 3153 (class 0 OID 0)
-- Dependencies: 285
-- Name: voicemail_users_uniqueid_seq; Type: SEQUENCE SET; Schema: asterisk; Owner: tintegro
--

SELECT pg_catalog.setval('voicemail_users_uniqueid_seq', 827, true);


SET search_path = public, pg_catalog;

--
-- TOC entry 3035 (class 0 OID 67427)
-- Dependencies: 287
-- Data for Name: nu_agente; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY nu_agente ("?column?") FROM stdin;
2000
2000
\.


--
-- TOC entry 3036 (class 0 OID 67430)
-- Dependencies: 288
-- Data for Name: salida; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY salida (id_usuari) FROM stdin;
\.


--
-- TOC entry 3037 (class 0 OID 67433)
-- Dependencies: 289
-- Data for Name: tc_estado; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY tc_estado (id_estado, no_estado) FROM stdin;
\.


--
-- TOC entry 3038 (class 0 OID 67439)
-- Dependencies: 290
-- Data for Name: temporal; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY temporal (data1, data2, data3, data4) FROM stdin;
5003	 jef de emergenc:	b23975176653284f1f7356ba5539cfcb	L
5005	 Comic Medica:	0609154fa35b3194026346c9cac2a248	L
5006	 Cood Emerg  Enf:	298923c8190045e91288b430794814c4	L
5007	 Pediatria Emerg:	351869bde8b9d6ad1e3090bd173f600d	L
5008	:	01894d6f048493d2cacde3c579c315a3	L
5010	 Sec Asunto Juri:	53f0d7c537d99b3824f0f99d62ea2428	L
5012	 Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	L
5016	 Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	L
5017	 Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	L
5018	 Und Programacio:	71463aaacf046fa24e7dfa4558607545	L
5019	 Recursos Medico:	e9510081ac30ffa83f10b68cde1cac07	L
5020	:	6b620aedfa4cf153467265629501dd61	L
5021	 Jef Materno Inf:	5d616dd38211ebb5d6ec52986674b6e4	L
5022	 jef espe quirur:	faacbcd5bf1d018912c116bf2783e9a1	L
5023	 Almacen:	883e881bb4d22a7add958f2d6b052c9f	L
5026	 Unidad de Adqui:	2639c6bd2a42e714227b06646829d6ea	L
5027	 Adquisiciones:	853c68de7253cdd55dc37be410a45c60	L
5028	 Jefe Admision:	a2137a2ae8e39b5002a3f8909ecb88fe	L
5034	 Jefe Of Seguros:	ae0909a324fb2530e205e52d40266418	L
5036	 medicina fisica:	e3408432c1a48a52fb6c74d926b38886	L
5040	 Jef. Patrimonio:	649adc59afdef2a8b9e943f94a04b02f	L
5041	 Jefe Prestacion:	0768281a05da9f27df178b5c39a51263	L
5042	 Desp Of Admis:	93d65641ff3f1586614cf2c1ad240b6c	L
5047	 Jefe Legajo:	1dba3025b159cd9354da65e2d0436a31	L
5052	 Jefe UCI:	03e0704b5690a2dee1861dc3ad3316c9	L
5053	 Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	L
5054	 ayuda al diagno:	64eec0c3fb6b12c43f51ec9e9c773fed	L
5055	 Relac Publicas:	1625abb8e458a79765c62009235e9d5b	L
5059	 Finanzas:	96bf57c6ff19504ff145e2a32991ea96	L
5062	 Tramite  Hospit:	bc7316929fe1545bf0b98d114ee3ecb8	L
5074	 Consul Prequiru:	fe7ecc4de28b2c83c016b5c6c2acd826	L
5077	 Jef Sala Operac:	82b8a3434904411a9fdc43ca87cee70c	L
5081	 Jef Cirug Secre:	2bc8ae25856bc2a6a1333d1331a3b7a6	L
5101	 Sercotel:	c315f0320b7cd4ec85756fac52d78076	L
5102	 sere emergencia:	5a751d6a0b6ef05cfe51b86e5d1458e6	L
5109	 remuneraciones:	e3408432c1a48a52fb6c74d926b38886	L
5115	 jEF oDONTOLOGIA:	34609bdc08a07ace4e1526bbb1777673	L
5116	 tramite 3¬∞ piso	878a0658e652765c4979dba411787e43	L
5117	 jef de med int:	0d441de75945e5acbc865406fc9a2559	L
5124	 REMUN:	416849da96fb73bee793e2bf65ae43ac	L
5126	 recursos humano:	757f843a169cc678064d9530d12a1881	L
5127	 Soport Informat:	99f97481f8214da999e3ccbe116f5334	L
5130	 Remuneraciones:	c64a9829fa4638ff5de86330dd227e35	L
5131	 Of Plan Operati:	8744cf92c88433f8cb04a02e6db69a0d	L
5134	 Jef Remuneracio:	b139aeda1c2914e3b579aafd3ceeb1bd	L
5135	 Soport Informat:	962e56a8a0b0420d87272a682bfd1e53	L
5136	 Finanzas:	6d9c547cf146054a5a720606a7694467	L
5137	 Capacitacion:	f33ba15effa5c10e873bf3842afb46a6	L
5138	 sec adminis:	a5329a91ef79db75900bd9cab3d96e43	L
5146	 jef de guardia:	def7924e3199be5e18060bb3e1d547a7	L
5153	 Unid Programaci:	e515df0d202ae52fcebb14295743063b	L
5154	 Und Programacio:	18a411989b47ed75a60ac69d9da05aa5	L
5155	 Und Programacio:	cf866614b6b18cda13fe699a3a65661b	L
5156	 analist. logist:	766d856ef1a6b02f93d894415e6bfa0e	L
5157	 Adquisiciones:	250dd56814ad7c50971ee4020519c6f5	L
5158	 Jef Und Program:	05a5cf06982ba7892ed2a6d38fe832d6	L
5178	 Jefe Visaciones:	6b180037abbebea991d8b1232f8a8ca9	L
5179	 Sec Adquis Logi:	edb947f2bbceb132245fdde9c59d3f59	L
5180	 RECURSOS HUMANO:	5968996e0aca329cf3218086223f8308	L
5182	 tramite hospita:	7a674153c63cff1ad7f0e261c369ab2c	L
5186	 Und Referencia:	84d2004bf28a2095230e8e14993d398d	L
5188	 Fax Jef Contab:	a385d7d1e52d89d1a445faa37f5b5307	L
5189	 Prestaciones:	cee8d6b7ce52554fd70354e37bbf44a2	L
5191	 Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	L
5192	 Almac rayos x:	ecd1b059424d5e0056f579a391d1ead9	L
5200	 Sec Cuerpo Medi:	f4d0e2e7fc057a58f7ca4a391f01940a	L
5203	 Atenc Proveedor:	a01610228fe998f515a72dd730294d87	L
5208	 adquisiciones:	b59c67bf196a4758191e42f76670ceba	L
5213	 Asunto Laboral:	7d3010c11d08cf990b7614d2c2ca9098	L
5229	 Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	L
5230	 Contab Finanzas:	28b9f8aa9f07db88404721af4a5b6c11	L
5230	 finanzas:	a60937eba57758ed45b6d3e91e8659f3	L
5231	 Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	L
5232	 Asist Admision:	46d045ff5190f6ea93739da6c0aa19bc	L
5233	 gerencia quirur:	85f66a7cda62391535fa2bd56811b806	L
5235	 comite de bioet:	398bb4d9a15db2d8bf52b9ca9c8538ee	L
5237	 asesor de geren:	285ab9448d2751ee57ece7f762c39095	L
5238	 RR HH Contratos:	9246444d94f081e3549803b928260f56	L
5242	 Secret. RR.HH:	585869cdf36ea981c9545fcfef880f1d	L
5245	 Fax de recirs H:	fea9c11c4ad9a395a636ed944a28b51a	L
5246	 Secre Direccion:	696b35cc35e710279b9c2dedc08e22d7	L
5251	 Unid Program:	7b7a53e239400a13bd6be6c91c4f6c4e	L
5252	 jef espec medic:	0c9ebb2ded806d7ffda75cd0b95eb70c	L
5256	 Jef. Cirugia:	fc4ddc15f9f4b4b06ef7844d6bb53abf	L
5259	 Jef de Recur Hu:	4462bf0ddbe0d0da40e1e828ebebeb11	L
5265	 Comte Auditoria:	d93591bdf7860e1e4ee2fca799911215	L
5276	 Jef Atc  Aseg:	489d0396e6826eb0c1e611d82ca8b215	L
5281	 Tram Document:	37e7897f62e8d91b1ce60515829ca282	L
5287	 Unid Adqui:	03fa2f7502f5f6b9169e67d17cbf51bb	L
5289	 Prueb de admist:	f2925f97bc13ad2852a7a551802feea0	L
5291	 Jef de atenci p:	7dab099bfda35ad14715763b75487b47	L
5292	 prestaciones:	c02f9de3c2f3040751818aacc7f60b74	L
5294	 Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	L
5297	 U.programacion:	81c2f886f91e18fe16d6f4e865877cb6	L
5303	 Jef. Medicina:	c802ceaa43e6ad9ddc511cab5f34789c	L
5304	 Jef. P. Operati:	c3b7ccc4385e8e1a6847a8358909a1f6	L
5305	 Jef .As .Jurid:	c25e9a36b62f62f58f847fa83c70dc91	L
5306	 Jef Dpto Cirug:	5e8a5161de49c943dd66591511207f50	L
5307	 Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	L
5308	 Jefe Int Sanit:	4a8423d5e91fda00bb7e46540e2b0cf1	L
5313	 Jef Neonatologi:	021bbc7ee20b71134d53e20206bd6feb	L
5314	 Jef Un Mantmto:	acab0116c354964a558e65bdd07ff047	L
5316	 Jefat. Farmacia:	4cc5400e63624c44fadeda99f57588a6	L
5318	 Secre Dir CERP:	4e4e53aa080247bc31d0eb4e7aeb07a0	L
5320	 Direccion Cerp:	b3dd760eb02d2e669c604f6b2f1e803f	L
5329	 Aula Comp Cerp:	00003e3b9e5336685200ae85d21b4f5e	L
5331	 Servico Social:	aec851e565646f6835e915293381e20a	L
5332	 Aseso Empre Dep:	7813d1590d28a7dd372ad54b5d29d033	L
5333	 Ter Ocup Cerp:	caa89215e67b35d504b99a0b22f1c56d	L
5347	 Rotonda CERP:	3fa146219c48a4393aace23e8f353125	L
5348	 Auditoria Cerp:	253f7b5d921338af34da817c00f42753	L
5349	 Ev Integ CERP:	6097d8f3714205740f30debe1166744e	L
5356	 Form Prof CERP:	83241188a22b7d05bd505118b2548723	L
5357	 Int Sec La Cerp:	82debd8a12b498e765a11a8e51159440	L
5359	 Des Emp CERP:	db079083386e2e0885f278fbd1d8a476	L
5361	 Informatica:	a431d70133ef6cf688bc4f6093922b48	L
5362	 Adminis CERP:	dab10c50dc668cd8560df444ff3a4227	L
5363	 Psicologia CERP:	e3bf28b1285c317068f56f7e4446d1a3	L
5365	 Cerp:	b105e5a192f80ef3ec4ee4756af089a3	L
5369	 Jef Dialisis:	912e79cd13c64069d91da65d62fbb78c	L
5382	 Hist Clini Cerp:	1a68e5f4ade56ed1d4bf273e55510750	L
5383	 Serv Soc CERP:	6624b6d8217cf71640993409df58204f	L
5385	 Cafet cerp:	944de8673b0f2d1603a6ff33b18b8192	L
5387	 Of GEst Desarr:	cd3afef9b8b89558cd56638c3631868a	L
5395	 Adquisiciones:	b139aeda1c2914e3b579aafd3ceeb1bd	L
5396	 Jef Contrl Cali:	effffa8deef3c927fefc014850129bb6	L
5397	 Of. Patrimonio:	5bd844f11fa520d54fa5edec06ea2507	L
5411	 Atenc Aseg Emer:	d7a84628c025d30f7b2c52c958767e76	L
5412	 REMUN:	3910d2e3adfd0dc2e3a048f15c11eb74	L
5414	 Prog de adm:	dda99de58ff020cfb57fec1404c97003	L
5416	 consul de oftal:	7f1a65908b05238c21c134c764c89e28	L
5423	 Psiquiatria:	7610db9e380ba9775b3c215346184a87	L
5429	 Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	L
5430	 REMUN:	bec26f4a5bef41402f39699b991bca01	L
5433	 JEFATURA PEDIAT:	49c0b9d84c2a16fcaf9d25694fda75e1	L
5435	 Jef dto uci:	9185f3ec501c674c7c788464a36e7fb3	L
5437	of.asesoria juri:	0a3b6f64f0523984e51323fe53b8c504	L
5442	 Auditoria:	a0dc078ca0d99b5ebb465a9f1cad54ba	L
5453	 depar pediatria:	f3f1b7fc5a8779a9e618e1f23a7b7860	L
5454	 Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	L
5459	 Jef Dep Ciru Ca:	9d05c2d955b24bd5d20b1638156ea0ef	L
5460	 recursos humano:	d1e946f4e67db4b362ad23818a6fb78a	L
5467	 Of Prog CERP:	6e7d2da6d3953058db75714ac400b584	L
5469	 Neumologia:	a3788c8c64fd65c470e23e7534c3ebc8	L
5469	 Plan confianza:	ae06fbdc519bddaa88aa1b24bace4500	L
5470	 OPO:	83691715fdc5baf20ed0742b0b85785b	L
5471	 cirugia emergen:	56c2698facb0e087dd1d2b606a325555	L
5473	 Campa√±a:	ccb421d5f36c5a412816d494b15ca9f6	L
5474	 Referencia:	3806734b256c27e41ec2c6bffa26d9e7	L
5475	 Referencias:	afdec7005cc9f14302cd0474fd0f3c96	L
5481	 Jef Aten Asegu:	56c2698facb0e087dd1d2b606a325555	L
5482	 Gerencia Clinic:	f4f691ac947fd92b7ab3c33d3f90bfed	L
5488	 choferes:	bd6fd20524553da5f0504d31e4134500	L
5492	 Atenc Asegura:	490640b43519c77281cb2f8471e61a71	L
5493	 Cerp:	fdbe012e2e11314b96402b32c0df26b7	L
5494	 Cerp:	85f3375756047fba207ce9b85780313b	L
5521	 Cerp:	8a94ecfa54dcb88a2fa993bfa6388f9e	L
5522	 soporte informa:	d756d3d2b9dac72449a6a6926534558a	L
5524	 Relac publicas:	1175defd049d3301e047ce50d93e9c7a	L
5525	 ofic de persona:	03fa2f7502f5f6b9169e67d17cbf51bb	L
5526	 Relac Publicas:	8c8a58fa97c205ff222de3685497742c	L
5527	 Relac publicas:	36ac8e558ac7690b6f44e2cb5ef93322	L
5532	 RR.HH:	378fb9f589cf7930275f25e4b5afbddd	L
5533	 RRHH:	8965f76632d7672e7d3cf29c87ecaa0c	L
5534	 RR.HH:	de6b1cf3fb0a3aa1244d30f7b8c29c41	L
5539	 com:	30aaf34d6afd4b11cc3b3ac4704c7908	L
5541	 Auditoria Bibtc:	5d50d22735a7469266aab23fd8aeb536	L
5547	 Pagaduria:	220c77af02f8ad8561b150d93000ddff	L
5550	 Of. Seguros:	959ef477884b6ac2241b19ee4fb776ae	L
5551	 Ger. Trami Docu:	68d13cf26c4b4f4f932e3eff990093ba	L
5555	 Und Adquisicion:	d81b9ce93c866abb7f0feb747d88868c	L
5600	:	7610db9e380ba9775b3c215346184a87	L
5542	 Procura :	bd4d08cd70f4be1982372107b3b448ef	L
5371	 jefe ing. hospi:	78719f11fa2df9917de3110133506521	L
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	N
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	N
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	N
5027	Adquisiciones:	853c68de7253cdd55dc37be410a45c60	N
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	N
5127	Soport Informat:	99f97481f8214da999e3ccbe116f5334	N
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	N
5229	Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	N
5230	finanzas:	a60937eba57758ed45b6d3e91e8659f3	N
5231	Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	N
5233	gerencia quirur:	85f66a7cda62391535fa2bd56811b806	N
5237	asesor de geren:	285ab9448d2751ee57ece7f762c39095	N
5245	Fax de recirs H:	fea9c11c4ad9a395a636ed944a28b51a	N
5294	Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	N
5307	Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	N
5429	Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	N
5454	Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	N
5474	Referencia:	3806734b256c27e41ec2c6bffa26d9e7	N
5475	Referencias:	afdec7005cc9f14302cd0474fd0f3c96	N
5371	jefe ing. hospi:	78719f11fa2df9917de3110133506521	N
5003	 jef de emergenc:	b23975176653284f1f7356ba5539cfcb	CL
5005	 Comic Medica:	0609154fa35b3194026346c9cac2a248	CL
5008	:	01894d6f048493d2cacde3c579c315a3	CL
5010	 Sec Asunto Juri:	53f0d7c537d99b3824f0f99d62ea2428	CL
5012	 Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	CL
5016	 Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	CL
5017	 Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	CL
5018	 Und Programacio:	71463aaacf046fa24e7dfa4558607545	CL
5020	                :	6b620aedfa4cf153467265629501dd61	CL
5022	 jef espe quirur:	faacbcd5bf1d018912c116bf2783e9a1	CL
5023	 Almacen:	883e881bb4d22a7add958f2d6b052c9f	CL
5026	 Unidad de Adqui:	2639c6bd2a42e714227b06646829d6ea	CL
5027	 Adquisiciones:	853c68de7253cdd55dc37be410a45c60	CL
5028	 Jefe Admision:	a2137a2ae8e39b5002a3f8909ecb88fe	CL
5034	 Jefe Of Seguros:	ae0909a324fb2530e205e52d40266418	CL
5036	 medicina fisica:	e3408432c1a48a52fb6c74d926b38886	CL
5040	 Jef. Patrimonio:	649adc59afdef2a8b9e943f94a04b02f	CL
5041	 Jefe Prestacion:	0768281a05da9f27df178b5c39a51263	CL
5042	 Desp Of Admis:	93d65641ff3f1586614cf2c1ad240b6c	CL
5047	 Jefe Legajo:	1dba3025b159cd9354da65e2d0436a31	CL
5052	 Jefe UCI:	03e0704b5690a2dee1861dc3ad3316c9	CL
5053	 Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	CL
5054	 ayuda al diagno:	64eec0c3fb6b12c43f51ec9e9c773fed	CL
5055	 Relac Publicas:	1625abb8e458a79765c62009235e9d5b	CL
5059	 Finanzas:	96bf57c6ff19504ff145e2a32991ea96	CL
5062	 Tramite  Hospit:	bc7316929fe1545bf0b98d114ee3ecb8	CL
5074	 Consul Prequiru:	fe7ecc4de28b2c83c016b5c6c2acd826	CL
5077	 Jef Sala Operac:	82b8a3434904411a9fdc43ca87cee70c	CL
5081	 Jef Cirug Secre:	2bc8ae25856bc2a6a1333d1331a3b7a6	CL
5101	 Sercotel:	c315f0320b7cd4ec85756fac52d78076	CL
5102	 sere emergencia:	5a751d6a0b6ef05cfe51b86e5d1458e6	CL
5109	 remuneraciones:	e3408432c1a48a52fb6c74d926b38886	CL
5115	 jEF oDONTOLOGIA:	34609bdc08a07ace4e1526bbb1777673	CL
5117	  jef de med int:	0d441de75945e5acbc865406fc9a2559	CL
5127	 Soport Informat:	99f97481f8214da999e3ccbe116f5334	CL
5134	 Jef Remuneracio:	b139aeda1c2914e3b579aafd3ceeb1bd	CL
5135	 Soport Informat:	962e56a8a0b0420d87272a682bfd1e53	CL
5146	 jef de guardia:	def7924e3199be5e18060bb3e1d547a7	CL
5153	 Unid Programaci:	e515df0d202ae52fcebb14295743063b	CL
5154	 Und Programacio:	18a411989b47ed75a60ac69d9da05aa5	CL
5155	 Und Programacio:	cf866614b6b18cda13fe699a3a65661b	CL
5156	 analist. logist:	766d856ef1a6b02f93d894415e6bfa0e	CL
5157	 Adquisiciones:	250dd56814ad7c50971ee4020519c6f5	CL
5158	 Jef Und Program:	05a5cf06982ba7892ed2a6d38fe832d6	CL
5178	 Jefe Visaciones:	6b180037abbebea991d8b1232f8a8ca9	CL
5179	 Sec Adquis Logi:	edb947f2bbceb132245fdde9c59d3f59	CL
5180	 RECURSOS HUMANO:	5968996e0aca329cf3218086223f8308	CL
5186	 Und Referencia:	84d2004bf28a2095230e8e14993d398d	CL
5189	 Prestaciones:	cee8d6b7ce52554fd70354e37bbf44a2	CL
5191	 Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	CL
5192	 Almac rayos x:	ecd1b059424d5e0056f579a391d1ead9	CL
5203	 Atenc Proveedor:	a01610228fe998f515a72dd730294d87	CL
5208	 adquisiciones:	b59c67bf196a4758191e42f76670ceba	CL
5229	 Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	CL
5230	 Contab Finanzas:	28b9f8aa9f07db88404721af4a5b6c11	CL
5230	 finanzas:	a60937eba57758ed45b6d3e91e8659f3	CL
5231	 Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	CL
5232	 Asist Admision:	46d045ff5190f6ea93739da6c0aa19bc	CL
5233	 gerencia quirur:	85f66a7cda62391535fa2bd56811b806	CL
5235	 comite de bioet:	398bb4d9a15db2d8bf52b9ca9c8538ee	CL
5237	 asesor de geren:	285ab9448d2751ee57ece7f762c39095	CL
5238	 RR HH Contratos:	9246444d94f081e3549803b928260f56	CL
5242	 Secret. RR.HH:	585869cdf36ea981c9545fcfef880f1d	CL
5246	 Secre Direccion:	696b35cc35e710279b9c2dedc08e22d7	CL
5251	 Unid Program:	7b7a53e239400a13bd6be6c91c4f6c4e	CL
5252	 jef espec medic:	0c9ebb2ded806d7ffda75cd0b95eb70c	CL
5256	 Jef. Cirugia:	fc4ddc15f9f4b4b06ef7844d6bb53abf	CL
5259	 Jef de Recur Hu:	4462bf0ddbe0d0da40e1e828ebebeb11	CL
5265	 Comte Auditoria:	d93591bdf7860e1e4ee2fca799911215	CL
5276	 Jef Atc  Aseg:	489d0396e6826eb0c1e611d82ca8b215	CL
5287	 Unid Adqui:	03fa2f7502f5f6b9169e67d17cbf51bb	CL
5289	 Prueb de admist:	f2925f97bc13ad2852a7a551802feea0	CL
5291	 Jef de atenci p:	7dab099bfda35ad14715763b75487b47	CL
5294	 Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	CL
5297	 U.programacion:	81c2f886f91e18fe16d6f4e865877cb6	CL
5303	 Jef. Medicina:	c802ceaa43e6ad9ddc511cab5f34789c	CL
5304	 Jef. P. Operati:	c3b7ccc4385e8e1a6847a8358909a1f6	CL
5305	 Jef .As .Jurid:	c25e9a36b62f62f58f847fa83c70dc91	CL
5306	 Jef Dpto Cirug:	5e8a5161de49c943dd66591511207f50	CL
5307	 Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	CL
5308	 Jefe Int Sanit:	4a8423d5e91fda00bb7e46540e2b0cf1	CL
5313	 Jef Neonatologi:	021bbc7ee20b71134d53e20206bd6feb	CL
5314	 Jef Un Mantmto:	acab0116c354964a558e65bdd07ff047	CL
5316	 Jefat. Farmacia:	4cc5400e63624c44fadeda99f57588a6	CL
5320	 Direccion Cerp:	b3dd760eb02d2e669c604f6b2f1e803f	CL
5329	 Aula Comp Cerp:	00003e3b9e5336685200ae85d21b4f5e	CL
5331	 Servico Social:	aec851e565646f6835e915293381e20a	CL
5332	 Aseso Empre Dep:	7813d1590d28a7dd372ad54b5d29d033	CL
5333	 Ter Ocup Cerp:	caa89215e67b35d504b99a0b22f1c56d	CL
5347	 Rotonda CERP:	3fa146219c48a4393aace23e8f353125	CL
5348	 Auditoria Cerp:	253f7b5d921338af34da817c00f42753	CL
5349	 Ev Integ CERP:	6097d8f3714205740f30debe1166744e	CL
5356	 Form Prof CERP:	83241188a22b7d05bd505118b2548723	CL
5357	 Int Sec La Cerp:	82debd8a12b498e765a11a8e51159440	CL
5359	 Des Emp CERP:	db079083386e2e0885f278fbd1d8a476	CL
5361	 Informatica:	a431d70133ef6cf688bc4f6093922b48	CL
5362	 Adminis CERP:	dab10c50dc668cd8560df444ff3a4227	CL
5363	 Psicologia CERP:	e3bf28b1285c317068f56f7e4446d1a3	CL
5365	 Cerp:	b105e5a192f80ef3ec4ee4756af089a3	CL
5382	 Hist Clini Cerp:	1a68e5f4ade56ed1d4bf273e55510750	CL
5383	 Serv Soc CERP:	6624b6d8217cf71640993409df58204f	CL
5385	 Cafet cerp:	944de8673b0f2d1603a6ff33b18b8192	CL
5387	 Of GEst Desarr:	cd3afef9b8b89558cd56638c3631868a	CL
5395	 Adquisiciones:	b139aeda1c2914e3b579aafd3ceeb1bd	CL
5411	 Atenc Aseg Emer:	d7a84628c025d30f7b2c52c958767e76	CL
5414	 Prog de adm:	dda99de58ff020cfb57fec1404c97003	CL
5416	 consul de oftal:	7f1a65908b05238c21c134c764c89e28	CL
5423	 Psiquiatria:	7610db9e380ba9775b3c215346184a87	CL
5429	 Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	CL
5430	 REMUN:	bec26f4a5bef41402f39699b991bca01	CL
5433	 JEFATURA PEDIAT:	49c0b9d84c2a16fcaf9d25694fda75e1	CL
5435	 Jef dto uci:	9185f3ec501c674c7c788464a36e7fb3	CL
5437	 of.asesoria juri	0a3b6f64f0523984e51323fe53b8c504	CL
5442	 Auditoria:	a0dc078ca0d99b5ebb465a9f1cad54ba	CL
5453	 depar pediatria:	f3f1b7fc5a8779a9e618e1f23a7b7860	CL
5454	 Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	CL
5459	 Jef Dep Ciru Ca:	9d05c2d955b24bd5d20b1638156ea0ef	CL
5460	 recursos humano:	d1e946f4e67db4b362ad23818a6fb78a	CL
5467	 Of Prog CERP:	6e7d2da6d3953058db75714ac400b584	CL
5469	 Neumologia:	a3788c8c64fd65c470e23e7534c3ebc8	CL
5469	 Plan confianza:	ae06fbdc519bddaa88aa1b24bace4500	CL
5470	 OPO:	83691715fdc5baf20ed0742b0b85785b	CL
5471	 cirugia emergen:	56c2698facb0e087dd1d2b606a325555	CL
5473	 Campa√±a:	ccb421d5f36c5a412816d494b15ca9f6	CL
5474	 Referencia:	3806734b256c27e41ec2c6bffa26d9e7	CL
5475	 Referencias:	afdec7005cc9f14302cd0474fd0f3c96	CL
5481	 Jef Aten Asegu:	56c2698facb0e087dd1d2b606a325555	CL
5482	 Gerencia Clinic:	f4f691ac947fd92b7ab3c33d3f90bfed	CL
5492	 Atenc Asegura:	490640b43519c77281cb2f8471e61a71	CL
5493	 Cerp:	fdbe012e2e11314b96402b32c0df26b7	CL
5494	 Cerp:	85f3375756047fba207ce9b85780313b	CL
5521	 Cerp:	8a94ecfa54dcb88a2fa993bfa6388f9e	CL
5522	 soporte informa:	d756d3d2b9dac72449a6a6926534558a	CL
5524	 Relac publicas:	1175defd049d3301e047ce50d93e9c7a	CL
5526	 Relac Publicas:	8c8a58fa97c205ff222de3685497742c	CL
5527	 Relac publicas:	36ac8e558ac7690b6f44e2cb5ef93322	CL
5539	 com:	30aaf34d6afd4b11cc3b3ac4704c7908	CL
5541	 Auditoria Bibtc:	5d50d22735a7469266aab23fd8aeb536	CL
5547	 Pagaduria:	220c77af02f8ad8561b150d93000ddff	CL
5550	 Of. Seguros:	959ef477884b6ac2241b19ee4fb776ae	CL
5551	 Ger. Trami Docu:	68d13cf26c4b4f4f932e3eff990093ba	CL
5555	 Und Adquisicion:	d81b9ce93c866abb7f0feb747d88868c	CL
5600	:	7610db9e380ba9775b3c215346184a87	CL
5542	 Procura :	bd4d08cd70f4be1982372107b3b448ef	CL
5371	 jefe ing. hospi:	78719f11fa2df9917de3110133506521	CL
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	CN
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	CN
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	CN
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	CN
5127	Soport Informat:	99f97481f8214da999e3ccbe116f5334	CN
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	CN
5229	Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	CN
5230	finanzas	a60937eba57758ed45b6d3e91e8659f3	CN
5231	Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	CN
5233	gerencia quirur:	85f66a7cda62391535fa2bd56811b806	CN
5237	asesor de geren:	285ab9448d2751ee57ece7f762c39095	CN
5294	Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	CN
5307	Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	CN
5429	Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	CN
5454	Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	CN
5371	jefe ing. hospi:	78719f11fa2df9917de3110133506521	CN
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	I
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	I
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	I
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	I
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	I
5003	 jef de emergenc:	b23975176653284f1f7356ba5539cfcb	L
5005	 Comic Medica:	0609154fa35b3194026346c9cac2a248	L
5006	 Cood Emerg  Enf:	298923c8190045e91288b430794814c4	L
5007	 Pediatria Emerg:	351869bde8b9d6ad1e3090bd173f600d	L
5008	:	01894d6f048493d2cacde3c579c315a3	L
5010	 Sec Asunto Juri:	53f0d7c537d99b3824f0f99d62ea2428	L
5012	 Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	L
5016	 Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	L
5017	 Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	L
5018	 Und Programacio:	71463aaacf046fa24e7dfa4558607545	L
5019	 Recursos Medico:	e9510081ac30ffa83f10b68cde1cac07	L
5020	:	6b620aedfa4cf153467265629501dd61	L
5021	 Jef Materno Inf:	5d616dd38211ebb5d6ec52986674b6e4	L
5022	 jef espe quirur:	faacbcd5bf1d018912c116bf2783e9a1	L
5023	 Almacen:	883e881bb4d22a7add958f2d6b052c9f	L
5026	 Unidad de Adqui:	2639c6bd2a42e714227b06646829d6ea	L
5027	 Adquisiciones:	853c68de7253cdd55dc37be410a45c60	L
5028	 Jefe Admision:	a2137a2ae8e39b5002a3f8909ecb88fe	L
5034	 Jefe Of Seguros:	ae0909a324fb2530e205e52d40266418	L
5036	 medicina fisica:	e3408432c1a48a52fb6c74d926b38886	L
5040	 Jef. Patrimonio:	649adc59afdef2a8b9e943f94a04b02f	L
5041	 Jefe Prestacion:	0768281a05da9f27df178b5c39a51263	L
5042	 Desp Of Admis:	93d65641ff3f1586614cf2c1ad240b6c	L
5047	 Jefe Legajo:	1dba3025b159cd9354da65e2d0436a31	L
5052	 Jefe UCI:	03e0704b5690a2dee1861dc3ad3316c9	L
5053	 Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	L
5054	 ayuda al diagno:	64eec0c3fb6b12c43f51ec9e9c773fed	L
5055	 Relac Publicas:	1625abb8e458a79765c62009235e9d5b	L
5059	 Finanzas:	96bf57c6ff19504ff145e2a32991ea96	L
5062	 Tramite  Hospit:	bc7316929fe1545bf0b98d114ee3ecb8	L
5074	 Consul Prequiru:	fe7ecc4de28b2c83c016b5c6c2acd826	L
5077	 Jef Sala Operac:	82b8a3434904411a9fdc43ca87cee70c	L
5081	 Jef Cirug Secre:	2bc8ae25856bc2a6a1333d1331a3b7a6	L
5101	 Sercotel:	c315f0320b7cd4ec85756fac52d78076	L
5102	 sere emergencia:	5a751d6a0b6ef05cfe51b86e5d1458e6	L
5109	 remuneraciones:	e3408432c1a48a52fb6c74d926b38886	L
5115	 jEF oDONTOLOGIA:	34609bdc08a07ace4e1526bbb1777673	L
5116	 tramite 3¬∞ piso	878a0658e652765c4979dba411787e43	L
5117	 jef de med int:	0d441de75945e5acbc865406fc9a2559	L
5124	 REMUN:	416849da96fb73bee793e2bf65ae43ac	L
5126	 recursos humano:	757f843a169cc678064d9530d12a1881	L
5127	 Soport Informat:	99f97481f8214da999e3ccbe116f5334	L
5130	 Remuneraciones:	c64a9829fa4638ff5de86330dd227e35	L
5131	 Of Plan Operati:	8744cf92c88433f8cb04a02e6db69a0d	L
5134	 Jef Remuneracio:	b139aeda1c2914e3b579aafd3ceeb1bd	L
5135	 Soport Informat:	962e56a8a0b0420d87272a682bfd1e53	L
5136	 Finanzas:	6d9c547cf146054a5a720606a7694467	L
5137	 Capacitacion:	f33ba15effa5c10e873bf3842afb46a6	L
5138	 sec adminis:	a5329a91ef79db75900bd9cab3d96e43	L
5146	 jef de guardia:	def7924e3199be5e18060bb3e1d547a7	L
5153	 Unid Programaci:	e515df0d202ae52fcebb14295743063b	L
5154	 Und Programacio:	18a411989b47ed75a60ac69d9da05aa5	L
5155	 Und Programacio:	cf866614b6b18cda13fe699a3a65661b	L
5156	 analist. logist:	766d856ef1a6b02f93d894415e6bfa0e	L
5157	 Adquisiciones:	250dd56814ad7c50971ee4020519c6f5	L
5158	 Jef Und Program:	05a5cf06982ba7892ed2a6d38fe832d6	L
5178	 Jefe Visaciones:	6b180037abbebea991d8b1232f8a8ca9	L
5179	 Sec Adquis Logi:	edb947f2bbceb132245fdde9c59d3f59	L
5180	 RECURSOS HUMANO:	5968996e0aca329cf3218086223f8308	L
5182	 tramite hospita:	7a674153c63cff1ad7f0e261c369ab2c	L
5186	 Und Referencia:	84d2004bf28a2095230e8e14993d398d	L
5188	 Fax Jef Contab:	a385d7d1e52d89d1a445faa37f5b5307	L
5189	 Prestaciones:	cee8d6b7ce52554fd70354e37bbf44a2	L
5191	 Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	L
5192	 Almac rayos x:	ecd1b059424d5e0056f579a391d1ead9	L
5200	 Sec Cuerpo Medi:	f4d0e2e7fc057a58f7ca4a391f01940a	L
5203	 Atenc Proveedor:	a01610228fe998f515a72dd730294d87	L
5208	 adquisiciones:	b59c67bf196a4758191e42f76670ceba	L
5213	 Asunto Laboral:	7d3010c11d08cf990b7614d2c2ca9098	L
5229	 Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	L
5230	 Contab Finanzas:	28b9f8aa9f07db88404721af4a5b6c11	L
5230	 finanzas:	a60937eba57758ed45b6d3e91e8659f3	L
5231	 Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	L
5232	 Asist Admision:	46d045ff5190f6ea93739da6c0aa19bc	L
5233	 gerencia quirur:	85f66a7cda62391535fa2bd56811b806	L
5235	 comite de bioet:	398bb4d9a15db2d8bf52b9ca9c8538ee	L
5237	 asesor de geren:	285ab9448d2751ee57ece7f762c39095	L
5238	 RR HH Contratos:	9246444d94f081e3549803b928260f56	L
5242	 Secret. RR.HH:	585869cdf36ea981c9545fcfef880f1d	L
5245	 Fax de recirs H:	fea9c11c4ad9a395a636ed944a28b51a	L
5246	 Secre Direccion:	696b35cc35e710279b9c2dedc08e22d7	L
5251	 Unid Program:	7b7a53e239400a13bd6be6c91c4f6c4e	L
5252	 jef espec medic:	0c9ebb2ded806d7ffda75cd0b95eb70c	L
5256	 Jef. Cirugia:	fc4ddc15f9f4b4b06ef7844d6bb53abf	L
5259	 Jef de Recur Hu:	4462bf0ddbe0d0da40e1e828ebebeb11	L
5265	 Comte Auditoria:	d93591bdf7860e1e4ee2fca799911215	L
5276	 Jef Atc  Aseg:	489d0396e6826eb0c1e611d82ca8b215	L
5281	 Tram Document:	37e7897f62e8d91b1ce60515829ca282	L
5287	 Unid Adqui:	03fa2f7502f5f6b9169e67d17cbf51bb	L
5289	 Prueb de admist:	f2925f97bc13ad2852a7a551802feea0	L
5291	 Jef de atenci p:	7dab099bfda35ad14715763b75487b47	L
5292	 prestaciones:	c02f9de3c2f3040751818aacc7f60b74	L
5294	 Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	L
5297	 U.programacion:	81c2f886f91e18fe16d6f4e865877cb6	L
5303	 Jef. Medicina:	c802ceaa43e6ad9ddc511cab5f34789c	L
5304	 Jef. P. Operati:	c3b7ccc4385e8e1a6847a8358909a1f6	L
5305	 Jef .As .Jurid:	c25e9a36b62f62f58f847fa83c70dc91	L
5306	 Jef Dpto Cirug:	5e8a5161de49c943dd66591511207f50	L
5307	 Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	L
5308	 Jefe Int Sanit:	4a8423d5e91fda00bb7e46540e2b0cf1	L
5313	 Jef Neonatologi:	021bbc7ee20b71134d53e20206bd6feb	L
5314	 Jef Un Mantmto:	acab0116c354964a558e65bdd07ff047	L
5316	 Jefat. Farmacia:	4cc5400e63624c44fadeda99f57588a6	L
5318	 Secre Dir CERP:	4e4e53aa080247bc31d0eb4e7aeb07a0	L
5320	 Direccion Cerp:	b3dd760eb02d2e669c604f6b2f1e803f	L
5329	 Aula Comp Cerp:	00003e3b9e5336685200ae85d21b4f5e	L
5331	 Servico Social:	aec851e565646f6835e915293381e20a	L
5332	 Aseso Empre Dep:	7813d1590d28a7dd372ad54b5d29d033	L
5333	 Ter Ocup Cerp:	caa89215e67b35d504b99a0b22f1c56d	L
5347	 Rotonda CERP:	3fa146219c48a4393aace23e8f353125	L
5348	 Auditoria Cerp:	253f7b5d921338af34da817c00f42753	L
5349	 Ev Integ CERP:	6097d8f3714205740f30debe1166744e	L
5356	 Form Prof CERP:	83241188a22b7d05bd505118b2548723	L
5357	 Int Sec La Cerp:	82debd8a12b498e765a11a8e51159440	L
5359	 Des Emp CERP:	db079083386e2e0885f278fbd1d8a476	L
5361	 Informatica:	a431d70133ef6cf688bc4f6093922b48	L
5362	 Adminis CERP:	dab10c50dc668cd8560df444ff3a4227	L
5363	 Psicologia CERP:	e3bf28b1285c317068f56f7e4446d1a3	L
5365	 Cerp:	b105e5a192f80ef3ec4ee4756af089a3	L
5369	 Jef Dialisis:	912e79cd13c64069d91da65d62fbb78c	L
5382	 Hist Clini Cerp:	1a68e5f4ade56ed1d4bf273e55510750	L
5383	 Serv Soc CERP:	6624b6d8217cf71640993409df58204f	L
5385	 Cafet cerp:	944de8673b0f2d1603a6ff33b18b8192	L
5387	 Of GEst Desarr:	cd3afef9b8b89558cd56638c3631868a	L
5395	 Adquisiciones:	b139aeda1c2914e3b579aafd3ceeb1bd	L
5396	 Jef Contrl Cali:	effffa8deef3c927fefc014850129bb6	L
5397	 Of. Patrimonio:	5bd844f11fa520d54fa5edec06ea2507	L
5411	 Atenc Aseg Emer:	d7a84628c025d30f7b2c52c958767e76	L
5412	 REMUN:	3910d2e3adfd0dc2e3a048f15c11eb74	L
5414	 Prog de adm:	dda99de58ff020cfb57fec1404c97003	L
5416	 consul de oftal:	7f1a65908b05238c21c134c764c89e28	L
5423	 Psiquiatria:	7610db9e380ba9775b3c215346184a87	L
5429	 Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	L
5430	 REMUN:	bec26f4a5bef41402f39699b991bca01	L
5433	 JEFATURA PEDIAT:	49c0b9d84c2a16fcaf9d25694fda75e1	L
5435	 Jef dto uci:	9185f3ec501c674c7c788464a36e7fb3	L
5437	of.asesoria juri:	0a3b6f64f0523984e51323fe53b8c504	L
5442	 Auditoria:	a0dc078ca0d99b5ebb465a9f1cad54ba	L
5453	 depar pediatria:	f3f1b7fc5a8779a9e618e1f23a7b7860	L
5454	 Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	L
5459	 Jef Dep Ciru Ca:	9d05c2d955b24bd5d20b1638156ea0ef	L
5460	 recursos humano:	d1e946f4e67db4b362ad23818a6fb78a	L
5467	 Of Prog CERP:	6e7d2da6d3953058db75714ac400b584	L
5469	 Neumologia:	a3788c8c64fd65c470e23e7534c3ebc8	L
5469	 Plan confianza:	ae06fbdc519bddaa88aa1b24bace4500	L
5470	 OPO:	83691715fdc5baf20ed0742b0b85785b	L
5471	 cirugia emergen:	56c2698facb0e087dd1d2b606a325555	L
5473	 Campa√±a:	ccb421d5f36c5a412816d494b15ca9f6	L
5474	 Referencia:	3806734b256c27e41ec2c6bffa26d9e7	L
5475	 Referencias:	afdec7005cc9f14302cd0474fd0f3c96	L
5481	 Jef Aten Asegu:	56c2698facb0e087dd1d2b606a325555	L
5482	 Gerencia Clinic:	f4f691ac947fd92b7ab3c33d3f90bfed	L
5488	 choferes:	bd6fd20524553da5f0504d31e4134500	L
5492	 Atenc Asegura:	490640b43519c77281cb2f8471e61a71	L
5493	 Cerp:	fdbe012e2e11314b96402b32c0df26b7	L
5494	 Cerp:	85f3375756047fba207ce9b85780313b	L
5521	 Cerp:	8a94ecfa54dcb88a2fa993bfa6388f9e	L
5522	 soporte informa:	d756d3d2b9dac72449a6a6926534558a	L
5524	 Relac publicas:	1175defd049d3301e047ce50d93e9c7a	L
5525	 ofic de persona:	03fa2f7502f5f6b9169e67d17cbf51bb	L
5526	 Relac Publicas:	8c8a58fa97c205ff222de3685497742c	L
5527	 Relac publicas:	36ac8e558ac7690b6f44e2cb5ef93322	L
5532	 RR.HH:	378fb9f589cf7930275f25e4b5afbddd	L
5533	 RRHH:	8965f76632d7672e7d3cf29c87ecaa0c	L
5534	 RR.HH:	de6b1cf3fb0a3aa1244d30f7b8c29c41	L
5539	 com:	30aaf34d6afd4b11cc3b3ac4704c7908	L
5541	 Auditoria Bibtc:	5d50d22735a7469266aab23fd8aeb536	L
5547	 Pagaduria:	220c77af02f8ad8561b150d93000ddff	L
5550	 Of. Seguros:	959ef477884b6ac2241b19ee4fb776ae	L
5551	 Ger. Trami Docu:	68d13cf26c4b4f4f932e3eff990093ba	L
5555	 Und Adquisicion:	d81b9ce93c866abb7f0feb747d88868c	L
5600	:	7610db9e380ba9775b3c215346184a87	L
5542	 Procura :	bd4d08cd70f4be1982372107b3b448ef	L
5371	 jefe ing. hospi:	78719f11fa2df9917de3110133506521	L
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	N
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	N
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	N
5027	Adquisiciones:	853c68de7253cdd55dc37be410a45c60	N
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	N
5127	Soport Informat:	99f97481f8214da999e3ccbe116f5334	N
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	N
5229	Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	N
5230	finanzas:	a60937eba57758ed45b6d3e91e8659f3	N
5231	Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	N
5233	gerencia quirur:	85f66a7cda62391535fa2bd56811b806	N
5237	asesor de geren:	285ab9448d2751ee57ece7f762c39095	N
5245	Fax de recirs H:	fea9c11c4ad9a395a636ed944a28b51a	N
5294	Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	N
5307	Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	N
5429	Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	N
5454	Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	N
5474	Referencia:	3806734b256c27e41ec2c6bffa26d9e7	N
5475	Referencias:	afdec7005cc9f14302cd0474fd0f3c96	N
5371	jefe ing. hospi:	78719f11fa2df9917de3110133506521	N
5003	 jef de emergenc:	b23975176653284f1f7356ba5539cfcb	CL
5005	 Comic Medica:	0609154fa35b3194026346c9cac2a248	CL
5008	:	01894d6f048493d2cacde3c579c315a3	CL
5010	 Sec Asunto Juri:	53f0d7c537d99b3824f0f99d62ea2428	CL
5012	 Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	CL
5016	 Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	CL
5017	 Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	CL
5018	 Und Programacio:	71463aaacf046fa24e7dfa4558607545	CL
5020	                :	6b620aedfa4cf153467265629501dd61	CL
5022	 jef espe quirur:	faacbcd5bf1d018912c116bf2783e9a1	CL
5023	 Almacen:	883e881bb4d22a7add958f2d6b052c9f	CL
5026	 Unidad de Adqui:	2639c6bd2a42e714227b06646829d6ea	CL
5027	 Adquisiciones:	853c68de7253cdd55dc37be410a45c60	CL
5028	 Jefe Admision:	a2137a2ae8e39b5002a3f8909ecb88fe	CL
5034	 Jefe Of Seguros:	ae0909a324fb2530e205e52d40266418	CL
5036	 medicina fisica:	e3408432c1a48a52fb6c74d926b38886	CL
5040	 Jef. Patrimonio:	649adc59afdef2a8b9e943f94a04b02f	CL
5041	 Jefe Prestacion:	0768281a05da9f27df178b5c39a51263	CL
5042	 Desp Of Admis:	93d65641ff3f1586614cf2c1ad240b6c	CL
5047	 Jefe Legajo:	1dba3025b159cd9354da65e2d0436a31	CL
5052	 Jefe UCI:	03e0704b5690a2dee1861dc3ad3316c9	CL
5053	 Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	CL
5054	 ayuda al diagno:	64eec0c3fb6b12c43f51ec9e9c773fed	CL
5055	 Relac Publicas:	1625abb8e458a79765c62009235e9d5b	CL
5059	 Finanzas:	96bf57c6ff19504ff145e2a32991ea96	CL
5062	 Tramite  Hospit:	bc7316929fe1545bf0b98d114ee3ecb8	CL
5074	 Consul Prequiru:	fe7ecc4de28b2c83c016b5c6c2acd826	CL
5077	 Jef Sala Operac:	82b8a3434904411a9fdc43ca87cee70c	CL
5081	 Jef Cirug Secre:	2bc8ae25856bc2a6a1333d1331a3b7a6	CL
5101	 Sercotel:	c315f0320b7cd4ec85756fac52d78076	CL
5102	 sere emergencia:	5a751d6a0b6ef05cfe51b86e5d1458e6	CL
5109	 remuneraciones:	e3408432c1a48a52fb6c74d926b38886	CL
5115	 jEF oDONTOLOGIA:	34609bdc08a07ace4e1526bbb1777673	CL
5117	  jef de med int:	0d441de75945e5acbc865406fc9a2559	CL
5127	 Soport Informat:	99f97481f8214da999e3ccbe116f5334	CL
5134	 Jef Remuneracio:	b139aeda1c2914e3b579aafd3ceeb1bd	CL
5135	 Soport Informat:	962e56a8a0b0420d87272a682bfd1e53	CL
5146	 jef de guardia:	def7924e3199be5e18060bb3e1d547a7	CL
5153	 Unid Programaci:	e515df0d202ae52fcebb14295743063b	CL
5154	 Und Programacio:	18a411989b47ed75a60ac69d9da05aa5	CL
5155	 Und Programacio:	cf866614b6b18cda13fe699a3a65661b	CL
5156	 analist. logist:	766d856ef1a6b02f93d894415e6bfa0e	CL
5157	 Adquisiciones:	250dd56814ad7c50971ee4020519c6f5	CL
5158	 Jef Und Program:	05a5cf06982ba7892ed2a6d38fe832d6	CL
5178	 Jefe Visaciones:	6b180037abbebea991d8b1232f8a8ca9	CL
5179	 Sec Adquis Logi:	edb947f2bbceb132245fdde9c59d3f59	CL
5180	 RECURSOS HUMANO:	5968996e0aca329cf3218086223f8308	CL
5186	 Und Referencia:	84d2004bf28a2095230e8e14993d398d	CL
5189	 Prestaciones:	cee8d6b7ce52554fd70354e37bbf44a2	CL
5191	 Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	CL
5192	 Almac rayos x:	ecd1b059424d5e0056f579a391d1ead9	CL
5203	 Atenc Proveedor:	a01610228fe998f515a72dd730294d87	CL
5208	 adquisiciones:	b59c67bf196a4758191e42f76670ceba	CL
5229	 Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	CL
5230	 Contab Finanzas:	28b9f8aa9f07db88404721af4a5b6c11	CL
5230	 finanzas:	a60937eba57758ed45b6d3e91e8659f3	CL
5231	 Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	CL
5232	 Asist Admision:	46d045ff5190f6ea93739da6c0aa19bc	CL
5233	 gerencia quirur:	85f66a7cda62391535fa2bd56811b806	CL
5235	 comite de bioet:	398bb4d9a15db2d8bf52b9ca9c8538ee	CL
5237	 asesor de geren:	285ab9448d2751ee57ece7f762c39095	CL
5238	 RR HH Contratos:	9246444d94f081e3549803b928260f56	CL
5242	 Secret. RR.HH:	585869cdf36ea981c9545fcfef880f1d	CL
5246	 Secre Direccion:	696b35cc35e710279b9c2dedc08e22d7	CL
5251	 Unid Program:	7b7a53e239400a13bd6be6c91c4f6c4e	CL
5252	 jef espec medic:	0c9ebb2ded806d7ffda75cd0b95eb70c	CL
5256	 Jef. Cirugia:	fc4ddc15f9f4b4b06ef7844d6bb53abf	CL
5259	 Jef de Recur Hu:	4462bf0ddbe0d0da40e1e828ebebeb11	CL
5265	 Comte Auditoria:	d93591bdf7860e1e4ee2fca799911215	CL
5276	 Jef Atc  Aseg:	489d0396e6826eb0c1e611d82ca8b215	CL
5287	 Unid Adqui:	03fa2f7502f5f6b9169e67d17cbf51bb	CL
5289	 Prueb de admist:	f2925f97bc13ad2852a7a551802feea0	CL
5291	 Jef de atenci p:	7dab099bfda35ad14715763b75487b47	CL
5294	 Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	CL
5297	 U.programacion:	81c2f886f91e18fe16d6f4e865877cb6	CL
5303	 Jef. Medicina:	c802ceaa43e6ad9ddc511cab5f34789c	CL
5304	 Jef. P. Operati:	c3b7ccc4385e8e1a6847a8358909a1f6	CL
5305	 Jef .As .Jurid:	c25e9a36b62f62f58f847fa83c70dc91	CL
5306	 Jef Dpto Cirug:	5e8a5161de49c943dd66591511207f50	CL
5307	 Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	CL
5308	 Jefe Int Sanit:	4a8423d5e91fda00bb7e46540e2b0cf1	CL
5313	 Jef Neonatologi:	021bbc7ee20b71134d53e20206bd6feb	CL
5314	 Jef Un Mantmto:	acab0116c354964a558e65bdd07ff047	CL
5316	 Jefat. Farmacia:	4cc5400e63624c44fadeda99f57588a6	CL
5320	 Direccion Cerp:	b3dd760eb02d2e669c604f6b2f1e803f	CL
5329	 Aula Comp Cerp:	00003e3b9e5336685200ae85d21b4f5e	CL
5331	 Servico Social:	aec851e565646f6835e915293381e20a	CL
5332	 Aseso Empre Dep:	7813d1590d28a7dd372ad54b5d29d033	CL
5333	 Ter Ocup Cerp:	caa89215e67b35d504b99a0b22f1c56d	CL
5347	 Rotonda CERP:	3fa146219c48a4393aace23e8f353125	CL
5348	 Auditoria Cerp:	253f7b5d921338af34da817c00f42753	CL
5349	 Ev Integ CERP:	6097d8f3714205740f30debe1166744e	CL
5356	 Form Prof CERP:	83241188a22b7d05bd505118b2548723	CL
5357	 Int Sec La Cerp:	82debd8a12b498e765a11a8e51159440	CL
5359	 Des Emp CERP:	db079083386e2e0885f278fbd1d8a476	CL
5361	 Informatica:	a431d70133ef6cf688bc4f6093922b48	CL
5362	 Adminis CERP:	dab10c50dc668cd8560df444ff3a4227	CL
5363	 Psicologia CERP:	e3bf28b1285c317068f56f7e4446d1a3	CL
5365	 Cerp:	b105e5a192f80ef3ec4ee4756af089a3	CL
5382	 Hist Clini Cerp:	1a68e5f4ade56ed1d4bf273e55510750	CL
5383	 Serv Soc CERP:	6624b6d8217cf71640993409df58204f	CL
5385	 Cafet cerp:	944de8673b0f2d1603a6ff33b18b8192	CL
5387	 Of GEst Desarr:	cd3afef9b8b89558cd56638c3631868a	CL
5395	 Adquisiciones:	b139aeda1c2914e3b579aafd3ceeb1bd	CL
5411	 Atenc Aseg Emer:	d7a84628c025d30f7b2c52c958767e76	CL
5414	 Prog de adm:	dda99de58ff020cfb57fec1404c97003	CL
5416	 consul de oftal:	7f1a65908b05238c21c134c764c89e28	CL
5423	 Psiquiatria:	7610db9e380ba9775b3c215346184a87	CL
5429	 Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	CL
5430	 REMUN:	bec26f4a5bef41402f39699b991bca01	CL
5433	 JEFATURA PEDIAT:	49c0b9d84c2a16fcaf9d25694fda75e1	CL
5435	 Jef dto uci:	9185f3ec501c674c7c788464a36e7fb3	CL
5437	 of.asesoria juri	0a3b6f64f0523984e51323fe53b8c504	CL
5442	 Auditoria:	a0dc078ca0d99b5ebb465a9f1cad54ba	CL
5453	 depar pediatria:	f3f1b7fc5a8779a9e618e1f23a7b7860	CL
5454	 Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	CL
5459	 Jef Dep Ciru Ca:	9d05c2d955b24bd5d20b1638156ea0ef	CL
5460	 recursos humano:	d1e946f4e67db4b362ad23818a6fb78a	CL
5467	 Of Prog CERP:	6e7d2da6d3953058db75714ac400b584	CL
5469	 Neumologia:	a3788c8c64fd65c470e23e7534c3ebc8	CL
5469	 Plan confianza:	ae06fbdc519bddaa88aa1b24bace4500	CL
5470	 OPO:	83691715fdc5baf20ed0742b0b85785b	CL
5471	 cirugia emergen:	56c2698facb0e087dd1d2b606a325555	CL
5473	 Campa√±a:	ccb421d5f36c5a412816d494b15ca9f6	CL
5474	 Referencia:	3806734b256c27e41ec2c6bffa26d9e7	CL
5475	 Referencias:	afdec7005cc9f14302cd0474fd0f3c96	CL
5481	 Jef Aten Asegu:	56c2698facb0e087dd1d2b606a325555	CL
5482	 Gerencia Clinic:	f4f691ac947fd92b7ab3c33d3f90bfed	CL
5492	 Atenc Asegura:	490640b43519c77281cb2f8471e61a71	CL
5493	 Cerp:	fdbe012e2e11314b96402b32c0df26b7	CL
5494	 Cerp:	85f3375756047fba207ce9b85780313b	CL
5521	 Cerp:	8a94ecfa54dcb88a2fa993bfa6388f9e	CL
5522	 soporte informa:	d756d3d2b9dac72449a6a6926534558a	CL
5524	 Relac publicas:	1175defd049d3301e047ce50d93e9c7a	CL
5526	 Relac Publicas:	8c8a58fa97c205ff222de3685497742c	CL
5527	 Relac publicas:	36ac8e558ac7690b6f44e2cb5ef93322	CL
5539	 com:	30aaf34d6afd4b11cc3b3ac4704c7908	CL
5541	 Auditoria Bibtc:	5d50d22735a7469266aab23fd8aeb536	CL
5547	 Pagaduria:	220c77af02f8ad8561b150d93000ddff	CL
5550	 Of. Seguros:	959ef477884b6ac2241b19ee4fb776ae	CL
5551	 Ger. Trami Docu:	68d13cf26c4b4f4f932e3eff990093ba	CL
5555	 Und Adquisicion:	d81b9ce93c866abb7f0feb747d88868c	CL
5600	:	7610db9e380ba9775b3c215346184a87	CL
5542	 Procura :	bd4d08cd70f4be1982372107b3b448ef	CL
5371	 jefe ing. hospi:	78719f11fa2df9917de3110133506521	CL
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	CN
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	CN
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	CN
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	CN
5127	Soport Informat:	99f97481f8214da999e3ccbe116f5334	CN
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	CN
5229	Jef Finanzas:	65cc2c8205a05d7379fa3a6386f710e1	CN
5230	finanzas	a60937eba57758ed45b6d3e91e8659f3	CN
5231	Jef Informatica:	57d3d307ea7a3152cb20d145dd50914b	CN
5233	gerencia quirur:	85f66a7cda62391535fa2bd56811b806	CN
5237	asesor de geren:	285ab9448d2751ee57ece7f762c39095	CN
5294	Asesor II de Ge:	1e4d36177d71bbb3558e43af9577d70e	CN
5307	Jefe Adquisicio:	ebb71045453f38676c40deb9864f811d	CN
5429	Adquisiciones:	2d95666e2649fcfc6e3af75e09f5adb9	CN
5454	Sala Comunicac:	bdb106a0560c4e46ccc488ef010af787	CN
5371	jefe ing. hospi:	78719f11fa2df9917de3110133506521	CN
5012	Desp Geren Medi:	f0873a91b499e265ff6d78ff6e8985a0	I
5016	Recep Central I:	3444fe680f33a865fb00d95d3da98bb9	I
5017	Recep Central 2:	9c9f1366edbae758a3bb56eca4388b64	I
5053	Soport Comunica:	cff02a74da64d145a4aed3a577a106ab	I
5191	Soporte Informa:	a5c236175c8f8de3d6abc00e07ce1fe9	I
\.


SET search_path = reportes, pg_catalog;

--
-- TOC entry 3040 (class 0 OID 67447)
-- Dependencies: 292
-- Data for Name: tb_detalle_llamada; Type: TABLE DATA; Schema: reportes; Owner: tintegro
--

COPY tb_detalle_llamada (id_llamada, fe_inillam, ho_inillam, fe_finllam, ho_finllam, ti_llamada, nu_ani, nu_dni, no_cola, no_agente, ti_convers) FROM stdin;
\.


--
-- TOC entry 3154 (class 0 OID 0)
-- Dependencies: 291
-- Name: tb_detalle_llamada_id_llamada_seq; Type: SEQUENCE SET; Schema: reportes; Owner: tintegro
--

SELECT pg_catalog.setval('tb_detalle_llamada_id_llamada_seq', 1, false);


--
-- TOC entry 3042 (class 0 OID 67456)
-- Dependencies: 294
-- Data for Name: tb_estado_agente; Type: TABLE DATA; Schema: reportes; Owner: tintegro
--

COPY tb_estado_agente (id_estage, co_agente, co_campan, co_estado, fe_iniest, ho_iniest, fe_finest, ho_finest, ti_estmin, ti_estseg) FROM stdin;
66	171	1	1	2014-08-18	09:44:11.512825	2014-08-18	09:48:27.120318	00:04:15	255
67	171	1	2	2014-08-18	09:48:27.120318	2014-08-18	11:10:56.714783	01:22:29	4949
65	170	1	1	2014-08-15	19:44:00.080701	2014-08-18	11:36:04.629635	15:00:00	54000
68	171	1	1	2014-08-18	11:10:56.714783	2014-08-18	11:36:16.468276	00:25:19	1519
69	170	1	2	2014-08-18	11:36:04.629635	2014-08-18	11:48:00.437437	00:11:55	715
71	170	1	1	2014-08-18	11:48:00.437437	2014-08-18	11:49:07.021029	00:01:06	66
72	170	1	2	2014-08-18	11:49:07.021029	2014-08-18	11:57:22.027885	00:08:15	495
83	181	1	1	2014-08-18	12:27:36.430357	2014-08-18	12:29:53.334646	00:02:16	136
79	183	1	1	2014-08-18	12:19:42.366678	2014-08-18	12:30:10.308004	00:10:27	627
84	181	1	2	2014-08-18	12:29:53.334646	2014-08-18	12:30:18.496371	00:00:25	25
85	183	1	2	2014-08-18	12:30:10.308004	2014-08-18	12:31:25.084144	00:01:14	74
80	176	1	1	2014-08-18	12:21:19.28316	2014-08-18	12:37:20.484671	00:16:01	961
89	176	1	2	2014-08-18	12:37:20.484671	2014-08-18	12:41:37.04467	00:04:16	256
77	186	1	1	2014-08-18	12:19:12.527117	2014-08-18	13:23:57.105524	01:04:44	3884
74	179	1	1	2014-08-18	12:18:14.616996	2014-08-18	13:41:02.161775	01:22:47	4967
76	172	1	1	2014-08-18	12:18:50.570026	2014-08-18	13:59:20.830028	01:40:30	6030
90	176	1	1	2014-08-18	12:41:37.04467	2014-08-18	13:59:57.425947	01:18:20	4700
82	174	1	1	2014-08-18	12:24:46.075525	2014-08-18	14:00:04.507091	01:35:18	5718
87	183	1	1	2014-08-18	12:31:25.084144	2014-08-18	14:00:59.898509	01:29:34	5374
86	181	1	1	2014-08-18	12:30:18.496371	2014-08-18	14:01:00.691163	01:30:42	5442
81	180	1	1	2014-08-18	12:23:07.20957	2014-08-18	14:01:44.488117	01:38:37	5917
78	175	1	1	2014-08-18	12:19:39.378087	2014-08-18	14:02:01.868163	01:42:22	6142
75	177	1	1	2014-08-18	12:18:38.094747	2014-08-18	14:03:14.220846	01:44:36	6276
91	186	1	2	2014-08-18	13:23:57.105524	2014-08-18	14:16:18.228721	00:52:21	3141
88	173	1	1	2014-08-18	12:33:28.844756	2014-08-18	15:26:16.003258	02:52:47	10367
105	185	1	1	2014-08-18	14:13:03.968037	2014-08-18	15:57:22.618114	01:44:18	6258
108	185	1	2	2014-08-18	15:57:22.618114	2014-08-18	15:59:08.297893	00:01:45	105
103	187	1	1	2014-08-18	14:10:12.271755	2014-08-18	16:44:28.075601	02:34:15	9255
110	187	1	2	2014-08-18	16:44:28.075601	2014-08-18	16:54:52.872821	00:10:24	624
102	188	1	1	2014-08-18	14:10:05.695588	2014-08-18	20:14:54.230449	06:04:48	21888
112	188	1	2	2014-08-18	20:14:54.230449	2014-08-18	20:15:09.072411	00:00:14	14
113	188	1	1	2014-08-18	20:15:09.072411	2014-08-18	22:00:14.791215	01:45:05	6305
104	184	1	1	2014-08-18	14:12:49.840081	2014-08-18	22:00:26.615787	07:47:36	28056
109	185	1	1	2014-08-18	15:59:08.297893	2014-08-18	22:00:30.873129	06:01:22	21682
111	187	1	1	2014-08-18	16:54:52.872821	2014-08-18	22:00:34.593436	05:05:41	18341
106	186	1	1	2014-08-18	14:16:18.228721	2014-08-18	22:01:00.157635	07:44:41	27881
101	189	1	1	2014-08-18	14:08:08.736518	2014-08-18	22:01:28.623812	07:53:19	28399
64	170	1	2	2014-08-15	19:43:55.246527	2014-08-15	19:44:00.080701	00:00:04	4
98	180	1	2	2014-08-18	14:01:44.488117	2014-08-19	05:58:39.538533	15:00:00	54000
92	179	1	2	2014-08-18	13:41:02.161775	2014-08-19	05:58:55.621247	15:00:00	54000
116	185	1	2	2014-08-18	22:00:30.873129	2014-08-19	06:01:03.197911	15:00:00	54000
97	181	1	2	2014-08-18	14:01:00.691163	2014-08-19	06:01:52.861153	15:00:00	54000
95	174	1	2	2014-08-18	14:00:04.507091	2014-08-19	06:02:48.342623	15:00:00	54000
99	175	1	2	2014-08-18	14:02:01.868163	2014-08-19	06:02:52.08037	15:00:00	54000
94	176	1	2	2014-08-18	13:59:57.425947	2014-08-19	06:05:07.246811	15:00:00	54000
96	183	1	2	2014-08-18	14:00:59.898509	2014-08-19	06:06:50.431871	15:00:00	54000
93	172	1	2	2014-08-18	13:59:20.830028	2014-08-19	06:13:53.426108	15:00:00	54000
100	177	1	2	2014-08-18	14:03:14.220846	2014-08-19	07:01:48.064667	15:00:00	54000
107	173	1	2	2014-08-18	15:26:16.003258	2014-08-19	07:03:02.989805	15:00:00	54000
130	177	1	1	2014-08-19	07:01:48.064667	2014-08-19	07:49:49.555631	00:48:01	2881
132	177	1	2	2014-08-19	07:49:49.555631	2014-08-19	07:50:24.116577	00:00:34	34
128	172	1	1	2014-08-19	06:13:53.426108	2014-08-19	09:33:02.836308	03:19:09	11949
134	172	1	2	2014-08-19	09:33:02.836308	2014-08-19	09:45:31.922123	00:12:29	749
122	185	1	1	2014-08-19	06:01:03.197911	2014-08-19	13:28:27.893129	07:27:24	26844
135	172	1	1	2014-08-19	09:45:31.922123	2014-08-19	13:55:33.646151	04:10:01	15001
137	172	1	2	2014-08-19	13:55:33.646151	2014-08-19	13:55:46.250572	00:00:12	12
129	178	1	1	2014-08-19	06:14:39.312246	2014-08-19	13:58:19.032665	07:43:39	27819
138	172	1	1	2014-08-19	13:55:46.250572	2014-08-19	14:00:16.07038	00:04:29	269
123	181	1	1	2014-08-19	06:01:52.861153	2014-08-19	14:00:27.826608	07:58:34	28714
121	179	1	1	2014-08-19	05:58:55.621247	2014-08-19	14:00:30.783061	08:01:35	28895
125	175	1	1	2014-08-19	06:02:52.08037	2014-08-19	14:00:52.328334	07:58:00	28680
127	183	1	1	2014-08-19	06:06:50.431871	2014-08-19	14:01:05.884574	07:54:15	28455
124	174	1	1	2014-08-19	06:02:48.342623	2014-08-19	14:01:26.430593	07:58:38	28718
126	176	1	1	2014-08-19	06:05:07.246811	2014-08-19	14:03:18.483375	07:58:11	28691
120	180	1	1	2014-08-19	05:58:39.538533	2014-08-19	14:03:37.716277	08:04:58	29098
117	187	1	2	2014-08-18	22:00:34.593436	2014-08-19	14:06:01.395597	15:00:00	54000
118	186	1	2	2014-08-18	22:01:00.157635	2014-08-19	14:09:04.786438	15:00:00	54000
119	189	1	2	2014-08-18	22:01:28.623812	2014-08-19	14:09:34.146749	15:00:00	54000
115	184	1	2	2014-08-18	22:00:26.615787	2014-08-19	14:34:38.455968	15:00:00	54000
133	177	1	1	2014-08-19	07:50:24.116577	2014-08-19	14:35:21.502585	06:44:57	24297
145	174	1	2	2014-08-19	14:01:26.430593	2014-08-20	06:02:08.35424	15:00:00	54000
143	175	1	2	2014-08-19	14:00:52.328334	2014-08-20	06:02:28.797209	15:00:00	54000
146	176	1	2	2014-08-19	14:03:18.483375	2014-08-20	06:02:50.495954	15:00:00	54000
141	181	1	2	2014-08-19	14:00:27.826608	2014-08-20	06:06:46.768103	15:00:00	54000
140	172	1	2	2014-08-19	14:00:16.07038	2014-08-20	06:10:53.052218	15:00:00	54000
147	180	1	2	2014-08-19	14:03:37.716277	2014-08-20	07:48:33.952702	15:00:00	54000
70	171	1	2	2014-08-18	11:36:16.468276	2014-08-21	06:07:51.511204	15:00:00	54000
114	188	1	2	2014-08-18	22:00:14.791215	2014-08-19	14:06:16.749969	15:00:00	54000
136	185	1	2	2014-08-19	13:28:27.893129	2014-08-19	14:09:47.73529	00:41:19	2479
150	186	1	1	2014-08-19	14:09:04.786438	2014-08-19	14:34:40.971443	00:25:36	1536
154	186	1	2	2014-08-19	14:34:40.971443	2014-08-19	14:41:46.358496	00:07:05	425
131	173	1	1	2014-08-19	07:03:02.989805	2014-08-19	14:57:18.585153	07:54:15	28455
152	185	1	1	2014-08-19	14:09:47.73529	2014-08-19	15:56:32.387294	01:46:44	6404
158	185	1	2	2014-08-19	15:56:32.387294	2014-08-19	15:57:10.575339	00:00:38	38
149	188	1	1	2014-08-19	14:06:16.749969	2014-08-19	16:01:27.020456	01:55:10	6910
160	188	1	2	2014-08-19	16:01:27.020456	2014-08-19	16:03:50.168115	00:02:23	143
151	189	1	1	2014-08-19	14:09:34.146749	2014-08-19	16:13:07.491778	02:03:33	7413
162	189	1	2	2014-08-19	16:13:07.491778	2014-08-19	16:34:01.017954	00:20:53	1253
159	185	1	1	2014-08-19	15:57:10.575339	2014-08-19	22:00:28.782867	06:03:18	21798
153	184	1	1	2014-08-19	14:34:38.455968	2014-08-19	22:00:44.722827	07:26:06	26766
161	188	1	1	2014-08-19	16:03:50.168115	2014-08-19	22:00:50.958135	05:57:00	21420
156	186	1	1	2014-08-19	14:41:46.358496	2014-08-19	22:00:56.667498	07:19:10	26350
163	189	1	1	2014-08-19	16:34:01.017954	2014-08-19	22:01:20.378517	05:27:19	19639
148	187	1	1	2014-08-19	14:06:01.395597	2014-08-19	22:01:34.775185	07:55:33	28533
142	179	1	2	2014-08-19	14:00:30.783061	2014-08-20	06:02:14.315314	15:00:00	54000
169	187	1	2	2014-08-19	22:01:34.775185	2014-08-20	06:02:38.221695	15:00:00	54000
172	175	1	1	2014-08-20	06:02:28.797209	2014-08-20	06:03:46.453482	00:01:17	77
144	183	1	2	2014-08-19	14:01:05.884574	2014-08-20	06:04:03.255395	15:00:00	54000
139	178	1	2	2014-08-19	13:58:19.032665	2014-08-20	06:18:06.714148	15:00:00	54000
175	175	1	2	2014-08-20	06:03:46.453482	2014-08-20	06:56:20.186358	00:52:33	3153
157	173	1	2	2014-08-19	14:57:18.585153	2014-08-20	07:06:24.996645	15:00:00	54000
155	177	1	2	2014-08-19	14:35:21.502585	2014-08-20	07:06:26.352357	15:00:00	54000
181	173	1	1	2014-08-20	07:06:24.996645	2014-08-20	12:06:21.474085	04:59:56	17996
184	173	1	2	2014-08-20	12:06:21.474085	2014-08-20	12:06:28.62908	00:00:07	7
173	187	1	1	2014-08-20	06:02:38.221695	2014-08-20	13:29:18.827427	07:26:40	26800
179	178	1	1	2014-08-20	06:18:06.714148	2014-08-20	13:38:34.381058	07:20:27	26427
187	178	1	2	2014-08-20	13:38:34.381058	2014-08-20	13:38:55.316794	00:00:20	20
182	177	1	1	2014-08-20	07:06:26.352357	2014-08-20	13:50:03.763083	06:43:37	24217
189	177	1	2	2014-08-20	13:50:03.763083	2014-08-20	13:50:20.687543	00:00:16	16
174	176	1	1	2014-08-20	06:02:50.495954	2014-08-20	13:59:39.700767	07:56:49	28609
178	172	1	1	2014-08-20	06:10:53.052218	2014-08-20	13:59:50.33439	07:48:57	28137
170	174	1	1	2014-08-20	06:02:08.35424	2014-08-20	14:00:17.14978	07:58:08	28688
176	183	1	1	2014-08-20	06:04:03.255395	2014-08-20	14:00:39.518174	07:56:36	28596
183	180	1	1	2014-08-20	07:48:33.952702	2014-08-20	14:01:22.358135	06:12:48	22368
177	181	1	1	2014-08-20	06:06:46.768103	2014-08-20	14:01:25.704159	07:54:38	28478
188	178	1	1	2014-08-20	13:38:55.316794	2014-08-20	14:01:37.851981	00:22:42	1362
171	179	1	1	2014-08-20	06:02:14.315314	2014-08-20	14:02:06.621445	07:59:52	28792
168	189	1	2	2014-08-19	22:01:20.378517	2014-08-20	14:06:15.165063	15:00:00	54000
166	188	1	2	2014-08-19	22:00:50.958135	2014-08-20	14:07:05.279223	15:00:00	54000
165	184	1	2	2014-08-19	22:00:44.722827	2014-08-20	14:07:15.758789	15:00:00	54000
164	185	1	2	2014-08-19	22:00:28.782867	2014-08-20	14:08:24.117681	15:00:00	54000
186	187	1	2	2014-08-20	13:29:18.827427	2014-08-20	14:09:34.675542	00:40:15	2415
167	186	1	2	2014-08-19	22:00:56.667498	2014-08-20	14:09:46.313918	15:00:00	54000
185	173	1	1	2014-08-20	12:06:28.62908	2014-08-20	14:59:13.696263	02:52:45	10365
190	177	1	1	2014-08-20	13:50:20.687543	2014-08-20	15:00:50.199357	01:10:29	4229
202	185	1	1	2014-08-20	14:08:24.117681	2014-08-20	19:15:37.072239	05:07:12	18432
207	185	1	2	2014-08-20	19:15:37.072239	2014-08-20	19:15:46.636331	00:00:09	9
204	186	1	1	2014-08-20	14:09:46.313918	2014-08-20	19:33:41.163911	05:23:54	19434
209	186	1	2	2014-08-20	19:33:41.163911	2014-08-20	19:33:48.36502	00:00:07	7
201	184	1	1	2014-08-20	14:07:15.758789	2014-08-20	22:00:38.368547	07:53:22	28402
210	186	1	1	2014-08-20	19:33:48.36502	2014-08-20	22:00:38.945004	02:26:50	8810
200	188	1	1	2014-08-20	14:07:05.279223	2014-08-20	22:00:45.145758	07:53:39	28419
208	185	1	1	2014-08-20	19:15:46.636331	2014-08-20	22:00:55.816009	02:45:09	9909
203	187	1	1	2014-08-20	14:09:34.675542	2014-08-20	22:00:57.520456	07:51:22	28282
199	189	1	1	2014-08-20	14:06:15.165063	2014-08-20	22:01:17.277242	07:55:02	28502
195	180	1	2	2014-08-20	14:01:22.358135	2014-08-21	05:58:40.048067	15:00:00	54000
198	179	1	2	2014-08-20	14:02:06.621445	2014-08-21	06:01:26.391849	15:00:00	54000
196	181	1	2	2014-08-20	14:01:25.704159	2014-08-21	06:01:35.888509	15:00:00	54000
197	178	1	2	2014-08-20	14:01:37.851981	2014-08-21	06:04:48.394674	15:00:00	54000
193	174	1	2	2014-08-20	14:00:17.14978	2014-08-21	06:05:17.125245	15:00:00	54000
194	183	1	2	2014-08-20	14:00:39.518174	2014-08-21	06:06:12.658039	15:00:00	54000
192	172	1	2	2014-08-20	13:59:50.33439	2014-08-21	06:09:57.801566	15:00:00	54000
191	176	1	2	2014-08-20	13:59:39.700767	2014-08-21	06:20:59.288526	15:00:00	54000
206	177	1	2	2014-08-20	15:00:50.199357	2014-08-21	06:59:59.616177	15:00:00	54000
218	179	1	1	2014-08-21	06:01:26.391849	2014-08-21	08:10:12.578682	02:08:46	7726
224	172	1	1	2014-08-21	06:09:57.801566	2014-08-21	13:59:30.461718	07:49:32	28172
220	178	1	1	2014-08-21	06:04:48.394674	2014-08-21	13:59:42.399222	07:54:54	28494
225	176	1	1	2014-08-21	06:20:59.288526	2014-08-21	14:00:54.883912	07:39:55	27595
222	183	1	1	2014-08-21	06:06:12.658039	2014-08-21	14:00:58.174671	07:54:45	28485
219	181	1	1	2014-08-21	06:01:35.888509	2014-08-21	14:02:09.362249	08:00:33	28833
216	189	1	2	2014-08-20	22:01:17.277242	2014-08-21	14:04:38.82698	15:00:00	54000
212	186	1	2	2014-08-20	22:00:38.945004	2014-08-21	14:07:10.24173	15:00:00	54000
211	184	1	2	2014-08-20	22:00:38.368547	2014-08-21	14:08:42.82543	15:00:00	54000
214	185	1	2	2014-08-20	22:00:55.816009	2014-08-21	14:09:59.846747	15:00:00	54000
205	173	1	2	2014-08-20	14:59:13.696263	2014-08-21	07:06:13.911402	15:00:00	54000
228	179	1	2	2014-08-21	08:10:12.578682	2014-08-21	08:10:23.625824	00:00:11	11
221	174	1	1	2014-08-21	06:05:17.125245	2014-08-21	10:00:33.512822	03:55:16	14116
217	180	1	1	2014-08-21	05:58:40.048067	2014-08-21	14:00:41.948183	08:02:01	28921
223	171	1	1	2014-08-21	06:07:51.511204	2014-08-21	14:00:59.09593	07:53:07	28387
229	179	1	1	2014-08-21	08:10:23.625824	2014-08-21	14:01:10.937382	05:50:47	21047
215	187	1	2	2014-08-20	22:00:57.520456	2014-08-21	14:07:04.235024	15:00:00	54000
213	188	1	2	2014-08-20	22:00:45.145758	2014-08-21	14:08:52.981022	15:00:00	54000
227	173	1	1	2014-08-21	07:06:13.911402	2014-08-21	15:03:49.697277	07:57:35	28655
226	177	1	1	2014-08-21	06:59:59.616177	2014-08-21	15:05:01.563868	08:05:01	29101
241	186	1	1	2014-08-21	14:07:10.24173	2014-08-21	22:00:49.452077	07:53:39	28419
243	188	1	1	2014-08-21	14:08:52.981022	2014-08-21	22:00:53.275736	07:52:00	28320
242	184	1	1	2014-08-21	14:08:42.82543	2014-08-21	22:01:08.494452	07:52:25	28345
240	187	1	1	2014-08-21	14:07:04.235024	2014-08-21	22:01:11.22669	07:54:06	28446
244	185	1	1	2014-08-21	14:09:59.846747	2014-08-21	22:01:11.677936	07:51:11	28271
239	189	1	1	2014-08-21	14:04:38.82698	2014-08-21	22:01:20.318487	07:56:41	28601
233	180	1	2	2014-08-21	14:00:41.948183	2014-08-22	05:59:04.834063	15:00:00	54000
232	178	1	2	2014-08-21	13:59:42.399222	2014-08-22	06:00:59.512751	15:00:00	54000
234	176	1	2	2014-08-21	14:00:54.883912	2014-08-22	06:01:19.545513	15:00:00	54000
237	179	1	2	2014-08-21	14:01:10.937382	2014-08-22	06:01:52.823854	15:00:00	54000
238	181	1	2	2014-08-21	14:02:09.362249	2014-08-22	06:02:12.888917	15:00:00	54000
236	171	1	2	2014-08-21	14:00:59.09593	2014-08-22	06:02:17.833094	15:00:00	54000
246	177	1	2	2014-08-21	15:05:01.563868	2014-08-22	06:02:28.969632	15:00:00	54000
230	174	1	2	2014-08-21	10:00:33.512822	2014-08-22	06:02:38.87948	15:00:00	54000
235	183	1	2	2014-08-21	14:00:58.174671	2014-08-22	06:04:53.172844	15:00:00	54000
231	172	1	2	2014-08-21	13:59:30.461718	2014-08-22	06:05:35.652367	15:00:00	54000
245	173	1	2	2014-08-21	15:03:49.697277	2014-08-22	07:08:17.844318	15:00:00	54000
262	172	1	1	2014-08-22	06:05:35.652367	2014-08-22	12:32:50.648259	06:27:14	23234
260	174	1	1	2014-08-22	06:02:38.87948	2014-08-22	13:54:00.21833	07:51:21	28281
253	180	1	1	2014-08-22	05:59:04.834063	2014-08-22	13:59:57.151853	08:00:52	28852
255	176	1	1	2014-08-22	06:01:19.545513	2014-08-22	14:00:46.63543	07:59:27	28767
257	181	1	1	2014-08-22	06:02:12.888917	2014-08-22	14:00:55.867897	07:58:42	28722
254	178	1	1	2014-08-22	06:00:59.512751	2014-08-22	14:01:13.395623	08:00:13	28813
261	183	1	1	2014-08-22	06:04:53.172844	2014-08-22	14:01:18.556561	07:56:25	28585
258	171	1	1	2014-08-22	06:02:17.833094	2014-08-22	14:01:47.01175	07:59:29	28769
256	179	1	1	2014-08-22	06:01:52.823854	2014-08-22	14:02:11.138457	08:00:18	28818
252	189	1	2	2014-08-21	22:01:20.318487	2014-08-22	14:06:48.3298	15:00:00	54000
259	177	1	1	2014-08-22	06:02:28.969632	2014-08-22	14:07:02.127402	08:04:33	29073
248	188	1	2	2014-08-21	22:00:53.275736	2014-08-22	14:07:51.048463	15:00:00	54000
250	187	1	2	2014-08-21	22:01:11.22669	2014-08-22	14:08:03.747265	15:00:00	54000
251	185	1	2	2014-08-21	22:01:11.677936	2014-08-22	14:09:27.323607	15:00:00	54000
247	186	1	2	2014-08-21	22:00:49.452077	2014-08-22	14:10:43.608011	15:00:00	54000
249	184	1	2	2014-08-21	22:01:08.494452	2014-08-22	14:11:17.57876	15:00:00	54000
263	173	1	1	2014-08-22	07:08:17.844318	2014-08-22	15:02:20.941793	07:54:03	28443
276	187	1	1	2014-08-22	14:08:03.747265	2014-08-22	18:14:55.601454	04:06:51	14811
281	187	1	2	2014-08-22	18:14:55.601454	2014-08-22	20:57:20.652246	02:42:25	9745
278	186	1	1	2014-08-22	14:10:43.608011	2014-08-22	22:01:22.980889	07:50:39	28239
275	188	1	1	2014-08-22	14:07:51.048463	2014-08-22	22:01:29.207392	07:53:38	28418
279	184	1	1	2014-08-22	14:11:17.57876	2014-08-22	22:01:30.394514	07:50:12	28212
282	187	1	1	2014-08-22	20:57:20.652246	2014-08-22	22:01:43.317264	01:04:22	3862
277	185	1	1	2014-08-22	14:09:27.323607	2014-08-22	22:02:27.424436	07:53:00	28380
266	180	1	2	2014-08-22	13:59:57.151853	2014-08-23	06:00:55.269198	15:00:00	54000
272	179	1	2	2014-08-22	14:02:11.138457	2014-08-23	06:02:53.283465	15:00:00	54000
270	183	1	2	2014-08-22	14:01:18.556561	2014-08-23	06:03:36.56471	15:00:00	54000
269	178	1	2	2014-08-22	14:01:13.395623	2014-08-23	06:03:41.799729	15:00:00	54000
271	171	1	2	2014-08-22	14:01:47.01175	2014-08-23	06:05:20.118434	15:00:00	54000
265	174	1	2	2014-08-22	13:54:00.21833	2014-08-23	06:06:16.820706	15:00:00	54000
264	172	1	2	2014-08-22	12:32:50.648259	2014-08-23	06:10:04.284235	15:00:00	54000
292	171	1	1	2014-08-23	06:05:20.118434	2014-08-23	06:17:11.997982	00:11:51	711
295	171	1	2	2014-08-23	06:17:11.997982	2014-08-23	06:17:21.885026	00:00:09	9
280	173	1	2	2014-08-22	15:02:20.941793	2014-08-23	07:07:01.622008	15:00:00	54000
297	173	1	1	2014-08-23	07:07:01.622008	2014-08-23	13:01:31.80708	05:54:30	21270
291	178	1	1	2014-08-23	06:03:41.799729	2014-08-23	13:18:30.898786	07:14:49	26089
294	172	1	1	2014-08-23	06:10:04.284235	2014-08-23	14:02:17.698846	07:52:13	28333
288	180	1	1	2014-08-23	06:00:55.269198	2014-08-23	14:02:22.563573	08:01:27	28887
293	174	1	1	2014-08-23	06:06:16.820706	2014-08-23	14:02:52.761501	07:56:35	28595
290	183	1	1	2014-08-23	06:03:36.56471	2014-08-23	14:02:55.472317	07:59:18	28758
296	171	1	1	2014-08-23	06:17:21.885026	2014-08-23	14:05:23.051632	07:48:01	28081
287	185	1	2	2014-08-22	22:02:27.424436	2014-08-23	14:09:38.342384	15:00:00	54000
283	186	1	2	2014-08-22	22:01:22.980889	2014-08-23	14:11:41.104375	15:00:00	54000
267	176	1	2	2014-08-22	14:00:46.63543	2014-08-24	06:17:52.987772	15:00:00	54000
274	177	1	2	2014-08-22	14:07:02.127402	2014-08-24	06:17:53.781908	15:00:00	54000
285	184	1	2	2014-08-22	22:01:30.394514	2014-08-24	14:07:19.394639	15:00:00	54000
301	180	1	2	2014-08-23	14:02:22.563573	2014-08-25	05:59:38.136888	15:00:00	54000
303	183	1	2	2014-08-23	14:02:55.472317	2014-08-25	06:02:04.134645	15:00:00	54000
300	172	1	2	2014-08-23	14:02:17.698846	2014-08-25	06:03:28.408398	15:00:00	54000
298	173	1	2	2014-08-23	13:01:31.80708	2014-08-25	07:05:44.413388	15:00:00	54000
289	179	1	1	2014-08-23	06:02:53.283465	2014-08-23	14:04:13.396853	08:01:20	28880
286	187	1	2	2014-08-22	22:01:43.317264	2014-08-23	14:08:28.578306	15:00:00	54000
309	182	1	1	2014-08-23	14:57:44.055199	2014-08-23	15:16:29.195969	00:18:45	1125
307	185	1	1	2014-08-23	14:09:38.342384	2014-08-23	17:30:13.809036	03:20:35	12035
311	185	1	2	2014-08-23	17:30:13.809036	2014-08-23	17:30:23.760704	00:00:09	9
312	185	1	1	2014-08-23	17:30:23.760704	2014-08-23	22:03:51.023766	04:33:27	16407
306	187	1	1	2014-08-23	14:08:28.578306	2014-08-23	22:04:01.44815	07:55:32	28532
268	181	1	2	2014-08-22	14:00:55.867897	2014-08-24	06:16:43.565921	15:00:00	54000
305	171	1	2	2014-08-23	14:05:23.051632	2014-08-24	08:32:07.346478	15:00:00	54000
316	176	1	1	2014-08-24	06:17:52.987772	2014-08-24	14:00:42.102329	07:42:49	27769
315	181	1	1	2014-08-24	06:16:43.565921	2014-08-24	14:00:58.104296	07:44:14	27854
284	188	1	2	2014-08-22	22:01:29.207392	2014-08-24	14:04:45.082846	15:00:00	54000
318	171	1	1	2014-08-24	08:32:07.346478	2014-08-24	14:04:56.880612	05:32:49	19969
310	182	1	2	2014-08-23	15:16:29.195969	2014-08-24	14:39:54.0132	15:00:00	54000
323	184	1	1	2014-08-24	14:07:19.394639	2014-08-24	22:01:54.715309	07:54:35	28475
324	182	1	1	2014-08-24	14:39:54.0132	2014-08-24	22:02:00.644538	07:22:06	26526
321	188	1	1	2014-08-24	14:04:45.082846	2014-08-24	22:02:02.40198	07:57:17	28637
320	181	1	2	2014-08-24	14:00:58.104296	2014-08-25	05:58:13.422532	15:00:00	54000
322	171	1	2	2014-08-24	14:04:56.880612	2014-08-25	06:01:31.05431	15:00:00	54000
319	176	1	2	2014-08-24	14:00:42.102329	2014-08-25	06:01:40.005619	15:00:00	54000
299	178	1	2	2014-08-23	13:18:30.898786	2014-08-25	06:01:49.417506	15:00:00	54000
304	179	1	2	2014-08-23	14:04:13.396853	2014-08-25	06:02:14.107762	15:00:00	54000
302	174	1	2	2014-08-23	14:02:52.761501	2014-08-25	06:09:22.893883	15:00:00	54000
330	171	1	1	2014-08-25	06:01:31.05431	2014-08-25	12:56:37.712949	06:55:06	24906
338	171	1	2	2014-08-25	12:56:37.712949	2014-08-25	13:52:20.791326	00:55:43	3343
332	178	1	1	2014-08-25	06:01:49.417506	2014-08-25	14:00:26.044974	07:58:36	28716
329	180	1	1	2014-08-25	05:59:38.136888	2014-08-25	14:00:47.78337	08:01:09	28869
331	176	1	1	2014-08-25	06:01:40.005619	2014-08-25	14:00:50.303475	07:59:10	28750
336	174	1	1	2014-08-25	06:09:22.893883	2014-08-25	14:00:52.248328	07:51:29	28289
335	172	1	1	2014-08-25	06:03:28.408398	2014-08-25	14:01:12.84517	07:57:44	28664
334	179	1	1	2014-08-25	06:02:14.107762	2014-08-25	14:01:19.366752	07:59:05	28745
328	181	1	1	2014-08-25	05:58:13.422532	2014-08-25	14:01:24.978711	08:03:11	28991
333	183	1	1	2014-08-25	06:02:04.134645	2014-08-25	14:01:47.070882	07:59:42	28782
314	187	1	2	2014-08-23	22:04:01.44815	2014-08-25	14:09:10.088521	15:00:00	54000
313	185	1	2	2014-08-23	22:03:51.023766	2014-08-25	14:09:19.178644	15:00:00	54000
325	184	1	2	2014-08-24	22:01:54.715309	2014-08-25	14:09:28.211787	15:00:00	54000
327	188	1	2	2014-08-24	22:02:02.40198	2014-08-25	14:09:54.005247	15:00:00	54000
326	182	1	2	2014-08-24	22:02:00.644538	2014-08-25	14:10:15.648789	15:00:00	54000
337	173	1	1	2014-08-25	07:05:44.413388	2014-08-25	15:02:44.025645	07:56:59	28619
317	177	1	1	2014-08-24	06:17:53.781908	2014-08-25	15:05:27.918046	15:00:00	54000
350	184	1	1	2014-08-25	14:09:28.211787	2014-08-25	22:01:37.914193	07:52:09	28329
351	188	1	1	2014-08-25	14:09:54.005247	2014-08-25	22:01:40.947068	07:51:46	28306
349	185	1	1	2014-08-25	14:09:19.178644	2014-08-25	22:01:43.449151	07:52:24	28344
356	188	1	2	2014-08-25	22:01:40.947068	2014-08-25	22:01:47.903972	00:00:06	6
348	187	1	1	2014-08-25	14:09:10.088521	2014-08-25	22:01:50.377087	07:52:40	28360
352	182	1	1	2014-08-25	14:10:15.648789	2014-08-25	22:01:54.32801	07:51:38	28298
339	171	1	1	2014-08-25	13:52:20.791326	2014-08-25	22:01:56.716762	08:09:35	29375
358	188	1	1	2014-08-25	22:01:47.903972	2014-08-25	22:01:58.132479	00:00:10	10
346	181	1	2	2014-08-25	14:01:24.978711	2014-08-26	05:59:39.888792	15:00:00	54000
341	180	1	2	2014-08-25	14:00:47.78337	2014-08-26	06:00:54.018669	15:00:00	54000
340	178	1	2	2014-08-25	14:00:26.044974	2014-08-26	06:02:07.517947	15:00:00	54000
342	176	1	2	2014-08-25	14:00:50.303475	2014-08-26	06:02:25.29185	15:00:00	54000
347	183	1	2	2014-08-25	14:01:47.070882	2014-08-26	06:03:07.034351	15:00:00	54000
344	172	1	2	2014-08-25	14:01:12.84517	2014-08-26	06:04:25.287178	15:00:00	54000
361	171	1	2	2014-08-25	22:01:56.716762	2014-08-26	06:04:38.759578	15:00:00	54000
343	174	1	2	2014-08-25	14:00:52.248328	2014-08-26	06:05:10.096256	15:00:00	54000
345	179	1	2	2014-08-25	14:01:19.366752	2014-08-26	06:08:15.13168	15:00:00	54000
353	173	1	2	2014-08-25	15:02:44.025645	2014-08-26	07:05:46.321679	15:00:00	54000
354	177	1	2	2014-08-25	15:05:27.918046	2014-08-26	07:08:56.581452	15:00:00	54000
370	174	1	1	2014-08-26	06:05:10.096256	2014-08-26	10:02:04.536384	03:56:54	14214
371	179	1	1	2014-08-26	06:08:15.13168	2014-08-26	11:51:32.889827	05:43:17	20597
375	179	1	2	2014-08-26	11:51:32.889827	2014-08-26	11:51:48.21294	00:00:15	15
372	173	1	1	2014-08-26	07:05:46.321679	2014-08-26	13:37:15.026706	06:31:28	23488
377	173	1	2	2014-08-26	13:37:15.026706	2014-08-26	13:42:41.153468	00:05:26	326
364	180	1	1	2014-08-26	06:00:54.018669	2014-08-26	14:00:40.222054	07:59:46	28786
369	171	1	1	2014-08-26	06:04:38.759578	2014-08-26	14:01:08.162784	07:56:29	28589
376	179	1	1	2014-08-26	11:51:48.21294	2014-08-26	14:01:24.747979	02:09:36	7776
368	172	1	1	2014-08-26	06:04:25.287178	2014-08-26	14:02:12.837883	07:57:47	28667
363	181	1	1	2014-08-26	05:59:39.888792	2014-08-26	14:02:28.938746	08:02:49	28969
365	178	1	1	2014-08-26	06:02:07.517947	2014-08-26	14:03:28.192224	08:01:20	28880
362	188	1	2	2014-08-25	22:01:58.132479	2014-08-26	14:05:20.070728	15:00:00	54000
355	184	1	2	2014-08-25	22:01:37.914193	2014-08-26	14:06:26.028054	15:00:00	54000
359	187	1	2	2014-08-25	22:01:50.377087	2014-08-26	14:08:05.058583	15:00:00	54000
378	173	1	1	2014-08-26	13:42:41.153468	2014-08-26	15:01:20.724886	01:18:39	4719
308	186	1	1	2014-08-23	14:11:41.104375	2014-08-26	22:02:42.092115	15:00:00	54000
379	180	1	2	2014-08-26	14:00:40.222054	2014-08-27	06:00:37.792299	15:00:00	54000
374	174	1	2	2014-08-26	10:02:04.536384	2014-08-27	06:04:25.594317	15:00:00	54000
366	176	1	1	2014-08-26	06:02:25.29185	2014-08-26	14:01:43.298631	07:59:18	28758
367	183	1	1	2014-08-26	06:03:07.034351	2014-08-26	14:02:23.13119	07:59:16	28756
360	182	1	2	2014-08-25	22:01:54.32801	2014-08-26	14:04:55.12922	15:00:00	54000
357	185	1	2	2014-08-25	22:01:43.449151	2014-08-26	14:06:33.23237	15:00:00	54000
387	182	1	1	2014-08-26	14:04:55.12922	2014-08-26	14:09:13.278445	00:04:18	258
392	182	1	2	2014-08-26	14:09:13.278445	2014-08-26	14:13:16.168566	00:04:02	242
373	177	1	1	2014-08-26	07:08:56.581452	2014-08-26	15:02:10.513207	07:53:13	28393
393	182	1	1	2014-08-26	14:13:16.168566	2014-08-26	15:06:18.216061	00:53:02	3182
396	182	1	2	2014-08-26	15:06:18.216061	2014-08-26	15:07:19.097665	00:01:00	60
388	188	1	1	2014-08-26	14:05:20.070728	2014-08-26	15:08:36.794404	01:03:16	3796
398	188	1	2	2014-08-26	15:08:36.794404	2014-08-26	15:09:16.487887	00:00:39	39
397	182	1	1	2014-08-26	15:07:19.097665	2014-08-26	15:09:35.629282	00:02:16	136
390	185	1	1	2014-08-26	14:06:33.23237	2014-08-26	22:02:13.898994	07:55:40	28540
273	189	1	1	2014-08-22	14:06:48.3298	2014-08-26	22:02:40.203826	15:00:00	54000
391	187	1	1	2014-08-26	14:08:05.058583	2014-08-26	22:02:40.674547	07:54:35	28475
389	184	1	1	2014-08-26	14:06:26.028054	2014-08-26	22:03:06.775253	07:56:40	28600
399	188	1	1	2014-08-26	15:09:16.487887	2014-08-26	22:03:32.616415	06:54:16	24856
386	178	1	2	2014-08-26	14:03:28.192224	2014-08-27	06:01:57.60845	15:00:00	54000
385	181	1	2	2014-08-26	14:02:28.938746	2014-08-27	06:02:41.453493	15:00:00	54000
382	176	1	2	2014-08-26	14:01:43.298631	2014-08-27	06:02:41.934933	15:00:00	54000
381	179	1	2	2014-08-26	14:01:24.747979	2014-08-27	06:03:59.796838	15:00:00	54000
380	171	1	2	2014-08-26	14:01:08.162784	2014-08-27	06:04:27.948518	15:00:00	54000
383	172	1	2	2014-08-26	14:02:12.837883	2014-08-27	06:04:29.7085	15:00:00	54000
384	183	1	2	2014-08-26	14:02:23.13119	2014-08-27	06:04:58.478473	15:00:00	54000
394	173	1	2	2014-08-26	15:01:20.724886	2014-08-27	07:05:27.086306	15:00:00	54000
395	177	1	2	2014-08-26	15:02:10.513207	2014-08-27	07:09:52.783338	15:00:00	54000
416	173	1	1	2014-08-27	07:05:27.086306	2014-08-27	12:14:49.14133	05:09:22	18562
418	173	1	2	2014-08-27	12:14:49.14133	2014-08-27	12:14:51.456211	00:00:02	2
419	173	1	1	2014-08-27	12:14:51.456211	2014-08-27	12:54:26.215496	00:39:34	2374
420	173	1	2	2014-08-27	12:54:26.215496	2014-08-27	12:54:30.776069	00:00:04	4
407	180	1	1	2014-08-27	06:00:37.792299	2014-08-27	14:00:55.491329	08:00:17	28817
414	172	1	1	2014-08-27	06:04:29.7085	2014-08-27	14:01:16.998248	07:56:47	28607
415	183	1	1	2014-08-27	06:04:58.478473	2014-08-27	14:01:20.71866	07:56:22	28582
410	176	1	1	2014-08-27	06:02:41.934933	2014-08-27	14:01:21.033378	07:58:39	28719
409	181	1	1	2014-08-27	06:02:41.453493	2014-08-27	14:01:26.32846	07:58:44	28724
425	176	1	2	2014-08-27	14:01:21.033378	2014-08-27	14:01:29.046435	00:00:08	8
411	179	1	1	2014-08-27	06:03:59.796838	2014-08-27	14:01:31.73563	07:57:31	28651
427	176	1	1	2014-08-27	14:01:29.046435	2014-08-27	14:01:40.57858	00:00:11	11
412	174	1	1	2014-08-27	06:04:25.594317	2014-08-27	14:01:44.305246	07:57:18	28638
413	171	1	1	2014-08-27	06:04:27.948518	2014-08-27	14:02:00.69629	07:57:32	28652
408	178	1	1	2014-08-27	06:01:57.60845	2014-08-27	14:05:42.45097	08:03:44	29024
402	189	1	2	2014-08-26	22:02:40.203826	2014-08-27	14:06:24.838982	15:00:00	54000
406	188	1	2	2014-08-26	22:03:32.616415	2014-08-27	14:08:19.865708	15:00:00	54000
403	187	1	2	2014-08-26	22:02:40.674547	2014-08-27	14:08:24.471982	15:00:00	54000
401	185	1	2	2014-08-26	22:02:13.898994	2014-08-27	14:08:43.354706	15:00:00	54000
405	184	1	2	2014-08-26	22:03:06.775253	2014-08-27	14:09:17.851019	15:00:00	54000
404	186	1	2	2014-08-26	22:02:42.092115	2014-08-27	14:09:43.076203	15:00:00	54000
421	173	1	1	2014-08-27	12:54:30.776069	2014-08-27	14:58:28.920662	02:03:58	7438
417	177	1	1	2014-08-27	07:09:52.783338	2014-08-27	15:00:57.937934	07:51:05	28265
434	188	1	1	2014-08-27	14:08:19.865708	2014-08-27	22:01:43.253888	07:53:23	28403
433	189	1	1	2014-08-27	14:06:24.838982	2014-08-27	22:02:38.278943	07:56:13	28573
436	185	1	1	2014-08-27	14:08:43.354706	2014-08-27	22:02:48.719308	07:54:05	28445
438	186	1	1	2014-08-27	14:09:43.076203	2014-08-27	22:02:54.996291	07:53:11	28391
435	187	1	1	2014-08-27	14:08:24.471982	2014-08-27	22:02:57.161085	07:54:32	28472
422	180	1	2	2014-08-27	14:00:55.491329	2014-08-28	06:00:15.553045	15:00:00	54000
432	178	1	2	2014-08-27	14:05:42.45097	2014-08-28	06:02:14.00491	15:00:00	54000
431	171	1	2	2014-08-27	14:02:00.69629	2014-08-28	06:02:18.048363	15:00:00	54000
430	174	1	2	2014-08-27	14:01:44.305246	2014-08-28	06:02:35.902439	15:00:00	54000
449	174	1	1	2014-08-28	06:02:35.902439	2014-08-28	06:03:14.130867	00:00:38	38
429	176	1	2	2014-08-27	14:01:40.57858	2014-08-28	06:03:22.800708	15:00:00	54000
437	184	1	1	2014-08-27	14:09:17.851019	2014-08-28	06:03:43.306679	15:00:00	54000
428	179	1	2	2014-08-27	14:01:31.73563	2014-08-28	06:03:45.10839	15:00:00	54000
450	174	1	2	2014-08-28	06:03:14.130867	2014-08-28	06:04:21.918219	00:01:07	67
423	172	1	2	2014-08-27	14:01:16.998248	2014-08-28	06:05:16.62175	15:00:00	54000
426	181	1	2	2014-08-27	14:01:26.32846	2014-08-28	06:05:29.116869	15:00:00	54000
424	183	1	2	2014-08-27	14:01:20.71866	2014-08-28	06:05:43.111429	15:00:00	54000
440	177	1	2	2014-08-27	15:00:57.937934	2014-08-28	07:07:55.961802	15:00:00	54000
454	174	1	1	2014-08-28	06:04:21.918219	2014-08-28	09:21:33.036897	03:17:11	11831
456	181	1	1	2014-08-28	06:05:29.116869	2014-08-28	09:21:35.813932	03:16:06	11766
451	176	1	1	2014-08-28	06:03:22.800708	2014-08-28	14:01:42.426337	07:58:19	28699
457	183	1	1	2014-08-28	06:05:43.111429	2014-08-28	14:03:19.678506	07:57:36	28656
448	171	1	1	2014-08-28	06:02:18.048363	2014-08-28	14:04:10.182264	08:01:52	28912
444	186	1	2	2014-08-27	22:02:54.996291	2014-08-28	14:04:33.825774	15:00:00	54000
446	180	1	1	2014-08-28	06:00:15.553045	2014-08-28	14:05:22.048591	08:05:06	29106
445	187	1	2	2014-08-27	22:02:57.161085	2014-08-28	14:07:06.456292	15:00:00	54000
442	189	1	2	2014-08-27	22:02:38.278943	2014-08-28	14:07:25.66433	15:00:00	54000
452	184	1	2	2014-08-28	06:03:43.306679	2014-08-28	14:10:28.369962	08:06:45	29205
400	182	1	2	2014-08-26	15:09:35.629282	2014-09-04	15:33:47.481988	15:00:00	54000
439	173	1	2	2014-08-27	14:58:28.920662	2014-08-28	07:08:49.31129	15:00:00	54000
460	174	1	2	2014-08-28	09:21:33.036897	2014-08-28	09:21:41.088801	00:00:08	8
453	179	1	1	2014-08-28	06:03:45.10839	2014-08-28	09:21:45.48422	03:18:00	11880
461	181	1	2	2014-08-28	09:21:35.813932	2014-08-28	09:21:48.827197	00:00:13	13
463	179	1	2	2014-08-28	09:21:45.48422	2014-08-28	09:21:53.582467	00:00:08	8
464	181	1	1	2014-08-28	09:21:48.827197	2014-08-28	09:22:09.933727	00:00:21	21
466	181	1	2	2014-08-28	09:22:09.933727	2014-08-28	09:22:18.876739	00:00:08	8
467	181	1	1	2014-08-28	09:22:18.876739	2014-08-28	09:24:59.642021	00:02:40	160
468	181	1	2	2014-08-28	09:24:59.642021	2014-08-28	09:25:06.465644	00:00:06	6
469	181	1	1	2014-08-28	09:25:06.465644	2014-08-28	10:08:17.199093	00:43:10	2590
470	181	1	2	2014-08-28	10:08:17.199093	2014-08-28	10:08:25.996574	00:00:08	8
471	181	1	1	2014-08-28	10:08:25.996574	2014-08-28	10:16:44.628005	00:08:18	498
472	181	1	2	2014-08-28	10:16:44.628005	2014-08-28	10:16:59.961442	00:00:15	15
473	181	1	1	2014-08-28	10:16:59.961442	2014-08-28	10:27:32.045279	00:10:32	632
474	181	1	2	2014-08-28	10:27:32.045279	2014-08-28	10:30:54.312387	00:03:22	202
465	179	1	1	2014-08-28	09:21:53.582467	2014-08-28	13:11:33.271196	03:49:39	13779
462	174	1	1	2014-08-28	09:21:41.088801	2014-08-28	14:02:20.414287	04:40:39	16839
455	172	1	1	2014-08-28	06:05:16.62175	2014-08-28	14:02:24.671652	07:57:08	28628
475	181	1	1	2014-08-28	10:30:54.312387	2014-08-28	14:03:36.372357	03:32:42	12762
447	178	1	1	2014-08-28	06:02:14.00491	2014-08-28	14:04:21.16016	08:02:07	28927
441	188	1	2	2014-08-27	22:01:43.253888	2014-08-28	14:06:51.797447	15:00:00	54000
443	185	1	2	2014-08-27	22:02:48.719308	2014-08-28	14:07:55.184098	15:00:00	54000
458	177	1	1	2014-08-28	07:07:55.961802	2014-08-28	15:00:48.525497	07:52:52	28372
459	173	1	1	2014-08-28	07:08:49.31129	2014-08-28	15:02:03.454972	07:53:14	28394
490	184	1	1	2014-08-28	14:10:28.369962	2014-08-28	22:02:35.625132	07:52:07	28327
484	186	1	1	2014-08-28	14:04:33.825774	2014-08-28	22:02:36.401718	07:58:02	28682
487	187	1	1	2014-08-28	14:07:06.456292	2014-08-28	22:02:42.871968	07:55:36	28536
489	185	1	1	2014-08-28	14:07:55.184098	2014-08-28	22:02:43.299306	07:54:48	28488
486	188	1	1	2014-08-28	14:06:51.797447	2014-08-28	22:02:48.849076	07:55:57	28557
488	189	1	1	2014-08-28	14:07:25.66433	2014-08-28	22:03:00.005754	07:55:34	28534
485	180	1	2	2014-08-28	14:05:22.048591	2014-08-29	05:59:29.710512	15:00:00	54000
478	174	1	2	2014-08-28	14:02:20.414287	2014-08-29	06:01:28.778424	15:00:00	54000
477	176	1	2	2014-08-28	14:01:42.426337	2014-08-29	06:01:41.643509	15:00:00	54000
482	171	1	2	2014-08-28	14:04:10.182264	2014-08-29	06:01:54.090894	15:00:00	54000
483	178	1	2	2014-08-28	14:04:21.16016	2014-08-29	06:02:58.79089	15:00:00	54000
479	172	1	2	2014-08-28	14:02:24.671652	2014-08-29	06:05:03.903836	15:00:00	54000
476	179	1	2	2014-08-28	13:11:33.271196	2014-08-29	06:05:50.424194	15:00:00	54000
481	181	1	2	2014-08-28	14:03:36.372357	2014-08-29	06:06:03.426467	15:00:00	54000
480	183	1	2	2014-08-28	14:03:19.678506	2014-08-29	06:06:59.027895	15:00:00	54000
491	177	1	2	2014-08-28	15:00:48.525497	2014-08-29	07:09:34.167162	15:00:00	54000
492	173	1	2	2014-08-28	15:02:03.454972	2014-08-29	07:10:56.955466	15:00:00	54000
502	171	1	1	2014-08-29	06:01:54.090894	2014-08-29	14:00:08.030227	07:58:13	28693
499	180	1	1	2014-08-29	05:59:29.710512	2014-08-29	14:01:24.818079	08:01:55	28915
507	183	1	1	2014-08-29	06:06:59.027895	2014-08-29	14:02:03.948542	07:55:04	28504
506	181	1	1	2014-08-29	06:06:03.426467	2014-08-29	14:02:05.405311	07:56:01	28561
504	172	1	1	2014-08-29	06:05:03.903836	2014-08-29	14:02:14.766335	07:57:10	28630
500	174	1	1	2014-08-29	06:01:28.778424	2014-08-29	14:03:31.062788	08:02:02	28922
505	179	1	1	2014-08-29	06:05:50.424194	2014-08-29	14:03:56.40865	07:58:05	28685
501	176	1	1	2014-08-29	06:01:41.643509	2014-08-29	14:04:44.998648	08:03:03	28983
495	187	1	2	2014-08-28	22:02:42.871968	2014-08-29	14:06:45.134666	15:00:00	54000
497	188	1	2	2014-08-28	22:02:48.849076	2014-08-29	14:07:33.038501	15:00:00	54000
498	189	1	2	2014-08-28	22:03:00.005754	2014-08-29	14:07:43.502744	15:00:00	54000
494	186	1	2	2014-08-28	22:02:36.401718	2014-08-29	14:08:19.46704	15:00:00	54000
496	185	1	2	2014-08-28	22:02:43.299306	2014-08-29	14:09:47.382499	15:00:00	54000
493	184	1	2	2014-08-28	22:02:35.625132	2014-08-29	14:14:49.136046	15:00:00	54000
523	184	1	1	2014-08-29	14:14:49.136046	2014-08-29	14:46:19.261325	00:31:30	1890
508	177	1	1	2014-08-29	07:09:34.167162	2014-08-29	14:56:44.98613	07:47:10	28030
524	184	1	2	2014-08-29	14:46:19.261325	2014-08-29	14:59:42.877534	00:13:23	803
509	173	1	1	2014-08-29	07:10:56.955466	2014-08-29	15:00:03.942944	07:49:06	28146
526	184	1	1	2014-08-29	14:59:42.877534	2014-08-29	15:43:18.938326	00:43:36	2616
519	188	1	1	2014-08-29	14:07:33.038501	2014-08-29	22:02:33.386502	07:55:00	28500
522	185	1	1	2014-08-29	14:09:47.382499	2014-08-29	22:02:39.375785	07:52:51	28371
521	186	1	1	2014-08-29	14:08:19.46704	2014-08-29	22:03:02.516168	07:54:43	28483
520	189	1	1	2014-08-29	14:07:43.502744	2014-08-29	22:03:08.287856	07:55:24	28524
518	187	1	1	2014-08-29	14:06:45.134666	2014-08-29	22:03:58.660719	07:57:13	28633
511	180	1	2	2014-08-29	14:01:24.818079	2014-08-30	06:00:13.583037	15:00:00	54000
515	174	1	2	2014-08-29	14:03:31.062788	2014-08-30	06:01:10.599282	15:00:00	54000
516	179	1	2	2014-08-29	14:03:56.40865	2014-08-30	06:06:12.705428	15:00:00	54000
517	176	1	2	2014-08-29	14:04:44.998648	2014-08-30	06:11:32.564611	15:00:00	54000
534	180	1	1	2014-08-30	06:00:13.583037	2014-08-30	10:01:57.027851	04:01:43	14503
535	174	1	1	2014-08-30	06:01:10.599282	2014-08-30	10:03:27.44988	04:02:16	14536
503	178	1	1	2014-08-29	06:02:58.79089	2014-08-30	10:09:40.622486	15:00:00	54000
533	187	1	2	2014-08-29	22:03:58.660719	2014-08-30	14:05:27.378015	15:00:00	54000
530	185	1	2	2014-08-29	22:02:39.375785	2014-08-30	14:12:33.566639	15:00:00	54000
525	177	1	2	2014-08-29	14:56:44.98613	2014-08-31	06:07:35.630621	15:00:00	54000
514	172	1	2	2014-08-29	14:02:14.766335	2014-08-31	06:26:54.655832	15:00:00	54000
529	188	1	2	2014-08-29	22:02:33.386502	2014-08-31	14:07:41.183185	15:00:00	54000
527	173	1	2	2014-08-29	15:00:03.942944	2014-08-30	06:03:33.998431	15:00:00	54000
512	183	1	2	2014-08-29	14:02:03.948542	2014-08-30	09:53:54.719137	15:00:00	54000
536	173	1	1	2014-08-30	06:03:33.998431	2014-08-30	10:02:14.189733	03:58:40	14320
510	171	1	2	2014-08-29	14:00:08.030227	2014-08-30	10:02:19.861331	15:00:00	54000
537	179	1	1	2014-08-30	06:06:12.705428	2014-08-30	10:04:45.840352	03:58:33	14313
545	178	1	2	2014-08-30	10:09:40.622486	2014-08-30	10:09:48.180259	00:00:07	7
538	176	1	1	2014-08-30	06:11:32.564611	2014-08-30	10:12:24.246806	04:00:51	14451
546	178	1	1	2014-08-30	10:09:48.180259	2014-08-30	14:02:43.929447	03:52:55	13975
542	171	1	1	2014-08-30	10:02:19.861331	2014-08-30	14:03:13.823705	04:00:53	14453
539	183	1	1	2014-08-30	09:53:54.719137	2014-08-30	14:03:55.291705	04:10:00	15000
531	186	1	2	2014-08-29	22:03:02.516168	2014-08-30	14:05:26.162327	15:00:00	54000
553	185	1	1	2014-08-30	14:12:33.566639	2014-08-30	18:11:41.558527	03:59:07	14347
552	187	1	1	2014-08-30	14:05:27.378015	2014-08-30	22:03:09.665773	07:57:42	28662
551	186	1	1	2014-08-30	14:05:26.162327	2014-08-30	22:04:22.543883	07:58:56	28736
513	181	1	2	2014-08-29	14:02:05.405311	2014-08-31	06:03:42.565533	15:00:00	54000
559	172	1	1	2014-08-31	06:26:54.655832	2014-08-31	14:00:57.298185	07:34:02	27242
558	177	1	1	2014-08-31	06:07:35.630621	2014-08-31	14:02:32.282171	07:54:56	28496
557	181	1	1	2014-08-31	06:03:42.565533	2014-08-31	14:02:38.340462	07:58:55	28735
532	189	1	2	2014-08-29	22:03:08.287856	2014-08-31	14:04:12.412109	15:00:00	54000
528	184	1	2	2014-08-29	15:43:18.938326	2014-08-31	14:08:03.543525	15:00:00	54000
565	184	1	1	2014-08-31	14:08:03.543525	2014-08-31	16:30:44.18396	02:22:40	8560
566	184	1	2	2014-08-31	16:30:44.18396	2014-08-31	17:07:22.518861	00:36:38	2198
564	188	1	1	2014-08-31	14:07:41.183185	2014-08-31	22:02:57.826176	07:55:16	28516
567	184	1	1	2014-08-31	17:07:22.518861	2014-08-31	22:03:40.27898	04:56:17	17777
563	189	1	1	2014-08-31	14:04:12.412109	2014-08-31	22:04:06.778053	07:59:54	28794
550	183	1	2	2014-08-30	14:03:55.291705	2014-09-01	06:01:10.798048	15:00:00	54000
540	180	1	2	2014-08-30	10:01:57.027851	2014-09-01	06:01:43.826177	15:00:00	54000
562	181	1	2	2014-08-31	14:02:38.340462	2014-09-01	06:01:56.948077	15:00:00	54000
549	171	1	2	2014-08-30	14:03:13.823705	2014-09-01	06:02:31.237963	15:00:00	54000
547	176	1	2	2014-08-30	10:12:24.246806	2014-09-01	06:02:42.513641	15:00:00	54000
543	174	1	2	2014-08-30	10:03:27.44988	2014-09-01	06:02:45.845927	15:00:00	54000
544	179	1	2	2014-08-30	10:04:45.840352	2014-09-01	06:02:52.428796	15:00:00	54000
560	172	1	2	2014-08-31	14:00:57.298185	2014-09-01	06:04:52.646247	15:00:00	54000
548	178	1	2	2014-08-30	14:02:43.929447	2014-09-01	06:05:49.497745	15:00:00	54000
576	174	1	1	2014-09-01	06:02:45.845927	2014-09-01	07:01:05.546961	00:58:19	3499
580	174	1	2	2014-09-01	07:01:05.546961	2014-09-01	07:01:16.395307	00:00:10	10
561	177	1	2	2014-08-31	14:02:32.282171	2014-09-01	07:11:45.215844	15:00:00	54000
541	173	1	2	2014-08-30	10:02:14.189733	2014-09-01	07:14:03.963852	15:00:00	54000
572	180	1	1	2014-09-01	06:01:43.826177	2014-09-01	14:01:48.12168	08:00:04	28804
573	181	1	1	2014-09-01	06:01:56.948077	2014-09-01	14:02:26.270933	08:00:29	28829
574	171	1	1	2014-09-01	06:02:31.237963	2014-09-01	14:02:40.1544	08:00:08	28808
571	183	1	1	2014-09-01	06:01:10.798048	2014-09-01	14:02:41.012534	08:01:30	28890
578	172	1	1	2014-09-01	06:04:52.646247	2014-09-01	14:02:44.001127	07:57:51	28671
581	174	1	1	2014-09-01	07:01:16.395307	2014-09-01	14:02:49.235918	07:01:32	25292
577	179	1	1	2014-09-01	06:02:52.428796	2014-09-01	14:02:56.092566	08:00:03	28803
575	176	1	1	2014-09-01	06:02:42.513641	2014-09-01	14:03:58.810694	08:01:16	28876
570	189	1	2	2014-08-31	22:04:06.778053	2014-09-01	14:06:01.432039	15:00:00	54000
568	188	1	2	2014-08-31	22:02:57.826176	2014-09-01	14:07:17.5225	15:00:00	54000
579	178	1	1	2014-09-01	06:05:49.497745	2014-09-01	14:07:58.208145	08:02:08	28928
555	187	1	2	2014-08-30	22:03:09.665773	2014-09-01	14:08:48.575389	15:00:00	54000
556	186	1	2	2014-08-30	22:04:22.543883	2014-09-01	14:08:57.156797	15:00:00	54000
554	185	1	2	2014-08-30	18:11:41.558527	2014-09-01	14:09:49.70351	15:00:00	54000
569	184	1	2	2014-08-31	22:03:40.27898	2014-09-01	14:11:16.434834	15:00:00	54000
583	173	1	1	2014-09-01	07:14:03.963852	2014-09-01	15:04:33.381198	07:50:29	28229
582	177	1	1	2014-09-01	07:11:45.215844	2014-09-01	15:06:54.428272	07:55:09	28509
592	189	1	1	2014-09-01	14:06:01.432039	2014-09-01	22:03:33.22357	07:57:31	28651
596	186	1	1	2014-09-01	14:08:57.156797	2014-09-01	22:03:35.081125	07:54:37	28477
593	188	1	1	2014-09-01	14:07:17.5225	2014-09-01	22:03:36.119716	07:56:18	28578
595	187	1	1	2014-09-01	14:08:48.575389	2014-09-01	22:03:44.600479	07:54:56	28496
597	185	1	1	2014-09-01	14:09:49.70351	2014-09-01	22:03:53.277937	07:54:03	28443
598	184	1	1	2014-09-01	14:11:16.434834	2014-09-01	22:03:55.904936	07:52:39	28359
584	180	1	2	2014-09-01	14:01:48.12168	2014-09-02	06:00:34.079313	15:00:00	54000
590	179	1	2	2014-09-01	14:02:56.092566	2014-09-02	06:01:50.541722	15:00:00	54000
594	178	1	2	2014-09-01	14:07:58.208145	2014-09-02	06:02:17.4938	15:00:00	54000
585	181	1	2	2014-09-01	14:02:26.270933	2014-09-02	06:03:16.221659	15:00:00	54000
587	183	1	2	2014-09-01	14:02:41.012534	2014-09-02	06:03:41.645831	15:00:00	54000
591	176	1	2	2014-09-01	14:03:58.810694	2014-09-02	06:04:42.347512	15:00:00	54000
589	174	1	2	2014-09-01	14:02:49.235918	2014-09-02	06:05:06.24623	15:00:00	54000
588	172	1	2	2014-09-01	14:02:44.001127	2014-09-02	06:05:42.618427	15:00:00	54000
599	173	1	2	2014-09-01	15:04:33.381198	2014-09-02	07:09:08.679424	15:00:00	54000
611	183	1	1	2014-09-02	06:03:41.645831	2014-09-02	14:03:00.94445	07:59:19	28759
610	181	1	1	2014-09-02	06:03:16.221659	2014-09-02	14:03:15.75643	07:59:59	28799
609	178	1	1	2014-09-02	06:02:17.4938	2014-09-02	14:03:59.189775	08:01:41	28901
608	179	1	1	2014-09-02	06:01:50.541722	2014-09-02	14:04:02.366739	08:02:11	28931
604	187	1	2	2014-09-01	22:03:44.600479	2014-09-02	14:08:30.53985	15:00:00	54000
605	185	1	2	2014-09-01	22:03:53.277937	2014-09-02	14:08:36.907683	15:00:00	54000
606	184	1	2	2014-09-01	22:03:55.904936	2014-09-02	14:10:36.087495	15:00:00	54000
586	171	1	2	2014-09-01	14:02:40.1544	2014-09-02	06:04:53.902993	15:00:00	54000
600	177	1	2	2014-09-01	15:06:54.428272	2014-09-02	07:06:08.381873	15:00:00	54000
607	180	1	1	2014-09-02	06:00:34.079313	2014-09-02	14:01:56.083337	08:01:22	28882
614	174	1	1	2014-09-02	06:05:06.24623	2014-09-02	14:01:59.916046	07:56:53	28613
615	172	1	1	2014-09-02	06:05:42.618427	2014-09-02	14:03:03.966855	07:57:21	28641
613	171	1	1	2014-09-02	06:04:53.902993	2014-09-02	14:03:30.540043	07:58:36	28716
612	176	1	1	2014-09-02	06:04:42.347512	2014-09-02	14:03:47.604754	07:59:05	28745
601	189	1	2	2014-09-01	22:03:33.22357	2014-09-02	14:07:01.048643	15:00:00	54000
603	188	1	2	2014-09-01	22:03:36.119716	2014-09-02	14:09:12.923095	15:00:00	54000
602	186	1	2	2014-09-01	22:03:35.081125	2014-09-02	14:10:56.612274	15:00:00	54000
617	173	1	1	2014-09-02	07:09:08.679424	2014-09-02	15:02:41.185454	07:53:32	28412
627	189	1	1	2014-09-02	14:07:01.048643	2014-09-02	15:05:55.74629	00:58:54	3534
616	177	1	1	2014-09-02	07:06:08.381873	2014-09-02	15:06:08.268952	07:59:59	28799
634	189	1	2	2014-09-02	15:05:55.74629	2014-09-02	15:50:13.389956	00:44:17	2657
636	189	1	1	2014-09-02	15:50:13.389956	2014-09-02	16:15:11.746378	00:24:58	1498
631	184	1	1	2014-09-02	14:10:36.087495	2014-09-02	18:00:28.750921	03:49:52	13792
638	184	1	2	2014-09-02	18:00:28.750921	2014-09-02	19:05:45.172349	01:05:16	3916
637	189	1	2	2014-09-02	16:15:11.746378	2014-09-02	20:48:22.657042	04:33:10	16390
628	187	1	1	2014-09-02	14:08:30.53985	2014-09-02	22:04:04.872816	07:55:34	28534
640	189	1	1	2014-09-02	20:48:22.657042	2014-09-02	22:04:07.444772	01:15:44	4544
630	188	1	1	2014-09-02	14:09:12.923095	2014-09-02	22:04:15.800068	07:55:02	28502
632	186	1	1	2014-09-02	14:10:56.612274	2014-09-02	22:04:16.291642	07:53:19	28399
629	185	1	1	2014-09-02	14:08:36.907683	2014-09-02	22:04:16.628326	07:55:39	28539
639	184	1	1	2014-09-02	19:05:45.172349	2014-09-02	22:04:45.19786	02:59:00	10740
622	181	1	2	2014-09-02	14:03:15.75643	2014-09-03	06:01:23.957887	15:00:00	54000
618	180	1	2	2014-09-02	14:01:56.083337	2014-09-03	06:02:19.502543	15:00:00	54000
625	178	1	2	2014-09-02	14:03:59.189775	2014-09-03	06:03:08.811565	15:00:00	54000
624	176	1	2	2014-09-02	14:03:47.604754	2014-09-03	06:03:21.69296	15:00:00	54000
623	171	1	2	2014-09-02	14:03:30.540043	2014-09-03	06:03:23.042046	15:00:00	54000
619	174	1	2	2014-09-02	14:01:59.916046	2014-09-03	06:03:32.809011	15:00:00	54000
626	179	1	2	2014-09-02	14:04:02.366739	2014-09-03	06:04:16.506404	15:00:00	54000
621	172	1	2	2014-09-02	14:03:03.966855	2014-09-03	06:05:27.253622	15:00:00	54000
620	183	1	2	2014-09-02	14:03:00.94445	2014-09-03	06:17:37.316639	15:00:00	54000
633	173	1	2	2014-09-02	15:02:41.185454	2014-09-03	07:06:19.186537	15:00:00	54000
635	177	1	2	2014-09-02	15:06:08.268952	2014-09-03	07:06:53.150768	15:00:00	54000
652	174	1	1	2014-09-03	06:03:32.809011	2014-09-03	13:02:46.966178	06:59:14	25154
657	177	1	1	2014-09-03	07:06:53.150768	2014-09-03	13:44:17.780726	06:37:24	23844
659	177	1	2	2014-09-03	13:44:17.780726	2014-09-03	13:44:45.618021	00:00:27	27
650	176	1	1	2014-09-03	06:03:21.69296	2014-09-03	13:50:32.631717	07:47:10	28030
647	181	1	1	2014-09-03	06:01:23.957887	2014-09-03	14:02:49.39256	08:01:25	28885
648	180	1	1	2014-09-03	06:02:19.502543	2014-09-03	14:03:10.838243	08:00:51	28851
654	172	1	1	2014-09-03	06:05:27.253622	2014-09-03	14:04:01.005467	07:58:33	28713
651	171	1	1	2014-09-03	06:03:23.042046	2014-09-03	14:04:08.731588	08:00:45	28845
649	178	1	1	2014-09-03	06:03:08.811565	2014-09-03	14:05:31.640425	08:02:22	28942
655	183	1	1	2014-09-03	06:17:37.316639	2014-09-03	14:05:35.146013	07:47:57	28077
653	179	1	1	2014-09-03	06:04:16.506404	2014-09-03	14:05:47.627707	08:01:31	28891
642	189	1	2	2014-09-02	22:04:07.444772	2014-09-03	14:09:04.345573	15:00:00	54000
646	184	1	2	2014-09-02	22:04:45.19786	2014-09-03	14:11:17.939207	15:00:00	54000
643	188	1	2	2014-09-02	22:04:15.800068	2014-09-03	14:11:25.781282	15:00:00	54000
641	187	1	2	2014-09-02	22:04:04.872816	2014-09-03	14:12:13.184422	15:00:00	54000
645	185	1	2	2014-09-02	22:04:16.628326	2014-09-03	14:13:12.163286	15:00:00	54000
644	186	1	2	2014-09-02	22:04:16.291642	2014-09-03	14:15:02.214048	15:00:00	54000
656	173	1	1	2014-09-03	07:06:19.186537	2014-09-03	15:02:59.582367	07:56:40	28600
660	177	1	1	2014-09-03	13:44:45.618021	2014-09-03	15:07:03.395975	01:22:17	4937
673	185	1	1	2014-09-03	14:13:12.163286	2014-09-03	22:03:48.31797	07:50:36	28236
671	188	1	1	2014-09-03	14:11:25.781282	2014-09-03	22:04:11.041644	07:52:45	28365
670	184	1	1	2014-09-03	14:11:17.939207	2014-09-03	22:04:20.256385	07:53:02	28382
672	187	1	1	2014-09-03	14:12:13.184422	2014-09-03	22:04:24.311671	07:52:11	28331
674	186	1	1	2014-09-03	14:15:02.214048	2014-09-03	22:04:51.592318	07:49:49	28189
669	189	1	1	2014-09-03	14:09:04.345573	2014-09-03	22:04:57.562106	07:55:53	28553
663	180	1	2	2014-09-03	14:03:10.838243	2014-09-04	06:02:52.923442	15:00:00	54000
662	181	1	2	2014-09-03	14:02:49.39256	2014-09-04	06:03:58.515216	15:00:00	54000
668	179	1	2	2014-09-03	14:05:47.627707	2014-09-04	06:04:03.88168	15:00:00	54000
665	171	1	2	2014-09-03	14:04:08.731588	2014-09-04	06:04:11.568009	15:00:00	54000
658	174	1	2	2014-09-03	13:02:46.966178	2014-09-04	06:04:17.334652	15:00:00	54000
666	178	1	2	2014-09-03	14:05:31.640425	2014-09-04	06:04:22.872249	15:00:00	54000
667	183	1	2	2014-09-03	14:05:35.146013	2014-09-04	06:07:18.454905	15:00:00	54000
661	176	1	2	2014-09-03	13:50:32.631717	2014-09-04	06:11:32.740313	15:00:00	54000
676	177	1	2	2014-09-03	15:07:03.395975	2014-09-04	07:04:12.983752	15:00:00	54000
686	171	1	1	2014-09-04	06:04:11.568009	2014-09-04	14:00:42.721571	07:56:31	28591
683	180	1	1	2014-09-04	06:02:52.923442	2014-09-04	14:02:06.533794	07:59:13	28753
684	181	1	1	2014-09-04	06:03:58.515216	2014-09-04	14:03:25.192815	07:59:26	28766
689	183	1	1	2014-09-04	06:07:18.454905	2014-09-04	14:03:33.658109	07:56:15	28575
688	178	1	1	2014-09-04	06:04:22.872249	2014-09-04	14:04:15.567135	07:59:52	28792
678	188	1	2	2014-09-03	22:04:11.041644	2014-09-04	14:08:59.338725	15:00:00	54000
682	189	1	2	2014-09-03	22:04:57.562106	2014-09-04	14:09:22.248006	15:00:00	54000
677	185	1	2	2014-09-03	22:03:48.31797	2014-09-04	14:13:21.808026	15:00:00	54000
664	172	1	2	2014-09-03	14:04:01.005467	2014-09-04	06:07:27.422659	15:00:00	54000
675	173	1	2	2014-09-03	15:02:59.582367	2014-09-04	07:13:35.916258	15:00:00	54000
691	176	1	1	2014-09-04	06:11:32.740313	2014-09-04	14:00:35.312983	07:49:02	28142
687	174	1	1	2014-09-04	06:04:17.334652	2014-09-04	14:00:43.322105	07:56:25	28585
690	172	1	1	2014-09-04	06:07:27.422659	2014-09-04	14:01:51.056873	07:54:23	28463
697	172	1	2	2014-09-04	14:01:51.056873	2014-09-04	14:02:26.669313	00:00:35	35
699	172	1	1	2014-09-04	14:02:26.669313	2014-09-04	14:02:32.793369	00:00:06	6
685	179	1	1	2014-09-04	06:04:03.88168	2014-09-04	14:03:27.510569	07:59:23	28763
680	187	1	2	2014-09-03	22:04:24.311671	2014-09-04	14:06:58.703055	15:00:00	54000
681	186	1	2	2014-09-03	22:04:51.592318	2014-09-04	14:09:56.309345	15:00:00	54000
693	173	1	1	2014-09-04	07:13:35.916258	2014-09-04	15:03:42.125332	07:50:06	28206
706	188	1	1	2014-09-04	14:08:59.338725	2014-09-04	15:57:19.755878	01:48:20	6500
712	188	1	2	2014-09-04	15:57:19.755878	2014-09-04	15:57:25.545246	00:00:05	5
705	187	1	1	2014-09-04	14:06:58.703055	2014-09-04	19:12:52.128092	05:05:53	18353
714	187	1	2	2014-09-04	19:12:52.128092	2014-09-04	20:54:29.41406	01:41:37	6097
709	185	1	1	2014-09-04	14:13:21.808026	2014-09-04	22:04:21.157321	07:50:59	28259
708	186	1	1	2014-09-04	14:09:56.309345	2014-09-04	22:04:23.900479	07:54:27	28467
713	188	1	1	2014-09-04	15:57:25.545246	2014-09-04	22:04:25.580939	06:07:00	22020
715	187	1	1	2014-09-04	20:54:29.41406	2014-09-04	22:04:30.689125	01:10:01	4201
707	189	1	1	2014-09-04	14:09:22.248006	2014-09-04	22:04:53.727317	07:55:31	28531
711	182	1	1	2014-09-04	15:33:47.481988	2014-09-04	22:04:54.784656	06:31:07	23467
698	180	1	2	2014-09-04	14:02:06.533794	2014-09-05	06:02:41.992296	15:00:00	54000
701	181	1	2	2014-09-04	14:03:25.192815	2014-09-05	06:04:56.62306	15:00:00	54000
702	179	1	2	2014-09-04	14:03:27.510569	2014-09-05	06:04:58.383133	15:00:00	54000
695	171	1	2	2014-09-04	14:00:42.721571	2014-09-05	06:05:09.596137	15:00:00	54000
694	176	1	2	2014-09-04	14:00:35.312983	2014-09-05	06:05:18.740246	15:00:00	54000
700	172	1	2	2014-09-04	14:02:32.793369	2014-09-05	06:10:10.652305	15:00:00	54000
720	189	1	2	2014-09-04	22:04:53.727317	2014-09-05	06:12:11.085824	15:00:00	54000
703	183	1	2	2014-09-04	14:03:33.658109	2014-09-05	06:21:11.523325	15:00:00	54000
704	178	1	2	2014-09-04	14:04:15.567135	2014-09-05	06:23:51.235678	15:00:00	54000
710	173	1	2	2014-09-04	15:03:42.125332	2014-09-05	07:08:46.19954	15:00:00	54000
727	172	1	1	2014-09-05	06:10:10.652305	2014-09-05	14:03:05.453144	07:52:54	28374
722	180	1	1	2014-09-05	06:02:41.992296	2014-09-05	14:04:11.616667	08:01:29	28889
729	183	1	1	2014-09-05	06:21:11.523325	2014-09-05	14:04:29.144428	07:43:17	27797
730	178	1	1	2014-09-05	06:23:51.235678	2014-09-05	14:04:36.041753	07:40:44	27644
692	177	1	1	2014-09-04	07:04:12.983752	2014-09-05	14:04:46.867539	15:00:00	54000
724	179	1	1	2014-09-05	06:04:58.383133	2014-09-05	14:05:01.31459	08:00:02	28802
728	189	1	1	2014-09-05	06:12:11.085824	2014-09-05	14:05:02.114804	07:52:51	28371
723	181	1	1	2014-09-05	06:04:56.62306	2014-09-05	14:05:26.038111	08:00:29	28829
719	187	1	2	2014-09-04	22:04:30.689125	2014-09-05	14:08:37.177995	15:00:00	54000
718	188	1	2	2014-09-04	22:04:25.580939	2014-09-05	14:09:06.054695	15:00:00	54000
725	171	1	1	2014-09-05	06:05:09.596137	2014-09-05	14:09:12.638593	08:04:03	29043
717	186	1	2	2014-09-04	22:04:23.900479	2014-09-05	14:09:32.459017	15:00:00	54000
726	176	1	1	2014-09-05	06:05:18.740246	2014-09-05	14:10:06.159287	08:04:47	29087
738	189	1	2	2014-09-05	14:05:02.114804	2014-09-05	14:20:15.932058	00:15:13	913
731	173	1	1	2014-09-05	07:08:46.19954	2014-09-05	14:28:24.084519	07:19:37	26377
746	173	1	2	2014-09-05	14:28:24.084519	2014-09-05	14:28:26.559986	00:00:02	2
747	173	1	1	2014-09-05	14:28:26.559986	2014-09-05	15:05:08.90811	00:36:42	2202
721	182	1	2	2014-09-04	22:04:54.784656	2014-09-05	15:05:44.74842	15:00:00	54000
741	188	1	1	2014-09-05	14:09:06.054695	2014-09-05	22:04:31.615369	07:55:25	28525
743	186	1	1	2014-09-05	14:09:32.459017	2014-09-05	22:04:35.330324	07:55:02	28502
740	187	1	1	2014-09-05	14:08:37.177995	2014-09-05	22:04:44.532076	07:56:07	28567
745	189	1	1	2014-09-05	14:20:15.932058	2014-09-05	22:07:29.113328	07:47:13	28033
733	180	1	2	2014-09-05	14:04:11.616667	2014-09-06	06:03:21.217074	15:00:00	54000
734	183	1	2	2014-09-05	14:04:29.144428	2014-09-06	06:04:48.611587	15:00:00	54000
737	179	1	2	2014-09-05	14:05:01.31459	2014-09-06	06:06:06.102051	15:00:00	54000
696	174	1	2	2014-09-04	14:00:43.322105	2014-09-06	06:07:01.898523	15:00:00	54000
742	171	1	2	2014-09-05	14:09:12.638593	2014-09-06	06:07:03.052662	15:00:00	54000
744	176	1	2	2014-09-05	14:10:06.159287	2014-09-06	06:07:44.681103	15:00:00	54000
739	181	1	2	2014-09-05	14:05:26.038111	2014-09-06	06:09:55.109115	15:00:00	54000
749	182	1	1	2014-09-05	15:05:44.74842	2014-09-06	06:30:36.653924	15:00:00	54000
761	182	1	2	2014-09-06	06:30:36.653924	2014-09-06	06:37:44.012547	00:07:07	427
748	173	1	2	2014-09-05	15:05:08.90811	2014-09-06	08:06:53.961526	15:00:00	54000
757	174	1	1	2014-09-06	06:07:01.898523	2014-09-06	12:16:47.199005	06:09:45	22185
758	171	1	1	2014-09-06	06:07:03.052662	2014-09-06	12:23:20.497889	06:16:17	22577
763	173	1	1	2014-09-06	08:06:53.961526	2014-09-06	12:23:47.909141	04:16:53	15413
752	187	1	2	2014-09-05	22:04:44.532076	2014-09-06	12:28:25.054976	15:00:00	54000
765	171	1	2	2014-09-06	12:23:20.497889	2014-09-06	13:13:00.600923	00:49:40	2980
766	173	1	2	2014-09-06	12:23:47.909141	2014-09-06	13:28:44.9119	01:04:57	3897
762	182	1	1	2014-09-06	06:37:44.012547	2014-09-06	14:04:13.579301	07:26:29	26789
759	176	1	1	2014-09-06	06:07:44.681103	2014-09-06	14:04:35.356286	07:56:50	28610
756	179	1	1	2014-09-06	06:06:06.102051	2014-09-06	14:04:45.138652	07:58:39	28719
753	189	1	2	2014-09-05	22:07:29.113328	2014-09-06	14:08:28.219207	15:00:00	54000
750	188	1	2	2014-09-05	22:04:31.615369	2014-09-06	14:08:58.52141	15:00:00	54000
732	172	1	2	2014-09-05	14:03:05.453144	2014-09-07	06:16:55.312228	15:00:00	54000
735	178	1	2	2014-09-05	14:04:36.041753	2014-09-07	06:24:34.812203	15:00:00	54000
716	185	1	2	2014-09-04	22:04:21.157321	2014-09-08	14:14:34.296753	15:00:00	54000
767	187	1	1	2014-09-06	12:28:25.054976	2014-09-06	13:11:36.788464	00:43:11	2591
764	174	1	2	2014-09-06	12:16:47.199005	2014-09-06	13:20:34.254138	01:03:47	3827
755	183	1	1	2014-09-06	06:04:48.611587	2014-09-06	14:04:32.988086	07:59:44	28784
770	174	1	1	2014-09-06	13:20:34.254138	2014-09-06	14:04:37.697277	00:44:03	2643
769	171	1	1	2014-09-06	13:13:00.600923	2014-09-06	14:04:56.597106	00:51:55	3115
760	181	1	1	2014-09-06	06:09:55.109115	2014-09-06	14:06:05.543983	07:56:10	28570
679	184	1	2	2014-09-03	22:04:20.256385	2014-09-06	14:13:36.455192	15:00:00	54000
771	173	1	1	2014-09-06	13:28:44.9119	2014-09-06	14:59:34.843897	01:30:49	5449
779	189	1	1	2014-09-06	14:08:28.219207	2014-09-06	22:04:14.461204	07:55:46	28546
781	184	1	1	2014-09-06	14:13:36.455192	2014-09-06	22:04:36.321426	07:50:59	28259
780	188	1	1	2014-09-06	14:08:58.52141	2014-09-06	22:04:44.605261	07:55:46	28546
736	177	1	2	2014-09-05	14:04:46.867539	2014-09-07	06:07:01.848103	15:00:00	54000
788	178	1	1	2014-09-07	06:24:34.812203	2014-09-07	10:00:28.063413	03:35:53	12953
789	178	1	2	2014-09-07	10:00:28.063413	2014-09-07	10:00:42.734238	00:00:14	14
787	172	1	1	2014-09-07	06:16:55.312228	2014-09-07	14:03:25.978281	07:46:30	27990
786	177	1	1	2014-09-07	06:07:01.848103	2014-09-07	14:04:14.853283	07:57:13	28633
790	178	1	1	2014-09-07	10:00:42.734238	2014-09-07	14:04:22.351596	04:03:39	14619
777	171	1	2	2014-09-06	14:04:56.597106	2014-09-07	14:04:27.306287	15:00:00	54000
768	187	1	2	2014-09-06	13:11:36.788464	2014-09-07	14:06:19.949041	15:00:00	54000
751	186	1	2	2014-09-05	22:04:35.330324	2014-09-07	14:06:52.342563	15:00:00	54000
796	186	1	1	2014-09-07	14:06:52.342563	2014-09-07	16:53:18.746286	02:46:26	9986
797	186	1	2	2014-09-07	16:53:18.746286	2014-09-07	16:53:41.798175	00:00:23	23
794	171	1	1	2014-09-07	14:04:27.306287	2014-09-07	22:04:14.881808	07:59:47	28787
798	186	1	1	2014-09-07	16:53:41.798175	2014-09-07	22:04:20.461984	05:10:38	18638
795	187	1	1	2014-09-07	14:06:19.949041	2014-09-07	22:04:22.678431	07:58:02	28682
775	174	1	2	2014-09-06	14:04:37.697277	2014-09-08	06:03:33.473426	15:00:00	54000
776	179	1	2	2014-09-06	14:04:45.138652	2014-09-08	06:04:07.741152	15:00:00	54000
773	183	1	2	2014-09-06	14:04:32.988086	2014-09-08	06:04:45.946176	15:00:00	54000
778	181	1	2	2014-09-06	14:06:05.543983	2014-09-08	06:04:46.157619	15:00:00	54000
774	176	1	2	2014-09-06	14:04:35.356286	2014-09-08	06:05:56.429512	15:00:00	54000
793	178	1	2	2014-09-07	14:04:22.351596	2014-09-08	06:07:23.133531	15:00:00	54000
791	172	1	2	2014-09-07	14:03:25.978281	2014-09-08	06:07:28.564471	15:00:00	54000
772	182	1	2	2014-09-06	14:04:13.579301	2014-09-08	06:08:42.630142	15:00:00	54000
799	171	1	2	2014-09-07	22:04:14.881808	2014-09-08	06:09:08.501745	15:00:00	54000
792	177	1	2	2014-09-07	14:04:14.853283	2014-09-08	07:13:39.078317	15:00:00	54000
782	173	1	2	2014-09-06	14:59:34.843897	2014-09-08	07:23:39.777309	15:00:00	54000
809	182	1	1	2014-09-08	06:08:42.630142	2014-09-08	14:04:25.433991	07:55:42	28542
808	172	1	1	2014-09-08	06:07:28.564471	2014-09-08	14:04:31.844827	07:57:03	28623
810	171	1	1	2014-09-08	06:09:08.501745	2014-09-08	14:04:58.985839	07:55:50	28550
803	179	1	1	2014-09-08	06:04:07.741152	2014-09-08	14:05:02.855293	08:00:55	28855
806	176	1	1	2014-09-08	06:05:56.429512	2014-09-08	14:05:05.278245	07:59:08	28748
805	181	1	1	2014-09-08	06:04:46.157619	2014-09-08	14:05:20.959483	08:00:34	28834
804	183	1	1	2014-09-08	06:04:45.946176	2014-09-08	14:06:31.267061	08:01:45	28905
802	174	1	1	2014-09-08	06:03:33.473426	2014-09-08	14:07:16.477697	08:03:43	29023
807	178	1	1	2014-09-08	06:07:23.133531	2014-09-08	14:11:42.131164	08:04:18	29058
800	186	1	2	2014-09-07	22:04:20.461984	2014-09-08	14:12:31.097634	15:00:00	54000
801	187	1	2	2014-09-07	22:04:22.678431	2014-09-08	14:12:42.73282	15:00:00	54000
785	188	1	2	2014-09-06	22:04:44.605261	2014-09-08	14:14:04.692483	15:00:00	54000
784	184	1	2	2014-09-06	22:04:36.321426	2014-09-08	14:17:03.825156	15:00:00	54000
812	173	1	1	2014-09-08	07:23:39.777309	2014-09-08	15:03:54.422772	07:40:14	27614
811	177	1	1	2014-09-08	07:13:39.078317	2014-09-08	15:07:59.026624	07:54:19	28459
813	182	1	2	2014-09-08	14:04:25.433991	2014-09-08	15:53:32.73231	01:49:07	6547
826	184	1	1	2014-09-08	14:17:03.825156	2014-09-08	18:36:56.388605	04:19:52	15592
822	186	1	1	2014-09-08	14:12:31.097634	2014-09-08	22:04:32.740642	07:52:01	28321
824	188	1	1	2014-09-08	14:14:04.692483	2014-09-08	22:04:34.192258	07:50:29	28229
825	185	1	1	2014-09-08	14:14:34.296753	2014-09-08	22:04:42.536301	07:50:08	28208
823	187	1	1	2014-09-08	14:12:42.73282	2014-09-08	22:04:56.144294	07:52:13	28333
829	182	1	1	2014-09-08	15:53:32.73231	2014-09-08	22:04:57.447079	06:11:24	22284
835	182	1	2	2014-09-08	22:04:57.447079	2014-09-09	06:03:23.021726	15:00:00	54000
816	179	1	2	2014-09-08	14:05:02.855293	2014-09-09	06:03:33.789148	15:00:00	54000
821	178	1	2	2014-09-08	14:11:42.131164	2014-09-09	06:04:46.10786	15:00:00	54000
817	176	1	2	2014-09-08	14:05:05.278245	2014-09-09	06:05:59.025303	15:00:00	54000
815	171	1	2	2014-09-08	14:04:58.985839	2014-09-09	06:09:00.644279	15:00:00	54000
814	172	1	2	2014-09-08	14:04:31.844827	2014-09-09	06:09:46.628114	15:00:00	54000
819	183	1	2	2014-09-08	14:06:31.267061	2014-09-09	06:09:47.370898	15:00:00	54000
820	174	1	2	2014-09-08	14:07:16.477697	2014-09-09	06:09:50.65107	15:00:00	54000
818	181	1	2	2014-09-08	14:05:20.959483	2014-09-09	06:09:57.38882	15:00:00	54000
827	173	1	2	2014-09-08	15:03:54.422772	2014-09-09	07:25:10.943243	15:00:00	54000
843	174	1	1	2014-09-09	06:09:50.65107	2014-09-09	14:03:54.41821	07:54:03	28443
838	178	1	1	2014-09-09	06:04:46.10786	2014-09-09	14:04:44.504416	07:59:58	28798
841	172	1	1	2014-09-09	06:09:46.628114	2014-09-09	14:05:05.296294	07:55:18	28518
836	182	1	1	2014-09-09	06:03:23.021726	2014-09-09	14:05:12.977769	08:01:49	28909
837	179	1	1	2014-09-09	06:03:33.789148	2014-09-09	14:05:29.047663	08:01:55	28915
830	184	1	2	2014-09-08	18:36:56.388605	2014-09-09	14:07:00.283341	15:00:00	54000
832	188	1	2	2014-09-08	22:04:34.192258	2014-09-09	14:10:19.178255	15:00:00	54000
834	187	1	2	2014-09-08	22:04:56.144294	2014-09-09	14:10:40.924437	15:00:00	54000
831	186	1	2	2014-09-08	22:04:32.740642	2014-09-09	14:13:58.143093	15:00:00	54000
828	177	1	2	2014-09-08	15:07:59.026624	2014-09-09	07:09:49.964177	15:00:00	54000
842	183	1	1	2014-09-09	06:09:47.370898	2014-09-09	14:04:38.30341	07:54:50	28490
839	176	1	1	2014-09-09	06:05:59.025303	2014-09-09	14:04:50.717277	07:58:51	28731
840	171	1	1	2014-09-09	06:09:00.644279	2014-09-09	14:05:17.995377	07:56:17	28577
844	181	1	1	2014-09-09	06:09:57.38882	2014-09-09	14:08:10.578341	07:58:13	28693
833	185	1	2	2014-09-08	22:04:42.536301	2014-09-09	14:11:37.406165	15:00:00	54000
846	173	1	1	2014-09-09	07:25:10.943243	2014-09-09	15:06:48.93694	07:41:37	27697
845	177	1	1	2014-09-09	07:09:49.964177	2014-09-09	15:09:30.826646	07:59:40	28780
852	182	1	2	2014-09-09	14:05:12.977769	2014-09-09	15:26:45.418655	01:21:32	4892
859	185	1	1	2014-09-09	14:11:37.406165	2014-09-09	21:45:33.494437	07:33:56	27236
864	185	1	2	2014-09-09	21:45:33.494437	2014-09-09	21:45:39.42706	00:00:05	5
865	185	1	1	2014-09-09	21:45:39.42706	2014-09-09	22:04:31.827543	00:18:52	1132
860	186	1	1	2014-09-09	14:13:58.143093	2014-09-09	22:04:41.833208	07:50:43	28243
857	188	1	1	2014-09-09	14:10:19.178255	2014-09-09	22:05:01.848146	07:54:42	28482
858	187	1	1	2014-09-09	14:10:40.924437	2014-09-09	22:05:02.111476	07:54:21	28461
855	184	1	1	2014-09-09	14:07:00.283341	2014-09-09	22:06:13.93772	07:59:13	28753
863	182	1	1	2014-09-09	15:26:45.418655	2014-09-09	22:07:31.091182	06:40:45	24045
871	182	1	2	2014-09-09	22:07:31.091182	2014-09-10	06:03:57.828131	15:00:00	54000
856	181	1	2	2014-09-09	14:08:10.578341	2014-09-10	06:04:24.512577	15:00:00	54000
850	176	1	2	2014-09-09	14:04:50.717277	2014-09-10	06:06:13.14955	15:00:00	54000
854	179	1	2	2014-09-09	14:05:29.047663	2014-09-10	06:06:39.538753	15:00:00	54000
853	171	1	2	2014-09-09	14:05:17.995377	2014-09-10	06:07:54.705804	15:00:00	54000
847	174	1	2	2014-09-09	14:03:54.41821	2014-09-10	06:08:44.231402	15:00:00	54000
848	183	1	2	2014-09-09	14:04:38.30341	2014-09-10	06:09:08.452487	15:00:00	54000
849	178	1	2	2014-09-09	14:04:44.504416	2014-09-10	06:09:22.259223	15:00:00	54000
851	172	1	2	2014-09-09	14:05:05.296294	2014-09-10	06:10:56.101248	15:00:00	54000
862	177	1	2	2014-09-09	15:09:30.826646	2014-09-10	07:12:33.312807	15:00:00	54000
861	173	1	2	2014-09-09	15:06:48.93694	2014-09-10	07:21:06.517816	15:00:00	54000
874	176	1	1	2014-09-10	06:06:13.14955	2014-09-10	14:01:58.630514	07:55:45	28545
880	172	1	1	2014-09-10	06:10:56.101248	2014-09-10	14:04:10.863076	07:53:14	28394
873	181	1	1	2014-09-10	06:04:24.512577	2014-09-10	14:04:14.369429	07:59:49	28789
876	171	1	1	2014-09-10	06:07:54.705804	2014-09-10	14:05:08.328157	07:57:13	28633
878	183	1	1	2014-09-10	06:09:08.452487	2014-09-10	14:05:10.314348	07:56:01	28561
875	179	1	1	2014-09-10	06:06:39.538753	2014-09-10	14:05:18.227059	07:58:38	28718
877	174	1	1	2014-09-10	06:08:44.231402	2014-09-10	14:05:19.636287	07:56:35	28595
872	182	1	1	2014-09-10	06:03:57.828131	2014-09-10	14:05:20.387701	08:01:22	28882
879	178	1	1	2014-09-10	06:09:22.259223	2014-09-10	14:06:59.829753	07:57:37	28657
783	189	1	2	2014-09-06	22:04:14.461204	2014-09-10	14:08:48.338298	15:00:00	54000
869	187	1	2	2014-09-09	22:05:02.111476	2014-09-10	14:09:38.910663	15:00:00	54000
866	185	1	2	2014-09-09	22:04:31.827543	2014-09-10	14:10:10.180771	15:00:00	54000
868	188	1	2	2014-09-09	22:05:01.848146	2014-09-10	14:10:17.968105	15:00:00	54000
870	184	1	2	2014-09-09	22:06:13.93772	2014-09-10	14:13:05.652625	15:00:00	54000
867	186	1	2	2014-09-09	22:04:41.833208	2014-09-10	14:16:46.49883	15:00:00	54000
881	177	1	1	2014-09-10	07:12:33.312807	2014-09-10	15:02:33.748473	07:50:00	28200
882	173	1	1	2014-09-10	07:21:06.517816	2014-09-10	15:03:41.430855	07:42:34	27754
896	184	1	1	2014-09-10	14:13:05.652625	2014-09-10	18:00:07.342304	03:47:01	13621
900	184	1	2	2014-09-10	18:00:07.342304	2014-09-10	18:00:21.287524	00:00:13	13
901	184	1	1	2014-09-10	18:00:21.287524	2014-09-10	18:01:20.448299	00:00:59	59
902	184	1	2	2014-09-10	18:01:20.448299	2014-09-10	18:47:51.409157	00:46:30	2790
895	188	1	1	2014-09-10	14:10:17.968105	2014-09-10	22:05:21.725174	07:55:03	28503
893	187	1	1	2014-09-10	14:09:38.910663	2014-09-10	22:05:22.207412	07:55:43	28543
903	184	1	1	2014-09-10	18:47:51.409157	2014-09-10	22:05:23.156109	03:17:31	11851
894	185	1	1	2014-09-10	14:10:10.180771	2014-09-10	22:05:23.395844	07:55:13	28513
892	189	1	1	2014-09-10	14:08:48.338298	2014-09-10	22:05:27.291686	07:56:38	28598
897	186	1	1	2014-09-10	14:16:46.49883	2014-09-10	22:05:27.834482	07:48:41	28121
888	179	1	2	2014-09-10	14:05:18.227059	2014-09-11	06:06:30.038072	15:00:00	54000
886	171	1	2	2014-09-10	14:05:08.328157	2014-09-11	06:07:03.460445	15:00:00	54000
907	185	1	2	2014-09-10	22:05:23.395844	2014-09-11	06:07:48.775083	15:00:00	54000
883	176	1	2	2014-09-10	14:01:58.630514	2014-09-11	06:08:01.422507	15:00:00	54000
887	183	1	2	2014-09-10	14:05:10.314348	2014-09-11	06:10:30.350869	15:00:00	54000
889	174	1	2	2014-09-10	14:05:19.636287	2014-09-11	06:11:52.664695	15:00:00	54000
885	181	1	2	2014-09-10	14:04:14.369429	2014-09-11	06:12:21.262055	15:00:00	54000
884	172	1	2	2014-09-10	14:04:10.863076	2014-09-11	06:12:26.251795	15:00:00	54000
890	182	1	2	2014-09-10	14:05:20.387701	2014-09-11	06:12:29.532162	15:00:00	54000
899	173	1	2	2014-09-10	15:03:41.430855	2014-09-11	07:14:35.672853	15:00:00	54000
898	177	1	2	2014-09-10	15:02:33.748473	2014-09-11	07:15:28.811811	15:00:00	54000
912	185	1	1	2014-09-11	06:07:48.775083	2014-09-11	13:36:34.311978	07:28:45	26925
918	182	1	1	2014-09-11	06:12:29.532162	2014-09-11	14:04:08.488719	07:51:38	28298
910	179	1	1	2014-09-11	06:06:30.038072	2014-09-11	14:04:33.761292	07:58:03	28683
913	176	1	1	2014-09-11	06:08:01.422507	2014-09-11	14:04:58.278294	07:56:56	28616
915	174	1	1	2014-09-11	06:11:52.664695	2014-09-11	14:06:10.574051	07:54:17	28457
916	181	1	1	2014-09-11	06:12:21.262055	2014-09-11	14:07:28.544408	07:55:07	28507
908	189	1	2	2014-09-10	22:05:27.291686	2014-09-11	14:11:39.920878	15:00:00	54000
904	188	1	2	2014-09-10	22:05:21.725174	2014-09-11	14:11:56.558984	15:00:00	54000
906	184	1	2	2014-09-10	22:05:23.156109	2014-09-11	14:14:46.031061	15:00:00	54000
919	173	1	1	2014-09-11	07:14:35.672853	2014-09-11	15:02:02.311324	07:47:26	28046
891	178	1	2	2014-09-10	14:06:59.829753	2014-09-12	06:04:54.057119	15:00:00	54000
921	185	1	2	2014-09-11	13:36:34.311978	2014-09-11	13:36:42.648722	00:00:08	8
917	172	1	1	2014-09-11	06:12:26.251795	2014-09-11	14:04:55.387016	07:52:29	28349
911	171	1	1	2014-09-11	06:07:03.460445	2014-09-11	14:06:07.225363	07:59:03	28743
922	185	1	1	2014-09-11	13:36:42.648722	2014-09-11	14:06:17.236941	00:29:34	1774
905	187	1	2	2014-09-10	22:05:22.207412	2014-09-11	14:10:38.838084	15:00:00	54000
909	186	1	2	2014-09-10	22:05:27.834482	2014-09-11	14:11:57.340558	15:00:00	54000
920	177	1	1	2014-09-11	07:15:28.811811	2014-09-11	15:03:43.409362	07:48:14	28094
923	182	1	2	2014-09-11	14:04:08.488719	2014-09-11	15:10:40.099057	01:06:31	3991
935	184	1	1	2014-09-11	14:14:46.031061	2014-09-11	20:54:43.537746	06:39:57	23997
933	188	1	1	2014-09-11	14:11:56.558984	2014-09-11	22:05:26.868754	07:53:30	28410
934	186	1	1	2014-09-11	14:11:57.340558	2014-09-11	22:05:40.351928	07:53:43	28423
932	189	1	1	2014-09-11	14:11:39.920878	2014-09-11	22:05:50.478677	07:54:10	28450
931	187	1	1	2014-09-11	14:10:38.838084	2014-09-11	22:06:34.633118	07:55:55	28555
938	182	1	1	2014-09-11	15:10:40.099057	2014-09-11	22:10:54.930447	07:00:14	25214
937	177	1	2	2014-09-11	15:03:43.409362	2014-09-12	06:00:09.350774	15:00:00	54000
944	182	1	2	2014-09-11	22:10:54.930447	2014-09-12	06:04:04.570526	15:00:00	54000
924	179	1	2	2014-09-11	14:04:33.761292	2014-09-12	06:04:22.06779	15:00:00	54000
927	171	1	2	2014-09-11	14:06:07.225363	2014-09-12	06:05:02.189017	15:00:00	54000
928	174	1	2	2014-09-11	14:06:10.574051	2014-09-12	06:05:03.915562	15:00:00	54000
925	172	1	2	2014-09-11	14:04:55.387016	2014-09-12	06:05:15.734463	15:00:00	54000
926	176	1	2	2014-09-11	14:04:58.278294	2014-09-12	06:08:00.576863	15:00:00	54000
930	181	1	2	2014-09-11	14:07:28.544408	2014-09-12	06:12:01.251592	15:00:00	54000
914	183	1	1	2014-09-11	06:10:30.350869	2014-09-12	06:16:16.038947	15:00:00	54000
954	183	1	2	2014-09-12	06:16:16.038947	2014-09-12	06:16:22.172453	00:00:06	6
936	173	1	2	2014-09-11	15:02:02.311324	2014-09-12	07:44:57.521932	15:00:00	54000
945	177	1	1	2014-09-12	06:00:09.350774	2014-09-12	08:57:28.241641	02:57:18	10638
957	177	1	2	2014-09-12	08:57:28.241641	2014-09-12	08:57:36.168045	00:00:07	7
946	182	1	1	2014-09-12	06:04:04.570526	2014-09-12	14:04:42.373982	08:00:37	28837
950	174	1	1	2014-09-12	06:05:03.915562	2014-09-12	14:04:46.912001	07:59:42	28782
949	171	1	1	2014-09-12	06:05:02.189017	2014-09-12	14:04:53.363053	07:59:51	28791
955	183	1	1	2014-09-12	06:16:22.172453	2014-09-12	14:04:59.267805	07:48:37	28117
953	181	1	1	2014-09-12	06:12:01.251592	2014-09-12	14:05:08.89732	07:53:07	28387
952	176	1	1	2014-09-12	06:08:00.576863	2014-09-12	14:05:50.612087	07:57:50	28670
951	172	1	1	2014-09-12	06:05:15.734463	2014-09-12	14:06:08.190177	08:00:52	28852
948	178	1	1	2014-09-12	06:04:54.057119	2014-09-12	14:06:12.603778	08:01:18	28878
947	179	1	1	2014-09-12	06:04:22.06779	2014-09-12	14:06:17.728855	08:01:55	28915
942	189	1	2	2014-09-11	22:05:50.478677	2014-09-12	14:11:12.191255	15:00:00	54000
943	187	1	2	2014-09-11	22:06:34.633118	2014-09-12	14:11:26.267935	15:00:00	54000
940	188	1	2	2014-09-11	22:05:26.868754	2014-09-12	14:12:41.832007	15:00:00	54000
941	186	1	2	2014-09-11	22:05:40.351928	2014-09-12	14:12:58.022759	15:00:00	54000
939	184	1	2	2014-09-11	20:54:43.537746	2014-09-12	14:13:27.987131	15:00:00	54000
929	185	1	2	2014-09-11	14:06:17.236941	2014-09-12	14:13:47.561094	15:00:00	54000
958	177	1	1	2014-09-12	08:57:36.168045	2014-09-12	14:17:02.728665	05:19:26	19166
956	173	1	1	2014-09-12	07:44:57.521932	2014-09-12	15:02:30.936834	07:17:33	26253
969	187	1	1	2014-09-12	14:11:26.267935	2014-09-12	19:52:12.706579	05:40:46	20446
976	187	1	2	2014-09-12	19:52:12.706579	2014-09-12	20:28:43.624536	00:36:30	2190
977	187	1	1	2014-09-12	20:28:43.624536	2014-09-12	20:28:56.066652	00:00:12	12
978	187	1	2	2014-09-12	20:28:56.066652	2014-09-12	21:28:58.108307	01:00:02	3602
970	188	1	1	2014-09-12	14:12:41.832007	2014-09-12	22:05:56.870674	07:53:15	28395
973	185	1	1	2014-09-12	14:13:47.561094	2014-09-12	22:06:02.457373	07:52:14	28334
979	187	1	1	2014-09-12	21:28:58.108307	2014-09-12	22:06:03.665974	00:37:05	2225
968	189	1	1	2014-09-12	14:11:12.191255	2014-09-12	22:06:04.806332	07:54:52	28492
971	186	1	1	2014-09-12	14:12:58.022759	2014-09-12	22:06:14.404651	07:53:16	28396
972	184	1	1	2014-09-12	14:13:27.987131	2014-09-12	22:06:29.428807	07:53:01	28381
959	182	1	2	2014-09-12	14:04:42.373982	2014-09-13	06:06:58.294815	15:00:00	54000
967	179	1	2	2014-09-12	14:06:17.728855	2014-09-13	06:07:55.238802	15:00:00	54000
964	176	1	2	2014-09-12	14:05:50.612087	2014-09-13	06:07:59.986809	15:00:00	54000
962	183	1	2	2014-09-12	14:04:59.267805	2014-09-13	06:08:11.641807	15:00:00	54000
960	174	1	2	2014-09-12	14:04:46.912001	2014-09-13	06:08:51.469253	15:00:00	54000
963	181	1	2	2014-09-12	14:05:08.89732	2014-09-13	06:11:07.122588	15:00:00	54000
974	177	1	2	2014-09-12	14:17:02.728665	2014-09-13	06:39:30.49749	15:00:00	54000
975	173	1	2	2014-09-12	15:02:30.936834	2014-09-13	07:11:53.399064	15:00:00	54000
986	182	1	1	2014-09-13	06:06:58.294815	2014-09-13	12:02:13.058214	05:55:14	21314
994	182	1	2	2014-09-13	12:02:13.058214	2014-09-13	12:14:08.707982	00:11:55	715
987	179	1	1	2014-09-13	06:07:55.238802	2014-09-13	14:02:58.519443	07:55:03	28503
995	182	1	1	2014-09-13	12:14:08.707982	2014-09-13	14:05:21.213111	01:51:12	6672
990	174	1	1	2014-09-13	06:08:51.469253	2014-09-13	14:05:29.185797	07:56:37	28597
991	181	1	1	2014-09-13	06:11:07.122588	2014-09-13	14:05:46.438734	07:54:39	28479
988	176	1	1	2014-09-13	06:07:59.986809	2014-09-13	14:06:09.151313	07:58:09	28689
983	189	1	2	2014-09-12	22:06:04.806332	2014-09-13	14:09:14.827983	15:00:00	54000
985	184	1	2	2014-09-12	22:06:29.428807	2014-09-13	14:12:40.220112	15:00:00	54000
993	173	1	1	2014-09-13	07:11:53.399064	2014-09-13	15:05:08.948599	07:53:15	28395
966	178	1	2	2014-09-12	14:06:12.603778	2014-09-14	06:07:50.211687	15:00:00	54000
965	172	1	2	2014-09-12	14:06:08.190177	2014-09-14	06:11:46.89397	15:00:00	54000
982	187	1	2	2014-09-12	22:06:03.665974	2014-09-14	14:07:55.237103	15:00:00	54000
984	186	1	2	2014-09-12	22:06:14.404651	2014-09-14	14:09:51.531575	15:00:00	54000
997	182	1	2	2014-09-13	14:05:21.213111	2014-09-15	06:09:30.849383	15:00:00	54000
989	183	1	1	2014-09-13	06:08:11.641807	2014-09-13	14:05:29.672417	07:57:18	28638
992	177	1	1	2014-09-13	06:39:30.49749	2014-09-13	14:08:28.741366	07:28:58	26938
980	188	1	2	2014-09-12	22:05:56.870674	2014-09-13	14:10:11.382708	15:00:00	54000
1005	184	1	1	2014-09-13	14:12:40.220112	2014-09-13	16:35:34.319363	02:22:54	8574
1007	184	1	2	2014-09-13	16:35:34.319363	2014-09-13	17:22:21.487023	00:46:47	2807
1003	189	1	1	2014-09-13	14:09:14.827983	2014-09-13	22:06:25.587069	07:57:10	28630
1004	188	1	1	2014-09-13	14:10:11.382708	2014-09-13	22:06:36.157746	07:56:24	28584
961	171	1	2	2014-09-12	14:04:53.363053	2014-09-14	06:06:36.346581	15:00:00	54000
1012	178	1	1	2014-09-14	06:07:50.211687	2014-09-14	07:11:30.522867	01:03:40	3820
1014	178	1	2	2014-09-14	07:11:30.522867	2014-09-14	07:53:03.633976	00:41:33	2493
1011	171	1	1	2014-09-14	06:06:36.346581	2014-09-14	14:05:23.090719	07:58:46	28726
1013	172	1	1	2014-09-14	06:11:46.89397	2014-09-14	14:05:24.542401	07:53:37	28417
981	185	1	2	2014-09-12	22:06:02.457373	2014-09-14	14:06:46.381906	15:00:00	54000
1015	178	1	1	2014-09-14	07:53:03.633976	2014-09-14	14:07:30.736159	06:14:27	22467
1018	185	1	1	2014-09-14	14:06:46.381906	2014-09-14	22:05:38.511206	07:58:52	28732
1020	187	1	1	2014-09-14	14:07:55.237103	2014-09-14	22:05:40.80066	07:57:45	28665
1021	186	1	1	2014-09-14	14:09:51.531575	2014-09-14	22:05:48.088868	07:55:56	28556
1019	178	1	2	2014-09-14	14:07:30.736159	2014-09-15	06:05:25.450974	15:00:00	54000
1016	171	1	2	2014-09-14	14:05:23.090719	2014-09-15	06:06:36.3863	15:00:00	54000
996	179	1	2	2014-09-13	14:02:58.519443	2014-09-15	06:06:46.713589	15:00:00	54000
1000	181	1	2	2014-09-13	14:05:46.438734	2014-09-15	06:06:50.805759	15:00:00	54000
999	183	1	2	2014-09-13	14:05:29.672417	2014-09-15	06:08:22.356697	15:00:00	54000
1017	172	1	2	2014-09-14	14:05:24.542401	2014-09-15	06:09:13.893675	15:00:00	54000
1008	184	1	1	2014-09-13	17:22:21.487023	2014-09-15	06:09:14.544754	15:00:00	54000
1001	176	1	2	2014-09-13	14:06:09.151313	2014-09-15	06:10:05.077741	15:00:00	54000
998	174	1	2	2014-09-13	14:05:29.185797	2014-09-15	06:11:28.139957	15:00:00	54000
1028	181	1	1	2014-09-15	06:06:50.805759	2014-09-15	07:06:07.846219	00:59:17	3557
1035	181	1	2	2014-09-15	07:06:07.846219	2014-09-15	07:06:16.516079	00:00:08	8
1006	173	1	2	2014-09-13	15:05:08.948599	2014-09-15	07:15:10.322674	15:00:00	54000
1002	177	1	2	2014-09-13	14:08:28.741366	2014-09-15	07:24:23.236638	15:00:00	54000
1037	173	1	1	2014-09-15	07:15:10.322674	2014-09-15	07:54:01.161212	00:38:50	2330
1039	173	1	2	2014-09-15	07:54:01.161212	2014-09-15	08:00:39.175558	00:06:38	398
1040	173	1	1	2014-09-15	08:00:39.175558	2014-09-15	08:14:38.731674	00:13:59	839
1041	173	1	2	2014-09-15	08:14:38.731674	2014-09-15	08:14:41.5182	00:00:02	2
1032	182	1	1	2014-09-15	06:09:30.849383	2014-09-15	08:15:05.735567	02:05:34	7534
1042	173	1	1	2014-09-15	08:14:41.5182	2014-09-15	08:16:34.680342	00:01:53	113
1044	173	1	2	2014-09-15	08:16:34.680342	2014-09-15	08:16:41.521251	00:00:06	6
754	180	1	1	2014-09-06	06:03:21.217074	2014-09-15	08:21:42.278484	15:00:00	54000
1043	182	1	2	2014-09-15	08:15:05.735567	2014-09-15	08:21:58.517023	00:06:52	412
1045	173	1	1	2014-09-15	08:16:41.521251	2014-09-15	08:32:23.976736	00:15:42	942
1048	173	1	2	2014-09-15	08:32:23.976736	2014-09-15	08:35:18.207544	00:02:54	174
1038	177	1	1	2014-09-15	07:24:23.236638	2014-09-15	08:43:04.567273	01:18:41	4721
1050	177	1	2	2014-09-15	08:43:04.567273	2014-09-15	08:43:12.657794	00:00:08	8
1030	172	1	1	2014-09-15	06:09:13.893675	2014-09-15	08:43:50.653619	02:34:36	9276
1052	172	1	2	2014-09-15	08:43:50.653619	2014-09-15	08:43:57.299277	00:00:06	6
1051	177	1	1	2014-09-15	08:43:12.657794	2014-09-15	08:45:09.949903	00:01:57	117
1054	177	1	2	2014-09-15	08:45:09.949903	2014-09-15	09:10:30.478446	00:25:20	1520
1055	177	1	1	2014-09-15	09:10:30.478446	2014-09-15	09:11:58.998499	00:01:28	88
1056	177	1	2	2014-09-15	09:11:58.998499	2014-09-15	09:12:15.203788	00:00:16	16
1057	177	1	1	2014-09-15	09:12:15.203788	2014-09-15	09:13:45.033067	00:01:29	89
1058	177	1	2	2014-09-15	09:13:45.033067	2014-09-15	09:13:52.033891	00:00:07	7
1026	171	1	1	2014-09-15	06:06:36.3863	2014-09-15	09:15:01.507379	03:08:25	11305
1060	171	1	2	2014-09-15	09:15:01.507379	2014-09-15	09:15:07.38914	00:00:05	5
1059	177	1	1	2014-09-15	09:13:52.033891	2014-09-15	09:15:59.116665	00:02:07	127
1062	177	1	2	2014-09-15	09:15:59.116665	2014-09-15	09:16:05.132302	00:00:06	6
1063	177	1	1	2014-09-15	09:16:05.132302	2014-09-15	09:17:34.097819	00:01:28	88
1064	177	1	2	2014-09-15	09:17:34.097819	2014-09-15	09:18:17.886515	00:00:43	43
1065	177	1	1	2014-09-15	09:18:17.886515	2014-09-15	09:21:31.780434	00:03:13	193
1066	177	1	2	2014-09-15	09:21:31.780434	2014-09-15	09:21:38.404219	00:00:06	6
1061	171	1	1	2014-09-15	09:15:07.38914	2014-09-15	09:21:47.173953	00:06:39	399
1068	171	1	2	2014-09-15	09:21:47.173953	2014-09-15	09:21:56.032796	00:00:08	8
1067	177	1	1	2014-09-15	09:21:38.404219	2014-09-15	09:22:28.346399	00:00:49	49
1070	177	1	2	2014-09-15	09:22:28.346399	2014-09-15	09:22:43.931004	00:00:15	15
1071	177	1	1	2014-09-15	09:22:43.931004	2014-09-15	09:24:32.862159	00:01:48	108
1072	177	1	2	2014-09-15	09:24:32.862159	2014-09-15	09:24:42.763681	00:00:09	9
1069	171	1	1	2014-09-15	09:21:56.032796	2014-09-15	09:28:28.188442	00:06:32	392
1074	171	1	2	2014-09-15	09:28:28.188442	2014-09-15	09:28:34.088562	00:00:05	5
1023	187	1	2	2014-09-14	22:05:40.80066	2014-09-15	10:34:12.185745	15:00:00	54000
1033	176	1	1	2014-09-15	06:10:05.077741	2014-09-15	14:01:30.008371	07:51:24	28284
1025	178	1	1	2014-09-15	06:05:25.450974	2014-09-15	14:02:36.501294	07:57:11	28631
1047	182	1	1	2014-09-15	08:21:58.517023	2014-09-15	14:02:43.841811	05:40:45	20445
1053	172	1	1	2014-09-15	08:43:57.299277	2014-09-15	14:03:15.504892	05:19:18	19158
1009	189	1	2	2014-09-13	22:06:25.587069	2014-09-15	14:04:07.917435	15:00:00	54000
1029	183	1	1	2014-09-15	06:08:22.356697	2014-09-15	14:04:13.575459	07:55:51	28551
1031	184	1	2	2014-09-15	06:09:14.544754	2014-09-15	14:07:17.940672	07:58:03	28683
1022	185	1	2	2014-09-14	22:05:38.511206	2014-09-15	14:07:30.713979	15:00:00	54000
1049	173	1	1	2014-09-15	08:35:18.207544	2014-09-15	15:05:19.869261	06:30:01	23401
1046	180	1	2	2014-09-15	08:21:42.278484	2014-09-16	06:12:09.905974	15:00:00	54000
1075	171	1	1	2014-09-15	09:28:34.088562	2014-09-15	09:33:02.809296	00:04:28	268
1076	171	1	2	2014-09-15	09:33:02.809296	2014-09-15	09:33:22.192011	00:00:19	19
1073	177	1	1	2014-09-15	09:24:42.763681	2014-09-15	09:37:46.388599	00:13:03	783
1078	177	1	2	2014-09-15	09:37:46.388599	2014-09-15	09:37:54.214436	00:00:07	7
1079	177	1	1	2014-09-15	09:37:54.214436	2014-09-15	09:45:14.678392	00:07:20	440
1080	177	1	2	2014-09-15	09:45:14.678392	2014-09-15	09:45:34.788678	00:00:20	20
1082	187	1	1	2014-09-15	10:34:12.185745	2014-09-15	10:34:32.605014	00:00:20	20
1081	177	1	1	2014-09-15	09:45:34.788678	2014-09-15	10:34:48.118582	00:49:13	2953
1084	177	1	2	2014-09-15	10:34:48.118582	2014-09-15	10:34:54.478393	00:00:06	6
1083	187	1	2	2014-09-15	10:34:32.605014	2014-09-15	10:35:15.098557	00:00:42	42
1085	177	1	1	2014-09-15	10:34:54.478393	2014-09-15	10:35:31.655665	00:00:37	37
1087	177	1	2	2014-09-15	10:35:31.655665	2014-09-15	11:30:57.297624	00:55:25	3325
1077	171	1	1	2014-09-15	09:33:22.192011	2014-09-15	11:52:48.968746	02:19:26	8366
1089	171	1	2	2014-09-15	11:52:48.968746	2014-09-15	11:52:55.598948	00:00:06	6
1090	171	1	1	2014-09-15	11:52:55.598948	2014-09-15	11:53:03.679502	00:00:08	8
1091	171	1	2	2014-09-15	11:53:03.679502	2014-09-15	11:53:09.894813	00:00:06	6
1088	177	1	1	2014-09-15	11:30:57.297624	2014-09-15	13:43:31.3019	02:12:34	7954
1093	177	1	2	2014-09-15	13:43:31.3019	2014-09-15	13:43:42.103108	00:00:10	10
1034	174	1	1	2014-09-15	06:11:28.139957	2014-09-15	14:02:28.925318	07:51:00	28260
1092	171	1	1	2014-09-15	11:53:09.894813	2014-09-15	14:02:30.057202	02:09:20	7760
1027	179	1	1	2014-09-15	06:06:46.713589	2014-09-15	14:02:43.146879	07:55:56	28556
1036	181	1	1	2014-09-15	07:06:16.516079	2014-09-15	14:03:20.282955	06:57:03	25023
1010	188	1	2	2014-09-13	22:06:36.157746	2014-09-15	14:07:03.380828	15:00:00	54000
1100	182	1	2	2014-09-15	14:02:43.841811	2014-09-15	14:09:43.028689	00:06:59	419
1024	186	1	2	2014-09-14	22:05:48.088868	2014-09-15	14:10:56.352746	15:00:00	54000
1106	184	1	1	2014-09-15	14:07:17.940672	2014-09-15	16:16:29.214405	02:09:11	7751
1109	186	1	1	2014-09-15	14:10:56.352746	2014-09-15	16:47:16.377561	02:36:20	9380
1112	186	1	2	2014-09-15	16:47:16.377561	2014-09-15	21:47:56.249982	05:00:39	18039
1111	184	1	2	2014-09-15	16:16:29.214405	2014-09-15	21:48:47.833886	05:32:18	19938
1107	185	1	1	2014-09-15	14:07:30.713979	2014-09-15	22:07:14.785625	07:59:44	28784
1113	186	1	1	2014-09-15	21:47:56.249982	2014-09-15	22:07:15.699057	00:19:19	1159
1105	188	1	1	2014-09-15	14:07:03.380828	2014-09-15	22:07:18.847922	08:00:15	28815
1114	184	1	1	2014-09-15	21:48:47.833886	2014-09-15	22:07:53.721139	00:19:05	1145
1108	182	1	1	2014-09-15	14:09:43.028689	2014-09-15	22:08:02.883789	07:58:19	28699
1098	178	1	2	2014-09-15	14:02:36.501294	2014-09-16	06:03:13.617731	15:00:00	54000
1097	171	1	2	2014-09-15	14:02:30.057202	2014-09-16	06:03:24.384964	15:00:00	54000
1096	174	1	2	2014-09-15	14:02:28.925318	2014-09-16	06:04:51.167594	15:00:00	54000
1102	181	1	2	2014-09-15	14:03:20.282955	2014-09-16	06:04:54.271318	15:00:00	54000
1104	183	1	2	2014-09-15	14:04:13.575459	2014-09-16	06:05:50.534874	15:00:00	54000
1119	182	1	2	2014-09-15	22:08:02.883789	2014-09-16	06:06:22.597285	15:00:00	54000
1101	172	1	2	2014-09-15	14:03:15.504892	2014-09-16	06:06:38.878703	15:00:00	54000
1095	176	1	2	2014-09-15	14:01:30.008371	2014-09-16	06:06:54.567465	15:00:00	54000
1099	179	1	2	2014-09-15	14:02:43.146879	2014-09-16	06:07:01.372913	15:00:00	54000
1125	182	1	1	2014-09-16	06:06:22.597285	2014-09-16	06:09:56.835918	00:03:34	214
1110	173	1	2	2014-09-15	15:05:19.869261	2014-09-16	07:11:29.265215	15:00:00	54000
73	170	1	1	2014-08-18	11:57:22.027885	2014-09-16	10:03:51.330707	15:00:00	54000
1122	174	1	1	2014-09-16	06:04:51.167594	2014-09-16	14:00:36.115972	07:55:44	28544
1133	174	1	2	2014-09-16	14:00:36.115972	2014-09-16	14:01:12.064548	00:00:35	35
1126	172	1	1	2014-09-16	06:06:38.878703	2014-09-16	14:02:27.209102	07:55:48	28548
1134	174	1	1	2014-09-16	14:01:12.064548	2014-09-16	14:02:33.54429	00:01:21	81
1128	179	1	1	2014-09-16	06:07:01.372913	2014-09-16	14:02:52.821091	07:55:51	28551
1127	176	1	1	2014-09-16	06:06:54.567465	2014-09-16	14:02:58.318922	07:56:03	28563
1130	180	1	1	2014-09-16	06:12:09.905974	2014-09-16	14:04:14.620829	07:52:04	28324
1121	171	1	1	2014-09-16	06:03:24.384964	2014-09-16	14:04:15.63823	08:00:51	28851
1123	181	1	1	2014-09-16	06:04:54.271318	2014-09-16	14:04:41.356332	07:59:47	28787
180	175	1	1	2014-08-20	06:56:20.186358	2014-09-16	14:05:00.077262	15:00:00	54000
1124	183	1	1	2014-09-16	06:05:50.534874	2014-09-16	14:05:25.137507	07:59:34	28774
1118	184	1	2	2014-09-15	22:07:53.721139	2014-09-16	14:06:07.195661	15:00:00	54000
1120	178	1	1	2014-09-16	06:03:13.617731	2014-09-16	14:06:25.169134	08:03:11	28991
1115	185	1	2	2014-09-15	22:07:14.785625	2014-09-16	14:07:55.158672	15:00:00	54000
1116	186	1	2	2014-09-15	22:07:15.699057	2014-09-16	14:09:49.306378	15:00:00	54000
1117	188	1	2	2014-09-15	22:07:18.847922	2014-09-16	14:19:57.363994	15:00:00	54000
1094	177	1	1	2014-09-15	13:43:42.103108	2014-09-16	15:06:27.947917	15:00:00	54000
1148	188	1	1	2014-09-16	14:19:57.363994	2014-09-16	17:38:59.973591	03:19:02	11942
1150	188	1	2	2014-09-16	17:38:59.973591	2014-09-16	20:08:29.29616	02:29:29	8969
1147	186	1	1	2014-09-16	14:09:49.306378	2014-09-16	22:06:48.386477	07:56:59	28619
1144	184	1	1	2014-09-16	14:06:07.195661	2014-09-16	22:06:52.638156	08:00:45	28845
1086	187	1	1	2014-09-15	10:35:15.098557	2014-09-16	22:07:01.711504	15:00:00	54000
1103	189	1	1	2014-09-15	14:04:07.917435	2014-09-16	22:07:10.348655	15:00:00	54000
1137	179	1	2	2014-09-16	14:02:52.821091	2014-09-17	06:03:50.555343	15:00:00	54000
1138	176	1	2	2014-09-16	14:02:58.318922	2014-09-17	06:04:18.728799	15:00:00	54000
1139	180	1	2	2014-09-16	14:04:14.620829	2014-09-17	06:04:55.602306	15:00:00	54000
1145	178	1	2	2014-09-16	14:06:25.169134	2014-09-17	06:08:05.581865	15:00:00	54000
1135	172	1	2	2014-09-16	14:02:27.209102	2014-09-17	06:09:56.648039	15:00:00	54000
1142	175	1	2	2014-09-16	14:05:00.077262	2014-09-17	06:13:55.256872	15:00:00	54000
1132	170	1	2	2014-09-16	10:03:51.330707	2014-09-17	07:00:24.154185	15:00:00	54000
1131	173	1	1	2014-09-16	07:11:29.265215	2014-09-17	15:18:04.060428	15:00:00	54000
1129	182	1	2	2014-09-16	06:09:56.835918	2014-09-27	15:31:25.061726	15:00:00	54000
1146	185	1	1	2014-09-16	14:07:55.158672	2014-09-16	22:06:48.10626	07:58:52	28732
1151	188	1	1	2014-09-16	20:08:29.29616	2014-09-16	22:06:56.364743	01:58:27	7107
1141	181	1	2	2014-09-16	14:04:41.356332	2014-09-17	06:01:10.461751	15:00:00	54000
1140	171	1	2	2014-09-16	14:04:15.63823	2014-09-17	06:04:03.103942	15:00:00	54000
1143	183	1	2	2014-09-16	14:05:25.137507	2014-09-17	06:06:32.844066	15:00:00	54000
1136	174	1	2	2014-09-16	14:02:33.54429	2014-09-17	06:10:15.559035	15:00:00	54000
1149	177	1	2	2014-09-16	15:06:27.947917	2014-09-17	07:15:56.292182	15:00:00	54000
1169	177	1	1	2014-09-17	07:15:56.292182	2014-09-17	07:17:37.418946	00:01:41	101
1170	177	1	2	2014-09-17	07:17:37.418946	2014-09-17	07:17:48.242881	00:00:10	10
1166	174	1	1	2014-09-17	06:10:15.559035	2014-09-17	14:02:29.502207	07:52:13	28333
1158	181	1	1	2014-09-17	06:01:10.461751	2014-09-17	14:02:40.388934	08:01:29	28889
1159	179	1	1	2014-09-17	06:03:50.555343	2014-09-17	14:03:37.396341	07:59:46	28786
1164	178	1	1	2014-09-17	06:08:05.581865	2014-09-17	14:03:42.337636	07:55:36	28536
1167	175	1	1	2014-09-17	06:13:55.256872	2014-09-17	14:03:49.987688	07:49:54	28194
1162	180	1	1	2014-09-17	06:04:55.602306	2014-09-17	14:04:56.670905	08:00:01	28801
1165	172	1	1	2014-09-17	06:09:56.648039	2014-09-17	14:05:59.82208	07:56:03	28563
1153	186	1	2	2014-09-16	22:06:48.386477	2014-09-17	14:06:00.942138	15:00:00	54000
1161	176	1	1	2014-09-17	06:04:18.728799	2014-09-17	14:06:02.834021	08:01:44	28904
1163	183	1	1	2014-09-17	06:06:32.844066	2014-09-17	14:06:24.361724	07:59:51	28791
1160	171	1	1	2014-09-17	06:04:03.103942	2014-09-17	14:06:44.18155	08:02:41	28961
1157	189	1	2	2014-09-16	22:07:10.348655	2014-09-17	14:08:22.675968	15:00:00	54000
1156	187	1	2	2014-09-16	22:07:01.711504	2014-09-17	14:08:28.435727	15:00:00	54000
1155	188	1	2	2014-09-16	22:06:56.364743	2014-09-17	14:09:03.777861	15:00:00	54000
1152	185	1	2	2014-09-16	22:06:48.10626	2014-09-17	14:09:24.249906	15:00:00	54000
1154	184	1	2	2014-09-16	22:06:52.638156	2014-09-17	14:10:13.984934	15:00:00	54000
1171	177	1	1	2014-09-17	07:17:48.242881	2014-09-17	15:12:53.601819	07:55:05	28505
1187	184	1	1	2014-09-17	14:10:13.984934	2014-09-17	17:55:51.838238	03:45:37	13537
1190	184	1	2	2014-09-17	17:55:51.838238	2014-09-17	18:39:11.562378	00:43:19	2599
1185	188	1	1	2014-09-17	14:09:03.777861	2014-09-17	22:07:16.228161	07:58:12	28692
1186	185	1	1	2014-09-17	14:09:24.249906	2014-09-17	22:07:17.658149	07:57:53	28673
1179	186	1	1	2014-09-17	14:06:00.942138	2014-09-17	22:07:21.036249	08:01:20	28880
1183	189	1	1	2014-09-17	14:08:22.675968	2014-09-17	22:07:21.733411	07:58:59	28739
1184	187	1	1	2014-09-17	14:08:28.435727	2014-09-17	22:07:22.332728	07:58:53	28733
1191	184	1	1	2014-09-17	18:39:11.562378	2014-09-17	22:07:33.974294	03:28:22	12502
1182	171	1	2	2014-09-17	14:06:44.18155	2014-09-18	06:02:11.769833	15:00:00	54000
1177	180	1	2	2014-09-17	14:04:56.670905	2014-09-18	06:02:19.257816	15:00:00	54000
1175	178	1	2	2014-09-17	14:03:42.337636	2014-09-18	06:03:10.193966	15:00:00	54000
1172	174	1	2	2014-09-17	14:02:29.502207	2014-09-18	06:04:16.679492	15:00:00	54000
1174	179	1	2	2014-09-17	14:03:37.396341	2014-09-18	06:04:37.360139	15:00:00	54000
1180	176	1	2	2014-09-17	14:06:02.834021	2014-09-18	06:07:08.721185	15:00:00	54000
1176	175	1	2	2014-09-17	14:03:49.987688	2014-09-18	06:07:45.08753	15:00:00	54000
1173	181	1	2	2014-09-17	14:02:40.388934	2014-09-18	06:08:57.41898	15:00:00	54000
1181	183	1	2	2014-09-17	14:06:24.361724	2014-09-18	06:09:47.243303	15:00:00	54000
1178	172	1	2	2014-09-17	14:05:59.82208	2014-09-18	06:10:46.10208	15:00:00	54000
1189	173	1	2	2014-09-17	15:18:04.060428	2014-09-18	07:13:58.006328	15:00:00	54000
1188	177	1	2	2014-09-17	15:12:53.601819	2014-09-18	07:16:05.598779	15:00:00	54000
1168	170	1	1	2014-09-17	07:00:24.154185	2014-09-18	13:57:32.290605	15:00:00	54000
1198	171	1	1	2014-09-18	06:02:11.769833	2014-09-18	14:04:42.282941	08:02:30	28950
1199	180	1	1	2014-09-18	06:02:19.257816	2014-09-18	14:05:10.168699	08:02:50	28970
1205	181	1	1	2014-09-18	06:08:57.41898	2014-09-18	14:05:26.542635	07:56:29	28589
1207	172	1	1	2014-09-18	06:10:46.10208	2014-09-18	14:06:22.927507	07:55:36	28536
1204	175	1	1	2014-09-18	06:07:45.08753	2014-09-18	14:06:31.799379	07:58:46	28726
1206	183	1	1	2014-09-18	06:09:47.243303	2014-09-18	14:06:58.203994	07:57:10	28630
1200	178	1	1	2014-09-18	06:03:10.193966	2014-09-18	14:07:01.257697	08:03:51	29031
1203	176	1	1	2014-09-18	06:07:08.721185	2014-09-18	14:07:37.380417	08:00:28	28828
1201	174	1	1	2014-09-18	06:04:16.679492	2014-09-18	14:08:00.071424	08:03:43	29023
1202	179	1	1	2014-09-18	06:04:37.360139	2014-09-18	14:08:17.905728	08:03:40	29020
1195	189	1	2	2014-09-17	22:07:21.733411	2014-09-18	14:10:18.339197	15:00:00	54000
1192	188	1	2	2014-09-17	22:07:16.228161	2014-09-18	14:12:06.549522	15:00:00	54000
1196	187	1	2	2014-09-17	22:07:22.332728	2014-09-18	14:12:16.95472	15:00:00	54000
1194	186	1	2	2014-09-17	22:07:21.036249	2014-09-18	14:12:47.496457	15:00:00	54000
1193	185	1	2	2014-09-17	22:07:17.658149	2014-09-18	14:12:50.070267	15:00:00	54000
1197	184	1	2	2014-09-17	22:07:33.974294	2014-09-18	14:14:29.699986	15:00:00	54000
1208	173	1	1	2014-09-18	07:13:58.006328	2014-09-18	14:59:41.152621	07:45:43	27943
1209	177	1	1	2014-09-18	07:16:05.598779	2014-09-18	15:08:47.231522	07:52:41	28361
1221	189	1	1	2014-09-18	14:10:18.339197	2014-09-18	22:10:21.955125	08:00:03	28803
1222	188	1	1	2014-09-18	14:12:06.549522	2014-09-18	22:10:31.238295	07:58:24	28704
1225	185	1	1	2014-09-18	14:12:50.070267	2014-09-18	22:12:39.484973	07:59:49	28789
1223	187	1	1	2014-09-18	14:12:16.95472	2014-09-18	22:15:09.921074	08:02:52	28972
1219	174	1	2	2014-09-18	14:08:00.071424	2014-09-19	06:03:29.507137	15:00:00	54000
1218	176	1	2	2014-09-18	14:07:37.380417	2014-09-19	06:04:19.22635	15:00:00	54000
1217	178	1	2	2014-09-18	14:07:01.257697	2014-09-19	06:04:38.223093	15:00:00	54000
1216	183	1	2	2014-09-18	14:06:58.203994	2014-09-19	06:06:16.213567	15:00:00	54000
1211	171	1	2	2014-09-18	14:04:42.282941	2014-09-19	06:06:29.674302	15:00:00	54000
1214	172	1	2	2014-09-18	14:06:22.927507	2014-09-19	06:10:08.690634	15:00:00	54000
1215	175	1	2	2014-09-18	14:06:31.799379	2014-09-19	06:11:46.92798	15:00:00	54000
1227	173	1	2	2014-09-18	14:59:41.152621	2014-09-19	07:15:47.014542	15:00:00	54000
1226	184	1	1	2014-09-18	14:14:29.699986	2014-09-18	22:12:36.86436	07:58:07	28687
1224	186	1	1	2014-09-18	14:12:47.496457	2014-09-18	22:17:03.036917	08:04:15	29055
1212	180	1	2	2014-09-18	14:05:10.168699	2014-09-19	06:03:29.609019	15:00:00	54000
1220	179	1	2	2014-09-18	14:08:17.905728	2014-09-19	06:05:15.182377	15:00:00	54000
1213	181	1	2	2014-09-18	14:05:26.542635	2014-09-19	06:06:41.378262	15:00:00	54000
1228	177	1	2	2014-09-18	15:08:47.231522	2014-09-19	07:11:32.641241	15:00:00	54000
1210	170	1	2	2014-09-18	13:57:32.290605	2014-09-19	07:29:02.146398	15:00:00	54000
1247	170	1	1	2014-09-19	07:29:02.146398	2014-09-19	07:37:26.017845	00:08:23	503
1248	170	1	2	2014-09-19	07:37:26.017845	2014-09-19	07:54:57.255052	00:17:31	1051
1249	170	1	1	2014-09-19	07:54:57.255052	2014-09-19	10:18:21.558957	02:23:24	8604
1250	170	1	2	2014-09-19	10:18:21.558957	2014-09-19	12:36:58.27152	02:18:36	8316
1251	170	1	1	2014-09-19	12:36:58.27152	2014-09-19	13:14:52.873722	00:37:54	2274
1235	174	1	1	2014-09-19	06:03:29.507137	2014-09-19	14:04:37.872984	08:01:08	28868
1239	179	1	1	2014-09-19	06:05:15.182377	2014-09-19	14:04:50.547446	07:59:35	28775
1236	180	1	1	2014-09-19	06:03:29.609019	2014-09-19	14:05:04.747436	08:01:35	28895
1238	178	1	1	2014-09-19	06:04:38.223093	2014-09-19	14:05:23.536028	08:00:45	28845
1243	172	1	1	2014-09-19	06:10:08.690634	2014-09-19	14:06:02.695981	07:55:54	28554
1242	181	1	1	2014-09-19	06:06:41.378262	2014-09-19	14:06:37.901501	07:59:56	28796
1237	176	1	1	2014-09-19	06:04:19.22635	2014-09-19	14:06:45.776357	08:02:26	28946
1241	171	1	1	2014-09-19	06:06:29.674302	2014-09-19	14:07:08.72458	08:00:39	28839
1244	175	1	1	2014-09-19	06:11:46.92798	2014-09-19	14:07:26.952424	07:55:40	28540
1240	183	1	1	2014-09-19	06:06:16.213567	2014-09-19	14:07:27.637915	08:01:11	28871
1229	189	1	2	2014-09-18	22:10:21.955125	2014-09-19	14:10:48.981498	15:00:00	54000
1233	187	1	2	2014-09-18	22:15:09.921074	2014-09-19	14:12:00.943256	15:00:00	54000
1231	184	1	2	2014-09-18	22:12:36.86436	2014-09-19	14:12:49.177655	15:00:00	54000
1232	185	1	2	2014-09-18	22:12:39.484973	2014-09-19	14:13:30.598518	15:00:00	54000
1230	188	1	2	2014-09-18	22:10:31.238295	2014-09-19	14:14:37.045749	15:00:00	54000
1234	186	1	2	2014-09-18	22:17:03.036917	2014-09-19	14:16:15.704886	15:00:00	54000
1265	184	1	1	2014-09-19	14:12:49.177655	2014-09-19	14:36:18.156126	00:23:28	1408
1245	177	1	1	2014-09-19	07:11:32.641241	2014-09-19	15:04:18.373228	07:52:45	28365
1246	173	1	1	2014-09-19	07:15:47.014542	2014-09-19	15:08:14.338643	07:52:27	28347
1269	184	1	2	2014-09-19	14:36:18.156126	2014-09-19	20:37:44.210739	06:01:26	21686
1267	188	1	1	2014-09-19	14:14:37.045749	2014-09-19	22:07:04.780445	07:52:27	28347
1266	185	1	1	2014-09-19	14:13:30.598518	2014-09-19	22:07:06.351464	07:53:35	28415
1268	186	1	1	2014-09-19	14:16:15.704886	2014-09-19	22:07:07.752101	07:50:52	28252
1272	184	1	1	2014-09-19	20:37:44.210739	2014-09-19	22:07:42.220776	01:29:58	5398
1264	187	1	1	2014-09-19	14:12:00.943256	2014-09-19	22:08:15.700787	07:56:14	28574
1253	174	1	2	2014-09-19	14:04:37.872984	2014-09-20	06:06:30.218518	15:00:00	54000
1255	180	1	2	2014-09-19	14:05:04.747436	2014-09-20	06:06:31.45855	15:00:00	54000
1262	183	1	2	2014-09-19	14:07:27.637915	2014-09-20	06:07:15.767923	15:00:00	54000
1279	180	1	1	2014-09-20	06:06:31.45855	2014-09-20	06:07:22.298745	00:00:50	50
1254	179	1	2	2014-09-19	14:04:50.547446	2014-09-20	06:08:27.527944	15:00:00	54000
1258	181	1	2	2014-09-19	14:06:37.901501	2014-09-20	06:10:07.454552	15:00:00	54000
1261	175	1	2	2014-09-19	14:07:26.952424	2014-09-20	06:10:44.397561	15:00:00	54000
1270	177	1	2	2014-09-19	15:04:18.373228	2014-09-20	06:11:23.249213	15:00:00	54000
1257	172	1	2	2014-09-19	14:06:02.695981	2014-09-20	06:17:40.188219	15:00:00	54000
1259	176	1	2	2014-09-19	14:06:45.776357	2014-09-20	06:20:31.016101	15:00:00	54000
1252	170	1	2	2014-09-19	13:14:52.873722	2014-09-20	07:14:37.949531	15:00:00	54000
1271	173	1	2	2014-09-19	15:08:14.338643	2014-09-20	07:15:00.970243	15:00:00	54000
1288	170	1	1	2014-09-20	07:14:37.949531	2014-09-20	10:25:59.651794	03:11:21	11481
1286	172	1	1	2014-09-20	06:17:40.188219	2014-09-20	14:07:52.935357	07:50:12	28212
1283	181	1	1	2014-09-20	06:10:07.454552	2014-09-20	14:08:03.455411	07:57:56	28676
1280	183	1	1	2014-09-20	06:07:15.767923	2014-09-20	14:08:10.524033	08:00:54	28854
1278	174	1	1	2014-09-20	06:06:30.218518	2014-09-20	14:08:20.197982	08:01:49	28909
1284	175	1	1	2014-09-20	06:10:44.397561	2014-09-20	14:08:42.883971	07:57:58	28678
1282	179	1	1	2014-09-20	06:08:27.527944	2014-09-20	14:09:12.968333	08:00:45	28845
1285	177	1	1	2014-09-20	06:11:23.249213	2014-09-20	14:09:22.850012	07:57:59	28679
2369	183	1	2	2015-05-14	12:45:35.918674	\N	\N	\N	\N
1273	188	1	2	2014-09-19	22:07:04.780445	2014-09-20	14:11:33.930563	15:00:00	54000
1276	184	1	2	2014-09-19	22:07:42.220776	2014-09-20	14:14:21.925255	15:00:00	54000
1287	176	1	1	2014-09-20	06:20:31.016101	2014-09-20	14:21:44.406604	08:01:13	28873
1289	173	1	1	2014-09-20	07:15:00.970243	2014-09-20	15:08:58.056165	07:53:57	28437
1263	189	1	1	2014-09-19	14:10:48.981498	2014-09-20	17:39:31.654748	15:00:00	54000
1302	189	1	2	2014-09-20	17:39:31.654748	2014-09-20	17:45:26.364447	00:05:54	354
1299	184	1	1	2014-09-20	14:14:21.925255	2014-09-20	22:07:01.125392	07:52:39	28359
1298	188	1	1	2014-09-20	14:11:33.930563	2014-09-20	22:07:04.542723	07:55:30	28530
1303	189	1	1	2014-09-20	17:45:26.364447	2014-09-20	22:07:04.678238	04:21:38	15698
1281	180	1	2	2014-09-20	06:07:22.298745	2014-09-21	06:04:49.578845	15:00:00	54000
1256	178	1	2	2014-09-19	14:05:23.536028	2014-09-21	06:07:01.438225	15:00:00	54000
1275	186	1	2	2014-09-19	22:07:07.752101	2014-09-21	14:06:21.342483	15:00:00	54000
1274	185	1	2	2014-09-19	22:07:06.351464	2014-09-21	14:08:45.728475	15:00:00	54000
1292	181	1	2	2014-09-20	14:08:03.455411	2014-09-22	06:03:47.881599	15:00:00	54000
1296	179	1	2	2014-09-20	14:09:12.968333	2014-09-22	06:05:28.457219	15:00:00	54000
1293	183	1	2	2014-09-20	14:08:10.524033	2014-09-22	06:08:01.934205	15:00:00	54000
1291	172	1	2	2014-09-20	14:07:52.935357	2014-09-22	06:08:47.898994	15:00:00	54000
1301	173	1	2	2014-09-20	15:08:58.056165	2014-09-22	07:10:50.331192	15:00:00	54000
1297	177	1	2	2014-09-20	14:09:22.850012	2014-09-22	07:12:02.00567	15:00:00	54000
1304	184	1	2	2014-09-20	22:07:01.125392	2014-09-22	14:13:56.152786	15:00:00	54000
1305	188	1	2	2014-09-20	22:07:04.542723	2014-09-22	14:17:34.142095	15:00:00	54000
1260	171	1	2	2014-09-19	14:07:08.72458	2014-09-21	06:06:26.141106	15:00:00	54000
1308	171	1	1	2014-09-21	06:06:26.141106	2014-09-21	14:06:10.753835	07:59:44	28784
1307	180	1	1	2014-09-21	06:04:49.578845	2014-09-21	14:06:12.714046	08:01:23	28883
1309	178	1	1	2014-09-21	06:07:01.438225	2014-09-21	14:06:15.553482	07:59:14	28754
1277	187	1	2	2014-09-19	22:08:15.700787	2014-09-21	14:08:39.85147	15:00:00	54000
1315	185	1	1	2014-09-21	14:08:45.728475	2014-09-21	16:28:35.522648	02:19:49	8389
1316	185	1	2	2014-09-21	16:28:35.522648	2014-09-21	16:28:41.286935	00:00:05	5
1313	186	1	1	2014-09-21	14:06:21.342483	2014-09-21	22:05:44.330132	07:59:22	28762
1317	185	1	1	2014-09-21	16:28:41.286935	2014-09-21	22:05:44.564318	05:37:03	20223
1314	187	1	1	2014-09-21	14:08:39.85147	2014-09-21	22:05:59.900161	07:57:20	28640
1312	178	1	2	2014-09-21	14:06:15.553482	2014-09-22	06:03:43.41098	15:00:00	54000
1310	171	1	2	2014-09-21	14:06:10.753835	2014-09-22	06:03:59.817376	15:00:00	54000
1294	174	1	2	2014-09-20	14:08:20.197982	2014-09-22	06:04:58.223759	15:00:00	54000
1300	176	1	2	2014-09-20	14:21:44.406604	2014-09-22	06:06:34.011469	15:00:00	54000
1295	175	1	2	2014-09-20	14:08:42.883971	2014-09-22	06:09:08.354525	15:00:00	54000
1311	180	1	2	2014-09-21	14:06:12.714046	2014-09-22	06:09:08.743128	15:00:00	54000
1290	170	1	2	2014-09-20	10:25:59.651794	2014-09-22	07:12:15.936717	15:00:00	54000
1333	170	1	1	2014-09-22	07:12:15.936717	2014-09-22	13:59:44.957408	06:47:29	24449
1321	178	1	1	2014-09-22	06:03:43.41098	2014-09-22	14:00:38.386551	07:56:54	28614
1323	171	1	1	2014-09-22	06:03:59.817376	2014-09-22	14:01:36.386513	07:57:36	28656
1322	181	1	1	2014-09-22	06:03:47.881599	2014-09-22	14:02:29.251159	07:58:41	28721
1306	189	1	2	2014-09-20	22:07:04.678238	2014-09-22	14:05:27.737574	15:00:00	54000
1330	180	1	1	2014-09-22	06:09:08.743128	2014-09-22	14:05:29.414016	07:56:20	28580
1324	174	1	1	2014-09-22	06:04:58.223759	2014-09-22	14:07:20.216668	08:02:21	28941
1325	179	1	1	2014-09-22	06:05:28.457219	2014-09-22	14:07:34.073294	08:02:05	28925
1326	176	1	1	2014-09-22	06:06:34.011469	2014-09-22	14:07:39.459015	08:01:05	28865
1327	183	1	1	2014-09-22	06:08:01.934205	2014-09-22	14:07:41.267609	07:59:39	28779
1329	175	1	1	2014-09-22	06:09:08.354525	2014-09-22	14:08:00.267711	07:58:51	28731
1328	172	1	1	2014-09-22	06:08:47.898994	2014-09-22	14:08:53.328335	08:00:05	28805
1320	187	1	2	2014-09-21	22:05:59.900161	2014-09-22	14:13:24.152042	15:00:00	54000
1319	185	1	2	2014-09-21	22:05:44.564318	2014-09-22	14:14:14.737983	15:00:00	54000
1318	186	1	2	2014-09-21	22:05:44.330132	2014-09-22	14:15:29.152748	15:00:00	54000
1350	188	1	1	2014-09-22	14:17:34.142095	2014-09-22	14:17:44.222151	00:00:10	10
1351	188	1	2	2014-09-22	14:17:44.222151	2014-09-22	14:17:49.416768	00:00:05	5
1347	184	1	1	2014-09-22	14:13:56.152786	2014-09-22	14:58:26.217248	00:44:30	2670
1353	184	1	2	2014-09-22	14:58:26.217248	2014-09-22	14:58:33.777067	00:00:07	7
1332	177	1	1	2014-09-22	07:12:02.00567	2014-09-22	15:10:37.223961	07:58:35	28715
1331	173	1	1	2014-09-22	07:10:50.331192	2014-09-22	15:10:56.718278	08:00:06	28806
1346	187	1	1	2014-09-22	14:13:24.152042	2014-09-22	22:07:41.315551	07:54:17	28457
1349	186	1	1	2014-09-22	14:15:29.152748	2014-09-22	22:07:42.902956	07:52:13	28333
1354	184	1	1	2014-09-22	14:58:33.777067	2014-09-22	22:07:46.331558	07:09:12	25752
1338	189	1	1	2014-09-22	14:05:27.737574	2014-09-22	22:07:47.412595	08:02:19	28939
1352	188	1	1	2014-09-22	14:17:49.416768	2014-09-22	22:07:51.017318	07:50:01	28201
1348	185	1	1	2014-09-22	14:14:14.737983	2014-09-22	22:07:57.812792	07:53:43	28423
1339	180	1	2	2014-09-22	14:05:29.414016	2014-09-23	06:04:48.80463	15:00:00	54000
1340	174	1	2	2014-09-22	14:07:20.216668	2014-09-23	06:05:37.797854	15:00:00	54000
1335	178	1	2	2014-09-22	14:00:38.386551	2014-09-23	06:06:25.227988	15:00:00	54000
1336	171	1	2	2014-09-22	14:01:36.386513	2014-09-23	06:06:45.628046	15:00:00	54000
1343	183	1	2	2014-09-22	14:07:41.267609	2014-09-23	06:06:51.353926	15:00:00	54000
1345	172	1	2	2014-09-22	14:08:53.328335	2014-09-23	06:10:08.639574	15:00:00	54000
1342	176	1	2	2014-09-22	14:07:39.459015	2014-09-23	06:10:12.91387	15:00:00	54000
1344	175	1	2	2014-09-22	14:08:00.267711	2014-09-23	06:10:18.815889	15:00:00	54000
1341	179	1	2	2014-09-22	14:07:34.073294	2014-09-23	06:10:51.640829	15:00:00	54000
1337	181	1	2	2014-09-22	14:02:29.251159	2014-09-23	06:17:05.36838	15:00:00	54000
1356	173	1	2	2014-09-22	15:10:56.718278	2014-09-23	07:12:23.813458	15:00:00	54000
1355	177	1	2	2014-09-22	15:10:37.223961	2014-09-23	07:16:38.644187	15:00:00	54000
1334	170	1	2	2014-09-22	13:59:44.957408	2014-09-23	08:09:46.691322	15:00:00	54000
1373	173	1	1	2014-09-23	07:12:23.813458	2014-09-23	09:26:14.915215	02:13:51	8031
1376	173	1	2	2014-09-23	09:26:14.915215	2014-09-23	09:26:17.646563	00:00:02	2
1367	183	1	1	2014-09-23	06:06:51.353926	2014-09-23	09:26:32.21886	03:19:40	11980
1378	183	1	2	2014-09-23	09:26:32.21886	2014-09-23	09:26:38.482493	00:00:06	6
1377	173	1	1	2014-09-23	09:26:17.646563	2014-09-23	09:29:53.295185	00:03:35	215
1380	173	1	2	2014-09-23	09:29:53.295185	2014-09-23	09:29:55.626839	00:00:02	2
1375	170	1	1	2014-09-23	08:09:46.691322	2014-09-23	09:34:39.402928	01:24:52	5092
1381	173	1	1	2014-09-23	09:29:55.626839	2014-09-23	10:26:29.822074	00:56:34	3394
1383	173	1	2	2014-09-23	10:26:29.822074	2014-09-23	10:26:33.253584	00:00:03	3
1363	180	1	1	2014-09-23	06:04:48.80463	2014-09-23	14:02:21.474288	07:57:32	28652
1365	178	1	1	2014-09-23	06:06:25.227988	2014-09-23	14:04:10.011718	07:57:44	28664
1364	174	1	1	2014-09-23	06:05:37.797854	2014-09-23	14:04:20.777234	07:58:42	28722
1368	172	1	1	2014-09-23	06:10:08.639574	2014-09-23	14:06:59.681212	07:56:51	28611
1379	183	1	1	2014-09-23	09:26:38.482493	2014-09-23	14:07:34.880899	04:40:56	16856
1369	176	1	1	2014-09-23	06:10:12.91387	2014-09-23	14:07:41.332655	07:57:28	28648
1360	189	1	2	2014-09-22	22:07:47.412595	2014-09-23	14:08:52.327248	15:00:00	54000
1358	186	1	2	2014-09-22	22:07:42.902956	2014-09-23	14:11:02.390459	15:00:00	54000
1357	187	1	2	2014-09-22	22:07:41.315551	2014-09-23	14:12:52.807668	15:00:00	54000
1359	184	1	2	2014-09-22	22:07:46.331558	2014-09-23	14:13:57.053924	15:00:00	54000
1382	170	1	2	2014-09-23	09:34:39.402928	2014-09-24	09:49:46.541507	15:00:00	54000
1374	177	1	1	2014-09-23	07:16:38.644187	2014-09-24	15:07:21.85915	15:00:00	54000
1384	173	1	1	2014-09-23	10:26:33.253584	2014-09-23	10:26:44.085045	00:00:10	10
1385	173	1	2	2014-09-23	10:26:44.085045	2014-09-23	10:26:47.067422	00:00:02	2
1366	171	1	1	2014-09-23	06:06:45.628046	2014-09-23	14:02:26.148168	07:55:40	28540
1370	175	1	1	2014-09-23	06:10:18.815889	2014-09-23	14:05:28.571629	07:55:09	28509
1372	181	1	1	2014-09-23	06:17:05.36838	2014-09-23	14:07:03.45066	07:49:58	28198
1371	179	1	1	2014-09-23	06:10:51.640829	2014-09-23	14:08:03.475415	07:57:11	28631
1362	185	1	2	2014-09-22	22:07:57.812792	2014-09-23	14:11:31.236342	15:00:00	54000
1361	188	1	2	2014-09-22	22:07:51.017318	2014-09-23	14:15:32.060331	15:00:00	54000
1386	173	1	1	2014-09-23	10:26:47.067422	2014-09-23	15:07:15.391613	04:40:28	16828
1401	184	1	1	2014-09-23	14:13:57.053924	2014-09-23	16:44:21.325886	02:30:24	9024
1404	184	1	2	2014-09-23	16:44:21.325886	2014-09-23	17:30:15.941267	00:45:54	2754
1405	184	1	1	2014-09-23	17:30:15.941267	2014-09-23	17:40:45.348801	00:10:29	629
1406	184	1	2	2014-09-23	17:40:45.348801	2014-09-23	18:49:11.155375	01:08:25	4105
1397	189	1	1	2014-09-23	14:08:52.327248	2014-09-23	22:08:07.76855	07:59:15	28755
1398	186	1	1	2014-09-23	14:11:02.390459	2014-09-23	22:08:16.90077	07:57:14	28634
1402	188	1	1	2014-09-23	14:15:32.060331	2014-09-23	22:08:20.22305	07:52:48	28368
1399	185	1	1	2014-09-23	14:11:31.236342	2014-09-23	22:08:25.462932	07:56:54	28614
1400	187	1	1	2014-09-23	14:12:52.807668	2014-09-23	22:08:32.815326	07:55:40	28540
1407	184	1	1	2014-09-23	18:49:11.155375	2014-09-23	22:08:38.99499	03:19:27	11967
1390	174	1	2	2014-09-23	14:04:20.777234	2014-09-24	06:03:06.92407	15:00:00	54000
1395	176	1	2	2014-09-23	14:07:41.332655	2014-09-24	06:03:11.061209	15:00:00	54000
1413	184	1	2	2014-09-23	22:08:38.99499	2014-09-24	06:03:47.786821	15:00:00	54000
1389	178	1	2	2014-09-23	14:04:10.011718	2014-09-24	06:03:54.178226	15:00:00	54000
1414	174	1	1	2014-09-24	06:03:06.92407	2014-09-24	06:05:20.799113	00:02:13	133
1388	171	1	2	2014-09-23	14:02:26.148168	2014-09-24	06:05:21.481964	15:00:00	54000
1387	180	1	2	2014-09-23	14:02:21.474288	2014-09-24	06:06:21.501602	15:00:00	54000
1418	174	1	2	2014-09-24	06:05:20.799113	2014-09-24	06:06:59.991732	00:01:39	99
1391	175	1	2	2014-09-23	14:05:28.571629	2014-09-24	06:08:16.574519	15:00:00	54000
1392	172	1	2	2014-09-23	14:06:59.681212	2014-09-24	06:08:17.205466	15:00:00	54000
1396	179	1	2	2014-09-23	14:08:03.475415	2014-09-24	06:09:07.245415	15:00:00	54000
1394	183	1	2	2014-09-23	14:07:34.880899	2014-09-24	06:09:41.751578	15:00:00	54000
1421	174	1	1	2014-09-24	06:06:59.991732	2014-09-24	06:20:33.035445	00:13:33	813
1426	174	1	2	2014-09-24	06:20:33.035445	2014-09-24	06:21:02.456729	00:00:29	29
1416	184	1	1	2014-09-24	06:03:47.786821	2014-09-24	06:21:19.507849	00:17:31	1051
1428	184	1	2	2014-09-24	06:21:19.507849	2014-09-24	06:21:45.852664	00:00:26	26
1429	184	1	1	2014-09-24	06:21:45.852664	2014-09-24	06:22:04.281752	00:00:18	18
1393	181	1	2	2014-09-23	14:07:03.45066	2014-09-24	06:22:10.715656	15:00:00	54000
1427	174	1	1	2014-09-24	06:21:02.456729	2014-09-24	06:36:10.231935	00:15:07	907
1432	174	1	2	2014-09-24	06:36:10.231935	2014-09-24	06:36:55.488584	00:00:45	45
1434	170	1	1	2014-09-24	09:49:46.541507	2014-09-24	13:26:32.932707	03:36:46	13006
1420	180	1	1	2014-09-24	06:06:21.501602	2014-09-24	14:00:17.306795	07:53:55	28435
1417	178	1	1	2014-09-24	06:03:54.178226	2014-09-24	14:02:37.775668	07:58:43	28723
1419	171	1	1	2014-09-24	06:05:21.481964	2014-09-24	14:02:41.689	07:57:20	28640
1433	174	1	1	2014-09-24	06:36:55.488584	2014-09-24	14:03:05.464	07:26:09	26769
1415	176	1	1	2014-09-24	06:03:11.061209	2014-09-24	14:03:08.61021	07:59:57	28797
1422	175	1	1	2014-09-24	06:08:16.574519	2014-09-24	14:06:09.833242	07:57:53	28673
1431	181	1	1	2014-09-24	06:22:10.715656	2014-09-24	14:06:44.4343	07:44:33	27873
1425	183	1	1	2014-09-24	06:09:41.751578	2014-09-24	14:07:21.142444	07:57:39	28659
1408	189	1	2	2014-09-23	22:08:07.76855	2014-09-24	14:07:25.639203	15:00:00	54000
1424	179	1	1	2014-09-24	06:09:07.245415	2014-09-24	14:07:37.611806	07:58:30	28710
1423	172	1	1	2014-09-24	06:08:17.205466	2014-09-24	14:08:10.080224	07:59:52	28792
1411	185	1	2	2014-09-23	22:08:25.462932	2014-09-24	14:10:28.365961	15:00:00	54000
1430	184	1	2	2014-09-24	06:22:04.281752	2014-09-24	14:12:36.406497	07:50:32	28232
1412	187	1	2	2014-09-23	22:08:32.815326	2014-09-24	14:12:52.11848	15:00:00	54000
1409	186	1	2	2014-09-23	22:08:16.90077	2014-09-24	14:17:14.196873	15:00:00	54000
1410	188	1	2	2014-09-23	22:08:20.22305	2014-09-24	14:17:39.500381	15:00:00	54000
1403	173	1	2	2014-09-23	15:07:15.391613	2014-09-24	15:11:37.362406	15:00:00	54000
1450	186	1	1	2014-09-24	14:17:14.196873	2014-09-24	17:04:28.375466	02:47:14	10034
1454	186	1	2	2014-09-24	17:04:28.375466	2014-09-24	20:21:28.96049	03:17:00	11820
1448	184	1	1	2014-09-24	14:12:36.406497	2014-09-24	22:07:41.718088	07:55:05	28505
1451	188	1	1	2014-09-24	14:17:39.500381	2014-09-24	22:07:46.248703	07:50:06	28206
1447	185	1	1	2014-09-24	14:10:28.365961	2014-09-24	22:07:48.834202	07:57:20	28640
1449	187	1	1	2014-09-24	14:12:52.11848	2014-09-24	22:07:54.920989	07:55:02	28502
1455	186	1	1	2014-09-24	20:21:28.96049	2014-09-24	22:07:55.808665	01:46:26	6386
1444	189	1	1	2014-09-24	14:07:25.639203	2014-09-24	22:08:09.878091	08:00:44	28844
1440	176	1	2	2014-09-24	14:03:08.61021	2014-09-25	06:02:55.777369	15:00:00	54000
1439	174	1	2	2014-09-24	14:03:05.464	2014-09-25	06:03:11.55502	15:00:00	54000
1458	185	1	2	2014-09-24	22:07:48.834202	2014-09-25	06:04:16.807154	15:00:00	54000
1441	175	1	2	2014-09-24	14:06:09.833242	2014-09-25	06:05:41.601007	15:00:00	54000
1445	179	1	2	2014-09-24	14:07:37.611806	2014-09-25	06:06:43.265593	15:00:00	54000
1443	183	1	2	2014-09-24	14:07:21.142444	2014-09-25	06:07:44.196804	15:00:00	54000
1446	172	1	2	2014-09-24	14:08:10.080224	2014-09-25	06:08:28.499045	15:00:00	54000
1453	173	1	2	2014-09-24	15:11:37.362406	2014-09-25	07:23:19.99398	15:00:00	54000
1435	170	1	2	2014-09-24	13:26:32.932707	2014-09-25	08:46:40.905496	15:00:00	54000
1461	189	1	2	2014-09-24	22:08:09.878091	2014-09-25	14:11:10.560079	15:00:00	54000
1460	186	1	2	2014-09-24	22:07:55.808665	2014-09-25	14:11:22.150023	15:00:00	54000
1457	188	1	2	2014-09-24	22:07:46.248703	2014-09-25	14:13:46.121733	15:00:00	54000
1436	180	1	2	2014-09-24	14:00:17.306795	2014-09-25	06:03:37.68123	15:00:00	54000
1438	171	1	2	2014-09-24	14:02:41.689	2014-09-25	06:06:26.578977	15:00:00	54000
1442	181	1	2	2014-09-24	14:06:44.4343	2014-09-25	06:07:25.373791	15:00:00	54000
1452	177	1	2	2014-09-24	15:07:21.85915	2014-09-25	07:16:52.267245	15:00:00	54000
1469	181	1	1	2014-09-25	06:07:25.373791	2014-09-25	13:43:30.001316	07:36:04	27364
1464	180	1	1	2014-09-25	06:03:37.68123	2014-09-25	14:03:11.633219	07:59:33	28773
1462	176	1	1	2014-09-25	06:02:55.777369	2014-09-25	14:03:12.691358	08:00:16	28816
1466	175	1	1	2014-09-25	06:05:41.601007	2014-09-25	14:05:25.11982	07:59:43	28783
1465	185	1	1	2014-09-25	06:04:16.807154	2014-09-25	14:06:58.857801	08:02:42	28962
1467	171	1	1	2014-09-25	06:06:26.578977	2014-09-25	14:07:07.691983	08:00:41	28841
1463	174	1	1	2014-09-25	06:03:11.55502	2014-09-25	14:07:14.446166	08:04:02	29042
1471	172	1	1	2014-09-25	06:08:28.499045	2014-09-25	14:07:20.097818	07:58:51	28731
1468	179	1	1	2014-09-25	06:06:43.265593	2014-09-25	14:08:44.314822	08:02:01	28921
1470	183	1	1	2014-09-25	06:07:44.196804	2014-09-25	14:08:45.005681	08:01:00	28860
1459	187	1	2	2014-09-24	22:07:54.920989	2014-09-25	14:10:36.035316	15:00:00	54000
1456	184	1	2	2014-09-24	22:07:41.718088	2014-09-25	14:13:30.115378	15:00:00	54000
1437	178	1	2	2014-09-24	14:02:37.775668	2014-09-25	14:45:52.158245	15:00:00	54000
1472	177	1	1	2014-09-25	07:16:52.267245	2014-09-25	15:06:22.207479	07:49:29	28169
1473	173	1	1	2014-09-25	07:23:19.99398	2014-09-25	15:07:58.603405	07:44:38	27878
1489	188	1	1	2014-09-25	14:13:46.121733	2014-09-25	18:12:59.103372	03:59:12	14352
1487	186	1	1	2014-09-25	14:11:22.150023	2014-09-25	22:07:26.251133	07:56:04	28564
1488	184	1	1	2014-09-25	14:13:30.115378	2014-09-25	22:07:26.974038	07:53:56	28436
1486	189	1	1	2014-09-25	14:11:10.560079	2014-09-25	22:07:48.07434	07:56:37	28597
1485	187	1	1	2014-09-25	14:10:36.035316	2014-09-25	22:08:14.90268	07:57:38	28658
1490	178	1	1	2014-09-25	14:45:52.158245	2014-09-25	22:09:55.874257	07:24:03	26643
1475	181	1	2	2014-09-25	13:43:30.001316	2014-09-26	06:02:50.896302	15:00:00	54000
1476	180	1	2	2014-09-25	14:03:11.633219	2014-09-26	06:04:10.594623	15:00:00	54000
1484	183	1	2	2014-09-25	14:08:45.005681	2014-09-26	06:04:40.914809	15:00:00	54000
1498	178	1	2	2014-09-25	22:09:55.874257	2014-09-26	06:05:50.885701	15:00:00	54000
1482	172	1	2	2014-09-25	14:07:20.097818	2014-09-26	06:06:00.771917	15:00:00	54000
1477	176	1	2	2014-09-25	14:03:12.691358	2014-09-26	06:06:36.841443	15:00:00	54000
1483	179	1	2	2014-09-25	14:08:44.314822	2014-09-26	06:06:38.418192	15:00:00	54000
1491	177	1	2	2014-09-25	15:06:22.207479	2014-09-26	06:07:03.829496	15:00:00	54000
1480	171	1	2	2014-09-25	14:07:07.691983	2014-09-26	06:07:33.680878	15:00:00	54000
1481	174	1	2	2014-09-25	14:07:14.446166	2014-09-26	06:07:45.612281	15:00:00	54000
1478	175	1	2	2014-09-25	14:05:25.11982	2014-09-26	06:10:05.498122	15:00:00	54000
1492	173	1	2	2014-09-25	15:07:58.603405	2014-09-26	07:11:28.30132	15:00:00	54000
1474	170	1	1	2014-09-25	08:46:40.905496	2014-09-26	13:44:00.437713	15:00:00	54000
1499	181	1	1	2014-09-26	06:02:50.896302	2014-09-26	14:01:47.718873	07:58:56	28736
1500	180	1	1	2014-09-26	06:04:10.594623	2014-09-26	14:02:06.127684	07:57:55	28675
1507	171	1	1	2014-09-26	06:07:33.680878	2014-09-26	14:06:32.864679	07:58:59	28739
1503	172	1	1	2014-09-26	06:06:00.771917	2014-09-26	14:07:01.214714	08:01:00	28860
1504	176	1	1	2014-09-26	06:06:36.841443	2014-09-26	14:07:37.567386	08:01:00	28860
1502	178	1	1	2014-09-26	06:05:50.885701	2014-09-26	14:07:45.822135	08:01:54	28914
1508	174	1	1	2014-09-26	06:07:45.612281	2014-09-26	14:07:47.54438	08:00:01	28801
1505	179	1	1	2014-09-26	06:06:38.418192	2014-09-26	14:08:23.298344	08:01:44	28904
1509	175	1	1	2014-09-26	06:10:05.498122	2014-09-26	14:08:39.933708	07:58:34	28714
1497	187	1	2	2014-09-25	22:08:14.90268	2014-09-26	14:11:48.291081	15:00:00	54000
1496	189	1	2	2014-09-25	22:07:48.07434	2014-09-26	14:12:23.658747	15:00:00	54000
1479	185	1	2	2014-09-25	14:06:58.857801	2014-09-26	14:12:26.251015	15:00:00	54000
1494	186	1	2	2014-09-25	22:07:26.251133	2014-09-26	14:12:29.473985	15:00:00	54000
1506	177	1	1	2014-09-26	06:07:03.829496	2014-09-26	14:16:22.730922	08:09:18	29358
1495	184	1	2	2014-09-25	22:07:26.974038	2014-09-26	14:17:04.378033	15:00:00	54000
1493	188	1	2	2014-09-25	18:12:59.103372	2014-09-26	14:19:43.92434	15:00:00	54000
1510	173	1	1	2014-09-26	07:11:28.30132	2014-09-26	15:02:06.335873	07:50:38	28238
1523	185	1	1	2014-09-26	14:12:26.251015	2014-09-26	16:37:26.027924	02:24:59	8699
1529	185	1	2	2014-09-26	16:37:26.027924	2014-09-26	16:37:35.04489	00:00:09	9
1524	186	1	1	2014-09-26	14:12:29.473985	2014-09-26	22:08:28.52509	07:55:59	28559
1530	185	1	1	2014-09-26	16:37:35.04489	2014-09-26	22:08:33.788766	05:30:58	19858
1527	188	1	1	2014-09-26	14:19:43.92434	2014-09-26	22:08:57.572101	07:49:13	28153
1526	184	1	1	2014-09-26	14:17:04.378033	2014-09-26	22:09:25.463673	07:52:21	28341
1521	187	1	1	2014-09-26	14:11:48.291081	2014-09-26	22:10:29.743957	07:58:41	28721
1522	189	1	1	2014-09-26	14:12:23.658747	2014-09-26	22:10:56.755674	07:58:33	28713
1519	179	1	2	2014-09-26	14:08:23.298344	2014-09-27	06:04:55.127723	15:00:00	54000
1517	178	1	2	2014-09-26	14:07:45.822135	2014-09-27	06:06:17.564137	15:00:00	54000
1516	176	1	2	2014-09-26	14:07:37.567386	2014-09-27	06:06:21.054069	15:00:00	54000
1515	172	1	2	2014-09-26	14:07:01.214714	2014-09-27	06:08:45.003071	15:00:00	54000
1534	184	1	2	2014-09-26	22:09:25.463673	2014-09-27	06:09:34.856237	15:00:00	54000
1512	181	1	2	2014-09-26	14:01:47.718873	2014-09-27	06:09:53.284055	15:00:00	54000
1518	174	1	2	2014-09-26	14:07:47.54438	2014-09-27	06:12:06.302871	15:00:00	54000
1511	170	1	2	2014-09-26	13:44:00.437713	2014-09-27	09:35:56.851652	15:00:00	54000
1538	178	1	1	2014-09-27	06:06:17.564137	2014-09-27	14:07:18.39856	08:01:00	28860
1537	179	1	1	2014-09-27	06:04:55.127723	2014-09-27	14:16:38.097397	08:11:42	29502
1533	188	1	2	2014-09-26	22:08:57.572101	2014-09-27	14:21:43.479333	15:00:00	54000
1514	171	1	2	2014-09-26	14:06:32.864679	2014-09-28	06:06:43.094493	15:00:00	54000
1528	173	1	2	2014-09-26	15:02:06.335873	2014-09-28	06:29:06.351806	15:00:00	54000
1532	185	1	2	2014-09-26	22:08:33.788766	2014-09-28	14:11:34.682666	15:00:00	54000
1535	187	1	2	2014-09-26	22:10:29.743957	2014-09-29	14:14:10.140241	15:00:00	54000
1525	177	1	2	2014-09-26	14:16:22.730922	2014-09-27	06:08:47.313092	15:00:00	54000
1542	184	1	1	2014-09-27	06:09:34.856237	2014-09-27	06:09:47.478362	00:00:12	12
1520	175	1	2	2014-09-26	14:08:39.933708	2014-09-27	06:10:11.74826	15:00:00	54000
1544	181	1	1	2014-09-27	06:09:53.284055	2014-09-27	12:29:25.048452	06:19:31	22771
1548	181	1	2	2014-09-27	12:29:25.048452	2014-09-27	12:36:56.899726	00:07:31	451
1549	181	1	1	2014-09-27	12:36:56.899726	2014-09-27	12:42:05.822567	00:05:08	308
1536	189	1	2	2014-09-26	22:10:56.755674	2014-09-27	12:46:51.411612	15:00:00	54000
1551	189	1	1	2014-09-27	12:46:51.411612	2014-09-27	13:39:08.389497	00:52:16	3136
1550	181	1	2	2014-09-27	12:42:05.822567	2014-09-27	13:43:01.501896	01:00:55	3655
1540	172	1	1	2014-09-27	06:08:45.003071	2014-09-27	14:07:16.270954	07:58:31	28711
1553	181	1	1	2014-09-27	13:43:01.501896	2014-09-27	14:12:46.296677	00:29:44	1784
1546	174	1	1	2014-09-27	06:12:06.302871	2014-09-27	14:13:09.005388	08:01:02	28862
1501	183	1	1	2014-09-26	06:04:40.914809	2014-09-27	14:13:25.736774	15:00:00	54000
1539	176	1	1	2014-09-27	06:06:21.054069	2014-09-27	14:16:27.21727	08:10:06	29406
1545	175	1	1	2014-09-27	06:10:11.74826	2014-09-27	14:17:10.777628	08:06:59	29219
1541	177	1	1	2014-09-27	06:08:47.313092	2014-09-27	14:17:14.096472	08:08:26	29306
1552	189	1	2	2014-09-27	13:39:08.389497	2014-09-27	14:19:57.217884	00:40:48	2448
1543	184	1	2	2014-09-27	06:09:47.478362	2014-09-27	14:33:21.242631	08:23:33	30213
1566	182	1	1	2014-09-27	15:31:25.061726	2014-09-27	16:05:12.162002	00:33:47	2027
1564	188	1	1	2014-09-27	14:21:43.479333	2014-09-27	22:07:54.851498	07:46:11	27971
1563	189	1	1	2014-09-27	14:19:57.217884	2014-09-27	22:08:09.086029	07:48:11	28091
1565	184	1	1	2014-09-27	14:33:21.242631	2014-09-27	22:08:09.77815	07:34:48	27288
1513	180	1	2	2014-09-26	14:02:06.127684	2014-09-28	06:06:33.905244	15:00:00	54000
1569	189	1	2	2014-09-27	22:08:09.086029	2014-09-28	06:23:19.438771	15:00:00	54000
1571	180	1	1	2014-09-28	06:06:33.905244	2014-09-28	14:06:14.94426	07:59:41	28781
1574	173	1	1	2014-09-28	06:29:06.351806	2014-09-28	14:10:17.22519	07:41:10	27670
1531	186	1	2	2014-09-26	22:08:28.52509	2014-09-28	14:10:57.562687	15:00:00	54000
1572	171	1	1	2014-09-28	06:06:43.094493	2014-09-28	21:40:37.027011	15:33:53	56033
1578	185	1	1	2014-09-28	14:11:34.682666	2014-09-28	22:04:37.875503	07:53:03	28383
1556	181	1	2	2014-09-27	14:12:46.296677	2014-09-29	06:01:07.972401	15:00:00	54000
1557	174	1	2	2014-09-27	14:13:09.005388	2014-09-29	06:02:37.184366	15:00:00	54000
1555	178	1	2	2014-09-27	14:07:18.39856	2014-09-29	06:03:03.475226	15:00:00	54000
1579	171	1	2	2014-09-28	21:40:37.027011	2014-09-29	06:03:10.544419	15:00:00	54000
1575	180	1	2	2014-09-28	14:06:14.94426	2014-09-29	06:05:31.190587	15:00:00	54000
1560	179	1	2	2014-09-27	14:16:38.097397	2014-09-29	06:06:11.258889	15:00:00	54000
1559	176	1	2	2014-09-27	14:16:27.21727	2014-09-29	06:06:25.402089	15:00:00	54000
1562	177	1	2	2014-09-27	14:17:14.096472	2014-09-29	06:07:49.298073	15:00:00	54000
1558	183	1	2	2014-09-27	14:13:25.736774	2014-09-29	06:08:02.250944	15:00:00	54000
1554	172	1	2	2014-09-27	14:07:16.270954	2014-09-29	06:10:29.728533	15:00:00	54000
1561	175	1	2	2014-09-27	14:17:10.777628	2014-09-29	06:11:18.763946	15:00:00	54000
1576	173	1	2	2014-09-28	14:10:17.22519	2014-09-29	07:14:10.037797	15:00:00	54000
1581	181	1	1	2014-09-29	06:01:07.972401	2014-09-29	14:02:09.938189	08:01:01	28861
1582	174	1	1	2014-09-29	06:02:37.184366	2014-09-29	14:03:44.913207	08:01:07	28867
1583	178	1	1	2014-09-29	06:03:03.475226	2014-09-29	14:04:18.801509	08:01:15	28875
1585	180	1	1	2014-09-29	06:05:31.190587	2014-09-29	14:05:53.808878	08:00:22	28822
1584	171	1	1	2014-09-29	06:03:10.544419	2014-09-29	14:07:25.319022	08:04:14	29054
1591	175	1	1	2014-09-29	06:11:18.763946	2014-09-29	14:07:49.889028	07:56:31	28591
1587	176	1	1	2014-09-29	06:06:25.402089	2014-09-29	14:08:04.068055	08:01:38	28898
1589	183	1	1	2014-09-29	06:08:02.250944	2014-09-29	14:08:43.245402	08:00:40	28840
1580	185	1	2	2014-09-28	22:04:37.875503	2014-09-29	14:14:46.250988	15:00:00	54000
1570	184	1	2	2014-09-27	22:08:09.77815	2014-09-29	14:14:54.628333	15:00:00	54000
1568	188	1	2	2014-09-27	22:07:54.851498	2014-09-29	14:14:56.926664	15:00:00	54000
1567	182	1	2	2014-09-27	16:05:12.162002	2014-09-29	14:15:52.539645	15:00:00	54000
1577	186	1	1	2014-09-28	14:10:57.562687	2014-09-29	14:23:14.171404	15:00:00	54000
1606	186	1	2	2014-09-29	14:23:14.171404	2014-09-29	14:23:42.105664	00:00:27	27
1588	177	1	1	2014-09-29	06:07:49.298073	2014-09-29	14:44:19.093301	08:36:29	30989
1605	182	1	1	2014-09-29	14:15:52.539645	2014-09-29	20:20:09.262295	06:04:16	21856
1609	182	1	2	2014-09-29	20:20:09.262295	2014-09-29	20:27:05.9088	00:06:56	416
1603	184	1	1	2014-09-29	14:14:54.628333	2014-09-29	22:07:16.086859	07:52:21	28341
1604	188	1	1	2014-09-29	14:14:56.926664	2014-09-29	22:07:16.224417	07:52:19	28339
1610	182	1	1	2014-09-29	20:27:05.9088	2014-09-29	22:07:44.925211	01:40:39	6039
1601	187	1	1	2014-09-29	14:14:10.140241	2014-09-29	22:07:55.729902	07:53:45	28425
1602	185	1	1	2014-09-29	14:14:46.250988	2014-09-29	22:09:32.590032	07:54:46	28486
1607	186	1	1	2014-09-29	14:23:42.105664	2014-09-29	22:10:19.961534	07:46:37	27997
1594	174	1	2	2014-09-29	14:03:44.913207	2014-09-30	05:59:50.899018	15:00:00	54000
1595	178	1	2	2014-09-29	14:04:18.801509	2014-09-30	06:01:10.042636	15:00:00	54000
1597	171	1	2	2014-09-29	14:07:25.319022	2014-09-30	06:02:49.935139	15:00:00	54000
1600	183	1	2	2014-09-29	14:08:43.245402	2014-09-30	06:07:25.59803	15:00:00	54000
1596	180	1	2	2014-09-29	14:05:53.808878	2014-09-30	06:08:31.998589	15:00:00	54000
1608	177	1	2	2014-09-29	14:44:19.093301	2014-09-30	07:19:36.996887	15:00:00	54000
1590	172	1	1	2014-09-29	06:10:29.728533	2014-09-30	14:08:37.850935	15:00:00	54000
1547	170	1	1	2014-09-27	09:35:56.851652	2014-09-30	14:08:54.916835	15:00:00	54000
1614	187	1	2	2014-09-29	22:07:55.729902	2014-09-30	14:35:08.105309	15:00:00	54000
1615	185	1	2	2014-09-29	22:09:32.590032	2014-09-30	14:38:01.454368	15:00:00	54000
1611	184	1	2	2014-09-29	22:07:16.086859	2014-09-30	14:40:44.509235	15:00:00	54000
1613	182	1	2	2014-09-29	22:07:44.925211	2014-09-30	14:43:52.221673	15:00:00	54000
1592	173	1	1	2014-09-29	07:14:10.037797	2014-09-30	15:04:08.980498	15:00:00	54000
1593	181	1	2	2014-09-29	14:02:09.938189	2014-09-30	06:00:16.980099	15:00:00	54000
1598	175	1	2	2014-09-29	14:07:49.889028	2014-09-30	06:06:44.049161	15:00:00	54000
1599	176	1	2	2014-09-29	14:08:04.068055	2014-09-30	06:08:59.13099	15:00:00	54000
1621	175	1	1	2014-09-30	06:06:44.049161	2014-09-30	14:04:01.380663	07:57:17	28637
1618	181	1	1	2014-09-30	06:00:16.980099	2014-09-30	14:05:27.028874	08:05:10	29110
1620	171	1	1	2014-09-30	06:02:49.935139	2014-09-30	14:06:42.113903	08:03:52	29032
1623	180	1	1	2014-09-30	06:08:31.998589	2014-09-30	14:07:28.642751	07:58:56	28736
1617	174	1	1	2014-09-30	05:59:50.899018	2014-09-30	14:07:59.968054	08:08:09	29289
1619	178	1	1	2014-09-30	06:01:10.042636	2014-09-30	14:08:09.358768	08:06:59	29219
1622	183	1	1	2014-09-30	06:07:25.59803	2014-09-30	14:09:01.593295	08:01:35	28895
1624	176	1	1	2014-09-30	06:08:59.13099	2014-09-30	14:09:25.018928	08:00:25	28825
1586	179	1	1	2014-09-29	06:06:11.258889	2014-09-30	14:11:14.631913	15:00:00	54000
1612	188	1	2	2014-09-29	22:07:16.224417	2014-09-30	14:40:06.170211	15:00:00	54000
1616	186	1	2	2014-09-29	22:10:19.961534	2014-09-30	14:48:29.250866	15:00:00	54000
1625	177	1	1	2014-09-30	07:19:36.996887	2014-09-30	15:06:32.084625	07:46:55	28015
1641	182	1	1	2014-09-30	14:43:52.221673	2014-09-30	16:51:12.857975	02:07:20	7640
1640	184	1	1	2014-09-30	14:40:44.509235	2014-09-30	17:56:41.088472	03:15:56	11756
1646	184	1	2	2014-09-30	17:56:41.088472	2014-09-30	18:56:03.165688	00:59:22	3562
1639	188	1	1	2014-09-30	14:40:06.170211	2014-09-30	22:09:04.743765	07:28:58	26938
1647	184	1	1	2014-09-30	18:56:03.165688	2014-09-30	22:09:07.477935	03:13:04	11584
1642	186	1	1	2014-09-30	14:48:29.250866	2014-09-30	22:09:21.33804	07:20:52	26452
1637	187	1	1	2014-09-30	14:35:08.105309	2014-09-30	22:09:30.428904	07:34:22	27262
1573	189	1	1	2014-09-28	06:23:19.438771	2014-09-30	22:09:55.032626	15:00:00	54000
1638	185	1	1	2014-09-30	14:38:01.454368	2014-09-30	22:10:06.041367	07:32:04	27124
1631	178	1	2	2014-09-30	14:08:09.358768	2014-10-01	06:02:09.145348	15:00:00	54000
1629	180	1	2	2014-09-30	14:07:28.642751	2014-10-01	06:02:52.57408	15:00:00	54000
1630	174	1	2	2014-09-30	14:07:59.968054	2014-10-01	06:04:34.239422	15:00:00	54000
1634	183	1	2	2014-09-30	14:09:01.593295	2014-10-01	06:06:04.500331	15:00:00	54000
1628	171	1	2	2014-09-30	14:06:42.113903	2014-10-01	06:06:36.188972	15:00:00	54000
1635	176	1	2	2014-09-30	14:09:25.018928	2014-10-01	06:07:32.957932	15:00:00	54000
1636	179	1	2	2014-09-30	14:11:14.631913	2014-10-01	06:09:26.034569	15:00:00	54000
1626	175	1	2	2014-09-30	14:04:01.380663	2014-10-01	06:10:03.492177	15:00:00	54000
1627	181	1	2	2014-09-30	14:05:27.028874	2014-10-01	06:12:11.108922	15:00:00	54000
1632	172	1	2	2014-09-30	14:08:37.850935	2014-10-01	06:14:04.012814	15:00:00	54000
1644	177	1	2	2014-09-30	15:06:32.084625	2014-10-01	07:08:25.302702	15:00:00	54000
1643	173	1	2	2014-09-30	15:04:08.980498	2014-10-01	07:40:03.646771	15:00:00	54000
1663	172	1	1	2014-10-01	06:14:04.012814	2014-10-01	08:41:31.966008	02:27:27	8847
1666	172	1	2	2014-10-01	08:41:31.966008	2014-10-01	10:15:43.955255	01:34:11	5651
1667	172	1	1	2014-10-01	10:15:43.955255	2014-10-01	10:17:54.953739	00:02:10	130
1668	172	1	2	2014-10-01	10:17:54.953739	2014-10-01	10:30:14.638247	00:12:19	739
1656	174	1	1	2014-10-01	06:04:34.239422	2014-10-01	14:03:49.328235	07:59:15	28755
1655	180	1	1	2014-10-01	06:02:52.57408	2014-10-01	14:04:05.095398	08:01:12	28872
1669	172	1	1	2014-10-01	10:30:14.638247	2014-10-01	14:06:28.279348	03:36:13	12973
1662	181	1	1	2014-10-01	06:12:11.108922	2014-10-01	14:06:30.94661	07:54:19	28459
1659	176	1	1	2014-10-01	06:07:32.957932	2014-10-01	14:06:59.169469	07:59:26	28766
1660	179	1	1	2014-10-01	06:09:26.034569	2014-10-01	14:07:07.998703	07:57:41	28661
1661	175	1	1	2014-10-01	06:10:03.492177	2014-10-01	14:07:22.935922	07:57:19	28639
1658	171	1	1	2014-10-01	06:06:36.188972	2014-10-01	14:08:15.792002	08:01:39	28899
1657	183	1	1	2014-10-01	06:06:04.500331	2014-10-01	14:08:29.608598	08:02:25	28945
1652	189	1	2	2014-09-30	22:09:55.032626	2014-10-01	14:10:39.170537	15:00:00	54000
1653	185	1	2	2014-09-30	22:10:06.041367	2014-10-01	14:10:43.330787	15:00:00	54000
1649	184	1	2	2014-09-30	22:09:07.477935	2014-10-01	14:10:47.953563	15:00:00	54000
1651	187	1	2	2014-09-30	22:09:30.428904	2014-10-01	14:10:48.861698	15:00:00	54000
1648	188	1	2	2014-09-30	22:09:04.743765	2014-10-01	14:11:14.781906	15:00:00	54000
1650	186	1	2	2014-09-30	22:09:21.33804	2014-10-01	14:11:16.210751	15:00:00	54000
1654	178	1	1	2014-10-01	06:02:09.145348	2014-10-01	14:14:07.55374	08:11:58	29518
1665	173	1	1	2014-10-01	07:40:03.646771	2014-10-01	15:07:21.671487	07:27:18	26838
1664	177	1	1	2014-10-01	07:08:25.302702	2014-10-01	15:12:25.146896	08:03:59	29039
1681	184	1	1	2014-10-01	14:10:47.953563	2014-10-01	16:16:19.062046	02:05:31	7531
1688	184	1	2	2014-10-01	16:16:19.062046	2014-10-01	16:36:10.948341	00:19:51	1191
1683	188	1	1	2014-10-01	14:11:14.781906	2014-10-01	22:08:05.198216	07:56:50	28610
1682	187	1	1	2014-10-01	14:10:48.861698	2014-10-01	22:08:13.38498	07:57:24	28644
1679	189	1	1	2014-10-01	14:10:39.170537	2014-10-01	22:08:16.377469	07:57:37	28657
1684	186	1	1	2014-10-01	14:11:16.210751	2014-10-01	22:08:17.258388	07:57:01	28621
1689	184	1	1	2014-10-01	16:36:10.948341	2014-10-01	22:08:43.612687	05:32:32	19952
1678	183	1	2	2014-10-01	14:08:29.608598	2014-10-02	05:59:39.885017	15:00:00	54000
1685	178	1	2	2014-10-01	14:14:07.55374	2014-10-02	06:00:36.696828	15:00:00	54000
1670	174	1	2	2014-10-01	14:03:49.328235	2014-10-02	06:01:45.465076	15:00:00	54000
1674	176	1	2	2014-10-01	14:06:59.169469	2014-10-02	06:04:00.12066	15:00:00	54000
1675	179	1	2	2014-10-01	14:07:07.998703	2014-10-02	06:05:53.601431	15:00:00	54000
1672	172	1	2	2014-10-01	14:06:28.279348	2014-10-02	06:07:28.863914	15:00:00	54000
1676	175	1	2	2014-10-01	14:07:22.935922	2014-10-02	06:08:46.871541	15:00:00	54000
1687	177	1	2	2014-10-01	15:12:25.146896	2014-10-02	07:14:49.20499	15:00:00	54000
1692	189	1	2	2014-10-01	22:08:16.377469	2014-10-02	14:10:41.153674	15:00:00	54000
1694	184	1	2	2014-10-01	22:08:43.612687	2014-10-02	14:13:03.246607	15:00:00	54000
1690	188	1	2	2014-10-01	22:08:05.198216	2014-10-02	14:15:32.618766	15:00:00	54000
1633	170	1	2	2014-09-30	14:08:54.916835	2014-10-03	09:53:21.848668	15:00:00	54000
1680	185	1	1	2014-10-01	14:10:43.330787	2014-10-01	22:09:04.789023	07:58:21	28701
1673	181	1	2	2014-10-01	14:06:30.94661	2014-10-02	06:01:05.138283	15:00:00	54000
1671	180	1	2	2014-10-01	14:04:05.095398	2014-10-02	06:05:39.191105	15:00:00	54000
1677	171	1	2	2014-10-01	14:08:15.792002	2014-10-02	06:07:17.543965	15:00:00	54000
1686	173	1	2	2014-10-01	15:07:21.671487	2014-10-02	07:12:42.735727	15:00:00	54000
1697	178	1	1	2014-10-02	06:00:36.696828	2014-10-02	08:22:59.327023	02:22:22	8542
1708	178	1	2	2014-10-02	08:22:59.327023	2014-10-02	08:23:04.988828	00:00:05	5
1705	175	1	1	2014-10-02	06:08:46.871541	2014-10-02	08:23:13.622957	02:14:26	8066
1709	178	1	1	2014-10-02	08:23:04.988828	2014-10-02	08:23:20.257322	00:00:15	15
1710	175	1	2	2014-10-02	08:23:13.622957	2014-10-02	08:23:22.937373	00:00:09	9
1711	178	1	2	2014-10-02	08:23:20.257322	2014-10-02	08:23:26.639195	00:00:06	6
1712	175	1	1	2014-10-02	08:23:22.937373	2014-10-02	08:23:58.897369	00:00:35	35
1714	175	1	2	2014-10-02	08:23:58.897369	2014-10-02	08:24:15.085993	00:00:16	16
1715	175	1	1	2014-10-02	08:24:15.085993	2014-10-02	08:25:19.046252	00:01:03	63
1716	175	1	2	2014-10-02	08:25:19.046252	2014-10-02	08:25:39.434983	00:00:20	20
1717	175	1	1	2014-10-02	08:25:39.434983	2014-10-02	08:25:54.05894	00:00:14	14
1718	175	1	2	2014-10-02	08:25:54.05894	2014-10-02	08:25:59.578424	00:00:05	5
1719	175	1	1	2014-10-02	08:25:59.578424	2014-10-02	11:03:24.067024	02:37:24	9444
1720	175	1	2	2014-10-02	11:03:24.067024	2014-10-02	11:03:35.98837	00:00:11	11
1721	175	1	1	2014-10-02	11:03:35.98837	2014-10-02	11:11:43.038498	00:08:07	487
1722	175	1	2	2014-10-02	11:11:43.038498	2014-10-02	11:11:52.22442	00:00:09	9
1723	175	1	1	2014-10-02	11:11:52.22442	2014-10-02	11:12:36.660901	00:00:44	44
1724	175	1	2	2014-10-02	11:12:36.660901	2014-10-02	11:50:40.564604	00:38:03	2283
1696	183	1	1	2014-10-02	05:59:39.885017	2014-10-02	14:02:19.378871	08:02:39	28959
1698	181	1	1	2014-10-02	06:01:05.138283	2014-10-02	14:02:37.055982	08:01:31	28891
1699	174	1	1	2014-10-02	06:01:45.465076	2014-10-02	14:03:54.373379	08:02:08	28928
1700	176	1	1	2014-10-02	06:04:00.12066	2014-10-02	14:03:55.629339	07:59:55	28795
1713	178	1	1	2014-10-02	08:23:26.639195	2014-10-02	14:04:31.436606	05:41:04	20464
1701	180	1	1	2014-10-02	06:05:39.191105	2014-10-02	14:06:34.57217	08:00:55	28855
1704	172	1	1	2014-10-02	06:07:28.863914	2014-10-02	14:06:45.01534	07:59:16	28756
1702	179	1	1	2014-10-02	06:05:53.601431	2014-10-02	14:07:32.874258	08:01:39	28899
1725	175	1	1	2014-10-02	11:50:40.564604	2014-10-02	14:07:37.756544	02:16:57	8217
1703	171	1	1	2014-10-02	06:07:17.543965	2014-10-02	14:07:48.806543	08:00:31	28831
1695	185	1	2	2014-10-01	22:09:04.789023	2014-10-02	14:11:14.007273	15:00:00	54000
1691	187	1	2	2014-10-01	22:08:13.38498	2014-10-02	14:12:12.330309	15:00:00	54000
1693	186	1	2	2014-10-01	22:08:17.258388	2014-10-02	14:17:28.125803	15:00:00	54000
1707	177	1	1	2014-10-02	07:14:49.20499	2014-10-02	14:53:53.186093	07:39:03	27543
1736	189	1	1	2014-10-02	14:10:41.153674	2014-10-02	22:07:52.352686	07:57:11	28631
1739	184	1	1	2014-10-02	14:13:03.246607	2014-10-02	22:08:07.816717	07:55:04	28504
1737	185	1	1	2014-10-02	14:11:14.007273	2014-10-02	22:08:10.902464	07:56:56	28616
1740	188	1	1	2014-10-02	14:15:32.618766	2014-10-02	22:08:13.308148	07:52:40	28360
1741	186	1	1	2014-10-02	14:17:28.125803	2014-10-02	22:08:53.331437	07:51:25	28285
1738	187	1	1	2014-10-02	14:12:12.330309	2014-10-02	22:09:13.514473	07:57:01	28621
1744	184	1	2	2014-10-02	22:08:07.816717	2014-10-03	06:04:22.69082	15:00:00	54000
1730	178	1	2	2014-10-02	14:04:31.436606	2014-10-03	06:04:57.632817	15:00:00	54000
1729	176	1	2	2014-10-02	14:03:55.629339	2014-10-03	06:05:26.130437	15:00:00	54000
1727	181	1	2	2014-10-02	14:02:37.055982	2014-10-03	06:05:39.010272	15:00:00	54000
1733	179	1	2	2014-10-02	14:07:32.874258	2014-10-03	06:08:54.759792	15:00:00	54000
1747	186	1	2	2014-10-02	22:08:53.331437	2014-10-03	06:08:55.736197	15:00:00	54000
1735	171	1	2	2014-10-02	14:07:48.806543	2014-10-03	06:09:01.199038	15:00:00	54000
1731	180	1	2	2014-10-02	14:06:34.57217	2014-10-03	06:09:34.217061	15:00:00	54000
1734	175	1	2	2014-10-02	14:07:37.756544	2014-10-03	06:10:20.12061	15:00:00	54000
1732	172	1	2	2014-10-02	14:06:45.01534	2014-10-03	06:10:38.17218	15:00:00	54000
1728	174	1	2	2014-10-02	14:03:54.373379	2014-10-03	06:10:57.034999	15:00:00	54000
1742	177	1	2	2014-10-02	14:53:53.186093	2014-10-03	07:23:30.302509	15:00:00	54000
1761	170	1	1	2014-10-03	09:53:21.848668	2014-10-03	13:25:06.112039	03:31:44	12704
1752	181	1	1	2014-10-03	06:05:39.010272	2014-10-03	14:01:31.607964	07:55:52	28552
1754	186	1	1	2014-10-03	06:08:55.736197	2014-10-03	14:02:39.878033	07:53:44	28424
1751	176	1	1	2014-10-03	06:05:26.130437	2014-10-03	14:04:28.910616	07:59:02	28742
1750	178	1	1	2014-10-03	06:04:57.632817	2014-10-03	14:04:50.650181	07:59:53	28793
1759	174	1	1	2014-10-03	06:10:57.034999	2014-10-03	14:05:17.058376	07:54:20	28460
1767	174	1	2	2014-10-03	14:05:17.058376	2014-10-03	14:05:31.071572	00:00:14	14
1756	180	1	1	2014-10-03	06:09:34.217061	2014-10-03	14:05:48.501195	07:56:14	28574
1757	175	1	1	2014-10-03	06:10:20.12061	2014-10-03	14:06:35.158186	07:56:15	28575
1758	172	1	1	2014-10-03	06:10:38.17218	2014-10-03	14:06:51.374916	07:56:13	28573
1755	171	1	1	2014-10-03	06:09:01.199038	2014-10-03	14:07:37.152491	07:58:35	28715
1753	179	1	1	2014-10-03	06:08:54.759792	2014-10-03	14:08:15.781561	07:59:21	28761
1748	187	1	2	2014-10-02	22:09:13.514473	2014-10-03	14:12:05.821858	15:00:00	54000
1743	189	1	2	2014-10-02	22:07:52.352686	2014-10-03	14:13:02.981349	15:00:00	54000
1764	186	1	2	2014-10-03	14:02:39.878033	2014-10-03	14:15:05.685597	00:12:25	745
1760	177	1	1	2014-10-03	07:23:30.302509	2014-10-03	15:08:45.289463	07:45:14	27914
1749	184	1	1	2014-10-03	06:04:22.69082	2014-10-03	17:38:52.474856	11:34:29	41669
1769	180	1	2	2014-10-03	14:05:48.501195	2014-10-04	06:05:01.973421	15:00:00	54000
1766	178	1	2	2014-10-03	14:04:50.650181	2014-10-04	06:05:12.930617	15:00:00	54000
1770	175	1	2	2014-10-03	14:06:35.158186	2014-10-04	06:10:39.237784	15:00:00	54000
1762	170	1	2	2014-10-03	13:25:06.112039	2014-10-04	07:44:27.783159	15:00:00	54000
1726	183	1	2	2014-10-02	14:02:19.378871	2014-10-05	06:13:21.299364	15:00:00	54000
1768	174	1	1	2014-10-03	14:05:31.071572	2014-10-03	14:09:53.398654	00:04:22	262
1745	185	1	2	2014-10-02	22:08:10.902464	2014-10-03	14:13:12.728921	15:00:00	54000
1746	188	1	2	2014-10-02	22:08:13.308148	2014-10-03	14:18:36.978198	15:00:00	54000
1781	184	1	2	2014-10-03	17:38:52.474856	2014-10-03	18:05:15.14842	00:26:22	1582
1778	186	1	1	2014-10-03	14:15:05.685597	2014-10-03	22:07:52.503732	07:52:46	28366
1782	184	1	1	2014-10-03	18:05:15.14842	2014-10-03	22:07:53.68427	04:02:38	14558
1779	188	1	1	2014-10-03	14:18:36.978198	2014-10-03	22:07:54.264673	07:49:17	28157
1777	185	1	1	2014-10-03	14:13:12.728921	2014-10-03	22:07:57.498489	07:54:44	28484
1775	187	1	1	2014-10-03	14:12:05.821858	2014-10-03	22:08:09.857621	07:56:04	28564
1776	189	1	1	2014-10-03	14:13:02.981349	2014-10-03	22:08:27.612202	07:55:24	28524
1763	181	1	2	2014-10-03	14:01:31.607964	2014-10-04	06:04:47.675983	15:00:00	54000
1774	174	1	2	2014-10-03	14:09:53.398654	2014-10-04	06:05:35.342155	15:00:00	54000
1773	179	1	2	2014-10-03	14:08:15.781561	2014-10-04	06:07:31.967791	15:00:00	54000
1772	171	1	2	2014-10-03	14:07:37.152491	2014-10-04	06:08:24.744102	15:00:00	54000
1771	172	1	2	2014-10-03	14:06:51.374916	2014-10-04	06:09:59.167402	15:00:00	54000
1780	177	1	2	2014-10-03	15:08:45.289463	2014-10-04	06:13:36.221159	15:00:00	54000
1791	178	1	1	2014-10-04	06:05:12.930617	2014-10-04	14:04:42.991935	07:59:30	28770
1789	181	1	1	2014-10-04	06:04:47.675983	2014-10-04	14:04:52.42433	08:00:04	28804
1790	180	1	1	2014-10-04	06:05:01.973421	2014-10-04	14:06:02.641875	08:01:00	28860
1792	174	1	1	2014-10-04	06:05:35.342155	2014-10-04	14:06:44.122029	08:01:08	28868
1795	172	1	1	2014-10-04	06:09:59.167402	2014-10-04	14:06:47.000886	07:56:47	28607
1794	171	1	1	2014-10-04	06:08:24.744102	2014-10-04	14:07:55.596903	07:59:30	28770
1796	175	1	1	2014-10-04	06:10:39.237784	2014-10-04	14:08:32.20811	07:57:52	28672
1793	179	1	1	2014-10-04	06:07:31.967791	2014-10-04	14:08:32.68063	08:01:00	28860
1797	177	1	1	2014-10-04	06:13:36.221159	2014-10-04	14:08:43.402207	07:55:07	28507
1787	187	1	2	2014-10-03	22:08:09.857621	2014-10-04	14:13:03.111857	15:00:00	54000
1788	189	1	2	2014-10-03	22:08:27.612202	2014-10-04	14:13:46.36833	15:00:00	54000
1785	188	1	2	2014-10-03	22:07:54.264673	2014-10-04	14:14:07.825985	15:00:00	54000
1798	170	1	1	2014-10-04	07:44:27.783159	2014-10-04	14:30:02.108434	06:45:34	24334
1809	189	1	1	2014-10-04	14:13:46.36833	2014-10-04	22:07:54.871126	07:54:08	28448
1808	187	1	1	2014-10-04	14:13:03.111857	2014-10-04	22:08:20.031257	07:55:16	28516
1810	188	1	1	2014-10-04	14:14:07.825985	2014-10-04	22:08:44.229234	07:54:36	28476
1765	176	1	2	2014-10-03	14:04:28.910616	2014-10-05	06:13:14.789237	15:00:00	54000
1816	183	1	1	2014-10-05	06:13:21.299364	2014-10-05	14:07:12.362544	07:53:51	28431
1706	173	1	1	2014-10-02	07:12:42.735727	2014-10-05	14:07:19.591286	15:00:00	54000
1815	176	1	1	2014-10-05	06:13:14.789237	2014-10-05	14:07:31.528135	07:54:16	28456
1786	185	1	2	2014-10-03	22:07:57.498489	2014-10-05	14:15:56.713397	15:00:00	54000
1784	184	1	2	2014-10-03	22:07:53.68427	2014-10-05	14:17:14.107915	15:00:00	54000
1783	186	1	2	2014-10-03	22:07:52.503732	2014-10-05	14:17:34.434065	15:00:00	54000
1820	185	1	1	2014-10-05	14:15:56.713397	2014-10-05	22:06:03.318072	07:50:06	28206
1822	186	1	1	2014-10-05	14:17:34.434065	2014-10-05	22:06:29.575195	07:48:55	28135
1821	184	1	1	2014-10-05	14:17:14.107915	2014-10-05	22:06:32.078148	07:49:17	28157
1801	180	1	2	2014-10-04	14:06:02.641875	2014-10-06	06:06:30.398372	15:00:00	54000
1799	178	1	2	2014-10-04	14:04:42.991935	2014-10-06	06:06:46.010613	15:00:00	54000
1819	176	1	2	2014-10-05	14:07:31.528135	2014-10-06	06:06:58.107823	15:00:00	54000
1802	174	1	2	2014-10-04	14:06:44.122029	2014-10-06	06:07:26.58223	15:00:00	54000
1817	183	1	2	2014-10-05	14:07:12.362544	2014-10-06	06:07:55.731712	15:00:00	54000
1804	171	1	2	2014-10-04	14:07:55.596903	2014-10-06	06:10:57.137258	15:00:00	54000
1800	181	1	2	2014-10-04	14:04:52.42433	2014-10-06	06:11:33.491774	15:00:00	54000
1805	175	1	2	2014-10-04	14:08:32.20811	2014-10-06	06:11:39.42393	15:00:00	54000
1823	185	1	2	2014-10-05	22:06:03.318072	2014-10-06	06:12:24.085747	15:00:00	54000
1803	172	1	2	2014-10-04	14:06:47.000886	2014-10-06	06:14:50.006886	15:00:00	54000
1807	177	1	2	2014-10-04	14:08:43.402207	2014-10-06	07:12:46.48084	15:00:00	54000
1818	173	1	2	2014-10-05	14:07:19.591286	2014-10-06	07:27:36.774771	15:00:00	54000
1837	173	1	1	2014-10-06	07:27:36.774771	2014-10-06	09:32:50.620973	02:05:13	7513
1838	173	1	2	2014-10-06	09:32:50.620973	2014-10-06	09:49:03.469691	00:16:12	972
1834	185	1	1	2014-10-06	06:12:24.085747	2014-10-06	13:05:45.170568	06:53:21	24801
1830	183	1	1	2014-10-06	06:07:55.731712	2014-10-06	13:22:04.533852	07:14:08	26048
1841	183	1	2	2014-10-06	13:22:04.533852	2014-10-06	13:22:13.220948	00:00:08	8
1831	171	1	1	2014-10-06	06:10:57.137258	2014-10-06	14:07:07.145163	07:56:10	28570
1835	172	1	1	2014-10-06	06:14:50.006886	2014-10-06	14:07:07.858255	07:52:17	28337
1826	180	1	1	2014-10-06	06:06:30.398372	2014-10-06	14:07:28.681868	08:00:58	28858
1829	174	1	1	2014-10-06	06:07:26.58223	2014-10-06	14:07:51.668825	08:00:25	28825
1828	176	1	1	2014-10-06	06:06:58.107823	2014-10-06	14:08:07.008	08:01:08	28868
1842	183	1	1	2014-10-06	13:22:13.220948	2014-10-06	14:08:11.680693	00:45:58	2758
1833	175	1	1	2014-10-06	06:11:39.42393	2014-10-06	14:08:12.052682	07:56:32	28592
1832	181	1	1	2014-10-06	06:11:33.491774	2014-10-06	14:08:24.933991	07:56:51	28611
1839	173	1	1	2014-10-06	09:49:03.469691	2014-10-06	14:09:41.960277	04:20:38	15638
1812	189	1	2	2014-10-04	22:07:54.871126	2014-10-06	14:11:59.133295	15:00:00	54000
1840	185	1	2	2014-10-06	13:05:45.170568	2014-10-06	14:20:13.274018	01:14:28	4468
1813	187	1	2	2014-10-04	22:08:20.031257	2014-10-06	14:20:24.931432	15:00:00	54000
1825	184	1	2	2014-10-05	22:06:32.078148	2014-10-06	14:22:52.738155	15:00:00	54000
1843	171	1	2	2014-10-06	14:07:07.145163	2014-10-07	06:03:43.699314	15:00:00	54000
1846	174	1	2	2014-10-06	14:07:51.668825	2014-10-07	06:05:01.638585	15:00:00	54000
1847	176	1	2	2014-10-06	14:08:07.008	2014-10-07	06:05:52.632242	15:00:00	54000
1806	179	1	2	2014-10-04	14:08:32.68063	2014-10-07	06:08:45.595134	15:00:00	54000
1848	183	1	2	2014-10-06	14:08:11.680693	2014-10-07	06:10:52.057979	15:00:00	54000
1811	170	1	2	2014-10-04	14:30:02.108434	2014-10-09	07:53:07.039931	15:00:00	54000
1827	178	1	1	2014-10-06	06:06:46.010613	2014-10-06	14:09:11.791106	08:02:25	28945
1814	188	1	2	2014-10-04	22:08:44.229234	2014-10-06	14:19:24.593513	15:00:00	54000
1824	186	1	2	2014-10-05	22:06:29.575195	2014-10-06	14:22:11.772204	15:00:00	54000
1852	173	1	2	2014-10-06	14:09:41.960277	2014-10-06	14:23:31.875112	00:13:49	829
1859	173	1	1	2014-10-06	14:23:31.875112	2014-10-06	15:00:56.440269	00:37:24	2244
1836	177	1	1	2014-10-06	07:12:46.48084	2014-10-06	15:10:57.59506	07:58:11	28691
1857	186	1	1	2014-10-06	14:22:11.772204	2014-10-06	22:05:46.953007	07:43:35	27815
1862	186	1	2	2014-10-06	22:05:46.953007	2014-10-06	22:05:57.020478	00:00:10	10
1854	188	1	1	2014-10-06	14:19:24.593513	2014-10-06	22:07:40.903782	07:48:16	28096
1855	185	1	1	2014-10-06	14:20:13.274018	2014-10-06	22:07:40.914663	07:47:27	28047
1853	189	1	1	2014-10-06	14:11:59.133295	2014-10-06	22:07:45.662868	07:55:46	28546
1856	187	1	1	2014-10-06	14:20:24.931432	2014-10-06	22:08:13.468278	07:47:48	28068
1863	186	1	1	2014-10-06	22:05:57.020478	2014-10-06	22:08:16.451631	00:02:19	139
1858	184	1	1	2014-10-06	14:22:52.738155	2014-10-06	22:09:12.514802	07:46:19	27979
1851	178	1	2	2014-10-06	14:09:11.791106	2014-10-07	06:00:56.031087	15:00:00	54000
1850	181	1	2	2014-10-06	14:08:24.933991	2014-10-07	06:03:40.231654	15:00:00	54000
1845	180	1	2	2014-10-06	14:07:28.681868	2014-10-07	06:05:15.616504	15:00:00	54000
1849	175	1	2	2014-10-06	14:08:12.052682	2014-10-07	06:09:26.817448	15:00:00	54000
1844	172	1	2	2014-10-06	14:07:07.858255	2014-10-07	06:10:41.560857	15:00:00	54000
1861	177	1	2	2014-10-06	15:10:57.59506	2014-10-07	07:15:06.220995	15:00:00	54000
1860	173	1	2	2014-10-06	15:00:56.440269	2014-10-07	07:16:23.004633	15:00:00	54000
1881	173	1	1	2014-10-07	07:16:23.004633	2014-10-07	08:45:43.22264	01:29:20	5360
1882	173	1	2	2014-10-07	08:45:43.22264	2014-10-07	09:13:54.94312	00:28:11	1691
1883	173	1	1	2014-10-07	09:13:54.94312	2014-10-07	10:14:26.288721	01:00:31	3631
1884	173	1	2	2014-10-07	10:14:26.288721	2014-10-07	11:41:47.96092	01:27:21	5241
1885	173	1	1	2014-10-07	11:41:47.96092	2014-10-07	12:33:58.533282	00:52:10	3130
1872	171	1	1	2014-10-07	06:03:43.699314	2014-10-07	14:01:36.696653	07:57:52	28672
1871	181	1	1	2014-10-07	06:03:40.231654	2014-10-07	14:02:45.502448	07:59:05	28745
1873	174	1	1	2014-10-07	06:05:01.638585	2014-10-07	14:03:28.028053	07:58:26	28706
1874	180	1	1	2014-10-07	06:05:15.616504	2014-10-07	14:05:41.566198	08:00:25	28825
1878	172	1	1	2014-10-07	06:10:41.560857	2014-10-07	14:05:55.388529	07:55:13	28513
1877	175	1	1	2014-10-07	06:09:26.817448	2014-10-07	14:06:21.503573	07:56:54	28614
1879	183	1	1	2014-10-07	06:10:52.057979	2014-10-07	14:06:22.985837	07:55:30	28530
1876	179	1	1	2014-10-07	06:08:45.595134	2014-10-07	14:07:15.934505	07:58:30	28710
1870	178	1	1	2014-10-07	06:00:56.031087	2014-10-07	14:07:45.492321	08:06:49	29209
1875	176	1	1	2014-10-07	06:05:52.632242	2014-10-07	14:07:45.697653	08:01:53	28913
1866	189	1	2	2014-10-06	22:07:45.662868	2014-10-07	14:09:29.334963	15:00:00	54000
1867	187	1	2	2014-10-06	22:08:13.468278	2014-10-07	14:09:44.495266	15:00:00	54000
1868	186	1	2	2014-10-06	22:08:16.451631	2014-10-07	14:09:54.075977	15:00:00	54000
1864	188	1	2	2014-10-06	22:07:40.903782	2014-10-07	14:10:27.921874	15:00:00	54000
1865	185	1	2	2014-10-06	22:07:40.914663	2014-10-07	14:10:44.232499	15:00:00	54000
1869	184	1	2	2014-10-06	22:09:12.514802	2014-10-07	14:14:30.391326	15:00:00	54000
1880	177	1	1	2014-10-07	07:15:06.220995	2014-10-07	14:56:19.927076	07:41:13	27673
1899	186	1	1	2014-10-07	14:09:54.075977	2014-10-07	22:07:17.551475	07:57:23	28643
1900	188	1	1	2014-10-07	14:10:27.921874	2014-10-07	22:08:29.054874	07:58:01	28681
1897	189	1	1	2014-10-07	14:09:29.334963	2014-10-07	22:08:37.843478	07:59:08	28748
1898	187	1	1	2014-10-07	14:09:44.495266	2014-10-07	22:08:54.739224	07:59:10	28750
1901	185	1	1	2014-10-07	14:10:44.232499	2014-10-07	22:09:37.695418	07:58:53	28733
1902	184	1	1	2014-10-07	14:14:30.391326	2014-10-07	22:09:40.278277	07:55:09	28509
1896	176	1	2	2014-10-07	14:07:45.697653	2014-10-08	06:04:33.081608	15:00:00	54000
1892	175	1	2	2014-10-07	14:06:21.503573	2014-10-08	06:09:50.979093	15:00:00	54000
1889	174	1	2	2014-10-07	14:03:28.028053	2014-10-08	06:12:46.174708	15:00:00	54000
1910	176	1	1	2014-10-08	06:04:33.081608	2014-10-08	10:06:03.323677	04:01:30	14490
1903	177	1	2	2014-10-07	14:56:19.927076	2014-10-08	10:06:11.634282	15:00:00	54000
1912	174	1	1	2014-10-08	06:12:46.174708	2014-10-08	10:06:50.651636	03:54:04	14044
1911	175	1	1	2014-10-08	06:09:50.979093	2014-10-08	10:06:55.788404	03:57:04	14224
1893	183	1	2	2014-10-07	14:06:22.985837	2014-10-08	10:08:50.234698	15:00:00	54000
1888	181	1	2	2014-10-07	14:02:45.502448	2014-10-08	10:09:32.000462	15:00:00	54000
1918	181	1	1	2014-10-08	10:09:32.000462	2014-10-08	13:09:38.055905	03:00:06	10806
1919	181	1	2	2014-10-08	13:09:38.055905	2014-10-08	13:09:45.883469	00:00:07	7
1917	183	1	1	2014-10-08	10:08:50.234698	2014-10-08	14:05:12.718413	03:56:22	14182
1920	181	1	1	2014-10-08	13:09:45.883469	2014-10-08	14:06:07.525039	00:56:21	3381
1914	177	1	1	2014-10-08	10:06:11.634282	2014-10-08	14:08:37.893602	04:02:26	14546
1905	188	1	2	2014-10-07	22:08:29.054874	2014-10-08	14:09:12.23897	15:00:00	54000
1908	185	1	2	2014-10-07	22:09:37.695418	2014-10-08	14:11:12.771421	15:00:00	54000
1921	183	1	2	2014-10-08	14:05:12.718413	2014-10-08	14:14:04.020043	00:08:51	531
1926	183	1	1	2014-10-08	14:14:04.020043	2014-10-08	21:45:18.139266	07:31:14	27074
1925	185	1	1	2014-10-08	14:11:12.771421	2014-10-08	22:08:35.804128	07:57:23	28643
1915	174	1	2	2014-10-08	10:06:50.651636	2014-10-09	06:03:13.596574	15:00:00	54000
1913	176	1	2	2014-10-08	10:06:03.323677	2014-10-09	06:05:02.551211	15:00:00	54000
1887	171	1	2	2014-10-07	14:01:36.696653	2014-10-09	06:07:46.061037	15:00:00	54000
1895	178	1	2	2014-10-07	14:07:45.492321	2014-10-09	06:07:48.322212	15:00:00	54000
1916	175	1	2	2014-10-08	10:06:55.788404	2014-10-09	06:08:30.43253	15:00:00	54000
1891	172	1	2	2014-10-07	14:05:55.388529	2014-10-09	06:09:14.861065	15:00:00	54000
1907	187	1	2	2014-10-07	22:08:54.739224	2014-10-09	14:10:45.394673	15:00:00	54000
1906	189	1	2	2014-10-07	22:08:37.843478	2014-10-09	14:11:33.607235	15:00:00	54000
1904	186	1	2	2014-10-07	22:07:17.551475	2014-10-09	14:16:29.403295	15:00:00	54000
1924	188	1	1	2014-10-08	14:09:12.23897	2014-10-08	22:08:35.100684	07:59:22	28762
1922	181	1	2	2014-10-08	14:06:07.525039	2014-10-09	06:03:32.023972	15:00:00	54000
1890	180	1	2	2014-10-07	14:05:41.566198	2014-10-09	06:05:11.191348	15:00:00	54000
1927	183	1	2	2014-10-08	21:45:18.139266	2014-10-09	06:06:09.156401	15:00:00	54000
1894	179	1	2	2014-10-07	14:07:15.934505	2014-10-09	06:08:20.717948	15:00:00	54000
1923	177	1	2	2014-10-08	14:08:37.893602	2014-10-09	07:18:24.889025	15:00:00	54000
1939	172	1	1	2014-10-09	06:09:14.861065	2014-10-09	10:45:08.065171	04:35:53	16553
1942	172	1	2	2014-10-09	10:45:08.065171	2014-10-09	10:45:10.983412	00:00:02	2
1941	170	1	1	2014-10-09	07:53:07.039931	2014-10-09	13:36:34.956482	05:43:27	20607
1931	181	1	1	2014-10-09	06:03:32.023972	2014-10-09	14:02:37.341699	07:59:05	28745
1930	174	1	1	2014-10-09	06:03:13.596574	2014-10-09	14:04:51.1949	08:01:37	28897
1938	175	1	1	2014-10-09	06:08:30.43253	2014-10-09	14:07:20.983994	07:58:50	28730
1936	178	1	1	2014-10-09	06:07:48.322212	2014-10-09	14:07:38.708206	07:59:50	28790
1933	180	1	1	2014-10-09	06:05:11.191348	2014-10-09	14:07:40.504191	08:02:29	28949
1932	176	1	1	2014-10-09	06:05:02.551211	2014-10-09	14:07:55.063191	08:02:52	28972
1935	171	1	1	2014-10-09	06:07:46.061037	2014-10-09	14:08:27.343405	08:00:41	28841
1937	179	1	1	2014-10-09	06:08:20.717948	2014-10-09	14:08:47.637275	08:00:26	28826
1943	172	1	1	2014-10-09	10:45:10.983412	2014-10-09	14:08:54.388835	03:23:43	12223
2308	189	1	1	2015-05-04	09:45:54.685952	2015-05-04	09:47:44.300717	00:01:49	109
1928	188	1	2	2014-10-08	22:08:35.100684	2014-10-09	14:11:36.087664	15:00:00	54000
1929	185	1	2	2014-10-08	22:08:35.804128	2014-10-09	14:12:23.996803	15:00:00	54000
1909	184	1	2	2014-10-07	22:09:40.278277	2014-10-09	14:14:47.07161	15:00:00	54000
1940	177	1	1	2014-10-09	07:18:24.889025	2014-10-09	15:13:37.966181	07:55:13	28513
1886	173	1	2	2014-10-07	12:33:58.533282	2014-11-04	14:58:40.725153	15:00:00	54000
1946	174	1	2	2014-10-09	14:04:51.1949	2014-11-06	15:35:37.112848	15:00:00	54000
1962	174	1	1	2014-11-06	15:35:37.112848	2014-11-06	15:36:41.865592	00:01:04	64
1963	174	1	2	2014-11-06	15:36:41.865592	2014-11-06	15:43:12.13795	00:06:30	390
1961	173	1	1	2014-11-04	14:58:40.725153	2014-11-11	10:04:01.279166	15:00:00	54000
1964	174	1	1	2014-11-06	15:43:12.13795	2014-11-11	10:17:37.025608	15:00:00	54000
1965	173	1	2	2014-11-11	10:04:01.279166	2014-11-11	13:59:13.598593	03:55:12	14112
1967	173	1	1	2014-11-11	13:59:13.598593	2014-11-11	14:00:44.168823	00:01:30	90
1968	173	1	2	2014-11-11	14:00:44.168823	2014-11-11	14:21:22.423488	00:20:38	1238
1969	173	1	1	2014-11-11	14:21:22.423488	2014-11-11	14:26:31.002098	00:05:08	308
1970	173	1	2	2014-11-11	14:26:31.002098	2014-11-11	14:33:25.542414	00:06:54	414
1971	173	1	1	2014-11-11	14:33:25.542414	2014-11-11	15:48:46.144268	01:15:20	4520
1972	173	1	2	2014-11-11	15:48:46.144268	2014-11-12	10:58:59.101378	15:00:00	54000
1973	173	1	1	2014-11-12	10:58:59.101378	2014-11-12	12:30:50.302935	01:31:51	5511
1974	173	1	3	2014-11-12	12:30:50.302935	2014-11-12	12:31:12.22852	00:00:21	21
1975	173	1	3	2014-11-12	12:31:12.22852	2014-11-12	12:32:42.862136	00:01:30	90
1976	173	1	3	2014-11-12	12:32:42.862136	2014-11-12	12:32:55.736055	00:00:12	12
1977	173	1	3	2014-11-12	12:32:55.736055	2014-11-12	12:33:48.494677	00:00:52	52
1978	173	1	3	2014-11-12	12:33:48.494677	2014-11-12	12:33:53.268183	00:00:04	4
1979	173	1	1	2014-11-12	12:33:53.268183	2014-11-12	14:25:36.999099	01:51:43	6703
1980	173	1	2	2014-11-12	14:25:36.999099	2014-11-12	16:26:10.760863	02:00:33	7233
1981	173	1	1	2014-11-12	16:26:10.760863	2014-11-12	16:44:13.101642	00:18:02	1082
1982	173	1	2	2014-11-12	16:44:13.101642	2014-11-12	17:38:03.508811	00:53:50	3230
1983	173	1	1	2014-11-12	17:38:03.508811	2014-11-12	18:02:31.018646	00:24:27	1467
1984	173	1	2	2014-11-12	18:02:31.018646	2014-11-12	18:11:09.088157	00:08:38	518
1985	173	1	1	2014-11-12	18:11:09.088157	2014-11-12	18:12:03.140379	00:00:54	54
1986	173	1	2	2014-11-12	18:12:03.140379	2014-11-12	18:12:18.165898	00:00:15	15
1987	173	1	1	2014-11-12	18:12:18.165898	2014-11-12	18:12:33.749839	00:00:15	15
1988	173	1	2	2014-11-12	18:12:33.749839	2014-11-12	18:27:50.78395	00:15:17	917
1989	173	1	1	2014-11-12	18:27:50.78395	2014-11-12	18:36:25.736453	00:08:34	514
1990	173	1	2	2014-11-12	18:36:25.736453	2014-11-12	18:37:57.556814	00:01:31	91
1991	173	1	1	2014-11-12	18:37:57.556814	2014-11-13	10:05:12.795106	15:00:00	54000
1992	173	1	2	2014-11-13	10:05:12.795106	2014-11-13	10:07:32.083577	00:02:19	139
1993	173	1	1	2014-11-13	10:07:32.083577	2014-11-13	10:07:50.584389	00:00:18	18
1994	173	1	2	2014-11-13	10:07:50.584389	2014-11-13	10:10:17.11608	00:02:26	146
1995	173	1	1	2014-11-13	10:10:17.11608	2014-11-13	10:31:25.073313	00:21:07	1267
1996	173	1	3	2014-11-13	10:31:25.073313	2014-11-13	10:37:48.618112	00:06:23	383
1997	173	1	2	2014-11-13	10:37:48.618112	2014-11-13	10:38:24.461192	00:00:35	35
1998	173	1	1	2014-11-13	10:38:24.461192	2014-11-17	16:49:33.677252	15:00:00	54000
1999	173	1	3	2014-11-17	16:49:33.677252	2014-11-18	15:49:11.199927	15:00:00	54000
1952	179	1	2	2014-10-09	14:08:47.637275	2014-11-27	10:19:13.560985	15:00:00	54000
1956	188	1	1	2014-10-09	14:11:36.087664	2014-11-27	10:42:02.494956	15:00:00	54000
1955	189	1	1	2014-10-09	14:11:33.607235	2014-11-27	12:27:26.424884	15:00:00	54000
1947	175	1	2	2014-10-09	14:07:20.983994	2014-11-28	11:39:21.432938	15:00:00	54000
1966	174	1	2	2014-11-11	10:17:37.025608	2014-12-03	16:53:16.306165	15:00:00	54000
1944	170	1	2	2014-10-09	13:36:34.956482	2014-12-05	10:20:34.53036	15:00:00	54000
1959	186	1	1	2014-10-09	14:16:29.403295	2014-12-10	10:27:21.081129	15:00:00	54000
1945	181	1	2	2014-10-09	14:02:37.341699	2014-12-24	12:04:13.493818	15:00:00	54000
2000	173	1	1	2014-11-18	15:49:11.199927	2014-11-18	16:43:22.197065	00:54:10	3250
2001	173	1	2	2014-11-18	16:43:22.197065	2014-11-18	16:53:11.043042	00:09:48	588
1950	176	1	2	2014-10-09	14:07:55.063191	2014-11-27	10:18:30.556064	15:00:00	54000
2003	176	1	1	2014-11-27	10:18:30.556064	2014-11-27	10:18:56.624401	00:00:26	26
2005	179	1	3	2014-11-27	10:19:13.560985	2014-11-27	10:19:27.973439	00:00:14	14
2006	179	1	1	2014-11-27	10:19:27.973439	2014-11-27	10:26:35.726884	00:07:07	427
2007	179	1	1	2014-11-27	10:26:35.726884	2014-11-27	10:26:41.471363	00:00:05	5
2008	179	1	2	2014-11-27	10:26:41.471363	2014-11-27	10:26:43.640828	00:00:02	2
2004	176	1	2	2014-11-27	10:18:56.624401	2014-11-27	10:27:30.912891	00:08:34	514
2011	188	1	1	2014-11-27	10:42:02.494956	2014-11-27	12:20:53.998381	01:38:51	5931
2012	188	1	3	2014-11-27	12:20:53.998381	2014-11-27	12:21:11.213054	00:00:17	17
2013	188	1	1	2014-11-27	12:21:11.213054	2014-11-27	12:22:07.266154	00:00:56	56
2010	176	1	1	2014-11-27	10:27:30.912891	2014-11-27	12:22:09.219053	01:54:38	6878
2009	179	1	2	2014-11-27	10:26:43.640828	2014-11-27	12:22:22.215043	01:55:38	6938
2016	179	1	1	2014-11-27	12:22:22.215043	2014-11-27	12:26:30.226271	00:04:08	248
2017	179	1	2	2014-11-27	12:26:30.226271	2014-11-27	12:26:37.385218	00:00:07	7
1949	180	1	2	2014-10-09	14:07:40.504191	2015-01-14	14:38:48.819915	15:00:00	54000
1948	178	1	2	2014-10-09	14:07:38.708206	2015-01-14	14:55:30.622114	15:00:00	54000
2019	189	1	1	2014-11-27	12:27:26.424884	2014-11-27	12:39:00.613049	00:11:34	694
2020	189	1	3	2014-11-27	12:39:00.613049	2014-11-27	12:46:39.053782	00:07:38	458
2018	179	1	1	2014-11-27	12:26:37.385218	2014-11-27	12:47:34.404932	00:20:57	1257
2022	179	1	3	2014-11-27	12:47:34.404932	2014-11-27	12:48:36.048019	00:01:01	61
2021	189	1	1	2014-11-27	12:46:39.053782	2014-11-27	14:46:13.600702	01:59:34	7174
2023	179	1	1	2014-11-27	12:48:36.048019	2014-11-27	14:46:15.235646	01:57:39	7059
1960	177	1	2	2014-10-09	15:13:37.966181	2014-11-27	15:33:48.235859	15:00:00	54000
2026	177	1	2	2014-11-27	15:33:48.235859	2014-11-27	15:34:00.574356	00:00:12	12
2025	179	1	1	2014-11-27	14:46:15.235646	2014-11-28	10:18:39.049314	15:00:00	54000
2024	189	1	1	2014-11-27	14:46:13.600702	2014-11-28	10:18:41.993173	15:00:00	54000
2027	177	1	1	2014-11-27	15:34:00.574356	2014-11-28	10:18:44.501448	15:00:00	54000
2015	176	1	2	2014-11-27	12:22:09.219053	2014-12-02	12:30:59.300543	15:00:00	54000
2033	174	1	1	2014-12-03	16:53:16.306165	2014-12-03	17:35:25.855891	00:42:09	2529
2028	179	1	2	2014-11-28	10:18:39.049314	2014-12-03	17:47:41.321937	15:00:00	54000
2035	179	1	3	2014-12-03	17:47:41.321937	2014-12-03	17:49:19.855771	00:01:38	98
2036	179	1	3	2014-12-03	17:49:19.855771	2014-12-03	17:49:44.204622	00:00:24	24
2037	179	1	2	2014-12-03	17:49:44.204622	2014-12-03	17:49:57.227375	00:00:13	13
2038	179	1	1	2014-12-03	17:49:57.227375	2014-12-03	17:50:39.093714	00:00:41	41
2039	179	1	3	2014-12-03	17:50:39.093714	2014-12-03	17:50:54.44093	00:00:15	15
2040	179	1	1	2014-12-03	17:50:54.44093	2014-12-03	17:51:01.968667	00:00:07	7
1951	171	1	2	2014-10-09	14:08:27.343405	2014-12-04	10:37:54.247676	15:00:00	54000
2042	171	1	1	2014-12-04	10:37:54.247676	2014-12-04	10:43:39.019224	00:05:44	344
2043	171	1	1	2014-12-04	10:43:39.019224	2014-12-04	10:51:08.623237	00:07:29	449
2044	171	1	1	2014-12-04	10:51:08.623237	2014-12-04	10:57:30.457361	00:06:21	381
2045	171	1	2	2014-12-04	10:57:30.457361	2014-12-04	10:58:31.595484	00:01:01	61
2046	171	1	1	2014-12-04	10:58:31.595484	2014-12-04	10:59:18.590391	00:00:46	46
2047	171	1	2	2014-12-04	10:59:18.590391	2014-12-04	11:09:24.383078	00:10:05	605
2048	171	1	1	2014-12-04	11:09:24.383078	2014-12-04	11:10:05.868272	00:00:41	41
2049	171	1	3	2014-12-04	11:10:05.868272	2014-12-04	11:10:19.198467	00:00:13	13
2050	171	1	1	2014-12-04	11:10:19.198467	2014-12-04	11:10:56.143957	00:00:36	36
2051	171	1	2	2014-12-04	11:10:56.143957	2014-12-04	11:13:26.210866	00:02:30	150
2052	171	1	1	2014-12-04	11:13:26.210866	2014-12-04	11:14:12.786346	00:00:46	46
2053	171	1	3	2014-12-04	11:14:12.786346	2014-12-04	11:23:02.379433	00:08:49	529
2054	171	1	2	2014-12-04	11:23:02.379433	2014-12-04	11:38:10.047303	00:15:07	907
2055	171	1	1	2014-12-04	11:38:10.047303	2014-12-04	11:38:52.433169	00:00:42	42
2056	171	1	2	2014-12-04	11:38:52.433169	2014-12-04	11:39:50.310141	00:00:57	57
2057	171	1	1	2014-12-04	11:39:50.310141	2014-12-04	11:40:04.831106	00:00:14	14
2058	171	1	2	2014-12-04	11:40:04.831106	2014-12-04	11:40:37.074643	00:00:32	32
2059	171	1	1	2014-12-04	11:40:37.074643	2014-12-04	12:19:28.914635	00:38:51	2331
2060	171	1	2	2014-12-04	12:19:28.914635	2014-12-04	12:19:37.113851	00:00:08	8
2061	171	1	1	2014-12-04	12:19:37.113851	2014-12-05	10:35:06.956433	15:00:00	54000
2063	171	1	2	2014-12-05	10:35:06.956433	2014-12-05	17:35:16.808789	07:00:09	25209
2064	171	1	1	2014-12-05	17:35:16.808789	2014-12-09	17:35:10.923162	15:00:00	54000
2065	171	1	2	2014-12-09	17:35:10.923162	2014-12-10	10:26:15.901842	15:00:00	54000
2066	171	1	1	2014-12-10	10:26:15.901842	2014-12-10	10:27:08.792705	00:00:52	52
2068	186	1	1	2014-12-10	10:27:21.081129	2014-12-10	11:43:33.487561	01:16:12	4572
2029	189	1	2	2014-11-28	10:18:41.993173	2014-12-10	11:44:16.33306	15:00:00	54000
2067	171	1	2	2014-12-10	10:27:08.792705	2014-12-10	11:47:15.657933	01:20:06	4806
2071	171	1	1	2014-12-10	11:47:15.657933	2014-12-10	11:47:38.700842	00:00:23	23
1954	187	1	1	2014-10-09	14:10:45.394673	2014-12-10	16:08:09.882392	15:00:00	54000
2034	174	1	2	2014-12-03	17:35:25.855891	2014-12-10	17:21:26.871982	15:00:00	54000
2090	170	1	2	2014-12-12	17:26:51.980397	2015-05-14	11:02:54.620138	15:00:00	54000
2014	188	1	2	2014-11-27	12:22:07.266154	2014-12-10	17:32:52.461374	15:00:00	54000
2072	171	1	2	2014-12-10	11:47:38.700842	2014-12-11	11:44:25.599563	15:00:00	54000
2076	171	1	1	2014-12-11	11:44:25.599563	2014-12-12	16:17:48.704233	15:00:00	54000
2077	171	1	2	2014-12-12	16:17:48.704233	2014-12-12	16:23:10.174455	00:05:21	321
2078	171	1	1	2014-12-12	16:23:10.174455	2014-12-12	16:24:15.49135	00:01:05	65
2079	171	1	2	2014-12-12	16:24:15.49135	2014-12-12	16:24:23.04237	00:00:07	7
2080	171	1	1	2014-12-12	16:24:23.04237	2014-12-12	16:24:56.736611	00:00:33	33
2081	171	1	2	2014-12-12	16:24:56.736611	2014-12-12	16:27:47.556283	00:02:50	170
2082	171	1	1	2014-12-12	16:27:47.556283	2014-12-12	16:28:02.277891	00:00:14	14
2083	171	1	2	2014-12-12	16:28:02.277891	2014-12-12	16:28:42.783099	00:00:40	40
2084	171	1	1	2014-12-12	16:28:42.783099	2014-12-12	17:09:44.797271	00:41:02	2462
2002	173	1	1	2014-11-18	16:53:11.043042	2014-12-12	17:10:31.155512	15:00:00	54000
2086	173	1	1	2014-12-12	17:10:31.155512	2014-12-12	17:12:55.561223	00:02:24	144
2085	171	1	2	2014-12-12	17:09:44.797271	2014-12-12	17:15:21.698068	00:05:36	336
2062	170	1	1	2014-12-05	10:20:34.53036	2014-12-12	17:26:51.980397	15:00:00	54000
2030	177	1	2	2014-11-28	10:18:44.501448	2014-12-15	11:24:01.039688	15:00:00	54000
2075	188	1	1	2014-12-10	17:32:52.461374	2014-12-16	12:21:48.770522	15:00:00	54000
2069	186	1	2	2014-12-10	11:43:33.487561	2014-12-12	17:14:24.752473	15:00:00	54000
2089	171	1	1	2014-12-12	17:15:21.698068	2014-12-12	17:31:45.1442	00:16:23	983
2032	176	1	1	2014-12-02	12:30:59.300543	2014-12-12	20:12:51.242847	15:00:00	54000
2092	176	1	1	2014-12-12	20:12:51.242847	2014-12-15	10:59:09.496171	15:00:00	54000
2088	186	1	1	2014-12-12	17:14:24.752473	2014-12-15	11:23:26.982121	15:00:00	54000
2095	177	1	1	2014-12-15	11:24:01.039688	2014-12-15	11:46:17.928379	00:22:16	1336
2091	171	1	2	2014-12-12	17:31:45.1442	2014-12-15	11:53:39.670355	15:00:00	54000
2094	186	1	2	2014-12-15	11:23:26.982121	2015-01-16	11:16:40.623573	15:00:00	54000
2070	189	1	1	2014-12-10	11:44:16.33306	2015-01-16	11:17:39.028345	15:00:00	54000
2087	173	1	2	2014-12-12	17:12:55.561223	2015-01-16	11:25:33.91032	15:00:00	54000
2031	175	1	1	2014-11-28	11:39:21.432938	2015-03-16	12:40:23.487755	15:00:00	54000
2097	171	1	1	2014-12-15	11:53:39.670355	2014-12-15	11:55:18.521264	00:01:38	98
2098	171	1	2	2014-12-15	11:55:18.521264	2014-12-15	11:55:47.742012	00:00:29	29
2099	171	1	1	2014-12-15	11:55:47.742012	2014-12-22	16:25:15.376833	15:00:00	54000
2101	171	1	1	2014-12-22	16:25:15.376833	2014-12-23	09:17:41.105571	15:00:00	54000
2102	171	1	2	2014-12-23	09:17:41.105571	2014-12-23	09:17:43.098776	00:00:01	1
2103	171	1	2	2014-12-23	09:17:43.098776	2014-12-23	10:03:09.594127	00:45:26	2726
2096	177	1	2	2014-12-15	11:46:17.928379	2014-12-23	15:26:12.822234	15:00:00	54000
2105	177	1	1	2014-12-23	15:26:12.822234	2014-12-24	10:24:07.160652	15:00:00	54000
2104	171	1	1	2014-12-23	10:03:09.594127	2014-12-24	10:24:09.465775	15:00:00	54000
2107	171	1	2	2014-12-24	10:24:09.465775	2014-12-24	10:24:11.559419	00:00:02	2
2106	177	1	2	2014-12-24	10:24:07.160652	2014-12-24	10:25:09.915971	00:01:02	62
2109	177	1	1	2014-12-24	10:25:09.915971	2014-12-24	10:29:06.534552	00:03:56	236
2108	171	1	2	2014-12-24	10:24:11.559419	2014-12-26	11:38:24.65972	15:00:00	54000
2112	171	1	1	2014-12-26	11:38:24.65972	2014-12-26	11:38:35.18764	00:00:10	10
2113	171	1	3	2014-12-26	11:38:35.18764	2014-12-26	11:38:48.41021	00:00:13	13
2114	171	1	1	2014-12-26	11:38:48.41021	2014-12-26	11:43:44.455125	00:04:56	296
2115	171	1	3	2014-12-26	11:43:44.455125	2014-12-26	11:43:53.276382	00:00:08	8
2116	171	1	1	2014-12-26	11:43:53.276382	2014-12-29	13:09:54.144643	15:00:00	54000
2117	171	1	2	2014-12-29	13:09:54.144643	2014-12-29	13:09:57.205646	00:00:03	3
2111	181	1	1	2014-12-24	12:04:13.493818	2014-12-29	13:10:00.58534	15:00:00	54000
2118	171	1	2	2014-12-29	13:09:57.205646	2014-12-29	13:14:10.962968	00:04:13	253
2120	171	1	1	2014-12-29	13:14:10.962968	2015-01-08	09:37:40.452158	15:00:00	54000
2121	171	1	2	2015-01-08	09:37:40.452158	2015-01-08	09:37:42.728474	00:00:02	2
2041	179	1	2	2014-12-03	17:51:01.968667	2015-01-08	09:58:16.204852	15:00:00	54000
2119	181	1	2	2014-12-29	13:10:00.58534	2015-01-08	09:58:34.951535	15:00:00	54000
2122	171	1	2	2015-01-08	09:37:42.728474	2015-01-08	09:58:41.699436	00:20:58	1258
2125	171	1	1	2015-01-08	09:58:41.699436	2015-01-14	05:31:45.289381	15:00:00	54000
2124	181	1	1	2015-01-08	09:58:34.951535	2015-01-14	05:31:46.961038	15:00:00	54000
2123	179	1	1	2015-01-08	09:58:16.204852	2015-01-14	05:31:48.779845	15:00:00	54000
2128	179	1	2	2015-01-14	05:31:48.779845	2015-01-14	05:31:59.724791	00:00:10	10
2110	177	1	2	2014-12-24	10:29:06.534552	2015-01-14	10:42:00.953442	15:00:00	54000
1645	182	1	2	2014-09-30	16:51:12.857975	2015-01-14	10:42:26.869753	15:00:00	54000
2131	182	1	1	2015-01-14	10:42:26.869753	2015-01-14	10:46:07.930026	00:03:41	221
2130	177	1	1	2015-01-14	10:42:00.953442	2015-01-14	10:46:09.70503	00:04:08	248
2129	179	1	1	2015-01-14	05:31:59.724791	2015-01-14	10:46:11.271635	05:14:11	18851
2134	179	1	2	2015-01-14	10:46:11.271635	2015-01-14	10:47:16.110316	00:01:04	64
2135	179	1	1	2015-01-14	10:47:16.110316	2015-01-14	11:02:40.151415	00:15:24	924
2136	179	1	3	2015-01-14	11:02:40.151415	2015-01-14	11:02:41.559609	00:00:01	1
2126	171	1	2	2015-01-14	05:31:45.289381	2015-01-14	11:03:50.559456	05:32:05	19925
1953	172	1	2	2014-10-09	14:08:54.388835	2015-01-14	11:15:41.282616	15:00:00	54000
2139	172	1	1	2015-01-14	11:15:41.282616	2015-01-14	11:15:48.418064	00:00:07	7
2133	177	1	2	2015-01-14	10:46:09.70503	2015-01-14	11:19:33.660062	00:33:23	2003
2141	177	1	1	2015-01-14	11:19:33.660062	2015-01-14	11:19:42.18727	00:00:08	8
2142	177	1	2	2015-01-14	11:19:42.18727	2015-01-14	11:21:27.769872	00:01:45	105
2143	177	1	1	2015-01-14	11:21:27.769872	2015-01-14	11:21:33.227391	00:00:05	5
2132	182	1	2	2015-01-14	10:46:07.930026	2015-01-14	11:23:40.714751	00:37:32	2252
2145	182	1	1	2015-01-14	11:23:40.714751	2015-01-14	11:23:56.017755	00:00:15	15
2144	177	1	2	2015-01-14	11:21:33.227391	2015-01-14	11:26:52.012543	00:05:18	318
2147	177	1	1	2015-01-14	11:26:52.012543	2015-01-14	11:33:04.526935	00:06:12	372
2148	177	1	2	2015-01-14	11:33:04.526935	2015-01-14	11:34:03.35263	00:00:58	58
2149	177	1	1	2015-01-14	11:34:03.35263	2015-01-14	11:34:11.527588	00:00:08	8
2146	182	1	2	2015-01-14	11:23:56.017755	2015-01-14	11:34:40.954284	00:10:44	644
2151	182	1	1	2015-01-14	11:34:40.954284	2015-01-14	11:38:05.358105	00:03:24	204
1958	184	1	1	2014-10-09	14:14:47.07161	2015-01-14	11:38:14.582562	15:00:00	54000
2153	184	1	1	2015-01-14	11:38:14.582562	2015-01-14	11:38:55.667026	00:00:41	41
2150	177	1	2	2015-01-14	11:34:11.527588	2015-01-14	11:43:44.576727	00:09:33	573
2155	177	1	1	2015-01-14	11:43:44.576727	2015-01-14	11:44:36.014995	00:00:51	51
2156	177	1	2	2015-01-14	11:44:36.014995	2015-01-14	11:47:12.56926	00:02:36	156
2157	177	1	1	2015-01-14	11:47:12.56926	2015-01-14	11:48:42.772167	00:01:30	90
2152	182	1	2	2015-01-14	11:38:05.358105	2015-01-14	12:33:26.533136	00:55:21	3321
2310	189	1	2	2015-05-04	09:47:44.300717	2015-05-04	09:47:57.442471	00:00:13	13
2158	177	1	2	2015-01-14	11:48:42.772167	2015-01-14	12:36:12.176951	00:47:29	2849
2160	177	1	2	2015-01-14	12:36:12.176951	2015-01-14	12:36:22.275358	00:00:10	10
2161	177	1	2	2015-01-14	12:36:22.275358	2015-01-14	12:36:33.237014	00:00:10	10
2162	177	1	1	2015-01-14	12:36:33.237014	2015-01-14	12:39:25.27612	00:02:52	172
2127	181	1	2	2015-01-14	05:31:46.961038	2015-01-14	12:41:05.586813	07:09:18	25758
2164	181	1	1	2015-01-14	12:41:05.586813	2015-01-14	12:44:30.318957	00:03:24	204
2138	171	1	1	2015-01-14	11:03:50.559456	2015-01-14	12:48:09.812352	01:44:19	6259
2166	171	1	1	2015-01-14	12:48:09.812352	2015-01-14	14:02:10.846455	01:14:01	4441
2163	177	1	2	2015-01-14	12:39:25.27612	2015-01-14	14:02:27.741527	01:23:02	4982
2168	177	1	1	2015-01-14	14:02:27.741527	2015-01-14	14:03:04.740149	00:00:36	36
2169	177	1	2	2015-01-14	14:03:04.740149	2015-01-14	14:03:32.168103	00:00:27	27
2170	177	1	1	2015-01-14	14:03:32.168103	2015-01-14	14:04:45.641502	00:01:13	73
2171	177	1	2	2015-01-14	14:04:45.641502	2015-01-14	14:10:28.141191	00:05:42	342
2172	177	1	1	2015-01-14	14:10:28.141191	2015-01-14	14:10:42.731462	00:00:14	14
2137	179	1	1	2015-01-14	11:02:41.559609	2015-01-14	15:55:16.783958	04:52:35	17555
2154	184	1	2	2015-01-14	11:38:55.667026	2015-01-22	11:08:38.957316	15:00:00	54000
2140	172	1	2	2015-01-14	11:15:48.418064	2015-01-22	13:31:42.813914	15:00:00	54000
2100	188	1	1	2014-12-16	12:21:48.770522	2015-04-10	14:24:32.221032	15:00:00	54000
2173	177	1	2	2015-01-14	14:10:42.731462	2015-01-14	14:36:42.666258	00:25:59	1559
2174	177	1	1	2015-01-14	14:36:42.666258	2015-01-14	14:37:30.982889	00:00:48	48
2176	180	1	1	2015-01-14	14:38:48.819915	2015-01-14	14:44:08.10726	00:05:19	319
2177	180	1	1	2015-01-14	14:44:08.10726	2015-01-14	14:46:16.955139	00:02:08	128
2175	177	1	1	2015-01-14	14:37:30.982889	2015-01-14	15:18:40.582562	00:41:09	2469
2167	171	1	2	2015-01-14	14:02:10.846455	2015-01-14	15:25:10.979026	01:23:00	4980
2181	171	1	1	2015-01-14	15:25:10.979026	2015-01-14	15:25:22.068205	00:00:11	11
2180	177	1	2	2015-01-14	15:18:40.582562	2015-01-14	15:30:21.007886	00:11:40	700
2183	177	1	1	2015-01-14	15:30:21.007886	2015-01-14	15:32:13.112911	00:01:52	112
2184	177	1	2	2015-01-14	15:32:13.112911	2015-01-14	15:32:46.191285	00:00:33	33
2179	178	1	1	2015-01-14	14:55:30.622114	2015-01-14	15:33:50.489508	00:38:19	2299
2178	180	1	2	2015-01-14	14:46:16.955139	2015-01-14	15:33:52.563622	00:47:35	2855
2186	178	1	2	2015-01-14	15:33:50.489508	2015-01-14	15:34:02.663677	00:00:12	12
2185	177	1	1	2015-01-14	15:32:46.191285	2015-01-14	15:34:39.356621	00:01:53	113
2189	177	1	1	2015-01-14	15:34:39.356621	2015-01-14	15:36:22.675064	00:01:43	103
2188	178	1	1	2015-01-14	15:34:02.663677	2015-01-14	15:36:31.165998	00:02:28	148
2191	178	1	1	2015-01-14	15:36:31.165998	2015-01-14	15:45:43.448933	00:09:12	552
2192	178	1	2	2015-01-14	15:45:43.448933	2015-01-14	15:48:16.354522	00:02:32	152
2190	177	1	2	2015-01-14	15:36:22.675064	2015-01-14	15:48:18.708085	00:11:56	716
2194	177	1	2	2015-01-14	15:48:18.708085	2015-01-14	15:49:09.113005	00:00:50	50
1957	185	1	1	2014-10-09	14:12:23.996803	2015-01-14	15:49:50.702751	15:00:00	54000
2195	177	1	1	2015-01-14	15:49:09.113005	2015-01-14	15:50:08.050517	00:00:58	58
2197	177	1	2	2015-01-14	15:50:08.050517	2015-01-14	15:51:04.867219	00:00:56	56
2198	177	1	1	2015-01-14	15:51:04.867219	2015-01-14	15:55:40.766926	00:04:35	275
2199	179	1	1	2015-01-14	15:55:16.783958	2015-01-14	15:56:02.23399	00:00:45	45
2201	179	1	1	2015-01-14	15:56:02.23399	2015-01-14	15:57:44.669253	00:01:42	102
2202	179	1	2	2015-01-14	15:57:44.669253	2015-01-14	15:57:55.450822	00:00:10	10
2200	177	1	2	2015-01-14	15:55:40.766926	2015-01-16	11:15:23.082217	15:00:00	54000
2182	171	1	2	2015-01-14	15:25:22.068205	2015-01-16	11:15:41.903397	15:00:00	54000
2193	178	1	2	2015-01-14	15:48:16.354522	2015-01-16	11:16:10.419645	15:00:00	54000
2093	176	1	2	2014-12-15	10:59:09.496171	2015-01-16	11:17:14.469988	15:00:00	54000
2205	171	1	1	2015-01-16	11:15:41.903397	2015-01-16	11:20:07.260933	00:04:25	265
2206	178	1	1	2015-01-16	11:16:10.419645	2015-01-16	11:21:57.010637	00:05:46	346
2196	185	1	1	2015-01-14	15:49:50.702751	2015-01-16	11:24:31.909268	15:00:00	54000
2210	171	1	1	2015-01-16	11:20:07.260933	2015-01-16	11:25:18.851495	00:05:11	311
2213	171	1	2	2015-01-16	11:25:18.851495	2015-01-22	10:05:25.16921	15:00:00	54000
2207	186	1	1	2015-01-16	11:16:40.623573	2015-01-22	10:16:37.597832	15:00:00	54000
2216	186	1	1	2015-01-22	10:16:37.597832	2015-01-22	11:03:32.325875	00:46:54	2814
2203	179	1	1	2015-01-14	15:57:55.450822	2015-01-22	11:40:36.5038	15:00:00	54000
2211	178	1	1	2015-01-16	11:21:57.010637	2015-01-22	11:40:37.659187	15:00:00	54000
2219	179	1	3	2015-01-22	11:40:36.5038	2015-01-22	12:42:40.993595	01:02:04	3724
2220	178	1	3	2015-01-22	11:40:37.659187	2015-01-22	12:42:42.029122	01:02:04	3724
2212	185	1	1	2015-01-16	11:24:31.909268	2015-01-22	13:17:39.893489	15:00:00	54000
2221	179	1	1	2015-01-22	12:42:40.993595	2015-01-22	13:17:41.33351	00:35:00	2100
2204	177	1	1	2015-01-16	11:15:23.082217	2015-01-22	13:17:43.1667	15:00:00	54000
2215	171	1	1	2015-01-22	10:05:25.16921	2015-01-22	13:17:44.741694	03:12:19	11539
2217	186	1	1	2015-01-22	11:03:32.325875	2015-01-22	13:17:46.291791	02:14:13	8053
2208	176	1	1	2015-01-16	11:17:14.469988	2015-01-22	13:17:48.016811	15:00:00	54000
2209	189	1	1	2015-01-16	11:17:39.028345	2015-01-22	13:17:49.348859	15:00:00	54000
2222	178	1	1	2015-01-22	12:42:42.029122	2015-01-22	13:17:50.750075	00:35:08	2108
2223	185	1	2	2015-01-22	13:17:39.893489	2015-01-22	13:17:52.441835	00:00:12	12
2231	185	1	2	2015-01-22	13:17:52.441835	\N	\N	\N	\N
2214	173	1	1	2015-01-16	11:25:33.91032	2015-01-22	13:17:53.833184	15:00:00	54000
2227	186	1	2	2015-01-22	13:17:46.291791	2015-01-22	13:17:55.215318	00:00:08	8
2218	184	1	1	2015-01-22	11:08:38.957316	2015-01-22	13:17:57.416418	02:09:18	7758
2234	184	1	2	2015-01-22	13:17:57.416418	\N	\N	\N	\N
2233	186	1	2	2015-01-22	13:17:55.215318	2015-01-22	13:17:59.276147	00:00:04	4
2230	178	1	2	2015-01-22	13:17:50.750075	2015-01-22	13:18:00.599596	00:00:09	9
2224	179	1	2	2015-01-22	13:17:41.33351	2015-01-22	13:18:02.125121	00:00:20	20
2226	171	1	2	2015-01-22	13:17:44.741694	2015-01-22	13:18:03.516277	00:00:18	18
2225	177	1	2	2015-01-22	13:17:43.1667	2015-01-22	13:20:14.406652	00:02:31	151
2238	171	1	2	2015-01-22	13:18:03.516277	2015-01-22	13:20:23.237522	00:02:19	139
2311	189	1	1	2015-05-04	09:47:57.442471	2015-05-05	14:27:02.521392	15:00:00	54000
2228	176	1	2	2015-01-22	13:17:48.016811	2015-01-22	13:20:44.665453	00:02:56	176
2237	179	1	2	2015-01-22	13:18:02.125121	2015-01-22	13:20:59.82429	00:02:57	177
2236	178	1	2	2015-01-22	13:18:00.599596	2015-01-22	13:21:13.091006	00:03:12	192
2242	179	1	1	2015-01-22	13:20:59.82429	2015-01-22	13:21:21.724489	00:00:21	21
2229	189	1	2	2015-01-22	13:17:49.348859	2015-01-22	13:21:30.074235	00:03:40	220
2235	186	1	2	2015-01-22	13:17:59.276147	2015-01-22	13:21:38.357715	00:03:39	219
2074	174	1	1	2014-12-10	17:21:26.871982	2015-01-22	13:21:51.76584	15:00:00	54000
2245	189	1	1	2015-01-22	13:21:30.074235	2015-01-22	13:22:02.674233	00:00:32	32
2246	186	1	1	2015-01-22	13:21:38.357715	2015-01-22	13:22:10.465917	00:00:32	32
2247	174	1	1	2015-01-22	13:21:51.76584	2015-01-22	13:22:19.324248	00:00:27	27
2249	186	1	1	2015-01-22	13:22:10.465917	2015-01-22	13:31:51.81334	00:09:41	581
2250	174	1	1	2015-01-22	13:22:19.324248	2015-01-22	13:32:57.271709	00:10:37	637
2232	173	1	2	2015-01-22	13:17:53.833184	2015-01-22	14:07:37.959507	00:49:44	2984
2248	189	1	1	2015-01-22	13:22:02.674233	2015-01-23	09:57:33.222223	15:00:00	54000
2243	178	1	1	2015-01-22	13:21:13.091006	2015-05-05	14:27:24.62085	15:00:00	54000
2159	182	1	1	2015-01-14	12:33:26.533136	2015-01-22	13:22:29.199475	15:00:00	54000
2240	171	1	1	2015-01-22	13:20:23.237522	2015-01-22	13:30:30.022437	00:10:06	606
2256	186	1	1	2015-01-22	13:32:16.650707	2015-01-22	13:32:18.169315	00:00:01	1
2252	171	1	1	2015-01-22	13:30:30.022437	2015-01-22	14:13:28.759083	00:42:58	2578
2251	182	1	1	2015-01-22	13:22:29.199475	2015-01-23	09:56:48.030718	15:00:00	54000
2258	174	1	2	2015-01-22	13:32:57.271709	2015-01-23	09:57:02.770432	15:00:00	54000
2257	186	1	1	2015-01-22	13:32:18.169315	2015-01-23	09:57:13.803855	15:00:00	54000
2241	176	1	1	2015-01-22	13:20:44.665453	2015-05-04	10:36:52.036157	15:00:00	54000
2312	176	1	1	2015-05-04	10:36:52.036157	2015-05-05	14:00:21.015748	15:00:00	54000
2244	179	1	1	2015-01-22	13:21:21.724489	2015-05-05	14:26:28.646625	15:00:00	54000
2318	189	1	1	2015-05-05	14:27:02.521392	2015-05-05	14:57:02.521505	00:30:00	1800
2319	186	1	1	2015-05-05	14:27:16.61267	2015-05-05	18:22:44.836643	03:55:28	14128
2323	189	1	3	2015-05-05	18:20:12.57495	2015-05-05	18:23:08.5328	00:02:55	175
2325	189	1	3	2015-05-05	18:23:08.5328	2015-05-05	18:23:17.447499	00:00:08	8
2315	179	1	1	2015-05-05	14:26:28.646625	2015-05-06	08:59:06.982596	15:00:00	54000
2328	186	1	3	2015-05-06	09:02:06.817387	2015-05-06	09:02:12.00128	00:00:05	5
2329	186	1	1	2015-05-06	09:02:12.00128	2015-05-06	09:03:46.050459	00:01:34	94
2330	186	1	3	2015-05-06	09:03:46.050459	2015-05-06	09:03:50.651428	00:00:04	4
2331	186	1	1	2015-05-06	09:03:50.651428	2015-05-06	09:03:56.792217	00:00:06	6
2332	186	1	3	2015-05-06	09:03:56.792217	2015-05-06	09:04:07.040495	00:00:10	10
2320	178	1	1	2015-05-05	14:27:24.62085	2015-05-08	11:54:22.827487	15:00:00	54000
2333	186	1	1	2015-05-06	09:04:07.040495	2015-05-08	11:54:39.885209	15:00:00	54000
2337	186	1	2	2015-05-08	11:54:39.885209	2015-05-08	11:54:53.818526	00:00:13	13
2339	175	1	1	2015-05-08	11:55:09.009899	2015-05-12	17:39:49.448588	15:00:00	54000
2314	176	1	1	2015-05-05	14:26:07.995953	2015-05-12	17:40:09.422428	15:00:00	54000
2316	188	1	1	2015-05-05	14:26:39.363482	2015-05-12	17:40:14.964788	15:00:00	54000
2341	176	1	3	2015-05-12	17:40:09.422428	2015-05-14	10:58:53.704577	15:00:00	54000
2345	176	1	1	2015-05-14	10:58:53.704577	2015-05-14	10:59:08.773253	00:00:15	15
2338	186	1	1	2015-05-08	11:54:53.818526	2015-05-14	10:59:12.648121	15:00:00	54000
2335	189	1	1	2015-05-06	15:42:15.745337	2015-05-14	10:59:15.014997	15:00:00	54000
2327	179	1	1	2015-05-06	08:59:06.982596	2015-05-14	10:59:16.68029	15:00:00	54000
2350	189	1	2	2015-05-14	10:59:15.014997	2015-05-14	10:59:18.505104	00:00:03	3
2317	171	1	1	2015-05-05	14:26:53.196303	2015-05-14	10:59:20.296332	15:00:00	54000
2353	171	1	2	2015-05-14	10:59:20.296332	\N	\N	\N	\N
2351	179	1	2	2015-05-14	10:59:16.68029	2015-05-14	10:59:31.056539	00:00:14	14
2347	176	1	2	2015-05-14	10:59:08.773253	2015-05-14	10:59:41.60628	00:00:32	32
2346	188	1	2	2015-05-14	10:59:06.681806	2015-05-14	10:59:51.022541	00:00:44	44
2352	189	1	2	2015-05-14	10:59:18.505104	2015-05-14	11:00:24.512723	00:01:06	66
2253	172	1	1	2015-01-22	13:31:42.813914	2015-05-14	11:01:43.203999	15:00:00	54000
2348	175	1	2	2015-05-14	10:59:10.665244	2015-05-14	11:02:11.687535	00:03:01	181
2073	187	1	1	2014-12-10	16:08:09.882392	2015-05-14	11:03:09.453425	15:00:00	54000
2349	186	1	2	2015-05-14	10:59:12.648121	2015-05-14	11:04:06.669045	00:04:54	294
2355	176	1	1	2015-05-14	10:59:41.60628	2015-05-14	14:36:44.665475	03:37:03	13023
2366	187	1	1	2015-05-14	11:03:09.453425	2015-05-14	17:48:42.590016	06:45:33	24333
2372	187	1	3	2015-05-14	17:48:42.590016	2015-05-14	17:48:53.939969	00:00:11	11
2373	187	1	3	2015-05-14	17:48:53.939969	2015-05-14	17:49:24.019726	00:00:30	30
2365	170	1	1	2015-05-14	11:02:54.620138	2015-05-14	17:50:41.221155	06:47:46	24466
2377	170	1	3	2015-05-14	17:50:41.221155	2015-05-14	17:56:08.551459	00:05:27	327
2380	170	1	1	2015-05-14	17:56:08.551459	2015-05-14	17:56:10.950231	00:00:02	2
2381	170	1	3	2015-05-14	17:56:10.950231	2015-05-14	17:56:16.61621	00:00:05	5
2367	182	1	1	2015-05-14	11:03:49.644659	2015-05-14	17:58:30.43938	06:54:40	24880
2354	179	1	1	2015-05-14	10:59:31.056539	2015-05-14	17:59:37.507856	07:00:06	25206
2384	182	1	3	2015-05-14	17:58:30.43938	2015-05-14	18:03:29.057105	00:04:58	298
2362	172	1	1	2015-05-14	11:01:43.203999	2015-05-14	18:05:02.867916	07:03:19	25399
2388	172	1	3	2015-05-14	18:05:02.867916	2015-05-14	18:06:25.19097	00:01:22	82
2385	187	1	3	2015-05-14	17:59:21.997696	2015-05-14	18:06:35.277843	00:07:13	433
2383	170	1	1	2015-05-14	17:58:21.542715	2015-05-14	18:07:58.818231	00:09:37	577
2392	178	1	3	2015-05-14	18:08:56.079205	2015-05-14	18:09:16.896346	00:00:20	20
2391	170	1	3	2015-05-14	18:07:58.818231	2015-05-14	18:09:24.790394	00:01:25	85
2390	187	1	3	2015-05-14	18:06:35.277843	2015-05-14	18:09:31.31579	00:02:56	176
2387	182	1	3	2015-05-14	18:03:29.057105	2015-05-14	18:09:32.030288	00:06:02	362
2389	172	1	1	2015-05-14	18:06:25.19097	2015-05-14	18:09:34.402282	00:03:09	189
2363	175	1	1	2015-05-14	11:02:11.687535	2015-05-14	18:10:25.818856	07:08:14	25694
2397	172	1	3	2015-05-14	18:09:34.402282	2015-05-14	18:10:41.798346	00:01:07	67
2398	175	1	3	2015-05-14	18:10:25.818856	2015-05-14	18:10:42.4417	00:00:16	16
2396	182	1	1	2015-05-14	18:09:32.030288	2015-05-14	18:12:33.496477	00:03:01	181
2400	175	1	1	2015-05-14	18:10:42.4417	2015-05-14	18:12:43.939022	00:02:01	121
2403	175	1	3	2015-05-14	18:12:43.939022	2015-05-14	18:12:46.55883	00:00:02	2
2401	181	1	3	2015-05-14	18:11:16.807154	2015-05-14	18:12:49.94427	00:01:33	93
2402	182	1	3	2015-05-14	18:12:33.496477	2015-05-14	18:12:51.49666	00:00:18	18
2395	187	1	1	2015-05-14	18:09:31.31579	2015-05-14	18:13:24.111482	00:03:52	232
2404	175	1	1	2015-05-14	18:12:46.55883	2015-05-14	18:15:12.656281	00:02:26	146
2394	170	1	1	2015-05-14	18:09:24.790394	2015-05-14	18:16:13.49605	00:06:48	408
2406	182	1	1	2015-05-14	18:12:51.49666	2015-05-14	18:18:02.733886	00:05:11	311
2408	175	1	3	2015-05-14	18:15:12.656281	2015-05-14	18:18:42.957965	00:03:30	210
2407	187	1	3	2015-05-14	18:13:24.111482	2015-05-14	18:18:44.855174	00:05:20	320
2356	188	1	1	2015-05-14	10:59:51.022541	2015-05-21	15:26:42.518175	15:00:00	54000
2405	181	1	1	2015-05-14	18:12:49.94427	2015-05-25	15:32:43.956712	15:00:00	54000
2254	186	1	3	2015-01-22	13:31:51.81334	2015-01-22	13:32:05.131245	00:00:13	13
2255	186	1	3	2015-01-22	13:32:05.131245	2015-01-22	13:32:16.650707	00:00:11	11
2239	177	1	1	2015-01-22	13:20:14.406652	2015-01-22	14:03:18.090294	00:43:03	2583
2260	173	1	1	2015-01-22	14:07:37.959507	2015-01-22	14:07:53.267796	00:00:15	15
2259	177	1	1	2015-01-22	14:03:18.090294	2015-01-22	15:01:12.443742	00:57:54	3474
2263	177	1	1	2015-01-22	15:01:12.443742	2015-01-22	15:02:05.013813	00:00:52	52
2264	177	1	2	2015-01-22	15:02:05.013813	2015-01-23	09:48:25.118968	15:00:00	54000
2268	186	1	1	2015-01-23	09:57:13.803855	2015-01-23	09:57:49.312105	00:00:35	35
1934	183	1	1	2014-10-09	06:06:09.156401	2015-03-13	10:35:58.171897	15:00:00	54000
2265	177	1	1	2015-01-23	09:48:25.118968	2015-03-13	13:44:54.07761	15:00:00	54000
2262	171	1	1	2015-01-22	14:13:28.759083	2015-03-13	13:44:55.201043	15:00:00	54000
2272	177	1	3	2015-03-13	13:44:54.07761	2015-03-13	13:44:59.314388	00:00:05	5
2273	171	1	3	2015-03-13	13:44:55.201043	2015-03-13	13:45:00.27687	00:00:05	5
2266	182	1	1	2015-01-23	09:56:48.030718	2015-03-13	13:45:01.944928	15:00:00	54000
2267	174	1	1	2015-01-23	09:57:02.770432	2015-03-13	13:45:02.773196	15:00:00	54000
2274	177	1	1	2015-03-13	13:44:59.314388	2015-03-13	13:45:06.526058	00:00:07	7
2276	182	1	3	2015-03-13	13:45:01.944928	2015-03-13	14:31:56.427642	00:46:54	2814
2277	174	1	3	2015-03-13	13:45:02.773196	2015-03-13	14:31:57.325546	00:46:54	2814
2278	177	1	3	2015-03-13	13:45:06.526058	2015-03-13	14:31:58.018011	00:46:51	2811
2270	186	1	1	2015-01-23	09:57:49.312105	2015-03-16	12:37:57.812638	15:00:00	54000
2271	183	1	1	2015-03-13	10:35:58.171897	2015-03-16	12:40:00.678499	15:00:00	54000
2285	175	1	1	2015-03-16	12:40:23.487755	2015-03-16	12:40:43.945374	00:00:20	20
2275	171	1	1	2015-03-13	13:45:00.27687	2015-03-16	12:52:29.554996	15:00:00	54000
2286	175	1	1	2015-03-16	12:40:43.945374	2015-03-30	09:58:21.672028	15:00:00	54000
2283	186	1	2	2015-03-16	12:37:57.812638	2015-03-30	10:28:01.494367	15:00:00	54000
2269	189	1	1	2015-01-23	09:57:33.222223	2015-03-30	10:28:05.258524	15:00:00	54000
2287	171	1	1	2015-03-16	12:52:29.554996	2015-03-30	10:28:08.551728	15:00:00	54000
2281	177	1	1	2015-03-13	14:31:58.018011	2015-03-30	10:28:11.816353	15:00:00	54000
2288	175	1	2	2015-03-30	09:58:21.672028	2015-03-30	10:28:16.77753	00:29:55	1795
2279	182	1	1	2015-03-13	14:31:56.427642	2015-03-30	10:28:23.039622	15:00:00	54000
2291	171	1	2	2015-03-30	10:28:08.551728	2015-03-30	10:28:27.06188	00:00:18	18
2282	190	1	1	2015-03-16	10:21:13.888265	2015-03-30	10:28:30.964801	15:00:00	54000
2280	174	1	1	2015-03-13	14:31:57.325546	2015-03-30	10:28:33.770735	15:00:00	54000
2297	174	1	2	2015-03-30	10:28:33.770735	\N	\N	\N	\N
2292	177	1	2	2015-03-30	10:28:11.816353	2015-03-30	10:37:10.410974	00:08:58	538
2298	177	1	2	2015-03-30	10:37:10.410974	\N	\N	\N	\N
2296	190	1	2	2015-03-30	10:28:30.964801	2015-03-30	10:37:26.181096	00:08:55	535
2299	190	1	1	2015-03-30	10:37:26.181096	2015-04-10	14:24:21.414216	15:00:00	54000
2300	190	1	2	2015-04-10	14:24:21.414216	\N	\N	\N	\N
2301	188	1	1	2015-04-10	14:24:32.221032	2015-04-14	15:34:31.942214	15:00:00	54000
2261	173	1	2	2015-01-22	14:07:53.267796	2015-04-14	15:34:43.785087	15:00:00	54000
2303	173	1	1	2015-04-14	15:34:43.785087	2015-04-22	17:38:24.329976	15:00:00	54000
2304	173	1	3	2015-04-22	17:38:24.329976	2015-04-22	17:38:39.669153	00:00:15	15
2305	173	1	1	2015-04-22	17:38:39.669153	2015-04-22	17:38:47.915745	00:00:08	8
2165	181	1	2	2015-01-14	12:44:30.318957	2015-04-22	17:39:02.338891	15:00:00	54000
2290	189	1	2	2015-03-30	10:28:05.258524	2015-05-04	09:45:54.685952	15:00:00	54000
2307	181	1	1	2015-04-22	17:39:02.338891	2015-05-04	09:45:59.002581	15:00:00	54000
2313	176	1	3	2015-05-05	14:00:21.015748	2015-05-05	14:26:07.995953	00:25:46	1546
2302	188	1	2	2015-04-14	15:34:31.942214	2015-05-05	14:26:39.363482	15:00:00	54000
2295	171	1	2	2015-03-30	10:28:27.06188	2015-05-05	14:26:53.196303	15:00:00	54000
2289	186	1	2	2015-03-30	10:28:01.494367	2015-05-05	14:27:16.61267	15:00:00	54000
2321	189	1	2	2015-05-05	14:57:02.521505	2015-05-05	15:01:06.781431	00:04:04	244
2322	189	1	1	2015-05-05	15:01:06.781431	2015-05-05	18:20:12.57495	03:19:05	11945
2324	186	1	1	2015-05-05	18:22:44.836643	2015-05-06	09:02:06.817387	15:00:00	54000
2326	189	1	1	2015-05-05	18:23:17.447499	2015-05-06	15:05:39.191469	15:00:00	54000
2334	189	1	3	2015-05-06	15:05:39.191469	2015-05-06	15:42:15.745337	00:36:36	2196
2293	175	1	2	2015-03-30	10:28:16.77753	2015-05-08	11:55:09.009899	15:00:00	54000
2340	175	1	3	2015-05-12	17:39:49.448588	2015-05-12	18:03:04.798746	00:23:15	1395
2342	188	1	3	2015-05-12	17:40:14.964788	2015-05-12	18:03:12.6895	00:22:57	1377
2344	188	1	1	2015-05-12	18:03:12.6895	2015-05-14	10:59:06.681806	15:00:00	54000
2343	175	1	1	2015-05-12	18:03:04.798746	2015-05-14	10:59:10.665244	15:00:00	54000
2309	181	1	2	2015-05-04	09:45:59.002581	2015-05-14	11:00:43.14696	15:00:00	54000
2284	183	1	2	2015-03-16	12:40:00.678499	2015-05-14	11:00:53.538961	15:00:00	54000
2187	180	1	2	2015-01-14	15:33:52.563622	2015-05-14	11:01:07.329943	15:00:00	54000
2306	173	1	2	2015-04-22	17:38:47.915745	2015-05-14	11:01:26.179282	15:00:00	54000
2336	178	1	2	2015-05-08	11:54:22.827487	2015-05-14	11:02:21.537142	15:00:00	54000
2294	182	1	2	2015-03-30	10:28:23.039622	2015-05-14	11:03:49.644659	15:00:00	54000
2359	183	1	1	2015-05-14	11:00:53.538961	2015-05-14	12:45:35.918674	01:44:42	6282
2357	189	1	1	2015-05-14	11:00:24.512723	2015-05-14	14:36:35.932259	03:36:11	12971
2374	187	1	1	2015-05-14	17:49:24.019726	2015-05-14	17:49:36.832583	00:00:12	12
2375	187	1	3	2015-05-14	17:49:36.832583	2015-05-14	17:50:34.248021	00:00:57	57
2376	187	1	1	2015-05-14	17:50:34.248021	2015-05-14	17:53:10.90858	00:02:36	156
2378	187	1	3	2015-05-14	17:53:10.90858	2015-05-14	17:56:03.310311	00:02:52	172
2382	170	1	3	2015-05-14	17:56:16.61621	2015-05-14	17:58:21.542715	00:02:04	124
2379	187	1	1	2015-05-14	17:56:03.310311	2015-05-14	17:59:21.997696	00:03:18	198
2364	178	1	1	2015-05-14	11:02:21.537142	2015-05-14	18:08:56.079205	07:06:34	25594
2358	181	1	1	2015-05-14	11:00:43.14696	2015-05-14	18:11:16.807154	07:10:33	25833
2360	180	1	1	2015-05-14	11:01:07.329943	2015-05-25	17:01:36.526208	15:00:00	54000
2361	173	1	1	2015-05-14	11:01:26.179282	2015-07-15	13:27:34.807877	15:00:00	54000
2393	178	1	1	2015-05-14	18:09:16.896346	2015-05-14	18:17:08.348296	00:07:51	471
2368	186	1	1	2015-05-14	11:04:06.669045	2015-05-14	18:18:27.36674	07:14:20	26060
2410	178	1	3	2015-05-14	18:17:08.348296	2015-05-14	18:18:43.626218	00:01:35	95
2409	170	1	3	2015-05-14	18:16:13.49605	2015-05-14	18:18:44.246596	00:02:30	150
2411	182	1	3	2015-05-14	18:18:02.733886	2015-05-14	18:18:45.626018	00:00:42	42
2412	186	1	3	2015-05-14	18:18:27.36674	2015-05-14	18:18:46.195929	00:00:18	18
2415	170	1	1	2015-05-14	18:18:44.246596	2015-05-14	18:20:30.885297	00:01:46	106
2414	178	1	1	2015-05-14	18:18:43.626218	2015-05-20	10:50:02.297798	15:00:00	54000
2419	170	1	3	2015-05-14	18:20:30.885297	2015-05-20	10:51:56.520103	15:00:00	54000
2413	175	1	1	2015-05-14	18:18:42.957965	2015-06-25	09:57:40.299425	15:00:00	54000
2417	182	1	1	2015-05-14	18:18:45.626018	2015-06-25	09:57:52.532577	15:00:00	54000
2416	187	1	1	2015-05-14	18:18:44.855174	2015-06-25	09:57:53.938889	15:00:00	54000
2418	186	1	1	2015-05-14	18:18:46.195929	2015-07-15	13:27:36.738121	15:00:00	54000
2420	178	1	3	2015-05-20	10:50:02.297798	2015-05-20	10:50:52.003445	00:00:49	49
2421	178	1	1	2015-05-20	10:50:52.003445	2015-05-20	10:52:49.348316	00:01:57	117
2423	178	1	3	2015-05-20	10:52:49.348316	2015-05-20	17:15:01.451902	06:22:12	22932
2425	188	1	3	2015-05-21	15:26:42.518175	2015-05-21	17:42:14.551473	02:15:32	8132
2427		1	3	2015-05-25	15:30:17.942965	2015-05-25	15:30:39.258148	00:00:21	21
2386	179	1	3	2015-05-14	17:59:37.507856	2015-05-25	15:32:42.354651	15:00:00	54000
2370	189	1	2	2015-05-14	14:36:35.932259	2015-06-01	10:34:41.350072	15:00:00	54000
2432	189	1	1	2015-06-01	10:34:41.350072	2015-06-01	10:35:20.071238	00:00:38	38
2433	189	1	2	2015-06-01	10:35:20.071238	2015-06-01	10:35:44.651562	00:00:24	24
2429	179	1	3	2015-05-25	15:32:42.354651	2015-06-02	16:46:09.950845	15:00:00	54000
2431	180	1	3	2015-05-25	17:01:36.526208	2015-06-03	10:27:26.038737	15:00:00	54000
2437	175	1	2	2015-06-25	09:57:40.299425	\N	\N	\N	\N
2399	172	1	1	2015-05-14	18:10:41.798346	2015-06-25	09:57:42.450931	15:00:00	54000
2436	180	1	1	2015-06-03	10:27:26.038737	2015-06-25	09:57:50.741338	15:00:00	54000
2424	178	1	1	2015-05-20	17:15:01.451902	2015-06-25	09:57:58.586219	15:00:00	54000
2422	170	1	1	2015-05-20	10:51:56.520103	2015-06-25	09:57:59.268305	15:00:00	54000
2434	189	1	1	2015-06-01	10:35:44.651562	2015-07-11	09:34:32.200275	15:00:00	54000
2446	186	1	2	2015-07-15	13:27:36.738121	\N	\N	\N	\N
2426	188	1	1	2015-05-21	17:42:14.551473	2015-07-15	13:27:40.966228	15:00:00	54000
2444	189	1	3	2015-07-11	09:34:32.200275	2015-07-15	13:27:44.096412	15:00:00	54000
2443	170	1	3	2015-06-25	09:57:59.268305	2015-07-15	13:27:46.732345	15:00:00	54000
2449	170	1	2	2015-07-15	13:27:46.732345	\N	\N	\N	\N
2428		1	3	2015-05-25	15:30:39.258148	2015-08-05	14:38:46.76439	15:00:00	54000
2438	172	1	3	2015-06-25	09:57:42.450931	2015-08-05	14:39:11.502796	15:00:00	54000
2439	180	1	3	2015-06-25	09:57:50.741338	2015-08-05	14:39:13.157088	15:00:00	54000
2430	181	1	3	2015-05-25	15:32:43.956712	2015-08-05	14:39:14.266217	15:00:00	54000
2440	182	1	3	2015-06-25	09:57:52.532577	2015-08-05	14:39:15.532295	15:00:00	54000
2442	178	1	3	2015-06-25	09:57:58.586219	2015-08-05	14:39:16.829418	15:00:00	54000
2441	187	1	3	2015-06-25	09:57:53.938889	2015-08-05	14:39:19.334121	15:00:00	54000
2453	181	1	1	2015-08-05	14:39:14.266217	2015-08-05	14:41:12.486264	00:01:58	118
2457	181	1	1	2015-08-05	14:41:12.486264	2015-08-05	14:45:07.826152	00:03:55	235
2458	181	1	1	2015-08-05	14:45:07.826152	2015-08-05	14:46:45.284341	00:01:37	97
2451	172	1	1	2015-08-05	14:39:11.502796	2015-08-05	14:47:44.908208	00:08:33	513
2452	180	1	1	2015-08-05	14:39:13.157088	2015-08-05	14:47:46.381103	00:08:33	513
2454	182	1	1	2015-08-05	14:39:15.532295	2015-08-05	14:47:49.57069	00:08:34	514
2456	187	1	1	2015-08-05	14:39:19.334121	2015-08-05	14:47:50.808067	00:08:31	511
2455	178	1	1	2015-08-05	14:39:16.829418	2015-08-05	14:47:51.932006	00:08:35	515
2464	178	1	1	2015-08-05	14:47:51.932006	2015-08-05	14:48:57.750206	00:01:05	65
2465	178	1	2	2015-08-05	14:48:57.750206	\N	\N	\N	\N
2463	187	1	1	2015-08-05	14:47:50.808067	2015-08-05	14:49:00.15939	00:01:09	69
2466	187	1	2	2015-08-05	14:49:00.15939	\N	\N	\N	\N
2462	182	1	1	2015-08-05	14:47:49.57069	2015-08-05	14:49:02.042685	00:01:12	72
2467	182	1	2	2015-08-05	14:49:02.042685	\N	\N	\N	\N
2461	180	1	1	2015-08-05	14:47:46.381103	2015-08-05	14:49:03.841032	00:01:17	77
2460	172	1	1	2015-08-05	14:47:44.908208	2015-08-05	14:49:05.640231	00:01:20	80
2469	172	1	2	2015-08-05	14:49:05.640231	\N	\N	\N	\N
2459	181	1	1	2015-08-05	14:46:45.284341	2015-08-05	14:49:07.419693	00:02:22	142
2435	179	1	1	2015-06-02	16:46:09.950845	2015-08-05	14:49:11.401337	15:00:00	54000
2448	189	1	2	2015-07-15	13:27:44.096412	2015-08-05	14:49:13.229747	15:00:00	54000
2371	176	1	2	2015-05-14	14:36:44.665475	2015-08-05	14:49:25.730844	15:00:00	54000
2473	176	1	1	2015-08-05	14:49:25.730844	2015-08-05	14:53:31.285741	00:04:05	245
2470	181	1	2	2015-08-05	14:49:07.419693	2015-08-05	14:53:46.046693	00:04:38	278
2445	173	1	2	2015-07-15	13:27:34.807877	2015-08-05	14:59:30.904419	15:00:00	54000
2450		1	3	2015-08-05	14:38:46.76439	2015-08-05	15:00:43.85496	00:21:57	1317
2477		1	3	2015-08-05	15:00:43.85496	2015-08-05	15:01:43.312909	00:00:59	59
2478		1	3	2015-08-05	15:01:43.312909	\N	\N	\N	\N
2475	181	1	1	2015-08-05	14:53:46.046693	2015-08-05	15:13:37.793847	00:19:51	1191
2479	181	1	3	2015-08-05	15:13:37.793847	2015-08-05	15:20:13.149052	00:06:35	395
2480	181	1	1	2015-08-05	15:20:13.149052	2015-08-06	14:29:58.542345	15:00:00	54000
2481	181	1	2	2015-08-06	14:29:58.542345	\N	\N	\N	\N
2476	173	1	1	2015-08-05	14:59:30.904419	2015-08-06	14:30:00.478705	15:00:00	54000
2471	179	1	2	2015-08-05	14:49:11.401337	2015-08-06	14:30:18.901323	15:00:00	54000
2483	179	1	1	2015-08-06	14:30:18.901323	\N	\N	\N	\N
2474	176	1	2	2015-08-05	14:53:31.285741	2015-08-06	14:54:32.520462	15:00:00	54000
2447	188	1	2	2015-07-15	13:27:40.966228	2015-08-06	14:54:41.178121	15:00:00	54000
2485	188	1	1	2015-08-06	14:54:41.178121	\N	\N	\N	\N
2472	189	1	2	2015-08-05	14:49:13.229747	2015-08-06	14:54:57.794264	15:00:00	54000
2484	176	1	1	2015-08-06	14:54:32.520462	2015-08-06	15:03:55.902593	00:09:23	563
2487	176	1	1	2015-08-06	15:03:55.902593	\N	\N	\N	\N
2486	189	1	1	2015-08-06	14:54:57.794264	2015-08-06	15:09:00.414261	00:14:02	842
2488	189	1	1	2015-08-06	15:09:00.414261	\N	\N	\N	\N
2482	173	1	2	2015-08-06	14:30:00.478705	2015-08-06	15:11:33.897704	00:41:33	2493
2489	173	1	1	2015-08-06	15:11:33.897704	\N	\N	\N	\N
2468	180	1	2	2015-08-05	14:49:03.841032	2015-08-06	15:19:18.994052	15:00:00	54000
2490	180	1	1	2015-08-06	15:19:18.994052	\N	\N	\N	\N
\.


--
-- TOC entry 3155 (class 0 OID 0)
-- Dependencies: 293
-- Name: tb_estado_agente_id_estage_seq; Type: SEQUENCE SET; Schema: reportes; Owner: tintegro
--

SELECT pg_catalog.setval('tb_estado_agente_id_estage_seq', 2490, true);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 3044 (class 0 OID 67465)
-- Dependencies: 296
-- Data for Name: rolusu; Type: TABLE DATA; Schema: seguridad; Owner: tintegro
--

COPY rolusu (id_rolusu, no_rolusu, no_descri, il_activo) FROM stdin;
1	SuperAdmin	Administradores	t
10	reportes	reportes	t
11	Supervisor	Supervisor	t
12	Administrador	Administrador SI	t
13	prueba	prueba	t
\.


--
-- TOC entry 3156 (class 0 OID 0)
-- Dependencies: 295
-- Name: rolusu_id_rolusu_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: tintegro
--

SELECT pg_catalog.setval('rolusu_id_rolusu_seq', 13, true);


--
-- TOC entry 3045 (class 0 OID 67470)
-- Dependencies: 297
-- Data for Name: tbconecion; Type: TABLE DATA; Schema: seguridad; Owner: tintegro
--

COPY tbconecion (no_ipconex) FROM stdin;
172.26.98.10
172.26.98.10
\.


--
-- TOC entry 3047 (class 0 OID 67475)
-- Dependencies: 299
-- Data for Name: tcmodulo; Type: TABLE DATA; Schema: seguridad; Owner: tintegro
--

COPY tcmodulo (id_modulo, no_modulo, no_metexp, id_parent, il_activo, va_orden, no_url) FROM stdin;
8	Agentes	agenteController.prepareList	7	t	1	\N
54	Conferencia	tbMeetmeController.prepareList	53	t	1	\N
4	Usuarios SIP	sipBuddiesController.prepareList	3	t	1	\N
10	Ring Group	tbGrupoController.prepareList	9	t	1	\N
15	Colas	queuesController.prepareList	14	t	1	\N
38	Roles	rolusuController.prepareList	36	t	2	\N
42	Perifoneo	tbPerifoneoController.prepareList	41	t	1	\N
43	Musica Ambiental	tbMusicaController.prepareList	41	t	2	\N
46	Area y Centro de Costo	empresaAreaController.prepareList	45	t	1	\N
49	Subir Audio	tbMusholdController.prepareList	48	t	1	\N
28	Grabaciones de agentes	grabAgenteController.prepareList	26	t	1	\N
29	Grabaciones de extensiones	grabExtensionController.prepareList	26	t	2	\N
18	Asignacion a Colas	queuesController.prepareListSup	17	t	1	\N
12	Lista Negra	tbListaNegraController.prepareList	11	t	1	\N
52	Monitoreo Servidor	serverMonitorController.prepareMainPage	51	t	1	\N
6	Usuarios	tbUsuarioController.prepareList	5	t	1	\N
61	IVR	tbAppivrController.prepareList	60	t	1	\N
62	Subir Audio Ivr	tbAppivrController.prepareUpload	60	t	2	\N
63	Monitoreo Servicios	serverMonitorController.prepareServicios	51	t	2	\N
64	Fecha y Hora	serverMonitorController.prepareFechaHora	51	t	3	\N
58	Troncales	tbtroncalController.prepareList	57	t	1	\N
67	Rutas Salientes	tbrutaSalientesController.prepareList	65	t	20	\N
32	Llamadas por Hora	llamadaDiaHoraController.prepareList	69	t	7	\N
33	Conexion por Estados	estadoAgenteController.prepareList	69	t	8	\N
34	Llamadas Generales	llamadaGeneralController.prepareList	25	t	1	\N
21	Ranking de Llamadas	llamadaUsuarioTopController.prepareList	25	t	5	\N
56	Usuarios IAX	iaxBuddiesController.prepareList	3	t	2	\N
44	Centro de Costos	areaLlamadaTopController.prepareCenCostoList	25	t	12	\N
47	Areas	areaLlamadaTopController.prepareList	25	t	10	\N
20	Llamadas por Usuario	llamadaUsuarioController.prepareList	25	t	3	\N
27	Atencion al Cliente	respuestaOperadorController.prepareList	69	t	1	\N
31	Llamadas contestadas	llamadaContestadaController.prepareList	69	t	2	\N
13	Reporte de abandonos	reporteAbandonosController.prepareList	69	t	4	\N
30	Llamadas de Agentes	llamadaAgenteController.prepareList	69	t	3	\N
66	Contextos	tbcontextoController.prepareList	65	t	10	\N
50	Produccion Agente	llamadaConsolidadosController.prepareList	25	\N	12	\N
68	Llamadas Consolidadas Agentes	llamadaConsolidadosController.prepareList	69	t	14	\N
73	Consolidado Llamadas Recibidas	consolidadoLlamadasRecibidasController.prepareList	69	t	21	\N
75	Llamadas Entrantes x Hora	llamadasEntrantesxHoraController.prepareList	69	t	23	\N
74	Llamadas Atendidas y Abandonadas	llamadaAtendidaAbandonadasController.prepareList	69	t	22	\N
76	Consolidado de Tiempos de Espera	consolidadoLlamadasRecibidasController.prepareListT	69	t	24	\N
77	Consolidado Llamada Abandonadas x Minuto	llamadasEntrantesxHoraController.prepareListMin	69	t	25	\N
78	Monitoreo Sip	sipBuddiesController.prepareListSip	3	t	4	\N
79	Llamadas Atendidas y Abandonadas F	llamadasEntrantesxHoraController.prepareListMinFecha	69	t	26	\N
82	Llamadas Abandonadas	rptLlamadasAbandonadasController.prepareList	81	t	1	\N
36	Seguridad		\N	t	500	\N
85	Niveles de Servicio	rptNivelesServiciosController.prepareList	81	t	4	\N
40	Gestion de Agentes	queueMemberTableController.prepareList	7	t	4	\N
83	Comparativo de Colas	rptComparativaColasController.prepareList	81	t	2	\N
84	Comparativo de Abandonos	rptComparativaAbandonosController.prepareList	81	t	3	\N
86	Datos Monitoreo Colas	queueDatosCallController.prepareList	14	t	6	\N
80	Monitoreo Colas Java	queuesController.showMonitoreoTiempoRealJava	14	t	5	\N
88	Marca	tcmarcaController.prepareList	87	t	1	\N
89	Modelo	tcmodeloController.prepareList	87	t	2	\N
90	Sip Aprov.	sipBuddiesAprovController.prepareList	87	t	3	\N
39	Cambiar Password	usuariController.changePass	36	t	3	\N
59	Monitoreo de Colas	queuesController.showMonitoreoTiempoReal	14	t	2	\N
11	Lista Negra		\N	t	60	\N
24	Monitoreo en Tiempo Real		22	t	2	\N
19	Supervision de Agentes	agenteController.prepareSuperv	7	f	3	\N
2	Archivos de configuracion		1	t	1	\N
1	Configuracion		\N	t	10	\N
22	Monitoreo		\N	t	90	\N
51	Servidor		\N	t	400	\N
3	Anexos		\N	t	20	\N
35	Cambiar Password		\N	t	\N	\N
81	Reporte Graficos		\N	t	13	\N
23	Actualizacion		22	t	1	\N
41	Perifoneo-Musica A.		\N	t	220	\N
53	Conferencia		\N	t	170	\N
26	Grabaciones		\N	t	210	\N
9	Grupos de Llamadas		\N	t	50	\N
45	Empresa		\N	t	40	\N
87	Mantenimiento		\N	t	3	\N
48	Music on hold		\N	t	280	\N
17	Supervision de Colas		\N	t	320	\N
16	Gestion Agentes	queueMembersController.prepareList	7	f	2	\N
14	Colas		\N	t	310	\N
57	Troncales		\N	t	250	\N
65	Plan de Marcacion		\N	t	270	\N
60	IVR		\N	t	260	\N
7	Agentes		\N	t	300	\N
69	Reportes CallCenter		\N	t	330	\N
25	Reportes Llamadas		\N	t	200	\N
5	Usuarios		\N	t	30	\N
37	Usuario de Administracion	usuariController.prepareList	36	t	1	/faces/seguridad/usuari/List.xhtml
\.


--
-- TOC entry 3157 (class 0 OID 0)
-- Dependencies: 298
-- Name: tcmodulo_id_modulo_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: tintegro
--

SELECT pg_catalog.setval('tcmodulo_id_modulo_seq', 90, true);


--
-- TOC entry 3048 (class 0 OID 67483)
-- Dependencies: 300
-- Data for Name: tcmodulo_rolusu; Type: TABLE DATA; Schema: seguridad; Owner: tintegro
--

COPY tcmodulo_rolusu (id_rolusu, id_modulo) FROM stdin;
1	36
1	37
1	38
1	31
1	17
1	53
1	43
1	29
1	21
1	10
1	4
1	14
1	52
1	8
1	27
1	46
1	19
1	51
1	11
1	57
1	56
1	7
1	9
1	12
1	58
1	44
1	32
1	41
1	5
1	33
1	50
1	54
1	48
1	47
1	49
1	40
1	15
1	3
1	13
1	45
1	20
1	42
1	18
1	25
1	34
1	39
1	6
1	26
10	68
10	44
10	25
10	21
10	47
10	34
10	20
1	61
10	29
10	26
1	68
11	14
11	26
11	32
11	34
11	25
11	21
11	59
11	29
11	7
11	31
1	59
1	62
1	60
11	20
11	13
11	40
11	69
11	27
11	33
11	68
10	13
10	33
10	31
10	69
10	32
10	27
1	16
1	63
1	64
12	52
12	17
12	36
12	37
12	33
12	31
12	27
12	47
12	69
12	5
12	40
12	59
12	12
12	8
12	13
12	6
12	11
12	32
12	15
12	14
12	4
12	68
12	20
12	26
12	21
12	46
12	7
12	25
12	29
12	63
12	16
12	34
12	45
12	51
12	44
12	18
12	3
12	64
11	76
11	74
11	75
11	73
11	77
1	74
1	76
1	75
1	73
1	77
10	77
10	76
10	74
10	75
10	73
12	73
12	76
12	75
12	77
12	74
1	69
1	65
1	67
1	28
1	30
1	66
1	78
1	79
1	80
1	81
1	82
1	83
1	84
1	85
1	86
13	3
13	4
13	25
13	34
13	21
13	47
13	44
13	50
13	20
1	87
1	88
1	89
1	90
\.


--
-- TOC entry 2930 (class 0 OID 66929)
-- Dependencies: 182
-- Data for Name: usuari; Type: TABLE DATA; Schema: seguridad; Owner: tintegro
--

COPY usuari (id_usuari, no_login, no_passwo, no_nombre, no_apelli, no_email, no_profe, id_rolusu, il_activo, fe_creaci) FROM stdin;
13	jlatorre	9c8a461426a35ad8174750b8f5a5b748	Jenny	La Torre Lazarte	essaludenlinea.cusco@essalud.gob.pe	Supervisor	11	t	2014-08-19
15	fsantacruz	299a2a65d2bf2f7ed89874c2fc2fad79	Fernando	Santa Cruz	fernando.santacruz@essalud.gob.pe		12	t	2014-08-19
16	Alberto	fa657f4d772ac648a8408474a0f8d504	Luis Alberto	Astete Luna	luis.astete@essalud.gob.pe		12	t	2014-08-20
14	inunez	96be35715459112775cdd0f17f03d9aa	Ivonne	Nunez	essaludenlinea.cusco@essalud.gob.pe	Supervisor	11	t	2014-08-19
17	supervisor	09348c20a019be0318387c08df7a783d	supervisor	supervisor	supervisor	supervisor	11	t	2014-11-05
19	Usuario	81dc9bdb52d04dc20036dbd8313ed055	Jorge	Garcia	Jorge@mail.com		13	t	2015-03-13
20	repo	89bb6900736548ebd6455d0ab07aa5fe	repo	repo	repo@repo.repo	repo	10	t	2015-03-25
21	julio	c027636003b468821081e281758e35ff	julio	julio	julio	julio	1	t	2016-12-01
1	admin	e10adc3949ba59abbe56e057f20f883e	ADMIN	ADMINISTRADOR	jtito@t-contacta.com	administrador	1	t	2012-10-22
\.


--
-- TOC entry 3158 (class 0 OID 0)
-- Dependencies: 181
-- Name: usuari_id_usuari_seq; Type: SEQUENCE SET; Schema: seguridad; Owner: tintegro
--

SELECT pg_catalog.setval('usuari_id_usuari_seq', 21, true);


SET search_path = asterisk, pg_catalog;

--
-- TOC entry 2654 (class 2606 OID 70133)
-- Name: agente_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente
    ADD CONSTRAINT agente_pkey PRIMARY KEY (id_agente);


--
-- TOC entry 2656 (class 2606 OID 70135)
-- Name: agente_por_cola_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente_por_cola
    ADD CONSTRAINT agente_por_cola_pkey PRIMARY KEY (id_agecola, id_cola);


--
-- TOC entry 2659 (class 2606 OID 70137)
-- Name: campana_id_pk; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY campana
    ADD CONSTRAINT campana_id_pk PRIMARY KEY (id_campan);


--
-- TOC entry 2661 (class 2606 OID 70139)
-- Name: cdr_id_pk; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY cdr
    ADD CONSTRAINT cdr_id_pk PRIMARY KEY (id);


--
-- TOC entry 2664 (class 2606 OID 70141)
-- Name: empresa_area_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY empresa_area
    ADD CONSTRAINT empresa_area_pkey PRIMARY KEY (id_empare);


--
-- TOC entry 2666 (class 2606 OID 70143)
-- Name: extensions_table_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY extensions_table
    ADD CONSTRAINT extensions_table_pkey PRIMARY KEY (id_extens);


--
-- TOC entry 2668 (class 2606 OID 70145)
-- Name: file_astersik_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY file_astersik
    ADD CONSTRAINT file_astersik_pkey PRIMARY KEY (nombre);


--
-- TOC entry 2670 (class 2606 OID 70147)
-- Name: iax_buddies_pkey1; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_buddies
    ADD CONSTRAINT iax_buddies_pkey1 PRIMARY KEY (id_iaxbud);


--
-- TOC entry 2672 (class 2606 OID 70149)
-- Name: iax_dialplan_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_dialplan
    ADD CONSTRAINT iax_dialplan_pkey PRIMARY KEY (id_iaxdia);


--
-- TOC entry 2674 (class 2606 OID 70151)
-- Name: iax_ip_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_ip
    ADD CONSTRAINT iax_ip_pkey PRIMARY KEY (id_iaxip);


--
-- TOC entry 2676 (class 2606 OID 70153)
-- Name: iax_red_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_red
    ADD CONSTRAINT iax_red_pkey PRIMARY KEY (id_iaxred);


--
-- TOC entry 2678 (class 2606 OID 70155)
-- Name: iax_trunk_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_trunk
    ADD CONSTRAINT iax_trunk_pkey PRIMARY KEY (id_iaxtru);


--
-- TOC entry 2762 (class 2606 OID 70157)
-- Name: id_rut_trom; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcrutde_tron
    ADD CONSTRAINT id_rut_trom PRIMARY KEY (id_rutdet, id_troncal);


--
-- TOC entry 2710 (class 2606 OID 70159)
-- Name: pk_bolsa_usuario; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsausuario
    ADD CONSTRAINT pk_bolsa_usuario PRIMARY KEY (id_usuari, id_tiptel, id_clave, fe_inibol);


--
-- TOC entry 2708 (class 2606 OID 70161)
-- Name: pk_bolsamepresa; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsaempresa
    ADD CONSTRAINT pk_bolsamepresa PRIMARY KEY (id_empare, id_tiptel, id_clave, fe_inibol);


--
-- TOC entry 2724 (class 2606 OID 70163)
-- Name: pk_id_meetme; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_meetme
    ADD CONSTRAINT pk_id_meetme PRIMARY KEY (id_meetme);


--
-- TOC entry 2746 (class 2606 OID 70165)
-- Name: pk_id_meetvar; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_meetmevar
    ADD CONSTRAINT pk_id_meetvar PRIMARY KEY (id_meetmevar);


--
-- TOC entry 2682 (class 2606 OID 70167)
-- Name: pk_queue_members_table; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_member_table
    ADD CONSTRAINT pk_queue_members_table PRIMARY KEY (uniqueid);


--
-- TOC entry 2706 (class 2606 OID 70169)
-- Name: pk_tb_auxcall; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_auxcallcenter
    ADD CONSTRAINT pk_tb_auxcall PRIMARY KEY (callid);


--
-- TOC entry 2680 (class 2606 OID 70171)
-- Name: queue_datos_call_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_datos_call
    ADD CONSTRAINT queue_datos_call_pkey PRIMARY KEY (id_datos);


--
-- TOC entry 2684 (class 2606 OID 70173)
-- Name: queue_interface; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_member_table
    ADD CONSTRAINT queue_interface UNIQUE (queue_name, interface);


--
-- TOC entry 2686 (class 2606 OID 70175)
-- Name: queue_members_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_members
    ADD CONSTRAINT queue_members_pkey PRIMARY KEY (id_queuem);


--
-- TOC entry 2688 (class 2606 OID 70177)
-- Name: queue_por_campana_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_por_campana
    ADD CONSTRAINT queue_por_campana_pkey PRIMARY KEY (id_queues, id_campan);


--
-- TOC entry 2690 (class 2606 OID 70179)
-- Name: queue_strategy_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_strategy
    ADD CONSTRAINT queue_strategy_pkey PRIMARY KEY (no_strategy);


--
-- TOC entry 2694 (class 2606 OID 70181)
-- Name: queues_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queues
    ADD CONSTRAINT queues_pkey PRIMARY KEY (id_queues);


--
-- TOC entry 2692 (class 2606 OID 70183)
-- Name: queues_prikey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_table
    ADD CONSTRAINT queues_prikey PRIMARY KEY (name);


--
-- TOC entry 2698 (class 2606 OID 70185)
-- Name: sip_buddies_aprov_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_buddies_aprov
    ADD CONSTRAINT sip_buddies_aprov_pkey PRIMARY KEY (id_aprov, id_sip);


--
-- TOC entry 2696 (class 2606 OID 70187)
-- Name: sip_buddies_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_buddies
    ADD CONSTRAINT sip_buddies_pkey PRIMARY KEY (id_sip);


--
-- TOC entry 2700 (class 2606 OID 70189)
-- Name: sip_trunk_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_trunk
    ADD CONSTRAINT sip_trunk_pkey PRIMARY KEY (id_siptru);


--
-- TOC entry 2702 (class 2606 OID 70191)
-- Name: tb_appivr_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_appivr
    ADD CONSTRAINT tb_appivr_pkey PRIMARY KEY (id_appivr);


--
-- TOC entry 2704 (class 2606 OID 70193)
-- Name: tb_aprovis_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_aprovis
    ADD CONSTRAINT tb_aprovis_pkey PRIMARY KEY (id_aprovis);


--
-- TOC entry 2712 (class 2606 OID 70195)
-- Name: tb_contexto_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_contexto
    ADD CONSTRAINT tb_contexto_pkey PRIMARY KEY (id_contexto);


--
-- TOC entry 2714 (class 2606 OID 70197)
-- Name: tb_extensionxgrupo_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxgrupo
    ADD CONSTRAINT tb_extensionxgrupo_pkey PRIMARY KEY (id_grupo, id_exten);


--
-- TOC entry 2716 (class 2606 OID 70199)
-- Name: tb_extensionxperifo_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxperifo
    ADD CONSTRAINT tb_extensionxperifo_pkey PRIMARY KEY (id_perifo, id_extens);


--
-- TOC entry 2718 (class 2606 OID 70201)
-- Name: tb_grupo_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_grupo
    ADD CONSTRAINT tb_grupo_pkey PRIMARY KEY (id_grupo);


--
-- TOC entry 2720 (class 2606 OID 70203)
-- Name: tb_ivrdet_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_ivrdet
    ADD CONSTRAINT tb_ivrdet_pkey PRIMARY KEY (id_ivrdet);


--
-- TOC entry 2722 (class 2606 OID 70205)
-- Name: tb_lista_negra_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_lista_negra
    ADD CONSTRAINT tb_lista_negra_pkey PRIMARY KEY (nu_telefo);


--
-- TOC entry 2726 (class 2606 OID 70207)
-- Name: tb_mushold_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_mushold
    ADD CONSTRAINT tb_mushold_pkey PRIMARY KEY (id_mushold);


--
-- TOC entry 2728 (class 2606 OID 70209)
-- Name: tb_musica_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_musica
    ADD CONSTRAINT tb_musica_pkey PRIMARY KEY (id_musica);


--
-- TOC entry 2730 (class 2606 OID 70211)
-- Name: tb_perifoneo_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_perifoneo
    ADD CONSTRAINT tb_perifoneo_pkey PRIMARY KEY (id_perifo);


--
-- TOC entry 2732 (class 2606 OID 70213)
-- Name: tb_pin_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_pin
    ADD CONSTRAINT tb_pin_pkey PRIMARY KEY (id_usupin, id_tiptel, id_clave);


--
-- TOC entry 2786 (class 2606 OID 70673)
-- Name: tb_sip_telefono_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_sip_telefono
    ADD CONSTRAINT tb_sip_telefono_pkey PRIMARY KEY (id_sip_telefono);


--
-- TOC entry 2734 (class 2606 OID 70217)
-- Name: tb_troncal_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_troncal
    ADD CONSTRAINT tb_troncal_pkey PRIMARY KEY (id_troncal);


--
-- TOC entry 2736 (class 2606 OID 70219)
-- Name: tb_usuario_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuari);


--
-- TOC entry 2738 (class 2606 OID 70221)
-- Name: tbruta_salientes_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tbruta_salientes
    ADD CONSTRAINT tbruta_salientes_pkey PRIMARY KEY (id_rutsal);


--
-- TOC entry 2740 (class 2606 OID 70223)
-- Name: tc_accion_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_accion
    ADD CONSTRAINT tc_accion_pkey PRIMARY KEY (id_accion);


--
-- TOC entry 2742 (class 2606 OID 70225)
-- Name: tc_clave_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_clave
    ADD CONSTRAINT tc_clave_pkey PRIMARY KEY (id_clave);


--
-- TOC entry 2744 (class 2606 OID 70227)
-- Name: tc_estado_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_estado
    ADD CONSTRAINT tc_estado_pkey PRIMARY KEY (id_estage);


--
-- TOC entry 2748 (class 2606 OID 70229)
-- Name: tc_tipcamana_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_tipcampana
    ADD CONSTRAINT tc_tipcamana_pkey PRIMARY KEY (id_tipcam);


--
-- TOC entry 2750 (class 2606 OID 70231)
-- Name: tc_tipotelefono_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_tipotelefono
    ADD CONSTRAINT tc_tipotelefono_pkey PRIMARY KEY (id_tiptel);


--
-- TOC entry 2752 (class 2606 OID 70233)
-- Name: tcdialopc_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcdialopc
    ADD CONSTRAINT tcdialopc_pkey PRIMARY KEY (id_dialopc);


--
-- TOC entry 2754 (class 2606 OID 70235)
-- Name: tcmarca_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcmarca
    ADD CONSTRAINT tcmarca_pkey PRIMARY KEY (id_marca);


--
-- TOC entry 2756 (class 2606 OID 70237)
-- Name: tcmodelo_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcmodelo
    ADD CONSTRAINT tcmodelo_pkey PRIMARY KEY (id_modelo);


--
-- TOC entry 2758 (class 2606 OID 70239)
-- Name: tcopcivr_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcopcivr
    ADD CONSTRAINT tcopcivr_pkey PRIMARY KEY (id_opcivr);


--
-- TOC entry 2760 (class 2606 OID 70241)
-- Name: tcruta_detalle_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcruta_detalle
    ADD CONSTRAINT tcruta_detalle_pkey PRIMARY KEY (id_rutdet);


--
-- TOC entry 2764 (class 2606 OID 70243)
-- Name: tcservicio_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcservicio
    ADD CONSTRAINT tcservicio_pkey PRIMARY KEY (id_servicio);


--
-- TOC entry 2766 (class 2606 OID 70245)
-- Name: tctipllam_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tctipllam
    ADD CONSTRAINT tctipllam_pkey PRIMARY KEY (id_tipllam);


--
-- TOC entry 2768 (class 2606 OID 70247)
-- Name: tctiptel_clave_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tctiptel_clave
    ADD CONSTRAINT tctiptel_clave_pkey PRIMARY KEY (id_tiptel, id_clave);


--
-- TOC entry 2770 (class 2606 OID 70249)
-- Name: usuarioxarea_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY usuarioxarea
    ADD CONSTRAINT usuarioxarea_pkey PRIMARY KEY (id_usuari, id_empare);


--
-- TOC entry 2772 (class 2606 OID 70251)
-- Name: voicemail_users_pkey; Type: CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY voicemail_users
    ADD CONSTRAINT voicemail_users_pkey PRIMARY KEY (uniqueid);


SET search_path = public, pg_catalog;

--
-- TOC entry 2774 (class 2606 OID 70253)
-- Name: tc_activo_pkey; Type: CONSTRAINT; Schema: public; Owner: tintegro
--

ALTER TABLE ONLY tc_estado
    ADD CONSTRAINT tc_activo_pkey PRIMARY KEY (id_estado);


SET search_path = reportes, pg_catalog;

--
-- TOC entry 2776 (class 2606 OID 70255)
-- Name: tb_detalle_llamada_pkey; Type: CONSTRAINT; Schema: reportes; Owner: tintegro
--

ALTER TABLE ONLY tb_detalle_llamada
    ADD CONSTRAINT tb_detalle_llamada_pkey PRIMARY KEY (id_llamada);


--
-- TOC entry 2778 (class 2606 OID 70257)
-- Name: tb_estagente_pkey; Type: CONSTRAINT; Schema: reportes; Owner: tintegro
--

ALTER TABLE ONLY tb_estado_agente
    ADD CONSTRAINT tb_estagente_pkey PRIMARY KEY (id_estage);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 2780 (class 2606 OID 70259)
-- Name: rolusu_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY rolusu
    ADD CONSTRAINT rolusu_pkey PRIMARY KEY (id_rolusu);


--
-- TOC entry 2782 (class 2606 OID 70261)
-- Name: tcmodulo_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY tcmodulo
    ADD CONSTRAINT tcmodulo_pkey PRIMARY KEY (id_modulo);


--
-- TOC entry 2784 (class 2606 OID 70263)
-- Name: tcmodulo_rolusu_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY tcmodulo_rolusu
    ADD CONSTRAINT tcmodulo_rolusu_pkey PRIMARY KEY (id_rolusu, id_modulo);


--
-- TOC entry 2650 (class 2606 OID 70265)
-- Name: usuari_no_login_ukey; Type: CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY usuari
    ADD CONSTRAINT usuari_no_login_ukey UNIQUE (no_login);


--
-- TOC entry 2652 (class 2606 OID 70267)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY usuari
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuari);


SET search_path = asterisk, pg_catalog;

--
-- TOC entry 2662 (class 1259 OID 70268)
-- Name: cdr_idx; Type: INDEX; Schema: asterisk; Owner: tintegro
--

CREATE INDEX cdr_idx ON cdr USING btree (uniqueid);


--
-- TOC entry 2657 (class 1259 OID 70269)
-- Name: queue_log_idxqname; Type: INDEX; Schema: asterisk; Owner: tintegro
--

CREATE INDEX queue_log_idxqname ON callcenter USING btree (queuename, "time");


--
-- TOC entry 2834 (class 2620 OID 70649)
-- Name: actualiza_fechaqueues; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER actualiza_fechaqueues
    AFTER INSERT ON queue_member_table
    FOR EACH ROW
    EXECUTE PROCEDURE update_fechaqueues();


--
-- TOC entry 2842 (class 2620 OID 70651)
-- Name: actualiza_usuario; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER actualiza_usuario
    AFTER UPDATE ON tb_usuario
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_usuario();


--
-- TOC entry 2840 (class 2620 OID 70652)
-- Name: actualiza_usuario_bolsa; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER actualiza_usuario_bolsa
    AFTER INSERT OR DELETE OR UPDATE ON tb_bolsausuario
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_usuario_bolsa();


--
-- TOC entry 2831 (class 2620 OID 70653)
-- Name: callcenter_actualiza; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER callcenter_actualiza
    BEFORE INSERT ON callcenter
    FOR EACH ROW
    EXECUTE PROCEDURE public.actualiza_callcenter();


--
-- TOC entry 2833 (class 2620 OID 70654)
-- Name: cdr; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER cdr
    AFTER INSERT OR UPDATE ON cdr
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_usuario_cdr();


--
-- TOC entry 2832 (class 2620 OID 70655)
-- Name: ingresa_auxiliarcallcenter; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER ingresa_auxiliarcallcenter
    AFTER INSERT ON callcenter
    FOR EACH ROW
    EXECUTE PROCEDURE public.ingresa_auxiliarcallcenter();


--
-- TOC entry 2836 (class 2620 OID 70656)
-- Name: sip_buddies_insert_tr; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER sip_buddies_insert_tr
    AFTER INSERT ON sip_buddies
    FOR EACH ROW
    EXECUTE PROCEDURE sip_buddies_insert();


--
-- TOC entry 2837 (class 2620 OID 70657)
-- Name: sip_buddies_tr; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER sip_buddies_tr
    AFTER UPDATE ON sip_buddies
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_agente();


--
-- TOC entry 2838 (class 2620 OID 70658)
-- Name: sip_buddies_tr1; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER sip_buddies_tr1
    AFTER DELETE ON sip_buddies
    FOR EACH ROW
    EXECUTE PROCEDURE elimina_sip_buddies();


--
-- TOC entry 2841 (class 2620 OID 70659)
-- Name: tr_act_meetme; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER tr_act_meetme
    AFTER INSERT OR UPDATE ON tb_meetme
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_var_meetme();


--
-- TOC entry 2830 (class 2620 OID 70660)
-- Name: tr_actualiza_eliminacion_agente; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER tr_actualiza_eliminacion_agente
    AFTER UPDATE ON agente
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_usuario_eliminado();


--
-- TOC entry 2839 (class 2620 OID 70661)
-- Name: tr_actualiza_error; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER tr_actualiza_error
    AFTER UPDATE ON sip_buddies
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_usuario_errado();


--
-- TOC entry 2835 (class 2620 OID 70662)
-- Name: tr_update_queuemembers; Type: TRIGGER; Schema: asterisk; Owner: tintegro
--

CREATE TRIGGER tr_update_queuemembers
    AFTER INSERT ON queue_members
    FOR EACH ROW
    EXECUTE PROCEDURE update_queuemembers();


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 2829 (class 2620 OID 70663)
-- Name: actualiza_password; Type: TRIGGER; Schema: seguridad; Owner: tintegro
--

CREATE TRIGGER actualiza_password
    BEFORE INSERT OR UPDATE ON usuari
    FOR EACH ROW
    EXECUTE PROCEDURE actualiza_password();


SET search_path = asterisk, pg_catalog;

--
-- TOC entry 2788 (class 2606 OID 70270)
-- Name: agente_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente
    ADD CONSTRAINT agente_fk FOREIGN KEY (nu_accion) REFERENCES tc_accion(id_accion);


--
-- TOC entry 2789 (class 2606 OID 70275)
-- Name: agente_fk1; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente
    ADD CONSTRAINT agente_fk1 FOREIGN KEY (co_estado) REFERENCES tc_estado(id_estage);


--
-- TOC entry 2790 (class 2606 OID 70280)
-- Name: agente_por_cola_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente_por_cola
    ADD CONSTRAINT agente_por_cola_fk FOREIGN KEY (id_agecola) REFERENCES agente(id_agente) ON DELETE CASCADE;


--
-- TOC entry 2791 (class 2606 OID 70285)
-- Name: agente_por_cola_fk1; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY agente_por_cola
    ADD CONSTRAINT agente_por_cola_fk1 FOREIGN KEY (id_cola) REFERENCES queues(id_queues) ON DELETE CASCADE;


--
-- TOC entry 2792 (class 2606 OID 70290)
-- Name: campana_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY campana
    ADD CONSTRAINT campana_fk FOREIGN KEY (ti_campan) REFERENCES tc_tipcampana(id_tipcam);


--
-- TOC entry 2801 (class 2606 OID 70295)
-- Name: fk_id_empare; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsaempresa
    ADD CONSTRAINT fk_id_empare FOREIGN KEY (id_empare) REFERENCES empresa_area(id_empare) ON DELETE CASCADE;


--
-- TOC entry 2802 (class 2606 OID 70300)
-- Name: fk_id_tiptel_clave; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsaempresa
    ADD CONSTRAINT fk_id_tiptel_clave FOREIGN KEY (id_tiptel, id_clave) REFERENCES tctiptel_clave(id_tiptel, id_clave) ON DELETE CASCADE;


--
-- TOC entry 2803 (class 2606 OID 70305)
-- Name: fk_id_tiptel_clave; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsausuario
    ADD CONSTRAINT fk_id_tiptel_clave FOREIGN KEY (id_tiptel, id_clave) REFERENCES tctiptel_clave(id_tiptel, id_clave) ON DELETE CASCADE;


--
-- TOC entry 2804 (class 2606 OID 70310)
-- Name: fk_id_usuari; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_bolsausuario
    ADD CONSTRAINT fk_id_usuari FOREIGN KEY (id_usuari) REFERENCES tb_usuario(id_usuari) ON DELETE CASCADE;


--
-- TOC entry 2793 (class 2606 OID 70330)
-- Name: iax_dialplan_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_dialplan
    ADD CONSTRAINT iax_dialplan_fk FOREIGN KEY (id_iaxtru) REFERENCES iax_trunk(id_iaxtru);


--
-- TOC entry 2794 (class 2606 OID 70335)
-- Name: iax_ip_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_ip
    ADD CONSTRAINT iax_ip_fk FOREIGN KEY (id_iaxbud) REFERENCES iax_buddies(id_iaxbud) ON DELETE CASCADE;


--
-- TOC entry 2795 (class 2606 OID 70340)
-- Name: iax_red_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY iax_red
    ADD CONSTRAINT iax_red_fk FOREIGN KEY (id_iaxbud) REFERENCES iax_buddies(id_iaxbud) ON DELETE CASCADE;


--
-- TOC entry 2809 (class 2606 OID 70345)
-- Name: id_appivr_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_ivrdet
    ADD CONSTRAINT id_appivr_fkey FOREIGN KEY (id_appivr) REFERENCES tb_appivr(id_appivr) MATCH FULL ON DELETE CASCADE;


--
-- TOC entry 2814 (class 2606 OID 111808)
-- Name: id_empare_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT id_empare_fkey FOREIGN KEY (id_empare) REFERENCES empresa_area(id_empare);


--
-- TOC entry 2810 (class 2606 OID 70355)
-- Name: id_opcivr_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_ivrdet
    ADD CONSTRAINT id_opcivr_fkey FOREIGN KEY (id_opcivr) REFERENCES tcopcivr(id_opcivr) MATCH FULL;


--
-- TOC entry 2811 (class 2606 OID 70360)
-- Name: id_parent_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_ivrdet
    ADD CONSTRAINT id_parent_fkey FOREIGN KEY (id_parent) REFERENCES tb_ivrdet(id_ivrdet) ON DELETE CASCADE;


--
-- TOC entry 2819 (class 2606 OID 70365)
-- Name: id_rutdet_detalle_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcrutde_tron
    ADD CONSTRAINT id_rutdet_detalle_fk FOREIGN KEY (id_rutdet) REFERENCES tcruta_detalle(id_rutdet);


--
-- TOC entry 2818 (class 2606 OID 70370)
-- Name: id_rutsal_detalle_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcruta_detalle
    ADD CONSTRAINT id_rutsal_detalle_fk FOREIGN KEY (id_rutsal) REFERENCES tbruta_salientes(id_rutsal);


--
-- TOC entry 2820 (class 2606 OID 70375)
-- Name: id_tbtroncal_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcrutde_tron
    ADD CONSTRAINT id_tbtroncal_fk FOREIGN KEY (id_troncal) REFERENCES tb_troncal(id_troncal);


--
-- TOC entry 2796 (class 2606 OID 70380)
-- Name: queue_members_id_agente_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_members
    ADD CONSTRAINT queue_members_id_agente_fkey FOREIGN KEY (id_agente) REFERENCES agente(id_agente) ON DELETE CASCADE;


--
-- TOC entry 2797 (class 2606 OID 70385)
-- Name: queue_por_campana_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_por_campana
    ADD CONSTRAINT queue_por_campana_fk FOREIGN KEY (id_queues) REFERENCES queues(id_queues) DEFERRABLE;


--
-- TOC entry 2798 (class 2606 OID 70390)
-- Name: queue_por_campana_fk1; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY queue_por_campana
    ADD CONSTRAINT queue_por_campana_fk1 FOREIGN KEY (id_campan) REFERENCES campana(id_campan);


--
-- TOC entry 2799 (class 2606 OID 70395)
-- Name: sip_buddies_aprov_id_modelo; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_buddies_aprov
    ADD CONSTRAINT sip_buddies_aprov_id_modelo FOREIGN KEY (id_modelo) REFERENCES tcmodelo(id_modelo) ON DELETE CASCADE;


--
-- TOC entry 2800 (class 2606 OID 70400)
-- Name: sip_buddies_aprov_id_sip_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY sip_buddies_aprov
    ADD CONSTRAINT sip_buddies_aprov_id_sip_fk FOREIGN KEY (id_sip) REFERENCES sip_buddies(id_sip) ON DELETE CASCADE;


--
-- TOC entry 2815 (class 2606 OID 70405)
-- Name: tb_contexto_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_rutasalcontex
    ADD CONSTRAINT tb_contexto_fk FOREIGN KEY (id_contexto) REFERENCES tb_contexto(id_contexto);


--
-- TOC entry 2805 (class 2606 OID 70410)
-- Name: tb_extensionxgrupo_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxgrupo
    ADD CONSTRAINT tb_extensionxgrupo_fk FOREIGN KEY (id_grupo) REFERENCES tb_grupo(id_grupo) ON DELETE CASCADE;


--
-- TOC entry 2806 (class 2606 OID 70415)
-- Name: tb_extensionxgrupo_fk1; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxgrupo
    ADD CONSTRAINT tb_extensionxgrupo_fk1 FOREIGN KEY (id_exten) REFERENCES sip_buddies(id_sip);


--
-- TOC entry 2807 (class 2606 OID 70420)
-- Name: tb_extensionxperifo_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxperifo
    ADD CONSTRAINT tb_extensionxperifo_fk FOREIGN KEY (id_perifo) REFERENCES tb_perifoneo(id_perifo);


--
-- TOC entry 2808 (class 2606 OID 70425)
-- Name: tb_extensionxperifo_fk1; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_extensionxperifo
    ADD CONSTRAINT tb_extensionxperifo_fk1 FOREIGN KEY (id_extens) REFERENCES sip_buddies(id_sip);


--
-- TOC entry 2812 (class 2606 OID 70430)
-- Name: tb_pin_id_usupin_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_pin
    ADD CONSTRAINT tb_pin_id_usupin_fkey FOREIGN KEY (id_usupin) REFERENCES tb_usuario(id_usuari);


--
-- TOC entry 2813 (class 2606 OID 70435)
-- Name: tb_pin_telcla_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tb_pin
    ADD CONSTRAINT tb_pin_telcla_fkey FOREIGN KEY (id_tiptel, id_clave) REFERENCES tctiptel_clave(id_tiptel, id_clave);


--
-- TOC entry 2816 (class 2606 OID 70440)
-- Name: tbruta_salientes_fk; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tc_rutasalcontex
    ADD CONSTRAINT tbruta_salientes_fk FOREIGN KEY (id_rutsal) REFERENCES tbruta_salientes(id_rutsal);


--
-- TOC entry 2817 (class 2606 OID 70445)
-- Name: tcmodelo_id_marca_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tcmodelo
    ADD CONSTRAINT tcmodelo_id_marca_fkey FOREIGN KEY (id_marca) REFERENCES tcmarca(id_marca) ON DELETE CASCADE;


--
-- TOC entry 2821 (class 2606 OID 70450)
-- Name: tctiptel_clave_id_clave_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tctiptel_clave
    ADD CONSTRAINT tctiptel_clave_id_clave_fkey FOREIGN KEY (id_clave) REFERENCES tc_clave(id_clave);


--
-- TOC entry 2822 (class 2606 OID 70455)
-- Name: tctiptel_clave_id_tiptel_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY tctiptel_clave
    ADD CONSTRAINT tctiptel_clave_id_tiptel_fkey FOREIGN KEY (id_tiptel) REFERENCES tc_tipotelefono(id_tiptel);


--
-- TOC entry 2823 (class 2606 OID 70460)
-- Name: usuarioxarea_id_empare_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY usuarioxarea
    ADD CONSTRAINT usuarioxarea_id_empare_fkey FOREIGN KEY (id_empare) REFERENCES empresa_area(id_empare);


--
-- TOC entry 2824 (class 2606 OID 70465)
-- Name: usuarioxarea_id_usuari_fkey; Type: FK CONSTRAINT; Schema: asterisk; Owner: tintegro
--

ALTER TABLE ONLY usuarioxarea
    ADD CONSTRAINT usuarioxarea_id_usuari_fkey FOREIGN KEY (id_usuari) REFERENCES tb_usuario(id_usuari);


SET search_path = reportes, pg_catalog;

--
-- TOC entry 2825 (class 2606 OID 70470)
-- Name: tb_estagente_fk1; Type: FK CONSTRAINT; Schema: reportes; Owner: tintegro
--

ALTER TABLE ONLY tb_estado_agente
    ADD CONSTRAINT tb_estagente_fk1 FOREIGN KEY (co_estado) REFERENCES asterisk.tc_estado(id_estage);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 2826 (class 2606 OID 70475)
-- Name: id_parent_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY tcmodulo
    ADD CONSTRAINT id_parent_fkey FOREIGN KEY (id_parent) REFERENCES tcmodulo(id_modulo);


--
-- TOC entry 2827 (class 2606 OID 70480)
-- Name: tcmodulo_rolusu_id_modulo_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY tcmodulo_rolusu
    ADD CONSTRAINT tcmodulo_rolusu_id_modulo_fkey FOREIGN KEY (id_modulo) REFERENCES tcmodulo(id_modulo) ON UPDATE RESTRICT;


--
-- TOC entry 2828 (class 2606 OID 70485)
-- Name: tcmodulo_rolusu_id_rolusu; Type: FK CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY tcmodulo_rolusu
    ADD CONSTRAINT tcmodulo_rolusu_id_rolusu FOREIGN KEY (id_rolusu) REFERENCES rolusu(id_rolusu) ON UPDATE RESTRICT;


--
-- TOC entry 2787 (class 2606 OID 70490)
-- Name: usuari_id_rolusu_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: tintegro
--

ALTER TABLE ONLY usuari
    ADD CONSTRAINT usuari_id_rolusu_fkey FOREIGN KEY (id_rolusu) REFERENCES rolusu(id_rolusu) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: tintegro
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM tintegro;
GRANT ALL ON SCHEMA public TO tintegro;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-04-07 11:08:15 PET

--
-- PostgreSQL database dump complete
--

