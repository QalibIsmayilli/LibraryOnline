package com.company.library.configure;

import com.company.library.dto.requests.UserSaveRequest;
import com.company.library.model.Role;
import com.company.library.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {

    private final UserService userService;

    public StartupConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(new UserSaveRequest(
                "OdinSon","salamm","qalibismayilli@gmail.com", Role.USER));
    }
}
