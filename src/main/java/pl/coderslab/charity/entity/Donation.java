package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private int quantity;
    @ManyToMany
    @NotEmpty
    private List<Category> categories = new ArrayList<>();
    @ManyToMany
    @NotEmpty
    private List<Institution> institutions = new ArrayList<>();
    @NotEmpty
    private String street;
    @NotEmpty
    private String zipCode;
    @NotEmpty
    private LocalDate pickUpDate;
    @NotEmpty
    private LocalTime pickUpTime;
    @NotEmpty
    private String pickUpComment;

    
}
