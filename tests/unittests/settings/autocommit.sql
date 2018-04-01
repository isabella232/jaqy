--------------------------------------------------------------------------
-- autocommit setting test
--------------------------------------------------------------------------
.set autocommit on
.set autocommit off
.set autocommit

.run ../common/mysql_setup.sql
USE vagrant;

.set autocommit

CREATE TABLE MyTable
(
	a	INTEGER PRIMARY KEY,
	b	VARCHAR(200)
);

.set autocommit off
.set autocommit
INSERT INTO MyTable VALUES (1, '1');
INSERT INTO MyTable VALUES (2, '2');
.commit

SELECT * FROM MyTable ORDER BY a;

INSERT INTO MyTable VALUES (3, '3');
INSERT INTO MyTable VALUES (4, '4');
.rollback

SELECT * FROM MyTable ORDER BY a;

.set autocommit on
.set autocommit

INSERT INTO MyTable VALUES (5, '5');
INSERT INTO MyTable VALUES (6, '6');
.rollback

SELECT * FROM MyTable ORDER BY a, b;

DROP TABLE MyTable;

.close
