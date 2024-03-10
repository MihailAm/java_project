package ru.mihail.spring.ispi.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mihail.spring.ispi.models.Users;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UsersDetails implements UserDetails {
    private Users users;
    public UsersDetails(Users users){
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(users.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
//    getAuthorities() - Этот метод возвращает коллекцию объектов, представляющих разрешения (права доступа) пользователя.
//    Arrays.stream(users.getRole().split(",")) - Здесь происходит разделение строки, содержащей роли пользователя, на отдельные роли, используя запятые в качестве разделителей. Результатом является поток (stream) строк, представляющих отдельные роли.
//            .map(SimpleGrantedAuthority::new) - Каждая строка (роль) из потока маппится (преобразуется) в объект SimpleGrantedAuthority. Этот объект обычно представляет собой разрешение или право доступа в системе.
//            .collect(Collectors.toList()) - Затем все объекты SimpleGrantedAuthority собираются в список.
//Таким образом, в итоге этот метод возвращает список разрешений (GrantedAuthority), которые были извлечены из строкового представления ролей пользователя. Этот список используется для определения прав доступа пользователя в системе.
    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
