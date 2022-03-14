-- option 2
INSERT INTO users(username, password, enabled) VALUES('john', 'test123', true);
INSERT INTO users(username, password, enabled) VALUES('sakshem', 'test123', true);
INSERT INTO authorities(username, authority) VALUES('john', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES('sakshem', 'ROLE_ADMIN');