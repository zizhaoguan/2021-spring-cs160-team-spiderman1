package teamspiderman.backend.appuser;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/edit_user")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;


    @PutMapping("/edit_email/{userId}/")
    public GetUserResponse updateEmailByuserID(
            @PathVariable("userId") Long userId,
            @RequestParam(value="email") String email){
        boolean userExists = appUserRepository
                .findUserByuserID(userId)
                .isPresent();

        System.out.println("userID = "+userId);
        if(!userExists){
            throw new IllegalStateException("user doesn't exist");
        }
        return appUserService.updateEmailByuserID(userId, email);
    }

}
