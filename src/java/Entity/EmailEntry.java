/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DalidasMac
 */
@Entity
@Table(name = "emailEntry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailEntry.findAll", query = "SELECT e FROM EmailEntry e"),
    @NamedQuery(name = "EmailEntry.findById", query = "SELECT e FROM EmailEntry e WHERE e.id = :id"),
    @NamedQuery(name = "EmailEntry.findByFirstName", query = "SELECT e FROM EmailEntry e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "EmailEntry.findByLastName", query = "SELECT e FROM EmailEntry e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "EmailEntry.findByEmailAddress", query = "SELECT e FROM EmailEntry e WHERE e.emailAddress = :emailAddress")})
public class EmailEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EmailAddress")
    private String emailAddress;

    public EmailEntry() {
    }

    public EmailEntry(Integer id) {
        this.id = id;
    }

    public EmailEntry(Integer id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailEntry)) {
            return false;
        }
        EmailEntry other = (EmailEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EmailEntry[ id=" + id + " ]";
    }
    
}
