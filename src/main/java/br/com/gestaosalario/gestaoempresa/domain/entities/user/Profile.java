package br.com.gestaosalario.gestaoempresa.domain.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeProfile type;

    public Profile(TypeProfile type) {
        this.type = type;
    }

    public boolean isAdmin(){
        return this.type.equals("ROLE_USER");
    };
    public boolean isManage(){
        return this.type.equals("ROLE_MANAGER");
    };
    public boolean isEmployee(){
        return this.type.equals("ROLE_EMPLOYEE");
    };
    public Long getId() {
        return id;
    }
}
