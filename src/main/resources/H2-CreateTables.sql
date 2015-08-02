DROP table Answer;
DROP table Result;
DROP table Choice;
DROP TABLE AssessmentQuestion;
DROP TABLE Assessment;
DROP TABLE Question;



CREATE TABLE Assessment
(
  Id       			    int                NOT NULL,
  name       			VARCHAR(128),
  topic					varchar(32)
);
ALTER TABLE Assessment ADD CONSTRAINT assessment_pk PRIMARY KEY (ID);
CREATE UNIQUE INDEX Assessment_pk_i ON Assessment (Id);

CREATE TABLE Question(
  Id 		int 			NOT NULL,
  Description		VARCHAR(1024) 	NOT NULL,
  Answer			VARCHAR(2)			NOT NULL,
  subtopic			varchar(32),
  multiSelect varchar(1)
);

ALTER TABLE Question ADD CONSTRAINT Question_PK PRIMARY KEY (Id);
CREATE UNIQUE INDEX Question_pk_i ON Question(Id);

Create table Choice(
	Id int NOT NULL,
	questionId int not null,
	Description varchar(512) not null
);
ALTER TABLE Choice ADD CONSTRAINT c_pk PRIMARY KEY (Id,questionId);
ALTER TABLE Choice ADD CONSTRAINT c_fk foreign key (questionId) references Question(Id);

CREATE TABLE AssessmentQuestion
(
  AssessmentId        			int                NOT NULL,
  QuestionId	           		int        NOT NULL
);
ALTER TABLE AssessmentQuestion ADD CONSTRAINT AssessmentQuestionPk PRIMARY KEY (AssessmentId, QuestionId);
ALTER TABLE AssessmentQuestion ADD CONSTRAINT AqFk1 FOREIGN KEY (QuestionId) REFERENCES QUESTION (Id);
ALTER TABLE AssessmentQuestion ADD CONSTRAINT AqFk2 FOREIGN KEY (AssessmentId) REFERENCES ASSESSMENT (Id);

CREATE table Result( 
	Id int not null,
	accessmentCode varchar(20),
	assessmentId int not null,
	assessmentName varchar(128),
	userid         VARCHAR(32) 
);
ALTER TABLE Result ADD CONSTRAINT result_pk PRIMARY KEY (Id);
ALTER TABLE Result ADD CONSTRAINT result_fk foreign key (assessmentId) references Assessment(Id);

CREATE table Answer(
 Id int not null,
 resultId int not null,
 subtopic varchar(50),
 correct  varchar(1)
);
ALTER TABLE Answer ADD CONSTRAINT answer_pk PRIMARY KEY (Id, resultId);
ALTER TABLE Answer ADD CONSTRAINT answer_fk foreign key (resultId) references Result(Id);

