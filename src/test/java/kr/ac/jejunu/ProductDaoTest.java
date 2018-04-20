package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDaoTest {
    private ProductDao productDao;
    @Before
    public void setup() {
        productDao = new ProductDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setTitle("한라감귤");
        product.setPrice(10000);

        long id = productDao.insert(product);

        Product insertProduct = productDao.get(id);

        assertThat(insertProduct.getTitle(), is(product.getTitle()));
        assertThat(insertProduct.getPrice(), is(product.getPrice()));
        assertThat(insertProduct.getId(), is(id));
    }
}
