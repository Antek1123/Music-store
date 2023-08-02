package antoni.podebski.musicstore.authorization.principal;

import antoni.podebski.musicstore.operator.model.Operator;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class OperatorPrincipal implements UserDetails {

    private final Operator operator;

    private final Set<? extends GrantedAuthority> authorities;

    public OperatorPrincipal(Operator operator, Set<? extends GrantedAuthority> authorities) {
        this.operator = operator;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return operator.getPassword();
    }

    @Override
    public String getUsername() {
        return operator.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return operator.getDeletedAt() == null;
    }

    public Operator getOperator() {
        return operator;
    }

}
