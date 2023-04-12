package com.poly.entity;

import com.poly.constant.NamedStored;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NamedQueries({@NamedQuery(name = "User.findByEmail", query = "Select o From User o Where o.email LIKE :param"),
        @NamedQuery(name = "User.findByUsername", query = "Select o From User o Where o.username = :param"),
        @NamedQuery(name = "User.findByUsernameAndPassword", query = "Select o From User o Where o.username = :username AND o.password = :password"),
})
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name =NamedStored.FIND_USER_LIKE_VIDEO_BY_VIDEO_HREF,
                procedureName = "sp_selectUserLikeVideoByVideoHref",
                resultClasses = {User.class},
                parameters = @StoredProcedureParameter(name="videoHref", type = String.class))
})
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ISADMIN")
    private boolean isAdmin;
    @Column(name = "ISACTIVE")
    private boolean isActive;
}
