
# --- !Ups

INSERT INTO Category (id, name) VALUES (1, 'category A'), (2, 'category B');

INSERT INTO Product (id, date, name, numberInteger, numberLong, category_id)
  VALUES
  (1, NOW(), 'Product AAA', 10, NULL, 1),
  (2, NOW(), 'Product BBB', 20, 100000, 1),
  (3, NOW(), 'Product CCC', 30, NULL, 2);

INSERT INTO County (code, name) VALUES ('1', 'Ain');
INSERT INTO County (code, name) VALUES ('2', 'Aisne');
INSERT INTO County (code, name) VALUES ('3', 'Allier');
INSERT INTO County (code, name) VALUES ('5', 'Hautes-Alpes');
INSERT INTO County (code, name) VALUES ('4', 'Alpes-de-Haute-Provence');
INSERT INTO County (code, name) VALUES ('6', 'Alpes-Maritimes');
INSERT INTO County (code, name) VALUES ('7', 'Ardèche');
INSERT INTO County (code, name) VALUES ('8', 'Ardennes');
INSERT INTO County (code, name) VALUES ('9', 'Ariège');
INSERT INTO County (code, name) VALUES ('10', 'Aube');
INSERT INTO County (code, name) VALUES ('11', 'Aude');
INSERT INTO County (code, name) VALUES ('12', 'Aveyron');
INSERT INTO County (code, name) VALUES ('13', 'Bouches-du-Rhône');
INSERT INTO County (code, name) VALUES ('14', 'Calvados');
INSERT INTO County (code, name) VALUES ('15', 'Cantal');
INSERT INTO County (code, name) VALUES ('16', 'Charente');
INSERT INTO County (code, name) VALUES ('17', 'Charente-Maritime');
INSERT INTO County (code, name) VALUES ('18', 'Cher');
INSERT INTO County (code, name) VALUES ('19', 'Corrèze');
INSERT INTO County (code, name) VALUES ('2a', 'Corse-du-sud');
INSERT INTO County (code, name) VALUES ('2b', 'Haute-corse');
INSERT INTO County (code, name) VALUES ('21', 'Côte-d\'or');
INSERT INTO County (code, name) VALUES ('22', 'Côtes-d\'armor');
INSERT INTO County (code, name) VALUES ('23', 'Creuse');
INSERT INTO County (code, name) VALUES ('24', 'Dordogne');
INSERT INTO County (code, name) VALUES ('25', 'Doubs');
INSERT INTO County (code, name) VALUES ('26', 'Drôme');
INSERT INTO County (code, name) VALUES ('27', 'Eure');
INSERT INTO County (code, name) VALUES ('28', 'Eure-et-Loir');
INSERT INTO County (code, name) VALUES ('29', 'Finistère');
INSERT INTO County (code, name) VALUES ('30', 'Gard');
INSERT INTO County (code, name) VALUES ('31', 'Haute-Garonne');
INSERT INTO County (code, name) VALUES ('32', 'Gers');
INSERT INTO County (code, name) VALUES ('33', 'Gironde');
INSERT INTO County (code, name) VALUES ('34', 'Hérault');
INSERT INTO County (code, name) VALUES ('35', 'Ile-et-Vilaine');
INSERT INTO County (code, name) VALUES ('36', 'Indre');
INSERT INTO County (code, name) VALUES ('37', 'Indre-et-Loire');
INSERT INTO County (code, name) VALUES ('38', 'Isère');
INSERT INTO County (code, name) VALUES ('39', 'Jura');
INSERT INTO County (code, name) VALUES ('40', 'Landes');
INSERT INTO County (code, name) VALUES ('41', 'Loir-et-Cher');
INSERT INTO County (code, name) VALUES ('42', 'Loire');
INSERT INTO County (code, name) VALUES ('43', 'Haute-Loire');
INSERT INTO County (code, name) VALUES ('44', 'Loire-Atlantique');
INSERT INTO County (code, name) VALUES ('45', 'Loiret');
INSERT INTO County (code, name) VALUES ('46', 'Lot');
INSERT INTO County (code, name) VALUES ('47', 'Lot-et-Garonne');
INSERT INTO County (code, name) VALUES ('48', 'Lozère');
INSERT INTO County (code, name) VALUES ('49', 'Maine-et-Loire');
INSERT INTO County (code, name) VALUES ('50', 'Manche');
INSERT INTO County (code, name) VALUES ('51', 'Marne');
INSERT INTO County (code, name) VALUES ('52', 'Haute-Marne');
INSERT INTO County (code, name) VALUES ('53', 'Mayenne');
INSERT INTO County (code, name) VALUES ('54', 'Meurthe-et-Moselle');
INSERT INTO County (code, name) VALUES ('55', 'Meuse');
INSERT INTO County (code, name) VALUES ('56', 'Morbihan');
INSERT INTO County (code, name) VALUES ('57', 'Moselle');
INSERT INTO County (code, name) VALUES ('58', 'Nièvre');
INSERT INTO County (code, name) VALUES ('59', 'Nord');
INSERT INTO County (code, name) VALUES ('60', 'Oise');
INSERT INTO County (code, name) VALUES ('61', 'Orne');
INSERT INTO County (code, name) VALUES ('62', 'Pas-de-Calais');
INSERT INTO County (code, name) VALUES ('63', 'Puy-de-Dôme');
INSERT INTO County (code, name) VALUES ('64', 'Pyrénées-Atlantiques');
INSERT INTO County (code, name) VALUES ('65', 'Hautes-Pyrénées');
INSERT INTO County (code, name) VALUES ('66', 'Pyrénées-Orientales');
INSERT INTO County (code, name) VALUES ('67', 'Bas-Rhin');
INSERT INTO County (code, name) VALUES ('68', 'Haut-Rhin');
INSERT INTO County (code, name) VALUES ('69', 'Rhône');
INSERT INTO County (code, name) VALUES ('70', 'Haute-Saône');
INSERT INTO County (code, name) VALUES ('71', 'Saône-et-Loire');
INSERT INTO County (code, name) VALUES ('72', 'Sarthe');
INSERT INTO County (code, name) VALUES ('73', 'Savoie');
INSERT INTO County (code, name) VALUES ('74', 'Haute-Savoie');
INSERT INTO County (code, name) VALUES ('75', 'Paris');
INSERT INTO County (code, name) VALUES ('76', 'Seine-Maritime');
INSERT INTO County (code, name) VALUES ('77', 'Seine-et-Marne');
INSERT INTO County (code, name) VALUES ('78', 'Yvelines');
INSERT INTO County (code, name) VALUES ('79', 'Deux-Sèvres');
INSERT INTO County (code, name) VALUES ('80', 'Somme');
INSERT INTO County (code, name) VALUES ('81', 'Tarn');
INSERT INTO County (code, name) VALUES ('82', 'Tarn-et-Garonne');
INSERT INTO County (code, name) VALUES ('83', 'Var');
INSERT INTO County (code, name) VALUES ('84', 'Vaucluse');
INSERT INTO County (code, name) VALUES ('85', 'Vendée');
INSERT INTO County (code, name) VALUES ('86', 'Vienne');
INSERT INTO County (code, name) VALUES ('87', 'Haute-Vienne');
INSERT INTO County (code, name) VALUES ('88', 'Vosges');
INSERT INTO County (code, name) VALUES ('89', 'Yonne');
INSERT INTO County (code, name) VALUES ('90', 'Territoire de Belfort');
INSERT INTO County (code, name) VALUES ('91', 'Essonne');
INSERT INTO County (code, name) VALUES ('92', 'Hauts-de-Seine');
INSERT INTO County (code, name) VALUES ('93', 'Seine-Saint-Denis');
INSERT INTO County (code, name) VALUES ('94', 'Val-de-Marne');
INSERT INTO County (code, name) VALUES ('95', 'Val-d\'oise');
INSERT INTO County (code, name) VALUES ('976', 'Mayotte');
INSERT INTO County (code, name) VALUES ('971', 'Guadeloupe');
INSERT INTO County (code, name) VALUES ('973', 'Guyane');
INSERT INTO County (code, name) VALUES ('972', 'Martinique');
INSERT INTO County (code, name) VALUES ('974', 'Réunion');




# --- !Downs
