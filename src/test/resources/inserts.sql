--INSERTS TYPE_PRODUCT

INSERT INTO type_product (id_type_product, name)
VALUES ( 1, 'food');

INSERT INTO type_product (id_type_product, name)
VALUES ( 2, 'technology');


--INSERTS PACKING

INSERT INTO packing (id_packing, height, high, quantity , width)
VALUES (  1, 3.5 ,  2.5 , 3 , 5.5 );

INSERT INTO packing (id_packing, height, high, quantity , width)
VALUES (  2, 5.0 ,  6.5 , 10 , 8.6);

INSERT INTO packing (id_packing, height, high, quantity , width)
VALUES (  3, 9.0 ,  7.5 , 8 , 10.0);

INSERT INTO packing (id_packing, height, high, quantity , width)
VALUES (  4, 2.0 ,  3.3 , 5 , 3.8);

INSERT INTO packing (id_packing, height, high, quantity , width)
VALUES (  5, 5.5 ,  6.8 , 15 , 12);

--INSERTS PRODUCT

INSERT INTO product (id_product, name, price, id_packing , id_type_product)
VALUES (  1 , 'rice' ,  3500 , 2 , 1);

INSERT INTO product (id_product, name, price, id_packing , id_type_product)
VALUES (  2 , 'cell phone' ,  8000 , 4 , 2);

INSERT INTO product (id_product, name, price, id_packing , id_type_product)
VALUES (  3 , 'tomato' ,  1500 , 3 , 1);

INSERT INTO product (id_product, name, price, id_packing , id_type_product)
VALUES (  4 , 'headphone' ,  3000 , 5 , 2);

--INSERTS INVENTORY

INSERT INTO inventory (id_inventory, quantity, id_packing , id_product)
VALUES (  1 , 50 , 5 , 1);

INSERT INTO inventory (id_inventory, quantity, id_packing , id_product)
VALUES (  2 , 25 , 3 , 2);

INSERT INTO inventory (id_inventory, quantity, id_packing , id_product)
VALUES (  3 , 15 , 2 , 3);

INSERT INTO inventory (id_inventory, quantity, id_packing , id_product)
VALUES (  4 , 10 , 4 , 4);