ALTER TABLE clientes
    ADD COLUMN matricula_id INT,
    ADD CONSTRAINT fk_matricula
    FOREIGN KEY (matricula_id) REFERENCES matriculas(id);