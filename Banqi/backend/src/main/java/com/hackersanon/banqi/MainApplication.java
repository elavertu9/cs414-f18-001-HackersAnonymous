package com.hackersanon.banqi;

import com.hackersanon.banqi.database.DaoSessionFactory;
import com.hackersanon.banqi.database.entity.UsersEntity;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
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

        UsersEntity user = new UsersEntity();
        user.setFirstName("Cody");
        user.setLastName("Coleman");
        Session session = DaoSessionFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User ID: "+user.getId());

        DaoSessionFactory.getSessionFactory().close();
    }
}