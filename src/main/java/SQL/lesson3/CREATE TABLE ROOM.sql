CREATE TABLE ROOM(
    ID NUMBER,
    CONSTRAINT ROOM_ID PRIMARY KEY(ID),
    NUMBEROFGUESTS NUMBER,
    PRICE NUMBER,
    BREAKFASTINCLUDED NUMBER CHECK (BREAKFASTINCLUDED = 0 OR BREAKFASTINCLUDED = 1),
    PETSALLOWED NUMBER CHECK (PETSALLOWED = 0 OR PETSALLOWED = 1),
    DATEAVAILABLEFROM DATE,
    HOTEL_ID NUMBER,
    CONSTRAINT HOTEL_FK FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)
)
