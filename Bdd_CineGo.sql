#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Cinema
#------------------------------------------------------------

CREATE TABLE Cinema(
        idCinema  int (11) Auto_increment  NOT NULL ,
        nomCine   Varchar (25) ,
        nVoieCine Varchar (25) ,
        idVille   Int ,
        PRIMARY KEY (idCinema )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PlanSalle
#------------------------------------------------------------

CREATE TABLE PlanSalle(
        idPlanSalle  int (11) Auto_increment  NOT NULL ,
        numPlanSalle Varchar (25) ,
        nomPlanSalle Varchar (25) ,
        idCinema     Int ,
        PRIMARY KEY (idPlanSalle )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CaseSalle
#------------------------------------------------------------

CREATE TABLE CaseSalle(
        idCaseSalle    int (11) Auto_increment  NOT NULL ,
        nomSiegeCase   Varchar (25) ,
        idPlanSalle    Int ,
        idPositionCase Int ,
        idTypeCase     Int ,
        PRIMARY KEY (idCaseSalle )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        idClient           Int NOT NULL ,
        loginClient        Varchar (25) ,
        mdpClient          Varchar (256) ,
        mailClient         Varchar (25) ,
        telephoneClient    Varchar (25) ,
        nomClient          Varchar (25) ,
        prenomClient       Varchar (25) ,
        ageClient          Int ,
        nVoieClient        Varchar (25) ,
        sexeClient         Varchar (25) ,
        codeFideliteClient Varchar (25) ,
        adminClient        Bool ,
        idVille            Int ,
        PRIMARY KEY (idClient )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Date
#------------------------------------------------------------

CREATE TABLE Date(
        idDate     int (11) Auto_increment  NOT NULL ,
        seanceDate Datetime ,
        PRIMARY KEY (idDate )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Film
#------------------------------------------------------------

CREATE TABLE Film(
        idFilm  int (11) Auto_increment  NOT NULL ,
        nomFilm Varchar (25) ,
        PRIMARY KEY (idFilm )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Produit
#------------------------------------------------------------

CREATE TABLE Produit(
        idProduit          int (11) Auto_increment  NOT NULL ,
        nomProduit         Varchar (25) ,
        descriptionProduit Varchar (25) ,
        prixProduit        Float ,
        PRIMARY KEY (idProduit )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Place
#------------------------------------------------------------

CREATE TABLE Place(
        IdPlace    int (11) Auto_increment  NOT NULL ,
        choixPlace Bool ,
        idClient   Int ,
        PRIMARY KEY (IdPlace )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Seance
#------------------------------------------------------------

CREATE TABLE Seance(
        idSeance int (11) Auto_increment  NOT NULL ,
        idFilm   Int ,
        PRIMARY KEY (idSeance )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Creneau
#------------------------------------------------------------

CREATE TABLE Creneau(
        idCreneau         int (11) Auto_increment  NOT NULL ,
        heureDebutCreneau Time ,
        heureFinCreneau   Time ,
        PRIMARY KEY (idCreneau )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ville
#------------------------------------------------------------

CREATE TABLE Ville(
        idVille  int (11) Auto_increment  NOT NULL ,
        nomVille Varchar (25) ,
        cpVille  Varchar (25) ,
        PRIMARY KEY (idVille )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PositionCase
#------------------------------------------------------------

CREATE TABLE PositionCase(
        idPositionCase   int (11) Auto_increment  NOT NULL ,
        posXPositionCase Varchar (3) ,
        posYPositionCase Varchar (3) ,
        PRIMARY KEY (idPositionCase )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypeCase
#------------------------------------------------------------

CREATE TABLE TypeCase(
        idTypeCase  int (11) Auto_increment  NOT NULL ,
        nomTypeCase Int ,
        imgTypeCase Varchar (25) ,
        PRIMARY KEY (idTypeCase )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Composer
#------------------------------------------------------------

CREATE TABLE Composer(
        IdPlace     Int NOT NULL ,
        idCaseSalle Int NOT NULL ,
        idSeance    Int NOT NULL ,
        PRIMARY KEY (IdPlace ,idCaseSalle ,idSeance )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Creer
#------------------------------------------------------------

CREATE TABLE Creer(
        idCreneau   Int NOT NULL ,
        idPlanSalle Int NOT NULL ,
        idDate      Int NOT NULL ,
        idSeance    Int NOT NULL ,
        PRIMARY KEY (idCreneau ,idPlanSalle ,idDate ,idSeance )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ajouter
#------------------------------------------------------------

CREATE TABLE Ajouter(
        IdPlace   Int NOT NULL ,
        idProduit Int NOT NULL ,
        PRIMARY KEY (IdPlace ,idProduit )
)ENGINE=InnoDB;

ALTER TABLE Cinema ADD CONSTRAINT FK_Cinema_idVille FOREIGN KEY (idVille) REFERENCES Ville(idVille);
ALTER TABLE PlanSalle ADD CONSTRAINT FK_PlanSalle_idCinema FOREIGN KEY (idCinema) REFERENCES Cinema(idCinema);
ALTER TABLE CaseSalle ADD CONSTRAINT FK_CaseSalle_idPlanSalle FOREIGN KEY (idPlanSalle) REFERENCES PlanSalle(idPlanSalle);
ALTER TABLE CaseSalle ADD CONSTRAINT FK_CaseSalle_idPositionCase FOREIGN KEY (idPositionCase) REFERENCES PositionCase(idPositionCase);
ALTER TABLE CaseSalle ADD CONSTRAINT FK_CaseSalle_idTypeCase FOREIGN KEY (idTypeCase) REFERENCES TypeCase(idTypeCase);
ALTER TABLE Client ADD CONSTRAINT FK_Client_idVille FOREIGN KEY (idVille) REFERENCES Ville(idVille);
ALTER TABLE Place ADD CONSTRAINT FK_Place_idClient FOREIGN KEY (idClient) REFERENCES Client(idClient);
ALTER TABLE Seance ADD CONSTRAINT FK_Seance_idFilm FOREIGN KEY (idFilm) REFERENCES Film(idFilm);
ALTER TABLE Composer ADD CONSTRAINT FK_Composer_IdPlace FOREIGN KEY (IdPlace) REFERENCES Place(IdPlace);
ALTER TABLE Composer ADD CONSTRAINT FK_Composer_idCaseSalle FOREIGN KEY (idCaseSalle) REFERENCES CaseSalle(idCaseSalle);
ALTER TABLE Composer ADD CONSTRAINT FK_Composer_idSeance FOREIGN KEY (idSeance) REFERENCES Seance(idSeance);
ALTER TABLE Creer ADD CONSTRAINT FK_Creer_idCreneau FOREIGN KEY (idCreneau) REFERENCES Creneau(idCreneau);
ALTER TABLE Creer ADD CONSTRAINT FK_Creer_idPlanSalle FOREIGN KEY (idPlanSalle) REFERENCES PlanSalle(idPlanSalle);
ALTER TABLE Creer ADD CONSTRAINT FK_Creer_idDate FOREIGN KEY (idDate) REFERENCES Date(idDate);
ALTER TABLE Creer ADD CONSTRAINT FK_Creer_idSeance FOREIGN KEY (idSeance) REFERENCES Seance(idSeance);
ALTER TABLE Ajouter ADD CONSTRAINT FK_Ajouter_IdPlace FOREIGN KEY (IdPlace) REFERENCES Place(IdPlace);
ALTER TABLE Ajouter ADD CONSTRAINT FK_Ajouter_idProduit FOREIGN KEY (idProduit) REFERENCES Produit(idProduit);
