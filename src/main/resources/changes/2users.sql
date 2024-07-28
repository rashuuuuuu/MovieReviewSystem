-- liquibase formatted sql
-- changeset rashmita:1
-- preconditions onFail:CONTINUE onError:HALT
CREATE TABLE  IF NOT EXISTS users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       full_name VARCHAR(255)  NOT NULL DEFAULT 'default name',
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       picture VARCHAR(255),
                       phone VARCHAR(255),
                       address VARCHAR(255),
                       role_id BIGINT NOT NULL,
                       CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users (address, created_at, email, full_name, password, phone, picture, role_id, updated_at)
VALUES ('123 Main St', NOW(), 'admin@example.com', 'Admin User', 'password', '1234567890', 'admin.png', 1, NOW());
