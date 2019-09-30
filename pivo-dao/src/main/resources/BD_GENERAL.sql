--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.20
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-04-06 15:34:35 PET

CREATE DATABASE "BD_GENERAL"
  WITH OWNER = tintegro
       ENCODING = 'LATIN1'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;

--SET statement_timeout = 0;
--SET lock_timeout = 0;
--SET client_encoding = 'LATIN1';
--SET standard_conforming_strings = off;
--SET check_function_bodies = false;
--SET client_min_messages = warning;
--SET escape_string_warning = off;
--SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 111850)
-- Name: oauth; Type: SCHEMA; Schema: -; Owner: tintegro
--

CREATE SCHEMA oauth;


ALTER SCHEMA oauth OWNER TO tintegro;

--
-- TOC entry 4 (class 2615 OID 70692)
-- Name: sistema; Type: SCHEMA; Schema: -; Owner: tintegro
--

CREATE SCHEMA sistema;


ALTER SCHEMA sistema OWNER TO tintegro;

--
-- TOC entry 703 (class 2612 OID 70691)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: tintegro
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO tintegro;

SET search_path = oauth, pg_catalog;

--
-- TOC entry 634 (class 1247 OID 136538)
-- Name: tp_client_details; Type: TYPE; Schema: oauth; Owner: tintegro
--

CREATE TYPE tp_client_details AS (
	no_client_id character varying,
	no_client character varying,
	no_ids_resources character varying,
	no_client_secret character varying,
	no_scope character varying,
	no_authorized_grant_types character varying,
	no_web_server_redirect_uri character varying,
	no_authorities character varying,
	no_access_token_validity character varying,
	no_refresh_access_token_validity character varying,
	no_aditional_information character varying,
	no_autoapprove character varying
);


ALTER TYPE tp_client_details OWNER TO tintegro;

--
-- TOC entry 650 (class 1247 OID 136635)
-- Name: tp_role; Type: TYPE; Schema: oauth; Owner: tintegro
--

CREATE TYPE tp_role AS (
	id_rol integer,
	no_rol character varying
);


ALTER TYPE tp_role OWNER TO tintegro;

--
-- TOC entry 647 (class 1247 OID 136622)
-- Name: tp_user; Type: TYPE; Schema: oauth; Owner: tintegro
--

CREATE TYPE tp_user AS (
	id_usuario integer,
	no_login character varying,
	no_password character varying,
	no_nombre character varying,
	no_apellido character varying,
	no_email character varying,
	no_profesion character varying,
	il_activo boolean,
	fe_creacion date,
	il_account_non_expired boolean,
	il_credential_non_expired boolean,
	il_account_non_locked boolean
);


ALTER TYPE tp_user OWNER TO tintegro;

--
-- TOC entry 628 (class 1247 OID 136484)
-- Name: tp_user_role; Type: TYPE; Schema: oauth; Owner: tintegro
--

CREATE TYPE tp_user_role AS (
	no_usuario character varying,
	no_role character varying
);


ALTER TYPE tp_user_role OWNER TO tintegro;

--
-- TOC entry 625 (class 1247 OID 136480)
-- Name: tp_usuario; Type: TYPE; Schema: oauth; Owner: tintegro
--

CREATE TYPE tp_usuario AS (
	no_usuario character varying,
	no_password character varying,
	il_activo boolean
);


ALTER TYPE tp_usuario OWNER TO tintegro;

SET search_path = sistema, pg_catalog;

--
-- TOC entry 546 (class 1247 OID 78993)
-- Name: tp_buscar_instancia_x_id; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_buscar_instancia_x_id AS (
	id_instancia integer,
	id_cliente integer
);


ALTER TYPE tp_buscar_instancia_x_id OWNER TO tintegro;

--
-- TOC entry 603 (class 1247 OID 136348)
-- Name: tp_cliente_pedido; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_cliente_pedido AS (
	id_cliente integer,
	id_pedido integer
);


ALTER TYPE tp_cliente_pedido OWNER TO tintegro;

--
-- TOC entry 549 (class 1247 OID 70719)
-- Name: tp_lista_instancia; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instancia AS (
	id_instancia integer,
	id_cliente integer
);


ALTER TYPE tp_lista_instancia OWNER TO tintegro;

--
-- TOC entry 552 (class 1247 OID 79052)
-- Name: tp_lista_instancia_x_idcliente; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instancia_x_idcliente AS (
	id_instancia integer,
	ip_red character varying(100),
	nro_vlan integer,
	ip_asterisk character varying(100),
	ip_median character varying(100),
	no_mascara character varying(100),
	no_iprouter character varying(100),
	no_dns_1 character varying(100),
	no_dns_2 character varying(100),
	no_subnet character varying(100),
	no_broadcast character varying(100),
	puerto_asterisk_bash_certificado_ext integer,
	id_cliente integer,
	il_estado boolean,
	il_libre boolean,
	ipasteriskbash character varying(100)
);


ALTER TYPE tp_lista_instancia_x_idcliente OWNER TO tintegro;

--
-- TOC entry 662 (class 1247 OID 136706)
-- Name: tp_lista_instanciadetalle; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instanciadetalle AS (
	id_instancia integer,
	ip_red character varying,
	nro_vlan integer,
	ip_asterisk character varying,
	ip_median character varying,
	no_mascara character varying,
	no_iprouter character varying,
	no_dns_1 character varying,
	no_dns_2 character varying,
	no_subnet character varying,
	no_broadcast character varying,
	id_cliente integer,
	il_estado boolean,
	il_libre boolean,
	ipasteriskbash character varying,
	puerto_asterisk_bash_certificado_ext integer,
	puerto_openvpn character varying,
	ip_confinicial character varying,
	mask_subredconfinicial character varying,
	pam_confinicial character varying,
	sim_pais character varying,
	sim_provincia character varying,
	full_provincia character varying,
	no_organi character varying,
	no_email character varying,
	id_modelo integer,
	id_marca integer,
	no_modelo character varying,
	no_marca character varying,
	inicial integer,
	id_estadoinst integer,
	no_estadoinstancia character varying,
	no_razon_social character varying,
	nu_docide character varying,
	direccion character varying,
	telefono character varying,
	correo character varying,
	personareferencia character varying,
	no_plan character varying,
	id_mostrar integer,
	fe_pedido date
);


ALTER TYPE tp_lista_instanciadetalle OWNER TO tintegro;

--
-- TOC entry 665 (class 1247 OID 144545)
-- Name: tp_lista_instanciadetalle_new; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instanciadetalle_new AS (
	id_instancia integer,
	ip_red character varying,
	nro_vlan integer,
	ip_asterisk character varying,
	ip_median character varying,
	no_mascara character varying,
	no_iprouter character varying,
	no_dns_1 character varying,
	no_dns_2 character varying,
	no_subnet character varying,
	no_broadcast character varying,
	id_cliente integer,
	il_estado boolean,
	il_libre boolean,
	ipasteriskbash character varying,
	puerto_asterisk_bash_certificado_ext integer,
	puerto_openvpn character varying,
	ip_confinicial character varying,
	mask_subredconfinicial character varying,
	pam_confinicial character varying,
	sim_pais character varying,
	sim_provincia character varying,
	full_provincia character varying,
	no_organi character varying,
	no_email character varying,
	id_modelo integer,
	id_marca integer,
	no_modelo character varying,
	no_marca character varying,
	inicial integer,
	id_estadoinst integer,
	no_estadoinstancia character varying,
	no_razon_social character varying,
	nu_docide character varying,
	direccion character varying,
	telefono character varying,
	correo character varying,
	personareferencia character varying,
	no_plan character varying,
	id_mostrar integer,
	fe_pedido character varying
);


ALTER TYPE tp_lista_instanciadetalle_new OWNER TO tintegro;

--
-- TOC entry 677 (class 1247 OID 144617)
-- Name: tp_lista_instanciadetalle_new2; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instanciadetalle_new2 AS (
	id_instancia integer,
	ip_red character varying,
	nro_vlan integer,
	ip_asterisk character varying,
	ip_median character varying,
	no_mascara character varying,
	no_iprouter character varying,
	no_dns_1 character varying,
	no_dns_2 character varying,
	no_subnet character varying,
	no_broadcast character varying,
	id_cliente integer,
	il_estado boolean,
	il_libre boolean,
	ipasteriskbash character varying,
	puerto_asterisk_bash_certificado_ext integer,
	puerto_openvpn character varying,
	ip_confinicial character varying,
	mask_subredconfinicial character varying,
	pam_confinicial character varying,
	sim_pais character varying,
	sim_provincia character varying,
	full_provincia character varying,
	no_organi character varying,
	no_email character varying,
	id_modelo integer,
	id_marca integer,
	no_modelo character varying,
	no_marca character varying,
	inicial integer,
	id_estadoinst integer,
	no_estadoinstancia character varying,
	no_razon_social character varying,
	nu_docide character varying,
	direccion character varying,
	telefono character varying,
	correo character varying,
	personareferencia character varying,
	no_plan character varying,
	id_mostrar character varying,
	fe_pedido character varying
);


ALTER TYPE tp_lista_instanciadetalle_new2 OWNER TO tintegro;

--
-- TOC entry 619 (class 1247 OID 136464)
-- Name: tp_lista_instancias; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_lista_instancias AS (
	id_instancia integer,
	ip_red character varying(100),
	nro_vlan integer,
	ip_asterisk character varying(100),
	ip_median character varying(100),
	no_mascara character varying(100),
	no_iprouter character varying(100),
	no_dns_1 character varying(100),
	no_dns_2 character varying(100),
	no_subnet character varying(100),
	no_broadcast character varying(100),
	id_cliente integer,
	il_estado boolean,
	il_libre boolean,
	ipasteriskbash character varying(100),
	puerto_asterisk_bash_certificado_ext integer,
	puerto_openvpn character varying,
	ip_confinicial character varying,
	mask_subredconfinicial character varying,
	pam_confinicial character varying,
	sim_pais character varying,
	sim_provincia character varying,
	full_provincia character varying,
	no_organi character varying,
	no_email character varying,
	id_modelo integer,
	id_marca integer,
	no_modelo character varying,
	no_marca character varying,
	inicial integer,
	id_estadoinst integer
);


ALTER TYPE tp_lista_instancias OWNER TO tintegro;

--
-- TOC entry 555 (class 1247 OID 78979)
-- Name: tp_listar_clientes; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_listar_clientes AS (
	id_cliente integer,
	no_razon_social character varying(100),
	ruc character varying(100),
	direccion character varying(100),
	telefono character varying(20),
	correo character varying(50),
	personareferencia character varying(50),
	estado boolean
);


ALTER TYPE tp_listar_clientes OWNER TO tintegro;

--
-- TOC entry 558 (class 1247 OID 79003)
-- Name: tp_listar_instancia_libres_activas; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_listar_instancia_libres_activas AS (
	id_instancia integer,
	ip_red character varying(100),
	nro_vlan integer,
	ip_asterisk character varying(100),
	ip_median character varying(100),
	no_mascara character varying(100),
	no_iprouter character varying(100),
	no_dns_1 character varying(100),
	no_dns_2 character varying(100),
	no_subnet character varying(100),
	no_broadcast character varying(100),
	puerto_asterisk_bash_certificado_ext character varying(100),
	id_cliente integer,
	il_estado boolean,
	il_libre boolean
);


ALTER TYPE tp_listar_instancia_libres_activas OWNER TO tintegro;

--
-- TOC entry 622 (class 1247 OID 136468)
-- Name: tp_pedido_usuario; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_pedido_usuario AS (
	no_razon_social character varying,
	id_pedido integer,
	fe_pedido date,
	id_cliente integer,
	no_estadopedido character varying
);


ALTER TYPE tp_pedido_usuario OWNER TO tintegro;

--
-- TOC entry 631 (class 1247 OID 136488)
-- Name: tp_resultado; Type: TYPE; Schema: sistema; Owner: tintegro
--

CREATE TYPE tp_resultado AS (
	id_resulta integer,
	no_mensaje character varying
);


ALTER TYPE tp_resultado OWNER TO tintegro;

SET search_path = oauth, pg_catalog;

--
-- TOC entry 226 (class 1255 OID 136559)
-- Name: fn_actualizar_usuario(integer, character varying, character varying, character varying, character varying, character varying, character varying, boolean); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_actualizar_usuario(p_id_usuario integer, p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying, p_il_activo boolean) RETURNS sistema.tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return sistema.tp_resultado%rowtype;
   v_id_resultado INTEGER := 0;
   v_no_resultado varchar := '';
   
  v_id_usuario integer := p_id_usuario;
  v_no_login   varchar := p_no_login;
  v_no_passwo  varchar := p_no_passwo;
  v_no_nombre  varchar := p_no_nombre;
  v_no_apelli  varchar := p_no_apelli;
  v_no_email   varchar := p_no_email;
  v_no_profe   varchar := p_no_profe;
  v_il_activo  boolean := p_il_activo;
BEGIN
   UPDATE oauth.tb_usuario
   SET no_login=v_no_login, no_passwo=v_no_passwo, no_nombre=v_no_nombre, no_apelli=v_no_apelli, 
       no_email=v_no_email, no_profe=v_no_profe, il_activo=v_il_activo
 WHERE id_usuario = v_id_usuario;

   v_va_return.id_resulta := 1;
   v_va_return.no_mensaje := 'Ok';    

   
   RETURN v_va_return;      
END
$$;


ALTER FUNCTION oauth.fn_actualizar_usuario(p_id_usuario integer, p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying, p_il_activo boolean) OWNER TO tintegro;

--
-- TOC entry 223 (class 1255 OID 136558)
-- Name: fn_insertar_usuario(character varying, character varying, character varying, character varying, character varying, character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_insertar_usuario(p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying) RETURNS sistema.tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return sistema.tp_resultado%rowtype;
   v_id_resultado INTEGER := 0;
   v_no_resultado varchar := '';
   
  v_no_login  varchar := p_no_login;
  v_no_passwo varchar := p_no_passwo;
  v_no_nombre varchar := p_no_nombre;
  v_no_apelli varchar := p_no_apelli;
  v_no_email  varchar := p_no_email;
  v_no_profe  varchar := p_no_profe;
BEGIN
   INSERT INTO oauth.tb_usuario(no_login, no_passwo, no_nombre, no_apelli, no_email, no_profe)
    VALUES (v_no_login, v_no_passwo, v_no_nombre, v_no_apelli, v_no_email, v_no_profe);

   v_va_return.id_resulta := 1;
   v_va_return.no_mensaje := 'Ok';    

   
   RETURN v_va_return;      
END
$$;


ALTER FUNCTION oauth.fn_insertar_usuario(p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying) OWNER TO tintegro;

--
-- TOC entry 247 (class 1255 OID 136693)
-- Name: fn_insertar_usuario_asignar_instancia(integer, character varying, character varying, character varying, character varying, character varying, character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_insertar_usuario_asignar_instancia(p_id_instancia integer, p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying) RETURNS sistema.tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return sistema.tp_resultado%rowtype;
   v_id_resultado INTEGER := 0;
   v_no_resultado varchar := '';
   
  v_no_login  varchar := trim(p_no_login);
  v_no_passwo varchar := p_no_passwo;
  v_no_nombre varchar := p_no_nombre;
  v_no_apelli varchar := p_no_apelli;
  v_no_email  varchar := p_no_email;
  v_no_profe  varchar := p_no_profe;
  v_id_instancia integer := p_id_instancia;
  v_id_usuario integer := 0;
BEGIN
select id_usuario into v_id_usuario from oauth.tb_usuario where upper(no_login) = upper(v_no_login);
if v_id_usuario is null then 
	INSERT INTO oauth.tb_usuario(no_login, no_passwo, no_nombre, no_apelli, no_email, no_profe)
	VALUES (v_no_login, v_no_passwo, v_no_nombre, v_no_apelli, v_no_email, v_no_profe);
	select id_usuario into v_id_usuario from oauth.tb_usuario where upper(no_login) = upper(v_no_login);
end if;

INSERT INTO sistema.tc_usuario_instancia(id_usuario, id_instancia) VALUES (v_id_usuario, v_id_instancia);

	
   v_va_return.id_resulta := 1;
   v_va_return.no_mensaje := 'Ok';    

   
   RETURN v_va_return;      
END
$$;


ALTER FUNCTION oauth.fn_insertar_usuario_asignar_instancia(p_id_instancia integer, p_no_login character varying, p_no_passwo character varying, p_no_nombre character varying, p_no_apelli character varying, p_no_email character varying, p_no_profe character varying) OWNER TO tintegro;

--
-- TOC entry 241 (class 1255 OID 136531)
-- Name: fn_is_client_available(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_is_client_available(p_no_client_id character varying) RETURNS sistema.tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return sistema.tp_resultado%rowtype;
   v_il_client_available INTEGER := 0;
   v_msg_client_available CHARACTER VARYING := 'El recurso no est� disponible.';
BEGIN
   SELECT 
      count( * )
   FROM 
      oauth.tb_client_details cd
   INTO
      v_il_client_available
   WHERE
      cd.no_client_id = p_no_client_id;

   IF v_il_client_available = 1 THEN
      v_msg_client_available := 'El recurso est� disponible.';
   END IF;

   v_va_return.id_resulta := v_il_client_available;
   v_va_return.no_mensaje := v_msg_client_available;

   RETURN v_va_return;         
END
$$;


ALTER FUNCTION oauth.fn_is_client_available(p_no_client_id character varying) OWNER TO tintegro;

--
-- TOC entry 245 (class 1255 OID 136636)
-- Name: fn_list_role_by_username(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_list_role_by_username(p_no_usuario character varying) RETURNS SETOF tp_role
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return oauth.tp_role%rowtype;
BEGIN
   FOR v_va_return IN
      SELECT
	 r.id_rol,
         r.no_rol
      FROM
         oauth.tb_usuario u, 
         oauth.tb_rol r,
         oauth.tc_usuario_rol ur
      WHERE
         ur.id_usuario = u.id_usuario
         AND ur.id_rol = r.id_rol
         AND u.no_login = p_no_usuario
   LOOP
      RETURN NEXT v_va_return;
   END LOOP; 
END
$$;


ALTER FUNCTION oauth.fn_list_role_by_username(p_no_usuario character varying) OWNER TO tintegro;

--
-- TOC entry 233 (class 1255 OID 136485)
-- Name: fn_list_user_role(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_list_user_role(p_no_usuario character varying) RETURNS SETOF tp_user_role
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return oauth.tp_user_role%rowtype;
BEGIN
   FOR v_va_return IN
      SELECT
         u.no_login,
         r.no_rol
      FROM
         oauth.tb_usuario u, 
         oauth.tb_rol r,
         oauth.tc_usuario_rol ur
      WHERE
         ur.id_usuario = u.id_usuario
         AND ur.id_rol = r.id_rol
         AND u.no_login = p_no_usuario
   LOOP
      RETURN NEXT v_va_return;
   END LOOP; 
END
$$;


ALTER FUNCTION oauth.fn_list_user_role(p_no_usuario character varying) OWNER TO tintegro;

--
-- TOC entry 232 (class 1255 OID 136481)
-- Name: fn_list_users_enabled(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_list_users_enabled(p_no_usuario character varying) RETURNS SETOF tp_usuario
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return oauth.tp_usuario%rowtype;
BEGIN
   FOR v_va_return IN
      SELECT 
         u.no_login, u.no_passwo, u.il_activo
      FROM
         oauth.tb_usuario u
      WHERE
         u.no_login = p_no_usuario
   LOOP
      RETURN NEXT v_va_return;
   END LOOP;   
END   
$$;


ALTER FUNCTION oauth.fn_list_users_enabled(p_no_usuario character varying) OWNER TO tintegro;

--
-- TOC entry 242 (class 1255 OID 136539)
-- Name: fn_load_client_by_id(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_load_client_by_id(p_no_client_id character varying) RETURNS SETOF tp_client_details
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return oauth.tp_client_details%rowtype;
BEGIN
   FOR v_va_return IN
      SELECT
         cd.no_client_id,
         cd.no_client,
	 cd.no_ids_resources,
	 cd.no_client_secret,
	 cd.no_scope,
	 cd.no_authorized_grant_types,
	 cd.no_web_server_redirect_uri,
	 cd.no_authorities,
	 cd.no_access_token_validity,
	 cd.no_refresh_access_token_validity,
	 cd.no_aditional_information,
	 cd.no_autoapprove
      FROM 
         oauth.tb_client_details cd
      WHERE
         cd.no_client_id = p_no_client_id
   LOOP
      RETURN NEXT v_va_return;
   END LOOP;
END
$$;


ALTER FUNCTION oauth.fn_load_client_by_id(p_no_client_id character varying) OWNER TO tintegro;

--
-- TOC entry 243 (class 1255 OID 136623)
-- Name: fn_load_user_by_username(character varying); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_load_user_by_username(p_no_username character varying) RETURNS SETOF tp_user
    LANGUAGE plpgsql
    AS $$
DECLARE
   v_va_return oauth.tp_user%rowtype;
BEGIN
   FOR v_va_return IN
      SELECT
         u.id_usuario,
         u.no_login,
         u.no_passwo,
         u.no_nombre,
         u.no_apelli,
         u.no_email,
         u.no_profe,
         u.il_activo,
         u.fe_creaci,
         u.il_account_non_expired,
         u.il_credential_non_expired,
         u.il_account_non_locked
      FROM
	 oauth.tb_usuario u
      WHERE
         u.no_login = p_no_username
   LOOP
      RETURN NEXT v_va_return;
   END LOOP;
END
$$;


ALTER FUNCTION oauth.fn_load_user_by_username(p_no_username character varying) OWNER TO tintegro;

--
-- TOC entry 251 (class 1255 OID 144539)
-- Name: fn_validar_servicio_por_usuario(character varying, character varying, boolean); Type: FUNCTION; Schema: oauth; Owner: tintegro
--

CREATE FUNCTION fn_validar_servicio_por_usuario(p_no_login character varying, p_no_url character varying, p_il_istancia boolean) RETURNS SETOF sistema.tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_resultado%rowtype;
	v_no_login character varying := p_no_login; 
	v_no_url character varying   := p_no_url; 
	v_il_istancia boolean := p_il_istancia;
	v_id_rol integer := 0;
	v_id_servicio integer := 0;
	
BEGIN
if (select id_instancia_ovligatorio from oauth.tb_servicio where trim(no_url) = trim(v_no_url)) = 1 then 
	if v_il_istancia = true then 	
		select r.id_rol into v_id_rol from oauth.tb_usuario u, oauth.tc_usuario_rol r where u.id_usuario = r.id_usuario and no_login = v_no_login;
		select id_servicio into v_id_servicio from oauth.tb_servicio where trim(no_url) = trim(v_no_url);
		
		if (select id_rol from oauth.tc_servicio_rol where id_rol = v_id_rol and id_servicio = v_id_servicio) is not null then 
			select 1, 'Permiso otorgado.' into v_va_return;
				
		else
			select 0, 'Permiso denegado.' into v_va_return; 
		end if;
	else 
		select 0, 'Permiso denegado.' into v_va_return; 
	end if;
else 
	select r.id_rol into v_id_rol from oauth.tb_usuario u, oauth.tc_usuario_rol r where u.id_usuario = r.id_usuario and no_login = v_no_login;
	select id_servicio into v_id_servicio from oauth.tb_servicio where trim(no_url) = trim(v_no_url);
	if (select id_rol from oauth.tc_servicio_rol where id_rol = v_id_rol and id_servicio = v_id_servicio) is not null then 
		select 1, 'Permiso otorgado.' into v_va_return;			
	else
		select 0, 'Permiso denegado.' into v_va_return; 
	end if;
end if;

return next v_va_return;

END;
$$;


ALTER FUNCTION oauth.fn_validar_servicio_por_usuario(p_no_login character varying, p_no_url character varying, p_il_istancia boolean) OWNER TO tintegro;

SET search_path = sistema, pg_catalog;

--
-- TOC entry 221 (class 1255 OID 78961)
-- Name: actualizarcliente(integer, character varying, character varying, character varying, character varying, character varying, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION actualizarcliente(p_id_cliente integer, p_no_razon character varying, p_ruc character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_persref character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
salida integer := 0;
v_id_Cliente integer := p_id_Cliente;
  v_no_razon varchar := p_no_razon;
  v_ruc varchar := p_ruc;
   v_direccion varchar := p_direccion;
  v_telefono varchar := p_telefono;
   v_correo varchar := p_correo;
   v_persRef varchar := p_persRef;
  
BEGIN


UPDATE sistema.cliente
   SET no_razon_social=v_no_razon, ruc=v_ruc, direccion=v_direccion, telefono=v_telefono, 
       correo=p_correo, personareferencia=p_persRef
 WHERE id_cliente=v_id_Cliente;
 
 salida := 1;

 return salida;
END;
$$;


ALTER FUNCTION sistema.actualizarcliente(p_id_cliente integer, p_no_razon character varying, p_ruc character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_persref character varying) OWNER TO tintegro;

--
-- TOC entry 224 (class 1255 OID 79040)
-- Name: asdesinstancia(integer, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION asdesinstancia(p_id_cliente integer, p_id_instancia integer, p_valor integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
salida integer := 0;
v_id_Cliente integer := p_id_Cliente;
v_id_instancia integer := p_id_instancia;
v_valor integer := p_valor;
  
BEGIN
--1:asignar
--2:desasignar
if v_valor=1 then
UPDATE sistema.instancia
   SET id_cliente=v_id_Cliente
 WHERE id_instancia=v_id_instancia;
 end if;

 if v_valor=0 then
UPDATE sistema.instancia
   SET id_cliente=null
 WHERE id_instancia=v_id_instancia;
 end if;
 
 salida := 1;

 return salida;
END;
$$;


ALTER FUNCTION sistema.asdesinstancia(p_id_cliente integer, p_id_instancia integer, p_valor integer) OWNER TO tintegro;

--
-- TOC entry 222 (class 1255 OID 78987)
-- Name: cambiarestadocliente(integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION cambiarestadocliente(p_id_cliente integer, p_estado integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
salida integer := 0;
v_id_Cliente integer := p_id_Cliente;
  v_estado integer := p_estado;

  
BEGIN

--1: activado
if v_estado=1 then
UPDATE sistema.cliente
   SET estado=true
 WHERE id_cliente=v_id_Cliente;
end if;

--0:desactivado
if v_estado=0 then
UPDATE sistema.cliente
   SET estado=false
 WHERE id_cliente=v_id_Cliente;
end if;

 
 salida := 1;

 return salida;
END;
$$;


ALTER FUNCTION sistema.cambiarestadocliente(p_id_cliente integer, p_estado integer) OWNER TO tintegro;

--
-- TOC entry 230 (class 1255 OID 79070)
-- Name: consultar_instanciaxcasos(integer, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION consultar_instanciaxcasos(p_id_cliente integer, p_estado integer, p_libre integer) RETURNS SETOF tp_listar_instancia_libres_activas
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_listar_instancia_libres_activas%rowtype;
  v_id_cliente integer := p_id_cliente;
  v_estado integer := p_estado;--1;activo;2:desactivado
  v_libre integer := p_libre;--1:libre;2;no libre(ocupado)
BEGIN

   --listar todo
    if (v_id_cliente is null and v_estado is null and v_libre is null )then 
	for v_va_return in  

		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia


	loop 
	return next v_va_return;
	end loop;  


	--listar x cliente
   	else if  (v_id_cliente is not null and v_estado is null and v_libre is null)  then 
   	for v_va_return in  


		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where id_cliente=v_id_cliente


	loop 
	return next v_va_return;
	end loop;  
   	
----------------------------------------------------------------------------------------------------------------------------------------------------------
	--listar x estado
   	else if (v_id_cliente is null and v_estado is not null and v_libre is null) then

	if v_estado=1 then
   	for v_va_return in  

		
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=true

		loop 
	return next v_va_return;
	end loop; 
	end if;

	if v_estado=0 then
   	for v_va_return in  

		
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=false

	loop 
	return next v_va_return;
	end loop; 

	end if;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 

	else if (v_id_cliente is null and v_estado is  null and v_libre is not null) then

		if(v_libre=1)then

	for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=true


	loop 
	return next v_va_return;
	end loop; 
	end if;
	
	if(v_libre=0)then

	for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=false


	loop 
	return next v_va_return;
	end loop; 
		end if;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		else if (v_id_cliente is not null  and v_estado is not  null and v_libre is  null) then

		if(v_estado=1)then

		for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=true and id_cliente=v_id_cliente


	loop 
	return next v_va_return;
	end loop; 
	end if;
	
	if(v_estado=0)then

	for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=false and id_cliente=v_id_cliente


	loop 
	return next v_va_return;
	end loop; 
		end if;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	else if (v_id_cliente is not null  and v_estado is null and v_libre is not null) then

		if(v_libre=1)then

		for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=true and id_cliente=v_id_cliente


	loop 
	return next v_va_return;
	end loop; 
	end if;
	
	if(v_libre=0)then

	for v_va_return in  



		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=false and id_cliente=v_id_cliente


	loop 
	return next v_va_return;
	end loop; 
		end if;

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	else if (v_id_cliente is not null  and v_estado is not null and v_libre is not null) then

		if(v_libre=1 and v_estado=1)then

		for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=true and id_cliente=v_id_cliente and il_estado=true


	loop 
	return next v_va_return;
	end loop; 
	end if;

					if(v_libre=1 and v_estado=0)then

					for v_va_return in  
					SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
					no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
					id_cliente,il_estado,il_libre from sistema.instancia where il_libre=true and id_cliente=v_id_cliente and il_estado=false
					loop 
					return next v_va_return;
					end loop; 
					end if;
					
	if(v_libre=0 and v_estado=0)then

	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=false and id_cliente=v_id_cliente and il_estado=false

	loop 
	return next v_va_return;
	end loop; 
		end if;
					if(v_libre=0 and v_estado=1)then

					for v_va_return in  
					SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
					no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
					id_cliente,il_estado,il_libre from sistema.instancia where il_libre=false and id_cliente=v_id_cliente and il_estado=true
					loop 
					return next v_va_return;
					end loop; 
					end if;


---------------------------------------------------------------------------------------------------------------------------------------
				end if;
			end if;
		end if;
            end if;
          end if; 
   	end if;
    end if;         



 return;
END;
$$;


ALTER FUNCTION sistema.consultar_instanciaxcasos(p_id_cliente integer, p_estado integer, p_libre integer) OWNER TO tintegro;

--
-- TOC entry 225 (class 1255 OID 79041)
-- Name: consultar_instanciaxvalor(integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION consultar_instanciaxvalor(p_id_valor integer) RETURNS SETOF tp_listar_instancia_libres_activas
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_listar_instancia_libres_activas%rowtype;
  v_id_valor integer := p_id_valor;
BEGIN
   --1:todas
   --2:libres 
   --3:activas 
   --4:desactivadas
   --5:en uso
    if p_id_valor = 1 then 
	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia
	loop 
	return next v_va_return;
	end loop;  
   	else if p_id_valor = 2 then 
   	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=true
	loop 
	return next v_va_return;
	end loop;  
   	
   	else if p_id_valor = 3 then
   	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=true
	loop 
	return next v_va_return;
	end loop; 
	else if p_id_valor = 4 then
	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_estado=false
	loop 
	return next v_va_return;
	end loop; 
	else if p_id_valor = 5 then 
   	for v_va_return in  
		SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
		no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
		id_cliente,il_estado,il_libre from sistema.instancia where il_libre=false
	loop 
	return next v_va_return;
	end loop;  

		end if;
            end if;
          end if;
   	end if;
    end if;         
 return;
END;
$$;


ALTER FUNCTION sistema.consultar_instanciaxvalor(p_id_valor integer) OWNER TO tintegro;

--
-- TOC entry 219 (class 1255 OID 78970)
-- Name: eliminarcliente(integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION eliminarcliente(p_id_cliente integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
salida integer := 0;
v_id_Cliente integer := p_id_Cliente;

  
BEGIN

delete from sistema.instancia where id_cliente=v_id_Cliente;

INSERT INTO sistema.cliente_eliminado 
select * from sistema.cliente where id_cliente=v_id_Cliente;

delete from sistema.cliente where id_cliente=v_id_Cliente;


 salida := 1;

 return salida;
END;
$$;


ALTER FUNCTION sistema.eliminarcliente(p_id_cliente integer) OWNER TO tintegro;

--
-- TOC entry 239 (class 1255 OID 136495)
-- Name: fn_actualizar_instancia(integer, character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, integer, boolean, boolean, character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, integer, integer, character varying, character varying, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_actualizar_instancia(p_id_instancia integer, p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_id_cliente integer, p_il_estado boolean, p_il_libre boolean, p_ipasteriskbash character varying, p_puerto_asterisk_bash_certificado_ext integer, p_puerto_openvpn character varying, p_ip_confinicial character varying, p_mask_subredconfinicial character varying, p_pam_confinicial character varying, p_sim_pais character varying, p_sim_provincia character varying, p_full_provincia character varying, p_no_organi character varying, p_no_email character varying, p_id_modelo integer, p_id_marca integer, p_no_modelo character varying, p_no_marca character varying, p_inicial integer, p_id_estadoinst integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_resultado%rowtype;
  v_id_resulta integer := 0;
  v_no_mensaje varchar := '';
  
  v_id_instancia integer := p_id_instancia;
  v_ip_red varchar := p_ip_red;
  v_nro_vlan integer := p_nro_vlan;
  v_ip_asterisk varchar := p_ip_asterisk;
  v_ip_median varchar := p_ip_median;
  v_no_mascara varchar := p_no_mascara;
  v_no_iprouter varchar := p_no_iprouter;
  v_no_dns_1 varchar := p_no_dns_1;
  v_no_dns_2 varchar := p_no_dns_2;
  v_no_subnet varchar := p_no_subnet;
  v_no_broadcast varchar := p_no_broadcast;
  v_id_cliente integer := p_id_cliente;
  v_il_estado boolean := p_il_estado;
  v_il_libre boolean := p_il_libre;
  v_ipasteriskbash varchar := p_ipasteriskbash;
  v_puerto_asterisk_bash_certificado_ext integer := p_puerto_asterisk_bash_certificado_ext;
  v_puerto_openvpn varchar := p_puerto_openvpn;
  v_ip_confinicial varchar := p_ip_confinicial;
  v_mask_subredconfinicial varchar := p_mask_subredconfinicial;
  v_pam_confinicial varchar := p_pam_confinicial;
  v_sim_pais varchar := p_sim_pais;
  v_sim_provincia varchar := p_sim_provincia;
  v_full_provincia varchar := p_full_provincia;
  v_no_organi varchar := p_no_organi;
  v_no_email varchar := p_no_email;
  v_id_modelo integer := p_id_modelo;
  v_id_marca integer := p_id_marca;
  v_no_modelo varchar := p_no_modelo;
  v_no_marca varchar := p_no_marca;
  v_inicial integer := p_inicial;
  v_id_estadoinst integer := p_id_estadoinst;
BEGIN

UPDATE sistema.tb_instancia
   SET ip_red=v_ip_red, nro_vlan=v_nro_vlan, ip_asterisk=v_ip_asterisk, ip_median=v_ip_median, 
       no_mascara=v_no_mascara, no_iprouter=v_no_iprouter, no_dns_1=v_no_dns_1, no_dns_2=v_no_dns_2, no_subnet=v_no_subnet, 
       no_broadcast=v_no_broadcast, id_cliente=v_id_cliente, il_estado=v_il_estado, il_libre=v_il_libre, ipasteriskbash=v_ipasteriskbash, 
       puerto_asterisk_bash_certificado_ext=v_puerto_asterisk_bash_certificado_ext, puerto_openvpn=v_puerto_openvpn, ip_confinicial=v_ip_confinicial, 
       mask_subredconfinicial=v_mask_subredconfinicial, pam_confinicial=v_pam_confinicial, sim_pais=v_sim_pais, sim_provincia=v_sim_provincia, 
       full_provincia=v_full_provincia, no_organi=v_no_organi, no_email=v_no_email, id_modelo=v_id_modelo, id_marca=v_id_marca, 
       no_modelo=v_no_modelo, no_marca=v_no_marca, inicial=v_inicial, id_estadoinst=v_id_estadoinst
 WHERE id_instancia = v_id_instancia;

v_id_resulta = 1;
v_no_mensaje = 'Ok';

select v_id_resulta, v_no_mensaje into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_actualizar_instancia(p_id_instancia integer, p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_id_cliente integer, p_il_estado boolean, p_il_libre boolean, p_ipasteriskbash character varying, p_puerto_asterisk_bash_certificado_ext integer, p_puerto_openvpn character varying, p_ip_confinicial character varying, p_mask_subredconfinicial character varying, p_pam_confinicial character varying, p_sim_pais character varying, p_sim_provincia character varying, p_full_provincia character varying, p_no_organi character varying, p_no_email character varying, p_id_modelo integer, p_id_marca integer, p_no_modelo character varying, p_no_marca character varying, p_inicial integer, p_id_estadoinst integer) OWNER TO tintegro;

--
-- TOC entry 246 (class 1255 OID 136626)
-- Name: fn_actualizar_plan(integer, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_actualizar_plan(p_id_plan integer, p_no_plan character varying) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_resultado%rowtype;
	v_no_plan varchar := trim(p_no_plan);
	v_id_plan integer := p_id_plan;
	v_resul integer := 0;
BEGIN
 if v_no_plan = '' then v_no_plan = null; end if;

select id_plan into v_resul from sistema.tc_plan where upper(no_plan) = upper('Plan 1');
if v_resul is null then
	if v_no_plan is not null then 
		UPDATE sistema.tc_plan  SET no_plan=v_no_plan WHERE id_plan = v_id_plan;
		select 1, 'OK' into v_va_return;
	else if v_no_plan is null then 
		select -1, 'El nombre del Plan no puede ser nulo o vacio.' into v_va_return;
	end if;
	end if;
else
	select -1, 'El nombre de Plan que desea actualizar ya esta registrado.' into v_va_return;
end if;

return next v_va_return;

END;
$$;


ALTER FUNCTION sistema.fn_actualizar_plan(p_id_plan integer, p_no_plan character varying) OWNER TO tintegro;

--
-- TOC entry 235 (class 1255 OID 136489)
-- Name: fn_cliente_pedido(integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_cliente_pedido(p_id_instancia integer, p_id_estadoinstancia integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_resultado%rowtype;
  v_id_resulta integer := 0;
  v_no_mensaje varchar := '';
  
  v_id_instancia integer := p_id_instancia; 
  v_id_estadoinstancia integer := p_id_estadoinstancia;
BEGIN

UPDATE sistema.tb_instancia SET id_estadoinst = v_id_estadoinstancia WHERE id_instancia = v_id_instancia;
v_id_resulta = 1;
v_no_mensaje = 'Ok';

select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_cliente_pedido(p_id_instancia integer, p_id_estadoinstancia integer) OWNER TO tintegro;

--
-- TOC entry 237 (class 1255 OID 136350)
-- Name: fn_cliente_pedido(character varying, character varying, character varying, character varying, character varying, character varying, boolean, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_cliente_pedido(p_no_razon_social character varying, p_nu_docide character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_personareferencia character varying, p_estado boolean, p_id_tipdoc integer) RETURNS SETOF tp_cliente_pedido
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_cliente_pedido%rowtype;
  v_id_cliente integer := 0;
  v_id_pedido integer := 0;

-- Parametros de entrada Cliente 
  v_no_razon_social varchar := p_no_razon_social;
  v_nu_docide varchar := p_nu_docide;
  v_direccion varchar := p_direccion;
  v_telefono varchar := p_telefono;
  v_correo varchar := p_correo;
  v_personareferencia varchar := p_personareferencia;
  v_estado boolean := p_estado;
  v_id_tipdoc integer := p_id_tipdoc;
 
BEGIN

-- Buscar si existe el cliente
SELECT id_cliente into v_id_cliente FROM sistema.tb_cliente  where nu_docide = v_nu_docide; 

if v_id_cliente is null then -- Si es nulo no existe el cliente se creara con los datos enviados y recogemos el Id_Clietne del registro creado
	INSERT INTO sistema.tb_cliente(no_razon_social, nu_docide, direccion, telefono, correo, personareferencia, estado, id_tipdoc)
               VALUES ( v_no_razon_social, v_nu_docide, v_direccion, v_telefono, v_correo, v_personareferencia, v_estado, v_id_tipdoc);
	SELECT id_cliente into v_id_cliente FROM sistema.tb_cliente  where nu_docide = v_nu_docide; 
end if;






select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_cliente_pedido(p_no_razon_social character varying, p_nu_docide character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_personareferencia character varying, p_estado boolean, p_id_tipdoc integer) OWNER TO tintegro;

--
-- TOC entry 234 (class 1255 OID 136351)
-- Name: fn_cliente_pedido(character varying, character varying, character varying, character varying, character varying, character varying, boolean, integer, date, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_cliente_pedido(p_no_razon_social character varying, p_nu_docide character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_personareferencia character varying, p_estado boolean, p_id_tipdoc integer, p_fe_pedido date, p_id_estadopedido integer) RETURNS SETOF tp_cliente_pedido
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_cliente_pedido%rowtype;
  v_id_cliente integer := 0;
  v_id_pedido integer := 0;

-- Parametros de entrada Cliente 
  v_no_razon_social varchar := p_no_razon_social;
  v_nu_docide varchar := p_nu_docide;
  v_direccion varchar := p_direccion;
  v_telefono varchar := p_telefono;
  v_correo varchar := p_correo;
  v_personareferencia varchar := p_personareferencia;
  v_estado boolean := p_estado;
  v_id_tipdoc integer := p_id_tipdoc;

  -- Parametros de entrada Pedido
  v_fe_pedido date := p_fe_pedido;
  v_id_estadopedido integer := p_id_estadopedido;
 
BEGIN

-- Buscar si existe el cliente
SELECT id_cliente into v_id_cliente FROM sistema.tb_cliente  where nu_docide = v_nu_docide; 

if v_id_cliente is null then -- Si es nulo no existe el cliente se creara con los datos enviados y recogemos el Id_Clietne del registro creado
	INSERT INTO sistema.tb_cliente(no_razon_social, nu_docide, direccion, telefono, correo, personareferencia, estado, id_tipdoc)
               VALUES ( v_no_razon_social, v_nu_docide, v_direccion, v_telefono, v_correo, v_personareferencia, v_estado, v_id_tipdoc);
	SELECT id_cliente into v_id_cliente FROM sistema.tb_cliente  where nu_docide = v_nu_docide; 
end if;

INSERT INTO sistema.tb_pedido(fe_pedido, id_cliente, id_estadopedido) VALUES (v_fe_pedido, v_id_cliente, v_id_estadopedido);


select id_pedido into v_id_pedido from sistema.tb_pedido 
where fe_pedido =  v_fe_pedido	
      and id_cliente = v_id_cliente	
      and id_estadopedido = v_id_estadopedido 
order by id_pedido desc limit 1;



select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_cliente_pedido(p_no_razon_social character varying, p_nu_docide character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_personareferencia character varying, p_estado boolean, p_id_tipdoc integer, p_fe_pedido date, p_id_estadopedido integer) OWNER TO tintegro;

--
-- TOC entry 240 (class 1255 OID 136384)
-- Name: fn_detalle_pedido(character varying, integer, integer, integer, integer, integer, character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, boolean, boolean, character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, integer, integer, character varying, character varying, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_detalle_pedido(p_no_detapedido character varying, p_id_tipopedido integer, p_id_pedido integer, p_id_tipodetalle integer, p_id_plan integer, p_id_cliente integer, p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_il_estado boolean, p_il_libre boolean, p_ipasteriskbash character varying, p_puerto_asterisk_bash_certificado_ext integer, p_cod_usuario character varying, p_puerto_openvpn character varying, p_ip_confinicial character varying, p_mask_subredconfinicial character varying, p_pam_confinicial character varying, p_sim_pais character varying, p_sim_provincia character varying, p_full_provincia character varying, p_no_organi character varying, p_no_email character varying, p_id_modelo integer, p_id_marca integer, p_no_modelo character varying, p_no_marca character varying, p_inicial integer, p_id_estadoinst integer) RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_id_instancia integer := 0; -- devolvemos el id_de la instancia si es el caso si devolvemos cero no es instancia es otro tipo de pedido
  
 -- Parametros de entrada Detalle pedido
  v_no_detapedido varchar := p_no_detapedido;
  v_id_tipopedido integer := p_id_tipopedido;
  v_id_pedido integer := p_id_pedido;
  v_id_tipodetalle integer := p_id_tipodetalle;
  v_id_plan integer := p_id_plan;
  v_id_cliente integer := p_id_cliente;

  -- Parametros de Instancia
  v_ip_red varchar := p_ip_red;
  v_nro_vlan integer := p_nro_vlan;
  v_ip_asterisk  varchar := p_ip_asterisk;
  v_ip_median  varchar := p_ip_median;
  v_no_mascara  varchar := p_no_mascara;
  v_no_iprouter  varchar := p_no_iprouter;
  v_no_dns_1  varchar := p_no_dns_1;
  v_no_dns_2  varchar := p_no_dns_2;
  v_no_subnet  varchar := p_no_subnet;
  v_no_broadcast  varchar := p_no_broadcast;
  v_il_estado boolean := p_il_estado;
  v_il_libre boolean := p_il_libre;
  v_ipasteriskbash  varchar := p_ipasteriskbash;
  v_puerto_asterisk_bash_certificado_ext integer := p_puerto_asterisk_bash_certificado_ext;

  v_puerto_openvpn  varchar := p_puerto_openvpn;
  v_ip_confinicial  varchar := p_ip_confinicial;
  v_mask_subredconfinicial  varchar := p_mask_subredconfinicial;
  v_pam_confinicial  varchar := p_pam_confinicial;
  v_sim_pais  varchar := p_sim_pais;
  v_sim_provincia  varchar := p_sim_provincia;
  v_full_provincia  varchar := p_full_provincia;
  v_no_organi  varchar := p_no_organi;
  v_no_email  varchar := p_no_email;
  v_id_modelo integer := p_id_modelo;
  v_id_marca integer := p_id_marca;
  v_no_modelo  varchar := p_no_modelo;
  v_no_marca  varchar := p_no_marca;
  v_inicial integer := p_inicial;
  v_id_estadoinst integer := p_id_estadoinst;
BEGIN
if p_id_tipodetalle = 1 then
	INSERT INTO sistema.tb_instancia(ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, 
	    no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, id_cliente, 
	    il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, 
	     puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
	    pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi, 
	    no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, 
	    id_estadoinst)
	VALUES (v_ip_red, v_nro_vlan, v_ip_asterisk, v_ip_median, v_no_mascara, 
	    v_no_iprouter, v_no_dns_1, v_no_dns_2, v_no_subnet, v_no_broadcast, v_id_cliente, 
	    v_il_estado, v_il_libre, v_ipasteriskbash, v_puerto_asterisk_bash_certificado_ext, 
	     v_puerto_openvpn, v_ip_confinicial, v_mask_subredconfinicial, 
	    v_pam_confinicial, v_sim_pais, v_sim_provincia, v_full_provincia, v_no_organi, 
	    v_no_email, v_id_modelo, v_id_marca, v_no_modelo, v_no_marca, v_inicial, 
	    v_id_estadoinst);

	SELECT id_instancia into v_id_instancia FROM sistema.tb_instancia where id_cliente = v_id_cliente order by id_instancia desc limit 1;

	INSERT INTO sistema.tc_detallepedido(no_detapedido, id_tipopedido, id_pedido, id_tipodetalle, id_plan, id_instancia, id_cliente)
	   VALUES (v_no_detapedido, v_id_tipopedido, v_id_pedido, v_id_tipodetalle, v_id_plan, v_id_instancia, v_id_cliente);
else 
	INSERT INTO sistema.tc_detallepedido(no_detapedido, id_tipopedido, id_pedido, id_tipodetalle, id_plan, id_cliente)
               VALUES (v_no_detapedido, v_id_tipopedido, v_id_pedido, v_id_tipodetalle, v_id_plan, v_id_cliente);
end if;

 return next v_id_instancia;
END;
$$;


ALTER FUNCTION sistema.fn_detalle_pedido(p_no_detapedido character varying, p_id_tipopedido integer, p_id_pedido integer, p_id_tipodetalle integer, p_id_plan integer, p_id_cliente integer, p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_il_estado boolean, p_il_libre boolean, p_ipasteriskbash character varying, p_puerto_asterisk_bash_certificado_ext integer, p_cod_usuario character varying, p_puerto_openvpn character varying, p_ip_confinicial character varying, p_mask_subredconfinicial character varying, p_pam_confinicial character varying, p_sim_pais character varying, p_sim_provincia character varying, p_full_provincia character varying, p_no_organi character varying, p_no_email character varying, p_id_modelo integer, p_id_marca integer, p_no_modelo character varying, p_no_marca character varying, p_inicial integer, p_id_estadoinst integer) OWNER TO tintegro;

--
-- TOC entry 238 (class 1255 OID 136491)
-- Name: fn_estado_instancia(integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_resultado%rowtype;
  v_id_resulta integer := 0;
  v_no_mensaje varchar := '';
  
  v_id_instancia integer := p_id_instancia; 
  v_id_estadoinstancia integer := p_id_estadoinstancia;
BEGIN

UPDATE sistema.tb_instancia SET id_estadoinst = v_id_estadoinstancia WHERE id_instancia = v_id_instancia;
v_id_resulta = 1;
v_no_mensaje = 'Ok';

select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer) OWNER TO tintegro;

--
-- TOC entry 229 (class 1255 OID 136579)
-- Name: fn_estado_instancia(integer, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer, p_id_usuario integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_resultado%rowtype;
  v_id_resulta integer := 0;
  v_no_mensaje varchar := '';
  
  v_id_instancia integer := p_id_instancia; 
  v_id_estadoinstancia integer := p_id_estadoinstancia;
  v_id_usuario integer := p_id_usuario;
BEGIN

--- Falta Programar  permisos para editar el el estado de la instancia dependiento del rol del v_id_usuario

UPDATE sistema.tb_instancia SET id_estadoinst = v_id_estadoinstancia WHERE id_instancia = v_id_instancia;
v_id_resulta = 1;
v_no_mensaje = 'Ok';

select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer, p_id_usuario integer) OWNER TO tintegro;

--
-- TOC entry 250 (class 1255 OID 144547)
-- Name: fn_estado_instancia(integer, integer, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer, p_no_login character varying) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_resultado%rowtype;
  v_id_resulta integer := 0;
  v_no_mensaje varchar := '';
  
  v_id_instancia integer := p_id_instancia; 
  v_id_estadoinstancia integer := p_id_estadoinstancia;
BEGIN

UPDATE sistema.tb_instancia SET id_estadoinst = v_id_estadoinstancia WHERE id_instancia = v_id_instancia;
v_id_resulta = 1;
v_no_mensaje = 'Ok';

select v_id_cliente, v_id_pedido into v_va_return;
return  next v_va_return;
            

END;
$$;


ALTER FUNCTION sistema.fn_estado_instancia(p_id_instancia integer, p_id_estadoinstancia integer, p_no_login character varying) OWNER TO tintegro;

--
-- TOC entry 244 (class 1255 OID 136624)
-- Name: fn_insertar_plan(character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_insertar_plan(p_no_plan character varying) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_resultado%rowtype;
	v_no_plan varchar := p_no_plan;
BEGIN
 if v_no_plan = '' then v_no_plan = null; end if;

if v_no_plan is not null then 
	INSERT INTO sistema.tc_plan(no_plan) VALUES (v_no_plan);
	select 1, 'OK' into v_va_return;
else if v_no_plan is null then 
	select -1, 'El nombre del Plan no puede ser nulo o vacio.' into v_va_return;
end if;
end if;


return next v_va_return;

END;
$$;


ALTER FUNCTION sistema.fn_insertar_plan(p_no_plan character varying) OWNER TO tintegro;

--
-- TOC entry 252 (class 1255 OID 144546)
-- Name: fn_listar_instancias(integer, character varying, integer, integer, integer, integer, integer, integer, integer, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_listar_instancias(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) RETURNS SETOF tp_lista_instanciadetalle_new
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_lista_instanciadetalle_new%rowtype;

	v_id_tipdoc varchar := p_id_tipdoc::varchar; 
	v_nu_docide varchar := p_nu_docide;
	v_id_cliente varchar := p_id_cliente::varchar; 
	v_id_pedido varchar := p_id_pedido::varchar; 
	v_id_estadoInstancia varchar := p_id_estadoInstancia::varchar;
	v_id_plan varchar := p_id_plan::varchar; 
	v_id_tipoEstadoPedido varchar := p_id_tipoEstadoPedido::varchar;
	v_id_instanciax varchar := p_id_instanciax::varchar; 
	v_id_usuario integer := p_id_usuario;
	v_no_login varchar := p_no_login;
	v_id_rol integer := 0;	
BEGIN
	if v_id_tipdoc is null then v_id_tipdoc = '%%'; end if;
	if v_nu_docide is null or v_nu_docide = '' then v_nu_docide = '%%'; end if;
	if v_id_cliente is null then v_id_cliente = '%%'; end if;
	if v_id_pedido is null then v_id_pedido = '%%'; end if;
	if v_id_estadoInstancia is null then v_id_estadoInstancia = '%%'; end if;
	if v_id_plan is null then v_id_plan = '%%'; end if;
	if v_id_instanciax is null then v_id_instanciax = '%%'; end if;
	if v_no_login = '' then v_no_login = null; end if;

	if v_id_tipoEstadoPedido is null then v_id_tipoEstadoPedido = '%%'; end if;

if v_id_usuario is not null then 
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = v_id_usuario limit 1;
	raise notice 'Entro primer if: %',v_id_rol;
else if v_no_login is not null then
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = (select id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1);
	select id_usuario into v_id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1;
	raise notice 'Entro segundo if: %',v_id_rol;
end if;
end if;
	
if v_id_rol <> 2 then -- Si no es cliente puede ver todos 2 = rol cliente 
	for v_va_return in  	
	 SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, 
		no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, 
		puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi, 
		no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,
		c.nu_docide,
		c.direccion,
		c.telefono,
		c.correo,
		c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,

		--(select sistema.array_agg(id_control) from sistema.tc_control_rol cr where id_rol = v_id_rol and id_estadoinst = i.id_estadoinst) as id_mostrar,
		(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido 
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;   
else -- sino osea si es cliente rol = 2 cliente, solo vera las instancias de ese usuario
for v_va_return in
	SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi,no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,c.nu_docide,c.direccion,c.telefono,c.correo,	c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,
		--(select sistema.array_agg(id_control) from sistema.tc_control_rol cr where id_rol = v_id_rol and id_estadoinst = i.id_estadoinst) as id_mostrar,
		(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar	
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p,
		sistema.tc_usuario_instancia ui	
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido
		and i.id_instancia = ui.id_instancia
		and ui.id_usuario = v_id_usuario
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;
end if;

     
return;
END;
$$;


ALTER FUNCTION sistema.fn_listar_instancias(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) OWNER TO tintegro;

--
-- TOC entry 254 (class 1255 OID 144618)
-- Name: fn_listar_instancias_new(integer, character varying, integer, integer, integer, integer, integer, integer, integer, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_listar_instancias_new(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) RETURNS SETOF tp_lista_instanciadetalle_new2
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_lista_instanciadetalle_new2%rowtype;

	v_id_tipdoc varchar := p_id_tipdoc::varchar; 
	v_nu_docide varchar := p_nu_docide;
	v_id_cliente varchar := p_id_cliente::varchar; 
	v_id_pedido varchar := p_id_pedido::varchar; 
	v_id_estadoInstancia varchar := p_id_estadoInstancia::varchar;
	v_id_plan varchar := p_id_plan::varchar; 
	v_id_tipoEstadoPedido varchar := p_id_tipoEstadoPedido::varchar;
	v_id_instanciax varchar := p_id_instanciax::varchar; 
	v_id_usuario integer := p_id_usuario;
	v_no_login varchar := p_no_login;
	v_id_rol integer := 0;	
BEGIN
	if v_id_tipdoc is null then v_id_tipdoc = '%%'; end if;
	if v_nu_docide is null or v_nu_docide = '' then v_nu_docide = '%%'; end if;
	if v_id_cliente is null then v_id_cliente = '%%'; end if;
	if v_id_pedido is null then v_id_pedido = '%%'; end if;
	if v_id_estadoInstancia is null then v_id_estadoInstancia = '%%'; end if;
	if v_id_plan is null then v_id_plan = '%%'; end if;
	if v_id_instanciax is null then v_id_instanciax = '%%'; end if;
	if v_no_login = '' then v_no_login = null; end if;

	if v_id_tipoEstadoPedido is null then v_id_tipoEstadoPedido = '%%'; end if;

if v_id_usuario is not null then 
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = v_id_usuario limit 1;
	raise notice 'Entro primer if: %',v_id_rol;
else if v_no_login is not null then
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = (select id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1);
	select id_usuario into v_id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1;
	raise notice 'Entro segundo if: %',v_id_rol;
end if;
end if;
	
if v_id_rol <> 2 then -- Si no es cliente puede ver todos 2 = rol cliente 
	for v_va_return in  	
	 SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, 
		no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, 
		puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi, 
		no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,
		c.nu_docide,
		c.direccion,
		c.telefono,
		c.correo,
		c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,

		(select replace(replace((sistema.array_agg(id_control))::varchar, '}', ''), '{', '') from sistema.tc_control_rol cr where id_rol = v_id_rol and id_estadoinst = i.id_estadoinst) as id_mostrar,
		--(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido 
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;   
else -- sino osea si es cliente rol = 2 cliente, solo vera las instancias de ese usuario
for v_va_return in
	SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi,no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,c.nu_docide,c.direccion,c.telefono,c.correo,	c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,
		(select replace(replace((sistema.array_agg(id_control))::varchar, '}', ''), '{', '') from sistema.tc_control_rol cr where id_rol = v_id_rol and id_estadoinst = i.id_estadoinst) as id_mostrar,
		--(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar	
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p,
		sistema.tc_usuario_instancia ui	
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido
		and i.id_instancia = ui.id_instancia
		and ui.id_usuario = v_id_usuario
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;
end if;

     
return;
END;
$$;


ALTER FUNCTION sistema.fn_listar_instancias_new(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) OWNER TO tintegro;

--
-- TOC entry 236 (class 1255 OID 136528)
-- Name: fn_listar_plan(); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_listar_plan() RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_resultado%rowtype;
 
BEGIN
for v_va_return in  

SELECT id_plan, no_plan  FROM sistema.tc_plan

loop 
return next v_va_return;
end loop;        
return;
END;
$$;


ALTER FUNCTION sistema.fn_listar_plan() OWNER TO tintegro;

--
-- TOC entry 228 (class 1255 OID 136473)
-- Name: fn_pedido_cliente(integer, integer, integer, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_pedido_cliente(p_id_tipodoc integer, p_id_cliente integer, p_id_pedido integer, p_id_estadiopedido integer) RETURNS SETOF tp_pedido_usuario
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_pedido_usuario%rowtype;

	v_id_tipodoc varchar := p_id_tipodoc; 
	v_id_cliente varchar := p_id_cliente; 
	v_id_pedido varchar := p_id_pedido; 
	v_id_estadiopedido varchar := p_id_estadiopedido;
 
BEGIN
	if v_id_tipodoc is null then v_id_tipodoc = '%%'; end if;
	if v_id_cliente is null then v_id_cliente  = '%%'; end if;
	if v_id_pedido  is null then v_id_pedido  = '%%'; end if;
	if v_id_estadiopedido is null then v_id_estadiopedido = '%%'; end if;

for v_va_return in  

SELECT c.no_razon_social, id_pedido, fe_pedido, p.id_cliente, ep.no_estadopedido
  FROM sistema.tb_pedido p,
	sistema.tb_cliente c,
	sistema.tc_estado_pedido ep
  where p.id_cliente = c.id_cliente
	and p.id_estadopedido = ep.id_estadopedido
	and (case when p.id_cliente is null then '' else p.id_cliente::varchar end) like v_id_cliente
	and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipodoc
	and (case when p.id_pedido is null then '' else p.id_pedido::varchar end) like v_id_pedido
	and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_estadiopedido
loop 
return next v_va_return;
end loop;        
return;
END;
$$;


ALTER FUNCTION sistema.fn_pedido_cliente(p_id_tipodoc integer, p_id_cliente integer, p_id_pedido integer, p_id_estadiopedido integer) OWNER TO tintegro;

--
-- TOC entry 248 (class 1255 OID 144794)
-- Name: fn_validar_control(character varying, integer, integer); Type: FUNCTION; Schema: sistema; Owner: postgres
--

CREATE FUNCTION fn_validar_control(p_no_login character varying, p_ti_elemto integer, p_id_estadoelemento integer) RETURNS SETOF character varying
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return varchar;  
	v_no_login character varying := p_no_login; 
	v_ti_elemto integer := p_ti_elemto;
	v_id_estadoelemento integer := p_id_estadoelemento;
	v_id_rol integer := 0;
BEGIN
	select id_rol into v_id_rol from oauth.tc_usuario_rol where id_usurol = (select id_usuario from oauth.tb_usuario where no_login = v_no_login);

	select (replace(replace((sistema.array_agg(cr.id_control))::varchar, '}', ''), '{', ''))::varchar into v_va_return
	from sistema.tc_control_rol cr, 
		sistema.tb_control  c
	where id_rol = v_id_rol 
	and cr.id_control = c.id_control
	and ti_elemento = v_ti_elemto 
	and id_estadoinst = v_id_estadoelemento;
	
     
return next v_va_return;
END;
$$;


ALTER FUNCTION sistema.fn_validar_control(p_no_login character varying, p_ti_elemto integer, p_id_estadoelemento integer) OWNER TO postgres;

--
-- TOC entry 253 (class 1255 OID 144789)
-- Name: fn_validar_control(integer, character varying, integer, integer, integer, integer, integer, integer, integer, character varying); Type: FUNCTION; Schema: sistema; Owner: postgres
--

CREATE FUNCTION fn_validar_control(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) RETURNS SETOF character varying
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return varchar;

	v_id_tipdoc varchar := p_id_tipdoc::varchar; 
	v_nu_docide varchar := p_nu_docide;
	v_id_cliente varchar := p_id_cliente::varchar; 
	v_id_pedido varchar := p_id_pedido::varchar; 
	v_id_estadoInstancia varchar := p_id_estadoInstancia::varchar;
	v_id_plan varchar := p_id_plan::varchar; 
	v_id_tipoEstadoPedido varchar := p_id_tipoEstadoPedido::varchar;
	v_id_instanciax varchar := p_id_instanciax::varchar; 
	v_id_usuario integer := p_id_usuario;
	v_no_login varchar := p_no_login;
	v_id_rol integer := 0;	
BEGIN
	if v_id_tipdoc is null then v_id_tipdoc = '%%'; end if;
	if v_nu_docide is null or v_nu_docide = '' then v_nu_docide = '%%'; end if;
	if v_id_cliente is null then v_id_cliente = '%%'; end if;
	if v_id_pedido is null then v_id_pedido = '%%'; end if;
	if v_id_estadoInstancia is null then v_id_estadoInstancia = '%%'; end if;
	if v_id_plan is null then v_id_plan = '%%'; end if;
	if v_id_instanciax is null then v_id_instanciax = '%%'; end if;
	if v_no_login = '' then v_no_login = null; end if;

	if v_id_tipoEstadoPedido is null then v_id_tipoEstadoPedido = '%%'; end if;

if v_id_usuario is not null then 
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = v_id_usuario limit 1;
	raise notice 'Entro primer if: %',v_id_rol;
else if v_no_login is not null then
	select  id_rol into v_id_rol from oauth.tc_usuario_rol where id_usuario = (select id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1);
	select id_usuario into v_id_usuario from oauth.tb_usuario where no_login = v_no_login limit 1;
	raise notice 'Entro segundo if: %',v_id_rol;
end if;
end if;
	
if v_id_rol <> 2 then -- Si no es cliente puede ver todos 2 = rol cliente 
	for v_va_return in  	
	 SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, 
		no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, 
		puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi, 
		no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,
		c.nu_docide,
		c.direccion,
		c.telefono,
		c.correo,
		c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,

		(select replace(replace((sistema.array_agg(id_control))::varchar, '}', ''), '{', '') from sistema.tc_control_rol cr where id_rol = v_id_rol and ti_elemento = 1 and id_estadoinst = i.id_estadoinst) as id_mostrar,
		--(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido 
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;   
else -- sino osea si es cliente rol = 2 cliente, solo vera las instancias de ese usuario
for v_va_return in
	SELECT  i.id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, i.id_cliente, 
		il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, puerto_openvpn, ip_confinicial, mask_subredconfinicial, 
		pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi,no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, i.id_estadoinst, 
		(select no_estadoinst from sistema.tc_estado_instancia where id_estadoinst = i.id_estadoinst limit 1) as no_estadoinstancia,
		c.no_razon_social,c.nu_docide,c.direccion,c.telefono,c.correo,	c.personareferencia,
		(select no_plan from sistema.tc_plan where id_plan = (select id_plan from sistema.tc_detallepedido where id_instancia = i.id_instancia limit 1)) as no_plan,
		(select replace(replace((sistema.array_agg(id_control))::varchar, '}', ''), '{', '') from sistema.tc_control_rol cr where id_rol = v_id_rol and id_estadoinst = i.id_estadoinst) as id_mostrar,
		--(case when i.id_estadoinst < 3 then 0 else 1 end) as id_mostrar,
		p.fe_pedido::date::varchar	
	from sistema.tb_instancia i, 
		sistema.tb_cliente c,	
		sistema.tc_detallepedido dp,
		sistema.tb_pedido p,
		sistema.tc_usuario_instancia ui	
	where i.id_cliente = c.id_cliente
		and (case when i.id_instancia is null then '' else i.id_instancia::varchar end) like v_id_instanciax
		and (case when c.id_tipdoc is null then '' else c.id_tipdoc::varchar end) like v_id_tipdoc
		and (case when c.nu_docide is null then '' else c.nu_docide end) like v_nu_docide
		and (case when c.id_cliente is null then '' else c.id_cliente::varchar end)like v_id_cliente
		and i.id_instancia = dp.id_instancia
		and (case when dp.id_pedido is null then '' else dp.id_pedido::varchar end) like v_id_pedido
		and (case when i.id_estadoinst is null then '' else i.id_estadoinst::varchar end) like v_id_estadoInstancia
		and (case when dp.id_plan is null then '' else dp.id_plan::varchar end) like v_id_plan
		and dp.id_pedido = p.id_pedido
		and (case when p.id_estadopedido is null then '' else p.id_estadopedido::varchar end) like v_id_tipoEstadoPedido
		and i.id_instancia = ui.id_instancia
		and ui.id_usuario = v_id_usuario
		order by p.fe_pedido desc
	loop 
	return next v_va_return;
	end loop;
end if;

     
return;
END;
$$;


ALTER FUNCTION sistema.fn_validar_control(p_id_tipdoc integer, p_nu_docide character varying, p_id_cliente integer, p_id_pedido integer, p_id_estadoinstancia integer, p_id_plan integer, p_id_tipoestadopedido integer, p_id_instanciax integer, p_id_usuario integer, p_no_login character varying) OWNER TO postgres;

--
-- TOC entry 249 (class 1255 OID 144541)
-- Name: fn_validar_instancia_por_usuario(character varying, integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION fn_validar_instancia_por_usuario(p_no_login character varying, p_id_instancia integer) RETURNS SETOF tp_resultado
    LANGUAGE plpgsql
    AS $$
DECLARE
	v_va_return sistema.tp_resultado%rowtype;
	v_no_login character varying := p_no_login; 
	v_id_instancia integer := p_id_instancia;
	v_id_usuario integer := 0;
	
	
BEGIN	
	select id_usuario into v_id_usuario from oauth.tb_usuario where no_login = v_no_login;
	if (select id_usuins from sistema.tc_usuario_instancia where id_usuario = v_id_usuario and id_instancia = v_id_instancia) is not null then 
		select 1, 'OK' into v_va_return;
	else 
		select 0, 'denegado' into v_va_return;
	end if;
return next v_va_return;

END;
$$;


ALTER FUNCTION sistema.fn_validar_instancia_por_usuario(p_no_login character varying, p_id_instancia integer) OWNER TO tintegro;

--
-- TOC entry 217 (class 1255 OID 78980)
-- Name: listar_clientes(); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION listar_clientes() RETURNS SETOF tp_listar_clientes
    LANGUAGE plpgsql
    AS $$
DECLARE
  v_va_return sistema.tp_listar_clientes%rowtype;
 
BEGIN
    for v_va_return in  

select id_cliente,no_razon_social,ruc,direccion,telefono,correo,personareferencia,estado From sistema.cliente

  loop 
  return next v_va_return;
  end loop;        
 return;
END;
$$;


ALTER FUNCTION sistema.listar_clientes() OWNER TO tintegro;

--
-- TOC entry 220 (class 1255 OID 78960)
-- Name: regitrarcliente(character varying, character varying, character varying, character varying, character varying, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION regitrarcliente(p_no_razon character varying, p_ruc character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_persref character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
salida integer := 0;
  v_no_razon varchar := p_no_razon;
  v_ruc varchar := p_ruc;
   v_direccion varchar := p_direccion;
  v_telefono varchar := p_telefono;
   v_correo varchar := p_correo;
   v_persRef varchar := p_persRef;
  
BEGIN

 INSERT INTO sistema.cliente(
            no_razon_social, ruc, direccion, telefono, correo, 
            personareferencia,estado)
    VALUES ( v_no_razon, v_ruc,v_direccion,v_telefono, v_correo,v_persRef,true);
 salida := 1;

 return salida;
END;
$$;


ALTER FUNCTION sistema.regitrarcliente(p_no_razon character varying, p_ruc character varying, p_direccion character varying, p_telefono character varying, p_correo character varying, p_persref character varying) OWNER TO tintegro;

--
-- TOC entry 216 (class 1255 OID 78994)
-- Name: sp_buscar_instancia_x_id(integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION sp_buscar_instancia_x_id(p_id_instancia integer) RETURNS SETOF tp_buscar_instancia_x_id
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return sistema.tp_buscar_instancia_x_id%rowtype;
  v_id_instancia integer := p_id_instancia;
  BEGIN
   FOR v_va_return IN
    SELECT id_instancia,id_cliente from sistema.instancia where id_instancia=v_id_instancia
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
 END;
$$;


ALTER FUNCTION sistema.sp_buscar_instancia_x_id(p_id_instancia integer) OWNER TO tintegro;

--
-- TOC entry 227 (class 1255 OID 79053)
-- Name: sp_buscar_instancia_x_id_cliente(integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION sp_buscar_instancia_x_id_cliente(p_id_cliente integer) RETURNS SETOF tp_lista_instancia_x_idcliente
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return sistema.tp_lista_instancia_x_idcliente%rowtype;
  v_id_cliente integer := p_id_cliente;
  BEGIN
   FOR v_va_return IN
    SELECT id_instancia,ip_red,nro_vlan,ip_asterisk,ip_median,no_mascara,no_iprouter,
    no_dns_1,no_dns_2,no_subnet,no_broadcast,puerto_asterisk_bash_certificado_ext,
    id_cliente,il_estado,il_libre,ipasteriskbash from sistema.instancia where id_cliente=v_id_cliente
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
 END;
$$;


ALTER FUNCTION sistema.sp_buscar_instancia_x_id_cliente(p_id_cliente integer) OWNER TO tintegro;

--
-- TOC entry 218 (class 1255 OID 70721)
-- Name: sp_ins_instancia(integer); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION sp_ins_instancia(p_id_cliente integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	salida integer := 0;
	
	v_id_cliente integer := p_id_cliente;
BEGIN

INSERT INTO sistema.instancia (
	id_cliente
) VALUES (
	v_id_cliente
);
salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION sistema.sp_ins_instancia(p_id_cliente integer) OWNER TO tintegro;

--
-- TOC entry 231 (class 1255 OID 79049)
-- Name: sp_ins_instancia(character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, integer, integer, character varying); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION sp_ins_instancia(p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_puerto_asterisk_bash_certificado_ext integer, p_id_cliente integer, p_ipasteriskbash character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	salida integer := 0;
	
	v_id_cliente integer := p_id_cliente;
	v_ip_red character varying := p_ip_red;
	v_nro_vlan integer := p_nro_vlan;
	v_ip_asterisk character varying := p_ip_asterisk;
	v_ip_median character varying := p_ip_median;
	v_no_mascara character varying := p_no_mascara;
	v_no_iprouter character varying := p_no_iprouter;
	v_no_dns_1 character varying := p_no_dns_1;
	v_no_dns_2 character varying := p_no_dns_2;
	v_no_subnet character varying := p_no_subnet;
	v_no_broadcast character varying := p_no_broadcast;
	v_puerto_asterisk_bash_certificado_ext integer := p_puerto_asterisk_bash_certificado_ext;
	v_ipasteriskbash character varying := p_ipasteriskbash;
BEGIN

INSERT INTO sistema.instancia(
           ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, 
            no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, puerto_asterisk_bash_certificado_ext, 
            id_cliente, il_estado, il_libre, ipasteriskbash)
    VALUES (v_ip_red, v_nro_vlan, v_ip_asterisk, v_ip_median, v_no_mascara, v_no_iprouter, 
             v_no_dns_1, v_no_dns_2, v_no_subnet,v_no_broadcast, v_puerto_asterisk_bash_certificado_ext, 
            v_id_cliente, true, true, v_ipasteriskbash);

salida := 1;
RETURN salida;
END;
$$;


ALTER FUNCTION sistema.sp_ins_instancia(p_ip_red character varying, p_nro_vlan integer, p_ip_asterisk character varying, p_ip_median character varying, p_no_mascara character varying, p_no_iprouter character varying, p_no_dns_1 character varying, p_no_dns_2 character varying, p_no_subnet character varying, p_no_broadcast character varying, p_puerto_asterisk_bash_certificado_ext integer, p_id_cliente integer, p_ipasteriskbash character varying) OWNER TO tintegro;

--
-- TOC entry 215 (class 1255 OID 70720)
-- Name: sp_lista_instancia(); Type: FUNCTION; Schema: sistema; Owner: tintegro
--

CREATE FUNCTION sp_lista_instancia() RETURNS SETOF tp_lista_instancia
    LANGUAGE plpgsql
    AS $$
 DECLARE
  v_va_return sistema.tp_lista_instancia%rowtype;
  BEGIN
   FOR v_va_return IN
    SELECT  id_instancia,id_cliente from sistema.instancia
   LOOP
    RETURN NEXT v_va_return;
   END LOOP;
 END;
$$;


ALTER FUNCTION sistema.sp_lista_instancia() OWNER TO tintegro;

SET search_path = public, pg_catalog;

--
-- TOC entry 704 (class 1255 OID 144611)
-- Name: array_agg(anyelement); Type: AGGREGATE; Schema: public; Owner: tintegro
--

CREATE AGGREGATE array_agg(anyelement) (
    SFUNC = array_append,
    STYPE = anyarray,
    INITCOND = '{}'
);


ALTER AGGREGATE public.array_agg(anyelement) OWNER TO tintegro;

SET search_path = sistema, pg_catalog;

--
-- TOC entry 705 (class 1255 OID 144614)
-- Name: array_agg(anyelement); Type: AGGREGATE; Schema: sistema; Owner: tintegro
--

CREATE AGGREGATE array_agg(anyelement) (
    SFUNC = array_append,
    STYPE = anyarray,
    INITCOND = '{}'
);


ALTER AGGREGATE sistema.array_agg(anyelement) OWNER TO tintegro;

SET search_path = oauth, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 136585)
-- Name: tb_client_details; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tb_client_details (
    id_client_details integer NOT NULL,
    no_client_id character varying,
    no_client character varying,
    no_ids_resources character varying,
    no_client_secret character varying,
    no_scope character varying,
    no_authorized_grant_types character varying,
    no_web_server_redirect_uri character varying,
    no_authorities character varying,
    no_access_token_validity integer,
    no_refresh_access_token_validity integer,
    no_aditional_information character varying,
    no_autoapprove character varying
);


ALTER TABLE tb_client_details OWNER TO tintegro;

--
-- TOC entry 182 (class 1259 OID 136583)
-- Name: tb_client_details_id_client_details_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tb_client_details_id_client_details_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_client_details_id_client_details_seq OWNER TO tintegro;

--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 182
-- Name: tb_client_details_id_client_details_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tb_client_details_id_client_details_seq OWNED BY tb_client_details.id_client_details;


--
-- TOC entry 169 (class 1259 OID 136420)
-- Name: tb_rol; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tb_rol (
    id_rol integer NOT NULL,
    no_rol character varying,
    no_descri character varying,
    il_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tb_rol OWNER TO tintegro;

--
-- TOC entry 168 (class 1259 OID 136418)
-- Name: tb_rol_id_rol_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tb_rol_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_rol_id_rol_seq OWNER TO tintegro;

--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 168
-- Name: tb_rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tb_rol_id_rol_seq OWNED BY tb_rol.id_rol;


--
-- TOC entry 187 (class 1259 OID 136666)
-- Name: tb_servicio; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tb_servicio (
    id_servicio integer NOT NULL,
    no_servicio character varying,
    no_caso_uso character varying,
    no_url character varying,
    id_instancia_ovligatorio integer
);


ALTER TABLE tb_servicio OWNER TO tintegro;

--
-- TOC entry 186 (class 1259 OID 136664)
-- Name: tb_servicio_id_servicio_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tb_servicio_id_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_servicio_id_servicio_seq OWNER TO tintegro;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 186
-- Name: tb_servicio_id_servicio_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tb_servicio_id_servicio_seq OWNED BY tb_servicio.id_servicio;


--
-- TOC entry 171 (class 1259 OID 136432)
-- Name: tb_usuario; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tb_usuario (
    id_usuario integer NOT NULL,
    no_login character varying NOT NULL,
    no_passwo character varying NOT NULL,
    no_nombre character varying NOT NULL,
    no_apelli character varying NOT NULL,
    no_email character varying NOT NULL,
    no_profe character varying,
    il_activo boolean DEFAULT true NOT NULL,
    fe_creaci date DEFAULT ('now'::text)::date,
    il_account_non_expired boolean DEFAULT true,
    il_credential_non_expired boolean DEFAULT true,
    il_account_non_locked boolean DEFAULT true
);


ALTER TABLE tb_usuario OWNER TO tintegro;

--
-- TOC entry 170 (class 1259 OID 136430)
-- Name: tb_usuario_id_usuario_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tb_usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_usuario_id_usuario_seq OWNER TO tintegro;

--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 170
-- Name: tb_usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tb_usuario_id_usuario_seq OWNED BY tb_usuario.id_usuario;


--
-- TOC entry 189 (class 1259 OID 136677)
-- Name: tc_servicio_rol; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tc_servicio_rol (
    id_ser_rol integer NOT NULL,
    id_servicio integer,
    id_rol integer
);


ALTER TABLE tc_servicio_rol OWNER TO tintegro;

--
-- TOC entry 188 (class 1259 OID 136675)
-- Name: tc_servicio_rol_id_ser_rol_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tc_servicio_rol_id_ser_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_servicio_rol_id_ser_rol_seq OWNER TO tintegro;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 188
-- Name: tc_servicio_rol_id_ser_rol_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tc_servicio_rol_id_ser_rol_seq OWNED BY tc_servicio_rol.id_ser_rol;


--
-- TOC entry 173 (class 1259 OID 136445)
-- Name: tc_usuario_rol; Type: TABLE; Schema: oauth; Owner: tintegro
--

CREATE TABLE tc_usuario_rol (
    id_usurol integer NOT NULL,
    id_usuario integer,
    id_rol integer
);


ALTER TABLE tc_usuario_rol OWNER TO tintegro;

--
-- TOC entry 172 (class 1259 OID 136443)
-- Name: tc_usuario_rol_id_usurol_seq; Type: SEQUENCE; Schema: oauth; Owner: tintegro
--

CREATE SEQUENCE tc_usuario_rol_id_usurol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_usuario_rol_id_usurol_seq OWNER TO tintegro;

--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 172
-- Name: tc_usuario_rol_id_usurol_seq; Type: SEQUENCE OWNED BY; Schema: oauth; Owner: tintegro
--

ALTER SEQUENCE tc_usuario_rol_id_usurol_seq OWNED BY tc_usuario_rol.id_usurol;


SET search_path = public, pg_catalog;

--
-- TOC entry 199 (class 1259 OID 144643)
-- Name: oauth_access_token; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_access_token (
    token_id character varying(256),
    token bytea,
    authentication_id character varying(256) NOT NULL,
    user_name character varying(256),
    client_id character varying(256),
    authentication bytea,
    refresh_token character varying(256)
);


ALTER TABLE oauth_access_token OWNER TO tintegro;

--
-- TOC entry 202 (class 1259 OID 144663)
-- Name: oauth_approvals; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_approvals (
    userid character varying(256),
    clientid character varying(256),
    scope character varying(256),
    status character varying(10),
    expiresat timestamp without time zone,
    lastmodifiedat timestamp without time zone
);


ALTER TABLE oauth_approvals OWNER TO tintegro;

--
-- TOC entry 197 (class 1259 OID 144627)
-- Name: oauth_client_details; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_client_details (
    client_id character varying(256) NOT NULL,
    resource_ids character varying(256),
    client_secret character varying(256),
    scope character varying(256),
    authorized_grant_types character varying(256),
    web_server_redirect_uri character varying(256),
    authorities character varying(256),
    access_token_validity integer,
    refresh_token_validity integer,
    additional_information character varying(4096),
    autoapprove character varying(256)
);


ALTER TABLE oauth_client_details OWNER TO tintegro;

--
-- TOC entry 198 (class 1259 OID 144635)
-- Name: oauth_client_token; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_client_token (
    token_id character varying(256),
    token bytea,
    authentication_id character varying(256) NOT NULL,
    user_name character varying(256),
    client_id character varying(256)
);


ALTER TABLE oauth_client_token OWNER TO tintegro;

--
-- TOC entry 201 (class 1259 OID 144657)
-- Name: oauth_code; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_code (
    code character varying(256),
    authentication bytea
);


ALTER TABLE oauth_code OWNER TO tintegro;

--
-- TOC entry 200 (class 1259 OID 144651)
-- Name: oauth_refresh_token; Type: TABLE; Schema: public; Owner: tintegro
--

CREATE TABLE oauth_refresh_token (
    token_id character varying(256),
    token bytea,
    authentication bytea
);


ALTER TABLE oauth_refresh_token OWNER TO tintegro;

SET search_path = sistema, pg_catalog;

--
-- TOC entry 144 (class 1259 OID 78937)
-- Name: tb_cliente; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tb_cliente (
    id_cliente integer NOT NULL,
    no_razon_social character varying(100),
    nu_docide character varying(20),
    direccion character varying(100),
    telefono character varying(20),
    correo character varying(50),
    personareferencia character varying(50),
    estado boolean,
    id_tipdoc integer
);


ALTER TABLE tb_cliente OWNER TO tintegro;

--
-- TOC entry 143 (class 1259 OID 78935)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_id_cliente_seq OWNER TO tintegro;

--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 143
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE cliente_id_cliente_seq OWNED BY tb_cliente.id_cliente;


--
-- TOC entry 146 (class 1259 OID 78945)
-- Name: tb_instancia; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tb_instancia (
    id_instancia integer NOT NULL,
    ip_red character varying(100),
    nro_vlan integer,
    ip_asterisk character varying(100),
    ip_median character varying(100),
    no_mascara character varying(100),
    no_iprouter character varying(100),
    no_dns_1 character varying(100),
    no_dns_2 character varying(100),
    no_subnet character varying(100),
    no_broadcast character varying(100),
    id_cliente integer,
    il_estado boolean,
    il_libre boolean,
    ipasteriskbash character varying(100),
    puerto_asterisk_bash_certificado_ext integer,
    puerto_openvpn character varying,
    ip_confinicial character varying,
    mask_subredconfinicial character varying,
    pam_confinicial character varying,
    sim_pais character varying,
    sim_provincia character varying,
    full_provincia character varying,
    no_organi character varying,
    no_email character varying,
    id_modelo integer,
    id_marca integer,
    no_modelo character varying,
    no_marca character varying,
    inicial integer,
    id_estadoinst integer DEFAULT 1
);


ALTER TABLE tb_instancia OWNER TO tintegro;

--
-- TOC entry 145 (class 1259 OID 78943)
-- Name: instancia_id_instancia_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE instancia_id_instancia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE instancia_id_instancia_seq OWNER TO tintegro;

--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 145
-- Name: instancia_id_instancia_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE instancia_id_instancia_seq OWNED BY tb_instancia.id_instancia;


--
-- TOC entry 193 (class 1259 OID 144569)
-- Name: tb_control; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tb_control (
    id_control integer NOT NULL,
    no_control character varying,
    no_descrip character varying,
    ti_elemento integer,
    no_desc_elemento character varying
);


ALTER TABLE tb_control OWNER TO tintegro;

--
-- TOC entry 192 (class 1259 OID 144567)
-- Name: tb_control_id_control_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tb_control_id_control_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_control_id_control_seq OWNER TO tintegro;

--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 192
-- Name: tb_control_id_control_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tb_control_id_control_seq OWNED BY tb_control.id_control;


--
-- TOC entry 155 (class 1259 OID 128191)
-- Name: tb_pedido; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tb_pedido (
    id_pedido integer NOT NULL,
    fe_pedido date,
    id_cliente integer,
    id_estadopedido integer
);


ALTER TABLE tb_pedido OWNER TO tintegro;

--
-- TOC entry 154 (class 1259 OID 128189)
-- Name: tb_pedido_id_pedido_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tb_pedido_id_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tb_pedido_id_pedido_seq OWNER TO tintegro;

--
-- TOC entry 2188 (class 0 OID 0)
-- Dependencies: 154
-- Name: tb_pedido_id_pedido_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tb_pedido_id_pedido_seq OWNED BY tb_pedido.id_pedido;


--
-- TOC entry 147 (class 1259 OID 78965)
-- Name: tc_cliente_eliminado; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_cliente_eliminado (
    id_cliente_eli integer NOT NULL,
    no_razon_social character varying(100),
    ruc character varying(20),
    direccion character varying(100),
    telefono character varying(20),
    correo character varying(50),
    personareferencia character varying(50),
    estado boolean
);


ALTER TABLE tc_cliente_eliminado OWNER TO tintegro;

--
-- TOC entry 195 (class 1259 OID 144580)
-- Name: tc_control_rol; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_control_rol (
    id_control_rol integer NOT NULL,
    id_control integer,
    id_rol integer,
    id_estadoinst integer
);


ALTER TABLE tc_control_rol OWNER TO tintegro;

--
-- TOC entry 194 (class 1259 OID 144578)
-- Name: tc_control_rol_id_control_rol_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_control_rol_id_control_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_control_rol_id_control_rol_seq OWNER TO tintegro;

--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 194
-- Name: tc_control_rol_id_control_rol_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_control_rol_id_control_rol_seq OWNED BY tc_control_rol.id_control_rol;


--
-- TOC entry 163 (class 1259 OID 128239)
-- Name: tc_detallepedido; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_detallepedido (
    id_detapedido integer NOT NULL,
    no_detapedido character varying,
    id_tipopedido integer,
    id_pedido integer,
    id_tipodetalle integer,
    id_plan integer,
    id_instancia integer,
    id_cliente integer
);


ALTER TABLE tc_detallepedido OWNER TO tintegro;

--
-- TOC entry 162 (class 1259 OID 128237)
-- Name: tc_detallepedido_id_detapedido_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_detallepedido_id_detapedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_detallepedido_id_detapedido_seq OWNER TO tintegro;

--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 162
-- Name: tc_detallepedido_id_detapedido_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_detallepedido_id_detapedido_seq OWNED BY tc_detallepedido.id_detapedido;


--
-- TOC entry 164 (class 1259 OID 128298)
-- Name: tc_estado_instancia; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_estado_instancia (
    id_estadoinst integer NOT NULL,
    no_estadoinst character varying
);


ALTER TABLE tc_estado_instancia OWNER TO tintegro;

--
-- TOC entry 166 (class 1259 OID 128334)
-- Name: tc_estado_pedido; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_estado_pedido (
    id_estadopedido integer NOT NULL,
    no_estadopedido character varying
);


ALTER TABLE tc_estado_pedido OWNER TO tintegro;

--
-- TOC entry 165 (class 1259 OID 128332)
-- Name: tc_estado_pedido_id_estadopedido_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_estado_pedido_id_estadopedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_estado_pedido_id_estadopedido_seq OWNER TO tintegro;

--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 165
-- Name: tc_estado_pedido_id_estadopedido_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_estado_pedido_id_estadopedido_seq OWNED BY tc_estado_pedido.id_estadopedido;


--
-- TOC entry 161 (class 1259 OID 128225)
-- Name: tc_plan; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_plan (
    id_plan integer NOT NULL,
    no_plan character varying
);


ALTER TABLE tc_plan OWNER TO tintegro;

--
-- TOC entry 160 (class 1259 OID 128223)
-- Name: tc_plan_id_plan_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_plan_id_plan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_plan_id_plan_seq OWNER TO tintegro;

--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 160
-- Name: tc_plan_id_plan_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_plan_id_plan_seq OWNED BY tc_plan.id_plan;


--
-- TOC entry 159 (class 1259 OID 128214)
-- Name: tc_tipo_detalle; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_tipo_detalle (
    id_tipodetalle integer NOT NULL,
    no_ripodetalle character varying
);


ALTER TABLE tc_tipo_detalle OWNER TO tintegro;

--
-- TOC entry 158 (class 1259 OID 128212)
-- Name: tc_tipo_detalle_id_tipodetalle_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_tipo_detalle_id_tipodetalle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_tipo_detalle_id_tipodetalle_seq OWNER TO tintegro;

--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 158
-- Name: tc_tipo_detalle_id_tipodetalle_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_tipo_detalle_id_tipodetalle_seq OWNED BY tc_tipo_detalle.id_tipodetalle;


--
-- TOC entry 157 (class 1259 OID 128201)
-- Name: tc_tipo_pedido; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_tipo_pedido (
    id_tipopedido integer NOT NULL,
    no_tipopedido character varying
);


ALTER TABLE tc_tipo_pedido OWNER TO tintegro;

--
-- TOC entry 156 (class 1259 OID 128199)
-- Name: tc_tipo_pedido_id_tipperdido_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_tipo_pedido_id_tipperdido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_tipo_pedido_id_tipperdido_seq OWNER TO tintegro;

--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 156
-- Name: tc_tipo_pedido_id_tipperdido_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_tipo_pedido_id_tipperdido_seq OWNED BY tc_tipo_pedido.id_tipopedido;


--
-- TOC entry 153 (class 1259 OID 128156)
-- Name: tc_tipodoc; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_tipodoc (
    id_tipdoc integer NOT NULL,
    no_tipo character varying
);


ALTER TABLE tc_tipodoc OWNER TO tintegro;

--
-- TOC entry 152 (class 1259 OID 128154)
-- Name: tc_tipodoc_id_tipdoc_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_tipodoc_id_tipdoc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_tipodoc_id_tipdoc_seq OWNER TO tintegro;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 152
-- Name: tc_tipodoc_id_tipdoc_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_tipodoc_id_tipdoc_seq OWNED BY tc_tipodoc.id_tipdoc;


--
-- TOC entry 181 (class 1259 OID 136562)
-- Name: tc_usuario_instancia; Type: TABLE; Schema: sistema; Owner: tintegro
--

CREATE TABLE tc_usuario_instancia (
    id_usuins integer NOT NULL,
    id_usuario integer,
    id_instancia integer
);


ALTER TABLE tc_usuario_instancia OWNER TO tintegro;

--
-- TOC entry 180 (class 1259 OID 136560)
-- Name: tc_usuario_instancia_id_usuins_seq; Type: SEQUENCE; Schema: sistema; Owner: tintegro
--

CREATE SEQUENCE tc_usuario_instancia_id_usuins_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tc_usuario_instancia_id_usuins_seq OWNER TO tintegro;

--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 180
-- Name: tc_usuario_instancia_id_usuins_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: tintegro
--

ALTER SEQUENCE tc_usuario_instancia_id_usuins_seq OWNED BY tc_usuario_instancia.id_usuins;


SET search_path = oauth, pg_catalog;

--
-- TOC entry 1970 (class 2604 OID 136588)
-- Name: id_client_details; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_client_details ALTER COLUMN id_client_details SET DEFAULT nextval('tb_client_details_id_client_details_seq'::regclass);


--
-- TOC entry 1960 (class 2604 OID 136423)
-- Name: id_rol; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_rol ALTER COLUMN id_rol SET DEFAULT nextval('tb_rol_id_rol_seq'::regclass);


--
-- TOC entry 1971 (class 2604 OID 136669)
-- Name: id_servicio; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_servicio ALTER COLUMN id_servicio SET DEFAULT nextval('tb_servicio_id_servicio_seq'::regclass);


--
-- TOC entry 1962 (class 2604 OID 136435)
-- Name: id_usuario; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_usuario ALTER COLUMN id_usuario SET DEFAULT nextval('tb_usuario_id_usuario_seq'::regclass);


--
-- TOC entry 1972 (class 2604 OID 136680)
-- Name: id_ser_rol; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_servicio_rol ALTER COLUMN id_ser_rol SET DEFAULT nextval('tc_servicio_rol_id_ser_rol_seq'::regclass);


--
-- TOC entry 1968 (class 2604 OID 136448)
-- Name: id_usurol; Type: DEFAULT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_rol ALTER COLUMN id_usurol SET DEFAULT nextval('tc_usuario_rol_id_usurol_seq'::regclass);


SET search_path = sistema, pg_catalog;

--
-- TOC entry 1950 (class 2604 OID 78940)
-- Name: id_cliente; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq'::regclass);


--
-- TOC entry 1973 (class 2604 OID 144572)
-- Name: id_control; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_control ALTER COLUMN id_control SET DEFAULT nextval('tb_control_id_control_seq'::regclass);


--
-- TOC entry 1951 (class 2604 OID 78948)
-- Name: id_instancia; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_instancia ALTER COLUMN id_instancia SET DEFAULT nextval('instancia_id_instancia_seq'::regclass);


--
-- TOC entry 1954 (class 2604 OID 128194)
-- Name: id_pedido; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_pedido ALTER COLUMN id_pedido SET DEFAULT nextval('tb_pedido_id_pedido_seq'::regclass);


--
-- TOC entry 1974 (class 2604 OID 144583)
-- Name: id_control_rol; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_control_rol ALTER COLUMN id_control_rol SET DEFAULT nextval('tc_control_rol_id_control_rol_seq'::regclass);


--
-- TOC entry 1958 (class 2604 OID 128242)
-- Name: id_detapedido; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido ALTER COLUMN id_detapedido SET DEFAULT nextval('tc_detallepedido_id_detapedido_seq'::regclass);


--
-- TOC entry 1959 (class 2604 OID 128337)
-- Name: id_estadopedido; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_estado_pedido ALTER COLUMN id_estadopedido SET DEFAULT nextval('tc_estado_pedido_id_estadopedido_seq'::regclass);


--
-- TOC entry 1957 (class 2604 OID 128228)
-- Name: id_plan; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_plan ALTER COLUMN id_plan SET DEFAULT nextval('tc_plan_id_plan_seq'::regclass);


--
-- TOC entry 1956 (class 2604 OID 128217)
-- Name: id_tipodetalle; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipo_detalle ALTER COLUMN id_tipodetalle SET DEFAULT nextval('tc_tipo_detalle_id_tipodetalle_seq'::regclass);


--
-- TOC entry 1955 (class 2604 OID 128204)
-- Name: id_tipopedido; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipo_pedido ALTER COLUMN id_tipopedido SET DEFAULT nextval('tc_tipo_pedido_id_tipperdido_seq'::regclass);


--
-- TOC entry 1953 (class 2604 OID 128159)
-- Name: id_tipdoc; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipodoc ALTER COLUMN id_tipdoc SET DEFAULT nextval('tc_tipodoc_id_tipdoc_seq'::regclass);


--
-- TOC entry 1969 (class 2604 OID 136565)
-- Name: id_usuins; Type: DEFAULT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_instancia ALTER COLUMN id_usuins SET DEFAULT nextval('tc_usuario_instancia_id_usuins_seq'::regclass);


SET search_path = oauth, pg_catalog;

--
-- TOC entry 2157 (class 0 OID 136585)
-- Dependencies: 183
-- Data for Name: tb_client_details; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tb_client_details (id_client_details, no_client_id, no_client, no_ids_resources, no_client_secret, no_scope, no_authorized_grant_types, no_web_server_redirect_uri, no_authorities, no_access_token_validity, no_refresh_access_token_validity, no_aditional_information, no_autoapprove) FROM stdin;
1	sic-frontend	Sistema Integral de Comunicaciones | T-Integro	sic-ws	1234567890987654321	read,write	password,refresh_token,client_credentials	http://192.168.3.202:9090/sic-ws/	Cliente	300	600	\N	\N
\.


--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 182
-- Name: tb_client_details_id_client_details_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tb_client_details_id_client_details_seq', 1, true);


--
-- TOC entry 2149 (class 0 OID 136420)
-- Dependencies: 169
-- Data for Name: tb_rol; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tb_rol (id_rol, no_rol, no_descri, il_activo) FROM stdin;
1	Administrador	Administrador	t
2	Cliente	Cliente	t
3	Implementador	Implementador	t
4	Operador mesa de ayuda	Operador mesa de ayuda	t
6	Instalador	Instalador	t
7	Supervisor de Instalacion	Supervisor de Instalacion	t
5	Supervisor de Implementacion	Supervisor de Implementacion	t
\.


--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 168
-- Name: tb_rol_id_rol_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tb_rol_id_rol_seq', 7, true);


--
-- TOC entry 2159 (class 0 OID 136666)
-- Dependencies: 187
-- Data for Name: tb_servicio; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tb_servicio (id_servicio, no_servicio, no_caso_uso, no_url, id_instancia_ovligatorio) FROM stdin;
11	Eliminar usuario	CU_Permiso de llamadas	/sic-ws/tbUsuario/eliminarUsuario	1
13	Listar extencion	CU_Permiso de llamadas	/sic-ws/extension/listarExtension	1
15	Descargar permiso de llamada	CU_Descarga_Permisos_Llamadas	/sic-ws/excelPermisosUsuario/descarga	1
16	Listar marca 	CUS_Anexos_Cloud	/sic-ws/marcaTelefono/listar	1
17	Listar Modelo por marca	CUS_Anexos_Cloud	/sic-ws/modeloTelefono/listarPorMarca	1
14	Cargar Permiso de llamada	CU_Cargar_Permisos_Llamadas	/sic-ws/excelPermisosUsuario/carga	1
18	Listar telfono	CUS_Anexos_Cloud	/sic-ws/sipTelefono/listar	1
19	Insertar Anexo	CUS_Anexos_Cloud	/sic-ws/sipBuddie/insertarAnexo	1
20	Editar Anexo	CUS_Anexos_Cloud	/sic-ws/sipBuddie/editarAnexo	1
21	Eliminar Anexo	CUS_Anexos_Cloud	/sic-ws/sipBuddie/eliminarAnexo	1
22	Cargar excel sip	CUS_Cargar_Excel_Sip	/sc-ws/cargaExcelSipBuddie/cargar	1
23	Descargar excel sip	CUS_Descargar_Excel_Sip	/sc-ws/cargaExcelSipBuddie/descarga	1
25	Listar centro de costo por area	CUS_Area Centro de Costo	/sic-ws/areaCentroCosto/listarCentroxArea	1
26	Insertar area	CUS_Area Centro de Costo	/sic-ws/areaCentroCosto/insertarArea	1
27	Actualizar area	CUS_Area Centro de Costo	/sic-ws/areaCentroCosto/actualizarArea	1
10	Actualizar Usuario	CU_Permiso de llamadas	/sic-ws/tbUsuario/actualizarUsuario	1
12	Modificar flag usuarioPin	CU_Permiso de llamadas	/sic-ws/tbUsuario/modificarFlagUsuarioPin	1
32	Reporte Llamadas generales	CU_Reporte Llamadas Generales	/sic-ws/reporte/reporteLlamadaGeneral	1
2	Isertar Pin	CU_Permiso de llamadas	/sic-ws/tbPin/insertarPin	1
3	Eliminar pin	CU_Permiso de llamadas	/sic-ws/tbPin/eliminarPin	1
41	Evaluar instancia	CU_Instancia	/sic-ws/instancia/evaluaInstancia	0
7	Listar empresa Area por centro	CU_Permiso de llamadas	/sic-ws/empresaArea/listarEmpresaAreaxCentro	1
42	Menu Sic sidebar	CU_menu	/sic-ws/menuSic/listar	0
38	Lista de Instancias	CU_Administracion_Listar_Instancias 	/sic-ws/instancia/listaInstancia	0
31	Lista llamadas generales	CU_Reporte Llamadas Generales	/sic-ws/reporte/lista-llamada-general	1
35	Reporte centro de costo Llamada	CU_Reporte_Centro_Costo_Llamada	/sic-ws/reporte/reporteCentroCostoLlamada	1
43	Busca pin	CU_Permiso de Llamadas	/sic-ws/tbPin/buscaPin	1
29	Lista de llamada Usuario	CU_Reporte_Llamadas 	/sic-ws/reporte/lista-llamada-usuario	1
30	Reporte llamada Usuario	CU_Reporte_Llamadas 	/sic-ws/reporte/reporteLlamadaUsuario	1
24	Buscar sip	CUS_Anexos_Cloud	/sc-ws/sipTelefono/buscaSipId	1
1	Listar usuario pin	CU_Permiso de llamadas	/sic-ws/tbUsuario/listar	1
4	FlagPin	CU_Permiso de llamadas	/sic-ws/tbPin/flagPin	1
8	Iinsertar usuario	CU_Permiso de llamadas	/sic-ws/tbUsuario/insertarUsuario	1
5	Listar Por Nombre	CU_Permiso de llamadas	/sic-ws/tbUsuario/listarPorNombre	1
6	Listar Empresa Area	CU_Permiso de llamadas	/sic-ws/empresaArea/listarEmpresaArea	1
9	Listar por Id	CU_Permiso de llamadas	/sic-ws/tbUsuario/listarPorId	1
36	Lista centro de costo llamada	CU_Reporte_Centro_Costo_Llamada	/sic-ws/reporte/listaCentroCostoLlamada	1
44	Cargar anexos iniciales	CU_Configuracion_Inicial	/sic-ws/configuracion-plan/cargar-anexos-iniciales	1
33	Listar Ranking de llamadas	CU_Reporte Ranking de llamadas	/sic-ws/reporte/listarRankingLlamadas	1
34	Reporte llamadas generales	CU_Reporte Ranking de llamadas	/sic-ws/reporte/reporteRankingLlamada	1
39	Reporte area Llamada	CU_Reporte_Area_Llamada	/sic-ws/areaLlamada/listarAreaLlamada	1
40	Generar clave anexo	CUS_Anexos_Cloud	/sic-ws/sipBuddie/generar-clave-anexo	1
28	Eliminar Area	CUS_Area Centro de Costo	/sic-ws/areaCentroCosto/eliminarIdArea	1
37	Reporte Area llamada	CU_Reporte_Area_Llamada	/sic-ws/reporte/reporteAreaLlamada	1
\.


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 186
-- Name: tb_servicio_id_servicio_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tb_servicio_id_servicio_seq', 14, true);


--
-- TOC entry 2151 (class 0 OID 136432)
-- Dependencies: 171
-- Data for Name: tb_usuario; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tb_usuario (id_usuario, no_login, no_passwo, no_nombre, no_apelli, no_email, no_profe, il_activo, fe_creaci, il_account_non_expired, il_credential_non_expired, il_account_non_locked) FROM stdin;
2	cli	123	Miguel	Ruiz	miguel@hotmail.com	Cliente	t	2017-03-28	t	t	t
34	usuario1	123	Mart�n	Araujo	maraujo@t-contacta.com	Programador	t	2017-04-03	t	t	t
43	usuario2	123	ramon	valdez	rvaldez@hotmail.com	No presenta	t	2017-04-03	t	t	t
46	usuario3	123	usuario	tres	usutres@hotmail.com	Implementador	t	2017-04-04	t	t	t
\.


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 170
-- Name: tb_usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tb_usuario_id_usuario_seq', 64, true);


--
-- TOC entry 2161 (class 0 OID 136677)
-- Dependencies: 189
-- Data for Name: tc_servicio_rol; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tc_servicio_rol (id_ser_rol, id_servicio, id_rol) FROM stdin;
2	1	2
3	2	2
4	3	2
5	4	2
6	5	2
7	6	2
8	7	2
9	8	2
10	9	2
11	10	2
12	11	2
13	12	2
14	13	2
15	14	2
16	15	2
17	16	2
18	17	2
19	18	2
20	19	2
21	20	2
22	21	2
23	22	2
24	23	2
25	24	2
26	25	2
27	26	2
28	27	2
29	28	2
30	29	2
31	30	2
32	31	2
33	32	2
34	33	2
35	34	2
36	35	2
37	36	2
38	37	2
39	38	2
40	39	2
41	40	2
42	41	2
43	42	2
44	43	2
\.


--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 188
-- Name: tc_servicio_rol_id_ser_rol_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tc_servicio_rol_id_ser_rol_seq', 41, true);


--
-- TOC entry 2153 (class 0 OID 136445)
-- Dependencies: 173
-- Data for Name: tc_usuario_rol; Type: TABLE DATA; Schema: oauth; Owner: tintegro
--

COPY tc_usuario_rol (id_usurol, id_usuario, id_rol) FROM stdin;
2	2	2
4	34	2
5	43	2
6	46	3
\.


--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 172
-- Name: tc_usuario_rol_id_usurol_seq; Type: SEQUENCE SET; Schema: oauth; Owner: tintegro
--

SELECT pg_catalog.setval('tc_usuario_rol_id_usurol_seq', 6, true);


SET search_path = public, pg_catalog;

--
-- TOC entry 2168 (class 0 OID 144643)
-- Dependencies: 199
-- Data for Name: oauth_access_token; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_access_token (token_id, token, authentication_id, user_name, client_id, authentication, refresh_token) FROM stdin;
\.


--
-- TOC entry 2171 (class 0 OID 144663)
-- Dependencies: 202
-- Data for Name: oauth_approvals; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_approvals (userid, clientid, scope, status, expiresat, lastmodifiedat) FROM stdin;
\.


--
-- TOC entry 2166 (class 0 OID 144627)
-- Dependencies: 197
-- Data for Name: oauth_client_details; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) FROM stdin;
\.


--
-- TOC entry 2167 (class 0 OID 144635)
-- Dependencies: 198
-- Data for Name: oauth_client_token; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_client_token (token_id, token, authentication_id, user_name, client_id) FROM stdin;
\.


--
-- TOC entry 2170 (class 0 OID 144657)
-- Dependencies: 201
-- Data for Name: oauth_code; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_code (code, authentication) FROM stdin;
\.


--
-- TOC entry 2169 (class 0 OID 144651)
-- Dependencies: 200
-- Data for Name: oauth_refresh_token; Type: TABLE DATA; Schema: public; Owner: tintegro
--

COPY oauth_refresh_token (token_id, token, authentication) FROM stdin;
\.


SET search_path = sistema, pg_catalog;

--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 143
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('cliente_id_cliente_seq', 70, true);


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 145
-- Name: instancia_id_instancia_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('instancia_id_instancia_seq', 72, true);


--
-- TOC entry 2129 (class 0 OID 78937)
-- Dependencies: 144
-- Data for Name: tb_cliente; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tb_cliente (id_cliente, no_razon_social, nu_docide, direccion, telefono, correo, personareferencia, estado, id_tipdoc) FROM stdin;
64	Misael SAC	20461826421	Av Monte de los Olivos 254	2345432	msac@gmail.com	Raul	t	2
65	SUPERREQUEST4	20189182944	Av SUPERSONICO4 Mq L4 63	2382440	rand44@gmail.com	rand44	t	2
\.


--
-- TOC entry 2163 (class 0 OID 144569)
-- Dependencies: 193
-- Data for Name: tb_control; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tb_control (id_control, no_control, no_descrip, ti_elemento, no_desc_elemento) FROM stdin;
1	Ver	\N	1	Instancia
2	Ver Detalle	\N	1	Instancia
3	Configurado	\N	1	Instancia
4	Conforme	\N	1	Instancia
5	Instalado	\N	1	Instancia
\.


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 192
-- Name: tb_control_id_control_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tb_control_id_control_seq', 5, true);


--
-- TOC entry 2131 (class 0 OID 78945)
-- Dependencies: 146
-- Data for Name: tb_instancia; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tb_instancia (id_instancia, ip_red, nro_vlan, ip_asterisk, ip_median, no_mascara, no_iprouter, no_dns_1, no_dns_2, no_subnet, no_broadcast, id_cliente, il_estado, il_libre, ipasteriskbash, puerto_asterisk_bash_certificado_ext, puerto_openvpn, ip_confinicial, mask_subredconfinicial, pam_confinicial, sim_pais, sim_provincia, full_provincia, no_organi, no_email, id_modelo, id_marca, no_modelo, no_marca, inicial, id_estadoinst) FROM stdin;
54	172.29.7.0	2	192.168.3.204		255.255.255.0	172.29.7.4	172.20.0.175	172.20.0.227	172.29.7.255	172.29.7.255	64	t	t	192.168.3.254	1169	1196	192.168.5.0	23	trust	PE	LI	LIMA	T-Contacta	soporte@t-contacta.com	13	7	T23G	YEALINK	10	1
55	168.29.7.0	2	192.168.3.202		255.255.255.0	172.29.7.4	172.20.0.175	172.20.0.227	172.29.7.255	178.29.7.255	65	t	t	192.168.3.254	1169	1196	192.168.5.0	23	trust	PE	LI	LIMA	T-Contacta	soporteer@t-contacta.com	13	7	T23G	YEALINKEDLINK	10	1
56	168.29.7.0	2	192.168.3.202		255.255.255.0	172.29.7.4	178.20.0.175	178.20.0.222	172.29.7.255	178.29.7.255	65	t	t	192.168.3.254	1169	1196	192.168.5.0	23	trust	PE	AQP	AREQUIPA	T-Contacta2	soporteer2@t-contacta.com	15	7	T23G	TP-LINK	10	1
53	172.29.7.0	2	192.168.3.202		255.255.255.0	172.29.7.4	172.20.0.175	172.20.0.227	172.29.7.255	172.29.7.255	64	t	t	192.168.3.254	1169	1196	192.168.5.0	23	trust	PE	LI	LIMA	T-Contacta	soporte@t-contacta.com	13	7	T23G	YEALINK	10	3
\.


--
-- TOC entry 2136 (class 0 OID 128191)
-- Dependencies: 155
-- Data for Name: tb_pedido; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tb_pedido (id_pedido, fe_pedido, id_cliente, id_estadopedido) FROM stdin;
35	2017-03-30	64	1
36	2017-04-02	64	1
37	2017-03-25	65	1
\.


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 154
-- Name: tb_pedido_id_pedido_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tb_pedido_id_pedido_seq', 46, true);


--
-- TOC entry 2132 (class 0 OID 78965)
-- Dependencies: 147
-- Data for Name: tc_cliente_eliminado; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_cliente_eliminado (id_cliente_eli, no_razon_social, ruc, direccion, telefono, correo, personareferencia, estado) FROM stdin;
1	num	num	num	num	num	num	t
11	noRazonSocial	ruc	direccion	 telefono	 correo	personareferencia	t
9	carro	xsd	xsd	xsd	xsd	xsd	t
2	francis	1222	ee	ee	ee	gg	t
10	\N	\N	\N	\N	\N	\N	t
28	\N	\N	\N	\N	\N	\N	t
29	LUIS	LUIS	LUIS	LUIS	LUIS	LUIS	t
12	\N	\N	\N	\N	\N	\N	t
33	\N	\N	\N	\N	\N	\N	t
35	\N	\N	\N	\N	\N	\N	t
37	\N	\N	\N	\N	\N	\N	t
38	\N	\N	\N	\N	\N	\N	t
25	\N	\N	\N	\N	\N	\N	t
39	\N	\N	\N	\N	\N	\N	t
53	t intacta	\N	\N	\N	\N	\N	t
\.


--
-- TOC entry 2165 (class 0 OID 144580)
-- Dependencies: 195
-- Data for Name: tc_control_rol; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_control_rol (id_control_rol, id_control, id_rol, id_estadoinst) FROM stdin;
1	1	2	3
2	1	2	4
3	1	2	5
4	1	5	3
5	1	5	4
6	1	5	5
8	1	3	4
7	1	3	3
9	1	3	5
10	1	4	3
11	1	4	4
12	1	4	5
13	1	6	3
14	1	6	4
15	1	6	5
16	2	5	1
17	2	5	2
18	2	5	3
19	2	5	4
20	2	5	5
21	2	3	1
22	2	3	2
23	2	3	3
24	2	3	4
25	2	3	5
26	2	4	1
27	2	4	2
28	2	4	3
29	2	4	4
30	2	4	5
31	3	3	1
32	4	5	2
33	5	6	3
34	5	6	4
\.


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 194
-- Name: tc_control_rol_id_control_rol_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_control_rol_id_control_rol_seq', 34, true);


--
-- TOC entry 2144 (class 0 OID 128239)
-- Dependencies: 163
-- Data for Name: tc_detallepedido; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_detallepedido (id_detapedido, no_detapedido, id_tipopedido, id_pedido, id_tipodetalle, id_plan, id_instancia, id_cliente) FROM stdin;
37	p_no_detapedido	1	35	1	1	53	64
38	p_no_detapedido	1	36	1	1	54	64
39	DetalleSuperRequet4	1	37	1	1	55	65
40	DetalleSuperRequet5	1	37	1	1	56	65
\.


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 162
-- Name: tc_detallepedido_id_detapedido_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_detallepedido_id_detapedido_seq', 56, true);


--
-- TOC entry 2145 (class 0 OID 128298)
-- Dependencies: 164
-- Data for Name: tc_estado_instancia; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_estado_instancia (id_estadoinst, no_estadoinst) FROM stdin;
2	Configurado
3	Revisado
1	Por Configurar
4	Por Instalar
5	Instalado
\.


--
-- TOC entry 2147 (class 0 OID 128334)
-- Dependencies: 166
-- Data for Name: tc_estado_pedido; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_estado_pedido (id_estadopedido, no_estadopedido) FROM stdin;
1	Estado Pedido 1
2	Estado Pedido 2
3	Estado Pedido 3
4	Estado Pedido 4
5	Estado Pedido 5
\.


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 165
-- Name: tc_estado_pedido_id_estadopedido_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_estado_pedido_id_estadopedido_seq', 5, true);


--
-- TOC entry 2142 (class 0 OID 128225)
-- Dependencies: 161
-- Data for Name: tc_plan; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_plan (id_plan, no_plan) FROM stdin;
1	Plan 1
2	Plan 2
3	Plan 3
4	Plan 4
5	Plan 5
\.


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 160
-- Name: tc_plan_id_plan_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_plan_id_plan_seq', 5, true);


--
-- TOC entry 2140 (class 0 OID 128214)
-- Dependencies: 159
-- Data for Name: tc_tipo_detalle; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_tipo_detalle (id_tipodetalle, no_ripodetalle) FROM stdin;
2	Tipo detalle 2
3	Tipo detalle 3
4	Tipo detalle 4
5	Tipo detalle 5
1	Call Center
\.


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 158
-- Name: tc_tipo_detalle_id_tipodetalle_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_tipo_detalle_id_tipodetalle_seq', 5, true);


--
-- TOC entry 2138 (class 0 OID 128201)
-- Dependencies: 157
-- Data for Name: tc_tipo_pedido; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_tipo_pedido (id_tipopedido, no_tipopedido) FROM stdin;
1	Tipo Pedido 1
2	Tipo Pedido 2
3	Tipo Pedido 3
4	Tipo Pedido 4
5	Tipo Pedido 5
\.


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 156
-- Name: tc_tipo_pedido_id_tipperdido_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_tipo_pedido_id_tipperdido_seq', 5, true);


--
-- TOC entry 2134 (class 0 OID 128156)
-- Dependencies: 153
-- Data for Name: tc_tipodoc; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_tipodoc (id_tipdoc, no_tipo) FROM stdin;
1	DNI
2	RUC
\.


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 152
-- Name: tc_tipodoc_id_tipdoc_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_tipodoc_id_tipdoc_seq', 2, true);


--
-- TOC entry 2155 (class 0 OID 136562)
-- Dependencies: 181
-- Data for Name: tc_usuario_instancia; Type: TABLE DATA; Schema: sistema; Owner: tintegro
--

COPY tc_usuario_instancia (id_usuins, id_usuario, id_instancia) FROM stdin;
49	34	55
50	34	56
58	43	53
47	2	53
48	2	54
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 180
-- Name: tc_usuario_instancia_id_usuins_seq; Type: SEQUENCE SET; Schema: sistema; Owner: tintegro
--

SELECT pg_catalog.setval('tc_usuario_instancia_id_usuins_seq', 62, true);


SET search_path = oauth, pg_catalog;

--
-- TOC entry 2006 (class 2606 OID 136593)
-- Name: pk_client_details; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_client_details
    ADD CONSTRAINT pk_client_details PRIMARY KEY (id_client_details);


--
-- TOC entry 1998 (class 2606 OID 136429)
-- Name: tb_rol_pkey; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_rol
    ADD CONSTRAINT tb_rol_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 2010 (class 2606 OID 136674)
-- Name: tb_servicio_pkey; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_servicio
    ADD CONSTRAINT tb_servicio_pkey PRIMARY KEY (id_servicio);


--
-- TOC entry 2000 (class 2606 OID 136442)
-- Name: tb_usuario_pkey; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2012 (class 2606 OID 136682)
-- Name: tc_servicio_rol_pkey; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_servicio_rol
    ADD CONSTRAINT tc_servicio_rol_pkey PRIMARY KEY (id_ser_rol);


--
-- TOC entry 2002 (class 2606 OID 136450)
-- Name: tc_usuario_rol_pkey; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_rol
    ADD CONSTRAINT tc_usuario_rol_pkey PRIMARY KEY (id_usurol);


--
-- TOC entry 2008 (class 2606 OID 136595)
-- Name: unq_client_id; Type: CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tb_client_details
    ADD CONSTRAINT unq_client_id UNIQUE (no_client_id);


SET search_path = public, pg_catalog;

--
-- TOC entry 2022 (class 2606 OID 144650)
-- Name: oauth_access_token_pkey; Type: CONSTRAINT; Schema: public; Owner: tintegro
--

ALTER TABLE ONLY oauth_access_token
    ADD CONSTRAINT oauth_access_token_pkey PRIMARY KEY (authentication_id);


--
-- TOC entry 2018 (class 2606 OID 144634)
-- Name: oauth_client_details_pkey; Type: CONSTRAINT; Schema: public; Owner: tintegro
--

ALTER TABLE ONLY oauth_client_details
    ADD CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id);


--
-- TOC entry 2020 (class 2606 OID 144642)
-- Name: oauth_client_token_pkey; Type: CONSTRAINT; Schema: public; Owner: tintegro
--

ALTER TABLE ONLY oauth_client_token
    ADD CONSTRAINT oauth_client_token_pkey PRIMARY KEY (authentication_id);


SET search_path = sistema, pg_catalog;

--
-- TOC entry 1980 (class 2606 OID 78969)
-- Name: id_cliente_eli_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_cliente_eliminado
    ADD CONSTRAINT id_cliente_eli_pkey PRIMARY KEY (id_cliente_eli);


--
-- TOC entry 1976 (class 2606 OID 78942)
-- Name: id_cliente_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT id_cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 1978 (class 2606 OID 78950)
-- Name: id_instancia_pk; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_instancia
    ADD CONSTRAINT id_instancia_pk PRIMARY KEY (id_instancia);


--
-- TOC entry 2014 (class 2606 OID 144577)
-- Name: tb_control_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_control
    ADD CONSTRAINT tb_control_pkey PRIMARY KEY (id_control);


--
-- TOC entry 1984 (class 2606 OID 128196)
-- Name: tb_pedido_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_pedido
    ADD CONSTRAINT tb_pedido_pkey PRIMARY KEY (id_pedido);


--
-- TOC entry 2016 (class 2606 OID 144585)
-- Name: tc_control_rol_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_control_rol
    ADD CONSTRAINT tc_control_rol_pkey PRIMARY KEY (id_control_rol);


--
-- TOC entry 1992 (class 2606 OID 128247)
-- Name: tc_detallepedido_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT tc_detallepedido_pkey PRIMARY KEY (id_detapedido);


--
-- TOC entry 1994 (class 2606 OID 128306)
-- Name: tc_estado_instancia_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_estado_instancia
    ADD CONSTRAINT tc_estado_instancia_pkey PRIMARY KEY (id_estadoinst);


--
-- TOC entry 1996 (class 2606 OID 128342)
-- Name: tc_estado_pedido_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_estado_pedido
    ADD CONSTRAINT tc_estado_pedido_pkey PRIMARY KEY (id_estadopedido);


--
-- TOC entry 1990 (class 2606 OID 128233)
-- Name: tc_plan_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_plan
    ADD CONSTRAINT tc_plan_pkey PRIMARY KEY (id_plan);


--
-- TOC entry 1988 (class 2606 OID 128222)
-- Name: tc_tipo_detalle_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipo_detalle
    ADD CONSTRAINT tc_tipo_detalle_pkey PRIMARY KEY (id_tipodetalle);


--
-- TOC entry 1986 (class 2606 OID 128209)
-- Name: tc_tipo_pedido_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipo_pedido
    ADD CONSTRAINT tc_tipo_pedido_pkey PRIMARY KEY (id_tipopedido);


--
-- TOC entry 1982 (class 2606 OID 128164)
-- Name: tc_tipodoc_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_tipodoc
    ADD CONSTRAINT tc_tipodoc_pkey PRIMARY KEY (id_tipdoc);


--
-- TOC entry 2004 (class 2606 OID 136567)
-- Name: tc_usuario_instancia_pkey; Type: CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_instancia
    ADD CONSTRAINT tc_usuario_instancia_pkey PRIMARY KEY (id_usuins);


SET search_path = oauth, pg_catalog;

--
-- TOC entry 2038 (class 2606 OID 136688)
-- Name: fk_id_rol_serrol; Type: FK CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_servicio_rol
    ADD CONSTRAINT fk_id_rol_serrol FOREIGN KEY (id_rol) REFERENCES tb_rol(id_rol);


--
-- TOC entry 2034 (class 2606 OID 136457)
-- Name: fk_id_rol_usuario_rol; Type: FK CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_rol
    ADD CONSTRAINT fk_id_rol_usuario_rol FOREIGN KEY (id_rol) REFERENCES tb_rol(id_rol);


--
-- TOC entry 2037 (class 2606 OID 136683)
-- Name: fk_id_servicio_serrol; Type: FK CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_servicio_rol
    ADD CONSTRAINT fk_id_servicio_serrol FOREIGN KEY (id_servicio) REFERENCES tb_servicio(id_servicio);


--
-- TOC entry 2033 (class 2606 OID 136452)
-- Name: fk_id_usuario_usuario_rol; Type: FK CONSTRAINT; Schema: oauth; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_rol
    ADD CONSTRAINT fk_id_usuario_usuario_rol FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario);


SET search_path = sistema, pg_catalog;

--
-- TOC entry 2039 (class 2606 OID 144596)
-- Name: fk_control_control_rol; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_control_rol
    ADD CONSTRAINT fk_control_control_rol FOREIGN KEY (id_control) REFERENCES tb_control(id_control);


--
-- TOC entry 2032 (class 2606 OID 136379)
-- Name: fk_id_cliente_detallepedido; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_id_cliente_detallepedido FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2024 (class 2606 OID 136541)
-- Name: fk_id_estadoinstancia; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_instancia
    ADD CONSTRAINT fk_id_estadoinstancia FOREIGN KEY (id_estadoinst) REFERENCES tc_estado_instancia(id_estadoinst);


--
-- TOC entry 2041 (class 2606 OID 144606)
-- Name: fk_id_estadoinstancia_controlrol; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_control_rol
    ADD CONSTRAINT fk_id_estadoinstancia_controlrol FOREIGN KEY (id_estadoinst) REFERENCES tc_estado_instancia(id_estadoinst);


--
-- TOC entry 2026 (class 2606 OID 128343)
-- Name: fk_id_estadopedido; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_pedido
    ADD CONSTRAINT fk_id_estadopedido FOREIGN KEY (id_estadopedido) REFERENCES tc_estado_pedido(id_estadopedido);


--
-- TOC entry 2036 (class 2606 OID 136574)
-- Name: fk_id_instancia_usuarioinstancia; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_instancia
    ADD CONSTRAINT fk_id_instancia_usuarioinstancia FOREIGN KEY (id_instancia) REFERENCES tb_instancia(id_instancia);


--
-- TOC entry 2027 (class 2606 OID 136354)
-- Name: fk_id_instanciia; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_id_instanciia FOREIGN KEY (id_instancia) REFERENCES tb_instancia(id_instancia);


--
-- TOC entry 2028 (class 2606 OID 136359)
-- Name: fk_id_plan; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_id_plan FOREIGN KEY (id_plan) REFERENCES tc_plan(id_plan);


--
-- TOC entry 2040 (class 2606 OID 144601)
-- Name: fk_id_rol_control_rol; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_control_rol
    ADD CONSTRAINT fk_id_rol_control_rol FOREIGN KEY (id_rol) REFERENCES oauth.tb_rol(id_rol);


--
-- TOC entry 2023 (class 2606 OID 128273)
-- Name: fk_id_tipdoc; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT fk_id_tipdoc FOREIGN KEY (id_tipdoc) REFERENCES tc_tipodoc(id_tipdoc);


--
-- TOC entry 2029 (class 2606 OID 136364)
-- Name: fk_id_tipo_detalle; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_id_tipo_detalle FOREIGN KEY (id_tipodetalle) REFERENCES tc_tipo_detalle(id_tipodetalle);


--
-- TOC entry 2030 (class 2606 OID 136369)
-- Name: fk_id_tipopedido; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_id_tipopedido FOREIGN KEY (id_tipopedido) REFERENCES tc_tipo_pedido(id_tipopedido);


--
-- TOC entry 2035 (class 2606 OID 136569)
-- Name: fk_id_usuario_usuarioinstancia; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_usuario_instancia
    ADD CONSTRAINT fk_id_usuario_usuarioinstancia FOREIGN KEY (id_usuario) REFERENCES oauth.tb_usuario(id_usuario);


--
-- TOC entry 2031 (class 2606 OID 136374)
-- Name: fk_if_pedido; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tc_detallepedido
    ADD CONSTRAINT fk_if_pedido FOREIGN KEY (id_pedido) REFERENCES tb_pedido(id_pedido);


--
-- TOC entry 2025 (class 2606 OID 136546)
-- Name: id_cliente_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: tintegro
--

ALTER TABLE ONLY tb_instancia
    ADD CONSTRAINT id_cliente_fk FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 8
-- Name: public; Type: ACL; Schema: -; Owner: tintegro
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM tintegro;
GRANT ALL ON SCHEMA public TO tintegro;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-04-06 15:34:36 PET

--
-- PostgreSQL database dump complete
--

