package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Andre", "SSS", "udfs@mail.ru");
        User user2 = new User("Neto", "ZZZ", "frefe@mail.ru");
        User user3 = new User("Zeto", "vdvd", "fffff3@mail.ru");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        CarService carService = context.getBean(CarService.class);
        Car car1 = new Car("Lada", 2107, user1);
        user1.setCar(car1);
        carService.add(car1);
        User finedUser = carService.getUser("Lada", 2107);
        System.out.println(finedUser.getFirstName());
        context.close();
    }
}
