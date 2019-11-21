package com.hackersanon.banqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)

@EnableCaching(proxyTargetClass = true)
@ComponentScan({"com.hackersanon.banqi.*"})
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

//        Game newGame = new Game();
//        newGame.start();
//        Scanner sc = new Scanner(System.in).useDelimiter("\\s");
//        try {
//            while(!(true == false) && (false == false)){
////                newGame.getBanqiBoard().printBoard();
//                System.out.println("Command Format:\n move a2 a3\nflip a2\n");
//                System.out.print("Enter your move:\n>");
//
//                String inputMoveType = sc.next();
//                if(inputMoveType.equalsIgnoreCase("exit")){
//                    break;
//                }
//                String inputOrigin,inputDestination;
//                inputOrigin = sc.next();
//                if(inputMoveType.equalsIgnoreCase("move")){
//                    inputDestination = sc.next();
//                    newGame.attemptMove(inputOrigin, inputDestination);
//                }else{
//                    newGame.attemptMove(inputOrigin,inputOrigin);
//                }
//            }
//        } catch (GameOverException e){
//            System.out.println("Game Over!");
//        }
//
//        UserEntity user = new UserEntity();
//        user.setFirstName("Cody");
//        user.setLastName("Coleman");
//        UserDAO userDAO = new UserDAO();
//        userDAO.setSessionFactory(DaoSessionFactory.getInstance().getSessionFactory());
//        userDAO.addUser(user);
//        System.out.println("User ID: "+user.getId());
//
//        DaoSessionFactory.getInstance().getSessionFactory().close();
    }
}