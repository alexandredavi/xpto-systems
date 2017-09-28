CREATE TABLE city (
  id             BIGSERIAL NOT NULL,
  cd_ibge        INTEGER,
  nm_uf          CHARACTER VARYING(2),
  nm_city        CHARACTER VARYING(255),
  fg_capital     BOOLEAN,
  nu_longitude   NUMERIC,
  nu_latitute    NUMERIC,
  nm_no_accents  CHARACTER VARYING(255),
  nm_alternative CHARACTER VARYING(255),
  nm_microregion CHARACTER VARYING(255),
  nm_mesoregion  CHARACTER VARYING(255),
  fg_excluded    BOOLEAN   NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_city PRIMARY KEY (id)
);