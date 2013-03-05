CREATE TABLE exTopics (
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title char(25) NOT NULL,
    description char(200) NOT NULL,
);

CREATE TABLE exExercises (
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title char(25) NOT NULL,
    question char(200) NOT NULL,
    answer char(200) NOT NULL,
    topicid int NOT NULL
);