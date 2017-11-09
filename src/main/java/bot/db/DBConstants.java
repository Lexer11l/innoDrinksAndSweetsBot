package bot.db;

public class DBConstants {
    static final String driver = "org.apache.derby.jdbc.EmbeddedDriver" ;
    static final String url = "jdbc:derby:test;create=true" ;

    static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE CUSTOMER (\n" +
            "    CUSTOMER_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n" +
            "    FIRSTNAME VARCHAR(30),\n" +
            "    LASTNAME VARCHAR(30),\n" +
            "    ADDRESS VARCHAR(255),\n" +
            "    ALIAS VARCHAR(50),\n" +
            "    PHONE VARCHAR(60)," +
            "CONSTRAINT primary_key PRIMARY KEY (CUSTOMER_ID)" +
            ")\n";
    static final String DROP_CUSTOMER_TABLE = "DROP TABLE CUSTOMER";
    static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, ADDRESS, ALIAS, PHONE) VALUES ('Theodore','Bagwell','T-Bag','2004-12-25','tbag@foxriver.com')";

    static final String CREATE_ORDER_TABLE = "CREATE TABLE ORDER (\n" +
            "    ORDER_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n" +
            "    SUM INTEGER,\n" +
            "    ORDER_DATE VARCHAR(30),\n" +
            "    ADDRESS VARCHAR(255),\n" +
            "    ALIAS VARCHAR(50),\n" +
            "    PHONE VARCHAR(60)," +
            "CONSTRAINT primary_key PRIMARY KEY (ORDER_ID)" +
            ")\n";
    static final String DROP_ORDER_TABLE = "DROP TABLE ORDER";

    static final String INSERT_ORDER= "INSERT INTO ORDER (FIRSTNAME, LASTNAME, ADDRESS, ALIAS, PHONE) VALUES ('Theodore','Bagwell','T-Bag','2004-12-25','tbag@foxriver.com')";


    static final String CREATE_ORDER_POSITION_TABLE = "CREATE TABLE ORDER_POSITION (\n" +
            "    ORDER_POSITION_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n" +
            "    ORDER_ID INTEGER,\n" +
            "    PRODUCT_ID INTEGER,\n" +
            "    COUNT INTEGER,\n" +
            "CONSTRAINT primary_key PRIMARY KEY (ORDER_POSITION_ID)" +
            ")\n";
    static final String DROP_ORDER_POSITION_TABLE = "DROP TABLE ORDER_POSITION";

    static final String INSERT_RDER_POSITION= "INSERT INTO ORDER_POSITION (FIRSTNAME, LASTNAME, ADDRESS, ALIAS, PHONE) VALUES ('Theodore','Bagwell','T-Bag','2004-12-25','tbag@foxriver.com')";


    static final String CREATE_PRODUCT_TABLE = "CREATE TABLE PRODUCT (\n" +
            "    PRODUCT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n" +
            "    FIRSTNAME VARCHAR(30),\n" +
            "    LASTNAME VARCHAR(30),\n" +
            "    ADDRESS VARCHAR(255),\n" +
            "    ALIAS VARCHAR(50),\n" +
            "    PHONE VARCHAR(60)," +
            "CONSTRAINT primary_key PRIMARY KEY (PRODUCT_ID)" +
            ")\n";
    static final String DROP_PRODUCT_TABLE = "DROP TABLE PRODUCT";

    static final String INSERT_PRODUCT = "INSERT INTO PRODUCT (FIRSTNAME, LASTNAME, ADDRESS, ALIAS, PHONE) VALUES ('Theodore','Bagwell','T-Bag','2004-12-25','tbag@foxriver.com')";

}
