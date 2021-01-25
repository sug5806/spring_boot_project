package com.my.my_project.service;

import com.my.my_project.domain.User;
import com.my.my_project.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 생성 service")
    public void create() {
        User user = User.builder()
                .userId("root")
                .password("1234")
                .build();

        userService.create(user);

        userRepository.save(user);
    }

    @Test
    @DisplayName("유저 불러오기 service")
    public void getUser() {
        Long fakeId = 1L;
        User user = User.builder()
                .Id(fakeId)
                .userId("root")
                .password("1234")
                .email("root@root.com")
                .build();

        // given
        given(userRepository.save(any())).willReturn(user);
        given(userRepository.findById(fakeId)).willReturn(Optional.ofNullable(user));

        // when
        Long newUserId = user.getId();

        // then
        User findUser = userRepository.findById(newUserId).get();

        assertThat(findUser).isNotNull();
        assertThat("root").isEqualTo(findUser.getUserId());
        assertThat("1234").isEqualTo(findUser.getPassword());
        assertThat("root@root.com").isEqualTo(findUser.getEmail());
    }

}