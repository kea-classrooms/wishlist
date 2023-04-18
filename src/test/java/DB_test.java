import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DB_test {
    DB_test db;

    // Udføres før hver test
    @BeforeEach
    void setUp() {
        db = new DB_test();
    }

    @Test
    //getConnection method
    public void testConnection() {
        Connection conn = null;
        try{
            //Replace the values in angle brackets with your database information
            String url = "jdbc:mysql://localhost:3306/WISHLIST"; //??
            String user = "tohasim";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
            Assertions.assertNotNull(conn, "Connection should not be null");
        } catch (SQLException e) {
            e.printStackTrace();
            Assertions.fail("SQLException thrown");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Assertions.fail("SQLException thrown");
                }
            }

        }
        assertTrue(true);    // test fejler
    }

    @Test
    void UserBuildDTO() {
        assertTrue(false);    // test fejler
    }
    @Test
    void getUserBuilds() {
        assertTrue(false);    // test fejler
    }

    @Test
    void getUser() {
        assertTrue(false);    // test fejler

    }

    @Test
    void getALLUsers() {
        assertTrue(false);    // test fejler

    }

    @Test
    void getBuildParts() {
        assertTrue(false);    // test fejler
    }

    @Test
    void getPartName() {
        assertTrue(false);    // test fejler
    }

    @Test
    void getComponentTypes() {
        assertTrue(false);    // test fejler

    }
    @Test
    void getAllParts() {
        assertTrue(false);    // test fejler

    }
    @Test
    void updateBuild() {
        assertTrue(false);    // test fejler

    }


}
