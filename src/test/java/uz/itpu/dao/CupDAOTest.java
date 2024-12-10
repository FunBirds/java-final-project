package uz.itpu.dao;

import org.junit.Test;
import uz.itpu.entity.Cup;
import java.sql.SQLException;
import static org.junit.Assert.*;


public class CupDAOTest {
    @Test
    public void insertShouldThrowSQLExceptionWhenNullPasses() {
        var cup = new CupDAO();
        Cup cup1 = new Cup().setName("Ceramic Inserting Data").setMaterial(null).setPrice(15).setColor("Blue").setVolume(300);
        assertThrows(SQLException.class, () -> cup.insert(cup1));
    }

    @Test
    public void insertNewData() throws SQLException {
        var cup = new CupDAO();
        Cup cup1 = new Cup().setName("Ceramic Inserting Data").setMaterial("Ceramic").setPrice(15).setColor("Blue").setVolume(300).setSize(12);
        cup.insert(cup1);
        Long insertedID = cup1.getId();
        assertEquals(cup1, cup.showByIndex(insertedID));
    }
}