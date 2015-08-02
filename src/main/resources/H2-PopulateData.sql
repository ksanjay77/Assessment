INSERT INTO ASSESSMENT(Id,name, topic) VALUES(1,'Class 1 Physics','Physics');
INSERT INTO ASSESSMENT(Id,name, topic) VALUES(2,'Class 2 Physics','Physics');
INSERT INTO ASSESSMENT(Id,name, topic) VALUES(3,'Class 3 Physics','Physics');

INSERT INTO QUESTION(ID,Description, Answer, subtopic, multiSelect)
 VALUES(1, 'Let X be the set of all citizens of India. Elements x,y in X are said to be related if the difference of their age is 5 years. Which one of the following is correct?', '2', 'Sound', 'N');

INSERT into choice(Id,questionId,	Description) values (1, 1,'The relation is an equivalence relation on X.');
INSERT into choice (Id,questionId,	Description) values (2, 1,'The relation is symmetric but neither reflexive nor transitive.');
INSERT into choice (Id,questionId,	Description) values (3, 1,'The relation is reflexive but neither symmetric nor transitive.');
INSERT into choice (Id,questionId,	Description) values (4, 1,'None of the above.');

INSERT INTO QUESTION(ID,Description, Answer, subtopic, multiSelect)
VALUES(2,
'The roots of equation \(2a^2x^2 – 2bax+ b^2 = 0\) where a< 0 and b > 0 are',
'3',
'Wave',
'N');
insert into choice (Id,questionId,	Description) values (1, 2,'Sometimes complex');
insert into choice (Id,questionId,	Description) values (2, 2,'Always irrational ');
insert into choice (Id,questionId,	Description) values (3, 2,'Always complex');
insert into choice (Id,questionId,	Description) values (4, 2,'Always real.');

INSERT INTO QUESTION(ID,Description, Answer, subtopic, multiSelect)
VALUES(3,
'What is the sum of two number$(11110)_2$ and $(1010)_2$ ?',
'1',
'Electricity',
'N');

insert into choice (Id,questionId,	Description) values (1, 3,'$(101000)_2$');
insert into choice (Id,questionId,	Description) values (2, 3,'$(110000)$');
insert into choice (Id,questionId,	Description) values (3, 3,'$(100100)$');
insert into choice (Id,questionId,	Description) values (4, 3,'$(101100)$');

insert into ASSESSMENTQUESTION(ASSESSMENTID,QUESTIONID) values (1,1);
insert into ASSESSMENTQUESTION(ASSESSMENTID,QUESTIONID) values (1,2);
insert into ASSESSMENTQUESTION(ASSESSMENTID,QUESTIONID) values (1,3);
insert into ASSESSMENTQUESTION(ASSESSMENTID,QUESTIONID) values (2,2);
insert into ASSESSMENTQUESTION(ASSESSMENTID,QUESTIONID) values (2,3);

commit;