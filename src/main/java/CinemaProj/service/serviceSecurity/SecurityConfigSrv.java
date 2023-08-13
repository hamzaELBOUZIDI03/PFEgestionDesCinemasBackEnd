package CinemaProj.service.serviceSecurity;

import CinemaProj.entite.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class SecurityConfigSrv {

    public List<UserEntity> getUser() {
        return Stream.of(new UserEntity(1L,"hamza","123"),
                new UserEntity(2L, "imad", "123")).collect(Collectors.toList());
    }

}