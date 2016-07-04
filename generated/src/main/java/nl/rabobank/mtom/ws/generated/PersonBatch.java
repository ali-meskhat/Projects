//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.01 at 03:35:10 PM CEST 
//


package nl.rabobank.mtom.ws.generated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for personBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personBatch"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="persons" type="{http://www.rabobank.nl/import/schema/beans}person" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personBatch", propOrder = {
    "persons"
})
public class PersonBatch
    implements Equals, HashCode
{

    protected List<Person> persons;

    /**
     * Gets the value of the persons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Person }
     * 
     * 
     */
    public List<Person> getPersons() {
        if (persons == null) {
            persons = new ArrayList<Person>();
        }
        return this.persons;
    }

    public PersonBatch withPersons(Person... values) {
        if (values!= null) {
            for (Person value: values) {
                getPersons().add(value);
            }
        }
        return this;
    }

    public PersonBatch withPersons(Collection<Person> values) {
        if (values!= null) {
            getPersons().addAll(values);
        }
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PersonBatch)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PersonBatch that = ((PersonBatch) object);
        {
            List<Person> lhsPersons;
            lhsPersons = (((this.persons!= null)&&(!this.persons.isEmpty()))?this.getPersons():null);
            List<Person> rhsPersons;
            rhsPersons = (((that.persons!= null)&&(!that.persons.isEmpty()))?that.getPersons():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "persons", lhsPersons), LocatorUtils.property(thatLocator, "persons", rhsPersons), lhsPersons, rhsPersons)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<Person> thePersons;
            thePersons = (((this.persons!= null)&&(!this.persons.isEmpty()))?this.getPersons():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "persons", thePersons), currentHashCode, thePersons);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}