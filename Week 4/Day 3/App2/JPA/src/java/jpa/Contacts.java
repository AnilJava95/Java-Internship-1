/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

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
 * @author Anil
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
   , @NamedQuery(name = "Contacts.findByName", query = "SELECT c FROM Contacts c WHERE c.name = :name")
   , @NamedQuery(name = "Contacts.findByTelNumber", query = "SELECT c FROM Contacts c WHERE c.telNumber = :telNumber")})
public class Contacts implements Serializable {

   private static final long serialVersionUID = 1L;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 20)
   @Column(name = "name")
   private String name;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "tel_number")
   private Integer telNumber;

   public Contacts() {
   }

   public Contacts(Integer telNumber) {
      this.telNumber = telNumber;
   }

   public Contacts(Integer telNumber, String name) {
      this.telNumber = telNumber;
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getTelNumber() {
      return telNumber;
   }

   public void setTelNumber(Integer telNumber) {
      this.telNumber = telNumber;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (telNumber != null ? telNumber.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Contacts)) {
         return false;
      }
      Contacts other = (Contacts) object;
      if ((this.telNumber == null && other.telNumber != null) || (this.telNumber != null && !this.telNumber.equals(other.telNumber))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "jpa.Contacts[ telNumber=" + telNumber + " ]";
   }
   
}
