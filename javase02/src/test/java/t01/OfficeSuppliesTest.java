package t01;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OfficeSuppliesTest {
    private Pen p1, p2LikePen1, p3, p4;
    private Pencil pencil1, pencilLikePen1, pencilLikePencil1;
    private Eraser e1, e2;

    @Before
    public void createFewPens() {
        p1 = new Pen("Pen1", new BigDecimal(10));
        p2LikePen1 = new Pen("Pen1", new BigDecimal(10));
        p3 = new Pen("Pen3", new BigDecimal(10));
        p4 = new Pen("Pen4", new BigDecimal(12));
        pencil1 = new Pencil("Pencil1", new BigDecimal(3));
        pencilLikePencil1 = new Pencil("Pencil1", new BigDecimal(3));
        pencilLikePen1 = new Pencil("Pen1", new BigDecimal(10));
        e1 = new Eraser("Bic", new BigDecimal(3));
        e2 = new Eraser("Bic", new BigDecimal(4));
    }

    @Test
    public void getName() throws Exception {
        assertTrue("Pen1".equals(p2LikePen1.getName()));
        assertFalse("Pen3".equals(p2LikePen1.getName()));
    }

    @Test
    public void getPrice() throws Exception {
        assertTrue((new BigDecimal(10)).equals(p2LikePen1.getPrice()));
        assertFalse((new BigDecimal(12)).equals(p3.getPrice()));
    }

    @Test
    public void penEqualsPen() throws Exception {
//        if (p1 != null)
        assertTrue(p1.equals(p2LikePen1));
        assertFalse(p1.equals(p3));
    }

    @Test
    public void pencilEqualsPencil() throws Exception {
        if (pencil1 != null) {
            assertTrue(pencil1.equals(pencilLikePencil1));
            assertFalse(pencil1.equals(pencilLikePen1));
        }
    }

    @SuppressWarnings({"EqualsBetweenInconvertibleTypes"})
    @Test
    public void penNotEqualsPencil() throws Exception {
        if (p1 != null) {
            assertFalse(p1.equals(pencil1));
            assertFalse(p1.equals(pencilLikePen1));
        }
    }

    @Test
    public void penHashCode() throws Exception {
        assertTrue(p1.hashCode() == p2LikePen1.hashCode());
        assertFalse(p1.hashCode() == p3.hashCode());
    }

    @Test
    public void pencilHashCode() throws Exception {
        assertTrue(pencil1.hashCode() == pencilLikePencil1.hashCode());
        assertFalse(pencil1.hashCode() == pencilLikePen1.hashCode());
    }

    @Test
    public void penHashCodeNotEqualsPencilHashCode() throws Exception {
        assertFalse(p1.hashCode() == pencilLikePen1.hashCode());
        assertFalse(pencil1.hashCode() == pencilLikePen1.hashCode());
    }

    @Test
    public void penToStringTest() throws Exception {
        assertTrue("Pen(name=Pen1, price=10)".equals(p1.toString()));
    }

    @Test
    public void pencilToStringTest() throws Exception {
        assertTrue("Pencil(name=Pencil1, price=3)".equals(pencil1.toString()));
    }

    @Test
    public void eraserClone() throws Exception {
        Eraser clonedEraser = e1.clone();
        assertTrue(e1.equals(clonedEraser));
        assertFalse(e1 == clonedEraser);
    }
    @Test
    public void penClone() throws Exception {
        Pen clonedPen = p1.clone();
        assertTrue(p1.equals(clonedPen));
        assertFalse(p1 == clonedPen);
    }
    @Test
    public void pencilClone() throws Exception {
        Pencil clonedPencil = pencil1.clone();
        assertTrue(pencil1.equals(clonedPencil));
        assertFalse(pencil1 == clonedPencil);
    }
}