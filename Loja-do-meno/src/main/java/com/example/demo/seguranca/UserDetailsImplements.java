package com.example.demo.seguranca;

import com.example.demo.model.usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImplements implements UserDetails {

    private static final long serioVersionUID = 1L;

    private String email;
    private String senha;
    private List<GrantedAuthority> autorizacoes;

    public UserDetailsImplements(usuario Usuario) {
        this.email = Usuario.getEmail();
        this.senha = Usuario.getSenha();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
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
