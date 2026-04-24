CREATE TABLE produtos (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco_valor DECIMAL(19,2) NOT NULL,
    preco_moeda VARCHAR(3) NOT NULL,
    sku VARCHAR(50) UNIQUE NOT NULL,
    categoria_id UUID,
    marca_id UUID,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);