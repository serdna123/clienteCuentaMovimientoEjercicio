--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-09-09 03:11:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16494)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta (
    id bigint NOT NULL,
    cliente_id character varying(255),
    estado boolean NOT NULL,
    numero_cuenta character varying(255),
    saldo_inicial double precision NOT NULL,
    tipo_cuenta character varying(255),
    nombre_cliente character varying(255)
);


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16493)
-- Name: cuenta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cuenta ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cuenta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 16502)
-- Name: movimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimiento (
    id bigint NOT NULL,
    fecha date,
    saldo double precision NOT NULL,
    tipo_movimiento character varying(255),
    valor double precision NOT NULL,
    cuenta_id bigint
);


ALTER TABLE public.movimiento OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16501)
-- Name: movimiento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.movimiento ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.movimiento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4694 (class 2606 OID 16500)
-- Name: cuenta cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id);


--
-- TOC entry 4698 (class 2606 OID 16506)
-- Name: movimiento movimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id);


--
-- TOC entry 4696 (class 2606 OID 16508)
-- Name: cuenta ukpj7ncg765kt4klndu25bwbwe4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT ukpj7ncg765kt4klndu25bwbwe4 UNIQUE (numero_cuenta);


--
-- TOC entry 4699 (class 2606 OID 16509)
-- Name: movimiento fk4ea11fe7p3xa1kwwmdgi9f2fi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT fk4ea11fe7p3xa1kwwmdgi9f2fi FOREIGN KEY (cuenta_id) REFERENCES public.cuenta(id);


-- Completed on 2024-09-09 03:11:40

--
-- PostgreSQL database dump complete
--

