package kr.ac.jejunu;

public class DaoFactory {

    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    private ConncetionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
