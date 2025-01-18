CREATE TABLE customer (
    id BIGSERIAL PRIMARY KEY, -- Automatically creates a sequence and assigns it to the id column.
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    age INT NOT NULL
);


CREATE SEQUENCE customer_id_sequence;
CREATE TABLE customer (
    id BIGINT DEFAULT nextval('customer_id_sequence') PRIMARY KEY, 
    -- You manually create the sequence (customer_id_sequence).
    --You manually create the sequence (customer_id_sequence).
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    age INT NOT NULL
);

-- install postgreSQl 14.1
