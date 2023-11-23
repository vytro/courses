package com.diplomado.courses.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student_id_card")
public class StudentIdCard implements Serializable {

    private static final long serialVersionUID = 879965647874712001L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "my_sequence")
    @SequenceGenerator(
            name = "my_sequence",
            sequenceName = "my_sequence",
            allocationSize = 1)
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            columnDefinition = "TEXT")
    private String cardNumber;

//    @OneToOne(mappedBy = "studentIdCard")
//    @JoinColumn(
//            name = "student_id",
//            referencedColumnName = "id",
//            foreignKey = @ForeignKey(
//                    name = "student_id_fk"
//            )
//    )
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
