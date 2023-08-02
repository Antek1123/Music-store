package antoni.podebski.musicstore.operator.model;

import antoni.podebski.musicstore.address.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Set;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "operator")
@Where(clause = "deleted_at IS NULL")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Operator.withRoles", attributeNodes = {
                @NamedAttributeNode("roles")
        }),
        @NamedEntityGraph(name = "Operator.withRolesAndAddress", attributeNodes = {
                @NamedAttributeNode("roles"),
                @NamedAttributeNode("address"),
        })
})
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "operator")
    private Set<OperatorToRole> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @Column(name = "date_of_employment")
    private OffsetDateTime dateOfEmployment;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<OperatorToRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<OperatorToRole> roles) {
        this.roles = roles;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OffsetDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(OffsetDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public OffsetDateTime getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(OffsetDateTime dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public OffsetDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(OffsetDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}
