import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticListTest {

    @Test
    void testarInclusaoDeDados() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test
    void testarTamanhoDaLista() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertEquals(4, lista.getSize());
    }

    @Test
    void testarBuscaElementoExistente() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertEquals(2, lista.search(15));
    }

    @Test
    void testarBuscaElementoInexistente() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertEquals(-1, lista.search(30));
    }

    @Test
    void testarRetirar() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        lista.remove(10);

        assertEquals("5,15,20", lista.toString());
        assertEquals(3, lista.getSize());
    }

    @Test
    void testarRedimensionamento() {
        StaticList lista = new StaticList();

        for (int i = 1; i <= 15; i++) {
            lista.insert(i);
        }

        assertEquals(
                "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15",
                lista.toString()
        );

        assertEquals(15, lista.getSize());
    }

    @Test
    void testarObterElemento() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertEquals(20, lista.getElement(3));
    }

    @Test
    void testarExcecaoObterElemento() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> lista.getElement(5)
        );
    }

    @Test
    void testarLiberar() {
        StaticList lista = new StaticList();

        lista.insert(5);
        lista.insert(10);
        lista.insert(15);
        lista.insert(20);

        lista.clear();

        assertTrue(lista.isEmpty());
    }
}