package com.example.storeadmin.domain.authorization;

import com.example.db.store.StoreRepository;
import com.example.db.store.enums.StoreStatus;
import com.example.storeadmin.domain.authorization.model.UserSession;
import com.example.storeadmin.domain.user.service.StoreUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {

    private final StoreUserService storeUserService;
    private final StoreRepository storeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var storeUserEntity = storeUserService.getRegisterUser(username);

        var storeEntity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(
                storeUserEntity.get().getStoreId(),
                StoreStatus.REGISTERED
        );

        return storeUserEntity.map(it ->{
                var userSession = UserSession.builder()
                        .userId(it.getId())
                        .email(it.getEmail())
                        .password(it.getPassword())
                        .status(it.getStatus())
                        .role(it.getRole())
                        .registeredAt(it.getRegisteredAt())
                        .lastLoginAt(it.getLastLoginAt())
                        .unregisteredAt(it.getUnregisteredAt())

                        .storeId(storeEntity.get().getId())
                        .storeName(storeEntity.get().getName())
                        .build();

                return userSession;
            })
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
