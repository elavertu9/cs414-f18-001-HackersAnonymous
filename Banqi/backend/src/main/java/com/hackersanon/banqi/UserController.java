//package com.hackersanon.banqi;
//
//import com.hackersanon.banqi.model.user.User;
//import com.hackersanon.banqi.service.GameService;
//import com.hackersanon.banqi.service.IGameService;
//import com.hackersanon.banqi.service.IUserService;
//import com.hackersanon.banqi.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/user")
//@CrossOrigin(origins = {"http://localhost:8081"})
//public class UserController
//{
//	private IGameService gameService;
//
//	private IUserService userService;
//
//	@Autowired
//	public void setGameService(GameService gameService){
//		this.gameService = gameService;
//	}
//
//	@Autowired
//	public void setUserService(UserService userService){
//		this.userService = userService;
//	}
//
//
//
//	@RequestMapping(value = "/add", consumes = "application/Json", produces = "application/Json")
//	public ResponseEntity createUser(@RequestBody User user) {
//		return ResponseEntity.accepted().body(userService.createUser(user));
//	}
//
//	@GetMapping(value = "/{userId}", produces = "application/Json")
//	public ResponseEntity<User> getUserById(@PathVariable long userId){
//		return ResponseEntity.accepted().body(userService.findById(userId));
//	}
//
//	@GetMapping(value = "/byUsername/{username}", produces = "application/Json")
//	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
//		return ResponseEntity.accepted().body(userService.findByUsername(username));
//	}
//
//	@GetMapping(value = "/list")
//	public ResponseEntity getAllUsers(){
//		return ResponseEntity.accepted().body(userService.listAllUsers());
//	}
//
//	@GetMapping(value = "/{userId}/delete", produces = "application/Json")
//	public ResponseEntity deleteUserById(@PathVariable Long userId){
//
//		userService.deleteUserById(userId);
//		gameService.deleteGameByUserId(userId);
//		return ResponseEntity.accepted().body("User Corresponding To Id: "+userId+" Has Been Deleted.");
//	}
//
//	@PostMapping(value = "/edit", consumes = "application/Json", produces = "application/Json")
//	public ResponseEntity<User> updateUser(@RequestBody User user){
//		System.out.println(user.getEmail()+"\n\n\n\n");
//		return ResponseEntity.accepted().body(userService.updateUser(user));
//	}
//
//
//	@RequestMapping(value="*")
//	public ResponseEntity fallbackPage() {
//		return ResponseEntity.badRequest().body("Couldn't find the page you are looking for.");
//	}
//}
