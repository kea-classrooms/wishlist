INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Gigabyte B450 AORUS M",120,"Motherboard");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Gigabyte B350 AORUS M",502,"Motherboard");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Gigabyte B650 AORUS M",30,"Motherboard");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("MOTHERBOARD COMPANY B450 AORUS M",12,"Motherboard");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("MB B450 AORUS M",90,"Motherboard");


INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("ASUS ROG Strix GeForce RTX 3080",1700,"GPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("NVIDIA GeForce RTX 3090",2099.99,"GPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("GPUCOMP Strix GeForce RTX 3070",1299.99,"GPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("MSI GeForce RTX 3080",1499.99,"GPU");


INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("AMD Ryzen 9 5900X",549.99,"CPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("AMD Ryzen 5 3600X",249.99,"CPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Intel Core i9-13900K",270,"CPU");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Intel Core i7-13700K",225,"CPU");


INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("EVGA SuperNOVA 750W G5",129.99,"Power Supply");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("EVGA SuperNOVA 650 G5",60,"Power Supply");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Corsair 750W G5",200,"Power Supply");


INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Samsung 970 EVO Plus 1TB NVMe SSD",199.99,"Storage");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Samsung 960 EVO Plus 500GB NVMe SSD",199.99,"Storage");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Samsung 5TB HDD ",199.99,"Storage");

INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Noctua NH-D15 chromax.black",99.99,"CPU Cooler");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Corsiar 2i4 aio",120,"CPU Cooler");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("Intel stock",20 ,"CPU Cooler");
INSERT INTO COMPUTERPART(pName, pPrice, pType) VALUE ("AMD stock",15,"CPU Cooler");

INSERT INTO USERR(uName) VALUE ("Carl");
INSERT INTO USERR(uName) VALUE ("Simone");
INSERT INTO USERR(uName) VALUE ("Sadek");
INSERT INTO USERR(uName) VALUE ("Tore");

INSERT INTO BUILD(userID, buildName) VALUE (1, "Build");
INSERT INTO BUILD(userID, buildName) VALUE (2, "My build");
INSERT INTO BUILD(userID, buildName) VALUE (3, "My PC");
INSERT INTO BUILD(userID, buildName) VALUE (4, "DREAM PC");
INSERT INTO BUILD(userID, buildName) VALUE (1, "WOWIE");

INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(3,4,1,1);
INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(8,5,1,0);
INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(3,2,2,1);
INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(8,3,3,0);
INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(6,5,4,1);
INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUE(1,2,5,0);

INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (4, 1);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (2, 3);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (3, 2);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (1, 4);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (5, 2);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (1, 3);
INSERT INTO SHARED_LIST(buildID, sharedToUserID) VALUE (5, 4);

commit;