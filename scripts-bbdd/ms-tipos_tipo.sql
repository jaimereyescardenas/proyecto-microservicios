-- Table: public.tipo

-- DROP TABLE public.tipo;

CREATE TABLE public.tipo
(
    id bigint NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    prob double precision NOT NULL,
    CONSTRAINT tipo_pkey PRIMARY KEY (id)
);

INSERT INTO public.tipo (id, nombre, prob) VALUES (1, "Común", 0.5);
INSERT INTO public.tipo (id, nombre, prob) VALUES (2, "Raro", 0.3);
INSERT INTO public.tipo (id, nombre, prob) VALUES (3, "Épico", 0.15);
INSERT INTO public.tipo (id, nombre, prob) VALUES (4, "Legendario", 0.05);