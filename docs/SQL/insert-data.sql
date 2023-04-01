INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Gigabyte B450 AORUS M",89.99,"Motherboard");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("ASUS ROG Strix GeForce RTX 3080",1299.99,"GPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("AMD Ryzen 9 5900X",549.99,"CPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("EVGA SuperNOVA 750W G5",129.99,"Power Supply");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("SteelSeries Arctis 7 Wireless Gaming Headset",149.99,"Headset");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Elgato Game Capture 4K60 Pro MK.2",249.99,"Capture Card");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Samsung 970 EVO Plus 1TB NVMe SSD",199.99,"Storage");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Noctua NH-D15 chromax.black",99.99,"CPU Cooler");

INSERT INTO USERR(uName) VALUE ("Carl");
INSERT INTO USERR(uName) VALUE ("Simone");
INSERT INTO USERR(uName) VALUE ("Sadek");
INSERT INTO USERR(uName) VALUE ("Tore");

INSERT INTO WISHLIST(userID, listName) VALUE (1, "Ønskeliste");
INSERT INTO WISHLIST(userID, listName) VALUE (3, "Wishlist");
INSERT INTO WISHLIST(userID, listName) VALUE (4, "Ønskeliste");
INSERT INTO WISHLIST(userID, listName) VALUE (2, "Liste");
INSERT INTO WISHLIST(userID, listName) VALUE (4, "Test");

INSERT INTO WISH(partID, numberCount, listID) VALUE(3,2,2);
INSERT INTO WISH(partID, numberCount, listID) VALUE(1,2,4);
INSERT INTO WISH(partID, numberCount, listID) VALUE(8,3,1);
INSERT INTO WISH(partID, numberCount, listID) VALUE(2,5,5);
INSERT INTO WISH(partID, numberCount, listID) VALUE(6,5,2);
INSERT INTO WISH(partID, numberCount, listID) VALUE(3,4,3);
INSERT INTO WISH(partID, numberCount, listID) VALUE(2,1,1);
INSERT INTO WISH(partID, numberCount, listID) VALUE(5,2,5);
INSERT INTO WISH(partID, numberCount, listID) VALUE(6,5,2);
INSERT INTO WISH(partID, numberCount, listID) VALUE(2,2,3);

INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (5, 4);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (5, 3);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (5, 2);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (3, 1);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (4, 2);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (2, 2);
INSERT INTO SHARED_LIST(listID, sharedToUserID) VALUE (1, 4);

commit;