CREATE TABLE cats (
    name character varying(100) NOT NULL,
    filename character varying(100),
    id integer NOT NULL
);


ALTER TABLE cats OWNER TO kittens;

--
-- TOC entry 169 (class 1259 OID 784041)
-- Name: cats_seq; Type: SEQUENCE; Schema: public; Owner: kittens
--

CREATE SEQUENCE cats_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 999999999999
    CACHE 1;


ALTER TABLE cats_seq OWNER TO kittens;

--
-- TOC entry 1918 (class 0 OID 784036)
-- Dependencies: 168
-- Data for Name: cats; Type: TABLE DATA; Schema: public; Owner: kittens
--

INSERT INTO cats (name, filename, id) VALUES ('Katty', 'resources/qqq.jpg', 1);
INSERT INTO cats (name, filename, id) VALUES ('Katty2', 'resources/flying_cat.jpg', 3);
INSERT INTO cats (name, filename, id) VALUES ('KattyX', 'resources/cat.jpg', 7);
INSERT INTO cats (name, filename, id) VALUES ('KattyQA', 'resources/cat.jpg', 8);


--
-- TOC entry 1928 (class 0 OID 0)
-- Dependencies: 169
-- Name: cats_seq; Type: SEQUENCE SET; Schema: public; Owner: kittens
--

SELECT pg_catalog.setval('cats_seq', 8, true);


--
-- TOC entry 1811 (class 2606 OID 784040)
-- Name: cats_pkey; Type: CONSTRAINT; Schema: public; Owner: kittens; Tablespace: 
--

ALTER TABLE ONLY cats
    ADD CONSTRAINT cats_pkey PRIMARY KEY (id);



