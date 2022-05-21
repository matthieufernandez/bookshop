import controller.BookShopController;
import dao.BookShopDao;
import dao.BookShopDaoImpl;
import view.BookShopView;
import view.UserIO;
import view.UserIOConsoleImpl;

public class App {
    public static void main (String[] args) {
        UserIO myIo= new UserIOConsoleImpl();
        BookShopView view = new BookShopView(myIo);
        BookShopDao dao = new BookShopDaoImpl();
        BookShopController controller = new BookShopController(dao, view);

        controller.run();
    }
}
